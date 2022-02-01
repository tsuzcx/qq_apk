package com.tencent.livesdk.accountengine;

import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.livesdk.servicefactory.ServiceManager;

class UserEngineLogic$4
  implements SdkLoginCallback
{
  UserEngineLogic$4(UserEngineLogic paramUserEngineLogic, SdkLoginCallback paramSdkLoginCallback) {}
  
  public void onFail(int paramInt, String paramString)
  {
    this.val$sdkLoginCallback.onFail(paramInt, paramString);
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    if ((UserEngineLogic.access$600(this.this$0) != null) && (UserEngineLogic.access$700(this.this$0) != null)) {
      UserEngineLogic.access$700(this.this$0).getEnginLogic().reWatchEnterRoom(UserEngineLogic.access$600(this.this$0));
    } else {
      ((LoginServiceInterface)UserEngineLogic.access$100(this.this$0).getService(LoginServiceInterface.class)).notifyLoginRefresh();
    }
    this.val$sdkLoginCallback.onSucceed(paramLoginInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngineLogic.4
 * JD-Core Version:    0.7.0.1
 */