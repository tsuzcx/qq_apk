package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

public final class ab
  extends Thread
{
  private boolean a = false;
  private List<aa> b = new ArrayList();
  private List<ac> c = new ArrayList();
  
  private void a(Handler paramHandler)
  {
    if (paramHandler == null) {
      x.e("removeThread handler should not be null", new Object[0]);
    }
    for (;;)
    {
      return;
      int i = 0;
      try
      {
        while (i < this.b.size())
        {
          if (((aa)this.b.get(i)).e().equals(paramHandler.getLooper().getThread().getName()))
          {
            x.c("remove handler::%s", new Object[] { this.b.get(i) });
            this.b.remove(i);
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramHandler)
      {
        x.b(paramHandler);
      }
    }
  }
  
  private void a(Handler paramHandler, long paramLong)
  {
    if (paramHandler == null)
    {
      x.e("addThread handler should not be null", new Object[0]);
      return;
    }
    String str = paramHandler.getLooper().getThread().getName();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.b.size())
        {
          if (!((aa)this.b.get(i)).e().equals(paramHandler.getLooper().getThread().getName())) {
            break label120;
          }
          x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
        }
      }
      catch (Exception localException)
      {
        x.b(localException);
        this.b.add(new aa(paramHandler, str, 5000L));
        return;
      }
      label120:
      i += 1;
    }
  }
  
  private int e()
  {
    int i = 0;
    j = 0;
    try
    {
      while (i < this.b.size())
      {
        int k = Math.max(j, ((aa)this.b.get(i)).c());
        j = k;
        i += 1;
      }
      return j;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
  }
  
  public final void a()
  {
    a(new Handler(Looper.getMainLooper()), 5000L);
  }
  
  public final void a(ac paramac)
  {
    if (this.c.contains(paramac))
    {
      x.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
      return;
    }
    this.c.add(paramac);
  }
  
  public final void b()
  {
    a(new Handler(Looper.getMainLooper()));
  }
  
  public final void b(ac paramac)
  {
    this.c.remove(paramac);
  }
  
  public final boolean c()
  {
    this.a = true;
    if (!isAlive()) {
      return false;
    }
    try
    {
      interrupt();
      return true;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
    return true;
  }
  
  public final boolean d()
  {
    if (isAlive()) {
      return false;
    }
    try
    {
      start();
      return true;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
    return false;
  }
  
  public final void run()
  {
    int i;
    label114:
    int j;
    label169:
    int k;
    while (!this.a)
    {
      i = 0;
      try
      {
        while (i < this.b.size())
        {
          ((aa)this.b.get(i)).a();
          i += 1;
        }
        long l2 = SystemClock.uptimeMillis();
        for (long l1 = 2000L; (l1 > 0L) && (!isInterrupted()); l1 = 2000L - (SystemClock.uptimeMillis() - l2)) {
          sleep(l1);
        }
        i = e();
        if ((i == 0) || (i == 1)) {
          continue;
        }
        localArrayList = new ArrayList();
        i = 0;
        if (i >= this.b.size()) {
          break label300;
        }
        localaa = (aa)this.b.get(i);
        if (!localaa.b()) {
          break label293;
        }
        localArrayList.add(localaa);
        localaa.a(9223372036854775807L);
      }
      catch (Exception localException)
      {
        ArrayList localArrayList;
        aa localaa;
        Thread localThread;
        x.b(localException);
      }
      if (j < localArrayList.size())
      {
        localaa = (aa)localArrayList.get(j);
        localThread = localaa.d();
        k = 0;
      }
    }
    for (;;)
    {
      if (k < this.c.size())
      {
        if (((ac)this.c.get(k)).a(localThread))
        {
          i = 1;
          break label307;
        }
      }
      else
      {
        if ((i == 0) && (localaa.e().contains("main")))
        {
          localaa.f();
          x.d("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new Object[0]);
        }
        j += 1;
        break label169;
        break;
        return;
      }
      break label307;
      label293:
      i += 1;
      break label114;
      label300:
      j = 0;
      i = 0;
      break label169;
      label307:
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.ab
 * JD-Core Version:    0.7.0.1
 */