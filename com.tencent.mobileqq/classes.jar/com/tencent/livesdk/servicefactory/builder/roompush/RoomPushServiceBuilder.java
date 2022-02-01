package com.tencent.livesdk.servicefactory.builder.roompush;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roompushservice.RoomPushService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class RoomPushServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new RoomPushService(new RoomPushServiceBuilder.1(this, paramServiceAccessor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.roompush.RoomPushServiceBuilder
 * JD-Core Version:    0.7.0.1
 */