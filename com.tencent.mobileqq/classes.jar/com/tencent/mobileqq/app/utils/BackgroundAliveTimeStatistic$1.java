package com.tencent.mobileqq.app.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class BackgroundAliveTimeStatistic$1
  implements Runnable
{
  BackgroundAliveTimeStatistic$1(long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("pss", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("downloadLaunched", String.valueOf(this.b));
    QLog.d("BackgroundAliveTimeStatistic", 1, "last time = " + this.jdField_a_of_type_Long + ",last pss = " + this.jdField_a_of_type_Int + ",downloadLaunched = " + this.b);
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "qq_bg_alive_time", true, this.jdField_a_of_type_Long, 1L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.BackgroundAliveTimeStatistic.1
 * JD-Core Version:    0.7.0.1
 */