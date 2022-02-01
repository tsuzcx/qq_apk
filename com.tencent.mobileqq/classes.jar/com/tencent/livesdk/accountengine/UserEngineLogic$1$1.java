package com.tencent.livesdk.accountengine;

import com.tencent.falco.base.libapi.channel.ChannelCreateCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceManager;
import java.util.Iterator;
import java.util.List;

class UserEngineLogic$1$1
  implements ChannelCreateCallback
{
  UserEngineLogic$1$1(UserEngineLogic.1 param1, long paramLong, LoginInfo paramLoginInfo) {}
  
  public void onFail(int paramInt, String paramString)
  {
    UserEngineLogic.access$302(this.this$1.this$0, 2);
    this.this$1.val$loginCallback.onFail(paramInt, paramString);
    paramString = UserEngineLogic.access$400(this.this$1.this$0).iterator();
    while (paramString.hasNext()) {
      ((UserInitStateCallback)paramString.next()).onLoginFail(paramInt);
    }
  }
  
  public void onSucceed()
  {
    UserEngineLogic.access$200(this.this$1.this$0).i("UserEngineLogic", "good, channel OK :)", new Object[0]);
    ((UserInfoServiceInterface)UserEngineLogic.access$100(this.this$1.this$0).getService(UserInfoServiceInterface.class)).queryUserInfo(this.val$selfUid, new UserEngineLogic.1.1.1(this));
    UserEngineLogic.access$302(this.this$1.this$0, 3);
    this.this$1.val$loginCallback.onSucceed(this.val$loginInfo);
    Iterator localIterator = UserEngineLogic.access$400(this.this$1.this$0).iterator();
    while (localIterator.hasNext()) {
      ((UserInitStateCallback)localIterator.next()).onLoginSucceed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngineLogic.1.1
 * JD-Core Version:    0.7.0.1
 */