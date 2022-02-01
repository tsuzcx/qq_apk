package com.tencent.livesdk.servicefactory.builder.appinfo;

import com.tencent.falco.base.appinfo.AppGeneralInfoServiceImpl;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class AppInfoBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new AppGeneralInfoServiceImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.appinfo.AppInfoBuilder
 * JD-Core Version:    0.7.0.1
 */