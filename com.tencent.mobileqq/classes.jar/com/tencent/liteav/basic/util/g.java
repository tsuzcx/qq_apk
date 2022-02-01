package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class g
{
  private Handler a;
  private Looper b;
  private boolean c;
  private Thread d;
  
  public g(String paramString)
  {
    paramString = new HandlerThread(paramString);
    this.c = true;
    paramString.start();
    this.b = paramString.getLooper();
    this.a = new Handler(this.b);
    this.d = paramString;
  }
  
  public Handler a()
  {
    return this.a;
  }
  
  public void a(Runnable paramRunnable)
  {
    boolean[] arrayOfBoolean = new boolean[1];
    if (Thread.currentThread().equals(this.d))
    {
      paramRunnable.run();
      return;
    }
    Handler localHandler = this.a;
    arrayOfBoolean[0] = false;
    try
    {
      this.a.post(new g.1(this, paramRunnable, arrayOfBoolean));
      for (;;)
      {
        int i = arrayOfBoolean[0];
        if (i == 0) {}
        try
        {
          this.a.wait();
        }
        catch (Exception paramRunnable) {}
      }
      return;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramRunnable;
        }
      }
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    this.a.postDelayed(paramRunnable, paramLong);
  }
  
  public void b(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
  
  protected void finalize()
  {
    if (this.c) {
      this.a.getLooper().quit();
    }
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.g
 * JD-Core Version:    0.7.0.1
 */