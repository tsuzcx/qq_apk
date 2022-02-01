package com.tencent.ilive;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.livesdk.accountengine.SdkLoginCallback;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.accountengine.UserEngineLogic;
import com.tencent.livesdk.liveengine.LiveEngine;

final class LiveSDK$2
  implements SdkLoginCallback
{
  LiveSDK$2(SdkLoginCallback paramSdkLoginCallback, LoginRequest paramLoginRequest) {}
  
  public void onFail(int paramInt, String paramString)
  {
    ((LogInterface)LiveSDK.liveEngine.getService(LogInterface.class)).e("livesdk", "livesdk login fail :( , code " + paramInt + ", msg " + paramString, new Object[0]);
    this.val$sdkLoginCallback.onFail(paramInt, paramString);
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    ((LogInterface)LiveSDK.liveEngine.getService(LogInterface.class)).i("livesdk", "livesdk login ok", new Object[0]);
    this.val$sdkLoginCallback.onSucceed(paramLoginInfo);
    if (this.val$request.initOpenSDK) {
      LiveSDK.userEngine.getEnginLogic().initOpensdkAv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.LiveSDK.2
 * JD-Core Version:    0.7.0.1
 */