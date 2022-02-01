package com.tencent.featuretoggle.hltxkg.common.a;

import com.tencent.featuretoggle.hltxkg.common.a;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class o
{
  private static o a = new o();
  private Timer b;
  private Map<Runnable, TimerTask> c = new ConcurrentHashMap();
  
  private o()
  {
    StringBuilder localStringBuilder = new StringBuilder("halley_");
    localStringBuilder.append(a.c());
    localStringBuilder.append("_");
    localStringBuilder.append("ConnectionTimer");
    this.b = new Timer(localStringBuilder.toString(), true);
  }
  
  public static o a()
  {
    return a;
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean, long paramLong)
  {
    try
    {
      a(paramRunnable);
      p localp = new p(this, paramRunnable);
      if (paramBoolean) {
        this.b.schedule(localp, paramLong, paramLong);
      } else {
        this.b.schedule(localp, paramLong);
      }
      this.c.put(paramRunnable, localp);
      return;
    }
    finally {}
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, false, paramLong);
  }
  
  public final boolean a(Runnable paramRunnable)
  {
    try
    {
      TimerTask localTimerTask = (TimerTask)this.c.get(paramRunnable);
      if (localTimerTask != null)
      {
        this.c.remove(paramRunnable);
        boolean bool = localTimerTask.cancel();
        return bool;
      }
      return true;
    }
    finally {}
  }
  
  public final void b(Runnable paramRunnable, long paramLong)
  {
    a(paramRunnable, true, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.o
 * JD-Core Version:    0.7.0.1
 */