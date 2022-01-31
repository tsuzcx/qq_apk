package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.c.a;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.protocol.event.EventRecord;
import com.tencent.beacon.core.protocol.event.EventRecordPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
  extends a
{
  private List<RDBean> g = null;
  private Context h;
  private Long[] i = null;
  private boolean j = false;
  
  public i(Context paramContext, String paramString, List<RDBean> paramList)
  {
    super(paramContext, 1, 2, paramString);
    this.g = paramList;
    this.h = paramContext;
    this.e = this.g.size();
    if ((this.g.size() == 1) && ("rqd_heartbeat".equals(((RDBean)this.g.get(0)).getEN()))) {
      this.j = true;
    }
    this.d = com.tencent.beacon.core.d.i.a(paramContext, 2);
    b.b("[event] request id:%s", new Object[] { this.d });
  }
  
  private RequestPackage a(int paramInt, List<RDBean> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return null;
      try
      {
        b.b("[event] encode rd size:" + paramList.size(), new Object[0]);
        paramList = a(paramList);
        if (paramList != null)
        {
          paramList = paramList.toByteArray();
          if (paramList != null)
          {
            paramList = a(paramInt, paramList, this.f);
            return paramList;
          }
        }
      }
      catch (Throwable paramList)
      {
        b.a(paramList);
        b.d("[event] encode2EventRecordPackage error}", new Object[0]);
      }
    }
    return null;
  }
  
  private static EventRecordPackage a(List<RDBean> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    EventRecordPackage localEventRecordPackage;
    try
    {
      localEventRecordPackage = new EventRecordPackage();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        EventRecord localEventRecord = j.a((RDBean)paramList.next());
        if (localEventRecord != null) {
          localArrayList.add(localEventRecord);
        }
      }
      localEventRecordPackage.list = localArrayList;
    }
    catch (Throwable paramList)
    {
      b.a(paramList);
      return null;
    }
    b.b("[event] encode end", new Object[0]);
    return localEventRecordPackage;
  }
  
  /* Error */
  public final RequestPackage a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 155
    //   4: iconst_0
    //   5: anewarray 68	java/lang/Object
    //   8: invokestatic 74	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield 20	com/tencent/beacon/core/event/i:g	Ljava/util/List;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 20	com/tencent/beacon/core/event/i:g	Ljava/util/List;
    //   22: invokeinterface 32 1 0
    //   27: istore_1
    //   28: iload_1
    //   29: ifgt +9 -> 38
    //   32: aconst_null
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: areturn
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 157	com/tencent/beacon/core/event/i:a	I
    //   43: aload_0
    //   44: getfield 20	com/tencent/beacon/core/event/i:g	Ljava/util/List;
    //   47: invokespecial 159	com/tencent/beacon/core/event/i:a	(ILjava/util/List;)Lcom/tencent/beacon/core/protocol/common/RequestPackage;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +29 -> 81
    //   55: ldc 161
    //   57: iconst_0
    //   58: anewarray 68	java/lang/Object
    //   61: invokestatic 74	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: goto -30 -> 34
    //   67: astore_2
    //   68: aload_2
    //   69: invokestatic 112	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   72: ldc 163
    //   74: iconst_0
    //   75: anewarray 68	java/lang/Object
    //   78: invokestatic 116	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aconst_null
    //   82: astore_2
    //   83: goto -49 -> 34
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	i
    //   27	2	1	k	int
    //   33	19	2	localRequestPackage	RequestPackage
    //   67	2	2	localThrowable	Throwable
    //   82	1	2	localObject1	Object
    //   86	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	51	67	java/lang/Throwable
    //   55	64	67	java/lang/Throwable
    //   2	28	86	finally
    //   38	51	86	finally
    //   55	64	86	finally
    //   68	81	86	finally
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      b.b("[event] isHandled:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      if ((this.g != null) && (!paramBoolean))
      {
        b.f("[event] upload failed, save to db", new Object[0]);
        if (!this.j)
        {
          this.i = k.a(this.h, this.f, this.g);
          if (this.i != null)
          {
            Iterator localIterator1 = com.tencent.beacon.core.c.i.a(this.h).c().iterator();
            while (localIterator1.hasNext()) {
              ((com.tencent.beacon.core.c.j)localIterator1.next()).incRealTimeEventWriteSucc(this.i.length);
            }
          }
          this.g = null;
        }
      }
    }
    finally {}
    if ((paramBoolean) && (this.j)) {
      f.a(this.h);
    }
    if ((paramBoolean) && (this.i != null)) {
      k.a(this.h, this.f, this.i);
    }
    if ((paramBoolean) && (this.g != null))
    {
      Iterator localIterator2 = com.tencent.beacon.core.c.i.a(this.h).c().iterator();
      while (localIterator2.hasNext()) {
        ((com.tencent.beacon.core.c.j)localIterator2.next()).incRealTimeEventUploadSucc(this.g.size());
      }
    }
    if ((paramBoolean) && (this.i == null) && (this.g != null)) {
      this.g = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.event.i
 * JD-Core Version:    0.7.0.1
 */