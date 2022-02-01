package com.tencent.TMG.ptt;

class TokenFetcher$4
  implements Runnable
{
  TokenFetcher$4(TokenFetcher paramTokenFetcher, String paramString1, String paramString2, TokenFetcher.HttpRequestListener paramHttpRequestListener, Object paramObject) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 38
    //   2: astore 4
    //   4: aconst_null
    //   5: astore 8
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 7
    //   13: aconst_null
    //   14: astore 9
    //   16: iconst_0
    //   17: istore_3
    //   18: iconst_0
    //   19: istore_1
    //   20: new 40	java/net/URL
    //   23: dup
    //   24: aload_0
    //   25: getfield 21	com/tencent/TMG/ptt/TokenFetcher$4:val$strUrl	Ljava/lang/String;
    //   28: invokespecial 43	java/net/URL:<init>	(Ljava/lang/String;)V
    //   31: invokevirtual 47	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   34: checkcast 49	java/net/HttpURLConnection
    //   37: astore 6
    //   39: aload 6
    //   41: sipush 5000
    //   44: invokevirtual 53	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   47: aload 6
    //   49: sipush 30000
    //   52: invokevirtual 56	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   55: aload 6
    //   57: iconst_1
    //   58: invokevirtual 60	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   61: aload 6
    //   63: iconst_1
    //   64: invokevirtual 63	java/net/HttpURLConnection:setDoInput	(Z)V
    //   67: aload 6
    //   69: iconst_0
    //   70: invokevirtual 66	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   73: aload 6
    //   75: ldc 68
    //   77: invokevirtual 71	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   80: aload 6
    //   82: ldc 73
    //   84: ldc 75
    //   86: invokevirtual 79	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: new 81	java/io/DataOutputStream
    //   92: dup
    //   93: aload 6
    //   95: invokevirtual 85	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   98: invokespecial 88	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   101: astore 5
    //   103: aload 5
    //   105: aload_0
    //   106: getfield 23	com/tencent/TMG/ptt/TokenFetcher$4:val$reqJson	Ljava/lang/String;
    //   109: invokevirtual 94	java/lang/String:getBytes	()[B
    //   112: invokevirtual 100	java/io/OutputStream:write	([B)V
    //   115: aload 5
    //   117: invokevirtual 103	java/io/OutputStream:flush	()V
    //   120: aload 6
    //   122: invokevirtual 107	java/net/HttpURLConnection:getResponseCode	()I
    //   125: istore_2
    //   126: new 109	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   133: astore 5
    //   135: aload 5
    //   137: ldc 112
    //   139: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 5
    //   145: iload_2
    //   146: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: ldc 121
    //   152: aload 5
    //   154: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 131	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   160: pop
    //   161: iload_2
    //   162: sipush 200
    //   165: if_icmpne +103 -> 268
    //   168: new 133	java/io/BufferedReader
    //   171: dup
    //   172: new 135	java/io/InputStreamReader
    //   175: dup
    //   176: aload 6
    //   178: invokevirtual 139	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   181: invokespecial 142	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   184: invokespecial 145	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   187: astore 5
    //   189: aload 5
    //   191: invokevirtual 148	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   194: astore 7
    //   196: aload 7
    //   198: ifnull +42 -> 240
    //   201: new 109	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   208: astore 8
    //   210: aload 8
    //   212: aload 4
    //   214: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 8
    //   220: aload 7
    //   222: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 8
    //   228: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 7
    //   233: aload 7
    //   235: astore 4
    //   237: goto -48 -> 189
    //   240: goto +69 -> 309
    //   243: astore 8
    //   245: aload 5
    //   247: astore 7
    //   249: aload 8
    //   251: astore 5
    //   253: iload_3
    //   254: istore_1
    //   255: goto +358 -> 613
    //   258: astore 7
    //   260: goto +110 -> 370
    //   263: astore 7
    //   265: goto +125 -> 390
    //   268: new 109	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   275: astore 5
    //   277: aload 5
    //   279: ldc 150
    //   281: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 5
    //   287: iload_2
    //   288: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc 121
    //   294: aload 5
    //   296: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 153	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   302: pop
    //   303: iload_2
    //   304: istore_1
    //   305: aload 9
    //   307: astore 5
    //   309: aload 6
    //   311: ifnull +8 -> 319
    //   314: aload 6
    //   316: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
    //   319: aload 5
    //   321: ifnull +11 -> 332
    //   324: aload 5
    //   326: invokevirtual 159	java/io/BufferedReader:close	()V
    //   329: goto +3 -> 332
    //   332: aload_0
    //   333: getfield 25	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
    //   336: astore 5
    //   338: aload 5
    //   340: ifnull +248 -> 588
    //   343: aload 5
    //   345: iload_1
    //   346: aload 4
    //   348: aload_0
    //   349: getfield 27	com/tencent/TMG/ptt/TokenFetcher$4:val$param	Ljava/lang/Object;
    //   352: invokeinterface 165 4 0
    //   357: return
    //   358: astore 5
    //   360: iload_3
    //   361: istore_1
    //   362: goto +251 -> 613
    //   365: astore 7
    //   367: aconst_null
    //   368: astore 5
    //   370: aload 6
    //   372: astore 8
    //   374: aload 7
    //   376: astore 10
    //   378: aload 5
    //   380: astore 9
    //   382: goto +38 -> 420
    //   385: astore 7
    //   387: aconst_null
    //   388: astore 5
    //   390: aload 6
    //   392: astore 8
    //   394: aload 7
    //   396: astore 10
    //   398: aload 5
    //   400: astore 9
    //   402: goto +101 -> 503
    //   405: astore 5
    //   407: aconst_null
    //   408: astore 6
    //   410: iload_3
    //   411: istore_1
    //   412: goto +201 -> 613
    //   415: astore 10
    //   417: aconst_null
    //   418: astore 9
    //   420: aload 4
    //   422: astore 5
    //   424: aload 8
    //   426: astore 7
    //   428: aload 9
    //   430: astore 6
    //   432: ldc 121
    //   434: ldc 167
    //   436: invokestatic 153	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   439: pop
    //   440: aload 4
    //   442: astore 5
    //   444: aload 8
    //   446: astore 7
    //   448: aload 9
    //   450: astore 6
    //   452: aload 10
    //   454: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   457: aload 8
    //   459: ifnull +8 -> 467
    //   462: aload 8
    //   464: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
    //   467: aload 9
    //   469: ifnull +11 -> 480
    //   472: aload 9
    //   474: invokevirtual 159	java/io/BufferedReader:close	()V
    //   477: goto +3 -> 480
    //   480: aload_0
    //   481: getfield 25	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
    //   484: astore 5
    //   486: aload 5
    //   488: ifnull +100 -> 588
    //   491: goto +83 -> 574
    //   494: astore 10
    //   496: aconst_null
    //   497: astore 9
    //   499: aload 5
    //   501: astore 8
    //   503: aload 4
    //   505: astore 5
    //   507: aload 8
    //   509: astore 7
    //   511: aload 9
    //   513: astore 6
    //   515: ldc 121
    //   517: ldc 172
    //   519: invokestatic 153	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   522: pop
    //   523: aload 4
    //   525: astore 5
    //   527: aload 8
    //   529: astore 7
    //   531: aload 9
    //   533: astore 6
    //   535: aload 10
    //   537: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   540: aload 8
    //   542: ifnull +8 -> 550
    //   545: aload 8
    //   547: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
    //   550: aload 9
    //   552: ifnull +11 -> 563
    //   555: aload 9
    //   557: invokevirtual 159	java/io/BufferedReader:close	()V
    //   560: goto +3 -> 563
    //   563: aload_0
    //   564: getfield 25	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
    //   567: astore 5
    //   569: aload 5
    //   571: ifnull +17 -> 588
    //   574: aload 5
    //   576: iconst_1
    //   577: aload 4
    //   579: aload_0
    //   580: getfield 27	com/tencent/TMG/ptt/TokenFetcher$4:val$param	Ljava/lang/Object;
    //   583: invokeinterface 165 4 0
    //   588: return
    //   589: astore 8
    //   591: aload 6
    //   593: astore 4
    //   595: iconst_1
    //   596: istore_1
    //   597: aload 7
    //   599: astore 6
    //   601: aload 4
    //   603: astore 7
    //   605: aload 5
    //   607: astore 4
    //   609: aload 8
    //   611: astore 5
    //   613: aload 6
    //   615: ifnull +8 -> 623
    //   618: aload 6
    //   620: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
    //   623: aload 7
    //   625: ifnull +11 -> 636
    //   628: aload 7
    //   630: invokevirtual 159	java/io/BufferedReader:close	()V
    //   633: goto +3 -> 636
    //   636: aload_0
    //   637: getfield 25	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
    //   640: astore 6
    //   642: aload 6
    //   644: ifnull +17 -> 661
    //   647: aload 6
    //   649: iload_1
    //   650: aload 4
    //   652: aload_0
    //   653: getfield 27	com/tencent/TMG/ptt/TokenFetcher$4:val$param	Ljava/lang/Object;
    //   656: invokeinterface 165 4 0
    //   661: goto +6 -> 667
    //   664: aload 5
    //   666: athrow
    //   667: goto -3 -> 664
    //   670: astore 5
    //   672: goto -340 -> 332
    //   675: astore 5
    //   677: goto -197 -> 480
    //   680: astore 5
    //   682: goto -119 -> 563
    //   685: astore 6
    //   687: goto -51 -> 636
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	690	0	this	4
    //   19	631	1	i	int
    //   125	179	2	j	int
    //   17	394	3	k	int
    //   2	649	4	localObject1	Object
    //   8	336	5	localObject2	Object
    //   358	1	5	localObject3	Object
    //   368	31	5	localObject4	Object
    //   405	1	5	localObject5	Object
    //   422	243	5	localObject6	Object
    //   670	1	5	localIOException1	java.io.IOException
    //   675	1	5	localIOException2	java.io.IOException
    //   680	1	5	localIOException3	java.io.IOException
    //   37	611	6	localObject7	Object
    //   685	1	6	localIOException4	java.io.IOException
    //   11	237	7	localObject8	Object
    //   258	1	7	localException1	java.lang.Exception
    //   263	1	7	localIOException5	java.io.IOException
    //   365	10	7	localException2	java.lang.Exception
    //   385	10	7	localIOException6	java.io.IOException
    //   426	203	7	localObject9	Object
    //   5	222	8	localStringBuilder	java.lang.StringBuilder
    //   243	7	8	localObject10	Object
    //   372	174	8	localObject11	Object
    //   589	21	8	localObject12	Object
    //   14	542	9	localObject13	Object
    //   376	21	10	localObject14	Object
    //   415	38	10	localException3	java.lang.Exception
    //   494	42	10	localIOException7	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   189	196	243	finally
    //   201	233	243	finally
    //   189	196	258	java/lang/Exception
    //   201	233	258	java/lang/Exception
    //   189	196	263	java/io/IOException
    //   201	233	263	java/io/IOException
    //   39	161	358	finally
    //   168	189	358	finally
    //   268	303	358	finally
    //   39	161	365	java/lang/Exception
    //   168	189	365	java/lang/Exception
    //   268	303	365	java/lang/Exception
    //   39	161	385	java/io/IOException
    //   168	189	385	java/io/IOException
    //   268	303	385	java/io/IOException
    //   20	39	405	finally
    //   20	39	415	java/lang/Exception
    //   20	39	494	java/io/IOException
    //   432	440	589	finally
    //   452	457	589	finally
    //   515	523	589	finally
    //   535	540	589	finally
    //   324	329	670	java/io/IOException
    //   472	477	675	java/io/IOException
    //   555	560	680	java/io/IOException
    //   628	633	685	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher.4
 * JD-Core Version:    0.7.0.1
 */