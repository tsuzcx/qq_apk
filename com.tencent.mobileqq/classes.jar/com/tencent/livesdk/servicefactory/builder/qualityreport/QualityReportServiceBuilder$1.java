package com.tencent.livesdk.servicefactory.builder.qualityreport;

import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class QualityReportServiceBuilder$1
  implements QualityReportServiceAdapter
{
  QualityReportServiceBuilder$1(QualityReportServiceBuilder paramQualityReportServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.val$serviceManager.getService(DataReportInterface.class);
  }
  
  public HttpInterface getHttpInterface()
  {
    return (HttpInterface)this.val$serviceManager.getService(HttpInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.qualityreport.QualityReportServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */