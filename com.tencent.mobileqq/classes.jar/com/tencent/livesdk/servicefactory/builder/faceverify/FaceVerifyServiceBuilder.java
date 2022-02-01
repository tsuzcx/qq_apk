package com.tencent.livesdk.servicefactory.builder.faceverify;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.faceverifyservice.FaceVerifyService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class FaceVerifyServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    FaceVerifyService localFaceVerifyService = new FaceVerifyService();
    localFaceVerifyService.setAdapter(new FaceVerifyServiceBuilder.1(this, paramServiceAccessor));
    return localFaceVerifyService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.faceverify.FaceVerifyServiceBuilder
 * JD-Core Version:    0.7.0.1
 */