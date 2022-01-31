import com.tencent.mobileqq.app.QQAppInterface;
import dov.com.qq.im.capture.text.DynamicTextBuilder;
import java.util.Arrays;
import java.util.Map;

public final class amxn
  implements Runnable
{
  public amxn(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.a.getCurrentNickname();
    DynamicTextBuilder.a().put(Integer.valueOf(5), Arrays.asList(new String[] { "旅行的意义", "MY JOURNEY \n" + str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amxn
 * JD-Core Version:    0.7.0.1
 */