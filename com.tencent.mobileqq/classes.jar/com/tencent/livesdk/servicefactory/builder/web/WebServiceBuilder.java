package com.tencent.livesdk.servicefactory.builder.web;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.webcomponent.WebComponentManager;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class WebServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    WebComponentManager localWebComponentManager = WebComponentManager.getInstance();
    localWebComponentManager.init(new WebServiceBuilder.BaseWebComponentAdapter(paramServiceAccessor));
    return localWebComponentManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.web.WebServiceBuilder
 * JD-Core Version:    0.7.0.1
 */