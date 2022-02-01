package com.tencent.livesdk.servicefactory.builder.anchorrate;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.anchorchangevideorateservice.AnchorChangeVideoRateService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class AnchorRateChangeServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    AnchorChangeVideoRateService localAnchorChangeVideoRateService = new AnchorChangeVideoRateService();
    localAnchorChangeVideoRateService.setAdapter(new AnchorRateChangeServiceBuilder.1(this, paramServiceAccessor));
    return localAnchorChangeVideoRateService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.anchorrate.AnchorRateChangeServiceBuilder
 * JD-Core Version:    0.7.0.1
 */