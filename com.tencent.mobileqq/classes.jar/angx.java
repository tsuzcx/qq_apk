import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.share.QZoneShareActivity;

public class angx
  implements Runnable
{
  public angx(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    if ((QZoneShareActivity.a(this.a) != null) && (QZoneShareActivity.a(this.a).isShowing())) {}
    try
    {
      QZoneShareActivity.a(this.a).dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneShare", 1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angx
 * JD-Core Version:    0.7.0.1
 */