import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bdli
  extends BroadcastReceiver
{
  bdli(bdlc parambdlc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bdht.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdli
 * JD-Core Version:    0.7.0.1
 */