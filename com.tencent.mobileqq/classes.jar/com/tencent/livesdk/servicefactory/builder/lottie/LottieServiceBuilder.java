package com.tencent.livesdk.servicefactory.builder.lottie;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilive.lottieservice.LottieServiceImpl;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LottieServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new LottieServiceImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.lottie.LottieServiceBuilder
 * JD-Core Version:    0.7.0.1
 */