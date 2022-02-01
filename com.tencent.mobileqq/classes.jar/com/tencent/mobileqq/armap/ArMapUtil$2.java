package com.tencent.mobileqq.armap;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public final class ArMapUtil$2
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Boolean)
    {
      str = "1";
      localHashMap.put("isMapShow", str);
      if (!this.b) {
        break label106;
      }
      str = "1";
      label36:
      localHashMap.put("isFelxMap", str);
      if (!this.c) {
        break label112;
      }
    }
    label106:
    label112:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isFelxMapClick", str);
      localHashMap.put("operatorMapCount", String.valueOf(this.jdField_a_of_type_Int));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ARMAP_DETAIL_GRID_MAP", this.c, 0L, 0L, localHashMap, "", false);
      return;
      str = "0";
      break;
      str = "0";
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapUtil.2
 * JD-Core Version:    0.7.0.1
 */