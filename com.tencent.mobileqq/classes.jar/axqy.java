import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public final class axqy
  extends BroadcastReceiver
{
  private axqy(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("action_brocassreceiver_for_filter".equals(paramIntent.getAction()))
    {
      axom.a().b();
      axom.a().a(new axqz(this));
      this.a.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "CaptureVideoFilterViewPager FilterBroadcastReceiver size=" + this.a.a.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axqy
 * JD-Core Version:    0.7.0.1
 */