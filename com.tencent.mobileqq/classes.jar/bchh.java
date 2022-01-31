import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bchh
  extends BroadcastReceiver
{
  bchh(bchb parambchb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bcds.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bchh
 * JD-Core Version:    0.7.0.1
 */