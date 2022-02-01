package com.tencent.livesdk.servicefactory.builder.anchorfinish;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.anchorfinishpageservice.AnchorFinishPageService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class AnchorFinishPageServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    AnchorFinishPageService localAnchorFinishPageService = new AnchorFinishPageService();
    localAnchorFinishPageService.setAdapter(new AnchorFinishPageServiceBuilder.1(this, paramServiceAccessor));
    return localAnchorFinishPageService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.anchorfinish.AnchorFinishPageServiceBuilder
 * JD-Core Version:    0.7.0.1
 */