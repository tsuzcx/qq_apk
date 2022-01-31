package com.tencent.beacon.upload;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.a.j;
import com.tencent.beacon.b.a.c;
import com.tencent.beacon.event.o;
import java.util.ArrayList;
import java.util.List;

public final class i
  implements h
{
  private static i a = null;
  private SparseArray<g> b = new SparseArray(5);
  private List<UploadHandleListener> c = new ArrayList(5);
  private f d;
  private Context e = null;
  private boolean f = true;
  private boolean g = true;
  
  private i(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    if (localContext != null) {}
    for (this.e = localContext;; this.e = paramContext)
    {
      this.f = paramBoolean;
      this.d = f.a(this.e);
      return;
    }
  }
  
  private static c a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = com.tencent.beacon.a.b.d.a();
        if (localObject == null) {
          break label85;
        }
        int i = ((com.tencent.beacon.a.b.d)localObject).k();
        paramArrayOfByte = com.tencent.beacon.a.f.b(paramArrayOfByte, ((com.tencent.beacon.a.b.d)localObject).l(), i, ((com.tencent.beacon.a.b.d)localObject).o());
        if (paramArrayOfByte != null)
        {
          localObject = new com.tencent.beacon.e.d();
          ((com.tencent.beacon.e.d)localObject).a(paramArrayOfByte);
          paramArrayOfByte = new c();
          com.tencent.beacon.d.a.b(" covert to ResponsePackage ", new Object[0]);
          paramArrayOfByte = (c)((com.tencent.beacon.e.d)localObject).b("detail", paramArrayOfByte);
          return paramArrayOfByte;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        com.tencent.beacon.d.a.a(paramArrayOfByte);
      }
      return null;
      label85:
      paramArrayOfByte = null;
    }
  }
  
  public static i a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new i(paramContext, true);
        com.tencent.beacon.d.a.h(" create uphandler up:true", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static i a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (a == null)
      {
        a = new i(paramContext, paramBoolean);
        com.tencent.beacon.d.a.h(" create uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      if (a.a() != paramBoolean)
      {
        a.b(paramBoolean);
        com.tencent.beacon.d.a.h(" change uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = c();
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
  
  private static void a(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3)
  {
    if ((paramInt1 != 0) && (paramLong1 != 0L))
    {
      o localo = o.d();
      if ((localo != null) && (localo.d != null)) {
        localo.d.a(paramInt1, paramBoolean, paramLong2, paramLong1, paramInt2, paramInt3, paramString1, paramString2, paramInt4, paramString3);
      }
    }
  }
  
  private boolean a(SparseArray<g> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramSparseArray == null) || (paramArrayOfByte == null)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      paramSparseArray = (g)paramSparseArray.get(paramInt);
      if (paramSparseArray == null)
      {
        com.tencent.beacon.d.a.c(" no handler key:%d", new Object[] { Integer.valueOf(paramInt) });
        return false;
      }
      break;
    case 103: 
      try
      {
        com.tencent.beacon.d.a.a(" process CMD_RESPONSE_GEN_QIMEI", new Object[0]);
        paramSparseArray = new com.tencent.beacon.e.a(paramArrayOfByte);
        paramArrayOfByte = new com.tencent.beacon.b.c.a();
        paramArrayOfByte.a(paramSparseArray);
        if (paramArrayOfByte.a != null)
        {
          j.a(this.e).a(paramArrayOfByte.a);
          new com.tencent.beacon.d.b(this.e).a(paramArrayOfByte.a);
        }
        com.tencent.beacon.d.a.h(" Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s ", new Object[] { paramArrayOfByte.a, paramArrayOfByte.b, paramArrayOfByte.d, paramArrayOfByte.e, paramArrayOfByte.c });
      }
      catch (Throwable paramSparseArray)
      {
        for (;;)
        {
          com.tencent.beacon.d.a.a(paramSparseArray);
        }
      }
      return true;
    }
    try
    {
      com.tencent.beacon.d.a.b(" key:%d  handler: %s", new Object[] { Integer.valueOf(paramInt), paramSparseArray.getClass().toString() });
      paramSparseArray.a(paramInt, paramArrayOfByte, true);
      return true;
    }
    catch (Throwable paramSparseArray)
    {
      com.tencent.beacon.d.a.a(paramSparseArray);
      com.tencent.beacon.d.a.d(" handle error key:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
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
  
  private static byte[] b(a parama)
  {
    if (parama != null) {
      try
      {
        Object localObject1 = parama.a();
        if (localObject1 != null)
        {
          com.tencent.beacon.d.a.b(" RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", new Object[] { ((com.tencent.beacon.b.a.b)localObject1).b, ((com.tencent.beacon.b.a.b)localObject1).d, ((com.tencent.beacon.b.a.b)localObject1).c, Integer.valueOf(((com.tencent.beacon.b.a.b)localObject1).f) });
          Object localObject2 = new com.tencent.beacon.e.d();
          ((com.tencent.beacon.e.d)localObject2).a();
          ((com.tencent.beacon.e.d)localObject2).b("test");
          ((com.tencent.beacon.e.d)localObject2).a("test");
          ((com.tencent.beacon.e.d)localObject2).a("detail", localObject1);
          localObject1 = ((com.tencent.beacon.e.d)localObject2).b();
          localObject2 = com.tencent.beacon.a.b.d.a();
          if (localObject2 != null)
          {
            int i = ((com.tencent.beacon.a.b.d)localObject2).k();
            localObject1 = com.tencent.beacon.a.f.a((byte[])localObject1, ((com.tencent.beacon.a.b.d)localObject2).l(), i, ((com.tencent.beacon.a.b.d)localObject2).o());
            return localObject1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.d(" parseSendDatas error", new Object[0]);
        com.tencent.beacon.d.a.a(localThrowable);
        parama.b();
      }
    }
    return null;
  }
  
  /* Error */
  private UploadHandleListener[] c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/beacon/upload/i:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 42	com/tencent/beacon/upload/i:c	Ljava/util/List;
    //   13: invokeinterface 275 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 42	com/tencent/beacon/upload/i:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 140	com/tencent/beacon/upload/UploadHandleListener
    //   29: invokeinterface 279 2 0
    //   34: checkcast 281	[Lcom/tencent/beacon/upload/UploadHandleListener;
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
  
  private f d()
  {
    try
    {
      f localf = this.d;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private SparseArray<g> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/beacon/upload/i:b	Landroid/util/SparseArray;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 37	com/tencent/beacon/upload/i:b	Landroid/util/SparseArray;
    //   13: invokevirtual 284	android/util/SparseArray:size	()I
    //   16: ifle +23 -> 39
    //   19: new 286	com/tencent/beacon/d/d
    //   22: dup
    //   23: invokespecial 287	com/tencent/beacon/d/d:<init>	()V
    //   26: pop
    //   27: aload_0
    //   28: getfield 37	com/tencent/beacon/upload/i:b	Landroid/util/SparseArray;
    //   31: invokestatic 290	com/tencent/beacon/d/d:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
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
  
  /* Error */
  public final void a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 129	com/tencent/beacon/upload/i:a	()Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: invokevirtual 296	com/tencent/beacon/upload/i:b	()Z
    //   11: ifne +64 -> 75
    //   14: aload_1
    //   15: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   18: iconst_2
    //   19: if_icmpne +18 -> 37
    //   22: ldc_w 300
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload_1
    //   33: iconst_0
    //   34: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   37: aload_1
    //   38: getfield 303	com/tencent/beacon/upload/a:b	I
    //   41: ifeq +24 -> 65
    //   44: ldc_w 305
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   57: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: return
    //   65: ldc_w 307
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_0
    //   76: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   79: invokestatic 311	com/tencent/beacon/a/f:t	(Landroid/content/Context;)Z
    //   82: ifne +27 -> 109
    //   85: ldc_w 313
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_1
    //   96: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   99: iconst_2
    //   100: if_icmpne -36 -> 64
    //   103: aload_1
    //   104: iconst_0
    //   105: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   108: return
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   114: invokestatic 318	com/tencent/beacon/a/h:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/h;
    //   117: invokevirtual 321	com/tencent/beacon/upload/i:a	(Lcom/tencent/beacon/upload/UploadHandleListener;)Z
    //   120: pop
    //   121: aload_1
    //   122: ifnonnull +14 -> 136
    //   125: ldc_w 323
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 232	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: return
    //   136: aload_1
    //   137: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   140: istore 5
    //   142: iconst_0
    //   143: istore 11
    //   145: iconst_0
    //   146: istore 7
    //   148: iconst_0
    //   149: istore 10
    //   151: iconst_m1
    //   152: istore 4
    //   154: aload_1
    //   155: invokevirtual 325	com/tencent/beacon/upload/a:e	()Ljava/lang/String;
    //   158: astore 20
    //   160: aload 20
    //   162: ifnull +17 -> 179
    //   165: ldc_w 327
    //   168: aload 20
    //   170: invokevirtual 332	java/lang/String:trim	()Ljava/lang/String;
    //   173: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifeq +40 -> 216
    //   179: ldc_w 338
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 232	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_1
    //   190: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   193: iconst_2
    //   194: if_icmpne +8 -> 202
    //   197: aload_1
    //   198: iconst_0
    //   199: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   202: aload_0
    //   203: iload 5
    //   205: iconst_m1
    //   206: lconst_0
    //   207: lconst_0
    //   208: iconst_0
    //   209: ldc_w 340
    //   212: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   215: return
    //   216: aload_1
    //   217: invokestatic 344	com/tencent/beacon/upload/i:b	(Lcom/tencent/beacon/upload/a;)[B
    //   220: astore 22
    //   222: aload_1
    //   223: invokevirtual 346	com/tencent/beacon/upload/a:d	()Ljava/lang/String;
    //   226: astore 19
    //   228: aconst_null
    //   229: astore 18
    //   231: aload 19
    //   233: ifnull +23 -> 256
    //   236: new 348	java/lang/StringBuilder
    //   239: dup
    //   240: ldc_w 350
    //   243: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: aload 19
    //   248: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: astore 18
    //   256: invokestatic 69	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   259: astore 21
    //   261: aload 18
    //   263: astore 19
    //   265: aload 21
    //   267: ifnull +59 -> 326
    //   270: aload 21
    //   272: invokevirtual 360	com/tencent/beacon/a/b/d:p	()Ljava/lang/String;
    //   275: astore 21
    //   277: aload 18
    //   279: astore 19
    //   281: aload 21
    //   283: ifnull +43 -> 326
    //   286: aload 18
    //   288: astore 19
    //   290: ldc_w 327
    //   293: aload 21
    //   295: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   298: ifne +28 -> 326
    //   301: aload 18
    //   303: ifnonnull +112 -> 415
    //   306: new 348	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 362
    //   313: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: aload 21
    //   318: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore 19
    //   326: aload 19
    //   328: ifnull +1492 -> 1820
    //   331: new 348	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   338: aload 20
    //   340: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 19
    //   345: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: astore 18
    //   353: ldc_w 365
    //   356: iconst_3
    //   357: anewarray 4	java/lang/Object
    //   360: dup
    //   361: iconst_0
    //   362: iload 5
    //   364: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: aastore
    //   368: dup
    //   369: iconst_1
    //   370: aload 18
    //   372: aastore
    //   373: dup
    //   374: iconst_2
    //   375: aload_1
    //   376: invokevirtual 220	java/lang/Object:getClass	()Ljava/lang/Class;
    //   379: invokevirtual 225	java/lang/Class:toString	()Ljava/lang/String;
    //   382: aastore
    //   383: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   386: aload 22
    //   388: ifnonnull +58 -> 446
    //   391: ldc_w 367
    //   394: iconst_0
    //   395: anewarray 4	java/lang/Object
    //   398: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: aload_0
    //   402: iload 5
    //   404: iconst_m1
    //   405: lconst_0
    //   406: lconst_0
    //   407: iconst_0
    //   408: ldc_w 369
    //   411: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   414: return
    //   415: new 348	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   422: aload 18
    //   424: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc_w 371
    //   430: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 21
    //   435: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: astore 19
    //   443: goto -117 -> 326
    //   446: aload_0
    //   447: invokespecial 373	com/tencent/beacon/upload/i:d	()Lcom/tencent/beacon/upload/f;
    //   450: astore 23
    //   452: aload 23
    //   454: ifnonnull +27 -> 481
    //   457: ldc_w 375
    //   460: iconst_0
    //   461: anewarray 4	java/lang/Object
    //   464: invokestatic 232	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   467: aload_0
    //   468: iload 5
    //   470: iconst_m1
    //   471: lconst_0
    //   472: lconst_0
    //   473: iconst_0
    //   474: ldc_w 377
    //   477: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   480: return
    //   481: aload_0
    //   482: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   485: invokestatic 380	com/tencent/beacon/a/f:k	(Landroid/content/Context;)Ljava/lang/String;
    //   488: astore 20
    //   490: new 382	com/tencent/beacon/upload/e
    //   493: dup
    //   494: invokespecial 383	com/tencent/beacon/upload/e:<init>	()V
    //   497: astore 21
    //   499: invokestatic 389	com/tencent/beacon/a/d:m	()Lcom/tencent/beacon/a/d;
    //   502: invokevirtual 392	com/tencent/beacon/a/d:h	()J
    //   505: new 394	java/util/Date
    //   508: dup
    //   509: invokespecial 395	java/util/Date:<init>	()V
    //   512: invokevirtual 398	java/util/Date:getTime	()J
    //   515: ladd
    //   516: ldc2_w 399
    //   519: ldiv
    //   520: lstore 12
    //   522: iload 4
    //   524: istore_2
    //   525: iload 10
    //   527: istore 8
    //   529: iload 11
    //   531: istore 9
    //   533: aload 23
    //   535: aload 18
    //   537: aload 22
    //   539: aload 21
    //   541: aload_1
    //   542: invokevirtual 403	com/tencent/beacon/upload/f:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/e;Lcom/tencent/beacon/upload/a;)[B
    //   545: astore 19
    //   547: aload 19
    //   549: ifnonnull +1264 -> 1813
    //   552: iload 5
    //   554: bipush 100
    //   556: if_icmpne +1257 -> 1813
    //   559: iload 4
    //   561: istore_2
    //   562: iload 10
    //   564: istore 8
    //   566: iload 11
    //   568: istore 9
    //   570: ldc_w 405
    //   573: aload 18
    //   575: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifne +1235 -> 1813
    //   581: iload 4
    //   583: istore_2
    //   584: iload 10
    //   586: istore 8
    //   588: iload 11
    //   590: istore 9
    //   592: aload 23
    //   594: ldc_w 405
    //   597: aload 22
    //   599: aload 21
    //   601: aload_1
    //   602: invokevirtual 403	com/tencent/beacon/upload/f:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/e;Lcom/tencent/beacon/upload/a;)[B
    //   605: astore 18
    //   607: iload 4
    //   609: istore_2
    //   610: iload 10
    //   612: istore 8
    //   614: iload 11
    //   616: istore 9
    //   618: aload 21
    //   620: invokevirtual 407	com/tencent/beacon/upload/e:a	()J
    //   623: lstore 14
    //   625: iload 4
    //   627: istore_2
    //   628: iload 10
    //   630: istore 8
    //   632: iload 11
    //   634: istore 9
    //   636: aload 21
    //   638: invokevirtual 409	com/tencent/beacon/upload/e:b	()J
    //   641: lstore 16
    //   643: iload 4
    //   645: istore_2
    //   646: iload 10
    //   648: istore 8
    //   650: iload 11
    //   652: istore 9
    //   654: aload 18
    //   656: invokestatic 411	com/tencent/beacon/upload/i:a	([B)Lcom/tencent/beacon/b/a/c;
    //   659: astore 18
    //   661: iload 4
    //   663: istore_3
    //   664: aload 18
    //   666: ifnull +1161 -> 1827
    //   669: iload 4
    //   671: istore_2
    //   672: iload 10
    //   674: istore 8
    //   676: iload 11
    //   678: istore 9
    //   680: aload 18
    //   682: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   685: istore_3
    //   686: iload_3
    //   687: istore_2
    //   688: iload 10
    //   690: istore 8
    //   692: iload 11
    //   694: istore 9
    //   696: aload 18
    //   698: getfield 415	com/tencent/beacon/b/a/c:a	B
    //   701: ifne +143 -> 844
    //   704: iconst_1
    //   705: istore 7
    //   707: iload_3
    //   708: istore_2
    //   709: iload 7
    //   711: istore 8
    //   713: iload 7
    //   715: istore 9
    //   717: ldc_w 417
    //   720: iconst_2
    //   721: anewarray 4	java/lang/Object
    //   724: dup
    //   725: iconst_0
    //   726: aload 18
    //   728: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   731: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   734: aastore
    //   735: dup
    //   736: iconst_1
    //   737: aload 18
    //   739: getfield 415	com/tencent/beacon/b/a/c:a	B
    //   742: invokestatic 422	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   745: aastore
    //   746: invokestatic 101	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   749: goto +1078 -> 1827
    //   752: iload_3
    //   753: istore_2
    //   754: iload 7
    //   756: istore 8
    //   758: iload 7
    //   760: istore 9
    //   762: aload_0
    //   763: iload 5
    //   765: iload_3
    //   766: lload 14
    //   768: lload 16
    //   770: iload 7
    //   772: aconst_null
    //   773: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   776: iload_3
    //   777: istore_2
    //   778: iload 7
    //   780: istore 8
    //   782: iload 7
    //   784: istore 9
    //   786: iload 5
    //   788: lload 14
    //   790: iload 7
    //   792: lload 12
    //   794: aload 21
    //   796: invokevirtual 424	com/tencent/beacon/upload/e:d	()J
    //   799: l2i
    //   800: aload_1
    //   801: invokevirtual 426	com/tencent/beacon/upload/a:f	()I
    //   804: aload 20
    //   806: aload 21
    //   808: invokevirtual 427	com/tencent/beacon/upload/e:e	()Ljava/lang/String;
    //   811: aload 21
    //   813: invokevirtual 428	com/tencent/beacon/upload/e:c	()I
    //   816: new 348	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   823: aload 18
    //   825: getfield 415	com/tencent/beacon/b/a/c:a	B
    //   828: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   831: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 433	com/tencent/beacon/upload/i:a	(IJZJIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   837: aload_1
    //   838: iload 7
    //   840: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   843: return
    //   844: iconst_0
    //   845: istore 7
    //   847: goto -140 -> 707
    //   850: iload_3
    //   851: istore_2
    //   852: iload 7
    //   854: istore 8
    //   856: iload 7
    //   858: istore 9
    //   860: invokestatic 389	com/tencent/beacon/a/d:m	()Lcom/tencent/beacon/a/d;
    //   863: astore 19
    //   865: aload 19
    //   867: ifnull +128 -> 995
    //   870: iload_3
    //   871: istore_2
    //   872: iload 7
    //   874: istore 8
    //   876: iload 7
    //   878: istore 9
    //   880: aload 18
    //   882: getfield 434	com/tencent/beacon/b/a/c:d	Ljava/lang/String;
    //   885: ifnull +26 -> 911
    //   888: iload_3
    //   889: istore_2
    //   890: iload 7
    //   892: istore 8
    //   894: iload 7
    //   896: istore 9
    //   898: aload 19
    //   900: aload 18
    //   902: getfield 434	com/tencent/beacon/b/a/c:d	Ljava/lang/String;
    //   905: invokevirtual 332	java/lang/String:trim	()Ljava/lang/String;
    //   908: invokevirtual 435	com/tencent/beacon/a/d:b	(Ljava/lang/String;)V
    //   911: iload_3
    //   912: istore_2
    //   913: iload 7
    //   915: istore 8
    //   917: iload 7
    //   919: istore 9
    //   921: new 394	java/util/Date
    //   924: dup
    //   925: invokespecial 395	java/util/Date:<init>	()V
    //   928: astore 22
    //   930: iload_3
    //   931: istore_2
    //   932: iload 7
    //   934: istore 8
    //   936: iload 7
    //   938: istore 9
    //   940: aload 19
    //   942: aload 18
    //   944: getfield 438	com/tencent/beacon/b/a/c:e	J
    //   947: aload 22
    //   949: invokevirtual 398	java/util/Date:getTime	()J
    //   952: lsub
    //   953: invokevirtual 441	com/tencent/beacon/a/d:a	(J)V
    //   956: iload_3
    //   957: istore_2
    //   958: iload 7
    //   960: istore 8
    //   962: iload 7
    //   964: istore 9
    //   966: ldc_w 443
    //   969: iconst_2
    //   970: anewarray 4	java/lang/Object
    //   973: dup
    //   974: iconst_0
    //   975: aload 19
    //   977: invokevirtual 445	com/tencent/beacon/a/d:g	()Ljava/lang/String;
    //   980: aastore
    //   981: dup
    //   982: iconst_1
    //   983: aload 19
    //   985: invokevirtual 392	com/tencent/beacon/a/d:h	()J
    //   988: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   991: aastore
    //   992: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   995: iload_3
    //   996: istore_2
    //   997: iload 7
    //   999: istore 8
    //   1001: iload 7
    //   1003: istore 9
    //   1005: aload 18
    //   1007: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   1010: bipush 101
    //   1012: if_icmpeq +43 -> 1055
    //   1015: iload_3
    //   1016: istore_2
    //   1017: iload 7
    //   1019: istore 8
    //   1021: iload 7
    //   1023: istore 9
    //   1025: aload 18
    //   1027: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   1030: bipush 103
    //   1032: if_icmpeq +23 -> 1055
    //   1035: iload_3
    //   1036: istore_2
    //   1037: iload 7
    //   1039: istore 8
    //   1041: iload 7
    //   1043: istore 9
    //   1045: aload 18
    //   1047: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   1050: bipush 105
    //   1052: if_icmpne +112 -> 1164
    //   1055: iload_3
    //   1056: istore_2
    //   1057: iload 7
    //   1059: istore 8
    //   1061: iload 7
    //   1063: istore 9
    //   1065: aload_0
    //   1066: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   1069: invokestatic 455	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   1072: invokevirtual 457	com/tencent/beacon/a/b/b:e	()Lcom/tencent/beacon/a/b/d;
    //   1075: astore 19
    //   1077: aload 19
    //   1079: ifnull +85 -> 1164
    //   1082: iload_3
    //   1083: istore_2
    //   1084: iload 7
    //   1086: istore 8
    //   1088: iload 7
    //   1090: istore 9
    //   1092: aload 19
    //   1094: invokevirtual 459	com/tencent/beacon/a/b/d:m	()Ljava/lang/String;
    //   1097: ifnull +47 -> 1144
    //   1100: iload_3
    //   1101: istore_2
    //   1102: iload 7
    //   1104: istore 8
    //   1106: iload 7
    //   1108: istore 9
    //   1110: aload 18
    //   1112: getfield 461	com/tencent/beacon/b/a/c:f	Ljava/lang/String;
    //   1115: ifnull +49 -> 1164
    //   1118: iload_3
    //   1119: istore_2
    //   1120: iload 7
    //   1122: istore 8
    //   1124: iload 7
    //   1126: istore 9
    //   1128: aload 19
    //   1130: invokevirtual 459	com/tencent/beacon/a/b/d:m	()Ljava/lang/String;
    //   1133: aload 18
    //   1135: getfield 461	com/tencent/beacon/b/a/c:f	Ljava/lang/String;
    //   1138: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1141: ifne +23 -> 1164
    //   1144: iload_3
    //   1145: istore_2
    //   1146: iload 7
    //   1148: istore 8
    //   1150: iload 7
    //   1152: istore 9
    //   1154: aload 19
    //   1156: aload 18
    //   1158: getfield 461	com/tencent/beacon/b/a/c:f	Ljava/lang/String;
    //   1161: invokevirtual 462	com/tencent/beacon/a/b/d:b	(Ljava/lang/String;)V
    //   1164: iload_3
    //   1165: istore_2
    //   1166: iload 7
    //   1168: istore 8
    //   1170: iload 7
    //   1172: istore 9
    //   1174: aload 18
    //   1176: getfield 465	com/tencent/beacon/b/a/c:c	[B
    //   1179: astore 19
    //   1181: aload 19
    //   1183: ifnonnull +131 -> 1314
    //   1186: iload_3
    //   1187: istore_2
    //   1188: iload 7
    //   1190: istore 8
    //   1192: iload 7
    //   1194: istore 9
    //   1196: ldc_w 467
    //   1199: iconst_0
    //   1200: anewarray 4	java/lang/Object
    //   1203: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1206: goto -454 -> 752
    //   1209: astore 18
    //   1211: aload 21
    //   1213: invokevirtual 407	com/tencent/beacon/upload/e:a	()J
    //   1216: lstore 14
    //   1218: aload 21
    //   1220: invokevirtual 409	com/tencent/beacon/upload/e:b	()J
    //   1223: lstore 16
    //   1225: aload 18
    //   1227: invokevirtual 468	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1230: ldc_w 470
    //   1233: ldc_w 327
    //   1236: invokevirtual 474	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1239: astore 19
    //   1241: aload_0
    //   1242: iload 5
    //   1244: iload_2
    //   1245: lload 14
    //   1247: lload 16
    //   1249: iconst_0
    //   1250: aload 19
    //   1252: invokespecial 342	com/tencent/beacon/upload/i:a	(IIJJZLjava/lang/String;)V
    //   1255: iload 5
    //   1257: lload 14
    //   1259: iconst_0
    //   1260: lload 12
    //   1262: aload 21
    //   1264: invokevirtual 424	com/tencent/beacon/upload/e:d	()J
    //   1267: l2i
    //   1268: aload_1
    //   1269: invokevirtual 426	com/tencent/beacon/upload/a:f	()I
    //   1272: aload 20
    //   1274: aload 21
    //   1276: invokevirtual 427	com/tencent/beacon/upload/e:e	()Ljava/lang/String;
    //   1279: aload 21
    //   1281: invokevirtual 428	com/tencent/beacon/upload/e:c	()I
    //   1284: aload 19
    //   1286: invokestatic 433	com/tencent/beacon/upload/i:a	(IJZJIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   1289: ldc_w 476
    //   1292: iconst_1
    //   1293: anewarray 4	java/lang/Object
    //   1296: dup
    //   1297: iconst_0
    //   1298: aload 18
    //   1300: invokevirtual 468	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1303: aastore
    //   1304: invokestatic 232	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1307: aload_1
    //   1308: iload 8
    //   1310: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   1313: return
    //   1314: iload_3
    //   1315: istore_2
    //   1316: iload 7
    //   1318: istore 8
    //   1320: iload 7
    //   1322: istore 9
    //   1324: aload_0
    //   1325: invokespecial 478	com/tencent/beacon/upload/i:e	()Landroid/util/SparseArray;
    //   1328: astore 22
    //   1330: aload 22
    //   1332: ifnull +21 -> 1353
    //   1335: iload_3
    //   1336: istore_2
    //   1337: iload 7
    //   1339: istore 8
    //   1341: iload 7
    //   1343: istore 9
    //   1345: aload 22
    //   1347: invokevirtual 284	android/util/SparseArray:size	()I
    //   1350: ifgt +37 -> 1387
    //   1353: iload_3
    //   1354: istore_2
    //   1355: iload 7
    //   1357: istore 8
    //   1359: iload 7
    //   1361: istore 9
    //   1363: ldc_w 480
    //   1366: iconst_0
    //   1367: anewarray 4	java/lang/Object
    //   1370: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1373: goto -621 -> 752
    //   1376: astore 18
    //   1378: aload_1
    //   1379: iload 9
    //   1381: invokevirtual 301	com/tencent/beacon/upload/a:b	(Z)V
    //   1384: aload 18
    //   1386: athrow
    //   1387: iload_3
    //   1388: istore_2
    //   1389: iload 7
    //   1391: istore 8
    //   1393: iload 7
    //   1395: istore 9
    //   1397: aload_1
    //   1398: invokevirtual 298	com/tencent/beacon/upload/a:c	()I
    //   1401: istore 4
    //   1403: iload_3
    //   1404: istore_2
    //   1405: iload 7
    //   1407: istore 8
    //   1409: iload 7
    //   1411: istore 9
    //   1413: aload 18
    //   1415: getfield 412	com/tencent/beacon/b/a/c:b	I
    //   1418: istore 6
    //   1420: iload_3
    //   1421: istore_2
    //   1422: iload 7
    //   1424: istore 8
    //   1426: iload 7
    //   1428: istore 9
    //   1430: aload 18
    //   1432: getfield 415	com/tencent/beacon/b/a/c:a	B
    //   1435: ifne +143 -> 1578
    //   1438: iload 4
    //   1440: ifle +138 -> 1578
    //   1443: iload 4
    //   1445: iconst_5
    //   1446: if_icmpgt +132 -> 1578
    //   1449: iload_3
    //   1450: istore_2
    //   1451: iload 7
    //   1453: istore 8
    //   1455: iload 7
    //   1457: istore 9
    //   1459: new 200	com/tencent/beacon/d/b
    //   1462: dup
    //   1463: aload_0
    //   1464: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   1467: invokespecial 203	com/tencent/beacon/d/b:<init>	(Landroid/content/Context;)V
    //   1470: astore 23
    //   1472: iload_3
    //   1473: istore_2
    //   1474: iload 7
    //   1476: istore 8
    //   1478: iload 7
    //   1480: istore 9
    //   1482: ldc_w 327
    //   1485: aload_0
    //   1486: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   1489: invokestatic 195	com/tencent/beacon/a/j:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/j;
    //   1492: invokevirtual 482	com/tencent/beacon/a/j:b	()Ljava/lang/String;
    //   1495: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1498: ifeq +80 -> 1578
    //   1501: iload_3
    //   1502: istore_2
    //   1503: iload 7
    //   1505: istore 8
    //   1507: iload 7
    //   1509: istore 9
    //   1511: invokestatic 69	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   1514: invokevirtual 485	com/tencent/beacon/a/b/d:j	()Z
    //   1517: ifne +61 -> 1578
    //   1520: iload_3
    //   1521: istore_2
    //   1522: iload 7
    //   1524: istore 8
    //   1526: iload 7
    //   1528: istore 9
    //   1530: new 487	com/tencent/beacon/upload/d
    //   1533: dup
    //   1534: aload_0
    //   1535: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   1538: invokespecial 488	com/tencent/beacon/upload/d:<init>	(Landroid/content/Context;)V
    //   1541: astore 24
    //   1543: iload_3
    //   1544: istore_2
    //   1545: iload 7
    //   1547: istore 8
    //   1549: iload 7
    //   1551: istore 9
    //   1553: invokestatic 491	com/tencent/beacon/a/b/b:c	()Lcom/tencent/beacon/upload/h;
    //   1556: aload 24
    //   1558: invokeinterface 493 2 0
    //   1563: iload_3
    //   1564: istore_2
    //   1565: iload 7
    //   1567: istore 8
    //   1569: iload 7
    //   1571: istore 9
    //   1573: aload 23
    //   1575: invokevirtual 495	com/tencent/beacon/d/b:c	()V
    //   1578: iload 6
    //   1580: ifne +259 -> 1839
    //   1583: iload_3
    //   1584: istore_2
    //   1585: iload 7
    //   1587: istore 8
    //   1589: iload 7
    //   1591: istore 9
    //   1593: ldc_w 497
    //   1596: iconst_0
    //   1597: anewarray 4	java/lang/Object
    //   1600: invokestatic 117	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1603: goto -851 -> 752
    //   1606: iload_3
    //   1607: istore_2
    //   1608: iload 7
    //   1610: istore 8
    //   1612: iload 7
    //   1614: istore 9
    //   1616: ldc_w 499
    //   1619: iconst_1
    //   1620: anewarray 4	java/lang/Object
    //   1623: dup
    //   1624: iconst_0
    //   1625: iload 4
    //   1627: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1630: aastore
    //   1631: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1634: goto -882 -> 752
    //   1637: iload 6
    //   1639: bipush 101
    //   1641: if_icmpeq +134 -> 1775
    //   1644: iload_3
    //   1645: istore_2
    //   1646: iload 7
    //   1648: istore 8
    //   1650: iload 7
    //   1652: istore 9
    //   1654: ldc_w 501
    //   1657: iconst_2
    //   1658: anewarray 4	java/lang/Object
    //   1661: dup
    //   1662: iconst_0
    //   1663: iload 4
    //   1665: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1668: aastore
    //   1669: dup
    //   1670: iconst_1
    //   1671: iload 6
    //   1673: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1676: aastore
    //   1677: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1680: goto -928 -> 752
    //   1683: iload 6
    //   1685: bipush 105
    //   1687: if_icmpeq +88 -> 1775
    //   1690: iload_3
    //   1691: istore_2
    //   1692: iload 7
    //   1694: istore 8
    //   1696: iload 7
    //   1698: istore 9
    //   1700: ldc_w 501
    //   1703: iconst_2
    //   1704: anewarray 4	java/lang/Object
    //   1707: dup
    //   1708: iconst_0
    //   1709: iload 4
    //   1711: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1714: aastore
    //   1715: dup
    //   1716: iconst_1
    //   1717: iload 6
    //   1719: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1722: aastore
    //   1723: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1726: goto -974 -> 752
    //   1729: iload 6
    //   1731: bipush 103
    //   1733: if_icmpeq +42 -> 1775
    //   1736: iload_3
    //   1737: istore_2
    //   1738: iload 7
    //   1740: istore 8
    //   1742: iload 7
    //   1744: istore 9
    //   1746: ldc_w 503
    //   1749: iconst_2
    //   1750: anewarray 4	java/lang/Object
    //   1753: dup
    //   1754: iconst_0
    //   1755: iload 4
    //   1757: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1760: aastore
    //   1761: dup
    //   1762: iconst_1
    //   1763: iload 6
    //   1765: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1768: aastore
    //   1769: invokestatic 173	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1772: goto -1020 -> 752
    //   1775: iload_3
    //   1776: istore_2
    //   1777: iload 7
    //   1779: istore 8
    //   1781: iload 7
    //   1783: istore 9
    //   1785: aload_0
    //   1786: aload 22
    //   1788: iload 6
    //   1790: aload 19
    //   1792: invokespecial 505	com/tencent/beacon/upload/i:a	(Landroid/util/SparseArray;I[B)Z
    //   1795: pop
    //   1796: goto -1044 -> 752
    //   1799: astore 18
    //   1801: iload 8
    //   1803: istore 9
    //   1805: goto -427 -> 1378
    //   1808: astore 23
    //   1810: goto -232 -> 1578
    //   1813: aload 19
    //   1815: astore 18
    //   1817: goto -1210 -> 607
    //   1820: aload 20
    //   1822: astore 18
    //   1824: goto -1471 -> 353
    //   1827: aload_1
    //   1828: ifnull -1076 -> 752
    //   1831: aload 18
    //   1833: ifnonnull -983 -> 850
    //   1836: goto -1084 -> 752
    //   1839: iload 4
    //   1841: lookupswitch	default:+35->1876, 4:+-158->1683, 100:+-204->1637, 102:+-112->1729
    //   1877: impdep1
    //   1878: <illegal opcode>
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1879	0	this	i
    //   0	1879	1	parama	a
    //   524	1253	2	i	int
    //   663	1113	3	j	int
    //   152	1688	4	k	int
    //   140	1116	5	m	int
    //   1418	371	6	n	int
    //   146	1636	7	bool1	boolean
    //   527	1275	8	bool2	boolean
    //   531	1273	9	bool3	boolean
    //   149	540	10	bool4	boolean
    //   143	550	11	bool5	boolean
    //   520	741	12	l1	long
    //   623	635	14	l2	long
    //   641	607	16	l3	long
    //   229	946	18	localObject1	Object
    //   1209	90	18	localThrowable	Throwable
    //   1376	55	18	localObject2	Object
    //   1799	1	18	localObject3	Object
    //   1815	17	18	localObject4	Object
    //   226	1588	19	localObject5	Object
    //   158	1663	20	str	String
    //   259	1021	21	localObject6	Object
    //   220	1567	22	localObject7	Object
    //   450	1124	23	localObject8	Object
    //   1808	1	23	localException	java.lang.Exception
    //   1541	16	24	locald	d
    // Exception table:
    //   from	to	target	type
    //   533	547	1209	java/lang/Throwable
    //   570	581	1209	java/lang/Throwable
    //   592	607	1209	java/lang/Throwable
    //   618	625	1209	java/lang/Throwable
    //   636	643	1209	java/lang/Throwable
    //   654	661	1209	java/lang/Throwable
    //   680	686	1209	java/lang/Throwable
    //   696	704	1209	java/lang/Throwable
    //   717	749	1209	java/lang/Throwable
    //   762	776	1209	java/lang/Throwable
    //   786	837	1209	java/lang/Throwable
    //   860	865	1209	java/lang/Throwable
    //   880	888	1209	java/lang/Throwable
    //   898	911	1209	java/lang/Throwable
    //   921	930	1209	java/lang/Throwable
    //   940	956	1209	java/lang/Throwable
    //   966	995	1209	java/lang/Throwable
    //   1005	1015	1209	java/lang/Throwable
    //   1025	1035	1209	java/lang/Throwable
    //   1045	1055	1209	java/lang/Throwable
    //   1065	1077	1209	java/lang/Throwable
    //   1092	1100	1209	java/lang/Throwable
    //   1110	1118	1209	java/lang/Throwable
    //   1128	1144	1209	java/lang/Throwable
    //   1154	1164	1209	java/lang/Throwable
    //   1174	1181	1209	java/lang/Throwable
    //   1196	1206	1209	java/lang/Throwable
    //   1324	1330	1209	java/lang/Throwable
    //   1345	1353	1209	java/lang/Throwable
    //   1363	1373	1209	java/lang/Throwable
    //   1397	1403	1209	java/lang/Throwable
    //   1413	1420	1209	java/lang/Throwable
    //   1430	1438	1209	java/lang/Throwable
    //   1459	1472	1209	java/lang/Throwable
    //   1482	1501	1209	java/lang/Throwable
    //   1511	1520	1209	java/lang/Throwable
    //   1530	1543	1209	java/lang/Throwable
    //   1553	1563	1209	java/lang/Throwable
    //   1573	1578	1209	java/lang/Throwable
    //   1593	1603	1209	java/lang/Throwable
    //   1616	1634	1209	java/lang/Throwable
    //   1654	1680	1209	java/lang/Throwable
    //   1700	1726	1209	java/lang/Throwable
    //   1746	1772	1209	java/lang/Throwable
    //   1785	1796	1209	java/lang/Throwable
    //   533	547	1376	finally
    //   570	581	1376	finally
    //   592	607	1376	finally
    //   618	625	1376	finally
    //   636	643	1376	finally
    //   654	661	1376	finally
    //   680	686	1376	finally
    //   696	704	1376	finally
    //   717	749	1376	finally
    //   762	776	1376	finally
    //   786	837	1376	finally
    //   860	865	1376	finally
    //   880	888	1376	finally
    //   898	911	1376	finally
    //   921	930	1376	finally
    //   940	956	1376	finally
    //   966	995	1376	finally
    //   1005	1015	1376	finally
    //   1025	1035	1376	finally
    //   1045	1055	1376	finally
    //   1065	1077	1376	finally
    //   1092	1100	1376	finally
    //   1110	1118	1376	finally
    //   1128	1144	1376	finally
    //   1154	1164	1376	finally
    //   1174	1181	1376	finally
    //   1196	1206	1376	finally
    //   1324	1330	1376	finally
    //   1345	1353	1376	finally
    //   1363	1373	1376	finally
    //   1397	1403	1376	finally
    //   1413	1420	1376	finally
    //   1430	1438	1376	finally
    //   1459	1472	1376	finally
    //   1482	1501	1376	finally
    //   1511	1520	1376	finally
    //   1530	1543	1376	finally
    //   1553	1563	1376	finally
    //   1573	1578	1376	finally
    //   1593	1603	1376	finally
    //   1616	1634	1376	finally
    //   1654	1680	1376	finally
    //   1700	1726	1376	finally
    //   1746	1772	1376	finally
    //   1785	1796	1376	finally
    //   1211	1307	1799	finally
    //   1482	1501	1808	java/lang/Exception
    //   1511	1520	1808	java/lang/Exception
    //   1530	1543	1808	java/lang/Exception
    //   1553	1563	1808	java/lang/Exception
    //   1573	1578	1808	java/lang/Exception
  }
  
  public final void a(boolean paramBoolean)
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
  
  public final boolean a(g paramg)
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
        this.b.append(101, paramg);
        bool = true;
      }
      finally {}
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/beacon/upload/i:e	Landroid/content/Context;
    //   6: invokestatic 518	com/tencent/beacon/a/f:s	(Landroid/content/Context;)Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +9 -> 20
    //   14: iconst_1
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 48	com/tencent/beacon/upload/i:g	Z
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	i
    //   9	16	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	28	finally
    //   20	25	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.i
 * JD-Core Version:    0.7.0.1
 */