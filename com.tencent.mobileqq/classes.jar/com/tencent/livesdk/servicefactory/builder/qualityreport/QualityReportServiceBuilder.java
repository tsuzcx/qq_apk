package com.tencent.livesdk.servicefactory.builder.qualityreport;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.qualityreportservice.QualityReportService;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class QualityReportServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    QualityReportService localQualityReportService = new QualityReportService();
    localQualityReportService.init(new QualityReportServiceBuilder.1(this, paramServiceAccessor));
    return localQualityReportService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.qualityreport.QualityReportServiceBuilder
 * JD-Core Version:    0.7.0.1
 */