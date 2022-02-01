package com.tencent.ilivesdk.loginservice;

import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginInfo;

class LoginImpl$2
  implements Runnable
{
  LoginImpl$2(LoginImpl paramLoginImpl, LoginInfo paramLoginInfo, LoginCallback paramLoginCallback, int paramInt, String paramString) {}
  
  public void run()
  {
    LoginInfo localLoginInfo = this.val$loginInfo;
    if (localLoginInfo == null)
    {
      this.val$loginCallback.onFail(this.val$code, this.val$msg);
      return;
    }
    this.val$loginCallback.onSucceed(localLoginInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpl.2
 * JD-Core Version:    0.7.0.1
 */