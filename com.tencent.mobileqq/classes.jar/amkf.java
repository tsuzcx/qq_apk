import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class amkf
  extends BroadcastReceiver
{
  amkf(amkd paramamkd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        if ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) && (!paramContext.equals("mqq.intent.action.LOGOUT"))) {
          break label57;
        }
        amkd.a(this.a);
      }
    }
    label57:
    while ((!paramContext.equals("mqq.intent.action.LOGIN")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED"))) {
      return;
    }
    amkd.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amkf
 * JD-Core Version:    0.7.0.1
 */