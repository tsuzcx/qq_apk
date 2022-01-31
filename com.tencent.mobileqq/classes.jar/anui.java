import com.tencent.common.app.AppInterface;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class anui
  implements Runnable
{
  public anui(QIMMusicConfigManager paramQIMMusicConfigManager) {}
  
  public void run()
  {
    this.a.a();
    this.a.a().notifyObservers(CaptureConfigUpdateObserver.class, 1, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anui
 * JD-Core Version:    0.7.0.1
 */