import com.tencent.qg.sdk.QGBitmapLoader.QGBitmapLoaderImpl;

public class bdsy
  implements QGBitmapLoader.QGBitmapLoaderImpl
{
  /* Error */
  public android.graphics.Bitmap load(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_1
    //   7: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +28 -> 46
    //   21: ldc 37
    //   23: iconst_2
    //   24: new 39	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   31: ldc 42
    //   33: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: ldc 56
    //   48: monitorenter
    //   49: aload_1
    //   50: invokestatic 61	bbcw:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +15 -> 70
    //   58: aload_2
    //   59: invokevirtual 66	android/graphics/Bitmap:isRecycled	()Z
    //   62: ifne +8 -> 70
    //   65: ldc 56
    //   67: monitorexit
    //   68: aload_2
    //   69: areturn
    //   70: ldc 56
    //   72: monitorexit
    //   73: aload_1
    //   74: invokestatic 71	naj:a	(Ljava/lang/String;)Z
    //   77: ifeq +365 -> 442
    //   80: new 73	java/net/URL
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 76	java/net/URL:<init>	(Ljava/lang/String;)V
    //   88: astore_3
    //   89: new 78	sfa
    //   92: dup
    //   93: invokestatic 84	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   96: invokespecial 87	sfa:<init>	(Lcom/tencent/common/app/BaseApplicationImpl;)V
    //   99: astore 4
    //   101: new 89	com/tencent/image/DownloadParams
    //   104: dup
    //   105: invokespecial 90	com/tencent/image/DownloadParams:<init>	()V
    //   108: astore 5
    //   110: aload 5
    //   112: aload_3
    //   113: putfield 94	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   116: aload 5
    //   118: aload_1
    //   119: putfield 98	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   122: aload 4
    //   124: aload 5
    //   126: new 100	bdsz
    //   129: dup
    //   130: aload_0
    //   131: invokespecial 103	bdsz:<init>	(Lbdsy;)V
    //   134: invokevirtual 107	sfa:loadImageFile	(Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   137: astore_3
    //   138: aload_3
    //   139: astore 8
    //   141: aload_3
    //   142: ifnonnull +28 -> 170
    //   145: new 23	java/io/IOException
    //   148: dup
    //   149: ldc 109
    //   151: invokespecial 110	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   154: athrow
    //   155: astore 4
    //   157: ldc 37
    //   159: ldc 112
    //   161: aload 4
    //   163: invokestatic 118	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   166: pop
    //   167: aload_3
    //   168: astore 8
    //   170: aload 8
    //   172: ifnull +283 -> 455
    //   175: aload_2
    //   176: astore_3
    //   177: aload_2
    //   178: astore 4
    //   180: aload_2
    //   181: astore 5
    //   183: aload 10
    //   185: astore 7
    //   187: aload 8
    //   189: invokevirtual 123	java/io/File:exists	()Z
    //   192: ifeq +263 -> 455
    //   195: aload_2
    //   196: astore_3
    //   197: aload_2
    //   198: astore 4
    //   200: aload_2
    //   201: astore 5
    //   203: aload 10
    //   205: astore 7
    //   207: aload 8
    //   209: invokevirtual 126	java/io/File:getPath	()Ljava/lang/String;
    //   212: invokestatic 131	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   215: astore 6
    //   217: aload 6
    //   219: astore_2
    //   220: aload 6
    //   222: astore_3
    //   223: aload 6
    //   225: astore 4
    //   227: aload 6
    //   229: astore 5
    //   231: aload 10
    //   233: astore 7
    //   235: aload_1
    //   236: invokestatic 71	naj:a	(Ljava/lang/String;)Z
    //   239: ifeq +78 -> 317
    //   242: aload 6
    //   244: astore_2
    //   245: aload 6
    //   247: astore_3
    //   248: aload 6
    //   250: astore 4
    //   252: aload 6
    //   254: astore 5
    //   256: aload 10
    //   258: astore 7
    //   260: aload 8
    //   262: invokestatic 137	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   265: ifeq +52 -> 317
    //   268: aload 6
    //   270: astore_3
    //   271: aload 6
    //   273: astore 4
    //   275: aload 6
    //   277: astore 5
    //   279: aload 10
    //   281: astore 7
    //   283: aload 6
    //   285: bipush 100
    //   287: aload 8
    //   289: invokestatic 142	bbef:a	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   292: pop
    //   293: aload 6
    //   295: astore_3
    //   296: aload 6
    //   298: astore 4
    //   300: aload 6
    //   302: astore 5
    //   304: aload 10
    //   306: astore 7
    //   308: aload 8
    //   310: invokevirtual 126	java/io/File:getPath	()Ljava/lang/String;
    //   313: invokestatic 131	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   316: astore_2
    //   317: aload_2
    //   318: astore_3
    //   319: aload_2
    //   320: astore 4
    //   322: aload_2
    //   323: astore 5
    //   325: aload 10
    //   327: astore 7
    //   329: ldc 37
    //   331: iconst_2
    //   332: new 39	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   339: ldc 144
    //   341: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload 8
    //   346: invokevirtual 126	java/io/File:getPath	()Ljava/lang/String;
    //   349: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: aload 9
    //   360: astore_3
    //   361: aload_2
    //   362: astore 4
    //   364: aload 4
    //   366: astore_2
    //   367: aload_3
    //   368: ifnull +10 -> 378
    //   371: aload_3
    //   372: invokevirtual 149	java/io/InputStream:close	()V
    //   375: aload 4
    //   377: astore_2
    //   378: ldc 56
    //   380: monitorenter
    //   381: aload_2
    //   382: ifnull +15 -> 397
    //   385: aload_2
    //   386: invokevirtual 66	android/graphics/Bitmap:isRecycled	()Z
    //   389: ifne +8 -> 397
    //   392: aload_1
    //   393: aload_2
    //   394: invokestatic 152	bbcw:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   397: ldc 56
    //   399: monitorexit
    //   400: aload_2
    //   401: areturn
    //   402: astore_1
    //   403: ldc 56
    //   405: monitorexit
    //   406: aload_1
    //   407: athrow
    //   408: astore_1
    //   409: ldc 56
    //   411: monitorexit
    //   412: aload_1
    //   413: athrow
    //   414: astore_2
    //   415: ldc 37
    //   417: iconst_2
    //   418: new 39	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   425: ldc 154
    //   427: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_1
    //   431: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aconst_null
    //   441: areturn
    //   442: new 120	java/io/File
    //   445: dup
    //   446: aload_1
    //   447: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   450: astore 8
    //   452: goto -282 -> 170
    //   455: aload_2
    //   456: astore_3
    //   457: aload_2
    //   458: astore 4
    //   460: aload_2
    //   461: astore 5
    //   463: aload 10
    //   465: astore 7
    //   467: getstatic 163	com/tencent/qg/sdk/QGRenderer:assetManager	Landroid/content/res/AssetManager;
    //   470: aload_1
    //   471: invokevirtual 169	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   474: astore 6
    //   476: aload 6
    //   478: astore_3
    //   479: aload_3
    //   480: astore 7
    //   482: aload_3
    //   483: invokestatic 173	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   486: astore 4
    //   488: goto -124 -> 364
    //   491: astore_2
    //   492: aload_2
    //   493: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   496: aload 4
    //   498: astore_2
    //   499: goto -121 -> 378
    //   502: astore 5
    //   504: aconst_null
    //   505: astore 4
    //   507: aload 4
    //   509: astore_2
    //   510: ldc 37
    //   512: ldc 178
    //   514: aload 5
    //   516: invokestatic 118	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   519: pop
    //   520: aload_3
    //   521: astore_2
    //   522: aload 4
    //   524: ifnull -146 -> 378
    //   527: aload 4
    //   529: invokevirtual 149	java/io/InputStream:close	()V
    //   532: aload_3
    //   533: astore_2
    //   534: goto -156 -> 378
    //   537: astore_2
    //   538: aload_2
    //   539: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   542: aload_3
    //   543: astore_2
    //   544: goto -166 -> 378
    //   547: astore 5
    //   549: aload 4
    //   551: astore_3
    //   552: aconst_null
    //   553: astore 4
    //   555: aload 4
    //   557: astore_2
    //   558: ldc 37
    //   560: ldc 180
    //   562: aload 5
    //   564: invokestatic 118	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   567: pop
    //   568: aload_3
    //   569: astore_2
    //   570: aload 4
    //   572: ifnull -194 -> 378
    //   575: aload 4
    //   577: invokevirtual 149	java/io/InputStream:close	()V
    //   580: aload_3
    //   581: astore_2
    //   582: goto -204 -> 378
    //   585: astore_2
    //   586: aload_2
    //   587: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   590: aload_3
    //   591: astore_2
    //   592: goto -214 -> 378
    //   595: astore_2
    //   596: aload 5
    //   598: astore_3
    //   599: aconst_null
    //   600: astore 4
    //   602: aload_2
    //   603: astore 5
    //   605: aload 4
    //   607: astore_2
    //   608: ldc 37
    //   610: ldc 182
    //   612: aload 5
    //   614: invokestatic 118	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   617: pop
    //   618: aload 4
    //   620: astore_2
    //   621: aload 5
    //   623: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   626: aload_3
    //   627: astore_2
    //   628: aload 4
    //   630: ifnull -252 -> 378
    //   633: aload 4
    //   635: invokevirtual 149	java/io/InputStream:close	()V
    //   638: aload_3
    //   639: astore_2
    //   640: goto -262 -> 378
    //   643: astore_2
    //   644: aload_2
    //   645: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   648: aload_3
    //   649: astore_2
    //   650: goto -272 -> 378
    //   653: astore_1
    //   654: aload 7
    //   656: ifnull +8 -> 664
    //   659: aload 7
    //   661: invokevirtual 149	java/io/InputStream:close	()V
    //   664: aload_1
    //   665: athrow
    //   666: astore_2
    //   667: aload_2
    //   668: invokevirtual 176	java/io/IOException:printStackTrace	()V
    //   671: goto -7 -> 664
    //   674: astore_1
    //   675: aload_2
    //   676: astore 7
    //   678: goto -24 -> 654
    //   681: astore 5
    //   683: aload_3
    //   684: astore 4
    //   686: aload_2
    //   687: astore_3
    //   688: goto -83 -> 605
    //   691: astore 5
    //   693: aload_3
    //   694: astore 4
    //   696: aload_2
    //   697: astore_3
    //   698: goto -143 -> 555
    //   701: astore 5
    //   703: aload_3
    //   704: astore 4
    //   706: aload_2
    //   707: astore_3
    //   708: goto -201 -> 507
    //   711: astore 4
    //   713: aconst_null
    //   714: astore_3
    //   715: goto -558 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	bdsy
    //   0	718	1	paramString	java.lang.String
    //   53	348	2	localObject1	Object
    //   414	47	2	localMalformedURLException	java.net.MalformedURLException
    //   491	2	2	localIOException1	java.io.IOException
    //   498	36	2	localObject2	Object
    //   537	2	2	localIOException2	java.io.IOException
    //   543	39	2	localObject3	Object
    //   585	2	2	localIOException3	java.io.IOException
    //   591	1	2	localObject4	Object
    //   595	8	2	localIOException4	java.io.IOException
    //   607	33	2	localObject5	Object
    //   643	2	2	localIOException5	java.io.IOException
    //   649	1	2	localObject6	Object
    //   666	41	2	localIOException6	java.io.IOException
    //   88	627	3	localObject7	Object
    //   99	24	4	localsfa	sfa
    //   155	7	4	localThrowable1	java.lang.Throwable
    //   178	527	4	localObject8	Object
    //   711	1	4	localThrowable2	java.lang.Throwable
    //   108	354	5	localObject9	Object
    //   502	13	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   547	50	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   603	19	5	localIOException7	java.io.IOException
    //   681	1	5	localIOException8	java.io.IOException
    //   691	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   701	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   215	262	6	localObject10	Object
    //   185	492	7	localObject11	Object
    //   139	312	8	localObject12	Object
    //   4	355	9	localObject13	Object
    //   1	463	10	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   145	155	155	java/lang/Throwable
    //   385	397	402	finally
    //   397	400	402	finally
    //   403	406	402	finally
    //   49	54	408	finally
    //   58	68	408	finally
    //   70	73	408	finally
    //   409	412	408	finally
    //   80	89	414	java/net/MalformedURLException
    //   371	375	491	java/io/IOException
    //   187	195	502	java/lang/OutOfMemoryError
    //   207	217	502	java/lang/OutOfMemoryError
    //   235	242	502	java/lang/OutOfMemoryError
    //   260	268	502	java/lang/OutOfMemoryError
    //   283	293	502	java/lang/OutOfMemoryError
    //   308	317	502	java/lang/OutOfMemoryError
    //   329	358	502	java/lang/OutOfMemoryError
    //   467	476	502	java/lang/OutOfMemoryError
    //   527	532	537	java/io/IOException
    //   187	195	547	java/io/FileNotFoundException
    //   207	217	547	java/io/FileNotFoundException
    //   235	242	547	java/io/FileNotFoundException
    //   260	268	547	java/io/FileNotFoundException
    //   283	293	547	java/io/FileNotFoundException
    //   308	317	547	java/io/FileNotFoundException
    //   329	358	547	java/io/FileNotFoundException
    //   467	476	547	java/io/FileNotFoundException
    //   575	580	585	java/io/IOException
    //   187	195	595	java/io/IOException
    //   207	217	595	java/io/IOException
    //   235	242	595	java/io/IOException
    //   260	268	595	java/io/IOException
    //   283	293	595	java/io/IOException
    //   308	317	595	java/io/IOException
    //   329	358	595	java/io/IOException
    //   467	476	595	java/io/IOException
    //   633	638	643	java/io/IOException
    //   187	195	653	finally
    //   207	217	653	finally
    //   235	242	653	finally
    //   260	268	653	finally
    //   283	293	653	finally
    //   308	317	653	finally
    //   329	358	653	finally
    //   467	476	653	finally
    //   482	488	653	finally
    //   659	664	666	java/io/IOException
    //   510	520	674	finally
    //   558	568	674	finally
    //   608	618	674	finally
    //   621	626	674	finally
    //   482	488	681	java/io/IOException
    //   482	488	691	java/io/FileNotFoundException
    //   482	488	701	java/lang/OutOfMemoryError
    //   122	138	711	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsy
 * JD-Core Version:    0.7.0.1
 */