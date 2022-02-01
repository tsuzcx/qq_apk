package com.tencent.av.config;

public final class MediaCodecFileUtils
{
  /* Error */
  public static java.lang.String a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +47 -> 50
    //   6: new 23	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 26
    //   17: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: ldc 32
    //   30: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 34
    //   42: iconst_2
    //   43: aload_2
    //   44: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aconst_null
    //   51: astore_3
    //   52: aconst_null
    //   53: astore 6
    //   55: aload_3
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull +376 -> 434
    //   61: aload_3
    //   62: astore_2
    //   63: aload_0
    //   64: ldc 44
    //   66: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifne +365 -> 434
    //   72: aload_3
    //   73: astore_2
    //   74: aload_1
    //   75: ifnull +359 -> 434
    //   78: aload_1
    //   79: ldc 44
    //   81: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +5 -> 89
    //   87: aconst_null
    //   88: areturn
    //   89: new 52	java/io/File
    //   92: dup
    //   93: aload_0
    //   94: aload_1
    //   95: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: astore 7
    //   100: aload_3
    //   101: astore_2
    //   102: aload 7
    //   104: invokevirtual 58	java/io/File:exists	()Z
    //   107: ifeq +327 -> 434
    //   110: new 60	java/io/FileInputStream
    //   113: dup
    //   114: aload 7
    //   116: invokespecial 63	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   119: astore_0
    //   120: new 65	java/io/BufferedInputStream
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 68	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   128: astore 5
    //   130: aload_0
    //   131: astore_1
    //   132: aload 5
    //   134: astore_3
    //   135: aload_0
    //   136: invokevirtual 72	java/io/FileInputStream:available	()I
    //   139: newarray byte
    //   141: astore_2
    //   142: aload_0
    //   143: astore_1
    //   144: aload 5
    //   146: astore_3
    //   147: aload 5
    //   149: aload_2
    //   150: invokevirtual 76	java/io/BufferedInputStream:read	([B)I
    //   153: pop
    //   154: aload_0
    //   155: astore_1
    //   156: aload 5
    //   158: astore_3
    //   159: new 46	java/lang/String
    //   162: dup
    //   163: aload_2
    //   164: ldc 78
    //   166: invokespecial 81	java/lang/String:<init>	([BLjava/lang/String;)V
    //   169: astore_2
    //   170: aload 5
    //   172: invokevirtual 84	java/io/BufferedInputStream:close	()V
    //   175: goto +8 -> 183
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   183: aload_0
    //   184: invokevirtual 88	java/io/FileInputStream:close	()V
    //   187: goto +8 -> 195
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   195: aload_2
    //   196: astore_0
    //   197: goto +157 -> 354
    //   200: astore 4
    //   202: aload_0
    //   203: astore_2
    //   204: aload 5
    //   206: astore_0
    //   207: goto +34 -> 241
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_3
    //   213: goto +187 -> 400
    //   216: astore 4
    //   218: aconst_null
    //   219: astore_1
    //   220: aload_0
    //   221: astore_2
    //   222: aload_1
    //   223: astore_0
    //   224: goto +17 -> 241
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_3
    //   230: aload_3
    //   231: astore_0
    //   232: goto +168 -> 400
    //   235: astore 4
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_2
    //   240: astore_0
    //   241: aload_2
    //   242: astore_1
    //   243: aload_0
    //   244: astore_3
    //   245: aload 7
    //   247: invokevirtual 91	java/io/File:delete	()Z
    //   250: pop
    //   251: aload_2
    //   252: astore_1
    //   253: aload_0
    //   254: astore_3
    //   255: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +55 -> 313
    //   261: aload_2
    //   262: astore_1
    //   263: aload_0
    //   264: astore_3
    //   265: new 23	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   272: astore 5
    //   274: aload_2
    //   275: astore_1
    //   276: aload_0
    //   277: astore_3
    //   278: aload 5
    //   280: ldc 93
    //   282: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_2
    //   287: astore_1
    //   288: aload_0
    //   289: astore_3
    //   290: aload 5
    //   292: aload 4
    //   294: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_2
    //   299: astore_1
    //   300: aload_0
    //   301: astore_3
    //   302: ldc 34
    //   304: iconst_2
    //   305: aload 5
    //   307: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: ifnull +15 -> 329
    //   317: aload_0
    //   318: invokevirtual 84	java/io/BufferedInputStream:close	()V
    //   321: goto +8 -> 329
    //   324: astore_0
    //   325: aload_0
    //   326: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   329: aload 6
    //   331: astore_0
    //   332: aload_2
    //   333: ifnull +21 -> 354
    //   336: aload_2
    //   337: invokevirtual 88	java/io/FileInputStream:close	()V
    //   340: aload 6
    //   342: astore_0
    //   343: goto +11 -> 354
    //   346: astore_0
    //   347: aload_0
    //   348: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   351: aload 6
    //   353: astore_0
    //   354: aload_0
    //   355: astore_2
    //   356: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +75 -> 434
    //   362: new 23	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   369: astore_1
    //   370: aload_1
    //   371: ldc 101
    //   373: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_1
    //   378: aload_0
    //   379: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: ldc 34
    //   385: iconst_2
    //   386: aload_1
    //   387: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: aload_0
    //   394: areturn
    //   395: astore_2
    //   396: aload_1
    //   397: astore_0
    //   398: aload_2
    //   399: astore_1
    //   400: aload_3
    //   401: ifnull +15 -> 416
    //   404: aload_3
    //   405: invokevirtual 84	java/io/BufferedInputStream:close	()V
    //   408: goto +8 -> 416
    //   411: astore_2
    //   412: aload_2
    //   413: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   416: aload_0
    //   417: ifnull +15 -> 432
    //   420: aload_0
    //   421: invokevirtual 88	java/io/FileInputStream:close	()V
    //   424: goto +8 -> 432
    //   427: astore_0
    //   428: aload_0
    //   429: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   432: aload_1
    //   433: athrow
    //   434: aload_2
    //   435: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	paramString1	java.lang.String
    //   0	436	1	paramString2	java.lang.String
    //   13	343	2	localObject1	Object
    //   395	4	2	localObject2	Object
    //   411	24	2	localIOException	java.io.IOException
    //   51	354	3	localObject3	Object
    //   200	1	4	localThrowable1	java.lang.Throwable
    //   216	1	4	localThrowable2	java.lang.Throwable
    //   235	58	4	localThrowable3	java.lang.Throwable
    //   128	178	5	localObject4	Object
    //   53	299	6	localObject5	Object
    //   98	148	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   170	175	178	java/io/IOException
    //   183	187	190	java/io/IOException
    //   135	142	200	java/lang/Throwable
    //   147	154	200	java/lang/Throwable
    //   159	170	200	java/lang/Throwable
    //   120	130	210	finally
    //   120	130	216	java/lang/Throwable
    //   110	120	227	finally
    //   110	120	235	java/lang/Throwable
    //   317	321	324	java/io/IOException
    //   336	340	346	java/io/IOException
    //   135	142	395	finally
    //   147	154	395	finally
    //   159	170	395	finally
    //   245	251	395	finally
    //   255	261	395	finally
    //   265	274	395	finally
    //   278	286	395	finally
    //   290	298	395	finally
    //   302	313	395	finally
    //   404	408	411	java/io/IOException
    //   420	424	427	java/io/IOException
  }
  
  /* Error */
  public static boolean a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +53 -> 56
    //   6: new 23	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc 106
    //   19: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 4
    //   25: aload_1
    //   26: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: ldc 32
    //   34: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: aload_2
    //   41: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 34
    //   47: iconst_2
    //   48: aload 4
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: ifnull +334 -> 391
    //   60: aload_1
    //   61: ifnull +330 -> 391
    //   64: aload_1
    //   65: ldc 44
    //   67: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +321 -> 391
    //   73: aload_2
    //   74: ifnull +317 -> 391
    //   77: aload_2
    //   78: ldc 44
    //   80: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq +5 -> 88
    //   86: iconst_0
    //   87: ireturn
    //   88: new 52	java/io/File
    //   91: dup
    //   92: aload_1
    //   93: aload_2
    //   94: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: astore 7
    //   99: new 23	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   106: astore 4
    //   108: aload 4
    //   110: aload_2
    //   111: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: ldc 108
    //   119: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: new 52	java/io/File
    //   126: dup
    //   127: aload_1
    //   128: aload 4
    //   130: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: astore 8
    //   138: iconst_0
    //   139: newarray byte
    //   141: astore 5
    //   143: aload_0
    //   144: ldc 78
    //   146: invokevirtual 112	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   149: astore_0
    //   150: aload_0
    //   151: astore 5
    //   153: goto +8 -> 161
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 113	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   161: aload 7
    //   163: invokevirtual 117	java/io/File:getParentFile	()Ljava/io/File;
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual 58	java/io/File:exists	()Z
    //   171: ifne +8 -> 179
    //   174: aload_0
    //   175: invokevirtual 120	java/io/File:mkdir	()Z
    //   178: pop
    //   179: aload 8
    //   181: invokevirtual 58	java/io/File:exists	()Z
    //   184: ifeq +9 -> 193
    //   187: aload 8
    //   189: invokevirtual 91	java/io/File:delete	()Z
    //   192: pop
    //   193: aconst_null
    //   194: astore_2
    //   195: aconst_null
    //   196: astore_1
    //   197: aconst_null
    //   198: astore 6
    //   200: new 122	java/io/FileOutputStream
    //   203: dup
    //   204: aload 8
    //   206: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   209: astore_0
    //   210: aload_2
    //   211: astore_1
    //   212: aload_0
    //   213: astore_2
    //   214: new 125	java/io/BufferedOutputStream
    //   217: dup
    //   218: aload_0
    //   219: invokespecial 128	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   222: astore 4
    //   224: aload 4
    //   226: aload 5
    //   228: invokevirtual 132	java/io/BufferedOutputStream:write	([B)V
    //   231: aload 4
    //   233: invokevirtual 135	java/io/BufferedOutputStream:flush	()V
    //   236: aload 8
    //   238: aload 7
    //   240: invokestatic 141	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   243: istore_3
    //   244: aload 4
    //   246: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   249: goto +8 -> 257
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   257: aload_0
    //   258: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   261: iload_3
    //   262: ireturn
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   268: iload_3
    //   269: ireturn
    //   270: astore_2
    //   271: aload 4
    //   273: astore_1
    //   274: goto +83 -> 357
    //   277: astore 5
    //   279: goto +26 -> 305
    //   282: astore 5
    //   284: aload 6
    //   286: astore 4
    //   288: goto +17 -> 305
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_0
    //   294: goto +63 -> 357
    //   297: astore 5
    //   299: aconst_null
    //   300: astore_0
    //   301: aload 6
    //   303: astore 4
    //   305: aload 4
    //   307: astore_1
    //   308: aload_0
    //   309: astore_2
    //   310: aload 5
    //   312: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   315: aload 4
    //   317: ifnull +16 -> 333
    //   320: aload 4
    //   322: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   325: goto +8 -> 333
    //   328: astore_1
    //   329: aload_1
    //   330: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   333: aload_0
    //   334: ifnull +14 -> 348
    //   337: aload_0
    //   338: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   341: iconst_0
    //   342: ireturn
    //   343: astore_0
    //   344: aload_0
    //   345: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   348: iconst_0
    //   349: ireturn
    //   350: astore 4
    //   352: aload_2
    //   353: astore_0
    //   354: aload 4
    //   356: astore_2
    //   357: aload_1
    //   358: ifnull +15 -> 373
    //   361: aload_1
    //   362: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   365: goto +8 -> 373
    //   368: astore_1
    //   369: aload_1
    //   370: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   373: aload_0
    //   374: ifnull +15 -> 389
    //   377: aload_0
    //   378: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   381: goto +8 -> 389
    //   384: astore_0
    //   385: aload_0
    //   386: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   389: aload_2
    //   390: athrow
    //   391: iconst_0
    //   392: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	paramString1	java.lang.String
    //   0	393	1	paramString2	java.lang.String
    //   0	393	2	paramString3	java.lang.String
    //   243	26	3	bool	boolean
    //   13	308	4	localObject1	Object
    //   350	5	4	localObject2	Object
    //   141	86	5	localObject3	Object
    //   277	1	5	localIOException1	java.io.IOException
    //   282	1	5	localIOException2	java.io.IOException
    //   297	14	5	localIOException3	java.io.IOException
    //   198	104	6	localObject4	Object
    //   97	142	7	localFile1	java.io.File
    //   136	101	8	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   143	150	156	java/io/UnsupportedEncodingException
    //   244	249	252	java/io/IOException
    //   257	261	263	java/io/IOException
    //   224	244	270	finally
    //   224	244	277	java/io/IOException
    //   214	224	282	java/io/IOException
    //   200	210	291	finally
    //   200	210	297	java/io/IOException
    //   320	325	328	java/io/IOException
    //   337	341	343	java/io/IOException
    //   214	224	350	finally
    //   310	315	350	finally
    //   361	365	368	java/io/IOException
    //   377	381	384	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.MediaCodecFileUtils
 * JD-Core Version:    0.7.0.1
 */