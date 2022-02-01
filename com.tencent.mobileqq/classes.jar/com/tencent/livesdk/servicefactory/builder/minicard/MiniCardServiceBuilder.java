package com.tencent.livesdk.servicefactory.builder.minicard;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.minicardservice.impl.MiniCardService;
import com.tencent.ilivesdk.minicardservice_interface.MiniCardServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class MiniCardServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    MiniCardService localMiniCardService = new MiniCardService();
    localMiniCardService.init(new MiniCardServiceBuilder.1(this, paramServiceAccessor));
    return localMiniCardService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.minicard.MiniCardServiceBuilder
 * JD-Core Version:    0.7.0.1
 */