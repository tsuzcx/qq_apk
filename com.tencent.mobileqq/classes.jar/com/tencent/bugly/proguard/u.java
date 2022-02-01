package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class u
{
  private static u b;
  public t a;
  private final p c;
  private final Context d;
  private Map<Integer, Long> e = new HashMap();
  private long f;
  private long g;
  private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue();
  private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue();
  private final Object j = new Object();
  private int k = 0;
  
  private u(Context paramContext)
  {
    this.d = paramContext;
    this.c = p.a();
  }
  
  public static u a()
  {
    try
    {
      u localu = b;
      return localu;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static u a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new u(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramRunnable == null) {
      x.d("[UploadManager] Upload task should not be null", new Object[0]);
    }
    x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (paramBoolean2)
    {
      if (paramRunnable == null)
      {
        x.d("[UploadManager] Upload task should not be null", new Object[0]);
        return;
      }
      x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      Thread localThread = z.a(paramRunnable, "BUGLY_SYNC_UPLOAD");
      if (localThread == null)
      {
        x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
        a(paramRunnable, true);
        return;
      }
      try
      {
        localThread.join(paramLong);
        return;
      }
      catch (Throwable localThrowable)
      {
        x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", new Object[] { localThrowable.getMessage() });
        a(paramRunnable, true);
        c(0);
        return;
      }
    }
    a(paramRunnable, paramBoolean1);
    c(0);
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null)
    {
      x.a("[UploadManager] Upload task should not be null", new Object[0]);
      return false;
    }
    try
    {
      x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      Object localObject = this.j;
      if (paramBoolean) {}
      try
      {
        this.h.put(paramRunnable);
        break label74;
        this.i.put(paramRunnable);
        label74:
        return true;
      }
      finally {}
      return false;
    }
    catch (Throwable paramRunnable)
    {
      x.e("[UploadManager] Failed to add upload task to queue: %s", new Object[] { paramRunnable.getMessage() });
    }
  }
  
  private void c(int paramInt)
  {
    w localw = w.a();
    LinkedBlockingQueue localLinkedBlockingQueue1 = new LinkedBlockingQueue();
    LinkedBlockingQueue localLinkedBlockingQueue2 = new LinkedBlockingQueue();
    int m;
    label518:
    label520:
    label532:
    synchronized (this.j)
    {
      x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      int n = this.h.size();
      paramInt = this.i.size();
      if ((n == 0) && (paramInt == 0))
      {
        x.c("[UploadManager] There is no upload task in queue.", new Object[0]);
        return;
      }
      if (localw != null)
      {
        if (localw.b()) {
          break label520;
        }
        break label518;
        if (m >= n) {
          break label532;
        }
        Runnable localRunnable1 = (Runnable)this.h.peek();
        if (localRunnable1 == null) {
          break label532;
        }
        try
        {
          localLinkedBlockingQueue1.put(localRunnable1);
          this.h.poll();
        }
        catch (Throwable localThrowable1)
        {
          x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", new Object[] { localThrowable1.getMessage() });
        }
        if (m < paramInt)
        {
          Runnable localRunnable2 = (Runnable)this.i.peek();
          if (localRunnable2 != null) {
            try
            {
              localLinkedBlockingQueue2.put(localRunnable2);
              this.i.poll();
            }
            catch (Throwable localThrowable2)
            {
              x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", new Object[] { localThrowable2.getMessage() });
            }
          }
        }
        if (n > 0) {
          x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(n), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        }
        m = 0;
        while (m < n)
        {
          Runnable localRunnable3 = (Runnable)localLinkedBlockingQueue1.poll();
          if (localRunnable3 != null) {
            synchronized (this.j)
            {
              if ((this.k >= 2) && (localw != null))
              {
                localw.a(localRunnable3);
              }
              else
              {
                x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", new Object[] { "BUGLY_ASYNC_UPLOAD" });
                if (z.a(new u.1(this, localRunnable3), "BUGLY_ASYNC_UPLOAD") != null) {
                  synchronized (this.j)
                  {
                    this.k += 1;
                  }
                }
                x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
                a(localRunnable3, true);
              }
              m += 1;
            }
          }
        }
        if (paramInt > 0) {
          x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        }
        if (localObject2 != null) {
          localObject2.a(new u.2(this, paramInt, localLinkedBlockingQueue2));
        }
        return;
      }
    }
  }
  
  public final long a(int paramInt)
  {
    long l2 = 0L;
    if (paramInt >= 0) {}
    try
    {
      Object localObject1 = (Long)this.e.get(Integer.valueOf(paramInt));
      if (localObject1 != null)
      {
        l1 = ((Long)localObject1).longValue();
        return l1;
      }
      localObject1 = this.c.a(paramInt);
      long l1 = l2;
      if (localObject1 != null)
      {
        l1 = l2;
        if (((List)localObject1).size() > 0) {
          if (((List)localObject1).size() > 1)
          {
            localObject1 = ((List)localObject1).iterator();
            l1 = l2;
            while (((Iterator)localObject1).hasNext())
            {
              r localr = (r)((Iterator)localObject1).next();
              if (localr.e > l1) {
                l1 = localr.e;
              }
            }
            this.c.b(paramInt);
          }
          else
          {
            try
            {
              l1 = ((r)((List)localObject1).get(0)).e;
            }
            catch (Throwable localThrowable)
            {
              x.a(localThrowable);
              l1 = l2;
            }
            x.e("[UploadManager] Unknown upload ID: %d", new Object[] { Integer.valueOf(paramInt) });
            l1 = l2;
          }
        }
      }
      return l1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final long a(boolean paramBoolean)
  {
    long l4 = z.b();
    int m;
    if (paramBoolean) {
      m = 5;
    } else {
      m = 3;
    }
    List localList = this.c.a(m);
    long l2;
    long l1;
    if ((localList != null) && (localList.size() > 0))
    {
      long l3 = 0L;
      l2 = l3;
      try
      {
        r localr = (r)localList.get(0);
        l2 = l3;
        l1 = l3;
        if (localr.e >= l4)
        {
          l2 = l3;
          l1 = z.c(localr.g);
          if (m == 3)
          {
            l2 = l1;
            this.f = l1;
          }
          else
          {
            l2 = l1;
            this.g = l1;
          }
          l2 = l1;
          localList.remove(localr);
        }
      }
      catch (Throwable localThrowable)
      {
        x.a(localThrowable);
        l1 = l2;
      }
      l2 = l1;
      if (localList.size() > 0)
      {
        this.c.a(localList);
        l2 = l1;
      }
    }
    else
    {
      if (paramBoolean) {
        l1 = this.g;
      } else {
        l1 = this.f;
      }
      l2 = l1;
    }
    x.c("[UploadManager] Local network consume: %d KB", new Object[] { Long.valueOf(l2 / 1024L) });
    return l2;
  }
  
  public final void a(int paramInt, long paramLong)
  {
    if (paramInt >= 0) {}
    try
    {
      this.e.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
      r localr = new r();
      localr.b = paramInt;
      localr.e = paramLong;
      localr.c = "";
      localr.d = "";
      localr.g = new byte[0];
      this.c.b(paramInt);
      this.c.a(localr);
      x.c("[UploadManager] Uploading(ID:%d) time: %s", new Object[] { Integer.valueOf(paramInt), z.a(paramLong) });
      return;
    }
    finally {}
    x.e("[UploadManager] Unknown uploading ID: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, long paramLong, boolean paramBoolean)
  {
    int m = paramam.g;
    paramam = a.a(paramam);
    try
    {
      a(new v(this.d, paramInt, m, paramam, paramString1, paramString2, paramt, true, paramBoolean), true, true, paramLong);
      return;
    }
    catch (Throwable paramam) {}
  }
  
  public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, boolean paramBoolean)
  {
    int m = paramam.g;
    paramam = a.a(paramam);
    try
    {
      a(new v(this.d, paramInt, m, paramam, paramString1, paramString2, paramt, 0, 0, false, null), paramBoolean, false, 0L);
      return;
    }
    catch (Throwable paramam) {}
  }
  
  protected final void a(long paramLong, boolean paramBoolean)
  {
    int m;
    if (paramBoolean) {
      m = 5;
    } else {
      m = 3;
    }
    try
    {
      r localr = new r();
      localr.b = m;
      localr.e = z.b();
      localr.c = "";
      localr.d = "";
      localr.g = z.c(paramLong);
      this.c.b(m);
      this.c.a(localr);
      if (paramBoolean) {
        this.g = paramLong;
      } else {
        this.f = paramLong;
      }
      x.c("[UploadManager] Network total consume: %d KB", new Object[] { Long.valueOf(paramLong / 1024L) });
      return;
    }
    finally {}
  }
  
  public final void b()
  {
    List localList = this.c.a(3);
    if (localList != null)
    {
      if (localList.size() == 0) {
        return;
      }
      this.f = 0L;
      this.c.a(localList);
      x.c("[UploadManager] Clear network consume.", new Object[0]);
    }
  }
  
  public final boolean b(int paramInt)
  {
    if (b.c)
    {
      x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
      return true;
    }
    long l = System.currentTimeMillis() - a(paramInt);
    x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(paramInt) });
    if (l < 30000L)
    {
      x.a("[UploadManager] Data only be uploaded once in %d seconds.", new Object[] { Long.valueOf(30L) });
      return false;
    }
    return true;
  }
  
  public final void c()
  {
    List localList = this.c.a(5);
    if (localList != null)
    {
      if (localList.size() == 0) {
        return;
      }
      this.g = 0L;
      this.c.a(localList);
      x.c("[UploadManager] Clear network consume of stuck.", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.proguard.u
 * JD-Core Version:    0.7.0.1
 */