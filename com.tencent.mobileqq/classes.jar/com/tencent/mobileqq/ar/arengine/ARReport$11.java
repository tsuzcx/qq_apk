package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ARReport$11
  implements Runnable
{
  ARReport$11(ARReport paramARReport, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.a));
    if (this.b) {
      localHashMap.put("result", "0");
    } else {
      localHashMap.put("result", "1");
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARLocalMarkerRecoglSo", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.11
 * JD-Core Version:    0.7.0.1
 */