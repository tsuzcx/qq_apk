package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.tencent.bugly.b;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class u
{
  private static u c = null;
  public t a;
  public boolean b = true;
  private final p d;
  private final Context e;
  private Map<Integer, Long> f = new HashMap();
  private long g;
  private long h;
  private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue();
  private LinkedBlockingQueue<Runnable> j = new LinkedBlockingQueue();
  private final Object k = new Object();
  private String l = null;
  private byte[] m = null;
  private long n = 0L;
  private byte[] o = null;
  private long p = 0L;
  private String q = null;
  private long r = 0L;
  private final Object s = new Object();
  private boolean t = false;
  private final Object u = new Object();
  private int v = 0;
  
  private u(Context paramContext)
  {
    this.e = paramContext;
    this.d = p.a();
    try
    {
      Class.forName("android.util.Base64");
      if (this.b)
      {
        paramContext = new StringBuilder();
        paramContext.append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/").append("fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB");
        this.l = paramContext.toString();
      }
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        x.a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
        this.b = false;
      }
    }
  }
  
  public static u a()
  {
    try
    {
      u localu = c;
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
      if (c == null) {
        c = new u(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Runnable paramRunnable, long paramLong)
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
    }
  }
  
  private void a(Runnable arg1, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (??? == null) {
      x.d("[UploadManager] Upload task should not be null", new Object[0]);
    }
    x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (this.q != null) {
      if (d())
      {
        x.c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        if (paramBoolean2) {
          a(???, paramLong);
        }
      }
    }
    do
    {
      return;
      a(???, paramBoolean1);
      c(0);
      return;
      x.a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      b(false);
      synchronized (this.u)
      {
        if (this.t)
        {
          a(???, paramBoolean1);
          return;
        }
      }
      this.t = true;
      x.c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      if (paramBoolean2)
      {
        a(new u.a(this, this.e, ???, paramLong), 0L);
        return;
      }
      a(???, paramBoolean1);
      ??? = new u.a(this, this.e);
      x.a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", new Object[] { "BUGLY_ASYNC_UPLOAD" });
    } while (z.a(???, "BUGLY_ASYNC_UPLOAD") != null);
    x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
    ??? = w.a();
    if (??? != null)
    {
      ((w)???).a(???);
      return;
    }
    x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
    synchronized (this.u)
    {
      this.t = false;
      return;
    }
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
      Object localObject = this.k;
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          this.i.put(paramRunnable);
          return true;
        }
        finally {}
        this.j.put(paramRunnable);
      }
      return false;
    }
    catch (Throwable paramRunnable)
    {
      x.e("[UploadManager] Failed to add upload task to queue: %s", new Object[] { paramRunnable.getMessage() });
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt < 0)
    {
      x.a("[UploadManager] Number of task to execute should >= 0", new Object[0]);
      return;
    }
    w localw = w.a();
    LinkedBlockingQueue localLinkedBlockingQueue1 = new LinkedBlockingQueue();
    LinkedBlockingQueue localLinkedBlockingQueue2 = new LinkedBlockingQueue();
    int i1;
    int i2;
    synchronized (this.k)
    {
      x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      i1 = this.i.size();
      i2 = this.j.size();
      if ((i1 == 0) && (i2 == 0))
      {
        x.c("[UploadManager] There is no upload task in queue.", new Object[0]);
        return;
      }
    }
    if (paramInt != 0)
    {
      if (paramInt < i1)
      {
        i2 = 0;
        i1 = paramInt;
        paramInt = i2;
      }
      for (;;)
      {
        label136:
        if (localObject1 != null) {
          if (!localObject1.b())
          {
            break label578;
            label152:
            if (i2 >= i1) {
              break label585;
            }
            Runnable localRunnable1 = (Runnable)this.i.peek();
            if (localRunnable1 == null) {
              break label585;
            }
            try
            {
              localLinkedBlockingQueue1.put(localRunnable1);
              this.i.poll();
              i2 += 1;
              break label152;
              if (paramInt < i1 + i2) {
                paramInt -= i1;
              }
            }
            catch (Throwable localThrowable1)
            {
              for (;;)
              {
                x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", new Object[] { localThrowable1.getMessage() });
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i2 < paramInt)
      {
        Runnable localRunnable2 = (Runnable)this.j.peek();
        if (localRunnable2 != null) {
          try
          {
            localLinkedBlockingQueue2.put(localRunnable2);
            this.j.poll();
            i2 += 1;
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", new Object[] { localThrowable2.getMessage() });
            }
          }
        }
      }
      if (i1 > 0) {
        x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(i1), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      }
      i2 = 0;
      if (i2 < i1)
      {
        Runnable localRunnable3 = (Runnable)localLinkedBlockingQueue1.poll();
        if (localRunnable3 != null) {
          for (;;)
          {
            synchronized (this.k)
            {
              if ((this.v >= 2) && (localObject1 != null))
              {
                localObject1.a(localRunnable3);
                i2 += 1;
                break;
              }
              x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", new Object[] { "BUGLY_ASYNC_UPLOAD" });
              if (z.a(new u.1(this, localRunnable3), "BUGLY_ASYNC_UPLOAD") != null) {
                synchronized (this.k)
                {
                  this.v += 1;
                }
              }
            }
            x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
            a(localRunnable3, true);
          }
        }
      }
      if (paramInt > 0) {
        x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      }
      if (localObject3 == null) {
        break;
      }
      localObject3.a(new u.2(this, paramInt, localLinkedBlockingQueue2));
      return;
      break label580;
      paramInt = i2;
      break label136;
      label578:
      paramInt = 0;
      label580:
      i2 = 0;
      break label152;
      label585:
      i2 = 0;
    }
  }
  
  private static boolean e()
  {
    x.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try
    {
      p localp = p.a();
      if (localp == null)
      {
        x.d("[UploadManager] Failed to get Database", new Object[0]);
        return false;
      }
      boolean bool = localp.a(555, "security_info", null, true);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      x.a(localThrowable);
    }
    return false;
  }
  
  private boolean f()
  {
    x.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        p localp = p.a();
        if (localp == null)
        {
          x.d("[UploadManager] Failed to get database", new Object[0]);
          return false;
        }
        localStringBuilder = new StringBuilder();
        if (this.o != null)
        {
          localStringBuilder.append(Base64.encodeToString(this.o, 0));
          localStringBuilder.append("#");
          if (this.p != 0L)
          {
            localStringBuilder.append(Long.toString(this.p));
            localStringBuilder.append("#");
            if (this.q == null) {
              break label218;
            }
            localStringBuilder.append(this.q);
            localStringBuilder.append("#");
            if (this.r == 0L) {
              break label229;
            }
            localStringBuilder.append(Long.toString(this.r));
            localp.a(555, "security_info", localStringBuilder.toString().getBytes(), null, true);
            return true;
          }
        }
        else
        {
          x.c("[UploadManager] AES key is null, will not record", new Object[0]);
          return false;
        }
        localStringBuilder.append("null");
        continue;
        localStringBuilder.append("null");
      }
      catch (Throwable localThrowable)
      {
        x.a(localThrowable);
        e();
        return false;
      }
      label218:
      continue;
      label229:
      localStringBuilder.append("null");
    }
  }
  
  private boolean g()
  {
    x.c("[UploadManager] Load security info from database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    label381:
    for (;;)
    {
      try
      {
        Object localObject = p.a();
        if (localObject == null)
        {
          x.d("[UploadManager] Failed to get database", new Object[0]);
          return false;
        }
        localObject = ((p)localObject).a(555, null, true);
        if ((localObject == null) || (!((Map)localObject).containsKey("security_info"))) {
          break;
        }
        String str = new String((byte[])((Map)localObject).get("security_info"));
        localObject = str.split("#");
        int i2;
        if (localObject.length == 4)
        {
          if (localObject[0].isEmpty()) {
            break label381;
          }
          boolean bool = localObject[0].equals("null");
          if (bool) {
            break label381;
          }
          try
          {
            this.o = Base64.decode(localObject[0], 0);
            i1 = 0;
          }
          catch (Throwable localThrowable3)
          {
            x.a(localThrowable3);
            i1 = 1;
            continue;
          }
          i2 = i1;
          if (i1 == 0)
          {
            i2 = i1;
            if (!localObject[1].isEmpty())
            {
              bool = localObject[1].equals("null");
              i2 = i1;
              if (bool) {}
            }
          }
          try
          {
            this.p = Long.parseLong(localObject[1]);
            i2 = i1;
          }
          catch (Throwable localThrowable4)
          {
            x.a(localThrowable4);
            i2 = 1;
            continue;
          }
          if ((i2 == 0) && (!localObject[2].isEmpty()) && (!localObject[2].equals("null"))) {
            this.q = localObject[2];
          }
          i1 = i2;
          if (i2 == 0)
          {
            i1 = i2;
            if (!localObject[3].isEmpty())
            {
              bool = localObject[3].equals("null");
              i1 = i2;
              if (bool) {}
            }
          }
          try
          {
            this.r = Long.parseLong(localObject[3]);
            i1 = i2;
          }
          catch (Throwable localThrowable1)
          {
            x.a(localThrowable1);
            i1 = 1;
            continue;
          }
          if (i1 == 0) {
            break;
          }
          e();
          break;
        }
        x.a("SecurityInfo = %s, Strings.length = %d", new Object[] { localThrowable4, Integer.valueOf(localThrowable1.length) });
        int i1 = 1;
        continue;
        i1 = 0;
      }
      catch (Throwable localThrowable2)
      {
        x.a(localThrowable2);
        return false;
      }
    }
    return true;
  }
  
  public final long a(int paramInt)
  {
    long l2 = 0L;
    if (paramInt >= 0) {}
    label211:
    for (;;)
    {
      try
      {
        Object localObject1 = (Long)this.f.get(Integer.valueOf(paramInt));
        if (localObject1 != null)
        {
          l1 = ((Long)localObject1).longValue();
          return l1;
        }
        localObject1 = this.d.a(paramInt);
        l1 = l2;
        if (localObject1 == null) {
          continue;
        }
        l1 = l2;
        if (((List)localObject1).size() <= 0) {
          continue;
        }
        if (((List)localObject1).size() > 1)
        {
          localObject1 = ((List)localObject1).iterator();
          l1 = l2;
          if (((Iterator)localObject1).hasNext())
          {
            r localr = (r)((Iterator)localObject1).next();
            if (localr.e <= l1) {
              break label211;
            }
            l1 = localr.e;
            break label211;
          }
          this.d.b(paramInt);
          continue;
        }
        try
        {
          l1 = ((r)localObject2.get(0)).e;
        }
        catch (Throwable localThrowable)
        {
          x.a(localThrowable);
          l1 = l2;
        }
      }
      finally {}
      continue;
      x.e("[UploadManager] Unknown upload ID: %d", new Object[] { Integer.valueOf(paramInt) });
      long l1 = l2;
    }
  }
  
  public final long a(boolean paramBoolean)
  {
    long l3 = 0L;
    long l4 = z.b();
    int i1;
    List localList;
    long l1;
    long l2;
    if (paramBoolean)
    {
      i1 = 5;
      localList = this.d.a(i1);
      if ((localList != null) && (localList.size() > 0)) {
        l1 = l3;
      }
    }
    else
    {
      try
      {
        r localr = (r)localList.get(0);
        l2 = l3;
        l1 = l3;
        if (localr.e >= l4)
        {
          l1 = l3;
          l2 = z.c(localr.g);
          if (i1 != 3) {
            break label172;
          }
          l1 = l2;
          this.g = l2;
          label100:
          l1 = l2;
          localList.remove(localr);
        }
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          x.a(localThrowable);
        }
      }
      l2 = l1;
      if (localList.size() > 0)
      {
        this.d.a(localList);
        l2 = l1;
      }
    }
    for (;;)
    {
      x.c("[UploadManager] Local network consume: %d KB", new Object[] { Long.valueOf(l2 / 1024L) });
      return l2;
      i1 = 3;
      break;
      label172:
      l1 = l2;
      this.h = l2;
      break label100;
      if (paramBoolean) {
        l2 = this.h;
      } else {
        l2 = this.g;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, t paramt, int paramInt3, int paramInt4, boolean paramBoolean, Map<String, String> paramMap)
  {
    try
    {
      a(new v(this.e, paramInt1, paramInt2, paramArrayOfByte, paramString1, paramString2, paramt, this.b, paramInt3, paramInt4, false, paramMap), paramBoolean, false, 0L);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      while (x.a(paramArrayOfByte)) {}
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public final void a(int paramInt, long paramLong)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      try
      {
        this.f.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
        r localr = new r();
        localr.b = paramInt;
        localr.e = paramLong;
        localr.c = "";
        localr.d = "";
        localr.g = new byte[0];
        this.d.b(paramInt);
        this.d.a(localr);
        x.c("[UploadManager] Uploading(ID:%d) time: %s", new Object[] { Integer.valueOf(paramInt), z.a(paramLong) });
        return;
      }
      finally {}
      x.e("[UploadManager] Unknown uploading ID: %d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, long paramLong, boolean paramBoolean)
  {
    int i1 = paramam.g;
    paramam = a.a(paramam);
    try
    {
      a(new v(this.e, paramInt, i1, paramam, paramString1, paramString2, paramt, this.b, paramBoolean), true, true, paramLong);
      return;
    }
    catch (Throwable paramam)
    {
      while (x.a(paramam)) {}
      paramam.printStackTrace();
    }
  }
  
  public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, boolean paramBoolean)
  {
    a(paramInt, paramam.g, a.a(paramam), paramString1, paramString2, paramt, 0, 0, paramBoolean, null);
  }
  
  public final void a(int paramInt, an arg2)
  {
    int i3 = 1;
    int i4 = 1;
    int i2 = 1;
    if (!this.b) {
      return;
    }
    if (paramInt == 2)
    {
      x.c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      b(true);
    }
    for (;;)
    {
      synchronized (this.u)
      {
        if (this.t)
        {
          this.t = false;
          z.b(this.e, "security_info");
        }
        return;
      }
      synchronized (this.u)
      {
        if (!this.t) {
          return;
        }
      }
      int i1;
      if (??? != null)
      {
        x.c("[UploadManager] Record security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        i1 = i4;
        for (;;)
        {
          try
          {
            ??? = ???.g;
            paramInt = i3;
            if (??? != null)
            {
              paramInt = i3;
              i1 = i4;
              if (((Map)???).containsKey("S1"))
              {
                paramInt = i3;
                i1 = i4;
                if (((Map)???).containsKey("S2"))
                {
                  i1 = i4;
                  this.n = (???.e - System.currentTimeMillis());
                  i1 = i4;
                  x.c("[UploadManager] Time lag of server is: %d", new Object[] { Long.valueOf(this.n) });
                  i1 = i4;
                  this.q = ((String)((Map)???).get("S1"));
                  i1 = i4;
                  x.c("[UploadManager] Session ID from server is: %s", new Object[] { this.q });
                  i1 = i4;
                  paramInt = this.q.length();
                  if (paramInt <= 0) {
                    continue;
                  }
                  i1 = i4;
                }
              }
            }
          }
          catch (Throwable ???)
          {
            x.a(???);
            paramInt = i1;
            continue;
            i1 = i4;
            x.c("[UploadManager] Failed to record database", new Object[0]);
            paramInt = i2;
            continue;
            i1 = i4;
            x.c("[UploadManager] Session ID from server is invalid, try next time", new Object[0]);
            paramInt = i3;
            continue;
          }
          try
          {
            this.r = Long.parseLong((String)((Map)???).get("S2"));
            i1 = i4;
            x.c("[UploadManager] Session expired time from server is: %d(%s)", new Object[] { Long.valueOf(this.r), new Date(this.r).toString() });
            i1 = i4;
            if (this.r < 1000L)
            {
              i1 = i4;
              x.d("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new Object[0]);
              i1 = i4;
              this.r = 259200000L;
            }
          }
          catch (NumberFormatException ???)
          {
            i1 = i4;
            x.d("[UploadManager] Session expired time is invalid, will set to default value", new Object[0]);
            i1 = i4;
            this.r = 259200000L;
          }
        }
        i1 = i4;
        if (f())
        {
          paramInt = 0;
          i1 = paramInt;
          c(0);
          if (paramInt == 0) {
            continue;
          }
          b(false);
          continue;
        }
      }
      x.c("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      b(false);
    }
  }
  
  /* Error */
  protected final void a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq +108 -> 111
    //   6: iconst_5
    //   7: istore 4
    //   9: new 393	com/tencent/bugly/proguard/r
    //   12: dup
    //   13: invokespecial 445	com/tencent/bugly/proguard/r:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: iload 4
    //   22: putfield 447	com/tencent/bugly/proguard/r:b	I
    //   25: aload 5
    //   27: invokestatic 405	com/tencent/bugly/proguard/z:b	()J
    //   30: putfield 395	com/tencent/bugly/proguard/r:e	J
    //   33: aload 5
    //   35: ldc_w 449
    //   38: putfield 451	com/tencent/bugly/proguard/r:c	Ljava/lang/String;
    //   41: aload 5
    //   43: ldc_w 449
    //   46: putfield 453	com/tencent/bugly/proguard/r:d	Ljava/lang/String;
    //   49: aload 5
    //   51: lload_1
    //   52: invokestatic 536	com/tencent/bugly/proguard/z:c	(J)[B
    //   55: putfield 407	com/tencent/bugly/proguard/r:g	[B
    //   58: aload_0
    //   59: getfield 98	com/tencent/bugly/proguard/u:d	Lcom/tencent/bugly/proguard/p;
    //   62: iload 4
    //   64: invokevirtual 397	com/tencent/bugly/proguard/p:b	(I)V
    //   67: aload_0
    //   68: getfield 98	com/tencent/bugly/proguard/u:d	Lcom/tencent/bugly/proguard/p;
    //   71: aload 5
    //   73: invokevirtual 456	com/tencent/bugly/proguard/p:a	(Lcom/tencent/bugly/proguard/r;)Z
    //   76: pop
    //   77: iload_3
    //   78: ifeq +39 -> 117
    //   81: aload_0
    //   82: lload_1
    //   83: putfield 427	com/tencent/bugly/proguard/u:h	J
    //   86: ldc_w 538
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: lload_1
    //   96: ldc2_w 421
    //   99: ldiv
    //   100: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: aastore
    //   104: invokestatic 166	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   107: pop
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: iconst_3
    //   112: istore 4
    //   114: goto -105 -> 9
    //   117: aload_0
    //   118: lload_1
    //   119: putfield 412	com/tencent/bugly/proguard/u:g	J
    //   122: goto -36 -> 86
    //   125: astore 5
    //   127: aload_0
    //   128: monitorexit
    //   129: aload 5
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	u
    //   0	132	1	paramLong	long
    //   0	132	3	paramBoolean	boolean
    //   7	106	4	i1	int
    //   16	56	5	localr	r
    //   125	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	77	125	finally
    //   81	86	125	finally
    //   86	108	125	finally
    //   117	122	125	finally
  }
  
  public final boolean a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    x.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (this.q != null)
    {
      paramMap.put("secureSessionId", this.q);
      return true;
    }
    if ((this.o == null) || (this.o.length << 3 != 128))
    {
      x.d("[UploadManager] AES key is invalid", new Object[0]);
      return false;
    }
    if (this.m == null)
    {
      this.m = Base64.decode(this.l, 0);
      if (this.m == null)
      {
        x.d("[UploadManager] Failed to decode RSA public key", new Object[0]);
        return false;
      }
    }
    Object localObject = z.b(1, this.o, this.m);
    if (localObject == null)
    {
      x.d("[UploadManager] Failed to encrypt AES key", new Object[0]);
      return false;
    }
    localObject = Base64.encodeToString((byte[])localObject, 0);
    if (localObject == null)
    {
      x.d("[UploadManager] Failed to encode AES key", new Object[0]);
      return false;
    }
    paramMap.put("raKey", localObject);
    return true;
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    if ((this.o == null) || (this.o.length << 3 != 128))
    {
      x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return null;
    }
    return z.a(1, paramArrayOfByte, this.o);
  }
  
  public final void b()
  {
    List localList = this.d.a(3);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    this.g = 0L;
    this.d.a(localList);
    x.c("[UploadManager] Clear network consume.", new Object[0]);
  }
  
  protected final void b(boolean paramBoolean)
  {
    synchronized (this.s)
    {
      x.c("[UploadManager] Clear security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      this.o = null;
      this.q = null;
      this.r = 0L;
      if (paramBoolean) {
        e();
      }
      return;
    }
  }
  
  public final boolean b(int paramInt)
  {
    if (b.c) {
      x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
    }
    long l1;
    do
    {
      return true;
      l1 = System.currentTimeMillis() - a(paramInt);
      x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", new Object[] { Long.valueOf(l1 / 1000L), Integer.valueOf(paramInt) });
    } while (l1 >= 30000L);
    x.a("[UploadManager] Data only be uploaded once in %d seconds.", new Object[] { Long.valueOf(30L) });
    return false;
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    if ((this.o == null) || (this.o.length << 3 != 128))
    {
      x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return null;
    }
    return z.a(2, paramArrayOfByte, this.o);
  }
  
  public final void c()
  {
    List localList = this.d.a(5);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    this.h = 0L;
    this.d.a(localList);
    x.c("[UploadManager] Clear network consume of stuck.", new Object[0]);
  }
  
  protected final boolean d()
  {
    if ((this.q == null) || (this.r == 0L)) {
      return false;
    }
    long l1 = System.currentTimeMillis() + this.n;
    if (this.r < l1)
    {
      x.c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", new Object[] { Long.valueOf(this.r), new Date(this.r).toString(), Long.valueOf(l1), new Date(l1).toString() });
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.u
 * JD-Core Version:    0.7.0.1
 */