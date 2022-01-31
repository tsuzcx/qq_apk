import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;
import mqq.os.MqqHandler;

public class anhd
  implements Runnable
{
  public anhd(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    if ((this.a.app != null) && (QZoneShareActivity.a(this.a).a > 0L) && (!TextUtils.isEmpty(QZoneShareActivity.a(this.a).i)) && (!this.a.a(this.a.app, QZoneShareActivity.a(this.a).a, QZoneShareActivity.a(this.a).i))) {
      return;
    }
    int i = this.a.b();
    int j = this.a.a();
    ThreadManager.getUIHandler().post(new anhe(this, i, j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhd
 * JD-Core Version:    0.7.0.1
 */