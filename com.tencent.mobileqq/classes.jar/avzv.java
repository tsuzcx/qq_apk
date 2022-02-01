import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class avzv
  extends BroadcastReceiver
{
  avzv(avzt paramavzt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    int k;
    int i;
    if (paramContext.equals(awax.a("com.tencent.od")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoWebPlugin", 2, "state:" + j);
      }
      paramContext = awaj.a;
      k = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || ((j == paramContext[i]) && (avzt.a(this.a).isShowing()))) {}
      try
      {
        avzt.a(this.a).dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzv
 * JD-Core Version:    0.7.0.1
 */