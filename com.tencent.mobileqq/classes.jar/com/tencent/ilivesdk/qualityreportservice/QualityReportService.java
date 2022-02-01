package com.tencent.ilivesdk.qualityreportservice;

import android.content.Context;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.HostQualityServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceAdapter;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.VideoRateQualityInterface;

public class QualityReportService
  implements QualityReportServiceInterface
{
  AudQualityService audQualityService;
  QualityReportServiceAdapter mAdapter;
  VideoRateQualityService videoRateQualityService;
  
  public void clearEventOutput() {}
  
  public AudQualityServiceInterface getAudQualityReporter()
  {
    return this.audQualityService;
  }
  
  public HostQualityServiceInterface getHostQualityReporter()
  {
    return null;
  }
  
  public VideoRateQualityInterface getVideoRateQualityReporter()
  {
    return this.videoRateQualityService;
  }
  
  public void init(QualityReportServiceAdapter paramQualityReportServiceAdapter)
  {
    this.mAdapter = paramQualityReportServiceAdapter;
  }
  
  public void onCreate(Context paramContext)
  {
    this.audQualityService = new AudQualityService(this.mAdapter.getDataReporter());
    this.videoRateQualityService = new VideoRateQualityService(this.mAdapter);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.qualityreportservice.QualityReportService
 * JD-Core Version:    0.7.0.1
 */