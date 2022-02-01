package com.tencent.livesdk.servicefactory.builder.liveconfig;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.liveconfigservice.LiveConfigService;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LiveConfigServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    LiveConfigService localLiveConfigService = new LiveConfigService();
    localLiveConfigService.init(new LiveConfigServiceBuilder.1(this, paramServiceAccessor));
    return localLiveConfigService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.liveconfig.LiveConfigServiceBuilder
 * JD-Core Version:    0.7.0.1
 */