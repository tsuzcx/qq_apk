package com.tencent.livesdk.servicefactory.builder.web;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.webcommonservice.WebCommonService;
import com.tencent.ilivesdk.webcommonserviceinterface.WebCommonServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class WebCommonUseBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    WebCommonService localWebCommonService = new WebCommonService();
    localWebCommonService.a(new WebCommonUseBuilder.1(this, paramServiceAccessor));
    return localWebCommonService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.web.WebCommonUseBuilder
 * JD-Core Version:    0.7.0.1
 */