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
  private static int jdField_a_of_type_Int = 5;
  private static volatile NewAIOTimeReporter jdField_a_of_type_ComTencentMobileqqActivityAioNewAIOTimeReporter;
  private static String jdField_a_of_type_JavaLangString = "helper_id";
  private static String b = "helper_state";
  private static String c = "helper_cost";
  private static String d = "helper_tag";
  private static String e = "AIOCostBusiness";
  private PriorityQueue<NewAIOTimeReporter.HelperReportData> jdField_a_of_type_JavaUtilPriorityQueue = new PriorityQueue(jdField_a_of_type_Int, new NewAIOTimeReporter.1(this));
  
  public static NewAIOTimeReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioNewAIOTimeReporter == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityAioNewAIOTimeReporter == null) {
          jdField_a_of_type_ComTencentMobileqqActivityAioNewAIOTimeReporter = new NewAIOTimeReporter();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioNewAIOTimeReporter;
  }
  
  private boolean a()
  {
    if (new Random().nextInt(100) != 1) {
      return false;
    }
    if (StartupTracker.a <= 0L) {
      return false;
    }
    return StartupTracker.a >= 1000L;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilPriorityQueue.clear();
  }
  
  public PriorityQueue<NewAIOTimeReporter.HelperReportData> a()
  {
    return this.jdField_a_of_type_JavaUtilPriorityQueue;
  }
  
  public void a()
  {
    if (!a())
    {
      b();
      return;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilPriorityQueue.iterator();
    while (localIterator.hasNext())
    {
      NewAIOTimeReporter.HelperReportData localHelperReportData = (NewAIOTimeReporter.HelperReportData)localIterator.next();
      if (localHelperReportData != null)
      {
        localHashMap.put(jdField_a_of_type_JavaLangString, String.valueOf(NewAIOTimeReporter.HelperReportData.a(localHelperReportData)));
        localHashMap.put(b, String.valueOf(NewAIOTimeReporter.HelperReportData.b(localHelperReportData)));
        localHashMap.put(c, String.valueOf(NewAIOTimeReporter.HelperReportData.a(localHelperReportData)));
        localHashMap.put(d, String.valueOf(NewAIOTimeReporter.HelperReportData.a(localHelperReportData)));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", e, true, StartupTracker.a, 0L, localHashMap, "");
      }
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.NewAIOTimeReporter
 * JD-Core Version:    0.7.0.1
 */