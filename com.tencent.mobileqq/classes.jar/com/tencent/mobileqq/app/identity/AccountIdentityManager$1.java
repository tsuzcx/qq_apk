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
    this.b.a.set(false);
    AccountIdentityManager.a(this.b, this.a, paramRspBody, this);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    this.b.a.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountIdentityManager.1
 * JD-Core Version:    0.7.0.1
 */