import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class apbr
  extends BroadcastReceiver
{
  apbr(apbp paramapbp) {}
  
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
        apbp.a(this.a);
      }
    }
    label57:
    while ((!paramContext.equals("mqq.intent.action.LOGIN")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED"))) {
      return;
    }
    apbp.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbr
 * JD-Core Version:    0.7.0.1
 */