package com.tencent.livesdk.servicefactory.builder.qqsdk;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.qqsdk.QQSdkImpl;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class QQSdkBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new QQSdkImpl(new QQSdkBuilder.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.qqsdk.QQSdkBuilder
 * JD-Core Version:    0.7.0.1
 */