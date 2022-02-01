package com.tencent.hlyyb.downloader.b;

import android.os.SystemClock;
import com.tencent.hlyyb.downloader.a.a.f;
import com.tencent.hlyyb.downloader.e.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class c
  implements Runnable
{
  private static AtomicInteger i = new AtomicInteger(1);
  public boolean a;
  public com.tencent.hlyyb.downloader.e.d.a b;
  public volatile boolean c = false;
  public volatile boolean d = false;
  public volatile boolean e = false;
  public com.tencent.hlyyb.common.a.e f;
  public e g = new e();
  public long h = 0L;
  private List<c> j;
  private i k;
  private d l;
  private com.tencent.hlyyb.downloader.e.d.c m;
  private f n;
  private List<com.tencent.hlyyb.downloader.d.a> o;
  private int p = -88;
  private boolean q = false;
  private AtomicInteger r;
  private AtomicInteger s;
  private int t = -1;
  private int u = -1;
  
  public c(i parami, com.tencent.hlyyb.downloader.e.d.c paramc, com.tencent.hlyyb.downloader.e.d.a parama, List<c> paramList, Map<com.tencent.hlyyb.downloader.e.d.a, c> paramMap, d paramd, boolean paramBoolean, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2)
  {
    this.k = parami;
    this.m = paramc;
    this.o = paramc.d();
    this.b = parama;
    this.j = paramList;
    this.l = paramd;
    this.q = paramBoolean;
    this.s = paramAtomicInteger1;
    this.r = paramAtomicInteger2;
  }
  
  private void a(List<byte[]> paramList, String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramList.size() > 0)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramList.next();
        localByteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
      }
      paramList = localByteArrayOutputStream.toByteArray();
    }
    try
    {
      localByteArrayOutputStream.close();
      label70:
      if (com.tencent.hlyyb.common.b.b.a(paramList))
      {
        this.p = 6;
        return;
      }
      int i1;
      if (!paramString.toLowerCase().equals(com.tencent.hlyyb.common.b.a.a(paramList).toLowerCase()))
      {
        i1 = -1;
      }
      else
      {
        this.p = 0;
        return;
        i1 = 3;
      }
      this.p = i1;
      return;
    }
    catch (IOException localIOException)
    {
      break label70;
    }
  }
  
  private byte[] a(com.tencent.hlyyb.downloader.e.d.a parama, com.tencent.hlyyb.downloader.a.a.b paramb)
  {
    byte[] arrayOfByte = null;
    int i1 = 0;
    Object localObject;
    for (;;)
    {
      localObject = arrayOfByte;
      if (i1 >= 2) {
        break;
      }
      localObject = this.k;
      boolean bool = this.a;
      int i3 = 1;
      this.n = new f(parama, null, paramb, false, (com.tencent.hlyyb.downloader.a.b)localObject, bool ^ true, 2);
      this.n.p();
      int i4 = this.n.a();
      localObject = this.g.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i4);
      ((List)localObject).add(localStringBuilder.toString());
      if (i4 == 0)
      {
        arrayOfByte = this.n.q();
      }
      else if (i4 == -74)
      {
        this.p = 7;
        arrayOfByte = null;
      }
      int i2 = i3;
      if (i4 != 0)
      {
        i2 = i3;
        if (i4 != -66)
        {
          i2 = i3;
          if (i4 != -15) {
            if (i4 == -16) {
              i2 = i3;
            } else {
              i2 = 0;
            }
          }
        }
      }
      localObject = arrayOfByte;
      if (i2 != 0) {
        break;
      }
      SystemClock.sleep(50L);
      i1 += 1;
    }
    return localObject;
  }
  
  private void d()
  {
    int i2 = this.b.b;
    int i3 = com.tencent.hlyyb.downloader.e.d.b.j;
    int i1 = 0;
    if (i2 == i3)
    {
      this.p = 0;
      return;
    }
    ArrayList localArrayList = new ArrayList();
    List localList = f();
    if (localList != null)
    {
      String str = this.m.c();
      while (i1 < localList.size())
      {
        byte[] arrayOfByte = a(this.b, (com.tencent.hlyyb.downloader.a.a.b)localList.get(i1));
        if (arrayOfByte != null)
        {
          localArrayList.add(arrayOfByte);
          i1 += 1;
        }
        else
        {
          if (this.p != 7) {
            this.p = 4;
          }
          return;
        }
      }
      a(localArrayList, str);
      return;
    }
    this.p = 2;
  }
  
  private List<c> e()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.j)
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.c) {
          localArrayList.add(localc);
        }
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private List<com.tencent.hlyyb.downloader.a.a.b> f()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i1 >= this.o.size()) {
        break label105;
      }
      localObject = (com.tencent.hlyyb.downloader.d.a)this.o.get(i1);
      long l1 = ((com.tencent.hlyyb.downloader.d.a)localObject).a;
      long l2 = ((com.tencent.hlyyb.downloader.d.a)localObject).b + l1 - 1L;
      if ((l1 < 0L) || (l1 > l2)) {
        break;
      }
      localArrayList.add(new com.tencent.hlyyb.downloader.a.a.b(l1, l2));
      i1 += 1;
    }
    Object localObject = null;
    label105:
    return localObject;
  }
  
  public final void a()
  {
    this.e = true;
    try
    {
      if (this.n != null) {
        this.n.s();
      }
      if (this.f != null) {
        this.f.a();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.t = paramInt1;
    this.u = paramInt2;
    e locale = this.g;
    locale.b = paramInt1;
    locale.d = paramInt2;
  }
  
  public final void a(String paramString)
  {
    this.g.j.add(paramString);
  }
  
  public final String b()
  {
    int i1;
    if (this.p == -1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = "";
    if ((i1 != 0) || (this.p == 7))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.t);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.b.c);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.u);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(com.tencent.hlyyb.common.b.b.b(this.n.e()));
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public final void b(String paramString)
  {
    this.g.l.add(paramString);
  }
  
  public final void c()
  {
    this.g.k = -1;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 177	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 272
    //   7: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: getstatic 51	com/tencent/hlyyb/downloader/b/c:i	Ljava/util/concurrent/atomic/AtomicInteger;
    //   13: invokevirtual 277	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   16: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   23: lstore_3
    //   24: aload_0
    //   25: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   28: istore 5
    //   30: iload 5
    //   32: ifeq +202 -> 234
    //   35: aload_0
    //   36: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   39: ifeq +17 -> 56
    //   42: aload_0
    //   43: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   46: bipush 168
    //   48: if_icmpne +8 -> 56
    //   51: aload_0
    //   52: iconst_5
    //   53: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   56: aload_0
    //   57: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   60: aload_0
    //   61: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   64: getfield 258	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   67: putfield 282	com/tencent/hlyyb/downloader/b/e:c	I
    //   70: aload_0
    //   71: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   74: astore 6
    //   76: aload 6
    //   78: aload_0
    //   79: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   82: putfield 284	com/tencent/hlyyb/downloader/b/e:f	I
    //   85: aload 6
    //   87: ldc 251
    //   89: putfield 287	com/tencent/hlyyb/downloader/b/e:g	Ljava/lang/String;
    //   92: aload 6
    //   94: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   97: lload_3
    //   98: lsub
    //   99: l2i
    //   100: putfield 289	com/tencent/hlyyb/downloader/b/e:h	I
    //   103: aload_0
    //   104: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   107: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   110: aload_0
    //   111: getfield 76	com/tencent/hlyyb/downloader/b/c:h	J
    //   114: lsub
    //   115: l2i
    //   116: putfield 291	com/tencent/hlyyb/downloader/b/e:i	I
    //   119: aload_0
    //   120: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   123: aload_0
    //   124: getfield 95	com/tencent/hlyyb/downloader/b/c:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   127: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   130: putfield 296	com/tencent/hlyyb/downloader/b/e:a	I
    //   133: aload_0
    //   134: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   137: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   140: astore 7
    //   142: aload_0
    //   143: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   146: astore 6
    //   148: aload 6
    //   150: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   153: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne +13 -> 169
    //   159: aload 6
    //   161: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   164: astore 6
    //   166: goto +10 -> 176
    //   169: aload 6
    //   171: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   174: astore 6
    //   176: aload 7
    //   178: aload 6
    //   180: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifne +50 -> 233
    //   186: aload_0
    //   187: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   190: astore 7
    //   192: aload_0
    //   193: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   196: astore 6
    //   198: aload 6
    //   200: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   203: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   206: ifne +13 -> 219
    //   209: aload 6
    //   211: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   214: astore 6
    //   216: goto +10 -> 226
    //   219: aload 6
    //   221: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   224: astore 6
    //   226: aload 7
    //   228: aload 6
    //   230: putfield 308	com/tencent/hlyyb/downloader/b/e:m	Ljava/lang/String;
    //   233: return
    //   234: aload_0
    //   235: invokespecial 310	com/tencent/hlyyb/downloader/b/c:d	()V
    //   238: aload_0
    //   239: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   242: ifne +199 -> 441
    //   245: aload_0
    //   246: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   249: istore_1
    //   250: iconst_0
    //   251: istore_2
    //   252: iload_1
    //   253: ifne +17 -> 270
    //   256: aload_0
    //   257: getfield 80	com/tencent/hlyyb/downloader/b/c:m	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   260: aload_0
    //   261: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   264: invokevirtual 313	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/a;)V
    //   267: goto +33 -> 300
    //   270: aload_0
    //   271: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   274: iconst_m1
    //   275: if_icmpne +854 -> 1129
    //   278: iconst_1
    //   279: istore_1
    //   280: goto +3 -> 283
    //   283: iload_1
    //   284: ifeq +16 -> 300
    //   287: aload_0
    //   288: iconst_1
    //   289: putfield 57	com/tencent/hlyyb/downloader/b/c:c	Z
    //   292: aload_0
    //   293: getfield 97	com/tencent/hlyyb/downloader/b/c:r	Ljava/util/concurrent/atomic/AtomicInteger;
    //   296: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   299: pop
    //   300: aload_0
    //   301: getfield 65	com/tencent/hlyyb/downloader/b/c:q	Z
    //   304: ifne +103 -> 407
    //   307: aload_0
    //   308: getfield 80	com/tencent/hlyyb/downloader/b/c:m	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   311: invokevirtual 315	com/tencent/hlyyb/downloader/e/d/c:e	()I
    //   314: ifle +80 -> 394
    //   317: aload_0
    //   318: invokespecial 317	com/tencent/hlyyb/downloader/b/c:e	()Ljava/util/List;
    //   321: astore 6
    //   323: ldc 2
    //   325: monitorenter
    //   326: aload 6
    //   328: invokeinterface 115 1 0
    //   333: astore 6
    //   335: aload 6
    //   337: invokeinterface 121 1 0
    //   342: ifeq +38 -> 380
    //   345: aload 6
    //   347: invokeinterface 125 1 0
    //   352: checkcast 2	com/tencent/hlyyb/downloader/b/c
    //   355: astore 7
    //   357: aload 7
    //   359: iconst_1
    //   360: putfield 59	com/tencent/hlyyb/downloader/b/c:d	Z
    //   363: aload_0
    //   364: getfield 93	com/tencent/hlyyb/downloader/b/c:l	Lcom/tencent/hlyyb/downloader/b/d;
    //   367: aload 7
    //   369: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   372: invokeinterface 320 2 0
    //   377: goto -42 -> 335
    //   380: ldc 2
    //   382: monitorexit
    //   383: goto +58 -> 441
    //   386: astore 6
    //   388: ldc 2
    //   390: monitorexit
    //   391: aload 6
    //   393: athrow
    //   394: aload_0
    //   395: getfield 93	com/tencent/hlyyb/downloader/b/c:l	Lcom/tencent/hlyyb/downloader/b/d;
    //   398: invokeinterface 323 1 0
    //   403: pop
    //   404: goto +37 -> 441
    //   407: iload_2
    //   408: istore_1
    //   409: aload_0
    //   410: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   413: iconst_m1
    //   414: if_icmpne +5 -> 419
    //   417: iconst_1
    //   418: istore_1
    //   419: iload_1
    //   420: ifeq +21 -> 441
    //   423: aload_0
    //   424: iconst_1
    //   425: putfield 59	com/tencent/hlyyb/downloader/b/c:d	Z
    //   428: aload_0
    //   429: getfield 93	com/tencent/hlyyb/downloader/b/c:l	Lcom/tencent/hlyyb/downloader/b/d;
    //   432: aload_0
    //   433: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   436: invokeinterface 320 2 0
    //   441: aload_0
    //   442: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   445: ifeq +17 -> 462
    //   448: aload_0
    //   449: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   452: bipush 168
    //   454: if_icmpne +8 -> 462
    //   457: aload_0
    //   458: iconst_5
    //   459: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   462: aload_0
    //   463: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   466: aload_0
    //   467: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   470: getfield 258	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   473: putfield 282	com/tencent/hlyyb/downloader/b/e:c	I
    //   476: aload_0
    //   477: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   480: astore 6
    //   482: aload 6
    //   484: aload_0
    //   485: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   488: putfield 284	com/tencent/hlyyb/downloader/b/e:f	I
    //   491: aload 6
    //   493: ldc 251
    //   495: putfield 287	com/tencent/hlyyb/downloader/b/e:g	Ljava/lang/String;
    //   498: aload 6
    //   500: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   503: lload_3
    //   504: lsub
    //   505: l2i
    //   506: putfield 289	com/tencent/hlyyb/downloader/b/e:h	I
    //   509: aload_0
    //   510: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   513: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   516: aload_0
    //   517: getfield 76	com/tencent/hlyyb/downloader/b/c:h	J
    //   520: lsub
    //   521: l2i
    //   522: putfield 291	com/tencent/hlyyb/downloader/b/e:i	I
    //   525: aload_0
    //   526: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   529: aload_0
    //   530: getfield 95	com/tencent/hlyyb/downloader/b/c:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   533: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   536: putfield 296	com/tencent/hlyyb/downloader/b/e:a	I
    //   539: aload_0
    //   540: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   543: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   546: astore 7
    //   548: aload_0
    //   549: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   552: astore 6
    //   554: aload 6
    //   556: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   559: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   562: ifne +13 -> 575
    //   565: aload 6
    //   567: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   570: astore 6
    //   572: goto +10 -> 582
    //   575: aload 6
    //   577: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   580: astore 6
    //   582: aload 7
    //   584: aload 6
    //   586: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   589: ifne +332 -> 921
    //   592: aload_0
    //   593: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   596: astore 7
    //   598: aload_0
    //   599: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   602: astore 6
    //   604: aload 6
    //   606: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   609: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   612: ifne +13 -> 625
    //   615: aload 6
    //   617: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   620: astore 6
    //   622: goto +10 -> 632
    //   625: aload 6
    //   627: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   630: astore 6
    //   632: aload 7
    //   634: aload 6
    //   636: putfield 308	com/tencent/hlyyb/downloader/b/e:m	Ljava/lang/String;
    //   639: return
    //   640: astore 7
    //   642: goto +280 -> 922
    //   645: astore 6
    //   647: aload_0
    //   648: iconst_1
    //   649: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   652: new 177	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   659: astore 7
    //   661: aload 7
    //   663: aload 6
    //   665: invokevirtual 327	java/lang/Object:getClass	()Ljava/lang/Class;
    //   668: invokevirtual 332	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   671: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 7
    //   677: ldc_w 334
    //   680: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 7
    //   686: aload 6
    //   688: invokevirtual 337	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   691: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload 7
    //   697: ldc_w 339
    //   700: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: pop
    //   704: aload 7
    //   706: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: astore 7
    //   711: aload 7
    //   713: astore 6
    //   715: aload_0
    //   716: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   719: ifeq +25 -> 744
    //   722: aload 7
    //   724: astore 6
    //   726: aload_0
    //   727: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   730: bipush 168
    //   732: if_icmpne +12 -> 744
    //   735: aload_0
    //   736: iconst_5
    //   737: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   740: ldc 251
    //   742: astore 6
    //   744: aload_0
    //   745: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   748: aload_0
    //   749: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   752: getfield 258	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   755: putfield 282	com/tencent/hlyyb/downloader/b/e:c	I
    //   758: aload_0
    //   759: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   762: astore 7
    //   764: aload 7
    //   766: aload_0
    //   767: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   770: putfield 284	com/tencent/hlyyb/downloader/b/e:f	I
    //   773: aload 7
    //   775: aload 6
    //   777: putfield 287	com/tencent/hlyyb/downloader/b/e:g	Ljava/lang/String;
    //   780: aload 7
    //   782: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   785: lload_3
    //   786: lsub
    //   787: l2i
    //   788: putfield 289	com/tencent/hlyyb/downloader/b/e:h	I
    //   791: aload_0
    //   792: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   795: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   798: aload_0
    //   799: getfield 76	com/tencent/hlyyb/downloader/b/c:h	J
    //   802: lsub
    //   803: l2i
    //   804: putfield 291	com/tencent/hlyyb/downloader/b/e:i	I
    //   807: aload_0
    //   808: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   811: aload_0
    //   812: getfield 95	com/tencent/hlyyb/downloader/b/c:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   815: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   818: putfield 296	com/tencent/hlyyb/downloader/b/e:a	I
    //   821: aload_0
    //   822: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   825: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   828: astore 7
    //   830: aload_0
    //   831: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   834: astore 6
    //   836: aload 6
    //   838: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   841: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   844: ifne +13 -> 857
    //   847: aload 6
    //   849: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   852: astore 6
    //   854: goto +10 -> 864
    //   857: aload 6
    //   859: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   862: astore 6
    //   864: aload 7
    //   866: aload 6
    //   868: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   871: ifne +50 -> 921
    //   874: aload_0
    //   875: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   878: astore 7
    //   880: aload_0
    //   881: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   884: astore 6
    //   886: aload 6
    //   888: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   891: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   894: ifne +13 -> 907
    //   897: aload 6
    //   899: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   902: astore 6
    //   904: goto +10 -> 914
    //   907: aload 6
    //   909: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   912: astore 6
    //   914: aload 7
    //   916: aload 6
    //   918: putfield 308	com/tencent/hlyyb/downloader/b/e:m	Ljava/lang/String;
    //   921: return
    //   922: aload_0
    //   923: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   926: ifeq +17 -> 943
    //   929: aload_0
    //   930: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   933: bipush 168
    //   935: if_icmpne +8 -> 943
    //   938: aload_0
    //   939: iconst_5
    //   940: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   943: aload_0
    //   944: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   947: aload_0
    //   948: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   951: getfield 258	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   954: putfield 282	com/tencent/hlyyb/downloader/b/e:c	I
    //   957: aload_0
    //   958: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   961: astore 6
    //   963: aload 6
    //   965: aload_0
    //   966: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   969: putfield 284	com/tencent/hlyyb/downloader/b/e:f	I
    //   972: aload 6
    //   974: ldc 251
    //   976: putfield 287	com/tencent/hlyyb/downloader/b/e:g	Ljava/lang/String;
    //   979: aload 6
    //   981: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   984: lload_3
    //   985: lsub
    //   986: l2i
    //   987: putfield 289	com/tencent/hlyyb/downloader/b/e:h	I
    //   990: aload_0
    //   991: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   994: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   997: aload_0
    //   998: getfield 76	com/tencent/hlyyb/downloader/b/c:h	J
    //   1001: lsub
    //   1002: l2i
    //   1003: putfield 291	com/tencent/hlyyb/downloader/b/e:i	I
    //   1006: aload_0
    //   1007: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   1010: aload_0
    //   1011: getfield 95	com/tencent/hlyyb/downloader/b/c:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1014: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   1017: putfield 296	com/tencent/hlyyb/downloader/b/e:a	I
    //   1020: aload_0
    //   1021: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1024: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1027: astore 8
    //   1029: aload_0
    //   1030: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1033: astore 6
    //   1035: aload 6
    //   1037: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   1040: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1043: ifne +13 -> 1056
    //   1046: aload 6
    //   1048: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   1051: astore 6
    //   1053: goto +10 -> 1063
    //   1056: aload 6
    //   1058: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1061: astore 6
    //   1063: aload 8
    //   1065: aload 6
    //   1067: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1070: ifne +50 -> 1120
    //   1073: aload_0
    //   1074: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   1077: astore 8
    //   1079: aload_0
    //   1080: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1083: astore 6
    //   1085: aload 6
    //   1087: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   1090: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1093: ifne +13 -> 1106
    //   1096: aload 6
    //   1098: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   1101: astore 6
    //   1103: goto +10 -> 1113
    //   1106: aload 6
    //   1108: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1111: astore 6
    //   1113: aload 8
    //   1115: aload 6
    //   1117: putfield 308	com/tencent/hlyyb/downloader/b/e:m	Ljava/lang/String;
    //   1120: goto +6 -> 1126
    //   1123: aload 7
    //   1125: athrow
    //   1126: goto -3 -> 1123
    //   1129: iconst_0
    //   1130: istore_1
    //   1131: goto -848 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1134	0	this	c
    //   249	882	1	i1	int
    //   251	157	2	i2	int
    //   23	962	3	l1	long
    //   28	3	5	bool	boolean
    //   74	272	6	localObject1	Object
    //   386	6	6	localObject2	Object
    //   480	155	6	localObject3	Object
    //   645	42	6	localThrowable	java.lang.Throwable
    //   713	403	6	localObject4	Object
    //   140	493	7	localObject5	Object
    //   640	1	7	localObject6	Object
    //   659	465	7	localObject7	Object
    //   1027	87	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   326	335	386	finally
    //   335	377	386	finally
    //   380	383	386	finally
    //   388	391	386	finally
    //   24	30	640	finally
    //   234	250	640	finally
    //   256	267	640	finally
    //   270	278	640	finally
    //   287	300	640	finally
    //   300	326	640	finally
    //   391	394	640	finally
    //   394	404	640	finally
    //   409	417	640	finally
    //   423	441	640	finally
    //   647	711	640	finally
    //   24	30	645	java/lang/Throwable
    //   234	250	645	java/lang/Throwable
    //   256	267	645	java/lang/Throwable
    //   270	278	645	java/lang/Throwable
    //   287	300	645	java/lang/Throwable
    //   300	326	645	java/lang/Throwable
    //   391	394	645	java/lang/Throwable
    //   394	404	645	java/lang/Throwable
    //   409	417	645	java/lang/Throwable
    //   423	441	645	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.b.c
 * JD-Core Version:    0.7.0.1
 */