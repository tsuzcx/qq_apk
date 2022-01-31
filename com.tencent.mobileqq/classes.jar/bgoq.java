import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qlink.QlinkStandardDialogActivity;

public class bgoq
  extends BroadcastReceiver
{
  public bgoq(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qlink.finishdlg".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgoq
 * JD-Core Version:    0.7.0.1
 */