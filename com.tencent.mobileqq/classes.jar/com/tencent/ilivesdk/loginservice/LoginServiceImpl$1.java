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
    LoginCallback localLoginCallback = this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginCallback;
    if (localLoginCallback != null) {
      localLoginCallback.onFail(paramInt, paramString);
    }
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl.reportLoginResultEvent(0, paramInt, this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.id);
    if ((LoginServiceImpl.access$000(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl) != null) && (LoginServiceImpl.access$000(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl).getHostProxyInterface() != null) && (LoginServiceImpl.access$000(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl).getHostProxyInterface().getSdkEventInterface() != null)) {
      LoginServiceImpl.access$000(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl).getHostProxyInterface().getSdkEventInterface().onLoginFail(this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.id, paramInt);
    }
    LoginServiceImpl.access$200(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl, paramInt);
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    LoginCallback localLoginCallback = this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginCallback;
    if (localLoginCallback != null) {
      localLoginCallback.onSucceed(paramLoginInfo);
    }
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl.reportLoginResultEvent(1, 0, this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.id);
    if ((LoginServiceImpl.access$000(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl) != null) && (LoginServiceImpl.access$000(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl).getHostProxyInterface() != null) && (LoginServiceImpl.access$000(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl).getHostProxyInterface().getSdkEventInterface() != null)) {
      LoginServiceImpl.access$000(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl).getHostProxyInterface().getSdkEventInterface().onLoginSuccess(paramLoginInfo.uid, this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.id);
    }
    LoginServiceImpl.access$100(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */