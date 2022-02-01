package com.tencent.beacon.core.event;

import com.tencent.beacon.core.e.d;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

final class j
  implements Runnable
{
  j(long paramLong1, String paramString, long paramLong2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("A110", String.valueOf(this.a));
    localHashMap.put("A111", this.b);
    localHashMap.put("A112", String.valueOf(this.c));
    UserAction.onUserAction("rqd_page_fgt", true, 0L, 0L, localHashMap, false);
    if (this.c >= 30000L)
    {
      d.a("[page] force flush page_fgt events in db.", new Object[0]);
      UserAction.flushObjectsToDB(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.j
 * JD-Core Version:    0.7.0.1
 */