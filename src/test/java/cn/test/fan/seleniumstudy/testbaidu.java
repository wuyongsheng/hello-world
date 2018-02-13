package cn.test.fan.seleniumstudy;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testbaidu {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
//		driver = new FirefoxDriver(); // 初始化chrome
		driver = new ChromeDriver(); // 初始化chrome

		baseUrl = "https://www.baidu.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 全局的元素等待设置
	}

	@Test
	public void testUntitled() throws Exception {

		driver.get(baseUrl); // get 打开网址

		// driver.findElement(By.id("kw")).click();
		// driver.findElement(By.id("kw")).clear();

		// 单个元素定位
		/*
		 * WebElement a = driver.findElement(By.name("wd")); WebElement b =
		 * driver.findElement(By.id("su"));
		 * 
		 * a.sendKeys("selenium"); b.click();
		 * 
		 * //多个元素定位 List<WebElement> ll= driver.findElements(By.name("abc"));
		 * 
		 * int n =ll.size(); //长度
		 * 
		 * ll.get(0); ll.get(1); ll.get(n-1);
		 */

		// 层级元素定位
		WebElement as = driver.findElement(By.id("u1"));

		List<WebElement> ll = as.findElements(By.tagName("a"));

		// List<WebElement> ll = driver.findElements(By.tagName("a"));
		System.out.println("a number is " + ll.size());

		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.get(i).getText());
		}

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit(); // 关闭浏览器
	}

}
