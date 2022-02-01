package com.tencent.mobileqq.apollo.game.process.chanel;

import android.os.Bundle;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class CmGameToolCmdChannel$2
  implements EIPCResultCallback
{
  CmGameToolCmdChannel$2(long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("respData");
    ApolloCmdChannel.getInstance().callbackFromRequest(this.a, 0, "cs.on_get_open_key.local", paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameToolCmdChannel.2
 * JD-Core Version:    0.7.0.1
 */