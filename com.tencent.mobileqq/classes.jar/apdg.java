import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;
import java.util.HashMap;

class apdg
  extends BroadcastReceiver
{
  apdg(apde paramapde) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (ReportData)paramIntent.getSerializableExtra("reportData");
    paramIntent = (apdh)apde.a(this.a).get(paramContext.actionName);
    if ((paramIntent != null) && (paramIntent.b()))
    {
      this.a.a();
      apde.a(this.a).a(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdg
 * JD-Core Version:    0.7.0.1
 */