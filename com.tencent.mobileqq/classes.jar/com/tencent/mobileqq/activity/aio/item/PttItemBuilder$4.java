package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class PttItemBuilder$4
  implements Runnable
{
  PttItemBuilder$4(PttItemBuilder paramPttItemBuilder, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "PttSttReport PTT_STT_RESULT_ERROR strErrorCode = " + this.a + "  | strSubErrorCode = " + this.b);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("sttErrorCode", this.a);
    localHashMap.put("sttSubErrorCode", this.b);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSttResultError", true, 0L, 0L, localHashMap, null);
    localHashMap = new HashMap();
    localHashMap.put("resultCode", this.a);
    localHashMap.put("subCode", this.b);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSttResultMonitor", false, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */