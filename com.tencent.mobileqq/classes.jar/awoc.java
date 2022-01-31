import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.startup.step.BroadcastReportRegister;
import mqq.app.AppCallback;

public class awoc
  implements AppCallback
{
  public awoc(BroadcastReportRegister paramBroadcastReportRegister) {}
  
  public void onSendBroadcast(Context paramContext, Intent paramIntent)
  {
    try
    {
      allq.a(paramIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awoc
 * JD-Core Version:    0.7.0.1
 */