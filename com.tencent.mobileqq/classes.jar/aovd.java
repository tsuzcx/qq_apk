import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import java.util.List;

public final class aovd
  extends BroadcastReceiver
{
  private aovd(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("action_brocassreceiver_for_filter".equals(paramIntent.getAction()))
    {
      CaptureVideoFilterManager.a().b();
      CaptureVideoFilterManager.a().a(new aove(this));
      this.a.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "CaptureVideoFilterViewPager FilterBroadcastReceiver size=" + this.a.a.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aovd
 * JD-Core Version:    0.7.0.1
 */