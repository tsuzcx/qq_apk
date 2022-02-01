package com.tencent.ilivesdk.loginservice;

import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginRequest;

class LoginServiceImpl$1
  implements LoginCallback
{
  LoginServiceImpl$1(LoginServiceImpl paramLoginServiceImpl, LoginCallback paramLoginCallback, LoginRequest paramLoginRequest) {}
  
  public void onFail(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginCallback != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginCallback.onFail(paramInt, paramString);
    }
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl.reportLoginResultEvent(0, paramInt, this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.id);
    LoginServiceImpl.access$100(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl, paramInt);
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginCallback != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginCallback.onSucceed(paramLoginInfo);
    }
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl.reportLoginResultEvent(1, 0, this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.id);
    LoginServiceImpl.access$000(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceLoginServiceImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */