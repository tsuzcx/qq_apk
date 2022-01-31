package com.tencent.component.network.module.report;

import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.base.QDLog;
import java.util.ArrayList;
import java.util.Random;

final class BusinessReport$1
  extends ArrayList
{
  private final boolean a(ReportObj paramReportObj)
  {
    return paramReportObj.retCode != 0;
  }
  
  public boolean add(ReportObj paramReportObj)
  {
    if (a(paramReportObj))
    {
      QDLog.c("BusinessReport", "download a img fail. need report retCode=" + paramReportObj.retCode);
      return super.add(paramReportObj);
    }
    if ((paramReportObj != null) && ((paramReportObj instanceof ReportHandler.DownloadReportObject)) && (((ReportHandler.DownloadReportObject)paramReportObj).needForceReport())) {
      return super.add(paramReportObj);
    }
    int i = BusinessReport.a();
    if (i <= 0) {
      return false;
    }
    if (BusinessReport.a().nextInt(Math.round(100 / i)) == 0) {
      return super.add(paramReportObj);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.report.BusinessReport.1
 * JD-Core Version:    0.7.0.1
 */