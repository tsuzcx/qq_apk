package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ARReport$5
  implements Runnable
{
  ARReport$5(ARReport paramARReport, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loadingtime", String.valueOf(this.a));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARWebView", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.5
 * JD-Core Version:    0.7.0.1
 */