package com.tencent.beacon.a.e;

import android.content.Context;
import com.tencent.beacon.a.f.f;
import com.tencent.beacon.a.f.g;
import com.tencent.beacon.a.f.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  extends com.tencent.beacon.a.a
{
  private static b c = null;
  protected a b = null;
  private boolean d = false;
  private f e = null;
  private Runnable f = null;
  private g g = null;
  private int h = 0;
  private boolean i = false;
  private boolean j = false;
  private int k = 0;
  private Object l = new Object();
  private Runnable m = new Runnable()
  {
    public final void run()
    {
      if ((b.a(b.this) != null) && (b.this.b != null)) {
        b.this.b.a(b.b(b.this));
      }
    }
  };
  
  private b(Context paramContext)
  {
    super(paramContext);
    this.g = h.a(paramContext);
    this.b = a.a();
    com.tencent.beacon.a.a.b.a().a(this.m);
    this.e = new f(paramContext);
    this.g.a(l());
    this.f = new c(paramContext);
  }
  
  /* Error */
  public static g i()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 30	com/tencent/beacon/a/e/b:c	Lcom/tencent/beacon/a/e/b;
    //   6: ifnull +15 -> 21
    //   9: getstatic 30	com/tencent/beacon/a/e/b:c	Lcom/tencent/beacon/a/e/b;
    //   12: invokespecial 105	com/tencent/beacon/a/e/b:r	()Lcom/tencent/beacon/a/f/g;
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: aconst_null
    //   22: astore_0
    //   23: goto -7 -> 16
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	8	0	localg	g
    //   26	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	26	finally
  }
  
  public static b j(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null)) {
        c = new b(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  private g r()
  {
    try
    {
      g localg = this.g;
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.l)
    {
      this.h = paramInt;
      com.tencent.beacon.a.g.a.f("[strategy] current query step:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 3) {}
      synchronized (this.l)
      {
        this.j = true;
        return;
      }
    }
  }
  
  public final void a(a parama)
  {
    super.a(parama);
    this.b.j();
  }
  
  public final void b(int paramInt)
  {
    synchronized (this.l)
    {
      this.k = paramInt;
      return;
    }
  }
  
  public final void b(int paramInt, Map<String, String> paramMap)
  {
    Iterator localIterator = com.tencent.beacon.a.a.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.beacon.a.a)localIterator.next()).a(paramInt, paramMap);
    }
  }
  
  public final void b(Context paramContext)
  {
    super.b(paramContext);
    j();
  }
  
  public final void b(a parama)
  {
    Iterator localIterator = com.tencent.beacon.a.a.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.beacon.a.a locala = (com.tencent.beacon.a.a)localIterator.next();
      try
      {
        locala.a(parama);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.a.g.a.a(localThrowable);
        com.tencent.beacon.a.g.a.d("[strategy] error %s", new Object[] { localThrowable.toString() });
      }
    }
  }
  
  public final boolean g()
  {
    synchronized (this.l)
    {
      boolean bool = this.i;
      return bool;
    }
  }
  
  public final void h()
  {
    synchronized (this.l)
    {
      this.i = true;
      return;
    }
  }
  
  public final void j()
  {
    try
    {
      com.tencent.beacon.a.a.b.a().a(this.f);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final a k()
  {
    try
    {
      a locala = this.b;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final f l()
  {
    try
    {
      f localf = this.e;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean m()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void n()
  {
    try
    {
      this.d = true;
      com.tencent.beacon.a.g.a.f("[strategy] set isFirst: %b", new Object[] { Boolean.valueOf(true) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int o()
  {
    synchronized (this.l)
    {
      int n = this.h;
      return n;
    }
  }
  
  public final boolean p()
  {
    synchronized (this.l)
    {
      boolean bool = this.j;
      return bool;
    }
  }
  
  public final int q()
  {
    synchronized (this.l)
    {
      int n = this.k;
      return n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.e.b
 * JD-Core Version:    0.7.0.1
 */