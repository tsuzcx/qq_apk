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
      label66:
      if (com.tencent.hlyyb.common.b.b.a(paramList))
      {
        this.p = 6;
        return;
      }
      if (!paramString.toLowerCase().equals(com.tencent.hlyyb.common.b.a.a(paramList).toLowerCase()))
      {
        this.p = -1;
        return;
      }
      this.p = 0;
      return;
      this.p = 3;
      return;
    }
    catch (IOException localIOException)
    {
      break label66;
    }
  }
  
  private byte[] a(com.tencent.hlyyb.downloader.e.d.a parama, com.tencent.hlyyb.downloader.a.a.b paramb)
  {
    byte[] arrayOfByte = null;
    int i1 = 0;
    Object localObject;
    boolean bool;
    label26:
    int i2;
    if (i1 < 2)
    {
      localObject = this.k;
      if (!this.a)
      {
        bool = true;
        this.n = new f(parama, null, paramb, false, (com.tencent.hlyyb.downloader.a.b)localObject, bool, 2);
        this.n.p();
        i2 = this.n.a();
        this.g.e.add(i2);
        if (i2 != 0) {
          break label161;
        }
        arrayOfByte = this.n.q();
      }
    }
    label161:
    label190:
    label193:
    for (;;)
    {
      label104:
      if ((i2 == 0) || (i2 == -66) || (i2 == -15) || (i2 == -16)) {}
      for (i2 = 1;; i2 = 0)
      {
        localObject = arrayOfByte;
        if (i2 != 0) {
          break label190;
        }
        SystemClock.sleep(50L);
        i1 += 1;
        break;
        bool = false;
        break label26;
        if (i2 != -74) {
          break label193;
        }
        this.p = 7;
        arrayOfByte = null;
        break label104;
      }
      localObject = arrayOfByte;
      return localObject;
    }
  }
  
  private void d()
  {
    if (this.b.b == com.tencent.hlyyb.downloader.e.d.b.j) {
      this.p = 0;
    }
    ArrayList localArrayList;
    String str;
    do
    {
      return;
      localArrayList = new ArrayList();
      List localList = f();
      if (localList == null) {
        break label121;
      }
      str = this.m.c();
      int i1 = 0;
      for (;;)
      {
        if (i1 >= localList.size()) {
          break label113;
        }
        byte[] arrayOfByte = a(this.b, (com.tencent.hlyyb.downloader.a.a.b)localList.get(i1));
        if (arrayOfByte == null) {
          break;
        }
        localArrayList.add(arrayOfByte);
        i1 += 1;
      }
    } while (this.p == 7);
    this.p = 4;
    return;
    label113:
    a(localArrayList, str);
    return;
    label121:
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
    }
    return localList1;
  }
  
  private List<com.tencent.hlyyb.downloader.a.a.b> f()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.o.size())
    {
      com.tencent.hlyyb.downloader.d.a locala = (com.tencent.hlyyb.downloader.d.a)this.o.get(i1);
      long l1 = locala.a;
      long l2 = locala.b + l1 - 1L;
      if ((l1 < 0L) || (l1 > l2)) {
        return null;
      }
      localArrayList.add(new com.tencent.hlyyb.downloader.a.a.b(l1, l2));
      i1 += 1;
    }
    return localArrayList;
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
    this.g.b = paramInt1;
    this.g.d = paramInt2;
  }
  
  public final void a(String paramString)
  {
    this.g.j.add(paramString);
  }
  
  public final String b()
  {
    String str = "";
    if (this.p == -1) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((i1 != 0) || (this.p == 7)) {
        str = "" + this.p + "," + this.t + "," + this.b.c + "," + this.u + "," + com.tencent.hlyyb.common.b.b.b(this.n.e());
      }
      return str;
    }
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
    //   0: iconst_1
    //   1: istore_2
    //   2: new 177	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 272
    //   9: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: getstatic 51	com/tencent/hlyyb/downloader/b/c:i	Ljava/util/concurrent/atomic/AtomicInteger;
    //   15: invokevirtual 277	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   18: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   25: lstore_3
    //   26: aload_0
    //   27: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   30: istore 5
    //   32: iload 5
    //   34: ifeq +202 -> 236
    //   37: aload_0
    //   38: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   41: ifeq +1066 -> 1107
    //   44: aload_0
    //   45: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   48: bipush 168
    //   50: if_icmpne +1057 -> 1107
    //   53: aload_0
    //   54: iconst_5
    //   55: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   58: aload_0
    //   59: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   62: aload_0
    //   63: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   66: getfield 258	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   69: putfield 282	com/tencent/hlyyb/downloader/b/e:c	I
    //   72: aload_0
    //   73: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   76: aload_0
    //   77: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   80: putfield 284	com/tencent/hlyyb/downloader/b/e:f	I
    //   83: aload_0
    //   84: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   87: ldc 251
    //   89: putfield 287	com/tencent/hlyyb/downloader/b/e:g	Ljava/lang/String;
    //   92: aload_0
    //   93: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   96: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   99: lload_3
    //   100: lsub
    //   101: l2i
    //   102: putfield 289	com/tencent/hlyyb/downloader/b/e:h	I
    //   105: aload_0
    //   106: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   109: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   112: aload_0
    //   113: getfield 76	com/tencent/hlyyb/downloader/b/c:h	J
    //   116: lsub
    //   117: l2i
    //   118: putfield 291	com/tencent/hlyyb/downloader/b/e:i	I
    //   121: aload_0
    //   122: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   125: aload_0
    //   126: getfield 95	com/tencent/hlyyb/downloader/b/c:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   129: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   132: putfield 296	com/tencent/hlyyb/downloader/b/e:a	I
    //   135: aload_0
    //   136: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   139: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   142: astore 7
    //   144: aload_0
    //   145: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   148: astore 6
    //   150: aload 6
    //   152: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   155: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +58 -> 216
    //   161: aload 6
    //   163: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   166: astore 6
    //   168: aload 7
    //   170: aload 6
    //   172: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   175: ifne +40 -> 215
    //   178: aload_0
    //   179: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   182: astore 7
    //   184: aload_0
    //   185: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   188: astore 6
    //   190: aload 6
    //   192: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   195: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +28 -> 226
    //   201: aload 6
    //   203: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   206: astore 6
    //   208: aload 7
    //   210: aload 6
    //   212: putfield 308	com/tencent/hlyyb/downloader/b/e:m	Ljava/lang/String;
    //   215: return
    //   216: aload 6
    //   218: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   221: astore 6
    //   223: goto -55 -> 168
    //   226: aload 6
    //   228: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   231: astore 6
    //   233: goto -25 -> 208
    //   236: aload_0
    //   237: invokespecial 310	com/tencent/hlyyb/downloader/b/c:d	()V
    //   240: aload_0
    //   241: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   244: ifne +571 -> 815
    //   247: aload_0
    //   248: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   251: ifne +343 -> 594
    //   254: aload_0
    //   255: getfield 80	com/tencent/hlyyb/downloader/b/c:m	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   258: aload_0
    //   259: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   262: invokevirtual 313	com/tencent/hlyyb/downloader/e/d/c:a	(Lcom/tencent/hlyyb/downloader/e/d/a;)V
    //   265: aload_0
    //   266: getfield 65	com/tencent/hlyyb/downloader/b/c:q	Z
    //   269: ifne +738 -> 1007
    //   272: aload_0
    //   273: getfield 80	com/tencent/hlyyb/downloader/b/c:m	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   276: invokevirtual 315	com/tencent/hlyyb/downloader/e/d/c:e	()I
    //   279: ifle +715 -> 994
    //   282: aload_0
    //   283: invokespecial 317	com/tencent/hlyyb/downloader/b/c:e	()Ljava/util/List;
    //   286: astore 6
    //   288: ldc 2
    //   290: monitorenter
    //   291: aload 6
    //   293: invokeinterface 115 1 0
    //   298: astore 6
    //   300: aload 6
    //   302: invokeinterface 121 1 0
    //   307: ifeq +505 -> 812
    //   310: aload 6
    //   312: invokeinterface 125 1 0
    //   317: checkcast 2	com/tencent/hlyyb/downloader/b/c
    //   320: astore 7
    //   322: aload 7
    //   324: iconst_1
    //   325: putfield 59	com/tencent/hlyyb/downloader/b/c:d	Z
    //   328: aload_0
    //   329: getfield 93	com/tencent/hlyyb/downloader/b/c:l	Lcom/tencent/hlyyb/downloader/b/d;
    //   332: aload 7
    //   334: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   337: invokeinterface 320 2 0
    //   342: goto -42 -> 300
    //   345: astore 6
    //   347: ldc 2
    //   349: monitorexit
    //   350: aload 6
    //   352: athrow
    //   353: astore 6
    //   355: aload_0
    //   356: iconst_1
    //   357: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   360: new 177	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   367: aload 6
    //   369: invokevirtual 324	java/lang/Object:getClass	()Ljava/lang/Class;
    //   372: invokevirtual 329	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   375: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: ldc_w 331
    //   381: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 6
    //   386: invokevirtual 334	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   389: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: ldc_w 336
    //   395: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: astore 6
    //   403: aload 6
    //   405: astore 7
    //   407: aload_0
    //   408: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   411: ifeq +25 -> 436
    //   414: aload 6
    //   416: astore 7
    //   418: aload_0
    //   419: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   422: bipush 168
    //   424: if_icmpne +12 -> 436
    //   427: aload_0
    //   428: iconst_5
    //   429: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   432: ldc 251
    //   434: astore 7
    //   436: aload_0
    //   437: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   440: aload_0
    //   441: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   444: getfield 258	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   447: putfield 282	com/tencent/hlyyb/downloader/b/e:c	I
    //   450: aload_0
    //   451: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   454: aload_0
    //   455: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   458: putfield 284	com/tencent/hlyyb/downloader/b/e:f	I
    //   461: aload_0
    //   462: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   465: aload 7
    //   467: putfield 287	com/tencent/hlyyb/downloader/b/e:g	Ljava/lang/String;
    //   470: aload_0
    //   471: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   474: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   477: lload_3
    //   478: lsub
    //   479: l2i
    //   480: putfield 289	com/tencent/hlyyb/downloader/b/e:h	I
    //   483: aload_0
    //   484: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   487: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   490: aload_0
    //   491: getfield 76	com/tencent/hlyyb/downloader/b/c:h	J
    //   494: lsub
    //   495: l2i
    //   496: putfield 291	com/tencent/hlyyb/downloader/b/e:i	I
    //   499: aload_0
    //   500: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   503: aload_0
    //   504: getfield 95	com/tencent/hlyyb/downloader/b/c:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   507: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   510: putfield 296	com/tencent/hlyyb/downloader/b/e:a	I
    //   513: aload_0
    //   514: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   517: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   520: astore 7
    //   522: aload_0
    //   523: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   526: astore 6
    //   528: aload 6
    //   530: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   533: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   536: ifne +531 -> 1067
    //   539: aload 6
    //   541: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   544: astore 6
    //   546: aload 7
    //   548: aload 6
    //   550: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   553: ifne -338 -> 215
    //   556: aload_0
    //   557: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   560: astore 7
    //   562: aload_0
    //   563: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   566: astore 6
    //   568: aload 6
    //   570: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   573: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   576: ifne +501 -> 1077
    //   579: aload 6
    //   581: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   584: astore 6
    //   586: aload 7
    //   588: aload 6
    //   590: putfield 308	com/tencent/hlyyb/downloader/b/e:m	Ljava/lang/String;
    //   593: return
    //   594: aload_0
    //   595: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   598: iconst_m1
    //   599: if_icmpne +208 -> 807
    //   602: iconst_1
    //   603: istore_1
    //   604: iload_1
    //   605: ifeq -340 -> 265
    //   608: aload_0
    //   609: iconst_1
    //   610: putfield 57	com/tencent/hlyyb/downloader/b/c:c	Z
    //   613: aload_0
    //   614: getfield 97	com/tencent/hlyyb/downloader/b/c:r	Ljava/util/concurrent/atomic/AtomicInteger;
    //   617: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   620: pop
    //   621: goto -356 -> 265
    //   624: astore 7
    //   626: aload_0
    //   627: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   630: ifeq +17 -> 647
    //   633: aload_0
    //   634: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   637: bipush 168
    //   639: if_icmpne +8 -> 647
    //   642: aload_0
    //   643: iconst_5
    //   644: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   647: aload_0
    //   648: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   651: aload_0
    //   652: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   655: getfield 258	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   658: putfield 282	com/tencent/hlyyb/downloader/b/e:c	I
    //   661: aload_0
    //   662: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   665: aload_0
    //   666: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   669: putfield 284	com/tencent/hlyyb/downloader/b/e:f	I
    //   672: aload_0
    //   673: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   676: ldc 251
    //   678: putfield 287	com/tencent/hlyyb/downloader/b/e:g	Ljava/lang/String;
    //   681: aload_0
    //   682: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   685: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   688: lload_3
    //   689: lsub
    //   690: l2i
    //   691: putfield 289	com/tencent/hlyyb/downloader/b/e:h	I
    //   694: aload_0
    //   695: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   698: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   701: aload_0
    //   702: getfield 76	com/tencent/hlyyb/downloader/b/c:h	J
    //   705: lsub
    //   706: l2i
    //   707: putfield 291	com/tencent/hlyyb/downloader/b/e:i	I
    //   710: aload_0
    //   711: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   714: aload_0
    //   715: getfield 95	com/tencent/hlyyb/downloader/b/c:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   718: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   721: putfield 296	com/tencent/hlyyb/downloader/b/e:a	I
    //   724: aload_0
    //   725: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   728: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   731: astore 8
    //   733: aload_0
    //   734: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   737: astore 6
    //   739: aload 6
    //   741: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   744: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   747: ifne +340 -> 1087
    //   750: aload 6
    //   752: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   755: astore 6
    //   757: aload 8
    //   759: aload 6
    //   761: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   764: ifne +40 -> 804
    //   767: aload_0
    //   768: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   771: astore 8
    //   773: aload_0
    //   774: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   777: astore 6
    //   779: aload 6
    //   781: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   784: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   787: ifne +310 -> 1097
    //   790: aload 6
    //   792: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   795: astore 6
    //   797: aload 8
    //   799: aload 6
    //   801: putfield 308	com/tencent/hlyyb/downloader/b/e:m	Ljava/lang/String;
    //   804: aload 7
    //   806: athrow
    //   807: iconst_0
    //   808: istore_1
    //   809: goto -205 -> 604
    //   812: ldc 2
    //   814: monitorexit
    //   815: aload_0
    //   816: getfield 61	com/tencent/hlyyb/downloader/b/c:e	Z
    //   819: ifeq +17 -> 836
    //   822: aload_0
    //   823: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   826: bipush 168
    //   828: if_icmpne +8 -> 836
    //   831: aload_0
    //   832: iconst_5
    //   833: putfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   836: aload_0
    //   837: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   840: aload_0
    //   841: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   844: getfield 258	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   847: putfield 282	com/tencent/hlyyb/downloader/b/e:c	I
    //   850: aload_0
    //   851: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   854: aload_0
    //   855: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   858: putfield 284	com/tencent/hlyyb/downloader/b/e:f	I
    //   861: aload_0
    //   862: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   865: ldc 251
    //   867: putfield 287	com/tencent/hlyyb/downloader/b/e:g	Ljava/lang/String;
    //   870: aload_0
    //   871: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   874: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   877: lload_3
    //   878: lsub
    //   879: l2i
    //   880: putfield 289	com/tencent/hlyyb/downloader/b/e:h	I
    //   883: aload_0
    //   884: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   887: invokestatic 281	android/os/SystemClock:elapsedRealtime	()J
    //   890: aload_0
    //   891: getfield 76	com/tencent/hlyyb/downloader/b/c:h	J
    //   894: lsub
    //   895: l2i
    //   896: putfield 291	com/tencent/hlyyb/downloader/b/e:i	I
    //   899: aload_0
    //   900: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   903: aload_0
    //   904: getfield 95	com/tencent/hlyyb/downloader/b/c:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   907: invokevirtual 294	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   910: putfield 296	com/tencent/hlyyb/downloader/b/e:a	I
    //   913: aload_0
    //   914: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   917: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   920: astore 7
    //   922: aload_0
    //   923: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   926: astore 6
    //   928: aload 6
    //   930: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   933: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   936: ifne +111 -> 1047
    //   939: aload 6
    //   941: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   944: astore 6
    //   946: aload 7
    //   948: aload 6
    //   950: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   953: ifne -738 -> 215
    //   956: aload_0
    //   957: getfield 74	com/tencent/hlyyb/downloader/b/c:g	Lcom/tencent/hlyyb/downloader/b/e;
    //   960: astore 7
    //   962: aload_0
    //   963: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   966: astore 6
    //   968: aload 6
    //   970: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   973: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   976: ifne +81 -> 1057
    //   979: aload 6
    //   981: getfield 300	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   984: astore 6
    //   986: aload 7
    //   988: aload 6
    //   990: putfield 308	com/tencent/hlyyb/downloader/b/e:m	Ljava/lang/String;
    //   993: return
    //   994: aload_0
    //   995: getfield 93	com/tencent/hlyyb/downloader/b/c:l	Lcom/tencent/hlyyb/downloader/b/d;
    //   998: invokeinterface 339 1 0
    //   1003: pop
    //   1004: goto -189 -> 815
    //   1007: aload_0
    //   1008: getfield 63	com/tencent/hlyyb/downloader/b/c:p	I
    //   1011: iconst_m1
    //   1012: if_icmpne +30 -> 1042
    //   1015: iload_2
    //   1016: istore_1
    //   1017: iload_1
    //   1018: ifeq -203 -> 815
    //   1021: aload_0
    //   1022: iconst_1
    //   1023: putfield 59	com/tencent/hlyyb/downloader/b/c:d	Z
    //   1026: aload_0
    //   1027: getfield 93	com/tencent/hlyyb/downloader/b/c:l	Lcom/tencent/hlyyb/downloader/b/d;
    //   1030: aload_0
    //   1031: getfield 89	com/tencent/hlyyb/downloader/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1034: invokeinterface 320 2 0
    //   1039: goto -224 -> 815
    //   1042: iconst_0
    //   1043: istore_1
    //   1044: goto -27 -> 1017
    //   1047: aload 6
    //   1049: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1052: astore 6
    //   1054: goto -108 -> 946
    //   1057: aload 6
    //   1059: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1062: astore 6
    //   1064: goto -78 -> 986
    //   1067: aload 6
    //   1069: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1072: astore 6
    //   1074: goto -528 -> 546
    //   1077: aload 6
    //   1079: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1082: astore 6
    //   1084: goto -498 -> 586
    //   1087: aload 6
    //   1089: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1092: astore 6
    //   1094: goto -337 -> 757
    //   1097: aload 6
    //   1099: getfield 298	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1102: astore 6
    //   1104: goto -307 -> 797
    //   1107: goto -1049 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1110	0	this	c
    //   603	441	1	i1	int
    //   1	1015	2	i2	int
    //   25	853	3	l1	long
    //   30	3	5	bool	boolean
    //   148	163	6	localObject1	Object
    //   345	6	6	localObject2	Object
    //   353	32	6	localThrowable	java.lang.Throwable
    //   401	702	6	localObject3	Object
    //   142	445	7	localObject4	Object
    //   624	181	7	localObject5	Object
    //   920	67	7	localObject6	Object
    //   731	67	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   291	300	345	finally
    //   300	342	345	finally
    //   347	350	345	finally
    //   812	815	345	finally
    //   26	32	353	java/lang/Throwable
    //   236	265	353	java/lang/Throwable
    //   265	291	353	java/lang/Throwable
    //   350	353	353	java/lang/Throwable
    //   594	602	353	java/lang/Throwable
    //   608	621	353	java/lang/Throwable
    //   994	1004	353	java/lang/Throwable
    //   1007	1015	353	java/lang/Throwable
    //   1021	1039	353	java/lang/Throwable
    //   26	32	624	finally
    //   236	265	624	finally
    //   265	291	624	finally
    //   350	353	624	finally
    //   355	403	624	finally
    //   594	602	624	finally
    //   608	621	624	finally
    //   994	1004	624	finally
    //   1007	1015	624	finally
    //   1021	1039	624	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.b.c
 * JD-Core Version:    0.7.0.1
 */