package com.tencent.mobileqq.bridge;

import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.mobileqq.bridge.report.service.IReportService;
import com.tencent.mobileqq.bridge.report.service.ITouchEventService;
import com.tencent.mobileqq.bridge.statistics.service.ICrashReportService;
import com.tencent.mobileqq.bridge.statistics.service.ILocalMultiProcConfigService;
import com.tencent.mobileqq.bridge.statistics.service.IStatisticsCollectorService;
import com.tencent.mobileqq.data.entitymanager.Provider;

public class ReportControllerServiceHolder
{
  private static Provider<IReportDataProviderService> a;
  private static Provider<ITouchEventService> b;
  private static Provider<IReportService> c;
  private static Provider<ILocalMultiProcConfigService> d;
  private static Provider<IStatisticsCollectorService> e;
  private static Provider<ICrashReportService> f;
  
  public static IReportDataProviderService a()
  {
    if (a != null) {
      return (IReportDataProviderService)a.get();
    }
    return null;
  }
  
  public static IReportService a()
  {
    if (c != null) {
      return (IReportService)c.get();
    }
    return null;
  }
  
  public static ITouchEventService a()
  {
    if (b != null) {
      return (ITouchEventService)b.get();
    }
    return null;
  }
  
  public static ICrashReportService a()
  {
    if (f != null) {
      return (ICrashReportService)f.get();
    }
    return null;
  }
  
  public static ILocalMultiProcConfigService a()
  {
    if (d != null) {
      return (ILocalMultiProcConfigService)d.get();
    }
    return null;
  }
  
  public static IStatisticsCollectorService a()
  {
    if (e != null) {
      return (IStatisticsCollectorService)e.get();
    }
    return null;
  }
  
  public static void a(Provider<IReportDataProviderService> paramProvider)
  {
    a = paramProvider;
  }
  
  public static void b(Provider<ITouchEventService> paramProvider)
  {
    b = paramProvider;
  }
  
  public static void c(Provider<IReportService> paramProvider)
  {
    c = paramProvider;
  }
  
  public static void d(Provider<ILocalMultiProcConfigService> paramProvider)
  {
    d = paramProvider;
  }
  
  public static void e(Provider<IStatisticsCollectorService> paramProvider)
  {
    e = paramProvider;
  }
  
  public static void f(Provider<ICrashReportService> paramProvider)
  {
    f = paramProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bridge.ReportControllerServiceHolder
 * JD-Core Version:    0.7.0.1
 */