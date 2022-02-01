import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bkil
  extends BroadcastReceiver
{
  bkil(bkik parambkik) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (blir)blji.a((Activity)paramContext, null);
      paramContext.b(2131697552);
      paramContext.c(2131690580);
      paramContext.a(new bkim(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkil
 * JD-Core Version:    0.7.0.1
 */