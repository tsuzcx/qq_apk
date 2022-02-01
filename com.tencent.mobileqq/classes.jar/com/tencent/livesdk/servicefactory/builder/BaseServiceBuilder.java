package com.tencent.livesdk.servicefactory.builder;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

public abstract interface BaseServiceBuilder
{
  public abstract ServiceBaseInterface build(ServiceAccessor paramServiceAccessor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder
 * JD-Core Version:    0.7.0.1
 */