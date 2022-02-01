package com.tencent.hippy.qq.update;

public class HttpClient
{
  /* Error */
  public static java.lang.String doGet(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 18	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 21	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 25	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 27	java/net/HttpURLConnection
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 29
    //   21: invokevirtual 32	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: sipush 15000
    //   28: invokevirtual 36	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   31: aload_0
    //   32: ldc 37
    //   34: invokevirtual 40	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   37: aload_0
    //   38: invokevirtual 43	java/net/HttpURLConnection:connect	()V
    //   41: aload_0
    //   42: invokevirtual 47	java/net/HttpURLConnection:getResponseCode	()I
    //   45: sipush 200
    //   48: if_icmpne +160 -> 208
    //   51: aload_0
    //   52: invokevirtual 51	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   55: astore_1
    //   56: new 53	java/io/BufferedReader
    //   59: dup
    //   60: new 55	java/io/InputStreamReader
    //   63: dup
    //   64: aload_1
    //   65: ldc 57
    //   67: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   70: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   73: astore 5
    //   75: aload_1
    //   76: astore_2
    //   77: aload 5
    //   79: astore_3
    //   80: aload_0
    //   81: astore 4
    //   83: new 65	java/lang/StringBuffer
    //   86: dup
    //   87: invokespecial 66	java/lang/StringBuffer:<init>	()V
    //   90: astore 6
    //   92: aload_1
    //   93: astore_2
    //   94: aload 5
    //   96: astore_3
    //   97: aload_0
    //   98: astore 4
    //   100: aload 5
    //   102: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: astore 7
    //   107: aload 7
    //   109: ifnull +38 -> 147
    //   112: aload_1
    //   113: astore_2
    //   114: aload 5
    //   116: astore_3
    //   117: aload_0
    //   118: astore 4
    //   120: aload 6
    //   122: aload 7
    //   124: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   127: pop
    //   128: aload_1
    //   129: astore_2
    //   130: aload 5
    //   132: astore_3
    //   133: aload_0
    //   134: astore 4
    //   136: aload 6
    //   138: ldc 76
    //   140: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   143: pop
    //   144: goto -52 -> 92
    //   147: aload_1
    //   148: astore_2
    //   149: aload 5
    //   151: astore_3
    //   152: aload_0
    //   153: astore 4
    //   155: aload 6
    //   157: invokevirtual 79	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   160: astore 6
    //   162: aload 6
    //   164: astore_2
    //   165: aload 5
    //   167: astore 4
    //   169: aload_1
    //   170: astore_3
    //   171: aload_2
    //   172: astore_1
    //   173: goto +39 -> 212
    //   176: astore 6
    //   178: goto +115 -> 293
    //   181: astore 6
    //   183: goto +173 -> 356
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_3
    //   189: goto +234 -> 423
    //   192: astore 6
    //   194: aconst_null
    //   195: astore 5
    //   197: goto +96 -> 293
    //   200: astore 6
    //   202: aconst_null
    //   203: astore 5
    //   205: goto +151 -> 356
    //   208: aconst_null
    //   209: astore_3
    //   210: aload_3
    //   211: astore_1
    //   212: aload 4
    //   214: ifnull +16 -> 230
    //   217: aload 4
    //   219: invokevirtual 82	java/io/BufferedReader:close	()V
    //   222: goto +8 -> 230
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   230: aload_3
    //   231: ifnull +15 -> 246
    //   234: aload_3
    //   235: invokevirtual 88	java/io/InputStream:close	()V
    //   238: goto +8 -> 246
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   246: aload_0
    //   247: ifnull +7 -> 254
    //   250: aload_0
    //   251: invokevirtual 91	java/net/HttpURLConnection:disconnect	()V
    //   254: aload_1
    //   255: areturn
    //   256: astore_2
    //   257: aconst_null
    //   258: astore_3
    //   259: aload_3
    //   260: astore_1
    //   261: goto +162 -> 423
    //   264: astore 6
    //   266: goto +22 -> 288
    //   269: astore 6
    //   271: goto +80 -> 351
    //   274: astore_2
    //   275: aconst_null
    //   276: astore_1
    //   277: aload_1
    //   278: astore_3
    //   279: aload_3
    //   280: astore_0
    //   281: goto +142 -> 423
    //   284: astore 6
    //   286: aconst_null
    //   287: astore_0
    //   288: aconst_null
    //   289: astore_1
    //   290: aconst_null
    //   291: astore 5
    //   293: aload_1
    //   294: astore_2
    //   295: aload 5
    //   297: astore_3
    //   298: aload_0
    //   299: astore 4
    //   301: aload 6
    //   303: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   306: aload 5
    //   308: ifnull +16 -> 324
    //   311: aload 5
    //   313: invokevirtual 82	java/io/BufferedReader:close	()V
    //   316: goto +8 -> 324
    //   319: astore_2
    //   320: aload_2
    //   321: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   324: aload_1
    //   325: ifnull +15 -> 340
    //   328: aload_1
    //   329: invokevirtual 88	java/io/InputStream:close	()V
    //   332: goto +8 -> 340
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   340: aload_0
    //   341: ifnull +70 -> 411
    //   344: goto +63 -> 407
    //   347: astore 6
    //   349: aconst_null
    //   350: astore_0
    //   351: aconst_null
    //   352: astore_1
    //   353: aconst_null
    //   354: astore 5
    //   356: aload_1
    //   357: astore_2
    //   358: aload 5
    //   360: astore_3
    //   361: aload_0
    //   362: astore 4
    //   364: aload 6
    //   366: invokevirtual 92	java/net/MalformedURLException:printStackTrace	()V
    //   369: aload 5
    //   371: ifnull +16 -> 387
    //   374: aload 5
    //   376: invokevirtual 82	java/io/BufferedReader:close	()V
    //   379: goto +8 -> 387
    //   382: astore_2
    //   383: aload_2
    //   384: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   387: aload_1
    //   388: ifnull +15 -> 403
    //   391: aload_1
    //   392: invokevirtual 88	java/io/InputStream:close	()V
    //   395: goto +8 -> 403
    //   398: astore_1
    //   399: aload_1
    //   400: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   403: aload_0
    //   404: ifnull +7 -> 411
    //   407: aload_0
    //   408: invokevirtual 91	java/net/HttpURLConnection:disconnect	()V
    //   411: aconst_null
    //   412: areturn
    //   413: astore 5
    //   415: aload 4
    //   417: astore_0
    //   418: aload_2
    //   419: astore_1
    //   420: aload 5
    //   422: astore_2
    //   423: aload_3
    //   424: ifnull +15 -> 439
    //   427: aload_3
    //   428: invokevirtual 82	java/io/BufferedReader:close	()V
    //   431: goto +8 -> 439
    //   434: astore_3
    //   435: aload_3
    //   436: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   439: aload_1
    //   440: ifnull +15 -> 455
    //   443: aload_1
    //   444: invokevirtual 88	java/io/InputStream:close	()V
    //   447: goto +8 -> 455
    //   450: astore_1
    //   451: aload_1
    //   452: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   455: aload_0
    //   456: ifnull +7 -> 463
    //   459: aload_0
    //   460: invokevirtual 91	java/net/HttpURLConnection:disconnect	()V
    //   463: goto +5 -> 468
    //   466: aload_2
    //   467: athrow
    //   468: goto -2 -> 466
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	paramString	java.lang.String
    //   55	274	1	localObject1	Object
    //   335	2	1	localIOException1	java.io.IOException
    //   352	40	1	localObject2	Object
    //   398	2	1	localIOException2	java.io.IOException
    //   419	25	1	localObject3	Object
    //   450	2	1	localIOException3	java.io.IOException
    //   76	96	2	localObject4	Object
    //   186	1	2	localObject5	Object
    //   225	2	2	localIOException4	java.io.IOException
    //   241	2	2	localIOException5	java.io.IOException
    //   256	1	2	localObject6	Object
    //   274	1	2	localObject7	Object
    //   294	1	2	localObject8	Object
    //   319	2	2	localIOException6	java.io.IOException
    //   357	1	2	localObject9	Object
    //   382	37	2	localIOException7	java.io.IOException
    //   422	45	2	localObject10	Object
    //   79	349	3	localObject11	Object
    //   434	2	3	localIOException8	java.io.IOException
    //   1	415	4	localObject12	Object
    //   73	302	5	localBufferedReader	java.io.BufferedReader
    //   413	8	5	localObject13	Object
    //   90	73	6	localObject14	Object
    //   176	1	6	localIOException9	java.io.IOException
    //   181	1	6	localMalformedURLException1	java.net.MalformedURLException
    //   192	1	6	localIOException10	java.io.IOException
    //   200	1	6	localMalformedURLException2	java.net.MalformedURLException
    //   264	1	6	localIOException11	java.io.IOException
    //   269	1	6	localMalformedURLException3	java.net.MalformedURLException
    //   284	18	6	localIOException12	java.io.IOException
    //   347	18	6	localMalformedURLException4	java.net.MalformedURLException
    //   105	18	7	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   83	92	176	java/io/IOException
    //   100	107	176	java/io/IOException
    //   120	128	176	java/io/IOException
    //   136	144	176	java/io/IOException
    //   155	162	176	java/io/IOException
    //   83	92	181	java/net/MalformedURLException
    //   100	107	181	java/net/MalformedURLException
    //   120	128	181	java/net/MalformedURLException
    //   136	144	181	java/net/MalformedURLException
    //   155	162	181	java/net/MalformedURLException
    //   56	75	186	finally
    //   56	75	192	java/io/IOException
    //   56	75	200	java/net/MalformedURLException
    //   217	222	225	java/io/IOException
    //   234	238	241	java/io/IOException
    //   18	56	256	finally
    //   18	56	264	java/io/IOException
    //   18	56	269	java/net/MalformedURLException
    //   3	18	274	finally
    //   3	18	284	java/io/IOException
    //   311	316	319	java/io/IOException
    //   328	332	335	java/io/IOException
    //   3	18	347	java/net/MalformedURLException
    //   374	379	382	java/io/IOException
    //   391	395	398	java/io/IOException
    //   83	92	413	finally
    //   100	107	413	finally
    //   120	128	413	finally
    //   136	144	413	finally
    //   155	162	413	finally
    //   301	306	413	finally
    //   364	369	413	finally
    //   427	431	434	java/io/IOException
    //   443	447	450	java/io/IOException
  }
  
