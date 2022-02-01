package com.tencent.livesdk.servicefactory.builder.avplayer;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.avpreloadservice.AVPreloadService;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class AVPreloadServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    AVPreloadService localAVPreloadService = new AVPreloadService();
    localAVPreloadService.a(new AVPreloadServiceBuilder.1(this, paramServiceAccessor));
    return localAVPreloadService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avplayer.AVPreloadServiceBuilder
 * JD-Core Version:    0.7.0.1
 */