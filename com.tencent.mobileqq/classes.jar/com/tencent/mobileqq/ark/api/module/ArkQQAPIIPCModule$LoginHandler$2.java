package com.tencent.mobileqq.ark.api.module;

import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class ArkQQAPIIPCModule$LoginHandler$2
  extends WtloginObserver
{
  ArkQQAPIIPCModule$LoginHandler$2(ArkQQAPIIPCModule.LoginHandler paramLoginHandler, ArkQQAPIIPCModule.LoginHandler.OnLoginEventHandler paramOnLoginEventHandler) {}
  
  public void onGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramErrMsg = new StringBuilder();
      paramErrMsg.append("OnGetOpenKeyWithoutPasswd userAccount=");
      paramErrMsg.append(paramString);
      paramErrMsg.append(", dwSrcAppid=");
      paramErrMsg.append(paramLong1);
      paramErrMsg.append(", dwDstAppid=");
      paramErrMsg.append(paramLong2);
      paramErrMsg.append(", dwMainSigMap=");
      paramErrMsg.append(paramInt1);
      paramErrMsg.append(", ret=");
      paramErrMsg.append(paramInt2);
      QLog.d("ArkApp.LoginHandler", 2, paramErrMsg.toString());
    }
    ArkQQAPIIPCModule.LoginHandler.a(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkQQAPIIPCModule$LoginHandler, null);
    if (paramInt2 == 0)
    {
      paramArrayOfByte1 = util.buf_to_string(paramArrayOfByte1);
      paramArrayOfByte2 = util.buf_to_string(paramArrayOfByte2);
      this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkQQAPIIPCModule$LoginHandler$OnLoginEventHandler.a(paramString, paramLong2, paramArrayOfByte1, paramArrayOfByte2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkQQAPIIPCModule$LoginHandler$OnLoginEventHandler.a(null, 0L, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.LoginHandler.2
 * JD-Core Version:    0.7.0.1
 */