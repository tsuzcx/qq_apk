package com.tencent.livesdk.accountengine;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.crash.CrashInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceManager;
import java.util.Iterator;
import java.util.List;

class UserEngineLogic$1
  implements LoginCallback
{
  UserEngineLogic$1(UserEngineLogic paramUserEngineLogic, LoginRequest paramLoginRequest, SdkLoginCallback paramSdkLoginCallback) {}
  
  public void onFail(int paramInt, String paramString)
  {
    UserEngineLogic.access$302(this.this$0, 2);
    this.val$loginCallback.onFail(paramInt, paramString);
    paramString = UserEngineLogic.access$400(this.this$0).iterator();
    while (paramString.hasNext()) {
      ((UserInitStateCallback)paramString.next()).onLoginFail(paramInt);
    }
    ((LogSdkServiceInterface)UserEngineLogic.access$100(this.this$0).getService(LogSdkServiceInterface.class)).setUid(String.valueOf(this.val$loginRequest.id));
    ((LogSdkServiceInterface)UserEngineLogic.access$100(this.this$0).getService(LogSdkServiceInterface.class)).upload(String.valueOf(this.val$loginRequest.id));
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    this.val$loginRequest.flushToSp(UserEngineLogic.access$000(this.this$0));
    ((LogSdkServiceInterface)UserEngineLogic.access$100(this.this$0).getService(LogSdkServiceInterface.class)).setUid(String.valueOf(paramLoginInfo.uid));
    ((LogSdkServiceInterface)UserEngineLogic.access$100(this.this$0).getService(LogSdkServiceInterface.class)).upload(String.valueOf(paramLoginInfo.uid));
    UserEngineLogic.access$200(this.this$0).i("UserEngineLogic", "new ticket OK :) tinyid: " + paramLoginInfo.tinyid, new Object[0]);
    UserEngineLogic.access$200(this.this$0).i("UserEngineLogic", "now create channel...", new Object[0]);
    ((CrashInterface)UserEngineLogic.access$100(this.this$0).getService(CrashInterface.class)).setUid(paramLoginInfo.uid);
    ((ChannelInterface)UserEngineLogic.access$100(this.this$0).getService(ChannelInterface.class)).setLoginInfo(paramLoginInfo);
    ((LiveConfigServiceInterface)UserEngineLogic.access$100(this.this$0).getService(LiveConfigServiceInterface.class)).handleLoginSuccess(paramLoginInfo.configData);
    long l = paramLoginInfo.uid;
    ((ChannelInterface)UserEngineLogic.access$100(this.this$0).getService(ChannelInterface.class)).create(new UserEngineLogic.1.1(this, l, paramLoginInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngineLogic.1
 * JD-Core Version:    0.7.0.1
 */