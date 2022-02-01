package com.tencent.map.sdk.a;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class ay
{
  private static ay a = new ay();
  private Timer b;
  private Map<Runnable, TimerTask> c = new ConcurrentHashMap();
  
  private ay()
  {
    StringBuilder localStringBuilder = new StringBuilder("halley_");
    localStringBuilder.append(ac.c());
    localStringBuilder.append("_");
    localStringBuilder.append("ConnectionTimer");
    this.b = new Timer(localStringBuilder.toString(), true);
  }
  
  public static ay a()
  {
    return a;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean, long paramLong)
  {
    try
    {
      a(paramRunnable);
      az localaz = new az(paramRunnable);
      if (paramBoolean) {
        this.b.schedule(localaz, paramLong, paramLong);
      } else {
        this.b.schedule(localaz, paramLong);
      }
      this.c.put(paramRunnable, localaz);
      return;
    }
    finally {}
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ay
 * JD-Core Version:    0.7.0.1
 */