import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class biss
  extends BroadcastReceiver
{
  biss(bisq parambisq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (bisq.a(this.a) != null))
    {
      bisq.a(this.a).dismiss();
      bisq.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     biss
 * JD-Core Version:    0.7.0.1
 */