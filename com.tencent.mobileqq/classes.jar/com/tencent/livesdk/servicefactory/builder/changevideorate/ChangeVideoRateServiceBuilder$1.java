package com.tencent.livesdk.servicefactory.builder.changevideorate;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.changevideorateservice_interface.ChangeVideoRateServiceAdapter;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class ChangeVideoRateServiceBuilder$1
  implements ChangeVideoRateServiceAdapter
{
  ChangeVideoRateServiceBuilder$1(ChangeVideoRateServiceBuilder paramChangeVideoRateServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public String getAppId()
  {
    return ((AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class)).getAppId();
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public PushReceiver getPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.changevideorate.ChangeVideoRateServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */