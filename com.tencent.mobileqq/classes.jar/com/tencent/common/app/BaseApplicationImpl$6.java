package com.tencent.common.app;

import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class BaseApplicationImpl$6
  implements Runnable
{
  BaseApplicationImpl$6(BaseApplicationImpl paramBaseApplicationImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(this.a));
    localHashMap.put("param_uin", this.b);
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.b, "PcActiveSuccB", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.6
 * JD-Core Version:    0.7.0.1
 */