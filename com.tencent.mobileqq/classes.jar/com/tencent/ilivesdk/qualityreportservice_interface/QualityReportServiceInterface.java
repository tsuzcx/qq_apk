package com.tencent.ilivesdk.qualityreportservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface QualityReportServiceInterface
  extends ServiceBaseInterface
{
  public abstract AudQualityServiceInterface getAudQualityReporter();
  
  public abstract HostQualityServiceInterface getHostQualityReporter();
  
  public abstract VideoRateQualityInterface getVideoRateQualityReporter();
  
  public abstract void init(QualityReportServiceAdapter paramQualityReportServiceAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface
 * JD-Core Version:    0.7.0.1
 */