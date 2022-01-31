import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bcrf
  extends BroadcastReceiver
{
  bcrf(bcre parambcre) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.a() != null))
    {
      paramContext = (begr)behe.a((Activity)paramContext, null);
      paramContext.b(2131632500);
      paramContext.c(2131625035);
      paramContext.a(new bcrg(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bcrf
 * JD-Core Version:    0.7.0.1
 */