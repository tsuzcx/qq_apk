import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bfpd
  extends BroadcastReceiver
{
  bfpd(bfox parambfox) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bflp.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfpd
 * JD-Core Version:    0.7.0.1
 */