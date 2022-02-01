import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class biwk
  extends BroadcastReceiver
{
  biwk(biwe parambiwe) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bisy.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biwk
 * JD-Core Version:    0.7.0.1
 */