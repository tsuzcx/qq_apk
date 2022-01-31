import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import dov.com.qq.im.capture.QIMCaptureController;

public class ankt
  implements Runnable
{
  public ankt(QIMCaptureController paramQIMCaptureController) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a;
    if (localQQAppInterface != null) {
      ConfigServlet.h(localQQAppInterface, localQQAppInterface.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ankt
 * JD-Core Version:    0.7.0.1
 */