import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bjys
  extends BroadcastReceiver
{
  bjys(bjyr parambjyr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (bkzi)bkzz.a((Activity)paramContext, null);
      paramContext.b(2131697981);
      paramContext.c(2131690697);
      paramContext.a(new bjyt(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjys
 * JD-Core Version:    0.7.0.1
 */