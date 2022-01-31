package com.tencent.mm.opensdk.diffdev.a;

public final class e
{
  /* Error */
  public static byte[] a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 20	java/lang/String:length	()I
    //   8: ifne +12 -> 20
    //   11: ldc 22
    //   13: ldc 24
    //   15: invokestatic 30	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aconst_null
    //   19: areturn
    //   20: new 32	java/net/URL
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 40	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   31: checkcast 42	java/net/HttpURLConnection
    //   34: astore_0
    //   35: aload_0
    //   36: ifnonnull +20 -> 56
    //   39: ldc 22
    //   41: ldc 44
    //   43: invokestatic 30	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: ifnull +7 -> 54
    //   50: aload_0
    //   51: invokevirtual 48	java/net/HttpURLConnection:disconnect	()V
    //   54: aconst_null
    //   55: areturn
    //   56: aload_0
    //   57: ldc 50
    //   59: invokevirtual 53	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: ldc 54
    //   65: invokevirtual 58	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   68: aload_0
    //   69: ldc 54
    //   71: invokevirtual 61	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   74: aload_0
    //   75: invokevirtual 64	java/net/HttpURLConnection:getResponseCode	()I
    //   78: sipush 300
    //   81: if_icmplt +20 -> 101
    //   84: ldc 22
    //   86: ldc 66
    //   88: invokestatic 30	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 48	java/net/HttpURLConnection:disconnect	()V
    //   99: aconst_null
    //   100: areturn
    //   101: aload_0
    //   102: invokevirtual 70	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   105: astore_2
    //   106: new 72	java/io/ByteArrayOutputStream
    //   109: dup
    //   110: invokespecial 74	java/io/ByteArrayOutputStream:<init>	()V
    //   113: astore 4
    //   115: sipush 1024
    //   118: newarray byte
    //   120: astore_3
    //   121: aload_2
    //   122: aload_3
    //   123: invokevirtual 80	java/io/InputStream:read	([B)I
    //   126: istore_1
    //   127: iload_1
    //   128: iconst_m1
    //   129: if_icmpeq +76 -> 205
    //   132: aload 4
    //   134: aload_3
    //   135: iconst_0
    //   136: iload_1
    //   137: invokevirtual 84	java/io/ByteArrayOutputStream:write	([BII)V
    //   140: goto -19 -> 121
    //   143: astore 5
    //   145: aload_0
    //   146: astore_3
    //   147: aload 4
    //   149: astore_0
    //   150: aload 5
    //   152: astore 4
    //   154: ldc 22
    //   156: new 86	java/lang/StringBuilder
    //   159: dup
    //   160: ldc 88
    //   162: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: aload 4
    //   167: invokevirtual 93	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   170: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 30	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 48	java/net/HttpURLConnection:disconnect	()V
    //   187: aload_2
    //   188: ifnull +7 -> 195
    //   191: aload_2
    //   192: invokevirtual 103	java/io/InputStream:close	()V
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   203: aconst_null
    //   204: areturn
    //   205: aload 4
    //   207: invokevirtual 108	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   210: astore_3
    //   211: ldc 22
    //   213: ldc 110
    //   215: invokestatic 113	com/tencent/mm/opensdk/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: ifnull +7 -> 226
    //   222: aload_0
    //   223: invokevirtual 48	java/net/HttpURLConnection:disconnect	()V
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 103	java/io/InputStream:close	()V
    //   234: aload 4
    //   236: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   239: aload_3
    //   240: areturn
    //   241: astore 5
    //   243: aconst_null
    //   244: astore_3
    //   245: aconst_null
    //   246: astore_2
    //   247: aconst_null
    //   248: astore_0
    //   249: aload_0
    //   250: astore 7
    //   252: aload_3
    //   253: astore 4
    //   255: aload_2
    //   256: astore 6
    //   258: ldc 22
    //   260: new 86	java/lang/StringBuilder
    //   263: dup
    //   264: ldc 88
    //   266: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   269: aload 5
    //   271: invokevirtual 114	java/io/IOException:getMessage	()Ljava/lang/String;
    //   274: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 30	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_0
    //   284: ifnull +7 -> 291
    //   287: aload_0
    //   288: invokevirtual 48	java/net/HttpURLConnection:disconnect	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 103	java/io/InputStream:close	()V
    //   299: aload_3
    //   300: ifnull +7 -> 307
    //   303: aload_3
    //   304: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   307: aconst_null
    //   308: areturn
    //   309: astore 5
    //   311: aconst_null
    //   312: astore_3
    //   313: aconst_null
    //   314: astore_2
    //   315: aconst_null
    //   316: astore_0
    //   317: aload_0
    //   318: astore 7
    //   320: aload_3
    //   321: astore 4
    //   323: aload_2
    //   324: astore 6
    //   326: ldc 22
    //   328: new 86	java/lang/StringBuilder
    //   331: dup
    //   332: ldc 88
    //   334: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: aload 5
    //   339: invokevirtual 115	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   342: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 30	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload_0
    //   352: ifnull +7 -> 359
    //   355: aload_0
    //   356: invokevirtual 48	java/net/HttpURLConnection:disconnect	()V
    //   359: aload_2
    //   360: ifnull +7 -> 367
    //   363: aload_2
    //   364: invokevirtual 103	java/io/InputStream:close	()V
    //   367: aload_3
    //   368: ifnull +7 -> 375
    //   371: aload_3
    //   372: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   375: aconst_null
    //   376: areturn
    //   377: astore_0
    //   378: aconst_null
    //   379: astore 4
    //   381: aconst_null
    //   382: astore_2
    //   383: aconst_null
    //   384: astore_3
    //   385: aload_3
    //   386: ifnull +7 -> 393
    //   389: aload_3
    //   390: invokevirtual 48	java/net/HttpURLConnection:disconnect	()V
    //   393: aload_2
    //   394: ifnull +7 -> 401
    //   397: aload_2
    //   398: invokevirtual 103	java/io/InputStream:close	()V
    //   401: aload 4
    //   403: ifnull +8 -> 411
    //   406: aload 4
    //   408: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   411: aload_0
    //   412: athrow
    //   413: astore_0
    //   414: goto -360 -> 54
    //   417: astore_0
    //   418: goto -319 -> 99
    //   421: astore_0
    //   422: goto -196 -> 226
    //   425: astore_0
    //   426: goto -192 -> 234
    //   429: astore_0
    //   430: goto -191 -> 239
    //   433: astore_3
    //   434: goto -247 -> 187
    //   437: astore_2
    //   438: goto -243 -> 195
    //   441: astore_0
    //   442: goto -239 -> 203
    //   445: astore_0
    //   446: goto -155 -> 291
    //   449: astore_0
    //   450: goto -151 -> 299
    //   453: astore_0
    //   454: goto -147 -> 307
    //   457: astore_0
    //   458: goto -99 -> 359
    //   461: astore_0
    //   462: goto -95 -> 367
    //   465: astore_0
    //   466: goto -91 -> 375
    //   469: astore_3
    //   470: goto -77 -> 393
    //   473: astore_2
    //   474: goto -73 -> 401
    //   477: astore_2
    //   478: goto -67 -> 411
    //   481: astore 5
    //   483: aconst_null
    //   484: astore 4
    //   486: aconst_null
    //   487: astore_2
    //   488: aload_0
    //   489: astore_3
    //   490: aload 5
    //   492: astore_0
    //   493: goto -108 -> 385
    //   496: astore 5
    //   498: aconst_null
    //   499: astore 4
    //   501: aload_0
    //   502: astore_3
    //   503: aload 5
    //   505: astore_0
    //   506: goto -121 -> 385
    //   509: astore 5
    //   511: aload_0
    //   512: astore_3
    //   513: aload 5
    //   515: astore_0
    //   516: goto -131 -> 385
    //   519: astore 5
    //   521: aload_0
    //   522: astore 4
    //   524: aload 5
    //   526: astore_0
    //   527: goto -142 -> 385
    //   530: astore_0
    //   531: aload 7
    //   533: astore_3
    //   534: aload 6
    //   536: astore_2
    //   537: goto -152 -> 385
    //   540: astore 5
    //   542: aconst_null
    //   543: astore_3
    //   544: aconst_null
    //   545: astore_2
    //   546: goto -229 -> 317
    //   549: astore 5
    //   551: aconst_null
    //   552: astore_3
    //   553: goto -236 -> 317
    //   556: astore 5
    //   558: aload 4
    //   560: astore_3
    //   561: goto -244 -> 317
    //   564: astore 5
    //   566: aconst_null
    //   567: astore_3
    //   568: aconst_null
    //   569: astore_2
    //   570: goto -321 -> 249
    //   573: astore 5
    //   575: aconst_null
    //   576: astore_3
    //   577: goto -328 -> 249
    //   580: astore 5
    //   582: aload 4
    //   584: astore_3
    //   585: goto -336 -> 249
    //   588: astore 4
    //   590: aconst_null
    //   591: astore_0
    //   592: aconst_null
    //   593: astore_2
    //   594: aconst_null
    //   595: astore_3
    //   596: goto -442 -> 154
    //   599: astore 4
    //   601: aconst_null
    //   602: astore_2
    //   603: aload_0
    //   604: astore_3
    //   605: aconst_null
    //   606: astore_0
    //   607: goto -453 -> 154
    //   610: astore 4
    //   612: aload_0
    //   613: astore_3
    //   614: aconst_null
    //   615: astore_0
    //   616: goto -462 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	paramString	java.lang.String
    //   126	11	1	i	int
    //   105	293	2	localInputStream1	java.io.InputStream
    //   437	1	2	localThrowable1	java.lang.Throwable
    //   473	1	2	localThrowable2	java.lang.Throwable
    //   477	1	2	localThrowable3	java.lang.Throwable
    //   487	116	2	localObject1	Object
    //   120	270	3	localObject2	Object
    //   433	1	3	localThrowable4	java.lang.Throwable
    //   469	1	3	localThrowable5	java.lang.Throwable
    //   489	125	3	localObject3	Object
    //   113	470	4	localObject4	Object
    //   588	1	4	localMalformedURLException1	java.net.MalformedURLException
    //   599	1	4	localMalformedURLException2	java.net.MalformedURLException
    //   610	1	4	localMalformedURLException3	java.net.MalformedURLException
    //   143	8	5	localMalformedURLException4	java.net.MalformedURLException
    //   241	29	5	localIOException1	java.io.IOException
    //   309	29	5	localException1	java.lang.Exception
    //   481	10	5	localObject5	Object
    //   496	8	5	localObject6	Object
    //   509	5	5	localObject7	Object
    //   519	6	5	localObject8	Object
    //   540	1	5	localException2	java.lang.Exception
    //   549	1	5	localException3	java.lang.Exception
    //   556	1	5	localException4	java.lang.Exception
    //   564	1	5	localIOException2	java.io.IOException
    //   573	1	5	localIOException3	java.io.IOException
    //   580	1	5	localIOException4	java.io.IOException
    //   256	279	6	localInputStream2	java.io.InputStream
    //   250	282	7	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   115	121	143	java/net/MalformedURLException
    //   121	127	143	java/net/MalformedURLException
    //   132	140	143	java/net/MalformedURLException
    //   205	218	143	java/net/MalformedURLException
    //   20	35	241	java/io/IOException
    //   20	35	309	java/lang/Exception
    //   20	35	377	finally
    //   50	54	413	java/lang/Throwable
    //   95	99	417	java/lang/Throwable
    //   222	226	421	java/lang/Throwable
    //   230	234	425	java/lang/Throwable
    //   234	239	429	java/lang/Throwable
    //   183	187	433	java/lang/Throwable
    //   191	195	437	java/lang/Throwable
    //   199	203	441	java/lang/Throwable
    //   287	291	445	java/lang/Throwable
    //   295	299	449	java/lang/Throwable
    //   303	307	453	java/lang/Throwable
    //   355	359	457	java/lang/Throwable
    //   363	367	461	java/lang/Throwable
    //   371	375	465	java/lang/Throwable
    //   389	393	469	java/lang/Throwable
    //   397	401	473	java/lang/Throwable
    //   406	411	477	java/lang/Throwable
    //   39	46	481	finally
    //   56	91	481	finally
    //   101	106	481	finally
    //   106	115	496	finally
    //   115	121	509	finally
    //   121	127	509	finally
    //   132	140	509	finally
    //   205	218	509	finally
    //   154	179	519	finally
    //   258	283	530	finally
    //   326	351	530	finally
    //   39	46	540	java/lang/Exception
    //   56	91	540	java/lang/Exception
    //   101	106	540	java/lang/Exception
    //   106	115	549	java/lang/Exception
    //   115	121	556	java/lang/Exception
    //   121	127	556	java/lang/Exception
    //   132	140	556	java/lang/Exception
    //   205	218	556	java/lang/Exception
    //   39	46	564	java/io/IOException
    //   56	91	564	java/io/IOException
    //   101	106	564	java/io/IOException
    //   106	115	573	java/io/IOException
    //   115	121	580	java/io/IOException
    //   121	127	580	java/io/IOException
    //   132	140	580	java/io/IOException
    //   205	218	580	java/io/IOException
    //   20	35	588	java/net/MalformedURLException
    //   39	46	599	java/net/MalformedURLException
    //   56	91	599	java/net/MalformedURLException
    //   101	106	599	java/net/MalformedURLException
    //   106	115	610	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.e
 * JD-Core Version:    0.7.0.1
 */