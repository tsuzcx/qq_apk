import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class bhod
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramIntent.getIntExtra("type", 0) == 0)) {
      return;
    }
    bhoa.a(paramIntent.getStringExtra("account"));
    bhoa.b(bhoa.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhod
 * JD-Core Version:    0.7.0.1
 */