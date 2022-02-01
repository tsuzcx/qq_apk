package com.tencent.ilivesdk.loginservice;

import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginServiceAdapter;

class LoginServiceImpl$1
  implements LoginCallback
{
  LoginServiceImpl$1(LoginServiceImpl paramLoginServiceImpl, LoginCallback paramLoginCallback, LoginRequest paramLoginRequest) {}
  
  public void onFail(int paramInt, String paramString)
  {
    LoginCallback localLoginCallback = this.a;
    if (localLoginCallback != null) {
      localLoginCallback.onFail(paramInt, paramString);
    }
    this.c.reportLoginResultEvent(0, paramInt, this.b.id);
    if ((LoginServiceImpl.access$000(this.c) != null) && (LoginServiceImpl.access$000(this.c).getHostProxyInterface() != null) && (LoginServiceImpl.access$000(this.c).getHostProxyInterface().getSdkEventInterface() != null)) {
      LoginServiceImpl.access$000(this.c).getHostProxyInterface().getSdkEventInterface().onLoginFail(this.b.id, paramInt);
    }
    LoginServiceImpl.access$200(this.c, paramInt);
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    LoginCallback localLoginCallback = this.a;
    if (localLoginCallback != null) {
      localLoginCallback.onSucceed(paramLoginInfo);
    }
    this.c.reportLoginResultEvent(1, 0, this.b.id);
    if ((LoginServiceImpl.access$000(this.c) != null) && (LoginServiceImpl.access$000(this.c).getHostProxyInterface() != null) && (LoginServiceImpl.access$000(this.c).getHostProxyInterface().getSdkEventInterface() != null)) {
      LoginServiceImpl.access$000(this.c).getHostProxyInterface().getSdkEventInterface().onLoginSuccess(paramLoginInfo.uid, this.b.id);
    }
    LoginServiceImpl.access$100(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */