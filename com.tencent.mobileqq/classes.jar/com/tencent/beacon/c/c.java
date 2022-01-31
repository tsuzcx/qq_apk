package com.tencent.beacon.c;

import android.content.Context;
import com.tencent.beacon.a.f.h;
import com.tencent.beacon.a.f.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c
  extends com.tencent.beacon.a.a
  implements i
{
  private static c e;
  private static int g;
  private static String p = "rqd_up_qua";
  private static int r = 5;
  protected String b;
  private boolean c = true;
  private boolean d = true;
  private final ConcurrentHashMap<Integer, d> f = new ConcurrentHashMap();
  private a<String> h = new a();
  private a<Long> i = new a();
  private a<Long> j = new a();
  private a<Long> k = new a();
  private a<Long> l = new a();
  private a<Long> m = new a();
  private a<Byte> n = new a();
  private a<com.tencent.beacon.a.a.c> o = new a();
  private int q = 5;
  private Runnable s = new Runnable()
  {
    public final void run()
    {
      try
      {
        ((com.tencent.beacon.a.a.c)c.g(c.this).a()).a().a("on_qua_date", c.f(c.this).a()).a("common_event_calls", c.e(c.this).a()).a("real_time_event_calls", c.d(c.this).a()).a("common_event_write_succ", c.c(c.this).a()).a("real_time_event_write_succ", c.b(c.this).a()).a("real_time_event_upload_succ", c.a(c.this).a()).b();
        return;
      }
      catch (Exception localException)
      {
        com.tencent.beacon.a.g.a.a(localException);
      }
    }
  };
  private Runnable t = new Runnable()
  {
    public final void run()
    {
      c.g(c.this).a(com.tencent.beacon.a.a.c.a(c.h(c.this)));
      c.f(c.this).a(((com.tencent.beacon.a.a.c)c.g(c.this).b()).a("on_qua_date", ""));
      c.e(c.this).a(Long.valueOf(((com.tencent.beacon.a.a.c)c.g(c.this).b()).b("common_event_calls")));
      c.d(c.this).a(Long.valueOf(((com.tencent.beacon.a.a.c)c.g(c.this).b()).b("real_time_event_calls")));
      c.c(c.this).a(Long.valueOf(((com.tencent.beacon.a.a.c)c.g(c.this).b()).b("common_event_write_succ")));
      c.b(c.this).a(Long.valueOf(((com.tencent.beacon.a.a.c)c.g(c.this).b()).b("real_time_event_write_succ")));
      c.a(c.this).a(Long.valueOf(((com.tencent.beacon.a.a.c)c.g(c.this).b()).b("real_time_event_upload_succ")));
      c.i(c.this);
    }
  };
  
  private c(Context paramContext)
  {
    super(paramContext);
    this.n.a(Byte.valueOf((byte)0));
    com.tencent.beacon.a.a.b.a().a(this.t);
    h.a(this.a).a(this);
  }
  
  private String g()
  {
    if (this.f.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.f.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        d locald = (d)localEntry.getValue();
        localStringBuilder.append(localEntry.getKey()).append(",").append(locald.a()).append(",").append(locald.b()).append(";");
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private String h()
  {
    if (this.f.size() > 0)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Iterator localIterator1 = this.f.entrySet().iterator();
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((d)((Map.Entry)localIterator1.next()).getValue()).c().iterator();
        label67:
        e locale;
        StringBuilder localStringBuilder2;
        if (localIterator2.hasNext())
        {
          locale = (e)localIterator2.next();
          localStringBuilder2 = localStringBuilder1.append(locale.a).append(",").append(locale.b).append(",");
          if (!locale.c) {
            break label235;
          }
        }
        label235:
        for (String str = "Y";; str = "N")
        {
          localStringBuilder2.append(str).append(",").append(locale.d).append(",").append(locale.e).append(",").append(locale.f).append(",").append(locale.g).append(",").append(locale.h).append(",").append(locale.i).append(",").append(locale.j).append(";");
          break label67;
          break;
        }
      }
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/beacon/c/c:c	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 76	com/tencent/beacon/c/c:n	Lcom/tencent/beacon/c/a;
    //   12: astore_3
    //   13: aload_3
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 76	com/tencent/beacon/c/c:n	Lcom/tencent/beacon/c/a;
    //   19: invokevirtual 224	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   22: checkcast 95	java/lang/Byte
    //   25: invokevirtual 228	java/lang/Byte:byteValue	()B
    //   28: iconst_1
    //   29: iadd
    //   30: i2b
    //   31: istore_2
    //   32: iload_2
    //   33: istore_1
    //   34: iload_2
    //   35: getstatic 49	com/tencent/beacon/c/c:r	I
    //   38: if_icmplt +15 -> 53
    //   41: invokestatic 108	com/tencent/beacon/a/a/b:a	()Lcom/tencent/beacon/a/a/b;
    //   44: aload_0
    //   45: getfield 85	com/tencent/beacon/c/c:s	Ljava/lang/Runnable;
    //   48: invokevirtual 111	com/tencent/beacon/a/a/b:a	(Ljava/lang/Runnable;)V
    //   51: iconst_0
    //   52: istore_1
    //   53: aload_0
    //   54: getfield 76	com/tencent/beacon/c/c:n	Lcom/tencent/beacon/c/a;
    //   57: iload_1
    //   58: invokestatic 99	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   61: invokevirtual 103	com/tencent/beacon/c/a:a	(Ljava/lang/Object;)V
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
    //   78: invokestatic 233	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   81: goto -17 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	c
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
    //   69	71	67	finally
    //   76	81	67	finally
    //   15	32	74	java/lang/Exception
    //   34	51	74	java/lang/Exception
    //   53	64	74	java/lang/Exception
  }
  
  public static c j(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new c(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  private void j()
  {
    try
    {
      if (!com.tencent.beacon.a.a.f().equals(this.h.a()))
      {
        this.h.a(com.tencent.beacon.a.a.f());
        this.i.a(Long.valueOf(0L));
        this.j.a(Long.valueOf(0L));
        this.k.a(Long.valueOf(0L));
        this.l.a(Long.valueOf(0L));
        this.m.a(Long.valueOf(0L));
        com.tencent.beacon.a.a.b.a().a(this.s);
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.a.g.a.a(localException);
    }
  }
  
  public final void a()
  {
    if (!this.c) {
      return;
    }
    try
    {
      j();
      long l1 = ((Long)this.i.a()).longValue();
      this.i.a(Long.valueOf(l1 + 1L));
      i();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.a.g.a.a(localException);
    }
  }
  
  public final void a(int paramInt)
  {
    if (!this.c) {}
    for (;;)
    {
      return;
      try
      {
        j();
        long l1 = ((Long)this.k.a()).longValue();
        this.k.a(Long.valueOf(l1 + paramInt));
        if (paramInt > 1)
        {
          com.tencent.beacon.a.a.b.a().a(this.s);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.a.g.a.a(localException);
      }
    }
  }
  
  public final void a(int paramInt, Map<String, String> paramMap)
  {
    super.a(paramInt, paramMap);
    if ((paramInt == 1) && (paramMap != null) && (paramMap.size() > 0))
    {
      this.c = com.tencent.beacon.a.a.a((String)paramMap.get("upQa"), this.c);
      this.d = com.tencent.beacon.a.a.a((String)paramMap.get("esnOnOff"), this.d);
      this.b = ((String)paramMap.get("speSerEnt"));
    }
    com.tencent.beacon.a.g.a.a("[module] stat module > %S", new Object[] { Boolean.valueOf(this.c) });
  }
  
  /* Error */
  public final void a(int paramInt1, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/beacon/c/c:c	Z
    //   6: istore 13
    //   8: iload 13
    //   10: ifne +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: iload_1
    //   17: ifeq -4 -> 13
    //   20: aload_0
    //   21: getfield 93	com/tencent/beacon/c/c:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: iload_1
    //   25: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 303	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 158	com/tencent/beacon/c/d
    //   34: astore 14
    //   36: aload 14
    //   38: ifnull +423 -> 461
    //   41: new 193	com/tencent/beacon/c/e
    //   44: dup
    //   45: invokespecial 304	com/tencent/beacon/c/e:<init>	()V
    //   48: astore 15
    //   50: iload_2
    //   51: ifeq +395 -> 446
    //   54: aload 14
    //   56: aload 14
    //   58: invokevirtual 172	com/tencent/beacon/c/d:a	()I
    //   61: iconst_1
    //   62: iadd
    //   63: invokevirtual 306	com/tencent/beacon/c/d:b	(I)V
    //   66: aload 15
    //   68: iload_1
    //   69: putfield 201	com/tencent/beacon/c/e:b	I
    //   72: aload 15
    //   74: lload_3
    //   75: putfield 196	com/tencent/beacon/c/e:a	J
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
    //   98: putfield 206	com/tencent/beacon/c/e:d	I
    //   101: aload 15
    //   103: iload 7
    //   105: putfield 208	com/tencent/beacon/c/e:e	I
    //   108: aload 15
    //   110: iload 8
    //   112: putfield 210	com/tencent/beacon/c/e:f	I
    //   115: aload 15
    //   117: aload 9
    //   119: putfield 212	com/tencent/beacon/c/e:g	Ljava/lang/String;
    //   122: aload 15
    //   124: aload 10
    //   126: putfield 214	com/tencent/beacon/c/e:h	Ljava/lang/String;
    //   129: aload 15
    //   131: iload_2
    //   132: putfield 202	com/tencent/beacon/c/e:c	Z
    //   135: aload 15
    //   137: iload 11
    //   139: putfield 216	com/tencent/beacon/c/e:i	I
    //   142: aload 15
    //   144: aload 12
    //   146: putfield 218	com/tencent/beacon/c/e:j	Ljava/lang/String;
    //   149: aload 14
    //   151: invokevirtual 188	com/tencent/beacon/c/d:c	()Ljava/util/List;
    //   154: aload 15
    //   156: invokeinterface 309 2 0
    //   161: pop
    //   162: getstatic 311	com/tencent/beacon/c/c:g	I
    //   165: iconst_1
    //   166: iadd
    //   167: istore_1
    //   168: iload_1
    //   169: putstatic 311	com/tencent/beacon/c/c:g	I
    //   172: iload_1
    //   173: aload_0
    //   174: getfield 80	com/tencent/beacon/c/c:q	I
    //   177: if_icmplt -164 -> 13
    //   180: new 313	java/util/HashMap
    //   183: dup
    //   184: invokespecial 314	java/util/HashMap:<init>	()V
    //   187: astore 9
    //   189: aload 9
    //   191: ldc_w 316
    //   194: new 130	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   201: getstatic 311	com/tencent/beacon/c/c:g	I
    //   204: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokeinterface 320 3 0
    //   215: pop
    //   216: aload 9
    //   218: ldc_w 322
    //   221: aload_0
    //   222: invokespecial 324	com/tencent/beacon/c/c:g	()Ljava/lang/String;
    //   225: invokeinterface 320 3 0
    //   230: pop
    //   231: aload 9
    //   233: ldc_w 326
    //   236: aload_0
    //   237: invokespecial 328	com/tencent/beacon/c/c:h	()Ljava/lang/String;
    //   240: invokeinterface 320 3 0
    //   245: pop
    //   246: aload 9
    //   248: ldc_w 330
    //   251: aload_0
    //   252: getfield 66	com/tencent/beacon/c/c:i	Lcom/tencent/beacon/c/a;
    //   255: invokevirtual 224	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   258: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   261: invokeinterface 320 3 0
    //   266: pop
    //   267: aload 9
    //   269: ldc_w 335
    //   272: aload_0
    //   273: getfield 68	com/tencent/beacon/c/c:j	Lcom/tencent/beacon/c/a;
    //   276: invokevirtual 224	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   279: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   282: invokeinterface 320 3 0
    //   287: pop
    //   288: aload 9
    //   290: ldc_w 337
    //   293: aload_0
    //   294: getfield 114	com/tencent/beacon/c/c:a	Landroid/content/Context;
    //   297: invokestatic 340	com/tencent/beacon/a/a:c	(Landroid/content/Context;)I
    //   300: invokestatic 343	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   303: invokeinterface 320 3 0
    //   308: pop
    //   309: aload 9
    //   311: ldc_w 345
    //   314: aload_0
    //   315: getfield 74	com/tencent/beacon/c/c:m	Lcom/tencent/beacon/c/a;
    //   318: invokevirtual 224	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   321: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   324: invokeinterface 320 3 0
    //   329: pop
    //   330: aload 9
    //   332: ldc_w 347
    //   335: aload_0
    //   336: getfield 72	com/tencent/beacon/c/c:l	Lcom/tencent/beacon/c/a;
    //   339: invokevirtual 224	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   342: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   345: invokeinterface 320 3 0
    //   350: pop
    //   351: aload 9
    //   353: ldc_w 349
    //   356: aload_0
    //   357: getfield 70	com/tencent/beacon/c/c:k	Lcom/tencent/beacon/c/a;
    //   360: invokevirtual 224	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   363: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   366: invokeinterface 320 3 0
    //   371: pop
    //   372: aload 9
    //   374: ldc_w 351
    //   377: aload_0
    //   378: getfield 64	com/tencent/beacon/c/c:h	Lcom/tencent/beacon/c/a;
    //   381: invokevirtual 224	com/tencent/beacon/c/a:a	()Ljava/lang/Object;
    //   384: checkcast 243	java/lang/String
    //   387: ldc_w 353
    //   390: ldc 184
    //   392: invokevirtual 357	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   395: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   398: invokeinterface 320 3 0
    //   403: pop
    //   404: getstatic 47	com/tencent/beacon/c/c:p	Ljava/lang/String;
    //   407: iconst_1
    //   408: lconst_0
    //   409: lconst_0
    //   410: aload 9
    //   412: iconst_1
    //   413: invokestatic 363	com/tencent/beacon/event/UserAction:onUserAction	(Ljava/lang/String;ZJJLjava/util/Map;Z)Z
    //   416: ifeq -403 -> 13
    //   419: aload_0
    //   420: getfield 93	com/tencent/beacon/c/c:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   423: invokevirtual 366	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   426: iconst_0
    //   427: putstatic 311	com/tencent/beacon/c/c:g	I
    //   430: aload_0
    //   431: bipush 10
    //   433: putfield 80	com/tencent/beacon/c/c:q	I
    //   436: goto -423 -> 13
    //   439: astore 9
    //   441: aload_0
    //   442: monitorexit
    //   443: aload 9
    //   445: athrow
    //   446: aload 14
    //   448: aload 14
    //   450: invokevirtual 177	com/tencent/beacon/c/d:b	()I
    //   453: iconst_1
    //   454: iadd
    //   455: invokevirtual 368	com/tencent/beacon/c/d:c	(I)V
    //   458: goto -392 -> 66
    //   461: new 158	com/tencent/beacon/c/d
    //   464: dup
    //   465: invokespecial 369	com/tencent/beacon/c/d:<init>	()V
    //   468: astore 14
    //   470: aload 14
    //   472: iload_1
    //   473: invokevirtual 371	com/tencent/beacon/c/d:a	(I)V
    //   476: iload_2
    //   477: ifeq +131 -> 608
    //   480: aload 14
    //   482: iconst_1
    //   483: invokevirtual 306	com/tencent/beacon/c/d:b	(I)V
    //   486: new 193	com/tencent/beacon/c/e
    //   489: dup
    //   490: invokespecial 304	com/tencent/beacon/c/e:<init>	()V
    //   493: astore 15
    //   495: aload 15
    //   497: iload_1
    //   498: putfield 201	com/tencent/beacon/c/e:b	I
    //   501: aload 15
    //   503: lload_3
    //   504: putfield 196	com/tencent/beacon/c/e:a	J
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
    //   527: putfield 206	com/tencent/beacon/c/e:d	I
    //   530: aload 15
    //   532: iload 7
    //   534: putfield 208	com/tencent/beacon/c/e:e	I
    //   537: aload 15
    //   539: iload 8
    //   541: putfield 210	com/tencent/beacon/c/e:f	I
    //   544: aload 15
    //   546: aload 9
    //   548: putfield 212	com/tencent/beacon/c/e:g	Ljava/lang/String;
    //   551: aload 15
    //   553: aload 10
    //   555: putfield 214	com/tencent/beacon/c/e:h	Ljava/lang/String;
    //   558: aload 15
    //   560: iload_2
    //   561: putfield 202	com/tencent/beacon/c/e:c	Z
    //   564: aload 15
    //   566: iload 11
    //   568: putfield 216	com/tencent/beacon/c/e:i	I
    //   571: aload 15
    //   573: aload 12
    //   575: putfield 218	com/tencent/beacon/c/e:j	Ljava/lang/String;
    //   578: aload 14
    //   580: invokevirtual 188	com/tencent/beacon/c/d:c	()Ljava/util/List;
    //   583: aload 15
    //   585: invokeinterface 309 2 0
    //   590: pop
    //   591: aload_0
    //   592: getfield 93	com/tencent/beacon/c/c:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   595: iload_1
    //   596: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   599: aload 14
    //   601: invokevirtual 372	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   604: pop
    //   605: goto -443 -> 162
    //   608: aload 14
    //   610: iconst_1
    //   611: invokevirtual 368	com/tencent/beacon/c/d:c	(I)V
    //   614: goto -128 -> 486
    //   617: astore 10
    //   619: aload 10
    //   621: invokestatic 233	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   624: goto -220 -> 404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	c
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
    //   34	575	14	locald	d
    //   48	536	15	locale	e
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
  
  public final String a_(String paramString)
  {
    String str = null;
    if (this.d) {
      str = b.a(this.a).a(paramString);
    }
    return str;
  }
  
  public final void b()
  {
    if (!this.c) {
      return;
    }
    try
    {
      j();
      long l1 = ((Long)this.j.a()).longValue();
      this.j.a(Long.valueOf(l1 + 1L));
      i();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.a.g.a.a(localException);
    }
  }
  
  public final void b(int paramInt)
  {
    if (!this.c) {}
    for (;;)
    {
      return;
      try
      {
        j();
        long l1 = ((Long)this.l.a()).longValue();
        this.l.a(Long.valueOf(l1 + paramInt));
        if (paramInt > 1)
        {
          com.tencent.beacon.a.a.b.a().a(this.s);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.a.g.a.a(localException);
      }
    }
  }
  
  public final void c(int paramInt)
  {
    if (!this.c) {}
    for (;;)
    {
      return;
      try
      {
        j();
        long l1 = ((Long)this.m.a()).longValue();
        this.m.a(Long.valueOf(l1 + paramInt));
        if (paramInt > 1)
        {
          com.tencent.beacon.a.a.b.a().a(this.s);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.a.g.a.a(localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.c.c
 * JD-Core Version:    0.7.0.1
 */