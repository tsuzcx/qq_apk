package com.tencent.livesdk.servicefactory.builder.avmedia;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.avmediaservice.AVMediaService;
import com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class AVMediaServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    AVMediaService localAVMediaService = new AVMediaService();
    localAVMediaService.init(new AVMediaServiceBuilder.1(this, paramServiceAccessor));
    return localAVMediaService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avmedia.AVMediaServiceBuilder
 * JD-Core Version:    0.7.0.1
 */