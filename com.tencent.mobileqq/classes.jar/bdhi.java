import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bdhi
  extends BroadcastReceiver
{
  bdhi(bdhh parambdhh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.TIME_TICK".equals(paramContext)) {
      this.a.b();
    }
    do
    {
      return;
      if ("android.intent.action.TIME_SET".equals(paramContext))
      {
        this.a.b();
        return;
      }
    } while (!"android.intent.action.TIMEZONE_CHANGED".equals(paramContext));
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhi
 * JD-Core Version:    0.7.0.1
 */