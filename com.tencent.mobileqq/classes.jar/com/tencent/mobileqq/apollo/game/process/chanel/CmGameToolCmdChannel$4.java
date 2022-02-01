package com.tencent.mobileqq.apollo.game.process.chanel;

import android.os.Bundle;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class CmGameToolCmdChannel$4
  implements EIPCResultCallback
{
  CmGameToolCmdChannel$4(long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("resData");
    ApolloCmdChannel.getInstance().callbackFromRequest(this.a, 0, "sc.script_notify_action_ready.local", paramEIPCResult);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" GET_ACTION_DATA onCallback resJson:");
      localStringBuilder.append(paramEIPCResult);
      QLog.d("cmgame_process.CmGameToolCmdChannel", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameToolCmdChannel.4
 * JD-Core Version:    0.7.0.1
 */