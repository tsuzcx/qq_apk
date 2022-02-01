package com.tencent.livesdk.servicefactory.builder.userinfo;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class UserInfoServiceBuilder$1
  implements UserInfoServiceAdapter
{
  UserInfoServiceBuilder$1(UserInfoServiceBuilder paramUserInfoServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.userinfo.UserInfoServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */