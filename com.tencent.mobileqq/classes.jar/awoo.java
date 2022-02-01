import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.qphone.base.util.QLog;

public class awoo
  extends BroadcastReceiver
{
  private awoo(QQMusicPlayService paramQQMusicPlayService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      QLog.d("QQMusicPlay.QQMusicPlayService", 1, "QQMusicPlayBroadcastReceiver onReceive,action:" + paramIntent.getAction());
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && ((paramContext.equals("com.tencent.mobileqq.intent.logout")) || (paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) || (paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) || (paramContext.equals("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName())) || (paramContext.equals("mqq.intent.action.LOGOUT")) || (paramContext.equals("QQMusicPlay_exit_action"))))
      {
        if (QQMusicPlayService.a(this.a) == null) {
          break label150;
        }
        QQMusicPlayService.a(this.a).sendEmptyMessage(11);
      }
    }
    return;
    label150:
    this.a.stopSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awoo
 * JD-Core Version:    0.7.0.1
 */