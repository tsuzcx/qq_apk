package com.tencent.livesdk.accountengine;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface.OnQueryUserInfoCallback;
import com.tencent.ilivesdk.userinfoservice_interface.model.UserInfo;
import com.tencent.livesdk.servicefactory.ServiceManager;

class UserEngineLogic$1$1$1
  implements UserInfoServiceInterface.OnQueryUserInfoCallback
{
  UserEngineLogic$1$1$1(UserEngineLogic.1.1 param1) {}
  
  public void onFail(boolean paramBoolean, int paramInt, String paramString)
  {
    UserEngineLogic.access$200(this.this$2.this$1.this$0).i("UserEngineLogic", "query selfinfo...fail", new Object[0]);
  }
  
  public void onSuccess(UserInfo paramUserInfo)
  {
    LogInterface localLogInterface = UserEngineLogic.access$200(this.this$2.this$1.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("query selfinfo.suc..uid=");
    localStringBuilder.append(paramUserInfo.uid);
    localStringBuilder.append(";nick=");
    localStringBuilder.append(paramUserInfo.nick);
    localLogInterface.i("UserEngineLogic", localStringBuilder.toString(), new Object[0]);
    ((UserInfoServiceInterface)UserEngineLogic.access$100(this.this$2.this$1.this$0).getService(UserInfoServiceInterface.class)).setSelfInfo(paramUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngineLogic.1.1.1
 * JD-Core Version:    0.7.0.1
 */