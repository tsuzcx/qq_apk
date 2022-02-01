package com.tencent.component.network.downloader.handler;

import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;

public abstract interface ReportHandler
{
  public abstract void handleReport(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport);
  
  public abstract ReportHandler.DownloadReportObject obtainReportObj(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport);
  
  public abstract void uploadReport(ReportHandler.DownloadReportObject paramDownloadReportObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.handler.ReportHandler
 * JD-Core Version:    0.7.0.1
 */