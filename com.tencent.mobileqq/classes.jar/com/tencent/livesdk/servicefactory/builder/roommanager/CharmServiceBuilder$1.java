package com.tencent.livesdk.servicefactory.builder.roommanager;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.charmservice_interface.CharmServiceAdapter;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class CharmServiceBuilder$1
  implements CharmServiceAdapter
{
  CharmServiceBuilder$1(CharmServiceBuilder paramCharmServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceAccessor.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceAccessor.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.val$serviceAccessor.getService(DataReportInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceAccessor.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.roommanager.CharmServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */