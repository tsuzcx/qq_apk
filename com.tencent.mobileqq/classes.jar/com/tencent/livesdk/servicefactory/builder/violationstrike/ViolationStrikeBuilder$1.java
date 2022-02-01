package com.tencent.livesdk.servicefactory.builder.violationstrike;

import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.violationstrikeservice_interface.ViolationStrikeServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class ViolationStrikeBuilder$1
  implements ViolationStrikeServiceAdapter
{
  ViolationStrikeBuilder$1(ViolationStrikeBuilder paramViolationStrikeBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.violationstrike.ViolationStrikeBuilder.1
 * JD-Core Version:    0.7.0.1
 */