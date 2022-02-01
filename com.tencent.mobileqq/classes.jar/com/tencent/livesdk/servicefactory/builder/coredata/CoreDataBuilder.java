package com.tencent.livesdk.servicefactory.builder.coredata;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.coredataservice.CoreDataService;
import com.tencent.ilivesdk.coredataserviceinterface.CoreDataServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class CoreDataBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    CoreDataService localCoreDataService = new CoreDataService();
    localCoreDataService.a(new CoreDataBuilder.1(this, paramServiceAccessor));
    return localCoreDataService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.coredata.CoreDataBuilder
 * JD-Core Version:    0.7.0.1
 */