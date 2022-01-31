import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qlink.QlinkStandardDialogActivity;

public class bipp
  extends BroadcastReceiver
{
  public bipp(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qlink.finishdlg".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bipp
 * JD-Core Version:    0.7.0.1
 */