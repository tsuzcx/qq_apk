import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class aszy
  extends BroadcastReceiver
{
  aszy(aszw paramaszw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    int k;
    int i;
    if (paramContext.equals(atav.a("com.tencent.od")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoWebPlugin", 2, "state:" + j);
      }
      paramContext = atam.a;
      k = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || ((j == paramContext[i]) && (aszw.a(this.a).isShowing()))) {}
      try
      {
        aszw.a(this.a).dismiss();
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
 * Qualified Name:     aszy
 * JD-Core Version:    0.7.0.1
 */