package com.tencent.livesdk.servicefactory.builder.supervision;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.supervisionservice_interface.SupervisionServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class SupervisionServiceBuilder$1
  implements SupervisionServiceAdapter
{
  SupervisionServiceBuilder$1(SupervisionServiceBuilder paramSupervisionServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public LoginServiceInterface getAccount()
  {
    return (LoginServiceInterface)this.val$serviceManager.getService(LoginServiceInterface.class);
  }
  
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
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.supervision.SupervisionServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */