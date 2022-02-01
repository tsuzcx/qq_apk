package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.d.a;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.protocol.common.MixPackage;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.beacon.qimei.QimeiSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e
  extends a
{
  private static e.b h;
  private static e.b i = new e.a(null);
  protected Context j = null;
  protected Long[] k = null;
  private List<Long> l = null;
  private byte[] m = null;
  private boolean n = false;
  
  public e(Context paramContext, String paramString)
  {
    super(paramContext, 1, 4, paramString);
    this.j = paramContext;
  }
  
  protected MixPackage a(List<RDBean> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    this.l = new ArrayList();
    Object localObject1 = h;
    if (localObject1 != null) {}
    for (localObject1 = ((e.b)localObject1).a(paramList, this.l);; localObject1 = null)
    {
      Object localObject2 = i;
      if (localObject2 != null) {}
      for (paramList = ((e.b)localObject2).a(paramList, this.l);; paramList = null)
      {
        if (this.l.size() > 0)
        {
          localObject2 = this.j;
          String str = this.f;
          List localList = this.l;
          t.a((Context)localObject2, str, (Long[])localList.toArray(new Long[localList.size()]));
        }
        if ((localObject1 == null) && (paramList == null)) {
          break;
        }
        localObject2 = new HashMap();
        if (localObject1 != null) {
          ((Map)localObject2).put(Integer.valueOf(3), localObject1);
        }
        if (paramList != null) {
          ((Map)localObject2).put(Integer.valueOf(1), paramList);
        }
        paramList = new MixPackage();
        paramList.mixMap = ((Map)localObject2);
        return paramList;
      }
    }
  }
  
  public void a()
  {
    try
    {
      d.i("[event] encode failed, clear db data", new Object[0]);
      Long[] arrayOfLong = this.k;
      if ((arrayOfLong != null) && (arrayOfLong.length > 0))
      {
        int i1 = t.a(this.j, this.f, arrayOfLong);
        d.a("[event] remove num :" + i1, new Object[0]);
        this.k = null;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 37	com/tencent/beacon/core/event/e:k	[Ljava/lang/Long;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +7 -> 19
    //   15: aload 4
    //   17: arraylength
    //   18: istore_2
    //   19: iload_2
    //   20: ifle +45 -> 65
    //   23: aload_0
    //   24: getfield 35	com/tencent/beacon/core/event/e:j	Landroid/content/Context;
    //   27: aload_0
    //   28: getfield 66	com/tencent/beacon/core/d/a:f	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 37	com/tencent/beacon/core/event/e:k	[Ljava/lang/Long;
    //   35: invokestatic 78	com/tencent/beacon/core/event/t:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/Long;)I
    //   38: istore_3
    //   39: new 113	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   46: ldc 132
    //   48: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_3
    //   52: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: iconst_0
    //   59: anewarray 106	java/lang/Object
    //   62: invokestatic 129	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 37	com/tencent/beacon/core/event/e:k	[Ljava/lang/Long;
    //   70: iload_1
    //   71: ifeq +34 -> 105
    //   74: aload_0
    //   75: invokevirtual 136	com/tencent/beacon/core/event/e:g	()Z
    //   78: ifeq +27 -> 105
    //   81: aload_0
    //   82: getfield 35	com/tencent/beacon/core/event/e:j	Landroid/content/Context;
    //   85: aload_0
    //   86: getfield 66	com/tencent/beacon/core/d/a:f	Ljava/lang/String;
    //   89: aload_0
    //   90: getfield 139	com/tencent/beacon/core/d/a:d	Ljava/lang/String;
    //   93: invokestatic 144	com/tencent/beacon/core/a/a/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   96: pop
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 41	com/tencent/beacon/core/event/e:m	[B
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: iload_1
    //   106: ifne -9 -> 97
    //   109: aload_0
    //   110: getfield 41	com/tencent/beacon/core/event/e:m	[B
    //   113: ifnull -16 -> 97
    //   116: ldc 146
    //   118: iconst_1
    //   119: anewarray 106	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_0
    //   125: getfield 139	com/tencent/beacon/core/d/a:d	Ljava/lang/String;
    //   128: aastore
    //   129: invokestatic 129	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_0
    //   133: getfield 35	com/tencent/beacon/core/event/e:j	Landroid/content/Context;
    //   136: aload_0
    //   137: getfield 66	com/tencent/beacon/core/d/a:f	Ljava/lang/String;
    //   140: aload_0
    //   141: getfield 41	com/tencent/beacon/core/event/e:m	[B
    //   144: aload_0
    //   145: getfield 139	com/tencent/beacon/core/d/a:d	Ljava/lang/String;
    //   148: iload_2
    //   149: invokestatic 149	com/tencent/beacon/core/a/a/b:a	(Landroid/content/Context;Ljava/lang/String;[BLjava/lang/String;I)Z
    //   152: pop
    //   153: goto -56 -> 97
    //   156: astore 4
    //   158: aload_0
    //   159: monitorexit
    //   160: aload 4
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	e
    //   0	163	1	paramBoolean	boolean
    //   1	148	2	i1	int
    //   38	14	3	i2	int
    //   8	8	4	arrayOfLong	Long[]
    //   156	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	10	156	finally
    //   15	19	156	finally
    //   23	65	156	finally
    //   65	70	156	finally
    //   74	97	156	finally
    //   97	102	156	finally
    //   109	153	156	finally
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.n = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public RequestPackage f()
  {
    Object localObject8 = null;
    Object localObject6;
    try
    {
      Object localObject1 = TunnelModule.getInstance(this.c);
      if ((localObject1 == null) || (!((TunnelModule)localObject1).isEnable))
      {
        d.b("[event] module null!", new Object[0]);
        localObject1 = localObject8;
      }
      for (;;)
      {
        return localObject1;
        localObject6 = EventStrategyBean.getInstance();
        if (localObject6 == null)
        {
          d.b("[event] strategy null!", new Object[0]);
          localObject1 = localObject8;
        }
        else
        {
          try
          {
            if (g())
            {
              localObject9 = com.tencent.beacon.core.a.a.b.a(this.j, this.f);
              if ((localObject9 != null) && (((List)localObject9).size() > 0))
              {
                localObject3 = (byte[])((List)localObject9).get(3);
                this.d = String.valueOf(((List)localObject9).get(1));
                this.e = ((Integer)((List)localObject9).get(4)).intValue();
                if (localObject3 != null)
                {
                  localObject3 = i.a(this.c, this.a, (byte[])localObject3, this.f);
                  continue;
                }
                i2 = ((EventStrategyBean)localObject6).getComNumUpload();
                i1 = i2;
                if (!com.tencent.beacon.core.e.e.d(this.j)) {
                  i1 = i2 / 2;
                }
                if (i1 >= 0)
                {
                  localObject3 = t.a(this.j, this.f, null, i1);
                  if (localObject3 != null)
                  {
                    i1 = ((List)localObject3).size();
                    if (i1 > 0) {}
                  }
                  else
                  {
                    d.h("[event] No event need upload.", new Object[0]);
                    localObject3 = localObject8;
                  }
                }
              }
            }
          }
          catch (Throwable localThrowable)
          {
            d.a(localThrowable);
            d.b("[event] get req data error: %s", new Object[] { localThrowable.toString() });
            localObject4 = localObject8;
          }
        }
      }
    }
    finally {}
    for (;;)
    {
      for (;;)
      {
        Object localObject9;
        Object localObject3;
        int i2;
        break;
        int i1 = ((List)localObject4).size();
        d.h("[event] %d events need upload.", new Object[] { Integer.valueOf(i1) });
        this.e = i1;
        localObject6 = ((List)localObject4).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject9 = ((RDBean)((Iterator)localObject6).next()).getEMap();
          if (localObject9 != null)
          {
            Qimei localQimei = QimeiSDK.getInstance().getQimei(this.c);
            if ((localQimei != null) && (localQimei.getQimeiMap() != null)) {
              ((Map)localObject9).putAll(localQimei.getQimeiMap());
            }
          }
        }
        Object localObject7;
        try
        {
          localObject6 = a((List)localObject4);
          this.k = new Long[i1];
          i1 = 0;
          while (i1 < this.k.length)
          {
            this.k[i1] = Long.valueOf(((RDBean)((List)localObject4).get(i1)).getCid());
            i1 += 1;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            a();
            localObject7 = null;
          }
          ((List)localObject4).clear();
          localObject4 = localObject8;
        }
        if (localObject7 == null) {
          break;
        }
        Object localObject4 = localObject7.toByteArray();
        this.m = new byte[localObject4.length];
        System.arraycopy(localObject4, 0, this.m, 0, localObject4.length);
        this.d = com.tencent.beacon.core.e.b.a(this.c, 4, this.f);
        d.a("[event] comm rid:%s", new Object[] { this.d });
        try
        {
          localObject4 = i.a(this.c, this.a, (byte[])localObject4, this.f);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            a();
            localObject5 = null;
          }
        }
      }
      Object localObject5 = null;
      continue;
      localObject5 = null;
    }
  }
  
  public boolean g()
  {
    try
    {
      boolean bool = this.n;
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
 * Qualified Name:     com.tencent.beacon.core.event.e
 * JD-Core Version:    0.7.0.1
 */