package com.tencent.hlyyb.downloader.e.b;

import android.text.TextUtils;
import com.tencent.hlyyb.downloader.a.a.e;
import com.tencent.hlyyb.downloader.e.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  implements com.tencent.hlyyb.downloader.a.a.d, com.tencent.hlyyb.downloader.a.b, com.tencent.hlyyb.downloader.b.d, Runnable
{
  private boolean A = false;
  private int B = 3;
  private boolean C = false;
  private volatile int D;
  private long E;
  private volatile boolean F = true;
  public a a;
  public com.tencent.hlyyb.downloader.e.d.a b;
  public volatile boolean c = false;
  private boolean d = true;
  private com.tencent.hlyyb.downloader.e.d.c e;
  private com.tencent.hlyyb.downloader.a.b f;
  private b g;
  private Map<String, String> h = null;
  private int i = 0;
  private String j = "";
  private boolean k = false;
  private boolean l = false;
  private e m;
  private Object n = new Object();
  private com.tencent.hlyyb.downloader.e.c.c o = new com.tencent.hlyyb.downloader.e.c.c();
  private String p;
  private boolean q = true;
  private List<com.tencent.hlyyb.downloader.b.c> r;
  private Map<com.tencent.hlyyb.downloader.e.d.a, com.tencent.hlyyb.downloader.b.c> s;
  private Map<com.tencent.hlyyb.downloader.e.d.a, List<String>> t;
  private com.tencent.hlyyb.downloader.b.a u;
  private volatile boolean v = false;
  private AtomicInteger w;
  private AtomicInteger x;
  private boolean y = true;
  private boolean z = true;
  
  public c(com.tencent.hlyyb.downloader.e.d.c paramc, boolean paramBoolean1, com.tencent.hlyyb.downloader.a.b paramb, b paramb1, Map<String, String> paramMap, boolean paramBoolean2)
  {
    this.e = paramc;
    this.d = paramBoolean1;
    this.o.a = paramBoolean1;
    this.f = paramb;
    this.g = paramb1;
    this.h = paramMap;
    this.q = paramBoolean2;
  }
  
  private boolean b(com.tencent.hlyyb.downloader.e.d.a parama)
  {
    if (this.e.a() <= 0L) {
      return false;
    }
    List localList = this.e.d();
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return false;
      }
      if (TextUtils.isEmpty(this.e.c())) {
        return false;
      }
      if (parama == null) {
        return false;
      }
      if (this.s.get(parama) != null) {
        return false;
      }
      if ((this.F) && (this.q)) {
        return this.y;
      }
    }
    return false;
  }
  
  public final void a(com.tencent.hlyyb.downloader.e.d.a parama)
  {
    com.tencent.hlyyb.downloader.b.c localc = (com.tencent.hlyyb.downloader.b.c)this.s.get(parama);
    if ((localc != null) && (!localc.e)) {
      this.u.a(parama, localc);
    }
  }
  
  public final void a(List<com.tencent.hlyyb.downloader.b.c> paramList, Map<com.tencent.hlyyb.downloader.e.d.a, com.tencent.hlyyb.downloader.b.c> paramMap, Map<com.tencent.hlyyb.downloader.e.d.a, List<String>> paramMap1, com.tencent.hlyyb.downloader.b.a parama, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, long paramLong)
  {
    this.r = paramList;
    this.s = paramMap;
    this.t = paramMap1;
    this.u = parama;
    this.w = paramAtomicInteger1;
    this.x = paramAtomicInteger2;
    this.E = paramLong;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.F = false;
  }
  
  public final boolean a()
  {
    if (this.k) {
      return true;
    }
    com.tencent.hlyyb.downloader.a.b localb = this.f;
    if (localb != null) {
      return localb.a();
    }
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    boolean bool = b(this.b);
    int i3 = 1;
    int i2 = 1;
    if (bool)
    {
      com.tencent.hlyyb.downloader.b.c localc = new com.tencent.hlyyb.downloader.b.c((i)this.f, this.e, this.b, this.r, this.s, this, false, this.x, this.w);
      synchronized (this.r)
      {
        this.r.add(localc);
        this.s.put(this.b, localc);
        localc.h = this.E;
        localc.f = com.tencent.hlyyb.downloader.f.a.a().c(localc);
        localc.a(this.d ^ true, this.D);
      }
    }
    ??? = (com.tencent.hlyyb.downloader.b.c)this.s.get(this.b);
    int i1;
    if ((??? != null) && (((com.tencent.hlyyb.downloader.b.c)???).d) && (!((com.tencent.hlyyb.downloader.b.c)???).e) && (this.u.a(this.a, (com.tencent.hlyyb.downloader.b.c)???)))
    {
      this.v = true;
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if (i1 != 0) {
      return false;
    }
    if (this.g != null)
    {
      if (this.a.f + paramInt >= this.a.g)
      {
        i1 = (int)(this.a.g - this.a.f);
        paramInt = 0;
      }
      else
      {
        i1 = paramInt;
        paramInt = i2;
      }
      i3 = paramInt & this.g.a(this, this.a.f, paramArrayOfByte, i1, paramBoolean);
    }
    return i3;
  }
  
  public final com.tencent.hlyyb.downloader.e.d.a b()
  {
    for (;;)
    {
      try
      {
        ??? = new ArrayList();
        synchronized (this.r)
        {
          Object localObject4 = this.r.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            ((List)???).add(((com.tencent.hlyyb.downloader.b.c)((Iterator)localObject4).next()).b);
            continue;
          }
          ??? = this.e;
          if (this.w.get() >= this.B)
          {
            bool = true;
            ??? = ((com.tencent.hlyyb.downloader.e.d.c)???).a((List)???, bool);
            if (b((com.tencent.hlyyb.downloader.e.d.a)???))
            {
              localObject4 = new com.tencent.hlyyb.downloader.b.c((i)this.f, this.e, (com.tencent.hlyyb.downloader.e.d.a)???, this.r, this.s, this, false, this.x, this.w);
              synchronized (this.r)
              {
                this.r.add(localObject4);
                this.s.put(???, localObject4);
                ((com.tencent.hlyyb.downloader.b.c)localObject4).h = this.E;
                ((com.tencent.hlyyb.downloader.b.c)localObject4).a = true;
                ((com.tencent.hlyyb.downloader.b.c)localObject4).f = com.tencent.hlyyb.downloader.f.a.a().c((Runnable)localObject4);
                return ???;
              }
            }
            return locala;
          }
        }
        boolean bool = false;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
    }
  }
  
  public final int c()
  {
    return this.i;
  }
  
  public final String d()
  {
    return this.j;
  }
  
  public final void e()
  {
    e locale = this.m;
    if (locale != null) {
      locale.s();
    }
  }
  
  public final void f()
  {
    try
    {
      this.k = true;
      if (this.m != null) {
        this.m.s();
      }
      synchronized (this.n)
      {
        this.n.notifyAll();
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final boolean g()
  {
    return this.l;
  }
  
  public final String h()
  {
    com.tencent.hlyyb.downloader.e.c.c localc = this.o;
    if (localc != null) {
      return localc.a();
    }
    return "";
  }
  
  public final String i()
  {
    com.tencent.hlyyb.downloader.e.c.c localc = this.o;
    if (localc != null) {
      return localc.toString();
    }
    return "";
  }
  
  public final String j()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.d ^ true);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.p);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(",");
    localStringBuilder1.append(";");
    return localStringBuilder1.toString();
  }
  
  public final int k()
  {
    return this.D;
  }
  
  public final String l()
  {
    try
    {
      if (this.m != null)
      {
        String str = ((com.tencent.hlyyb.downloader.a.a.a)this.m).e();
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   4: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   7: putfield 310	com/tencent/hlyyb/downloader/e/c/c:b	J
    //   10: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   13: lstore 10
    //   15: lconst_0
    //   16: lstore 4
    //   18: iconst_0
    //   19: istore_1
    //   20: iconst_1
    //   21: istore_2
    //   22: iconst_0
    //   23: istore 12
    //   25: aload_0
    //   26: astore 16
    //   28: aload 16
    //   30: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   33: ifne +27 -> 60
    //   36: aload 16
    //   38: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   41: astore 15
    //   43: aload 15
    //   45: ifnull +15 -> 60
    //   48: aload 15
    //   50: invokeinterface 179 1 0
    //   55: istore 13
    //   57: goto +6 -> 63
    //   60: iconst_1
    //   61: istore 13
    //   63: iload 13
    //   65: ifne +3456 -> 3521
    //   68: aload 16
    //   70: getfield 71	com/tencent/hlyyb/downloader/e/b/c:d	Z
    //   73: ifne +82 -> 155
    //   76: aload 16
    //   78: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   81: sipush 15000
    //   84: invokevirtual 318	com/tencent/hlyyb/downloader/e/d/c:b	(I)V
    //   87: aload 16
    //   89: getfield 92	com/tencent/hlyyb/downloader/e/b/c:q	Z
    //   92: ifeq +63 -> 155
    //   95: aload 16
    //   97: getfield 100	com/tencent/hlyyb/downloader/e/b/c:z	Z
    //   100: ifeq +55 -> 155
    //   103: aload 16
    //   105: getfield 106	com/tencent/hlyyb/downloader/e/b/c:C	Z
    //   108: ifne +47 -> 155
    //   111: aload 16
    //   113: getfield 158	com/tencent/hlyyb/downloader/e/b/c:u	Lcom/tencent/hlyyb/downloader/b/a;
    //   116: aload 16
    //   118: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   121: invokevirtual 125	com/tencent/hlyyb/downloader/e/d/c:a	()J
    //   124: invokeinterface 321 3 0
    //   129: aload 16
    //   131: iconst_1
    //   132: putfield 106	com/tencent/hlyyb/downloader/e/b/c:C	Z
    //   135: goto +20 -> 155
    //   138: astore 15
    //   140: aload 15
    //   142: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   145: goto +10 -> 155
    //   148: astore 15
    //   150: aload 15
    //   152: invokevirtual 322	java/lang/Throwable:printStackTrace	()V
    //   155: aload 16
    //   157: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   160: ifne +27 -> 187
    //   163: aload 16
    //   165: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   168: astore 15
    //   170: aload 15
    //   172: ifnull +15 -> 187
    //   175: aload 15
    //   177: invokeinterface 179 1 0
    //   182: istore 13
    //   184: goto +6 -> 190
    //   187: iconst_1
    //   188: istore 13
    //   190: iload 13
    //   192: ifne +3329 -> 3521
    //   195: aload 16
    //   197: getfield 71	com/tencent/hlyyb/downloader/e/b/c:d	Z
    //   200: ifne +11 -> 211
    //   203: aload 16
    //   205: getfield 92	com/tencent/hlyyb/downloader/e/b/c:q	Z
    //   208: ifeq +3313 -> 3521
    //   211: iload_1
    //   212: ifle +50 -> 262
    //   215: aload 16
    //   217: getfield 85	com/tencent/hlyyb/downloader/e/b/c:n	Ljava/lang/Object;
    //   220: astore 15
    //   222: aload 15
    //   224: monitorenter
    //   225: aload 16
    //   227: getfield 85	com/tencent/hlyyb/downloader/e/b/c:n	Ljava/lang/Object;
    //   230: iload_1
    //   231: i2l
    //   232: invokevirtual 325	java/lang/Object:wait	(J)V
    //   235: goto +15 -> 250
    //   238: astore 16
    //   240: goto +16 -> 256
    //   243: astore 17
    //   245: aload 17
    //   247: invokevirtual 326	java/lang/InterruptedException:printStackTrace	()V
    //   250: aload 15
    //   252: monitorexit
    //   253: goto +9 -> 262
    //   256: aload 15
    //   258: monitorexit
    //   259: aload 16
    //   261: athrow
    //   262: aload 16
    //   264: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   267: ifne +27 -> 294
    //   270: aload 16
    //   272: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   275: astore 15
    //   277: aload 15
    //   279: ifnull +15 -> 294
    //   282: aload 15
    //   284: invokeinterface 179 1 0
    //   289: istore 13
    //   291: goto +6 -> 297
    //   294: iconst_1
    //   295: istore 13
    //   297: iload 13
    //   299: ifne +3222 -> 3521
    //   302: lload 4
    //   304: lstore 6
    //   306: lload 4
    //   308: lconst_0
    //   309: lcmp
    //   310: ifne +8 -> 318
    //   313: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   316: lstore 6
    //   318: lload 6
    //   320: lstore 4
    //   322: aload 16
    //   324: getfield 96	com/tencent/hlyyb/downloader/e/b/c:v	Z
    //   327: ifeq +17 -> 344
    //   330: aload 16
    //   332: iconst_0
    //   333: putfield 96	com/tencent/hlyyb/downloader/e/b/c:v	Z
    //   336: iconst_1
    //   337: istore_2
    //   338: iconst_1
    //   339: istore 13
    //   341: goto +6 -> 347
    //   344: iconst_0
    //   345: istore 13
    //   347: iload_2
    //   348: ifeq +87 -> 435
    //   351: aload 16
    //   353: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   356: istore_3
    //   357: iload_3
    //   358: sipush 404
    //   361: if_icmpeq +40 -> 401
    //   364: iload_3
    //   365: bipush 246
    //   367: if_icmpeq +34 -> 401
    //   370: iload_3
    //   371: bipush 245
    //   373: if_icmpeq +28 -> 401
    //   376: aload 16
    //   378: getfield 170	com/tencent/hlyyb/downloader/e/b/c:w	Ljava/util/concurrent/atomic/AtomicInteger;
    //   381: invokevirtual 256	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   384: aload 16
    //   386: getfield 104	com/tencent/hlyyb/downloader/e/b/c:B	I
    //   389: if_icmplt +6 -> 395
    //   392: goto +9 -> 401
    //   395: iconst_0
    //   396: istore 14
    //   398: goto +6 -> 404
    //   401: iconst_1
    //   402: istore 14
    //   404: aload 16
    //   406: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   409: invokestatic 330	com/tencent/hlyyb/common/a/a:b	()Ljava/lang/String;
    //   412: aload 16
    //   414: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   417: aload 16
    //   419: getfield 71	com/tencent/hlyyb/downloader/e/b/c:d	Z
    //   422: iconst_0
    //   423: iload 13
    //   425: iload 14
    //   427: invokevirtual 333	com/tencent/hlyyb/downloader/e/d/c:a	(Ljava/lang/String;Lcom/tencent/hlyyb/downloader/e/d/a;ZZZZ)Lcom/tencent/hlyyb/downloader/e/d/a;
    //   430: astore 15
    //   432: goto +68 -> 500
    //   435: aload 16
    //   437: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   440: getfield 337	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   443: getstatic 340	com/tencent/hlyyb/downloader/e/d/b:b	I
    //   446: if_icmpeq +31 -> 477
    //   449: aload 16
    //   451: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   454: getfield 337	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   457: getstatic 342	com/tencent/hlyyb/downloader/e/d/b:a	I
    //   460: if_icmpeq +17 -> 477
    //   463: aload 16
    //   465: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   468: getfield 337	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   471: getstatic 344	com/tencent/hlyyb/downloader/e/d/b:g	I
    //   474: if_icmpne +33 -> 507
    //   477: aload 16
    //   479: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   482: aload 16
    //   484: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   487: getfield 337	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   490: invokevirtual 347	com/tencent/hlyyb/downloader/e/d/c:a	(I)Lcom/tencent/hlyyb/downloader/e/d/a;
    //   493: astore 15
    //   495: aload 15
    //   497: ifnull +10 -> 507
    //   500: aload 16
    //   502: aload 15
    //   504: putfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   507: aload 16
    //   509: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   512: astore 15
    //   514: aload 15
    //   516: iconst_1
    //   517: putfield 349	com/tencent/hlyyb/downloader/e/d/a:f	Z
    //   520: aload 16
    //   522: getfield 145	com/tencent/hlyyb/downloader/e/b/c:s	Ljava/util/Map;
    //   525: aload 15
    //   527: invokeinterface 151 2 0
    //   532: checkcast 154	com/tencent/hlyyb/downloader/b/c
    //   535: astore 15
    //   537: aload 15
    //   539: ifnull +39 -> 578
    //   542: aload 15
    //   544: getfield 350	com/tencent/hlyyb/downloader/b/c:c	Z
    //   547: ifeq +31 -> 578
    //   550: aload 16
    //   552: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   555: invokevirtual 352	com/tencent/hlyyb/downloader/e/d/c:e	()I
    //   558: ifle +20 -> 578
    //   561: aload 15
    //   563: getfield 156	com/tencent/hlyyb/downloader/b/c:e	Z
    //   566: ifne +12 -> 578
    //   569: aload 16
    //   571: iconst_1
    //   572: putfield 96	com/tencent/hlyyb/downloader/e/b/c:v	Z
    //   575: goto -550 -> 25
    //   578: aload 16
    //   580: aload 16
    //   582: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   585: aload 16
    //   587: invokeinterface 355 2 0
    //   592: putfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   595: aload 16
    //   597: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   600: ifnull +2921 -> 3521
    //   603: iload 12
    //   605: ifeq +35 -> 640
    //   608: invokestatic 357	com/tencent/hlyyb/common/a/a:i	()Z
    //   611: istore 13
    //   613: iload 13
    //   615: ifne +25 -> 640
    //   618: iconst_0
    //   619: istore 12
    //   621: goto +19 -> 640
    //   624: astore 15
    //   626: aconst_null
    //   627: astore 16
    //   629: goto +2842 -> 3471
    //   632: astore 16
    //   634: aconst_null
    //   635: astore 15
    //   637: goto +2735 -> 3372
    //   640: iconst_m1
    //   641: istore_1
    //   642: iload 12
    //   644: ifeq +7 -> 651
    //   647: ldc_w 358
    //   650: istore_1
    //   651: aload 16
    //   653: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   656: astore 15
    //   658: aload 16
    //   660: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   663: invokeinterface 359 1 0
    //   668: istore 13
    //   670: aload 15
    //   672: getfield 227	com/tencent/hlyyb/downloader/e/b/a:g	J
    //   675: lstore 6
    //   677: iload_1
    //   678: ifle +100 -> 778
    //   681: aload 15
    //   683: getfield 227	com/tencent/hlyyb/downloader/e/b/a:g	J
    //   686: lstore 8
    //   688: lload 8
    //   690: ldc2_w 360
    //   693: lcmp
    //   694: ifne +24 -> 718
    //   697: aload 15
    //   699: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   702: lstore 6
    //   704: iload_1
    //   705: i2l
    //   706: lstore 8
    //   708: lload 6
    //   710: lload 8
    //   712: ladd
    //   713: lstore 6
    //   715: goto +63 -> 778
    //   718: iload_1
    //   719: i2l
    //   720: lstore 8
    //   722: lload 8
    //   724: aload 15
    //   726: getfield 227	com/tencent/hlyyb/downloader/e/b/a:g	J
    //   729: aload 15
    //   731: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   734: lsub
    //   735: lcmp
    //   736: ifge +13 -> 749
    //   739: aload 15
    //   741: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   744: lstore 6
    //   746: goto -38 -> 708
    //   749: iload 13
    //   751: ifne +27 -> 778
    //   754: ldc2_w 360
    //   757: lstore 6
    //   759: goto +19 -> 778
    //   762: astore 15
    //   764: aconst_null
    //   765: astore 16
    //   767: goto +2704 -> 3471
    //   770: astore 16
    //   772: aconst_null
    //   773: astore 15
    //   775: goto +2597 -> 3372
    //   778: new 363	com/tencent/hlyyb/downloader/a/a/b
    //   781: dup
    //   782: aload 15
    //   784: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   787: lload 6
    //   789: invokespecial 366	com/tencent/hlyyb/downloader/a/a/b:<init>	(JJ)V
    //   792: astore 15
    //   794: aload_0
    //   795: astore 20
    //   797: aload 20
    //   799: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   802: astore 16
    //   804: aload 20
    //   806: getfield 73	com/tencent/hlyyb/downloader/e/b/c:h	Ljava/util/Map;
    //   809: astore 17
    //   811: aload 20
    //   813: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   816: getfield 367	com/tencent/hlyyb/downloader/e/d/a:d	Z
    //   819: istore 14
    //   821: iload 12
    //   823: istore 13
    //   825: new 369	com/tencent/hlyyb/downloader/a/a/f
    //   828: dup
    //   829: aload 16
    //   831: aload 17
    //   833: aload 15
    //   835: iload 12
    //   837: aload_0
    //   838: iload 14
    //   840: iconst_1
    //   841: invokespecial 372	com/tencent/hlyyb/downloader/a/a/f:<init>	(Lcom/tencent/hlyyb/downloader/e/d/a;Ljava/util/Map;Lcom/tencent/hlyyb/downloader/a/a/b;ZLcom/tencent/hlyyb/downloader/a/b;ZI)V
    //   844: astore 16
    //   846: aload 20
    //   848: aload 16
    //   850: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   853: aload 20
    //   855: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   858: istore 14
    //   860: iload 14
    //   862: ifne +60 -> 922
    //   865: aload 16
    //   867: astore 17
    //   869: aload 16
    //   871: astore 18
    //   873: aload 20
    //   875: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   878: ifnull +44 -> 922
    //   881: aload 16
    //   883: astore 17
    //   885: aload 16
    //   887: astore 18
    //   889: aload 20
    //   891: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   894: invokeinterface 179 1 0
    //   899: istore 14
    //   901: goto +24 -> 925
    //   904: astore 15
    //   906: aload 17
    //   908: astore 16
    //   910: goto -281 -> 629
    //   913: astore 16
    //   915: aload 18
    //   917: astore 15
    //   919: goto -282 -> 637
    //   922: iconst_1
    //   923: istore 14
    //   925: iload 14
    //   927: ifeq +45 -> 972
    //   930: aload 20
    //   932: iconst_0
    //   933: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   936: aload 20
    //   938: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   941: aload 20
    //   943: invokeinterface 375 2 0
    //   948: aload 20
    //   950: aconst_null
    //   951: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   954: aload 20
    //   956: aload 16
    //   958: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   961: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   964: aload 16
    //   966: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   969: goto +2552 -> 3521
    //   972: aload 20
    //   974: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   977: astore 17
    //   979: aload 17
    //   981: getfield 381	com/tencent/hlyyb/downloader/e/c/c:d	I
    //   984: istore_1
    //   985: aload 17
    //   987: iload_1
    //   988: iconst_1
    //   989: iadd
    //   990: putfield 381	com/tencent/hlyyb/downloader/e/c/c:d	I
    //   993: aload 20
    //   995: iload_1
    //   996: putfield 212	com/tencent/hlyyb/downloader/e/b/c:D	I
    //   999: new 383	com/tencent/hlyyb/downloader/e/c/d
    //   1002: dup
    //   1003: aload 20
    //   1005: getfield 212	com/tencent/hlyyb/downloader/e/b/c:D	I
    //   1008: aload 20
    //   1010: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1013: invokespecial 386	com/tencent/hlyyb/downloader/e/c/d:<init>	(ILcom/tencent/hlyyb/downloader/e/d/a;)V
    //   1016: astore 21
    //   1018: aload 21
    //   1020: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1023: lload 10
    //   1025: lsub
    //   1026: putfield 388	com/tencent/hlyyb/downloader/e/c/d:c	J
    //   1029: aload 21
    //   1031: iload 13
    //   1033: putfield 389	com/tencent/hlyyb/downloader/e/c/d:a	Z
    //   1036: aload 21
    //   1038: aload 20
    //   1040: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   1043: invokevirtual 390	com/tencent/hlyyb/downloader/e/b/a:toString	()Ljava/lang/String;
    //   1046: putfield 392	com/tencent/hlyyb/downloader/e/c/d:b	Ljava/lang/String;
    //   1049: aload 21
    //   1051: aload 15
    //   1053: invokevirtual 393	com/tencent/hlyyb/downloader/a/a/b:toString	()Ljava/lang/String;
    //   1056: putfield 395	com/tencent/hlyyb/downloader/e/c/d:f	Ljava/lang/String;
    //   1059: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1062: lstore 6
    //   1064: aload 16
    //   1066: invokevirtual 397	com/tencent/hlyyb/downloader/a/a/f:p	()V
    //   1069: aload 20
    //   1071: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   1074: istore 14
    //   1076: iload 14
    //   1078: ifne +42 -> 1120
    //   1081: aload 16
    //   1083: astore 17
    //   1085: aload 16
    //   1087: astore 18
    //   1089: aload 20
    //   1091: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1094: ifnull +26 -> 1120
    //   1097: aload 16
    //   1099: astore 17
    //   1101: aload 16
    //   1103: astore 18
    //   1105: aload 20
    //   1107: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1110: invokeinterface 179 1 0
    //   1115: istore 14
    //   1117: goto +6 -> 1123
    //   1120: iconst_1
    //   1121: istore 14
    //   1123: iload 14
    //   1125: ifeq +45 -> 1170
    //   1128: aload 20
    //   1130: iconst_0
    //   1131: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   1134: aload 20
    //   1136: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1139: aload 20
    //   1141: invokeinterface 375 2 0
    //   1146: aload 20
    //   1148: aconst_null
    //   1149: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1152: aload 20
    //   1154: aload 16
    //   1156: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   1159: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   1162: aload 16
    //   1164: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   1167: goto +2354 -> 3521
    //   1170: aload 20
    //   1172: aload 16
    //   1174: invokevirtual 399	com/tencent/hlyyb/downloader/a/a/f:a	()I
    //   1177: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1180: aload 20
    //   1182: aload 16
    //   1184: invokevirtual 400	com/tencent/hlyyb/downloader/a/a/f:b	()Ljava/lang/String;
    //   1187: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   1190: aload 21
    //   1192: aload 20
    //   1194: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1197: putfield 402	com/tencent/hlyyb/downloader/e/c/d:e	I
    //   1200: aload 21
    //   1202: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1205: lload 10
    //   1207: lsub
    //   1208: putfield 404	com/tencent/hlyyb/downloader/e/c/d:d	J
    //   1211: aload 21
    //   1213: aload 16
    //   1215: invokevirtual 406	com/tencent/hlyyb/downloader/a/a/f:g	()Ljava/lang/String;
    //   1218: putfield 408	com/tencent/hlyyb/downloader/e/c/d:g	Ljava/lang/String;
    //   1221: aload 21
    //   1223: aload 16
    //   1225: invokevirtual 410	com/tencent/hlyyb/downloader/a/a/f:i	()Ljava/lang/String;
    //   1228: putfield 412	com/tencent/hlyyb/downloader/e/c/d:i	Ljava/lang/String;
    //   1231: aload 21
    //   1233: aload 16
    //   1235: invokevirtual 414	com/tencent/hlyyb/downloader/a/a/f:j	()Ljava/lang/String;
    //   1238: putfield 415	com/tencent/hlyyb/downloader/e/c/d:j	Ljava/lang/String;
    //   1241: aload 21
    //   1243: aload 16
    //   1245: invokevirtual 417	com/tencent/hlyyb/downloader/a/a/f:c	()J
    //   1248: putfield 418	com/tencent/hlyyb/downloader/e/c/d:h	J
    //   1251: aload 21
    //   1253: aload 16
    //   1255: invokevirtual 420	com/tencent/hlyyb/downloader/a/a/f:h	()Ljava/lang/String;
    //   1258: putfield 422	com/tencent/hlyyb/downloader/e/c/d:k	Ljava/lang/String;
    //   1261: aload 21
    //   1263: aload 16
    //   1265: invokevirtual 424	com/tencent/hlyyb/downloader/a/a/f:k	()Ljava/lang/String;
    //   1268: putfield 426	com/tencent/hlyyb/downloader/e/c/d:l	Ljava/lang/String;
    //   1271: aload 21
    //   1273: aload 16
    //   1275: invokevirtual 428	com/tencent/hlyyb/downloader/a/a/f:l	()Ljava/lang/String;
    //   1278: putfield 430	com/tencent/hlyyb/downloader/e/c/d:m	Ljava/lang/String;
    //   1281: aload 21
    //   1283: aload 16
    //   1285: iconst_0
    //   1286: invokevirtual 433	com/tencent/hlyyb/downloader/a/a/f:a	(Z)Ljava/lang/String;
    //   1289: putfield 435	com/tencent/hlyyb/downloader/e/c/d:r	Ljava/lang/String;
    //   1292: aload 21
    //   1294: aload 16
    //   1296: invokevirtual 437	com/tencent/hlyyb/downloader/a/a/f:f	()Ljava/lang/String;
    //   1299: putfield 439	com/tencent/hlyyb/downloader/e/c/d:s	Ljava/lang/String;
    //   1302: aload 20
    //   1304: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   1307: aload 21
    //   1309: invokevirtual 442	com/tencent/hlyyb/downloader/e/c/c:a	(Lcom/tencent/hlyyb/downloader/e/c/d;)V
    //   1312: aload 20
    //   1314: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1317: istore_1
    //   1318: aload 21
    //   1320: astore 19
    //   1322: aload 16
    //   1324: astore 15
    //   1326: iload_1
    //   1327: bipush 203
    //   1329: if_icmpne +491 -> 1820
    //   1332: aload 16
    //   1334: astore 17
    //   1336: aload 16
    //   1338: astore 18
    //   1340: aload 21
    //   1342: astore 19
    //   1344: aload 16
    //   1346: astore 15
    //   1348: aload 20
    //   1350: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1353: invokeinterface 359 1 0
    //   1358: ifne +462 -> 1820
    //   1361: aload 16
    //   1363: astore 17
    //   1365: aload 16
    //   1367: astore 18
    //   1369: new 369	com/tencent/hlyyb/downloader/a/a/f
    //   1372: dup
    //   1373: aload 20
    //   1375: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1378: aload 20
    //   1380: getfield 73	com/tencent/hlyyb/downloader/e/b/c:h	Ljava/util/Map;
    //   1383: aconst_null
    //   1384: iload 13
    //   1386: aload_0
    //   1387: aload 20
    //   1389: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1392: getfield 367	com/tencent/hlyyb/downloader/e/d/a:d	Z
    //   1395: iconst_1
    //   1396: invokespecial 372	com/tencent/hlyyb/downloader/a/a/f:<init>	(Lcom/tencent/hlyyb/downloader/e/d/a;Ljava/util/Map;Lcom/tencent/hlyyb/downloader/a/a/b;ZLcom/tencent/hlyyb/downloader/a/b;ZI)V
    //   1399: astore 16
    //   1401: aload 20
    //   1403: aload 16
    //   1405: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1408: aload 20
    //   1410: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   1413: ifne +26 -> 1439
    //   1416: aload 20
    //   1418: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1421: ifnull +18 -> 1439
    //   1424: aload 20
    //   1426: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1429: invokeinterface 179 1 0
    //   1434: istore 14
    //   1436: goto +6 -> 1442
    //   1439: iconst_1
    //   1440: istore 14
    //   1442: iload 14
    //   1444: ifeq +45 -> 1489
    //   1447: aload 20
    //   1449: iconst_0
    //   1450: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   1453: aload 20
    //   1455: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1458: aload 20
    //   1460: invokeinterface 375 2 0
    //   1465: aload 20
    //   1467: aconst_null
    //   1468: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1471: aload 20
    //   1473: aload 16
    //   1475: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   1478: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   1481: aload 16
    //   1483: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   1486: goto +2035 -> 3521
    //   1489: aload 20
    //   1491: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   1494: astore 15
    //   1496: aload 15
    //   1498: getfield 381	com/tencent/hlyyb/downloader/e/c/c:d	I
    //   1501: istore_1
    //   1502: aload 15
    //   1504: iload_1
    //   1505: iconst_1
    //   1506: iadd
    //   1507: putfield 381	com/tencent/hlyyb/downloader/e/c/c:d	I
    //   1510: aload 20
    //   1512: iload_1
    //   1513: putfield 212	com/tencent/hlyyb/downloader/e/b/c:D	I
    //   1516: new 383	com/tencent/hlyyb/downloader/e/c/d
    //   1519: dup
    //   1520: aload 20
    //   1522: getfield 212	com/tencent/hlyyb/downloader/e/b/c:D	I
    //   1525: aload 20
    //   1527: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1530: invokespecial 386	com/tencent/hlyyb/downloader/e/c/d:<init>	(ILcom/tencent/hlyyb/downloader/e/d/a;)V
    //   1533: astore 19
    //   1535: aload 19
    //   1537: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1540: lload 10
    //   1542: lsub
    //   1543: putfield 388	com/tencent/hlyyb/downloader/e/c/d:c	J
    //   1546: aload 19
    //   1548: iload 13
    //   1550: putfield 389	com/tencent/hlyyb/downloader/e/c/d:a	Z
    //   1553: aload 19
    //   1555: aload 20
    //   1557: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   1560: invokevirtual 390	com/tencent/hlyyb/downloader/e/b/a:toString	()Ljava/lang/String;
    //   1563: putfield 392	com/tencent/hlyyb/downloader/e/c/d:b	Ljava/lang/String;
    //   1566: aload 19
    //   1568: ldc 77
    //   1570: putfield 395	com/tencent/hlyyb/downloader/e/c/d:f	Ljava/lang/String;
    //   1573: aload 16
    //   1575: invokevirtual 397	com/tencent/hlyyb/downloader/a/a/f:p	()V
    //   1578: aload 20
    //   1580: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   1583: ifne +26 -> 1609
    //   1586: aload 20
    //   1588: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1591: ifnull +18 -> 1609
    //   1594: aload 20
    //   1596: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1599: invokeinterface 179 1 0
    //   1604: istore 14
    //   1606: goto +6 -> 1612
    //   1609: iconst_1
    //   1610: istore 14
    //   1612: iload 14
    //   1614: ifeq +45 -> 1659
    //   1617: aload 20
    //   1619: iconst_0
    //   1620: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   1623: aload 20
    //   1625: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1628: aload 20
    //   1630: invokeinterface 375 2 0
    //   1635: aload 20
    //   1637: aconst_null
    //   1638: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1641: aload 20
    //   1643: aload 16
    //   1645: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   1648: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   1651: aload 16
    //   1653: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   1656: goto +1865 -> 3521
    //   1659: aload 20
    //   1661: aload 16
    //   1663: invokevirtual 399	com/tencent/hlyyb/downloader/a/a/f:a	()I
    //   1666: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1669: aload 20
    //   1671: aload 16
    //   1673: invokevirtual 400	com/tencent/hlyyb/downloader/a/a/f:b	()Ljava/lang/String;
    //   1676: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   1679: aload 19
    //   1681: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1684: lload 10
    //   1686: lsub
    //   1687: putfield 404	com/tencent/hlyyb/downloader/e/c/d:d	J
    //   1690: aload 19
    //   1692: aload 16
    //   1694: invokevirtual 406	com/tencent/hlyyb/downloader/a/a/f:g	()Ljava/lang/String;
    //   1697: putfield 408	com/tencent/hlyyb/downloader/e/c/d:g	Ljava/lang/String;
    //   1700: aload 19
    //   1702: aload 16
    //   1704: invokevirtual 410	com/tencent/hlyyb/downloader/a/a/f:i	()Ljava/lang/String;
    //   1707: putfield 412	com/tencent/hlyyb/downloader/e/c/d:i	Ljava/lang/String;
    //   1710: aload 19
    //   1712: aload 16
    //   1714: invokevirtual 414	com/tencent/hlyyb/downloader/a/a/f:j	()Ljava/lang/String;
    //   1717: putfield 415	com/tencent/hlyyb/downloader/e/c/d:j	Ljava/lang/String;
    //   1720: aload 19
    //   1722: aload 16
    //   1724: invokevirtual 417	com/tencent/hlyyb/downloader/a/a/f:c	()J
    //   1727: putfield 418	com/tencent/hlyyb/downloader/e/c/d:h	J
    //   1730: aload 19
    //   1732: aload 16
    //   1734: invokevirtual 420	com/tencent/hlyyb/downloader/a/a/f:h	()Ljava/lang/String;
    //   1737: putfield 422	com/tencent/hlyyb/downloader/e/c/d:k	Ljava/lang/String;
    //   1740: aload 19
    //   1742: aload 16
    //   1744: invokevirtual 424	com/tencent/hlyyb/downloader/a/a/f:k	()Ljava/lang/String;
    //   1747: putfield 426	com/tencent/hlyyb/downloader/e/c/d:l	Ljava/lang/String;
    //   1750: aload 19
    //   1752: aload 16
    //   1754: invokevirtual 428	com/tencent/hlyyb/downloader/a/a/f:l	()Ljava/lang/String;
    //   1757: putfield 430	com/tencent/hlyyb/downloader/e/c/d:m	Ljava/lang/String;
    //   1760: aload 19
    //   1762: aload 16
    //   1764: iconst_0
    //   1765: invokevirtual 433	com/tencent/hlyyb/downloader/a/a/f:a	(Z)Ljava/lang/String;
    //   1768: putfield 435	com/tencent/hlyyb/downloader/e/c/d:r	Ljava/lang/String;
    //   1771: aload 19
    //   1773: aload 16
    //   1775: invokevirtual 437	com/tencent/hlyyb/downloader/a/a/f:f	()Ljava/lang/String;
    //   1778: putfield 439	com/tencent/hlyyb/downloader/e/c/d:s	Ljava/lang/String;
    //   1781: aload 20
    //   1783: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   1786: aload 19
    //   1788: invokevirtual 442	com/tencent/hlyyb/downloader/e/c/c:a	(Lcom/tencent/hlyyb/downloader/e/c/d;)V
    //   1791: aload 16
    //   1793: astore 15
    //   1795: goto +25 -> 1820
    //   1798: astore 15
    //   1800: goto -1171 -> 629
    //   1803: astore 15
    //   1805: aload 16
    //   1807: astore 17
    //   1809: aload 15
    //   1811: astore 16
    //   1813: aload 17
    //   1815: astore 15
    //   1817: goto -1180 -> 637
    //   1820: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1823: lstore 8
    //   1825: aload 20
    //   1827: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1830: istore_1
    //   1831: iload_1
    //   1832: ifeq +89 -> 1921
    //   1835: aload 15
    //   1837: astore 17
    //   1839: aload 15
    //   1841: astore 18
    //   1843: aload 20
    //   1845: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1848: bipush 197
    //   1850: if_icmpne +1721 -> 3571
    //   1853: iconst_0
    //   1854: istore_2
    //   1855: iconst_1
    //   1856: istore 13
    //   1858: goto +1715 -> 3573
    //   1861: aload 15
    //   1863: astore 17
    //   1865: aload 15
    //   1867: astore 18
    //   1869: aload 20
    //   1871: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1874: istore_1
    //   1875: iload_1
    //   1876: bipush 240
    //   1878: if_icmpeq +23 -> 1901
    //   1881: iload_1
    //   1882: bipush 241
    //   1884: if_icmpeq +17 -> 1901
    //   1887: iload_1
    //   1888: bipush 179
    //   1890: if_icmpne +6 -> 1896
    //   1893: goto +8 -> 1901
    //   1896: iconst_0
    //   1897: istore_1
    //   1898: goto +5 -> 1903
    //   1901: iconst_1
    //   1902: istore_1
    //   1903: iload_1
    //   1904: ifeq +10 -> 1914
    //   1907: sipush 3000
    //   1910: istore_1
    //   1911: goto +1676 -> 3587
    //   1914: sipush 1000
    //   1917: istore_1
    //   1918: goto +1669 -> 3587
    //   1921: aload 20
    //   1923: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   1926: iconst_0
    //   1927: invokevirtual 445	com/tencent/hlyyb/downloader/e/d/c:a	(Z)Z
    //   1930: istore 14
    //   1932: iload 14
    //   1934: ifeq +140 -> 2074
    //   1937: aload 15
    //   1939: astore 17
    //   1941: aload 15
    //   1943: astore 18
    //   1945: aload 15
    //   1947: invokevirtual 447	com/tencent/hlyyb/downloader/a/a/a:n	()Ljava/util/List;
    //   1950: astore 16
    //   1952: aload 16
    //   1954: ifnull +120 -> 2074
    //   1957: aload 15
    //   1959: astore 17
    //   1961: aload 15
    //   1963: astore 18
    //   1965: aload 16
    //   1967: invokeinterface 134 1 0
    //   1972: ifle +102 -> 2074
    //   1975: aload 15
    //   1977: astore 17
    //   1979: aload 15
    //   1981: astore 18
    //   1983: aload 16
    //   1985: invokeinterface 242 1 0
    //   1990: astore 16
    //   1992: aload 15
    //   1994: astore 17
    //   1996: aload 15
    //   1998: astore 18
    //   2000: aload 16
    //   2002: invokeinterface 247 1 0
    //   2007: ifeq +50 -> 2057
    //   2010: aload 15
    //   2012: astore 17
    //   2014: aload 15
    //   2016: astore 18
    //   2018: aload 16
    //   2020: invokeinterface 251 1 0
    //   2025: checkcast 449	java/lang/String
    //   2028: astore 21
    //   2030: aload 15
    //   2032: astore 17
    //   2034: aload 15
    //   2036: astore 18
    //   2038: aload 20
    //   2040: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   2043: invokestatic 330	com/tencent/hlyyb/common/a/a:b	()Ljava/lang/String;
    //   2046: aload 21
    //   2048: getstatic 450	com/tencent/hlyyb/downloader/e/d/b:e	I
    //   2051: invokevirtual 453	com/tencent/hlyyb/downloader/e/d/c:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2054: goto -62 -> 1992
    //   2057: aload 15
    //   2059: astore 17
    //   2061: aload 15
    //   2063: astore 18
    //   2065: aload 20
    //   2067: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   2070: iconst_0
    //   2071: invokevirtual 455	com/tencent/hlyyb/downloader/e/d/c:b	(Z)V
    //   2074: aload 20
    //   2076: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   2079: istore 14
    //   2081: iload 14
    //   2083: ifne +42 -> 2125
    //   2086: aload 15
    //   2088: astore 17
    //   2090: aload 15
    //   2092: astore 18
    //   2094: aload 20
    //   2096: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   2099: ifnull +26 -> 2125
    //   2102: aload 15
    //   2104: astore 17
    //   2106: aload 15
    //   2108: astore 18
    //   2110: aload 20
    //   2112: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   2115: invokeinterface 179 1 0
    //   2120: istore 14
    //   2122: goto +6 -> 2128
    //   2125: iconst_1
    //   2126: istore 14
    //   2128: iload 14
    //   2130: ifeq +45 -> 2175
    //   2133: aload 20
    //   2135: iconst_0
    //   2136: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2139: aload 20
    //   2141: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2144: aload 20
    //   2146: invokeinterface 375 2 0
    //   2151: aload 20
    //   2153: aconst_null
    //   2154: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2157: aload 20
    //   2159: aload 15
    //   2161: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2164: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2167: aload 15
    //   2169: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2172: goto +1349 -> 3521
    //   2175: aload 20
    //   2177: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2180: astore 16
    //   2182: aload 20
    //   2184: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   2187: astore 17
    //   2189: aload 15
    //   2191: invokevirtual 456	com/tencent/hlyyb/downloader/a/a/f:e	()Ljava/lang/String;
    //   2194: astore 18
    //   2196: aload 15
    //   2198: invokevirtual 417	com/tencent/hlyyb/downloader/a/a/f:c	()J
    //   2201: lstore 6
    //   2203: aload 15
    //   2205: invokevirtual 458	com/tencent/hlyyb/downloader/a/a/f:o	()Z
    //   2208: istore 14
    //   2210: aload 15
    //   2212: invokevirtual 424	com/tencent/hlyyb/downloader/a/a/f:k	()Ljava/lang/String;
    //   2215: astore 21
    //   2217: aload 15
    //   2219: invokevirtual 428	com/tencent/hlyyb/downloader/a/a/f:l	()Ljava/lang/String;
    //   2222: astore 22
    //   2224: aload 15
    //   2226: invokevirtual 420	com/tencent/hlyyb/downloader/a/a/f:h	()Ljava/lang/String;
    //   2229: astore 23
    //   2231: aload 15
    //   2233: invokevirtual 460	com/tencent/hlyyb/downloader/a/a/f:m	()Ljava/lang/String;
    //   2236: astore 24
    //   2238: aload 16
    //   2240: aload_0
    //   2241: aload 17
    //   2243: aload 18
    //   2245: lload 6
    //   2247: iload 14
    //   2249: aload 21
    //   2251: aload 22
    //   2253: aload 23
    //   2255: aload 24
    //   2257: invokeinterface 463 11 0
    //   2262: astore 16
    //   2264: aload 20
    //   2266: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   2269: istore 14
    //   2271: iload 14
    //   2273: ifne +48 -> 2321
    //   2276: aload 20
    //   2278: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   2281: ifnull +40 -> 2321
    //   2284: aload 20
    //   2286: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   2289: invokeinterface 179 1 0
    //   2294: istore 14
    //   2296: goto +28 -> 2324
    //   2299: astore 16
    //   2301: aload 15
    //   2303: astore 17
    //   2305: aload 16
    //   2307: astore 15
    //   2309: aload 17
    //   2311: astore 16
    //   2313: goto +1158 -> 3471
    //   2316: astore 16
    //   2318: goto +1054 -> 3372
    //   2321: iconst_1
    //   2322: istore 14
    //   2324: iload 14
    //   2326: ifeq +45 -> 2371
    //   2329: aload 20
    //   2331: iconst_0
    //   2332: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2335: aload 20
    //   2337: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2340: aload 20
    //   2342: invokeinterface 375 2 0
    //   2347: aload 20
    //   2349: aconst_null
    //   2350: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2353: aload 20
    //   2355: aload 15
    //   2357: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2360: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2363: aload 15
    //   2365: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2368: goto +1153 -> 3521
    //   2371: aload 19
    //   2373: aload 16
    //   2375: getfield 466	com/tencent/hlyyb/common/a/f:a	I
    //   2378: putfield 468	com/tencent/hlyyb/downloader/e/c/d:n	I
    //   2381: aload 16
    //   2383: getfield 466	com/tencent/hlyyb/common/a/f:a	I
    //   2386: ifne +337 -> 2723
    //   2389: aload 20
    //   2391: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   2394: istore 13
    //   2396: iload 13
    //   2398: ifne +26 -> 2424
    //   2401: aload 20
    //   2403: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   2406: ifnull +18 -> 2424
    //   2409: aload 20
    //   2411: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   2414: invokeinterface 179 1 0
    //   2419: istore 13
    //   2421: goto +6 -> 2427
    //   2424: iconst_1
    //   2425: istore 13
    //   2427: iload 13
    //   2429: ifeq +45 -> 2474
    //   2432: aload 20
    //   2434: iconst_0
    //   2435: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2438: aload 20
    //   2440: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2443: aload 20
    //   2445: invokeinterface 375 2 0
    //   2450: aload 20
    //   2452: aconst_null
    //   2453: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2456: aload 20
    //   2458: aload 15
    //   2460: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2463: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2466: aload 15
    //   2468: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2471: goto +1050 -> 3521
    //   2474: aload 20
    //   2476: iconst_1
    //   2477: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2480: aload 15
    //   2482: astore 16
    //   2484: aload 16
    //   2486: aload 20
    //   2488: invokevirtual 471	com/tencent/hlyyb/downloader/a/a/f:a	(Lcom/tencent/hlyyb/downloader/a/a/d;)V
    //   2491: aload 20
    //   2493: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   2496: astore 17
    //   2498: aload 20
    //   2500: iconst_0
    //   2501: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2504: aload 17
    //   2506: iconst_0
    //   2507: putfield 349	com/tencent/hlyyb/downloader/e/d/a:f	Z
    //   2510: aload 20
    //   2512: aload 16
    //   2514: invokevirtual 399	com/tencent/hlyyb/downloader/a/a/f:a	()I
    //   2517: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2520: aload 20
    //   2522: aload 16
    //   2524: invokevirtual 400	com/tencent/hlyyb/downloader/a/a/f:b	()Ljava/lang/String;
    //   2527: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   2530: aload 19
    //   2532: aload 20
    //   2534: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2537: putfield 473	com/tencent/hlyyb/downloader/e/c/d:o	I
    //   2540: aload 19
    //   2542: aload 20
    //   2544: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2547: invokevirtual 390	com/tencent/hlyyb/downloader/e/b/a:toString	()Ljava/lang/String;
    //   2550: putfield 474	com/tencent/hlyyb/downloader/e/c/d:p	Ljava/lang/String;
    //   2553: aload 19
    //   2555: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   2558: lload 10
    //   2560: lsub
    //   2561: putfield 476	com/tencent/hlyyb/downloader/e/c/d:q	J
    //   2564: aload 20
    //   2566: getfield 96	com/tencent/hlyyb/downloader/e/b/c:v	Z
    //   2569: ifne +141 -> 2710
    //   2572: aload 20
    //   2574: getfield 168	com/tencent/hlyyb/downloader/e/b/c:t	Ljava/util/Map;
    //   2577: aload 20
    //   2579: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   2582: invokeinterface 151 2 0
    //   2587: checkcast 130	java/util/List
    //   2590: astore 17
    //   2592: aload 17
    //   2594: astore 16
    //   2596: aload 17
    //   2598: ifnonnull +33 -> 2631
    //   2601: new 237	java/util/ArrayList
    //   2604: dup
    //   2605: invokespecial 238	java/util/ArrayList:<init>	()V
    //   2608: invokestatic 482	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   2611: astore 16
    //   2613: aload 20
    //   2615: getfield 168	com/tencent/hlyyb/downloader/e/b/c:t	Ljava/util/Map;
    //   2618: aload 20
    //   2620: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   2623: aload 16
    //   2625: invokeinterface 197 3 0
    //   2630: pop
    //   2631: aload 20
    //   2633: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2636: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   2639: aload 20
    //   2641: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2644: getfield 483	com/tencent/hlyyb/downloader/e/b/a:d	J
    //   2647: lcmp
    //   2648: ifle +62 -> 2710
    //   2651: new 281	java/lang/StringBuilder
    //   2654: dup
    //   2655: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   2658: astore 17
    //   2660: aload 17
    //   2662: aload 20
    //   2664: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2667: getfield 483	com/tencent/hlyyb/downloader/e/b/a:d	J
    //   2670: invokevirtual 486	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2673: pop
    //   2674: aload 17
    //   2676: ldc_w 292
    //   2679: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2682: pop
    //   2683: aload 17
    //   2685: aload 20
    //   2687: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2690: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   2693: invokevirtual 486	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2696: pop
    //   2697: aload 16
    //   2699: aload 17
    //   2701: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2704: invokeinterface 193 2 0
    //   2709: pop
    //   2710: aload 20
    //   2712: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2715: ifeq +881 -> 3596
    //   2718: iconst_1
    //   2719: istore_2
    //   2720: goto +878 -> 3598
    //   2723: aload 16
    //   2725: getfield 466	com/tencent/hlyyb/common/a/f:a	I
    //   2728: ifge +880 -> 3608
    //   2731: aload 20
    //   2733: aload 16
    //   2735: getfield 466	com/tencent/hlyyb/common/a/f:a	I
    //   2738: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2741: aload 20
    //   2743: aload 16
    //   2745: getfield 487	com/tencent/hlyyb/common/a/f:b	Ljava/lang/String;
    //   2748: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   2751: iload 13
    //   2753: istore 12
    //   2755: sipush 1000
    //   2758: istore_1
    //   2759: iconst_1
    //   2760: istore_2
    //   2761: goto +830 -> 3591
    //   2764: aload 15
    //   2766: astore 16
    //   2768: iload_3
    //   2769: ifeq +476 -> 3245
    //   2772: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   2775: lstore 6
    //   2777: lload 6
    //   2779: lload 4
    //   2781: lsub
    //   2782: lstore 6
    //   2784: lload 6
    //   2786: ldc2_w 488
    //   2789: lcmp
    //   2790: ifle +45 -> 2835
    //   2793: aload 20
    //   2795: iconst_0
    //   2796: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2799: aload 20
    //   2801: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2804: aload 20
    //   2806: invokeinterface 375 2 0
    //   2811: aload 20
    //   2813: aconst_null
    //   2814: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2817: aload 20
    //   2819: aload 16
    //   2821: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2824: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2827: aload 16
    //   2829: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2832: goto +689 -> 3521
    //   2835: aload 20
    //   2837: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2840: istore_3
    //   2841: iload_3
    //   2842: bipush 240
    //   2844: if_icmpeq +23 -> 2867
    //   2847: iload_3
    //   2848: bipush 241
    //   2850: if_icmpeq +17 -> 2867
    //   2853: iload_3
    //   2854: bipush 179
    //   2856: if_icmpne +6 -> 2862
    //   2859: goto +8 -> 2867
    //   2862: iconst_0
    //   2863: istore_3
    //   2864: goto +5 -> 2869
    //   2867: iconst_1
    //   2868: istore_3
    //   2869: iload_3
    //   2870: ifeq +54 -> 2924
    //   2873: lload 6
    //   2875: ldc2_w 490
    //   2878: lcmp
    //   2879: ifle +45 -> 2924
    //   2882: aload 20
    //   2884: iconst_0
    //   2885: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2888: aload 20
    //   2890: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2893: aload 20
    //   2895: invokeinterface 375 2 0
    //   2900: aload 20
    //   2902: aconst_null
    //   2903: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2906: aload 20
    //   2908: aload 16
    //   2910: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2913: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2916: aload 16
    //   2918: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2921: goto +600 -> 3521
    //   2924: aload 20
    //   2926: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2929: istore_3
    //   2930: iload_3
    //   2931: bipush 180
    //   2933: if_icmpeq +105 -> 3038
    //   2936: iload_3
    //   2937: bipush 183
    //   2939: if_icmpeq +99 -> 3038
    //   2942: iload_3
    //   2943: bipush 185
    //   2945: if_icmpeq +93 -> 3038
    //   2948: iload_3
    //   2949: bipush 188
    //   2951: if_icmpeq +87 -> 3038
    //   2954: iload_3
    //   2955: bipush 205
    //   2957: if_icmpeq +81 -> 3038
    //   2960: iload_3
    //   2961: bipush 212
    //   2963: if_icmpeq +75 -> 3038
    //   2966: iload_3
    //   2967: bipush 213
    //   2969: if_icmpeq +69 -> 3038
    //   2972: iload_3
    //   2973: bipush 245
    //   2975: if_icmpeq +63 -> 3038
    //   2978: iload_3
    //   2979: bipush 246
    //   2981: if_icmpeq +57 -> 3038
    //   2984: iload_3
    //   2985: tableswitch	default:+27 -> 3012, -56:+53->3038, -55:+53->3038, -54:+53->3038
    //   3013: ifle +20 -> 3033
    //   3016: iload_3
    //   3017: sipush 200
    //   3020: if_icmpeq +13 -> 3033
    //   3023: iload_3
    //   3024: sipush 206
    //   3027: if_icmpeq +6 -> 3033
    //   3030: goto +8 -> 3038
    //   3033: iconst_0
    //   3034: istore_3
    //   3035: goto +5 -> 3040
    //   3038: iconst_1
    //   3039: istore_3
    //   3040: iload_3
    //   3041: ifeq +54 -> 3095
    //   3044: lload 6
    //   3046: ldc2_w 492
    //   3049: lcmp
    //   3050: ifle +45 -> 3095
    //   3053: aload 20
    //   3055: iconst_0
    //   3056: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   3059: aload 20
    //   3061: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   3064: aload 20
    //   3066: invokeinterface 375 2 0
    //   3071: aload 20
    //   3073: aconst_null
    //   3074: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   3077: aload 20
    //   3079: aload 16
    //   3081: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   3084: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   3087: aload 16
    //   3089: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   3092: goto +429 -> 3521
    //   3095: aload 20
    //   3097: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   3100: bipush 241
    //   3102: if_icmpne +57 -> 3159
    //   3105: invokestatic 497	com/tencent/hlyyb/downloader/a/a:d	()I
    //   3108: istore_3
    //   3109: lload 6
    //   3111: iload_3
    //   3112: i2l
    //   3113: lcmp
    //   3114: ifle +45 -> 3159
    //   3117: aload 20
    //   3119: iconst_0
    //   3120: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   3123: aload 20
    //   3125: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   3128: aload 20
    //   3130: invokeinterface 375 2 0
    //   3135: aload 20
    //   3137: aconst_null
    //   3138: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   3141: aload 20
    //   3143: aload 16
    //   3145: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   3148: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   3151: aload 16
    //   3153: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   3156: goto +365 -> 3521
    //   3159: aload 20
    //   3161: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   3164: bipush 205
    //   3166: if_icmpne +79 -> 3245
    //   3169: aload 20
    //   3171: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   3174: getfield 337	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   3177: getstatic 340	com/tencent/hlyyb/downloader/e/d/b:b	I
    //   3180: if_icmpne +65 -> 3245
    //   3183: ldc2_w 498
    //   3186: invokestatic 502	android/os/SystemClock:sleep	(J)V
    //   3189: aload 20
    //   3191: iconst_0
    //   3192: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   3195: aload 20
    //   3197: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   3200: aload 20
    //   3202: invokeinterface 375 2 0
    //   3207: aload 20
    //   3209: aconst_null
    //   3210: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   3213: aload 20
    //   3215: aload 16
    //   3217: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   3220: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   3223: aload 16
    //   3225: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   3228: goto +293 -> 3521
    //   3231: aload 15
    //   3233: astore 16
    //   3235: astore 15
    //   3237: goto -2470 -> 767
    //   3240: astore 16
    //   3242: goto +78 -> 3320
    //   3245: aload 20
    //   3247: iconst_0
    //   3248: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   3251: aload 20
    //   3253: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   3256: aload 20
    //   3258: invokeinterface 375 2 0
    //   3263: aload 20
    //   3265: aconst_null
    //   3266: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   3269: aload 20
    //   3271: aload 16
    //   3273: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   3276: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   3279: aload 16
    //   3281: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   3284: goto -3259 -> 25
    //   3287: astore 17
    //   3289: aload 15
    //   3291: astore 16
    //   3293: aload 17
    //   3295: astore 15
    //   3297: goto -2530 -> 767
    //   3300: astore 16
    //   3302: goto +18 -> 3320
    //   3305: astore 17
    //   3307: aload 15
    //   3309: astore 16
    //   3311: aload 17
    //   3313: astore 15
    //   3315: goto -2548 -> 767
    //   3318: astore 16
    //   3320: goto +52 -> 3372
    //   3323: astore 15
    //   3325: goto +146 -> 3471
    //   3328: astore 15
    //   3330: aload 16
    //   3332: astore 17
    //   3334: aload 15
    //   3336: astore 16
    //   3338: aload 17
    //   3340: astore 15
    //   3342: goto +30 -> 3372
    //   3345: astore 15
    //   3347: goto +10 -> 3357
    //   3350: astore 15
    //   3352: goto +13 -> 3365
    //   3355: astore 15
    //   3357: aconst_null
    //   3358: astore 16
    //   3360: goto +111 -> 3471
    //   3363: astore 15
    //   3365: aload 15
    //   3367: astore 16
    //   3369: aconst_null
    //   3370: astore 15
    //   3372: aload_0
    //   3373: astore 17
    //   3375: aload 16
    //   3377: invokevirtual 322	java/lang/Throwable:printStackTrace	()V
    //   3380: aload 17
    //   3382: bipush 195
    //   3384: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   3387: new 281	java/lang/StringBuilder
    //   3390: dup
    //   3391: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   3394: astore 18
    //   3396: aload 18
    //   3398: aload 16
    //   3400: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3403: pop
    //   3404: aload 17
    //   3406: aload 18
    //   3408: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3411: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   3414: aload 17
    //   3416: iconst_0
    //   3417: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   3420: aload 17
    //   3422: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   3425: aload 17
    //   3427: invokeinterface 375 2 0
    //   3432: aload 17
    //   3434: aconst_null
    //   3435: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   3438: aload 15
    //   3440: ifnull +81 -> 3521
    //   3443: aload 17
    //   3445: aload 15
    //   3447: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   3450: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   3453: aload 15
    //   3455: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   3458: goto +63 -> 3521
    //   3461: astore 17
    //   3463: aload 15
    //   3465: astore 16
    //   3467: aload 17
    //   3469: astore 15
    //   3471: aload_0
    //   3472: astore 17
    //   3474: aload 17
    //   3476: iconst_0
    //   3477: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   3480: aload 17
    //   3482: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   3485: aload 17
    //   3487: invokeinterface 375 2 0
    //   3492: aload 17
    //   3494: aconst_null
    //   3495: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   3498: aload 16
    //   3500: ifnull +18 -> 3518
    //   3503: aload 17
    //   3505: aload 16
    //   3507: invokevirtual 377	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   3510: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   3513: aload 16
    //   3515: invokevirtual 379	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   3518: aload 15
    //   3520: athrow
    //   3521: aload_0
    //   3522: astore 15
    //   3524: aload 15
    //   3526: iconst_1
    //   3527: putfield 83	com/tencent/hlyyb/downloader/e/b/c:l	Z
    //   3530: aload 15
    //   3532: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   3535: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   3538: aload 15
    //   3540: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   3543: getfield 310	com/tencent/hlyyb/downloader/e/c/c:b	J
    //   3546: lsub
    //   3547: putfield 506	com/tencent/hlyyb/downloader/e/c/c:c	J
    //   3550: aload 15
    //   3552: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   3555: aload 15
    //   3557: invokeinterface 508 2 0
    //   3562: return
    //   3563: astore 15
    //   3565: aload 15
    //   3567: invokevirtual 322	java/lang/Throwable:printStackTrace	()V
    //   3570: return
    //   3571: iconst_1
    //   3572: istore_2
    //   3573: lload 8
    //   3575: lload 6
    //   3577: lsub
    //   3578: ldc2_w 492
    //   3581: lcmp
    //   3582: ifle -1721 -> 1861
    //   3585: iconst_0
    //   3586: istore_1
    //   3587: iload 13
    //   3589: istore 12
    //   3591: iconst_1
    //   3592: istore_3
    //   3593: goto -829 -> 2764
    //   3596: iconst_0
    //   3597: istore_2
    //   3598: iconst_0
    //   3599: istore_1
    //   3600: lconst_0
    //   3601: lstore 4
    //   3603: iconst_0
    //   3604: istore_3
    //   3605: goto -841 -> 2764
    //   3608: iload 13
    //   3610: istore 12
    //   3612: sipush 1000
    //   3615: istore_1
    //   3616: iconst_0
    //   3617: istore_2
    //   3618: goto -27 -> 3591
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3621	0	this	c
    //   19	3597	1	i1	int
    //   21	3597	2	i2	int
    //   356	3249	3	i3	int
    //   16	3586	4	l1	long
    //   304	3272	6	l2	long
    //   686	2888	8	l3	long
    //   13	2546	10	l4	long
    //   23	3588	12	bool1	boolean
    //   55	3554	13	bool2	boolean
    //   396	1929	14	bool3	boolean
    //   41	8	15	localb	com.tencent.hlyyb.downloader.a.b
    //   138	3	15	localException	Exception
    //   148	3	15	localThrowable1	Throwable
    //   168	394	15	localObject1	Object
    //   624	1	15	localObject2	Object
    //   635	105	15	locala	a
    //   762	1	15	localObject3	Object
    //   773	61	15	localb1	com.tencent.hlyyb.downloader.a.a.b
    //   904	1	15	localObject4	Object
    //   917	877	15	localObject5	Object
    //   1798	1	15	localObject6	Object
    //   1803	7	15	localThrowable2	Throwable
    //   1815	1417	15	localObject7	Object
    //   3235	55	15	localObject8	Object
    //   3295	19	15	localObject9	Object
    //   3323	1	15	localObject10	Object
    //   3328	7	15	localThrowable3	Throwable
    //   3340	1	15	localObject11	Object
    //   3345	1	15	localObject12	Object
    //   3350	1	15	localThrowable4	Throwable
    //   3355	1	15	localObject13	Object
    //   3363	3	15	localThrowable5	Throwable
    //   3370	186	15	localObject14	Object
    //   3563	3	15	localThrowable6	Throwable
    //   26	200	16	localc1	c
    //   238	358	16	localc2	c
    //   627	1	16	localObject15	Object
    //   632	27	16	localThrowable7	Throwable
    //   765	1	16	localObject16	Object
    //   770	1	16	localThrowable8	Throwable
    //   802	107	16	localObject17	Object
    //   913	453	16	localThrowable9	Throwable
    //   1399	864	16	localObject18	Object
    //   2299	7	16	localObject19	Object
    //   2311	1	16	localObject20	Object
    //   2316	66	16	localThrowable10	Throwable
    //   2482	752	16	localObject21	Object
    //   3240	40	16	localThrowable11	Throwable
    //   3291	1	16	localObject22	Object
    //   3300	1	16	localThrowable12	Throwable
    //   3309	1	16	localObject23	Object
    //   3318	13	16	localThrowable13	Throwable
    //   3336	178	16	localObject24	Object
    //   243	3	17	localInterruptedException	java.lang.InterruptedException
    //   809	1891	17	localObject25	Object
    //   3287	7	17	localObject26	Object
    //   3305	7	17	localObject27	Object
    //   3332	112	17	localObject28	Object
    //   3461	7	17	localObject29	Object
    //   3472	32	17	localc3	c
    //   871	2536	18	localObject30	Object
    //   1320	1234	19	localObject31	Object
    //   795	2475	20	localc4	c
    //   1016	1234	21	localObject32	Object
    //   2222	30	22	str1	String
    //   2229	25	23	str2	String
    //   2236	20	24	str3	String
    // Exception table:
    //   from	to	target	type
    //   87	135	138	java/lang/Exception
    //   68	87	148	java/lang/Throwable
    //   87	135	148	java/lang/Throwable
    //   140	145	148	java/lang/Throwable
    //   225	235	238	finally
    //   245	250	238	finally
    //   250	253	238	finally
    //   256	259	238	finally
    //   225	235	243	java/lang/InterruptedException
    //   608	613	624	finally
    //   697	704	624	finally
    //   608	613	632	java/lang/Throwable
    //   697	704	632	java/lang/Throwable
    //   681	688	762	finally
    //   722	746	762	finally
    //   681	688	770	java/lang/Throwable
    //   722	746	770	java/lang/Throwable
    //   873	881	904	finally
    //   889	901	904	finally
    //   1089	1097	904	finally
    //   1105	1117	904	finally
    //   1348	1361	904	finally
    //   1369	1401	904	finally
    //   1843	1853	904	finally
    //   1869	1875	904	finally
    //   1945	1952	904	finally
    //   1965	1975	904	finally
    //   1983	1992	904	finally
    //   2000	2010	904	finally
    //   2018	2030	904	finally
    //   2038	2054	904	finally
    //   2065	2074	904	finally
    //   2094	2102	904	finally
    //   2110	2122	904	finally
    //   873	881	913	java/lang/Throwable
    //   889	901	913	java/lang/Throwable
    //   1089	1097	913	java/lang/Throwable
    //   1105	1117	913	java/lang/Throwable
    //   1348	1361	913	java/lang/Throwable
    //   1369	1401	913	java/lang/Throwable
    //   1843	1853	913	java/lang/Throwable
    //   1869	1875	913	java/lang/Throwable
    //   1945	1952	913	java/lang/Throwable
    //   1965	1975	913	java/lang/Throwable
    //   1983	1992	913	java/lang/Throwable
    //   2000	2010	913	java/lang/Throwable
    //   2018	2030	913	java/lang/Throwable
    //   2038	2054	913	java/lang/Throwable
    //   2065	2074	913	java/lang/Throwable
    //   2094	2102	913	java/lang/Throwable
    //   2110	2122	913	java/lang/Throwable
    //   1401	1436	1798	finally
    //   1489	1606	1798	finally
    //   1659	1791	1798	finally
    //   1401	1436	1803	java/lang/Throwable
    //   1489	1606	1803	java/lang/Throwable
    //   1659	1791	1803	java/lang/Throwable
    //   2276	2296	2299	finally
    //   2401	2421	2299	finally
    //   2276	2296	2316	java/lang/Throwable
    //   2401	2421	2316	java/lang/Throwable
    //   2484	2592	3231	finally
    //   2601	2631	3231	finally
    //   2631	2710	3231	finally
    //   2710	2718	3231	finally
    //   2723	2751	3231	finally
    //   2772	2777	3231	finally
    //   2835	2841	3231	finally
    //   2924	2930	3231	finally
    //   3095	3109	3231	finally
    //   3159	3189	3231	finally
    //   2484	2592	3240	java/lang/Throwable
    //   2601	2631	3240	java/lang/Throwable
    //   2631	2710	3240	java/lang/Throwable
    //   2710	2718	3240	java/lang/Throwable
    //   2723	2751	3240	java/lang/Throwable
    //   2772	2777	3240	java/lang/Throwable
    //   2835	2841	3240	java/lang/Throwable
    //   2924	2930	3240	java/lang/Throwable
    //   3095	3109	3240	java/lang/Throwable
    //   3159	3189	3240	java/lang/Throwable
    //   2238	2271	3287	finally
    //   2371	2396	3287	finally
    //   2474	2480	3287	finally
    //   2238	2271	3300	java/lang/Throwable
    //   2371	2396	3300	java/lang/Throwable
    //   2474	2480	3300	java/lang/Throwable
    //   1820	1831	3305	finally
    //   1921	1932	3305	finally
    //   2074	2081	3305	finally
    //   2175	2238	3305	finally
    //   1820	1831	3318	java/lang/Throwable
    //   1921	1932	3318	java/lang/Throwable
    //   2074	2081	3318	java/lang/Throwable
    //   2175	2238	3318	java/lang/Throwable
    //   846	860	3323	finally
    //   972	1076	3323	finally
    //   1170	1318	3323	finally
    //   846	860	3328	java/lang/Throwable
    //   972	1076	3328	java/lang/Throwable
    //   1170	1318	3328	java/lang/Throwable
    //   778	794	3345	finally
    //   778	794	3350	java/lang/Throwable
    //   651	677	3355	finally
    //   797	821	3355	finally
    //   825	846	3355	finally
    //   651	677	3363	java/lang/Throwable
    //   797	821	3363	java/lang/Throwable
    //   825	846	3363	java/lang/Throwable
    //   3375	3414	3461	finally
    //   3550	3562	3563	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.b.c
 * JD-Core Version:    0.7.0.1
 */