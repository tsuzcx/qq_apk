import android.os.Bundle;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.gamecenter.view.GameSessionView.3.1;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;

public class atzj
  implements EIPCResultCallback
{
  public atzj(GameSessionView paramGameSessionView) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    List localList;
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null)
      {
        localList = (List)paramEIPCResult.getSerializable("key_get_game_msg");
        if (GameSessionView.a(this.a)) {
          break label97;
        }
        if (paramEIPCResult.getBoolean("key_get_game_gray_user", false)) {
          break label62;
        }
        if (QLog.isColorLevel()) {
          QLog.d(GameSessionView.a, 0, "[setData] gray is not open. return.");
        }
      }
    }
    return;
    label62:
    GameSessionView.a(this.a, paramEIPCResult.getBoolean("key_get_game_show_on_list", false));
    GameSessionView.a(paramEIPCResult.getBoolean("key_get_game_show_req_msg_unread", false));
    GameSessionView.b(this.a, true);
    label97:
    QLog.e(GameSessionView.a, 1, "[onCallback] list:" + localList.size() + ",type:" + GameSessionView.a(this.a));
    GameSessionView.a(this.a).post(new GameSessionView.3.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzj
 * JD-Core Version:    0.7.0.1
 */