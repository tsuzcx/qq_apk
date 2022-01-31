import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bdvg
  extends BroadcastReceiver
{
  bdvg(bdvf parambdvf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (bfol)bfoy.a((Activity)paramContext, null);
      paramContext.b(2131698236);
      paramContext.c(2131690596);
      paramContext.a(new bdvh(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bdvg
 * JD-Core Version:    0.7.0.1
 */