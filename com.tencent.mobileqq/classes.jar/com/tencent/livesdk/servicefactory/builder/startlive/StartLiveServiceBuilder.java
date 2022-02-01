package com.tencent.livesdk.servicefactory.builder.startlive;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.startliveservice.StartLiveService;
import com.tencent.ilivesdk.startliveservice_interface.StartLiveServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class StartLiveServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    StartLiveService localStartLiveService = new StartLiveService();
    localStartLiveService.init(new StartLiveServiceBuilder.1(this, paramServiceAccessor));
    return localStartLiveService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.startlive.StartLiveServiceBuilder
 * JD-Core Version:    0.7.0.1
 */