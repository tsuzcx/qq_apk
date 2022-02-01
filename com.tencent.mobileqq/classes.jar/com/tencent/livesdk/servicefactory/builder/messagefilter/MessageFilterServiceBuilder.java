package com.tencent.livesdk.servicefactory.builder.messagefilter;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.messagefilterservice.MessageFilterService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class MessageFilterServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    MessageFilterService localMessageFilterService = new MessageFilterService();
    localMessageFilterService.init(new MessageFilterServiceBuilder.1(this, paramServiceAccessor));
    return localMessageFilterService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.messagefilter.MessageFilterServiceBuilder
 * JD-Core Version:    0.7.0.1
 */