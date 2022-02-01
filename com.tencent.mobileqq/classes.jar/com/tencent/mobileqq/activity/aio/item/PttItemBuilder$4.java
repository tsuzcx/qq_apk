package com.tencent.mobileqq.activity.aio.item;

import agkm;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PttItemBuilder$4
  implements Runnable
{
  public PttItemBuilder$4(agkm paramagkm, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "PttSttReport PTT_STT_RESULT_ERROR strErrorCode = " + this.a + "  | strSubErrorCode = " + this.b);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("sttErrorCode", this.a);
    localHashMap.put("sttSubErrorCode", this.b);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSttResultError", true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */