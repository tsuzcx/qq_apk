import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class arfb
  extends BroadcastReceiver
{
  arfb(arez paramarez) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    int k;
    int i;
    if (paramContext.equals(arfy.a("com.tencent.od")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoWebPlugin", 2, "state:" + j);
      }
      paramContext = arfp.a;
      k = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || ((j == paramContext[i]) && (arez.a(this.a).isShowing()))) {}
      try
      {
        arez.a(this.a).dismiss();
        label105:
        i += 1;
        continue;
        return;
      }
      catch (Throwable paramIntent)
      {
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arfb
 * JD-Core Version:    0.7.0.1
 */