  /* Error */
  public static java.lang.String doPost(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, com.tencent.hippy.qq.api.PackageUpdateListener paramPackageUpdateListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: new 18	java/net/URL
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 21	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 25	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 27	java/net/HttpURLConnection
    //   26: astore_0
    //   27: aload_0
    //   28: ldc 98
    //   30: invokevirtual 32	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: sipush 15000
    //   37: invokevirtual 36	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   40: aload_0
    //   41: ldc 37
    //   43: invokevirtual 40	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   46: aload_0
    //   47: iconst_1
    //   48: invokevirtual 102	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   51: aload_0
    //   52: iconst_1
    //   53: invokevirtual 105	java/net/HttpURLConnection:setDoInput	(Z)V
    //   56: aload_2
    //   57: ifnull +17 -> 74
    //   60: aload_2
    //   61: invokevirtual 110	java/lang/String:length	()I
    //   64: ifle +10 -> 74
    //   67: aload_0
    //   68: ldc 112
    //   70: aload_2
    //   71: invokevirtual 116	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: ldc 118
    //   77: ldc 120
    //   79: invokevirtual 116	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokevirtual 124	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   86: astore 5
    //   88: aload 5
    //   90: astore_2
    //   91: aload_2
    //   92: aload_1
    //   93: ldc 126
    //   95: invokevirtual 130	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   98: invokevirtual 136	java/io/OutputStream:write	([B)V
    //   101: aload_0
    //   102: invokevirtual 47	java/net/HttpURLConnection:getResponseCode	()I
    //   105: istore 4
    //   107: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +35 -> 145
    //   113: new 144	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   120: astore_1
    //   121: aload_1
    //   122: ldc 147
    //   124: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_1
    //   129: iload 4
    //   131: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: ldc 155
    //   137: iconst_2
    //   138: aload_1
    //   139: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: iload 4
    //   147: sipush 200
    //   150: if_icmpne +199 -> 349
    //   153: aload_0
    //   154: invokevirtual 51	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   157: astore_3
    //   158: aload_3
    //   159: astore 6
    //   161: new 53	java/io/BufferedReader
    //   164: dup
    //   165: new 55	java/io/InputStreamReader
    //   168: dup
    //   169: aload 6
    //   171: ldc 57
    //   173: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   176: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   179: astore_1
    //   180: new 65	java/lang/StringBuffer
    //   183: dup
    //   184: invokespecial 66	java/lang/StringBuffer:<init>	()V
    //   187: astore 7
    //   189: aload_1
    //   190: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   193: astore 8
    //   195: aload 8
    //   197: ifnull +22 -> 219
    //   200: aload 7
    //   202: aload 8
    //   204: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   207: pop
    //   208: aload 7
    //   210: ldc 76
    //   212: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   215: pop
    //   216: goto -27 -> 189
    //   219: aload 7
    //   221: invokevirtual 79	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   224: astore 7
    //   226: aload 7
    //   228: astore_3
    //   229: goto +168 -> 397
    //   232: astore_3
    //   233: aload_0
    //   234: astore 7
    //   236: aload 6
    //   238: astore_0
    //   239: aload_1
    //   240: astore 5
    //   242: aload_3
    //   243: astore_1
    //   244: aload_2
    //   245: astore_3
    //   246: aload 7
    //   248: astore_2
    //   249: goto +970 -> 1219
    //   252: astore 9
    //   254: aload_1
    //   255: astore 6
    //   257: goto +43 -> 300
    //   260: astore 9
    //   262: aload_1
    //   263: astore 6
    //   265: goto +53 -> 318
    //   268: astore 9
    //   270: aload_1
    //   271: astore 6
    //   273: goto +63 -> 336
    //   276: astore_1
    //   277: aload_0
    //   278: astore 7
    //   280: aload 6
    //   282: astore_0
    //   283: aload 8
    //   285: astore 5
    //   287: aload_2
    //   288: astore_3
    //   289: aload 7
    //   291: astore_2
    //   292: goto +927 -> 1219
    //   295: astore 9
    //   297: aconst_null
    //   298: astore 6
    //   300: aload 5
    //   302: astore 8
    //   304: aload_0
    //   305: astore 5
    //   307: aload_3
    //   308: astore 7
    //   310: goto +281 -> 591
    //   313: astore 9
    //   315: aconst_null
    //   316: astore 6
    //   318: aload 5
    //   320: astore 8
    //   322: aload_0
    //   323: astore 5
    //   325: aload_3
    //   326: astore 7
    //   328: goto +472 -> 800
    //   331: astore 9
    //   333: aconst_null
    //   334: astore 6
    //   336: aload 5
    //   338: astore 8
    //   340: aload_0
    //   341: astore 5
    //   343: aload_3
    //   344: astore 7
    //   346: goto +663 -> 1009
    //   349: aload_3
    //   350: ifnull +38 -> 388
    //   353: new 144	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   360: astore_1
    //   361: aload_1
    //   362: ldc 162
    //   364: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload_1
    //   369: iload 4
    //   371: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_3
    //   376: bipush 250
    //   378: aload_1
    //   379: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: aconst_null
    //   383: invokeinterface 168 4 0
    //   388: aconst_null
    //   389: astore 6
    //   391: aload 6
    //   393: astore_1
    //   394: aload 7
    //   396: astore_3
    //   397: aload_1
    //   398: ifnull +15 -> 413
    //   401: aload_1
    //   402: invokevirtual 82	java/io/BufferedReader:close	()V
    //   405: goto +8 -> 413
    //   408: astore_1
    //   409: aload_1
    //   410: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   413: aload_2
    //   414: ifnull +15 -> 429
    //   417: aload_2
    //   418: invokevirtual 169	java/io/OutputStream:close	()V
    //   421: goto +8 -> 429
    //   424: astore_1
    //   425: aload_1
    //   426: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   429: aload 6
    //   431: ifnull +16 -> 447
    //   434: aload 6
    //   436: invokevirtual 88	java/io/InputStream:close	()V
    //   439: goto +8 -> 447
    //   442: astore_1
    //   443: aload_1
    //   444: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   447: aload_3
    //   448: astore_1
    //   449: aload_0
    //   450: ifnull +751 -> 1201
    //   453: aload_0
    //   454: invokevirtual 91	java/net/HttpURLConnection:disconnect	()V
    //   457: aload_3
    //   458: areturn
    //   459: astore_1
    //   460: aload_0
    //   461: astore 6
    //   463: aconst_null
    //   464: astore_0
    //   465: aload 8
    //   467: astore 5
    //   469: aload_2
    //   470: astore_3
    //   471: aload 6
    //   473: astore_2
    //   474: goto +745 -> 1219
    //   477: astore 9
    //   479: aconst_null
    //   480: astore 7
    //   482: aload 7
    //   484: astore 6
    //   486: aload_0
    //   487: astore 5
    //   489: aload_2
    //   490: astore 8
    //   492: goto +99 -> 591
    //   495: astore 9
    //   497: aconst_null
    //   498: astore 7
    //   500: aload 7
    //   502: astore 6
    //   504: aload_0
    //   505: astore 5
    //   507: aload_2
    //   508: astore 8
    //   510: goto +290 -> 800
    //   513: astore 9
    //   515: aconst_null
    //   516: astore 7
    //   518: aload 7
    //   520: astore 6
    //   522: aload_0
    //   523: astore 5
    //   525: aload_2
    //   526: astore 8
    //   528: goto +481 -> 1009
    //   531: astore_1
    //   532: aload_0
    //   533: astore_2
    //   534: aconst_null
    //   535: astore_0
    //   536: aload_0
    //   537: astore_3
    //   538: aload 8
    //   540: astore 5
    //   542: goto +677 -> 1219
    //   545: astore 9
    //   547: goto +31 -> 578
    //   550: astore 9
    //   552: goto +235 -> 787
    //   555: astore 9
    //   557: goto +439 -> 996
    //   560: astore_1
    //   561: aconst_null
    //   562: astore_0
    //   563: aload_0
    //   564: astore_3
    //   565: aload_3
    //   566: astore_2
    //   567: aload 8
    //   569: astore 5
    //   571: goto +648 -> 1219
    //   574: astore 9
    //   576: aconst_null
    //   577: astore_0
    //   578: aconst_null
    //   579: astore 7
    //   581: aconst_null
    //   582: astore 8
    //   584: aload 8
    //   586: astore 6
    //   588: aload_0
    //   589: astore 5
    //   591: aload 6
    //   593: astore_3
    //   594: aload 5
    //   596: astore_2
    //   597: aload 7
    //   599: astore_1
    //   600: aload 8
    //   602: astore_0
    //   603: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq +106 -> 712
    //   609: aload 6
    //   611: astore_3
    //   612: aload 5
    //   614: astore_2
    //   615: aload 7
    //   617: astore_1
    //   618: aload 8
    //   620: astore_0
    //   621: aload 9
    //   623: invokevirtual 172	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   626: astore 9
    //   628: aload 6
    //   630: astore_3
    //   631: aload 5
    //   633: astore_2
    //   634: aload 7
    //   636: astore_1
    //   637: aload 8
    //   639: astore_0
    //   640: new 144	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   647: astore 12
    //   649: aload 6
    //   651: astore_3
    //   652: aload 5
    //   654: astore_2
    //   655: aload 7
    //   657: astore_1
    //   658: aload 8
    //   660: astore_0
    //   661: aload 12
    //   663: ldc 174
    //   665: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 6
    //   671: astore_3
    //   672: aload 5
    //   674: astore_2
    //   675: aload 7
    //   677: astore_1
    //   678: aload 8
    //   680: astore_0
    //   681: aload 12
    //   683: aload 9
    //   685: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 6
    //   691: astore_3
    //   692: aload 5
    //   694: astore_2
    //   695: aload 7
    //   697: astore_1
    //   698: aload 8
    //   700: astore_0
    //   701: ldc 155
    //   703: iconst_2
    //   704: aload 12
    //   706: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aload 6
    //   714: ifnull +16 -> 730
    //   717: aload 6
    //   719: invokevirtual 82	java/io/BufferedReader:close	()V
    //   722: goto +8 -> 730
    //   725: astore_0
    //   726: aload_0
    //   727: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   730: aload 8
    //   732: ifnull +16 -> 748
    //   735: aload 8
    //   737: invokevirtual 169	java/io/OutputStream:close	()V
    //   740: goto +8 -> 748
    //   743: astore_0
    //   744: aload_0
    //   745: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   748: aload 7
    //   750: ifnull +16 -> 766
    //   753: aload 7
    //   755: invokevirtual 88	java/io/InputStream:close	()V
    //   758: goto +8 -> 766
    //   761: astore_0
    //   762: aload_0
    //   763: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   766: aload 11
    //   768: astore_1
    //   769: aload 5
    //   771: ifnull +430 -> 1201
    //   774: aload 10
    //   776: astore_3
    //   777: aload 5
    //   779: astore_0
    //   780: goto -327 -> 453
    //   783: astore 9
    //   785: aconst_null
    //   786: astore_0
    //   787: aconst_null
    //   788: astore 7
    //   790: aconst_null
    //   791: astore 8
    //   793: aload 8
    //   795: astore 6
    //   797: aload_0
    //   798: astore 5
    //   800: aload 6
    //   802: astore_3
    //   803: aload 5
    //   805: astore_2
    //   806: aload 7
    //   808: astore_1
    //   809: aload 8
    //   811: astore_0
    //   812: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   815: ifeq +106 -> 921
    //   818: aload 6
    //   820: astore_3
    //   821: aload 5
    //   823: astore_2
    //   824: aload 7
    //   826: astore_1
    //   827: aload 8
    //   829: astore_0
    //   830: aload 9
    //   832: invokevirtual 175	java/io/IOException:getMessage	()Ljava/lang/String;
    //   835: astore 9
    //   837: aload 6
    //   839: astore_3
    //   840: aload 5
    //   842: astore_2
    //   843: aload 7
    //   845: astore_1
    //   846: aload 8
    //   848: astore_0
    //   849: new 144	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   856: astore 12
    //   858: aload 6
    //   860: astore_3
    //   861: aload 5
    //   863: astore_2
    //   864: aload 7
    //   866: astore_1
    //   867: aload 8
    //   869: astore_0
    //   870: aload 12
    //   872: ldc 177
    //   874: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 6
    //   880: astore_3
    //   881: aload 5
    //   883: astore_2
    //   884: aload 7
    //   886: astore_1
    //   887: aload 8
    //   889: astore_0
    //   890: aload 12
    //   892: aload 9
    //   894: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: pop
    //   898: aload 6
    //   900: astore_3
    //   901: aload 5
    //   903: astore_2
    //   904: aload 7
    //   906: astore_1
    //   907: aload 8
    //   909: astore_0
    //   910: ldc 155
    //   912: iconst_2
    //   913: aload 12
    //   915: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   921: aload 6
    //   923: ifnull +16 -> 939
    //   926: aload 6
    //   928: invokevirtual 82	java/io/BufferedReader:close	()V
    //   931: goto +8 -> 939
    //   934: astore_0
    //   935: aload_0
    //   936: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   939: aload 8
    //   941: ifnull +16 -> 957
    //   944: aload 8
    //   946: invokevirtual 169	java/io/OutputStream:close	()V
    //   949: goto +8 -> 957
    //   952: astore_0
    //   953: aload_0
    //   954: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   957: aload 7
    //   959: ifnull +16 -> 975
    //   962: aload 7
    //   964: invokevirtual 88	java/io/InputStream:close	()V
    //   967: goto +8 -> 975
    //   970: astore_0
    //   971: aload_0
    //   972: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   975: aload 11
    //   977: astore_1
    //   978: aload 5
    //   980: ifnull +221 -> 1201
    //   983: aload 10
    //   985: astore_3
    //   986: aload 5
    //   988: astore_0
    //   989: goto -536 -> 453
    //   992: astore 9
    //   994: aconst_null
    //   995: astore_0
    //   996: aconst_null
    //   997: astore 7
    //   999: aconst_null
    //   1000: astore 8
    //   1002: aload 8
    //   1004: astore 6
    //   1006: aload_0
    //   1007: astore 5
    //   1009: aload 6
    //   1011: astore_3
    //   1012: aload 5
    //   1014: astore_2
    //   1015: aload 7
    //   1017: astore_1
    //   1018: aload 8
    //   1020: astore_0
    //   1021: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1024: ifeq +106 -> 1130
    //   1027: aload 6
    //   1029: astore_3
    //   1030: aload 5
    //   1032: astore_2
    //   1033: aload 7
    //   1035: astore_1
    //   1036: aload 8
    //   1038: astore_0
    //   1039: aload 9
    //   1041: invokevirtual 178	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1044: astore 9
    //   1046: aload 6
    //   1048: astore_3
    //   1049: aload 5
    //   1051: astore_2
    //   1052: aload 7
    //   1054: astore_1
    //   1055: aload 8
    //   1057: astore_0
    //   1058: new 144	java/lang/StringBuilder
    //   1061: dup
    //   1062: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   1065: astore 12
    //   1067: aload 6
    //   1069: astore_3
    //   1070: aload 5
    //   1072: astore_2
    //   1073: aload 7
    //   1075: astore_1
    //   1076: aload 8
    //   1078: astore_0
    //   1079: aload 12
    //   1081: ldc 180
    //   1083: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 6
    //   1089: astore_3
    //   1090: aload 5
    //   1092: astore_2
    //   1093: aload 7
    //   1095: astore_1
    //   1096: aload 8
    //   1098: astore_0
    //   1099: aload 12
    //   1101: aload 9
    //   1103: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload 6
    //   1109: astore_3
    //   1110: aload 5
    //   1112: astore_2
    //   1113: aload 7
    //   1115: astore_1
    //   1116: aload 8
    //   1118: astore_0
    //   1119: ldc 155
    //   1121: iconst_2
    //   1122: aload 12
    //   1124: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1127: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1130: aload 6
    //   1132: ifnull +16 -> 1148
    //   1135: aload 6
    //   1137: invokevirtual 82	java/io/BufferedReader:close	()V
    //   1140: goto +8 -> 1148
    //   1143: astore_0
    //   1144: aload_0
    //   1145: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   1148: aload 8
    //   1150: ifnull +16 -> 1166
    //   1153: aload 8
    //   1155: invokevirtual 169	java/io/OutputStream:close	()V
    //   1158: goto +8 -> 1166
    //   1161: astore_0
    //   1162: aload_0
    //   1163: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   1166: aload 7
    //   1168: ifnull +16 -> 1184
    //   1171: aload 7
    //   1173: invokevirtual 88	java/io/InputStream:close	()V
    //   1176: goto +8 -> 1184
    //   1179: astore_0
    //   1180: aload_0
    //   1181: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   1184: aload 11
    //   1186: astore_1
    //   1187: aload 5
    //   1189: ifnull +12 -> 1201
    //   1192: aload 10
    //   1194: astore_3
    //   1195: aload 5
    //   1197: astore_0
    //   1198: goto -745 -> 453
    //   1201: aload_1
    //   1202: areturn
    //   1203: astore 7
    //   1205: aload_3
    //   1206: astore 5
    //   1208: aload_1
    //   1209: astore 6
    //   1211: aload_0
    //   1212: astore_3
    //   1213: aload 7
    //   1215: astore_1
    //   1216: aload 6
    //   1218: astore_0
    //   1219: aload 5
    //   1221: ifnull +18 -> 1239
    //   1224: aload 5
    //   1226: invokevirtual 82	java/io/BufferedReader:close	()V
    //   1229: goto +10 -> 1239
    //   1232: astore 5
    //   1234: aload 5
    //   1236: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   1239: aload_3
    //   1240: ifnull +15 -> 1255
    //   1243: aload_3
    //   1244: invokevirtual 169	java/io/OutputStream:close	()V
    //   1247: goto +8 -> 1255
    //   1250: astore_3
    //   1251: aload_3
    //   1252: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   1255: aload_0
    //   1256: ifnull +15 -> 1271
    //   1259: aload_0
    //   1260: invokevirtual 88	java/io/InputStream:close	()V
    //   1263: goto +8 -> 1271
    //   1266: astore_0
    //   1267: aload_0
    //   1268: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   1271: aload_2
    //   1272: ifnull +7 -> 1279
    //   1275: aload_2
    //   1276: invokevirtual 91	java/net/HttpURLConnection:disconnect	()V
    //   1279: goto +5 -> 1284
    //   1282: aload_1
    //   1283: athrow
    //   1284: goto -2 -> 1282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1287	0	paramString1	java.lang.String
    //   0	1287	1	paramString2	java.lang.String
    //   0	1287	2	paramString3	java.lang.String
    //   0	1287	3	paramPackageUpdateListener	com.tencent.hippy.qq.api.PackageUpdateListener
    //   105	265	4	i	int
    //   86	1139	5	localObject1	Object
    //   1232	3	5	localIOException1	java.io.IOException
    //   159	1058	6	localObject2	Object
    //   10	1162	7	localObject3	Object
    //   1203	11	7	localObject4	Object
    //   7	1147	8	localObject5	Object
    //   252	1	9	localThrowable1	java.lang.Throwable
    //   260	1	9	localIOException2	java.io.IOException
    //   268	1	9	localMalformedURLException1	java.net.MalformedURLException
    //   295	1	9	localThrowable2	java.lang.Throwable
    //   313	1	9	localIOException3	java.io.IOException
    //   331	1	9	localMalformedURLException2	java.net.MalformedURLException
    //   477	1	9	localThrowable3	java.lang.Throwable
    //   495	1	9	localIOException4	java.io.IOException
    //   513	1	9	localMalformedURLException3	java.net.MalformedURLException
    //   545	1	9	localThrowable4	java.lang.Throwable
    //   550	1	9	localIOException5	java.io.IOException
    //   555	1	9	localMalformedURLException4	java.net.MalformedURLException
    //   574	48	9	localThrowable5	java.lang.Throwable
    //   626	58	9	str1	java.lang.String
    //   783	48	9	localIOException6	java.io.IOException
    //   835	58	9	str2	java.lang.String
    //   992	48	9	localMalformedURLException5	java.net.MalformedURLException
    //   1044	58	9	str3	java.lang.String
    //   1	1192	10	localObject6	Object
    //   4	1181	11	localObject7	Object
    //   647	476	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   180	189	232	finally
    //   189	195	232	finally
    //   200	216	232	finally
    //   219	226	232	finally
    //   180	189	252	java/lang/Throwable
    //   189	195	252	java/lang/Throwable
    //   200	216	252	java/lang/Throwable
    //   219	226	252	java/lang/Throwable
    //   180	189	260	java/io/IOException
    //   189	195	260	java/io/IOException
    //   200	216	260	java/io/IOException
    //   219	226	260	java/io/IOException
    //   180	189	268	java/net/MalformedURLException
    //   189	195	268	java/net/MalformedURLException
    //   200	216	268	java/net/MalformedURLException
    //   219	226	268	java/net/MalformedURLException
    //   161	180	276	finally
    //   161	180	295	java/lang/Throwable
    //   161	180	313	java/io/IOException
    //   161	180	331	java/net/MalformedURLException
    //   401	405	408	java/io/IOException
    //   417	421	424	java/io/IOException
    //   434	439	442	java/io/IOException
    //   91	145	459	finally
    //   153	158	459	finally
    //   353	388	459	finally
    //   91	145	477	java/lang/Throwable
    //   153	158	477	java/lang/Throwable
    //   353	388	477	java/lang/Throwable
    //   91	145	495	java/io/IOException
    //   153	158	495	java/io/IOException
    //   353	388	495	java/io/IOException
    //   91	145	513	java/net/MalformedURLException
    //   153	158	513	java/net/MalformedURLException
    //   353	388	513	java/net/MalformedURLException
    //   27	56	531	finally
    //   60	74	531	finally
    //   74	88	531	finally
    //   27	56	545	java/lang/Throwable
    //   60	74	545	java/lang/Throwable
    //   74	88	545	java/lang/Throwable
    //   27	56	550	java/io/IOException
    //   60	74	550	java/io/IOException
    //   74	88	550	java/io/IOException
    //   27	56	555	java/net/MalformedURLException
    //   60	74	555	java/net/MalformedURLException
    //   74	88	555	java/net/MalformedURLException
    //   12	27	560	finally
    //   12	27	574	java/lang/Throwable
    //   717	722	725	java/io/IOException
    //   735	740	743	java/io/IOException
    //   753	758	761	java/io/IOException
    //   12	27	783	java/io/IOException
    //   926	931	934	java/io/IOException
    //   944	949	952	java/io/IOException
    //   962	967	970	java/io/IOException
    //   12	27	992	java/net/MalformedURLException
    //   1135	1140	1143	java/io/IOException
    //   1153	1158	1161	java/io/IOException
    //   1171	1176	1179	java/io/IOException
    //   603	609	1203	finally
    //   621	628	1203	finally
    //   640	649	1203	finally
    //   661	669	1203	finally
    //   681	689	1203	finally
    //   701	712	1203	finally
    //   812	818	1203	finally
    //   830	837	1203	finally
    //   849	858	1203	finally
    //   870	878	1203	finally
    //   890	898	1203	finally
    //   910	921	1203	finally
    //   1021	1027	1203	finally
    //   1039	1046	1203	finally
    //   1058	1067	1203	finally
    //   1079	1087	1203	finally
    //   1099	1107	1203	finally
    //   1119	1130	1203	finally
    //   1224	1229	1232	java/io/IOException
    //   1243	1247	1250	java/io/IOException
    //   1259	1263	1266	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HttpClient
 * JD-Core Version:    0.7.0.1
 */