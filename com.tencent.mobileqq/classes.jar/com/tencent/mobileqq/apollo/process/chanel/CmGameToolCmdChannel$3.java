package com.tencent.mobileqq.apollo.process.chanel;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class CmGameToolCmdChannel$3
  implements EIPCResultCallback
{
  CmGameToolCmdChannel$3(long paramLong, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("resData");
    CmGameUtil.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, this.jdField_a_of_type_JavaLangString, paramEIPCResult);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameToolCmdChannel", 2, " GET_DRESS_PATH onCallback resJson:" + paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel.3
 * JD-Core Version:    0.7.0.1
 */