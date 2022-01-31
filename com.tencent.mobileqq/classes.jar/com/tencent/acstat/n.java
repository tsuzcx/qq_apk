package com.tencent.acstat;

import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.event.c;
import java.util.Map;

final class n
  implements Runnable
{
  n(String paramString, c paramc) {}
  
  public final void run()
  {
    try
    {
      if (StatServiceImpl.a(this.a))
      {
        StatServiceImpl.f().error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
        return;
      }
      if (StatConfig.isDebugEnable()) {
        StatServiceImpl.f().i("add begin key:" + this.b);
      }
      if (StatServiceImpl.j().containsKey(this.b))
      {
        StatServiceImpl.f().warn("Duplicate CustomEvent key: " + this.b.toString() + ", trackCustomBeginKVEvent() repeated?");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      return;
    }
    if (StatServiceImpl.j().size() <= StatConfig.getMaxParallelTimmingEvents())
    {
      StatServiceImpl.j().put(this.b, Long.valueOf(System.currentTimeMillis()));
      return;
    }
    StatServiceImpl.f().error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.acstat.n
 * JD-Core Version:    0.7.0.1
 */