package com.tencent.livesdk.servicefactory.builder.livestartcustomerconfig;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.livestartcustomerconfigservice.LiveStartCusConfService;
import com.tencent.ilivesdk.livestartcustomerconfigservice_interface.LiveStartCusConfServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LiveStartCusConfServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    LiveStartCusConfService localLiveStartCusConfService = new LiveStartCusConfService();
    localLiveStartCusConfService.init(new LiveStartCusConfServiceBuilder.1(this, paramServiceAccessor));
    return localLiveStartCusConfService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.livestartcustomerconfig.LiveStartCusConfServiceBuilder
 * JD-Core Version:    0.7.0.1
 */