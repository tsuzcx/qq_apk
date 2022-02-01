import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.startup.step.BroadcastReportRegister;
import mqq.app.AppCallback;

public class bdhq
  implements AppCallback
{
  public bdhq(BroadcastReportRegister paramBroadcastReportRegister) {}
  
  public void onSendBroadcast(Context paramContext, Intent paramIntent)
  {
    try
    {
      aqjg.a(paramIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhq
 * JD-Core Version:    0.7.0.1
 */