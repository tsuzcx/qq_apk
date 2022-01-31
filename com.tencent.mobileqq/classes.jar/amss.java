import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.dingdong.data.ScheduleTipsDialog;

public class amss
  extends BroadcastReceiver
{
  public amss(ScheduleTipsDialog paramScheduleTipsDialog) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")) && (ScheduleTipsDialog.b(this.a))) {
        ScheduleTipsDialog.a(this.a, this.a);
      }
    }
    while ((!paramContext.equals("android.intent.action.SCREEN_OFF")) || (!ScheduleTipsDialog.b(this.a))) {
      return;
    }
    ScheduleTipsDialog.a(this.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amss
 * JD-Core Version:    0.7.0.1
 */