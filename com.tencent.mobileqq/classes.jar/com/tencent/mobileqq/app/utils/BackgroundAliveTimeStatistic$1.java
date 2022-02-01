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
    localHashMap.put("time", String.valueOf(this.a));
    localHashMap.put("pss", String.valueOf(this.b));
    localHashMap.put("downloadLaunched", String.valueOf(this.c));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last time = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",last pss = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",downloadLaunched = ");
    localStringBuilder.append(this.c);
    QLog.d("BackgroundAliveTimeStatistic", 1, localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "qq_bg_alive_time", true, this.a, 1L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.BackgroundAliveTimeStatistic.1
 * JD-Core Version:    0.7.0.1
 */