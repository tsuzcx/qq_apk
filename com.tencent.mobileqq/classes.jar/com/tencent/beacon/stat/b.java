package com.tencent.beacon.stat;

import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

class b
  implements Runnable
{
  b(d paramd, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("A145", this.a);
    localHashMap.put("A146", String.valueOf(this.b));
    localHashMap.put("A147", String.valueOf(this.c));
    boolean bool = UserAction.onUserAction("rqd_logidtrace", true, 0L, 0L, localHashMap, true);
    com.tencent.beacon.core.e.d.a("[stat] upload last day logid Date: %s, realtimeesn: %d, normalesn: %d, upload success: %s", new Object[] { this.a, Long.valueOf(this.b), Long.valueOf(this.c), Boolean.valueOf(bool) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.stat.b
 * JD-Core Version:    0.7.0.1
 */