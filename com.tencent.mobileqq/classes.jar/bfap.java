import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class bfap
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramIntent.getIntExtra("type", 0) == 0)) {
      return;
    }
    bfam.a(paramIntent.getStringExtra("account"));
    bfam.b(bfam.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfap
 * JD-Core Version:    0.7.0.1
 */