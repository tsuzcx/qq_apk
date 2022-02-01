package com.tencent.TMG.utils;

final class CosFileTransfer$2
  implements Runnable
{
  CosFileTransfer$2(String paramString1, String paramString2, String paramString3, CosFileTransfer.DownloadCosFileListener paramDownloadCosFileListener, Object paramObject) {}
  
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
    //   22: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   25: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +71 -> 99
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
    //   78: getfield 24	com/tencent/TMG/utils/CosFileTransfer$2:val$listener	Lcom/tencent/TMG/utils/CosFileTransfer$DownloadCosFileListener;
    //   81: ifnull +17 -> 98
    //   84: aload_0
    //   85: getfield 24	com/tencent/TMG/utils/CosFileTransfer$2:val$listener	Lcom/tencent/TMG/utils/CosFileTransfer$DownloadCosFileListener;
    //   88: iload_1
    //   89: aload_0
    //   90: getfield 26	com/tencent/TMG/utils/CosFileTransfer$2:val$param	Ljava/lang/Object;
    //   93: invokeinterface 72 3 0
    //   98: return
    //   99: aload_0
    //   100: getfield 20	com/tencent/TMG/utils/CosFileTransfer$2:val$savePath	Ljava/lang/String;
    //   103: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +24 -> 130
    //   109: ldc 45
    //   111: ldc 74
    //   113: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: sipush 12289
    //   120: istore_1
    //   121: aconst_null
    //   122: astore 4
    //   124: aconst_null
    //   125: astore 5
    //   127: goto -80 -> 47
    //   130: new 76	java/net/URL
    //   133: dup
    //   134: aload_0
    //   135: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   138: invokespecial 79	java/net/URL:<init>	(Ljava/lang/String;)V
    //   141: invokevirtual 83	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   144: checkcast 63	java/net/HttpURLConnection
    //   147: astore 4
    //   149: aload 4
    //   151: ldc 85
    //   153: invokevirtual 88	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   156: aload 4
    //   158: ldc 90
    //   160: aload_0
    //   161: getfield 22	com/tencent/TMG/utils/CosFileTransfer$2:val$sign	Ljava/lang/String;
    //   164: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 4
    //   169: ldc 96
    //   171: ldc 98
    //   173: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload 4
    //   178: ldc 100
    //   180: ldc 102
    //   182: invokevirtual 94	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload 4
    //   187: invokevirtual 106	java/net/HttpURLConnection:getResponseCode	()I
    //   190: istore_3
    //   191: iload_3
    //   192: sipush 200
    //   195: if_icmpne +251 -> 446
    //   198: new 108	java/io/File
    //   201: dup
    //   202: aload_0
    //   203: getfield 20	com/tencent/TMG/utils/CosFileTransfer$2:val$savePath	Ljava/lang/String;
    //   206: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: astore 5
    //   211: aload 5
    //   213: invokevirtual 113	java/io/File:exists	()Z
    //   216: ifne +9 -> 225
    //   219: aload 5
    //   221: invokevirtual 116	java/io/File:createNewFile	()Z
    //   224: pop
    //   225: new 55	java/io/FileOutputStream
    //   228: dup
    //   229: aload 5
    //   231: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   234: astore 5
    //   236: aload 4
    //   238: invokevirtual 123	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   241: astore 6
    //   243: aload 6
    //   245: astore 7
    //   247: aload 6
    //   249: astore 8
    //   251: aload 6
    //   253: astore 9
    //   255: aload 4
    //   257: invokevirtual 123	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   260: astore 6
    //   262: aload 6
    //   264: astore 7
    //   266: aload 6
    //   268: astore 8
    //   270: aload 6
    //   272: astore 9
    //   274: sipush 1024
    //   277: newarray byte
    //   279: astore 10
    //   281: aload 6
    //   283: astore 7
    //   285: aload 6
    //   287: astore 8
    //   289: aload 6
    //   291: astore 9
    //   293: aload 6
    //   295: aload 10
    //   297: invokevirtual 127	java/io/InputStream:read	([B)I
    //   300: istore_3
    //   301: iload_3
    //   302: iconst_m1
    //   303: if_icmpeq +112 -> 415
    //   306: aload 6
    //   308: astore 7
    //   310: aload 6
    //   312: astore 8
    //   314: aload 6
    //   316: astore 9
    //   318: aload 5
    //   320: aload 10
    //   322: iconst_0
    //   323: iload_3
    //   324: invokevirtual 131	java/io/FileOutputStream:write	([BII)V
    //   327: goto -46 -> 281
    //   330: astore 8
    //   332: aload 4
    //   334: astore 6
    //   336: aload 7
    //   338: astore 4
    //   340: aload 8
    //   342: astore 7
    //   344: ldc 45
    //   346: new 133	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   353: ldc 136
    //   355: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_0
    //   359: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   362: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   371: pop
    //   372: aload 7
    //   374: invokevirtual 147	java/net/MalformedURLException:printStackTrace	()V
    //   377: iload_2
    //   378: istore_1
    //   379: goto -332 -> 47
    //   382: astore 6
    //   384: ldc 45
    //   386: ldc 149
    //   388: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   391: pop
    //   392: aload 6
    //   394: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   397: sipush 12291
    //   400: istore_1
    //   401: aconst_null
    //   402: astore 7
    //   404: aload 4
    //   406: astore 6
    //   408: aload 7
    //   410: astore 4
    //   412: goto -365 -> 47
    //   415: aload 6
    //   417: astore 7
    //   419: aload 5
    //   421: astore 6
    //   423: aload 7
    //   425: astore 5
    //   427: aload 6
    //   429: astore 7
    //   431: aload 4
    //   433: astore 6
    //   435: aload 5
    //   437: astore 4
    //   439: aload 7
    //   441: astore 5
    //   443: goto -396 -> 47
    //   446: iload_3
    //   447: sipush 404
    //   450: if_icmpne +45 -> 495
    //   453: ldc 45
    //   455: new 133	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   462: ldc 136
    //   464: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_0
    //   468: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   471: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   480: pop
    //   481: sipush 12292
    //   484: istore_1
    //   485: aconst_null
    //   486: astore 5
    //   488: aload 9
    //   490: astore 6
    //   492: goto -65 -> 427
    //   495: ldc 45
    //   497: new 133	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   504: ldc 152
    //   506: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_0
    //   510: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   513: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   522: pop
    //   523: sipush 12291
    //   526: istore_1
    //   527: aconst_null
    //   528: astore 5
    //   530: aload 9
    //   532: astore 6
    //   534: goto -107 -> 427
    //   537: astore 8
    //   539: aconst_null
    //   540: astore 4
    //   542: aconst_null
    //   543: astore 5
    //   545: aload 7
    //   547: astore 6
    //   549: aload 8
    //   551: astore 7
    //   553: ldc 45
    //   555: ldc 154
    //   557: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   560: pop
    //   561: aload 7
    //   563: invokevirtual 155	java/net/UnknownHostException:printStackTrace	()V
    //   566: sipush 12291
    //   569: istore_1
    //   570: goto -523 -> 47
    //   573: astore 7
    //   575: aconst_null
    //   576: astore 4
    //   578: aconst_null
    //   579: astore 5
    //   581: aload 8
    //   583: astore 6
    //   585: ldc 45
    //   587: new 133	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   594: ldc 157
    //   596: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload_0
    //   600: getfield 20	com/tencent/TMG/utils/CosFileTransfer$2:val$savePath	Ljava/lang/String;
    //   603: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   612: pop
    //   613: aload 7
    //   615: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   618: sipush 12289
    //   621: istore_1
    //   622: goto -575 -> 47
    //   625: astore 5
    //   627: aload 5
    //   629: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   632: goto -575 -> 57
    //   635: astore 4
    //   637: aload 4
    //   639: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   642: goto -575 -> 67
    //   645: astore 7
    //   647: aconst_null
    //   648: astore 5
    //   650: aconst_null
    //   651: astore 8
    //   653: aload 4
    //   655: astore 6
    //   657: aload 8
    //   659: astore 4
    //   661: goto -76 -> 585
    //   664: astore 7
    //   666: aconst_null
    //   667: astore 8
    //   669: aload 4
    //   671: astore 6
    //   673: aload 8
    //   675: astore 4
    //   677: goto -92 -> 585
    //   680: astore 7
    //   682: aload 4
    //   684: astore 6
    //   686: aload 8
    //   688: astore 4
    //   690: goto -105 -> 585
    //   693: astore 7
    //   695: aconst_null
    //   696: astore 5
    //   698: aconst_null
    //   699: astore 8
    //   701: aload 4
    //   703: astore 6
    //   705: aload 8
    //   707: astore 4
    //   709: goto -156 -> 553
    //   712: astore 7
    //   714: aconst_null
    //   715: astore 8
    //   717: aload 4
    //   719: astore 6
    //   721: aload 8
    //   723: astore 4
    //   725: goto -172 -> 553
    //   728: astore 7
    //   730: aload 4
    //   732: astore 6
    //   734: aload 9
    //   736: astore 4
    //   738: goto -185 -> 553
    //   741: astore 7
    //   743: aconst_null
    //   744: astore 4
    //   746: aconst_null
    //   747: astore 8
    //   749: aload 5
    //   751: astore 6
    //   753: aload 8
    //   755: astore 5
    //   757: goto -413 -> 344
    //   760: astore 7
    //   762: aconst_null
    //   763: astore 5
    //   765: aconst_null
    //   766: astore 8
    //   768: aload 4
    //   770: astore 6
    //   772: aload 8
    //   774: astore 4
    //   776: goto -432 -> 344
    //   779: astore 7
    //   781: aconst_null
    //   782: astore 8
    //   784: aload 4
    //   786: astore 6
    //   788: aload 8
    //   790: astore 4
    //   792: goto -448 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	795	0	this	2
    //   1	621	1	i	int
    //   20	358	2	j	int
    //   190	261	3	k	int
    //   40	537	4	localObject1	Object
    //   635	19	4	localIOException1	java.io.IOException
    //   659	132	4	localObject2	Object
    //   3	577	5	localObject3	Object
    //   625	3	5	localIOException2	java.io.IOException
    //   648	116	5	localObject4	Object
    //   15	320	6	localObject5	Object
    //   382	11	6	localIOException3	java.io.IOException
    //   406	381	6	localObject6	Object
    //   9	553	7	localObject7	Object
    //   573	41	7	localIOException4	java.io.IOException
    //   645	1	7	localIOException5	java.io.IOException
    //   664	1	7	localIOException6	java.io.IOException
    //   680	1	7	localIOException7	java.io.IOException
    //   693	1	7	localUnknownHostException1	java.net.UnknownHostException
    //   712	1	7	localUnknownHostException2	java.net.UnknownHostException
    //   728	1	7	localUnknownHostException3	java.net.UnknownHostException
    //   741	1	7	localMalformedURLException1	java.net.MalformedURLException
    //   760	1	7	localMalformedURLException2	java.net.MalformedURLException
    //   779	1	7	localMalformedURLException3	java.net.MalformedURLException
    //   12	301	8	localObject8	Object
    //   330	11	8	localMalformedURLException4	java.net.MalformedURLException
    //   537	45	8	localUnknownHostException4	java.net.UnknownHostException
    //   651	138	8	localObject9	Object
    //   6	729	9	localObject10	Object
    //   279	42	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   255	262	330	java/net/MalformedURLException
    //   274	281	330	java/net/MalformedURLException
    //   293	301	330	java/net/MalformedURLException
    //   318	327	330	java/net/MalformedURLException
    //   236	243	382	java/io/IOException
    //   130	149	537	java/net/UnknownHostException
    //   130	149	573	java/io/IOException
    //   52	57	625	java/io/IOException
    //   62	67	635	java/io/IOException
    //   149	191	645	java/io/IOException
    //   198	225	645	java/io/IOException
    //   225	236	645	java/io/IOException
    //   453	481	645	java/io/IOException
    //   495	523	645	java/io/IOException
    //   384	397	664	java/io/IOException
    //   255	262	680	java/io/IOException
    //   274	281	680	java/io/IOException
    //   293	301	680	java/io/IOException
    //   318	327	680	java/io/IOException
    //   149	191	693	java/net/UnknownHostException
    //   198	225	693	java/net/UnknownHostException
    //   225	236	693	java/net/UnknownHostException
    //   453	481	693	java/net/UnknownHostException
    //   495	523	693	java/net/UnknownHostException
    //   236	243	712	java/net/UnknownHostException
    //   384	397	712	java/net/UnknownHostException
    //   255	262	728	java/net/UnknownHostException
    //   274	281	728	java/net/UnknownHostException
    //   293	301	728	java/net/UnknownHostException
    //   318	327	728	java/net/UnknownHostException
    //   130	149	741	java/net/MalformedURLException
    //   149	191	760	java/net/MalformedURLException
    //   198	225	760	java/net/MalformedURLException
    //   225	236	760	java/net/MalformedURLException
    //   453	481	760	java/net/MalformedURLException
    //   495	523	760	java/net/MalformedURLException
    //   236	243	779	java/net/MalformedURLException
    //   384	397	779	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.CosFileTransfer.2
 * JD-Core Version:    0.7.0.1
 */