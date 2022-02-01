package com.tencent.mobileqq.armap;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

final class ArMapUtil$3
  implements Runnable
{
  public void run()
  {
    Object localObject = this.a;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.length;
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("preloadFileCount", String.valueOf(i));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ARMAP_OFFLINE_ENTER", true, 0L, 0L, (HashMap)localObject, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapUtil.3
 * JD-Core Version:    0.7.0.1
 */