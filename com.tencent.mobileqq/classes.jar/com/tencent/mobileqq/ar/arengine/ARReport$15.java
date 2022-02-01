package com.tencent.mobileqq.ar.arengine;

import android.os.Build;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ARReport$15
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ar_model", Build.MODEL);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("");
    localHashMap.put("result", localStringBuilder.toString());
    localHashMap.put("alltime", String.valueOf(this.b));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AREngine_openCamera", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.15
 * JD-Core Version:    0.7.0.1
 */