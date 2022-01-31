import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class asxq
  extends BroadcastReceiver
{
  asxq(asxg paramasxg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("close.activity".equals(paramContext)) {
      if (asxg.a(this.a) != null) {
        asxg.a(this.a).finish();
      }
    }
    while ((!"close.loading".equals(paramContext)) || (this.a.a == null)) {
      return;
    }
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxq
 * JD-Core Version:    0.7.0.1
 */