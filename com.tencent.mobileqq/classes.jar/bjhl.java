import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bjhl
  extends BroadcastReceiver
{
  bjhl(bjhk parambjhk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (bkho)bkif.a((Activity)paramContext, null);
      paramContext.b(2131697470);
      paramContext.c(2131690582);
      paramContext.a(new bjhm(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjhl
 * JD-Core Version:    0.7.0.1
 */