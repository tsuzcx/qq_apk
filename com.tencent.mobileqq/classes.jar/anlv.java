import com.tencent.mobileqq.app.QQAppInterface;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class anlv
  implements Runnable
{
  public anlv(QIMMusicConfigManager paramQIMMusicConfigManager) {}
  
  public void run()
  {
    this.a.a();
    this.a.a().notifyObservers(CaptureConfigUpdateObserver.class, 1, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anlv
 * JD-Core Version:    0.7.0.1
 */