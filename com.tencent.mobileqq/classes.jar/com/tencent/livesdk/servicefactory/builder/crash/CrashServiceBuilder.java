package com.tencent.livesdk.servicefactory.builder.crash;

import com.tencent.falco.base.crash.CrashComponent;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class CrashServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    CrashComponent localCrashComponent = new CrashComponent();
    localCrashComponent.init(new CrashServiceBuilder.1(this, paramServiceAccessor));
    return localCrashComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.crash.CrashServiceBuilder
 * JD-Core Version:    0.7.0.1
 */