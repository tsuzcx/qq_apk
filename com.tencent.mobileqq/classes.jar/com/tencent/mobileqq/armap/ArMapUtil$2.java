package com.tencent.mobileqq.armap;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

final class ArMapUtil$2
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    boolean bool = this.a;
    String str2 = "1";
    String str1;
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("isMapShow", str1);
    if (this.b) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("isFelxMap", str1);
    if (this.c) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localHashMap.put("isFelxMapClick", str1);
    localHashMap.put("operatorMapCount", String.valueOf(this.d));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ARMAP_DETAIL_GRID_MAP", this.c, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapUtil.2
 * JD-Core Version:    0.7.0.1
 */