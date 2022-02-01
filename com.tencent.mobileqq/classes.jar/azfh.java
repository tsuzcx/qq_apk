import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class azfh
  extends BroadcastReceiver
{
  private azfh(azfg paramazfg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (azhh.a().b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VoiceAssistantManager", 2, "VoiceAssistantReceiver not allow");
        return;
        paramContext = paramIntent.getAction();
        if ((!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) && (!"tencent.av.v2q.StartVideoChat".equals(paramContext))) {
          break;
        }
        azeu.a("HelloQQWake", "releaseQQWake()");
        if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
          azhh.a().f = true;
        }
        if (this.a.b()) {
          azfg.a(this.a, false, false);
        }
        azhh.a().b(paramContext);
      } while (!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext));
      azhh.a().a();
      return;
      if (("mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) || ("tencent.av.v2q.StopVideoChat".equals(paramContext)))
      {
        if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) {
          azhh.a().f = false;
        }
        azhh.a().a(paramContext);
        return;
      }
    } while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext));
    azhh.a().b(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfh
 * JD-Core Version:    0.7.0.1
 */