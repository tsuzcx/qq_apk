package com.tencent.livesdk.accountengine;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.livesdk.servicefactory.ServiceManager;

class UserEngineLogic$6
  implements LoginCallback
{
  UserEngineLogic$6(UserEngineLogic paramUserEngineLogic) {}
  
  public void onFail(int paramInt, String paramString)
  {
    ((ToastInterface)UserEngineLogic.access$100(this.this$0).getService(ToastInterface.class)).showToast("直播模块登录异常，请尝试重新登录");
    UserEngineLogic.access$200(this.this$0).e("UserEngineLogic", "updateAuthTicket-> refreshLogin invalid, code=" + paramInt + ", msg=" + paramString, new Object[0]);
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    ((ChannelInterface)UserEngineLogic.access$100(this.this$0).getService(ChannelInterface.class)).setLoginInfo(paramLoginInfo);
    UserEngineLogic.access$200(this.this$0).e("UserEngineLogic", "updateAuthTicket-> refreshLogin success", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngineLogic.6
 * JD-Core Version:    0.7.0.1
 */