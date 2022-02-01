package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class NewAIOTimeReporter
{
  private static String a = "helper_id";
  private static String b = "helper_state";
  private static String c = "helper_cost";
  private static String d = "helper_tag";
  private static String e = "AIOCostBusiness";
  private static volatile NewAIOTimeReporter f;
  private static int g = 5;
  private PriorityQueue<NewAIOTimeReporter.HelperReportData> h = new PriorityQueue(g, new NewAIOTimeReporter.1(this));
  
  public static NewAIOTimeReporter b()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new NewAIOTimeReporter();
        }
      }
      finally {}
    }
    return f;
  }
  
  private boolean d()
  {
    if (new Random().nextInt(100) != 1) {
      return false;
    }
    if (StartupTracker.b <= 0L) {
      return false;
    }
    return StartupTracker.b >= 1000L;
  }
  
  private void e()
  {
    this.h.clear();
  }
  
  public PriorityQueue<NewAIOTimeReporter.HelperReportData> a()
  {
    return this.h;
  }
  
  public void c()
  {
    if (!d())
    {
      e();
      return;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      NewAIOTimeReporter.HelperReportData localHelperReportData = (NewAIOTimeReporter.HelperReportData)localIterator.next();
      if (localHelperReportData != null)
      {
        localHashMap.put(a, String.valueOf(NewAIOTimeReporter.HelperReportData.b(localHelperReportData)));
        localHashMap.put(b, String.valueOf(NewAIOTimeReporter.HelperReportData.c(localHelperReportData)));
        localHashMap.put(c, String.valueOf(NewAIOTimeReporter.HelperReportData.a(localHelperReportData)));
        localHashMap.put(d, String.valueOf(NewAIOTimeReporter.HelperReportData.d(localHelperReportData)));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", e, true, StartupTracker.b, 0L, localHashMap, "");
      }
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.NewAIOTimeReporter
 * JD-Core Version:    0.7.0.1
 */