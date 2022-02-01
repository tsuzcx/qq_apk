import android.os.Bundle;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class amtn
  implements EIPCResultCallback
{
  amtn(amtm paramamtm) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("key_game_friUin");
      QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] current game friendUin:" + paramEIPCResult + ",mCurrentFriUin:" + amtm.a(this.a));
      if (!amtm.a(this.a).equals(paramEIPCResult))
      {
        amtm.a(this.a).removeMessages(1);
        amtm.a(this.a).sendEmptyMessage(1);
      }
      return;
    }
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] game is not exist. exit room");
    amtm.a(this.a).removeMessages(1);
    amtm.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtn
 * JD-Core Version:    0.7.0.1
 */