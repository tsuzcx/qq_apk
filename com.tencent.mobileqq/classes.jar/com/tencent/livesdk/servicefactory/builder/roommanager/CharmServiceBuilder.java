package com.tencent.livesdk.servicefactory.builder.roommanager;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.charmservice.impl.CharmService;
import com.tencent.ilivesdk.charmservice_interface.CharmServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class CharmServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    CharmService localCharmService = new CharmService();
    localCharmService.init(new CharmServiceBuilder.1(this, paramServiceAccessor));
    return localCharmService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.roommanager.CharmServiceBuilder
 * JD-Core Version:    0.7.0.1
 */