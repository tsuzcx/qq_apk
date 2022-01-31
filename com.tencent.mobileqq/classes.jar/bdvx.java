import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bdvx
  extends BroadcastReceiver
{
  bdvx(bdvw parambdvw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (bfpc)bfpp.a((Activity)paramContext, null);
      paramContext.b(2131698246);
      paramContext.c(2131690596);
      paramContext.a(new bdvy(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bdvx
 * JD-Core Version:    0.7.0.1
 */