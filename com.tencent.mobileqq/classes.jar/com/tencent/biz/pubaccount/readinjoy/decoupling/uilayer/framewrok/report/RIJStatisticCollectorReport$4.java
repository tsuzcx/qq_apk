package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public final class RIJStatisticCollectorReport$4
  implements Runnable
{
  public RIJStatisticCollectorReport$4(JSONObject paramJSONObject, AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.jdField_a_of_type_OrgJsonJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localHashMap.put(str, this.jdField_a_of_type_OrgJsonJSONObject.optString(str));
      }
      StatisticCollector.getInstance(this.jdField_a_of_type_MqqAppAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaPageDataNew", this.jdField_a_of_type_Boolean, -1L, -1L, localException, null, true);
    }
    catch (Exception localException)
    {
      QLog.e("RIJStatisticCollectorReport", 2, "reportViolaPageProcessNew , error : " + localException.getMessage());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport.4
 * JD-Core Version:    0.7.0.1
 */