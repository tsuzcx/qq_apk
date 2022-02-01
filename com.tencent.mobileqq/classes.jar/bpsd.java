public class bpsd
  extends bpsv<bpsf, bpsf>
  implements wjy
{
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, bpsf parambpsf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aload_2
    //   7: getfield 27	bpsf:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   10: getfield 33	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   13: ifnonnull +18 -> 31
    //   16: aload_0
    //   17: new 35	com/tencent/biz/qqstory/base/ErrorMessage
    //   20: dup
    //   21: iconst_m1
    //   22: ldc 37
    //   24: invokespecial 40	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   27: invokespecial 44	bpsv:notifyError	(Ljava/lang/Error;)V
    //   30: return
    //   31: aload_2
    //   32: getfield 27	bpsf:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   35: getfield 47	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   38: astore 12
    //   40: aload_2
    //   41: getfield 27	bpsf:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   44: getfield 50	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   47: astore 11
    //   49: aload 11
    //   51: ifnonnull +14 -> 65
    //   54: aload 12
    //   56: ifnonnull +9 -> 65
    //   59: aload_0
    //   60: aload_2
    //   61: invokespecial 54	bpsv:notifyResult	(Ljava/lang/Object;)V
    //   64: return
    //   65: aload_2
    //   66: getfield 57	bpsf:jdField_a_of_type_Bpsn	Lbpsn;
    //   69: getfield 63	bpsn:c	I
    //   72: istore 5
    //   74: aload_2
    //   75: getfield 65	bpsf:jdField_a_of_type_Int	I
    //   78: istore_3
    //   79: iload_3
    //   80: iconst_2
    //   81: if_icmpeq +31 -> 112
    //   84: iload_3
    //   85: iconst_3
    //   86: if_icmpeq +26 -> 112
    //   89: iload_3
    //   90: iconst_5
    //   91: if_icmpeq +21 -> 112
    //   94: iload_3
    //   95: bipush 101
    //   97: if_icmpeq +15 -> 112
    //   100: iload_3
    //   101: bipush 102
    //   103: if_icmpeq +9 -> 112
    //   106: iload_3
    //   107: bipush 6
    //   109: if_icmpne +418 -> 527
    //   112: aload 12
    //   114: ifnull +209 -> 323
    //   117: aload 12
    //   119: aconst_null
    //   120: invokestatic 70	zkh:a	(Ljava/lang/String;Lzki;)Landroid/graphics/Bitmap;
    //   123: astore_1
    //   124: iconst_1
    //   125: istore 4
    //   127: aload_1
    //   128: ifnonnull +703 -> 831
    //   131: aload 11
    //   133: ifnull +698 -> 831
    //   136: new 72	java/io/BufferedInputStream
    //   139: dup
    //   140: new 74	java/io/FileInputStream
    //   143: dup
    //   144: aload 11
    //   146: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   149: invokespecial 80	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   152: astore 8
    //   154: aload 8
    //   156: astore 9
    //   158: aload 8
    //   160: invokestatic 86	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   163: astore 10
    //   165: aload 8
    //   167: ifnull +667 -> 834
    //   170: aload 8
    //   172: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   175: aload 10
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull +332 -> 511
    //   182: iload 5
    //   184: sipush 270
    //   187: if_icmpne +279 -> 466
    //   190: bipush 90
    //   192: istore_3
    //   193: aload_2
    //   194: getfield 92	bpsf:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   197: instanceof 94
    //   200: ifeq +39 -> 239
    //   203: ldc 96
    //   205: new 98	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   212: ldc 101
    //   214: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: iload 5
    //   219: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: ldc 110
    //   224: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iconst_0
    //   228: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 120	yqp:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: iconst_0
    //   238: istore_3
    //   239: aload_1
    //   240: iload_3
    //   241: invokestatic 125	bpsg:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   244: astore_1
    //   245: aload_1
    //   246: ifnull +574 -> 820
    //   249: iload 4
    //   251: ifeq +239 -> 490
    //   254: aload_1
    //   255: aload 12
    //   257: aconst_null
    //   258: invokestatic 128	zkh:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lzki;)V
    //   261: iconst_1
    //   262: istore 6
    //   264: iload 6
    //   266: istore 7
    //   268: iload 6
    //   270: ifne +25 -> 295
    //   273: iload 6
    //   275: istore 7
    //   277: aload 11
    //   279: ifnull +16 -> 295
    //   282: aload_1
    //   283: getstatic 134	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   286: bipush 60
    //   288: aload 11
    //   290: invokestatic 137	zkh:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   293: istore 7
    //   295: aload_1
    //   296: invokevirtual 142	android/graphics/Bitmap:recycle	()V
    //   299: aload_1
    //   300: ifnull +8 -> 308
    //   303: iload 7
    //   305: ifeq +191 -> 496
    //   308: aload_0
    //   309: aload_2
    //   310: invokespecial 54	bpsv:notifyResult	(Ljava/lang/Object;)V
    //   313: return
    //   314: astore_1
    //   315: ldc 96
    //   317: ldc 144
    //   319: aload_1
    //   320: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   323: iconst_0
    //   324: istore 4
    //   326: aconst_null
    //   327: astore_1
    //   328: goto -201 -> 127
    //   331: astore_1
    //   332: ldc 96
    //   334: ldc 149
    //   336: aload_1
    //   337: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload 10
    //   342: astore_1
    //   343: goto -165 -> 178
    //   346: astore 10
    //   348: aconst_null
    //   349: astore 8
    //   351: aload 8
    //   353: astore 9
    //   355: ldc 96
    //   357: ldc 151
    //   359: aload 10
    //   361: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   364: aload 8
    //   366: ifnull +465 -> 831
    //   369: aload 8
    //   371: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   374: goto -196 -> 178
    //   377: astore 8
    //   379: ldc 96
    //   381: ldc 149
    //   383: aload 8
    //   385: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   388: goto -210 -> 178
    //   391: astore 9
    //   393: aload 10
    //   395: astore 8
    //   397: aload 9
    //   399: astore 10
    //   401: aload 8
    //   403: astore 9
    //   405: ldc 96
    //   407: ldc 153
    //   409: aload 10
    //   411: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   414: aload 8
    //   416: ifnull +415 -> 831
    //   419: aload 8
    //   421: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   424: goto -246 -> 178
    //   427: astore 8
    //   429: ldc 96
    //   431: ldc 149
    //   433: aload 8
    //   435: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   438: goto -260 -> 178
    //   441: astore_1
    //   442: aload 9
    //   444: ifnull +8 -> 452
    //   447: aload 9
    //   449: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   452: aload_1
    //   453: athrow
    //   454: astore_2
    //   455: ldc 96
    //   457: ldc 149
    //   459: aload_2
    //   460: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   463: goto -11 -> 452
    //   466: iload 5
    //   468: bipush 90
    //   470: if_icmpne +356 -> 826
    //   473: bipush 166
    //   475: istore_3
    //   476: goto -283 -> 193
    //   479: astore 8
    //   481: ldc 96
    //   483: ldc 155
    //   485: aload 8
    //   487: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   490: iconst_0
    //   491: istore 6
    //   493: goto -229 -> 264
    //   496: aload_0
    //   497: new 35	com/tencent/biz/qqstory/base/ErrorMessage
    //   500: dup
    //   501: iconst_m1
    //   502: ldc 157
    //   504: invokespecial 40	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   507: invokespecial 44	bpsv:notifyError	(Ljava/lang/Error;)V
    //   510: return
    //   511: aload_0
    //   512: new 159	com/tencent/biz/qqstory/base/BitmapError
    //   515: dup
    //   516: ldc 96
    //   518: bipush 6
    //   520: invokespecial 162	com/tencent/biz/qqstory/base/BitmapError:<init>	(Ljava/lang/String;I)V
    //   523: invokespecial 44	bpsv:notifyError	(Ljava/lang/Error;)V
    //   526: return
    //   527: iload_3
    //   528: iconst_1
    //   529: if_icmpne +255 -> 784
    //   532: aload 12
    //   534: ifnull +180 -> 714
    //   537: aload 12
    //   539: aconst_null
    //   540: invokestatic 70	zkh:a	(Ljava/lang/String;Lzki;)Landroid/graphics/Bitmap;
    //   543: astore_1
    //   544: iconst_1
    //   545: istore 4
    //   547: aload_1
    //   548: ifnonnull +185 -> 733
    //   551: aload 11
    //   553: ifnull +180 -> 733
    //   556: aload 11
    //   558: invokestatic 166	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   561: astore 8
    //   563: aload 8
    //   565: astore_1
    //   566: aload_1
    //   567: ifnull +201 -> 768
    //   570: aload_2
    //   571: getfield 92	bpsf:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   574: instanceof 94
    //   577: ifeq +238 -> 815
    //   580: aload_2
    //   581: getfield 27	bpsf:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   584: ldc 168
    //   586: iconst_0
    //   587: invokevirtual 172	com/tencent/biz/qqstory/database/PublishVideoEntry:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   590: ifeq +220 -> 810
    //   593: bipush 166
    //   595: istore_3
    //   596: ldc 96
    //   598: new 98	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   605: ldc 101
    //   607: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: iload 5
    //   612: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   615: ldc 174
    //   617: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: iload_3
    //   621: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   624: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 120	yqp:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: aload_1
    //   631: iload_3
    //   632: invokestatic 125	bpsg:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   635: astore_1
    //   636: aload_1
    //   637: ifnull +167 -> 804
    //   640: iload 4
    //   642: ifeq +105 -> 747
    //   645: aload_1
    //   646: aload 12
    //   648: aconst_null
    //   649: invokestatic 128	zkh:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lzki;)V
    //   652: iconst_1
    //   653: istore 6
    //   655: iload 6
    //   657: istore 7
    //   659: iload 6
    //   661: ifne +25 -> 686
    //   664: iload 6
    //   666: istore 7
    //   668: aload 11
    //   670: ifnull +16 -> 686
    //   673: aload_1
    //   674: getstatic 134	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   677: bipush 60
    //   679: aload 11
    //   681: invokestatic 137	zkh:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   684: istore 7
    //   686: aload_1
    //   687: invokevirtual 142	android/graphics/Bitmap:recycle	()V
    //   690: aload_1
    //   691: ifnull +8 -> 699
    //   694: iload 7
    //   696: ifeq +57 -> 753
    //   699: aload_0
    //   700: aload_2
    //   701: invokespecial 54	bpsv:notifyResult	(Ljava/lang/Object;)V
    //   704: return
    //   705: astore_1
    //   706: ldc 96
    //   708: ldc 144
    //   710: aload_1
    //   711: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   714: aconst_null
    //   715: astore_1
    //   716: iconst_0
    //   717: istore 4
    //   719: goto -172 -> 547
    //   722: astore 8
    //   724: ldc 96
    //   726: ldc 151
    //   728: aload 8
    //   730: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   733: goto -167 -> 566
    //   736: astore 8
    //   738: ldc 96
    //   740: ldc 155
    //   742: aload 8
    //   744: invokestatic 147	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   747: iconst_0
    //   748: istore 6
    //   750: goto -95 -> 655
    //   753: aload_0
    //   754: new 35	com/tencent/biz/qqstory/base/ErrorMessage
    //   757: dup
    //   758: iconst_m1
    //   759: ldc 157
    //   761: invokespecial 40	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   764: invokespecial 44	bpsv:notifyError	(Ljava/lang/Error;)V
    //   767: return
    //   768: aload_0
    //   769: new 159	com/tencent/biz/qqstory/base/BitmapError
    //   772: dup
    //   773: ldc 96
    //   775: bipush 6
    //   777: invokespecial 162	com/tencent/biz/qqstory/base/BitmapError:<init>	(Ljava/lang/String;I)V
    //   780: invokespecial 44	bpsv:notifyError	(Ljava/lang/Error;)V
    //   783: return
    //   784: aload_0
    //   785: aload_2
    //   786: invokespecial 54	bpsv:notifyResult	(Ljava/lang/Object;)V
    //   789: return
    //   790: astore_1
    //   791: goto -349 -> 442
    //   794: astore 10
    //   796: goto -395 -> 401
    //   799: astore 10
    //   801: goto -450 -> 351
    //   804: iconst_0
    //   805: istore 7
    //   807: goto -117 -> 690
    //   810: iconst_0
    //   811: istore_3
    //   812: goto -216 -> 596
    //   815: iconst_0
    //   816: istore_3
    //   817: goto -187 -> 630
    //   820: iconst_0
    //   821: istore 7
    //   823: goto -524 -> 299
    //   826: iconst_0
    //   827: istore_3
    //   828: goto -635 -> 193
    //   831: goto -653 -> 178
    //   834: aload 10
    //   836: astore_1
    //   837: goto -659 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	840	0	this	bpsd
    //   0	840	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	840	2	parambpsf	bpsf
    //   78	750	3	i	int
    //   125	593	4	j	int
    //   72	539	5	k	int
    //   262	487	6	bool1	boolean
    //   266	556	7	bool2	boolean
    //   152	218	8	localBufferedInputStream	java.io.BufferedInputStream
    //   377	7	8	localIOException1	java.io.IOException
    //   395	25	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   427	7	8	localIOException2	java.io.IOException
    //   479	7	8	localIOException3	java.io.IOException
    //   561	3	8	localBitmap1	android.graphics.Bitmap
    //   722	7	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   736	7	8	localIOException4	java.io.IOException
    //   1	353	9	localObject1	java.lang.Object
    //   391	7	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   403	45	9	localObject2	java.lang.Object
    //   4	337	10	localBitmap2	android.graphics.Bitmap
    //   346	48	10	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   399	11	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   794	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   799	36	10	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   47	633	11	str1	java.lang.String
    //   38	609	12	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   117	124	314	java/lang/Throwable
    //   170	175	331	java/io/IOException
    //   136	154	346	java/lang/OutOfMemoryError
    //   369	374	377	java/io/IOException
    //   136	154	391	java/io/FileNotFoundException
    //   419	424	427	java/io/IOException
    //   136	154	441	finally
    //   405	414	441	finally
    //   447	452	454	java/io/IOException
    //   254	261	479	java/io/IOException
    //   537	544	705	java/lang/Throwable
    //   556	563	722	java/lang/OutOfMemoryError
    //   645	652	736	java/io/IOException
    //   158	165	790	finally
    //   355	364	790	finally
    //   158	165	794	java/io/FileNotFoundException
    //   158	165	799	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpsd
 * JD-Core Version:    0.7.0.1
 */