package com.tencent.livesdk.servicefactory.builder.room;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roomservice.RoomService;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class RoomServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    RoomService localRoomService = new RoomService();
    localRoomService.init(new RoomServiceBuilder.1(this, paramServiceAccessor));
    return localRoomService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.room.RoomServiceBuilder
 * JD-Core Version:    0.7.0.1
 */