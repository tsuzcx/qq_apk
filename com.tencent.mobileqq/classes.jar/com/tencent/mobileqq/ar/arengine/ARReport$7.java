package com.tencent.mobileqq.ar.arengine;

import apmk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$7
  implements Runnable
{
  public ARReport$7(apmk paramapmk, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_Boolean) {
      localHashMap.put("result", "0");
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ARLocalControlInt", true, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("result", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.7
 * JD-Core Version:    0.7.0.1
 */