package com.tencent.livesdk.servicefactory.builder.roomaudience;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roomaudienceservice.RoomAudienceService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class RoomAudienceServiceBuilder
  implements BaseServiceBuilder
{
  private static final String TAG = "RoomAudienceServiceBuilder";
  
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    RoomAudienceService localRoomAudienceService = new RoomAudienceService();
    localRoomAudienceService.init(new RoomAudienceServiceBuilder.1(this, paramServiceAccessor));
    return localRoomAudienceService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.roomaudience.RoomAudienceServiceBuilder
 * JD-Core Version:    0.7.0.1
 */