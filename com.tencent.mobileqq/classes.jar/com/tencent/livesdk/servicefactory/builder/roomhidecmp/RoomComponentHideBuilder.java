package com.tencent.livesdk.servicefactory.builder.roomhidecmp;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roomcomponenthiderservice.RoomComponentHiderService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class RoomComponentHideBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    RoomComponentHiderService localRoomComponentHiderService = new RoomComponentHiderService();
    localRoomComponentHiderService.setAdapter(new RoomComponentHideBuilder.1(this, paramServiceAccessor));
    return localRoomComponentHiderService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.roomhidecmp.RoomComponentHideBuilder
 * JD-Core Version:    0.7.0.1
 */