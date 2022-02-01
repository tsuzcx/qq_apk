package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

final class RIJStatisticCollectorReport$1
  implements Runnable
{
  RIJStatisticCollectorReport$1(HashMap paramHashMap, boolean paramBoolean, Context paramContext, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((StringBuilder)localObject).append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(" ");
      }
      QLog.d("Q.readinjoy.video", 2, "reportKandianVideoInfo, success =" + this.jdField_a_of_type_Boolean + ", data=" + ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap(this.jdField_a_of_type_JavaUtilHashMap);
    StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(this.jdField_a_of_type_JavaLangString, "actKandianVideoWithExtraInfo", this.jdField_a_of_type_Boolean, -1L, 0L, (HashMap)localObject, null);
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_speedList");
      StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(this.jdField_a_of_type_JavaLangString, "actKandianVideo", this.jdField_a_of_type_Boolean, -1L, 0L, this.jdField_a_of_type_JavaUtilHashMap, null);
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          localObject = new JSONObject(this.jdField_a_of_type_JavaUtilHashMap);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80096D9", "0X80096D9", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
          return;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("RIJStatisticCollectorReport", 2, localThrowable2.getMessage());
        }
        localThrowable1 = localThrowable1;
        QLog.e("RIJStatisticCollectorReport", 2, localThrowable1.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport.1
 * JD-Core Version:    0.7.0.1
 */