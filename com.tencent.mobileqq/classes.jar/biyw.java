import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class biyw
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramIntent.getIntExtra("type", 0) == 0)) {
      return;
    }
    biyt.a(paramIntent.getStringExtra("account"));
    biyt.b(biyt.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyw
 * JD-Core Version:    0.7.0.1
 */