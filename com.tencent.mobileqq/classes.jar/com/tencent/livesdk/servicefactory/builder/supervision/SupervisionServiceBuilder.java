package com.tencent.livesdk.servicefactory.builder.supervision;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.supervisionservice.SupervisionService;
import com.tencent.ilivesdk.supervisionservice_interface.SupervisionServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class SupervisionServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    SupervisionService localSupervisionService = new SupervisionService();
    localSupervisionService.init(new SupervisionServiceBuilder.1(this, paramServiceAccessor));
    return localSupervisionService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.supervision.SupervisionServiceBuilder
 * JD-Core Version:    0.7.0.1
 */