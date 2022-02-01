package c.t.m.g;

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

public final class ap
  extends aj
{
  private int A;
  private long B = 0L;
  private String C;
  private ap.a D = new ap.a((byte)0);
  private boolean E = false;
  private an F;
  long o;
  boolean p = false;
  int q = 0;
  boolean r = false;
  private HttpURLConnection s;
  private DataOutputStream t;
  private DataInputStream u;
  private ao v;
  private String w;
  private boolean x;
  private boolean y;
  private String z = "";
  
  public ap(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString3)
  {
    this.w = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    int i;
    if (x.g() == 2) {
      i = x.a.a("direct_access_time_out", 1000, 60000, 15000);
    } else {
      i = x.a.a("direct_access_time_out", 1000, 60000, 10000);
    }
    int j = i;
    if (paramInt < i) {
      j = paramInt;
    }
    this.f = cn.a(j, 200, 60000, 10000);
    this.g = paramString3;
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
          this.D.f = SystemClock.elapsedRealtime();
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
      ((ao)localObject2).a = -287;
      localObject1 = "read without content-length error";
      ((ao)localObject2).b = ((String)localObject1);
      return;
      j = 0;
      localObject2 = this.v;
      ((ao)localObject2).a = -306;
      localObject1 = "no-content-length:".concat(String.valueOf(j));
      continue;
      label227:
      paramInt = 1;
    }
  }
  
  private void b()
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
    ((StringBuilder)localObject2).append(this.g);
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
  
  private void c()
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
  public final ao a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   4: putfield 269	c/t/m/g/ap:m	J
    //   7: aload_0
    //   8: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   11: putfield 271	c/t/m/g/ap:o	J
    //   14: aload_0
    //   15: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   18: aload_0
    //   19: getfield 271	c/t/m/g/ap:o	J
    //   22: putfield 273	c/t/m/g/ap$a:a	J
    //   25: iconst_0
    //   26: istore_2
    //   27: iconst_0
    //   28: istore 4
    //   30: iconst_0
    //   31: istore_3
    //   32: iconst_0
    //   33: istore_1
    //   34: aload_0
    //   35: new 135	c/t/m/g/ao
    //   38: dup
    //   39: iconst_0
    //   40: ldc 39
    //   42: invokespecial 276	c/t/m/g/ao:<init>	(ILjava/lang/String;)V
    //   45: putfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   48: new 278	java/net/URL
    //   51: dup
    //   52: aload_0
    //   53: getfield 63	c/t/m/g/ap:b	Ljava/lang/String;
    //   56: invokespecial 281	java/net/URL:<init>	(Ljava/lang/String;)V
    //   59: astore 6
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 284	java/net/URL:getProtocol	()Ljava/lang/String;
    //   67: invokevirtual 208	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   70: ldc_w 286
    //   73: invokevirtual 290	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   76: putfield 292	c/t/m/g/ap:x	Z
    //   79: aload_0
    //   80: aload 6
    //   82: invokevirtual 295	java/net/URL:getHost	()Ljava/lang/String;
    //   85: invokestatic 297	c/t/m/g/cn:d	(Ljava/lang/String;)Z
    //   88: putfield 299	c/t/m/g/ap:y	Z
    //   91: aload_0
    //   92: getfield 292	c/t/m/g/ap:x	Z
    //   95: ifeq +104 -> 199
    //   98: aload_0
    //   99: getfield 52	c/t/m/g/ap:p	Z
    //   102: ifeq +29 -> 131
    //   105: invokestatic 303	c/t/m/g/x:k	()Ljava/net/Proxy;
    //   108: ifnull +23 -> 131
    //   111: aload 6
    //   113: invokestatic 303	c/t/m/g/x:k	()Ljava/net/Proxy;
    //   116: invokevirtual 307	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   119: astore 6
    //   121: aload 6
    //   123: checkcast 309	javax/net/ssl/HttpsURLConnection
    //   126: astore 7
    //   128: goto +13 -> 141
    //   131: aload 6
    //   133: invokevirtual 312	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   136: astore 6
    //   138: goto -17 -> 121
    //   141: aload 7
    //   143: astore 6
    //   145: aload_0
    //   146: getfield 299	c/t/m/g/ap:y	Z
    //   149: ifeq +93 -> 242
    //   152: aload_0
    //   153: new 314	c/t/m/g/an
    //   156: dup
    //   157: aload_0
    //   158: getfield 60	c/t/m/g/ap:w	Ljava/lang/String;
    //   161: invokespecial 315	c/t/m/g/an:<init>	(Ljava/lang/String;)V
    //   164: putfield 317	c/t/m/g/ap:F	Lc/t/m/g/an;
    //   167: aload 7
    //   169: aload_0
    //   170: getfield 317	c/t/m/g/ap:F	Lc/t/m/g/an;
    //   173: invokevirtual 321	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   176: aload 7
    //   178: new 323	c/t/m/g/am
    //   181: dup
    //   182: aload_0
    //   183: getfield 60	c/t/m/g/ap:w	Ljava/lang/String;
    //   186: invokespecial 324	c/t/m/g/am:<init>	(Ljava/lang/String;)V
    //   189: invokevirtual 328	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   192: aload 7
    //   194: astore 6
    //   196: goto +46 -> 242
    //   199: aload_0
    //   200: getfield 52	c/t/m/g/ap:p	Z
    //   203: ifeq +29 -> 232
    //   206: invokestatic 303	c/t/m/g/x:k	()Ljava/net/Proxy;
    //   209: ifnull +23 -> 232
    //   212: aload 6
    //   214: invokestatic 303	c/t/m/g/x:k	()Ljava/net/Proxy;
    //   217: invokevirtual 307	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   220: astore 6
    //   222: aload 6
    //   224: checkcast 113	java/net/HttpURLConnection
    //   227: astore 6
    //   229: goto +13 -> 242
    //   232: aload 6
    //   234: invokevirtual 312	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   237: astore 6
    //   239: goto -17 -> 222
    //   242: aload_0
    //   243: aload 6
    //   245: putfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   248: aload_0
    //   249: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   252: astore 7
    //   254: aload_0
    //   255: getfield 66	c/t/m/g/ap:c	Z
    //   258: ifeq +1391 -> 1649
    //   261: ldc_w 330
    //   264: astore 6
    //   266: goto +3 -> 269
    //   269: aload 7
    //   271: aload 6
    //   273: invokevirtual 333	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   276: aload_0
    //   277: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   280: aload_0
    //   281: getfield 97	c/t/m/g/ap:f	I
    //   284: invokevirtual 336	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   287: aload_0
    //   288: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   291: aload_0
    //   292: getfield 97	c/t/m/g/ap:f	I
    //   295: invokevirtual 339	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   298: aload_0
    //   299: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   302: iconst_0
    //   303: invokevirtual 343	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   306: aload_0
    //   307: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   310: iconst_1
    //   311: invokevirtual 346	java/net/HttpURLConnection:setDoInput	(Z)V
    //   314: aload_0
    //   315: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   318: iconst_0
    //   319: invokevirtual 349	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   322: aload_0
    //   323: invokespecial 351	c/t/m/g/ap:b	()V
    //   326: aload_0
    //   327: getfield 66	c/t/m/g/ap:c	Z
    //   330: ifne +31 -> 361
    //   333: aload_0
    //   334: getfield 74	c/t/m/g/ap:e	[B
    //   337: invokestatic 354	c/t/m/g/cn:a	([B)Z
    //   340: ifne +21 -> 361
    //   343: aload_0
    //   344: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   347: iconst_1
    //   348: invokevirtual 357	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   351: aload_0
    //   352: aload_0
    //   353: getfield 74	c/t/m/g/ap:e	[B
    //   356: arraylength
    //   357: i2l
    //   358: putfield 43	c/t/m/g/ap:B	J
    //   361: aload_0
    //   362: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   365: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   368: putfield 359	c/t/m/g/ap$a:b	J
    //   371: aload_0
    //   372: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   375: invokevirtual 362	java/net/HttpURLConnection:connect	()V
    //   378: aload_0
    //   379: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   382: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   385: putfield 364	c/t/m/g/ap$a:c	J
    //   388: aload_0
    //   389: getfield 66	c/t/m/g/ap:c	Z
    //   392: ifne +49 -> 441
    //   395: aload_0
    //   396: getfield 74	c/t/m/g/ap:e	[B
    //   399: invokestatic 354	c/t/m/g/cn:a	([B)Z
    //   402: ifne +39 -> 441
    //   405: aload_0
    //   406: new 257	java/io/DataOutputStream
    //   409: dup
    //   410: aload_0
    //   411: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   414: invokevirtual 368	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   417: invokespecial 371	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   420: putfield 255	c/t/m/g/ap:t	Ljava/io/DataOutputStream;
    //   423: aload_0
    //   424: getfield 255	c/t/m/g/ap:t	Ljava/io/DataOutputStream;
    //   427: aload_0
    //   428: getfield 74	c/t/m/g/ap:e	[B
    //   431: invokevirtual 374	java/io/DataOutputStream:write	([B)V
    //   434: aload_0
    //   435: getfield 255	c/t/m/g/ap:t	Ljava/io/DataOutputStream;
    //   438: invokevirtual 377	java/io/DataOutputStream:flush	()V
    //   441: aload_0
    //   442: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   445: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   448: putfield 379	c/t/m/g/ap$a:d	J
    //   451: aload_0
    //   452: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   455: invokevirtual 382	java/net/HttpURLConnection:getResponseCode	()I
    //   458: istore 5
    //   460: aload_0
    //   461: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   464: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   467: putfield 384	c/t/m/g/ap$a:e	J
    //   470: aload_0
    //   471: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   474: iload 5
    //   476: putfield 386	c/t/m/g/ao:c	I
    //   479: aload_0
    //   480: aload_0
    //   481: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   484: invokevirtual 389	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   487: putfield 41	c/t/m/g/ap:z	Ljava/lang/String;
    //   490: new 391	java/util/HashMap
    //   493: dup
    //   494: invokespecial 392	java/util/HashMap:<init>	()V
    //   497: astore 6
    //   499: aload_0
    //   500: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   503: invokevirtual 396	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   506: invokeinterface 399 1 0
    //   511: invokeinterface 186 1 0
    //   516: astore 7
    //   518: aload 7
    //   520: invokeinterface 192 1 0
    //   525: ifeq +59 -> 584
    //   528: aload 7
    //   530: invokeinterface 196 1 0
    //   535: checkcast 401	java/util/Map$Entry
    //   538: astore 8
    //   540: aload 8
    //   542: invokeinterface 404 1 0
    //   547: ifnull -29 -> 518
    //   550: aload 6
    //   552: aload 8
    //   554: invokeinterface 404 1 0
    //   559: aload 8
    //   561: invokeinterface 407 1 0
    //   566: checkcast 409	java/util/List
    //   569: iconst_0
    //   570: invokeinterface 412 2 0
    //   575: invokeinterface 416 3 0
    //   580: pop
    //   581: goto -63 -> 518
    //   584: aload_0
    //   585: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   588: aload 6
    //   590: invokevirtual 419	c/t/m/g/ao:a	(Ljava/util/Map;)V
    //   593: aload_0
    //   594: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   597: getfield 386	c/t/m/g/ao:c	I
    //   600: sipush 200
    //   603: if_icmplt +253 -> 856
    //   606: aload_0
    //   607: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   610: getfield 386	c/t/m/g/ao:c	I
    //   613: sipush 300
    //   616: if_icmpge +240 -> 856
    //   619: aload_0
    //   620: aload_0
    //   621: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   624: invokevirtual 422	java/net/HttpURLConnection:getContentLength	()I
    //   627: putfield 424	c/t/m/g/ap:A	I
    //   630: ldc_w 426
    //   633: ldc_w 427
    //   636: ldc_w 428
    //   639: ldc_w 429
    //   642: invokestatic 89	c/t/m/g/x$a:a	(Ljava/lang/String;III)I
    //   645: istore 5
    //   647: aload_0
    //   648: getfield 424	c/t/m/g/ap:A	I
    //   651: ifge +12 -> 663
    //   654: aload_0
    //   655: iload 5
    //   657: invokespecial 431	c/t/m/g/ap:a	(I)V
    //   660: goto +236 -> 896
    //   663: aload_0
    //   664: getfield 424	c/t/m/g/ap:A	I
    //   667: ifne +26 -> 693
    //   670: aload_0
    //   671: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   674: iconst_0
    //   675: newarray byte
    //   677: putfield 146	c/t/m/g/ao:d	[B
    //   680: aload_0
    //   681: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   684: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   687: putfield 154	c/t/m/g/ap$a:f	J
    //   690: goto +206 -> 896
    //   693: aload_0
    //   694: getfield 424	c/t/m/g/ap:A	I
    //   697: iload 5
    //   699: if_icmple +55 -> 754
    //   702: aload_0
    //   703: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   706: sipush -303
    //   709: putfield 137	c/t/m/g/ao:a	I
    //   712: aload_0
    //   713: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   716: astore 6
    //   718: new 221	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   725: astore 7
    //   727: aload 7
    //   729: aload_0
    //   730: getfield 424	c/t/m/g/ap:A	I
    //   733: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 7
    //   739: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: astore 7
    //   744: aload 6
    //   746: aload 7
    //   748: putfield 140	c/t/m/g/ao:b	Ljava/lang/String;
    //   751: goto +145 -> 896
    //   754: aload_0
    //   755: getfield 424	c/t/m/g/ap:A	I
    //   758: newarray byte
    //   760: astore 6
    //   762: aload_0
    //   763: new 262	java/io/DataInputStream
    //   766: dup
    //   767: aload_0
    //   768: getfield 111	c/t/m/g/ap:s	Ljava/net/HttpURLConnection;
    //   771: invokevirtual 117	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   774: invokespecial 432	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   777: putfield 260	c/t/m/g/ap:u	Ljava/io/DataInputStream;
    //   780: aload_0
    //   781: getfield 260	c/t/m/g/ap:u	Ljava/io/DataInputStream;
    //   784: aload 6
    //   786: invokevirtual 435	java/io/DataInputStream:readFully	([B)V
    //   789: aload_0
    //   790: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   793: aload 6
    //   795: putfield 146	c/t/m/g/ao:d	[B
    //   798: aload_0
    //   799: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   802: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   805: putfield 154	c/t/m/g/ap$a:f	J
    //   808: goto +88 -> 896
    //   811: aload_0
    //   812: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   815: sipush -306
    //   818: putfield 137	c/t/m/g/ao:a	I
    //   821: aload_0
    //   822: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   825: astore 6
    //   827: new 221	java/lang/StringBuilder
    //   830: dup
    //   831: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   834: astore 7
    //   836: aload 7
    //   838: aload_0
    //   839: getfield 424	c/t/m/g/ap:A	I
    //   842: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload 7
    //   848: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: astore 7
    //   853: goto -109 -> 744
    //   856: aload_0
    //   857: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   860: getfield 386	c/t/m/g/ao:c	I
    //   863: sipush 300
    //   866: if_icmplt +30 -> 896
    //   869: aload_0
    //   870: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   873: getfield 386	c/t/m/g/ao:c	I
    //   876: sipush 400
    //   879: if_icmpge +17 -> 896
    //   882: aload_0
    //   883: aload_0
    //   884: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   887: ldc_w 437
    //   890: invokevirtual 439	c/t/m/g/ao:a	(Ljava/lang/String;)Ljava/lang/String;
    //   893: putfield 442	c/t/m/g/ap:h	Ljava/lang/String;
    //   896: aload_0
    //   897: invokespecial 444	c/t/m/g/ap:c	()V
    //   900: aload_0
    //   901: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   904: aload_0
    //   905: getfield 271	c/t/m/g/ap:o	J
    //   908: lsub
    //   909: putfield 271	c/t/m/g/ap:o	J
    //   912: aload_0
    //   913: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   916: invokevirtual 446	c/t/m/g/ap$a:a	()V
    //   919: aload_0
    //   920: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   923: getfield 137	c/t/m/g/ao:a	I
    //   926: ifeq +616 -> 1542
    //   929: invokestatic 448	c/t/m/g/x:h	()Z
    //   932: ifeq +610 -> 1542
    //   935: aload_0
    //   936: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   939: getfield 137	c/t/m/g/ao:a	I
    //   942: bipush 236
    //   944: if_icmpeq +598 -> 1542
    //   947: ldc_w 450
    //   950: iconst_0
    //   951: iconst_1
    //   952: iconst_0
    //   953: invokestatic 89	c/t/m/g/x$a:a	(Ljava/lang/String;III)I
    //   956: iconst_1
    //   957: if_icmpne +5 -> 962
    //   960: iconst_1
    //   961: istore_1
    //   962: iload_1
    //   963: ifeq +579 -> 1542
    //   966: aload_0
    //   967: aload_0
    //   968: getfield 60	c/t/m/g/ap:w	Ljava/lang/String;
    //   971: invokestatic 452	c/t/m/g/cn:c	(Ljava/lang/String;)Ljava/lang/String;
    //   974: putfield 454	c/t/m/g/ap:C	Ljava/lang/String;
    //   977: goto +565 -> 1542
    //   980: astore 6
    //   982: goto +565 -> 1547
    //   985: astore 6
    //   987: aload 6
    //   989: invokevirtual 457	java/lang/Throwable:printStackTrace	()V
    //   992: aload_0
    //   993: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   996: sipush -287
    //   999: putfield 137	c/t/m/g/ao:a	I
    //   1002: aload_0
    //   1003: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1006: astore 7
    //   1008: new 221	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1015: astore 8
    //   1017: aload 8
    //   1019: aload 6
    //   1021: invokevirtual 463	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1024: invokevirtual 468	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   1027: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: aload 8
    //   1033: ldc_w 470
    //   1036: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload 8
    //   1042: aload 6
    //   1044: invokevirtual 473	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   1047: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: pop
    //   1051: aload 8
    //   1053: ldc_w 475
    //   1056: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload 7
    //   1062: aload 8
    //   1064: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: putfield 140	c/t/m/g/ao:b	Ljava/lang/String;
    //   1070: aload_0
    //   1071: getfield 317	c/t/m/g/ap:F	Lc/t/m/g/an;
    //   1074: ifnull +13 -> 1087
    //   1077: aload_0
    //   1078: getfield 317	c/t/m/g/ap:F	Lc/t/m/g/an;
    //   1081: getfield 477	c/t/m/g/an:a	Z
    //   1084: ifne +573 -> 1657
    //   1087: aload_0
    //   1088: getfield 292	c/t/m/g/ap:x	Z
    //   1091: ifeq +22 -> 1113
    //   1094: aload_0
    //   1095: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1098: getfield 140	c/t/m/g/ao:b	Ljava/lang/String;
    //   1101: invokevirtual 208	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1104: ldc_w 479
    //   1107: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1110: ifne +547 -> 1657
    //   1113: aload_0
    //   1114: getfield 292	c/t/m/g/ap:x	Z
    //   1117: ifeq +545 -> 1662
    //   1120: aload_0
    //   1121: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1124: getfield 140	c/t/m/g/ao:b	Ljava/lang/String;
    //   1127: invokevirtual 208	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1130: ldc_w 481
    //   1133: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1136: ifeq +526 -> 1662
    //   1139: goto +518 -> 1657
    //   1142: invokestatic 448	c/t/m/g/x:h	()Z
    //   1145: ifne +15 -> 1160
    //   1148: aload_0
    //   1149: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1152: bipush 252
    //   1154: putfield 137	c/t/m/g/ao:a	I
    //   1157: goto +224 -> 1381
    //   1160: iload_1
    //   1161: ifeq +16 -> 1177
    //   1164: aload_0
    //   1165: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1168: sipush -289
    //   1171: putfield 137	c/t/m/g/ao:a	I
    //   1174: goto +207 -> 1381
    //   1177: aload_0
    //   1178: iconst_1
    //   1179: putfield 484	c/t/m/g/ap:i	Z
    //   1182: aload 6
    //   1184: invokevirtual 487	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1187: ifnull +43 -> 1230
    //   1190: aload 6
    //   1192: invokevirtual 487	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1195: invokevirtual 208	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1198: ldc_w 489
    //   1201: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1204: ifeq +26 -> 1230
    //   1207: aload_0
    //   1208: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1211: sipush -281
    //   1214: putfield 137	c/t/m/g/ao:a	I
    //   1217: aload_0
    //   1218: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1221: ldc_w 491
    //   1224: putfield 140	c/t/m/g/ao:b	Ljava/lang/String;
    //   1227: goto +154 -> 1381
    //   1230: aload 6
    //   1232: instanceof 493
    //   1235: ifeq +16 -> 1251
    //   1238: aload_0
    //   1239: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1242: sipush -284
    //   1245: putfield 137	c/t/m/g/ao:a	I
    //   1248: goto +133 -> 1381
    //   1251: aload 6
    //   1253: instanceof 495
    //   1256: ifeq +15 -> 1271
    //   1259: aload_0
    //   1260: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1263: bipush 214
    //   1265: putfield 137	c/t/m/g/ao:a	I
    //   1268: goto +113 -> 1381
    //   1271: aload 6
    //   1273: instanceof 497
    //   1276: ifeq +67 -> 1343
    //   1279: aload 6
    //   1281: invokevirtual 473	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
    //   1284: astore 6
    //   1286: aload 6
    //   1288: ifnull +43 -> 1331
    //   1291: aload 6
    //   1293: invokevirtual 208	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1296: ldc_w 498
    //   1299: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1302: ifne +17 -> 1319
    //   1305: aload 6
    //   1307: invokevirtual 208	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1310: ldc_w 500
    //   1313: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1316: ifeq +15 -> 1331
    //   1319: aload_0
    //   1320: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1323: bipush 246
    //   1325: putfield 137	c/t/m/g/ao:a	I
    //   1328: goto +53 -> 1381
    //   1331: aload_0
    //   1332: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1335: bipush 243
    //   1337: putfield 137	c/t/m/g/ao:a	I
    //   1340: goto +41 -> 1381
    //   1343: aload 6
    //   1345: instanceof 502
    //   1348: ifeq +15 -> 1363
    //   1351: aload_0
    //   1352: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1355: bipush 215
    //   1357: putfield 137	c/t/m/g/ao:a	I
    //   1360: goto +21 -> 1381
    //   1363: aload 6
    //   1365: instanceof 504
    //   1368: ifeq +13 -> 1381
    //   1371: aload_0
    //   1372: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1375: sipush -286
    //   1378: putfield 137	c/t/m/g/ao:a	I
    //   1381: aload_0
    //   1382: invokespecial 444	c/t/m/g/ap:c	()V
    //   1385: aload_0
    //   1386: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   1389: aload_0
    //   1390: getfield 271	c/t/m/g/ap:o	J
    //   1393: lsub
    //   1394: putfield 271	c/t/m/g/ap:o	J
    //   1397: aload_0
    //   1398: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   1401: invokevirtual 446	c/t/m/g/ap$a:a	()V
    //   1404: aload_0
    //   1405: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1408: getfield 137	c/t/m/g/ao:a	I
    //   1411: ifeq +131 -> 1542
    //   1414: invokestatic 448	c/t/m/g/x:h	()Z
    //   1417: ifeq +125 -> 1542
    //   1420: aload_0
    //   1421: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1424: getfield 137	c/t/m/g/ao:a	I
    //   1427: bipush 236
    //   1429: if_icmpeq +113 -> 1542
    //   1432: iload_2
    //   1433: istore_1
    //   1434: ldc_w 450
    //   1437: iconst_0
    //   1438: iconst_1
    //   1439: iconst_0
    //   1440: invokestatic 89	c/t/m/g/x$a:a	(Ljava/lang/String;III)I
    //   1443: iconst_1
    //   1444: if_icmpne +5 -> 1449
    //   1447: iconst_1
    //   1448: istore_1
    //   1449: iload_1
    //   1450: ifeq +92 -> 1542
    //   1453: goto -487 -> 966
    //   1456: aload_0
    //   1457: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1460: sipush -300
    //   1463: putfield 137	c/t/m/g/ao:a	I
    //   1466: aload_0
    //   1467: invokespecial 444	c/t/m/g/ap:c	()V
    //   1470: aload_0
    //   1471: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   1474: aload_0
    //   1475: getfield 271	c/t/m/g/ap:o	J
    //   1478: lsub
    //   1479: putfield 271	c/t/m/g/ap:o	J
    //   1482: aload_0
    //   1483: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   1486: invokevirtual 446	c/t/m/g/ap$a:a	()V
    //   1489: aload_0
    //   1490: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1493: getfield 137	c/t/m/g/ao:a	I
    //   1496: ifeq +46 -> 1542
    //   1499: invokestatic 448	c/t/m/g/x:h	()Z
    //   1502: ifeq +40 -> 1542
    //   1505: aload_0
    //   1506: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1509: getfield 137	c/t/m/g/ao:a	I
    //   1512: bipush 236
    //   1514: if_icmpeq +28 -> 1542
    //   1517: iload 4
    //   1519: istore_1
    //   1520: ldc_w 450
    //   1523: iconst_0
    //   1524: iconst_1
    //   1525: iconst_0
    //   1526: invokestatic 89	c/t/m/g/x$a:a	(Ljava/lang/String;III)I
    //   1529: iconst_1
    //   1530: if_icmpne +5 -> 1535
    //   1533: iconst_1
    //   1534: istore_1
    //   1535: iload_1
    //   1536: ifeq +6 -> 1542
    //   1539: goto -573 -> 966
    //   1542: aload_0
    //   1543: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1546: areturn
    //   1547: aload_0
    //   1548: invokespecial 444	c/t/m/g/ap:c	()V
    //   1551: aload_0
    //   1552: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   1555: aload_0
    //   1556: getfield 271	c/t/m/g/ap:o	J
    //   1559: lsub
    //   1560: putfield 271	c/t/m/g/ap:o	J
    //   1563: aload_0
    //   1564: getfield 50	c/t/m/g/ap:D	Lc/t/m/g/ap$a;
    //   1567: invokevirtual 446	c/t/m/g/ap$a:a	()V
    //   1570: aload_0
    //   1571: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1574: getfield 137	c/t/m/g/ao:a	I
    //   1577: ifeq +53 -> 1630
    //   1580: invokestatic 448	c/t/m/g/x:h	()Z
    //   1583: ifeq +47 -> 1630
    //   1586: aload_0
    //   1587: getfield 133	c/t/m/g/ap:v	Lc/t/m/g/ao;
    //   1590: getfield 137	c/t/m/g/ao:a	I
    //   1593: bipush 236
    //   1595: if_icmpeq +35 -> 1630
    //   1598: iload_3
    //   1599: istore_1
    //   1600: ldc_w 450
    //   1603: iconst_0
    //   1604: iconst_1
    //   1605: iconst_0
    //   1606: invokestatic 89	c/t/m/g/x$a:a	(Ljava/lang/String;III)I
    //   1609: iconst_1
    //   1610: if_icmpne +5 -> 1615
    //   1613: iconst_1
    //   1614: istore_1
    //   1615: iload_1
    //   1616: ifeq +14 -> 1630
    //   1619: aload_0
    //   1620: aload_0
    //   1621: getfield 60	c/t/m/g/ap:w	Ljava/lang/String;
    //   1624: invokestatic 452	c/t/m/g/cn:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1627: putfield 454	c/t/m/g/ap:C	Ljava/lang/String;
    //   1630: goto +6 -> 1636
    //   1633: aload 6
    //   1635: athrow
    //   1636: goto -3 -> 1633
    //   1639: astore 6
    //   1641: goto -185 -> 1456
    //   1644: astore 6
    //   1646: goto -835 -> 811
    //   1649: ldc_w 506
    //   1652: astore 6
    //   1654: goto -1385 -> 269
    //   1657: iconst_1
    //   1658: istore_1
    //   1659: goto -517 -> 1142
    //   1662: iconst_0
    //   1663: istore_1
    //   1664: goto -522 -> 1142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1667	0	this	ap
    //   33	1631	1	i	int
    //   26	1407	2	j	int
    //   31	1568	3	k	int
    //   28	1490	4	m	int
    //   458	242	5	n	int
    //   59	767	6	localObject1	Object
    //   980	1	6	localObject2	Object
    //   985	295	6	localThrowable	Throwable
    //   1284	350	6	str1	String
    //   1639	1	6	localMalformedURLException	java.net.MalformedURLException
    //   1644	1	6	localOutOfMemoryError	OutOfMemoryError
    //   1652	1	6	str2	String
    //   126	935	7	localObject3	Object
    //   538	525	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   48	121	980	finally
    //   121	128	980	finally
    //   131	138	980	finally
    //   145	192	980	finally
    //   199	222	980	finally
    //   222	229	980	finally
    //   232	239	980	finally
    //   242	261	980	finally
    //   269	361	980	finally
    //   361	441	980	finally
    //   441	518	980	finally
    //   518	581	980	finally
    //   584	660	980	finally
    //   663	690	980	finally
    //   693	744	980	finally
    //   744	751	980	finally
    //   754	808	980	finally
    //   811	853	980	finally
    //   856	896	980	finally
    //   987	1087	980	finally
    //   1087	1113	980	finally
    //   1113	1139	980	finally
    //   1142	1157	980	finally
    //   1164	1174	980	finally
    //   1177	1227	980	finally
    //   1230	1248	980	finally
    //   1251	1268	980	finally
    //   1271	1286	980	finally
    //   1291	1319	980	finally
    //   1319	1328	980	finally
    //   1331	1340	980	finally
    //   1343	1360	980	finally
    //   1363	1381	980	finally
    //   1456	1466	980	finally
    //   48	121	985	java/lang/Throwable
    //   121	128	985	java/lang/Throwable
    //   131	138	985	java/lang/Throwable
    //   145	192	985	java/lang/Throwable
    //   199	222	985	java/lang/Throwable
    //   222	229	985	java/lang/Throwable
    //   232	239	985	java/lang/Throwable
    //   242	261	985	java/lang/Throwable
    //   269	361	985	java/lang/Throwable
    //   361	441	985	java/lang/Throwable
    //   441	518	985	java/lang/Throwable
    //   518	581	985	java/lang/Throwable
    //   584	660	985	java/lang/Throwable
    //   663	690	985	java/lang/Throwable
    //   693	744	985	java/lang/Throwable
    //   744	751	985	java/lang/Throwable
    //   754	808	985	java/lang/Throwable
    //   811	853	985	java/lang/Throwable
    //   856	896	985	java/lang/Throwable
    //   48	121	1639	java/net/MalformedURLException
    //   121	128	1639	java/net/MalformedURLException
    //   131	138	1639	java/net/MalformedURLException
    //   145	192	1639	java/net/MalformedURLException
    //   199	222	1639	java/net/MalformedURLException
    //   222	229	1639	java/net/MalformedURLException
    //   232	239	1639	java/net/MalformedURLException
    //   242	261	1639	java/net/MalformedURLException
    //   269	361	1639	java/net/MalformedURLException
    //   361	441	1639	java/net/MalformedURLException
    //   441	518	1639	java/net/MalformedURLException
    //   518	581	1639	java/net/MalformedURLException
    //   584	660	1639	java/net/MalformedURLException
    //   663	690	1639	java/net/MalformedURLException
    //   693	744	1639	java/net/MalformedURLException
    //   744	751	1639	java/net/MalformedURLException
    //   754	808	1639	java/net/MalformedURLException
    //   811	853	1639	java/net/MalformedURLException
    //   856	896	1639	java/net/MalformedURLException
    //   754	808	1644	java/lang/OutOfMemoryError
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
      paramMap1.append(this.B);
      localHashMap.put("B96", paramMap1.toString());
    }
    if (!this.y) {
      localHashMap.put("B23", "1");
    }
    paramMap1 = new HashMap();
    paramMap1.putAll(paramMap2);
    if (this.m != 0L)
    {
      paramMap2 = new StringBuilder();
      paramMap2.append(this.m);
      paramMap1.put("B84", paramMap2.toString());
    }
    paramMap1.put("B87", this.z);
    paramMap2 = new StringBuilder();
    paramMap2.append(this.A);
    paramMap1.put("B88", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.D.g);
    paramMap1.put("B90", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.D.h);
    paramMap1.put("B91", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.D.i);
    paramMap1.put("B92", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.D.j);
    paramMap1.put("B93", paramMap2.toString());
    paramMap2 = new StringBuilder();
    paramMap2.append(this.D.k);
    paramMap1.put("B94", paramMap2.toString());
    if (!TextUtils.isEmpty(this.h)) {
      paramMap1.put("B47", this.h);
    }
    if (!TextUtils.isEmpty(this.C)) {
      paramMap1.put("B41", this.C);
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
      cl.a("HLHttpDirect", m.c(), i, this.v.b, localHashMap, paramMap1, this.i);
      return;
    }
    cl.b("HLHttpDirect", m.c(), i, this.v.b, localHashMap, paramMap1, this.i);
  }
  
  public final void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ap
 * JD-Core Version:    0.7.0.1
 */