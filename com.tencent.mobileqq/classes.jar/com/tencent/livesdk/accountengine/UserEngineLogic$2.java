package com.tencent.livesdk.accountengine;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.livesdk.servicefactory.ServiceManager;

class UserEngineLogic$2
  implements EnterExitRoomCallback
{
  UserEngineLogic$2(UserEngineLogic paramUserEngineLogic) {}
  
  public void onFail(int paramInt, String paramString)
  {
    LogInterface localLogInterface = ((LogSdkServiceInterface)UserEngineLogic.access$100(this.this$0).getService(LogSdkServiceInterface.class)).getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("re-login exit room fail, errorCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    localLogInterface.i("UserEngineLogic", localStringBuilder.toString(), new Object[0]);
  }
  
  public void onSuccess()
  {
    ((LogSdkServiceInterface)UserEngineLogic.access$100(this.this$0).getService(LogSdkServiceInterface.class)).getLog().i("UserEngineLogic", "re-login exit room success", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngineLogic.2
 * JD-Core Version:    0.7.0.1
 */