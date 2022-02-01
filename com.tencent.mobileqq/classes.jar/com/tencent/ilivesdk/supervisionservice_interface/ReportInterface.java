package com.tencent.ilivesdk.supervisionservice_interface;

import java.util.List;

public abstract interface ReportInterface
{
  public abstract List<String> getReportReason(ReportInterface.ReportType paramReportType);
  
  public abstract void report(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString, ReportInterface.ReportCallback paramReportCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.ReportInterface
 * JD-Core Version:    0.7.0.1
 */