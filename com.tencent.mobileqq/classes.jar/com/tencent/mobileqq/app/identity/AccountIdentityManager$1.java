package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.observer.LoginVerifyObserver;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

class AccountIdentityManager$1
  extends LoginVerifyObserver
{
  AccountIdentityManager$1(AccountIdentityManager paramAccountIdentityManager, AppRuntime paramAppRuntime) {}
  
  public void getAccountIdentitySuccess(cmd0x9ae.RspBody paramRspBody)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountIdentityManager.a.set(false);
    AccountIdentityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountIdentityManager, this.jdField_a_of_type_MqqAppAppRuntime, paramRspBody, this);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountIdentityManager.a.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountIdentityManager.1
 * JD-Core Version:    0.7.0.1
 */