package com.tencent.livesdk.servicefactory.builder.floatwindowconfig;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.floatwindowconfigservice.FloatWindowConfigService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class FloatWindowConfigServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new FloatWindowConfigService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.floatwindowconfig.FloatWindowConfigServiceBuilder
 * JD-Core Version:    0.7.0.1
 */