import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.view.FilterProviderView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public final class axro
  extends BroadcastReceiver
{
  private axro(FilterProviderView paramFilterProviderView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("action_brocassreceiver_for_filter".equals(paramIntent.getAction()))
    {
      axom.a().b();
      FilterProviderView.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("FilterProviderView", 2, "FilterProviderView FilterBroadcastReceiver size=" + this.a.a.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axro
 * JD-Core Version:    0.7.0.1
 */