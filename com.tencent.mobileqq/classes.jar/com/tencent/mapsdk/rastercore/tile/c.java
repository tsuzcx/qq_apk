package com.tencent.mapsdk.rastercore.tile;

import java.util.Locale;

public final class c
{
  private static String a = Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
  
  /* Error */
  public static byte[] a(java.net.URL paramURL, MapTile.MapSource paramMapSource)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: lconst_0
    //   7: lstore_3
    //   8: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   11: lstore 5
    //   13: invokestatic 52	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   16: ifnull +554 -> 570
    //   19: new 54	java/net/Proxy
    //   22: dup
    //   23: getstatic 60	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   26: new 62	java/net/InetSocketAddress
    //   29: dup
    //   30: invokestatic 52	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   33: invokestatic 66	android/net/Proxy:getDefaultPort	()I
    //   36: invokespecial 69	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   39: invokespecial 72	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   42: astore 9
    //   44: aload 9
    //   46: ifnull +167 -> 213
    //   49: aload_0
    //   50: aload 9
    //   52: invokevirtual 78	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   55: checkcast 80	java/net/HttpURLConnection
    //   58: astore_0
    //   59: aload_0
    //   60: sipush 5000
    //   63: invokevirtual 84	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   66: aload_0
    //   67: sipush 15000
    //   70: invokevirtual 87	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   73: aload_0
    //   74: ldc 89
    //   76: ldc 91
    //   78: invokevirtual 95	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: ldc 97
    //   84: ldc 99
    //   86: invokevirtual 95	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_0
    //   90: ldc 101
    //   92: getstatic 37	com/tencent/mapsdk/rastercore/tile/c:a	Ljava/lang/String;
    //   95: invokevirtual 95	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: invokevirtual 104	java/net/HttpURLConnection:getResponseCode	()I
    //   102: istore_2
    //   103: iload_2
    //   104: sipush 200
    //   107: if_icmpne +180 -> 287
    //   110: aload_0
    //   111: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   114: astore 9
    //   116: ldc 110
    //   118: aload_0
    //   119: ldc 112
    //   121: invokevirtual 116	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   124: invokevirtual 122	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   127: ifeq +440 -> 567
    //   130: new 124	java/util/zip/GZIPInputStream
    //   133: dup
    //   134: aload 9
    //   136: invokespecial 127	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   139: astore 9
    //   141: aload 9
    //   143: invokestatic 132	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/InputStream;)[B
    //   146: astore 9
    //   148: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   151: lstore 7
    //   153: lload 7
    //   155: lload 5
    //   157: lsub
    //   158: lstore_3
    //   159: aload 9
    //   161: iconst_0
    //   162: aload 9
    //   164: arraylength
    //   165: invokestatic 138	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   168: pop
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   177: aload_1
    //   178: getstatic 147	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:TENCENT	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   181: if_acmpne +70 -> 251
    //   184: getstatic 152	com/tencent/mapsdk/rastercore/d/e:a	Ljava/lang/StringBuffer;
    //   187: new 10	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   194: lload_3
    //   195: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: ldc 157
    //   200: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokevirtual 162	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   209: pop
    //   210: aload 9
    //   212: areturn
    //   213: aload_0
    //   214: invokevirtual 165	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   217: checkcast 80	java/net/HttpURLConnection
    //   220: astore_0
    //   221: goto -162 -> 59
    //   224: astore 10
    //   226: new 10	java/lang/StringBuilder
    //   229: dup
    //   230: ldc 167
    //   232: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload 10
    //   237: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   240: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc2_w 174
    //   247: lstore_3
    //   248: goto -79 -> 169
    //   251: aload_1
    //   252: getstatic 178	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:BING	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   255: if_acmpne -45 -> 210
    //   258: getstatic 181	com/tencent/mapsdk/rastercore/d/e:b	Ljava/lang/StringBuffer;
    //   261: new 10	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   268: lload_3
    //   269: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   272: ldc 157
    //   274: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokevirtual 162	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   283: pop
    //   284: goto -74 -> 210
    //   287: iload_2
    //   288: sipush 400
    //   291: if_icmplt +7 -> 298
    //   294: iload_2
    //   295: ineg
    //   296: i2l
    //   297: lstore_3
    //   298: aload_0
    //   299: ifnull +7 -> 306
    //   302: aload_0
    //   303: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   306: aload_1
    //   307: getstatic 147	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:TENCENT	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   310: if_acmpne +31 -> 341
    //   313: getstatic 152	com/tencent/mapsdk/rastercore/d/e:a	Ljava/lang/StringBuffer;
    //   316: new 10	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   323: lload_3
    //   324: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   327: ldc 157
    //   329: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 162	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   338: pop
    //   339: aconst_null
    //   340: areturn
    //   341: aload_1
    //   342: getstatic 178	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:BING	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   345: if_acmpne -6 -> 339
    //   348: getstatic 181	com/tencent/mapsdk/rastercore/d/e:b	Ljava/lang/StringBuffer;
    //   351: new 10	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   358: lload_3
    //   359: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   362: ldc 157
    //   364: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokevirtual 162	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   373: pop
    //   374: goto -35 -> 339
    //   377: astore_0
    //   378: lconst_0
    //   379: lstore_3
    //   380: aconst_null
    //   381: astore_0
    //   382: aload_0
    //   383: ifnull +7 -> 390
    //   386: aload_0
    //   387: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   390: aload_1
    //   391: getstatic 147	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:TENCENT	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   394: if_acmpne +31 -> 425
    //   397: getstatic 152	com/tencent/mapsdk/rastercore/d/e:a	Ljava/lang/StringBuffer;
    //   400: new 10	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   407: lload_3
    //   408: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   411: ldc 157
    //   413: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokevirtual 162	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   422: pop
    //   423: aconst_null
    //   424: areturn
    //   425: aload_1
    //   426: getstatic 178	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:BING	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   429: if_acmpne -6 -> 423
    //   432: getstatic 181	com/tencent/mapsdk/rastercore/d/e:b	Ljava/lang/StringBuffer;
    //   435: new 10	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   442: lload_3
    //   443: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   446: ldc 157
    //   448: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokevirtual 162	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   457: pop
    //   458: goto -35 -> 423
    //   461: astore 9
    //   463: aconst_null
    //   464: astore_0
    //   465: aload_0
    //   466: ifnull +7 -> 473
    //   469: aload_0
    //   470: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   473: aload_1
    //   474: getstatic 147	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:TENCENT	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   477: if_acmpne +32 -> 509
    //   480: getstatic 152	com/tencent/mapsdk/rastercore/d/e:a	Ljava/lang/StringBuffer;
    //   483: new 10	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   490: lload_3
    //   491: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   494: ldc 157
    //   496: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokevirtual 162	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   505: pop
    //   506: aload 9
    //   508: athrow
    //   509: aload_1
    //   510: getstatic 178	com/tencent/mapsdk/rastercore/tile/MapTile$MapSource:BING	Lcom/tencent/mapsdk/rastercore/tile/MapTile$MapSource;
    //   513: if_acmpne -7 -> 506
    //   516: getstatic 181	com/tencent/mapsdk/rastercore/d/e:b	Ljava/lang/StringBuffer;
    //   519: new 10	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   526: lload_3
    //   527: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   530: ldc 157
    //   532: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokevirtual 162	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   541: pop
    //   542: goto -36 -> 506
    //   545: astore 9
    //   547: goto -82 -> 465
    //   550: astore 9
    //   552: goto -87 -> 465
    //   555: astore 9
    //   557: lconst_0
    //   558: lstore_3
    //   559: goto -177 -> 382
    //   562: astore 9
    //   564: goto -182 -> 382
    //   567: goto -426 -> 141
    //   570: aconst_null
    //   571: astore 9
    //   573: goto -529 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	paramURL	java.net.URL
    //   0	576	1	paramMapSource	MapTile.MapSource
    //   102	193	2	i	int
    //   7	552	3	l1	long
    //   11	145	5	l2	long
    //   151	3	7	l3	long
    //   42	169	9	localObject1	Object
    //   461	46	9	localObject2	Object
    //   545	1	9	localObject3	Object
    //   550	1	9	localObject4	Object
    //   555	1	9	localException1	java.lang.Exception
    //   562	1	9	localException2	java.lang.Exception
    //   571	1	9	localObject5	Object
    //   224	12	10	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   159	169	224	java/lang/Exception
    //   8	44	377	java/lang/Exception
    //   49	59	377	java/lang/Exception
    //   213	221	377	java/lang/Exception
    //   8	44	461	finally
    //   49	59	461	finally
    //   213	221	461	finally
    //   59	103	545	finally
    //   110	141	545	finally
    //   141	153	545	finally
    //   159	169	550	finally
    //   226	244	550	finally
    //   59	103	555	java/lang/Exception
    //   110	141	555	java/lang/Exception
    //   141	153	555	java/lang/Exception
    //   226	244	562	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.c
 * JD-Core Version:    0.7.0.1
 */