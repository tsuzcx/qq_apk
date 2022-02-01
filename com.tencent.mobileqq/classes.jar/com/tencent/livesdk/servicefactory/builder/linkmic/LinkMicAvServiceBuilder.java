package com.tencent.livesdk.servicefactory.builder.linkmic;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.linkmicavservice.LinkMicAvService;
import com.tencent.ilivesdk.linkmicavservice_interface.LinkMicAvServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LinkMicAvServiceBuilder
  implements BaseServiceBuilder
{
  private static final String TAG = "LinkMicAvServiceBuilder";
  
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    paramServiceAccessor = new LinkMicAvService();
    paramServiceAccessor.init(new LinkMicAvServiceBuilder.1(this));
    return paramServiceAccessor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.linkmic.LinkMicAvServiceBuilder
 * JD-Core Version:    0.7.0.1
 */