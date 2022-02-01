package com.tencent.map.sdk.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bi
  extends bc
{
  private long A = 0L;
  private String B;
  private bi.a C;
  private boolean D;
  private bg E;
  long o;
  boolean p;
  int q;
  boolean r;
  private HttpURLConnection s;
  private DataOutputStream t;
  private DataInputStream u;
  private bh v;
  private String w;
  private boolean x;
  private boolean y;
  private int z;
  
  public bi(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString3)
  {
    boolean bool = false;
    this.C = new bi.a((byte)0);
    this.p = false;
    this.D = false;
    this.q = 0;
    this.r = false;
    this.w = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    int i;
    if (ao.g() == 2) {
      i = as.a("direct_access_time_out", 1000, 60000, 15000);
    } else {
      i = as.a("direct_access_time_out", 1000, 60000, 10000);
    }
    int j = i;
    if (paramInt < i) {
      j = paramInt;
    }
    this.f = dg.a(j, 200, 60000, 10000);
    paramBoolean = bool;
    if (this.b.length() > 8) {
      if (this.b.charAt(7) != '[')
      {
        paramBoolean = bool;
        if (this.b.charAt(8) != '[') {}
      }
      else
      {
        paramBoolean = true;
      }
    }
    this.g = a(paramInt, paramBoolean);
    this.h = paramString3;
  }
  
  private static int a(int paramInt, boolean paramBoolean)
  {
    int i;
    if ((ao.h() == 2) && (paramBoolean)) {
      i = as.a("direct_access_conn_time_out", 1000, 60000, 2000);
    } else {
      i = as.a("direct_access_conn_time_out", 1000, 60000, 10000);
    }
    if (paramInt >= i) {
      paramInt = i;
    }
    return dg.a(paramInt, 200, 60000, 10000);
  }
  
  private void a(int paramInt)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        localObject1 = new BufferedInputStream(this.s.getInputStream());
        localObject2 = new ByteArrayOutputStream();
        arrayOfByte = new byte[4096];
        i = 0;
        j = i;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        Object localObject1;
        Object localObject2;
        byte[] arrayOfByte;
        int i;
        int j;
        int k;
        continue;
      }
      catch (Exception localException1)
      {
        continue;
      }
      try
      {
        k = ((BufferedInputStream)localObject1).read(arrayOfByte);
        if (k == -1) {
          break label227;
        }
        j = i;
        ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, k);
        k = i + k;
        i = k;
        if (k <= paramInt) {
          continue;
        }
        j = k;
        this.v.a = -303;
        j = k;
        this.v.b = "no-content-length";
        paramInt = m;
        i = k;
        if (paramInt != 0)
        {
          j = i;
          this.v.d = ((ByteArrayOutputStream)localObject2).toByteArray();
          j = i;
          this.C.f = SystemClock.elapsedRealtime();
        }
        j = i;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        continue;
      }
      try
      {
        ((ByteArrayOutputStream)localObject2).close();
        return;
      }
      catch (Exception localException2)
      {
        return;
      }
      localObject2 = this.v;
      ((bh)localObject2).a = -287;
      localObject1 = "read without content-length error";
      ((bh)localObject2).b = ((String)localObject1);
      return;
      j = 0;
      localObject2 = this.v;
      ((bh)localObject2).a = -306;
      localObject1 = "no-content-length:".concat(String.valueOf(j));
      continue;
      label227:
      paramInt = 1;
    }
  }
  
  private void c()
  {
    Object localObject1 = this.d;
    int k = 0;
    int i = 0;
    int j = k;
    if (localObject1 != null)
    {
      j = k;
      if (this.d.size() > 0)
      {
        localObject1 = this.d.keySet().iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
          String str = (String)this.d.get(localObject2);
          this.s.addRequestProperty((String)localObject2, str);
          if (((String)localObject2).toLowerCase().contains("host")) {
            i = 1;
          }
        }
      }
    }
    if (j == 0) {
      this.s.setRequestProperty("Host", this.w);
    }
    localObject1 = this.s;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.h);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(this.q);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((HttpURLConnection)localObject1).setRequestProperty("Halley", ((StringBuilder)localObject2).toString());
    if (this.p)
    {
      this.s.setRequestProperty("X-Online-Host", this.w);
      this.s.setRequestProperty("x-tx-host", this.w);
    }
  }
  
  private boolean d()
  {
    if (this.m)
    {
      this.v.a = -20;
      this.o = (SystemClock.elapsedRealtime() - this.o);
      this.C.a();
      return true;
    }
    return false;
  }
  
  private void e()
  {
    try
    {
      if (this.s != null) {
        this.s.disconnect();
      }
      if (this.t != null) {
        this.t.close();
      }
      if (this.u != null) {
        this.u.close();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  /* Error */
  public final bh a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   4: putfield 266	com/tencent/map/sdk/a/bi:o	J
    //   7: aload_0
    //   8: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   11: aload_0
    //   12: getfield 266	com/tencent/map/sdk/a/bi:o	J
    //   15: putfield 288	com/tencent/map/sdk/a/bi$a:a	J
    //   18: iconst_0
    //   19: istore 6
    //   21: iconst_0
    //   22: istore_1
    //   23: iconst_0
    //   24: istore_2
    //   25: iconst_0
    //   26: istore 4
    //   28: iconst_0
    //   29: istore_3
    //   30: iconst_0
    //   31: istore 5
    //   33: aload_0
    //   34: new 150	com/tencent/map/sdk/a/bh
    //   37: dup
    //   38: iconst_0
    //   39: ldc_w 290
    //   42: invokespecial 293	com/tencent/map/sdk/a/bh:<init>	(ILjava/lang/String;)V
    //   45: putfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   48: aload_0
    //   49: invokespecial 295	com/tencent/map/sdk/a/bi:d	()Z
    //   52: ifeq +96 -> 148
    //   55: aload_0
    //   56: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   59: astore 7
    //   61: aload_0
    //   62: invokespecial 297	com/tencent/map/sdk/a/bi:e	()V
    //   65: aload_0
    //   66: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   69: aload_0
    //   70: getfield 266	com/tencent/map/sdk/a/bi:o	J
    //   73: lsub
    //   74: putfield 266	com/tencent/map/sdk/a/bi:o	J
    //   77: aload_0
    //   78: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   81: invokevirtual 268	com/tencent/map/sdk/a/bi$a:a	()V
    //   84: aload_0
    //   85: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   88: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   91: ifeq +54 -> 145
    //   94: invokestatic 300	com/tencent/map/sdk/a/ao:i	()Z
    //   97: ifeq +48 -> 145
    //   100: aload_0
    //   101: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   104: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   107: bipush 236
    //   109: if_icmpeq +36 -> 145
    //   112: iload 5
    //   114: istore_1
    //   115: ldc_w 302
    //   118: iconst_0
    //   119: iconst_1
    //   120: iconst_0
    //   121: invokestatic 84	com/tencent/map/sdk/a/as:a	(Ljava/lang/String;III)I
    //   124: iconst_1
    //   125: if_icmpne +5 -> 130
    //   128: iconst_1
    //   129: istore_1
    //   130: iload_1
    //   131: ifeq +14 -> 145
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 55	com/tencent/map/sdk/a/bi:w	Ljava/lang/String;
    //   139: invokestatic 304	com/tencent/map/sdk/a/dg:c	(Ljava/lang/String;)Ljava/lang/String;
    //   142: putfield 306	com/tencent/map/sdk/a/bi:B	Ljava/lang/String;
    //   145: aload 7
    //   147: areturn
    //   148: new 308	java/net/URL
    //   151: dup
    //   152: aload_0
    //   153: getfield 58	com/tencent/map/sdk/a/bi:b	Ljava/lang/String;
    //   156: invokespecial 311	java/net/URL:<init>	(Ljava/lang/String;)V
    //   159: astore 7
    //   161: aload_0
    //   162: aload 7
    //   164: invokevirtual 314	java/net/URL:getProtocol	()Ljava/lang/String;
    //   167: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   170: ldc_w 316
    //   173: invokevirtual 320	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   176: putfield 322	com/tencent/map/sdk/a/bi:x	Z
    //   179: aload_0
    //   180: aload 7
    //   182: invokevirtual 325	java/net/URL:getHost	()Ljava/lang/String;
    //   185: invokestatic 327	com/tencent/map/sdk/a/dg:d	(Ljava/lang/String;)Z
    //   188: putfield 329	com/tencent/map/sdk/a/bi:y	Z
    //   191: aload_0
    //   192: getfield 322	com/tencent/map/sdk/a/bi:x	Z
    //   195: ifeq +104 -> 299
    //   198: aload_0
    //   199: getfield 47	com/tencent/map/sdk/a/bi:p	Z
    //   202: ifeq +29 -> 231
    //   205: invokestatic 333	com/tencent/map/sdk/a/ao:l	()Ljava/net/Proxy;
    //   208: ifnull +23 -> 231
    //   211: aload 7
    //   213: invokestatic 333	com/tencent/map/sdk/a/ao:l	()Ljava/net/Proxy;
    //   216: invokevirtual 337	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   219: astore 7
    //   221: aload 7
    //   223: checkcast 339	javax/net/ssl/HttpsURLConnection
    //   226: astore 8
    //   228: goto +13 -> 241
    //   231: aload 7
    //   233: invokevirtual 342	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   236: astore 7
    //   238: goto -17 -> 221
    //   241: aload 8
    //   243: astore 7
    //   245: aload_0
    //   246: getfield 329	com/tencent/map/sdk/a/bi:y	Z
    //   249: ifeq +93 -> 342
    //   252: aload_0
    //   253: new 344	com/tencent/map/sdk/a/bg
    //   256: dup
    //   257: aload_0
    //   258: getfield 55	com/tencent/map/sdk/a/bi:w	Ljava/lang/String;
    //   261: invokespecial 345	com/tencent/map/sdk/a/bg:<init>	(Ljava/lang/String;)V
    //   264: putfield 347	com/tencent/map/sdk/a/bi:E	Lcom/tencent/map/sdk/a/bg;
    //   267: aload 8
    //   269: aload_0
    //   270: getfield 347	com/tencent/map/sdk/a/bi:E	Lcom/tencent/map/sdk/a/bg;
    //   273: invokevirtual 351	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   276: aload 8
    //   278: new 353	com/tencent/map/sdk/a/bf
    //   281: dup
    //   282: aload_0
    //   283: getfield 55	com/tencent/map/sdk/a/bi:w	Ljava/lang/String;
    //   286: invokespecial 354	com/tencent/map/sdk/a/bf:<init>	(Ljava/lang/String;)V
    //   289: invokevirtual 358	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   292: aload 8
    //   294: astore 7
    //   296: goto +46 -> 342
    //   299: aload_0
    //   300: getfield 47	com/tencent/map/sdk/a/bi:p	Z
    //   303: ifeq +29 -> 332
    //   306: invokestatic 333	com/tencent/map/sdk/a/ao:l	()Ljava/net/Proxy;
    //   309: ifnull +23 -> 332
    //   312: aload 7
    //   314: invokestatic 333	com/tencent/map/sdk/a/ao:l	()Ljava/net/Proxy;
    //   317: invokevirtual 337	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   320: astore 7
    //   322: aload 7
    //   324: checkcast 128	java/net/HttpURLConnection
    //   327: astore 7
    //   329: goto +13 -> 342
    //   332: aload 7
    //   334: invokevirtual 342	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   337: astore 7
    //   339: goto -17 -> 322
    //   342: aload_0
    //   343: aload 7
    //   345: putfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   348: aload_0
    //   349: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   352: astore 8
    //   354: aload_0
    //   355: getfield 61	com/tencent/map/sdk/a/bi:c	Z
    //   358: ifeq +1690 -> 2048
    //   361: ldc_w 360
    //   364: astore 7
    //   366: goto +3 -> 369
    //   369: aload 8
    //   371: aload 7
    //   373: invokevirtual 363	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   376: aload_0
    //   377: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   380: aload_0
    //   381: getfield 106	com/tencent/map/sdk/a/bi:g	I
    //   384: invokevirtual 366	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   387: aload_0
    //   388: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   391: aload_0
    //   392: getfield 92	com/tencent/map/sdk/a/bi:f	I
    //   395: invokevirtual 369	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   398: aload_0
    //   399: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   402: iconst_0
    //   403: invokevirtual 373	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   406: aload_0
    //   407: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   410: iconst_1
    //   411: invokevirtual 376	java/net/HttpURLConnection:setDoInput	(Z)V
    //   414: aload_0
    //   415: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   418: iconst_0
    //   419: invokevirtual 379	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   422: aload_0
    //   423: invokespecial 381	com/tencent/map/sdk/a/bi:c	()V
    //   426: aload_0
    //   427: getfield 61	com/tencent/map/sdk/a/bi:c	Z
    //   430: ifne +31 -> 461
    //   433: aload_0
    //   434: getfield 69	com/tencent/map/sdk/a/bi:e	[B
    //   437: invokestatic 384	com/tencent/map/sdk/a/dg:a	([B)Z
    //   440: ifne +21 -> 461
    //   443: aload_0
    //   444: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   447: iconst_1
    //   448: invokevirtual 387	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   451: aload_0
    //   452: aload_0
    //   453: getfield 69	com/tencent/map/sdk/a/bi:e	[B
    //   456: arraylength
    //   457: i2l
    //   458: putfield 38	com/tencent/map/sdk/a/bi:A	J
    //   461: aload_0
    //   462: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   465: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   468: putfield 389	com/tencent/map/sdk/a/bi$a:b	J
    //   471: aload_0
    //   472: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   475: invokevirtual 392	java/net/HttpURLConnection:connect	()V
    //   478: aload_0
    //   479: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   482: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   485: putfield 394	com/tencent/map/sdk/a/bi$a:c	J
    //   488: aload_0
    //   489: invokespecial 295	com/tencent/map/sdk/a/bi:d	()Z
    //   492: ifeq +96 -> 588
    //   495: aload_0
    //   496: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   499: astore 7
    //   501: aload_0
    //   502: invokespecial 297	com/tencent/map/sdk/a/bi:e	()V
    //   505: aload_0
    //   506: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   509: aload_0
    //   510: getfield 266	com/tencent/map/sdk/a/bi:o	J
    //   513: lsub
    //   514: putfield 266	com/tencent/map/sdk/a/bi:o	J
    //   517: aload_0
    //   518: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   521: invokevirtual 268	com/tencent/map/sdk/a/bi$a:a	()V
    //   524: aload_0
    //   525: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   528: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   531: ifeq +54 -> 585
    //   534: invokestatic 300	com/tencent/map/sdk/a/ao:i	()Z
    //   537: ifeq +48 -> 585
    //   540: aload_0
    //   541: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   544: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   547: bipush 236
    //   549: if_icmpeq +36 -> 585
    //   552: iload 6
    //   554: istore_1
    //   555: ldc_w 302
    //   558: iconst_0
    //   559: iconst_1
    //   560: iconst_0
    //   561: invokestatic 84	com/tencent/map/sdk/a/as:a	(Ljava/lang/String;III)I
    //   564: iconst_1
    //   565: if_icmpne +5 -> 570
    //   568: iconst_1
    //   569: istore_1
    //   570: iload_1
    //   571: ifeq +14 -> 585
    //   574: aload_0
    //   575: aload_0
    //   576: getfield 55	com/tencent/map/sdk/a/bi:w	Ljava/lang/String;
    //   579: invokestatic 304	com/tencent/map/sdk/a/dg:c	(Ljava/lang/String;)Ljava/lang/String;
    //   582: putfield 306	com/tencent/map/sdk/a/bi:B	Ljava/lang/String;
    //   585: aload 7
    //   587: areturn
    //   588: aload_0
    //   589: getfield 61	com/tencent/map/sdk/a/bi:c	Z
    //   592: ifne +49 -> 641
    //   595: aload_0
    //   596: getfield 69	com/tencent/map/sdk/a/bi:e	[B
    //   599: invokestatic 384	com/tencent/map/sdk/a/dg:a	([B)Z
    //   602: ifne +39 -> 641
    //   605: aload_0
    //   606: new 277	java/io/DataOutputStream
    //   609: dup
    //   610: aload_0
    //   611: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   614: invokevirtual 398	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   617: invokespecial 401	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   620: putfield 275	com/tencent/map/sdk/a/bi:t	Ljava/io/DataOutputStream;
    //   623: aload_0
    //   624: getfield 275	com/tencent/map/sdk/a/bi:t	Ljava/io/DataOutputStream;
    //   627: aload_0
    //   628: getfield 69	com/tencent/map/sdk/a/bi:e	[B
    //   631: invokevirtual 404	java/io/DataOutputStream:write	([B)V
    //   634: aload_0
    //   635: getfield 275	com/tencent/map/sdk/a/bi:t	Ljava/io/DataOutputStream;
    //   638: invokevirtual 407	java/io/DataOutputStream:flush	()V
    //   641: aload_0
    //   642: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   645: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   648: putfield 409	com/tencent/map/sdk/a/bi$a:d	J
    //   651: aload_0
    //   652: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   655: invokevirtual 412	java/net/HttpURLConnection:getResponseCode	()I
    //   658: istore 5
    //   660: aload_0
    //   661: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   664: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   667: putfield 414	com/tencent/map/sdk/a/bi$a:e	J
    //   670: aload_0
    //   671: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   674: iload 5
    //   676: putfield 416	com/tencent/map/sdk/a/bh:c	I
    //   679: aload_0
    //   680: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   683: invokevirtual 419	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   686: pop
    //   687: new 421	java/util/HashMap
    //   690: dup
    //   691: invokespecial 422	java/util/HashMap:<init>	()V
    //   694: astore 7
    //   696: aload_0
    //   697: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   700: invokevirtual 426	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   703: invokeinterface 429 1 0
    //   708: invokeinterface 199 1 0
    //   713: astore 8
    //   715: aload 8
    //   717: invokeinterface 205 1 0
    //   722: ifeq +59 -> 781
    //   725: aload 8
    //   727: invokeinterface 209 1 0
    //   732: checkcast 431	java/util/Map$Entry
    //   735: astore 9
    //   737: aload 9
    //   739: invokeinterface 434 1 0
    //   744: ifnull -29 -> 715
    //   747: aload 7
    //   749: aload 9
    //   751: invokeinterface 434 1 0
    //   756: aload 9
    //   758: invokeinterface 437 1 0
    //   763: checkcast 439	java/util/List
    //   766: iconst_0
    //   767: invokeinterface 442 2 0
    //   772: invokeinterface 446 3 0
    //   777: pop
    //   778: goto -63 -> 715
    //   781: aload_0
    //   782: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   785: aload 7
    //   787: invokevirtual 449	com/tencent/map/sdk/a/bh:a	(Ljava/util/Map;)V
    //   790: aload_0
    //   791: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   794: getfield 416	com/tencent/map/sdk/a/bh:c	I
    //   797: sipush 200
    //   800: if_icmplt +253 -> 1053
    //   803: aload_0
    //   804: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   807: getfield 416	com/tencent/map/sdk/a/bh:c	I
    //   810: sipush 300
    //   813: if_icmpge +240 -> 1053
    //   816: aload_0
    //   817: aload_0
    //   818: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   821: invokevirtual 452	java/net/HttpURLConnection:getContentLength	()I
    //   824: putfield 454	com/tencent/map/sdk/a/bi:z	I
    //   827: ldc_w 456
    //   830: ldc_w 457
    //   833: ldc_w 458
    //   836: ldc_w 459
    //   839: invokestatic 84	com/tencent/map/sdk/a/as:a	(Ljava/lang/String;III)I
    //   842: istore 5
    //   844: aload_0
    //   845: getfield 454	com/tencent/map/sdk/a/bi:z	I
    //   848: ifge +12 -> 860
    //   851: aload_0
    //   852: iload 5
    //   854: invokespecial 461	com/tencent/map/sdk/a/bi:a	(I)V
    //   857: goto +236 -> 1093
    //   860: aload_0
    //   861: getfield 454	com/tencent/map/sdk/a/bi:z	I
    //   864: ifne +26 -> 890
    //   867: aload_0
    //   868: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   871: iconst_0
    //   872: newarray byte
    //   874: putfield 161	com/tencent/map/sdk/a/bh:d	[B
    //   877: aload_0
    //   878: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   881: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   884: putfield 169	com/tencent/map/sdk/a/bi$a:f	J
    //   887: goto +206 -> 1093
    //   890: aload_0
    //   891: getfield 454	com/tencent/map/sdk/a/bi:z	I
    //   894: iload 5
    //   896: if_icmple +55 -> 951
    //   899: aload_0
    //   900: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   903: sipush -303
    //   906: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   909: aload_0
    //   910: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   913: astore 7
    //   915: new 234	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   922: astore 8
    //   924: aload 8
    //   926: aload_0
    //   927: getfield 454	com/tencent/map/sdk/a/bi:z	I
    //   930: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: aload 8
    //   936: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: astore 8
    //   941: aload 7
    //   943: aload 8
    //   945: putfield 155	com/tencent/map/sdk/a/bh:b	Ljava/lang/String;
    //   948: goto +145 -> 1093
    //   951: aload_0
    //   952: getfield 454	com/tencent/map/sdk/a/bi:z	I
    //   955: newarray byte
    //   957: astore 7
    //   959: aload_0
    //   960: new 282	java/io/DataInputStream
    //   963: dup
    //   964: aload_0
    //   965: getfield 126	com/tencent/map/sdk/a/bi:s	Ljava/net/HttpURLConnection;
    //   968: invokevirtual 132	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   971: invokespecial 462	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   974: putfield 280	com/tencent/map/sdk/a/bi:u	Ljava/io/DataInputStream;
    //   977: aload_0
    //   978: getfield 280	com/tencent/map/sdk/a/bi:u	Ljava/io/DataInputStream;
    //   981: aload 7
    //   983: invokevirtual 465	java/io/DataInputStream:readFully	([B)V
    //   986: aload_0
    //   987: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   990: aload 7
    //   992: putfield 161	com/tencent/map/sdk/a/bh:d	[B
    //   995: aload_0
    //   996: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   999: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   1002: putfield 169	com/tencent/map/sdk/a/bi$a:f	J
    //   1005: goto +88 -> 1093
    //   1008: aload_0
    //   1009: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1012: sipush -306
    //   1015: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1018: aload_0
    //   1019: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1022: astore 7
    //   1024: new 234	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   1031: astore 8
    //   1033: aload 8
    //   1035: aload_0
    //   1036: getfield 454	com/tencent/map/sdk/a/bi:z	I
    //   1039: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: aload 8
    //   1045: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: astore 8
    //   1050: goto -109 -> 941
    //   1053: aload_0
    //   1054: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1057: getfield 416	com/tencent/map/sdk/a/bh:c	I
    //   1060: sipush 300
    //   1063: if_icmplt +30 -> 1093
    //   1066: aload_0
    //   1067: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1070: getfield 416	com/tencent/map/sdk/a/bh:c	I
    //   1073: sipush 400
    //   1076: if_icmpge +17 -> 1093
    //   1079: aload_0
    //   1080: aload_0
    //   1081: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1084: ldc_w 467
    //   1087: invokevirtual 469	com/tencent/map/sdk/a/bh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1090: putfield 471	com/tencent/map/sdk/a/bi:i	Ljava/lang/String;
    //   1093: aload_0
    //   1094: invokespecial 297	com/tencent/map/sdk/a/bi:e	()V
    //   1097: aload_0
    //   1098: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   1101: aload_0
    //   1102: getfield 266	com/tencent/map/sdk/a/bi:o	J
    //   1105: lsub
    //   1106: putfield 266	com/tencent/map/sdk/a/bi:o	J
    //   1109: aload_0
    //   1110: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   1113: invokevirtual 268	com/tencent/map/sdk/a/bi$a:a	()V
    //   1116: aload_0
    //   1117: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1120: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1123: ifeq +818 -> 1941
    //   1126: invokestatic 300	com/tencent/map/sdk/a/ao:i	()Z
    //   1129: ifeq +812 -> 1941
    //   1132: aload_0
    //   1133: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1136: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1139: bipush 236
    //   1141: if_icmpeq +800 -> 1941
    //   1144: ldc_w 302
    //   1147: iconst_0
    //   1148: iconst_1
    //   1149: iconst_0
    //   1150: invokestatic 84	com/tencent/map/sdk/a/as:a	(Ljava/lang/String;III)I
    //   1153: iconst_1
    //   1154: if_icmpne +5 -> 1159
    //   1157: iconst_1
    //   1158: istore_1
    //   1159: iload_1
    //   1160: ifeq +781 -> 1941
    //   1163: aload_0
    //   1164: aload_0
    //   1165: getfield 55	com/tencent/map/sdk/a/bi:w	Ljava/lang/String;
    //   1168: invokestatic 304	com/tencent/map/sdk/a/dg:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1171: putfield 306	com/tencent/map/sdk/a/bi:B	Ljava/lang/String;
    //   1174: goto +767 -> 1941
    //   1177: astore 7
    //   1179: goto +767 -> 1946
    //   1182: astore 7
    //   1184: aload 7
    //   1186: invokevirtual 474	java/lang/Throwable:printStackTrace	()V
    //   1189: aload_0
    //   1190: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1193: sipush -287
    //   1196: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1199: aload_0
    //   1200: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1203: astore 8
    //   1205: new 234	java/lang/StringBuilder
    //   1208: dup
    //   1209: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   1212: astore 9
    //   1214: aload 9
    //   1216: aload 7
    //   1218: invokevirtual 480	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1221: invokevirtual 485	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   1224: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: pop
    //   1228: aload 9
    //   1230: ldc_w 487
    //   1233: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: pop
    //   1237: aload 9
    //   1239: aload 7
    //   1241: invokevirtual 490	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   1244: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload 9
    //   1250: ldc_w 492
    //   1253: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: pop
    //   1257: aload 8
    //   1259: aload 9
    //   1261: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1264: putfield 155	com/tencent/map/sdk/a/bh:b	Ljava/lang/String;
    //   1267: aload_0
    //   1268: getfield 322	com/tencent/map/sdk/a/bi:x	Z
    //   1271: ifeq +22 -> 1293
    //   1274: aload_0
    //   1275: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1278: getfield 155	com/tencent/map/sdk/a/bh:b	Ljava/lang/String;
    //   1281: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1284: ldc_w 494
    //   1287: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1290: ifne +766 -> 2056
    //   1293: aload_0
    //   1294: getfield 322	com/tencent/map/sdk/a/bi:x	Z
    //   1297: ifeq +764 -> 2061
    //   1300: aload_0
    //   1301: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1304: getfield 155	com/tencent/map/sdk/a/bh:b	Ljava/lang/String;
    //   1307: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1310: ldc_w 496
    //   1313: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1316: ifeq +745 -> 2061
    //   1319: goto +737 -> 2056
    //   1322: invokestatic 300	com/tencent/map/sdk/a/ao:i	()Z
    //   1325: ifne +15 -> 1340
    //   1328: aload_0
    //   1329: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1332: bipush 252
    //   1334: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1337: goto +443 -> 1780
    //   1340: aload_0
    //   1341: getfield 264	com/tencent/map/sdk/a/bi:m	Z
    //   1344: ifeq +15 -> 1359
    //   1347: aload_0
    //   1348: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1351: bipush 236
    //   1353: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1356: goto +424 -> 1780
    //   1359: iload_1
    //   1360: ifeq +16 -> 1376
    //   1363: aload_0
    //   1364: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1367: sipush -289
    //   1370: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1373: goto +407 -> 1780
    //   1376: aload 7
    //   1378: instanceof 498
    //   1381: ifeq +20 -> 1401
    //   1384: aload_0
    //   1385: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1388: astore 7
    //   1390: aload 7
    //   1392: sipush -290
    //   1395: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1398: goto +382 -> 1780
    //   1401: aload 7
    //   1403: instanceof 500
    //   1406: ifne +364 -> 1770
    //   1409: aload 7
    //   1411: instanceof 502
    //   1414: ifne +356 -> 1770
    //   1417: aload 7
    //   1419: instanceof 504
    //   1422: ifeq +6 -> 1428
    //   1425: goto +345 -> 1770
    //   1428: aload_0
    //   1429: iconst_1
    //   1430: putfield 507	com/tencent/map/sdk/a/bi:j	Z
    //   1433: aload 7
    //   1435: invokevirtual 510	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1438: ifnull +43 -> 1481
    //   1441: aload 7
    //   1443: invokevirtual 510	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1446: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1449: ldc_w 512
    //   1452: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1455: ifeq +26 -> 1481
    //   1458: aload_0
    //   1459: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1462: sipush -281
    //   1465: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1468: aload_0
    //   1469: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1472: ldc_w 514
    //   1475: putfield 155	com/tencent/map/sdk/a/bh:b	Ljava/lang/String;
    //   1478: goto +302 -> 1780
    //   1481: aload 7
    //   1483: instanceof 516
    //   1486: ifeq +16 -> 1502
    //   1489: aload_0
    //   1490: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1493: sipush -284
    //   1496: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1499: goto +281 -> 1780
    //   1502: aload 7
    //   1504: instanceof 518
    //   1507: ifeq +15 -> 1522
    //   1510: aload_0
    //   1511: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1514: bipush 214
    //   1516: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1519: goto +261 -> 1780
    //   1522: aload 7
    //   1524: instanceof 520
    //   1527: ifeq +71 -> 1598
    //   1530: aload 7
    //   1532: invokevirtual 490	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   1535: astore 7
    //   1537: aload 7
    //   1539: ifnull +47 -> 1586
    //   1542: aload 7
    //   1544: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1547: ldc_w 521
    //   1550: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1553: ifne +17 -> 1570
    //   1556: aload 7
    //   1558: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1561: ldc_w 523
    //   1564: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1567: ifeq +19 -> 1586
    //   1570: aload_0
    //   1571: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1574: astore 7
    //   1576: aload 7
    //   1578: bipush 246
    //   1580: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1583: goto +197 -> 1780
    //   1586: aload_0
    //   1587: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1590: bipush 243
    //   1592: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1595: goto +185 -> 1780
    //   1598: aload 7
    //   1600: instanceof 525
    //   1603: ifeq +15 -> 1618
    //   1606: aload_0
    //   1607: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1610: bipush 215
    //   1612: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1615: goto +165 -> 1780
    //   1618: aload 7
    //   1620: instanceof 527
    //   1623: ifeq +157 -> 1780
    //   1626: aload_0
    //   1627: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1630: sipush -286
    //   1633: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1636: aload_0
    //   1637: getfield 322	com/tencent/map/sdk/a/bi:x	Z
    //   1640: ifeq +109 -> 1749
    //   1643: aload_0
    //   1644: getfield 347	com/tencent/map/sdk/a/bi:E	Lcom/tencent/map/sdk/a/bg;
    //   1647: ifnull +102 -> 1749
    //   1650: aload_0
    //   1651: getfield 347	com/tencent/map/sdk/a/bi:E	Lcom/tencent/map/sdk/a/bg;
    //   1654: getfield 529	com/tencent/map/sdk/a/bg:a	Z
    //   1657: ifeq +92 -> 1749
    //   1660: aload_0
    //   1661: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1664: getfield 155	com/tencent/map/sdk/a/bh:b	Ljava/lang/String;
    //   1667: ldc_w 531
    //   1670: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1673: ifeq +12 -> 1685
    //   1676: aload_0
    //   1677: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1680: astore 7
    //   1682: goto -292 -> 1390
    //   1685: aload_0
    //   1686: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1689: getfield 155	com/tencent/map/sdk/a/bh:b	Ljava/lang/String;
    //   1692: ldc_w 533
    //   1695: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1698: ifeq +12 -> 1710
    //   1701: aload_0
    //   1702: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1705: astore 7
    //   1707: goto -131 -> 1576
    //   1710: aload 7
    //   1712: instanceof 535
    //   1715: ifeq +21 -> 1736
    //   1718: aload_0
    //   1719: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1722: sipush -292
    //   1725: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1728: aload_0
    //   1729: iconst_0
    //   1730: putfield 507	com/tencent/map/sdk/a/bi:j	Z
    //   1733: goto +47 -> 1780
    //   1736: aload_0
    //   1737: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1740: sipush -293
    //   1743: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1746: goto +34 -> 1780
    //   1749: aload 7
    //   1751: instanceof 535
    //   1754: ifeq +26 -> 1780
    //   1757: aload_0
    //   1758: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1761: sipush -292
    //   1764: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1767: goto -39 -> 1728
    //   1770: aload_0
    //   1771: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1774: sipush -291
    //   1777: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1780: aload_0
    //   1781: invokespecial 297	com/tencent/map/sdk/a/bi:e	()V
    //   1784: aload_0
    //   1785: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   1788: aload_0
    //   1789: getfield 266	com/tencent/map/sdk/a/bi:o	J
    //   1792: lsub
    //   1793: putfield 266	com/tencent/map/sdk/a/bi:o	J
    //   1796: aload_0
    //   1797: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   1800: invokevirtual 268	com/tencent/map/sdk/a/bi$a:a	()V
    //   1803: aload_0
    //   1804: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1807: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1810: ifeq +131 -> 1941
    //   1813: invokestatic 300	com/tencent/map/sdk/a/ao:i	()Z
    //   1816: ifeq +125 -> 1941
    //   1819: aload_0
    //   1820: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1823: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1826: bipush 236
    //   1828: if_icmpeq +113 -> 1941
    //   1831: iload_2
    //   1832: istore_1
    //   1833: ldc_w 302
    //   1836: iconst_0
    //   1837: iconst_1
    //   1838: iconst_0
    //   1839: invokestatic 84	com/tencent/map/sdk/a/as:a	(Ljava/lang/String;III)I
    //   1842: iconst_1
    //   1843: if_icmpne +5 -> 1848
    //   1846: iconst_1
    //   1847: istore_1
    //   1848: iload_1
    //   1849: ifeq +92 -> 1941
    //   1852: goto -689 -> 1163
    //   1855: aload_0
    //   1856: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1859: sipush -300
    //   1862: putfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1865: aload_0
    //   1866: invokespecial 297	com/tencent/map/sdk/a/bi:e	()V
    //   1869: aload_0
    //   1870: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   1873: aload_0
    //   1874: getfield 266	com/tencent/map/sdk/a/bi:o	J
    //   1877: lsub
    //   1878: putfield 266	com/tencent/map/sdk/a/bi:o	J
    //   1881: aload_0
    //   1882: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   1885: invokevirtual 268	com/tencent/map/sdk/a/bi$a:a	()V
    //   1888: aload_0
    //   1889: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1892: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1895: ifeq +46 -> 1941
    //   1898: invokestatic 300	com/tencent/map/sdk/a/ao:i	()Z
    //   1901: ifeq +40 -> 1941
    //   1904: aload_0
    //   1905: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1908: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1911: bipush 236
    //   1913: if_icmpeq +28 -> 1941
    //   1916: iload 4
    //   1918: istore_1
    //   1919: ldc_w 302
    //   1922: iconst_0
    //   1923: iconst_1
    //   1924: iconst_0
    //   1925: invokestatic 84	com/tencent/map/sdk/a/as:a	(Ljava/lang/String;III)I
    //   1928: iconst_1
    //   1929: if_icmpne +5 -> 1934
    //   1932: iconst_1
    //   1933: istore_1
    //   1934: iload_1
    //   1935: ifeq +6 -> 1941
    //   1938: goto -775 -> 1163
    //   1941: aload_0
    //   1942: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1945: areturn
    //   1946: aload_0
    //   1947: invokespecial 297	com/tencent/map/sdk/a/bi:e	()V
    //   1950: aload_0
    //   1951: invokestatic 167	android/os/SystemClock:elapsedRealtime	()J
    //   1954: aload_0
    //   1955: getfield 266	com/tencent/map/sdk/a/bi:o	J
    //   1958: lsub
    //   1959: putfield 266	com/tencent/map/sdk/a/bi:o	J
    //   1962: aload_0
    //   1963: getfield 45	com/tencent/map/sdk/a/bi:C	Lcom/tencent/map/sdk/a/bi$a;
    //   1966: invokevirtual 268	com/tencent/map/sdk/a/bi$a:a	()V
    //   1969: aload_0
    //   1970: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1973: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1976: ifeq +53 -> 2029
    //   1979: invokestatic 300	com/tencent/map/sdk/a/ao:i	()Z
    //   1982: ifeq +47 -> 2029
    //   1985: aload_0
    //   1986: getfield 148	com/tencent/map/sdk/a/bi:v	Lcom/tencent/map/sdk/a/bh;
    //   1989: getfield 152	com/tencent/map/sdk/a/bh:a	I
    //   1992: bipush 236
    //   1994: if_icmpeq +35 -> 2029
    //   1997: iload_3
    //   1998: istore_1
    //   1999: ldc_w 302
    //   2002: iconst_0
    //   2003: iconst_1
    //   2004: iconst_0
    //   2005: invokestatic 84	com/tencent/map/sdk/a/as:a	(Ljava/lang/String;III)I
    //   2008: iconst_1
    //   2009: if_icmpne +5 -> 2014
    //   2012: iconst_1
    //   2013: istore_1
    //   2014: iload_1
    //   2015: ifeq +14 -> 2029
    //   2018: aload_0
    //   2019: aload_0
    //   2020: getfield 55	com/tencent/map/sdk/a/bi:w	Ljava/lang/String;
    //   2023: invokestatic 304	com/tencent/map/sdk/a/dg:c	(Ljava/lang/String;)Ljava/lang/String;
    //   2026: putfield 306	com/tencent/map/sdk/a/bi:B	Ljava/lang/String;
    //   2029: goto +6 -> 2035
    //   2032: aload 7
    //   2034: athrow
    //   2035: goto -3 -> 2032
    //   2038: astore 7
    //   2040: goto -185 -> 1855
    //   2043: astore 7
    //   2045: goto -1037 -> 1008
    //   2048: ldc_w 537
    //   2051: astore 7
    //   2053: goto -1684 -> 369
    //   2056: iconst_1
    //   2057: istore_1
    //   2058: goto -736 -> 1322
    //   2061: iconst_0
    //   2062: istore_1
    //   2063: goto -741 -> 1322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2066	0	this	bi
    //   22	2041	1	i	int
    //   24	1808	2	j	int
    //   29	1969	3	k	int
    //   26	1891	4	m	int
    //   31	866	5	n	int
    //   19	534	6	i1	int
    //   59	964	7	localObject1	Object
    //   1177	1	7	localObject2	Object
    //   1182	195	7	localThrowable	Throwable
    //   1388	645	7	localObject3	Object
    //   2038	1	7	localMalformedURLException	java.net.MalformedURLException
    //   2043	1	7	localOutOfMemoryError	OutOfMemoryError
    //   2051	1	7	str	String
    //   226	1032	8	localObject4	Object
    //   735	525	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   48	61	1177	finally
    //   148	221	1177	finally
    //   221	228	1177	finally
    //   231	238	1177	finally
    //   245	292	1177	finally
    //   299	322	1177	finally
    //   322	329	1177	finally
    //   332	339	1177	finally
    //   342	361	1177	finally
    //   369	461	1177	finally
    //   461	501	1177	finally
    //   588	641	1177	finally
    //   641	715	1177	finally
    //   715	778	1177	finally
    //   781	857	1177	finally
    //   860	887	1177	finally
    //   890	941	1177	finally
    //   941	948	1177	finally
    //   951	1005	1177	finally
    //   1008	1050	1177	finally
    //   1053	1093	1177	finally
    //   1184	1293	1177	finally
    //   1293	1319	1177	finally
    //   1322	1337	1177	finally
    //   1340	1356	1177	finally
    //   1363	1373	1177	finally
    //   1376	1390	1177	finally
    //   1390	1398	1177	finally
    //   1401	1425	1177	finally
    //   1428	1478	1177	finally
    //   1481	1499	1177	finally
    //   1502	1519	1177	finally
    //   1522	1537	1177	finally
    //   1542	1570	1177	finally
    //   1570	1576	1177	finally
    //   1576	1583	1177	finally
    //   1586	1595	1177	finally
    //   1598	1615	1177	finally
    //   1618	1682	1177	finally
    //   1685	1707	1177	finally
    //   1710	1728	1177	finally
    //   1728	1733	1177	finally
    //   1736	1746	1177	finally
    //   1749	1767	1177	finally
    //   1770	1780	1177	finally
    //   1855	1865	1177	finally
    //   48	61	1182	java/lang/Throwable
    //   148	221	1182	java/lang/Throwable
    //   221	228	1182	java/lang/Throwable
    //   231	238	1182	java/lang/Throwable
    //   245	292	1182	java/lang/Throwable
    //   299	322	1182	java/lang/Throwable
    //   322	329	1182	java/lang/Throwable
    //   332	339	1182	java/lang/Throwable
    //   342	361	1182	java/lang/Throwable
    //   369	461	1182	java/lang/Throwable
    //   461	501	1182	java/lang/Throwable
    //   588	641	1182	java/lang/Throwable
    //   641	715	1182	java/lang/Throwable
    //   715	778	1182	java/lang/Throwable
    //   781	857	1182	java/lang/Throwable
    //   860	887	1182	java/lang/Throwable
    //   890	941	1182	java/lang/Throwable
    //   941	948	1182	java/lang/Throwable
    //   951	1005	1182	java/lang/Throwable
    //   1008	1050	1182	java/lang/Throwable
    //   1053	1093	1182	java/lang/Throwable
    //   48	61	2038	java/net/MalformedURLException
    //   148	221	2038	java/net/MalformedURLException
    //   221	228	2038	java/net/MalformedURLException
    //   231	238	2038	java/net/MalformedURLException
    //   245	292	2038	java/net/MalformedURLException
    //   299	322	2038	java/net/MalformedURLException
    //   322	329	2038	java/net/MalformedURLException
    //   332	339	2038	java/net/MalformedURLException
    //   342	361	2038	java/net/MalformedURLException
    //   369	461	2038	java/net/MalformedURLException
    //   461	501	2038	java/net/MalformedURLException
    //   588	641	2038	java/net/MalformedURLException
    //   641	715	2038	java/net/MalformedURLException
    //   715	778	2038	java/net/MalformedURLException
    //   781	857	2038	java/net/MalformedURLException
    //   860	887	2038	java/net/MalformedURLException
    //   890	941	2038	java/net/MalformedURLException
    //   941	948	2038	java/net/MalformedURLException
    //   951	1005	2038	java/net/MalformedURLException
    //   1008	1050	2038	java/net/MalformedURLException
    //   1053	1093	2038	java/net/MalformedURLException
    //   951	1005	2043	java/lang/OutOfMemoryError
  }
  
  public final void a(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap1);
    paramMap1 = new StringBuilder();
    paramMap1.append(this.o);
    localHashMap.put("B59", paramMap1.toString());
    if (this.x) {
      localHashMap.put("B85", "1");
    }
    if (this.c)
    {
      localHashMap.put("B95", "1");
    }
    else
    {
      paramMap1 = new StringBuilder();
      paramMap1.append(this.A);
      localHashMap.put("B96", paramMap1.toString());
    }
    if (!this.y) {
      localHashMap.put("B23", "1");
    }
    paramMap1 = new StringBuilder();
    paramMap1.append(ao.h());
    localHashMap.put("B220", paramMap1.toString());
    paramMap1 = new HashMap();
    paramMap1.putAll(paramMap2);
    paramMap2 = new StringBuilder();
    paramMap2.append(this.z);
    paramMap1.put("B88", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.C.g);
    paramMap1.put("B90", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.C.h);
    paramMap1.put("B91", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.C.i);
    paramMap1.put("B92", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.C.j);
    paramMap1.put("B93", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.C.k);
    paramMap1.put("B94", paramMap2.toString());
    if (!TextUtils.isEmpty(this.i)) {
      paramMap1.put("B47", this.i);
    }
    if (!TextUtils.isEmpty(this.B)) {
      paramMap1.put("B41", this.B);
    }
    if (this.v.a != 0) {}
    for (int i = this.v.a;; i = this.v.c)
    {
      break;
      if (this.v.c == 200)
      {
        i = 0;
        break;
      }
    }
    if ((this.r) && (i != -4))
    {
      dd.a("HLHttpDirect", ac.c(), i, this.v.b, localHashMap, paramMap1, this.j);
      return;
    }
    dd.b("HLHttpDirect", ac.c(), i, this.v.b, localHashMap, paramMap1, this.j);
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean b()
  {
    this.m = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bi
 * JD-Core Version:    0.7.0.1
 */