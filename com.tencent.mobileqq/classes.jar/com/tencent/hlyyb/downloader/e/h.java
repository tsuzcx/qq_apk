package com.tencent.hlyyb.downloader.e;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public final class h
{
  public long a;
  public volatile long b;
  volatile long c;
  volatile long d;
  public boolean e;
  private long f;
  private String g;
  private String h;
  private List<com.tencent.hlyyb.downloader.e.b.a> i;
  private List<com.tencent.hlyyb.downloader.e.b.a> j;
  private volatile long k;
  private volatile int l;
  
  /* Error */
  public h(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc2_w 34
    //   8: putfield 37	com/tencent/hlyyb/downloader/e/h:a	J
    //   11: aload_0
    //   12: lconst_0
    //   13: putfield 39	com/tencent/hlyyb/downloader/e/h:f	J
    //   16: aload_0
    //   17: lconst_0
    //   18: putfield 41	com/tencent/hlyyb/downloader/e/h:b	J
    //   21: aload_0
    //   22: lconst_0
    //   23: putfield 43	com/tencent/hlyyb/downloader/e/h:c	J
    //   26: aload_0
    //   27: lconst_0
    //   28: putfield 45	com/tencent/hlyyb/downloader/e/h:d	J
    //   31: aload_0
    //   32: ldc 47
    //   34: putfield 49	com/tencent/hlyyb/downloader/e/h:g	Ljava/lang/String;
    //   37: aload_0
    //   38: ldc 47
    //   40: putfield 51	com/tencent/hlyyb/downloader/e/h:h	Ljava/lang/String;
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 53	com/tencent/hlyyb/downloader/e/h:e	Z
    //   48: aload_0
    //   49: new 55	java/util/LinkedList
    //   52: dup
    //   53: invokespecial 56	java/util/LinkedList:<init>	()V
    //   56: putfield 58	com/tencent/hlyyb/downloader/e/h:i	Ljava/util/List;
    //   59: aload_0
    //   60: new 55	java/util/LinkedList
    //   63: dup
    //   64: invokespecial 56	java/util/LinkedList:<init>	()V
    //   67: putfield 60	com/tencent/hlyyb/downloader/e/h:j	Ljava/util/List;
    //   70: aload_0
    //   71: lconst_0
    //   72: putfield 62	com/tencent/hlyyb/downloader/e/h:k	J
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 64	com/tencent/hlyyb/downloader/e/h:l	I
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 53	com/tencent/hlyyb/downloader/e/h:e	Z
    //   85: aload_1
    //   86: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: istore 4
    //   91: iload 4
    //   93: ifne +304 -> 397
    //   96: aload_1
    //   97: ldc 72
    //   99: invokevirtual 78	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +319 -> 423
    //   107: aload_1
    //   108: arraylength
    //   109: ifne +4 -> 113
    //   112: return
    //   113: aload_1
    //   114: iconst_0
    //   115: aaload
    //   116: ldc 80
    //   118: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifne +4 -> 125
    //   124: return
    //   125: aload_1
    //   126: arraylength
    //   127: istore_2
    //   128: iload_2
    //   129: bipush 7
    //   131: if_icmpge +4 -> 135
    //   134: return
    //   135: aload_0
    //   136: aload_1
    //   137: iconst_1
    //   138: aaload
    //   139: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   142: putfield 37	com/tencent/hlyyb/downloader/e/h:a	J
    //   145: aload_0
    //   146: aload_1
    //   147: iconst_2
    //   148: aaload
    //   149: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   152: putfield 41	com/tencent/hlyyb/downloader/e/h:b	J
    //   155: aload_0
    //   156: aload_1
    //   157: iconst_3
    //   158: aaload
    //   159: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   162: putfield 43	com/tencent/hlyyb/downloader/e/h:c	J
    //   165: aload_0
    //   166: aload_1
    //   167: iconst_4
    //   168: aaload
    //   169: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   172: putfield 45	com/tencent/hlyyb/downloader/e/h:d	J
    //   175: aload_1
    //   176: iconst_5
    //   177: aaload
    //   178: ldc 92
    //   180: invokevirtual 78	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   183: astore 5
    //   185: aload 5
    //   187: arraylength
    //   188: istore_3
    //   189: iconst_0
    //   190: istore_2
    //   191: iload_2
    //   192: iload_3
    //   193: if_icmpge +54 -> 247
    //   196: new 94	com/tencent/hlyyb/downloader/e/b/a
    //   199: dup
    //   200: aload_0
    //   201: aload 5
    //   203: iload_2
    //   204: aaload
    //   205: invokespecial 97	com/tencent/hlyyb/downloader/e/b/a:<init>	(Lcom/tencent/hlyyb/downloader/e/h;Ljava/lang/String;)V
    //   208: astore 6
    //   210: aload 6
    //   212: getfield 99	com/tencent/hlyyb/downloader/e/b/a:a	Z
    //   215: ifeq +22 -> 237
    //   218: aload_0
    //   219: getfield 58	com/tencent/hlyyb/downloader/e/h:i	Ljava/util/List;
    //   222: aload 6
    //   224: invokeinterface 104 2 0
    //   229: pop
    //   230: iload_2
    //   231: iconst_1
    //   232: iadd
    //   233: istore_2
    //   234: goto -43 -> 191
    //   237: aload_0
    //   238: getfield 58	com/tencent/hlyyb/downloader/e/h:i	Ljava/util/List;
    //   241: invokeinterface 107 1 0
    //   246: return
    //   247: aload_1
    //   248: arraylength
    //   249: bipush 9
    //   251: if_icmplt +19 -> 270
    //   254: aload_0
    //   255: aload_1
    //   256: bipush 7
    //   258: aaload
    //   259: invokevirtual 109	com/tencent/hlyyb/downloader/e/h:a	(Ljava/lang/String;)V
    //   262: aload_0
    //   263: aload_1
    //   264: bipush 8
    //   266: aaload
    //   267: invokevirtual 111	com/tencent/hlyyb/downloader/e/h:b	(Ljava/lang/String;)V
    //   270: aload_1
    //   271: arraylength
    //   272: bipush 11
    //   274: if_icmplt +123 -> 397
    //   277: aload_1
    //   278: bipush 9
    //   280: aaload
    //   281: ldc 92
    //   283: invokevirtual 78	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   286: astore 5
    //   288: aload 5
    //   290: arraylength
    //   291: istore_3
    //   292: iconst_0
    //   293: istore_2
    //   294: iload_2
    //   295: iload_3
    //   296: if_icmpge +56 -> 352
    //   299: new 94	com/tencent/hlyyb/downloader/e/b/a
    //   302: dup
    //   303: aload_0
    //   304: aload 5
    //   306: iload_2
    //   307: aaload
    //   308: invokespecial 97	com/tencent/hlyyb/downloader/e/b/a:<init>	(Lcom/tencent/hlyyb/downloader/e/h;Ljava/lang/String;)V
    //   311: astore 6
    //   313: aload 6
    //   315: getfield 99	com/tencent/hlyyb/downloader/e/b/a:a	Z
    //   318: ifeq +18 -> 336
    //   321: aload_0
    //   322: getfield 60	com/tencent/hlyyb/downloader/e/h:j	Ljava/util/List;
    //   325: aload 6
    //   327: invokeinterface 104 2 0
    //   332: pop
    //   333: goto +12 -> 345
    //   336: aload_0
    //   337: getfield 60	com/tencent/hlyyb/downloader/e/h:j	Ljava/util/List;
    //   340: invokeinterface 107 1 0
    //   345: iload_2
    //   346: iconst_1
    //   347: iadd
    //   348: istore_2
    //   349: goto -55 -> 294
    //   352: aload_1
    //   353: bipush 10
    //   355: aaload
    //   356: ldc 92
    //   358: invokevirtual 78	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   361: astore_1
    //   362: aload_0
    //   363: aload_1
    //   364: iconst_0
    //   365: aaload
    //   366: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   369: putfield 62	com/tencent/hlyyb/downloader/e/h:k	J
    //   372: aload_0
    //   373: aload_1
    //   374: iconst_1
    //   375: aaload
    //   376: invokestatic 117	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   379: putfield 64	com/tencent/hlyyb/downloader/e/h:l	I
    //   382: goto +15 -> 397
    //   385: astore_1
    //   386: aload_1
    //   387: invokevirtual 120	java/lang/Throwable:printStackTrace	()V
    //   390: return
    //   391: astore_1
    //   392: aload_1
    //   393: invokevirtual 121	java/lang/NumberFormatException:printStackTrace	()V
    //   396: return
    //   397: aload_0
    //   398: aload_0
    //   399: invokespecial 125	com/tencent/hlyyb/downloader/e/h:m	()J
    //   402: putfield 39	com/tencent/hlyyb/downloader/e/h:f	J
    //   405: aload_0
    //   406: iconst_1
    //   407: putfield 53	com/tencent/hlyyb/downloader/e/h:e	Z
    //   410: return
    //   411: astore_1
    //   412: aload_0
    //   413: iconst_0
    //   414: putfield 53	com/tencent/hlyyb/downloader/e/h:e	Z
    //   417: aload_1
    //   418: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   421: return
    //   422: astore_1
    //   423: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	h
    //   0	424	1	paramString	String
    //   127	222	2	m	int
    //   188	109	3	n	int
    //   89	3	4	bool	boolean
    //   183	122	5	arrayOfString	String[]
    //   208	118	6	locala	com.tencent.hlyyb.downloader.e.b.a
    // Exception table:
    //   from	to	target	type
    //   352	382	385	java/lang/Throwable
    //   135	175	391	java/lang/NumberFormatException
    //   85	91	411	java/lang/Exception
    //   107	112	411	java/lang/Exception
    //   113	124	411	java/lang/Exception
    //   125	128	411	java/lang/Exception
    //   135	175	411	java/lang/Exception
    //   175	189	411	java/lang/Exception
    //   196	230	411	java/lang/Exception
    //   237	246	411	java/lang/Exception
    //   247	270	411	java/lang/Exception
    //   270	292	411	java/lang/Exception
    //   299	333	411	java/lang/Exception
    //   336	345	411	java/lang/Exception
    //   352	382	411	java/lang/Exception
    //   386	390	411	java/lang/Exception
    //   392	396	411	java/lang/Exception
    //   397	410	411	java/lang/Exception
    //   96	103	422	java/lang/Exception
  }
  
  private com.tencent.hlyyb.downloader.e.b.a j()
  {
    Object localObject3;
    long l1;
    long l3;
    long l2;
    label330:
    label346:
    Object localObject2;
    label352:
    label358:
    synchronized (this.i)
    {
      com.tencent.hlyyb.downloader.e.b.a locala;
      if (this.i.size() == 0)
      {
        locala = new com.tencent.hlyyb.downloader.e.b.a(this, 0L, 0L, 0L, -1L);
      }
      else
      {
        localObject3 = (com.tencent.hlyyb.downloader.e.b.a)this.i.get(0);
        Iterator localIterator = this.i.iterator();
        if (!localIterator.hasNext()) {
          break label346;
        }
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
        if (!locala.h)
        {
          l1 = this.a;
          if (locala.g != -1L) {
            l1 = locala.g;
          }
          if (l1 - locala.f > 0L) {}
        }
        else
        {
          l1 = this.a;
          if (locala.g != -1L) {
            l1 = locala.g;
          }
          l3 = locala.f;
          l2 = this.a;
          if (((com.tencent.hlyyb.downloader.e.b.a)localObject3).g != -1L)
          {
            l2 = ((com.tencent.hlyyb.downloader.e.b.a)localObject3).g - ((com.tencent.hlyyb.downloader.e.b.a)localObject3).f;
            break label330;
          }
          l2 -= ((com.tencent.hlyyb.downloader.e.b.a)localObject3).f;
          break label330;
        }
        if (locala != null) {
          break label358;
        }
        l1 = this.a;
        if (((com.tencent.hlyyb.downloader.e.b.a)localObject3).g != -1L) {
          l1 = ((com.tencent.hlyyb.downloader.e.b.a)localObject3).g;
        }
        l1 -= ((com.tencent.hlyyb.downloader.e.b.a)localObject3).f;
        l2 = ((com.tencent.hlyyb.downloader.e.b.a)localObject3).f;
        if (l1 <= com.tencent.hlyyb.downloader.a.a.a() << 1) {
          break label352;
        }
        l1 = l2 + l1 / 2L;
        locala = new com.tencent.hlyyb.downloader.e.b.a(this, l1, l1, l1, ((com.tencent.hlyyb.downloader.e.b.a)localObject3).g);
        locala.c = ((com.tencent.hlyyb.downloader.e.b.a)localObject3).b;
      }
      if (locala != null) {
        locala.h = true;
      }
      return locala;
    }
  }
  
  private com.tencent.hlyyb.downloader.e.b.a k()
  {
    List localList = this.j;
    Object localObject3 = null;
    try
    {
      Iterator localIterator = this.j.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
      } while ((((com.tencent.hlyyb.downloader.e.b.a)localObject1).h) || (((com.tencent.hlyyb.downloader.e.b.a)localObject1).f == ((com.tencent.hlyyb.downloader.e.b.a)localObject1).g));
      if (localObject1 != null) {
        ((com.tencent.hlyyb.downloader.e.b.a)localObject1).h = true;
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private long l()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      com.tencent.hlyyb.downloader.e.b.a locala;
      for (long l1 = 0L; localIterator.hasNext(); l1 += locala.e - locala.d) {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
      }
      synchronized (this.j)
      {
        localIterator = this.j.iterator();
        for (long l2 = 0L; localIterator.hasNext(); l2 += locala.g - locala.d) {
          locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
        }
        localIterator = this.j.iterator();
        for (long l3 = 0L; localIterator.hasNext(); l3 += locala.e - locala.d) {
          locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
        }
        l1 = l1 - l2 + l3;
        if (l1 > 0L) {
          return l1;
        }
      }
    }
    return 0L;
  }
  
  private long m()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      com.tencent.hlyyb.downloader.e.b.a locala;
      for (long l1 = 0L; localIterator.hasNext(); l1 += locala.e - locala.d) {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
      }
      synchronized (this.j)
      {
        localIterator = this.j.iterator();
        while (localIterator.hasNext())
        {
          locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
          l1 += locala.e - locala.d;
        }
        return l1;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final com.tencent.hlyyb.downloader.e.b.a a()
  {
    com.tencent.hlyyb.downloader.e.b.a locala = j();
    if (locala != null) {
      return locala;
    }
    return k();
  }
  
  /* Error */
  public final com.tencent.hlyyb.downloader.e.b.a a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/tencent/hlyyb/downloader/e/h:i	Ljava/util/List;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 58	com/tencent/hlyyb/downloader/e/h:i	Ljava/util/List;
    //   11: invokeinterface 143 1 0
    //   16: astore 4
    //   18: aload 4
    //   20: invokeinterface 149 1 0
    //   25: ifeq +31 -> 56
    //   28: aload 4
    //   30: invokeinterface 153 1 0
    //   35: checkcast 94	com/tencent/hlyyb/downloader/e/b/a
    //   38: astore 5
    //   40: aload 5
    //   42: getfield 166	com/tencent/hlyyb/downloader/e/b/a:b	I
    //   45: istore_2
    //   46: iload_2
    //   47: iload_1
    //   48: if_icmpne -30 -> 18
    //   51: aload_3
    //   52: monitorexit
    //   53: aload 5
    //   55: areturn
    //   56: aload_3
    //   57: monitorexit
    //   58: aload_0
    //   59: getfield 60	com/tencent/hlyyb/downloader/e/h:j	Ljava/util/List;
    //   62: astore_3
    //   63: aload_3
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 60	com/tencent/hlyyb/downloader/e/h:j	Ljava/util/List;
    //   69: invokeinterface 143 1 0
    //   74: astore 4
    //   76: aload 4
    //   78: invokeinterface 149 1 0
    //   83: ifeq +31 -> 114
    //   86: aload 4
    //   88: invokeinterface 153 1 0
    //   93: checkcast 94	com/tencent/hlyyb/downloader/e/b/a
    //   96: astore 5
    //   98: aload 5
    //   100: getfield 166	com/tencent/hlyyb/downloader/e/b/a:b	I
    //   103: istore_2
    //   104: iload_2
    //   105: iload_1
    //   106: if_icmpne -30 -> 76
    //   109: aload_3
    //   110: monitorexit
    //   111: aload 5
    //   113: areturn
    //   114: aload_3
    //   115: monitorexit
    //   116: aconst_null
    //   117: areturn
    //   118: aload_3
    //   119: monitorexit
    //   120: aload 4
    //   122: athrow
    //   123: aload_3
    //   124: monitorexit
    //   125: goto +6 -> 131
    //   128: aload 4
    //   130: athrow
    //   131: goto -3 -> 128
    //   134: astore 4
    //   136: goto -80 -> 56
    //   139: astore 4
    //   141: goto -27 -> 114
    //   144: astore 4
    //   146: goto -23 -> 123
    //   149: astore 4
    //   151: goto -33 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	h
    //   0	154	1	paramInt	int
    //   45	62	2	m	int
    //   16	113	4	localIterator	Iterator
    //   134	1	4	localException1	java.lang.Exception
    //   139	1	4	localException2	java.lang.Exception
    //   144	1	4	localObject1	Object
    //   149	1	4	localObject2	Object
    //   38	74	5	locala	com.tencent.hlyyb.downloader.e.b.a
    // Exception table:
    //   from	to	target	type
    //   7	18	134	java/lang/Exception
    //   18	46	134	java/lang/Exception
    //   65	76	139	java/lang/Exception
    //   76	104	139	java/lang/Exception
    //   7	18	144	finally
    //   18	46	144	finally
    //   51	53	144	finally
    //   56	58	144	finally
    //   123	125	144	finally
    //   65	76	149	finally
    //   76	104	149	finally
    //   109	111	149	finally
    //   114	116	149	finally
    //   118	120	149	finally
  }
  
  public final void a(long paramLong, int paramInt)
  {
    long l1;
    if (this.k == 0L)
    {
      l1 = paramLong;
    }
    else
    {
      l1 = paramLong;
      if (this.k > paramLong) {
        l1 = this.k;
      }
    }
    this.k = l1;
    int m;
    if (this.l == 0)
    {
      m = paramInt;
    }
    else
    {
      m = paramInt;
      if (this.l > paramInt) {
        m = this.l;
      }
    }
    this.l = m;
  }
  
  public final void a(com.tencent.hlyyb.downloader.e.b.a parama)
  {
    if (parama.g == -1L) {
      return;
    }
    if (parama.d >= parama.g) {
      return;
    }
    List localList = this.j;
    Object localObject2 = null;
    int i1 = 0;
    int m = 0;
    Object localObject1 = localObject2;
    int n = i1;
    for (;;)
    {
      try
      {
        if (m < this.j.size())
        {
          localObject1 = (com.tencent.hlyyb.downloader.e.b.a)this.j.get(m);
          if (((com.tencent.hlyyb.downloader.e.b.a)localObject1).d != parama.d) {
            continue;
          }
          n = m;
        }
        if (localObject1 != null)
        {
          if (parama.g <= ((com.tencent.hlyyb.downloader.e.b.a)localObject1).g) {
            break label243;
          }
          parama.b = ((com.tencent.hlyyb.downloader.e.b.a)localObject1).b;
          parama.c = ((com.tencent.hlyyb.downloader.e.b.a)localObject1).c;
          this.j.remove(n);
          this.j.add(n, parama);
          return;
        }
        m = 10000;
        n = this.j.size();
        if (n > 0) {
          m = ((com.tencent.hlyyb.downloader.e.b.a)this.j.get(n - 1)).b + 1;
        }
        parama.c = m;
        parama.b = m;
        this.j.add(parama);
        return;
      }
      finally
      {
        continue;
        throw parama;
        continue;
        m += 1;
      }
      break;
      label243:
      parama = (com.tencent.hlyyb.downloader.e.b.a)localObject1;
    }
  }
  
  public final void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("null")))
    {
      this.g = paramString.replace("|", "");
      return;
    }
    this.g = "";
  }
  
  public final int b()
  {
    synchronized (this.j)
    {
      Iterator localIterator = this.j.iterator();
      com.tencent.hlyyb.downloader.e.b.a locala;
      for (int m = 0; localIterator.hasNext(); m = (int)(m + (locala.e - locala.d))) {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
      }
      return m;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("null")))
    {
      this.h = paramString.replace("|", "");
      return;
    }
    this.h = "";
  }
  
  public final boolean b(com.tencent.hlyyb.downloader.e.b.a parama)
  {
    if (parama.b == -1) {}
    for (;;)
    {
      com.tencent.hlyyb.downloader.e.b.a locala;
      synchronized (this.i)
      {
        if (parama.c == -1)
        {
          if (this.i.size() == 0)
          {
            parama.b = 0;
            parama.g = this.a;
            this.i.add(parama);
            return true;
          }
        }
        else if (parama.c < this.i.size())
        {
          localObject = null;
          Iterator localIterator = this.i.iterator();
          if (localIterator.hasNext())
          {
            locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
            if (locala.b == parama.c)
            {
              if (locala.f >= locala.g) {
                return false;
              }
              if (locala.f + com.tencent.hlyyb.downloader.a.a.a() <= parama.d) {
                break label254;
              }
              return false;
            }
            if ((locala.g <= parama.d) || (locala.d >= parama.g)) {
              continue;
            }
            return false;
          }
          if (localObject == null) {
            return false;
          }
          parama.b = this.i.size();
          localObject.g = parama.d;
          this.i.add(parama);
          return true;
        }
        return false;
      }
      return false;
      label254:
      Object localObject = locala;
    }
  }
  
  public final String c()
  {
    StringBuilder localStringBuilder = new StringBuilder("3.0");
    localStringBuilder.append("|");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(((com.tencent.hlyyb.downloader.e.b.a)localIterator.next()).a());
        localStringBuilder.append(";");
      }
      if (this.i.size() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      localStringBuilder.append("|");
      localStringBuilder.append("null");
      localStringBuilder.append("|");
      if (TextUtils.isEmpty(this.g)) {
        ??? = "null";
      } else {
        ??? = this.g;
      }
      localStringBuilder.append((String)???);
      localStringBuilder.append("|");
      if (TextUtils.isEmpty(this.h)) {
        ??? = "null";
      } else {
        ??? = this.h;
      }
      localStringBuilder.append((String)???);
      localStringBuilder.append("|");
      synchronized (this.j)
      {
        localIterator = this.j.iterator();
        while (localIterator.hasNext())
        {
          localStringBuilder.append(((com.tencent.hlyyb.downloader.e.b.a)localIterator.next()).a());
          localStringBuilder.append(";");
        }
        if (this.j.size() > 0) {
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        }
        localStringBuilder.append("|");
        ??? = new StringBuilder();
        ((StringBuilder)???).append(this.k);
        ((StringBuilder)???).append(";");
        ((StringBuilder)???).append(this.l);
        localStringBuilder.append(((StringBuilder)???).toString());
        return localStringBuilder.toString();
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public final long d()
  {
    return l();
  }
  
  public final boolean e()
  {
    long l1 = this.a;
    return (l1 > 0L) && (l1 == l());
  }
  
  public final long f()
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
      com.tencent.hlyyb.downloader.e.b.a locala;
      for (long l1 = 0L; localIterator.hasNext(); l1 += locala.f - locala.d) {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
      }
      synchronized (this.j)
      {
        localIterator = this.j.iterator();
        for (long l2 = 0L; localIterator.hasNext(); l2 += locala.g - locala.d) {
          locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
        }
        localIterator = this.j.iterator();
        for (long l3 = 0L; localIterator.hasNext(); l3 += locala.f - locala.d) {
          locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
        }
        l1 = l1 - l2 + l3;
        if (l1 > 0L) {
          return l1;
        }
      }
    }
    return 0L;
  }
  
  public final long g()
  {
    return m() - this.f;
  }
  
  public final long h()
  {
    return this.k;
  }
  
  public final int i()
  {
    return this.l;
  }
  
  public final String toString()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.h
 * JD-Core Version:    0.7.0.1
 */