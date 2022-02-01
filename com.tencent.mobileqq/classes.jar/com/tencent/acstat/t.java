package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;
import java.util.Map;

final class t
  implements Runnable
{
  t(String paramString, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      synchronized ()
      {
        StatLogger localStatLogger;
        StringBuilder localStringBuilder;
        if (StatServiceImpl.g().size() >= StatConfig.getMaxParallelTimmingEvents())
        {
          localStatLogger = StatServiceImpl.f();
          localStringBuilder = new StringBuilder("The number of page events exceeds the maximum value ");
          localStringBuilder.append(Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
          localStatLogger.error(localStringBuilder.toString());
          return;
        }
        StatServiceImpl.b(this.a);
        if (StatServiceImpl.g().containsKey(StatServiceImpl.h()))
        {
          localStatLogger = StatServiceImpl.f();
          localStringBuilder = new StringBuilder("Duplicate PageID : ");
          localStringBuilder.append(StatServiceImpl.h());
          localStringBuilder.append(", onResume() repeated?");
          localStatLogger.e(localStringBuilder.toString());
          return;
        }
        StatServiceImpl.g().put(StatServiceImpl.h(), Long.valueOf(System.currentTimeMillis()));
        StatServiceImpl.a(this.b, true, this.c);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.t
 * JD-Core Version:    0.7.0.1
 */