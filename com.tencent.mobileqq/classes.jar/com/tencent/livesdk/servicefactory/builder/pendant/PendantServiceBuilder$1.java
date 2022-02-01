package com.tencent.livesdk.servicefactory.builder.pendant;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.pendantservice_interface.PendantServiceAdapter;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class PendantServiceBuilder$1
  implements PendantServiceAdapter
{
  PendantServiceBuilder$1(PendantServiceBuilder paramPendantServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.val$serviceManager.getService(DataReportInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public long getRoomId()
  {
    LiveInfo localLiveInfo = ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo();
    if ((localLiveInfo != null) && (localLiveInfo.roomInfo != null)) {
      return localLiveInfo.roomInfo.roomId;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.pendant.PendantServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */