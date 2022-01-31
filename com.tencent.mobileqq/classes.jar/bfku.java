import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bfku
  extends BroadcastReceiver
{
  bfku(bfko parambfko) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bfhg.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfku
 * JD-Core Version:    0.7.0.1
 */