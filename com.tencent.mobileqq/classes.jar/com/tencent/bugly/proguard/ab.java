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
  private ArrayList<aa> d = new ArrayList();
  
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
          if (!((aa)this.b.get(i)).d().equals(paramHandler.getLooper().getThread().getName())) {
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
    int i = 0;
    try
    {
      while (i < this.b.size())
      {
        if (((aa)this.b.get(i)).d().equals(Looper.getMainLooper().getThread().getName()))
        {
          x.c("remove handler::%s", new Object[] { this.b.get(i) });
          this.b.remove(i);
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
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
    if (!this.a) {
      i = 0;
    }
    for (;;)
    {
      int k;
      try
      {
        if (i < this.b.size())
        {
          ((aa)this.b.get(i)).a();
          i += 1;
          continue;
        }
        long l2 = SystemClock.uptimeMillis();
        long l1 = 2000L;
        if ((l1 > 0L) && (!isInterrupted()))
        {
          sleep(l1);
          l1 = 2000L - (SystemClock.uptimeMillis() - l2);
          continue;
        }
        i = e();
        if ((i == 0) || (i == 1)) {
          break;
        }
        this.d.clear();
        i = 0;
        if (i >= this.b.size()) {
          break label295;
        }
        aa localaa = (aa)this.b.get(i);
        if (!localaa.b()) {
          break label288;
        }
        this.d.add(localaa);
        localaa.a(9223372036854775807L);
        break label288;
        if (j >= this.d.size()) {
          break;
        }
        localaa = (aa)this.d.get(j);
        k = 0;
        if (k < this.c.size())
        {
          if (!((ac)this.c.get(k)).a(localaa)) {
            break label285;
          }
          i = 1;
          break label302;
        }
        if (i == 0)
        {
          localaa.f();
          x.c("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new Object[0]);
        }
        j += 1;
        continue;
      }
      catch (Exception localException)
      {
        x.b(localException);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        x.b(localOutOfMemoryError);
      }
      break;
      return;
      label285:
      break label302;
      label288:
      i += 1;
      continue;
      label295:
      int j = 0;
      i = 0;
      continue;
      label302:
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.ab
 * JD-Core Version:    0.7.0.1
 */