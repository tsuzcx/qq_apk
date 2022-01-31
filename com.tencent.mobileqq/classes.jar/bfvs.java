import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bfvs
  extends BroadcastReceiver
{
  bfvs(bfvr parambfvr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (bhpy)bhql.a((Activity)paramContext, null);
      paramContext.b(2131698536);
      paramContext.c(2131690648);
      paramContext.a(new bfvt(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvs
 * JD-Core Version:    0.7.0.1
 */