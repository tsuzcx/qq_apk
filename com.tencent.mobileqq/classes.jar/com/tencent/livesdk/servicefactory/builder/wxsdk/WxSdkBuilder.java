package com.tencent.livesdk.servicefactory.builder.wxsdk;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.wxsdk.WxSdkImpl;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class WxSdkBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new WxSdkImpl(new WxSdkBuilder.1(this, paramServiceAccessor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.wxsdk.WxSdkBuilder
 * JD-Core Version:    0.7.0.1
 */