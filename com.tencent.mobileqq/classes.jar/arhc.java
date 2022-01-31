import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class arhc
  extends BroadcastReceiver
{
  arhc(args paramargs) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("close.activity".equals(paramContext)) {
      if (args.a(this.a) != null) {
        args.a(this.a).finish();
      }
    }
    while ((!"close.loading".equals(paramContext)) || (this.a.a == null)) {
      return;
    }
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arhc
 * JD-Core Version:    0.7.0.1
 */