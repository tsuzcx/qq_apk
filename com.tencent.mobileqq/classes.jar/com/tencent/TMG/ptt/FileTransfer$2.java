package com.tencent.TMG.ptt;

class FileTransfer$2
  implements Runnable
{
  FileTransfer$2(FileTransfer paramFileTransfer, String paramString1, String paramString2, String paramString3, PttListener.DownloadFileListener paramDownloadFileListener) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 9
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 6
    //   17: sipush 12292
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 20	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   25: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +75 -> 103
    //   31: ldc 45
    //   33: ldc 47
    //   35: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aconst_null
    //   40: astore 4
    //   42: aconst_null
    //   43: astore 5
    //   45: iload_2
    //   46: istore_1
    //   47: aload 5
    //   49: ifnull +8 -> 57
    //   52: aload 5
    //   54: invokevirtual 58	java/io/FileOutputStream:close	()V
    //   57: aload 4
    //   59: ifnull +8 -> 67
    //   62: aload 4
    //   64: invokevirtual 61	java/io/InputStream:close	()V
    //   67: aload 6
    //   69: ifnull +8 -> 77
    //   72: aload 6
    //   74: invokevirtual 66	java/net/HttpURLConnection:disconnect	()V
    //   77: aload_0
    //   78: getfield 26	com/tencent/TMG/ptt/FileTransfer$2:val$monitor	Lcom/tencent/TMG/ptt/PttListener$DownloadFileListener;
    //   81: ifnull +21 -> 102
    //   84: aload_0
    //   85: getfield 26	com/tencent/TMG/ptt/FileTransfer$2:val$monitor	Lcom/tencent/TMG/ptt/PttListener$DownloadFileListener;
    //   88: iload_1
    //   89: aload_0
    //   90: getfield 22	com/tencent/TMG/ptt/FileTransfer$2:val$savePath	Ljava/lang/String;
    //   93: aload_0
    //   94: getfield 20	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   97: invokeinterface 72 4 0
    //   102: return
    //   103: aload_0
    //   104: getfield 22	com/tencent/TMG/ptt/FileTransfer$2:val$savePath	Ljava/lang/String;
    //   107: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifeq +24 -> 134
    //   113: ldc 45
    //   115: ldc 74
    //   117: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   120: pop
    //   121: sipush 12289
    //   124: istore_1
    //   125: aconst_null
    //   126: astore 4
    //   128: aconst_null
    //   129: astore 5
    //   131: goto -84 -> 47
    //   134: new 76	java/net/URL
    //   137: dup
    //   138: aload_0
    //   139: getfield 20	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   142: invokespecial 79	java/net/URL:<init>	(Ljava/lang/String;)V
    //   145: invokevirtual 83	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   148: checkcast 63	java/net/HttpURLConnection
    //   151: astore 4
    //   153: aload 4
    //   155: ldc 85
    //   157: invokevirtual 88	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   160: aload 4
    //   162: ldc 90
    //   164: aload_0
    //   165: getfield 24	com/tencent/TMG/ptt/FileTransfer$2:val$sign	Ljava/lang/String;
    //   168: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload 4
    //   173: ldc 96
    //   175: ldc 98
    //   177: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload 4
    //   182: ldc 100
    //   184: ldc 102
    //   186: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload 4
    //   191: invokevirtual 106	java/net/HttpURLConnection:getResponseCode	()I
    //   194: istore_3
    //   195: iload_3
    //   196: sipush 200
    //   199: if_icmpne +251 -> 450
    //   202: new 108	java/io/File
    //   205: dup
    //   206: aload_0
    //   207: getfield 22	com/tencent/TMG/ptt/FileTransfer$2:val$savePath	Ljava/lang/String;
    //   210: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   213: astore 5
    //   215: aload 5
    //   217: invokevirtual 113	java/io/File:exists	()Z
    //   220: ifne +9 -> 229
    //   223: aload 5
    //   225: invokevirtual 116	java/io/File:createNewFile	()Z
    //   228: pop
    //   229: new 55	java/io/FileOutputStream
    //   232: dup
    //   233: aload 5
    //   235: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   238: astore 5
    //   240: aload 4
    //   242: invokevirtual 123	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   245: astore 6
    //   247: aload 6
    //   249: astore 7
    //   251: aload 6
    //   253: astore 8
    //   255: aload 6
    //   257: astore 9
    //   259: aload 4
    //   261: invokevirtual 123	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   264: astore 6
    //   266: aload 6
    //   268: astore 7
    //   270: aload 6
    //   272: astore 8
    //   274: aload 6
    //   276: astore 9
    //   278: sipush 1024
    //   281: newarray byte
    //   283: astore 10
    //   285: aload 6
    //   287: astore 7
    //   289: aload 6
    //   291: astore 8
    //   293: aload 6
    //   295: astore 9
    //   297: aload 6
    //   299: aload 10
    //   301: invokevirtual 127	java/io/InputStream:read	([B)I
    //   304: istore_3
    //   305: iload_3
    //   306: iconst_m1
    //   307: if_icmpeq +112 -> 419
    //   310: aload 6
    //   312: astore 7
    //   314: aload 6
    //   316: astore 8
    //   318: aload 6
    //   320: astore 9
    //   322: aload 5
    //   324: aload 10
    //   326: iconst_0
    //   327: iload_3
    //   328: invokevirtual 131	java/io/FileOutputStream:write	([BII)V
    //   331: goto -46 -> 285
    //   334: astore 8
    //   336: aload 4
    //   338: astore 6
    //   340: aload 7
    //   342: astore 4
    //   344: aload 8
    //   346: astore 7
    //   348: ldc 45
    //   350: new 133	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   357: ldc 136
    //   359: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_0
    //   363: getfield 20	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   366: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   375: pop
    //   376: aload 7
    //   378: invokevirtual 147	java/net/MalformedURLException:printStackTrace	()V
    //   381: iload_2
    //   382: istore_1
    //   383: goto -336 -> 47
    //   386: astore 6
    //   388: ldc 45
    //   390: ldc 149
    //   392: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   395: pop
    //   396: aload 6
    //   398: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   401: sipush 12291
    //   404: istore_1
    //   405: aconst_null
    //   406: astore 7
    //   408: aload 4
    //   410: astore 6
    //   412: aload 7
    //   414: astore 4
    //   416: goto -369 -> 47
    //   419: aload 6
    //   421: astore 7
    //   423: aload 5
    //   425: astore 6
    //   427: aload 7
    //   429: astore 5
    //   431: aload 6
    //   433: astore 7
    //   435: aload 4
    //   437: astore 6
    //   439: aload 5
    //   441: astore 4
    //   443: aload 7
    //   445: astore 5
    //   447: goto -400 -> 47
    //   450: iload_3
    //   451: sipush 404
    //   454: if_icmpne +45 -> 499
    //   457: ldc 45
    //   459: new 133	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   466: ldc 136
    //   468: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload_0
    //   472: getfield 20	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   475: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   484: pop
    //   485: sipush 12292
    //   488: istore_1
    //   489: aconst_null
    //   490: astore 5
    //   492: aload 9
    //   494: astore 6
    //   496: goto -65 -> 431
    //   499: ldc 45
    //   501: new 133	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   508: ldc 152
    //   510: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_0
    //   514: getfield 20	com/tencent/TMG/ptt/FileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   517: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   526: pop
    //   527: sipush 12291
    //   530: istore_1
    //   531: aconst_null
    //   532: astore 5
    //   534: aload 9
    //   536: astore 6
    //   538: goto -107 -> 431
    //   541: astore 8
    //   543: aconst_null
    //   544: astore 4
    //   546: aconst_null
    //   547: astore 5
    //   549: aload 7
    //   551: astore 6
    //   553: aload 8
    //   555: astore 7
    //   557: ldc 45
    //   559: ldc 154
    //   561: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   564: pop
    //   565: aload 7
    //   567: invokevirtual 155	java/net/UnknownHostException:printStackTrace	()V
    //   570: sipush 12291
    //   573: istore_1
    //   574: goto -527 -> 47
    //   577: astore 7
    //   579: aconst_null
    //   580: astore 4
    //   582: aconst_null
    //   583: astore 5
    //   585: aload 8
    //   587: astore 6
    //   589: ldc 45
    //   591: new 133	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   598: ldc 157
    //   600: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_0
    //   604: getfield 22	com/tencent/TMG/ptt/FileTransfer$2:val$savePath	Ljava/lang/String;
    //   607: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   616: pop
    //   617: aload 7
    //   619: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   622: sipush 12289
    //   625: istore_1
    //   626: goto -579 -> 47
    //   629: astore 5
    //   631: aload 5
    //   633: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   636: goto -579 -> 57
    //   639: astore 4
    //   641: aload 4
    //   643: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   646: goto -579 -> 67
    //   649: astore 7
    //   651: aconst_null
    //   652: astore 5
    //   654: aconst_null
    //   655: astore 8
    //   657: aload 4
    //   659: astore 6
    //   661: aload 8
    //   663: astore 4
    //   665: goto -76 -> 589
    //   668: astore 7
    //   670: aconst_null
    //   671: astore 8
    //   673: aload 4
    //   675: astore 6
    //   677: aload 8
    //   679: astore 4
    //   681: goto -92 -> 589
    //   684: astore 7
    //   686: aload 4
    //   688: astore 6
    //   690: aload 8
    //   692: astore 4
    //   694: goto -105 -> 589
    //   697: astore 7
    //   699: aconst_null
    //   700: astore 5
    //   702: aconst_null
    //   703: astore 8
    //   705: aload 4
    //   707: astore 6
    //   709: aload 8
    //   711: astore 4
    //   713: goto -156 -> 557
    //   716: astore 7
    //   718: aconst_null
    //   719: astore 8
    //   721: aload 4
    //   723: astore 6
    //   725: aload 8
    //   727: astore 4
    //   729: goto -172 -> 557
    //   732: astore 7
    //   734: aload 4
    //   736: astore 6
    //   738: aload 9
    //   740: astore 4
    //   742: goto -185 -> 557
    //   745: astore 7
    //   747: aconst_null
    //   748: astore 4
    //   750: aconst_null
    //   751: astore 8
    //   753: aload 5
    //   755: astore 6
    //   757: aload 8
    //   759: astore 5
    //   761: goto -413 -> 348
    //   764: astore 7
    //   766: aconst_null
    //   767: astore 5
    //   769: aconst_null
    //   770: astore 8
    //   772: aload 4
    //   774: astore 6
    //   776: aload 8
    //   778: astore 4
    //   780: goto -432 -> 348
    //   783: astore 7
    //   785: aconst_null
    //   786: astore 8
    //   788: aload 4
    //   790: astore 6
    //   792: aload 8
    //   794: astore 4
    //   796: goto -448 -> 348
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	this	2
    //   1	625	1	i	int
    //   20	362	2	j	int
    //   194	261	3	k	int
    //   40	541	4	localObject1	Object
    //   639	19	4	localIOException1	java.io.IOException
    //   663	132	4	localObject2	Object
    //   3	581	5	localObject3	Object
    //   629	3	5	localIOException2	java.io.IOException
    //   652	116	5	localObject4	Object
    //   15	324	6	localObject5	Object
    //   386	11	6	localIOException3	java.io.IOException
    //   410	381	6	localObject6	Object
    //   9	557	7	localObject7	Object
    //   577	41	7	localIOException4	java.io.IOException
    //   649	1	7	localIOException5	java.io.IOException
    //   668	1	7	localIOException6	java.io.IOException
    //   684	1	7	localIOException7	java.io.IOException
    //   697	1	7	localUnknownHostException1	java.net.UnknownHostException
    //   716	1	7	localUnknownHostException2	java.net.UnknownHostException
    //   732	1	7	localUnknownHostException3	java.net.UnknownHostException
    //   745	1	7	localMalformedURLException1	java.net.MalformedURLException
    //   764	1	7	localMalformedURLException2	java.net.MalformedURLException
    //   783	1	7	localMalformedURLException3	java.net.MalformedURLException
    //   12	305	8	localObject8	Object
    //   334	11	8	localMalformedURLException4	java.net.MalformedURLException
    //   541	45	8	localUnknownHostException4	java.net.UnknownHostException
    //   655	138	8	localObject9	Object
    //   6	733	9	localObject10	Object
    //   283	42	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   259	266	334	java/net/MalformedURLException
    //   278	285	334	java/net/MalformedURLException
    //   297	305	334	java/net/MalformedURLException
    //   322	331	334	java/net/MalformedURLException
    //   240	247	386	java/io/IOException
    //   134	153	541	java/net/UnknownHostException
    //   134	153	577	java/io/IOException
    //   52	57	629	java/io/IOException
    //   62	67	639	java/io/IOException
    //   153	195	649	java/io/IOException
    //   202	229	649	java/io/IOException
    //   229	240	649	java/io/IOException
    //   457	485	649	java/io/IOException
    //   499	527	649	java/io/IOException
    //   388	401	668	java/io/IOException
    //   259	266	684	java/io/IOException
    //   278	285	684	java/io/IOException
    //   297	305	684	java/io/IOException
    //   322	331	684	java/io/IOException
    //   153	195	697	java/net/UnknownHostException
    //   202	229	697	java/net/UnknownHostException
    //   229	240	697	java/net/UnknownHostException
    //   457	485	697	java/net/UnknownHostException
    //   499	527	697	java/net/UnknownHostException
    //   240	247	716	java/net/UnknownHostException
    //   388	401	716	java/net/UnknownHostException
    //   259	266	732	java/net/UnknownHostException
    //   278	285	732	java/net/UnknownHostException
    //   297	305	732	java/net/UnknownHostException
    //   322	331	732	java/net/UnknownHostException
    //   134	153	745	java/net/MalformedURLException
    //   153	195	764	java/net/MalformedURLException
    //   202	229	764	java/net/MalformedURLException
    //   229	240	764	java/net/MalformedURLException
    //   457	485	764	java/net/MalformedURLException
    //   499	527	764	java/net/MalformedURLException
    //   240	247	783	java/net/MalformedURLException
    //   388	401	783	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.ptt.FileTransfer.2
 * JD-Core Version:    0.7.0.1
 */