import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bicr
  extends BroadcastReceiver
{
  bicr(bicl parambicl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bhzm.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicr
 * JD-Core Version:    0.7.0.1
 */