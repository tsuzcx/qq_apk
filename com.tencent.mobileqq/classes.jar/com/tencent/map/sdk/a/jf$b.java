package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.AsyncTask;

final class jf$b
  extends AsyncTask<Context, Void, Void>
{
  private jf$b(jf paramjf) {}
  
  /* Error */
  private Void a(Context... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   3: istore_3
    //   4: new 28	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   11: astore 7
    //   13: aload 7
    //   15: ldc 31
    //   17: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 7
    //   23: ldc 37
    //   25: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_1
    //   30: ifnull +23 -> 53
    //   33: aload_1
    //   34: arraylength
    //   35: ifle +18 -> 53
    //   38: aload 7
    //   40: aload_1
    //   41: iconst_0
    //   42: aaload
    //   43: invokevirtual 43	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   46: invokestatic 48	com/tencent/map/sdk/a/jf:a	(Landroid/content/Context;)Ljava/lang/String;
    //   49: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: iconst_1
    //   54: istore_2
    //   55: iconst_1
    //   56: istore 5
    //   58: iconst_1
    //   59: istore 6
    //   61: iconst_1
    //   62: istore 4
    //   64: new 50	java/net/URL
    //   67: dup
    //   68: aload 7
    //   70: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 57	java/net/URL:<init>	(Ljava/lang/String;)V
    //   76: invokevirtual 61	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   79: checkcast 63	javax/net/ssl/HttpsURLConnection
    //   82: astore_1
    //   83: aload_1
    //   84: sipush 3000
    //   87: invokevirtual 67	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   90: aload_1
    //   91: invokevirtual 70	javax/net/ssl/HttpsURLConnection:connect	()V
    //   94: aload_1
    //   95: invokevirtual 74	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   98: astore 10
    //   100: aload_1
    //   101: astore 7
    //   103: aload 10
    //   105: astore 8
    //   107: aload 10
    //   109: invokestatic 79	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;)[B
    //   112: astore 9
    //   114: aload 9
    //   116: ifnull +172 -> 288
    //   119: aload_1
    //   120: astore 7
    //   122: aload 10
    //   124: astore 8
    //   126: aload 9
    //   128: arraylength
    //   129: ifne +6 -> 135
    //   132: goto +156 -> 288
    //   135: aload_1
    //   136: astore 7
    //   138: aload 10
    //   140: astore 8
    //   142: new 81	org/json/JSONObject
    //   145: dup
    //   146: new 83	java/lang/String
    //   149: dup
    //   150: aload 9
    //   152: invokespecial 86	java/lang/String:<init>	([B)V
    //   155: invokespecial 87	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   158: astore 9
    //   160: iload_3
    //   161: istore_2
    //   162: aload_1
    //   163: astore 7
    //   165: aload 10
    //   167: astore 8
    //   169: aload 9
    //   171: ldc 89
    //   173: iconst_m1
    //   174: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   177: ifne +42 -> 219
    //   180: aload_1
    //   181: astore 7
    //   183: aload 10
    //   185: astore 8
    //   187: aload 9
    //   189: ldc 95
    //   191: invokevirtual 99	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   194: astore 9
    //   196: iload_3
    //   197: istore_2
    //   198: aload 9
    //   200: ifnull +19 -> 219
    //   203: aload_1
    //   204: astore 7
    //   206: aload 10
    //   208: astore 8
    //   210: aload 9
    //   212: ldc 101
    //   214: iload_3
    //   215: invokevirtual 93	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   218: istore_2
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 104	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   227: aload 10
    //   229: ifnull +8 -> 237
    //   232: aload 10
    //   234: invokestatic 107	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   237: iload_2
    //   238: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   241: if_icmpeq +9 -> 250
    //   244: iload 4
    //   246: istore_3
    //   247: goto +5 -> 252
    //   250: iconst_0
    //   251: istore_3
    //   252: iload_3
    //   253: ifeq +256 -> 509
    //   256: aload_0
    //   257: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   260: getfield 110	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   263: ifnull +246 -> 509
    //   266: aload_0
    //   267: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   270: getfield 110	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   273: iload_2
    //   274: invokestatic 113	com/tencent/map/sdk/a/jc:a	(Landroid/content/Context;I)V
    //   277: aload_0
    //   278: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   281: getfield 117	com/tencent/map/sdk/a/jf:b	Ljava/lang/ref/WeakReference;
    //   284: astore_1
    //   285: goto +212 -> 497
    //   288: aload_1
    //   289: ifnull +7 -> 296
    //   292: aload_1
    //   293: invokevirtual 104	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   296: aload 10
    //   298: ifnull +8 -> 306
    //   301: aload 10
    //   303: invokestatic 107	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   306: iload_3
    //   307: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   310: if_icmpeq +6 -> 316
    //   313: goto +5 -> 318
    //   316: iconst_0
    //   317: istore_2
    //   318: iload_2
    //   319: ifeq +42 -> 361
    //   322: aload_0
    //   323: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   326: getfield 110	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   329: ifnull +32 -> 361
    //   332: aload_0
    //   333: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   336: getfield 110	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   339: iload_3
    //   340: invokestatic 113	com/tencent/map/sdk/a/jc:a	(Landroid/content/Context;I)V
    //   343: aload_0
    //   344: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   347: getfield 117	com/tencent/map/sdk/a/jf:b	Ljava/lang/ref/WeakReference;
    //   350: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   353: checkcast 125	com/tencent/map/sdk/a/jf$a
    //   356: invokeinterface 127 1 0
    //   361: aconst_null
    //   362: areturn
    //   363: astore 7
    //   365: aload_1
    //   366: astore 9
    //   368: aload 10
    //   370: astore_1
    //   371: aload 7
    //   373: astore 10
    //   375: goto +44 -> 419
    //   378: astore 8
    //   380: aconst_null
    //   381: astore 9
    //   383: goto +139 -> 522
    //   386: astore 10
    //   388: aconst_null
    //   389: astore 7
    //   391: aload_1
    //   392: astore 9
    //   394: aload 7
    //   396: astore_1
    //   397: goto +22 -> 419
    //   400: astore 8
    //   402: aconst_null
    //   403: astore 9
    //   405: aload 9
    //   407: astore_1
    //   408: goto +114 -> 522
    //   411: astore 10
    //   413: aconst_null
    //   414: astore 9
    //   416: aload 9
    //   418: astore_1
    //   419: aload 9
    //   421: astore 7
    //   423: aload_1
    //   424: astore 8
    //   426: aload 10
    //   428: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   431: aload 9
    //   433: ifnull +8 -> 441
    //   436: aload 9
    //   438: invokevirtual 104	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   441: aload_1
    //   442: ifnull +7 -> 449
    //   445: aload_1
    //   446: invokestatic 107	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   449: iload_3
    //   450: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   453: if_icmpeq +9 -> 462
    //   456: iload 5
    //   458: istore_2
    //   459: goto +5 -> 464
    //   462: iconst_0
    //   463: istore_2
    //   464: iload_2
    //   465: ifeq +44 -> 509
    //   468: aload_0
    //   469: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   472: getfield 110	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   475: ifnull +34 -> 509
    //   478: aload_0
    //   479: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   482: getfield 110	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   485: iload_3
    //   486: invokestatic 113	com/tencent/map/sdk/a/jc:a	(Landroid/content/Context;I)V
    //   489: aload_0
    //   490: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   493: getfield 117	com/tencent/map/sdk/a/jf:b	Ljava/lang/ref/WeakReference;
    //   496: astore_1
    //   497: aload_1
    //   498: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   501: checkcast 125	com/tencent/map/sdk/a/jf$a
    //   504: invokeinterface 127 1 0
    //   509: aconst_null
    //   510: areturn
    //   511: astore_1
    //   512: aload 8
    //   514: astore 9
    //   516: aload_1
    //   517: astore 8
    //   519: aload 7
    //   521: astore_1
    //   522: aload_1
    //   523: ifnull +7 -> 530
    //   526: aload_1
    //   527: invokevirtual 104	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   530: aload 9
    //   532: ifnull +8 -> 540
    //   535: aload 9
    //   537: invokestatic 107	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   540: iload_3
    //   541: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   544: if_icmpeq +9 -> 553
    //   547: iload 6
    //   549: istore_2
    //   550: goto +5 -> 555
    //   553: iconst_0
    //   554: istore_2
    //   555: iload_2
    //   556: ifeq +42 -> 598
    //   559: aload_0
    //   560: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   563: getfield 110	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   566: ifnull +32 -> 598
    //   569: aload_0
    //   570: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   573: getfield 110	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   576: iload_3
    //   577: invokestatic 113	com/tencent/map/sdk/a/jc:a	(Landroid/content/Context;I)V
    //   580: aload_0
    //   581: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   584: getfield 117	com/tencent/map/sdk/a/jf:b	Ljava/lang/ref/WeakReference;
    //   587: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   590: checkcast 125	com/tencent/map/sdk/a/jf$a
    //   593: invokeinterface 127 1 0
    //   598: aload 8
    //   600: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	b
    //   0	601	1	paramVarArgs	Context[]
    //   54	502	2	i	int
    //   3	574	3	j	int
    //   62	183	4	k	int
    //   56	401	5	m	int
    //   59	489	6	n	int
    //   11	194	7	localObject1	java.lang.Object
    //   363	9	7	localThrowable1	java.lang.Throwable
    //   389	131	7	localObject2	java.lang.Object
    //   105	104	8	localObject3	java.lang.Object
    //   378	1	8	localObject4	java.lang.Object
    //   400	1	8	localObject5	java.lang.Object
    //   424	175	8	arrayOfContext	Context[]
    //   112	424	9	localObject6	java.lang.Object
    //   98	276	10	localObject7	java.lang.Object
    //   386	1	10	localThrowable2	java.lang.Throwable
    //   411	16	10	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   107	114	363	java/lang/Throwable
    //   126	132	363	java/lang/Throwable
    //   142	160	363	java/lang/Throwable
    //   169	180	363	java/lang/Throwable
    //   187	196	363	java/lang/Throwable
    //   210	219	363	java/lang/Throwable
    //   83	100	378	finally
    //   83	100	386	java/lang/Throwable
    //   64	83	400	finally
    //   64	83	411	java/lang/Throwable
    //   107	114	511	finally
    //   126	132	511	finally
    //   142	160	511	finally
    //   169	180	511	finally
    //   187	196	511	finally
    //   210	219	511	finally
    //   426	431	511	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.jf.b
 * JD-Core Version:    0.7.0.1
 */