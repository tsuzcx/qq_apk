import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.qphone.base.util.QLog;

class aupq
  extends BroadcastReceiver
{
  aupq(aupc paramaupc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramContext))
    {
      QLog.i("XProxy|NowProxy", 1, "accountReceiver, expired");
      NowLive.killPluginProcess();
    }
    while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext)) {
      return;
    }
    QLog.i("XProxy|NowProxy", 1, "accountReceiver, kicked");
    NowLive.killPluginProcess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupq
 * JD-Core Version:    0.7.0.1
 */