package com.sina.weibo.sdk.share;

public final class a
{
  /* Error */
  protected static java.lang.String a(android.content.Context paramContext, android.net.Uri paramUri, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: invokestatic 14	com/sina/weibo/sdk/c/a:c	(Landroid/content/Context;)Lcom/sina/weibo/sdk/c/a$a;
    //   10: getfield 20	com/sina/weibo/sdk/c/a$a:packageName	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 4
    //   20: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +6 -> 29
    //   26: ldc 28
    //   28: astore_3
    //   29: new 30	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 32
    //   35: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_3
    //   39: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 42
    //   44: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 8
    //   52: new 48	java/io/File
    //   55: dup
    //   56: new 30	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   63: invokestatic 57	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   66: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 8
    //   74: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: invokevirtual 65	java/io/File:mkdirs	()Z
    //   86: pop
    //   87: invokestatic 71	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   90: astore_3
    //   91: ldc 73
    //   93: aload_1
    //   94: invokevirtual 78	android/net/Uri:getScheme	()Ljava/lang/String;
    //   97: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifeq +283 -> 383
    //   103: new 30	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   110: aload_3
    //   111: invokevirtual 88	java/util/Calendar:getTimeInMillis	()J
    //   114: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 94	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   121: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore 4
    //   129: aconst_null
    //   130: astore 5
    //   132: aload 4
    //   134: astore_3
    //   135: aload 5
    //   137: ifnull +13 -> 150
    //   140: aload 5
    //   142: invokeinterface 99 1 0
    //   147: aload 4
    //   149: astore_3
    //   150: aload_3
    //   151: astore 4
    //   153: aload_3
    //   154: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifeq +39 -> 196
    //   160: new 30	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   167: invokestatic 71	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   170: invokevirtual 88	java/util/Calendar:getTimeInMillis	()J
    //   173: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   176: astore 4
    //   178: iload_2
    //   179: ifne +339 -> 518
    //   182: ldc 101
    //   184: astore_3
    //   185: aload 4
    //   187: aload_3
    //   188: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: astore 4
    //   196: new 103	java/io/BufferedInputStream
    //   199: dup
    //   200: new 105	java/io/FileInputStream
    //   203: dup
    //   204: aload_0
    //   205: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   208: aload_1
    //   209: ldc 113
    //   211: invokevirtual 119	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   214: invokevirtual 125	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   217: invokespecial 128	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   220: invokespecial 131	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   223: astore_1
    //   224: new 48	java/io/File
    //   227: dup
    //   228: new 30	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   235: invokestatic 57	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   238: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   241: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 8
    //   246: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 4
    //   251: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: astore_3
    //   261: aload_3
    //   262: invokevirtual 134	java/io/File:exists	()Z
    //   265: ifeq +8 -> 273
    //   268: aload_3
    //   269: invokevirtual 137	java/io/File:delete	()Z
    //   272: pop
    //   273: new 139	java/io/FileOutputStream
    //   276: dup
    //   277: aload_3
    //   278: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   281: astore_0
    //   282: sipush 1444
    //   285: newarray byte
    //   287: astore 4
    //   289: aload_1
    //   290: aload 4
    //   292: invokevirtual 148	java/io/InputStream:read	([B)I
    //   295: istore_2
    //   296: iload_2
    //   297: iconst_m1
    //   298: if_icmpeq +226 -> 524
    //   301: aload_0
    //   302: aload 4
    //   304: iconst_0
    //   305: iload_2
    //   306: invokevirtual 154	java/io/OutputStream:write	([BII)V
    //   309: goto -20 -> 289
    //   312: astore 4
    //   314: aload_1
    //   315: astore_3
    //   316: aload_0
    //   317: astore_1
    //   318: aload_3
    //   319: astore_0
    //   320: aload 4
    //   322: astore_3
    //   323: ldc 156
    //   325: new 30	java/lang/StringBuilder
    //   328: dup
    //   329: ldc 158
    //   331: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: aload_3
    //   335: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   338: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 167	com/sina/weibo/sdk/c/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: new 169	java/lang/Throwable
    //   350: dup
    //   351: aload_3
    //   352: invokespecial 172	java/lang/Throwable:<init>	(Ljava/lang/Throwable;)V
    //   355: athrow
    //   356: astore 4
    //   358: aload_1
    //   359: astore_3
    //   360: aload_0
    //   361: astore_1
    //   362: aload 4
    //   364: astore_0
    //   365: aload_1
    //   366: ifnull +7 -> 373
    //   369: aload_1
    //   370: invokevirtual 173	java/io/InputStream:close	()V
    //   373: aload_3
    //   374: ifnull +7 -> 381
    //   377: aload_3
    //   378: invokevirtual 174	java/io/OutputStream:close	()V
    //   381: aload_0
    //   382: athrow
    //   383: aload_0
    //   384: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   387: aload_1
    //   388: iconst_1
    //   389: anewarray 80	java/lang/String
    //   392: dup
    //   393: iconst_0
    //   394: ldc 176
    //   396: aastore
    //   397: aconst_null
    //   398: aconst_null
    //   399: aconst_null
    //   400: invokevirtual 180	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   403: astore_3
    //   404: aload_3
    //   405: ifnull +198 -> 603
    //   408: aload_3
    //   409: astore 4
    //   411: aload_3
    //   412: invokeinterface 183 1 0
    //   417: ifeq +186 -> 603
    //   420: aload_3
    //   421: astore 4
    //   423: aload_3
    //   424: aload_3
    //   425: ldc 176
    //   427: invokeinterface 187 2 0
    //   432: invokeinterface 191 2 0
    //   437: astore 5
    //   439: aload 5
    //   441: astore 4
    //   443: aload_3
    //   444: astore 5
    //   446: goto -314 -> 132
    //   449: astore 5
    //   451: aconst_null
    //   452: astore_3
    //   453: aload_3
    //   454: astore 4
    //   456: ldc 156
    //   458: new 30	java/lang/StringBuilder
    //   461: dup
    //   462: ldc 193
    //   464: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   467: aload 5
    //   469: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   472: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 167	com/sina/weibo/sdk/c/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload_3
    //   482: astore 4
    //   484: aload 5
    //   486: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   489: aload_3
    //   490: ifnull +108 -> 598
    //   493: aload_3
    //   494: invokeinterface 99 1 0
    //   499: aconst_null
    //   500: astore_3
    //   501: goto -351 -> 150
    //   504: aload 4
    //   506: ifnull +10 -> 516
    //   509: aload 4
    //   511: invokeinterface 99 1 0
    //   516: aload_0
    //   517: athrow
    //   518: ldc 198
    //   520: astore_3
    //   521: goto -336 -> 185
    //   524: aload_3
    //   525: invokevirtual 201	java/io/File:getPath	()Ljava/lang/String;
    //   528: astore_3
    //   529: aload_1
    //   530: invokevirtual 173	java/io/InputStream:close	()V
    //   533: aload_0
    //   534: invokevirtual 174	java/io/OutputStream:close	()V
    //   537: aload_3
    //   538: areturn
    //   539: astore_0
    //   540: aload_0
    //   541: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   544: aload_3
    //   545: areturn
    //   546: astore_1
    //   547: aload_1
    //   548: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   551: goto -170 -> 381
    //   554: astore_0
    //   555: aconst_null
    //   556: astore_1
    //   557: aload 7
    //   559: astore_3
    //   560: goto -195 -> 365
    //   563: astore_0
    //   564: aload 7
    //   566: astore_3
    //   567: goto -202 -> 365
    //   570: astore 4
    //   572: aload_0
    //   573: astore_3
    //   574: aload 4
    //   576: astore_0
    //   577: goto -212 -> 365
    //   580: astore_3
    //   581: aload_1
    //   582: astore_0
    //   583: aload 6
    //   585: astore_1
    //   586: goto -263 -> 323
    //   589: astore_0
    //   590: goto -86 -> 504
    //   593: astore 5
    //   595: goto -142 -> 453
    //   598: aconst_null
    //   599: astore_3
    //   600: goto -450 -> 150
    //   603: aconst_null
    //   604: astore 4
    //   606: aload_3
    //   607: astore 5
    //   609: goto -477 -> 132
    //   612: astore_0
    //   613: aconst_null
    //   614: astore 4
    //   616: goto -112 -> 504
    //   619: astore_3
    //   620: aconst_null
    //   621: astore_0
    //   622: aload 6
    //   624: astore_1
    //   625: goto -302 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	paramContext	android.content.Context
    //   0	628	1	paramUri	android.net.Uri
    //   0	628	2	paramInt	int
    //   17	557	3	localObject1	Object
    //   580	1	3	localException1	java.lang.Exception
    //   599	8	3	localObject2	Object
    //   619	1	3	localException2	java.lang.Exception
    //   13	290	4	localObject3	Object
    //   312	9	4	localException3	java.lang.Exception
    //   356	7	4	localObject4	Object
    //   409	101	4	localObject5	Object
    //   570	5	4	localObject6	Object
    //   604	11	4	localObject7	Object
    //   130	315	5	localObject8	Object
    //   449	36	5	localException4	java.lang.Exception
    //   593	1	5	localException5	java.lang.Exception
    //   607	1	5	localObject9	Object
    //   4	619	6	localObject10	Object
    //   1	564	7	localObject11	Object
    //   50	195	8	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   282	289	312	java/lang/Exception
    //   289	296	312	java/lang/Exception
    //   301	309	312	java/lang/Exception
    //   524	529	312	java/lang/Exception
    //   323	356	356	finally
    //   91	129	449	java/lang/Exception
    //   383	404	449	java/lang/Exception
    //   529	537	539	java/lang/Exception
    //   369	373	546	java/lang/Exception
    //   377	381	546	java/lang/Exception
    //   6	15	554	finally
    //   18	26	554	finally
    //   29	91	554	finally
    //   140	147	554	finally
    //   153	178	554	finally
    //   185	196	554	finally
    //   196	224	554	finally
    //   493	499	554	finally
    //   509	516	554	finally
    //   516	518	554	finally
    //   224	273	563	finally
    //   273	282	563	finally
    //   282	289	570	finally
    //   289	296	570	finally
    //   301	309	570	finally
    //   524	529	570	finally
    //   224	273	580	java/lang/Exception
    //   273	282	580	java/lang/Exception
    //   411	420	589	finally
    //   423	439	589	finally
    //   456	481	589	finally
    //   484	489	589	finally
    //   411	420	593	java/lang/Exception
    //   423	439	593	java/lang/Exception
    //   91	129	612	finally
    //   383	404	612	finally
    //   6	15	619	java/lang/Exception
    //   18	26	619	java/lang/Exception
    //   29	91	619	java/lang/Exception
    //   140	147	619	java/lang/Exception
    //   153	178	619	java/lang/Exception
    //   185	196	619	java/lang/Exception
    //   196	224	619	java/lang/Exception
    //   493	499	619	java/lang/Exception
    //   509	516	619	java/lang/Exception
    //   516	518	619	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.a
 * JD-Core Version:    0.7.0.1
 */