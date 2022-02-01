package com.tencent.livesdk.servicefactory.builder.cover;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.coverservice.CoverService;
import com.tencent.ilivesdk.coverservice_interface.CoverServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class CoverServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    CoverService localCoverService = new CoverService();
    localCoverService.init(new CoverServiceBuilder.1(this, paramServiceAccessor));
    return localCoverService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.cover.CoverServiceBuilder
 * JD-Core Version:    0.7.0.1
 */