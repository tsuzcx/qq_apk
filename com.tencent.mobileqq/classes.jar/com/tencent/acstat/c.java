package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import java.util.Timer;
import java.util.TimerTask;

public class c
{
  private static volatile c b;
  private Timer a = null;
  private Context c = null;
  
  private c(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = new Timer(false);
  }
  
  public static c a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new c(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a()
  {
    if (StatConfig.getStatSendStrategy() == StatReportStrategy.PERIOD)
    {
      long l = StatConfig.getSendPeriodMinutes() * 60 * 1000;
      if (StatConfig.isDebugEnable())
      {
        StatLogger localStatLogger = StatCommonHelper.getLogger();
        StringBuilder localStringBuilder = new StringBuilder("setupPeriodTimer delay:");
        localStringBuilder.append(l);
        localStatLogger.i(localStringBuilder.toString());
      }
      a(new d(this), l);
    }
  }
  
  public void a(TimerTask paramTimerTask, long paramLong)
  {
    if (this.a != null)
    {
      if (StatConfig.isDebugEnable())
      {
        StatLogger localStatLogger = StatCommonHelper.getLogger();
        StringBuilder localStringBuilder = new StringBuilder("setupPeriodTimer schedule delay:");
        localStringBuilder.append(paramLong);
        localStatLogger.i(localStringBuilder.toString());
      }
      this.a.schedule(paramTimerTask, paramLong);
      return;
    }
    if (StatConfig.isDebugEnable()) {
      StatCommonHelper.getLogger().w("setupPeriodTimer schedule timer == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.c
 * JD-Core Version:    0.7.0.1
 */