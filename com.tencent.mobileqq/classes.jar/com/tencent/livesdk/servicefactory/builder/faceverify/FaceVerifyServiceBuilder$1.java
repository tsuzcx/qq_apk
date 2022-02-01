package com.tencent.livesdk.servicefactory.builder.faceverify;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.faceverifyservice_interface.FaceVerifyServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class FaceVerifyServiceBuilder$1
  implements FaceVerifyServiceAdapter
{
  FaceVerifyServiceBuilder$1(FaceVerifyServiceBuilder paramFaceVerifyServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.faceverify.FaceVerifyServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */