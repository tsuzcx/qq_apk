package com.tencent.mobileqq.activity.aio;

import java.util.Comparator;

class NewAIOTimeReporter$1
  implements Comparator<NewAIOTimeReporter.HelperReportData>
{
  NewAIOTimeReporter$1(NewAIOTimeReporter paramNewAIOTimeReporter) {}
  
  public int a(NewAIOTimeReporter.HelperReportData paramHelperReportData1, NewAIOTimeReporter.HelperReportData paramHelperReportData2)
  {
    if (NewAIOTimeReporter.HelperReportData.a(paramHelperReportData2) > NewAIOTimeReporter.HelperReportData.a(paramHelperReportData1)) {
      return 1;
    }
    if (NewAIOTimeReporter.HelperReportData.a(paramHelperReportData2) < NewAIOTimeReporter.HelperReportData.a(paramHelperReportData1)) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.NewAIOTimeReporter.1
 * JD-Core Version:    0.7.0.1
 */