package com.tencent.livesdk.servicefactory.builder.csc;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.cscservice.CscServiceImpl;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class CscServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    CscServiceImpl localCscServiceImpl = new CscServiceImpl();
    localCscServiceImpl.init(new CscServiceBuilder.1(this, paramServiceAccessor));
    return localCscServiceImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.csc.CscServiceBuilder
 * JD-Core Version:    0.7.0.1
 */