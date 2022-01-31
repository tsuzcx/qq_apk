package com.tencent.beacon.a;

import android.content.Context;
import android.os.Process;
import com.tencent.beacon.d.a;
import com.tencent.beacon.upload.UploadHandleListener;
import com.tencent.beacon.upload.i;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class h
  implements UploadHandleListener
{
  private static h e = null;
  private static long f = 1073741824L;
  private static long g = 209715200L;
  private com.tencent.beacon.a.a.f a;
  private com.tencent.beacon.a.a.f b;
  private com.tencent.beacon.a.a.f c;
  private Context d = null;
  
  private h(Context paramContext)
  {
    this.d = paramContext;
    i.a(this.d).a(this);
    d();
    if (f() > 0) {
      g();
    }
  }
  
  private com.tencent.beacon.a.a.f a()
  {
    for (;;)
    {
      boolean bool;
      long l3;
      long l4;
      long l6;
      long l5;
      try
      {
        int i = Process.myUid();
        localObject = Class.forName("android.net.TrafficStats");
        if (localObject == null) {
          break label485;
        }
        l2 = ((Long)((Class)localObject).getMethod("getUidRxBytes", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(i) })).longValue();
        l1 = ((Long)((Class)localObject).getMethod("getUidTxBytes", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(i) })).longValue();
        e();
        if (this.c == null) {
          break label431;
        }
        if ((l2 == this.c.i) && (l1 == this.c.h)) {
          break label476;
        }
        bool = f.s(this.d);
        this.c.b = System.currentTimeMillis();
        l3 = 0L;
        l4 = 0L;
        l6 = 0L;
        l5 = 0L;
        if (l2 - this.c.i > 0L) {
          l3 = l2 - this.c.i;
        }
        if (l1 - this.c.h <= 0L) {
          break label493;
        }
        l4 = l1 - this.c.h;
      }
      catch (Exception localException)
      {
        Object localObject;
        a.a(localException);
        return null;
      }
      localObject = this.c;
      ((com.tencent.beacon.a.a.f)localObject).g = (l3 + ((com.tencent.beacon.a.a.f)localObject).g);
      localObject = this.c;
      ((com.tencent.beacon.a.a.f)localObject).f = (l4 + ((com.tencent.beacon.a.a.f)localObject).f);
      localObject = this.c;
      ((com.tencent.beacon.a.a.f)localObject).d = (l6 + ((com.tencent.beacon.a.a.f)localObject).d);
      localObject = this.c;
      ((com.tencent.beacon.a.a.f)localObject).e = (l5 + ((com.tencent.beacon.a.a.f)localObject).e);
      this.c.i = l2;
      this.c.h = l1;
      if ((this.c.g < f) && (this.c.f < g) && (this.c.d < f) && (this.c.e < f))
      {
        c(this.c);
        return this.c;
      }
      this.c.g = 0L;
      this.c.f = 0L;
      this.c.d = 0L;
      this.c.e = 0L;
      c(this.c);
      continue;
      label431:
      this.c = new com.tencent.beacon.a.a.f(2, System.currentTimeMillis(), 0L, 0L, 0L, 0L, 0L);
      this.c.i = l2;
      this.c.h = l1;
      c(this.c);
      label476:
      com.tencent.beacon.a.a.f localf = this.c;
      return localf;
      label485:
      long l1 = 0L;
      long l2 = 0L;
      continue;
      label493:
      if (bool) {
        l6 = l3 + l4;
      } else {
        l5 = l3 + l4;
      }
    }
  }
  
  public static h a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new h(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    for (;;)
    {
      long l3;
      long l2;
      long l1;
      try
      {
        l3 = new Date().getTime();
        l2 = paramLong1 + paramLong2;
        if (paramBoolean)
        {
          l1 = l2;
          break label277;
          if (this.b == null)
          {
            this.b = new com.tencent.beacon.a.a.f(1, l3, 1L, l1, l2, paramLong1, paramLong2);
            if (this.a != null) {
              break label190;
            }
            this.a = new com.tencent.beacon.a.a.f(0, l3, 1L, l1, l2, paramLong1, paramLong2);
          }
        }
        else
        {
          l1 = 0L;
          break label277;
        }
        long l4 = this.b.a();
        this.b = new com.tencent.beacon.a.a.f(1, this.b.b, 1L + this.b.c, this.b.d + l1, this.b.e + l2, this.b.f + paramLong1, this.b.g + paramLong2);
        this.b.a(l4);
        continue;
        l3 = this.a.a();
      }
      finally {}
      label190:
      this.a = new com.tencent.beacon.a.a.f(0, this.a.b, this.a.c + 1L, l1 + this.a.d, l2 + this.a.e, this.a.f + paramLong1, this.a.g + paramLong2);
      this.a.a(l3);
      continue;
      label277:
      if (paramBoolean) {
        l2 = 0L;
      }
    }
  }
  
  public static void a(Context paramContext, com.tencent.beacon.a.a.f paramf)
  {
    paramf.g = 0L;
    paramf.f = 0L;
    paramf.d = 0L;
    paramf.e = 0L;
    a(paramContext).c(paramf);
  }
  
  private void a(com.tencent.beacon.a.a.f paramf)
  {
    try
    {
      this.a = paramf;
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  private com.tencent.beacon.a.a.f b()
  {
    try
    {
      com.tencent.beacon.a.a.f localf = this.a;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static com.tencent.beacon.a.a.f b(Context paramContext)
  {
    return a(paramContext).b();
  }
  
  private void b(com.tencent.beacon.a.a.f paramf)
  {
    try
    {
      this.b = paramf;
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  private com.tencent.beacon.a.a.f c()
  {
    try
    {
      f();
      com.tencent.beacon.a.a.f localf = this.b;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static com.tencent.beacon.a.a.f c(Context paramContext)
  {
    return a(paramContext).a();
  }
  
  private void c(com.tencent.beacon.a.a.f paramf)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (paramf != null) {
        localArrayList.add(paramf);
      }
      if (localArrayList.size() > 0) {
        f.c(this.d, (com.tencent.beacon.a.a.f[])localArrayList.toArray(new com.tencent.beacon.a.a.f[localArrayList.size()]));
      }
      return;
    }
    finally {}
  }
  
  private void d()
  {
    for (;;)
    {
      com.tencent.beacon.a.a.f localf;
      try
      {
        Object localObject1 = f.m(this.d);
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localf = (com.tencent.beacon.a.a.f)((Iterator)localObject1).next();
        if (localf.a == 0)
        {
          a(localf);
          continue;
        }
        if (localf.a != 1) {
          continue;
        }
      }
      finally {}
      b(localf);
    }
  }
  
  public static void d(Context paramContext)
  {
    a(paramContext).h();
  }
  
  private void e()
  {
    try
    {
      Object localObject1 = f.n(this.d);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          this.c = ((com.tencent.beacon.a.a.f)((Iterator)localObject1).next());
        }
      }
    }
    finally {}
  }
  
  public static void e(Context paramContext)
  {
    a(paramContext).i();
  }
  
  private int f()
  {
    for (;;)
    {
      try
      {
        long l1 = f.m();
        long l2 = new Date().getTime();
        int i = 0;
        if ((this.b == null) || (this.b.b < l1))
        {
          this.b = new com.tencent.beacon.a.a.f(1, l2, 0L, 0L, 0L, 0L, 0L);
          i = 1;
        }
        if (this.a == null)
        {
          this.a = new com.tencent.beacon.a.a.f(0, l2, 0L, 0L, 0L, 0L, 0L);
          i += 1;
          return i;
        }
      }
      finally {}
    }
  }
  
  public static com.tencent.beacon.a.a.f f(Context paramContext)
  {
    return a(paramContext).c();
  }
  
  private void g()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      com.tencent.beacon.a.a.f localf = b();
      if (localf != null) {
        localArrayList.add(localf);
      }
      localf = c();
      if (localf != null) {
        localArrayList.add(localf);
      }
      if (localArrayList.size() > 0) {
        f.a(this.d, (com.tencent.beacon.a.a.f[])localArrayList.toArray(new com.tencent.beacon.a.a.f[localArrayList.size()]));
      }
      return;
    }
    finally {}
  }
  
  private void h()
  {
    try
    {
      long l = new Date().getTime();
      com.tencent.beacon.a.a.f localf = b();
      if ((localf != null) && (localf.a() >= 0L)) {
        f.b(this.d, new com.tencent.beacon.a.a.f[] { localf });
      }
      a(new com.tencent.beacon.a.a.f(0, l, 0L, 0L, 0L, 0L, 0L));
      return;
    }
    finally {}
  }
  
  private void i()
  {
    try
    {
      long l = new Date().getTime();
      com.tencent.beacon.a.a.f localf = this.c;
      if ((localf != null) && (localf.a() >= 0L)) {
        f.b(this.d, new com.tencent.beacon.a.a.f[] { localf });
      }
      a(new com.tencent.beacon.a.a.f(2, l, 0L, 0L, 0L, 0L, 0L));
      return;
    }
    finally {}
  }
  
  public final void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    a.h(" req:%d  res:%d  send:%d  recv:%d  result: %b  msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString });
    if (paramInt1 != 5)
    {
      d();
      f();
      a(paramLong1, paramLong2, f.s(this.d));
      g();
      a.f(" [total:%s] \n[today:%s]", new Object[] { b(), c() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.h
 * JD-Core Version:    0.7.0.1
 */