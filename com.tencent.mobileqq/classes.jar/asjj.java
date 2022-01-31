import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;

public class asjj
  extends BroadcastReceiver
{
  private asjj(GameSessionView paramGameSessionView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      String str2 = GameSessionView.a;
      if ("[onRecevier] action:" + str1 + ",data:" + paramIntent.getExtras() != null)
      {
        paramContext = paramIntent.getExtras().toString();
        QLog.d(str2, 0, paramContext);
      }
    }
    else
    {
      if (str1 != null) {
        break label78;
      }
    }
    label78:
    int i;
    label163:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramContext = null;
            break;
            if (!"action_qgame_messgae_change".equals(str1)) {
              break label163;
            }
            paramContext = paramIntent.getExtras();
          } while (paramContext == null);
          paramIntent = (GameCenterSessionInfo)paramContext.getParcelable("key_game_msg");
          i = paramContext.getInt("key_msg_change_type");
          if (QLog.isColorLevel()) {
            QLog.d(GameSessionView.a, 0, "[onReceive] type:" + i + ",info:" + paramIntent);
          }
          this.a.a();
          return;
        } while (!"action_qgame_unread_change".equals(str1));
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      i = paramContext.getInt("key_msg_unread_cnt");
    } while (!QLog.isColorLevel());
    QLog.d(GameSessionView.a, 0, "[onReceive] cnt:" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjj
 * JD-Core Version:    0.7.0.1
 */