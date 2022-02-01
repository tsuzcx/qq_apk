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
      if (StatConfig.isDebugEnable())
      {
        localStatLogger = StatServiceImpl.f();
        localStringBuilder = new StringBuilder("add begin key:");
        localStringBuilder.append(this.b);
        localStatLogger.i(localStringBuilder.toString());
      }
      if (StatServiceImpl.j().containsKey(this.b))
      {
        localStatLogger = StatServiceImpl.f();
        localStringBuilder = new StringBuilder("Duplicate CustomEvent key: ");
        localStringBuilder.append(this.b.toString());
        localStringBuilder.append(", trackCustomBeginKVEvent() repeated?");
        localStatLogger.warn(localStringBuilder.toString());
        return;
      }
      if (StatServiceImpl.j().size() <= StatConfig.getMaxParallelTimmingEvents())
      {
        StatServiceImpl.j().put(this.b, Long.valueOf(System.currentTimeMillis()));
        return;
      }
      StatLogger localStatLogger = StatServiceImpl.f();
      StringBuilder localStringBuilder = new StringBuilder("The number of timedEvent exceeds the maximum value ");
      localStringBuilder.append(Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
      localStatLogger.error(localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.n
 * JD-Core Version:    0.7.0.1
 */