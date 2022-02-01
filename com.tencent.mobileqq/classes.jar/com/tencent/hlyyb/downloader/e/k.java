package com.tencent.hlyyb.downloader.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;

final class k
  implements com.tencent.hlyyb.downloader.e.b.b
{
  com.tencent.hlyyb.downloader.e.b.c a;
  com.tencent.hlyyb.downloader.e.b.c b;
  
  private k(i parami) {}
  
  private void a(long paramLong, com.tencent.hlyyb.common.a.f paramf)
  {
    paramf.a = -10;
    StringBuilder localStringBuilder = new StringBuilder("knownSize:");
    localStringBuilder.append(this.c.f);
    localStringBuilder.append(",rspLength:");
    localStringBuilder.append(paramLong);
    paramf.b = localStringBuilder.toString();
  }
  
  private void a(com.tencent.hlyyb.downloader.e.b.c paramc, long paramLong, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, com.tencent.hlyyb.common.a.f paramf)
  {
    i locali = this.c;
    locali.g = paramLong;
    locali.k = paramBoolean;
    locali.l = paramString3;
    locali.m = paramString4;
    if (paramc.b != null) {
      this.c.z = paramc.b.c;
    }
    if (!this.c.k)
    {
      i.a(this.c, new h(""));
      paramc.a = i.h(this.c).a();
    }
    else if (i.h(this.c).a > 0L)
    {
      int i = 0;
      if (i.h(this.c).a != this.c.g) {
        i = 1;
      }
      if (i != 0)
      {
        i.a(this.c, new h(""));
        paramf.a = 3;
        paramf.b = "can not resume from cfg, start over now";
      }
    }
    i.h(this.c).a = paramLong;
    i.h(this.c).a(paramString1);
    i.h(this.c).b(paramString2);
    if ((paramc.a.c == -1) && (paramc.a.b == -1)) {
      i.h(this.c).b(paramc.a);
    }
  }
  
  private void a(com.tencent.hlyyb.downloader.e.d.a parama, long paramLong, com.tencent.hlyyb.common.a.f paramf)
  {
    if (parama.b == com.tencent.hlyyb.downloader.e.d.b.j) {
      paramf.a = -76;
    }
    for (parama = new StringBuilder("sche size:");; parama = new StringBuilder("sche size:"))
    {
      parama.append(i.a(this.c).a());
      parama.append(",rsp size:");
      parama.append(paramLong);
      paramf.b = parama.toString();
      return;
      paramf.a = -73;
    }
  }
  
  public final com.tencent.hlyyb.common.a.f a(com.tencent.hlyyb.downloader.e.b.c paramc, com.tencent.hlyyb.downloader.e.d.a parama, String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      if (this.c.C)
      {
        com.tencent.hlyyb.common.a.a.d();
        if (com.tencent.hlyyb.common.a.a.f())
        {
          this.c.pause();
          this.c.D = true;
        }
      }
      if (paramc == null) {
        break label676;
      }
      if (paramc == this.a) {
        break label670;
      }
      if (paramc != this.b) {
        break label676;
      }
    }
    finally
    {
      label670:
      label676:
      label685:
      label693:
      for (;;)
      {
        com.tencent.hlyyb.common.a.f localf;
        h localh;
        for (;;)
        {
          throw paramc;
        }
        int i = 1;
        continue;
        i = 0;
        continue;
        i = 0;
        if (i == 0) {}
      }
    }
    if ((i != 0) && (!paramc.a()) && (paramLong > 0L))
    {
      localf = new com.tencent.hlyyb.common.a.f(0, "");
      if (i.h(this.c) != null)
      {
        localh = i.h(this.c);
        if (paramc.a.i == localh)
        {
          i = 1;
          break label685;
          if (this.c.g == -1L)
          {
            if ((this.c.B ^ true))
            {
              if ((this.c.f > 0L) && (paramLong != this.c.f)) {
                a(paramLong, localf);
              } else {
                a(paramc, paramLong, paramBoolean, paramString2, paramString3, paramString4, paramString5, localf);
              }
            }
            else if (i.i(this.c) != -1L)
            {
              if (paramLong != i.i(this.c))
              {
                if (i.a(this.c).a() > 0L)
                {
                  a(parama, paramLong, localf);
                  break label693;
                }
                a(paramLong, localf);
                break label693;
              }
              a(paramc, i.i(this.c), paramBoolean, paramString2, paramString3, paramString4, paramString5, localf);
            }
            else
            {
              a(paramc, paramLong, paramBoolean, paramString2, paramString3, paramString4, paramString5, localf);
            }
            if (localf.a == 0)
            {
              if ((!i.j(this.c)) && (!i.b(this.c, paramLong))) {
                this.c.a(false, this.c.r, this.c.s, DownloaderTaskStatus.FAILED);
              }
              i.k(this.c).a(f.c);
            }
          }
          else
          {
            paramString2 = localf;
            if (paramLong != this.c.g)
            {
              if (i.a(this.c).a() > 0L)
              {
                a(parama, paramLong, paramString2);
              }
              else if (this.c.f > 0L)
              {
                a(paramLong, paramString2);
              }
              else
              {
                paramString2.a = -43;
                paramc = new StringBuilder("detectLength:");
                paramc.append(this.c.g);
                paramc.append(",rspLength:");
                paramc.append(paramLong);
              }
            }
            else {
              for (paramc = paramc.toString();; paramc = "not support range")
              {
                paramString2.b = paramc;
                break;
                if (this.c.k) {
                  break;
                }
                paramString2.a = 1;
              }
            }
          }
          if ((localf.a == 0) && (!TextUtils.isEmpty(paramString1))) {
            if ((parama.b != com.tencent.hlyyb.downloader.e.d.b.b) && (parama.b != com.tencent.hlyyb.downloader.e.d.b.a))
            {
              if (parama.b == com.tencent.hlyyb.downloader.e.d.b.g) {
                i.a(this.c).b(com.tencent.hlyyb.common.a.a.b(), paramString1);
              }
            }
            else {
              i.a(this.c).a(com.tencent.hlyyb.common.a.a.b(), paramString1);
            }
          }
          return localf;
        }
      }
      else
      {
        localf.a = 2;
        localf.b = "not the same divider";
        return localf;
      }
    }
    else
    {
      paramc = new com.tencent.hlyyb.common.a.f(4, "");
      return paramc;
    }
  }
  
  public final com.tencent.hlyyb.downloader.e.b.a a(com.tencent.hlyyb.downloader.e.b.c paramc)
  {
    int i;
    if ((paramc != null) && ((paramc == this.a) || (paramc == this.b))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return null;
    }
    if (!this.c.k) {
      return null;
    }
    return i.h(this.c).a();
  }
  
  public final boolean a()
  {
    return this.c.g != -1L;
  }
  
  /* Error */
  public final boolean a(com.tencent.hlyyb.downloader.e.b.c arg1, long paramLong, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_1
    //   4: ifnull +25 -> 29
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 156	com/tencent/hlyyb/downloader/e/k:a	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   12: if_acmpeq +11 -> 23
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 158	com/tencent/hlyyb/downloader/e/k:b	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   20: if_acmpne +9 -> 29
    //   23: iconst_1
    //   24: istore 7
    //   26: goto +6 -> 32
    //   29: iconst_0
    //   30: istore 7
    //   32: iload 7
    //   34: ifne +5 -> 39
    //   37: iconst_0
    //   38: ireturn
    //   39: iload 5
    //   41: ifle +38 -> 79
    //   44: aload_0
    //   45: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   48: getfield 248	com/tencent/hlyyb/downloader/e/i:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   51: astore 11
    //   53: iload 5
    //   55: i2l
    //   56: lstore 9
    //   58: aload 11
    //   60: lload 9
    //   62: invokevirtual 254	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   65: pop2
    //   66: aload_0
    //   67: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   70: getfield 257	com/tencent/hlyyb/downloader/e/i:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   73: lload 9
    //   75: invokevirtual 254	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   78: pop2
    //   79: aload_0
    //   80: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   83: invokestatic 95	com/tencent/hlyyb/downloader/e/i:h	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/h;
    //   86: ifnull +352 -> 438
    //   89: aload_0
    //   90: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   93: invokestatic 95	com/tencent/hlyyb/downloader/e/i:h	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/h;
    //   96: astore 11
    //   98: aload_1
    //   99: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   102: getfield 167	com/tencent/hlyyb/downloader/e/b/a:i	Lcom/tencent/hlyyb/downloader/e/h;
    //   105: aload 11
    //   107: if_acmpne +9 -> 116
    //   110: iconst_1
    //   111: istore 7
    //   113: goto +6 -> 119
    //   116: iconst_0
    //   117: istore 7
    //   119: iload 7
    //   121: ifne +5 -> 126
    //   124: iconst_0
    //   125: ireturn
    //   126: iload 6
    //   128: ifeq +33 -> 161
    //   131: aload_1
    //   132: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   135: getfield 114	com/tencent/hlyyb/downloader/e/b/a:b	I
    //   138: iconst_m1
    //   139: if_icmpne +22 -> 161
    //   142: aload_0
    //   143: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   146: invokestatic 95	com/tencent/hlyyb/downloader/e/i:h	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/h;
    //   149: aload_1
    //   150: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   153: invokevirtual 117	com/tencent/hlyyb/downloader/e/h:b	(Lcom/tencent/hlyyb/downloader/e/b/a;)Z
    //   156: ifne +5 -> 161
    //   159: iconst_0
    //   160: ireturn
    //   161: iload 5
    //   163: ifle +273 -> 436
    //   166: aload_0
    //   167: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   170: invokevirtual 260	com/tencent/hlyyb/downloader/e/i:isPaused	()Z
    //   173: ifne +263 -> 436
    //   176: aload_0
    //   177: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   180: invokestatic 263	com/tencent/hlyyb/downloader/e/i:l	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/a/a;
    //   183: astore 11
    //   185: aload_1
    //   186: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   189: getfield 114	com/tencent/hlyyb/downloader/e/b/a:b	I
    //   192: istore 7
    //   194: iload 5
    //   196: i2l
    //   197: lstore 9
    //   199: aload 11
    //   201: iload 7
    //   203: lload_2
    //   204: aload 4
    //   206: lload 9
    //   208: invokevirtual 268	com/tencent/hlyyb/downloader/e/a/a:a	(IJ[BJ)V
    //   211: aload_1
    //   212: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   215: astore_1
    //   216: aload_1
    //   217: aload_1
    //   218: getfield 269	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   221: lload 9
    //   223: ladd
    //   224: putfield 269	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   227: aload_0
    //   228: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   231: invokestatic 95	com/tencent/hlyyb/downloader/e/i:h	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/h;
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 271	com/tencent/hlyyb/downloader/e/h:f	()J
    //   239: lstore_2
    //   240: lload_2
    //   241: lconst_0
    //   242: lcmp
    //   243: ifle +18 -> 261
    //   246: lload_2
    //   247: aload_1
    //   248: getfield 103	com/tencent/hlyyb/downloader/e/h:a	J
    //   251: lcmp
    //   252: ifne +9 -> 261
    //   255: iconst_1
    //   256: istore 5
    //   258: goto +6 -> 264
    //   261: iconst_0
    //   262: istore 5
    //   264: iload 5
    //   266: ifeq +19 -> 285
    //   269: aload_0
    //   270: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   273: invokestatic 274	com/tencent/hlyyb/downloader/e/i:m	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/a;
    //   276: invokevirtual 278	com/tencent/hlyyb/downloader/e/a:b	()V
    //   279: invokestatic 283	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   282: invokevirtual 284	com/tencent/hlyyb/downloader/c/b:b	()V
    //   285: iload 8
    //   287: istore 5
    //   289: invokestatic 283	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   292: invokevirtual 285	com/tencent/hlyyb/downloader/c/b:f	()J
    //   295: ldc2_w 286
    //   298: lcmp
    //   299: ifle +6 -> 305
    //   302: iconst_1
    //   303: istore 5
    //   305: iload 5
    //   307: ifeq +129 -> 436
    //   310: aload_0
    //   311: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   314: iconst_1
    //   315: invokestatic 290	com/tencent/hlyyb/downloader/e/i:a	(Lcom/tencent/hlyyb/downloader/e/i;Z)Z
    //   318: pop
    //   319: invokestatic 283	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   322: invokevirtual 284	com/tencent/hlyyb/downloader/c/b:b	()V
    //   325: aload_0
    //   326: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   329: iconst_1
    //   330: invokestatic 292	com/tencent/hlyyb/downloader/e/i:b	(Lcom/tencent/hlyyb/downloader/e/i;Z)Z
    //   333: pop
    //   334: aload_0
    //   335: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   338: invokestatic 296	com/tencent/hlyyb/downloader/e/i:n	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/lang/Object;
    //   341: astore_1
    //   342: aload_1
    //   343: monitorenter
    //   344: aload_0
    //   345: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   348: invokestatic 296	com/tencent/hlyyb/downloader/e/i:n	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/lang/Object;
    //   351: ldc2_w 297
    //   354: invokevirtual 302	java/lang/Object:wait	(J)V
    //   357: aload_1
    //   358: monitorexit
    //   359: iconst_1
    //   360: ireturn
    //   361: astore 4
    //   363: aload_1
    //   364: monitorexit
    //   365: aload 4
    //   367: athrow
    //   368: astore_1
    //   369: aload_1
    //   370: invokevirtual 305	java/lang/OutOfMemoryError:printStackTrace	()V
    //   373: aload_0
    //   374: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   377: astore_1
    //   378: new 30	java/lang/StringBuilder
    //   381: dup
    //   382: ldc_w 307
    //   385: invokespecial 35	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: astore 4
    //   390: aload 4
    //   392: iload 5
    //   394: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 4
    //   400: ldc_w 312
    //   403: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 4
    //   409: invokestatic 283	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   412: invokevirtual 285	com/tencent/hlyyb/downloader/c/b:f	()J
    //   415: invokevirtual 45	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_1
    //   420: iconst_0
    //   421: bipush 237
    //   423: aload 4
    //   425: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: getstatic 199	com/tencent/hlyyb/downloader/DownloaderTaskStatus:FAILED	Lcom/tencent/hlyyb/downloader/DownloaderTaskStatus;
    //   431: invokevirtual 202	com/tencent/hlyyb/downloader/e/i:a	(ZILjava/lang/String;Lcom/tencent/hlyyb/downloader/DownloaderTaskStatus;)V
    //   434: iconst_0
    //   435: ireturn
    //   436: iconst_1
    //   437: ireturn
    //   438: iconst_0
    //   439: ireturn
    //   440: astore_1
    //   441: iconst_1
    //   442: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	k
    //   0	443	2	paramLong	long
    //   0	443	4	paramArrayOfByte	byte[]
    //   0	443	5	paramInt	int
    //   0	443	6	paramBoolean	boolean
    //   24	178	7	i	int
    //   1	285	8	j	int
    //   56	166	9	l	long
    //   51	149	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   344	359	361	finally
    //   363	365	361	finally
    //   176	194	368	java/lang/OutOfMemoryError
    //   199	211	368	java/lang/OutOfMemoryError
    //   325	344	440	java/lang/Exception
    //   365	368	440	java/lang/Exception
  }
  
  public final com.tencent.hlyyb.common.a.f b()
  {
    com.tencent.hlyyb.common.a.f localf;
    label267:
    try
    {
      i.a(this.c, SystemClock.elapsedRealtime());
      localf = new com.tencent.hlyyb.common.a.f(0, "");
      this.a = new com.tencent.hlyyb.downloader.e.b.c(i.a(this.c), true, this.c, this, this.c.e, this.c.B);
      try
      {
        this.a.a(i.b(this.c), i.c(this.c), i.d(this.c), this.c, i.e(this.c), i.f(this.c), i.g(this.c));
        com.tencent.hlyyb.downloader.f.a.a().a(this.a);
      }
      catch (Exception localException1)
      {
        this.a = null;
        localf.a = -67;
        localException1.printStackTrace();
      }
      if ((localf.a == 0) && (!this.c.isEaseTask())) {
        this.b = new com.tencent.hlyyb.downloader.e.b.c(i.a(this.c), false, this.c, this, this.c.e, this.c.B);
      }
    }
    finally {}
    try
    {
      this.b.a(i.b(this.c), i.c(this.c), i.d(this.c), this.c, i.e(this.c), i.f(this.c), i.g(this.c));
      com.tencent.hlyyb.downloader.f.a.a().b(this.b);
    }
    catch (Exception localException2)
    {
      break label267;
    }
    this.b = null;
    return localf;
  }
  
  public final void b(com.tencent.hlyyb.downloader.e.b.c paramc)
  {
    int i;
    if ((paramc != null) && ((paramc == this.a) || (paramc == this.b))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    if (paramc.a == null) {
      return;
    }
    paramc.a.h = false;
  }
  
  public final void c(com.tencent.hlyyb.downloader.e.b.c paramc)
  {
    int j = 1;
    int i;
    if ((paramc != null) && ((paramc == this.a) || (paramc == this.b))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    label265:
    label270:
    synchronized (i.o(this.c))
    {
      if ((this.a == null) || (this.a.g()))
      {
        if ((!this.c.B) || (this.b == null) || (this.b.g())) {
          break label270;
        }
        break label265;
        if ((i != 0) && (!i.p(this.c)))
        {
          ??? = i.h(this.c);
          long l = ((h)???).f();
          if ((l > 0L) && (l == ((h)???).a)) {
            i = j;
          } else {
            i = 0;
          }
          if (i != 0) {
            return;
          }
          this.c.r = paramc.c();
          this.c.s = paramc.d();
          if (this.c.r == 0)
          {
            paramc = this.c;
            paramc.r = -69;
            ??? = new StringBuilder("readLen:");
            ((StringBuilder)???).append(i.h(this.c).f());
            paramc.s = ((StringBuilder)???).toString();
          }
          i.k(this.c).a(DownloaderTaskStatus.FAILED);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.k
 * JD-Core Version:    0.7.0.1
 */