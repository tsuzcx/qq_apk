package com.tencent.livesdk.servicefactory.builder.recordscreen;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.recordservice.RecordScreenService;
import com.tencent.ilivesdk.recordservice_interface.RecordServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class RecordScreenServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    RecordScreenService localRecordScreenService = new RecordScreenService();
    localRecordScreenService.init(new RecordScreenServiceBuilder.1(this, paramServiceAccessor));
    return localRecordScreenService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.recordscreen.RecordScreenServiceBuilder
 * JD-Core Version:    0.7.0.1
 */