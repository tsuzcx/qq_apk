package com.tencent.livesdk.servicefactory.ecommerce;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.ecommerceservice_interface.ECommerceServiceAdapter;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class ECommerceServiceBuilder$1
  implements ECommerceServiceAdapter
{
  ECommerceServiceBuilder$1(ECommerceServiceBuilder paramECommerceServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public int getClientType()
  {
    return ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo.initialClientType;
  }
  
  public DataReportInterface getDataReport()
  {
    return (DataReportInterface)this.val$serviceManager.getService(DataReportInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public String getProgramId()
  {
    return ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().roomInfo.programId;
  }
  
  public long getRoomId()
  {
    return ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().roomInfo.roomId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.ecommerce.ECommerceServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */