package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class NeonControl$2
  implements Runnable
{
  NeonControl$2(NeonControl paramNeonControl, NeonControl.AvgConsumeReport paramAvgConsumeReport, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("neon_opened", String.valueOf(this.a.c));
    localHashMap.put("selimg_frame_consume", String.valueOf(this.b));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_selimg_frame_consume", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel())
    {
      QLog.i("NeonControl", 2, String.format("doReport selimg count:%d avgConsume:%dms neonOpened:%d", new Object[] { Integer.valueOf(this.a.b), Integer.valueOf(this.b), Integer.valueOf(this.a.c) }));
      ARDebugReport.a().a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.NeonControl.2
 * JD-Core Version:    0.7.0.1
 */