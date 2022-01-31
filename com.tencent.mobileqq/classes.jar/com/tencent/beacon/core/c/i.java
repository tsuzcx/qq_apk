package com.tencent.beacon.core.c;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.protocol.common.ResponsePackage;
import com.tencent.beacon.core.protocol.common.SocketResponsePackage;
import com.tencent.beacon.core.wup.c;
import com.tencent.beacon.upload.UploadHandleListener;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i
  implements h
{
  private static i a = null;
  private SparseArray<g> b = new SparseArray(5);
  private List<UploadHandleListener> c = new ArrayList(5);
  private ArrayList<j> d = new ArrayList(5);
  private Context e = null;
  private boolean f = true;
  private boolean g = true;
  
  private i(Context paramContext)
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
  
  public static i a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new i(paramContext);
        com.tencent.beacon.core.d.b.h("[net] create upload handler successfully.", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static ResponsePackage a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = com.tencent.beacon.core.strategy.a.a();
        if (localObject == null) {
          break label74;
        }
        int i = ((com.tencent.beacon.core.strategy.a)localObject).l();
        paramArrayOfByte = com.tencent.beacon.core.d.i.b(paramArrayOfByte, ((com.tencent.beacon.core.strategy.a)localObject).m(), i, ((com.tencent.beacon.core.strategy.a)localObject).o());
        if (paramArrayOfByte != null)
        {
          localObject = new c();
          ((c)localObject).a(paramArrayOfByte);
          paramArrayOfByte = (ResponsePackage)((c)localObject).b("detail", new ResponsePackage());
          return paramArrayOfByte;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        com.tencent.beacon.core.d.b.a(paramArrayOfByte);
      }
      return null;
      label74:
      paramArrayOfByte = null;
    }
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
        ((j)localIterator.next()).record(paramInt1, paramBoolean, paramLong2, paramLong1, paramInt2, paramInt3, paramString1, paramString2, paramInt4, paramString3);
      }
    }
  }
  
  private static boolean a(SparseArray<g> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramSparseArray == null) || (paramArrayOfByte == null)) {
      return true;
    }
    paramSparseArray = (g)paramSparseArray.get(paramInt);
    if (paramSparseArray == null)
    {
      com.tencent.beacon.core.d.b.c("[net] no handler key:%d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    try
    {
      com.tencent.beacon.core.d.b.b("[net] key:%d  handler: %s", new Object[] { Integer.valueOf(paramInt), paramSparseArray.getClass().toString() });
      paramSparseArray.a(paramInt, paramArrayOfByte, true);
      return true;
    }
    catch (Throwable paramSparseArray)
    {
      com.tencent.beacon.core.d.b.a(paramSparseArray);
      com.tencent.beacon.core.d.b.d("[net] handle error key:%d", new Object[] { Integer.valueOf(paramInt) });
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
          com.tencent.beacon.core.d.b.b("[net] RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", new Object[] { ((RequestPackage)localObject1).appkey, ((RequestPackage)localObject1).sdkId, ((RequestPackage)localObject1).appVersion, Integer.valueOf(((RequestPackage)localObject1).cmd) });
          Object localObject2 = new c();
          ((c)localObject2).a.iRequestId = 1;
          ((c)localObject2).a.sServantName = "test";
          ((c)localObject2).a.sFuncName = "test";
          ((c)localObject2).a("detail", localObject1);
          localObject1 = ((c)localObject2).a();
          com.tencent.beacon.core.d.b.b("[event] reqPackage to wup byte size: %d", new Object[] { Integer.valueOf(localObject1.length) });
          localObject2 = com.tencent.beacon.core.strategy.a.a();
          if (localObject2 != null)
          {
            int i = ((com.tencent.beacon.core.strategy.a)localObject2).l();
            localObject1 = com.tencent.beacon.core.d.i.a((byte[])localObject1, ((com.tencent.beacon.core.strategy.a)localObject2).m(), i, ((com.tencent.beacon.core.strategy.a)localObject2).o());
            com.tencent.beacon.core.d.b.b("[event] wup through zip->encry byte size: %d", new Object[] { Integer.valueOf(localObject1.length) });
            return localObject1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.core.d.b.d("[event] parseSendData error", new Object[0]);
        com.tencent.beacon.core.d.b.a(localThrowable);
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
    //   3: getfield 43	com/tencent/beacon/core/c/i:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 43	com/tencent/beacon/core/c/i:c	Ljava/util/List;
    //   13: invokeinterface 240 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 43	com/tencent/beacon/core/c/i:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 115	com/tencent/beacon/upload/UploadHandleListener
    //   29: invokeinterface 244 2 0
    //   34: checkcast 246	[Lcom/tencent/beacon/upload/UploadHandleListener;
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
    //   0	52	0	this	i
    //   37	7	1	arrayOfUploadHandleListener	UploadHandleListener[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private f e()
  {
    try
    {
      f localf = f.a(this.e);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private SparseArray<g> f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/beacon/core/c/i:b	Landroid/util/SparseArray;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 38	com/tencent/beacon/core/c/i:b	Landroid/util/SparseArray;
    //   13: invokevirtual 254	android/util/SparseArray:size	()I
    //   16: ifle +23 -> 39
    //   19: new 256	com/tencent/beacon/core/d/g
    //   22: dup
    //   23: invokespecial 257	com/tencent/beacon/core/d/g:<init>	()V
    //   26: pop
    //   27: aload_0
    //   28: getfield 38	com/tencent/beacon/core/c/i:b	Landroid/util/SparseArray;
    //   31: invokestatic 260	com/tencent/beacon/core/d/g:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
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
    //   0	49	0	this	i
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
        com.tencent.beacon.core.d.b.h("[event] Not UpProc real event sync 2 DB done false", new Object[0]);
        parama.b(false);
      }
    }
    do
    {
      return;
      com.tencent.beacon.core.d.b.h("[event] NotUpProcess, don't upload, return!", new Object[0]);
      return;
      if (com.tencent.beacon.core.d.d.b(this.e)) {
        break;
      }
      com.tencent.beacon.core.d.b.c("[net] doUpload network is disabled or qimei is empty", new Object[0]);
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
      com.tencent.beacon.core.d.b.d("[net] url error", new Object[0]);
      if (m == 2) {
        parama.b(false);
      }
      a(m, -1, 0L, 0L, false, "url error");
      return;
    }
    byte[] arrayOfByte = b(parama);
    if (arrayOfByte == null)
    {
      com.tencent.beacon.core.d.b.c("[event] sendData is null", new Object[0]);
      a(m, -1, 0L, 0L, false, "sendData error");
      return;
    }
    f localf = e();
    if (localf == null)
    {
      com.tencent.beacon.core.d.b.d("[net] reqH is null.", new Object[0]);
      a(m, -1, 0L, 0L, false, "reqHandler error");
      return;
    }
    Object localObject5;
    Object localObject1;
    Object localObject7;
    label366:
    label370:
    d locald;
    long l1;
    int i;
    boolean bool2;
    boolean bool3;
    if (!localf.a())
    {
      localObject5 = parama.d();
      localObject1 = null;
      if (localObject5 != null) {
        localObject1 = "?rid=" + (String)localObject5;
      }
      localObject7 = com.tencent.beacon.core.strategy.a.a();
      localObject5 = localObject1;
      if (localObject7 != null)
      {
        localObject7 = ((com.tencent.beacon.core.strategy.a)localObject7).p();
        localObject5 = localObject1;
        if (localObject7 != null)
        {
          localObject5 = localObject1;
          if (!"".equals(localObject7))
          {
            if (localObject1 != null) {
              break label1205;
            }
            localObject5 = "?sid=" + (String)localObject7;
          }
        }
      }
      if (localObject5 != null)
      {
        localObject1 = (String)localObject6 + (String)localObject5;
        localObject5 = localObject1;
        com.tencent.beacon.core.d.b.h("[net] start upload cmd: %d  url:%s  data type:%s", new Object[] { Integer.valueOf(m), localObject5, parama.getClass().getSimpleName() });
        localObject7 = com.tencent.beacon.core.b.d.i(this.e);
        locald = new d();
        l1 = com.tencent.beacon.core.d.i.a(com.tencent.beacon.core.b.b.a(this.e).i()) / 1000L;
        i = k;
        bool2 = bool4;
        bool3 = bool5;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        if (!localf.a()) {
          continue;
        }
        i = k;
        bool2 = bool4;
        bool3 = bool5;
        localObject5 = localf.a((String)localObject5, com.tencent.beacon.core.strategy.a.a().k(), arrayOfByte, parama, locald);
        localObject1 = localObject5;
        if (localObject5 != null)
        {
          i = k;
          bool2 = bool4;
          bool3 = bool5;
          localObject1 = new SocketResponsePackage();
          i = k;
          bool2 = bool4;
          bool3 = bool5;
          ((SocketResponsePackage)localObject1).readFrom(new com.tencent.beacon.core.wup.a((byte[])localObject5));
          i = k;
          bool2 = bool4;
          bool3 = bool5;
          com.tencent.beacon.core.d.b.b("[net] received body size:%d |statusCode:%d |header:%s |msg:%s", new Object[] { Integer.valueOf(((SocketResponsePackage)localObject1).body.length), Integer.valueOf(((SocketResponsePackage)localObject1).statusCode), ((SocketResponsePackage)localObject1).header, ((SocketResponsePackage)localObject1).msg });
          i = k;
          bool2 = bool4;
          bool3 = bool5;
          localObject6 = ((SocketResponsePackage)localObject1).header;
          i = k;
          bool2 = bool4;
          bool3 = bool5;
          if (((Map)localObject6).containsKey("session_id"))
          {
            i = k;
            bool2 = bool4;
            bool3 = bool5;
            if (((Map)localObject6).containsKey("max_time"))
            {
              i = k;
              bool2 = bool4;
              bool3 = bool5;
              localObject5 = (String)((Map)localObject6).get("session_id");
              i = k;
              bool2 = bool4;
              bool3 = bool5;
              localObject6 = (String)((Map)localObject6).get("max_time");
              i = k;
              bool2 = bool4;
              bool3 = bool5;
              com.tencent.beacon.core.strategy.a.a().a(this.e, (String)localObject5, (String)localObject6);
            }
          }
          i = k;
          bool2 = bool4;
          bool3 = bool5;
          localObject1 = ((SocketResponsePackage)localObject1).body;
        }
        i = k;
        bool2 = bool4;
        bool3 = bool5;
        l2 = locald.b();
        i = k;
        bool2 = bool4;
        bool3 = bool5;
        l3 = locald.c();
        i = k;
        bool2 = bool4;
        bool3 = bool5;
        localObject1 = a((byte[])localObject1);
        j = k;
        if (localObject1 != null)
        {
          i = k;
          bool2 = bool4;
          bool3 = bool5;
          j = ((ResponsePackage)localObject1).cmd;
          i = j;
          bool2 = bool4;
          bool3 = bool5;
          if (((ResponsePackage)localObject1).result != 0) {
            break label1871;
          }
          bool1 = true;
          i = j;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.beacon.core.d.b.b("[net] response cmd:%d result:%d", new Object[] { Integer.valueOf(((ResponsePackage)localObject1).cmd), Byte.valueOf(((ResponsePackage)localObject1).result) });
        }
        if (localObject1 != null)
        {
          i = j;
          bool2 = bool1;
          bool3 = bool1;
          localObject5 = com.tencent.beacon.core.b.b.a(this.e);
          if (localObject5 != null)
          {
            i = j;
            bool2 = bool1;
            bool3 = bool1;
            if (((ResponsePackage)localObject1).srcGatewayIp != null)
            {
              i = j;
              bool2 = bool1;
              bool3 = bool1;
              ((com.tencent.beacon.core.b.b)localObject5).c(((ResponsePackage)localObject1).srcGatewayIp.trim());
            }
            i = j;
            bool2 = bool1;
            bool3 = bool1;
            localObject6 = new Date();
            i = j;
            bool2 = bool1;
            bool3 = bool1;
            ((com.tencent.beacon.core.b.b)localObject5).a(((ResponsePackage)localObject1).serverTime - ((Date)localObject6).getTime());
            i = j;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.beacon.core.d.b.h("[net] fix ip:%s  tmgap: %d", new Object[] { ((com.tencent.beacon.core.b.b)localObject5).h(), Long.valueOf(((com.tencent.beacon.core.b.b)localObject5).i()) });
          }
          i = j;
          bool2 = bool1;
          bool3 = bool1;
          localObject5 = ((ResponsePackage)localObject1).sBuffer;
          if (localObject5 != null) {
            continue;
          }
          i = j;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.beacon.core.d.b.h("[net] no response! ", new Object[0]);
        }
      }
      catch (Throwable localThrowable)
      {
        long l2;
        long l3;
        localThrowable = localThrowable;
        try
        {
          l2 = locald.b();
          l3 = locald.c();
          localObject5 = localThrowable.toString().replace("java.lang.Exception: ", "");
          a(m, i, l2, l3, false, (String)localObject5);
          a(m, l2, false, l1, (int)locald.e(), parama.f(), (String)localObject7, locald.f(), locald.d(), (String)localObject5);
          if ((com.tencent.beacon.core.strategy.a.a().h()) && ((localThrowable instanceof ConnectException))) {
            com.tencent.beacon.core.strategy.a.a().i();
          }
          com.tencent.beacon.core.d.b.d("[net] req error  %s", new Object[] { localThrowable.toString() });
          parama.b(bool2);
          return;
        }
        finally
        {
          for (;;)
          {
            int n;
            String str;
            bool3 = bool2;
          }
        }
        i = j;
        bool2 = bool1;
        bool3 = bool1;
        k = parama.c();
        i = j;
        bool2 = bool1;
        bool3 = bool1;
        n = localThrowable.cmd;
        if (n != 0) {
          break label1612;
        }
        i = j;
        bool2 = bool1;
        bool3 = bool1;
        com.tencent.beacon.core.d.b.h("[net] response with no data", new Object[0]);
        continue;
      }
      finally {}
      i = j;
      bool2 = bool1;
      bool3 = bool1;
      a(m, j, l2, l3, bool1, null);
      if (localObject1 != null)
      {
        i = j;
        bool2 = bool1;
        bool3 = bool1;
        localObject1 = String.valueOf(((ResponsePackage)localObject1).result);
        i = j;
        bool2 = bool1;
        bool3 = bool1;
        a(m, l2, bool1, l1, (int)locald.e(), parama.f(), (String)localObject7, locald.f(), locald.d(), (String)localObject1);
        parama.b(bool1);
        return;
        label1205:
        localObject5 = (String)localObject1 + "&sid=" + (String)localObject7;
        break;
        i = k;
        bool2 = bool4;
        bool3 = bool5;
        localObject6 = localf.a((String)localObject5, arrayOfByte, parama, locald);
        localObject1 = localObject6;
        if (localObject6 != null) {
          continue;
        }
        localObject1 = localObject6;
        i = k;
        bool2 = bool4;
        bool3 = bool5;
        if (parama.c() != 100) {
          continue;
        }
        localObject1 = localObject6;
        i = k;
        bool2 = bool4;
        bool3 = bool5;
        if ("http://strategy.beacon.qq.com/analytics/upload".equals(localObject5)) {
          continue;
        }
        i = k;
        bool2 = bool4;
        bool3 = bool5;
        localObject1 = localf.a("http://strategy.beacon.qq.com/analytics/upload", arrayOfByte, parama, locald);
        continue;
        i = j;
        bool2 = bool1;
        bool3 = bool1;
        localObject6 = f();
        if (localObject6 != null)
        {
          i = j;
          bool2 = bool1;
          bool3 = bool1;
          if (((SparseArray)localObject6).size() > 0) {}
        }
        else
        {
          i = j;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.beacon.core.d.b.h("[net] no handler! ", new Object[0]);
          continue;
        }
        parama.b(bool3);
        throw localObject2;
        switch (k)
        {
        default: 
          i = j;
          bool2 = bool1;
          bool3 = bool1;
          com.tencent.beacon.core.d.b.c("[net] unknown req: %d ", new Object[] { Integer.valueOf(k) });
          break;
        case 100: 
          if (n != 101)
          {
            i = j;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.beacon.core.d.b.c("[net] UNMATCH req: %d , rep: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
          }
          break;
        case 4: 
          if (n != 105)
          {
            i = j;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.beacon.core.d.b.c("[net] UNMATCH req: %d , rep: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
          }
          break;
        case 102: 
          label1612:
          if (n != 103)
          {
            i = j;
            bool2 = bool1;
            bool3 = bool1;
            com.tencent.beacon.core.d.b.c("[net] UNMATCH req: %d  , rep: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            continue;
          }
          i = j;
          bool2 = bool1;
          bool3 = bool1;
          a((SparseArray)localObject6, n, (byte[])localObject5);
          break;
        }
      }
      str = "response null";
      continue;
      Object localObject4 = localObject6;
      break label366;
      localObject5 = localObject6;
      break label370;
      label1871:
      bool1 = false;
    }
  }
  
  public final void a(j paramj)
  {
    this.d.add(paramj);
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
  
  public final boolean a(int paramInt, g paramg)
  {
    boolean bool;
    if (paramg == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.b.append(paramInt, paramg);
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
    //   3: getfield 47	com/tencent/beacon/core/c/i:e	Landroid/content/Context;
    //   6: invokestatic 525	com/tencent/beacon/core/d/d:a	(Landroid/content/Context;)Z
    //   9: ifne +12 -> 21
    //   12: aload_0
    //   13: getfield 51	com/tencent/beacon/core/c/i:g	Z
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
    //   0	37	0	this	i
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public final ArrayList<j> c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.c.i
 * JD-Core Version:    0.7.0.1
 */