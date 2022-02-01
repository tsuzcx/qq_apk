package com.tencent.hippy.qq.update;

public class HttpClient
{
  /* Error */
  public static java.lang.String doGet(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 18	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 21	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 25	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 27	java/net/HttpURLConnection
    //   19: astore_0
    //   20: aload_0
    //   21: ldc 29
    //   23: invokevirtual 32	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: sipush 15000
    //   30: invokevirtual 36	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   33: aload_0
    //   34: ldc 37
    //   36: invokevirtual 40	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   39: aload_0
    //   40: invokevirtual 43	java/net/HttpURLConnection:connect	()V
    //   43: aload_0
    //   44: invokevirtual 47	java/net/HttpURLConnection:getResponseCode	()I
    //   47: sipush 200
    //   50: if_icmpne +412 -> 462
    //   53: aload_0
    //   54: invokevirtual 51	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   57: astore_1
    //   58: new 53	java/io/BufferedReader
    //   61: dup
    //   62: new 55	java/io/InputStreamReader
    //   65: dup
    //   66: aload_1
    //   67: ldc 57
    //   69: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   72: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   75: astore_3
    //   76: new 65	java/lang/StringBuffer
    //   79: dup
    //   80: invokespecial 66	java/lang/StringBuffer:<init>	()V
    //   83: astore_2
    //   84: aload_3
    //   85: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   88: astore 4
    //   90: aload 4
    //   92: ifnull +61 -> 153
    //   95: aload_2
    //   96: aload 4
    //   98: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   101: pop
    //   102: aload_2
    //   103: ldc 76
    //   105: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   108: pop
    //   109: goto -25 -> 84
    //   112: astore 4
    //   114: aload_0
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: aload_3
    //   119: astore_1
    //   120: aload 4
    //   122: astore_3
    //   123: aload_3
    //   124: invokevirtual 79	java/net/MalformedURLException:printStackTrace	()V
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 82	java/io/BufferedReader:close	()V
    //   135: aload_0
    //   136: ifnull +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 85	java/io/InputStream:close	()V
    //   143: aload_2
    //   144: ifnull +314 -> 458
    //   147: aload_2
    //   148: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   151: aconst_null
    //   152: areturn
    //   153: aload_2
    //   154: invokevirtual 91	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   157: astore 4
    //   159: aload_1
    //   160: astore_2
    //   161: aload 4
    //   163: astore_1
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 82	java/io/BufferedReader:close	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 85	java/io/InputStream:close	()V
    //   180: aload_0
    //   181: ifnull +279 -> 460
    //   184: aload_0
    //   185: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   188: aload_1
    //   189: areturn
    //   190: astore_3
    //   191: aload_3
    //   192: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   195: goto -23 -> 172
    //   198: astore_2
    //   199: aload_2
    //   200: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   203: goto -23 -> 180
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   211: goto -76 -> 135
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   219: goto -76 -> 143
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_2
    //   230: aload 4
    //   232: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   235: aload_0
    //   236: ifnull +7 -> 243
    //   239: aload_0
    //   240: invokevirtual 82	java/io/BufferedReader:close	()V
    //   243: aload_1
    //   244: ifnull +7 -> 251
    //   247: aload_1
    //   248: invokevirtual 85	java/io/InputStream:close	()V
    //   251: aload_2
    //   252: ifnull +206 -> 458
    //   255: aload_2
    //   256: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   266: goto -23 -> 243
    //   269: astore_0
    //   270: aload_0
    //   271: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   274: goto -23 -> 251
    //   277: astore_0
    //   278: aconst_null
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_2
    //   282: aload 4
    //   284: astore_3
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 82	java/io/BufferedReader:close	()V
    //   293: aload_1
    //   294: ifnull +7 -> 301
    //   297: aload_1
    //   298: invokevirtual 85	java/io/InputStream:close	()V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_3
    //   312: aload_3
    //   313: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   316: goto -23 -> 293
    //   319: astore_1
    //   320: aload_1
    //   321: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   324: goto -23 -> 301
    //   327: astore_3
    //   328: aconst_null
    //   329: astore_1
    //   330: aload_0
    //   331: astore_2
    //   332: aload_3
    //   333: astore_0
    //   334: aload 4
    //   336: astore_3
    //   337: goto -52 -> 285
    //   340: astore_3
    //   341: aload_0
    //   342: astore_2
    //   343: aload_3
    //   344: astore_0
    //   345: aload 4
    //   347: astore_3
    //   348: goto -63 -> 285
    //   351: astore 4
    //   353: aload_0
    //   354: astore_2
    //   355: aload 4
    //   357: astore_0
    //   358: goto -73 -> 285
    //   361: astore_3
    //   362: aload_0
    //   363: astore 4
    //   365: aload_3
    //   366: astore_0
    //   367: aload_1
    //   368: astore_3
    //   369: aload 4
    //   371: astore_1
    //   372: goto -87 -> 285
    //   375: astore 4
    //   377: aload_0
    //   378: astore_3
    //   379: aload 4
    //   381: astore_0
    //   382: goto -97 -> 285
    //   385: astore 4
    //   387: aconst_null
    //   388: astore_3
    //   389: aconst_null
    //   390: astore_1
    //   391: aload_0
    //   392: astore_2
    //   393: aload_3
    //   394: astore_0
    //   395: goto -165 -> 230
    //   398: astore 4
    //   400: aconst_null
    //   401: astore_3
    //   402: aload_0
    //   403: astore_2
    //   404: aload_3
    //   405: astore_0
    //   406: goto -176 -> 230
    //   409: astore 4
    //   411: aload_0
    //   412: astore_2
    //   413: aload_3
    //   414: astore_0
    //   415: goto -185 -> 230
    //   418: astore_3
    //   419: aconst_null
    //   420: astore_1
    //   421: aconst_null
    //   422: astore_0
    //   423: aconst_null
    //   424: astore_2
    //   425: goto -302 -> 123
    //   428: astore_3
    //   429: aconst_null
    //   430: astore 4
    //   432: aload_0
    //   433: astore_2
    //   434: aconst_null
    //   435: astore_1
    //   436: aload 4
    //   438: astore_0
    //   439: goto -316 -> 123
    //   442: astore_3
    //   443: aload_1
    //   444: astore_2
    //   445: aload_0
    //   446: astore 4
    //   448: aconst_null
    //   449: astore_1
    //   450: aload_2
    //   451: astore_0
    //   452: aload 4
    //   454: astore_2
    //   455: goto -332 -> 123
    //   458: aconst_null
    //   459: areturn
    //   460: aload_1
    //   461: areturn
    //   462: aconst_null
    //   463: astore_3
    //   464: aconst_null
    //   465: astore_2
    //   466: goto -302 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	paramString	java.lang.String
    //   4	185	1	localObject1	Object
    //   206	2	1	localIOException1	java.io.IOException
    //   227	71	1	localObject2	Object
    //   319	2	1	localIOException2	java.io.IOException
    //   329	132	1	str1	java.lang.String
    //   83	94	2	localObject3	Object
    //   198	2	2	localIOException3	java.io.IOException
    //   229	237	2	str2	java.lang.String
    //   75	94	3	localObject4	Object
    //   190	2	3	localIOException4	java.io.IOException
    //   284	6	3	localIOException5	java.io.IOException
    //   311	2	3	localIOException6	java.io.IOException
    //   327	6	3	localObject5	Object
    //   336	1	3	localIOException7	java.io.IOException
    //   340	4	3	localObject6	Object
    //   347	1	3	localIOException8	java.io.IOException
    //   361	5	3	localObject7	Object
    //   368	46	3	str3	java.lang.String
    //   418	1	3	localMalformedURLException1	java.net.MalformedURLException
    //   428	1	3	localMalformedURLException2	java.net.MalformedURLException
    //   442	1	3	localMalformedURLException3	java.net.MalformedURLException
    //   463	1	3	localObject8	Object
    //   1	96	4	str4	java.lang.String
    //   112	9	4	localMalformedURLException4	java.net.MalformedURLException
    //   157	5	4	str5	java.lang.String
    //   222	124	4	localIOException9	java.io.IOException
    //   351	5	4	localObject9	Object
    //   363	7	4	str6	java.lang.String
    //   375	5	4	localObject10	Object
    //   385	1	4	localIOException10	java.io.IOException
    //   398	1	4	localIOException11	java.io.IOException
    //   409	1	4	localIOException12	java.io.IOException
    //   430	23	4	str7	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   76	84	112	java/net/MalformedURLException
    //   84	90	112	java/net/MalformedURLException
    //   95	109	112	java/net/MalformedURLException
    //   153	159	112	java/net/MalformedURLException
    //   168	172	190	java/io/IOException
    //   176	180	198	java/io/IOException
    //   131	135	206	java/io/IOException
    //   139	143	214	java/io/IOException
    //   5	20	222	java/io/IOException
    //   239	243	261	java/io/IOException
    //   247	251	269	java/io/IOException
    //   5	20	277	finally
    //   289	293	311	java/io/IOException
    //   297	301	319	java/io/IOException
    //   20	58	327	finally
    //   58	76	340	finally
    //   76	84	351	finally
    //   84	90	351	finally
    //   95	109	351	finally
    //   153	159	351	finally
    //   123	127	361	finally
    //   230	235	375	finally
    //   20	58	385	java/io/IOException
    //   58	76	398	java/io/IOException
    //   76	84	409	java/io/IOException
    //   84	90	409	java/io/IOException
    //   95	109	409	java/io/IOException
    //   153	159	409	java/io/IOException
    //   5	20	418	java/net/MalformedURLException
    //   20	58	428	java/net/MalformedURLException
    //   58	76	442	java/net/MalformedURLException
  }
  
