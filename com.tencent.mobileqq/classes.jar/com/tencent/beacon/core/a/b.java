package com.tencent.beacon.core.a;

import java.util.concurrent.ScheduledExecutorService;

public abstract class b
{
  public static boolean a = true;
  private static b b;
  
  public static b a(ScheduledExecutorService paramScheduledExecutorService)
  {
    return new b.a(paramScheduledExecutorService);
  }
  
  public static void a(b paramb)
  {
    try
    {
      com.tencent.beacon.core.d.b.b("[task] setInstance: " + paramb, new Object[0]);
      if (b != null) {
        b.a();
      }
      b = paramb;
      com.tencent.beacon.core.d.b.b("[task] setInstance end", new Object[0]);
      return;
    }
    finally {}
  }
  
  public static b b()
  {
    try
    {
      if (b == null) {
        b = new b.a();
      }
      b localb = b;
      return localb;
    }
    finally {}
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(Runnable paramRunnable, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.a.b
 * JD-Core Version:    0.7.0.1
 */