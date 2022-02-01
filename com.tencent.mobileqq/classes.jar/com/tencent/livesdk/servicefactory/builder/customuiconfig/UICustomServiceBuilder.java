package com.tencent.livesdk.servicefactory.builder.customuiconfig;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.uicustomservice.UICustomService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class UICustomServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new UICustomService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.customuiconfig.UICustomServiceBuilder
 * JD-Core Version:    0.7.0.1
 */