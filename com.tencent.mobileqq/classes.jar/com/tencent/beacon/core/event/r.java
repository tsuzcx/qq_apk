package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.d.a;
import com.tencent.beacon.core.e.b;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.protocol.event.EventRecord;
import com.tencent.beacon.core.protocol.event.EventRecordPackage;
import com.tencent.beacon.core.wup.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r
  extends a
{
  protected List<RDBean> h = null;
  protected Context i;
  protected Long[] j = null;
  protected boolean k = false;
  
  public r(Context paramContext, String paramString, List<RDBean> paramList)
  {
    super(paramContext, 1, 2, paramString);
    this.h = paramList;
    this.i = paramContext;
    this.e = this.h.size();
    if ((this.h.size() == 1) && ("rqd_heartbeat".equals(((RDBean)this.h.get(0)).getEN()))) {
      this.k = true;
    }
    this.d = b.a(paramContext, 2, paramString);
    d.a("[event] request id:%s", new Object[] { this.d });
  }
  
  public RequestPackage a(Context paramContext, int paramInt, List<RDBean> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return null;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        d.a("[event] encode rd size:" + paramList.size(), new Object[0]);
        paramList = a(paramList);
        if (paramList != null)
        {
          paramList = paramList.toByteArray();
          if (paramList != null)
          {
            paramContext = i.a(paramContext, paramInt, paramList, this.f);
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        d.a(paramContext);
        d.b("[event] encode2EventRecordPackage error}", new Object[0]);
      }
    }
    return null;
  }
  
  protected EventRecordPackage a(List<RDBean> paramList)
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
        EventRecord localEventRecord = s.a((RDBean)paramList.next());
        if (localEventRecord != null) {
          localArrayList.add(localEventRecord);
        }
      }
      localEventRecordPackage.list = localArrayList;
    }
    catch (Throwable paramList)
    {
      d.a(paramList);
      return null;
    }
    d.a("[event] encode end", new Object[0]);
    return localEventRecordPackage;
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   6: ifnull +110 -> 116
    //   9: new 81	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   16: astore_2
    //   17: aload_0
    //   18: getfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   21: invokeinterface 132 1 0
    //   26: astore_3
    //   27: aload_3
    //   28: invokeinterface 138 1 0
    //   33: ifeq +43 -> 76
    //   36: aload_2
    //   37: aload_3
    //   38: invokeinterface 142 1 0
    //   43: checkcast 44	com/tencent/beacon/core/event/RDBean
    //   46: invokevirtual 162	com/tencent/beacon/core/event/RDBean:getEMap	()Ljava/util/Map;
    //   49: ldc 164
    //   51: invokeinterface 169 2 0
    //   56: checkcast 50	java/lang/String
    //   59: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 171
    //   64: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto -41 -> 27
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: ldc 173
    //   78: iconst_4
    //   79: anewarray 68	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: iload_1
    //   85: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: aload_2
    //   92: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: aastore
    //   96: dup
    //   97: iconst_2
    //   98: aload_0
    //   99: getfield 64	com/tencent/beacon/core/d/a:d	Ljava/lang/String;
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: aload_0
    //   106: invokevirtual 182	java/lang/Object:hashCode	()I
    //   109: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 73	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: getfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   120: ifnull +99 -> 219
    //   123: iload_1
    //   124: ifne +95 -> 219
    //   127: ldc 189
    //   129: iconst_0
    //   130: anewarray 68	java/lang/Object
    //   133: invokestatic 191	com/tencent/beacon/core/e/d:f	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_0
    //   137: getfield 24	com/tencent/beacon/core/event/r:k	Z
    //   140: ifne +79 -> 219
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 26	com/tencent/beacon/core/event/r:i	Landroid/content/Context;
    //   148: aload_0
    //   149: getfield 108	com/tencent/beacon/core/d/a:f	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   156: invokestatic 196	com/tencent/beacon/core/event/t:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)[Ljava/lang/Long;
    //   159: putfield 22	com/tencent/beacon/core/event/r:j	[Ljava/lang/Long;
    //   162: aload_0
    //   163: getfield 22	com/tencent/beacon/core/event/r:j	[Ljava/lang/Long;
    //   166: ifnull +48 -> 214
    //   169: aload_0
    //   170: getfield 26	com/tencent/beacon/core/event/r:i	Landroid/content/Context;
    //   173: invokestatic 201	com/tencent/beacon/core/d/k:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/k;
    //   176: invokevirtual 204	com/tencent/beacon/core/d/k:d	()Ljava/util/ArrayList;
    //   179: invokevirtual 205	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   182: astore_2
    //   183: aload_2
    //   184: invokeinterface 138 1 0
    //   189: ifeq +25 -> 214
    //   192: aload_2
    //   193: invokeinterface 142 1 0
    //   198: checkcast 207	com/tencent/beacon/core/d/l
    //   201: aload_0
    //   202: getfield 22	com/tencent/beacon/core/event/r:j	[Ljava/lang/Long;
    //   205: arraylength
    //   206: invokeinterface 211 2 0
    //   211: goto -28 -> 183
    //   214: aload_0
    //   215: aconst_null
    //   216: putfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   219: iload_1
    //   220: ifeq +17 -> 237
    //   223: aload_0
    //   224: getfield 24	com/tencent/beacon/core/event/r:k	Z
    //   227: ifeq +10 -> 237
    //   230: aload_0
    //   231: getfield 26	com/tencent/beacon/core/event/r:i	Landroid/content/Context;
    //   234: invokestatic 216	com/tencent/beacon/core/event/m:a	(Landroid/content/Context;)V
    //   237: iload_1
    //   238: ifeq +59 -> 297
    //   241: aload_0
    //   242: getfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   245: ifnull +52 -> 297
    //   248: aload_0
    //   249: getfield 26	com/tencent/beacon/core/event/r:i	Landroid/content/Context;
    //   252: invokestatic 201	com/tencent/beacon/core/d/k:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/k;
    //   255: invokevirtual 204	com/tencent/beacon/core/d/k:d	()Ljava/util/ArrayList;
    //   258: invokevirtual 205	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   261: astore_2
    //   262: aload_2
    //   263: invokeinterface 138 1 0
    //   268: ifeq +29 -> 297
    //   271: aload_2
    //   272: invokeinterface 142 1 0
    //   277: checkcast 207	com/tencent/beacon/core/d/l
    //   280: aload_0
    //   281: getfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   284: invokeinterface 32 1 0
    //   289: invokeinterface 219 2 0
    //   294: goto -32 -> 262
    //   297: iload_1
    //   298: ifeq +22 -> 320
    //   301: aload_0
    //   302: getfield 22	com/tencent/beacon/core/event/r:j	[Ljava/lang/Long;
    //   305: ifnonnull +15 -> 320
    //   308: aload_0
    //   309: getfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   312: ifnull +8 -> 320
    //   315: aload_0
    //   316: aconst_null
    //   317: putfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   320: aload_0
    //   321: monitorexit
    //   322: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	r
    //   0	323	1	paramBoolean	boolean
    //   16	21	2	localStringBuilder	StringBuilder
    //   71	21	2	localObject	Object
    //   182	90	2	localIterator1	Iterator
    //   26	12	3	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	27	71	finally
    //   27	68	71	finally
    //   76	116	71	finally
    //   116	123	71	finally
    //   127	183	71	finally
    //   183	211	71	finally
    //   214	219	71	finally
    //   223	237	71	finally
    //   241	262	71	finally
    //   262	294	71	finally
    //   301	320	71	finally
  }
  
  /* Error */
  public RequestPackage f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 222
    //   4: iconst_0
    //   5: anewarray 68	java/lang/Object
    //   8: invokestatic 73	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +14 -> 31
    //   20: aload_2
    //   21: invokeinterface 32 1 0
    //   26: istore_1
    //   27: iload_1
    //   28: ifgt +9 -> 37
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 26	com/tencent/beacon/core/event/r:i	Landroid/content/Context;
    //   42: aload_0
    //   43: getfield 224	com/tencent/beacon/core/d/a:a	I
    //   46: aload_0
    //   47: getfield 20	com/tencent/beacon/core/event/r:h	Ljava/util/List;
    //   50: invokevirtual 226	com/tencent/beacon/core/event/r:a	(Landroid/content/Context;ILjava/util/List;)Lcom/tencent/beacon/core/protocol/common/RequestPackage;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +29 -> 84
    //   58: ldc 228
    //   60: iconst_0
    //   61: anewarray 68	java/lang/Object
    //   64: invokestatic 73	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: goto -34 -> 33
    //   70: astore_2
    //   71: aload_2
    //   72: invokestatic 116	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   75: ldc 230
    //   77: iconst_0
    //   78: anewarray 68	java/lang/Object
    //   81: invokestatic 121	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aconst_null
    //   85: astore_2
    //   86: goto -53 -> 33
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	r
    //   26	2	1	m	int
    //   15	40	2	localObject1	Object
    //   70	2	2	localThrowable	Throwable
    //   85	1	2	localObject2	Object
    //   89	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	54	70	java/lang/Throwable
    //   58	67	70	java/lang/Throwable
    //   2	16	89	finally
    //   20	27	89	finally
    //   37	54	89	finally
    //   58	67	89	finally
    //   71	84	89	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.r
 * JD-Core Version:    0.7.0.1
 */