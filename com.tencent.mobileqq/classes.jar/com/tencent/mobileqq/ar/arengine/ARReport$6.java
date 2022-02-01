package com.tencent.mobileqq.ar.arengine;

import apmk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$6
  implements Runnable
{
  public ARReport$6(apmk paramapmk, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.a));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARMarkerResourceManagerInt", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.6
 * JD-Core Version:    0.7.0.1
 */