package com.tencent.livesdk.servicefactory.builder.room;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class RoomServiceBuilder$1
  implements RoomServiceAdapter
{
  RoomServiceBuilder$1(RoomServiceBuilder paramRoomServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.val$serviceManager.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.val$serviceManager.getService(DataReportInterface.class);
  }
  
  public HostProxyInterface getHostProxyInterface()
  {
    return (HostProxyInterface)this.val$serviceManager.getService(HostProxyInterface.class);
  }
  
  public HttpInterface getHttpInterface()
  {
    return (HttpInterface)this.val$serviceManager.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.room.RoomServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */