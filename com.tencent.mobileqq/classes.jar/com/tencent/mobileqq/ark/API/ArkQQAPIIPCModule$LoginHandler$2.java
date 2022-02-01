package com.tencent.mobileqq.ark.API;

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
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.LoginHandler", 2, "OnGetOpenKeyWithoutPasswd userAccount=" + paramString + ", dwSrcAppid=" + paramLong1 + ", dwDstAppid=" + paramLong2 + ", dwMainSigMap=" + paramInt1 + ", ret=" + paramInt2);
    }
    ArkQQAPIIPCModule.LoginHandler.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$LoginHandler, null);
    if (paramInt2 == 0)
    {
      paramArrayOfByte1 = util.buf_to_string(paramArrayOfByte1);
      paramArrayOfByte2 = util.buf_to_string(paramArrayOfByte2);
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$LoginHandler$OnLoginEventHandler.a(paramString, paramLong2, paramArrayOfByte1, paramArrayOfByte2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$LoginHandler$OnLoginEventHandler.a(null, 0L, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.LoginHandler.2
 * JD-Core Version:    0.7.0.1
 */