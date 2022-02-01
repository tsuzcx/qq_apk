import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public final class bbiy
  extends BroadcastReceiver
{
  private bbiy(PtvTemplateProviderView paramPtvTemplateProviderView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("action_brocassreceiver_for_ptv".equals(paramIntent.getAction()))
    {
      bbew.a().b(false);
      PtvTemplateProviderView.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, "PtvTemplateProviderView PtvBroadcastReceiver size=" + this.a.a.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbiy
 * JD-Core Version:    0.7.0.1
 */