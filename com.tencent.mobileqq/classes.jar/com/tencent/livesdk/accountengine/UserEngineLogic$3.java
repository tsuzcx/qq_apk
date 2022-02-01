package com.tencent.livesdk.accountengine;

import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LogoutCallback;

class UserEngineLogic$3
  implements LogoutCallback
{
  UserEngineLogic$3(UserEngineLogic paramUserEngineLogic, LoginRequest paramLoginRequest, SdkLoginCallback paramSdkLoginCallback) {}
  
  public void onFail(int paramInt, String paramString)
  {
    UserEngineLogic.access$500(this.this$0, this.val$loginRequest, this.val$sdkLoginCallback);
  }
  
  public void onSucceed()
  {
    UserEngineLogic.access$500(this.this$0, this.val$loginRequest, this.val$sdkLoginCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngineLogic.3
 * JD-Core Version:    0.7.0.1
 */