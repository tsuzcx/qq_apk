package com.tencent.beacon.a.f;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.a.d.a.c;
import com.tencent.beacon.upload.UploadHandleListener;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
  implements g
{
  private static h a = null;
  private SparseArray<f> b = new SparseArray(5);
  private List<UploadHandleListener> c = new ArrayList(5);
  private ArrayList<i> d = new ArrayList(5);
  private Context e = null;
  private boolean f = true;
  private boolean g = true;
  
  private h(Context paramContext)
  {
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    if (localContext != null)
    {
      this.e = localContext;
      return;
    }
    this.e = paramContext;
  }
  
  private static c a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = com.tencent.beacon.a.e.a.a();
        if (localObject == null) {
          break label74;
        }
        int i = ((com.tencent.beacon.a.e.a)localObject).l();
        paramArrayOfByte = com.tencent.beacon.a.a.b(paramArrayOfByte, ((com.tencent.beacon.a.e.a)localObject).m(), i, ((com.tencent.beacon.a.e.a)localObject).o());
        if (paramArrayOfByte != null)
        {
          localObject = new com.tencent.beacon.a.h.d();
          ((com.tencent.beacon.a.h.d)localObject).a(paramArrayOfByte);
          paramArrayOfByte = (c)((com.tencent.beacon.a.h.d)localObject).b("detail", new c());
          return paramArrayOfByte;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        com.tencent.beacon.a.g.a.a(paramArrayOfByte);
      }
      return null;
      label74:
      paramArrayOfByte = null;
    }
  }
  
  public static h a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new h(paramContext);
        com.tencent.beacon.a.g.a.h("[net] create upload handler successfully.", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = d();
    if (arrayOfUploadHandleListener != null)
    {
      int j = arrayOfUploadHandleListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUploadHandleListener[i].onUploadEnd(paramInt1, paramInt2, paramLong1, paramLong2, paramBoolean, paramString);
        i += 1;
      }
    }
  }
  
  private void a(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3)
  {
    if ((paramInt1 != 0) && (paramLong1 != 0L))
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).a(paramInt1, paramBoolean, paramLong2, paramLong1, paramInt2, paramInt3, paramString1, paramString2, paramInt4, paramString3);
      }
    }
  }
  
  private boolean a(SparseArray<f> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramSparseArray == null) || (paramArrayOfByte == null)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      paramSparseArray = (f)paramSparseArray.get(paramInt);
      if (paramSparseArray == null)
      {
        com.tencent.beacon.a.g.a.c("[net] no handler key:%d", new Object[] { Integer.valueOf(paramInt) });
        return false;
      }
      break;
    case 103: 
      com.tencent.beacon.a.g.a.a("[net] process CMD_RESPONSE_GEN_QIMEI", new Object[0]);
      com.tencent.beacon.a.c.d.a(this.e).g().a(paramArrayOfByte);
      return true;
    }
    try
    {
      com.tencent.beacon.a.g.a.b("[net] key:%d  handler: %s", new Object[] { Integer.valueOf(paramInt), paramSparseArray.getClass().toString() });
      paramSparseArray.a(paramInt, paramArrayOfByte, true);
      return true;
    }
    catch (Throwable paramSparseArray)
    {
      com.tencent.beacon.a.g.a.a(paramSparseArray);
      com.tencent.beacon.a.g.a.d("[net] handle error key:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  private static byte[] b(a parama)
  {
    if (parama != null) {
      try
      {
        Object localObject1 = parama.a();
        if (localObject1 != null)
        {
          com.tencent.beacon.a.g.a.b("[net] RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", new Object[] { ((com.tencent.beacon.a.d.a.b)localObject1).b, ((com.tencent.beacon.a.d.a.b)localObject1).d, ((com.tencent.beacon.a.d.a.b)localObject1).c, Integer.valueOf(((com.tencent.beacon.a.d.a.b)localObject1).f) });
          Object localObject2 = new com.tencent.beacon.a.h.d();
          ((com.tencent.beacon.a.h.d)localObject2).a.b = 1;
          ((com.tencent.beacon.a.h.d)localObject2).a.c = "test";
          ((com.tencent.beacon.a.h.d)localObject2).a.d = "test";
          ((com.tencent.beacon.a.h.d)localObject2).a("detail", localObject1);
          localObject1 = ((com.tencent.beacon.a.h.d)localObject2).a();
          localObject2 = com.tencent.beacon.a.e.a.a();
          if (localObject2 != null)
          {
            int i = ((com.tencent.beacon.a.e.a)localObject2).l();
            localObject1 = com.tencent.beacon.a.a.a((byte[])localObject1, ((com.tencent.beacon.a.e.a)localObject2).m(), i, ((com.tencent.beacon.a.e.a)localObject2).o());
            return localObject1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.a.g.a.d("[event] parseSendData error", new Object[0]);
        com.tencent.beacon.a.g.a.a(localThrowable);
        parama.b();
      }
    }
    return null;
  }
  
  /* Error */
  private UploadHandleListener[] d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/beacon/a/f/h:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 43	com/tencent/beacon/a/f/h:c	Ljava/util/List;
    //   13: invokeinterface 241 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 43	com/tencent/beacon/a/f/h:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 115	com/tencent/beacon/upload/UploadHandleListener
    //   29: invokeinterface 245 2 0
    //   34: checkcast 247	[Lcom/tencent/beacon/upload/UploadHandleListener;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	h
    //   37	7	1	arrayOfUploadHandleListener	UploadHandleListener[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private e e()
  {
    try
    {
      e locale = e.a(this.e);
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private SparseArray<f> f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/beacon/a/f/h:b	Landroid/util/SparseArray;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 38	com/tencent/beacon/a/f/h:b	Landroid/util/SparseArray;
    //   13: invokevirtual 255	android/util/SparseArray:size	()I
    //   16: ifle +23 -> 39
    //   19: new 257	com/tencent/beacon/a/g/c
    //   22: dup
    //   23: invokespecial 258	com/tencent/beacon/a/g/c:<init>	()V
    //   26: pop
    //   27: aload_0
    //   28: getfield 38	com/tencent/beacon/a/f/h:b	Landroid/util/SparseArray;
    //   31: invokestatic 261	com/tencent/beacon/a/g/c:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	h
    //   34	7	1	localSparseArray	SparseArray
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	44	finally
  }
  
  public final void a(a parama)
  {
    int m = parama.c();
    if ((!a()) || (!b())) {
      if (m == 2)
      {
        com.tencent.beacon.a.g.a.h("[event] Not UpProc real event sync 2 DB done false", new Object[0]);
        parama.b(false);
      }
    }
    do
    {
      return;
      com.tencent.beacon.a.g.a.h("[event] NotUpProcess, don't upload, return!", new Object[0]);
      return;
      if (com.tencent.beacon.a.a.h(this.e)) {
        break;
      }
      com.tencent.beacon.a.g.a.c("[net] doUpload network is disabled!", new Object[0]);
    } while (m != 2);
    parama.b(false);
    return;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    int k = -1;
    Object localObject6 = parama.e();
    if ((localObject6 == null) || ("".equals(((String)localObject6).trim())))
    {
      com.tencent.beacon.a.g.a.d("[net] url error", new Object[0]);
      if (m == 2) {
        parama.b(false);
      }
      a(m, -1, 0L, 0L, false, "url error");
      return;
    }
    Object localObject7 = b(parama);
    if (localObject7 == null)
    {
      com.tencent.beacon.a.g.a.c("[event] sendData is null", new Object[0]);
      a(m, -1, 0L, 0L, false, "sendData error");
      return;
    }
    Object localObject8 = e();
    if (localObject8 == null)
    {
      com.tencent.beacon.a.g.a.d("[net] reqH is null.", new Object[0]);
      a(m, -1, 0L, 0L, false, "reqHandler error");
      return;
    }
    Object localObject4;
    Object localObject1;
    if (!((e)localObject8).a())
    {
      localObject4 = parama.d();
      localObject1 = null;
      if (localObject4 != null) {
        localObject1 = "?rid=" + (String)localObject4;
      }
      localObject5 = com.tencent.beacon.a.e.a.a();
      localObject4 = localObject1;
      if (localObject5 != null)
      {
        localObject5 = ((com.tencent.beacon.a.e.a)localObject5).p();
        localObject4 = localObject1;
        if (localObject5 != null)
        {
          localObject4 = localObject1;
          if (!"".equals(localObject5))
          {
            if (localObject1 != null) {
              break label1166;
            }
            localObject4 = "?sid=" + (String)localObject5;
          }
        }
      }
      if (localObject4 != null) {
        new StringBuilder().append((String)localObject6).append((String)localObject4);
      }
    }
    com.tencent.beacon.a.g.a.h("[net] start upload cmd: %d  url:%s  data type:%s", new Object[] { Integer.valueOf(m), localObject6, parama.getClass().getSimpleName() });
    Object localObject5 = com.tencent.beacon.a.c.e.h(this.e);
    d locald = new d();
    long l1 = (com.tencent.beacon.a.c.b.a(this.e).j() + new Date().getTime()) / 1000L;
    int j = k;
    boolean bool2 = bool4;
    boolean bool3 = bool5;
    for (;;)
    {
      try
      {
        if (!((e)localObject8).a()) {
          continue;
        }
        j = k;
        bool2 = bool4;
        bool3 = bool5;
        localObject4 = ((e)localObject8).a((String)localObject6, com.tencent.beacon.a.e.a.a().k(), (byte[])localObject7, parama, locald);
        localObject1 = localObject4;
        if (localObject4 != null)
        {
          j = k;
          bool2 = bool4;
          bool3 = bool5;
          localObject1 = new com.tencent.beacon.a.d.a.e();
          j = k;
          bool2 = bool4;
          bool3 = bool5;
          ((com.tencent.beacon.a.d.a.e)localObject1).a(new com.tencent.beacon.a.h.a((byte[])localObject4));
          j = k;
          bool2 = bool4;
          bool3 = bool5;
          com.tencent.beacon.a.g.a.b("[net] received body size:%d |statusCode:%d |header:%s |msg:%s", new Object[] { Integer.valueOf(((com.tencent.beacon.a.d.a.e)localObject1).c.length), Integer.valueOf(((com.tencent.beacon.a.d.a.e)localObject1).a), ((com.tencent.beacon.a.d.a.e)localObject1).b, ((com.tencent.beacon.a.d.a.e)localObject1).d });
          j = k;
          bool2 = bool4;
          bool3 = bool5;
          localObject6 = ((com.tencent.beacon.a.d.a.e)localObject1).b;
          j = k;
          bool2 = bool4;
          bool3 = bool5;
          if (((Map)localObject6).containsKey("session_id"))
          {
            j = k;
            bool2 = bool4;
            bool3 = bool5;
            if (((Map)localObject6).containsKey("max_time"))
            {
              j = k;
              bool2 = bool4;
              bool3 = bool5;
              localObject4 = (String)((Map)localObject6).get("session_id");
              j = k;
              bool2 = bool4;
              bool3 = bool5;
              localObject6 = (String)((Map)localObject6).get("max_time");
              j = k;
              bool2 = bool4;
              bool3 = bool5;
              com.tencent.beacon.a.e.a.a().a(this.e, (String)localObject4, (String)localObject6);
            }
          }
          j = k;
          bool2 = bool4;
          bool3 = bool5;
          localObject1 = ((com.tencent.beacon.a.d.a.e)localObject1).c;
        }
        j = k;
        bool2 = bool4;
        bool3 = bool5;
        l2 = locald.a();
        j = k;
        bool2 = bool4;
        bool3 = bool5;
        l3 = locald.b();
        j = k;
        bool2 = bool4;
        bool3 = bool5;
        localObject1 = a((byte[])localObject1);
        i = k;
        if (localObject1 != null)
        {
          j = k;
          bool2 = bool4;
          bool3 = bool5;
          i = ((c)localObject1).b;
          j = i;
          bool2 = bool4;
          bool3 = bool5;
          if (((c)localObject1).a != 0) {
            break label1949;
          }
          bool1 = true;
          break label1946;
        }
        if (localObject1 != null)
        {
          j = i;
          bool2 = bool1;
          bool3 = bool1;
          localObject4 = com.tencent.beacon.a.c.b.a(this.e);
          if (localObject4 != null)
          {
            j = i;
            bool2 = bool1;
            bool3 = bool1;
            if (((c)localObject1).d != null)
            {
              j = i;
              bool2 = bool1;
              bool3 = bool1;
              ((com.tencent.beacon.a.c.b)localObject4).a(((c)localObject1).d.trim());
            }
            j = i;
            bool2 = bool1;
            bool3 = bool1;
            localObject6 = new Date();
            j = i;
            bool2 = bool1;
            bool3 = bool1;
            ((com.tencent.beacon.a.c.b)localObject4).a(((c)localObject1).e - ((Date)localObject6).getTime());
            j = i;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.beacon.a.g.a.h("[net] fix ip:%s  tmgap: %d", new Object[] { ((com.tencent.beacon.a.c.b)localObject4).i(), Long.valueOf(((com.tencent.beacon.a.c.b)localObject4).j()) });
          }
          j = i;
          bool2 = bool1;
          bool3 = bool1;
          localObject4 = ((c)localObject1).c;
          if (localObject4 != null) {
            continue;
          }
          j = i;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.beacon.a.g.a.h("[net] no response! ", new Object[0]);
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          label1113:
          long l2 = locald.a();
          label1166:
          long l3 = locald.b();
          localObject4 = localThrowable.toString().replace("java.lang.Exception: ", "");
          a(m, j, l2, l3, false, (String)localObject4);
          a(m, l2, false, l1, (int)locald.d(), parama.f(), (String)localObject5, locald.e(), locald.c(), (String)localObject4);
          if ((com.tencent.beacon.a.e.a.a().h()) && ((localThrowable instanceof ConnectException))) {
            com.tencent.beacon.a.e.a.a().i();
          }
          com.tencent.beacon.a.g.a.d("[net] req error  %s", new Object[] { localThrowable.toString() });
          return;
        }
        finally
        {
          int i;
          bool3 = bool2;
          continue;
        }
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        k = parama.c();
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        n = localThrowable.b;
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        if ((localThrowable.a != 0) || (k <= 0) || (k > 5)) {
          continue;
        }
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        localObject7 = com.tencent.beacon.a.c.d.a(this.e).g();
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        localObject8 = ((com.tencent.beacon.a.c.f)localObject7).a();
        if (localObject8 == null) {
          break label1955;
        }
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        if (!((String)localObject8).equals("")) {
          break label1693;
        }
        break label1955;
        if (j == 0) {
          continue;
        }
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        ((com.tencent.beacon.a.c.f)localObject7).a_();
        if (n != 0) {
          break label1698;
        }
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        com.tencent.beacon.a.g.a.h("[net] response with no data", new Object[0]);
        continue;
      }
      finally
      {
        parama.b(bool3);
      }
      j = i;
      bool2 = bool1;
      bool3 = bool1;
      a(m, i, l2, l3, bool1, null);
      if (localObject1 == null) {
        break label1929;
      }
      j = i;
      bool2 = bool1;
      bool3 = bool1;
      localObject1 = String.valueOf(((c)localObject1).a);
      j = i;
      bool2 = bool1;
      bool3 = bool1;
      a(m, l2, bool1, l1, (int)locald.d(), parama.f(), (String)localObject5, locald.e(), locald.c(), (String)localObject1);
      parama.b(bool1);
      return;
      localObject4 = (String)localObject1 + "&sid=" + (String)localObject5;
      break;
      j = k;
      bool2 = bool4;
      bool3 = bool5;
      localObject4 = ((e)localObject8).a((String)localObject6, (byte[])localObject7, parama, locald);
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        localObject1 = localObject4;
        j = k;
        bool2 = bool4;
        bool3 = bool5;
        if (parama.c() == 100)
        {
          localObject1 = localObject4;
          j = k;
          bool2 = bool4;
          bool3 = bool5;
          if (!"http://strategy.beacon.qq.com/analytics/upload".equals(localObject6))
          {
            j = k;
            bool2 = bool4;
            bool3 = bool5;
            localObject1 = ((e)localObject8).a("http://strategy.beacon.qq.com/analytics/upload", (byte[])localObject7, parama, locald);
            continue;
            j = i;
            bool2 = bool1;
            bool3 = bool1;
            localObject6 = f();
            if (localObject6 != null)
            {
              j = i;
              bool2 = bool1;
              bool3 = bool1;
              if (((SparseArray)localObject6).size() > 0) {
                continue;
              }
            }
            j = i;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.beacon.a.g.a.h("[net] no handler! ", new Object[0]);
          }
        }
      }
    }
    for (;;)
    {
      int n;
      label1693:
      j = 0;
      continue;
      switch (k)
      {
      default: 
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        com.tencent.beacon.a.g.a.c("[net] unknown req: %d ", new Object[] { Integer.valueOf(k) });
        break;
      case 100: 
        if (n != 101)
        {
          j = i;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.beacon.a.g.a.c("[net] UNMATCH req: %d , rep: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
        }
        break;
      case 4: 
        if (n != 105)
        {
          j = i;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.beacon.a.g.a.c("[net] UNMATCH req: %d , rep: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
        }
        break;
      case 102: 
        label1698:
        if (n != 103)
        {
          j = i;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.beacon.a.g.a.c("[net] UNMATCH req: %d  , rep: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
          break;
        }
        j = i;
        bool2 = bool1;
        bool3 = bool1;
        a((SparseArray)localObject6, n, (byte[])localObject4);
        break;
        label1929:
        String str = "response null";
        break label1113;
        for (;;)
        {
          label1946:
          break;
          label1949:
          bool1 = false;
        }
        label1955:
        j = 1;
      }
    }
  }
  
  public final void a(i parami)
  {
    this.d.add(parami);
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a(f paramf)
  {
    boolean bool;
    if (paramf == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.b.append(101, paramf);
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean a(UploadHandleListener paramUploadHandleListener)
  {
    boolean bool;
    if (paramUploadHandleListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (!this.c.contains(paramUploadHandleListener)) {
          this.c.add(paramUploadHandleListener);
        }
        bool = true;
      }
      finally {}
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      this.g = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/beacon/a/f/h:e	Landroid/content/Context;
    //   6: invokestatic 506	com/tencent/beacon/a/a:g	(Landroid/content/Context;)Z
    //   9: ifne +12 -> 21
    //   12: aload_0
    //   13: getfield 51	com/tencent/beacon/a/f/h:g	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	h
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public final ArrayList<i> c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.f.h
 * JD-Core Version:    0.7.0.1
 */