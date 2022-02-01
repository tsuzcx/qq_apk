public class bpek
  extends bpez<bpel, bpel>
  implements wef
{
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, bpel parambpel)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aload_2
    //   7: getfield 27	bpel:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   10: getfield 33	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   13: ifnonnull +18 -> 31
    //   16: aload_0
    //   17: new 35	com/tencent/biz/qqstory/base/ErrorMessage
    //   20: dup
    //   21: iconst_m1
    //   22: ldc 37
    //   24: invokespecial 40	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   27: invokespecial 44	bpez:notifyError	(Ljava/lang/Error;)V
    //   30: return
    //   31: aload_2
    //   32: getfield 27	bpel:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   35: getfield 47	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   38: astore 12
    //   40: aload_2
    //   41: getfield 27	bpel:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   44: getfield 50	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   47: astore 11
    //   49: aload 11
    //   51: ifnonnull +14 -> 65
    //   54: aload 12
    //   56: ifnonnull +9 -> 65
    //   59: aload_0
    //   60: aload_2
    //   61: invokespecial 54	bpez:notifyResult	(Ljava/lang/Object;)V
    //   64: return
    //   65: aload_2
    //   66: getfield 57	bpel:jdField_a_of_type_Bpes	Lbpes;
    //   69: getfield 63	bpes:c	I
    //   72: istore 5
    //   74: aload_2
    //   75: getfield 65	bpel:jdField_a_of_type_Int	I
    //   78: istore_3
    //   79: iload_3
    //   80: iconst_2
    //   81: if_icmpeq +25 -> 106
    //   84: iload_3
    //   85: iconst_3
    //   86: if_icmpeq +20 -> 106
    //   89: iload_3
    //   90: iconst_5
    //   91: if_icmpeq +15 -> 106
    //   94: iload_3
    //   95: bipush 102
    //   97: if_icmpeq +9 -> 106
    //   100: iload_3
    //   101: bipush 6
    //   103: if_icmpne +418 -> 521
    //   106: aload 12
    //   108: ifnull +209 -> 317
    //   111: aload 12
    //   113: aconst_null
    //   114: invokestatic 70	zdr:a	(Ljava/lang/String;Lzds;)Landroid/graphics/Bitmap;
    //   117: astore_1
    //   118: iconst_1
    //   119: istore 4
    //   121: aload_1
    //   122: ifnonnull +430 -> 552
    //   125: aload 11
    //   127: ifnull +425 -> 552
    //   130: new 72	java/io/BufferedInputStream
    //   133: dup
    //   134: new 74	java/io/FileInputStream
    //   137: dup
    //   138: aload 11
    //   140: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   143: invokespecial 80	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   146: astore 8
    //   148: aload 8
    //   150: astore 9
    //   152: aload 8
    //   154: invokestatic 86	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   157: astore 10
    //   159: aload 8
    //   161: ifnull +394 -> 555
    //   164: aload 8
    //   166: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   169: aload 10
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +332 -> 505
    //   176: iload 5
    //   178: sipush 270
    //   181: if_icmpne +279 -> 460
    //   184: bipush 90
    //   186: istore_3
    //   187: aload_2
    //   188: getfield 92	bpel:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   191: instanceof 94
    //   194: ifeq +39 -> 233
    //   197: ldc 96
    //   199: new 98	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   206: ldc 101
    //   208: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload 5
    //   213: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: ldc 110
    //   218: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iconst_0
    //   222: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 120	ykq:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: iconst_0
    //   232: istore_3
    //   233: aload_1
    //   234: iload_3
    //   235: invokestatic 125	bpem:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   238: astore_1
    //   239: aload_1
    //   240: ifnull +301 -> 541
    //   243: iload 4
    //   245: ifeq +239 -> 484
    //   248: aload_1
    //   249: aload 12
    //   251: aconst_null
    //   252: invokestatic 128	zdr:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lzds;)V
    //   255: iconst_1
    //   256: istore 6
    //   258: iload 6
    //   260: istore 7
    //   262: iload 6
    //   264: ifne +25 -> 289
    //   267: iload 6
    //   269: istore 7
    //   271: aload 11
    //   273: ifnull +16 -> 289
    //   276: aload_1
    //   277: getstatic 134	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   280: bipush 60
    //   282: aload 11
    //   284: invokestatic 137	zdr:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   287: istore 7
    //   289: aload_1
    //   290: invokevirtual 142	android/graphics/Bitmap:recycle	()V
    //   293: aload_1
    //   294: ifnull +8 -> 302
    //   297: iload 7
    //   299: ifeq +191 -> 490
    //   302: aload_0
    //   303: aload_2
    //   304: invokespecial 54	bpez:notifyResult	(Ljava/lang/Object;)V
    //   307: return
    //   308: astore_1
    //   309: ldc 96
    //   311: ldc 144
    //   313: aload_1
    //   314: invokestatic 147	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   317: iconst_0
    //   318: istore 4
    //   320: aconst_null
    //   321: astore_1
    //   322: goto -201 -> 121
    //   325: astore_1
    //   326: ldc 96
    //   328: ldc 149
    //   330: aload_1
    //   331: invokestatic 147	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   334: aload 10
    //   336: astore_1
    //   337: goto -165 -> 172
    //   340: astore 10
    //   342: aconst_null
    //   343: astore 8
    //   345: aload 8
    //   347: astore 9
    //   349: ldc 96
    //   351: ldc 151
    //   353: aload 10
    //   355: invokestatic 147	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   358: aload 8
    //   360: ifnull +192 -> 552
    //   363: aload 8
    //   365: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   368: goto -196 -> 172
    //   371: astore 8
    //   373: ldc 96
    //   375: ldc 149
    //   377: aload 8
    //   379: invokestatic 147	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   382: goto -210 -> 172
    //   385: astore 9
    //   387: aload 10
    //   389: astore 8
    //   391: aload 9
    //   393: astore 10
    //   395: aload 8
    //   397: astore 9
    //   399: ldc 96
    //   401: ldc 153
    //   403: aload 10
    //   405: invokestatic 147	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   408: aload 8
    //   410: ifnull +142 -> 552
    //   413: aload 8
    //   415: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   418: goto -246 -> 172
    //   421: astore 8
    //   423: ldc 96
    //   425: ldc 149
    //   427: aload 8
    //   429: invokestatic 147	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   432: goto -260 -> 172
    //   435: astore_1
    //   436: aload 9
    //   438: ifnull +8 -> 446
    //   441: aload 9
    //   443: invokevirtual 89	java/io/BufferedInputStream:close	()V
    //   446: aload_1
    //   447: athrow
    //   448: astore_2
    //   449: ldc 96
    //   451: ldc 149
    //   453: aload_2
    //   454: invokestatic 147	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   457: goto -11 -> 446
    //   460: iload 5
    //   462: bipush 90
    //   464: if_icmpne +83 -> 547
    //   467: bipush 166
    //   469: istore_3
    //   470: goto -283 -> 187
    //   473: astore 8
    //   475: ldc 96
    //   477: ldc 155
    //   479: aload 8
    //   481: invokestatic 147	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   484: iconst_0
    //   485: istore 6
    //   487: goto -229 -> 258
    //   490: aload_0
    //   491: new 35	com/tencent/biz/qqstory/base/ErrorMessage
    //   494: dup
    //   495: iconst_m1
    //   496: ldc 157
    //   498: invokespecial 40	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   501: invokespecial 44	bpez:notifyError	(Ljava/lang/Error;)V
    //   504: return
    //   505: aload_0
    //   506: new 159	com/tencent/biz/qqstory/base/BitmapError
    //   509: dup
    //   510: ldc 96
    //   512: bipush 6
    //   514: invokespecial 162	com/tencent/biz/qqstory/base/BitmapError:<init>	(Ljava/lang/String;I)V
    //   517: invokespecial 44	bpez:notifyError	(Ljava/lang/Error;)V
    //   520: return
    //   521: aload_0
    //   522: aload_2
    //   523: invokespecial 54	bpez:notifyResult	(Ljava/lang/Object;)V
    //   526: return
    //   527: astore_1
    //   528: goto -92 -> 436
    //   531: astore 10
    //   533: goto -138 -> 395
    //   536: astore 10
    //   538: goto -193 -> 345
    //   541: iconst_0
    //   542: istore 7
    //   544: goto -251 -> 293
    //   547: iconst_0
    //   548: istore_3
    //   549: goto -362 -> 187
    //   552: goto -380 -> 172
    //   555: aload 10
    //   557: astore_1
    //   558: goto -386 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	this	bpek
    //   0	561	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	561	2	parambpel	bpel
    //   78	471	3	i	int
    //   119	200	4	j	int
    //   72	393	5	k	int
    //   256	230	6	bool1	boolean
    //   260	283	7	bool2	boolean
    //   146	218	8	localBufferedInputStream	java.io.BufferedInputStream
    //   371	7	8	localIOException1	java.io.IOException
    //   389	25	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   421	7	8	localIOException2	java.io.IOException
    //   473	7	8	localIOException3	java.io.IOException
    //   1	347	9	localObject1	java.lang.Object
    //   385	7	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   397	45	9	localObject2	java.lang.Object
    //   4	331	10	localBitmap	android.graphics.Bitmap
    //   340	48	10	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   393	11	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   531	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   536	20	10	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   47	236	11	str1	java.lang.String
    //   38	212	12	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   111	118	308	java/lang/Throwable
    //   164	169	325	java/io/IOException
    //   130	148	340	java/lang/OutOfMemoryError
    //   363	368	371	java/io/IOException
    //   130	148	385	java/io/FileNotFoundException
    //   413	418	421	java/io/IOException
    //   130	148	435	finally
    //   399	408	435	finally
    //   441	446	448	java/io/IOException
    //   248	255	473	java/io/IOException
    //   152	159	527	finally
    //   349	358	527	finally
    //   152	159	531	java/io/FileNotFoundException
    //   152	159	536	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpek
 * JD-Core Version:    0.7.0.1
 */