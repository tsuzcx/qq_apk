package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

class AccountPhoneUnityManager$3
  extends LoginVerifyObserver
{
  AccountPhoneUnityManager$3(AccountPhoneUnityManager paramAccountPhoneUnityManager, QQAppInterface paramQQAppInterface) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("AccountPhoneUnityManager", 1, new Object[] { "onFailedResponse code : ", Integer.valueOf(paramInt), " message : ", paramString2 });
  }
  
  public void b(cmd0x9ae.RspBody paramRspBody)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountPhoneUnityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.3
 * JD-Core Version:    0.7.0.1
 */