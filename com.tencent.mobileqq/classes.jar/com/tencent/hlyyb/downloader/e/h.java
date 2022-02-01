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
    //   93: ifne +300 -> 393
    //   96: aload_1
    //   97: ldc 72
    //   99: invokevirtual 78	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +310 -> 414
    //   107: aload_1
    //   108: arraylength
    //   109: ifne +4 -> 113
    //   112: return
    //   113: aload_1
    //   114: iconst_0
    //   115: aaload
    //   116: ldc 80
    //   118: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifeq +293 -> 414
    //   124: aload_1
    //   125: arraylength
    //   126: istore_2
    //   127: iload_2
    //   128: bipush 7
    //   130: if_icmplt +284 -> 414
    //   133: aload_0
    //   134: aload_1
    //   135: iconst_1
    //   136: aaload
    //   137: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   140: putfield 37	com/tencent/hlyyb/downloader/e/h:a	J
    //   143: aload_0
    //   144: aload_1
    //   145: iconst_2
    //   146: aaload
    //   147: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   150: putfield 41	com/tencent/hlyyb/downloader/e/h:b	J
    //   153: aload_0
    //   154: aload_1
    //   155: iconst_3
    //   156: aaload
    //   157: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   160: putfield 43	com/tencent/hlyyb/downloader/e/h:c	J
    //   163: aload_0
    //   164: aload_1
    //   165: iconst_4
    //   166: aaload
    //   167: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   170: putfield 45	com/tencent/hlyyb/downloader/e/h:d	J
    //   173: aload_1
    //   174: iconst_5
    //   175: aaload
    //   176: ldc 92
    //   178: invokevirtual 78	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   181: astore 5
    //   183: aload 5
    //   185: arraylength
    //   186: istore_3
    //   187: iconst_0
    //   188: istore_2
    //   189: iload_2
    //   190: iload_3
    //   191: if_icmpge +71 -> 262
    //   194: new 94	com/tencent/hlyyb/downloader/e/b/a
    //   197: dup
    //   198: aload_0
    //   199: aload 5
    //   201: iload_2
    //   202: aaload
    //   203: invokespecial 97	com/tencent/hlyyb/downloader/e/b/a:<init>	(Lcom/tencent/hlyyb/downloader/e/h;Ljava/lang/String;)V
    //   206: astore 6
    //   208: aload 6
    //   210: getfield 99	com/tencent/hlyyb/downloader/e/b/a:a	Z
    //   213: ifeq +39 -> 252
    //   216: aload_0
    //   217: getfield 58	com/tencent/hlyyb/downloader/e/h:i	Ljava/util/List;
    //   220: aload 6
    //   222: invokeinterface 104 2 0
    //   227: pop
    //   228: iload_2
    //   229: iconst_1
    //   230: iadd
    //   231: istore_2
    //   232: goto -43 -> 189
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 107	java/lang/NumberFormatException:printStackTrace	()V
    //   240: return
    //   241: astore_1
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 53	com/tencent/hlyyb/downloader/e/h:e	Z
    //   247: aload_1
    //   248: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   251: return
    //   252: aload_0
    //   253: getfield 58	com/tencent/hlyyb/downloader/e/h:i	Ljava/util/List;
    //   256: invokeinterface 111 1 0
    //   261: return
    //   262: aload_1
    //   263: arraylength
    //   264: bipush 9
    //   266: if_icmplt +19 -> 285
    //   269: aload_0
    //   270: aload_1
    //   271: bipush 7
    //   273: aaload
    //   274: invokevirtual 113	com/tencent/hlyyb/downloader/e/h:a	(Ljava/lang/String;)V
    //   277: aload_0
    //   278: aload_1
    //   279: bipush 8
    //   281: aaload
    //   282: invokevirtual 115	com/tencent/hlyyb/downloader/e/h:b	(Ljava/lang/String;)V
    //   285: aload_1
    //   286: arraylength
    //   287: bipush 11
    //   289: if_icmplt +104 -> 393
    //   292: aload_1
    //   293: bipush 9
    //   295: aaload
    //   296: ldc 92
    //   298: invokevirtual 78	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   301: astore 5
    //   303: aload 5
    //   305: arraylength
    //   306: istore_3
    //   307: iconst_0
    //   308: istore_2
    //   309: iload_2
    //   310: iload_3
    //   311: if_icmpge +52 -> 363
    //   314: new 94	com/tencent/hlyyb/downloader/e/b/a
    //   317: dup
    //   318: aload_0
    //   319: aload 5
    //   321: iload_2
    //   322: aaload
    //   323: invokespecial 97	com/tencent/hlyyb/downloader/e/b/a:<init>	(Lcom/tencent/hlyyb/downloader/e/h;Ljava/lang/String;)V
    //   326: astore 6
    //   328: aload 6
    //   330: getfield 99	com/tencent/hlyyb/downloader/e/b/a:a	Z
    //   333: ifeq +18 -> 351
    //   336: aload_0
    //   337: getfield 60	com/tencent/hlyyb/downloader/e/h:j	Ljava/util/List;
    //   340: aload 6
    //   342: invokeinterface 104 2 0
    //   347: pop
    //   348: goto +67 -> 415
    //   351: aload_0
    //   352: getfield 60	com/tencent/hlyyb/downloader/e/h:j	Ljava/util/List;
    //   355: invokeinterface 111 1 0
    //   360: goto +55 -> 415
    //   363: aload_1
    //   364: bipush 10
    //   366: aaload
    //   367: ldc 92
    //   369: invokevirtual 78	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   372: astore_1
    //   373: aload_0
    //   374: aload_1
    //   375: iconst_0
    //   376: aaload
    //   377: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   380: putfield 62	com/tencent/hlyyb/downloader/e/h:k	J
    //   383: aload_0
    //   384: aload_1
    //   385: iconst_1
    //   386: aaload
    //   387: invokestatic 121	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   390: putfield 64	com/tencent/hlyyb/downloader/e/h:l	I
    //   393: aload_0
    //   394: aload_0
    //   395: invokespecial 125	com/tencent/hlyyb/downloader/e/h:m	()J
    //   398: putfield 39	com/tencent/hlyyb/downloader/e/h:f	J
    //   401: aload_0
    //   402: iconst_1
    //   403: putfield 53	com/tencent/hlyyb/downloader/e/h:e	Z
    //   406: return
    //   407: astore_1
    //   408: aload_1
    //   409: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   412: return
    //   413: astore_1
    //   414: return
    //   415: iload_2
    //   416: iconst_1
    //   417: iadd
    //   418: istore_2
    //   419: goto -110 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	h
    //   0	422	1	paramString	String
    //   126	293	2	m	int
    //   186	126	3	n	int
    //   89	3	4	bool	boolean
    //   181	139	5	arrayOfString	String[]
    //   206	135	6	locala	com.tencent.hlyyb.downloader.e.b.a
    // Exception table:
    //   from	to	target	type
    //   133	173	235	java/lang/NumberFormatException
    //   85	91	241	java/lang/Exception
    //   107	112	241	java/lang/Exception
    //   113	127	241	java/lang/Exception
    //   133	173	241	java/lang/Exception
    //   173	187	241	java/lang/Exception
    //   194	228	241	java/lang/Exception
    //   236	240	241	java/lang/Exception
    //   252	261	241	java/lang/Exception
    //   262	285	241	java/lang/Exception
    //   285	307	241	java/lang/Exception
    //   314	348	241	java/lang/Exception
    //   351	360	241	java/lang/Exception
    //   363	393	241	java/lang/Exception
    //   393	406	241	java/lang/Exception
    //   408	412	241	java/lang/Exception
    //   363	393	407	java/lang/Throwable
    //   96	103	413	java/lang/Exception
  }
  
  private com.tencent.hlyyb.downloader.e.b.a j()
  {
    for (;;)
    {
      Object localObject5;
      synchronized (this.i)
      {
        if (this.i.size() == 0)
        {
          localObject1 = new com.tencent.hlyyb.downloader.e.b.a(this, 0L, 0L, 0L, -1L);
          if (localObject1 != null) {
            ((com.tencent.hlyyb.downloader.e.b.a)localObject1).h = true;
          }
          return localObject1;
        }
        localObject4 = (com.tencent.hlyyb.downloader.e.b.a)this.i.get(0);
        localObject5 = this.i.iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label364;
        }
        Object localObject1 = (com.tencent.hlyyb.downloader.e.b.a)((Iterator)localObject5).next();
        if (((com.tencent.hlyyb.downloader.e.b.a)localObject1).h) {
          break label255;
        }
        l1 = this.a;
        if (((com.tencent.hlyyb.downloader.e.b.a)localObject1).g != -1L)
        {
          l1 = ((com.tencent.hlyyb.downloader.e.b.a)localObject1).g - ((com.tencent.hlyyb.downloader.e.b.a)localObject1).f;
          break label370;
          localObject1 = localObject5;
          if (localObject5 != null) {
            continue;
          }
          l1 = this.a;
          if (((com.tencent.hlyyb.downloader.e.b.a)localObject4).g == -1L) {
            break label338;
          }
          l1 = ((com.tencent.hlyyb.downloader.e.b.a)localObject4).g - ((com.tencent.hlyyb.downloader.e.b.a)localObject4).f;
          l2 = ((com.tencent.hlyyb.downloader.e.b.a)localObject4).f;
          if (l1 <= com.tencent.hlyyb.downloader.a.a.a() << 1) {
            break label351;
          }
          l1 = l2 + l1 / 2L;
          localObject1 = new com.tencent.hlyyb.downloader.e.b.a(this, l1, l1, l1, ((com.tencent.hlyyb.downloader.e.b.a)localObject4).g);
          ((com.tencent.hlyyb.downloader.e.b.a)localObject1).c = ((com.tencent.hlyyb.downloader.e.b.a)localObject4).b;
        }
      }
      l1 -= localObject2.f;
      break label370;
      label255:
      long l1 = this.a;
      if (localObject2.g != -1L) {}
      for (l1 = localObject2.g - localObject2.f;; l1 -= localObject2.f)
      {
        l2 = this.a;
        if (((com.tencent.hlyyb.downloader.e.b.a)localObject4).g == -1L) {
          break;
        }
        l2 = ((com.tencent.hlyyb.downloader.e.b.a)localObject4).g - ((com.tencent.hlyyb.downloader.e.b.a)localObject4).f;
        break label383;
      }
      l2 -= ((com.tencent.hlyyb.downloader.e.b.a)localObject4).f;
      break label383;
      label338:
      long l2 = ((com.tencent.hlyyb.downloader.e.b.a)localObject4).f;
      l1 -= l2;
      continue;
      label351:
      Object localObject3 = null;
      label364:
      label370:
      label383:
      while (l1 <= l2)
      {
        localObject3 = localObject4;
        break label389;
        localObject5 = null;
        break;
        if (l1 <= 0L) {
          break label255;
        }
        localObject5 = localObject3;
        break;
      }
      label389:
      Object localObject4 = localObject3;
    }
  }
  
  private com.tencent.hlyyb.downloader.e.b.a k()
  {
    for (;;)
    {
      synchronized (this.j)
      {
        Iterator localIterator = this.j.iterator();
        if (localIterator.hasNext())
        {
          com.tencent.hlyyb.downloader.e.b.a locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
          if ((locala.h) || (locala.f == locala.g)) {
            continue;
          }
          if (locala != null) {
            locala.h = true;
          }
          return locala;
        }
      }
      Object localObject2 = null;
    }
  }
  
  private long l()
  {
    Iterator localIterator1;
    long l1;
    com.tencent.hlyyb.downloader.e.b.a locala;
    synchronized (this.i)
    {
      localIterator1 = this.i.iterator();
      for (l1 = 0L; localIterator1.hasNext(); l1 = locala.e - locala.d + l1) {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator1.next();
      }
    }
    synchronized (this.j)
    {
      localIterator1 = this.j.iterator();
      long l2 = 0L;
      while (localIterator1.hasNext())
      {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator1.next();
        l3 = locala.g;
        long l4 = locala.d;
        l2 = l3 - l4 + l2;
        continue;
        localObject1 = finally;
        throw localObject1;
      }
      Iterator localIterator2 = this.j.iterator();
      for (long l3 = 0L; localIterator2.hasNext(); l3 = locala.e - locala.d + l3) {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator2.next();
      }
      l1 = l1 - l2 + l3;
      if (l1 > 0L) {
        return l1;
      }
    }
    return 0L;
  }
  
  private long m()
  {
    long l1 = 0L;
    Iterator localIterator;
    com.tencent.hlyyb.downloader.e.b.a locala;
    synchronized (this.i)
    {
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
        l1 += locala.e - locala.d;
      }
    }
    synchronized (this.j)
    {
      localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
        long l2 = locala.e;
        long l3 = locala.d;
        l1 = l2 - l3 + l1;
        continue;
        localObject1 = finally;
        throw localObject1;
      }
      return l1;
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
    //   11: invokeinterface 145 1 0
    //   16: astore 4
    //   18: aload 4
    //   20: invokeinterface 151 1 0
    //   25: ifeq +31 -> 56
    //   28: aload 4
    //   30: invokeinterface 155 1 0
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
    //   69: invokeinterface 145 1 0
    //   74: astore 4
    //   76: aload 4
    //   78: invokeinterface 151 1 0
    //   83: ifeq +47 -> 130
    //   86: aload 4
    //   88: invokeinterface 155 1 0
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
    //   114: astore 4
    //   116: aload_3
    //   117: monitorexit
    //   118: aload 4
    //   120: athrow
    //   121: astore 4
    //   123: aload_3
    //   124: monitorexit
    //   125: aload 4
    //   127: athrow
    //   128: astore 4
    //   130: aload_3
    //   131: monitorexit
    //   132: aconst_null
    //   133: areturn
    //   134: astore 4
    //   136: goto -80 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	h
    //   0	139	1	paramInt	int
    //   45	62	2	m	int
    //   16	71	4	localIterator	Iterator
    //   114	5	4	localObject1	Object
    //   121	5	4	localObject2	Object
    //   128	1	4	localException1	java.lang.Exception
    //   134	1	4	localException2	java.lang.Exception
    //   38	74	5	locala	com.tencent.hlyyb.downloader.e.b.a
    // Exception table:
    //   from	to	target	type
    //   65	76	114	finally
    //   76	104	114	finally
    //   109	111	114	finally
    //   116	118	114	finally
    //   130	132	114	finally
    //   7	18	121	finally
    //   18	46	121	finally
    //   51	53	121	finally
    //   56	58	121	finally
    //   123	125	121	finally
    //   65	76	128	java/lang/Exception
    //   76	104	128	java/lang/Exception
    //   7	18	134	java/lang/Exception
    //   18	46	134	java/lang/Exception
  }
  
  public final void a(long paramLong, int paramInt)
  {
    if (this.k == 0L) {}
    label68:
    for (;;)
    {
      this.k = paramLong;
      int m;
      if (this.l == 0) {
        m = paramInt;
      }
      for (;;)
      {
        this.l = m;
        return;
        if (this.k <= paramLong) {
          break label68;
        }
        paramLong = this.k;
        break;
        m = paramInt;
        if (this.l > paramInt) {
          m = this.l;
        }
      }
    }
  }
  
  public final void a(com.tencent.hlyyb.downloader.e.b.a parama)
  {
    if (parama.g == -1L) {}
    while (parama.d >= parama.g) {
      return;
    }
    List localList = this.j;
    int m = 0;
    for (;;)
    {
      try
      {
        if (m >= this.j.size()) {
          break label221;
        }
        locala = (com.tencent.hlyyb.downloader.e.b.a)this.j.get(m);
        if (locala.d == parama.d)
        {
          if (locala == null) {
            break label157;
          }
          if (parama.g <= locala.g) {
            break label151;
          }
          parama.b = locala.b;
          parama.c = locala.c;
          this.j.remove(m);
          this.j.add(m, parama);
          return;
        }
      }
      finally {}
      m += 1;
      continue;
      label151:
      parama = locala;
      continue;
      label157:
      m = 10000;
      int n = this.j.size();
      if (n > 0) {
        m = ((com.tencent.hlyyb.downloader.e.b.a)this.j.get(n - 1)).b + 1;
      }
      parama.c = m;
      parama.b = m;
      this.j.add(parama);
      return;
      label221:
      com.tencent.hlyyb.downloader.e.b.a locala = null;
      m = 0;
    }
  }
  
  public final void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("null")))
    {
      this.g = "";
      return;
    }
    this.g = paramString.replace("|", "");
  }
  
  public final int b()
  {
    synchronized (this.j)
    {
      Iterator localIterator = this.j.iterator();
      com.tencent.hlyyb.downloader.e.b.a locala;
      long l1;
      for (int m = 0; localIterator.hasNext(); m = (int)(locala.e - locala.d + l1))
      {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
        l1 = m;
      }
      return m;
    }
  }
  
  public final void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("null")))
    {
      this.h = "";
      return;
    }
    this.h = paramString.replace("|", "");
  }
  
  public final boolean b(com.tencent.hlyyb.downloader.e.b.a parama)
  {
    if (parama.b == -1) {
      label255:
      for (;;)
      {
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
            Object localObject = null;
            Iterator localIterator = this.i.iterator();
            if (localIterator.hasNext())
            {
              com.tencent.hlyyb.downloader.e.b.a locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator.next();
              if (locala.b == parama.c)
              {
                if (locala.f >= locala.g) {
                  return false;
                }
                localObject = locala;
                if (locala.f + com.tencent.hlyyb.downloader.a.a.a() <= parama.d) {
                  break label255;
                }
                return false;
              }
              if ((locala.g <= parama.d) || (locala.d >= parama.g)) {
                break label255;
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
        }
      }
    }
    return false;
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
    Iterator localIterator;
    synchronized (this.i)
    {
      localIterator = this.i.iterator();
      if (localIterator.hasNext())
      {
        localStringBuilder.append(((com.tencent.hlyyb.downloader.e.b.a)localIterator.next()).a());
        localStringBuilder.append(";");
      }
    }
    if (this.i.size() > 0) {
      localObject1.deleteCharAt(localObject1.length() - 1);
    }
    localObject1.append("|");
    localObject1.append("null");
    localObject1.append("|");
    if (TextUtils.isEmpty(this.g))
    {
      localObject1.append("null");
      localObject1.append("|");
      if (!TextUtils.isEmpty(this.h)) {
        break label303;
      }
      localObject1.append("null");
    }
    for (;;)
    {
      localObject1.append("|");
      synchronized (this.j)
      {
        localIterator = this.j.iterator();
        if (!localIterator.hasNext()) {
          break label315;
        }
        localObject1.append(((com.tencent.hlyyb.downloader.e.b.a)localIterator.next()).a());
        localObject1.append(";");
      }
      localObject2.append(this.g);
      break;
      label303:
      localObject2.append(this.h);
    }
    label315:
    if (this.j.size() > 0) {
      localObject2.deleteCharAt(localObject2.length() - 1);
    }
    localObject2.append("|");
    localObject2.append(this.k + ";" + this.l);
    return localObject2.toString();
  }
  
  public final long d()
  {
    return l();
  }
  
  public final boolean e()
  {
    return (this.a > 0L) && (this.a == l());
  }
  
  public final long f()
  {
    Iterator localIterator1;
    long l1;
    com.tencent.hlyyb.downloader.e.b.a locala;
    synchronized (this.i)
    {
      localIterator1 = this.i.iterator();
      for (l1 = 0L; localIterator1.hasNext(); l1 = locala.f - locala.d + l1) {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator1.next();
      }
    }
    synchronized (this.j)
    {
      localIterator1 = this.j.iterator();
      long l2 = 0L;
      while (localIterator1.hasNext())
      {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator1.next();
        l3 = locala.g;
        long l4 = locala.d;
        l2 = l3 - l4 + l2;
        continue;
        localObject1 = finally;
        throw localObject1;
      }
      Iterator localIterator2 = this.j.iterator();
      for (long l3 = 0L; localIterator2.hasNext(); l3 = locala.f - locala.d + l3) {
        locala = (com.tencent.hlyyb.downloader.e.b.a)localIterator2.next();
      }
      l1 = l1 - l2 + l3;
      if (l1 > 0L) {
        return l1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.h
 * JD-Core Version:    0.7.0.1
 */