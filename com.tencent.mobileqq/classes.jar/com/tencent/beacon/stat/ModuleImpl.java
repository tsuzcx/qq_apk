package com.tencent.beacon.stat;

import android.content.Context;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.d.l;
import com.tencent.beacon.core.event.t;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ModuleImpl
  extends c
  implements l
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
  private final ConcurrentHashMap<Integer, g> buffer = new ConcurrentHashMap();
  private a<Long> commonEventCalls = new a();
  private a<Long> commonEventWriteSucc = new a();
  private Runnable doReadSyncTask = new f(this);
  private Runnable doWriteSyncTask = new e(this);
  private a<Byte> eventCallsMod = new a();
  private boolean eventSerialNumberEnable = true;
  public boolean isEnable = true;
  private int maxCnt = 5;
  private a<String> onQuaDate = new a();
  private a<com.tencent.beacon.core.a.f> quaSharedPrefs = new a();
  private a<Long> realTimeEventCalls = new a();
  private a<Long> realTimeEventUploadSucc = new a();
  private a<Long> realTimeEventWriteSucc = new a();
  private int uploadCnt;
  
  private ModuleImpl(Context paramContext)
  {
    super(paramContext);
    this.eventCallsMod.a(Byte.valueOf((byte)0));
    com.tencent.beacon.core.a.d.a().a(this.doReadSyncTask);
    k.a(this.mContext).a(this);
  }
  
  private String getBuffer()
  {
    Object localObject = this.buffer;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.buffer.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        g localg = (g)localEntry.getValue();
        ((StringBuilder)localObject).append(localEntry.getKey()).append(",").append(localg.c()).append(",").append(localg.b()).append(";");
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  private String getDetailBuffer()
  {
    Object localObject = this.buffer;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Iterator localIterator1 = this.buffer.entrySet().iterator();
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((g)((Map.Entry)localIterator1.next()).getValue()).a().iterator();
        label73:
        h localh;
        StringBuilder localStringBuilder2;
        if (localIterator2.hasNext())
        {
          localh = (h)localIterator2.next();
          localStringBuilder2 = localStringBuilder1.append(localh.a).append(",").append(localh.b).append(",");
          if (!localh.c) {
            break label241;
          }
        }
        label241:
        for (localObject = "Y";; localObject = "N")
        {
          localStringBuilder2.append((String)localObject).append(",").append(localh.d).append(",").append(localh.e).append(",").append(localh.f).append(",").append(localh.g).append(",").append(localh.h).append(",").append(localh.i).append(",").append(localh.j).append(";");
          break label73;
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
    //   1: getfield 66	com/tencent/beacon/stat/ModuleImpl:isEnable	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 86	com/tencent/beacon/stat/ModuleImpl:eventCallsMod	Lcom/tencent/beacon/stat/a;
    //   12: astore_3
    //   13: aload_3
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 86	com/tencent/beacon/stat/ModuleImpl:eventCallsMod	Lcom/tencent/beacon/stat/a;
    //   19: invokevirtual 269	com/tencent/beacon/stat/a:a	()Ljava/lang/Object;
    //   22: checkcast 109	java/lang/Byte
    //   25: invokevirtual 273	java/lang/Byte:byteValue	()B
    //   28: iconst_1
    //   29: iadd
    //   30: i2b
    //   31: istore_2
    //   32: iload_2
    //   33: istore_1
    //   34: iload_2
    //   35: getstatic 275	com/tencent/beacon/stat/ModuleImpl:MAX_EVENT_CALLS_SYNC	I
    //   38: if_icmplt +15 -> 53
    //   41: invokestatic 122	com/tencent/beacon/core/a/d:a	()Lcom/tencent/beacon/core/a/d;
    //   44: aload_0
    //   45: getfield 97	com/tencent/beacon/stat/ModuleImpl:doWriteSyncTask	Ljava/lang/Runnable;
    //   48: invokevirtual 125	com/tencent/beacon/core/a/d:a	(Ljava/lang/Runnable;)V
    //   51: iconst_0
    //   52: istore_1
    //   53: aload_0
    //   54: getfield 86	com/tencent/beacon/stat/ModuleImpl:eventCallsMod	Lcom/tencent/beacon/stat/a;
    //   57: iload_1
    //   58: invokestatic 113	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   61: invokevirtual 117	com/tencent/beacon/stat/a:a	(Ljava/lang/Object;)V
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
    //   78: invokestatic 280	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
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
      if (!com.tencent.beacon.core.e.b.a().equals(this.onQuaDate.a()))
      {
        this.onQuaDate.a(com.tencent.beacon.core.e.b.a());
        this.commonEventCalls.a(Long.valueOf(0L));
        this.realTimeEventCalls.a(Long.valueOf(0L));
        this.commonEventWriteSucc.a(Long.valueOf(0L));
        this.realTimeEventWriteSucc.a(Long.valueOf(0L));
        this.realTimeEventUploadSucc.a(Long.valueOf(0L));
        com.tencent.beacon.core.a.d.a().a(this.doWriteSyncTask);
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.core.e.d.a(localException);
    }
  }
  
  public String getAppFirstInstallTime()
  {
    if (this.eventSerialNumberEnable) {
      return com.tencent.beacon.core.e.b.b(this.mContext);
    }
    return "";
  }
  
  public String getEventSerialNumber(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = null;
    if (this.eventSerialNumberEnable) {
      str = d.a(this.mContext, paramString1).a(paramString2, paramBoolean);
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
      com.tencent.beacon.core.e.d.a(localException);
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
          com.tencent.beacon.core.a.d.a().a(this.doWriteSyncTask);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.core.e.d.a(localException);
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
      com.tencent.beacon.core.e.d.a(localException);
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
          com.tencent.beacon.core.a.d.a().a(this.doWriteSyncTask);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.core.e.d.a(localException);
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
          com.tencent.beacon.core.a.d.a().a(this.doWriteSyncTask);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.core.e.d.a(localException);
      }
    }
  }
  
  public void onModuleStarted()
  {
    super.onModuleStarted();
    com.tencent.beacon.core.e.d.d("[module] stat module > %S", new Object[] { Boolean.valueOf(this.isEnable) });
  }
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap)
  {
    super.onModuleStrategyUpdated(paramInt, paramMap);
    if ((paramInt == 1) && (paramMap != null) && (paramMap.size() > 0))
    {
      this.isEnable = com.tencent.beacon.core.e.b.a((String)paramMap.get("upQa"), this.isEnable);
      this.eventSerialNumberEnable = com.tencent.beacon.core.e.b.a((String)paramMap.get("esnOnOff"), this.eventSerialNumberEnable);
    }
  }
  
  public void record(int paramInt1, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3)
  {
    h localh;
    for (;;)
    {
      try
      {
        boolean bool = this.isEnable;
        if (!bool) {
          return;
        }
        if (paramInt1 == 0) {
          continue;
        }
        localg = (g)this.buffer.get(Integer.valueOf(paramInt1));
        if (localg != null)
        {
          localh = new h();
          if (paramBoolean)
          {
            localg.c(localg.c() + 1);
            localh.b = paramInt1;
            localh.a = paramLong1;
            if ((paramLong2 > 0L) && (paramInt4 > 0)) {
              localh.d = ((int)paramLong2 / paramInt4);
            }
            localh.e = paramInt2;
            localh.f = paramInt3;
            localh.g = paramString1;
            localh.h = paramString2;
            localh.c = paramBoolean;
            localh.i = paramInt4;
            localh.j = paramString3;
            localg.a().add(localh);
            this.uploadCnt += 1;
            if (this.uploadCnt < this.maxCnt) {
              continue;
            }
            paramString1 = new HashMap();
            paramString1.put("B1", this.uploadCnt + "");
            paramString1.put("B2", getBuffer());
            paramString1.put("B3", getDetailBuffer());
          }
        }
      }
      finally {}
      try
      {
        paramString1.put("B4", String.valueOf(this.commonEventCalls.a()));
        paramString1.put("B5", String.valueOf(this.realTimeEventCalls.a()));
        paramString1.put("B6", String.valueOf(t.a(this.mContext, com.tencent.beacon.core.info.b.b(this.mContext).a())));
        paramString1.put("B7", String.valueOf(this.realTimeEventUploadSucc.a()));
        paramString1.put("B8", String.valueOf(this.realTimeEventWriteSucc.a()));
        paramString1.put("B9", String.valueOf(this.commonEventWriteSucc.a()));
        paramString2 = (String)this.onQuaDate.a();
        paramString1.put("B10", String.valueOf(paramString2.replace("-", "")));
      }
      catch (InterruptedException paramString2)
      {
        com.tencent.beacon.core.e.d.a(paramString2);
        continue;
      }
      if (UserAction.onUserAction(eventName, true, 0L, 0L, paramString1, true))
      {
        this.buffer.clear();
        this.uploadCnt = 0;
        this.maxCnt = 10;
        continue;
        localg.b(localg.b() + 1);
      }
    }
    g localg = new g();
    localg.a(paramInt1);
    if (paramBoolean) {
      localg.c(1);
    }
    for (;;)
    {
      localh = new h();
      localh.b = paramInt1;
      localh.a = paramLong1;
      if ((paramLong2 > 0L) && (paramInt4 > 0)) {
        localh.d = ((int)paramLong2 / paramInt4);
      }
      localh.e = paramInt2;
      localh.f = paramInt3;
      localh.g = paramString1;
      localh.h = paramString2;
      localh.c = paramBoolean;
      localh.i = paramInt4;
      localh.j = paramString3;
      localg.a().add(localh);
      this.buffer.put(Integer.valueOf(paramInt1), localg);
      break;
      localg.b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.stat.ModuleImpl
 * JD-Core Version:    0.7.0.1
 */