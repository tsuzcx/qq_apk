import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;
import java.util.HashMap;

class arxk
  extends BroadcastReceiver
{
  arxk(arxi paramarxi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (ReportData)paramIntent.getSerializableExtra("reportData");
    paramIntent = (arxl)arxi.a(this.a).get(paramContext.actionName);
    if ((paramIntent != null) && (paramIntent.b()))
    {
      this.a.a();
      arxi.a(this.a).a(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxk
 * JD-Core Version:    0.7.0.1
 */