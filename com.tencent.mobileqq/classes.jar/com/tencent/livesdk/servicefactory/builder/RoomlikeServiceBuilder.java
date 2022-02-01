package com.tencent.livesdk.servicefactory.builder;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roomlikeservice.RoomlikeService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

public class RoomlikeServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    RoomlikeService localRoomlikeService = new RoomlikeService();
    localRoomlikeService.init(new RoomlikeServiceBuilder.1(this, paramServiceAccessor));
    return localRoomlikeService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.RoomlikeServiceBuilder
 * JD-Core Version:    0.7.0.1
 */