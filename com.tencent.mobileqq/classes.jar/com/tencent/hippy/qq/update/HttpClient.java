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
    //   50: if_icmpne +392 -> 442
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
    //   92: ifnull +57 -> 149
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
    //   144: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   147: aconst_null
    //   148: areturn
    //   149: aload_2
    //   150: invokevirtual 91	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   153: astore 4
    //   155: aload_1
    //   156: astore_2
    //   157: aload 4
    //   159: astore_1
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 82	java/io/BufferedReader:close	()V
    //   168: aload_2
    //   169: ifnull +7 -> 176
    //   172: aload_2
    //   173: invokevirtual 85	java/io/InputStream:close	()V
    //   176: aload_0
    //   177: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   180: aload_1
    //   181: areturn
    //   182: astore_3
    //   183: aload_3
    //   184: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   187: goto -19 -> 168
    //   190: astore_2
    //   191: aload_2
    //   192: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   195: goto -19 -> 176
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   203: goto -68 -> 135
    //   206: astore_0
    //   207: aload_0
    //   208: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   211: goto -68 -> 143
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_0
    //   218: aconst_null
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_2
    //   222: aload 4
    //   224: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   227: aload_0
    //   228: ifnull +7 -> 235
    //   231: aload_0
    //   232: invokevirtual 82	java/io/BufferedReader:close	()V
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 85	java/io/InputStream:close	()V
    //   243: aload_2
    //   244: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_0
    //   250: aload_0
    //   251: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   254: goto -19 -> 235
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   262: goto -19 -> 243
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_1
    //   268: aconst_null
    //   269: astore_2
    //   270: aload 4
    //   272: astore_3
    //   273: aload_3
    //   274: ifnull +7 -> 281
    //   277: aload_3
    //   278: invokevirtual 82	java/io/BufferedReader:close	()V
    //   281: aload_1
    //   282: ifnull +7 -> 289
    //   285: aload_1
    //   286: invokevirtual 85	java/io/InputStream:close	()V
    //   289: aload_2
    //   290: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   293: aload_0
    //   294: athrow
    //   295: astore_3
    //   296: aload_3
    //   297: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   300: goto -19 -> 281
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   308: goto -19 -> 289
    //   311: astore_3
    //   312: aconst_null
    //   313: astore_1
    //   314: aload_0
    //   315: astore_2
    //   316: aload_3
    //   317: astore_0
    //   318: aload 4
    //   320: astore_3
    //   321: goto -48 -> 273
    //   324: astore_3
    //   325: aload_0
    //   326: astore_2
    //   327: aload_3
    //   328: astore_0
    //   329: aload 4
    //   331: astore_3
    //   332: goto -59 -> 273
    //   335: astore 4
    //   337: aload_0
    //   338: astore_2
    //   339: aload 4
    //   341: astore_0
    //   342: goto -69 -> 273
    //   345: astore_3
    //   346: aload_0
    //   347: astore 4
    //   349: aload_3
    //   350: astore_0
    //   351: aload_1
    //   352: astore_3
    //   353: aload 4
    //   355: astore_1
    //   356: goto -83 -> 273
    //   359: astore 4
    //   361: aload_0
    //   362: astore_3
    //   363: aload 4
    //   365: astore_0
    //   366: goto -93 -> 273
    //   369: astore 4
    //   371: aconst_null
    //   372: astore_3
    //   373: aconst_null
    //   374: astore_1
    //   375: aload_0
    //   376: astore_2
    //   377: aload_3
    //   378: astore_0
    //   379: goto -157 -> 222
    //   382: astore 4
    //   384: aconst_null
    //   385: astore_3
    //   386: aload_0
    //   387: astore_2
    //   388: aload_3
    //   389: astore_0
    //   390: goto -168 -> 222
    //   393: astore 4
    //   395: aload_0
    //   396: astore_2
    //   397: aload_3
    //   398: astore_0
    //   399: goto -177 -> 222
    //   402: astore_3
    //   403: aconst_null
    //   404: astore_1
    //   405: aconst_null
    //   406: astore_0
    //   407: aconst_null
    //   408: astore_2
    //   409: goto -286 -> 123
    //   412: astore_3
    //   413: aconst_null
    //   414: astore 4
    //   416: aload_0
    //   417: astore_2
    //   418: aconst_null
    //   419: astore_1
    //   420: aload 4
    //   422: astore_0
    //   423: goto -300 -> 123
    //   426: astore_3
    //   427: aload_1
    //   428: astore_2
    //   429: aload_0
    //   430: astore 4
    //   432: aconst_null
    //   433: astore_1
    //   434: aload_2
    //   435: astore_0
    //   436: aload 4
    //   438: astore_2
    //   439: goto -316 -> 123
    //   442: aconst_null
    //   443: astore_3
    //   444: aconst_null
    //   445: astore_2
    //   446: goto -286 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	paramString	java.lang.String
    //   4	177	1	localObject1	Object
    //   198	2	1	localIOException1	java.io.IOException
    //   219	67	1	localObject2	Object
    //   303	2	1	localIOException2	java.io.IOException
    //   313	121	1	str1	java.lang.String
    //   83	90	2	localObject3	Object
    //   190	2	2	localIOException3	java.io.IOException
    //   221	225	2	str2	java.lang.String
    //   75	90	3	localObject4	Object
    //   182	2	3	localIOException4	java.io.IOException
    //   272	6	3	localIOException5	java.io.IOException
    //   295	2	3	localIOException6	java.io.IOException
    //   311	6	3	localObject5	Object
    //   320	1	3	localIOException7	java.io.IOException
    //   324	4	3	localObject6	Object
    //   331	1	3	localIOException8	java.io.IOException
    //   345	5	3	localObject7	Object
    //   352	46	3	str3	java.lang.String
    //   402	1	3	localMalformedURLException1	java.net.MalformedURLException
    //   412	1	3	localMalformedURLException2	java.net.MalformedURLException
    //   426	1	3	localMalformedURLException3	java.net.MalformedURLException
    //   443	1	3	localObject8	Object
    //   1	96	4	str4	java.lang.String
    //   112	9	4	localMalformedURLException4	java.net.MalformedURLException
    //   153	5	4	str5	java.lang.String
    //   214	116	4	localIOException9	java.io.IOException
    //   335	5	4	localObject9	Object
    //   347	7	4	str6	java.lang.String
    //   359	5	4	localObject10	Object
    //   369	1	4	localIOException10	java.io.IOException
    //   382	1	4	localIOException11	java.io.IOException
    //   393	1	4	localIOException12	java.io.IOException
    //   414	23	4	str7	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   76	84	112	java/net/MalformedURLException
    //   84	90	112	java/net/MalformedURLException
    //   95	109	112	java/net/MalformedURLException
    //   149	155	112	java/net/MalformedURLException
    //   164	168	182	java/io/IOException
    //   172	176	190	java/io/IOException
    //   131	135	198	java/io/IOException
    //   139	143	206	java/io/IOException
    //   5	20	214	java/io/IOException
    //   231	235	249	java/io/IOException
    //   239	243	257	java/io/IOException
    //   5	20	265	finally
    //   277	281	295	java/io/IOException
    //   285	289	303	java/io/IOException
    //   20	58	311	finally
    //   58	76	324	finally
    //   76	84	335	finally
    //   84	90	335	finally
    //   95	109	335	finally
    //   149	155	335	finally
    //   123	127	345	finally
    //   222	227	359	finally
    //   20	58	369	java/io/IOException
    //   58	76	382	java/io/IOException
    //   76	84	393	java/io/IOException
    //   84	90	393	java/io/IOException
    //   95	109	393	java/io/IOException
    //   149	155	393	java/io/IOException
    //   5	20	402	java/net/MalformedURLException
    //   20	58	412	java/net/MalformedURLException
    //   58	76	426	java/net/MalformedURLException
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
    //   134: if_icmpne +198 -> 332
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
    //   178: ifnull +117 -> 295
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
    //   229: ifnull +177 -> 406
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
    //   290: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   293: aconst_null
    //   294: areturn
    //   295: aload_1
    //   296: invokevirtual 91	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   299: astore_1
    //   300: aload 6
    //   302: ifnull +8 -> 310
    //   305: aload 6
    //   307: invokevirtual 82	java/io/BufferedReader:close	()V
    //   310: aload_2
    //   311: ifnull +7 -> 318
    //   314: aload_2
    //   315: invokevirtual 164	java/io/OutputStream:close	()V
    //   318: aload_3
    //   319: ifnull +7 -> 326
    //   322: aload_3
    //   323: invokevirtual 85	java/io/InputStream:close	()V
    //   326: aload_0
    //   327: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   330: aload_1
    //   331: areturn
    //   332: aload_3
    //   333: ifnull +32 -> 365
    //   336: aload_3
    //   337: bipush 250
    //   339: new 144	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   346: ldc 166
    //   348: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: iload 4
    //   353: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: aconst_null
    //   360: invokeinterface 172 4 0
    //   365: aconst_null
    //   366: astore 5
    //   368: aconst_null
    //   369: astore_3
    //   370: aload 6
    //   372: astore_1
    //   373: aload 5
    //   375: astore 6
    //   377: goto -77 -> 300
    //   380: astore 5
    //   382: aload 5
    //   384: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   387: goto -77 -> 310
    //   390: astore_2
    //   391: aload_2
    //   392: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   395: goto -77 -> 318
    //   398: astore_2
    //   399: aload_2
    //   400: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   403: goto -77 -> 326
    //   406: ldc 174
    //   408: astore 5
    //   410: goto -171 -> 239
    //   413: astore_1
    //   414: aload_1
    //   415: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   418: goto -145 -> 273
    //   421: astore_0
    //   422: aload_0
    //   423: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   426: goto -145 -> 281
    //   429: astore_0
    //   430: aload_0
    //   431: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   434: goto -145 -> 289
    //   437: astore 5
    //   439: aconst_null
    //   440: astore_0
    //   441: aconst_null
    //   442: astore_2
    //   443: aconst_null
    //   444: astore_3
    //   445: aconst_null
    //   446: astore_1
    //   447: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +41 -> 491
    //   453: aload 5
    //   455: ifnull +66 -> 521
    //   458: aload 5
    //   460: invokevirtual 175	java/io/IOException:getMessage	()Ljava/lang/String;
    //   463: astore 5
    //   465: ldc 142
    //   467: iconst_2
    //   468: new 144	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   475: ldc 177
    //   477: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload 5
    //   482: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: aload_0
    //   492: ifnull +7 -> 499
    //   495: aload_0
    //   496: invokevirtual 82	java/io/BufferedReader:close	()V
    //   499: aload_2
    //   500: ifnull +7 -> 507
    //   503: aload_2
    //   504: invokevirtual 164	java/io/OutputStream:close	()V
    //   507: aload_3
    //   508: ifnull +7 -> 515
    //   511: aload_3
    //   512: invokevirtual 85	java/io/InputStream:close	()V
    //   515: aload_1
    //   516: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   519: aconst_null
    //   520: areturn
    //   521: ldc 174
    //   523: astore 5
    //   525: goto -60 -> 465
    //   528: astore_0
    //   529: aload_0
    //   530: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   533: goto -34 -> 499
    //   536: astore_0
    //   537: aload_0
    //   538: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   541: goto -34 -> 507
    //   544: astore_0
    //   545: aload_0
    //   546: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   549: goto -34 -> 515
    //   552: astore_0
    //   553: aconst_null
    //   554: astore_2
    //   555: aconst_null
    //   556: astore_3
    //   557: aconst_null
    //   558: astore_1
    //   559: aload 5
    //   561: ifnull +8 -> 569
    //   564: aload 5
    //   566: invokevirtual 82	java/io/BufferedReader:close	()V
    //   569: aload_2
    //   570: ifnull +7 -> 577
    //   573: aload_2
    //   574: invokevirtual 164	java/io/OutputStream:close	()V
    //   577: aload_3
    //   578: ifnull +7 -> 585
    //   581: aload_3
    //   582: invokevirtual 85	java/io/InputStream:close	()V
    //   585: aload_1
    //   586: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   589: aload_0
    //   590: athrow
    //   591: astore 5
    //   593: aload 5
    //   595: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   598: goto -29 -> 569
    //   601: astore_2
    //   602: aload_2
    //   603: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   606: goto -29 -> 577
    //   609: astore_2
    //   610: aload_2
    //   611: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   614: goto -29 -> 585
    //   617: astore 6
    //   619: aconst_null
    //   620: astore_2
    //   621: aconst_null
    //   622: astore_3
    //   623: aload_0
    //   624: astore_1
    //   625: aload 6
    //   627: astore_0
    //   628: goto -69 -> 559
    //   631: astore 6
    //   633: aconst_null
    //   634: astore_3
    //   635: aload_0
    //   636: astore_1
    //   637: aload 6
    //   639: astore_0
    //   640: goto -81 -> 559
    //   643: astore 6
    //   645: aload_0
    //   646: astore_1
    //   647: aload 6
    //   649: astore_0
    //   650: goto -91 -> 559
    //   653: astore 5
    //   655: aload_0
    //   656: astore_1
    //   657: aload 5
    //   659: astore_0
    //   660: aload 6
    //   662: astore 5
    //   664: goto -105 -> 559
    //   667: astore 5
    //   669: aload_3
    //   670: astore 6
    //   672: aload_2
    //   673: astore_3
    //   674: aload_0
    //   675: astore_2
    //   676: aload 5
    //   678: astore_0
    //   679: aload_1
    //   680: astore 5
    //   682: aload 6
    //   684: astore_1
    //   685: goto -126 -> 559
    //   688: astore 6
    //   690: aload_0
    //   691: astore 5
    //   693: aload 6
    //   695: astore_0
    //   696: goto -137 -> 559
    //   699: astore 5
    //   701: aconst_null
    //   702: astore 6
    //   704: aconst_null
    //   705: astore_2
    //   706: aconst_null
    //   707: astore_3
    //   708: aload_0
    //   709: astore_1
    //   710: aload 6
    //   712: astore_0
    //   713: goto -266 -> 447
    //   716: astore 5
    //   718: aconst_null
    //   719: astore 6
    //   721: aconst_null
    //   722: astore_3
    //   723: aload_0
    //   724: astore_1
    //   725: aload 6
    //   727: astore_0
    //   728: goto -281 -> 447
    //   731: astore 5
    //   733: aconst_null
    //   734: astore 6
    //   736: aload_0
    //   737: astore_1
    //   738: aload 6
    //   740: astore_0
    //   741: goto -294 -> 447
    //   744: astore 5
    //   746: aload_0
    //   747: astore_1
    //   748: aload 6
    //   750: astore_0
    //   751: goto -304 -> 447
    //   754: astore 5
    //   756: aconst_null
    //   757: astore_1
    //   758: aconst_null
    //   759: astore_0
    //   760: aconst_null
    //   761: astore_2
    //   762: aconst_null
    //   763: astore_3
    //   764: goto -543 -> 221
    //   767: astore 5
    //   769: aconst_null
    //   770: astore 6
    //   772: aconst_null
    //   773: astore_2
    //   774: aload_0
    //   775: astore_3
    //   776: aconst_null
    //   777: astore_1
    //   778: aload 6
    //   780: astore_0
    //   781: goto -560 -> 221
    //   784: astore 5
    //   786: aload_0
    //   787: astore_3
    //   788: aconst_null
    //   789: astore 6
    //   791: aconst_null
    //   792: astore_1
    //   793: aload_2
    //   794: astore_0
    //   795: aload 6
    //   797: astore_2
    //   798: goto -577 -> 221
    //   801: astore 5
    //   803: aload_0
    //   804: astore 6
    //   806: aconst_null
    //   807: astore_1
    //   808: aload_2
    //   809: astore_0
    //   810: aload_3
    //   811: astore_2
    //   812: aload 6
    //   814: astore_3
    //   815: goto -594 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	paramString1	java.lang.String
    //   0	818	1	paramString2	java.lang.String
    //   0	818	2	paramString3	java.lang.String
    //   0	818	3	paramPackageUpdateListener	HippyQQUpdateManager.PackageUpdateListener
    //   95	257	4	i	int
    //   1	373	5	localObject1	Object
    //   380	3	5	localIOException1	java.io.IOException
    //   408	1	5	str1	java.lang.String
    //   437	22	5	localIOException2	java.io.IOException
    //   463	102	5	str2	java.lang.String
    //   591	3	5	localIOException3	java.io.IOException
    //   653	5	5	localObject2	Object
    //   662	1	5	localObject3	Object
    //   667	10	5	localObject4	Object
    //   680	12	5	str3	java.lang.String
    //   699	1	5	localIOException4	java.io.IOException
    //   716	1	5	localIOException5	java.io.IOException
    //   731	1	5	localIOException6	java.io.IOException
    //   744	1	5	localIOException7	java.io.IOException
    //   754	1	5	localMalformedURLException1	java.net.MalformedURLException
    //   767	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   784	1	5	localMalformedURLException3	java.net.MalformedURLException
    //   801	1	5	localMalformedURLException4	java.net.MalformedURLException
    //   4	372	6	localObject5	Object
    //   617	9	6	localObject6	Object
    //   631	7	6	localObject7	Object
    //   643	18	6	localObject8	Object
    //   670	13	6	localPackageUpdateListener	HippyQQUpdateManager.PackageUpdateListener
    //   688	6	6	localObject9	Object
    //   702	111	6	str4	java.lang.String
    //   198	11	7	localMalformedURLException5	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   161	169	198	java/net/MalformedURLException
    //   169	176	198	java/net/MalformedURLException
    //   181	195	198	java/net/MalformedURLException
    //   295	300	198	java/net/MalformedURLException
    //   305	310	380	java/io/IOException
    //   314	318	390	java/io/IOException
    //   322	326	398	java/io/IOException
    //   269	273	413	java/io/IOException
    //   277	281	421	java/io/IOException
    //   285	289	429	java/io/IOException
    //   6	21	437	java/io/IOException
    //   495	499	528	java/io/IOException
    //   503	507	536	java/io/IOException
    //   511	515	544	java/io/IOException
    //   6	21	552	finally
    //   564	569	591	java/io/IOException
    //   573	577	601	java/io/IOException
    //   581	585	609	java/io/IOException
    //   21	50	617	finally
    //   54	68	617	finally
    //   68	81	617	finally
    //   81	129	631	finally
    //   137	142	631	finally
    //   336	365	631	finally
    //   142	161	643	finally
    //   161	169	653	finally
    //   169	176	653	finally
    //   181	195	653	finally
    //   295	300	653	finally
    //   221	227	667	finally
    //   232	239	667	finally
    //   239	265	667	finally
    //   447	453	688	finally
    //   458	465	688	finally
    //   465	491	688	finally
    //   21	50	699	java/io/IOException
    //   54	68	699	java/io/IOException
    //   68	81	699	java/io/IOException
    //   81	129	716	java/io/IOException
    //   137	142	716	java/io/IOException
    //   336	365	716	java/io/IOException
    //   142	161	731	java/io/IOException
    //   161	169	744	java/io/IOException
    //   169	176	744	java/io/IOException
    //   181	195	744	java/io/IOException
    //   295	300	744	java/io/IOException
    //   6	21	754	java/net/MalformedURLException
    //   21	50	767	java/net/MalformedURLException
    //   54	68	767	java/net/MalformedURLException
    //   68	81	767	java/net/MalformedURLException
    //   81	129	784	java/net/MalformedURLException
    //   137	142	784	java/net/MalformedURLException
    //   336	365	784	java/net/MalformedURLException
    //   142	161	801	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HttpClient
 * JD-Core Version:    0.7.0.1
 */