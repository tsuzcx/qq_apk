package com.tencent.beacon.core.event;

import com.tencent.beacon.core.d.b;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

final class e$1
  implements Runnable
{
  e$1(long paramLong1, String paramString, long paramLong2) {}
  
  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("A110", String.valueOf(this.a));
    localHashMap.put("A111", this.b);
    localHashMap.put("A112", String.valueOf(this.c));
    UserAction.onUserAction("rqd_page_fgt", true, 0L, 0L, localHashMap, false);
    if (this.c >= 30000L)
    {
      b.b("[page] force flush page_fgt events in db.", new Object[0]);
      UserAction.flushObjectsToDB(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.event.e.1
 * JD-Core Version:    0.7.0.1
 */