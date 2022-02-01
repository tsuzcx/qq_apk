package com.tencent.mobileqq.apollo.process.chanel;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class CmGameToolCmdChannel$1
  implements EIPCResultCallback
{
  CmGameToolCmdChannel$1(long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("respData");
    CmGameUtil.a().callbackFromRequest(this.a, 0, "cs.check_pubAccount_state.local", paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel.1
 * JD-Core Version:    0.7.0.1
 */