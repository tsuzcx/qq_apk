import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class baky
  extends BroadcastReceiver
{
  private baky(bakx parambakx) {}
  
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
          if (banp.a().b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VoiceAssistantManager", 2, "VoiceAssistantReceiver not allow");
        return;
        paramContext = paramIntent.getAction();
        if ((!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) && (!"tencent.av.v2q.StartVideoChat".equals(paramContext))) {
          break;
        }
        bakl.a("HelloQQWake", "releaseQQWake()");
        if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
          banp.a().f = true;
        }
        if (this.a.c()) {
          bakx.a(this.a, false);
        }
        banp.a().b(paramContext);
      } while (!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext));
      banp.a().a();
      return;
      if (("mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) || ("tencent.av.v2q.StopVideoChat".equals(paramContext)))
      {
        if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) {
          banp.a().f = false;
        }
        banp.a().a(paramContext);
        return;
      }
    } while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext));
    banp.a().b(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baky
 * JD-Core Version:    0.7.0.1
 */