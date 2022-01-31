package com.tencent.hlyyb.downloader.e;

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
    paramf.b = ("knownSize:" + this.c.f + ",rspLength:" + paramLong);
  }
  
  private void a(com.tencent.hlyyb.downloader.e.b.c paramc, long paramLong, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, com.tencent.hlyyb.common.a.f paramf)
  {
    this.c.g = paramLong;
    this.c.k = paramBoolean;
    this.c.l = paramString3;
    this.c.m = paramString4;
    if (paramc.b != null) {
      this.c.z = paramc.b.c;
    }
    if (!this.c.k)
    {
      i.a(this.c, new h(""));
      paramc.a = i.h(this.c).a();
    }
    for (;;)
    {
      i.h(this.c).a = paramLong;
      i.h(this.c).a(paramString1);
      i.h(this.c).b(paramString2);
      if ((paramc.a.c == -1) && (paramc.a.b == -1)) {
        i.h(this.c).b(paramc.a);
      }
      return;
      if (i.h(this.c).a > 0L)
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
    }
  }
  
  private void a(com.tencent.hlyyb.downloader.e.d.a parama, long paramLong, com.tencent.hlyyb.common.a.f paramf)
  {
    if (parama.b == com.tencent.hlyyb.downloader.e.d.b.j)
    {
      paramf.a = -76;
      paramf.b = ("sche size:" + i.a(this.c).a() + ",rsp size:" + paramLong);
      return;
    }
    paramf.a = -73;
    paramf.b = ("sche size:" + i.a(this.c).a() + ",rsp size:" + paramLong);
  }
  
  public final com.tencent.hlyyb.common.a.f a(com.tencent.hlyyb.downloader.e.b.c paramc, com.tencent.hlyyb.downloader.e.d.a parama, String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    label89:
    label99:
    com.tencent.hlyyb.common.a.f localf;
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
      if (paramc != null)
      {
        if (paramc == this.a) {
          break label677;
        }
        if (paramc == this.b)
        {
          break label677;
          if ((i != 0) && (!paramc.a()) && (paramLong > 0L)) {
            break label99;
          }
        }
      }
      for (paramc = new com.tencent.hlyyb.common.a.f(4, "");; paramc = localf)
      {
        return paramc;
        i = 0;
        break;
        localf = new com.tencent.hlyyb.common.a.f(0, "");
        if (i.h(this.c) != null)
        {
          h localh = i.h(this.c);
          if (paramc.a.i != localh) {
            break label172;
          }
          i = 1;
          break label683;
        }
        label148:
        localf.a = 2;
        localf.b = "not the same divider";
      }
      i = 0;
    }
    finally {}
    label172:
    break label683;
    label178:
    if (this.c.g == -1L) {
      if (this.c.B) {
        break label691;
      }
    }
    label644:
    label677:
    label683:
    label691:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if ((this.c.f > 0L) && (paramLong != this.c.f))
        {
          a(paramLong, localf);
          label243:
          if (localf.a == 0)
          {
            if ((!i.j(this.c)) && (!i.b(this.c, paramLong))) {
              this.c.a(false, this.c.r, this.c.s, DownloaderTaskStatus.FAILED);
            }
            i.k(this.c).a(f.c);
          }
        }
      }
      for (;;)
      {
        paramc = localf;
        if (localf.a != 0) {
          break;
        }
        paramc = localf;
        if (TextUtils.isEmpty(paramString1)) {
          break;
        }
        if ((parama.b != com.tencent.hlyyb.downloader.e.d.b.b) && (parama.b != com.tencent.hlyyb.downloader.e.d.b.a)) {
          break label644;
        }
        i.a(this.c).a(com.tencent.hlyyb.common.a.a.b(), paramString1);
        paramc = localf;
        break;
        a(paramc, paramLong, paramBoolean, paramString2, paramString3, paramString4, paramString5, localf);
        break label243;
        if (i.i(this.c) != -1L)
        {
          if (paramLong != i.i(this.c))
          {
            if (i.a(this.c).a() > 0L)
            {
              a(parama, paramLong, localf);
              break label243;
            }
            a(paramLong, localf);
            break label243;
          }
          a(paramc, i.i(this.c), paramBoolean, paramString2, paramString3, paramString4, paramString5, localf);
          break label243;
        }
        a(paramc, paramLong, paramBoolean, paramString2, paramString3, paramString4, paramString5, localf);
        break label243;
        if (paramLong != this.c.g)
        {
          if (i.a(this.c).a() > 0L)
          {
            a(parama, paramLong, localf);
          }
          else if (this.c.f > 0L)
          {
            a(paramLong, localf);
          }
          else
          {
            localf.a = -43;
            localf.b = ("detectLength:" + this.c.g + ",rspLength:" + paramLong);
          }
        }
        else if (!this.c.k)
        {
          localf.a = 1;
          localf.b = "not support range";
        }
      }
      paramc = localf;
      if (parama.b != com.tencent.hlyyb.downloader.e.d.b.g) {
        break label89;
      }
      i.a(this.c).b(com.tencent.hlyyb.common.a.a.b(), paramString1);
      paramc = localf;
      break label89;
      i = 1;
      break;
      if (i != 0) {
        break label178;
      }
      break label148;
    }
  }
  
  public final com.tencent.hlyyb.downloader.e.b.a a(com.tencent.hlyyb.downloader.e.b.c paramc)
  {
    int i;
    if ((paramc != null) && ((paramc == this.a) || (paramc == this.b)))
    {
      i = 1;
      if (i != 0) {
        break label33;
      }
    }
    label33:
    while (!this.c.k)
    {
      return null;
      i = 0;
      break;
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
    //   4: ifnull +29 -> 33
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 156	com/tencent/hlyyb/downloader/e/k:a	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   12: if_acmpeq +11 -> 23
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 158	com/tencent/hlyyb/downloader/e/k:b	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   20: if_acmpne +13 -> 33
    //   23: iconst_1
    //   24: istore 7
    //   26: iload 7
    //   28: ifne +11 -> 39
    //   31: iconst_0
    //   32: ireturn
    //   33: iconst_0
    //   34: istore 7
    //   36: goto -10 -> 26
    //   39: iload 5
    //   41: ifle +31 -> 72
    //   44: aload_0
    //   45: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   48: getfield 248	com/tencent/hlyyb/downloader/e/i:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   51: iload 5
    //   53: i2l
    //   54: invokevirtual 254	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   57: pop2
    //   58: aload_0
    //   59: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   62: getfield 257	com/tencent/hlyyb/downloader/e/i:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   65: iload 5
    //   67: i2l
    //   68: invokevirtual 254	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   71: pop2
    //   72: aload_0
    //   73: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   76: invokestatic 95	com/tencent/hlyyb/downloader/e/i:h	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/h;
    //   79: ifnull +32 -> 111
    //   82: aload_0
    //   83: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   86: invokestatic 95	com/tencent/hlyyb/downloader/e/i:h	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/h;
    //   89: astore 9
    //   91: aload_1
    //   92: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   95: getfield 167	com/tencent/hlyyb/downloader/e/b/a:i	Lcom/tencent/hlyyb/downloader/e/h;
    //   98: aload 9
    //   100: if_acmpne +13 -> 113
    //   103: iconst_1
    //   104: istore 7
    //   106: iload 7
    //   108: ifne +11 -> 119
    //   111: iconst_0
    //   112: ireturn
    //   113: iconst_0
    //   114: istore 7
    //   116: goto -10 -> 106
    //   119: iload 6
    //   121: ifeq +33 -> 154
    //   124: aload_1
    //   125: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   128: getfield 112	com/tencent/hlyyb/downloader/e/b/a:b	I
    //   131: iconst_m1
    //   132: if_icmpne +22 -> 154
    //   135: aload_0
    //   136: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   139: invokestatic 95	com/tencent/hlyyb/downloader/e/i:h	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/h;
    //   142: aload_1
    //   143: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   146: invokevirtual 115	com/tencent/hlyyb/downloader/e/h:b	(Lcom/tencent/hlyyb/downloader/e/b/a;)Z
    //   149: ifne +5 -> 154
    //   152: iconst_0
    //   153: ireturn
    //   154: iload 5
    //   156: ifle +179 -> 335
    //   159: aload_0
    //   160: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   163: invokevirtual 260	com/tencent/hlyyb/downloader/e/i:isPaused	()Z
    //   166: ifne +169 -> 335
    //   169: aload_0
    //   170: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   173: invokestatic 263	com/tencent/hlyyb/downloader/e/i:l	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/a/a;
    //   176: aload_1
    //   177: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   180: getfield 112	com/tencent/hlyyb/downloader/e/b/a:b	I
    //   183: lload_2
    //   184: aload 4
    //   186: iload 5
    //   188: i2l
    //   189: invokevirtual 268	com/tencent/hlyyb/downloader/e/a/a:a	(IJ[BJ)V
    //   192: aload_1
    //   193: getfield 101	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   196: astore_1
    //   197: aload_1
    //   198: aload_1
    //   199: getfield 269	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   202: iload 5
    //   204: i2l
    //   205: ladd
    //   206: putfield 269	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   209: aload_0
    //   210: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   213: invokestatic 95	com/tencent/hlyyb/downloader/e/i:h	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/h;
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 271	com/tencent/hlyyb/downloader/e/h:f	()J
    //   221: lstore_2
    //   222: lload_2
    //   223: lconst_0
    //   224: lcmp
    //   225: ifle +165 -> 390
    //   228: lload_2
    //   229: aload_1
    //   230: getfield 103	com/tencent/hlyyb/downloader/e/h:a	J
    //   233: lcmp
    //   234: ifne +156 -> 390
    //   237: iconst_1
    //   238: istore 5
    //   240: iload 5
    //   242: ifeq +19 -> 261
    //   245: aload_0
    //   246: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   249: invokestatic 274	com/tencent/hlyyb/downloader/e/i:m	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/a;
    //   252: invokevirtual 278	com/tencent/hlyyb/downloader/e/a:b	()V
    //   255: invokestatic 283	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   258: invokevirtual 284	com/tencent/hlyyb/downloader/c/b:b	()V
    //   261: iload 8
    //   263: istore 5
    //   265: invokestatic 283	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   268: invokevirtual 285	com/tencent/hlyyb/downloader/c/b:f	()J
    //   271: ldc2_w 286
    //   274: lcmp
    //   275: ifle +6 -> 281
    //   278: iconst_1
    //   279: istore 5
    //   281: iload 5
    //   283: ifeq +52 -> 335
    //   286: aload_0
    //   287: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   290: iconst_1
    //   291: invokestatic 290	com/tencent/hlyyb/downloader/e/i:a	(Lcom/tencent/hlyyb/downloader/e/i;Z)Z
    //   294: pop
    //   295: invokestatic 283	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   298: invokevirtual 284	com/tencent/hlyyb/downloader/c/b:b	()V
    //   301: aload_0
    //   302: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   305: iconst_1
    //   306: invokestatic 292	com/tencent/hlyyb/downloader/e/i:b	(Lcom/tencent/hlyyb/downloader/e/i;Z)Z
    //   309: pop
    //   310: aload_0
    //   311: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   314: invokestatic 296	com/tencent/hlyyb/downloader/e/i:n	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/lang/Object;
    //   317: astore_1
    //   318: aload_1
    //   319: monitorenter
    //   320: aload_0
    //   321: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   324: invokestatic 296	com/tencent/hlyyb/downloader/e/i:n	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/lang/Object;
    //   327: ldc2_w 297
    //   330: invokevirtual 302	java/lang/Object:wait	(J)V
    //   333: aload_1
    //   334: monitorexit
    //   335: iconst_1
    //   336: ireturn
    //   337: astore_1
    //   338: aload_1
    //   339: invokevirtual 305	java/lang/OutOfMemoryError:printStackTrace	()V
    //   342: aload_0
    //   343: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   346: iconst_0
    //   347: bipush 237
    //   349: new 30	java/lang/StringBuilder
    //   352: dup
    //   353: ldc_w 307
    //   356: invokespecial 35	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   359: iload 5
    //   361: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: ldc_w 312
    //   367: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokestatic 283	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   373: invokevirtual 285	com/tencent/hlyyb/downloader/c/b:f	()J
    //   376: invokevirtual 45	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   379: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: getstatic 194	com/tencent/hlyyb/downloader/DownloaderTaskStatus:FAILED	Lcom/tencent/hlyyb/downloader/DownloaderTaskStatus;
    //   385: invokevirtual 197	com/tencent/hlyyb/downloader/e/i:a	(ZILjava/lang/String;Lcom/tencent/hlyyb/downloader/DownloaderTaskStatus;)V
    //   388: iconst_0
    //   389: ireturn
    //   390: iconst_0
    //   391: istore 5
    //   393: goto -153 -> 240
    //   396: astore 4
    //   398: aload_1
    //   399: monitorexit
    //   400: aload 4
    //   402: athrow
    //   403: astore_1
    //   404: goto -69 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	k
    //   0	407	2	paramLong	long
    //   0	407	4	paramArrayOfByte	byte[]
    //   0	407	5	paramInt	int
    //   0	407	6	paramBoolean	boolean
    //   24	91	7	i	int
    //   1	261	8	j	int
    //   89	10	9	localh	h
    // Exception table:
    //   from	to	target	type
    //   169	192	337	java/lang/OutOfMemoryError
    //   320	335	396	finally
    //   398	400	396	finally
    //   301	320	403	java/lang/Exception
    //   400	403	403	java/lang/Exception
  }
  
  /* Error */
  public final com.tencent.hlyyb.common.a.f b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   6: invokestatic 318	android/os/SystemClock:elapsedRealtime	()J
    //   9: invokestatic 321	com/tencent/hlyyb/downloader/e/i:a	(Lcom/tencent/hlyyb/downloader/e/i;J)J
    //   12: pop2
    //   13: new 25	com/tencent/hlyyb/common/a/f
    //   16: dup
    //   17: iconst_0
    //   18: ldc 87
    //   20: invokespecial 163	com/tencent/hlyyb/common/a/f:<init>	(ILjava/lang/String;)V
    //   23: astore_1
    //   24: aload_0
    //   25: new 73	com/tencent/hlyyb/downloader/e/b/c
    //   28: dup
    //   29: aload_0
    //   30: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   33: invokestatic 129	com/tencent/hlyyb/downloader/e/i:a	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/d/c;
    //   36: iconst_1
    //   37: aload_0
    //   38: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   46: getfield 325	com/tencent/hlyyb/downloader/e/i:e	Ljava/util/Map;
    //   49: aload_0
    //   50: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   53: getfield 174	com/tencent/hlyyb/downloader/e/i:B	Z
    //   56: invokespecial 328	com/tencent/hlyyb/downloader/e/b/c:<init>	(Lcom/tencent/hlyyb/downloader/e/d/c;ZLcom/tencent/hlyyb/downloader/a/b;Lcom/tencent/hlyyb/downloader/e/b/b;Ljava/util/Map;Z)V
    //   59: putfield 156	com/tencent/hlyyb/downloader/e/k:a	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   62: aload_0
    //   63: getfield 156	com/tencent/hlyyb/downloader/e/k:a	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   66: aload_0
    //   67: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   70: invokestatic 331	com/tencent/hlyyb/downloader/e/i:b	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/List;
    //   73: aload_0
    //   74: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   77: invokestatic 334	com/tencent/hlyyb/downloader/e/i:c	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/Map;
    //   80: aload_0
    //   81: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   84: invokestatic 336	com/tencent/hlyyb/downloader/e/i:d	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/Map;
    //   87: aload_0
    //   88: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   91: aload_0
    //   92: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   95: invokestatic 339	com/tencent/hlyyb/downloader/e/i:e	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   98: aload_0
    //   99: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   102: invokestatic 341	com/tencent/hlyyb/downloader/e/i:f	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   105: aload_0
    //   106: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   109: invokestatic 343	com/tencent/hlyyb/downloader/e/i:g	(Lcom/tencent/hlyyb/downloader/e/i;)J
    //   112: invokevirtual 346	com/tencent/hlyyb/downloader/e/b/c:a	(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/hlyyb/downloader/b/a;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;J)V
    //   115: invokestatic 351	com/tencent/hlyyb/downloader/f/a:a	()Lcom/tencent/hlyyb/downloader/f/a;
    //   118: aload_0
    //   119: getfield 156	com/tencent/hlyyb/downloader/e/k:a	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   122: invokevirtual 354	com/tencent/hlyyb/downloader/f/a:a	(Ljava/lang/Runnable;)Lcom/tencent/hlyyb/common/a/e;
    //   125: pop
    //   126: aload_1
    //   127: getfield 28	com/tencent/hlyyb/common/a/f:a	I
    //   130: ifne +115 -> 245
    //   133: aload_0
    //   134: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   137: invokevirtual 357	com/tencent/hlyyb/downloader/e/i:isEaseTask	()Z
    //   140: ifne +105 -> 245
    //   143: aload_0
    //   144: new 73	com/tencent/hlyyb/downloader/e/b/c
    //   147: dup
    //   148: aload_0
    //   149: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   152: invokestatic 129	com/tencent/hlyyb/downloader/e/i:a	(Lcom/tencent/hlyyb/downloader/e/i;)Lcom/tencent/hlyyb/downloader/e/d/c;
    //   155: iconst_0
    //   156: aload_0
    //   157: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   165: getfield 325	com/tencent/hlyyb/downloader/e/i:e	Ljava/util/Map;
    //   168: aload_0
    //   169: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   172: getfield 174	com/tencent/hlyyb/downloader/e/i:B	Z
    //   175: invokespecial 328	com/tencent/hlyyb/downloader/e/b/c:<init>	(Lcom/tencent/hlyyb/downloader/e/d/c;ZLcom/tencent/hlyyb/downloader/a/b;Lcom/tencent/hlyyb/downloader/e/b/b;Ljava/util/Map;Z)V
    //   178: putfield 158	com/tencent/hlyyb/downloader/e/k:b	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   181: aload_0
    //   182: getfield 158	com/tencent/hlyyb/downloader/e/k:b	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   185: aload_0
    //   186: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   189: invokestatic 331	com/tencent/hlyyb/downloader/e/i:b	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/List;
    //   192: aload_0
    //   193: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   196: invokestatic 334	com/tencent/hlyyb/downloader/e/i:c	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/Map;
    //   199: aload_0
    //   200: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   203: invokestatic 336	com/tencent/hlyyb/downloader/e/i:d	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/Map;
    //   206: aload_0
    //   207: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   210: aload_0
    //   211: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   214: invokestatic 339	com/tencent/hlyyb/downloader/e/i:e	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   217: aload_0
    //   218: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   221: invokestatic 341	com/tencent/hlyyb/downloader/e/i:f	(Lcom/tencent/hlyyb/downloader/e/i;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   224: aload_0
    //   225: getfield 15	com/tencent/hlyyb/downloader/e/k:c	Lcom/tencent/hlyyb/downloader/e/i;
    //   228: invokestatic 343	com/tencent/hlyyb/downloader/e/i:g	(Lcom/tencent/hlyyb/downloader/e/i;)J
    //   231: invokevirtual 346	com/tencent/hlyyb/downloader/e/b/c:a	(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/hlyyb/downloader/b/a;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;J)V
    //   234: invokestatic 351	com/tencent/hlyyb/downloader/f/a:a	()Lcom/tencent/hlyyb/downloader/f/a;
    //   237: aload_0
    //   238: getfield 158	com/tencent/hlyyb/downloader/e/k:b	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   241: invokevirtual 359	com/tencent/hlyyb/downloader/f/a:b	(Ljava/lang/Runnable;)Lcom/tencent/hlyyb/common/a/e;
    //   244: pop
    //   245: aload_0
    //   246: monitorexit
    //   247: aload_1
    //   248: areturn
    //   249: astore_2
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 156	com/tencent/hlyyb/downloader/e/k:a	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   255: aload_1
    //   256: bipush 189
    //   258: putfield 28	com/tencent/hlyyb/common/a/f:a	I
    //   261: aload_2
    //   262: invokevirtual 360	java/lang/Exception:printStackTrace	()V
    //   265: goto -139 -> 126
    //   268: astore_1
    //   269: aload_0
    //   270: monitorexit
    //   271: aload_1
    //   272: athrow
    //   273: astore_2
    //   274: aload_0
    //   275: aconst_null
    //   276: putfield 158	com/tencent/hlyyb/downloader/e/k:b	Lcom/tencent/hlyyb/downloader/e/b/c;
    //   279: goto -34 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	k
    //   23	233	1	localf	com.tencent.hlyyb.common.a.f
    //   268	4	1	localObject	Object
    //   249	13	2	localException1	java.lang.Exception
    //   273	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   62	126	249	java/lang/Exception
    //   2	62	268	finally
    //   62	126	268	finally
    //   126	181	268	finally
    //   181	245	268	finally
    //   250	265	268	finally
    //   274	279	268	finally
    //   181	245	273	java/lang/Exception
  }
  
  public final void b(com.tencent.hlyyb.downloader.e.b.c paramc)
  {
    int i;
    if ((paramc != null) && ((paramc == this.a) || (paramc == this.b)))
    {
      i = 1;
      if (i != 0) {
        break label32;
      }
    }
    label32:
    while (paramc.a == null)
    {
      return;
      i = 0;
      break;
    }
    paramc.a.h = false;
  }
  
  public final void c(com.tencent.hlyyb.downloader.e.b.c paramc)
  {
    int j = 1;
    if ((paramc != null) && ((paramc == this.a) || (paramc == this.b))) {}
    for (int i = 1; i == 0; i = 0) {
      return;
    }
    for (;;)
    {
      synchronized (i.o(this.c))
      {
        if ((this.a != null) && (!this.a.g()))
        {
          i = 0;
          if ((i == 0) || (i.p(this.c))) {
            break;
          }
          ??? = i.h(this.c);
          long l = ((h)???).f();
          if ((l <= 0L) || (l != ((h)???).a)) {
            break label248;
          }
          i = j;
          if (i != 0) {
            break;
          }
          this.c.r = paramc.c();
          this.c.s = paramc.d();
          if (this.c.r == 0)
          {
            this.c.r = -69;
            this.c.s = ("readLen:" + i.h(this.c).f());
          }
          i.k(this.c).a(DownloaderTaskStatus.FAILED);
          return;
        }
        if ((!this.c.B) || (this.b == null) || (this.b.g())) {
          break label253;
        }
        i = 0;
      }
      label248:
      i = 0;
      continue;
      label253:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.k
 * JD-Core Version:    0.7.0.1
 */