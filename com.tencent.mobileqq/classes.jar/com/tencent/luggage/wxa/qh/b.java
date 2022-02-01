package com.tencent.luggage.wxa.qh;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qj.d;
import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.x;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements Runnable
{
  public b.b a;
  private String b = null;
  private com.tencent.luggage.wxa.ig.e c;
  private a d;
  private float e;
  private long f = 307200L;
  private boolean g;
  private boolean h = true;
  private String i = "";
  private int j = -1;
  private int k = 0;
  
  public b(com.tencent.luggage.wxa.ig.e parame, a parama)
  {
    this.c = parame;
    this.d = parama;
    if (parama.a()) {
      o.b("MicroMsg.Music.MusicDownloadTask", "downloadInfo is invalid");
    } else {
      o.d("MicroMsg.Music.MusicDownloadTask", "downloadInfo is valid");
    }
    this.g = x.j(r.a());
  }
  
  private HttpURLConnection a(String paramString, Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      o.d("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
      paramString = this.b;
    }
    Object localObject1 = null;
    int m = 0;
    for (;;)
    {
      if (localObject1 != null)
      {
        try
        {
          ((HttpURLConnection)localObject1).getInputStream().close();
        }
        catch (Exception localException)
        {
          o.b("MicroMsg.Music.MusicDownloadTask", localException.getMessage());
        }
        ((HttpURLConnection)localObject1).disconnect();
      }
      o.d("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", new Object[] { paramString });
      Object localObject2 = i.i();
      localObject1 = new URL(paramString);
      if (localObject2 != null) {
        localObject1 = ((com.tencent.luggage.wxa.qj.a)localObject2).b(paramString);
      }
      localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
      ((HttpURLConnection)localObject1).setRequestMethod("GET");
      ((HttpURLConnection)localObject1).setConnectTimeout(25000);
      ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject2 = (Map.Entry)paramString.next();
        ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
      int n = ((HttpURLConnection)localObject1).getResponseCode();
      o.d("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(m) });
      if ((n != 300) && (n != 301) && (n != 302) && (n != 303) && (n != 307))
      {
        if ((n != 200) && (n != 206)) {
          this.b = null;
        }
        return localObject1;
      }
      a(n);
      paramString = ((HttpURLConnection)localObject1).getRequestMethod();
      if ((n == 307) && (!paramString.equals("GET")) && (!paramString.equals("HEAD"))) {
        return localObject1;
      }
      paramString = ((HttpURLConnection)localObject1).getHeaderField("Location");
      if (paramString == null)
      {
        o.b("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", new Object[] { Integer.valueOf(n) });
        return localObject1;
      }
      localObject2 = new URL(((HttpURLConnection)localObject1).getURL(), paramString);
      o.d("MicroMsg.Music.MusicDownloadTask", "location:%s", new Object[] { paramString });
      o.d("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", new Object[] { ((URL)localObject2).toString() });
      if ((!((URL)localObject2).getProtocol().equals("https")) && (!((URL)localObject2).getProtocol().equals("http")))
      {
        o.b("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", new Object[] { Integer.valueOf(n) });
        return localObject1;
      }
      m += 1;
      if (m > 5)
      {
        paramString = new StringBuilder();
        paramString.append("Too many redirects: ");
        paramString.append(m);
        o.b("MicroMsg.Music.MusicDownloadTask", paramString.toString());
        return localObject1;
      }
      paramString = ((URL)localObject2).toString();
      this.b = paramString;
    }
  }
  
  private void a(int paramInt)
  {
    d locald = (d)com.tencent.luggage.wxa.qn.b.a(d.class);
    if (locald != null) {
      locald.a(paramInt);
    }
  }
  
  private void a(long paramLong)
  {
    a locala;
    if (this.g)
    {
      locala = this.d;
      locala.d = paramLong;
      locala.e = 1;
      locala.f = paramLong;
      com.tencent.luggage.wxa.qg.e.a(this.c.c, this.d);
    }
    else
    {
      locala = this.d;
      locala.a = paramLong;
      locala.c = 1;
      locala.b = paramLong;
      com.tencent.luggage.wxa.qg.e.a(this.c.c, this.d);
    }
    t.a(new b.a(this, 2));
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    o.f("MicroMsg.Music.MusicDownloadTask", "update updateCurrentDownloadLength %d %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.g)
    {
      locala = this.d;
      locala.d = paramLong1;
      locala.f = paramLong2;
      return;
    }
    a locala = this.d;
    locala.a = paramLong1;
    locala.b = paramLong2;
  }
  
  private long[] a(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    try
    {
      paramString = paramString.replace("bytes", "").trim().split("-");
      long l1 = Long.valueOf(paramString[0]).longValue();
      paramString = paramString[1].split("/");
      long l2 = Long.valueOf(paramString[0]).longValue();
      long l3 = Long.valueOf(paramString[1]).longValue();
      return new long[] { l1, l2, l3 };
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void b(int paramInt)
  {
    this.b = null;
    t.a(new b.a(this, paramInt));
  }
  
  private void b(long paramLong1, long paramLong2)
  {
    a locala;
    if (this.g)
    {
      locala = this.d;
      locala.d = paramLong1;
      locala.e = 0;
      locala.f = paramLong2;
      com.tencent.luggage.wxa.qg.e.a(this.c.c, this.d);
    }
    else
    {
      locala = this.d;
      locala.a = paramLong1;
      locala.c = 0;
      locala.b = paramLong2;
      com.tencent.luggage.wxa.qg.e.a(this.c.c, this.d);
    }
    t.a(new b.a(this, 3));
  }
  
  public com.tencent.luggage.wxa.ig.e a()
  {
    return this.c;
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
    boolean bool = x.k(r.a());
    if ((b()) && (bool))
    {
      float f1;
      long l;
      if (this.g)
      {
        if (this.d.f == 0L) {
          return;
        }
        f1 = (float)this.d.d;
        l = this.d.f;
      }
      else
      {
        if (this.d.b == 0L) {
          return;
        }
        f1 = (float)this.d.a;
        l = this.d.b;
      }
      f1 /= (float)l;
      if (f1 >= 1.0F) {
        return;
      }
      if ((f1 - paramFloat <= 0.15F) && (bool))
      {
        o.f("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(paramFloat), Float.valueOf(f1), Boolean.valueOf(bool) });
        d();
      }
    }
  }
  
  public void a(b.b paramb)
  {
    this.a = paramb;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public boolean b(float paramFloat)
  {
    float f1;
    long l;
    if (this.g)
    {
      if (this.d.f == 0L) {
        return false;
      }
      f1 = (float)this.d.d;
      l = this.d.f;
    }
    else
    {
      if (this.d.b == 0L) {
        return false;
      }
      f1 = (float)this.d.a;
      l = this.d.b;
    }
    f1 /= (float)l;
    if (f1 >= 1.0F) {
      return true;
    }
    return f1 - paramFloat > 0.05F;
  }
  
  public void c()
  {
    this.h = true;
  }
  
  public void d()
  {
    if (!b()) {
      return;
    }
    this.h = false;
    com.tencent.luggage.wxa.rd.a.b(this, "music_download_thread");
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public int f()
  {
    long l;
    if (this.g)
    {
      o.f("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(this.d.f), Long.valueOf(this.d.d) });
      if (this.d.f == 0L) {
        break label156;
      }
      l = this.d.d * 100L / this.d.f;
    }
    else
    {
      o.f("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(this.d.b), Long.valueOf(this.d.a) });
      if (this.d.b == 0L) {
        break label156;
      }
      l = this.d.a * 100L / this.d.b;
    }
    int m = (int)l;
    break label158;
    label156:
    m = 0;
    label158:
    if (m >= 1) {
      return m;
    }
    return 0;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 73	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   11: invokestatic 337	com/tencent/luggage/wxa/qz/x:k	(Landroid/content/Context;)Z
    //   14: istore 20
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 46	com/tencent/luggage/wxa/qh/b:k	I
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 44	com/tencent/luggage/wxa/qh/b:j	I
    //   26: invokestatic 120	com/tencent/luggage/wxa/qj/i:i	()Lcom/tencent/luggage/wxa/qj/a;
    //   29: astore 22
    //   31: iload 20
    //   33: ifeq +6485 -> 6518
    //   36: aload_0
    //   37: getfield 80	com/tencent/luggage/wxa/qh/b:g	Z
    //   40: ifeq +151 -> 191
    //   43: aload_0
    //   44: getfield 48	com/tencent/luggage/wxa/qh/b:c	Lcom/tencent/luggage/wxa/ig/e;
    //   47: getfield 384	com/tencent/luggage/wxa/ig/e:C	Ljava/lang/String;
    //   50: invokestatic 387	com/tencent/luggage/wxa/qg/g:c	(Ljava/lang/String;)Z
    //   53: istore 20
    //   55: aload 22
    //   57: ifnull +22 -> 79
    //   60: aload 22
    //   62: aload_0
    //   63: getfield 48	com/tencent/luggage/wxa/qh/b:c	Lcom/tencent/luggage/wxa/ig/e;
    //   66: getfield 384	com/tencent/luggage/wxa/ig/e:C	Ljava/lang/String;
    //   69: invokeinterface 389 2 0
    //   74: astore 22
    //   76: goto +6 -> 82
    //   79: aconst_null
    //   80: astore 22
    //   82: ldc 57
    //   84: ldc_w 391
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload 22
    //   95: aastore
    //   96: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_0
    //   100: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   103: getfield 263	com/tencent/luggage/wxa/qh/a:d	J
    //   106: lstore 6
    //   108: aload_0
    //   109: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   112: getfield 266	com/tencent/luggage/wxa/qh/a:f	J
    //   115: lstore 4
    //   117: lload 4
    //   119: lconst_0
    //   120: lcmp
    //   121: ifeq +16 -> 137
    //   124: aload_0
    //   125: lload 4
    //   127: ldc2_w 392
    //   130: ldiv
    //   131: putfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   134: goto +3 -> 137
    //   137: aload_0
    //   138: getfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   141: lstore_2
    //   142: lload 6
    //   144: lload_2
    //   145: lcmp
    //   146: ifge +6 -> 152
    //   149: goto +21 -> 170
    //   152: lload 6
    //   154: l2f
    //   155: aload_0
    //   156: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   159: getfield 266	com/tencent/luggage/wxa/qh/a:f	J
    //   162: l2f
    //   163: ldc_w 340
    //   166: fmul
    //   167: fadd
    //   168: f2l
    //   169: lstore_2
    //   170: aload_0
    //   171: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   174: getfield 265	com/tencent/luggage/wxa/qh/a:e	I
    //   177: iconst_1
    //   178: if_icmpne +8 -> 186
    //   181: iconst_1
    //   182: istore_1
    //   183: goto +5 -> 188
    //   186: iconst_0
    //   187: istore_1
    //   188: goto +136 -> 324
    //   191: aload 22
    //   193: ifnull +22 -> 215
    //   196: aload 22
    //   198: aload_0
    //   199: getfield 48	com/tencent/luggage/wxa/qh/b:c	Lcom/tencent/luggage/wxa/ig/e;
    //   202: getfield 384	com/tencent/luggage/wxa/ig/e:C	Ljava/lang/String;
    //   205: invokeinterface 389 2 0
    //   210: astore 22
    //   212: goto +6 -> 218
    //   215: aconst_null
    //   216: astore 22
    //   218: ldc 57
    //   220: ldc_w 391
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload 22
    //   231: aastore
    //   232: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_0
    //   236: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   239: getfield 277	com/tencent/luggage/wxa/qh/a:a	J
    //   242: lstore 6
    //   244: aload_0
    //   245: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   248: getfield 281	com/tencent/luggage/wxa/qh/a:b	J
    //   251: lstore 4
    //   253: lload 4
    //   255: lconst_0
    //   256: lcmp
    //   257: ifeq +13 -> 270
    //   260: aload_0
    //   261: lload 4
    //   263: ldc2_w 392
    //   266: ldiv
    //   267: putfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   270: aload_0
    //   271: getfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   274: lstore_2
    //   275: lload 6
    //   277: lload_2
    //   278: lcmp
    //   279: ifge +6 -> 285
    //   282: goto +21 -> 303
    //   285: lload 6
    //   287: l2f
    //   288: aload_0
    //   289: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   292: getfield 281	com/tencent/luggage/wxa/qh/a:b	J
    //   295: l2f
    //   296: ldc_w 340
    //   299: fmul
    //   300: fadd
    //   301: f2l
    //   302: lstore_2
    //   303: aload_0
    //   304: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   307: getfield 279	com/tencent/luggage/wxa/qh/a:c	I
    //   310: iconst_1
    //   311: if_icmpne +8 -> 319
    //   314: iconst_1
    //   315: istore_1
    //   316: goto +5 -> 321
    //   319: iconst_0
    //   320: istore_1
    //   321: iconst_0
    //   322: istore 20
    //   324: aload_0
    //   325: getfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   328: ldc2_w 394
    //   331: lcmp
    //   332: ifge +18 -> 350
    //   335: aload_0
    //   336: ldc2_w 394
    //   339: putfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   342: ldc 57
    //   344: ldc_w 397
    //   347: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: new 399	com/tencent/luggage/wxa/rt/i
    //   353: dup
    //   354: aload_0
    //   355: getfield 48	com/tencent/luggage/wxa/qh/b:c	Lcom/tencent/luggage/wxa/ig/e;
    //   358: getfield 270	com/tencent/luggage/wxa/ig/e:c	Ljava/lang/String;
    //   361: aload_0
    //   362: getfield 80	com/tencent/luggage/wxa/qh/b:g	Z
    //   365: invokestatic 404	com/tencent/luggage/wxa/qq/b:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   368: invokespecial 405	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   371: astore 31
    //   373: aload 31
    //   375: invokevirtual 407	com/tencent/luggage/wxa/rt/i:j	()Z
    //   378: ifne +86 -> 464
    //   381: ldc 57
    //   383: ldc_w 409
    //   386: iconst_1
    //   387: anewarray 4	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: aload 31
    //   394: invokevirtual 412	com/tencent/luggage/wxa/rt/i:v	()Z
    //   397: invokestatic 352	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   400: aastore
    //   401: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: goto +27 -> 431
    //   407: astore 23
    //   409: ldc 57
    //   411: aload 23
    //   413: ldc_w 414
    //   416: iconst_1
    //   417: anewarray 4	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload 31
    //   424: invokevirtual 417	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   427: aastore
    //   428: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: aload_0
    //   432: getfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   435: lstore 8
    //   437: ldc 57
    //   439: ldc_w 422
    //   442: iconst_1
    //   443: anewarray 4	java/lang/Object
    //   446: dup
    //   447: iconst_0
    //   448: lload 8
    //   450: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   453: aastore
    //   454: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   457: lconst_0
    //   458: lstore_2
    //   459: iconst_0
    //   460: istore_1
    //   461: goto +9 -> 470
    //   464: lload_2
    //   465: lstore 8
    //   467: lload 6
    //   469: lstore_2
    //   470: ldc 57
    //   472: ldc_w 424
    //   475: iconst_3
    //   476: anewarray 4	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: lload_2
    //   482: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: aload 31
    //   490: invokevirtual 427	com/tencent/luggage/wxa/rt/i:q	()J
    //   493: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   496: aastore
    //   497: dup
    //   498: iconst_2
    //   499: lload 8
    //   501: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   504: aastore
    //   505: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   508: lload_2
    //   509: aload_0
    //   510: getfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   513: lcmp
    //   514: iflt +12 -> 526
    //   517: aload_0
    //   518: getfield 335	com/tencent/luggage/wxa/qh/b:e	F
    //   521: fconst_0
    //   522: fcmpl
    //   523: ifeq +7 -> 530
    //   526: iload_1
    //   527: ifeq +29 -> 556
    //   530: ldc 57
    //   532: ldc_w 429
    //   535: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   538: aload_0
    //   539: iconst_1
    //   540: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   543: new 283	com/tencent/luggage/wxa/qh/b$a
    //   546: dup
    //   547: aload_0
    //   548: iconst_1
    //   549: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   552: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   555: return
    //   556: aload 22
    //   558: invokestatic 307	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   561: ifeq +30 -> 591
    //   564: ldc 57
    //   566: ldc_w 431
    //   569: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: aload_0
    //   573: iconst_1
    //   574: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   577: new 283	com/tencent/luggage/wxa/qh/b$a
    //   580: dup
    //   581: aload_0
    //   582: bipush 254
    //   584: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   587: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   590: return
    //   591: aconst_null
    //   592: astore 27
    //   594: aload 31
    //   596: invokevirtual 407	com/tencent/luggage/wxa/rt/i:j	()Z
    //   599: istore 21
    //   601: iload 21
    //   603: ifne +362 -> 965
    //   606: aload_0
    //   607: iconst_1
    //   608: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   611: ldc 57
    //   613: ldc_w 433
    //   616: iconst_1
    //   617: anewarray 4	java/lang/Object
    //   620: dup
    //   621: iconst_0
    //   622: aload 31
    //   624: invokevirtual 417	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   627: aastore
    //   628: invokestatic 214	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   631: aload_0
    //   632: bipush 19
    //   634: invokespecial 435	com/tencent/luggage/wxa/qh/b:b	(I)V
    //   637: lload 4
    //   639: lconst_0
    //   640: lcmp
    //   641: ifne +69 -> 710
    //   644: lload_2
    //   645: lconst_0
    //   646: lcmp
    //   647: ifle +63 -> 710
    //   650: ldc 57
    //   652: ldc_w 437
    //   655: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   658: new 439	java/lang/NullPointerException
    //   661: dup
    //   662: invokespecial 440	java/lang/NullPointerException:<init>	()V
    //   665: athrow
    //   666: astore 22
    //   668: ldc 57
    //   670: aload 22
    //   672: ldc_w 442
    //   675: iconst_0
    //   676: anewarray 4	java/lang/Object
    //   679: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   682: aload_0
    //   683: lload_2
    //   684: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   687: lload_2
    //   688: ldc2_w 394
    //   691: lcmp
    //   692: ifge +147 -> 839
    //   695: new 283	com/tencent/luggage/wxa/qh/b$a
    //   698: dup
    //   699: aload_0
    //   700: iconst_1
    //   701: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   704: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   707: goto +132 -> 839
    //   710: lload 4
    //   712: lconst_0
    //   713: lcmp
    //   714: ifeq +47 -> 761
    //   717: lload_2
    //   718: lload 4
    //   720: lcmp
    //   721: ifeq +40 -> 761
    //   724: ldc 57
    //   726: ldc_w 446
    //   729: iconst_2
    //   730: anewarray 4	java/lang/Object
    //   733: dup
    //   734: iconst_0
    //   735: lload 4
    //   737: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   740: aastore
    //   741: dup
    //   742: iconst_1
    //   743: lload_2
    //   744: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   747: aastore
    //   748: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   751: aload_0
    //   752: lload_2
    //   753: lload 4
    //   755: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   758: goto +81 -> 839
    //   761: lload 4
    //   763: lconst_0
    //   764: lcmp
    //   765: ifeq +66 -> 831
    //   768: lload_2
    //   769: lload 4
    //   771: lcmp
    //   772: ifne +59 -> 831
    //   775: ldc 57
    //   777: ldc_w 450
    //   780: iconst_2
    //   781: anewarray 4	java/lang/Object
    //   784: dup
    //   785: iconst_0
    //   786: lload 4
    //   788: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   791: aastore
    //   792: dup
    //   793: iconst_1
    //   794: lload_2
    //   795: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   798: aastore
    //   799: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   802: aload_0
    //   803: lload 4
    //   805: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   808: lload_2
    //   809: ldc2_w 394
    //   812: lcmp
    //   813: ifge +26 -> 839
    //   816: new 283	com/tencent/luggage/wxa/qh/b$a
    //   819: dup
    //   820: aload_0
    //   821: iconst_1
    //   822: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   825: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   828: goto +11 -> 839
    //   831: ldc 57
    //   833: ldc_w 452
    //   836: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   839: aload_0
    //   840: iconst_1
    //   841: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   844: ldc 57
    //   846: ldc_w 454
    //   849: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   852: return
    //   853: astore 22
    //   855: ldc_w 456
    //   858: astore 26
    //   860: ldc_w 454
    //   863: astore 25
    //   865: aconst_null
    //   866: astore 23
    //   868: aconst_null
    //   869: astore 28
    //   871: ldc_w 452
    //   874: astore 24
    //   876: goto +5332 -> 6208
    //   879: astore 24
    //   881: aconst_null
    //   882: astore 25
    //   884: aconst_null
    //   885: astore 23
    //   887: aconst_null
    //   888: astore 22
    //   890: aload 22
    //   892: astore 26
    //   894: goto +3171 -> 4065
    //   897: astore 29
    //   899: aconst_null
    //   900: astore 22
    //   902: aconst_null
    //   903: astore 24
    //   905: aconst_null
    //   906: astore 23
    //   908: lload 4
    //   910: lstore 8
    //   912: goto +3560 -> 4472
    //   915: astore 24
    //   917: aconst_null
    //   918: astore 22
    //   920: aconst_null
    //   921: astore 29
    //   923: aconst_null
    //   924: astore 23
    //   926: lload 4
    //   928: lstore 8
    //   930: goto +3973 -> 4903
    //   933: astore 24
    //   935: aconst_null
    //   936: astore 22
    //   938: aconst_null
    //   939: astore 29
    //   941: aconst_null
    //   942: astore 23
    //   944: lload 4
    //   946: lstore 8
    //   948: goto +4397 -> 5345
    //   951: astore 25
    //   953: aconst_null
    //   954: astore 22
    //   956: aconst_null
    //   957: astore 24
    //   959: aconst_null
    //   960: astore 23
    //   962: goto +4849 -> 5811
    //   965: aload 31
    //   967: invokevirtual 458	com/tencent/luggage/wxa/rt/i:b	()Ljava/lang/String;
    //   970: astore 23
    //   972: aload 23
    //   974: iconst_1
    //   975: invokestatic 463	com/tencent/luggage/wxa/rt/k:b	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   978: astore 25
    //   980: aload 25
    //   982: astore 24
    //   984: ldc_w 454
    //   987: astore 26
    //   989: ldc 57
    //   991: ldc_w 465
    //   994: iconst_1
    //   995: anewarray 4	java/lang/Object
    //   998: dup
    //   999: iconst_0
    //   1000: aload 22
    //   1002: aastore
    //   1003: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1006: new 467	java/util/HashMap
    //   1009: dup
    //   1010: bipush 10
    //   1012: invokespecial 469	java/util/HashMap:<init>	(I)V
    //   1015: astore 23
    //   1017: aload 23
    //   1019: ldc_w 471
    //   1022: ldc_w 473
    //   1025: invokeinterface 477 3 0
    //   1030: pop
    //   1031: lload 8
    //   1033: lload_2
    //   1034: lcmp
    //   1035: ifle +5753 -> 6788
    //   1038: ldc 57
    //   1040: ldc_w 479
    //   1043: iconst_2
    //   1044: anewarray 4	java/lang/Object
    //   1047: dup
    //   1048: iconst_0
    //   1049: lload_2
    //   1050: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1053: aastore
    //   1054: dup
    //   1055: iconst_1
    //   1056: lload 8
    //   1058: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1061: aastore
    //   1062: invokestatic 481	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1065: new 239	java/lang/StringBuilder
    //   1068: dup
    //   1069: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   1072: astore 27
    //   1074: aload 27
    //   1076: ldc_w 483
    //   1079: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: aload 27
    //   1085: lload_2
    //   1086: invokevirtual 486	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: aload 27
    //   1092: ldc_w 318
    //   1095: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload 27
    //   1101: lload 8
    //   1103: invokevirtual 486	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload 23
    //   1109: ldc_w 488
    //   1112: aload 27
    //   1114: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokeinterface 477 3 0
    //   1122: pop
    //   1123: goto +3 -> 1126
    //   1126: iload 20
    //   1128: ifne +105 -> 1233
    //   1131: aload 22
    //   1133: invokestatic 492	com/tencent/luggage/wxa/qq/e:a	(Ljava/lang/String;)Z
    //   1136: istore 20
    //   1138: iload 20
    //   1140: ifeq +101 -> 1241
    //   1143: goto +90 -> 1233
    //   1146: astore 22
    //   1148: aconst_null
    //   1149: astore 23
    //   1151: aload 25
    //   1153: astore 27
    //   1155: ldc_w 454
    //   1158: astore 25
    //   1160: ldc_w 452
    //   1163: astore 24
    //   1165: ldc_w 456
    //   1168: astore 26
    //   1170: aconst_null
    //   1171: astore 28
    //   1173: goto +5035 -> 6208
    //   1176: astore 23
    //   1178: aload 24
    //   1180: astore 22
    //   1182: aload 23
    //   1184: astore 24
    //   1186: goto +2869 -> 4055
    //   1189: astore 25
    //   1191: aload 24
    //   1193: astore 22
    //   1195: goto +3259 -> 4454
    //   1198: astore 22
    //   1200: aload 24
    //   1202: astore 25
    //   1204: aload 22
    //   1206: astore 24
    //   1208: goto +3677 -> 4885
    //   1211: astore 22
    //   1213: aload 24
    //   1215: astore 25
    //   1217: aload 22
    //   1219: astore 24
    //   1221: goto +4094 -> 5315
    //   1224: astore 25
    //   1226: aload 24
    //   1228: astore 22
    //   1230: goto +4571 -> 5801
    //   1233: ldc 57
    //   1235: ldc_w 494
    //   1238: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1241: new 239	java/lang/StringBuilder
    //   1244: dup
    //   1245: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   1248: astore 27
    //   1250: aload 27
    //   1252: ldc_w 496
    //   1255: invokestatic 501	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   1258: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload 27
    //   1264: ldc_w 503
    //   1267: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: pop
    //   1271: aload 27
    //   1273: invokestatic 73	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   1276: invokestatic 506	com/tencent/luggage/wxa/qq/e:a	(Landroid/content/Context;)Ljava/lang/String;
    //   1279: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: pop
    //   1283: aload 23
    //   1285: ldc_w 508
    //   1288: aload 27
    //   1290: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1293: invokeinterface 477 3 0
    //   1298: pop
    //   1299: aload_0
    //   1300: aload 22
    //   1302: aload 23
    //   1304: invokespecial 510	com/tencent/luggage/wxa/qh/b:a	(Ljava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   1307: astore 22
    //   1309: aload 22
    //   1311: invokevirtual 185	java/net/HttpURLConnection:getResponseCode	()I
    //   1314: istore_1
    //   1315: iload_1
    //   1316: sipush 200
    //   1319: if_icmpeq +392 -> 1711
    //   1322: iload_1
    //   1323: sipush 206
    //   1326: if_icmpeq +385 -> 1711
    //   1329: aload_0
    //   1330: iload_1
    //   1331: invokespecial 195	com/tencent/luggage/wxa/qh/b:a	(I)V
    //   1334: ldc 57
    //   1336: ldc_w 512
    //   1339: iconst_1
    //   1340: anewarray 4	java/lang/Object
    //   1343: dup
    //   1344: iconst_0
    //   1345: iload_1
    //   1346: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1349: aastore
    //   1350: invokestatic 214	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1353: aload_0
    //   1354: iload_1
    //   1355: putfield 44	com/tencent/luggage/wxa/qh/b:j	I
    //   1358: aload_0
    //   1359: iconst_m1
    //   1360: invokespecial 435	com/tencent/luggage/wxa/qh/b:b	(I)V
    //   1363: lload 4
    //   1365: lconst_0
    //   1366: lcmp
    //   1367: ifne +70 -> 1437
    //   1370: lload_2
    //   1371: lconst_0
    //   1372: lcmp
    //   1373: ifle +64 -> 1437
    //   1376: ldc 57
    //   1378: ldc_w 437
    //   1381: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1384: aload 24
    //   1386: lload_2
    //   1387: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   1390: goto +19 -> 1409
    //   1393: astore 23
    //   1395: ldc 57
    //   1397: aload 23
    //   1399: ldc_w 442
    //   1402: iconst_0
    //   1403: anewarray 4	java/lang/Object
    //   1406: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1409: aload_0
    //   1410: lload_2
    //   1411: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   1414: lload_2
    //   1415: ldc2_w 394
    //   1418: lcmp
    //   1419: ifge +66 -> 1485
    //   1422: new 283	com/tencent/luggage/wxa/qh/b$a
    //   1425: dup
    //   1426: aload_0
    //   1427: iconst_1
    //   1428: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   1431: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   1434: goto +51 -> 1485
    //   1437: lload 4
    //   1439: lconst_0
    //   1440: lcmp
    //   1441: ifeq +47 -> 1488
    //   1444: lload_2
    //   1445: lload 4
    //   1447: lcmp
    //   1448: ifeq +40 -> 1488
    //   1451: ldc 57
    //   1453: ldc_w 446
    //   1456: iconst_2
    //   1457: anewarray 4	java/lang/Object
    //   1460: dup
    //   1461: iconst_0
    //   1462: lload 4
    //   1464: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1467: aastore
    //   1468: dup
    //   1469: iconst_1
    //   1470: lload_2
    //   1471: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1474: aastore
    //   1475: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1478: aload_0
    //   1479: lload_2
    //   1480: lload 4
    //   1482: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   1485: goto +81 -> 1566
    //   1488: lload 4
    //   1490: lconst_0
    //   1491: lcmp
    //   1492: ifeq +66 -> 1558
    //   1495: lload_2
    //   1496: lload 4
    //   1498: lcmp
    //   1499: ifne +59 -> 1558
    //   1502: ldc 57
    //   1504: ldc_w 450
    //   1507: iconst_2
    //   1508: anewarray 4	java/lang/Object
    //   1511: dup
    //   1512: iconst_0
    //   1513: lload 4
    //   1515: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1518: aastore
    //   1519: dup
    //   1520: iconst_1
    //   1521: lload_2
    //   1522: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1525: aastore
    //   1526: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1529: aload_0
    //   1530: lload 4
    //   1532: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   1535: lload_2
    //   1536: ldc2_w 394
    //   1539: lcmp
    //   1540: ifge +26 -> 1566
    //   1543: new 283	com/tencent/luggage/wxa/qh/b$a
    //   1546: dup
    //   1547: aload_0
    //   1548: iconst_1
    //   1549: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   1552: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   1555: goto +11 -> 1566
    //   1558: ldc 57
    //   1560: ldc_w 452
    //   1563: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1566: aload 25
    //   1568: ifnull +27 -> 1595
    //   1571: aload 25
    //   1573: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   1576: goto +19 -> 1595
    //   1579: astore 23
    //   1581: ldc 57
    //   1583: aload 23
    //   1585: ldc_w 442
    //   1588: iconst_0
    //   1589: anewarray 4	java/lang/Object
    //   1592: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1595: aload 22
    //   1597: ifnull +31 -> 1628
    //   1600: aload 22
    //   1602: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1605: invokevirtual 103	java/io/InputStream:close	()V
    //   1608: goto +15 -> 1623
    //   1611: astore 23
    //   1613: ldc 57
    //   1615: aload 23
    //   1617: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1620: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1623: aload 22
    //   1625: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   1628: aload_0
    //   1629: iconst_1
    //   1630: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   1633: ldc 57
    //   1635: aload 26
    //   1637: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1640: return
    //   1641: astore 23
    //   1643: goto +2059 -> 3702
    //   1646: astore 25
    //   1648: aload 22
    //   1650: astore 23
    //   1652: aload 24
    //   1654: astore 22
    //   1656: aload 25
    //   1658: astore 24
    //   1660: goto +2398 -> 4058
    //   1663: astore 24
    //   1665: aload 22
    //   1667: astore 23
    //   1669: aload 24
    //   1671: astore 22
    //   1673: goto +2212 -> 3885
    //   1676: astore 25
    //   1678: aload 24
    //   1680: astore 23
    //   1682: aload 25
    //   1684: astore 24
    //   1686: goto +2290 -> 3976
    //   1689: astore 23
    //   1691: goto +2300 -> 3991
    //   1694: astore 25
    //   1696: aload 22
    //   1698: astore 23
    //   1700: aload 24
    //   1702: astore 22
    //   1704: aload 25
    //   1706: astore 24
    //   1708: goto +2298 -> 4006
    //   1711: ldc_w 446
    //   1714: astore 27
    //   1716: ldc 57
    //   1718: ldc_w 520
    //   1721: iconst_1
    //   1722: anewarray 4	java/lang/Object
    //   1725: dup
    //   1726: iconst_0
    //   1727: iload_1
    //   1728: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1731: aastore
    //   1732: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1735: new 239	java/lang/StringBuilder
    //   1738: dup
    //   1739: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   1742: astore 23
    //   1744: aload 23
    //   1746: ldc_w 522
    //   1749: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: pop
    //   1753: aload 23
    //   1755: aload 22
    //   1757: ldc_w 508
    //   1760: invokevirtual 525	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   1763: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: pop
    //   1767: ldc 57
    //   1769: aload 23
    //   1771: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: invokestatic 527	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1777: aload 22
    //   1779: invokevirtual 530	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1782: astore 23
    //   1784: ldc 57
    //   1786: ldc_w 532
    //   1789: iconst_1
    //   1790: anewarray 4	java/lang/Object
    //   1793: dup
    //   1794: iconst_0
    //   1795: aload 23
    //   1797: aastore
    //   1798: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1801: aload_0
    //   1802: aload 23
    //   1804: putfield 42	com/tencent/luggage/wxa/qh/b:i	Ljava/lang/String;
    //   1807: aload_0
    //   1808: getfield 42	com/tencent/luggage/wxa/qh/b:i	Ljava/lang/String;
    //   1811: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1814: istore 20
    //   1816: iload 20
    //   1818: ifne +93 -> 1911
    //   1821: aload_0
    //   1822: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   1825: getfield 534	com/tencent/luggage/wxa/qh/a:g	Ljava/lang/String;
    //   1828: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1831: ifeq +80 -> 1911
    //   1834: aload_0
    //   1835: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   1838: aload_0
    //   1839: getfield 42	com/tencent/luggage/wxa/qh/b:i	Ljava/lang/String;
    //   1842: putfield 534	com/tencent/luggage/wxa/qh/a:g	Ljava/lang/String;
    //   1845: aload_0
    //   1846: getfield 48	com/tencent/luggage/wxa/qh/b:c	Lcom/tencent/luggage/wxa/ig/e;
    //   1849: getfield 270	com/tencent/luggage/wxa/ig/e:c	Ljava/lang/String;
    //   1852: aload_0
    //   1853: getfield 42	com/tencent/luggage/wxa/qh/b:i	Ljava/lang/String;
    //   1856: invokestatic 535	com/tencent/luggage/wxa/qg/e:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1859: goto +52 -> 1911
    //   1862: astore 23
    //   1864: goto +1745 -> 3609
    //   1867: astore 24
    //   1869: aconst_null
    //   1870: astore 26
    //   1872: aload 22
    //   1874: astore 23
    //   1876: aload 26
    //   1878: astore 22
    //   1880: goto -990 -> 890
    //   1883: astore 24
    //   1885: aload 22
    //   1887: astore 23
    //   1889: aload 24
    //   1891: astore 22
    //   1893: goto +1992 -> 3885
    //   1896: astore 24
    //   1898: goto +1744 -> 3642
    //   1901: astore 23
    //   1903: goto +1744 -> 3647
    //   1906: astore 23
    //   1908: goto +1744 -> 3652
    //   1911: aload 22
    //   1913: ldc_w 537
    //   1916: invokevirtual 210	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1919: astore 30
    //   1921: aload_0
    //   1922: aload 30
    //   1924: invokespecial 539	com/tencent/luggage/wxa/qh/b:a	(Ljava/lang/String;)[J
    //   1927: astore 28
    //   1929: aload 22
    //   1931: ldc_w 541
    //   1934: invokevirtual 210	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1937: astore 29
    //   1939: aload 22
    //   1941: astore 23
    //   1943: aload 29
    //   1945: lconst_0
    //   1946: invokestatic 544	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;J)J
    //   1949: lstore 6
    //   1951: ldc 57
    //   1953: ldc_w 546
    //   1956: iconst_2
    //   1957: anewarray 4	java/lang/Object
    //   1960: dup
    //   1961: iconst_0
    //   1962: aload 30
    //   1964: aastore
    //   1965: dup
    //   1966: iconst_1
    //   1967: lload 6
    //   1969: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1972: aastore
    //   1973: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1976: aload 28
    //   1978: ifnonnull +95 -> 2073
    //   1981: ldc 57
    //   1983: ldc_w 548
    //   1986: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1989: lload_2
    //   1990: lstore 4
    //   1992: lload_2
    //   1993: lconst_0
    //   1994: lcmp
    //   1995: ifeq +6 -> 2001
    //   1998: lconst_0
    //   1999: lstore 4
    //   2001: lload 4
    //   2003: lstore_2
    //   2004: lload 6
    //   2006: lstore 4
    //   2008: goto +408 -> 2416
    //   2011: astore 22
    //   2013: goto -862 -> 1151
    //   2016: astore 24
    //   2018: goto -149 -> 1869
    //   2021: astore 25
    //   2023: aload 24
    //   2025: astore 22
    //   2027: goto +2430 -> 4457
    //   2030: astore 22
    //   2032: aload 24
    //   2034: astore 25
    //   2036: aload 22
    //   2038: astore 24
    //   2040: aload 23
    //   2042: astore 22
    //   2044: goto +2844 -> 4888
    //   2047: astore 22
    //   2049: aload 24
    //   2051: astore 25
    //   2053: aload 22
    //   2055: astore 24
    //   2057: aload 23
    //   2059: astore 22
    //   2061: goto +3257 -> 5318
    //   2064: astore 25
    //   2066: aload 24
    //   2068: astore 22
    //   2070: goto +3734 -> 5804
    //   2073: lload_2
    //   2074: lconst_0
    //   2075: lcmp
    //   2076: ifle +334 -> 2410
    //   2079: lload_2
    //   2080: aload 28
    //   2082: iconst_0
    //   2083: laload
    //   2084: lcmp
    //   2085: ifeq +325 -> 2410
    //   2088: ldc 57
    //   2090: ldc_w 550
    //   2093: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2096: aload_0
    //   2097: bipush 6
    //   2099: invokespecial 435	com/tencent/luggage/wxa/qh/b:b	(I)V
    //   2102: lload 4
    //   2104: lconst_0
    //   2105: lcmp
    //   2106: ifne +70 -> 2176
    //   2109: lload_2
    //   2110: lconst_0
    //   2111: lcmp
    //   2112: ifle +64 -> 2176
    //   2115: ldc 57
    //   2117: ldc_w 437
    //   2120: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2123: aload 24
    //   2125: lload_2
    //   2126: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   2129: goto +19 -> 2148
    //   2132: astore 22
    //   2134: ldc 57
    //   2136: aload 22
    //   2138: ldc_w 442
    //   2141: iconst_0
    //   2142: anewarray 4	java/lang/Object
    //   2145: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2148: aload_0
    //   2149: lload_2
    //   2150: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   2153: lload_2
    //   2154: ldc2_w 394
    //   2157: lcmp
    //   2158: ifge +65 -> 2223
    //   2161: new 283	com/tencent/luggage/wxa/qh/b$a
    //   2164: dup
    //   2165: aload_0
    //   2166: iconst_1
    //   2167: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   2170: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   2173: goto +50 -> 2223
    //   2176: lload 4
    //   2178: lconst_0
    //   2179: lcmp
    //   2180: ifeq +46 -> 2226
    //   2183: lload_2
    //   2184: lload 4
    //   2186: lcmp
    //   2187: ifeq +39 -> 2226
    //   2190: ldc 57
    //   2192: aload 27
    //   2194: iconst_2
    //   2195: anewarray 4	java/lang/Object
    //   2198: dup
    //   2199: iconst_0
    //   2200: lload 4
    //   2202: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2205: aastore
    //   2206: dup
    //   2207: iconst_1
    //   2208: lload_2
    //   2209: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2212: aastore
    //   2213: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2216: aload_0
    //   2217: lload_2
    //   2218: lload 4
    //   2220: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   2223: goto +81 -> 2304
    //   2226: lload 4
    //   2228: lconst_0
    //   2229: lcmp
    //   2230: ifeq +66 -> 2296
    //   2233: lload_2
    //   2234: lload 4
    //   2236: lcmp
    //   2237: ifne +59 -> 2296
    //   2240: ldc 57
    //   2242: ldc_w 450
    //   2245: iconst_2
    //   2246: anewarray 4	java/lang/Object
    //   2249: dup
    //   2250: iconst_0
    //   2251: lload 4
    //   2253: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2256: aastore
    //   2257: dup
    //   2258: iconst_1
    //   2259: lload_2
    //   2260: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2263: aastore
    //   2264: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2267: aload_0
    //   2268: lload 4
    //   2270: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   2273: lload_2
    //   2274: ldc2_w 394
    //   2277: lcmp
    //   2278: ifge +26 -> 2304
    //   2281: new 283	com/tencent/luggage/wxa/qh/b$a
    //   2284: dup
    //   2285: aload_0
    //   2286: iconst_1
    //   2287: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   2290: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   2293: goto +11 -> 2304
    //   2296: ldc 57
    //   2298: ldc_w 452
    //   2301: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2304: aload 25
    //   2306: ifnull +27 -> 2333
    //   2309: aload 25
    //   2311: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   2314: goto +19 -> 2333
    //   2317: astore 22
    //   2319: ldc 57
    //   2321: aload 22
    //   2323: ldc_w 442
    //   2326: iconst_0
    //   2327: anewarray 4	java/lang/Object
    //   2330: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2333: aload 23
    //   2335: ifnull +31 -> 2366
    //   2338: aload 23
    //   2340: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2343: invokevirtual 103	java/io/InputStream:close	()V
    //   2346: goto +15 -> 2361
    //   2349: astore 22
    //   2351: ldc 57
    //   2353: aload 22
    //   2355: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2358: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2361: aload 23
    //   2363: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   2366: aload_0
    //   2367: iconst_1
    //   2368: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   2371: ldc 57
    //   2373: ldc_w 454
    //   2376: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2379: return
    //   2380: astore 23
    //   2382: goto -518 -> 1864
    //   2385: astore 24
    //   2387: goto -518 -> 1869
    //   2390: astore 23
    //   2392: goto +1293 -> 3685
    //   2395: astore 24
    //   2397: goto -499 -> 1898
    //   2400: astore 23
    //   2402: goto -499 -> 1903
    //   2405: astore 23
    //   2407: goto -499 -> 1908
    //   2410: aload 28
    //   2412: iconst_2
    //   2413: laload
    //   2414: lstore 4
    //   2416: ldc_w 450
    //   2419: astore 26
    //   2421: aload 25
    //   2423: astore 22
    //   2425: lload 4
    //   2427: lconst_0
    //   2428: lcmp
    //   2429: ifeq +10 -> 2439
    //   2432: lload 4
    //   2434: lstore 18
    //   2436: goto +8 -> 2444
    //   2439: ldc2_w 551
    //   2442: lstore 18
    //   2444: ldc 57
    //   2446: ldc_w 554
    //   2449: iconst_3
    //   2450: anewarray 4	java/lang/Object
    //   2453: dup
    //   2454: iconst_0
    //   2455: lload 18
    //   2457: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2460: aastore
    //   2461: dup
    //   2462: iconst_1
    //   2463: lload_2
    //   2464: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2467: aastore
    //   2468: dup
    //   2469: iconst_2
    //   2470: aload_0
    //   2471: getfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   2474: invokestatic 352	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2477: aastore
    //   2478: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2481: aload 22
    //   2483: lload 18
    //   2485: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   2488: aload 22
    //   2490: lload_2
    //   2491: invokevirtual 557	java/io/RandomAccessFile:seek	(J)V
    //   2494: aload 23
    //   2496: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2499: astore 24
    //   2501: sipush 4096
    //   2504: newarray byte
    //   2506: astore 25
    //   2508: aload_0
    //   2509: getfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   2512: istore 20
    //   2514: iload 20
    //   2516: ifne +268 -> 2784
    //   2519: aload 24
    //   2521: aload 25
    //   2523: invokevirtual 561	java/io/InputStream:read	([B)I
    //   2526: istore_1
    //   2527: iload_1
    //   2528: ifle +101 -> 2629
    //   2531: lload_2
    //   2532: lstore 6
    //   2534: lload_2
    //   2535: lstore 12
    //   2537: lload_2
    //   2538: lstore 16
    //   2540: lload_2
    //   2541: lstore 14
    //   2543: lload_2
    //   2544: lstore 8
    //   2546: lload_2
    //   2547: lstore 10
    //   2549: aload 22
    //   2551: aload 25
    //   2553: iconst_0
    //   2554: iload_1
    //   2555: invokevirtual 565	java/io/RandomAccessFile:write	([BII)V
    //   2558: lload_2
    //   2559: iload_1
    //   2560: i2l
    //   2561: ladd
    //   2562: lstore_2
    //   2563: lload_2
    //   2564: lstore 6
    //   2566: lload_2
    //   2567: lstore 12
    //   2569: lload_2
    //   2570: lstore 16
    //   2572: lload_2
    //   2573: lstore 14
    //   2575: lload_2
    //   2576: lstore 8
    //   2578: lload_2
    //   2579: lstore 10
    //   2581: aload_0
    //   2582: lload_2
    //   2583: lload 18
    //   2585: invokespecial 567	com/tencent/luggage/wxa/qh/b:a	(JJ)V
    //   2588: lload_2
    //   2589: ldc2_w 394
    //   2592: lcmp
    //   2593: iflt +4198 -> 6791
    //   2596: lload_2
    //   2597: lstore 6
    //   2599: lload_2
    //   2600: lstore 12
    //   2602: lload_2
    //   2603: lstore 16
    //   2605: lload_2
    //   2606: lstore 14
    //   2608: lload_2
    //   2609: lstore 8
    //   2611: lload_2
    //   2612: lstore 10
    //   2614: new 283	com/tencent/luggage/wxa/qh/b$a
    //   2617: dup
    //   2618: aload_0
    //   2619: iconst_1
    //   2620: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   2623: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   2626: goto +4165 -> 6791
    //   2629: lload_2
    //   2630: lstore 6
    //   2632: lload_2
    //   2633: lstore 12
    //   2635: lload_2
    //   2636: lstore 16
    //   2638: lload_2
    //   2639: lstore 14
    //   2641: lload_2
    //   2642: lstore 8
    //   2644: lload_2
    //   2645: lstore 10
    //   2647: ldc 57
    //   2649: ldc_w 569
    //   2652: iconst_4
    //   2653: anewarray 4	java/lang/Object
    //   2656: dup
    //   2657: iconst_0
    //   2658: iload_1
    //   2659: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2662: aastore
    //   2663: dup
    //   2664: iconst_1
    //   2665: aload_0
    //   2666: getfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   2669: invokestatic 352	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2672: aastore
    //   2673: dup
    //   2674: iconst_2
    //   2675: lload_2
    //   2676: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2679: aastore
    //   2680: dup
    //   2681: iconst_3
    //   2682: lload 18
    //   2684: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2687: aastore
    //   2688: invokestatic 214	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2691: goto +93 -> 2784
    //   2694: astore 25
    //   2696: aload 24
    //   2698: astore 28
    //   2700: aload 25
    //   2702: astore 24
    //   2704: goto +450 -> 3154
    //   2707: astore 25
    //   2709: aload 24
    //   2711: astore 26
    //   2713: aload 25
    //   2715: astore 24
    //   2717: aload 22
    //   2719: astore 25
    //   2721: aload 26
    //   2723: astore 22
    //   2725: goto -1835 -> 890
    //   2728: astore 25
    //   2730: aload 25
    //   2732: astore 29
    //   2734: aload 24
    //   2736: astore 25
    //   2738: goto +477 -> 3215
    //   2741: astore 25
    //   2743: aload 25
    //   2745: astore 26
    //   2747: aload 24
    //   2749: astore 25
    //   2751: aload 26
    //   2753: astore 24
    //   2755: goto +485 -> 3240
    //   2758: astore 25
    //   2760: aload 25
    //   2762: astore 26
    //   2764: aload 24
    //   2766: astore 25
    //   2768: aload 26
    //   2770: astore 24
    //   2772: goto +485 -> 3257
    //   2775: astore 25
    //   2777: aload 24
    //   2779: astore 26
    //   2781: goto +485 -> 3266
    //   2784: ldc 57
    //   2786: ldc_w 571
    //   2789: iconst_1
    //   2790: anewarray 4	java/lang/Object
    //   2793: dup
    //   2794: iconst_0
    //   2795: aload_0
    //   2796: getfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   2799: invokestatic 352	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2802: aastore
    //   2803: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2806: lload 4
    //   2808: lconst_0
    //   2809: lcmp
    //   2810: ifne +70 -> 2880
    //   2813: lload_2
    //   2814: lconst_0
    //   2815: lcmp
    //   2816: ifle +64 -> 2880
    //   2819: ldc 57
    //   2821: ldc_w 437
    //   2824: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2827: aload 22
    //   2829: lload_2
    //   2830: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   2833: goto +19 -> 2852
    //   2836: astore 25
    //   2838: ldc 57
    //   2840: aload 25
    //   2842: ldc_w 442
    //   2845: iconst_0
    //   2846: anewarray 4	java/lang/Object
    //   2849: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2852: aload_0
    //   2853: lload_2
    //   2854: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   2857: lload_2
    //   2858: ldc2_w 394
    //   2861: lcmp
    //   2862: ifge +65 -> 2927
    //   2865: new 283	com/tencent/luggage/wxa/qh/b$a
    //   2868: dup
    //   2869: aload_0
    //   2870: iconst_1
    //   2871: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   2874: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   2877: goto +50 -> 2927
    //   2880: lload 4
    //   2882: lconst_0
    //   2883: lcmp
    //   2884: ifeq +46 -> 2930
    //   2887: lload_2
    //   2888: lload 4
    //   2890: lcmp
    //   2891: ifeq +39 -> 2930
    //   2894: ldc 57
    //   2896: aload 27
    //   2898: iconst_2
    //   2899: anewarray 4	java/lang/Object
    //   2902: dup
    //   2903: iconst_0
    //   2904: lload 4
    //   2906: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2909: aastore
    //   2910: dup
    //   2911: iconst_1
    //   2912: lload_2
    //   2913: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2916: aastore
    //   2917: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2920: aload_0
    //   2921: lload_2
    //   2922: lload 4
    //   2924: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   2927: goto +80 -> 3007
    //   2930: lload 4
    //   2932: lconst_0
    //   2933: lcmp
    //   2934: ifeq +65 -> 2999
    //   2937: lload_2
    //   2938: lload 4
    //   2940: lcmp
    //   2941: ifne +58 -> 2999
    //   2944: ldc 57
    //   2946: aload 26
    //   2948: iconst_2
    //   2949: anewarray 4	java/lang/Object
    //   2952: dup
    //   2953: iconst_0
    //   2954: lload 4
    //   2956: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2959: aastore
    //   2960: dup
    //   2961: iconst_1
    //   2962: lload_2
    //   2963: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2966: aastore
    //   2967: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2970: aload_0
    //   2971: lload 4
    //   2973: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   2976: lload_2
    //   2977: ldc2_w 394
    //   2980: lcmp
    //   2981: ifge +26 -> 3007
    //   2984: new 283	com/tencent/luggage/wxa/qh/b$a
    //   2987: dup
    //   2988: aload_0
    //   2989: iconst_1
    //   2990: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   2993: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   2996: goto +11 -> 3007
    //   2999: ldc 57
    //   3001: ldc_w 452
    //   3004: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   3007: aload 24
    //   3009: ifnull +30 -> 3039
    //   3012: aload 24
    //   3014: invokevirtual 103	java/io/InputStream:close	()V
    //   3017: goto +22 -> 3039
    //   3020: astore 24
    //   3022: ldc 57
    //   3024: aload 24
    //   3026: ldc_w 456
    //   3029: iconst_0
    //   3030: anewarray 4	java/lang/Object
    //   3033: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3036: goto +3 -> 3039
    //   3039: aload 22
    //   3041: ifnull +27 -> 3068
    //   3044: aload 22
    //   3046: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   3049: goto +19 -> 3068
    //   3052: astore 22
    //   3054: ldc 57
    //   3056: aload 22
    //   3058: ldc_w 442
    //   3061: iconst_0
    //   3062: anewarray 4	java/lang/Object
    //   3065: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3068: aload 23
    //   3070: ifnull +31 -> 3101
    //   3073: aload 23
    //   3075: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3078: invokevirtual 103	java/io/InputStream:close	()V
    //   3081: goto +15 -> 3096
    //   3084: astore 22
    //   3086: ldc 57
    //   3088: aload 22
    //   3090: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3093: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3096: aload 23
    //   3098: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   3101: aload_0
    //   3102: iconst_1
    //   3103: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   3106: ldc_w 454
    //   3109: astore 22
    //   3111: goto +3041 -> 6152
    //   3114: astore 25
    //   3116: goto +30 -> 3146
    //   3119: astore 25
    //   3121: goto +65 -> 3186
    //   3124: astore 25
    //   3126: goto +81 -> 3207
    //   3129: astore 25
    //   3131: goto +97 -> 3228
    //   3134: astore 25
    //   3136: goto +109 -> 3245
    //   3139: astore 25
    //   3141: goto +121 -> 3262
    //   3144: astore 25
    //   3146: aload 24
    //   3148: astore 28
    //   3150: aload 25
    //   3152: astore 24
    //   3154: aload 22
    //   3156: astore 27
    //   3158: ldc_w 454
    //   3161: astore 25
    //   3163: ldc_w 452
    //   3166: astore 29
    //   3168: ldc_w 456
    //   3171: astore 26
    //   3173: aload 24
    //   3175: astore 22
    //   3177: aload 29
    //   3179: astore 24
    //   3181: goto +862 -> 4043
    //   3184: astore 25
    //   3186: aload 24
    //   3188: astore 26
    //   3190: aload 25
    //   3192: astore 24
    //   3194: aload 22
    //   3196: astore 25
    //   3198: aload 26
    //   3200: astore 22
    //   3202: goto -2312 -> 890
    //   3205: astore 25
    //   3207: aload 25
    //   3209: astore 29
    //   3211: aload 24
    //   3213: astore 25
    //   3215: aload 23
    //   3217: astore 24
    //   3219: aload 25
    //   3221: astore 23
    //   3223: goto -2315 -> 908
    //   3226: astore 25
    //   3228: aload 25
    //   3230: astore 26
    //   3232: aload 24
    //   3234: astore 25
    //   3236: aload 26
    //   3238: astore 24
    //   3240: goto +3507 -> 6747
    //   3243: astore 25
    //   3245: aload 25
    //   3247: astore 26
    //   3249: aload 24
    //   3251: astore 25
    //   3253: aload 26
    //   3255: astore 24
    //   3257: goto +3505 -> 6762
    //   3260: astore 25
    //   3262: aload 24
    //   3264: astore 26
    //   3266: goto +3511 -> 6777
    //   3269: astore 25
    //   3271: aload 24
    //   3273: astore 28
    //   3275: aload 22
    //   3277: astore 27
    //   3279: ldc_w 452
    //   3282: astore 24
    //   3284: ldc_w 454
    //   3287: astore 29
    //   3289: ldc_w 456
    //   3292: astore 26
    //   3294: aload 25
    //   3296: astore 22
    //   3298: aload 29
    //   3300: astore 25
    //   3302: goto +2906 -> 6208
    //   3305: astore 25
    //   3307: aload 24
    //   3309: astore 26
    //   3311: aload 25
    //   3313: astore 24
    //   3315: aload 22
    //   3317: astore 25
    //   3319: goto +746 -> 4065
    //   3322: astore 29
    //   3324: aload 24
    //   3326: astore 25
    //   3328: lload 4
    //   3330: lstore 8
    //   3332: aload 23
    //   3334: astore 24
    //   3336: aload 25
    //   3338: astore 23
    //   3340: goto +1132 -> 4472
    //   3343: astore 26
    //   3345: aload 24
    //   3347: astore 25
    //   3349: aload 26
    //   3351: astore 24
    //   3353: lload 4
    //   3355: lstore 8
    //   3357: aload 23
    //   3359: astore 29
    //   3361: aload 25
    //   3363: astore 23
    //   3365: goto +1538 -> 4903
    //   3368: astore 26
    //   3370: aload 24
    //   3372: astore 25
    //   3374: aload 26
    //   3376: astore 24
    //   3378: lload 4
    //   3380: lstore 8
    //   3382: aload 23
    //   3384: astore 29
    //   3386: aload 25
    //   3388: astore 23
    //   3390: goto +1955 -> 5345
    //   3393: astore 25
    //   3395: aload 24
    //   3397: astore 26
    //   3399: goto +71 -> 3470
    //   3402: astore 22
    //   3404: goto +30 -> 3434
    //   3407: astore 24
    //   3409: goto +30 -> 3439
    //   3412: astore 24
    //   3414: goto +30 -> 3444
    //   3417: astore 24
    //   3419: goto +34 -> 3453
    //   3422: astore 24
    //   3424: goto +34 -> 3458
    //   3427: astore 24
    //   3429: goto +34 -> 3463
    //   3432: astore 22
    //   3434: goto -1421 -> 2013
    //   3437: astore 24
    //   3439: goto +619 -> 4058
    //   3442: astore 24
    //   3444: aload 24
    //   3446: astore 29
    //   3448: goto +63 -> 3511
    //   3451: astore 24
    //   3453: goto +78 -> 3531
    //   3456: astore 24
    //   3458: goto +93 -> 3551
    //   3461: astore 24
    //   3463: aconst_null
    //   3464: astore 26
    //   3466: aload 24
    //   3468: astore 25
    //   3470: aload 23
    //   3472: astore 24
    //   3474: aload 26
    //   3476: astore 23
    //   3478: goto +2333 -> 5811
    //   3481: astore 22
    //   3483: ldc_w 454
    //   3486: astore 22
    //   3488: ldc_w 452
    //   3491: astore 22
    //   3493: ldc_w 456
    //   3496: astore 22
    //   3498: aconst_null
    //   3499: astore 22
    //   3501: goto +542 -> 4043
    //   3504: astore 22
    //   3506: goto +213 -> 3719
    //   3509: astore 24
    //   3511: aconst_null
    //   3512: astore 25
    //   3514: lload 4
    //   3516: lstore 8
    //   3518: aload 23
    //   3520: astore 24
    //   3522: aload 25
    //   3524: astore 23
    //   3526: goto +946 -> 4472
    //   3529: astore 25
    //   3531: aconst_null
    //   3532: astore 25
    //   3534: lload 4
    //   3536: lstore 8
    //   3538: aload 23
    //   3540: astore 29
    //   3542: aload 25
    //   3544: astore 23
    //   3546: goto +1357 -> 4903
    //   3549: astore 25
    //   3551: aconst_null
    //   3552: astore 25
    //   3554: lload 4
    //   3556: lstore 8
    //   3558: aload 23
    //   3560: astore 29
    //   3562: aload 25
    //   3564: astore 23
    //   3566: goto +1779 -> 5345
    //   3569: astore 22
    //   3571: aconst_null
    //   3572: astore 22
    //   3574: goto +2237 -> 5811
    //   3577: astore 23
    //   3579: goto +30 -> 3609
    //   3582: astore 23
    //   3584: goto +48 -> 3632
    //   3587: astore 23
    //   3589: goto +48 -> 3637
    //   3592: astore 24
    //   3594: goto +48 -> 3642
    //   3597: astore 23
    //   3599: goto +48 -> 3647
    //   3602: astore 23
    //   3604: goto +48 -> 3652
    //   3607: astore 23
    //   3609: aload 25
    //   3611: astore 27
    //   3613: aload 22
    //   3615: astore 28
    //   3617: ldc_w 456
    //   3620: astore 30
    //   3622: ldc_w 452
    //   3625: astore 24
    //   3627: goto +32 -> 3659
    //   3630: astore 23
    //   3632: goto +87 -> 3719
    //   3635: astore 23
    //   3637: goto +48 -> 3685
    //   3640: astore 24
    //   3642: goto +111 -> 3753
    //   3645: astore 23
    //   3647: goto +115 -> 3762
    //   3650: astore 23
    //   3652: aload 23
    //   3654: astore 24
    //   3656: goto +115 -> 3771
    //   3659: aconst_null
    //   3660: astore 29
    //   3662: aload 26
    //   3664: astore 25
    //   3666: aload 23
    //   3668: astore 22
    //   3670: aload 30
    //   3672: astore 26
    //   3674: aload 28
    //   3676: astore 23
    //   3678: aload 29
    //   3680: astore 28
    //   3682: goto +2526 -> 6208
    //   3685: aload 22
    //   3687: astore 24
    //   3689: aload 23
    //   3691: astore 22
    //   3693: aload 24
    //   3695: astore 23
    //   3697: goto +188 -> 3885
    //   3700: astore 23
    //   3702: aload 22
    //   3704: astore 25
    //   3706: aload 23
    //   3708: astore 22
    //   3710: aload 25
    //   3712: astore 23
    //   3714: goto +143 -> 3857
    //   3717: astore 23
    //   3719: aload 22
    //   3721: astore 26
    //   3723: aload 25
    //   3725: astore 22
    //   3727: aload 23
    //   3729: astore 24
    //   3731: aload 26
    //   3733: astore 23
    //   3735: goto +323 -> 4058
    //   3738: astore 24
    //   3740: aload 22
    //   3742: astore 23
    //   3744: aload 24
    //   3746: astore 22
    //   3748: goto +137 -> 3885
    //   3751: astore 24
    //   3753: aload 25
    //   3755: astore 23
    //   3757: goto +219 -> 3976
    //   3760: astore 23
    //   3762: aload 25
    //   3764: astore 24
    //   3766: goto +225 -> 3991
    //   3769: astore 24
    //   3771: aload 22
    //   3773: astore 23
    //   3775: aload 25
    //   3777: astore 22
    //   3779: goto +227 -> 4006
    //   3782: astore 22
    //   3784: goto +30 -> 3814
    //   3787: astore 22
    //   3789: goto +82 -> 3871
    //   3792: astore 22
    //   3794: goto +88 -> 3882
    //   3797: astore 24
    //   3799: goto +30 -> 3829
    //   3802: astore 23
    //   3804: goto +34 -> 3838
    //   3807: astore 24
    //   3809: goto +38 -> 3847
    //   3812: astore 22
    //   3814: goto +40 -> 3854
    //   3817: astore 22
    //   3819: goto +52 -> 3871
    //   3822: astore 22
    //   3824: goto +58 -> 3882
    //   3827: astore 24
    //   3829: aload 25
    //   3831: astore 23
    //   3833: goto +140 -> 3973
    //   3836: astore 23
    //   3838: aload 25
    //   3840: astore 24
    //   3842: goto +146 -> 3988
    //   3845: astore 24
    //   3847: aload 25
    //   3849: astore 22
    //   3851: goto +152 -> 4003
    //   3854: aconst_null
    //   3855: astore 23
    //   3857: aconst_null
    //   3858: astore 28
    //   3860: aload 24
    //   3862: astore 27
    //   3864: aload 26
    //   3866: astore 24
    //   3868: goto +560 -> 4428
    //   3871: aload 22
    //   3873: astore 24
    //   3875: aload 25
    //   3877: astore 22
    //   3879: goto +176 -> 4055
    //   3882: aconst_null
    //   3883: astore 23
    //   3885: aload 25
    //   3887: astore 24
    //   3889: aload 22
    //   3891: astore 25
    //   3893: aload 24
    //   3895: astore 22
    //   3897: aload 23
    //   3899: astore 24
    //   3901: goto +560 -> 4461
    //   3904: astore 22
    //   3906: goto +142 -> 4048
    //   3909: astore 25
    //   3911: goto +54 -> 3965
    //   3914: astore 24
    //   3916: goto +54 -> 3970
    //   3919: astore 23
    //   3921: goto +64 -> 3985
    //   3924: astore 24
    //   3926: goto +74 -> 4000
    //   3929: astore 22
    //   3931: ldc_w 452
    //   3934: astore 24
    //   3936: aconst_null
    //   3937: astore 27
    //   3939: aconst_null
    //   3940: astore 23
    //   3942: aconst_null
    //   3943: astore 28
    //   3945: ldc_w 454
    //   3948: astore 25
    //   3950: ldc_w 456
    //   3953: astore 26
    //   3955: goto +2253 -> 6208
    //   3958: astore 22
    //   3960: goto +88 -> 4048
    //   3963: astore 25
    //   3965: goto +486 -> 4451
    //   3968: astore 24
    //   3970: aconst_null
    //   3971: astore 23
    //   3973: aconst_null
    //   3974: astore 22
    //   3976: aload 23
    //   3978: astore 25
    //   3980: goto +908 -> 4888
    //   3983: astore 23
    //   3985: aconst_null
    //   3986: astore 24
    //   3988: aconst_null
    //   3989: astore 22
    //   3991: aload 24
    //   3993: astore 25
    //   3995: goto +1327 -> 5322
    //   3998: astore 24
    //   4000: aconst_null
    //   4001: astore 22
    //   4003: aconst_null
    //   4004: astore 23
    //   4006: aload 24
    //   4008: astore 25
    //   4010: aload 23
    //   4012: astore 24
    //   4014: goto +1794 -> 5808
    //   4017: astore 22
    //   4019: ldc_w 456
    //   4022: astore 26
    //   4024: ldc_w 452
    //   4027: astore 24
    //   4029: aconst_null
    //   4030: astore 27
    //   4032: aconst_null
    //   4033: astore 23
    //   4035: aconst_null
    //   4036: astore 28
    //   4038: ldc_w 454
    //   4041: astore 25
    //   4043: goto +2165 -> 6208
    //   4046: astore 22
    //   4048: aload 22
    //   4050: astore 24
    //   4052: aconst_null
    //   4053: astore 22
    //   4055: aconst_null
    //   4056: astore 23
    //   4058: aconst_null
    //   4059: astore 26
    //   4061: aload 22
    //   4063: astore 25
    //   4065: ldc_w 454
    //   4068: astore 27
    //   4070: ldc 57
    //   4072: aload 24
    //   4074: ldc_w 573
    //   4077: iconst_1
    //   4078: anewarray 4	java/lang/Object
    //   4081: dup
    //   4082: iconst_0
    //   4083: aload 31
    //   4085: invokevirtual 417	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   4088: aastore
    //   4089: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4092: aload_0
    //   4093: sipush 754
    //   4096: putfield 46	com/tencent/luggage/wxa/qh/b:k	I
    //   4099: aload_0
    //   4100: iconst_5
    //   4101: invokespecial 435	com/tencent/luggage/wxa/qh/b:b	(I)V
    //   4104: lload 4
    //   4106: lconst_0
    //   4107: lcmp
    //   4108: ifne +70 -> 4178
    //   4111: lload_2
    //   4112: lconst_0
    //   4113: lcmp
    //   4114: ifle +64 -> 4178
    //   4117: ldc 57
    //   4119: ldc_w 437
    //   4122: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   4125: aload 25
    //   4127: lload_2
    //   4128: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   4131: goto +19 -> 4150
    //   4134: astore 22
    //   4136: ldc 57
    //   4138: aload 22
    //   4140: ldc_w 442
    //   4143: iconst_0
    //   4144: anewarray 4	java/lang/Object
    //   4147: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4150: aload_0
    //   4151: lload_2
    //   4152: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   4155: lload_2
    //   4156: ldc2_w 394
    //   4159: lcmp
    //   4160: ifge +66 -> 4226
    //   4163: new 283	com/tencent/luggage/wxa/qh/b$a
    //   4166: dup
    //   4167: aload_0
    //   4168: iconst_1
    //   4169: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   4172: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   4175: goto +51 -> 4226
    //   4178: lload 4
    //   4180: lconst_0
    //   4181: lcmp
    //   4182: ifeq +47 -> 4229
    //   4185: lload_2
    //   4186: lload 4
    //   4188: lcmp
    //   4189: ifeq +40 -> 4229
    //   4192: ldc 57
    //   4194: ldc_w 446
    //   4197: iconst_2
    //   4198: anewarray 4	java/lang/Object
    //   4201: dup
    //   4202: iconst_0
    //   4203: lload 4
    //   4205: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4208: aastore
    //   4209: dup
    //   4210: iconst_1
    //   4211: lload_2
    //   4212: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4215: aastore
    //   4216: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4219: aload_0
    //   4220: lload_2
    //   4221: lload 4
    //   4223: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   4226: goto +81 -> 4307
    //   4229: lload 4
    //   4231: lconst_0
    //   4232: lcmp
    //   4233: ifeq +66 -> 4299
    //   4236: lload_2
    //   4237: lload 4
    //   4239: lcmp
    //   4240: ifne +59 -> 4299
    //   4243: ldc 57
    //   4245: ldc_w 450
    //   4248: iconst_2
    //   4249: anewarray 4	java/lang/Object
    //   4252: dup
    //   4253: iconst_0
    //   4254: lload 4
    //   4256: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4259: aastore
    //   4260: dup
    //   4261: iconst_1
    //   4262: lload_2
    //   4263: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4266: aastore
    //   4267: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4270: aload_0
    //   4271: lload 4
    //   4273: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   4276: lload_2
    //   4277: ldc2_w 394
    //   4280: lcmp
    //   4281: ifge +26 -> 4307
    //   4284: new 283	com/tencent/luggage/wxa/qh/b$a
    //   4287: dup
    //   4288: aload_0
    //   4289: iconst_1
    //   4290: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   4293: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   4296: goto +11 -> 4307
    //   4299: ldc 57
    //   4301: ldc_w 452
    //   4304: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   4307: aload 26
    //   4309: ifnull +30 -> 4339
    //   4312: aload 26
    //   4314: invokevirtual 103	java/io/InputStream:close	()V
    //   4317: goto +22 -> 4339
    //   4320: astore 22
    //   4322: ldc 57
    //   4324: aload 22
    //   4326: ldc_w 456
    //   4329: iconst_0
    //   4330: anewarray 4	java/lang/Object
    //   4333: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4336: goto +3 -> 4339
    //   4339: aload 25
    //   4341: ifnull +27 -> 4368
    //   4344: aload 25
    //   4346: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   4349: goto +19 -> 4368
    //   4352: astore 22
    //   4354: ldc 57
    //   4356: aload 22
    //   4358: ldc_w 442
    //   4361: iconst_0
    //   4362: anewarray 4	java/lang/Object
    //   4365: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4368: aload 23
    //   4370: ifnull +31 -> 4401
    //   4373: aload 23
    //   4375: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4378: invokevirtual 103	java/io/InputStream:close	()V
    //   4381: goto +15 -> 4396
    //   4384: astore 22
    //   4386: ldc 57
    //   4388: aload 22
    //   4390: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4393: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4396: aload 23
    //   4398: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   4401: aload_0
    //   4402: iconst_1
    //   4403: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   4406: ldc 57
    //   4408: aload 27
    //   4410: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   4413: return
    //   4414: astore 22
    //   4416: aload 27
    //   4418: astore 24
    //   4420: aload 26
    //   4422: astore 28
    //   4424: aload 25
    //   4426: astore 27
    //   4428: ldc_w 456
    //   4431: astore 26
    //   4433: ldc_w 452
    //   4436: astore 29
    //   4438: aload 24
    //   4440: astore 25
    //   4442: aload 29
    //   4444: astore 24
    //   4446: goto +1762 -> 6208
    //   4449: astore 25
    //   4451: aconst_null
    //   4452: astore 22
    //   4454: aconst_null
    //   4455: astore 23
    //   4457: aload 23
    //   4459: astore 24
    //   4461: aconst_null
    //   4462: astore 23
    //   4464: lload 4
    //   4466: lstore 8
    //   4468: aload 25
    //   4470: astore 29
    //   4472: ldc_w 452
    //   4475: astore 30
    //   4477: aload 22
    //   4479: astore 28
    //   4481: lload_2
    //   4482: lstore 6
    //   4484: lload 8
    //   4486: lstore 4
    //   4488: aload 24
    //   4490: astore 26
    //   4492: aload 23
    //   4494: astore 25
    //   4496: aload 30
    //   4498: astore 27
    //   4500: ldc 57
    //   4502: aload 29
    //   4504: ldc_w 573
    //   4507: iconst_1
    //   4508: anewarray 4	java/lang/Object
    //   4511: dup
    //   4512: iconst_0
    //   4513: aload 31
    //   4515: invokevirtual 417	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   4518: aastore
    //   4519: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4522: aload 22
    //   4524: astore 28
    //   4526: lload_2
    //   4527: lstore 6
    //   4529: lload 8
    //   4531: lstore 4
    //   4533: aload 24
    //   4535: astore 26
    //   4537: aload 23
    //   4539: astore 25
    //   4541: aload 30
    //   4543: astore 27
    //   4545: aload_0
    //   4546: sipush 753
    //   4549: putfield 46	com/tencent/luggage/wxa/qh/b:k	I
    //   4552: aload 22
    //   4554: astore 28
    //   4556: lload_2
    //   4557: lstore 6
    //   4559: lload 8
    //   4561: lstore 4
    //   4563: aload 24
    //   4565: astore 26
    //   4567: aload 23
    //   4569: astore 25
    //   4571: aload 30
    //   4573: astore 27
    //   4575: aload_0
    //   4576: iconst_5
    //   4577: invokespecial 435	com/tencent/luggage/wxa/qh/b:b	(I)V
    //   4580: lload 8
    //   4582: lconst_0
    //   4583: lcmp
    //   4584: ifne +70 -> 4654
    //   4587: lload_2
    //   4588: lconst_0
    //   4589: lcmp
    //   4590: ifle +64 -> 4654
    //   4593: ldc 57
    //   4595: ldc_w 437
    //   4598: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   4601: aload 22
    //   4603: lload_2
    //   4604: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   4607: goto +19 -> 4626
    //   4610: astore 25
    //   4612: ldc 57
    //   4614: aload 25
    //   4616: ldc_w 442
    //   4619: iconst_0
    //   4620: anewarray 4	java/lang/Object
    //   4623: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4626: aload_0
    //   4627: lload_2
    //   4628: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   4631: lload_2
    //   4632: ldc2_w 394
    //   4635: lcmp
    //   4636: ifge +147 -> 4783
    //   4639: new 283	com/tencent/luggage/wxa/qh/b$a
    //   4642: dup
    //   4643: aload_0
    //   4644: iconst_1
    //   4645: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   4648: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   4651: goto +132 -> 4783
    //   4654: lload 8
    //   4656: lconst_0
    //   4657: lcmp
    //   4658: ifeq +47 -> 4705
    //   4661: lload_2
    //   4662: lload 8
    //   4664: lcmp
    //   4665: ifeq +40 -> 4705
    //   4668: ldc 57
    //   4670: ldc_w 446
    //   4673: iconst_2
    //   4674: anewarray 4	java/lang/Object
    //   4677: dup
    //   4678: iconst_0
    //   4679: lload 8
    //   4681: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4684: aastore
    //   4685: dup
    //   4686: iconst_1
    //   4687: lload_2
    //   4688: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4691: aastore
    //   4692: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4695: aload_0
    //   4696: lload_2
    //   4697: lload 8
    //   4699: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   4702: goto +81 -> 4783
    //   4705: lload 8
    //   4707: lconst_0
    //   4708: lcmp
    //   4709: ifeq +66 -> 4775
    //   4712: lload_2
    //   4713: lload 8
    //   4715: lcmp
    //   4716: ifne +59 -> 4775
    //   4719: ldc 57
    //   4721: ldc_w 450
    //   4724: iconst_2
    //   4725: anewarray 4	java/lang/Object
    //   4728: dup
    //   4729: iconst_0
    //   4730: lload 8
    //   4732: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4735: aastore
    //   4736: dup
    //   4737: iconst_1
    //   4738: lload_2
    //   4739: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4742: aastore
    //   4743: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4746: aload_0
    //   4747: lload 8
    //   4749: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   4752: lload_2
    //   4753: ldc2_w 394
    //   4756: lcmp
    //   4757: ifge +26 -> 4783
    //   4760: new 283	com/tencent/luggage/wxa/qh/b$a
    //   4763: dup
    //   4764: aload_0
    //   4765: iconst_1
    //   4766: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   4769: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   4772: goto +11 -> 4783
    //   4775: ldc 57
    //   4777: ldc_w 452
    //   4780: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   4783: aload 23
    //   4785: ifnull +30 -> 4815
    //   4788: aload 23
    //   4790: invokevirtual 103	java/io/InputStream:close	()V
    //   4793: goto +22 -> 4815
    //   4796: astore 23
    //   4798: ldc 57
    //   4800: aload 23
    //   4802: ldc_w 456
    //   4805: iconst_0
    //   4806: anewarray 4	java/lang/Object
    //   4809: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4812: goto +3 -> 4815
    //   4815: aload 22
    //   4817: ifnull +27 -> 4844
    //   4820: aload 22
    //   4822: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   4825: goto +19 -> 4844
    //   4828: astore 22
    //   4830: ldc 57
    //   4832: aload 22
    //   4834: ldc_w 442
    //   4837: iconst_0
    //   4838: anewarray 4	java/lang/Object
    //   4841: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4844: aload 24
    //   4846: ifnull +903 -> 5749
    //   4849: aload 24
    //   4851: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   4854: invokevirtual 103	java/io/InputStream:close	()V
    //   4857: goto +15 -> 4872
    //   4860: astore 22
    //   4862: ldc 57
    //   4864: aload 22
    //   4866: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4869: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4872: aload 24
    //   4874: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   4877: goto +872 -> 5749
    //   4880: astore 24
    //   4882: aconst_null
    //   4883: astore 25
    //   4885: aconst_null
    //   4886: astore 22
    //   4888: aconst_null
    //   4889: astore 23
    //   4891: aload 22
    //   4893: astore 29
    //   4895: lload 4
    //   4897: lstore 8
    //   4899: aload 25
    //   4901: astore 22
    //   4903: ldc_w 452
    //   4906: astore 30
    //   4908: aload 22
    //   4910: astore 28
    //   4912: lload_2
    //   4913: lstore 6
    //   4915: lload 8
    //   4917: lstore 4
    //   4919: aload 29
    //   4921: astore 26
    //   4923: aload 23
    //   4925: astore 25
    //   4927: aload 30
    //   4929: astore 27
    //   4931: ldc 57
    //   4933: aload 24
    //   4935: ldc_w 573
    //   4938: iconst_1
    //   4939: anewarray 4	java/lang/Object
    //   4942: dup
    //   4943: iconst_0
    //   4944: aload 31
    //   4946: invokevirtual 417	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   4949: aastore
    //   4950: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4953: aload 22
    //   4955: astore 28
    //   4957: lload_2
    //   4958: lstore 6
    //   4960: lload 8
    //   4962: lstore 4
    //   4964: aload 29
    //   4966: astore 26
    //   4968: aload 23
    //   4970: astore 25
    //   4972: aload 30
    //   4974: astore 27
    //   4976: aload_0
    //   4977: sipush 752
    //   4980: putfield 46	com/tencent/luggage/wxa/qh/b:k	I
    //   4983: aload 22
    //   4985: astore 28
    //   4987: lload_2
    //   4988: lstore 6
    //   4990: lload 8
    //   4992: lstore 4
    //   4994: aload 29
    //   4996: astore 26
    //   4998: aload 23
    //   5000: astore 25
    //   5002: aload 30
    //   5004: astore 27
    //   5006: aload_0
    //   5007: iconst_5
    //   5008: invokespecial 435	com/tencent/luggage/wxa/qh/b:b	(I)V
    //   5011: lload 8
    //   5013: lconst_0
    //   5014: lcmp
    //   5015: ifne +70 -> 5085
    //   5018: lload_2
    //   5019: lconst_0
    //   5020: lcmp
    //   5021: ifle +64 -> 5085
    //   5024: ldc 57
    //   5026: ldc_w 437
    //   5029: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   5032: aload 22
    //   5034: lload_2
    //   5035: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   5038: goto +19 -> 5057
    //   5041: astore 24
    //   5043: ldc 57
    //   5045: aload 24
    //   5047: ldc_w 442
    //   5050: iconst_0
    //   5051: anewarray 4	java/lang/Object
    //   5054: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5057: aload_0
    //   5058: lload_2
    //   5059: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   5062: lload_2
    //   5063: ldc2_w 394
    //   5066: lcmp
    //   5067: ifge +146 -> 5213
    //   5070: new 283	com/tencent/luggage/wxa/qh/b$a
    //   5073: dup
    //   5074: aload_0
    //   5075: iconst_1
    //   5076: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   5079: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   5082: goto +131 -> 5213
    //   5085: lload 8
    //   5087: lconst_0
    //   5088: lcmp
    //   5089: ifeq +47 -> 5136
    //   5092: lload_2
    //   5093: lload 8
    //   5095: lcmp
    //   5096: ifeq +40 -> 5136
    //   5099: ldc 57
    //   5101: ldc_w 446
    //   5104: iconst_2
    //   5105: anewarray 4	java/lang/Object
    //   5108: dup
    //   5109: iconst_0
    //   5110: lload 8
    //   5112: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5115: aastore
    //   5116: dup
    //   5117: iconst_1
    //   5118: lload_2
    //   5119: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5122: aastore
    //   5123: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5126: aload_0
    //   5127: lload_2
    //   5128: lload 8
    //   5130: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   5133: goto +80 -> 5213
    //   5136: lload 8
    //   5138: lconst_0
    //   5139: lcmp
    //   5140: ifeq +66 -> 5206
    //   5143: lload_2
    //   5144: lload 8
    //   5146: lcmp
    //   5147: ifne +59 -> 5206
    //   5150: ldc 57
    //   5152: ldc_w 450
    //   5155: iconst_2
    //   5156: anewarray 4	java/lang/Object
    //   5159: dup
    //   5160: iconst_0
    //   5161: lload 8
    //   5163: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5166: aastore
    //   5167: dup
    //   5168: iconst_1
    //   5169: lload_2
    //   5170: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5173: aastore
    //   5174: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5177: aload_0
    //   5178: lload 8
    //   5180: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   5183: lload_2
    //   5184: ldc2_w 394
    //   5187: lcmp
    //   5188: ifge +25 -> 5213
    //   5191: new 283	com/tencent/luggage/wxa/qh/b$a
    //   5194: dup
    //   5195: aload_0
    //   5196: iconst_1
    //   5197: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   5200: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   5203: goto +10 -> 5213
    //   5206: ldc 57
    //   5208: aload 30
    //   5210: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   5213: aload 23
    //   5215: ifnull +30 -> 5245
    //   5218: aload 23
    //   5220: invokevirtual 103	java/io/InputStream:close	()V
    //   5223: goto +22 -> 5245
    //   5226: astore 23
    //   5228: ldc 57
    //   5230: aload 23
    //   5232: ldc_w 456
    //   5235: iconst_0
    //   5236: anewarray 4	java/lang/Object
    //   5239: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5242: goto +3 -> 5245
    //   5245: aload 22
    //   5247: ifnull +27 -> 5274
    //   5250: aload 22
    //   5252: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   5255: goto +19 -> 5274
    //   5258: astore 22
    //   5260: ldc 57
    //   5262: aload 22
    //   5264: ldc_w 442
    //   5267: iconst_0
    //   5268: anewarray 4	java/lang/Object
    //   5271: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5274: aload 29
    //   5276: ifnull +473 -> 5749
    //   5279: aload 29
    //   5281: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5284: invokevirtual 103	java/io/InputStream:close	()V
    //   5287: goto +15 -> 5302
    //   5290: astore 22
    //   5292: ldc 57
    //   5294: aload 22
    //   5296: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5299: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5302: aload 29
    //   5304: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   5307: goto +442 -> 5749
    //   5310: astore 24
    //   5312: aconst_null
    //   5313: astore 25
    //   5315: aconst_null
    //   5316: astore 22
    //   5318: aload 24
    //   5320: astore 23
    //   5322: aconst_null
    //   5323: astore 26
    //   5325: aload 23
    //   5327: astore 24
    //   5329: aload 26
    //   5331: astore 23
    //   5333: aload 22
    //   5335: astore 29
    //   5337: lload 4
    //   5339: lstore 8
    //   5341: aload 25
    //   5343: astore 22
    //   5345: ldc_w 452
    //   5348: astore 30
    //   5350: aload 22
    //   5352: astore 28
    //   5354: lload_2
    //   5355: lstore 6
    //   5357: lload 8
    //   5359: lstore 4
    //   5361: aload 29
    //   5363: astore 26
    //   5365: aload 23
    //   5367: astore 25
    //   5369: aload 30
    //   5371: astore 27
    //   5373: ldc 57
    //   5375: aload 24
    //   5377: ldc_w 573
    //   5380: iconst_1
    //   5381: anewarray 4	java/lang/Object
    //   5384: dup
    //   5385: iconst_0
    //   5386: aload 31
    //   5388: invokevirtual 417	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   5391: aastore
    //   5392: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5395: aload 22
    //   5397: astore 28
    //   5399: lload_2
    //   5400: lstore 6
    //   5402: lload 8
    //   5404: lstore 4
    //   5406: aload 29
    //   5408: astore 26
    //   5410: aload 23
    //   5412: astore 25
    //   5414: aload 30
    //   5416: astore 27
    //   5418: aload_0
    //   5419: sipush 751
    //   5422: putfield 46	com/tencent/luggage/wxa/qh/b:k	I
    //   5425: aload 22
    //   5427: astore 28
    //   5429: lload_2
    //   5430: lstore 6
    //   5432: lload 8
    //   5434: lstore 4
    //   5436: aload 29
    //   5438: astore 26
    //   5440: aload 23
    //   5442: astore 25
    //   5444: aload 30
    //   5446: astore 27
    //   5448: aload_0
    //   5449: iconst_5
    //   5450: invokespecial 435	com/tencent/luggage/wxa/qh/b:b	(I)V
    //   5453: lload 8
    //   5455: lconst_0
    //   5456: lcmp
    //   5457: ifne +70 -> 5527
    //   5460: lload_2
    //   5461: lconst_0
    //   5462: lcmp
    //   5463: ifle +64 -> 5527
    //   5466: ldc 57
    //   5468: ldc_w 437
    //   5471: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   5474: aload 22
    //   5476: lload_2
    //   5477: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   5480: goto +19 -> 5499
    //   5483: astore 24
    //   5485: ldc 57
    //   5487: aload 24
    //   5489: ldc_w 442
    //   5492: iconst_0
    //   5493: anewarray 4	java/lang/Object
    //   5496: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5499: aload_0
    //   5500: lload_2
    //   5501: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   5504: lload_2
    //   5505: ldc2_w 394
    //   5508: lcmp
    //   5509: ifge +146 -> 5655
    //   5512: new 283	com/tencent/luggage/wxa/qh/b$a
    //   5515: dup
    //   5516: aload_0
    //   5517: iconst_1
    //   5518: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   5521: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   5524: goto +131 -> 5655
    //   5527: lload 8
    //   5529: lconst_0
    //   5530: lcmp
    //   5531: ifeq +47 -> 5578
    //   5534: lload_2
    //   5535: lload 8
    //   5537: lcmp
    //   5538: ifeq +40 -> 5578
    //   5541: ldc 57
    //   5543: ldc_w 446
    //   5546: iconst_2
    //   5547: anewarray 4	java/lang/Object
    //   5550: dup
    //   5551: iconst_0
    //   5552: lload 8
    //   5554: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5557: aastore
    //   5558: dup
    //   5559: iconst_1
    //   5560: lload_2
    //   5561: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5564: aastore
    //   5565: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5568: aload_0
    //   5569: lload_2
    //   5570: lload 8
    //   5572: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   5575: goto +80 -> 5655
    //   5578: lload 8
    //   5580: lconst_0
    //   5581: lcmp
    //   5582: ifeq +66 -> 5648
    //   5585: lload_2
    //   5586: lload 8
    //   5588: lcmp
    //   5589: ifne +59 -> 5648
    //   5592: ldc 57
    //   5594: ldc_w 450
    //   5597: iconst_2
    //   5598: anewarray 4	java/lang/Object
    //   5601: dup
    //   5602: iconst_0
    //   5603: lload 8
    //   5605: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5608: aastore
    //   5609: dup
    //   5610: iconst_1
    //   5611: lload_2
    //   5612: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5615: aastore
    //   5616: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5619: aload_0
    //   5620: lload 8
    //   5622: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   5625: lload_2
    //   5626: ldc2_w 394
    //   5629: lcmp
    //   5630: ifge +25 -> 5655
    //   5633: new 283	com/tencent/luggage/wxa/qh/b$a
    //   5636: dup
    //   5637: aload_0
    //   5638: iconst_1
    //   5639: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   5642: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   5645: goto +10 -> 5655
    //   5648: ldc 57
    //   5650: aload 30
    //   5652: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   5655: aload 23
    //   5657: ifnull +30 -> 5687
    //   5660: aload 23
    //   5662: invokevirtual 103	java/io/InputStream:close	()V
    //   5665: goto +22 -> 5687
    //   5668: astore 23
    //   5670: ldc 57
    //   5672: aload 23
    //   5674: ldc_w 456
    //   5677: iconst_0
    //   5678: anewarray 4	java/lang/Object
    //   5681: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5684: goto +3 -> 5687
    //   5687: aload 22
    //   5689: ifnull +27 -> 5716
    //   5692: aload 22
    //   5694: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   5697: goto +19 -> 5716
    //   5700: astore 22
    //   5702: ldc 57
    //   5704: aload 22
    //   5706: ldc_w 442
    //   5709: iconst_0
    //   5710: anewarray 4	java/lang/Object
    //   5713: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5716: aload 29
    //   5718: ifnull +31 -> 5749
    //   5721: aload 29
    //   5723: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5726: invokevirtual 103	java/io/InputStream:close	()V
    //   5729: goto +15 -> 5744
    //   5732: astore 22
    //   5734: ldc 57
    //   5736: aload 22
    //   5738: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5741: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5744: aload 29
    //   5746: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   5749: aload_0
    //   5750: iconst_1
    //   5751: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   5754: ldc_w 454
    //   5757: astore 22
    //   5759: goto +393 -> 6152
    //   5762: astore 22
    //   5764: ldc_w 456
    //   5767: astore 29
    //   5769: ldc_w 454
    //   5772: astore 30
    //   5774: aload 27
    //   5776: astore 24
    //   5778: lload 6
    //   5780: lstore_2
    //   5781: aload 28
    //   5783: astore 27
    //   5785: aload 26
    //   5787: astore 23
    //   5789: aload 25
    //   5791: astore 28
    //   5793: goto +404 -> 6197
    //   5796: astore 25
    //   5798: aconst_null
    //   5799: astore 22
    //   5801: aconst_null
    //   5802: astore 23
    //   5804: aload 23
    //   5806: astore 24
    //   5808: aconst_null
    //   5809: astore 23
    //   5811: ldc 57
    //   5813: aload 25
    //   5815: ldc_w 573
    //   5818: iconst_1
    //   5819: anewarray 4	java/lang/Object
    //   5822: dup
    //   5823: iconst_0
    //   5824: aload 31
    //   5826: invokevirtual 417	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   5829: aastore
    //   5830: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5833: aload_0
    //   5834: sipush 750
    //   5837: putfield 46	com/tencent/luggage/wxa/qh/b:k	I
    //   5840: aload_0
    //   5841: iconst_5
    //   5842: invokespecial 435	com/tencent/luggage/wxa/qh/b:b	(I)V
    //   5845: lload 4
    //   5847: lconst_0
    //   5848: lcmp
    //   5849: ifne +70 -> 5919
    //   5852: lload_2
    //   5853: lconst_0
    //   5854: lcmp
    //   5855: ifle +64 -> 5919
    //   5858: ldc 57
    //   5860: ldc_w 437
    //   5863: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   5866: aload 22
    //   5868: lload_2
    //   5869: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   5872: goto +19 -> 5891
    //   5875: astore 25
    //   5877: ldc 57
    //   5879: aload 25
    //   5881: ldc_w 442
    //   5884: iconst_0
    //   5885: anewarray 4	java/lang/Object
    //   5888: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5891: aload_0
    //   5892: lload_2
    //   5893: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   5896: lload_2
    //   5897: ldc2_w 394
    //   5900: lcmp
    //   5901: ifge +147 -> 6048
    //   5904: new 283	com/tencent/luggage/wxa/qh/b$a
    //   5907: dup
    //   5908: aload_0
    //   5909: iconst_1
    //   5910: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   5913: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   5916: goto +132 -> 6048
    //   5919: lload 4
    //   5921: lconst_0
    //   5922: lcmp
    //   5923: ifeq +47 -> 5970
    //   5926: lload_2
    //   5927: lload 4
    //   5929: lcmp
    //   5930: ifeq +40 -> 5970
    //   5933: ldc 57
    //   5935: ldc_w 446
    //   5938: iconst_2
    //   5939: anewarray 4	java/lang/Object
    //   5942: dup
    //   5943: iconst_0
    //   5944: lload 4
    //   5946: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5949: aastore
    //   5950: dup
    //   5951: iconst_1
    //   5952: lload_2
    //   5953: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5956: aastore
    //   5957: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5960: aload_0
    //   5961: lload_2
    //   5962: lload 4
    //   5964: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   5967: goto +81 -> 6048
    //   5970: lload 4
    //   5972: lconst_0
    //   5973: lcmp
    //   5974: ifeq +66 -> 6040
    //   5977: lload_2
    //   5978: lload 4
    //   5980: lcmp
    //   5981: ifne +59 -> 6040
    //   5984: ldc 57
    //   5986: ldc_w 450
    //   5989: iconst_2
    //   5990: anewarray 4	java/lang/Object
    //   5993: dup
    //   5994: iconst_0
    //   5995: lload 4
    //   5997: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6000: aastore
    //   6001: dup
    //   6002: iconst_1
    //   6003: lload_2
    //   6004: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6007: aastore
    //   6008: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6011: aload_0
    //   6012: lload 4
    //   6014: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   6017: lload_2
    //   6018: ldc2_w 394
    //   6021: lcmp
    //   6022: ifge +26 -> 6048
    //   6025: new 283	com/tencent/luggage/wxa/qh/b$a
    //   6028: dup
    //   6029: aload_0
    //   6030: iconst_1
    //   6031: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   6034: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   6037: goto +11 -> 6048
    //   6040: ldc 57
    //   6042: ldc_w 452
    //   6045: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6048: aload 23
    //   6050: ifnull +30 -> 6080
    //   6053: aload 23
    //   6055: invokevirtual 103	java/io/InputStream:close	()V
    //   6058: goto +22 -> 6080
    //   6061: astore 23
    //   6063: ldc 57
    //   6065: aload 23
    //   6067: ldc_w 456
    //   6070: iconst_0
    //   6071: anewarray 4	java/lang/Object
    //   6074: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6077: goto +3 -> 6080
    //   6080: aload 22
    //   6082: ifnull +27 -> 6109
    //   6085: aload 22
    //   6087: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   6090: goto +19 -> 6109
    //   6093: astore 22
    //   6095: ldc 57
    //   6097: aload 22
    //   6099: ldc_w 442
    //   6102: iconst_0
    //   6103: anewarray 4	java/lang/Object
    //   6106: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6109: aload 24
    //   6111: ifnull +31 -> 6142
    //   6114: aload 24
    //   6116: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6119: invokevirtual 103	java/io/InputStream:close	()V
    //   6122: goto +15 -> 6137
    //   6125: astore 22
    //   6127: ldc 57
    //   6129: aload 22
    //   6131: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6134: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6137: aload 24
    //   6139: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   6142: aload_0
    //   6143: iconst_1
    //   6144: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   6147: ldc_w 454
    //   6150: astore 22
    //   6152: ldc 57
    //   6154: aload 22
    //   6156: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6159: return
    //   6160: astore 25
    //   6162: ldc_w 456
    //   6165: astore 29
    //   6167: ldc_w 454
    //   6170: astore 30
    //   6172: ldc_w 452
    //   6175: astore 26
    //   6177: aload 23
    //   6179: astore 28
    //   6181: aload 24
    //   6183: astore 23
    //   6185: aload 22
    //   6187: astore 27
    //   6189: aload 26
    //   6191: astore 24
    //   6193: aload 25
    //   6195: astore 22
    //   6197: aload 30
    //   6199: astore 25
    //   6201: aload 29
    //   6203: astore 26
    //   6205: goto -2162 -> 4043
    //   6208: lload 4
    //   6210: lconst_0
    //   6211: lcmp
    //   6212: ifne +70 -> 6282
    //   6215: lload_2
    //   6216: lconst_0
    //   6217: lcmp
    //   6218: ifle +64 -> 6282
    //   6221: ldc 57
    //   6223: ldc_w 437
    //   6226: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6229: aload 27
    //   6231: lload_2
    //   6232: invokevirtual 517	java/io/RandomAccessFile:setLength	(J)V
    //   6235: goto +19 -> 6254
    //   6238: astore 24
    //   6240: ldc 57
    //   6242: aload 24
    //   6244: ldc_w 442
    //   6247: iconst_0
    //   6248: anewarray 4	java/lang/Object
    //   6251: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6254: aload_0
    //   6255: lload_2
    //   6256: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   6259: lload_2
    //   6260: ldc2_w 394
    //   6263: lcmp
    //   6264: ifge +146 -> 6410
    //   6267: new 283	com/tencent/luggage/wxa/qh/b$a
    //   6270: dup
    //   6271: aload_0
    //   6272: iconst_1
    //   6273: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   6276: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   6279: goto +131 -> 6410
    //   6282: lload 4
    //   6284: lconst_0
    //   6285: lcmp
    //   6286: ifeq +47 -> 6333
    //   6289: lload_2
    //   6290: lload 4
    //   6292: lcmp
    //   6293: ifeq +40 -> 6333
    //   6296: ldc 57
    //   6298: ldc_w 446
    //   6301: iconst_2
    //   6302: anewarray 4	java/lang/Object
    //   6305: dup
    //   6306: iconst_0
    //   6307: lload 4
    //   6309: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6312: aastore
    //   6313: dup
    //   6314: iconst_1
    //   6315: lload_2
    //   6316: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6319: aastore
    //   6320: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6323: aload_0
    //   6324: lload_2
    //   6325: lload 4
    //   6327: invokespecial 448	com/tencent/luggage/wxa/qh/b:b	(JJ)V
    //   6330: goto +80 -> 6410
    //   6333: lload 4
    //   6335: lconst_0
    //   6336: lcmp
    //   6337: ifeq +66 -> 6403
    //   6340: lload_2
    //   6341: lload 4
    //   6343: lcmp
    //   6344: ifne +59 -> 6403
    //   6347: ldc 57
    //   6349: ldc_w 450
    //   6352: iconst_2
    //   6353: anewarray 4	java/lang/Object
    //   6356: dup
    //   6357: iconst_0
    //   6358: lload 4
    //   6360: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6363: aastore
    //   6364: dup
    //   6365: iconst_1
    //   6366: lload_2
    //   6367: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6370: aastore
    //   6371: invokestatic 115	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6374: aload_0
    //   6375: lload 4
    //   6377: invokespecial 444	com/tencent/luggage/wxa/qh/b:a	(J)V
    //   6380: lload_2
    //   6381: ldc2_w 394
    //   6384: lcmp
    //   6385: ifge +25 -> 6410
    //   6388: new 283	com/tencent/luggage/wxa/qh/b$a
    //   6391: dup
    //   6392: aload_0
    //   6393: iconst_1
    //   6394: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   6397: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   6400: goto +10 -> 6410
    //   6403: ldc 57
    //   6405: aload 24
    //   6407: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6410: aload 28
    //   6412: ifnull +29 -> 6441
    //   6415: aload 28
    //   6417: invokevirtual 103	java/io/InputStream:close	()V
    //   6420: goto +21 -> 6441
    //   6423: astore 24
    //   6425: ldc 57
    //   6427: aload 24
    //   6429: aload 26
    //   6431: iconst_0
    //   6432: anewarray 4	java/lang/Object
    //   6435: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6438: goto +3 -> 6441
    //   6441: aload 27
    //   6443: ifnull +27 -> 6470
    //   6446: aload 27
    //   6448: invokevirtual 518	java/io/RandomAccessFile:close	()V
    //   6451: goto +19 -> 6470
    //   6454: astore 24
    //   6456: ldc 57
    //   6458: aload 24
    //   6460: ldc_w 442
    //   6463: iconst_0
    //   6464: anewarray 4	java/lang/Object
    //   6467: invokestatic 420	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6470: aload 23
    //   6472: ifnull +31 -> 6503
    //   6475: aload 23
    //   6477: invokevirtual 98	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6480: invokevirtual 103	java/io/InputStream:close	()V
    //   6483: goto +15 -> 6498
    //   6486: astore 24
    //   6488: ldc 57
    //   6490: aload 24
    //   6492: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6495: invokestatic 64	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6498: aload 23
    //   6500: invokevirtual 110	java/net/HttpURLConnection:disconnect	()V
    //   6503: aload_0
    //   6504: iconst_1
    //   6505: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   6508: ldc 57
    //   6510: aload 25
    //   6512: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6515: aload 22
    //   6517: athrow
    //   6518: aload_0
    //   6519: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6522: getfield 263	com/tencent/luggage/wxa/qh/a:d	J
    //   6525: lconst_0
    //   6526: lcmp
    //   6527: ifeq +96 -> 6623
    //   6530: aload_0
    //   6531: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6534: getfield 263	com/tencent/luggage/wxa/qh/a:d	J
    //   6537: aload_0
    //   6538: getfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   6541: lcmp
    //   6542: ifge +21 -> 6563
    //   6545: aload_0
    //   6546: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6549: getfield 263	com/tencent/luggage/wxa/qh/a:d	J
    //   6552: aload_0
    //   6553: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6556: getfield 266	com/tencent/luggage/wxa/qh/a:f	J
    //   6559: lcmp
    //   6560: ifne +63 -> 6623
    //   6563: aload_0
    //   6564: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6567: getfield 263	com/tencent/luggage/wxa/qh/a:d	J
    //   6570: l2f
    //   6571: aload_0
    //   6572: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6575: getfield 266	com/tencent/luggage/wxa/qh/a:f	J
    //   6578: l2f
    //   6579: fdiv
    //   6580: aload_0
    //   6581: getfield 335	com/tencent/luggage/wxa/qh/b:e	F
    //   6584: fsub
    //   6585: ldc_w 340
    //   6588: fcmpl
    //   6589: iflt +34 -> 6623
    //   6592: ldc 57
    //   6594: ldc_w 429
    //   6597: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6600: aload_0
    //   6601: iconst_1
    //   6602: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   6605: aload_0
    //   6606: iconst_1
    //   6607: putfield 80	com/tencent/luggage/wxa/qh/b:g	Z
    //   6610: new 283	com/tencent/luggage/wxa/qh/b$a
    //   6613: dup
    //   6614: aload_0
    //   6615: iconst_1
    //   6616: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   6619: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   6622: return
    //   6623: aload_0
    //   6624: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6627: getfield 277	com/tencent/luggage/wxa/qh/a:a	J
    //   6630: lconst_0
    //   6631: lcmp
    //   6632: ifeq +96 -> 6728
    //   6635: aload_0
    //   6636: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6639: getfield 277	com/tencent/luggage/wxa/qh/a:a	J
    //   6642: aload_0
    //   6643: getfield 36	com/tencent/luggage/wxa/qh/b:f	J
    //   6646: lcmp
    //   6647: ifge +21 -> 6668
    //   6650: aload_0
    //   6651: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6654: getfield 277	com/tencent/luggage/wxa/qh/a:a	J
    //   6657: aload_0
    //   6658: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6661: getfield 281	com/tencent/luggage/wxa/qh/a:b	J
    //   6664: lcmp
    //   6665: ifne +63 -> 6728
    //   6668: aload_0
    //   6669: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6672: getfield 277	com/tencent/luggage/wxa/qh/a:a	J
    //   6675: l2f
    //   6676: aload_0
    //   6677: getfield 50	com/tencent/luggage/wxa/qh/b:d	Lcom/tencent/luggage/wxa/qh/a;
    //   6680: getfield 281	com/tencent/luggage/wxa/qh/a:b	J
    //   6683: l2f
    //   6684: fdiv
    //   6685: aload_0
    //   6686: getfield 335	com/tencent/luggage/wxa/qh/b:e	F
    //   6689: fsub
    //   6690: ldc_w 340
    //   6693: fcmpl
    //   6694: iflt +34 -> 6728
    //   6697: ldc 57
    //   6699: ldc_w 429
    //   6702: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6705: aload_0
    //   6706: iconst_1
    //   6707: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   6710: aload_0
    //   6711: iconst_0
    //   6712: putfield 80	com/tencent/luggage/wxa/qh/b:g	Z
    //   6715: new 283	com/tencent/luggage/wxa/qh/b$a
    //   6718: dup
    //   6719: aload_0
    //   6720: iconst_1
    //   6721: invokespecial 286	com/tencent/luggage/wxa/qh/b$a:<init>	(Lcom/tencent/luggage/wxa/qh/b;I)V
    //   6724: invokestatic 291	com/tencent/luggage/wxa/qz/t:a	(Ljava/lang/Runnable;)V
    //   6727: return
    //   6728: ldc 57
    //   6730: ldc_w 575
    //   6733: invokestatic 68	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   6736: aload_0
    //   6737: iconst_1
    //   6738: putfield 38	com/tencent/luggage/wxa/qh/b:h	Z
    //   6741: aload_0
    //   6742: iconst_4
    //   6743: invokespecial 435	com/tencent/luggage/wxa/qh/b:b	(I)V
    //   6746: return
    //   6747: lload 4
    //   6749: lstore 8
    //   6751: aload 23
    //   6753: astore 29
    //   6755: aload 25
    //   6757: astore 23
    //   6759: goto -1856 -> 4903
    //   6762: lload 4
    //   6764: lstore 8
    //   6766: aload 23
    //   6768: astore 29
    //   6770: aload 25
    //   6772: astore 23
    //   6774: goto -1429 -> 5345
    //   6777: aload 23
    //   6779: astore 24
    //   6781: aload 26
    //   6783: astore 23
    //   6785: goto -974 -> 5811
    //   6788: goto -5662 -> 1126
    //   6791: goto -4283 -> 2508
    //   6794: astore 25
    //   6796: lload 6
    //   6798: lstore_2
    //   6799: goto -4103 -> 2696
    //   6802: astore 25
    //   6804: lload 12
    //   6806: lstore_2
    //   6807: goto -4098 -> 2709
    //   6810: astore 25
    //   6812: lload 16
    //   6814: lstore_2
    //   6815: goto -4085 -> 2730
    //   6818: astore 25
    //   6820: lload 14
    //   6822: lstore_2
    //   6823: goto -4080 -> 2743
    //   6826: astore 25
    //   6828: lload 8
    //   6830: lstore_2
    //   6831: goto -4071 -> 2760
    //   6834: astore 25
    //   6836: lload 10
    //   6838: lstore_2
    //   6839: goto -4062 -> 2777
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6842	0	this	b
    //   182	2477	1	m	int
    //   141	2836	2	l1	long
    //   115	3264	4	l2	long
    //   106	2525	6	l3	long
    //   435	2946	8	l4	long
    //   2547	99	10	l5	long
    //   2535	99	12	l6	long
    //   2541	99	14	l7	long
    //   2538	99	16	l8	long
    //   2434	249	18	l9	long
    //   14	2501	20	bool1	boolean
    //   599	3	21	bool2	boolean
    //   29	528	22	localObject1	Object
    //   666	5	22	localIOException1	java.io.IOException
    //   853	1	22	localObject2	Object
    //   888	244	22	str1	String
    //   1146	1	22	localObject3	Object
    //   1180	14	22	localObject4	Object
    //   1198	7	22	localUnknownServiceException1	java.net.UnknownServiceException
    //   1211	7	22	localNoRouteToHostException1	java.net.NoRouteToHostException
    //   1228	712	22	localObject5	Object
    //   2011	1	22	localObject6	Object
    //   2025	1	22	localObject7	Object
    //   2030	7	22	localUnknownServiceException2	java.net.UnknownServiceException
    //   2042	1	22	localObject8	Object
    //   2047	7	22	localNoRouteToHostException2	java.net.NoRouteToHostException
    //   2059	10	22	localObject9	Object
    //   2132	5	22	localIOException2	java.io.IOException
    //   2317	5	22	localIOException3	java.io.IOException
    //   2349	5	22	localException1	Exception
    //   2423	622	22	localObject10	Object
    //   3052	5	22	localIOException4	java.io.IOException
    //   3084	5	22	localException2	Exception
    //   3109	207	22	localObject11	Object
    //   3402	1	22	localObject12	Object
    //   3432	1	22	localObject13	Object
    //   407	5	23	localIOException5	java.io.IOException
    //   866	284	23	localObject14	Object
    //   1176	127	23	localException3	Exception
    //   1393	5	23	localIOException6	java.io.IOException
    //   1579	5	23	localIOException7	java.io.IOException
    //   1611	5	23	localException4	Exception
    //   1641	1	23	localObject15	Object
    //   1650	31	23	localObject16	Object
    //   1689	1	23	localNoRouteToHostException3	java.net.NoRouteToHostException
    //   1698	105	23	localObject17	Object
    //   1862	1	23	localObject18	Object
    //   1874	14	23	localObject19	Object
    //   1901	1	23	localNoRouteToHostException4	java.net.NoRouteToHostException
    //   1906	1	23	localProtocolException1	java.net.ProtocolException
    //   1941	421	23	localObject20	Object
    //   2380	1	23	localObject21	Object
    //   2390	1	23	localIOException8	java.io.IOException
    //   2400	1	23	localNoRouteToHostException5	java.net.NoRouteToHostException
    //   2405	811	23	localProtocolException2	java.net.ProtocolException
    //   3221	256	23	localObject22	Object
    //   874	1	24	str2	String
    //   879	1	24	localException5	Exception
    //   903	1	24	localObject23	Object
    //   915	1	24	localUnknownServiceException3	java.net.UnknownServiceException
    //   933	1	24	localNoRouteToHostException6	java.net.NoRouteToHostException
    //   957	702	24	localObject24	Object
    //   1663	16	24	localIOException9	java.io.IOException
    //   1684	23	24	localObject25	Object
    //   1867	1	24	localException6	Exception
    //   1883	7	24	localIOException10	java.io.IOException
    //   1896	1	24	localUnknownServiceException4	java.net.UnknownServiceException
    //   2016	17	24	localException7	Exception
    //   2038	86	24	localObject26	Object
    //   2385	1	24	localException8	Exception
    //   2395	1	24	localUnknownServiceException5	java.net.UnknownServiceException
    //   2499	514	24	localObject27	Object
    //   3020	127	24	localIOException11	java.io.IOException
    //   3152	244	24	localObject28	Object
    //   3407	1	24	localException9	Exception
    //   3412	1	24	localIOException12	java.io.IOException
    //   3417	1	24	localUnknownServiceException6	java.net.UnknownServiceException
    //   3422	1	24	localNoRouteToHostException7	java.net.NoRouteToHostException
    //   3427	1	24	localProtocolException3	java.net.ProtocolException
    //   3437	1	24	localException10	Exception
    //   3442	3	24	localIOException13	java.io.IOException
    //   3451	1	24	localUnknownServiceException7	java.net.UnknownServiceException
    //   3456	1	24	localNoRouteToHostException8	java.net.NoRouteToHostException
    //   3461	6	24	localProtocolException4	java.net.ProtocolException
    //   3472	1	24	localObject29	Object
    //   863	20	25	str3	String
    //   951	1	25	localProtocolException5	java.net.ProtocolException
    //   978	181	25	localObject30	Object
    //   1189	1	25	localIOException14	java.io.IOException
    //   1202	14	25	localObject31	Object
    //   1224	348	25	localProtocolException6	java.net.ProtocolException
    //   1646	11	25	localException11	Exception
    //   1676	7	25	localUnknownServiceException8	java.net.UnknownServiceException
    //   1694	11	25	localProtocolException7	java.net.ProtocolException
    //   2021	1	25	localIOException15	java.io.IOException
    //   2034	18	25	localObject32	Object
    //   2064	358	25	localProtocolException8	java.net.ProtocolException
    //   2506	46	25	arrayOfByte	byte[]
    //   2694	7	25	localObject33	Object
    //   2707	7	25	localException12	Exception
    //   2719	1	25	localObject34	Object
    //   2728	3	25	localIOException16	java.io.IOException
    //   2736	1	25	localObject35	Object
    //   2741	3	25	localUnknownServiceException9	java.net.UnknownServiceException
    //   2749	1	25	localObject36	Object
    //   2758	3	25	localNoRouteToHostException9	java.net.NoRouteToHostException
    //   2766	1	25	localObject37	Object
    //   2775	1	25	localProtocolException9	java.net.ProtocolException
    //   2836	5	25	localIOException17	java.io.IOException
    //   3114	1	25	localObject38	Object
    //   3119	1	25	localException13	Exception
    //   3124	1	25	localIOException18	java.io.IOException
    //   3129	1	25	localUnknownServiceException10	java.net.UnknownServiceException
    //   3134	1	25	localNoRouteToHostException10	java.net.NoRouteToHostException
    //   3139	1	25	localProtocolException10	java.net.ProtocolException
    //   3144	7	25	localObject39	Object
    //   3161	1	25	str4	String
    //   3184	7	25	localException14	Exception
    //   3196	1	25	localObject40	Object
    //   3205	3	25	localIOException19	java.io.IOException
    //   3213	7	25	localObject41	Object
    //   3226	3	25	localUnknownServiceException11	java.net.UnknownServiceException
    //   3234	1	25	localObject42	Object
    //   3243	3	25	localNoRouteToHostException11	java.net.NoRouteToHostException
    //   3251	1	25	localObject43	Object
    //   3260	1	25	localProtocolException11	java.net.ProtocolException
    //   3269	26	25	localObject44	Object
    //   3300	1	25	localObject45	Object
    //   3305	7	25	localException15	Exception
    //   3317	70	25	localObject46	Object
    //   3393	1	25	localProtocolException12	java.net.ProtocolException
    //   3468	1	25	localObject47	Object
    //   858	2452	26	localObject48	Object
    //   3343	7	26	localUnknownServiceException12	java.net.UnknownServiceException
    //   3368	7	26	localNoRouteToHostException12	java.net.NoRouteToHostException
    //   3397	78	26	localObject49	Object
    //   592	2686	27	localObject50	Object
    //   869	2405	28	localObject51	Object
    //   897	1	29	localIOException20	java.io.IOException
    //   921	2378	29	localObject52	Object
    //   3322	1	29	localIOException21	java.io.IOException
    //   3359	88	29	localObject53	Object
    //   1919	44	30	str5	String
    //   371	595	31	locali	com.tencent.luggage.wxa.rt.i
    // Exception table:
    //   from	to	target	type
    //   381	404	407	java/io/IOException
    //   658	666	666	java/io/IOException
    //   606	637	853	finally
    //   606	637	879	java/lang/Exception
    //   606	637	897	java/io/IOException
    //   606	637	915	java/net/UnknownServiceException
    //   606	637	933	java/net/NoRouteToHostException
    //   606	637	951	java/net/ProtocolException
    //   1038	1123	1146	finally
    //   1131	1138	1146	finally
    //   1038	1123	1176	java/lang/Exception
    //   1131	1138	1176	java/lang/Exception
    //   1038	1123	1189	java/io/IOException
    //   1131	1138	1189	java/io/IOException
    //   1038	1123	1198	java/net/UnknownServiceException
    //   1131	1138	1198	java/net/UnknownServiceException
    //   1038	1123	1211	java/net/NoRouteToHostException
    //   1131	1138	1211	java/net/NoRouteToHostException
    //   1038	1123	1224	java/net/ProtocolException
    //   1131	1138	1224	java/net/ProtocolException
    //   1384	1390	1393	java/io/IOException
    //   1571	1576	1579	java/io/IOException
    //   1600	1608	1611	java/lang/Exception
    //   1329	1363	1641	finally
    //   1329	1363	1646	java/lang/Exception
    //   1329	1363	1663	java/io/IOException
    //   1329	1363	1676	java/net/UnknownServiceException
    //   1329	1363	1689	java/net/NoRouteToHostException
    //   1329	1363	1694	java/net/ProtocolException
    //   1821	1859	1862	finally
    //   1821	1859	1867	java/lang/Exception
    //   1821	1859	1883	java/io/IOException
    //   1821	1859	1896	java/net/UnknownServiceException
    //   1821	1859	1901	java/net/NoRouteToHostException
    //   1821	1859	1906	java/net/ProtocolException
    //   1981	1989	2011	finally
    //   1981	1989	2016	java/lang/Exception
    //   1981	1989	2021	java/io/IOException
    //   1981	1989	2030	java/net/UnknownServiceException
    //   1981	1989	2047	java/net/NoRouteToHostException
    //   1981	1989	2064	java/net/ProtocolException
    //   2123	2129	2132	java/io/IOException
    //   2309	2314	2317	java/io/IOException
    //   2338	2346	2349	java/lang/Exception
    //   2088	2102	2380	finally
    //   2088	2102	2385	java/lang/Exception
    //   2088	2102	2390	java/io/IOException
    //   2088	2102	2395	java/net/UnknownServiceException
    //   2088	2102	2400	java/net/NoRouteToHostException
    //   2088	2102	2405	java/net/ProtocolException
    //   2519	2527	2694	finally
    //   2519	2527	2707	java/lang/Exception
    //   2519	2527	2728	java/io/IOException
    //   2519	2527	2741	java/net/UnknownServiceException
    //   2519	2527	2758	java/net/NoRouteToHostException
    //   2519	2527	2775	java/net/ProtocolException
    //   2827	2833	2836	java/io/IOException
    //   3012	3017	3020	java/io/IOException
    //   3044	3049	3052	java/io/IOException
    //   3073	3081	3084	java/lang/Exception
    //   2784	2806	3114	finally
    //   2784	2806	3119	java/lang/Exception
    //   2784	2806	3124	java/io/IOException
    //   2784	2806	3129	java/net/UnknownServiceException
    //   2784	2806	3134	java/net/NoRouteToHostException
    //   2784	2806	3139	java/net/ProtocolException
    //   2508	2514	3144	finally
    //   2508	2514	3184	java/lang/Exception
    //   2508	2514	3205	java/io/IOException
    //   2508	2514	3226	java/net/UnknownServiceException
    //   2508	2514	3243	java/net/NoRouteToHostException
    //   2508	2514	3260	java/net/ProtocolException
    //   2501	2508	3269	finally
    //   2501	2508	3305	java/lang/Exception
    //   2501	2508	3322	java/io/IOException
    //   2501	2508	3343	java/net/UnknownServiceException
    //   2501	2508	3368	java/net/NoRouteToHostException
    //   2501	2508	3393	java/net/ProtocolException
    //   2481	2501	3402	finally
    //   2481	2501	3407	java/lang/Exception
    //   2481	2501	3412	java/io/IOException
    //   2481	2501	3417	java/net/UnknownServiceException
    //   2481	2501	3422	java/net/NoRouteToHostException
    //   2481	2501	3427	java/net/ProtocolException
    //   2444	2481	3432	finally
    //   2444	2481	3437	java/lang/Exception
    //   2444	2481	3442	java/io/IOException
    //   2444	2481	3451	java/net/UnknownServiceException
    //   2444	2481	3456	java/net/NoRouteToHostException
    //   2444	2481	3461	java/net/ProtocolException
    //   1943	1976	3577	finally
    //   1943	1976	3582	java/lang/Exception
    //   1943	1976	3587	java/io/IOException
    //   1943	1976	3592	java/net/UnknownServiceException
    //   1943	1976	3597	java/net/NoRouteToHostException
    //   1943	1976	3602	java/net/ProtocolException
    //   1716	1816	3607	finally
    //   1911	1939	3607	finally
    //   1716	1816	3630	java/lang/Exception
    //   1911	1939	3630	java/lang/Exception
    //   1716	1816	3635	java/io/IOException
    //   1911	1939	3635	java/io/IOException
    //   1716	1816	3640	java/net/UnknownServiceException
    //   1911	1939	3640	java/net/UnknownServiceException
    //   1716	1816	3645	java/net/NoRouteToHostException
    //   1911	1939	3645	java/net/NoRouteToHostException
    //   1716	1816	3650	java/net/ProtocolException
    //   1911	1939	3650	java/net/ProtocolException
    //   1309	1315	3700	finally
    //   1309	1315	3717	java/lang/Exception
    //   1309	1315	3738	java/io/IOException
    //   1309	1315	3751	java/net/UnknownServiceException
    //   1309	1315	3760	java/net/NoRouteToHostException
    //   1309	1315	3769	java/net/ProtocolException
    //   1233	1241	3782	finally
    //   1241	1309	3782	finally
    //   1233	1241	3787	java/lang/Exception
    //   1241	1309	3787	java/lang/Exception
    //   1233	1241	3792	java/io/IOException
    //   1241	1309	3792	java/io/IOException
    //   1233	1241	3797	java/net/UnknownServiceException
    //   1241	1309	3797	java/net/UnknownServiceException
    //   1233	1241	3802	java/net/NoRouteToHostException
    //   1241	1309	3802	java/net/NoRouteToHostException
    //   1233	1241	3807	java/net/ProtocolException
    //   1241	1309	3807	java/net/ProtocolException
    //   989	1031	3812	finally
    //   989	1031	3817	java/lang/Exception
    //   989	1031	3822	java/io/IOException
    //   989	1031	3827	java/net/UnknownServiceException
    //   989	1031	3836	java/net/NoRouteToHostException
    //   989	1031	3845	java/net/ProtocolException
    //   972	980	3904	java/lang/Exception
    //   972	980	3909	java/io/IOException
    //   972	980	3914	java/net/UnknownServiceException
    //   972	980	3919	java/net/NoRouteToHostException
    //   972	980	3924	java/net/ProtocolException
    //   965	972	3929	finally
    //   972	980	3929	finally
    //   965	972	3958	java/lang/Exception
    //   965	972	3963	java/io/IOException
    //   965	972	3968	java/net/UnknownServiceException
    //   965	972	3983	java/net/NoRouteToHostException
    //   965	972	3998	java/net/ProtocolException
    //   594	601	4017	finally
    //   594	601	4046	java/lang/Exception
    //   4125	4131	4134	java/io/IOException
    //   4312	4317	4320	java/io/IOException
    //   4344	4349	4352	java/io/IOException
    //   4373	4381	4384	java/lang/Exception
    //   4070	4104	4414	finally
    //   594	601	4449	java/io/IOException
    //   4601	4607	4610	java/io/IOException
    //   4788	4793	4796	java/io/IOException
    //   4820	4825	4828	java/io/IOException
    //   4849	4857	4860	java/lang/Exception
    //   594	601	4880	java/net/UnknownServiceException
    //   5032	5038	5041	java/io/IOException
    //   5218	5223	5226	java/io/IOException
    //   5250	5255	5258	java/io/IOException
    //   5279	5287	5290	java/lang/Exception
    //   594	601	5310	java/net/NoRouteToHostException
    //   5474	5480	5483	java/io/IOException
    //   5660	5665	5668	java/io/IOException
    //   5692	5697	5700	java/io/IOException
    //   5721	5729	5732	java/lang/Exception
    //   4500	4522	5762	finally
    //   4545	4552	5762	finally
    //   4575	4580	5762	finally
    //   4931	4953	5762	finally
    //   4976	4983	5762	finally
    //   5006	5011	5762	finally
    //   5373	5395	5762	finally
    //   5418	5425	5762	finally
    //   5448	5453	5762	finally
    //   594	601	5796	java/net/ProtocolException
    //   5866	5872	5875	java/io/IOException
    //   6053	6058	6061	java/io/IOException
    //   6085	6090	6093	java/io/IOException
    //   6114	6122	6125	java/lang/Exception
    //   5811	5845	6160	finally
    //   6229	6235	6238	java/io/IOException
    //   6415	6420	6423	java/io/IOException
    //   6446	6451	6454	java/io/IOException
    //   6475	6483	6486	java/lang/Exception
    //   2549	2558	6794	finally
    //   2581	2588	6794	finally
    //   2614	2626	6794	finally
    //   2647	2691	6794	finally
    //   2549	2558	6802	java/lang/Exception
    //   2581	2588	6802	java/lang/Exception
    //   2614	2626	6802	java/lang/Exception
    //   2647	2691	6802	java/lang/Exception
    //   2549	2558	6810	java/io/IOException
    //   2581	2588	6810	java/io/IOException
    //   2614	2626	6810	java/io/IOException
    //   2647	2691	6810	java/io/IOException
    //   2549	2558	6818	java/net/UnknownServiceException
    //   2581	2588	6818	java/net/UnknownServiceException
    //   2614	2626	6818	java/net/UnknownServiceException
    //   2647	2691	6818	java/net/UnknownServiceException
    //   2549	2558	6826	java/net/NoRouteToHostException
    //   2581	2588	6826	java/net/NoRouteToHostException
    //   2614	2626	6826	java/net/NoRouteToHostException
    //   2647	2691	6826	java/net/NoRouteToHostException
    //   2549	2558	6834	java/net/ProtocolException
    //   2581	2588	6834	java/net/ProtocolException
    //   2614	2626	6834	java/net/ProtocolException
    //   2647	2691	6834	java/net/ProtocolException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qh.b
 * JD-Core Version:    0.7.0.1
 */