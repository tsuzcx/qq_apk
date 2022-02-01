package com.tencent.livesdk.servicefactory.builder.wns;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.wns.WnsSdkImpl;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class WnsBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new WnsSdkImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.wns.WnsBuilder
 * JD-Core Version:    0.7.0.1
 */