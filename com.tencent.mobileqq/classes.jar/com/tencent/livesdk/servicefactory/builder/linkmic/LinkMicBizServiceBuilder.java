package com.tencent.livesdk.servicefactory.builder.linkmic;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.linkmicbizservice.LinkMicBizService;
import com.tencent.ilivesdk.linkmicbizserviceinterface.LinkMicBizServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LinkMicBizServiceBuilder
  implements BaseServiceBuilder
{
  private static final String TAG = "LinkMicAvServiceBuilder";
  
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    LinkMicBizService localLinkMicBizService = new LinkMicBizService();
    localLinkMicBizService.a(new LinkMicBizServiceBuilder.1(this, paramServiceAccessor));
    return localLinkMicBizService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.linkmic.LinkMicBizServiceBuilder
 * JD-Core Version:    0.7.0.1
 */