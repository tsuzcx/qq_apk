import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bjxj
  extends BroadcastReceiver
{
  bjxj(bjxd parambjxd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bjtx.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxj
 * JD-Core Version:    0.7.0.1
 */