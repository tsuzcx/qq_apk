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
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 5
    //   6: iconst_1
    //   7: istore_2
    //   8: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   11: istore_3
    //   12: new 28	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   19: astore 7
    //   21: aload 7
    //   23: ldc 31
    //   25: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 7
    //   31: ldc 37
    //   33: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_1
    //   38: ifnull +23 -> 61
    //   41: aload_1
    //   42: arraylength
    //   43: ifle +18 -> 61
    //   46: aload 7
    //   48: aload_1
    //   49: iconst_0
    //   50: aaload
    //   51: invokevirtual 43	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: invokestatic 48	com/tencent/map/sdk/a/jf:a	(Landroid/content/Context;)Ljava/lang/String;
    //   57: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: new 50	java/net/URL
    //   64: dup
    //   65: aload 7
    //   67: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 57	java/net/URL:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 61	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   76: checkcast 63	javax/net/ssl/HttpsURLConnection
    //   79: astore_1
    //   80: aload_1
    //   81: sipush 3000
    //   84: invokevirtual 67	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   87: aload_1
    //   88: invokevirtual 70	javax/net/ssl/HttpsURLConnection:connect	()V
    //   91: aload_1
    //   92: invokevirtual 74	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   95: astore 7
    //   97: aload 7
    //   99: invokestatic 79	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;)[B
    //   102: astore 8
    //   104: aload 8
    //   106: ifnull +13 -> 119
    //   109: aload 8
    //   111: arraylength
    //   112: istore 6
    //   114: iload 6
    //   116: ifne +78 -> 194
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 82	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   127: aload 7
    //   129: ifnull +8 -> 137
    //   132: aload 7
    //   134: invokestatic 85	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   137: iload_3
    //   138: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   141: if_icmpeq +48 -> 189
    //   144: iload_2
    //   145: ifeq +42 -> 187
    //   148: aload_0
    //   149: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   152: getfield 88	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   155: ifnull +32 -> 187
    //   158: aload_0
    //   159: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   162: getfield 88	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   165: iload_3
    //   166: invokestatic 91	com/tencent/map/sdk/a/jc:a	(Landroid/content/Context;I)V
    //   169: aload_0
    //   170: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   173: getfield 95	com/tencent/map/sdk/a/jf:b	Ljava/lang/ref/WeakReference;
    //   176: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   179: checkcast 103	com/tencent/map/sdk/a/jf$a
    //   182: invokeinterface 105 1 0
    //   187: aconst_null
    //   188: areturn
    //   189: iconst_0
    //   190: istore_2
    //   191: goto -47 -> 144
    //   194: new 107	org/json/JSONObject
    //   197: dup
    //   198: new 109	java/lang/String
    //   201: dup
    //   202: aload 8
    //   204: invokespecial 112	java/lang/String:<init>	([B)V
    //   207: invokespecial 113	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   210: astore 8
    //   212: iload_3
    //   213: istore_2
    //   214: aload 8
    //   216: ldc 115
    //   218: iconst_m1
    //   219: invokevirtual 119	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   222: ifne +28 -> 250
    //   225: aload 8
    //   227: ldc 121
    //   229: invokevirtual 125	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   232: astore 8
    //   234: iload_3
    //   235: istore_2
    //   236: aload 8
    //   238: ifnull +12 -> 250
    //   241: aload 8
    //   243: ldc 127
    //   245: iload_3
    //   246: invokevirtual 119	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   249: istore_2
    //   250: aload_1
    //   251: ifnull +7 -> 258
    //   254: aload_1
    //   255: invokevirtual 82	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   258: aload 7
    //   260: ifnull +8 -> 268
    //   263: aload 7
    //   265: invokestatic 85	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   268: iload_2
    //   269: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   272: if_icmpeq +51 -> 323
    //   275: iload 4
    //   277: istore_3
    //   278: iload_3
    //   279: ifeq -92 -> 187
    //   282: aload_0
    //   283: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   286: getfield 88	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   289: ifnull -102 -> 187
    //   292: aload_0
    //   293: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   296: getfield 88	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   299: iload_2
    //   300: invokestatic 91	com/tencent/map/sdk/a/jc:a	(Landroid/content/Context;I)V
    //   303: aload_0
    //   304: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   307: getfield 95	com/tencent/map/sdk/a/jf:b	Ljava/lang/ref/WeakReference;
    //   310: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   313: checkcast 103	com/tencent/map/sdk/a/jf$a
    //   316: invokeinterface 105 1 0
    //   321: aconst_null
    //   322: areturn
    //   323: iconst_0
    //   324: istore_3
    //   325: goto -47 -> 278
    //   328: astore 8
    //   330: aconst_null
    //   331: astore_1
    //   332: aconst_null
    //   333: astore 7
    //   335: aload 8
    //   337: invokevirtual 130	java/lang/Throwable:printStackTrace	()V
    //   340: aload 7
    //   342: ifnull +8 -> 350
    //   345: aload 7
    //   347: invokevirtual 82	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   350: aload_1
    //   351: ifnull +7 -> 358
    //   354: aload_1
    //   355: invokestatic 85	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   358: iload_3
    //   359: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   362: if_icmpeq +51 -> 413
    //   365: iload 5
    //   367: istore_2
    //   368: iload_2
    //   369: ifeq -182 -> 187
    //   372: aload_0
    //   373: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   376: getfield 88	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   379: ifnull -192 -> 187
    //   382: aload_0
    //   383: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   386: getfield 88	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   389: iload_3
    //   390: invokestatic 91	com/tencent/map/sdk/a/jc:a	(Landroid/content/Context;I)V
    //   393: aload_0
    //   394: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   397: getfield 95	com/tencent/map/sdk/a/jf:b	Ljava/lang/ref/WeakReference;
    //   400: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   403: checkcast 103	com/tencent/map/sdk/a/jf$a
    //   406: invokeinterface 105 1 0
    //   411: aconst_null
    //   412: areturn
    //   413: iconst_0
    //   414: istore_2
    //   415: goto -47 -> 368
    //   418: astore_1
    //   419: aconst_null
    //   420: astore 7
    //   422: aconst_null
    //   423: astore 8
    //   425: aload 8
    //   427: ifnull +8 -> 435
    //   430: aload 8
    //   432: invokevirtual 82	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   435: aload 7
    //   437: ifnull +8 -> 445
    //   440: aload 7
    //   442: invokestatic 85	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   445: iload_3
    //   446: invokestatic 26	com/tencent/map/sdk/a/jc:a	()I
    //   449: if_icmpeq +50 -> 499
    //   452: iconst_1
    //   453: istore_2
    //   454: iload_2
    //   455: ifeq +42 -> 497
    //   458: aload_0
    //   459: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   462: getfield 88	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   465: ifnull +32 -> 497
    //   468: aload_0
    //   469: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   472: getfield 88	com/tencent/map/sdk/a/jf:a	Landroid/content/Context;
    //   475: iload_3
    //   476: invokestatic 91	com/tencent/map/sdk/a/jc:a	(Landroid/content/Context;I)V
    //   479: aload_0
    //   480: getfield 11	com/tencent/map/sdk/a/jf$b:a	Lcom/tencent/map/sdk/a/jf;
    //   483: getfield 95	com/tencent/map/sdk/a/jf:b	Ljava/lang/ref/WeakReference;
    //   486: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   489: checkcast 103	com/tencent/map/sdk/a/jf$a
    //   492: invokeinterface 105 1 0
    //   497: aload_1
    //   498: athrow
    //   499: iconst_0
    //   500: istore_2
    //   501: goto -47 -> 454
    //   504: astore 9
    //   506: aconst_null
    //   507: astore 7
    //   509: aload_1
    //   510: astore 8
    //   512: aload 9
    //   514: astore_1
    //   515: goto -90 -> 425
    //   518: astore 9
    //   520: aload_1
    //   521: astore 8
    //   523: aload 9
    //   525: astore_1
    //   526: goto -101 -> 425
    //   529: astore 9
    //   531: aload 7
    //   533: astore 8
    //   535: aload_1
    //   536: astore 7
    //   538: aload 9
    //   540: astore_1
    //   541: goto -116 -> 425
    //   544: astore 8
    //   546: aload_1
    //   547: astore 7
    //   549: aconst_null
    //   550: astore_1
    //   551: goto -216 -> 335
    //   554: astore 8
    //   556: aload_1
    //   557: astore 9
    //   559: aload 7
    //   561: astore_1
    //   562: aload 9
    //   564: astore 7
    //   566: goto -231 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	b
    //   0	569	1	paramVarArgs	Context[]
    //   7	494	2	i	int
    //   11	465	3	j	int
    //   1	275	4	k	int
    //   4	362	5	m	int
    //   112	3	6	n	int
    //   19	546	7	localObject1	java.lang.Object
    //   102	140	8	localObject2	java.lang.Object
    //   328	8	8	localThrowable1	java.lang.Throwable
    //   423	111	8	localObject3	java.lang.Object
    //   544	1	8	localThrowable2	java.lang.Throwable
    //   554	1	8	localThrowable3	java.lang.Throwable
    //   504	9	9	localObject4	java.lang.Object
    //   518	6	9	localObject5	java.lang.Object
    //   529	10	9	localObject6	java.lang.Object
    //   557	6	9	arrayOfContext	Context[]
    // Exception table:
    //   from	to	target	type
    //   61	80	328	java/lang/Throwable
    //   61	80	418	finally
    //   80	97	504	finally
    //   97	104	518	finally
    //   109	114	518	finally
    //   194	212	518	finally
    //   214	234	518	finally
    //   241	250	518	finally
    //   335	340	529	finally
    //   80	97	544	java/lang/Throwable
    //   97	104	554	java/lang/Throwable
    //   109	114	554	java/lang/Throwable
    //   194	212	554	java/lang/Throwable
    //   214	234	554	java/lang/Throwable
    //   241	250	554	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jf.b
 * JD-Core Version:    0.7.0.1
 */