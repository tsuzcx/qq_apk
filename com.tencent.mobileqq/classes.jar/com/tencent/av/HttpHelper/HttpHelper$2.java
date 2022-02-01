package com.tencent.av.HttpHelper;

import java.util.Map;

final class HttpHelper$2
  implements Runnable
{
  HttpHelper$2(String paramString, int paramInt, byte[] paramArrayOfByte, Map paramMap, HttpHelper.HttpRequestListener paramHttpRequestListener, Object paramObject) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: sipush 200
    //   3: istore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: new 43	java/net/URL
    //   10: dup
    //   11: aload_0
    //   12: getfield 22	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
    //   15: invokespecial 46	java/net/URL:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 50	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   21: checkcast 52	java/net/HttpURLConnection
    //   24: checkcast 52	java/net/HttpURLConnection
    //   27: astore_3
    //   28: aload_3
    //   29: ldc 54
    //   31: invokevirtual 57	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   34: aload_3
    //   35: aload_0
    //   36: getfield 24	com/tencent/av/HttpHelper/HttpHelper$2:val$timeout	I
    //   39: invokevirtual 61	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   42: aload_3
    //   43: aload_0
    //   44: getfield 24	com/tencent/av/HttpHelper/HttpHelper$2:val$timeout	I
    //   47: invokevirtual 64	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   50: aload_3
    //   51: iconst_1
    //   52: invokevirtual 68	java/net/HttpURLConnection:setDoInput	(Z)V
    //   55: aload_3
    //   56: iconst_1
    //   57: invokevirtual 71	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   60: aload_3
    //   61: ldc 73
    //   63: ldc 75
    //   65: invokevirtual 79	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_3
    //   69: ldc 81
    //   71: aload_0
    //   72: getfield 26	com/tencent/av/HttpHelper/HttpHelper$2:val$req	[B
    //   75: arraylength
    //   76: invokestatic 87	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 79	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_0
    //   83: getfield 28	com/tencent/av/HttpHelper/HttpHelper$2:val$mapPropertys	Ljava/util/Map;
    //   86: ifnull +146 -> 232
    //   89: aload_0
    //   90: getfield 28	com/tencent/av/HttpHelper/HttpHelper$2:val$mapPropertys	Ljava/util/Map;
    //   93: invokeinterface 93 1 0
    //   98: ifne +134 -> 232
    //   101: aload_0
    //   102: getfield 28	com/tencent/av/HttpHelper/HttpHelper$2:val$mapPropertys	Ljava/util/Map;
    //   105: invokeinterface 97 1 0
    //   110: invokeinterface 103 1 0
    //   115: astore 4
    //   117: aload 4
    //   119: invokeinterface 108 1 0
    //   124: ifeq +108 -> 232
    //   127: aload 4
    //   129: invokeinterface 112 1 0
    //   134: checkcast 114	java/util/Map$Entry
    //   137: astore 6
    //   139: aload_3
    //   140: aload 6
    //   142: invokeinterface 117 1 0
    //   147: checkcast 83	java/lang/String
    //   150: aload 6
    //   152: invokeinterface 120 1 0
    //   157: checkcast 83	java/lang/String
    //   160: invokevirtual 79	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: goto -46 -> 117
    //   166: astore 4
    //   168: aconst_null
    //   169: astore 5
    //   171: sipush 200
    //   174: istore_1
    //   175: ldc 122
    //   177: ldc 124
    //   179: aload 4
    //   181: invokestatic 130	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   184: pop
    //   185: aload 5
    //   187: ifnull +8 -> 195
    //   190: aload 5
    //   192: invokevirtual 134	java/io/InputStream:close	()V
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 137	java/net/HttpURLConnection:disconnect	()V
    //   203: aload_0
    //   204: getfield 30	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   207: ifnull +24 -> 231
    //   210: aload_0
    //   211: getfield 30	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   214: aload_0
    //   215: getfield 22	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
    //   218: sipush 404
    //   221: aconst_null
    //   222: aload_0
    //   223: getfield 32	com/tencent/av/HttpHelper/HttpHelper$2:val$param	Ljava/lang/Object;
    //   226: invokeinterface 143 5 0
    //   231: return
    //   232: aload_3
    //   233: invokevirtual 147	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   236: aload_0
    //   237: getfield 26	com/tencent/av/HttpHelper/HttpHelper$2:val$req	[B
    //   240: invokevirtual 153	java/io/OutputStream:write	([B)V
    //   243: aload_3
    //   244: invokevirtual 157	java/net/HttpURLConnection:getResponseCode	()I
    //   247: istore_1
    //   248: iload_1
    //   249: sipush 200
    //   252: if_icmpne +125 -> 377
    //   255: new 159	java/io/BufferedInputStream
    //   258: dup
    //   259: aload_3
    //   260: invokevirtual 163	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   263: invokespecial 166	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   266: astore 4
    //   268: new 168	java/io/ByteArrayOutputStream
    //   271: dup
    //   272: sipush 10240
    //   275: invokespecial 170	java/io/ByteArrayOutputStream:<init>	(I)V
    //   278: astore 5
    //   280: sipush 1024
    //   283: newarray byte
    //   285: astore 6
    //   287: aload 4
    //   289: aload 6
    //   291: invokevirtual 174	java/io/InputStream:read	([B)I
    //   294: istore_2
    //   295: iload_2
    //   296: ifge +56 -> 352
    //   299: aload 5
    //   301: invokevirtual 178	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   304: astore 5
    //   306: aload 4
    //   308: ifnull +8 -> 316
    //   311: aload 4
    //   313: invokevirtual 134	java/io/InputStream:close	()V
    //   316: aload_3
    //   317: ifnull +7 -> 324
    //   320: aload_3
    //   321: invokevirtual 137	java/net/HttpURLConnection:disconnect	()V
    //   324: aload_0
    //   325: getfield 30	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   328: ifnull -97 -> 231
    //   331: aload_0
    //   332: getfield 30	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   335: aload_0
    //   336: getfield 22	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
    //   339: iload_1
    //   340: aload 5
    //   342: aload_0
    //   343: getfield 32	com/tencent/av/HttpHelper/HttpHelper$2:val$param	Ljava/lang/Object;
    //   346: invokeinterface 143 5 0
    //   351: return
    //   352: aload 5
    //   354: aload 6
    //   356: iconst_0
    //   357: iload_2
    //   358: invokevirtual 181	java/io/ByteArrayOutputStream:write	([BII)V
    //   361: goto -74 -> 287
    //   364: astore 6
    //   366: aload 4
    //   368: astore 5
    //   370: aload 6
    //   372: astore 4
    //   374: goto -199 -> 175
    //   377: ldc 122
    //   379: new 183	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   386: ldc 186
    //   388: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: iload_1
    //   392: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 200	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   401: pop
    //   402: aconst_null
    //   403: astore 4
    //   405: goto -99 -> 306
    //   408: astore 4
    //   410: aload 4
    //   412: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   415: goto -99 -> 316
    //   418: astore 4
    //   420: aload 4
    //   422: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   425: goto -230 -> 195
    //   428: astore 5
    //   430: aconst_null
    //   431: astore_3
    //   432: aconst_null
    //   433: astore 4
    //   435: iload_2
    //   436: istore_1
    //   437: ldc 122
    //   439: ldc 124
    //   441: aload 5
    //   443: invokestatic 130	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   446: pop
    //   447: aload_3
    //   448: ifnull +7 -> 455
    //   451: aload_3
    //   452: invokevirtual 134	java/io/InputStream:close	()V
    //   455: aload 4
    //   457: ifnull +8 -> 465
    //   460: aload 4
    //   462: invokevirtual 137	java/net/HttpURLConnection:disconnect	()V
    //   465: aload_0
    //   466: getfield 30	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   469: ifnull -238 -> 231
    //   472: aload_0
    //   473: getfield 30	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   476: aload_0
    //   477: getfield 22	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
    //   480: iconst_m1
    //   481: aconst_null
    //   482: aload_0
    //   483: getfield 32	com/tencent/av/HttpHelper/HttpHelper$2:val$param	Ljava/lang/Object;
    //   486: invokeinterface 143 5 0
    //   491: return
    //   492: astore_3
    //   493: aload_3
    //   494: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   497: goto -42 -> 455
    //   500: astore_3
    //   501: aconst_null
    //   502: astore 5
    //   504: aconst_null
    //   505: astore 4
    //   507: iload_2
    //   508: istore_1
    //   509: aload 5
    //   511: ifnull +8 -> 519
    //   514: aload 5
    //   516: invokevirtual 134	java/io/InputStream:close	()V
    //   519: aload 4
    //   521: ifnull +8 -> 529
    //   524: aload 4
    //   526: invokevirtual 137	java/net/HttpURLConnection:disconnect	()V
    //   529: aload_0
    //   530: getfield 30	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   533: ifnull +22 -> 555
    //   536: aload_0
    //   537: getfield 30	com/tencent/av/HttpHelper/HttpHelper$2:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   540: aload_0
    //   541: getfield 22	com/tencent/av/HttpHelper/HttpHelper$2:val$url	Ljava/lang/String;
    //   544: iload_1
    //   545: aconst_null
    //   546: aload_0
    //   547: getfield 32	com/tencent/av/HttpHelper/HttpHelper$2:val$param	Ljava/lang/Object;
    //   550: invokeinterface 143 5 0
    //   555: aload_3
    //   556: athrow
    //   557: astore 5
    //   559: aload 5
    //   561: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   564: goto -45 -> 519
    //   567: astore 6
    //   569: aconst_null
    //   570: astore 5
    //   572: aload_3
    //   573: astore 4
    //   575: aload 6
    //   577: astore_3
    //   578: iload_2
    //   579: istore_1
    //   580: goto -71 -> 509
    //   583: astore 6
    //   585: aconst_null
    //   586: astore 5
    //   588: aload_3
    //   589: astore 4
    //   591: aload 6
    //   593: astore_3
    //   594: goto -85 -> 509
    //   597: astore 6
    //   599: aload_3
    //   600: astore 5
    //   602: aload 6
    //   604: astore_3
    //   605: aload 4
    //   607: astore 6
    //   609: aload 5
    //   611: astore 4
    //   613: aload 6
    //   615: astore 5
    //   617: goto -108 -> 509
    //   620: astore 6
    //   622: aload_3
    //   623: astore 4
    //   625: aload 6
    //   627: astore_3
    //   628: goto -119 -> 509
    //   631: astore 6
    //   633: aload_3
    //   634: astore 5
    //   636: aload 6
    //   638: astore_3
    //   639: goto -130 -> 509
    //   642: astore 5
    //   644: aload_3
    //   645: astore 4
    //   647: aconst_null
    //   648: astore_3
    //   649: iload_2
    //   650: istore_1
    //   651: goto -214 -> 437
    //   654: astore 5
    //   656: aload_3
    //   657: astore 4
    //   659: aconst_null
    //   660: astore_3
    //   661: goto -224 -> 437
    //   664: astore 5
    //   666: aload_3
    //   667: astore 6
    //   669: aload 4
    //   671: astore_3
    //   672: aload 6
    //   674: astore 4
    //   676: goto -239 -> 437
    //   679: astore 4
    //   681: sipush 200
    //   684: istore_1
    //   685: aconst_null
    //   686: astore 5
    //   688: aconst_null
    //   689: astore_3
    //   690: goto -515 -> 175
    //   693: astore 4
    //   695: aconst_null
    //   696: astore 5
    //   698: goto -523 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	this	2
    //   174	511	1	i	int
    //   3	647	2	j	int
    //   27	425	3	localHttpURLConnection	java.net.HttpURLConnection
    //   492	2	3	localIOException1	java.io.IOException
    //   500	73	3	localObject1	Object
    //   577	113	3	localObject2	Object
    //   115	13	4	localIterator	java.util.Iterator
    //   166	14	4	localUnknownHostException1	java.net.UnknownHostException
    //   266	138	4	localObject3	Object
    //   408	3	4	localIOException2	java.io.IOException
    //   418	3	4	localIOException3	java.io.IOException
    //   433	242	4	localObject4	Object
    //   679	1	4	localUnknownHostException2	java.net.UnknownHostException
    //   693	1	4	localUnknownHostException3	java.net.UnknownHostException
    //   5	364	5	localObject5	Object
    //   428	14	5	localIOException4	java.io.IOException
    //   502	13	5	localObject6	Object
    //   557	3	5	localIOException5	java.io.IOException
    //   570	65	5	localObject7	Object
    //   642	1	5	localIOException6	java.io.IOException
    //   654	1	5	localIOException7	java.io.IOException
    //   664	1	5	localIOException8	java.io.IOException
    //   686	11	5	localObject8	Object
    //   137	218	6	localObject9	Object
    //   364	7	6	localUnknownHostException4	java.net.UnknownHostException
    //   567	9	6	localObject10	Object
    //   583	9	6	localObject11	Object
    //   597	6	6	localObject12	Object
    //   607	7	6	localObject13	Object
    //   620	6	6	localObject14	Object
    //   631	6	6	localObject15	Object
    //   667	6	6	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   28	117	166	java/net/UnknownHostException
    //   117	163	166	java/net/UnknownHostException
    //   232	248	166	java/net/UnknownHostException
    //   268	287	364	java/net/UnknownHostException
    //   287	295	364	java/net/UnknownHostException
    //   299	306	364	java/net/UnknownHostException
    //   352	361	364	java/net/UnknownHostException
    //   311	316	408	java/io/IOException
    //   190	195	418	java/io/IOException
    //   7	28	428	java/io/IOException
    //   451	455	492	java/io/IOException
    //   7	28	500	finally
    //   514	519	557	java/io/IOException
    //   28	117	567	finally
    //   117	163	567	finally
    //   232	248	567	finally
    //   255	268	583	finally
    //   377	402	583	finally
    //   268	287	597	finally
    //   287	295	597	finally
    //   299	306	597	finally
    //   352	361	597	finally
    //   175	185	620	finally
    //   437	447	631	finally
    //   28	117	642	java/io/IOException
    //   117	163	642	java/io/IOException
    //   232	248	642	java/io/IOException
    //   255	268	654	java/io/IOException
    //   377	402	654	java/io/IOException
    //   268	287	664	java/io/IOException
    //   287	295	664	java/io/IOException
    //   299	306	664	java/io/IOException
    //   352	361	664	java/io/IOException
    //   7	28	679	java/net/UnknownHostException
    //   255	268	693	java/net/UnknownHostException
    //   377	402	693	java/net/UnknownHostException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.HttpHelper.HttpHelper.2
 * JD-Core Version:    0.7.0.1
 */