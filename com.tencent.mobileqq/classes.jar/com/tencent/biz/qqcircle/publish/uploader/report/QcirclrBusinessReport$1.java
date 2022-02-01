package com.tencent.biz.qqcircle.publish.uploader.report;

import java.util.ArrayList;
import java.util.Random;

final class QcirclrBusinessReport$1
  extends ArrayList<ReportObj>
{
  private final boolean a(ReportObj paramReportObj)
  {
    return (paramReportObj.m != 0) && (paramReportObj.m != -2);
  }
  
  public boolean add(ReportObj paramReportObj)
  {
    if (a(paramReportObj)) {
      return super.add(paramReportObj);
    }
    if ((QcirclrBusinessReport.b().nextInt(Math.round(20.0F)) != 0) && (!QcirclrBusinessReport.c())) {
      return false;
    }
    return super.add(paramReportObj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.report.QcirclrBusinessReport.1
 * JD-Core Version:    0.7.0.1
 */