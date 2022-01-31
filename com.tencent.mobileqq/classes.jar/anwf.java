import com.tencent.common.app.AppInterface;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.capture.text.DynamicTextBuilder;
import java.util.Arrays;
import java.util.Map;

public final class anwf
  implements Runnable
{
  public void run()
  {
    String str = CaptureContext.a().getCurrentNickname();
    DynamicTextBuilder.a().put(Integer.valueOf(5), Arrays.asList(new String[] { "旅行的意义", "MY JOURNEY \n" + str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwf
 * JD-Core Version:    0.7.0.1
 */