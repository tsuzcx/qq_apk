package com.tencent.beacon.pagepath;

import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

class a
  implements Runnable
{
  a(b paramb, long paramLong1, String paramString, long paramLong2) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("A110", String.valueOf(this.a));
    ((Map)localObject).put("A111", this.b);
    ((Map)localObject).put("A112", String.valueOf(this.c));
    UserAction.onUserAction("rqd_page", true, 0L, 0L, (Map)localObject, false);
    localObject = this.d;
    b.a((b)localObject, b.a((b)localObject) + this.c);
    if (b.a(this.d) >= 15000L)
    {
      b.a(this.d, 0L);
      UserAction.flushObjectsToDB(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.pagepath.a
 * JD-Core Version:    0.7.0.1
 */