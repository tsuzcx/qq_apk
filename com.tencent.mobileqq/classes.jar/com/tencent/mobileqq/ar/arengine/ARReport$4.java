package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ARReport$4
  implements Runnable
{
  ARReport$4(ARReport paramARReport, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (ARReport.a(this.this$0, this.a)) {
      localHashMap.put("local_load_feature_time", String.valueOf(this.a));
    }
    long l = this.b;
    if (l > 0L) {
      localHashMap.put("local_load_feature_count", String.valueOf(l));
    }
    if (ARReport.a(this.this$0, this.c)) {
      localHashMap.put("local_recognize_time", String.valueOf(this.c));
    }
    l = this.d;
    if (l > 0L) {
      localHashMap.put("local_recognize_times", String.valueOf(l));
    }
    l = this.e;
    if (l > 0L) {
      localHashMap.put("local_recognize_quality", String.valueOf(l));
    }
    if (!this.f.equals("")) {
      localHashMap.put("local_recognize_featureid", this.f);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARLocal", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.4
 * JD-Core Version:    0.7.0.1
 */