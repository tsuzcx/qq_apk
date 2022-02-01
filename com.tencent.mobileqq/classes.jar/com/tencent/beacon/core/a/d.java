package com.tencent.beacon.core.a;

import java.util.concurrent.ScheduledExecutorService;

public abstract class d
{
  public static boolean a = true;
  protected static d b;
  
  public static d a()
  {
    try
    {
      if (b == null) {
        b = new d.a();
      }
      d locald = b;
      return locald;
    }
    finally {}
  }
  
  public static d a(ScheduledExecutorService paramScheduledExecutorService)
  {
    return new d.a(paramScheduledExecutorService);
  }
  
  public static void a(d paramd)
  {
    try
    {
      com.tencent.beacon.core.e.d.a("[task] setInstance: " + paramd, new Object[0]);
      d locald = b;
      if (locald != null) {
        locald.c(true);
      }
      b = paramd;
      com.tencent.beacon.core.e.d.a("[task] setInstance end", new Object[0]);
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(Runnable paramRunnable, long paramLong);
  
  public abstract void b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.d
 * JD-Core Version:    0.7.0.1
 */