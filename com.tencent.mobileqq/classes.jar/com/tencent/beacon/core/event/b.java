package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.c.a;
import com.tencent.beacon.core.d.d;
import com.tencent.beacon.core.d.i;
import com.tencent.beacon.core.protocol.common.MixPackage;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.qimei.QimeiSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  extends a
{
  private static b.b l = new b.a((byte)0);
  private Context g = null;
  private Long[] h = null;
  private List<Long> i = null;
  private byte[] j = null;
  private boolean k = false;
  
  public b(Context paramContext, String paramString)
  {
    super(paramContext, 1, 4, paramString);
    this.g = paramContext;
  }
  
  private boolean g()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final RequestPackage a()
  {
    Object localObject9 = null;
    Object localObject7;
    Object localObject8;
    label150:
    int n;
    label210:
    for (;;)
    {
      try
      {
        Object localObject1 = TunnelModule.getInstance(this.c);
        if ((localObject1 == null) || (!((TunnelModule)localObject1).isEnable))
        {
          com.tencent.beacon.core.d.b.d("[event] module null!", new Object[0]);
          localObject1 = localObject9;
          return localObject1;
        }
        localObject7 = EventStrategyBean.getInstance();
        if (localObject7 == null)
        {
          com.tencent.beacon.core.d.b.d("[event] strategy null!", new Object[0]);
          localObject1 = localObject9;
        }
        else
        {
          try
          {
            if (!g()) {
              break label666;
            }
            localObject8 = com.tencent.beacon.core.a.a.b.a(this.g, this.f);
            if ((localObject8 == null) || (((List)localObject8).size() <= 0)) {
              break label666;
            }
            Object localObject3 = (byte[])((List)localObject8).get(3);
            this.d = String.valueOf(((List)localObject8).get(1));
            this.e = ((Integer)((List)localObject8).get(4)).intValue();
            if (localObject3 != null)
            {
              localObject3 = a(this.a, (byte[])localObject3, this.f);
            }
            else
            {
              n = ((EventStrategyBean)localObject7).getComNumUpload();
              m = n;
              if (!d.a(this.g)) {
                m = n / 2;
              }
              if (m < 0) {
                break label660;
              }
              localObject7 = k.a(this.g, this.f, m);
              if ((localObject7 != null) && (((List)localObject7).size() > 0)) {
                break;
              }
              com.tencent.beacon.core.d.b.h("[event] No event need upload.", new Object[0]);
              localObject3 = localObject9;
            }
          }
          catch (Throwable localThrowable)
          {
            com.tencent.beacon.core.d.b.a(localThrowable);
            com.tencent.beacon.core.d.b.d("[event] get req data error: %s", new Object[] { localThrowable.toString() });
            localObject4 = localObject9;
          }
        }
      }
      finally {}
    }
    int m = ((List)localObject7).size();
    com.tencent.beacon.core.d.b.h("[event] %d events need upload.", new Object[] { Integer.valueOf(m) });
    this.e = m;
    Object localObject4 = ((List)localObject7).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject8 = ((RDBean)((Iterator)localObject4).next()).getEMap();
      if (localObject8 != null) {
        ((Map)localObject8).put("A3", QimeiSDK.getInstance().getQimeiInternal());
      }
    }
    if (localObject7 != null) {}
    for (;;)
    {
      for (;;)
      {
        try
        {
          n = ((List)localObject7).size();
          if (n > 0) {
            continue;
          }
          localObject4 = null;
          localObject8 = localObject4;
        }
        catch (Exception localException1)
        {
          b();
          localObject8 = null;
          continue;
          ((List)localObject7).clear();
          localObject5 = localObject9;
        }
        this.h = new Long[m];
        m = 0;
        if (m < this.h.length)
        {
          this.h[m] = Long.valueOf(((RDBean)((List)localObject7).get(m)).getCid());
          m += 1;
          continue;
          this.i = new ArrayList();
          if (l == null) {
            break label655;
          }
          localObject4 = l.a((List)localObject7, this.i);
          if (this.i.size() <= 0) {
            break label671;
          }
          k.a(this.g, this.f, (Long[])this.i.toArray(new Long[this.i.size()]));
          break label671;
          localObject8 = new HashMap();
          if (localObject4 != null) {
            ((Map)localObject8).put(Integer.valueOf(1), localObject4);
          }
          localObject4 = new MixPackage();
          ((MixPackage)localObject4).mixMap = ((Map)localObject8);
        }
        else
        {
          if (localObject8 == null) {
            break;
          }
          Object localObject5 = ((MixPackage)localObject8).toByteArray();
          this.j = new byte[localObject5.length];
          System.arraycopy(localObject5, 0, this.j, 0, localObject5.length);
          this.d = i.a(this.c, 4);
          com.tencent.beacon.core.d.b.b("[event] comm rid:%s", new Object[] { this.d });
          try
          {
            localObject5 = a(this.a, (byte[])localObject5, this.f);
          }
          catch (Exception localException2)
          {
            b();
            localObject6 = localObject9;
          }
        }
      }
      break;
      label655:
      Object localObject6 = null;
      continue;
      label660:
      localObject7 = null;
      break label210;
      label666:
      localObject6 = null;
      break label150;
      label671:
      if (localObject6 == null) {
        localObject6 = null;
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    try
    {
      com.tencent.beacon.core.d.b.c("[event] encode failed, clear db data", new Object[0]);
      if ((this.h != null) && (this.h.length > 0))
      {
        int m = k.a(this.g, this.f, this.h);
        com.tencent.beacon.core.d.b.b("[event] remove num :" + m, new Object[0]);
        this.h = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 36	com/tencent/beacon/core/event/b:h	[Ljava/lang/Long;
    //   8: ifnull +9 -> 17
    //   11: aload_0
    //   12: getfield 36	com/tencent/beacon/core/event/b:h	[Ljava/lang/Long;
    //   15: arraylength
    //   16: istore_2
    //   17: iload_2
    //   18: ifle +43 -> 61
    //   21: aload_0
    //   22: getfield 34	com/tencent/beacon/core/event/b:g	Landroid/content/Context;
    //   25: aload_0
    //   26: getfield 84	com/tencent/beacon/core/event/b:f	Ljava/lang/String;
    //   29: aload_0
    //   30: getfield 36	com/tencent/beacon/core/event/b:h	[Ljava/lang/Long;
    //   33: invokestatic 214	com/tencent/beacon/core/event/k:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Long;)I
    //   36: istore_3
    //   37: new 256	java/lang/StringBuilder
    //   40: dup
    //   41: ldc_w 268
    //   44: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: iload_3
    //   48: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: iconst_0
    //   55: anewarray 65	java/lang/Object
    //   58: invokestatic 249	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 36	com/tencent/beacon/core/event/b:h	[Ljava/lang/Long;
    //   66: iload_1
    //   67: ifeq +34 -> 101
    //   70: aload_0
    //   71: invokespecial 80	com/tencent/beacon/core/event/b:g	()Z
    //   74: ifeq +27 -> 101
    //   77: aload_0
    //   78: getfield 34	com/tencent/beacon/core/event/b:g	Landroid/content/Context;
    //   81: aload_0
    //   82: getfield 84	com/tencent/beacon/core/event/b:f	Ljava/lang/String;
    //   85: aload_0
    //   86: getfield 108	com/tencent/beacon/core/event/b:d	Ljava/lang/String;
    //   89: invokestatic 271	com/tencent/beacon/core/a/a/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   92: pop
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 40	com/tencent/beacon/core/event/b:j	[B
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: iload_1
    //   102: ifne -9 -> 93
    //   105: aload_0
    //   106: getfield 40	com/tencent/beacon/core/event/b:j	[B
    //   109: ifnull -16 -> 93
    //   112: ldc_w 273
    //   115: iconst_1
    //   116: anewarray 65	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_0
    //   122: getfield 108	com/tencent/beacon/core/event/b:d	Ljava/lang/String;
    //   125: aastore
    //   126: invokestatic 249	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_0
    //   130: getfield 34	com/tencent/beacon/core/event/b:g	Landroid/content/Context;
    //   133: aload_0
    //   134: getfield 84	com/tencent/beacon/core/event/b:f	Ljava/lang/String;
    //   137: aload_0
    //   138: getfield 40	com/tencent/beacon/core/event/b:j	[B
    //   141: aload_0
    //   142: getfield 108	com/tencent/beacon/core/event/b:d	Ljava/lang/String;
    //   145: iload_2
    //   146: invokestatic 276	com/tencent/beacon/core/a/a/b:a	(Landroid/content/Context;Ljava/lang/String;[BLjava/lang/String;I)Z
    //   149: pop
    //   150: goto -57 -> 93
    //   153: astore 4
    //   155: aload_0
    //   156: monitorexit
    //   157: aload 4
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	b
    //   0	160	1	paramBoolean	boolean
    //   1	145	2	m	int
    //   36	12	3	n	int
    //   153	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	153	finally
    //   21	61	153	finally
    //   61	66	153	finally
    //   70	93	153	finally
    //   93	98	153	finally
    //   105	150	153	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.b
 * JD-Core Version:    0.7.0.1
 */