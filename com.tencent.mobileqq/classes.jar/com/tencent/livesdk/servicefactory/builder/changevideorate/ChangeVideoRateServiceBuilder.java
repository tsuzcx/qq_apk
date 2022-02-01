package com.tencent.livesdk.servicefactory.builder.changevideorate;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.changevideorateservice.ChangeVideoRateService;
import com.tencent.ilivesdk.changevideorateservice_interface.ChangeVideoRateServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class ChangeVideoRateServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    ChangeVideoRateService localChangeVideoRateService = new ChangeVideoRateService();
    localChangeVideoRateService.setAdapter(new ChangeVideoRateServiceBuilder.1(this, paramServiceAccessor));
    return localChangeVideoRateService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.changevideorate.ChangeVideoRateServiceBuilder
 * JD-Core Version:    0.7.0.1
 */