import android.content.Context;
import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class auul
  implements EIPCResultCallback
{
  public auul(GameSessionView paramGameSessionView, Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null)
      {
        paramEIPCResult = paramEIPCResult.getString("key_get_msg_list_url");
        QLog.i(GameSessionView.a, 1, "[onCallback] url:" + paramEIPCResult);
        autf.a(paramEIPCResult, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameCenterSessionInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auul
 * JD-Core Version:    0.7.0.1
 */