  /* Error */
  public static java.lang.String doPost(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, HippyQQUpdateManager.PackageUpdateListener paramPackageUpdateListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 18	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 21	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 25	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 27	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc 96
    //   24: invokevirtual 32	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: sipush 15000
    //   31: invokevirtual 36	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   34: aload_0
    //   35: ldc 37
    //   37: invokevirtual 40	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   40: aload_0
    //   41: iconst_1
    //   42: invokevirtual 100	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   45: aload_0
    //   46: iconst_1
    //   47: invokevirtual 103	java/net/HttpURLConnection:setDoInput	(Z)V
    //   50: aload_2
    //   51: ifnull +17 -> 68
    //   54: aload_2
    //   55: invokevirtual 108	java/lang/String:length	()I
    //   58: ifle +10 -> 68
    //   61: aload_0
    //   62: ldc 110
    //   64: aload_2
    //   65: invokevirtual 114	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: ldc 116
    //   71: ldc 118
    //   73: invokevirtual 114	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: invokevirtual 122	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   80: astore_2
    //   81: aload_2
    //   82: aload_1
    //   83: ldc 124
    //   85: invokevirtual 128	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   88: invokevirtual 134	java/io/OutputStream:write	([B)V
    //   91: aload_0
    //   92: invokevirtual 47	java/net/HttpURLConnection:getResponseCode	()I
    //   95: istore 4
    //   97: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +29 -> 129
    //   103: ldc 142
    //   105: iconst_2
    //   106: new 144	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   113: ldc 147
    //   115: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 4
    //   120: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload 4
    //   131: sipush 200
    //   134: if_icmpne +206 -> 340
    //   137: aload_0
    //   138: invokevirtual 51	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   141: astore_3
    //   142: new 53	java/io/BufferedReader
    //   145: dup
    //   146: new 55	java/io/InputStreamReader
    //   149: dup
    //   150: aload_3
    //   151: ldc 57
    //   153: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   156: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   159: astore 6
    //   161: new 65	java/lang/StringBuffer
    //   164: dup
    //   165: invokespecial 66	java/lang/StringBuffer:<init>	()V
    //   168: astore_1
    //   169: aload 6
    //   171: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: ifnull +121 -> 299
    //   181: aload_1
    //   182: aload 5
    //   184: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   187: pop
    //   188: aload_1
    //   189: ldc 76
    //   191: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   194: pop
    //   195: goto -26 -> 169
    //   198: astore 7
    //   200: aload 6
    //   202: astore_1
    //   203: aload_2
    //   204: astore 5
    //   206: aload_3
    //   207: astore_2
    //   208: aload 7
    //   210: astore 6
    //   212: aload_0
    //   213: astore_3
    //   214: aload 5
    //   216: astore_0
    //   217: aload 6
    //   219: astore 5
    //   221: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +41 -> 265
    //   227: aload 5
    //   229: ifnull +185 -> 414
    //   232: aload 5
    //   234: invokevirtual 161	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   237: astore 5
    //   239: ldc 142
    //   241: iconst_2
    //   242: new 144	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   249: ldc 163
    //   251: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload 5
    //   256: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 82	java/io/BufferedReader:close	()V
    //   273: aload_0
    //   274: ifnull +7 -> 281
    //   277: aload_0
    //   278: invokevirtual 164	java/io/OutputStream:close	()V
    //   281: aload_2
    //   282: ifnull +7 -> 289
    //   285: aload_2
    //   286: invokevirtual 85	java/io/InputStream:close	()V
    //   289: aload_3
    //   290: ifnull +544 -> 834
    //   293: aload_3
    //   294: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   297: aconst_null
    //   298: areturn
    //   299: aload_1
    //   300: invokevirtual 91	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   303: astore_1
    //   304: aload 6
    //   306: ifnull +8 -> 314
    //   309: aload 6
    //   311: invokevirtual 82	java/io/BufferedReader:close	()V
    //   314: aload_2
    //   315: ifnull +7 -> 322
    //   318: aload_2
    //   319: invokevirtual 164	java/io/OutputStream:close	()V
    //   322: aload_3
    //   323: ifnull +7 -> 330
    //   326: aload_3
    //   327: invokevirtual 85	java/io/InputStream:close	()V
    //   330: aload_0
    //   331: ifnull +505 -> 836
    //   334: aload_0
    //   335: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   338: aload_1
    //   339: areturn
    //   340: aload_3
    //   341: ifnull +32 -> 373
    //   344: aload_3
    //   345: bipush 250
    //   347: new 144	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   354: ldc 166
    //   356: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: iload 4
    //   361: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: aconst_null
    //   368: invokeinterface 172 4 0
    //   373: aconst_null
    //   374: astore 5
    //   376: aconst_null
    //   377: astore_3
    //   378: aload 6
    //   380: astore_1
    //   381: aload 5
    //   383: astore 6
    //   385: goto -81 -> 304
    //   388: astore 5
    //   390: aload 5
    //   392: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   395: goto -81 -> 314
    //   398: astore_2
    //   399: aload_2
    //   400: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   403: goto -81 -> 322
    //   406: astore_2
    //   407: aload_2
    //   408: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   411: goto -81 -> 330
    //   414: ldc 174
    //   416: astore 5
    //   418: goto -179 -> 239
    //   421: astore_1
    //   422: aload_1
    //   423: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   426: goto -153 -> 273
    //   429: astore_0
    //   430: aload_0
    //   431: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   434: goto -153 -> 281
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   442: goto -153 -> 289
    //   445: astore 5
    //   447: aconst_null
    //   448: astore_0
    //   449: aconst_null
    //   450: astore_2
    //   451: aconst_null
    //   452: astore_3
    //   453: aconst_null
    //   454: astore_1
    //   455: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +41 -> 499
    //   461: aload 5
    //   463: ifnull +70 -> 533
    //   466: aload 5
    //   468: invokevirtual 175	java/io/IOException:getMessage	()Ljava/lang/String;
    //   471: astore 5
    //   473: ldc 142
    //   475: iconst_2
    //   476: new 144	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   483: ldc 177
    //   485: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 5
    //   490: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: aload_0
    //   500: ifnull +7 -> 507
    //   503: aload_0
    //   504: invokevirtual 82	java/io/BufferedReader:close	()V
    //   507: aload_2
    //   508: ifnull +7 -> 515
    //   511: aload_2
    //   512: invokevirtual 164	java/io/OutputStream:close	()V
    //   515: aload_3
    //   516: ifnull +7 -> 523
    //   519: aload_3
    //   520: invokevirtual 85	java/io/InputStream:close	()V
    //   523: aload_1
    //   524: ifnull +310 -> 834
    //   527: aload_1
    //   528: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   531: aconst_null
    //   532: areturn
    //   533: ldc 174
    //   535: astore 5
    //   537: goto -64 -> 473
    //   540: astore_0
    //   541: aload_0
    //   542: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   545: goto -38 -> 507
    //   548: astore_0
    //   549: aload_0
    //   550: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   553: goto -38 -> 515
    //   556: astore_0
    //   557: aload_0
    //   558: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   561: goto -38 -> 523
    //   564: astore_0
    //   565: aconst_null
    //   566: astore_2
    //   567: aconst_null
    //   568: astore_3
    //   569: aconst_null
    //   570: astore_1
    //   571: aload 5
    //   573: ifnull +8 -> 581
    //   576: aload 5
    //   578: invokevirtual 82	java/io/BufferedReader:close	()V
    //   581: aload_2
    //   582: ifnull +7 -> 589
    //   585: aload_2
    //   586: invokevirtual 164	java/io/OutputStream:close	()V
    //   589: aload_3
    //   590: ifnull +7 -> 597
    //   593: aload_3
    //   594: invokevirtual 85	java/io/InputStream:close	()V
    //   597: aload_1
    //   598: ifnull +7 -> 605
    //   601: aload_1
    //   602: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   605: aload_0
    //   606: athrow
    //   607: astore 5
    //   609: aload 5
    //   611: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   614: goto -33 -> 581
    //   617: astore_2
    //   618: aload_2
    //   619: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   622: goto -33 -> 589
    //   625: astore_2
    //   626: aload_2
    //   627: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   630: goto -33 -> 597
    //   633: astore 6
    //   635: aconst_null
    //   636: astore_2
    //   637: aconst_null
    //   638: astore_3
    //   639: aload_0
    //   640: astore_1
    //   641: aload 6
    //   643: astore_0
    //   644: goto -73 -> 571
    //   647: astore 6
    //   649: aconst_null
    //   650: astore_3
    //   651: aload_0
    //   652: astore_1
    //   653: aload 6
    //   655: astore_0
    //   656: goto -85 -> 571
    //   659: astore 6
    //   661: aload_0
    //   662: astore_1
    //   663: aload 6
    //   665: astore_0
    //   666: goto -95 -> 571
    //   669: astore 5
    //   671: aload_0
    //   672: astore_1
    //   673: aload 5
    //   675: astore_0
    //   676: aload 6
    //   678: astore 5
    //   680: goto -109 -> 571
    //   683: astore 5
    //   685: aload_3
    //   686: astore 6
    //   688: aload_2
    //   689: astore_3
    //   690: aload_0
    //   691: astore_2
    //   692: aload 5
    //   694: astore_0
    //   695: aload_1
    //   696: astore 5
    //   698: aload 6
    //   700: astore_1
    //   701: goto -130 -> 571
    //   704: astore 6
    //   706: aload_0
    //   707: astore 5
    //   709: aload 6
    //   711: astore_0
    //   712: goto -141 -> 571
    //   715: astore 5
    //   717: aconst_null
    //   718: astore 6
    //   720: aconst_null
    //   721: astore_2
    //   722: aconst_null
    //   723: astore_3
    //   724: aload_0
    //   725: astore_1
    //   726: aload 6
    //   728: astore_0
    //   729: goto -274 -> 455
    //   732: astore 5
    //   734: aconst_null
    //   735: astore 6
    //   737: aconst_null
    //   738: astore_3
    //   739: aload_0
    //   740: astore_1
    //   741: aload 6
    //   743: astore_0
    //   744: goto -289 -> 455
    //   747: astore 5
    //   749: aconst_null
    //   750: astore 6
    //   752: aload_0
    //   753: astore_1
    //   754: aload 6
    //   756: astore_0
    //   757: goto -302 -> 455
    //   760: astore 5
    //   762: aload_0
    //   763: astore_1
    //   764: aload 6
    //   766: astore_0
    //   767: goto -312 -> 455
    //   770: astore 5
    //   772: aconst_null
    //   773: astore_1
    //   774: aconst_null
    //   775: astore_0
    //   776: aconst_null
    //   777: astore_2
    //   778: aconst_null
    //   779: astore_3
    //   780: goto -559 -> 221
    //   783: astore 5
    //   785: aconst_null
    //   786: astore 6
    //   788: aconst_null
    //   789: astore_2
    //   790: aload_0
    //   791: astore_3
    //   792: aconst_null
    //   793: astore_1
    //   794: aload 6
    //   796: astore_0
    //   797: goto -576 -> 221
    //   800: astore 5
    //   802: aload_0
    //   803: astore_3
    //   804: aconst_null
    //   805: astore 6
    //   807: aconst_null
    //   808: astore_1
    //   809: aload_2
    //   810: astore_0
    //   811: aload 6
    //   813: astore_2
    //   814: goto -593 -> 221
    //   817: astore 5
    //   819: aload_0
    //   820: astore 6
    //   822: aconst_null
    //   823: astore_1
    //   824: aload_2
    //   825: astore_0
    //   826: aload_3
    //   827: astore_2
    //   828: aload 6
    //   830: astore_3
    //   831: goto -610 -> 221
    //   834: aconst_null
    //   835: areturn
    //   836: aload_1
    //   837: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	paramString1	java.lang.String
    //   0	838	1	paramString2	java.lang.String
    //   0	838	2	paramString3	java.lang.String
    //   0	838	3	paramPackageUpdateListener	HippyQQUpdateManager.PackageUpdateListener
    //   95	265	4	i	int
    //   1	381	5	localObject1	Object
    //   388	3	5	localIOException1	java.io.IOException
    //   416	1	5	str1	java.lang.String
    //   445	22	5	localIOException2	java.io.IOException
    //   471	106	5	str2	java.lang.String
    //   607	3	5	localIOException3	java.io.IOException
    //   669	5	5	localObject2	Object
    //   678	1	5	localObject3	Object
    //   683	10	5	localObject4	Object
    //   696	12	5	str3	java.lang.String
    //   715	1	5	localIOException4	java.io.IOException
    //   732	1	5	localIOException5	java.io.IOException
    //   747	1	5	localIOException6	java.io.IOException
    //   760	1	5	localIOException7	java.io.IOException
    //   770	1	5	localMalformedURLException1	java.net.MalformedURLException
    //   783	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   800	1	5	localMalformedURLException3	java.net.MalformedURLException
    //   817	1	5	localMalformedURLException4	java.net.MalformedURLException
    //   4	380	6	localObject5	Object
    //   633	9	6	localObject6	Object
    //   647	7	6	localObject7	Object
    //   659	18	6	localObject8	Object
    //   686	13	6	localPackageUpdateListener	HippyQQUpdateManager.PackageUpdateListener
    //   704	6	6	localObject9	Object
    //   718	111	6	str4	java.lang.String
    //   198	11	7	localMalformedURLException5	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   161	169	198	java/net/MalformedURLException
    //   169	176	198	java/net/MalformedURLException
    //   181	195	198	java/net/MalformedURLException
    //   299	304	198	java/net/MalformedURLException
    //   309	314	388	java/io/IOException
    //   318	322	398	java/io/IOException
    //   326	330	406	java/io/IOException
    //   269	273	421	java/io/IOException
    //   277	281	429	java/io/IOException
    //   285	289	437	java/io/IOException
    //   6	21	445	java/io/IOException
    //   503	507	540	java/io/IOException
    //   511	515	548	java/io/IOException
    //   519	523	556	java/io/IOException
    //   6	21	564	finally
    //   576	581	607	java/io/IOException
    //   585	589	617	java/io/IOException
    //   593	597	625	java/io/IOException
    //   21	50	633	finally
    //   54	68	633	finally
    //   68	81	633	finally
    //   81	129	647	finally
    //   137	142	647	finally
    //   344	373	647	finally
    //   142	161	659	finally
    //   161	169	669	finally
    //   169	176	669	finally
    //   181	195	669	finally
    //   299	304	669	finally
    //   221	227	683	finally
    //   232	239	683	finally
    //   239	265	683	finally
    //   455	461	704	finally
    //   466	473	704	finally
    //   473	499	704	finally
    //   21	50	715	java/io/IOException
    //   54	68	715	java/io/IOException
    //   68	81	715	java/io/IOException
    //   81	129	732	java/io/IOException
    //   137	142	732	java/io/IOException
    //   344	373	732	java/io/IOException
    //   142	161	747	java/io/IOException
    //   161	169	760	java/io/IOException
    //   169	176	760	java/io/IOException
    //   181	195	760	java/io/IOException
    //   299	304	760	java/io/IOException
    //   6	21	770	java/net/MalformedURLException
    //   21	50	783	java/net/MalformedURLException
    //   54	68	783	java/net/MalformedURLException
    //   68	81	783	java/net/MalformedURLException
    //   81	129	800	java/net/MalformedURLException
    //   137	142	800	java/net/MalformedURLException
    //   344	373	800	java/net/MalformedURLException
    //   142	161	817	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HttpClient
 * JD-Core Version:    0.7.0.1
 */