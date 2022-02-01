package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import android.content.Context;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

final class RIJStatisticCollectorReport$3
  implements Runnable
{
  RIJStatisticCollectorReport$3(Context paramContext, String paramString, HashMap paramHashMap) {}
  
  public void run()
  {
    StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(this.jdField_a_of_type_JavaLangString, "actKandianVideoH265GetURL", true, -1L, 0L, this.jdField_a_of_type_JavaUtilHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport.3
 * JD-Core Version:    0.7.0.1
 */