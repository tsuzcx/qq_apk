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
    //   38: astore 4
    //   40: aload 4
    //   42: aload_3
    //   43: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: ldc 42
    //   51: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 8
    //   62: new 30	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   69: astore_3
    //   70: aload_3
    //   71: invokestatic 55	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   74: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   77: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_3
    //   82: aload 8
    //   84: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: new 57	java/io/File
    //   91: dup
    //   92: aload_3
    //   93: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 65	java/io/File:mkdirs	()Z
    //   102: pop
    //   103: invokestatic 71	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   106: astore_3
    //   107: ldc 73
    //   109: aload_1
    //   110: invokevirtual 78	android/net/Uri:getScheme	()Ljava/lang/String;
    //   113: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifeq +44 -> 160
    //   119: new 30	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   126: astore 4
    //   128: aload 4
    //   130: aload_3
    //   131: invokevirtual 88	java/util/Calendar:getTimeInMillis	()J
    //   134: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 4
    //   140: aload_1
    //   141: invokevirtual 94	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   144: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 4
    //   150: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore_3
    //   154: aconst_null
    //   155: astore 5
    //   157: goto +85 -> 242
    //   160: aload_0
    //   161: invokevirtual 100	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   164: aload_1
    //   165: iconst_1
    //   166: anewarray 80	java/lang/String
    //   169: dup
    //   170: iconst_0
    //   171: ldc 102
    //   173: aastore
    //   174: aconst_null
    //   175: aconst_null
    //   176: aconst_null
    //   177: invokevirtual 108	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   180: astore 4
    //   182: aload 4
    //   184: ifnull +52 -> 236
    //   187: aload 4
    //   189: astore_3
    //   190: aload 4
    //   192: invokeinterface 113 1 0
    //   197: ifeq +39 -> 236
    //   200: aload 4
    //   202: astore_3
    //   203: aload 4
    //   205: aload 4
    //   207: ldc 102
    //   209: invokeinterface 117 2 0
    //   214: invokeinterface 121 2 0
    //   219: astore 5
    //   221: aload 5
    //   223: astore_3
    //   224: aload 4
    //   226: astore 5
    //   228: goto +14 -> 242
    //   231: astore 5
    //   233: goto +41 -> 274
    //   236: aconst_null
    //   237: astore_3
    //   238: aload 4
    //   240: astore 5
    //   242: aload_3
    //   243: astore 4
    //   245: aload 5
    //   247: ifnull +91 -> 338
    //   250: aload 5
    //   252: invokeinterface 124 1 0
    //   257: aload_3
    //   258: astore 4
    //   260: goto +78 -> 338
    //   263: astore_0
    //   264: aconst_null
    //   265: astore_3
    //   266: goto +304 -> 570
    //   269: astore 5
    //   271: aconst_null
    //   272: astore 4
    //   274: aload 4
    //   276: astore_3
    //   277: new 30	java/lang/StringBuilder
    //   280: dup
    //   281: ldc 126
    //   283: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   286: astore 9
    //   288: aload 4
    //   290: astore_3
    //   291: aload 9
    //   293: aload 5
    //   295: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   298: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 4
    //   304: astore_3
    //   305: ldc 131
    //   307: aload 9
    //   309: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 137	com/sina/weibo/sdk/c/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload 4
    //   317: astore_3
    //   318: aload 5
    //   320: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   323: aload 4
    //   325: ifnull +355 -> 680
    //   328: aload 4
    //   330: invokeinterface 124 1 0
    //   335: goto +345 -> 680
    //   338: aload 4
    //   340: astore_3
    //   341: aload 4
    //   343: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   346: ifeq +47 -> 393
    //   349: new 30	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   356: astore 4
    //   358: aload 4
    //   360: invokestatic 71	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   363: invokevirtual 88	java/util/Calendar:getTimeInMillis	()J
    //   366: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: iload_2
    //   371: ifne +315 -> 686
    //   374: ldc 142
    //   376: astore_3
    //   377: goto +3 -> 380
    //   380: aload 4
    //   382: aload_3
    //   383: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 4
    //   389: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: astore_3
    //   393: new 144	java/io/BufferedInputStream
    //   396: dup
    //   397: new 146	java/io/FileInputStream
    //   400: dup
    //   401: aload_0
    //   402: invokevirtual 100	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   405: aload_1
    //   406: ldc 148
    //   408: invokevirtual 152	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   411: invokevirtual 158	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   414: invokespecial 161	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   417: invokespecial 164	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   420: astore 4
    //   422: new 30	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   429: astore_0
    //   430: aload_0
    //   431: invokestatic 55	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   434: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   437: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload_0
    //   442: aload 8
    //   444: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload_0
    //   449: aload_3
    //   450: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: new 57	java/io/File
    //   457: dup
    //   458: aload_0
    //   459: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   465: astore_1
    //   466: aload_1
    //   467: invokevirtual 167	java/io/File:exists	()Z
    //   470: ifeq +8 -> 478
    //   473: aload_1
    //   474: invokevirtual 170	java/io/File:delete	()Z
    //   477: pop
    //   478: new 172	java/io/FileOutputStream
    //   481: dup
    //   482: aload_1
    //   483: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   486: astore_0
    //   487: sipush 1444
    //   490: newarray byte
    //   492: astore_3
    //   493: aload 4
    //   495: aload_3
    //   496: invokevirtual 181	java/io/InputStream:read	([B)I
    //   499: istore_2
    //   500: iload_2
    //   501: iconst_m1
    //   502: if_icmpeq +13 -> 515
    //   505: aload_0
    //   506: aload_3
    //   507: iconst_0
    //   508: iload_2
    //   509: invokevirtual 187	java/io/OutputStream:write	([BII)V
    //   512: goto -19 -> 493
    //   515: aload_1
    //   516: invokevirtual 190	java/io/File:getPath	()Ljava/lang/String;
    //   519: astore_1
    //   520: aload 4
    //   522: invokevirtual 191	java/io/InputStream:close	()V
    //   525: aload_0
    //   526: invokevirtual 192	java/io/OutputStream:close	()V
    //   529: aload_1
    //   530: areturn
    //   531: astore_0
    //   532: aload_0
    //   533: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   536: aload_1
    //   537: areturn
    //   538: astore_3
    //   539: goto +12 -> 551
    //   542: astore_3
    //   543: aload_0
    //   544: astore_1
    //   545: goto +18 -> 563
    //   548: astore_3
    //   549: aconst_null
    //   550: astore_0
    //   551: aload 4
    //   553: astore_1
    //   554: aload_0
    //   555: astore 4
    //   557: goto +87 -> 644
    //   560: astore_3
    //   561: aconst_null
    //   562: astore_1
    //   563: aload 4
    //   565: astore_0
    //   566: goto +32 -> 598
    //   569: astore_0
    //   570: aload_3
    //   571: ifnull +9 -> 580
    //   574: aload_3
    //   575: invokeinterface 124 1 0
    //   580: aload_0
    //   581: athrow
    //   582: astore_3
    //   583: aconst_null
    //   584: astore 4
    //   586: aload 7
    //   588: astore_1
    //   589: goto +55 -> 644
    //   592: astore_3
    //   593: aconst_null
    //   594: astore_1
    //   595: aload 6
    //   597: astore_0
    //   598: new 30	java/lang/StringBuilder
    //   601: dup
    //   602: ldc 194
    //   604: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   607: astore 4
    //   609: aload 4
    //   611: aload_3
    //   612: invokevirtual 129	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   615: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: ldc 131
    //   621: aload 4
    //   623: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 137	com/sina/weibo/sdk/c/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: new 196	java/lang/Throwable
    //   632: dup
    //   633: aload_3
    //   634: invokespecial 199	java/lang/Throwable:<init>	(Ljava/lang/Throwable;)V
    //   637: athrow
    //   638: astore_3
    //   639: aload_1
    //   640: astore 4
    //   642: aload_0
    //   643: astore_1
    //   644: aload_1
    //   645: ifnull +10 -> 655
    //   648: aload_1
    //   649: invokevirtual 191	java/io/InputStream:close	()V
    //   652: goto +3 -> 655
    //   655: aload 4
    //   657: ifnull +15 -> 672
    //   660: aload 4
    //   662: invokevirtual 192	java/io/OutputStream:close	()V
    //   665: goto +7 -> 672
    //   668: aload_0
    //   669: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   672: goto +5 -> 677
    //   675: aload_3
    //   676: athrow
    //   677: goto -2 -> 675
    //   680: aconst_null
    //   681: astore 4
    //   683: goto -345 -> 338
    //   686: ldc 201
    //   688: astore_3
    //   689: goto -309 -> 380
    //   692: astore_0
    //   693: goto -25 -> 668
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	paramContext	android.content.Context
    //   0	696	1	paramUri	android.net.Uri
    //   0	696	2	paramInt	int
    //   17	490	3	localObject1	Object
    //   538	1	3	localObject2	Object
    //   542	1	3	localException1	java.lang.Exception
    //   548	1	3	localObject3	Object
    //   560	15	3	localException2	java.lang.Exception
    //   582	1	3	localObject4	Object
    //   592	42	3	localException3	java.lang.Exception
    //   638	38	3	localObject5	Object
    //   688	1	3	str1	java.lang.String
    //   13	669	4	localObject6	Object
    //   155	72	5	localObject7	Object
    //   231	1	5	localException4	java.lang.Exception
    //   240	11	5	localObject8	Object
    //   269	50	5	localException5	java.lang.Exception
    //   4	592	6	localObject9	Object
    //   1	586	7	localObject10	Object
    //   60	383	8	str2	java.lang.String
    //   286	22	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   190	200	231	java/lang/Exception
    //   203	221	231	java/lang/Exception
    //   107	154	263	finally
    //   160	182	263	finally
    //   107	154	269	java/lang/Exception
    //   160	182	269	java/lang/Exception
    //   520	529	531	java/lang/Exception
    //   487	493	538	finally
    //   493	500	538	finally
    //   505	512	538	finally
    //   515	520	538	finally
    //   487	493	542	java/lang/Exception
    //   493	500	542	java/lang/Exception
    //   505	512	542	java/lang/Exception
    //   515	520	542	java/lang/Exception
    //   422	478	548	finally
    //   478	487	548	finally
    //   422	478	560	java/lang/Exception
    //   478	487	560	java/lang/Exception
    //   190	200	569	finally
    //   203	221	569	finally
    //   277	288	569	finally
    //   291	302	569	finally
    //   305	315	569	finally
    //   318	323	569	finally
    //   6	15	582	finally
    //   18	26	582	finally
    //   29	107	582	finally
    //   250	257	582	finally
    //   328	335	582	finally
    //   341	370	582	finally
    //   380	393	582	finally
    //   393	422	582	finally
    //   574	580	582	finally
    //   580	582	582	finally
    //   6	15	592	java/lang/Exception
    //   18	26	592	java/lang/Exception
    //   29	107	592	java/lang/Exception
    //   250	257	592	java/lang/Exception
    //   328	335	592	java/lang/Exception
    //   341	370	592	java/lang/Exception
    //   380	393	592	java/lang/Exception
    //   393	422	592	java/lang/Exception
    //   574	580	592	java/lang/Exception
    //   580	582	592	java/lang/Exception
    //   598	638	638	finally
    //   648	652	692	java/lang/Exception
    //   660	665	692	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.a
 * JD-Core Version:    0.7.0.1
 */