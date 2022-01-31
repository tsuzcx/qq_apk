package com.tencent.beacon.stat;

import android.content.Context;
import com.tencent.beacon.core.c.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ModuleImpl
  extends com.tencent.beacon.core.b
  implements j
{
  private static final String KEY_COMMON_EVENT_CALLS = "common_event_calls";
  private static final String KEY_COMMON_EVENT_WRITE_SUCC = "common_event_write_succ";
  private static final String KEY_ON_QUA_DATE = "on_qua_date";
  private static final String KEY_REAL_TIME_EVENT_CALLS = "real_time_event_calls";
  private static final String KEY_REAL_TIME_EVENT_UPLOAD_SUCC = "real_time_event_upload_succ";
  private static final String KEY_REAL_TIME_EVENT_WRITE_SUCC = "real_time_event_write_succ";
  private static int MAX_EVENT_CALLS_SYNC = 5;
  private static String eventName = "rqd_up_qua";
  private static ModuleImpl mInstance;
  private static int uploadCnt;
  private final ConcurrentHashMap<Integer, c> buffer = new ConcurrentHashMap();
  private a<Long> commonEventCalls = new a();
  private a<Long> commonEventWriteSucc = new a();
  private Runnable doReadSyncTask = new ModuleImpl.2(this);
  private Runnable doWriteSyncTask = new ModuleImpl.1(this);
  private a<Byte> eventCallsMod = new a();
  private boolean eventSerialNumberEnable = true;
  public boolean isEnable = true;
  private int maxCnt = 5;
  private a<String> onQuaDate = new a();
  private a<com.tencent.beacon.core.a.c> quaSharedPrefs = new a();
  private a<Long> realTimeEventCalls = new a();
  private a<Long> realTimeEventUploadSucc = new a();
  private a<Long> realTimeEventWriteSucc = new a();
  protected String specifiedSerialEventName;
  
  private ModuleImpl(Context paramContext)
  {
    super(paramContext);
    this.eventCallsMod.a(Byte.valueOf((byte)0));
    com.tencent.beacon.core.a.b.b().a(this.doReadSyncTask);
    com.tencent.beacon.core.c.i.a(this.mContext).a(this);
  }
  
  private String getBuffer()
  {
    if ((this.buffer != null) && (this.buffer.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.buffer.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        c localc = (c)localEntry.getValue();
        localStringBuilder.append(localEntry.getKey()).append(",").append(localc.a()).append(",").append(localc.b()).append(";");
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private String getDetailBuffer()
  {
    if ((this.buffer != null) && (this.buffer.size() > 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Iterator localIterator1 = this.buffer.entrySet().iterator();
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((c)((Map.Entry)localIterator1.next()).getValue()).c().iterator();
        label74:
        d locald;
        StringBuilder localStringBuilder2;
        if (localIterator2.hasNext())
        {
          locald = (d)localIterator2.next();
          localStringBuilder2 = localStringBuilder1.append(locald.a).append(",").append(locald.b).append(",");
          if (!locald.c) {
            break label242;
          }
        }
        label242:
        for (String str = "Y";; str = "N")
        {
          localStringBuilder2.append(str).append(",").append(locald.d).append(",").append(locald.e).append(",").append(locald.f).append(",").append(locald.g).append(",").append(locald.h).append(",").append(locald.i).append(",").append(locald.j).append(";");
          break label74;
          break;
        }
      }
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  public static ModuleImpl getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new ModuleImpl(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void incTotalCallsMod()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/tencent/beacon/stat/ModuleImpl:isEnable	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 90	com/tencent/beacon/stat/ModuleImpl:eventCallsMod	Lcom/tencent/beacon/stat/a;
    //   12: astore_3
    //   13: aload_3
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 90	com/tencent/beacon/stat/ModuleImpl:eventCallsMod	Lcom/tencent/beacon/stat/a;
    //   19: invokevirtual 273	com/tencent/beacon/stat/a:a	()Ljava/lang/Object;
    //   22: checkcast 113	java/lang/Byte
    //   25: invokevirtual 277	java/lang/Byte:byteValue	()B
    //   28: iconst_1
    //   29: iadd
    //   30: i2b
    //   31: istore_2
    //   32: iload_2
    //   33: istore_1
    //   34: iload_2
    //   35: getstatic 63	com/tencent/beacon/stat/ModuleImpl:MAX_EVENT_CALLS_SYNC	I
    //   38: if_icmplt +15 -> 53
    //   41: invokestatic 127	com/tencent/beacon/core/a/b:b	()Lcom/tencent/beacon/core/a/b;
    //   44: aload_0
    //   45: getfield 101	com/tencent/beacon/stat/ModuleImpl:doWriteSyncTask	Ljava/lang/Runnable;
    //   48: invokevirtual 130	com/tencent/beacon/core/a/b:a	(Ljava/lang/Runnable;)V
    //   51: iconst_0
    //   52: istore_1
    //   53: aload_0
    //   54: getfield 90	com/tencent/beacon/stat/ModuleImpl:eventCallsMod	Lcom/tencent/beacon/stat/a;
    //   57: iload_1
    //   58: invokestatic 117	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   61: invokevirtual 121	com/tencent/beacon/stat/a:a	(Ljava/lang/Object;)V
    //   64: aload_3
    //   65: monitorexit
    //   66: return
    //   67: astore 4
    //   69: aload_3
    //   70: monitorexit
    //   71: aload 4
    //   73: athrow
    //   74: astore 4
    //   76: aload 4
    //   78: invokestatic 282	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   81: goto -17 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ModuleImpl
    //   33	25	1	i	int
    //   31	8	2	j	int
    //   67	5	4	localObject	Object
    //   74	3	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   15	32	67	finally
    //   34	51	67	finally
    //   53	64	67	finally
    //   64	66	67	finally
    //   69	71	67	finally
    //   76	81	67	finally
    //   15	32	74	java/lang/Exception
    //   34	51	74	java/lang/Exception
    //   53	64	74	java/lang/Exception
  }
  
  private void resetAllAnotherDay()
  {
    try
    {
      if (!com.tencent.beacon.core.d.i.a().equals(this.onQuaDate.a()))
      {
        this.onQuaDate.a(com.tencent.beacon.core.d.i.a());
        this.commonEventCalls.a(Long.valueOf(0L));
        this.realTimeEventCalls.a(Long.valueOf(0L));
        this.commonEventWriteSucc.a(Long.valueOf(0L));
        this.realTimeEventWriteSucc.a(Long.valueOf(0L));
        this.realTimeEventUploadSucc.a(Long.valueOf(0L));
        com.tencent.beacon.core.a.b.b().a(this.doWriteSyncTask);
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.core.d.b.a(localException);
    }
  }
  
  public String getEventSerialNumber(String paramString)
  {
    String str = null;
    if (this.eventSerialNumberEnable) {
      str = b.a(this.mContext).a(paramString);
    }
    return str;
  }
  
  public void incCommonEventCalls()
  {
    if (!this.isEnable) {
      return;
    }
    try
    {
      resetAllAnotherDay();
      long l = ((Long)this.commonEventCalls.a()).longValue();
      this.commonEventCalls.a(Long.valueOf(l + 1L));
      incTotalCallsMod();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.core.d.b.a(localException);
    }
  }
  
  public void incCommonEventWriteSucc(int paramInt)
  {
    if (!this.isEnable) {}
    for (;;)
    {
      return;
      try
      {
        resetAllAnotherDay();
        long l = ((Long)this.commonEventWriteSucc.a()).longValue();
        this.commonEventWriteSucc.a(Long.valueOf(l + paramInt));
        if (paramInt > 1)
        {
          com.tencent.beacon.core.a.b.b().a(this.doWriteSyncTask);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.core.d.b.a(localException);
      }
    }
  }
  
  public void incRealTimeEventCalls()
  {
    if (!this.isEnable) {
      return;
    }
    try
    {
      resetAllAnotherDay();
      long l = ((Long)this.realTimeEventCalls.a()).longValue();
      this.realTimeEventCalls.a(Long.valueOf(l + 1L));
      incTotalCallsMod();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.core.d.b.a(localException);
    }
  }
  
  public void incRealTimeEventUploadSucc(int paramInt)
  {
    if (!this.isEnable) {}
    for (;;)
    {
      return;
      try
      {
        resetAllAnotherDay();
        long l = ((Long)this.realTimeEventUploadSucc.a()).longValue();
        this.realTimeEventUploadSucc.a(Long.valueOf(l + paramInt));
        if (paramInt > 1)
        {
          com.tencent.beacon.core.a.b.b().a(this.doWriteSyncTask);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.core.d.b.a(localException);
      }
    }
  }
  
  public void incRealTimeEventWriteSucc(int paramInt)
  {
    if (!this.isEnable) {}
    for (;;)
    {
      return;
      try
      {
        resetAllAnotherDay();
        long l = ((Long)this.realTimeEventWriteSucc.a()).longValue();
        this.realTimeEventWriteSucc.a(Long.valueOf(l + paramInt));
        if (paramInt > 1)
        {
          com.tencent.beacon.core.a.b.b().a(this.doWriteSyncTask);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.core.d.b.a(localException);
      }
    }
  }
  
  public void onModuleStarted()
  {
    super.onModuleStarted();
    com.tencent.beacon.core.d.b.a("[module] stat module > %S", new Object[] { Boolean.valueOf(this.isEnable) });
  }
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap)
  {
    super.onModuleStrategyUpdated(paramInt, paramMap);
    if ((paramInt == 1) && (paramMap != null) && (paramMap.size() > 0))
    {
      this.isEnable = com.tencent.beacon.core.d.i.a((String)paramMap.get("upQa"), this.isEnable);
      this.eventSerialNumberEnable = com.tencent.beacon.core.d.i.a((String)paramMap.get("esnOnOff"), this.eventSerialNumberEnable);
      this.specifiedSerialEventName = ((String)paramMap.get("speSerEnt"));
    }
  }
  
  /* Error */
  public void record(int paramInt1, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/tencent/beacon/stat/ModuleImpl:isEnable	Z
    //   6: istore 13
    //   8: iload 13
    //   10: ifne +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: iload_1
    //   17: ifeq -4 -> 13
    //   20: aload_0
    //   21: getfield 111	com/tencent/beacon/stat/ModuleImpl:buffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: iload_1
    //   25: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 367	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 192	com/tencent/beacon/stat/c
    //   34: astore 14
    //   36: aload 14
    //   38: ifnull +433 -> 471
    //   41: new 228	com/tencent/beacon/stat/d
    //   44: dup
    //   45: invokespecial 368	com/tencent/beacon/stat/d:<init>	()V
    //   48: astore 15
    //   50: iload_2
    //   51: ifeq +405 -> 456
    //   54: aload 14
    //   56: aload 14
    //   58: invokevirtual 206	com/tencent/beacon/stat/c:a	()I
    //   61: iconst_1
    //   62: iadd
    //   63: invokevirtual 370	com/tencent/beacon/stat/c:b	(I)V
    //   66: aload 15
    //   68: iload_1
    //   69: putfield 236	com/tencent/beacon/stat/d:b	I
    //   72: aload 15
    //   74: lload_3
    //   75: putfield 231	com/tencent/beacon/stat/d:a	J
    //   78: lload 5
    //   80: lconst_0
    //   81: lcmp
    //   82: ifle +19 -> 101
    //   85: iload 11
    //   87: ifle +14 -> 101
    //   90: aload 15
    //   92: lload 5
    //   94: l2i
    //   95: iload 11
    //   97: idiv
    //   98: putfield 243	com/tencent/beacon/stat/d:d	I
    //   101: aload 15
    //   103: iload 7
    //   105: putfield 246	com/tencent/beacon/stat/d:e	I
    //   108: aload 15
    //   110: iload 8
    //   112: putfield 249	com/tencent/beacon/stat/d:f	I
    //   115: aload 15
    //   117: aload 9
    //   119: putfield 252	com/tencent/beacon/stat/d:g	Ljava/lang/String;
    //   122: aload 15
    //   124: aload 10
    //   126: putfield 255	com/tencent/beacon/stat/d:h	Ljava/lang/String;
    //   129: aload 15
    //   131: iload_2
    //   132: putfield 238	com/tencent/beacon/stat/d:c	Z
    //   135: aload 15
    //   137: iload 11
    //   139: putfield 258	com/tencent/beacon/stat/d:i	I
    //   142: aload 15
    //   144: aload 12
    //   146: putfield 261	com/tencent/beacon/stat/d:j	Ljava/lang/String;
    //   149: aload 14
    //   151: invokevirtual 223	com/tencent/beacon/stat/c:c	()Ljava/util/List;
    //   154: aload 15
    //   156: invokeinterface 373 2 0
    //   161: pop
    //   162: getstatic 375	com/tencent/beacon/stat/ModuleImpl:uploadCnt	I
    //   165: iconst_1
    //   166: iadd
    //   167: istore_1
    //   168: iload_1
    //   169: putstatic 375	com/tencent/beacon/stat/ModuleImpl:uploadCnt	I
    //   172: iload_1
    //   173: aload_0
    //   174: getfield 94	com/tencent/beacon/stat/ModuleImpl:maxCnt	I
    //   177: if_icmplt -164 -> 13
    //   180: new 377	java/util/HashMap
    //   183: dup
    //   184: invokespecial 378	java/util/HashMap:<init>	()V
    //   187: astore 9
    //   189: aload 9
    //   191: ldc_w 380
    //   194: new 164	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   201: getstatic 375	com/tencent/beacon/stat/ModuleImpl:uploadCnt	I
    //   204: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokeinterface 384 3 0
    //   215: pop
    //   216: aload 9
    //   218: ldc_w 386
    //   221: aload_0
    //   222: invokespecial 388	com/tencent/beacon/stat/ModuleImpl:getBuffer	()Ljava/lang/String;
    //   225: invokeinterface 384 3 0
    //   230: pop
    //   231: aload 9
    //   233: ldc_w 390
    //   236: aload_0
    //   237: invokespecial 392	com/tencent/beacon/stat/ModuleImpl:getDetailBuffer	()Ljava/lang/String;
    //   240: invokeinterface 384 3 0
    //   245: pop
    //   246: aload 9
    //   248: ldc_w 394
    //   251: aload_0
    //   252: getfield 80	com/tencent/beacon/stat/ModuleImpl:commonEventCalls	Lcom/tencent/beacon/stat/a;
    //   255: invokevirtual 273	com/tencent/beacon/stat/a:a	()Ljava/lang/Object;
    //   258: invokestatic 397	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   261: invokeinterface 384 3 0
    //   266: pop
    //   267: aload 9
    //   269: ldc_w 399
    //   272: aload_0
    //   273: getfield 82	com/tencent/beacon/stat/ModuleImpl:realTimeEventCalls	Lcom/tencent/beacon/stat/a;
    //   276: invokevirtual 273	com/tencent/beacon/stat/a:a	()Ljava/lang/Object;
    //   279: invokestatic 397	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   282: invokeinterface 384 3 0
    //   287: pop
    //   288: aload 9
    //   290: ldc_w 401
    //   293: aload_0
    //   294: getfield 134	com/tencent/beacon/stat/ModuleImpl:mContext	Landroid/content/Context;
    //   297: aload_0
    //   298: getfield 134	com/tencent/beacon/stat/ModuleImpl:mContext	Landroid/content/Context;
    //   301: invokestatic 406	com/tencent/beacon/core/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/b/b;
    //   304: invokevirtual 408	com/tencent/beacon/core/b/b:b	()Ljava/lang/String;
    //   307: invokestatic 413	com/tencent/beacon/core/event/k:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   310: invokestatic 416	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   313: invokeinterface 384 3 0
    //   318: pop
    //   319: aload 9
    //   321: ldc_w 418
    //   324: aload_0
    //   325: getfield 88	com/tencent/beacon/stat/ModuleImpl:realTimeEventUploadSucc	Lcom/tencent/beacon/stat/a;
    //   328: invokevirtual 273	com/tencent/beacon/stat/a:a	()Ljava/lang/Object;
    //   331: invokestatic 397	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   334: invokeinterface 384 3 0
    //   339: pop
    //   340: aload 9
    //   342: ldc_w 420
    //   345: aload_0
    //   346: getfield 86	com/tencent/beacon/stat/ModuleImpl:realTimeEventWriteSucc	Lcom/tencent/beacon/stat/a;
    //   349: invokevirtual 273	com/tencent/beacon/stat/a:a	()Ljava/lang/Object;
    //   352: invokestatic 397	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   355: invokeinterface 384 3 0
    //   360: pop
    //   361: aload 9
    //   363: ldc_w 422
    //   366: aload_0
    //   367: getfield 84	com/tencent/beacon/stat/ModuleImpl:commonEventWriteSucc	Lcom/tencent/beacon/stat/a;
    //   370: invokevirtual 273	com/tencent/beacon/stat/a:a	()Ljava/lang/Object;
    //   373: invokestatic 397	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   376: invokeinterface 384 3 0
    //   381: pop
    //   382: aload 9
    //   384: ldc_w 424
    //   387: aload_0
    //   388: getfield 78	com/tencent/beacon/stat/ModuleImpl:onQuaDate	Lcom/tencent/beacon/stat/a;
    //   391: invokevirtual 273	com/tencent/beacon/stat/a:a	()Ljava/lang/Object;
    //   394: checkcast 288	java/lang/String
    //   397: ldc_w 426
    //   400: ldc 218
    //   402: invokevirtual 430	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   405: invokestatic 397	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   408: invokeinterface 384 3 0
    //   413: pop
    //   414: getstatic 61	com/tencent/beacon/stat/ModuleImpl:eventName	Ljava/lang/String;
    //   417: iconst_1
    //   418: lconst_0
    //   419: lconst_0
    //   420: aload 9
    //   422: iconst_1
    //   423: invokestatic 436	com/tencent/beacon/event/UserAction:onUserAction	(Ljava/lang/String;ZJJLjava/util/Map;Z)Z
    //   426: ifeq -413 -> 13
    //   429: aload_0
    //   430: getfield 111	com/tencent/beacon/stat/ModuleImpl:buffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   433: invokevirtual 439	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   436: iconst_0
    //   437: putstatic 375	com/tencent/beacon/stat/ModuleImpl:uploadCnt	I
    //   440: aload_0
    //   441: bipush 10
    //   443: putfield 94	com/tencent/beacon/stat/ModuleImpl:maxCnt	I
    //   446: goto -433 -> 13
    //   449: astore 9
    //   451: aload_0
    //   452: monitorexit
    //   453: aload 9
    //   455: athrow
    //   456: aload 14
    //   458: aload 14
    //   460: invokevirtual 211	com/tencent/beacon/stat/c:b	()I
    //   463: iconst_1
    //   464: iadd
    //   465: invokevirtual 441	com/tencent/beacon/stat/c:c	(I)V
    //   468: goto -402 -> 66
    //   471: new 192	com/tencent/beacon/stat/c
    //   474: dup
    //   475: invokespecial 442	com/tencent/beacon/stat/c:<init>	()V
    //   478: astore 14
    //   480: aload 14
    //   482: iload_1
    //   483: invokevirtual 444	com/tencent/beacon/stat/c:a	(I)V
    //   486: iload_2
    //   487: ifeq +131 -> 618
    //   490: aload 14
    //   492: iconst_1
    //   493: invokevirtual 370	com/tencent/beacon/stat/c:b	(I)V
    //   496: new 228	com/tencent/beacon/stat/d
    //   499: dup
    //   500: invokespecial 368	com/tencent/beacon/stat/d:<init>	()V
    //   503: astore 15
    //   505: aload 15
    //   507: iload_1
    //   508: putfield 236	com/tencent/beacon/stat/d:b	I
    //   511: aload 15
    //   513: lload_3
    //   514: putfield 231	com/tencent/beacon/stat/d:a	J
    //   517: lload 5
    //   519: lconst_0
    //   520: lcmp
    //   521: ifle +19 -> 540
    //   524: iload 11
    //   526: ifle +14 -> 540
    //   529: aload 15
    //   531: lload 5
    //   533: l2i
    //   534: iload 11
    //   536: idiv
    //   537: putfield 243	com/tencent/beacon/stat/d:d	I
    //   540: aload 15
    //   542: iload 7
    //   544: putfield 246	com/tencent/beacon/stat/d:e	I
    //   547: aload 15
    //   549: iload 8
    //   551: putfield 249	com/tencent/beacon/stat/d:f	I
    //   554: aload 15
    //   556: aload 9
    //   558: putfield 252	com/tencent/beacon/stat/d:g	Ljava/lang/String;
    //   561: aload 15
    //   563: aload 10
    //   565: putfield 255	com/tencent/beacon/stat/d:h	Ljava/lang/String;
    //   568: aload 15
    //   570: iload_2
    //   571: putfield 238	com/tencent/beacon/stat/d:c	Z
    //   574: aload 15
    //   576: iload 11
    //   578: putfield 258	com/tencent/beacon/stat/d:i	I
    //   581: aload 15
    //   583: aload 12
    //   585: putfield 261	com/tencent/beacon/stat/d:j	Ljava/lang/String;
    //   588: aload 14
    //   590: invokevirtual 223	com/tencent/beacon/stat/c:c	()Ljava/util/List;
    //   593: aload 15
    //   595: invokeinterface 373 2 0
    //   600: pop
    //   601: aload_0
    //   602: getfield 111	com/tencent/beacon/stat/ModuleImpl:buffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   605: iload_1
    //   606: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   609: aload 14
    //   611: invokevirtual 445	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   614: pop
    //   615: goto -453 -> 162
    //   618: aload 14
    //   620: iconst_1
    //   621: invokevirtual 441	com/tencent/beacon/stat/c:c	(I)V
    //   624: goto -128 -> 496
    //   627: astore 10
    //   629: aload 10
    //   631: invokestatic 282	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   634: goto -220 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	ModuleImpl
    //   0	637	1	paramInt1	int
    //   0	637	2	paramBoolean	boolean
    //   0	637	3	paramLong1	long
    //   0	637	5	paramLong2	long
    //   0	637	7	paramInt2	int
    //   0	637	8	paramInt3	int
    //   0	637	9	paramString1	String
    //   0	637	10	paramString2	String
    //   0	637	11	paramInt4	int
    //   0	637	12	paramString3	String
    //   6	3	13	bool	boolean
    //   34	585	14	localc	c
    //   48	546	15	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	8	449	finally
    //   20	36	449	finally
    //   41	50	449	finally
    //   54	66	449	finally
    //   66	78	449	finally
    //   90	101	449	finally
    //   101	162	449	finally
    //   162	246	449	finally
    //   246	414	449	finally
    //   414	446	449	finally
    //   456	468	449	finally
    //   471	486	449	finally
    //   490	496	449	finally
    //   496	517	449	finally
    //   529	540	449	finally
    //   540	615	449	finally
    //   618	624	449	finally
    //   629	634	449	finally
    //   246	414	627	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.stat.ModuleImpl
 * JD-Core Version:    0.7.0.1
 */