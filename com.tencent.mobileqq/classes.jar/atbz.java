import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class atbz
  extends BroadcastReceiver
{
  atbz(atbp paramatbp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("close.activity".equals(paramContext)) {
      if (atbp.a(this.a) != null) {
        atbp.a(this.a).finish();
      }
    }
    while ((!"close.loading".equals(paramContext)) || (this.a.a == null)) {
      return;
    }
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbz
 * JD-Core Version:    0.7.0.1
 */