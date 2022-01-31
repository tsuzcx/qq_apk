import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.share.QZoneShareActivity;
import mqq.os.MqqHandler;

public class amiv
  implements Runnable
{
  public amiv(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    int i = this.a.b();
    int j = this.a.a();
    ThreadManager.getUIHandler().post(new amiw(this, i - j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amiv
 * JD-Core Version:    0.7.0.1
 */