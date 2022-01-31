import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import dov.com.qq.im.capture.QIMCaptureController;

public class antf
  implements Runnable
{
  public antf(QIMCaptureController paramQIMCaptureController) {}
  
  public void run()
  {
    AppInterface localAppInterface = this.a.a;
    if (localAppInterface != null) {
      ConfigServlet.a(localAppInterface, localAppInterface.getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     antf
 * JD-Core Version:    0.7.0.1
 */