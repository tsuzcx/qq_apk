package com.tencent.livesdk.servicefactory.builder.datareport;

import com.tencent.falco.base.datareport.DataReportService;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class DataReportServiceBuilder
  implements BaseServiceBuilder
{
  HostProxyInterface mHostProxyInterface;
  
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    DataReportService localDataReportService = new DataReportService();
    this.mHostProxyInterface = ((HostProxyInterface)paramServiceAccessor.getService(HostProxyInterface.class));
    localDataReportService.init(new DataReportServiceBuilder.1(this, paramServiceAccessor));
    return localDataReportService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.datareport.DataReportServiceBuilder
 * JD-Core Version:    0.7.0.1
 */