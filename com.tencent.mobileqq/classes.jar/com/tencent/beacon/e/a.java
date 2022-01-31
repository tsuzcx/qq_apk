package com.tencent.beacon.e;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.beacon.a.b.j;
import com.tencent.beacon.a.b.j.a;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.f.h;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.UploadHandleListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  extends com.tencent.beacon.a.a
  implements j.a, UploadHandleListener
{
  private static a h = null;
  private static long i = 1073741824L;
  private static long j = 209715200L;
  private boolean b = false;
  private int c = 600;
  private boolean d = true;
  private b e;
  private b f;
  private b g;
  
  private a(Context paramContext)
  {
    super(paramContext);
    h.a(this.a).a(this);
    j.a(this);
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
          if (this.f == null)
          {
            this.f = new b(1, l3, 1L, l1, l2, paramLong1, paramLong2);
            if (this.e != null) {
              break label190;
            }
            this.e = new b(0, l3, 1L, l1, l2, paramLong1, paramLong2);
          }
        }
        else
        {
          l1 = 0L;
          break label277;
        }
        long l4 = this.f.a();
        this.f = new b(1, this.f.b, 1L + this.f.c, this.f.d + l1, this.f.e + l2, this.f.f + paramLong1, this.f.g + paramLong2);
        this.f.a(l4);
        continue;
        l3 = this.e.a();
      }
      finally {}
      label190:
      this.e = new b(0, this.e.b, this.e.c + 1L, l1 + this.e.d, l2 + this.e.e, this.e.f + paramLong1, this.e.g + paramLong2);
      this.e.a(l3);
      continue;
      label277:
      if (paramBoolean) {
        l2 = 0L;
      }
    }
  }
  
  private void a(b paramb)
  {
    try
    {
      this.e = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private void b(b paramb)
  {
    try
    {
      this.f = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private void c(b paramb)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (paramb != null) {
        localArrayList.add(paramb);
      }
      if (localArrayList.size() > 0) {
        com.tencent.beacon.a.a.c(this.a, (b[])localArrayList.toArray(new b[localArrayList.size()]));
      }
      return;
    }
    finally {}
  }
  
  public static a j(Context paramContext)
  {
    try
    {
      if (h == null) {
        h = new a(paramContext);
      }
      paramContext = h;
      return paramContext;
    }
    finally {}
  }
  
  private b j()
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
        int k = Process.myUid();
        localObject = Class.forName("android.net.TrafficStats");
        if (localObject == null) {
          break label485;
        }
        l2 = ((Long)((Class)localObject).getMethod("getUidRxBytes", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(k) })).longValue();
        l1 = ((Long)((Class)localObject).getMethod("getUidTxBytes", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(k) })).longValue();
        m();
        if (this.g == null) {
          break label431;
        }
        if ((l2 == this.g.i) && (l1 == this.g.h)) {
          break label476;
        }
        bool = com.tencent.beacon.a.a.g(this.a);
        this.g.b = System.currentTimeMillis();
        l3 = 0L;
        l4 = 0L;
        l6 = 0L;
        l5 = 0L;
        if (l2 - this.g.i > 0L) {
          l3 = l2 - this.g.i;
        }
        if (l1 - this.g.h <= 0L) {
          break label493;
        }
        l4 = l1 - this.g.h;
      }
      catch (Exception localException)
      {
        Object localObject;
        com.tencent.beacon.a.g.a.a(localException);
        return null;
      }
      localObject = this.g;
      ((b)localObject).g = (l3 + ((b)localObject).g);
      localObject = this.g;
      ((b)localObject).f = (l4 + ((b)localObject).f);
      localObject = this.g;
      ((b)localObject).d = (l6 + ((b)localObject).d);
      localObject = this.g;
      ((b)localObject).e = (l5 + ((b)localObject).e);
      this.g.i = l2;
      this.g.h = l1;
      if ((this.g.g < i) && (this.g.f < j) && (this.g.d < i) && (this.g.e < i))
      {
        c(this.g);
        return this.g;
      }
      this.g.g = 0L;
      this.g.f = 0L;
      this.g.d = 0L;
      this.g.e = 0L;
      c(this.g);
      continue;
      label431:
      this.g = new b(2, System.currentTimeMillis(), 0L, 0L, 0L, 0L, 0L);
      this.g.i = l2;
      this.g.h = l1;
      c(this.g);
      label476:
      b localb = this.g;
      return localb;
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
  
  private b k()
  {
    try
    {
      b localb = this.e;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private b l()
  {
    try
    {
      h();
      b localb = this.f;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void m()
  {
    try
    {
      Object localObject1 = com.tencent.beacon.a.a.f(this.a);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          this.g = ((b)((Iterator)localObject1).next());
        }
      }
    }
    finally {}
  }
  
  private void n()
  {
    try
    {
      long l = new Date().getTime();
      b localb = k();
      if ((localb != null) && (localb.a() >= 0L)) {
        com.tencent.beacon.a.a.b(this.a, new b[] { localb });
      }
      a(new b(0, l, 0L, 0L, 0L, 0L, 0L));
      return;
    }
    finally {}
  }
  
  private static boolean o()
  {
    try
    {
      int k = Process.myUid();
      Class localClass = Class.forName("android.net.TrafficStats");
      if (localClass != null)
      {
        long l1 = ((Long)localClass.getMethod("getUidRxBytes", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(k) })).longValue();
        long l2 = ((Long)localClass.getMethod("getUidTxBytes", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(k) })).longValue();
        if ((l1 != -1L) && (l2 != -1L)) {
          return true;
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final long a()
  {
    b localb = l();
    if (localb != null) {
      return localb.e;
    }
    return 0L;
  }
  
  public final void a(int paramInt, Map<String, String> paramMap)
  {
    super.a(paramInt, paramMap);
    if (paramInt == 1)
    {
      this.b = com.tencent.beacon.a.a.a((String)paramMap.get("appNetConOnOff"), this.b);
      this.c = com.tencent.beacon.a.a.a((String)paramMap.get("netConQuePeriod"), this.c, 60, 1200);
      this.d = com.tencent.beacon.a.a.a((String)paramMap.get("sdkNetConOnOff"), this.d);
    }
  }
  
  public final void b(Context paramContext)
  {
    super.b(paramContext);
    com.tencent.beacon.a.a.b.a().a(new Runnable()
    {
      public final void run()
      {
        a.this.g();
        if (a.this.h() > 0) {
          a.this.i();
        }
      }
    });
  }
  
  public final void c()
  {
    super.c();
    com.tencent.beacon.a.g.a.a("[module] netConsume module > %S", new Object[] { this.d });
    Object localObject;
    if (this.d)
    {
      localObject = k();
      if (localObject != null)
      {
        long l1 = ((b)localObject).d;
        long l2 = ((b)localObject).e;
        long l3 = ((b)localObject).e;
        localObject = new HashMap();
        e.a(this.a);
        ((HashMap)localObject).put("A33", e.i(this.a));
        ((HashMap)localObject).put("A64", String.valueOf(l1 + l2));
        ((HashMap)localObject).put("A65", String.valueOf(l3));
        if (UserAction.onUserAction("rqd_sdk_net_consumed", true, 0L, 0L, (Map)localObject, true)) {
          n();
        }
      }
    }
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {}
    for (boolean bool = false;; bool = this.b)
    {
      if ((bool) && (o()))
      {
        localObject = new Runnable()
        {
          public final void run()
          {
            a.a(a.this);
          }
        };
        com.tencent.beacon.a.a.b.a().a((Runnable)localObject, 50000L);
        int k = this.c;
        if (k > 0)
        {
          localObject = new Runnable()
          {
            public final void run()
            {
              a.b(a.this);
            }
          };
          com.tencent.beacon.a.a.b.a().a(107, (Runnable)localObject, 0L, k * 1000);
        }
      }
      return;
    }
  }
  
  protected final void g()
  {
    for (;;)
    {
      b localb;
      try
      {
        Object localObject1 = com.tencent.beacon.a.a.e(this.a);
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localb = (b)((Iterator)localObject1).next();
        if (localb.a == 0)
        {
          a(localb);
          continue;
        }
        if (localb.a != 1) {
          continue;
        }
      }
      finally {}
      b(localb);
    }
  }
  
  protected final int h()
  {
    for (;;)
    {
      try
      {
        long l1 = com.tencent.beacon.a.a.e();
        long l2 = new Date().getTime();
        int k = 0;
        if ((this.f == null) || (this.f.b < l1))
        {
          this.f = new b(1, l2, 0L, 0L, 0L, 0L, 0L);
          k = 1;
        }
        if (this.e == null)
        {
          this.e = new b(0, l2, 0L, 0L, 0L, 0L, 0L);
          k += 1;
          return k;
        }
      }
      finally {}
    }
  }
  
  protected final void i()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      b localb = k();
      if (localb != null) {
        localArrayList.add(localb);
      }
      localb = l();
      if (localb != null) {
        localArrayList.add(localb);
      }
      if (localArrayList.size() > 0) {
        com.tencent.beacon.a.a.a(this.a, (b[])localArrayList.toArray(new b[localArrayList.size()]));
      }
      return;
    }
    finally {}
  }
  
  public final void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    com.tencent.beacon.a.g.a.h("[netC] req:%d  res:%d  send:%d  recv:%d  result: %b  msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString });
    if (paramInt1 != 5)
    {
      g();
      h();
      a(paramLong1, paramLong2, com.tencent.beacon.a.a.g(this.a));
      i();
      com.tencent.beacon.a.g.a.f("[netC] total:%s | today:%s", new Object[] { k(), l() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.e.a
 * JD-Core Version:    0.7.0.1
 */