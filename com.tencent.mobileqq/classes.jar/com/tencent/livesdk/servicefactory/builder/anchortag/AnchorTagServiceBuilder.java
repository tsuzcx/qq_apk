package com.tencent.livesdk.servicefactory.builder.anchortag;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.anchortagservice.AnchorTagService;
import com.tencent.ilivesdk.anchortagserviceinterface.AnchorTagServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class AnchorTagServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    AnchorTagService localAnchorTagService = new AnchorTagService();
    localAnchorTagService.a(new AnchorTagServiceBuilder.1(this, paramServiceAccessor));
    return localAnchorTagService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.anchortag.AnchorTagServiceBuilder
 * JD-Core Version:    0.7.0.1
 */