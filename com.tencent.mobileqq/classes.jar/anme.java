import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;

public class anme
  extends ayor
{
  public anme(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onBatteryChanged updateOnlineStatusItem");
    }
    if (FrameHelperActivity.a(this.a) != null) {
      FrameHelperActivity.a(this.a).a(paramInt);
    }
    this.a.a("OnBatteryChangeObserver");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anme
 * JD-Core Version:    0.7.0.1
 */