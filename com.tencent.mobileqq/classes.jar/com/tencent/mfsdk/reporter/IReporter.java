package com.tencent.mfsdk.reporter;

import com.tencent.mfsdk.collector.ResultObject;

public abstract interface IReporter
{
  public abstract boolean a(ResultObject paramResultObject, IReporter.ReportResultCallback paramReportResultCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.IReporter
 * JD-Core Version:    0.7.0.1
 */