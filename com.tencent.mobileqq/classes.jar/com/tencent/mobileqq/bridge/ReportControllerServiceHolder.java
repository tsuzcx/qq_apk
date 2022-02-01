package com.tencent.mobileqq.bridge;

import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.mobileqq.bridge.report.service.IReportService;
import com.tencent.mobileqq.bridge.report.service.ITouchEventService;
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
  
  public static IReportDataProviderService a()
  {
    Provider localProvider = a;
    if (localProvider != null) {
      return (IReportDataProviderService)localProvider.get();
    }
    return null;
  }
  
  public static void a(Provider<IReportDataProviderService> paramProvider)
  {
    a = paramProvider;
  }
  
  public static ITouchEventService b()
  {
    Provider localProvider = b;
    if (localProvider != null) {
      return (ITouchEventService)localProvider.get();
    }
    return null;
  }
  
  public static void b(Provider<ITouchEventService> paramProvider)
  {
    b = paramProvider;
  }
  
  public static IReportService c()
  {
    Provider localProvider = c;
    if (localProvider != null) {
      return (IReportService)localProvider.get();
    }
    return null;
  }
  
  public static void c(Provider<IReportService> paramProvider)
  {
    c = paramProvider;
  }
  
  public static ILocalMultiProcConfigService d()
  {
    Provider localProvider = d;
    if (localProvider != null) {
      return (ILocalMultiProcConfigService)localProvider.get();
    }
    return null;
  }
  
  public static void d(Provider<ILocalMultiProcConfigService> paramProvider)
  {
    d = paramProvider;
  }
  
  public static IStatisticsCollectorService e()
  {
    Provider localProvider = e;
    if (localProvider != null) {
      return (IStatisticsCollectorService)localProvider.get();
    }
    return null;
  }
  
  public static void e(Provider<IStatisticsCollectorService> paramProvider)
  {
    e = paramProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bridge.ReportControllerServiceHolder
 * JD-Core Version:    0.7.0.1
 */