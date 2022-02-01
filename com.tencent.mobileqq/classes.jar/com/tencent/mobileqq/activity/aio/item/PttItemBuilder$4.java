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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PttSttReport PTT_STT_RESULT_ERROR strErrorCode = ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("  | strSubErrorCode = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("sttErrorCode", this.a);
    ((HashMap)localObject).put("sttSubErrorCode", this.b);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSttResultError", true, 0L, 0L, (HashMap)localObject, null);
    localObject = new HashMap();
    ((HashMap)localObject).put("resultCode", this.a);
    ((HashMap)localObject).put("subCode", this.b);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSttResultMonitor", false, 0L, 0L, (HashMap)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */