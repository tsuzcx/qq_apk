package com.tencent.mobileqq.armap;

import bctj;
import com.tencent.common.app.BaseApplicationImpl;
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
      bctj.a(BaseApplicationImpl.getContext()).a("", "ARMAP_OFFLINE_ENTER", true, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapUtil.3
 * JD-Core Version:    0.7.0.1
 */