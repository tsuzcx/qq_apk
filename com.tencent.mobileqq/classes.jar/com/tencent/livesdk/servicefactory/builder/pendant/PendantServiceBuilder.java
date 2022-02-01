package com.tencent.livesdk.servicefactory.builder.pendant;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.pendantservice.PendantService;
import com.tencent.ilivesdk.pendantservice_interface.PendantServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class PendantServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    PendantService localPendantService = new PendantService();
    localPendantService.init(new PendantServiceBuilder.1(this, paramServiceAccessor));
    return localPendantService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.pendant.PendantServiceBuilder
 * JD-Core Version:    0.7.0.1
 */