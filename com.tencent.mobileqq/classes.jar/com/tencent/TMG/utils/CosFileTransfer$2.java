package com.tencent.TMG.utils;

final class CosFileTransfer$2
  implements Runnable
{
  CosFileTransfer$2(String paramString1, String paramString2, String paramString3, CosFileTransfer.DownloadCosFileListener paramDownloadCosFileListener, Object paramObject) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   4: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_3
    //   8: sipush 12289
    //   11: istore_1
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore 7
    //   18: aconst_null
    //   19: astore 8
    //   21: aconst_null
    //   22: astore 9
    //   24: aconst_null
    //   25: astore 13
    //   27: aconst_null
    //   28: astore 10
    //   30: aconst_null
    //   31: astore 11
    //   33: aconst_null
    //   34: astore 12
    //   36: aconst_null
    //   37: astore 14
    //   39: iload_3
    //   40: ifeq +29 -> 69
    //   43: ldc 45
    //   45: ldc 47
    //   47: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   50: pop
    //   51: aconst_null
    //   52: astore 4
    //   54: aload 4
    //   56: astore 5
    //   58: aload 14
    //   60: astore 6
    //   62: sipush 12292
    //   65: istore_1
    //   66: goto +622 -> 688
    //   69: aload_0
    //   70: getfield 20	com/tencent/TMG/utils/CosFileTransfer$2:val$savePath	Ljava/lang/String;
    //   73: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifeq +25 -> 101
    //   79: ldc 45
    //   81: ldc 55
    //   83: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aconst_null
    //   88: astore 4
    //   90: aload 4
    //   92: astore 5
    //   94: aload 13
    //   96: astore 6
    //   98: goto +590 -> 688
    //   101: new 57	java/net/URL
    //   104: dup
    //   105: aload_0
    //   106: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   109: invokespecial 60	java/net/URL:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 64	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   115: checkcast 66	java/net/HttpURLConnection
    //   118: astore 4
    //   120: aload 4
    //   122: ldc 68
    //   124: invokevirtual 71	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   127: aload 4
    //   129: ldc 73
    //   131: aload_0
    //   132: getfield 22	com/tencent/TMG/utils/CosFileTransfer$2:val$sign	Ljava/lang/String;
    //   135: invokevirtual 77	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 4
    //   140: ldc 79
    //   142: ldc 81
    //   144: invokevirtual 77	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 4
    //   149: ldc 83
    //   151: ldc 85
    //   153: invokevirtual 77	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 4
    //   158: invokevirtual 89	java/net/HttpURLConnection:getResponseCode	()I
    //   161: istore_2
    //   162: iload_2
    //   163: sipush 200
    //   166: if_icmpne +204 -> 370
    //   169: new 91	java/io/File
    //   172: dup
    //   173: aload_0
    //   174: getfield 20	com/tencent/TMG/utils/CosFileTransfer$2:val$savePath	Ljava/lang/String;
    //   177: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: astore 5
    //   182: aload 5
    //   184: invokevirtual 96	java/io/File:exists	()Z
    //   187: ifne +9 -> 196
    //   190: aload 5
    //   192: invokevirtual 99	java/io/File:createNewFile	()Z
    //   195: pop
    //   196: new 101	java/io/FileOutputStream
    //   199: dup
    //   200: aload 5
    //   202: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   205: astore 5
    //   207: aload 11
    //   209: astore 7
    //   211: aload 12
    //   213: astore 8
    //   215: aload 4
    //   217: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   220: astore 9
    //   222: aload 9
    //   224: astore 6
    //   226: aload 9
    //   228: astore 7
    //   230: aload 9
    //   232: astore 8
    //   234: aload 4
    //   236: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   239: astore 9
    //   241: aload 9
    //   243: astore 6
    //   245: aload 9
    //   247: astore 7
    //   249: aload 9
    //   251: astore 8
    //   253: sipush 1024
    //   256: newarray byte
    //   258: astore 10
    //   260: aload 9
    //   262: astore 6
    //   264: aload 9
    //   266: astore 7
    //   268: aload 9
    //   270: astore 8
    //   272: aload 9
    //   274: aload 10
    //   276: invokevirtual 114	java/io/InputStream:read	([B)I
    //   279: istore_2
    //   280: iload_2
    //   281: iconst_m1
    //   282: if_icmpeq +480 -> 762
    //   285: aload 9
    //   287: astore 6
    //   289: aload 9
    //   291: astore 7
    //   293: aload 9
    //   295: astore 8
    //   297: aload 5
    //   299: aload 10
    //   301: iconst_0
    //   302: iload_2
    //   303: invokevirtual 118	java/io/FileOutputStream:write	([BII)V
    //   306: goto -46 -> 260
    //   309: astore 9
    //   311: aload 10
    //   313: astore 6
    //   315: aload 11
    //   317: astore 7
    //   319: aload 12
    //   321: astore 8
    //   323: ldc 45
    //   325: ldc 120
    //   327: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   330: pop
    //   331: aload 10
    //   333: astore 6
    //   335: aload 11
    //   337: astore 7
    //   339: aload 12
    //   341: astore 8
    //   343: aload 9
    //   345: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   348: aload 4
    //   350: astore 6
    //   352: aconst_null
    //   353: astore 4
    //   355: aload 5
    //   357: astore 7
    //   359: aload 6
    //   361: astore 5
    //   363: aload 7
    //   365: astore 6
    //   367: goto +251 -> 618
    //   370: iload_2
    //   371: sipush 404
    //   374: if_icmpne +51 -> 425
    //   377: new 125	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   384: astore 5
    //   386: aload 5
    //   388: ldc 128
    //   390: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 5
    //   396: aload_0
    //   397: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   400: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: ldc 45
    //   406: aload 5
    //   408: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   414: pop
    //   415: aconst_null
    //   416: astore 5
    //   418: sipush 12292
    //   421: istore_1
    //   422: goto +48 -> 470
    //   425: new 125	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   432: astore 5
    //   434: aload 5
    //   436: ldc 138
    //   438: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 5
    //   444: aload_0
    //   445: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   448: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: ldc 45
    //   454: aload 5
    //   456: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   462: pop
    //   463: aconst_null
    //   464: astore 5
    //   466: sipush 12291
    //   469: istore_1
    //   470: aload 4
    //   472: astore 7
    //   474: aload 5
    //   476: astore 4
    //   478: aload 7
    //   480: astore 5
    //   482: goto +206 -> 688
    //   485: astore 6
    //   487: aload 4
    //   489: astore 5
    //   491: aconst_null
    //   492: astore 4
    //   494: goto +44 -> 538
    //   497: astore 6
    //   499: aload 4
    //   501: astore 5
    //   503: aconst_null
    //   504: astore 4
    //   506: aload 8
    //   508: astore 7
    //   510: goto +91 -> 601
    //   513: astore 6
    //   515: aload 4
    //   517: astore 5
    //   519: aconst_null
    //   520: astore 4
    //   522: aload 9
    //   524: astore 7
    //   526: goto +112 -> 638
    //   529: astore 6
    //   531: aconst_null
    //   532: astore 4
    //   534: aload 4
    //   536: astore 5
    //   538: new 125	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   545: astore 8
    //   547: aload 8
    //   549: ldc 140
    //   551: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 8
    //   557: aload_0
    //   558: getfield 20	com/tencent/TMG/utils/CosFileTransfer$2:val$savePath	Ljava/lang/String;
    //   561: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: ldc 45
    //   567: aload 8
    //   569: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   575: pop
    //   576: aload 6
    //   578: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   581: aload 7
    //   583: astore 6
    //   585: goto +103 -> 688
    //   588: astore 6
    //   590: aconst_null
    //   591: astore 4
    //   593: aload 4
    //   595: astore 5
    //   597: aload 8
    //   599: astore 7
    //   601: ldc 45
    //   603: ldc 142
    //   605: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   608: pop
    //   609: aload 6
    //   611: invokevirtual 143	java/net/UnknownHostException:printStackTrace	()V
    //   614: aload 7
    //   616: astore 6
    //   618: sipush 12291
    //   621: istore_1
    //   622: goto +66 -> 688
    //   625: astore 6
    //   627: aconst_null
    //   628: astore 4
    //   630: aload 4
    //   632: astore 5
    //   634: aload 9
    //   636: astore 7
    //   638: new 125	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   645: astore 8
    //   647: aload 8
    //   649: ldc 128
    //   651: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload 8
    //   657: aload_0
    //   658: getfield 18	com/tencent/TMG/utils/CosFileTransfer$2:val$downloadUrl	Ljava/lang/String;
    //   661: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: ldc 45
    //   667: aload 8
    //   669: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   675: pop
    //   676: aload 6
    //   678: invokevirtual 144	java/net/MalformedURLException:printStackTrace	()V
    //   681: aload 7
    //   683: astore 6
    //   685: goto -623 -> 62
    //   688: aload 6
    //   690: ifnull +18 -> 708
    //   693: aload 6
    //   695: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   698: goto +10 -> 708
    //   701: astore 6
    //   703: aload 6
    //   705: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   708: aload 4
    //   710: ifnull +18 -> 728
    //   713: aload 4
    //   715: invokevirtual 148	java/io/InputStream:close	()V
    //   718: goto +10 -> 728
    //   721: astore 4
    //   723: aload 4
    //   725: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   728: aload 5
    //   730: ifnull +8 -> 738
    //   733: aload 5
    //   735: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   738: aload_0
    //   739: getfield 24	com/tencent/TMG/utils/CosFileTransfer$2:val$listener	Lcom/tencent/TMG/utils/CosFileTransfer$DownloadCosFileListener;
    //   742: astore 4
    //   744: aload 4
    //   746: ifnull +15 -> 761
    //   749: aload 4
    //   751: iload_1
    //   752: aload_0
    //   753: getfield 26	com/tencent/TMG/utils/CosFileTransfer$2:val$param	Ljava/lang/Object;
    //   756: invokeinterface 157 3 0
    //   761: return
    //   762: aload 5
    //   764: astore 6
    //   766: iconst_0
    //   767: istore_1
    //   768: aload 9
    //   770: astore 5
    //   772: goto -302 -> 470
    //   775: astore 9
    //   777: aload 4
    //   779: astore 7
    //   781: aload 6
    //   783: astore 4
    //   785: aload 5
    //   787: astore 8
    //   789: aload 9
    //   791: astore 6
    //   793: aload 7
    //   795: astore 5
    //   797: aload 8
    //   799: astore 7
    //   801: goto -263 -> 538
    //   804: astore 6
    //   806: aload 4
    //   808: astore 8
    //   810: aload 7
    //   812: astore 4
    //   814: aload 5
    //   816: astore 7
    //   818: aload 8
    //   820: astore 5
    //   822: goto -221 -> 601
    //   825: astore 6
    //   827: aload 4
    //   829: astore 7
    //   831: aload 8
    //   833: astore 4
    //   835: aload 5
    //   837: astore 8
    //   839: aload 7
    //   841: astore 5
    //   843: aload 8
    //   845: astore 7
    //   847: goto -209 -> 638
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	850	0	this	2
    //   11	757	1	i	int
    //   161	214	2	j	int
    //   7	33	3	bool	boolean
    //   52	662	4	localObject1	Object
    //   721	3	4	localIOException1	java.io.IOException
    //   742	92	4	localObject2	Object
    //   56	786	5	localObject3	Object
    //   13	353	6	localObject4	Object
    //   485	1	6	localIOException2	java.io.IOException
    //   497	1	6	localUnknownHostException1	java.net.UnknownHostException
    //   513	1	6	localMalformedURLException1	java.net.MalformedURLException
    //   529	48	6	localIOException3	java.io.IOException
    //   583	1	6	localObject5	Object
    //   588	22	6	localUnknownHostException2	java.net.UnknownHostException
    //   616	1	6	localObject6	Object
    //   625	52	6	localMalformedURLException2	java.net.MalformedURLException
    //   683	11	6	localObject7	Object
    //   701	3	6	localIOException4	java.io.IOException
    //   764	28	6	localObject8	Object
    //   804	1	6	localUnknownHostException3	java.net.UnknownHostException
    //   825	1	6	localMalformedURLException3	java.net.MalformedURLException
    //   16	830	7	localObject9	Object
    //   19	825	8	localObject10	Object
    //   22	272	9	localInputStream	java.io.InputStream
    //   309	460	9	localIOException5	java.io.IOException
    //   775	15	9	localIOException6	java.io.IOException
    //   28	304	10	arrayOfByte	byte[]
    //   31	305	11	localObject11	Object
    //   34	306	12	localObject12	Object
    //   25	70	13	localObject13	Object
    //   37	22	14	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   215	222	309	java/io/IOException
    //   120	162	485	java/io/IOException
    //   169	196	485	java/io/IOException
    //   196	207	485	java/io/IOException
    //   377	415	485	java/io/IOException
    //   425	463	485	java/io/IOException
    //   120	162	497	java/net/UnknownHostException
    //   169	196	497	java/net/UnknownHostException
    //   196	207	497	java/net/UnknownHostException
    //   377	415	497	java/net/UnknownHostException
    //   425	463	497	java/net/UnknownHostException
    //   120	162	513	java/net/MalformedURLException
    //   169	196	513	java/net/MalformedURLException
    //   196	207	513	java/net/MalformedURLException
    //   377	415	513	java/net/MalformedURLException
    //   425	463	513	java/net/MalformedURLException
    //   101	120	529	java/io/IOException
    //   101	120	588	java/net/UnknownHostException
    //   101	120	625	java/net/MalformedURLException
    //   693	698	701	java/io/IOException
    //   713	718	721	java/io/IOException
    //   234	241	775	java/io/IOException
    //   253	260	775	java/io/IOException
    //   272	280	775	java/io/IOException
    //   297	306	775	java/io/IOException
    //   323	331	775	java/io/IOException
    //   343	348	775	java/io/IOException
    //   215	222	804	java/net/UnknownHostException
    //   234	241	804	java/net/UnknownHostException
    //   253	260	804	java/net/UnknownHostException
    //   272	280	804	java/net/UnknownHostException
    //   297	306	804	java/net/UnknownHostException
    //   323	331	804	java/net/UnknownHostException
    //   343	348	804	java/net/UnknownHostException
    //   215	222	825	java/net/MalformedURLException
    //   234	241	825	java/net/MalformedURLException
    //   253	260	825	java/net/MalformedURLException
    //   272	280	825	java/net/MalformedURLException
    //   297	306	825	java/net/MalformedURLException
    //   323	331	825	java/net/MalformedURLException
    //   343	348	825	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.CosFileTransfer.2
 * JD-Core Version:    0.7.0.1
 */