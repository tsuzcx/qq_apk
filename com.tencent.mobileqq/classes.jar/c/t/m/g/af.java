package c.t.m.g;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class af
{
  private static af a = new af();
  private Timer b;
  private Map<Runnable, TimerTask> c = new ConcurrentHashMap();
  
  private af()
  {
    StringBuilder localStringBuilder = new StringBuilder("halley_");
    localStringBuilder.append(m.c());
    localStringBuilder.append("_");
    localStringBuilder.append("ConnectionTimer");
    this.b = new Timer(localStringBuilder.toString(), true);
  }
  
  public static af a()
  {
    return a;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean, long paramLong)
  {
    try
    {
      a(paramRunnable);
      ag localag = new ag(paramRunnable);
      if (paramBoolean) {
        this.b.schedule(localag, paramLong, paramLong);
      } else {
        this.b.schedule(localag, paramLong);
      }
      this.c.put(paramRunnable, localag);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.af
 * JD-Core Version:    0.7.0.1
 */