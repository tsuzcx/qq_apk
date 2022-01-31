import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class beiz
  extends BroadcastReceiver
{
  beiz(beiy parambeiy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.HEADSET_PLUG")) && (paramIntent.hasExtra("state")))
    {
      if (paramIntent.getIntExtra("state", 0) != 0) {
        break label46;
      }
      beiy.a(this.a, 2);
    }
    label46:
    while (paramIntent.getIntExtra("state", 0) != 1) {
      return;
    }
    beiy.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beiz
 * JD-Core Version:    0.7.0.1
 */