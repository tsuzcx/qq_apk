import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;

public class asnq
  implements EIPCResultCallback
{
  public asnq(GameSessionView paramGameSessionView) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null)
      {
        paramEIPCResult = (List)paramEIPCResult.getSerializable("key_get_game_msg");
        QLog.e(GameSessionView.a, 1, "[onCallback] list:" + paramEIPCResult.size());
        this.a.setData(paramEIPCResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnq
 * JD-Core Version:    0.7.0.1
 */