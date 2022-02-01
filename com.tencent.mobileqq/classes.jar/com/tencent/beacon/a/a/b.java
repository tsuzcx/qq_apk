package com.tencent.beacon.a.a;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  private static volatile b a;
  private final SparseArray<List<d>> b = new SparseArray();
  private final Object c = new Object();
  private final SparseArray<List<c>> d = new SparseArray();
  private final SparseArray<Object> e = new SparseArray();
  private AtomicBoolean f = new AtomicBoolean(false);
  
  public static b a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new b();
        }
      }
      finally {}
    }
    return a;
  }
  
  private Object a(int paramInt)
  {
    synchronized (this.c)
    {
      Object localObject3 = this.e.get(paramInt);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new Object();
        this.e.put(paramInt, localObject1);
      }
      return localObject1;
    }
  }
  
  private List<d> b(int paramInt)
  {
    List localList = (List)this.b.get(paramInt);
    if ((localList != null) && (!localList.isEmpty())) {
      return localList;
    }
    return null;
  }
  
  private void c(c paramc)
  {
    d(paramc);
    synchronized (a(paramc.a))
    {
      Object localObject2 = b(paramc.a);
      if (localObject2 == null) {
        return;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        d locald = (d)((Iterator)localObject2).next();
        try
        {
          locald.onEvent(paramc);
        }
        catch (Throwable localThrowable)
        {
          com.tencent.beacon.base.util.c.a(localThrowable);
        }
        if (this.f.compareAndSet(false, true))
        {
          com.tencent.beacon.a.b.d locald1 = com.tencent.beacon.a.b.d.b();
          locald1.a("512", "dispatchEvent error", localThrowable);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramc;
    }
  }
  
  private void d(c paramc) {}
  
  public void a(int paramInt, d paramd)
  {
    synchronized (a(paramInt))
    {
      Object localObject2 = (List)this.b.get(paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        this.b.put(paramInt, localObject1);
      }
      if (((List)localObject1).contains(paramd)) {
        return;
      }
      ((List)localObject1).add(paramd);
      localObject1 = (List)this.d.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c)((Iterator)localObject1).next();
          try
          {
            paramd.onEvent((c)localObject2);
          }
          catch (Throwable localThrowable)
          {
            com.tencent.beacon.base.util.c.a(localThrowable);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramd;
    }
  }
  
  public void a(@NonNull c paramc)
  {
    com.tencent.beacon.a.b.a.a().a(new a(this, paramc));
  }
  
  public void b(@NonNull c paramc)
  {
    synchronized (a(paramc.a))
    {
      c localc = new c(paramc.a, paramc.b);
      List localList = (List)this.d.get(localc.a);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new ArrayList();
        this.d.put(localc.a, localObject1);
      }
      ((List)localObject1).add(localc);
      c(paramc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.a.b
 * JD-Core Version:    0.7.0.1
 */