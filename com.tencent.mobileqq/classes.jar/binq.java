import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class binq
  extends BroadcastReceiver
{
  binq(binp parambinp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (bjnw)bjon.a((Activity)paramContext, null);
      paramContext.b(2131697698);
      paramContext.c(2131690620);
      paramContext.a(new binr(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     binq
 * JD-Core Version:    0.7.0.1
 */