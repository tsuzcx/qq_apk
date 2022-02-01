package com.tencent.mobileqq.apollo.lightGame;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class CmGameAudioManager$1
  implements EIPCResultCallback
{
  CmGameAudioManager$1(CmGameAudioManager paramCmGameAudioManager) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("key_game_friUin");
      QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] current game friendUin:" + paramEIPCResult + ",mCurrentFriUin:" + CmGameAudioManager.a(this.a));
      if (!CmGameAudioManager.a(this.a).equals(paramEIPCResult))
      {
        CmGameAudioManager.a(this.a).removeMessages(1);
        CmGameAudioManager.a(this.a).sendEmptyMessage(1);
      }
      return;
    }
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] game is not exist. exit room");
    CmGameAudioManager.a(this.a).removeMessages(1);
    CmGameAudioManager.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager.1
 * JD-Core Version:    0.7.0.1
 */