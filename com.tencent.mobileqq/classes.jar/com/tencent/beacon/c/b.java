package com.tencent.beacon.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.f;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static int d;
  private static String m = "rqd_up_qua";
  private static int o = 10;
  public boolean a = false;
  private final Context b;
  private final ConcurrentHashMap<Integer, c> c = new ConcurrentHashMap();
  private a<String> e = new a();
  private a<Long> f = new a();
  private a<Long> g = new a();
  private a<Long> h = new a();
  private a<Long> i = new a();
  private a<Long> j = new a();
  private a<Byte> k = new a();
  private a<SharedPreferences> l = new a();
  private int n = 5;
  private Runnable p = new Runnable()
  {
    public final void run()
    {
      try
      {
        ((SharedPreferences)b.g(b.this).a()).edit().putString("on_qua_date", (String)b.f(b.this).a()).putLong("common_event_calls", ((Long)b.e(b.this).a()).longValue()).putLong("real_time_event_calls", ((Long)b.d(b.this).a()).longValue()).putLong("common_event_write_succ", ((Long)b.c(b.this).a()).longValue()).putLong("real_time_event_write_succ", ((Long)b.b(b.this).a()).longValue()).putLong("real_time_event_upload_succ", ((Long)b.a(b.this).a()).longValue()).commit();
        return;
      }
      catch (Exception localException)
      {
        com.tencent.beacon.d.a.a(localException);
      }
    }
  };
  private Runnable q = new Runnable()
  {
    public final void run()
    {
      b.h(b.this).getSharedPreferences("DENGTA_META", 0);
      b.g(b.this).a(b.h(b.this).getSharedPreferences("DENGTA_META", 0));
      b.f(b.this).a(((SharedPreferences)b.g(b.this).b()).getString("on_qua_date", ""));
      b.e(b.this).a(Long.valueOf(((SharedPreferences)b.g(b.this).b()).getLong("common_event_calls", 0L)));
      b.d(b.this).a(Long.valueOf(((SharedPreferences)b.g(b.this).b()).getLong("real_time_event_calls", 0L)));
      b.c(b.this).a(Long.valueOf(((SharedPreferences)b.g(b.this).b()).getLong("common_event_write_succ", 0L)));
      b.b(b.this).a(Long.valueOf(((SharedPreferences)b.g(b.this).b()).getLong("real_time_event_write_succ", 0L)));
      b.a(b.this).a(Long.valueOf(((SharedPreferences)b.g(b.this).b()).getLong("real_time_event_upload_succ", 0L)));
      b.i(b.this);
    }
  };
  
  public b(Context paramContext)
  {
    this.b = paramContext;
    this.k.a(Byte.valueOf((byte)0));
    com.tencent.beacon.a.c.a().a(this.q);
  }
  
  private String c()
  {
    if ((this.c != null) && (this.c.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.c.entrySet().iterator();
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
  
  private String d()
  {
    if ((this.c != null) && (this.c.size() > 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Iterator localIterator1 = this.c.entrySet().iterator();
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
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/tencent/beacon/c/b:a	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 69	com/tencent/beacon/c/b:k	Lcom/tencent/beacon/c/a;
    //   12: astore_3
    //   13: aload_3
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 69	com/tencent/beacon/c/b:k	Lcom/tencent/beacon/c/a;
    //   19: invokevirtual 207	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   22: checkcast 90	java/lang/Byte
    //   25: invokevirtual 211	java/lang/Byte:byteValue	()B
    //   28: iconst_1
    //   29: iadd
    //   30: i2b
    //   31: istore_2
    //   32: iload_2
    //   33: istore_1
    //   34: iload_2
    //   35: getstatic 45	com/tencent/beacon/c/b:o	I
    //   38: if_icmplt +15 -> 53
    //   41: invokestatic 102	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   44: aload_0
    //   45: getfield 78	com/tencent/beacon/c/b:p	Ljava/lang/Runnable;
    //   48: invokevirtual 105	com/tencent/beacon/a/c:a	(Ljava/lang/Runnable;)V
    //   51: iconst_0
    //   52: istore_1
    //   53: aload_0
    //   54: getfield 69	com/tencent/beacon/c/b:k	Lcom/tencent/beacon/c/a;
    //   57: iload_1
    //   58: invokestatic 94	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   61: invokevirtual 97	com/tencent/beacon/c/a:a	(Ljava/lang/Object;)V
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
    //   78: invokestatic 216	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   81: goto -17 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	b
    //   33	25	1	i1	int
    //   31	8	2	i2	int
    //   67	5	4	localObject	Object
    //   74	3	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   15	32	67	finally
    //   34	51	67	finally
    //   53	64	67	finally
    //   64	66	67	finally
    //   76	81	67	finally
    //   15	32	74	java/lang/Exception
    //   34	51	74	java/lang/Exception
    //   53	64	74	java/lang/Exception
  }
  
  private void f()
  {
    try
    {
      if (!f.n().equals(this.e.a()))
      {
        this.e.a(f.n());
        this.f.a(Long.valueOf(0L));
        this.g.a(Long.valueOf(0L));
        this.h.a(Long.valueOf(0L));
        this.i.a(Long.valueOf(0L));
        this.j.a(Long.valueOf(0L));
        com.tencent.beacon.a.c.a().a(this.p);
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.a(localException);
    }
  }
  
  public final void a()
  {
    if (!this.a) {
      return;
    }
    try
    {
      f();
      long l1 = ((Long)this.f.a()).longValue();
      this.f.a(Long.valueOf(l1 + 1L));
      e();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.a(localException);
    }
  }
  
  public final void a(int paramInt)
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      try
      {
        f();
        long l1 = ((Long)this.h.a()).longValue();
        this.h.a(Long.valueOf(l1 + paramInt));
        if (paramInt > 1)
        {
          com.tencent.beacon.a.c.a().a(this.p);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.d.a.a(localException);
      }
    }
  }
  
  /* Error */
  public final void a(int paramInt1, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/tencent/beacon/c/b:a	Z
    //   6: istore 13
    //   8: iload 13
    //   10: ifne +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: iload_1
    //   17: ifeq -4 -> 13
    //   20: aload_0
    //   21: getfield 86	com/tencent/beacon/c/b:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: iload_1
    //   25: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 253	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 141	com/tencent/beacon/c/c
    //   34: astore 14
    //   36: aload 14
    //   38: ifnull +423 -> 461
    //   41: new 175	com/tencent/beacon/c/d
    //   44: dup
    //   45: invokespecial 254	com/tencent/beacon/c/d:<init>	()V
    //   48: astore 15
    //   50: iload_2
    //   51: ifeq +395 -> 446
    //   54: aload 14
    //   56: aload 14
    //   58: invokevirtual 155	com/tencent/beacon/c/c:a	()I
    //   61: iconst_1
    //   62: iadd
    //   63: invokevirtual 256	com/tencent/beacon/c/c:b	(I)V
    //   66: aload 15
    //   68: iload_1
    //   69: putfield 183	com/tencent/beacon/c/d:b	I
    //   72: aload 15
    //   74: lload_3
    //   75: putfield 178	com/tencent/beacon/c/d:a	J
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
    //   98: putfield 189	com/tencent/beacon/c/d:d	I
    //   101: aload 15
    //   103: iload 7
    //   105: putfield 191	com/tencent/beacon/c/d:e	I
    //   108: aload 15
    //   110: iload 8
    //   112: putfield 193	com/tencent/beacon/c/d:f	I
    //   115: aload 15
    //   117: aload 9
    //   119: putfield 195	com/tencent/beacon/c/d:g	Ljava/lang/String;
    //   122: aload 15
    //   124: aload 10
    //   126: putfield 197	com/tencent/beacon/c/d:h	Ljava/lang/String;
    //   129: aload 15
    //   131: iload_2
    //   132: putfield 185	com/tencent/beacon/c/d:c	Z
    //   135: aload 15
    //   137: iload 11
    //   139: putfield 199	com/tencent/beacon/c/d:i	I
    //   142: aload 15
    //   144: aload 12
    //   146: putfield 201	com/tencent/beacon/c/d:j	Ljava/lang/String;
    //   149: aload 14
    //   151: invokevirtual 170	com/tencent/beacon/c/c:c	()Ljava/util/List;
    //   154: aload 15
    //   156: invokeinterface 259 2 0
    //   161: pop
    //   162: getstatic 260	com/tencent/beacon/c/b:d	I
    //   165: iconst_1
    //   166: iadd
    //   167: istore_1
    //   168: iload_1
    //   169: putstatic 260	com/tencent/beacon/c/b:d	I
    //   172: iload_1
    //   173: aload_0
    //   174: getfield 73	com/tencent/beacon/c/b:n	I
    //   177: if_icmplt -164 -> 13
    //   180: new 262	java/util/HashMap
    //   183: dup
    //   184: invokespecial 263	java/util/HashMap:<init>	()V
    //   187: astore 9
    //   189: aload 9
    //   191: ldc_w 265
    //   194: new 113	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   201: getstatic 260	com/tencent/beacon/c/b:d	I
    //   204: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokeinterface 271 3 0
    //   215: pop
    //   216: aload 9
    //   218: ldc_w 273
    //   221: aload_0
    //   222: invokespecial 275	com/tencent/beacon/c/b:c	()Ljava/lang/String;
    //   225: invokeinterface 271 3 0
    //   230: pop
    //   231: aload 9
    //   233: ldc_w 277
    //   236: aload_0
    //   237: invokespecial 279	com/tencent/beacon/c/b:d	()Ljava/lang/String;
    //   240: invokeinterface 271 3 0
    //   245: pop
    //   246: aload 9
    //   248: ldc_w 281
    //   251: aload_0
    //   252: getfield 59	com/tencent/beacon/c/b:f	Lcom/tencent/beacon/c/a;
    //   255: invokevirtual 207	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   258: invokestatic 284	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   261: invokeinterface 271 3 0
    //   266: pop
    //   267: aload 9
    //   269: ldc_w 286
    //   272: aload_0
    //   273: getfield 61	com/tencent/beacon/c/b:g	Lcom/tencent/beacon/c/a;
    //   276: invokevirtual 207	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   279: invokestatic 284	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   282: invokeinterface 271 3 0
    //   287: pop
    //   288: aload 9
    //   290: ldc_w 288
    //   293: aload_0
    //   294: getfield 88	com/tencent/beacon/c/b:b	Landroid/content/Context;
    //   297: invokestatic 291	com/tencent/beacon/a/f:q	(Landroid/content/Context;)I
    //   300: invokestatic 294	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   303: invokeinterface 271 3 0
    //   308: pop
    //   309: aload 9
    //   311: ldc_w 296
    //   314: aload_0
    //   315: getfield 67	com/tencent/beacon/c/b:j	Lcom/tencent/beacon/c/a;
    //   318: invokevirtual 207	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   321: invokestatic 284	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   324: invokeinterface 271 3 0
    //   329: pop
    //   330: aload 9
    //   332: ldc_w 298
    //   335: aload_0
    //   336: getfield 65	com/tencent/beacon/c/b:i	Lcom/tencent/beacon/c/a;
    //   339: invokevirtual 207	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   342: invokestatic 284	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   345: invokeinterface 271 3 0
    //   350: pop
    //   351: aload 9
    //   353: ldc_w 300
    //   356: aload_0
    //   357: getfield 63	com/tencent/beacon/c/b:h	Lcom/tencent/beacon/c/a;
    //   360: invokevirtual 207	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   363: invokestatic 284	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   366: invokeinterface 271 3 0
    //   371: pop
    //   372: aload 9
    //   374: ldc_w 302
    //   377: aload_0
    //   378: getfield 57	com/tencent/beacon/c/b:e	Lcom/tencent/beacon/c/a;
    //   381: invokevirtual 207	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   384: checkcast 222	java/lang/String
    //   387: ldc_w 304
    //   390: ldc 167
    //   392: invokevirtual 308	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   395: invokestatic 284	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   398: invokeinterface 271 3 0
    //   403: pop
    //   404: getstatic 43	com/tencent/beacon/c/b:m	Ljava/lang/String;
    //   407: iconst_1
    //   408: lconst_0
    //   409: lconst_0
    //   410: aload 9
    //   412: iconst_1
    //   413: invokestatic 314	com/tencent/beacon/event/UserAction:onUserAction	(Ljava/lang/String;ZJJLjava/util/Map;Z)Z
    //   416: ifeq -403 -> 13
    //   419: aload_0
    //   420: getfield 86	com/tencent/beacon/c/b:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   423: invokevirtual 317	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   426: iconst_0
    //   427: putstatic 260	com/tencent/beacon/c/b:d	I
    //   430: aload_0
    //   431: bipush 10
    //   433: putfield 73	com/tencent/beacon/c/b:n	I
    //   436: goto -423 -> 13
    //   439: astore 9
    //   441: aload_0
    //   442: monitorexit
    //   443: aload 9
    //   445: athrow
    //   446: aload 14
    //   448: aload 14
    //   450: invokevirtual 160	com/tencent/beacon/c/c:b	()I
    //   453: iconst_1
    //   454: iadd
    //   455: invokevirtual 319	com/tencent/beacon/c/c:c	(I)V
    //   458: goto -392 -> 66
    //   461: new 141	com/tencent/beacon/c/c
    //   464: dup
    //   465: invokespecial 320	com/tencent/beacon/c/c:<init>	()V
    //   468: astore 14
    //   470: aload 14
    //   472: iload_1
    //   473: invokevirtual 322	com/tencent/beacon/c/c:a	(I)V
    //   476: iload_2
    //   477: ifeq +131 -> 608
    //   480: aload 14
    //   482: iconst_1
    //   483: invokevirtual 256	com/tencent/beacon/c/c:b	(I)V
    //   486: new 175	com/tencent/beacon/c/d
    //   489: dup
    //   490: invokespecial 254	com/tencent/beacon/c/d:<init>	()V
    //   493: astore 15
    //   495: aload 15
    //   497: iload_1
    //   498: putfield 183	com/tencent/beacon/c/d:b	I
    //   501: aload 15
    //   503: lload_3
    //   504: putfield 178	com/tencent/beacon/c/d:a	J
    //   507: lload 5
    //   509: lconst_0
    //   510: lcmp
    //   511: ifle +19 -> 530
    //   514: iload 11
    //   516: ifle +14 -> 530
    //   519: aload 15
    //   521: lload 5
    //   523: l2i
    //   524: iload 11
    //   526: idiv
    //   527: putfield 189	com/tencent/beacon/c/d:d	I
    //   530: aload 15
    //   532: iload 7
    //   534: putfield 191	com/tencent/beacon/c/d:e	I
    //   537: aload 15
    //   539: iload 8
    //   541: putfield 193	com/tencent/beacon/c/d:f	I
    //   544: aload 15
    //   546: aload 9
    //   548: putfield 195	com/tencent/beacon/c/d:g	Ljava/lang/String;
    //   551: aload 15
    //   553: aload 10
    //   555: putfield 197	com/tencent/beacon/c/d:h	Ljava/lang/String;
    //   558: aload 15
    //   560: iload_2
    //   561: putfield 185	com/tencent/beacon/c/d:c	Z
    //   564: aload 15
    //   566: iload 11
    //   568: putfield 199	com/tencent/beacon/c/d:i	I
    //   571: aload 15
    //   573: aload 12
    //   575: putfield 201	com/tencent/beacon/c/d:j	Ljava/lang/String;
    //   578: aload 14
    //   580: invokevirtual 170	com/tencent/beacon/c/c:c	()Ljava/util/List;
    //   583: aload 15
    //   585: invokeinterface 259 2 0
    //   590: pop
    //   591: aload_0
    //   592: getfield 86	com/tencent/beacon/c/b:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   595: iload_1
    //   596: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   599: aload 14
    //   601: invokevirtual 323	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   604: pop
    //   605: goto -443 -> 162
    //   608: aload 14
    //   610: iconst_1
    //   611: invokevirtual 319	com/tencent/beacon/c/c:c	(I)V
    //   614: goto -128 -> 486
    //   617: astore 10
    //   619: aload 10
    //   621: invokestatic 216	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   624: goto -220 -> 404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	b
    //   0	627	1	paramInt1	int
    //   0	627	2	paramBoolean	boolean
    //   0	627	3	paramLong1	long
    //   0	627	5	paramLong2	long
    //   0	627	7	paramInt2	int
    //   0	627	8	paramInt3	int
    //   0	627	9	paramString1	String
    //   0	627	10	paramString2	String
    //   0	627	11	paramInt4	int
    //   0	627	12	paramString3	String
    //   6	3	13	bool	boolean
    //   34	575	14	localc	c
    //   48	536	15	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	8	439	finally
    //   20	36	439	finally
    //   41	50	439	finally
    //   54	66	439	finally
    //   66	78	439	finally
    //   90	101	439	finally
    //   101	162	439	finally
    //   162	246	439	finally
    //   246	404	439	finally
    //   404	436	439	finally
    //   446	458	439	finally
    //   461	476	439	finally
    //   480	486	439	finally
    //   486	507	439	finally
    //   519	530	439	finally
    //   530	605	439	finally
    //   608	614	439	finally
    //   619	624	439	finally
    //   246	404	617	java/lang/InterruptedException
  }
  
  public final void b()
  {
    if (!this.a) {
      return;
    }
    try
    {
      f();
      long l1 = ((Long)this.g.a()).longValue();
      this.g.a(Long.valueOf(l1 + 1L));
      e();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.a(localException);
    }
  }
  
  public final void b(int paramInt)
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      try
      {
        f();
        long l1 = ((Long)this.i.a()).longValue();
        this.i.a(Long.valueOf(l1 + paramInt));
        if (paramInt > 1)
        {
          com.tencent.beacon.a.c.a().a(this.p);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.d.a.a(localException);
      }
    }
  }
  
  public final void c(int paramInt)
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      try
      {
        f();
        long l1 = ((Long)this.j.a()).longValue();
        this.j.a(Long.valueOf(l1 + paramInt));
        if (paramInt > 1)
        {
          com.tencent.beacon.a.c.a().a(this.p);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.d.a.a(localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.c.b
 * JD-Core Version:    0.7.0.1
 */