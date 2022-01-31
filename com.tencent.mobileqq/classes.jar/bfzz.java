import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bfzz
  extends BroadcastReceiver
{
  bfzz(bfzy parambfzy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (bhuf)bhus.a((Activity)paramContext, null);
      paramContext.b(2131698548);
      paramContext.c(2131690648);
      paramContext.a(new bgaa(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfzz
 * JD-Core Version:    0.7.0.1
 */