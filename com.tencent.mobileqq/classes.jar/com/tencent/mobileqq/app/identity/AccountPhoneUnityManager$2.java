package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

class AccountPhoneUnityManager$2
  extends LoginVerifyObserver
{
  AccountPhoneUnityManager$2(AccountPhoneUnityManager paramAccountPhoneUnityManager, AppRuntime paramAppRuntime) {}
  
  public void getPhoneUnitySuccess(cmd0x9ae.RspBody paramRspBody)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountPhoneUnityManager.a(this.jdField_a_of_type_MqqAppAppRuntime, paramRspBody);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("AccountPhoneUnityManager", 1, new Object[] { "onFailedResponse code : ", Integer.valueOf(paramInt), " message : ", paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.2
 * JD-Core Version:    0.7.0.1
 */