package com.tencent.av.HttpHelper;

final class HttpHelper$1
  implements Runnable
{
  HttpHelper$1(String paramString, int paramInt, HttpHelper.HttpRequestListener paramHttpRequestListener, Object paramObject) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 35	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: getfield 18	com/tencent/av/HttpHelper/HttpHelper$1:val$url	Ljava/lang/String;
    //   11: invokespecial 38	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 42	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 44	java/net/HttpURLConnection
    //   20: checkcast 44	java/net/HttpURLConnection
    //   23: astore 4
    //   25: aload 4
    //   27: ldc 46
    //   29: invokevirtual 49	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   32: aload 4
    //   34: aload_0
    //   35: getfield 20	com/tencent/av/HttpHelper/HttpHelper$1:val$timeout	I
    //   38: invokevirtual 53	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   41: aload 4
    //   43: aload_0
    //   44: getfield 20	com/tencent/av/HttpHelper/HttpHelper$1:val$timeout	I
    //   47: invokevirtual 56	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   50: aload 4
    //   52: invokevirtual 59	java/net/HttpURLConnection:connect	()V
    //   55: aload 4
    //   57: invokevirtual 63	java/net/HttpURLConnection:getResponseCode	()I
    //   60: istore_1
    //   61: iload_1
    //   62: sipush 200
    //   65: if_icmpne +158 -> 223
    //   68: new 65	java/io/BufferedInputStream
    //   71: dup
    //   72: aload 4
    //   74: invokevirtual 69	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   77: invokespecial 72	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   80: astore 7
    //   82: aload 7
    //   84: astore 5
    //   86: aload 4
    //   88: astore 6
    //   90: iload_1
    //   91: istore_2
    //   92: new 74	java/io/ByteArrayOutputStream
    //   95: dup
    //   96: sipush 10240
    //   99: invokespecial 76	java/io/ByteArrayOutputStream:<init>	(I)V
    //   102: astore 8
    //   104: aload 7
    //   106: astore 5
    //   108: aload 4
    //   110: astore 6
    //   112: iload_1
    //   113: istore_2
    //   114: sipush 1024
    //   117: newarray byte
    //   119: astore 9
    //   121: aload 7
    //   123: astore 5
    //   125: aload 4
    //   127: astore 6
    //   129: iload_1
    //   130: istore_2
    //   131: aload 7
    //   133: aload 9
    //   135: invokevirtual 82	java/io/InputStream:read	([B)I
    //   138: istore_3
    //   139: iload_3
    //   140: ifge +27 -> 167
    //   143: aload 7
    //   145: astore 5
    //   147: aload 4
    //   149: astore 6
    //   151: iload_1
    //   152: istore_2
    //   153: aload 8
    //   155: invokevirtual 86	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   158: astore 8
    //   160: aload 8
    //   162: astore 5
    //   164: goto +97 -> 261
    //   167: aload 7
    //   169: astore 5
    //   171: aload 4
    //   173: astore 6
    //   175: iload_1
    //   176: istore_2
    //   177: aload 8
    //   179: aload 9
    //   181: iconst_0
    //   182: iload_3
    //   183: invokevirtual 90	java/io/ByteArrayOutputStream:write	([BII)V
    //   186: goto -65 -> 121
    //   189: astore 8
    //   191: goto +172 -> 363
    //   194: astore 8
    //   196: goto +245 -> 441
    //   199: astore 5
    //   201: aconst_null
    //   202: astore 6
    //   204: goto +336 -> 540
    //   207: astore 8
    //   209: aconst_null
    //   210: astore 7
    //   212: goto +151 -> 363
    //   215: astore 8
    //   217: aconst_null
    //   218: astore 7
    //   220: goto +221 -> 441
    //   223: new 92	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   230: astore 6
    //   232: aload 6
    //   234: ldc 95
    //   236: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 6
    //   242: iload_1
    //   243: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 104
    //   249: aload 6
    //   251: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 114	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: aconst_null
    //   259: astore 7
    //   261: aload 7
    //   263: ifnull +18 -> 281
    //   266: aload 7
    //   268: invokevirtual 117	java/io/InputStream:close	()V
    //   271: goto +10 -> 281
    //   274: astore 6
    //   276: aload 6
    //   278: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   281: aload 4
    //   283: ifnull +8 -> 291
    //   286: aload 4
    //   288: invokevirtual 123	java/net/HttpURLConnection:disconnect	()V
    //   291: aload_0
    //   292: getfield 22	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   295: astore 4
    //   297: aload 4
    //   299: ifnull +224 -> 523
    //   302: aload 4
    //   304: aload_0
    //   305: getfield 18	com/tencent/av/HttpHelper/HttpHelper$1:val$url	Ljava/lang/String;
    //   308: iload_1
    //   309: aload 5
    //   311: aload_0
    //   312: getfield 24	com/tencent/av/HttpHelper/HttpHelper$1:val$param	Ljava/lang/Object;
    //   315: invokeinterface 129 5 0
    //   320: return
    //   321: astore 5
    //   323: goto +18 -> 341
    //   326: astore 8
    //   328: goto +28 -> 356
    //   331: astore 8
    //   333: goto +101 -> 434
    //   336: astore 5
    //   338: aconst_null
    //   339: astore 4
    //   341: aconst_null
    //   342: astore 6
    //   344: sipush 200
    //   347: istore_1
    //   348: goto +192 -> 540
    //   351: astore 8
    //   353: aconst_null
    //   354: astore 4
    //   356: aconst_null
    //   357: astore 7
    //   359: sipush 200
    //   362: istore_1
    //   363: aload 7
    //   365: astore 5
    //   367: aload 4
    //   369: astore 6
    //   371: iload_1
    //   372: istore_2
    //   373: ldc 104
    //   375: ldc 131
    //   377: aload 8
    //   379: invokestatic 134	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   382: pop
    //   383: iconst_m1
    //   384: istore_1
    //   385: aload 7
    //   387: ifnull +18 -> 405
    //   390: aload 7
    //   392: invokevirtual 117	java/io/InputStream:close	()V
    //   395: goto +10 -> 405
    //   398: astore 5
    //   400: aload 5
    //   402: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   405: aload 4
    //   407: ifnull +8 -> 415
    //   410: aload 4
    //   412: invokevirtual 123	java/net/HttpURLConnection:disconnect	()V
    //   415: aload_0
    //   416: getfield 22	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   419: astore 4
    //   421: aload 4
    //   423: ifnull +100 -> 523
    //   426: goto +80 -> 506
    //   429: astore 8
    //   431: aconst_null
    //   432: astore 4
    //   434: aconst_null
    //   435: astore 7
    //   437: sipush 200
    //   440: istore_1
    //   441: aload 7
    //   443: astore 5
    //   445: aload 4
    //   447: astore 6
    //   449: iload_1
    //   450: istore_2
    //   451: ldc 104
    //   453: ldc 131
    //   455: aload 8
    //   457: invokestatic 134	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   460: pop
    //   461: sipush 404
    //   464: istore_1
    //   465: aload 7
    //   467: ifnull +18 -> 485
    //   470: aload 7
    //   472: invokevirtual 117	java/io/InputStream:close	()V
    //   475: goto +10 -> 485
    //   478: astore 5
    //   480: aload 5
    //   482: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   485: aload 4
    //   487: ifnull +8 -> 495
    //   490: aload 4
    //   492: invokevirtual 123	java/net/HttpURLConnection:disconnect	()V
    //   495: aload_0
    //   496: getfield 22	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   499: astore 4
    //   501: aload 4
    //   503: ifnull +20 -> 523
    //   506: aload 4
    //   508: aload_0
    //   509: getfield 18	com/tencent/av/HttpHelper/HttpHelper$1:val$url	Ljava/lang/String;
    //   512: iload_1
    //   513: aconst_null
    //   514: aload_0
    //   515: getfield 24	com/tencent/av/HttpHelper/HttpHelper$1:val$param	Ljava/lang/Object;
    //   518: invokeinterface 129 5 0
    //   523: return
    //   524: astore 7
    //   526: iload_2
    //   527: istore_1
    //   528: aload 6
    //   530: astore 4
    //   532: aload 5
    //   534: astore 6
    //   536: aload 7
    //   538: astore 5
    //   540: aload 6
    //   542: ifnull +18 -> 560
    //   545: aload 6
    //   547: invokevirtual 117	java/io/InputStream:close	()V
    //   550: goto +10 -> 560
    //   553: astore 6
    //   555: aload 6
    //   557: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   560: aload 4
    //   562: ifnull +8 -> 570
    //   565: aload 4
    //   567: invokevirtual 123	java/net/HttpURLConnection:disconnect	()V
    //   570: aload_0
    //   571: getfield 22	com/tencent/av/HttpHelper/HttpHelper$1:val$listener	Lcom/tencent/av/HttpHelper/HttpHelper$HttpRequestListener;
    //   574: astore 4
    //   576: aload 4
    //   578: ifnull +20 -> 598
    //   581: aload 4
    //   583: aload_0
    //   584: getfield 18	com/tencent/av/HttpHelper/HttpHelper$1:val$url	Ljava/lang/String;
    //   587: iload_1
    //   588: aconst_null
    //   589: aload_0
    //   590: getfield 24	com/tencent/av/HttpHelper/HttpHelper$1:val$param	Ljava/lang/Object;
    //   593: invokeinterface 129 5 0
    //   598: goto +6 -> 604
    //   601: aload 5
    //   603: athrow
    //   604: goto -3 -> 601
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	this	1
    //   60	528	1	i	int
    //   91	436	2	j	int
    //   138	45	3	k	int
    //   23	559	4	localObject1	Object
    //   1	169	5	localObject2	Object
    //   199	111	5	arrayOfByte1	byte[]
    //   321	1	5	localObject3	Object
    //   336	1	5	localObject4	Object
    //   365	1	5	localObject5	Object
    //   398	3	5	localIOException1	java.io.IOException
    //   443	1	5	localObject6	Object
    //   478	55	5	localIOException2	java.io.IOException
    //   538	64	5	localObject7	Object
    //   88	162	6	localObject8	Object
    //   274	3	6	localIOException3	java.io.IOException
    //   342	204	6	localObject9	Object
    //   553	3	6	localIOException4	java.io.IOException
    //   80	391	7	localBufferedInputStream	java.io.BufferedInputStream
    //   524	13	7	localObject10	Object
    //   102	76	8	localObject11	Object
    //   189	1	8	localIOException5	java.io.IOException
    //   194	1	8	localUnknownHostException1	java.net.UnknownHostException
    //   207	1	8	localIOException6	java.io.IOException
    //   215	1	8	localUnknownHostException2	java.net.UnknownHostException
    //   326	1	8	localIOException7	java.io.IOException
    //   331	1	8	localUnknownHostException3	java.net.UnknownHostException
    //   351	27	8	localIOException8	java.io.IOException
    //   429	27	8	localUnknownHostException4	java.net.UnknownHostException
    //   119	61	9	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   92	104	189	java/io/IOException
    //   114	121	189	java/io/IOException
    //   131	139	189	java/io/IOException
    //   153	160	189	java/io/IOException
    //   177	186	189	java/io/IOException
    //   92	104	194	java/net/UnknownHostException
    //   114	121	194	java/net/UnknownHostException
    //   131	139	194	java/net/UnknownHostException
    //   153	160	194	java/net/UnknownHostException
    //   177	186	194	java/net/UnknownHostException
    //   68	82	199	finally
    //   223	258	199	finally
    //   68	82	207	java/io/IOException
    //   223	258	207	java/io/IOException
    //   68	82	215	java/net/UnknownHostException
    //   223	258	215	java/net/UnknownHostException
    //   266	271	274	java/io/IOException
    //   25	61	321	finally
    //   25	61	326	java/io/IOException
    //   25	61	331	java/net/UnknownHostException
    //   3	25	336	finally
    //   3	25	351	java/io/IOException
    //   390	395	398	java/io/IOException
    //   3	25	429	java/net/UnknownHostException
    //   470	475	478	java/io/IOException
    //   92	104	524	finally
    //   114	121	524	finally
    //   131	139	524	finally
    //   153	160	524	finally
    //   177	186	524	finally
    //   373	383	524	finally
    //   451	461	524	finally
    //   545	550	553	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.HttpHelper.HttpHelper.1
 * JD-Core Version:    0.7.0.1
 */