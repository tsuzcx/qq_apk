package com.tencent.livesdk.servicefactory.builder.http;

import com.tencent.falco.base.http.HttpComponent;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class HttpServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    HttpComponent localHttpComponent = new HttpComponent();
    localHttpComponent.init(new HttpServiceBuilder.1(this, paramServiceAccessor));
    return localHttpComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.http.HttpServiceBuilder
 * JD-Core Version:    0.7.0.1
 */