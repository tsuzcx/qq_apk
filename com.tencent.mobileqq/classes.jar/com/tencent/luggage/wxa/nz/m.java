package com.tencent.luggage.wxa.nz;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class m
  implements X509TrustManager
{
  private LinkedList<X509TrustManager> a = new LinkedList();
  private LinkedList<X509TrustManager> b = new LinkedList();
  private KeyStore c;
  private final boolean d;
  private List<String> e = null;
  private KeyStore f = null;
  private X509Certificate[] g;
  
  public m(boolean paramBoolean)
  {
    this.d = paramBoolean;
    try
    {
      this.c = KeyStore.getInstance(KeyStore.getDefaultType());
      this.c.load(null, null);
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.AppBrandX509TrustManager", localException, "Exception: Local KeyStore init failed", new Object[0]);
    }
  }
  
  private void b()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      int i = 0;
      while ((localObject != null) && (i < localObject.length))
      {
        this.a.add((X509TrustManager)localObject[i]);
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.AppBrandX509TrustManager", localException, "Exception: init SystemTrustManager", new Object[0]);
    }
  }
  
  private void c()
  {
    if (this.c == null) {
      return;
    }
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init(this.c);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      int i = 0;
      while ((localObject != null) && (i < localObject.length))
      {
        this.b.add((X509TrustManager)localObject[i]);
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.AppBrandX509TrustManager", localException, "Exception: init LocalTrustManager", new Object[0]);
    }
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.a.iterator();
    X509Certificate[] arrayOfX509Certificate;
    while (localIterator.hasNext())
    {
      arrayOfX509Certificate = ((X509TrustManager)localIterator.next()).getAcceptedIssuers();
      if (arrayOfX509Certificate != null) {
        localArrayList.addAll(Arrays.asList(arrayOfX509Certificate));
      }
    }
    long l2 = System.currentTimeMillis();
    localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      arrayOfX509Certificate = ((X509TrustManager)localIterator.next()).getAcceptedIssuers();
      if (arrayOfX509Certificate != null) {
        localArrayList.addAll(Arrays.asList(arrayOfX509Certificate));
      }
    }
    long l3 = System.currentTimeMillis();
    this.g = new X509Certificate[localArrayList.size()];
    this.g = ((X509Certificate[])localArrayList.toArray(this.g));
    o.d("MicroMsg.AppBrandX509TrustManager", "initAcceptedIssuers: %d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(System.currentTimeMillis() - l3) });
  }
  
  public void a()
  {
    long l = af.d();
    b();
    c();
    d();
    o.e("MicroMsg.AppBrandX509TrustManager", "init() cost[%dms]", new Object[] { Long.valueOf(af.d() - l) });
  }
  
  public void a(InputStream paramInputStream)
  {
    if (this.c == null)
    {
      o.b("MicroMsg.AppBrandX509TrustManager", "local keystore is null");
      return;
    }
    try
    {
      Object localObject1 = CertificateFactory.getInstance("X.509");
      try
      {
        localObject1 = ((CertificateFactory)localObject1).generateCertificate(paramInputStream);
        paramInputStream.close();
        paramInputStream = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((X509Certificate)localObject1).getSubjectDN());
        localStringBuilder.append("");
        paramInputStream.setCertificateEntry(localStringBuilder.toString(), (Certificate)localObject1);
        return;
      }
      finally
      {
        paramInputStream.close();
      }
      return;
    }
    catch (Exception paramInputStream)
    {
      o.a("MicroMsg.AppBrandX509TrustManager", paramInputStream, "Exception: initLocalSelfSignedCertificate", new Object[0]);
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    throw new CertificateException("Client Certification not supported");
  }
  
  /* Error */
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    // Byte code:
    //   0: ldc 230
    //   2: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   5: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   8: ldc2_w 236
    //   11: lconst_0
    //   12: lconst_1
    //   13: iconst_0
    //   14: invokeinterface 240 8 0
    //   19: new 189	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   26: astore 7
    //   28: aload 7
    //   30: ldc 242
    //   32: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 7
    //   38: aload_0
    //   39: getfield 36	com/tencent/luggage/wxa/nz/m:a	Ljava/util/LinkedList;
    //   42: invokevirtual 243	java/util/LinkedList:size	()I
    //   45: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 58
    //   51: aload 7
    //   53: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 36	com/tencent/luggage/wxa/nz/m:a	Ljava/util/LinkedList;
    //   63: invokevirtual 103	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   66: astore 7
    //   68: aload 7
    //   70: invokeinterface 109 1 0
    //   75: ifeq +124 -> 199
    //   78: aload 7
    //   80: invokeinterface 113 1 0
    //   85: checkcast 6	javax/net/ssl/X509TrustManager
    //   88: astore 8
    //   90: new 189	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   97: astore 9
    //   99: aload 9
    //   101: ldc 250
    //   103: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 9
    //   109: aload 8
    //   111: invokevirtual 251	java/lang/Object:toString	()Ljava/lang/String;
    //   114: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 58
    //   120: aload 9
    //   122: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload 8
    //   130: aload_1
    //   131: aload_2
    //   132: invokeinterface 253 3 0
    //   137: new 189	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   144: astore 7
    //   146: aload 7
    //   148: ldc 255
    //   150: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 7
    //   156: aload 8
    //   158: invokevirtual 251	java/lang/Object:toString	()Ljava/lang/String;
    //   161: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: ldc 58
    //   167: aload 7
    //   169: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: iconst_1
    //   176: istore_3
    //   177: goto +24 -> 201
    //   180: astore 8
    //   182: ldc 58
    //   184: aload 8
    //   186: ldc_w 257
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 65	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: goto -128 -> 68
    //   199: iconst_0
    //   200: istore_3
    //   201: iload_3
    //   202: ifeq +31 -> 233
    //   205: ldc 58
    //   207: ldc_w 259
    //   210: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: ldc 230
    //   215: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   218: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   221: ldc2_w 236
    //   224: lconst_1
    //   225: lconst_1
    //   226: iconst_0
    //   227: invokeinterface 240 8 0
    //   232: return
    //   233: ldc 58
    //   235: ldc_w 261
    //   238: iconst_1
    //   239: anewarray 4	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: aload_0
    //   245: getfield 38	com/tencent/luggage/wxa/nz/m:b	Ljava/util/LinkedList;
    //   248: invokevirtual 243	java/util/LinkedList:size	()I
    //   251: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: aastore
    //   255: invokestatic 151	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: aload_0
    //   259: getfield 38	com/tencent/luggage/wxa/nz/m:b	Ljava/util/LinkedList;
    //   262: invokevirtual 103	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   265: astore 7
    //   267: aload 7
    //   269: invokeinterface 109 1 0
    //   274: ifeq +83 -> 357
    //   277: aload 7
    //   279: invokeinterface 113 1 0
    //   284: checkcast 6	javax/net/ssl/X509TrustManager
    //   287: astore 8
    //   289: aload 8
    //   291: aload_1
    //   292: aload_2
    //   293: invokeinterface 253 3 0
    //   298: new 189	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   305: astore_2
    //   306: aload_2
    //   307: ldc_w 268
    //   310: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_2
    //   315: aload 8
    //   317: invokevirtual 251	java/lang/Object:toString	()Ljava/lang/String;
    //   320: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: ldc 58
    //   326: aload_2
    //   327: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: iconst_1
    //   334: istore_3
    //   335: goto +24 -> 359
    //   338: astore 8
    //   340: ldc 58
    //   342: aload 8
    //   344: ldc_w 270
    //   347: iconst_0
    //   348: anewarray 4	java/lang/Object
    //   351: invokestatic 65	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: goto -87 -> 267
    //   357: iconst_0
    //   358: istore_3
    //   359: iload_3
    //   360: ifeq +33 -> 393
    //   363: ldc 58
    //   365: ldc_w 272
    //   368: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: ldc 230
    //   373: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   376: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   379: ldc2_w 236
    //   382: ldc2_w 273
    //   385: lconst_1
    //   386: iconst_0
    //   387: invokeinterface 240 8 0
    //   392: return
    //   393: aload_0
    //   394: getfield 40	com/tencent/luggage/wxa/nz/m:d	Z
    //   397: ifeq +750 -> 1147
    //   400: ldc 58
    //   402: ldc_w 276
    //   405: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload_0
    //   409: getfield 31	com/tencent/luggage/wxa/nz/m:f	Ljava/security/KeyStore;
    //   412: ifnonnull +22 -> 434
    //   415: aload_0
    //   416: ldc_w 278
    //   419: invokestatic 50	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   422: putfield 31	com/tencent/luggage/wxa/nz/m:f	Ljava/security/KeyStore;
    //   425: aload_0
    //   426: getfield 31	com/tencent/luggage/wxa/nz/m:f	Ljava/security/KeyStore;
    //   429: aconst_null
    //   430: aconst_null
    //   431: invokevirtual 56	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   434: aload_0
    //   435: getfield 29	com/tencent/luggage/wxa/nz/m:e	Ljava/util/List;
    //   438: ifnonnull +73 -> 511
    //   441: aload_0
    //   442: new 92	java/util/ArrayList
    //   445: dup
    //   446: invokespecial 93	java/util/ArrayList:<init>	()V
    //   449: putfield 29	com/tencent/luggage/wxa/nz/m:e	Ljava/util/List;
    //   452: aload_0
    //   453: getfield 31	com/tencent/luggage/wxa/nz/m:f	Ljava/security/KeyStore;
    //   456: invokevirtual 282	java/security/KeyStore:aliases	()Ljava/util/Enumeration;
    //   459: astore_2
    //   460: aload_2
    //   461: invokeinterface 287 1 0
    //   466: ifeq +45 -> 511
    //   469: aload_2
    //   470: invokeinterface 290 1 0
    //   475: checkcast 292	java/lang/String
    //   478: astore 7
    //   480: aload 7
    //   482: ifnull -22 -> 460
    //   485: aload 7
    //   487: ldc_w 294
    //   490: invokevirtual 298	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   493: ifeq -33 -> 460
    //   496: aload_0
    //   497: getfield 29	com/tencent/luggage/wxa/nz/m:e	Ljava/util/List;
    //   500: aload 7
    //   502: invokeinterface 301 2 0
    //   507: pop
    //   508: goto -48 -> 460
    //   511: aload_0
    //   512: getfield 29	com/tencent/luggage/wxa/nz/m:e	Ljava/util/List;
    //   515: invokeinterface 302 1 0
    //   520: ifle +146 -> 666
    //   523: aload_0
    //   524: getfield 29	com/tencent/luggage/wxa/nz/m:e	Ljava/util/List;
    //   527: invokeinterface 303 1 0
    //   532: astore_2
    //   533: iconst_0
    //   534: istore_3
    //   535: iload_3
    //   536: istore 5
    //   538: iload_3
    //   539: istore 4
    //   541: aload_2
    //   542: invokeinterface 109 1 0
    //   547: ifeq +151 -> 698
    //   550: iload_3
    //   551: istore 4
    //   553: aload_2
    //   554: invokeinterface 113 1 0
    //   559: checkcast 292	java/lang/String
    //   562: astore 7
    //   564: iload_3
    //   565: istore 4
    //   567: aload_0
    //   568: getfield 31	com/tencent/luggage/wxa/nz/m:f	Ljava/security/KeyStore;
    //   571: aload 7
    //   573: invokevirtual 307	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   576: checkcast 133	java/security/cert/X509Certificate
    //   579: astore 7
    //   581: iload_3
    //   582: istore 4
    //   584: aload_1
    //   585: arraylength
    //   586: istore 6
    //   588: iconst_0
    //   589: istore 5
    //   591: iload 5
    //   593: iload 6
    //   595: if_icmpge -60 -> 535
    //   598: aload_1
    //   599: iload 5
    //   601: aaload
    //   602: astore 8
    //   604: iload_3
    //   605: istore 4
    //   607: aload 8
    //   609: aload 7
    //   611: invokevirtual 311	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   614: invokevirtual 315	java/security/cert/X509Certificate:verify	(Ljava/security/PublicKey;)V
    //   617: iconst_1
    //   618: istore_3
    //   619: goto -84 -> 535
    //   622: astore 8
    //   624: iload_3
    //   625: istore 4
    //   627: ldc 58
    //   629: aload 8
    //   631: ldc_w 317
    //   634: iconst_0
    //   635: anewarray 4	java/lang/Object
    //   638: invokestatic 65	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: iload 5
    //   643: iconst_1
    //   644: iadd
    //   645: istore 5
    //   647: goto -56 -> 591
    //   650: astore_1
    //   651: goto +92 -> 743
    //   654: astore_1
    //   655: goto +165 -> 820
    //   658: astore_1
    //   659: goto +238 -> 897
    //   662: astore_1
    //   663: goto +311 -> 974
    //   666: ldc 58
    //   668: ldc_w 319
    //   671: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   674: ldc 230
    //   676: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   679: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   682: ldc2_w 236
    //   685: ldc2_w 320
    //   688: lconst_1
    //   689: iconst_0
    //   690: invokeinterface 240 8 0
    //   695: iconst_0
    //   696: istore 5
    //   698: iload 5
    //   700: ifeq +348 -> 1048
    //   703: ldc 58
    //   705: ldc_w 323
    //   708: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: ldc 230
    //   713: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   716: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   719: ldc2_w 236
    //   722: ldc2_w 324
    //   725: lconst_1
    //   726: iconst_0
    //   727: invokeinterface 240 8 0
    //   732: return
    //   733: astore_1
    //   734: iconst_0
    //   735: istore 4
    //   737: goto +344 -> 1081
    //   740: astore_1
    //   741: iconst_0
    //   742: istore_3
    //   743: iload_3
    //   744: istore 4
    //   746: ldc 58
    //   748: aload_1
    //   749: ldc_w 327
    //   752: iconst_0
    //   753: anewarray 4	java/lang/Object
    //   756: invokestatic 65	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: iload_3
    //   760: istore 4
    //   762: ldc 230
    //   764: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   767: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   770: ldc2_w 236
    //   773: ldc2_w 328
    //   776: lconst_1
    //   777: iconst_0
    //   778: invokeinterface 240 8 0
    //   783: iload_3
    //   784: ifeq +264 -> 1048
    //   787: ldc 58
    //   789: ldc_w 323
    //   792: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   795: ldc 230
    //   797: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   800: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   803: ldc2_w 236
    //   806: ldc2_w 324
    //   809: lconst_1
    //   810: iconst_0
    //   811: invokeinterface 240 8 0
    //   816: return
    //   817: astore_1
    //   818: iconst_0
    //   819: istore_3
    //   820: iload_3
    //   821: istore 4
    //   823: ldc 58
    //   825: aload_1
    //   826: ldc_w 331
    //   829: iconst_0
    //   830: anewarray 4	java/lang/Object
    //   833: invokestatic 65	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   836: iload_3
    //   837: istore 4
    //   839: ldc 230
    //   841: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   844: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   847: ldc2_w 236
    //   850: ldc2_w 332
    //   853: lconst_1
    //   854: iconst_0
    //   855: invokeinterface 240 8 0
    //   860: iload_3
    //   861: ifeq +187 -> 1048
    //   864: ldc 58
    //   866: ldc_w 323
    //   869: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   872: ldc 230
    //   874: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   877: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   880: ldc2_w 236
    //   883: ldc2_w 324
    //   886: lconst_1
    //   887: iconst_0
    //   888: invokeinterface 240 8 0
    //   893: return
    //   894: astore_1
    //   895: iconst_0
    //   896: istore_3
    //   897: iload_3
    //   898: istore 4
    //   900: ldc 58
    //   902: aload_1
    //   903: ldc_w 335
    //   906: iconst_0
    //   907: anewarray 4	java/lang/Object
    //   910: invokestatic 65	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: iload_3
    //   914: istore 4
    //   916: ldc 230
    //   918: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   921: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   924: ldc2_w 236
    //   927: ldc2_w 336
    //   930: lconst_1
    //   931: iconst_0
    //   932: invokeinterface 240 8 0
    //   937: iload_3
    //   938: ifeq +110 -> 1048
    //   941: ldc 58
    //   943: ldc_w 323
    //   946: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   949: ldc 230
    //   951: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   954: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   957: ldc2_w 236
    //   960: ldc2_w 324
    //   963: lconst_1
    //   964: iconst_0
    //   965: invokeinterface 240 8 0
    //   970: return
    //   971: astore_1
    //   972: iconst_0
    //   973: istore_3
    //   974: iload_3
    //   975: istore 4
    //   977: ldc 58
    //   979: aload_1
    //   980: ldc_w 339
    //   983: iconst_0
    //   984: anewarray 4	java/lang/Object
    //   987: invokestatic 65	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   990: iload_3
    //   991: istore 4
    //   993: ldc 230
    //   995: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   998: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   1001: ldc2_w 236
    //   1004: ldc2_w 340
    //   1007: lconst_1
    //   1008: iconst_0
    //   1009: invokeinterface 240 8 0
    //   1014: iload_3
    //   1015: ifeq +33 -> 1048
    //   1018: ldc 58
    //   1020: ldc_w 323
    //   1023: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1026: ldc 230
    //   1028: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   1031: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   1034: ldc2_w 236
    //   1037: ldc2_w 324
    //   1040: lconst_1
    //   1041: iconst_0
    //   1042: invokeinterface 240 8 0
    //   1047: return
    //   1048: ldc 58
    //   1050: ldc_w 343
    //   1053: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1056: ldc 230
    //   1058: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   1061: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   1064: ldc2_w 236
    //   1067: ldc2_w 344
    //   1070: lconst_1
    //   1071: iconst_0
    //   1072: invokeinterface 240 8 0
    //   1077: goto +91 -> 1168
    //   1080: astore_1
    //   1081: iload 4
    //   1083: ifeq +33 -> 1116
    //   1086: ldc 58
    //   1088: ldc_w 323
    //   1091: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1094: ldc 230
    //   1096: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   1099: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   1102: ldc2_w 236
    //   1105: ldc2_w 324
    //   1108: lconst_1
    //   1109: iconst_0
    //   1110: invokeinterface 240 8 0
    //   1115: return
    //   1116: ldc 58
    //   1118: ldc_w 343
    //   1121: invokestatic 248	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1124: ldc 230
    //   1126: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   1129: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   1132: ldc2_w 236
    //   1135: ldc2_w 344
    //   1138: lconst_1
    //   1139: iconst_0
    //   1140: invokeinterface 240 8 0
    //   1145: aload_1
    //   1146: athrow
    //   1147: ldc 230
    //   1149: invokestatic 235	com/tencent/luggage/wxa/ba/e:b	(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/ba/d;
    //   1152: checkcast 230	com/tencent/luggage/wxa/ot/c
    //   1155: ldc2_w 236
    //   1158: ldc2_w 346
    //   1161: lconst_1
    //   1162: iconst_0
    //   1163: invokeinterface 240 8 0
    //   1168: new 216	java/security/cert/CertificateException
    //   1171: dup
    //   1172: ldc_w 349
    //   1175: invokespecial 221	java/security/cert/CertificateException:<init>	(Ljava/lang/String;)V
    //   1178: astore_1
    //   1179: goto +5 -> 1184
    //   1182: aload_1
    //   1183: athrow
    //   1184: goto -2 -> 1182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1187	0	this	m
    //   0	1187	1	paramArrayOfX509Certificate	X509Certificate[]
    //   0	1187	2	paramString	String
    //   176	839	3	i	int
    //   539	543	4	j	int
    //   536	163	5	k	int
    //   586	10	6	m	int
    //   26	584	7	localObject	Object
    //   88	69	8	localX509TrustManager1	X509TrustManager
    //   180	5	8	localCertificateException1	CertificateException
    //   287	29	8	localX509TrustManager2	X509TrustManager
    //   338	5	8	localCertificateException2	CertificateException
    //   602	6	8	localX509Certificate	X509Certificate
    //   622	8	8	localException	Exception
    //   97	24	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   90	137	180	java/security/cert/CertificateException
    //   289	298	338	java/security/cert/CertificateException
    //   607	617	622	java/lang/Exception
    //   541	550	650	java/lang/Exception
    //   553	564	650	java/lang/Exception
    //   567	581	650	java/lang/Exception
    //   584	588	650	java/lang/Exception
    //   627	641	650	java/lang/Exception
    //   541	550	654	java/io/IOException
    //   553	564	654	java/io/IOException
    //   567	581	654	java/io/IOException
    //   584	588	654	java/io/IOException
    //   607	617	654	java/io/IOException
    //   627	641	654	java/io/IOException
    //   541	550	658	java/security/NoSuchAlgorithmException
    //   553	564	658	java/security/NoSuchAlgorithmException
    //   567	581	658	java/security/NoSuchAlgorithmException
    //   584	588	658	java/security/NoSuchAlgorithmException
    //   607	617	658	java/security/NoSuchAlgorithmException
    //   627	641	658	java/security/NoSuchAlgorithmException
    //   541	550	662	java/security/KeyStoreException
    //   553	564	662	java/security/KeyStoreException
    //   567	581	662	java/security/KeyStoreException
    //   584	588	662	java/security/KeyStoreException
    //   607	617	662	java/security/KeyStoreException
    //   627	641	662	java/security/KeyStoreException
    //   408	434	733	finally
    //   434	460	733	finally
    //   460	480	733	finally
    //   485	508	733	finally
    //   511	533	733	finally
    //   666	695	733	finally
    //   408	434	740	java/lang/Exception
    //   434	460	740	java/lang/Exception
    //   460	480	740	java/lang/Exception
    //   485	508	740	java/lang/Exception
    //   511	533	740	java/lang/Exception
    //   666	695	740	java/lang/Exception
    //   408	434	817	java/io/IOException
    //   434	460	817	java/io/IOException
    //   460	480	817	java/io/IOException
    //   485	508	817	java/io/IOException
    //   511	533	817	java/io/IOException
    //   666	695	817	java/io/IOException
    //   408	434	894	java/security/NoSuchAlgorithmException
    //   434	460	894	java/security/NoSuchAlgorithmException
    //   460	480	894	java/security/NoSuchAlgorithmException
    //   485	508	894	java/security/NoSuchAlgorithmException
    //   511	533	894	java/security/NoSuchAlgorithmException
    //   666	695	894	java/security/NoSuchAlgorithmException
    //   408	434	971	java/security/KeyStoreException
    //   434	460	971	java/security/KeyStoreException
    //   460	480	971	java/security/KeyStoreException
    //   485	508	971	java/security/KeyStoreException
    //   511	533	971	java/security/KeyStoreException
    //   666	695	971	java/security/KeyStoreException
    //   541	550	1080	finally
    //   553	564	1080	finally
    //   567	581	1080	finally
    //   584	588	1080	finally
    //   607	617	1080	finally
    //   627	641	1080	finally
    //   746	759	1080	finally
    //   762	783	1080	finally
    //   823	836	1080	finally
    //   839	860	1080	finally
    //   900	913	1080	finally
    //   916	937	1080	finally
    //   977	990	1080	finally
    //   993	1014	1080	finally
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.m
 * JD-Core Version:    0.7.0.1
 */