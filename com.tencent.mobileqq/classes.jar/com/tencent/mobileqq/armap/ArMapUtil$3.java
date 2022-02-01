package com.tencent.mobileqq.armap;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public final class ArMapUtil$3
  implements Runnable
{
  public void run()
  {
    if (this.a == null) {}
    for (int i = 0;; i = this.a.length)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("preloadFileCount", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ARMAP_OFFLINE_ENTER", true, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapUtil.3
 * JD-Core Version:    0.7.0.1
 */