package com.tencent.mobileqq.bridge.statistics.service;

import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.statistics.StatisticCollector;

public abstract interface ICrashReportService
{
  public abstract CrashHandleListener a(StatisticCollector paramStatisticCollector);
  
  public abstract void a(String paramString, StatisticCollector paramStatisticCollector);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bridge.statistics.service.ICrashReportService
 * JD-Core Version:    0.7.0.1
 */