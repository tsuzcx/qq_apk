package com.tencent.livesdk.servicefactory.builder.harvest;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.harvestservice_interface.HarvestServiceAdapter;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class HarvestServiceBuilder$1
  implements HarvestServiceAdapter
{
  HarvestServiceBuilder$1(HarvestServiceBuilder paramHarvestServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.harvest.HarvestServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */