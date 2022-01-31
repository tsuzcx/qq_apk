import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class arha
  extends BroadcastReceiver
{
  arha(argq paramargq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("close.activity".equals(paramContext)) {
      if (argq.a(this.a) != null) {
        argq.a(this.a).finish();
      }
    }
    while ((!"close.loading".equals(paramContext)) || (this.a.a == null)) {
      return;
    }
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arha
 * JD-Core Version:    0.7.0.1
 */