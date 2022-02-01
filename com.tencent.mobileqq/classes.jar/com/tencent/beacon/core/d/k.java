package com.tencent.beacon.core.d;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.protocol.common.ResponsePackage;
import com.tencent.beacon.core.protocol.common.SocketResponsePackage;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class k
  implements j
{
  private static volatile k a;
  private SparseArray<g> b = new SparseArray(5);
  private List<UploadHandleListener> c = new ArrayList(5);
  private ArrayList<l> d = new ArrayList(5);
  private Context e = null;
  private boolean f = true;
  private int g = 0;
  private boolean h = true;
  
  protected k(Context paramContext)
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
  
  public static k a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new k(paramContext);
        d.h("[net] create upload handler successfully.", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private ResponsePackage a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = com.tencent.beacon.core.strategy.g.b(this.e);
        if (localObject == null) {
          break label149;
        }
        paramArrayOfByte = com.tencent.beacon.core.e.b.a(paramArrayOfByte, 2, 3, ((com.tencent.beacon.core.strategy.g)localObject).a());
        if (paramArrayOfByte == null) {
          break label112;
        }
        localObject = new com.tencent.beacon.core.wup.c();
        ((com.tencent.beacon.core.wup.c)localObject).a(paramArrayOfByte);
        paramArrayOfByte = new ResponsePackage();
        paramArrayOfByte = (ResponsePackage)((com.tencent.beacon.core.wup.c)localObject).a("detail", paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!c().a()) {
          break label114;
        }
      }
      i.a(this.e).a("402", "[net] parse received data error! url: " + paramString, paramArrayOfByte);
      for (;;)
      {
        d.a(paramArrayOfByte);
        label112:
        return null;
        label114:
        i.a(this.e).a("452", "[net] parse received data error! url: " + paramString, paramArrayOfByte);
      }
      label149:
      paramArrayOfByte = null;
    }
  }
  
  private String a(a parama, String paramString)
  {
    Object localObject1 = parama.d();
    parama = null;
    if (localObject1 != null) {
      parama = "?rid=" + (String)localObject1;
    }
    Object localObject2 = com.tencent.beacon.core.strategy.g.b(this.e);
    localObject1 = parama;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.beacon.core.strategy.g)localObject2).b();
      localObject1 = parama;
      if (localObject2 != null)
      {
        localObject1 = parama;
        if (!"".equals(localObject2)) {
          if (parama != null) {
            break label125;
          }
        }
      }
    }
    label125:
    for (localObject1 = "?sid=" + (String)localObject2;; localObject1 = parama + "&sid=" + (String)localObject2)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = paramString + (String)localObject1;
      }
      return parama;
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, int paramInt4, String paramString1, String paramString2, int paramInt5, String paramString3)
  {
    if ((paramInt1 != 0) && (paramLong1 != 0L))
    {
      Iterator localIterator = d().iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).record(paramInt1, paramBoolean, paramLong3, paramLong1, paramInt3, paramInt4, paramString1, paramString2, paramInt5, paramString3);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = b();
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
  
  private void a(SocketResponsePackage paramSocketResponsePackage)
  {
    Object localObject = paramSocketResponsePackage.header;
    if ((((Map)localObject).containsKey("session_id")) && (((Map)localObject).containsKey("max_time")))
    {
      paramSocketResponsePackage = (String)((Map)localObject).get("session_id");
      localObject = (String)((Map)localObject).get("max_time");
      com.tencent.beacon.core.strategy.g.b(this.e).a(this.e, paramSocketResponsePackage, (String)localObject);
    }
  }
  
  private boolean a(SparseArray<g> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramSparseArray == null) || (paramArrayOfByte == null)) {
      return true;
    }
    paramSparseArray = (g)paramSparseArray.get(paramInt);
    if (paramSparseArray == null)
    {
      d.i("[net] no handler key:%d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    try
    {
      d.a("[net] key:%d  handler: %s", new Object[] { Integer.valueOf(paramInt), paramSparseArray.getClass().toString() });
      paramSparseArray.a(paramInt, paramArrayOfByte, true);
      return true;
    }
    catch (Throwable paramSparseArray)
    {
      d.a(paramSparseArray);
      d.b("[net] handle error key:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  private byte[] a(f paramf, String paramString, byte[] paramArrayOfByte, a parama, c paramc)
  {
    byte[] arrayOfByte2 = paramf.a(paramString, paramArrayOfByte, parama, paramc);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (parama.c() == 100)
      {
        arrayOfByte1 = arrayOfByte2;
        if (!"http://183.36.108.226:8080/analytics/upload".equals(paramString)) {
          arrayOfByte1 = paramf.a("http://183.36.108.226:8080/analytics/upload", paramArrayOfByte, parama, paramc);
        }
      }
    }
    return arrayOfByte1;
  }
  
  private byte[] b(a parama)
  {
    if (parama != null)
    {
      String str = parama.d();
      try
      {
        Object localObject1 = parama.f();
        if (localObject1 != null)
        {
          d.a("[net] RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d  rid:%s", new Object[] { ((RequestPackage)localObject1).appkey, ((RequestPackage)localObject1).sdkId, ((RequestPackage)localObject1).appVersion, Integer.valueOf(((RequestPackage)localObject1).cmd), str });
          Object localObject2 = new com.tencent.beacon.core.wup.c();
          ((com.tencent.beacon.core.wup.c)localObject2).a(1);
          ((com.tencent.beacon.core.wup.c)localObject2).b("test");
          ((com.tencent.beacon.core.wup.c)localObject2).a("test");
          ((com.tencent.beacon.core.wup.c)localObject2).b("detail", localObject1);
          localObject1 = ((com.tencent.beacon.core.wup.c)localObject2).a();
          d.a("[event] reqPackage to wup byte size: %d  rid:%s", new Object[] { Integer.valueOf(localObject1.length), str });
          localObject2 = com.tencent.beacon.core.strategy.g.b(this.e);
          if (localObject2 != null)
          {
            localObject1 = com.tencent.beacon.core.e.b.b((byte[])localObject1, 2, 3, ((com.tencent.beacon.core.strategy.g)localObject2).a());
            if (localObject1 == null) {}
            for (int i = 0;; i = localObject1.length)
            {
              d.a("[event] wup through zip->encry byte size: %d   rid:%s", new Object[] { Integer.valueOf(i), str });
              return localObject1;
            }
          }
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        d.b("[event] parseSendData error  rid:%s", new Object[] { str });
        d.a(localThrowable);
        parama.a();
      }
    }
  }
  
  private byte[] b(f paramf, String paramString, byte[] paramArrayOfByte, a parama, c paramc)
  {
    if (paramf.a()) {
      return c(paramf, paramString, paramArrayOfByte, parama, paramc);
    }
    return a(paramf, paramString, paramArrayOfByte, parama, paramc);
  }
  
  private byte[] c(f paramf, String paramString, byte[] paramArrayOfByte, a parama, c paramc)
  {
    paramString = paramf.a(paramString, com.tencent.beacon.core.strategy.g.b(this.e).d(), paramArrayOfByte, parama, paramc);
    if (paramString != null)
    {
      if (parama != null) {}
      for (paramf = parama.d();; paramf = null)
      {
        paramString = a(paramString);
        d.a("[net] received body size:%d |statusCode:%d |header:%s |msg:%s  rid:%s", new Object[] { Integer.valueOf(paramString.body.length), Integer.valueOf(paramString.statusCode), paramString.header, paramString.msg, paramf });
        a(paramString);
        return paramString.body;
      }
    }
    return paramString;
  }
  
  /* Error */
  protected SparseArray<g> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/beacon/core/d/k:b	Landroid/util/SparseArray;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +29 -> 37
    //   11: aload_1
    //   12: invokevirtual 333	android/util/SparseArray:size	()I
    //   15: ifle +22 -> 37
    //   18: new 335	com/tencent/beacon/core/e/h
    //   21: dup
    //   22: invokespecial 336	com/tencent/beacon/core/e/h:<init>	()V
    //   25: aload_0
    //   26: getfield 36	com/tencent/beacon/core/d/k:b	Landroid/util/SparseArray;
    //   29: invokevirtual 339	com/tencent/beacon/core/e/h:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aconst_null
    //   38: astore_1
    //   39: goto -6 -> 33
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	k
    //   6	33	1	localSparseArray	SparseArray
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	42	finally
    //   11	33	42	finally
  }
  
  protected SocketResponsePackage a(byte[] paramArrayOfByte)
  {
    SocketResponsePackage localSocketResponsePackage = new SocketResponsePackage();
    localSocketResponsePackage.readFrom(new com.tencent.beacon.core.wup.a(paramArrayOfByte));
    return localSocketResponsePackage;
  }
  
  public void a(a parama, ResponsePackage paramResponsePackage)
  {
    if ((parama == null) || (paramResponsePackage == null)) {
      return;
    }
    String str = parama.d();
    Object localObject1 = com.tencent.beacon.core.info.b.b(this.e);
    if (localObject1 != null)
    {
      localObject2 = paramResponsePackage.srcGatewayIp;
      if (localObject2 != null) {
        ((com.tencent.beacon.core.info.b)localObject1).c(((String)localObject2).trim());
      }
      localObject2 = new Date();
      ((com.tencent.beacon.core.info.b)localObject1).a(paramResponsePackage.serverTime - ((Date)localObject2).getTime());
      d.h("[net] fix ip:%s  tmgap: %d  rid:%s", new Object[] { ((com.tencent.beacon.core.info.b)localObject1).d(), Long.valueOf(((com.tencent.beacon.core.info.b)localObject1).j()), str });
    }
    localObject1 = paramResponsePackage.sBuffer;
    if (localObject1 == null)
    {
      d.h("[net] no response!  rid:%s", new Object[] { str });
      return;
    }
    Object localObject2 = a();
    if ((localObject2 == null) || (((SparseArray)localObject2).size() <= 0))
    {
      d.h("[net] no handler!  rid:%s", new Object[] { str });
      return;
    }
    int i = parama.c();
    int j = paramResponsePackage.cmd;
    if (j == 0)
    {
      d.h("[net] response with no data  rid:%s", new Object[] { str });
      return;
    }
    if (i != 4)
    {
      if (i != 100)
      {
        if (i != 102)
        {
          d.i("[net] unknown req: %d  rid:%s", new Object[] { Integer.valueOf(i), str });
          return;
        }
        if (j != 103) {
          d.i("[net] UNMATCH req: %d  , rep: %d   rid:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), str });
        }
      }
      else if (j != 101)
      {
        d.i("[net] UNMATCH req: %d , rep: %d   rid:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), str });
      }
    }
    else if (j != 105)
    {
      d.i("[net] UNMATCH req: %d , rep: %d  rid:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), str });
      return;
    }
    a((SparseArray)localObject2, j, (byte[])localObject1);
  }
  
  public void a(l paraml)
  {
    this.d.add(paraml);
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(int paramInt, g paramg)
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
  
  /* Error */
  public boolean a(a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +15 -> 16
    //   4: ldc_w 422
    //   7: iconst_0
    //   8: anewarray 4	java/lang/Object
    //   11: invokestatic 246	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_1
    //   17: invokevirtual 140	com/tencent/beacon/core/d/a:d	()Ljava/lang/String;
    //   20: astore 14
    //   22: aload_1
    //   23: invokevirtual 255	com/tencent/beacon/core/d/a:c	()I
    //   26: istore_3
    //   27: aload_0
    //   28: invokevirtual 424	com/tencent/beacon/core/d/k:f	()Z
    //   31: ifeq +10 -> 41
    //   34: aload_0
    //   35: invokevirtual 426	com/tencent/beacon/core/d/k:e	()Z
    //   38: ifne +25 -> 63
    //   41: iload_3
    //   42: iconst_2
    //   43: if_icmpne +723 -> 766
    //   46: ldc_w 428
    //   49: iconst_0
    //   50: anewarray 4	java/lang/Object
    //   53: invokestatic 70	com/tencent/beacon/core/e/d:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload_1
    //   57: iconst_0
    //   58: invokevirtual 430	com/tencent/beacon/core/d/a:a	(Z)V
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_0
    //   64: getfield 45	com/tencent/beacon/core/d/k:e	Landroid/content/Context;
    //   67: invokestatic 435	com/tencent/beacon/core/e/e:c	(Landroid/content/Context;)Z
    //   70: ifne +30 -> 100
    //   73: ldc_w 437
    //   76: iconst_1
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload 14
    //   84: aastore
    //   85: invokestatic 228	com/tencent/beacon/core/e/d:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: iload_3
    //   89: iconst_2
    //   90: if_icmpne +8 -> 98
    //   93: aload_1
    //   94: iconst_0
    //   95: invokevirtual 430	com/tencent/beacon/core/d/a:a	(Z)V
    //   98: iconst_0
    //   99: ireturn
    //   100: iconst_0
    //   101: istore 5
    //   103: aload_1
    //   104: invokevirtual 439	com/tencent/beacon/core/d/a:e	()Ljava/lang/String;
    //   107: astore 13
    //   109: aload 13
    //   111: ifnull +16 -> 127
    //   114: ldc 146
    //   116: aload 13
    //   118: invokevirtual 361	java/lang/String:trim	()Ljava/lang/String;
    //   121: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   124: ifeq +42 -> 166
    //   127: ldc_w 441
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload 14
    //   138: aastore
    //   139: invokestatic 246	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: iload_3
    //   143: iconst_2
    //   144: if_icmpne +8 -> 152
    //   147: aload_1
    //   148: iconst_0
    //   149: invokevirtual 430	com/tencent/beacon/core/d/a:a	(Z)V
    //   152: aload_0
    //   153: iload_3
    //   154: iconst_m1
    //   155: lconst_0
    //   156: lconst_0
    //   157: iconst_0
    //   158: ldc_w 443
    //   161: invokespecial 445	com/tencent/beacon/core/d/k:a	(IIJJZLjava/lang/String;)V
    //   164: iconst_0
    //   165: ireturn
    //   166: aload_0
    //   167: aload_1
    //   168: invokespecial 447	com/tencent/beacon/core/d/k:b	(Lcom/tencent/beacon/core/d/a;)[B
    //   171: astore 17
    //   173: aload 17
    //   175: ifnonnull +32 -> 207
    //   178: ldc_w 449
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 14
    //   189: aastore
    //   190: invokestatic 228	com/tencent/beacon/core/e/d:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: iload_3
    //   195: iconst_m1
    //   196: lconst_0
    //   197: lconst_0
    //   198: iconst_0
    //   199: ldc_w 451
    //   202: invokespecial 445	com/tencent/beacon/core/d/k:a	(IIJJZLjava/lang/String;)V
    //   205: iconst_0
    //   206: ireturn
    //   207: aload_0
    //   208: invokevirtual 103	com/tencent/beacon/core/d/k:c	()Lcom/tencent/beacon/core/d/f;
    //   211: astore 18
    //   213: aload 18
    //   215: ifnonnull +32 -> 247
    //   218: ldc_w 453
    //   221: iconst_1
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload 14
    //   229: aastore
    //   230: invokestatic 246	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: aload_0
    //   234: iload_3
    //   235: iconst_m1
    //   236: lconst_0
    //   237: lconst_0
    //   238: iconst_0
    //   239: ldc_w 455
    //   242: invokespecial 445	com/tencent/beacon/core/d/k:a	(IIJJZLjava/lang/String;)V
    //   245: iconst_0
    //   246: ireturn
    //   247: aload 18
    //   249: invokevirtual 108	com/tencent/beacon/core/d/f:a	()Z
    //   252: ifne +545 -> 797
    //   255: aload_0
    //   256: aload_1
    //   257: aload 13
    //   259: invokespecial 457	com/tencent/beacon/core/d/k:a	(Lcom/tencent/beacon/core/d/a;Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 13
    //   264: ldc_w 459
    //   267: iconst_4
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: iload_3
    //   274: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: aload 13
    //   282: aastore
    //   283: dup
    //   284: iconst_2
    //   285: aload_1
    //   286: invokevirtual 234	java/lang/Object:getClass	()Ljava/lang/Class;
    //   289: invokevirtual 462	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   292: aastore
    //   293: dup
    //   294: iconst_3
    //   295: aload 14
    //   297: aastore
    //   298: invokestatic 70	com/tencent/beacon/core/e/d:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload_0
    //   302: getfield 45	com/tencent/beacon/core/d/k:e	Landroid/content/Context;
    //   305: invokestatic 468	com/tencent/beacon/core/info/e:l	(Landroid/content/Context;)Ljava/lang/String;
    //   308: astore 15
    //   310: new 470	com/tencent/beacon/core/d/c
    //   313: dup
    //   314: invokespecial 471	com/tencent/beacon/core/d/c:<init>	()V
    //   317: astore 16
    //   319: aload_0
    //   320: getfield 45	com/tencent/beacon/core/d/k:e	Landroid/content/Context;
    //   323: invokestatic 355	com/tencent/beacon/core/info/b:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/b;
    //   326: invokevirtual 383	com/tencent/beacon/core/info/b:j	()J
    //   329: invokestatic 474	com/tencent/beacon/core/e/b:b	(J)J
    //   332: ldc2_w 475
    //   335: ldiv
    //   336: lstore 7
    //   338: aload_0
    //   339: aload 18
    //   341: aload 13
    //   343: aload 17
    //   345: aload_1
    //   346: aload 16
    //   348: invokespecial 478	com/tencent/beacon/core/d/k:b	(Lcom/tencent/beacon/core/d/f;Ljava/lang/String;[BLcom/tencent/beacon/core/d/a;Lcom/tencent/beacon/core/d/c;)[B
    //   351: astore 17
    //   353: aload 16
    //   355: invokevirtual 480	com/tencent/beacon/core/d/c:f	()J
    //   358: lstore 9
    //   360: aload 16
    //   362: invokevirtual 482	com/tencent/beacon/core/d/c:d	()J
    //   365: lstore 11
    //   367: aload_0
    //   368: aload 17
    //   370: aload 13
    //   372: invokespecial 484	com/tencent/beacon/core/d/k:a	([BLjava/lang/String;)Lcom/tencent/beacon/core/protocol/common/ResponsePackage;
    //   375: astore 13
    //   377: aload 13
    //   379: ifnull +342 -> 721
    //   382: aload 13
    //   384: getfield 398	com/tencent/beacon/core/protocol/common/ResponsePackage:cmd	I
    //   387: istore_2
    //   388: aload 13
    //   390: getfield 488	com/tencent/beacon/core/protocol/common/ResponsePackage:result	B
    //   393: istore 4
    //   395: iload 4
    //   397: ifne +129 -> 526
    //   400: iconst_1
    //   401: istore 5
    //   403: iload 5
    //   405: istore 6
    //   407: ldc_w 490
    //   410: iconst_3
    //   411: anewarray 4	java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: aload 13
    //   418: getfield 398	com/tencent/beacon/core/protocol/common/ResponsePackage:cmd	I
    //   421: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   424: aastore
    //   425: dup
    //   426: iconst_1
    //   427: aload 13
    //   429: getfield 488	com/tencent/beacon/core/protocol/common/ResponsePackage:result	B
    //   432: invokestatic 495	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   435: aastore
    //   436: dup
    //   437: iconst_2
    //   438: aload 14
    //   440: aastore
    //   441: invokestatic 239	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: aload_0
    //   445: aload_1
    //   446: aload 13
    //   448: invokevirtual 497	com/tencent/beacon/core/d/k:a	(Lcom/tencent/beacon/core/d/a;Lcom/tencent/beacon/core/protocol/common/ResponsePackage;)V
    //   451: aload_0
    //   452: iload_3
    //   453: iload_2
    //   454: lload 9
    //   456: lload 11
    //   458: iload 5
    //   460: aconst_null
    //   461: invokespecial 445	com/tencent/beacon/core/d/k:a	(IIJJZLjava/lang/String;)V
    //   464: aload 13
    //   466: ifnull +263 -> 729
    //   469: aload 13
    //   471: getfield 488	com/tencent/beacon/core/protocol/common/ResponsePackage:result	B
    //   474: invokestatic 500	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   477: astore 13
    //   479: aload_0
    //   480: iload_3
    //   481: iload_2
    //   482: lload 9
    //   484: lload 11
    //   486: iload 5
    //   488: lload 7
    //   490: aload 16
    //   492: invokevirtual 502	com/tencent/beacon/core/d/c:c	()J
    //   495: l2i
    //   496: aload_1
    //   497: invokevirtual 504	com/tencent/beacon/core/d/a:b	()I
    //   500: aload 15
    //   502: aload 16
    //   504: invokevirtual 505	com/tencent/beacon/core/d/c:b	()Ljava/lang/String;
    //   507: aload 16
    //   509: invokevirtual 507	com/tencent/beacon/core/d/c:e	()I
    //   512: aload 13
    //   514: invokespecial 509	com/tencent/beacon/core/d/k:a	(IIJJZJIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   517: aload_1
    //   518: iload 5
    //   520: invokevirtual 430	com/tencent/beacon/core/d/a:a	(Z)V
    //   523: iload 5
    //   525: ireturn
    //   526: iconst_0
    //   527: istore 5
    //   529: goto -126 -> 403
    //   532: astore 13
    //   534: iload 5
    //   536: istore 6
    //   538: aload 16
    //   540: invokevirtual 480	com/tencent/beacon/core/d/c:f	()J
    //   543: lstore 9
    //   545: iload 5
    //   547: istore 6
    //   549: aload 16
    //   551: invokevirtual 482	com/tencent/beacon/core/d/c:d	()J
    //   554: lstore 11
    //   556: iload 5
    //   558: istore 6
    //   560: aload 13
    //   562: invokevirtual 510	java/lang/Throwable:toString	()Ljava/lang/String;
    //   565: astore 17
    //   567: iload 5
    //   569: istore 6
    //   571: aload 17
    //   573: ldc_w 512
    //   576: ldc 146
    //   578: invokevirtual 516	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   581: astore 17
    //   583: iload 5
    //   585: istore 6
    //   587: aload_0
    //   588: iload_3
    //   589: iload_2
    //   590: lload 9
    //   592: lload 11
    //   594: iconst_0
    //   595: aload 17
    //   597: invokespecial 445	com/tencent/beacon/core/d/k:a	(IIJJZLjava/lang/String;)V
    //   600: iload 5
    //   602: istore 6
    //   604: aload_0
    //   605: iload_3
    //   606: iload_2
    //   607: lload 9
    //   609: lload 11
    //   611: iconst_0
    //   612: lload 7
    //   614: aload 16
    //   616: invokevirtual 502	com/tencent/beacon/core/d/c:c	()J
    //   619: l2i
    //   620: aload_1
    //   621: invokevirtual 504	com/tencent/beacon/core/d/a:b	()I
    //   624: aload 15
    //   626: aload 16
    //   628: invokevirtual 505	com/tencent/beacon/core/d/c:b	()Ljava/lang/String;
    //   631: aload 16
    //   633: invokevirtual 507	com/tencent/beacon/core/d/c:e	()I
    //   636: aload 17
    //   638: invokespecial 509	com/tencent/beacon/core/d/k:a	(IIJJZJIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   641: iload 5
    //   643: istore 6
    //   645: ldc_w 518
    //   648: iconst_2
    //   649: anewarray 4	java/lang/Object
    //   652: dup
    //   653: iconst_0
    //   654: aload 13
    //   656: invokevirtual 510	java/lang/Throwable:toString	()Ljava/lang/String;
    //   659: aastore
    //   660: dup
    //   661: iconst_1
    //   662: aload 14
    //   664: aastore
    //   665: invokestatic 246	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   668: iload 5
    //   670: istore 6
    //   672: aload_0
    //   673: getfield 45	com/tencent/beacon/core/d/k:e	Landroid/content/Context;
    //   676: invokestatic 78	com/tencent/beacon/core/strategy/g:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/g;
    //   679: invokevirtual 519	com/tencent/beacon/core/strategy/g:e	()Z
    //   682: ifeq +30 -> 712
    //   685: iload 5
    //   687: istore 6
    //   689: aload 13
    //   691: instanceof 521
    //   694: ifeq +18 -> 712
    //   697: iload 5
    //   699: istore 6
    //   701: aload_0
    //   702: getfield 45	com/tencent/beacon/core/d/k:e	Landroid/content/Context;
    //   705: invokestatic 78	com/tencent/beacon/core/strategy/g:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/g;
    //   708: iconst_0
    //   709: invokevirtual 522	com/tencent/beacon/core/strategy/g:a	(Z)V
    //   712: aload_1
    //   713: iload 5
    //   715: invokevirtual 430	com/tencent/beacon/core/d/a:a	(Z)V
    //   718: iload 5
    //   720: ireturn
    //   721: iconst_m1
    //   722: istore_2
    //   723: iconst_0
    //   724: istore 5
    //   726: goto -282 -> 444
    //   729: ldc_w 524
    //   732: astore 13
    //   734: goto -255 -> 479
    //   737: astore 13
    //   739: goto -205 -> 534
    //   742: astore 13
    //   744: iconst_m1
    //   745: istore_2
    //   746: iconst_0
    //   747: istore 5
    //   749: goto -215 -> 534
    //   752: astore 13
    //   754: iconst_0
    //   755: istore 5
    //   757: aload_1
    //   758: iload 5
    //   760: invokevirtual 430	com/tencent/beacon/core/d/a:a	(Z)V
    //   763: aload 13
    //   765: athrow
    //   766: ldc_w 526
    //   769: iconst_0
    //   770: anewarray 4	java/lang/Object
    //   773: invokestatic 70	com/tencent/beacon/core/e/d:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   776: iconst_0
    //   777: ireturn
    //   778: astore 13
    //   780: iload 6
    //   782: istore 5
    //   784: goto -27 -> 757
    //   787: astore 13
    //   789: goto -32 -> 757
    //   792: astore 13
    //   794: goto -260 -> 534
    //   797: goto -533 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	k
    //   0	800	1	parama	a
    //   387	359	2	i	int
    //   26	580	3	j	int
    //   393	3	4	k	int
    //   101	682	5	bool1	boolean
    //   405	376	6	bool2	boolean
    //   336	277	7	l1	long
    //   358	250	9	l2	long
    //   365	245	11	l3	long
    //   107	406	13	localObject1	Object
    //   532	158	13	localThrowable1	Throwable
    //   732	1	13	str1	String
    //   737	1	13	localThrowable2	Throwable
    //   742	1	13	localThrowable3	Throwable
    //   752	12	13	localObject2	Object
    //   778	1	13	localObject3	Object
    //   787	1	13	localObject4	Object
    //   792	1	13	localThrowable4	Throwable
    //   20	643	14	str2	String
    //   308	317	15	str3	String
    //   317	315	16	localc	c
    //   171	466	17	localObject5	Object
    //   211	129	18	localf	f
    // Exception table:
    //   from	to	target	type
    //   388	395	532	java/lang/Throwable
    //   444	464	737	java/lang/Throwable
    //   469	479	737	java/lang/Throwable
    //   479	517	737	java/lang/Throwable
    //   338	377	742	java/lang/Throwable
    //   382	388	742	java/lang/Throwable
    //   338	377	752	finally
    //   382	388	752	finally
    //   388	395	752	finally
    //   407	444	778	finally
    //   538	545	778	finally
    //   549	556	778	finally
    //   560	567	778	finally
    //   571	583	778	finally
    //   587	600	778	finally
    //   604	641	778	finally
    //   645	668	778	finally
    //   672	685	778	finally
    //   689	697	778	finally
    //   701	712	778	finally
    //   444	464	787	finally
    //   469	479	787	finally
    //   479	517	787	finally
    //   407	444	792	java/lang/Throwable
  }
  
  public boolean a(UploadHandleListener paramUploadHandleListener)
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
  
  public void b(boolean paramBoolean)
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
  
  /* Error */
  protected UploadHandleListener[] b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/tencent/beacon/core/d/k:c	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +33 -> 41
    //   11: aload_1
    //   12: invokeinterface 534 1 0
    //   17: ifle +24 -> 41
    //   20: aload_0
    //   21: getfield 41	com/tencent/beacon/core/d/k:c	Ljava/util/List;
    //   24: iconst_0
    //   25: anewarray 185	com/tencent/beacon/upload/UploadHandleListener
    //   28: invokeinterface 538 2 0
    //   33: checkcast 540	[Lcom/tencent/beacon/upload/UploadHandleListener;
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aconst_null
    //   42: astore_1
    //   43: goto -6 -> 37
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	k
    //   6	37	1	localObject1	Object
    //   46	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	46	finally
    //   11	37	46	finally
  }
  
  protected f c()
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
  
  public ArrayList<l> d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean f()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.d.k
 * JD-Core Version:    0.7.0.1
 */