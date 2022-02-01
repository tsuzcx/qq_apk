package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.event.b;
import com.tencent.acstat.event.c;
import com.tencent.acstat.event.d;
import java.util.Map;

final class o
  implements Runnable
{
  o(String paramString, c paramc, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      if (StatServiceImpl.a(this.a))
      {
        StatServiceImpl.f().error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
        return;
      }
      Object localObject2 = (Long)StatServiceImpl.j().remove(this.b);
      if (localObject2 != null)
      {
        localObject1 = new b(this.c, StatServiceImpl.a(this.c, false, this.d), this.b.a, this.d);
        ((b)localObject1).b().c = this.b.c;
        localObject2 = Long.valueOf((System.currentTimeMillis() - ((Long)localObject2).longValue()) / 1000L);
        long l;
        if (((Long)localObject2).longValue() <= 0L) {
          l = 1L;
        } else {
          l = ((Long)localObject2).longValue();
        }
        ((b)localObject1).a(Long.valueOf(l).longValue());
        new ab((d)localObject1).a();
        return;
      }
      Object localObject1 = StatServiceImpl.f();
      localObject2 = new StringBuilder("No start time found for custom event: ");
      ((StringBuilder)localObject2).append(this.b.toString());
      ((StringBuilder)localObject2).append(", lost trackCustomBeginKVEvent()?");
      ((StatLogger)localObject1).warn(((StringBuilder)localObject2).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.o
 * JD-Core Version:    0.7.0.1
 */