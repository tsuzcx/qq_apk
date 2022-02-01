package com.tencent.livesdk.servicefactory.builder.liveover;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.liveoverservice.LiveOverService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LiveOverServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    LiveOverService localLiveOverService = new LiveOverService();
    localLiveOverService.init(new LiveOverServiceBuilder.1(this, paramServiceAccessor));
    return localLiveOverService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.liveover.LiveOverServiceBuilder
 * JD-Core Version:    0.7.0.1
 */