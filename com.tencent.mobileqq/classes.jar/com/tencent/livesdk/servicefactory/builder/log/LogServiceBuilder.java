package com.tencent.livesdk.servicefactory.builder.log;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.log.LogComponent;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LogServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    LogComponent localLogComponent = new LogComponent();
    localLogComponent.init(new LogServiceBuilder.1(this, paramServiceAccessor));
    return localLogComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.log.LogServiceBuilder
 * JD-Core Version:    0.7.0.1
 */