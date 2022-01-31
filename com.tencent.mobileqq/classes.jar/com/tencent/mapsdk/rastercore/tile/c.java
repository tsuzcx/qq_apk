package com.tencent.mapsdk.rastercore.tile;

import java.util.Locale;

public final class c
{
  private static String a = Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
  
  /* Error */
  public static byte[] a(java.net.URL paramURL)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: invokestatic 46	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   15: ifnull +508 -> 523
    //   18: new 48	java/net/Proxy
    //   21: dup
    //   22: getstatic 54	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   25: new 56	java/net/InetSocketAddress
    //   28: dup
    //   29: invokestatic 46	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   32: invokestatic 60	android/net/Proxy:getDefaultPort	()I
    //   35: invokespecial 63	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   38: invokespecial 66	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +173 -> 216
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 72	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   51: checkcast 74	java/net/HttpURLConnection
    //   54: astore_0
    //   55: aload_0
    //   56: sipush 5000
    //   59: invokevirtual 78	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   62: aload_0
    //   63: sipush 15000
    //   66: invokevirtual 81	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   69: aload_0
    //   70: ldc 83
    //   72: ldc 85
    //   74: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: ldc 91
    //   80: ldc 93
    //   82: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: ldc 95
    //   88: getstatic 37	com/tencent/mapsdk/rastercore/tile/c:a	Ljava/lang/String;
    //   91: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: invokevirtual 98	java/net/HttpURLConnection:getResponseCode	()I
    //   98: sipush 200
    //   101: if_icmpne +413 -> 514
    //   104: aload_0
    //   105: invokevirtual 102	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   108: astore_1
    //   109: aload_0
    //   110: invokevirtual 105	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   113: invokevirtual 110	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   116: invokevirtual 113	java/lang/String:trim	()Ljava/lang/String;
    //   119: ldc 115
    //   121: invokevirtual 119	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   124: ifeq +103 -> 227
    //   127: new 121	java/io/InputStreamReader
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 124	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   135: astore_3
    //   136: new 126	java/io/BufferedReader
    //   139: dup
    //   140: aload_3
    //   141: invokespecial 129	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   144: astore 4
    //   146: aload 4
    //   148: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   151: astore_2
    //   152: aload_2
    //   153: ifnull +356 -> 509
    //   156: aload_2
    //   157: invokevirtual 110	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   160: invokevirtual 113	java/lang/String:trim	()Ljava/lang/String;
    //   163: pop
    //   164: aload_2
    //   165: ldc 134
    //   167: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq +339 -> 509
    //   173: iconst_1
    //   174: newarray byte
    //   176: astore_2
    //   177: aload_2
    //   178: iconst_0
    //   179: iconst_m1
    //   180: bastore
    //   181: aload_2
    //   182: astore 5
    //   184: aload_1
    //   185: astore_2
    //   186: aload 4
    //   188: astore_1
    //   189: aload 5
    //   191: astore 4
    //   193: aload_0
    //   194: ifnull +7 -> 201
    //   197: aload_0
    //   198: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   201: aload_1
    //   202: invokestatic 146	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   205: aload_3
    //   206: invokestatic 146	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   209: aload_2
    //   210: invokestatic 146	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   213: aload 4
    //   215: areturn
    //   216: aload_0
    //   217: invokevirtual 149	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   220: checkcast 74	java/net/HttpURLConnection
    //   223: astore_0
    //   224: goto -169 -> 55
    //   227: ldc 151
    //   229: aload_0
    //   230: ldc 153
    //   232: invokevirtual 157	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   235: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   238: ifeq +268 -> 506
    //   241: new 163	java/util/zip/GZIPInputStream
    //   244: dup
    //   245: aload_1
    //   246: invokespecial 164	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   249: astore_2
    //   250: aload_2
    //   251: astore_1
    //   252: aload_1
    //   253: invokestatic 167	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/InputStream;)[B
    //   256: astore 6
    //   258: aload 6
    //   260: iconst_0
    //   261: aload 6
    //   263: arraylength
    //   264: invokestatic 173	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   267: pop
    //   268: aconst_null
    //   269: astore_3
    //   270: aload_1
    //   271: astore_2
    //   272: aconst_null
    //   273: astore_1
    //   274: aload 6
    //   276: astore 4
    //   278: goto -85 -> 193
    //   281: astore_2
    //   282: new 10	java/lang/StringBuilder
    //   285: dup
    //   286: ldc 175
    //   288: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   291: aload_2
    //   292: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aconst_null
    //   300: astore_3
    //   301: aload_1
    //   302: astore_2
    //   303: aconst_null
    //   304: astore_1
    //   305: goto -112 -> 193
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_0
    //   311: aconst_null
    //   312: astore_1
    //   313: aconst_null
    //   314: astore_2
    //   315: aconst_null
    //   316: astore_3
    //   317: aload_3
    //   318: ifnull +7 -> 325
    //   321: aload_3
    //   322: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   325: aload_0
    //   326: invokestatic 146	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   329: aload_1
    //   330: invokestatic 146	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   333: aload_2
    //   334: invokestatic 146	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   337: aconst_null
    //   338: areturn
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_3
    //   342: aconst_null
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_0
    //   346: aload 5
    //   348: astore 4
    //   350: aload_0
    //   351: ifnull +7 -> 358
    //   354: aload_0
    //   355: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   358: aload 4
    //   360: invokestatic 146	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   363: aload_3
    //   364: invokestatic 146	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   367: aload_1
    //   368: invokestatic 146	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   371: aload_2
    //   372: athrow
    //   373: astore_2
    //   374: aconst_null
    //   375: astore_3
    //   376: aconst_null
    //   377: astore_1
    //   378: aload 5
    //   380: astore 4
    //   382: goto -32 -> 350
    //   385: astore_2
    //   386: aconst_null
    //   387: astore_3
    //   388: aload 5
    //   390: astore 4
    //   392: goto -42 -> 350
    //   395: astore_2
    //   396: aload 5
    //   398: astore 4
    //   400: goto -50 -> 350
    //   403: astore_2
    //   404: goto -54 -> 350
    //   407: astore_2
    //   408: aconst_null
    //   409: astore_3
    //   410: aload 5
    //   412: astore 4
    //   414: goto -64 -> 350
    //   417: astore_1
    //   418: aconst_null
    //   419: astore 4
    //   421: aconst_null
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_2
    //   425: aload_0
    //   426: astore_3
    //   427: aload 4
    //   429: astore_0
    //   430: goto -113 -> 317
    //   433: astore_2
    //   434: aconst_null
    //   435: astore 5
    //   437: aconst_null
    //   438: astore 4
    //   440: aload_1
    //   441: astore_2
    //   442: aload_0
    //   443: astore_3
    //   444: aload 5
    //   446: astore_0
    //   447: aload 4
    //   449: astore_1
    //   450: goto -133 -> 317
    //   453: astore_2
    //   454: aconst_null
    //   455: astore 5
    //   457: aload_1
    //   458: astore_2
    //   459: aload_0
    //   460: astore 4
    //   462: aload 5
    //   464: astore_0
    //   465: aload_3
    //   466: astore_1
    //   467: aload 4
    //   469: astore_3
    //   470: goto -153 -> 317
    //   473: astore_2
    //   474: aload_1
    //   475: astore_2
    //   476: aload_0
    //   477: astore 5
    //   479: aload 4
    //   481: astore_0
    //   482: aload_3
    //   483: astore_1
    //   484: aload 5
    //   486: astore_3
    //   487: goto -170 -> 317
    //   490: astore_2
    //   491: aconst_null
    //   492: astore 4
    //   494: aload_1
    //   495: astore_2
    //   496: aload_0
    //   497: astore_3
    //   498: aconst_null
    //   499: astore_1
    //   500: aload 4
    //   502: astore_0
    //   503: goto -186 -> 317
    //   506: goto -254 -> 252
    //   509: aconst_null
    //   510: astore_2
    //   511: goto -330 -> 181
    //   514: aconst_null
    //   515: astore_1
    //   516: aconst_null
    //   517: astore_3
    //   518: aconst_null
    //   519: astore_2
    //   520: goto -327 -> 193
    //   523: aconst_null
    //   524: astore_1
    //   525: goto -483 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	paramURL	java.net.URL
    //   41	337	1	localObject1	Object
    //   417	1	1	localException1	java.lang.Exception
    //   422	103	1	localObject2	Object
    //   151	121	2	localObject3	Object
    //   281	11	2	localException2	java.lang.Exception
    //   302	32	2	localObject4	Object
    //   339	33	2	localObject5	Object
    //   373	1	2	localObject6	Object
    //   385	1	2	localObject7	Object
    //   395	1	2	localObject8	Object
    //   403	1	2	localObject9	Object
    //   407	1	2	localObject10	Object
    //   424	1	2	localObject11	Object
    //   433	1	2	localException3	java.lang.Exception
    //   441	1	2	localObject12	Object
    //   453	1	2	localException4	java.lang.Exception
    //   458	1	2	localObject13	Object
    //   473	1	2	localException5	java.lang.Exception
    //   475	1	2	localObject14	Object
    //   490	1	2	localException6	java.lang.Exception
    //   495	25	2	localObject15	Object
    //   135	383	3	localObject16	Object
    //   4	497	4	localObject17	Object
    //   1	484	5	localObject18	Object
    //   256	19	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   258	268	281	java/lang/Exception
    //   12	42	308	java/lang/Exception
    //   46	55	308	java/lang/Exception
    //   216	224	308	java/lang/Exception
    //   12	42	339	finally
    //   46	55	339	finally
    //   216	224	339	finally
    //   55	109	373	finally
    //   109	136	385	finally
    //   227	250	385	finally
    //   136	146	395	finally
    //   146	152	403	finally
    //   156	177	403	finally
    //   252	258	407	finally
    //   258	268	407	finally
    //   282	299	407	finally
    //   55	109	417	java/lang/Exception
    //   109	136	433	java/lang/Exception
    //   227	250	433	java/lang/Exception
    //   136	146	453	java/lang/Exception
    //   146	152	473	java/lang/Exception
    //   156	177	473	java/lang/Exception
    //   252	258	490	java/lang/Exception
    //   282	299	490	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.c
 * JD-Core Version:    0.7.0.1
 */