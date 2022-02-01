package com.tencent.livesdk.servicefactory.builder.roompush;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class RoomPushServiceBuilder$1
  implements RoomPushServiceAdapter
{
  RoomPushServiceBuilder$1(RoomPushServiceBuilder paramRoomPushServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public AppGeneralInfoService getAppGeneralInfo()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public HostProxyInterface getHostProxyInterface()
  {
    return (HostProxyInterface)this.val$serviceManager.getService(HostProxyInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public LoginServiceInterface getLoginInfo()
  {
    return (LoginServiceInterface)this.val$serviceManager.getService(LoginServiceInterface.class);
  }
  
  public String getProgramId()
  {
    RoomServiceInterface localRoomServiceInterface = (RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class);
    if ((localRoomServiceInterface.getLiveInfo() != null) && (localRoomServiceInterface.getLiveInfo().roomInfo != null)) {
      return localRoomServiceInterface.getLiveInfo().roomInfo.programId;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.roompush.RoomPushServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */