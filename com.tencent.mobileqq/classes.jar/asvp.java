import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class asvp
  extends BroadcastReceiver
{
  asvp(asvn paramasvn) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    int k;
    int i;
    if (paramContext.equals(aswm.a("com.tencent.od")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoWebPlugin", 2, "state:" + j);
      }
      paramContext = aswd.a;
      k = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || ((j == paramContext[i]) && (asvn.a(this.a).isShowing()))) {}
      try
      {
        asvn.a(this.a).dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvp
 * JD-Core Version:    0.7.0.1
 */