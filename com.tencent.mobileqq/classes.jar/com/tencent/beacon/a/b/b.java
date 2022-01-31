package com.tencent.beacon.a.b;

import android.content.Context;
import com.tencent.beacon.a.h.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends com.tencent.beacon.a.f.a
{
  private static a k = new a((byte)0);
  private Context f = null;
  private Long[] g = null;
  private List<Long> h = null;
  private byte[] i = null;
  private boolean j = false;
  
  public b(Context paramContext)
  {
    super(paramContext, 1, 4);
    this.f = paramContext;
  }
  
  private boolean g()
  {
    try
    {
      boolean bool = this.j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.beacon.a.d.a.b a()
  {
    Object localObject9 = null;
    Object localObject7;
    Object localObject8;
    label146:
    int n;
    label198:
    Object localObject4;
    for (;;)
    {
      try
      {
        Object localObject1 = j.j(this.c);
        if ((localObject1 == null) || (!((j)localObject1).h()))
        {
          com.tencent.beacon.a.g.a.d("[event] module null!", new Object[0]);
          localObject1 = localObject9;
          return localObject1;
        }
        localObject7 = d.a();
        if (localObject7 == null)
        {
          com.tencent.beacon.a.g.a.d("[event] strategy null!", new Object[0]);
          localObject1 = localObject9;
        }
        else
        {
          try
          {
            if (!g()) {
              break label608;
            }
            localObject8 = com.tencent.beacon.a.a.a.a.a(this.f);
            if ((localObject8 == null) || (((List)localObject8).size() <= 0)) {
              break label608;
            }
            Object localObject3 = (byte[])((List)localObject8).get(3);
            this.d = String.valueOf(((List)localObject8).get(1));
            this.e = ((Integer)((List)localObject8).get(4)).intValue();
            if (localObject3 != null)
            {
              localObject3 = a(this.a, (byte[])localObject3);
            }
            else
            {
              n = ((d)localObject7).f();
              m = n;
              if (!com.tencent.beacon.a.a.g(this.f)) {
                m = n / 2;
              }
              if (m < 0) {
                break label602;
              }
              localObject7 = com.tencent.beacon.a.a.a(this.f, m);
              if ((localObject7 != null) && (((List)localObject7).size() > 0)) {
                break;
              }
              com.tencent.beacon.a.g.a.h("[event] No event need upload.", new Object[0]);
              localObject3 = localObject9;
            }
          }
          catch (Throwable localThrowable)
          {
            com.tencent.beacon.a.g.a.a(localThrowable);
            com.tencent.beacon.a.g.a.d("[event] get req data error: %s", new Object[] { localThrowable.toString() });
            localObject4 = localObject9;
          }
        }
      }
      finally {}
    }
    int m = ((List)localObject7).size();
    com.tencent.beacon.a.g.a.h("[event] %d events need upload.", new Object[] { Integer.valueOf(m) });
    this.e = m;
    if (localObject7 != null) {}
    for (;;)
    {
      try
      {
        n = ((List)localObject7).size();
        if (n > 0) {
          continue;
        }
        localObject4 = null;
        label303:
        localObject8 = localObject4;
      }
      catch (Exception localException1)
      {
        label382:
        Long[] arrayOfLong;
        b();
        localObject8 = null;
        continue;
      }
      this.g = new Long[m];
      m = 0;
      if (m < this.g.length)
      {
        this.g[m] = Long.valueOf(((g)((List)localObject7).get(m)).a());
        m += 1;
        continue;
        this.h = new ArrayList();
        if (k == null) {
          break label597;
        }
        localObject4 = a.a((List)localObject7, this.h);
        if (this.h.size() <= 0) {
          break label613;
        }
        localObject8 = this.f;
        arrayOfLong = (Long[])this.h.toArray(new Long[this.h.size()]);
        if (localObject8 == null) {
          com.tencent.beacon.a.g.a.d("[db] have null args!", new Object[0]);
        } else {
          com.tencent.beacon.a.a.a.a.a((Context)localObject8, arrayOfLong);
        }
      }
      label597:
      label602:
      label608:
      label613:
      while (localObject6 != null)
      {
        for (;;)
        {
          localObject8 = new HashMap();
          if (localException1 != null) {
            ((Map)localObject8).put(Integer.valueOf(1), localException1);
          }
          Object localObject5 = new com.tencent.beacon.a.d.a.a();
          ((com.tencent.beacon.a.d.a.a)localObject5).a = ((Map)localObject8);
          break label303;
          ((List)localObject7).clear();
          localObject5 = localObject9;
          if (localObject8 == null) {
            break;
          }
          localObject5 = new com.tencent.beacon.a.h.b();
          ((c)localObject8).a((com.tencent.beacon.a.h.b)localObject5);
          localObject5 = ((com.tencent.beacon.a.h.b)localObject5).b();
          this.i = new byte[localObject5.length];
          System.arraycopy(localObject5, 0, this.i, 0, localObject5.length);
          this.d = com.tencent.beacon.a.a.b(this.c, 4);
          try
          {
            localObject5 = a(this.a, (byte[])localObject5);
          }
          catch (Exception localException2)
          {
            b();
            localObject6 = localObject9;
          }
        }
        break;
        localObject6 = null;
        break label382;
        localObject7 = null;
        break label198;
        localObject6 = null;
        break label146;
      }
      Object localObject6 = null;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.j = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 216
    //   4: iconst_0
    //   5: anewarray 63	java/lang/Object
    //   8: invokestatic 218	com/tencent/beacon/a/g/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield 37	com/tencent/beacon/a/b/b:g	[Ljava/lang/Long;
    //   15: ifnull +39 -> 54
    //   18: aload_0
    //   19: getfield 37	com/tencent/beacon/a/b/b:g	[Ljava/lang/Long;
    //   22: arraylength
    //   23: ifle +31 -> 54
    //   26: aload_0
    //   27: getfield 35	com/tencent/beacon/a/b/b:f	Landroid/content/Context;
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 37	com/tencent/beacon/a/b/b:g	[Ljava/lang/Long;
    //   35: astore_2
    //   36: aload_1
    //   37: ifnonnull +20 -> 57
    //   40: ldc 169
    //   42: iconst_0
    //   43: anewarray 63	java/lang/Object
    //   46: invokestatic 69	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 37	com/tencent/beacon/a/b/b:g	[Ljava/lang/Long;
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_1
    //   58: aload_2
    //   59: invokestatic 172	com/tencent/beacon/a/a/a/a:a	(Landroid/content/Context;[Ljava/lang/Long;)I
    //   62: pop
    //   63: goto -14 -> 49
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	b
    //   30	28	1	localContext	Context
    //   66	4	1	localObject	Object
    //   35	24	2	arrayOfLong	Long[]
    // Exception table:
    //   from	to	target	type
    //   2	36	66	finally
    //   40	49	66	finally
    //   49	54	66	finally
    //   57	63	66	finally
  }
  
  public final void b(boolean paramBoolean)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        if (this.g != null) {
          m = this.g.length;
        }
        Context localContext;
        Long[] arrayOfLong;
        if (m > 0)
        {
          localContext = this.f;
          arrayOfLong = this.g;
          if (localContext == null) {
            com.tencent.beacon.a.g.a.d("[db] have null args!", new Object[0]);
          }
        }
        else
        {
          this.g = null;
          if ((!paramBoolean) || (!g())) {
            break label96;
          }
          com.tencent.beacon.a.a.a.a.a(this.f, this.d);
          this.i = null;
          return;
        }
        com.tencent.beacon.a.a.a.a.a(localContext, arrayOfLong);
        continue;
        if (paramBoolean) {
          continue;
        }
      }
      finally {}
      label96:
      if (this.i != null) {
        com.tencent.beacon.a.a.a.a.a(this.f, this.i, this.d, m);
      }
    }
  }
  
  public static final class a
  {
    public static byte[] a(List<g> paramList, List<Long> paramList1)
    {
      if ((paramList == null) || (paramList.size() <= 0)) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int j = paramList.size();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          try
          {
            localg = (g)paramList.get(i);
            if ((localg.e() == null) || (!"UA".equals(localg.b()))) {
              break label187;
            }
            com.tencent.beacon.a.g.a.f("[event] pack eName: %s", new Object[] { localg.d() });
            locala = com.tencent.beacon.a.a.a(localg);
            if (locala != null) {
              localArrayList.add(locala);
            } else {
              paramList1.add(Long.valueOf(localg.a()));
            }
          }
          catch (Throwable paramList)
          {
            com.tencent.beacon.a.g.a.d("[event] encode2MixPackage error.", new Object[0]);
            com.tencent.beacon.a.g.a.a(paramList);
          }
        }
        else
        {
          while (localArrayList.size() <= 0)
          {
            g localg;
            com.tencent.beacon.a.d.b.a locala;
            return null;
          }
          paramList = new com.tencent.beacon.a.d.b.b();
          paramList.a = localArrayList;
          paramList1 = new com.tencent.beacon.a.h.b();
          paramList.a(paramList1);
          paramList = paramList1.b();
          return paramList;
        }
        label187:
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.b
 * JD-Core Version:    0.7.0.1
 */