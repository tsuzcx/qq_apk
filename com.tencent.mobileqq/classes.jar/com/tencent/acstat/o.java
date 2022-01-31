package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.event.b;
import com.tencent.acstat.event.c;
import java.util.Map;

final class o
  implements Runnable
{
  o(String paramString, c paramc, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    for (;;)
    {
      Long localLong;
      try
      {
        if (StatServiceImpl.a(this.a))
        {
          StatServiceImpl.f().error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
          return;
        }
        localLong = (Long)StatServiceImpl.j().remove(this.b);
        if (localLong == null) {
          break;
        }
        b localb = new b(this.c, StatServiceImpl.a(this.c, false, this.d), this.b.a, this.d);
        localb.b().c = this.b.c;
        localLong = Long.valueOf((System.currentTimeMillis() - localLong.longValue()) / 1000L);
        if (localLong.longValue() <= 0L)
        {
          l = 1L;
          localb.a(Long.valueOf(l).longValue());
          new ab(localb).a();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        StatServiceImpl.f().e(localThrowable);
        return;
      }
      long l = localLong.longValue();
    }
    StatServiceImpl.f().warn("No start time found for custom event: " + this.b.toString() + ", lost trackCustomBeginKVEvent()?");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.acstat.o
 * JD-Core Version:    0.7.0.1
 */