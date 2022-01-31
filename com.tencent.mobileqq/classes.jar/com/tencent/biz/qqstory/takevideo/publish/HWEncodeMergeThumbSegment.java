package com.tencent.biz.qqstory.takevideo.publish;

public class HWEncodeMergeThumbSegment
  extends MeasureJobSegment
{
  private final String a;
  
  public HWEncodeMergeThumbSegment()
  {
    this(null);
  }
  
  public HWEncodeMergeThumbSegment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_2
    //   4: getfield 26	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: astore 5
    //   9: aload 5
    //   11: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +18 -> 32
    //   17: aload_0
    //   18: new 34	com/tencent/biz/qqstory/base/ErrorMessage
    //   21: dup
    //   22: iconst_m1
    //   23: ldc 36
    //   25: invokespecial 39	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   28: invokespecial 43	com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   31: return
    //   32: aload_0
    //   33: getfield 16	com/tencent/biz/qqstory/takevideo/publish/HWEncodeMergeThumbSegment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: astore 7
    //   40: aload_1
    //   41: ifnonnull +18 -> 59
    //   44: aload_2
    //   45: getfield 46	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   48: aload_2
    //   49: getfield 49	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:b	Ljava/lang/String;
    //   52: ldc 51
    //   54: invokestatic 56	com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 7
    //   59: aload_2
    //   60: getfield 59	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   63: getfield 64	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   66: astore 10
    //   68: aload_2
    //   69: getfield 59	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   72: getfield 67	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   75: astore 9
    //   77: aload 10
    //   79: ifnonnull +116 -> 195
    //   82: aload 9
    //   84: ifnonnull +111 -> 195
    //   87: ldc 69
    //   89: ldc 71
    //   91: aload 7
    //   93: invokestatic 76	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   96: new 78	java/io/File
    //   99: dup
    //   100: aload 5
    //   102: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: new 78	java/io/File
    //   108: dup
    //   109: aload 7
    //   111: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: invokestatic 84	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   117: ifeq +52 -> 169
    //   120: aload_2
    //   121: getfield 59	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   124: aload 7
    //   126: putfield 87	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   129: iconst_1
    //   130: istore_3
    //   131: iload_3
    //   132: ifeq +507 -> 639
    //   135: new 78	java/io/File
    //   138: dup
    //   139: aload_2
    //   140: getfield 59	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   143: getfield 87	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   146: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: new 78	java/io/File
    //   152: dup
    //   153: getstatic 90	com/tencent/biz/qqstory/takevideo/QQStoryTakeVideoCloseAnimationActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   156: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: invokestatic 84	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   162: pop
    //   163: aload_0
    //   164: aload_2
    //   165: invokespecial 94	com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   168: return
    //   169: ldc 69
    //   171: ldc 96
    //   173: iconst_2
    //   174: anewarray 98	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload 5
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload 7
    //   186: aastore
    //   187: invokestatic 102	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: iconst_0
    //   191: istore_3
    //   192: goto -61 -> 131
    //   195: new 104	java/io/BufferedInputStream
    //   198: dup
    //   199: new 106	java/io/FileInputStream
    //   202: dup
    //   203: aload 5
    //   205: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   208: invokespecial 110	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   211: astore 5
    //   213: aload 5
    //   215: astore_1
    //   216: aload 5
    //   218: invokestatic 116	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   221: astore 6
    //   223: aload 5
    //   225: ifnull +471 -> 696
    //   228: aload 5
    //   230: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   233: aload 6
    //   235: astore_1
    //   236: aload_1
    //   237: ifnonnull +150 -> 387
    //   240: aload_0
    //   241: new 34	com/tencent/biz/qqstory/base/ErrorMessage
    //   244: dup
    //   245: iconst_m1
    //   246: ldc 121
    //   248: invokespecial 39	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   251: invokespecial 43	com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   254: return
    //   255: astore_1
    //   256: ldc 69
    //   258: ldc 123
    //   260: aload_1
    //   261: invokestatic 126	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: aload 6
    //   266: astore_1
    //   267: goto -31 -> 236
    //   270: astore 6
    //   272: aconst_null
    //   273: astore 5
    //   275: aload 5
    //   277: astore_1
    //   278: ldc 69
    //   280: ldc 128
    //   282: aload 6
    //   284: invokestatic 126	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: aload 5
    //   289: ifnull +402 -> 691
    //   292: aload 5
    //   294: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   297: aconst_null
    //   298: astore_1
    //   299: goto -63 -> 236
    //   302: astore_1
    //   303: ldc 69
    //   305: ldc 123
    //   307: aload_1
    //   308: invokestatic 126	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   311: aconst_null
    //   312: astore_1
    //   313: goto -77 -> 236
    //   316: astore 6
    //   318: aconst_null
    //   319: astore 5
    //   321: aload 5
    //   323: astore_1
    //   324: ldc 69
    //   326: ldc 130
    //   328: aload 6
    //   330: invokestatic 126	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   333: aload 5
    //   335: ifnull +356 -> 691
    //   338: aload 5
    //   340: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   343: aconst_null
    //   344: astore_1
    //   345: goto -109 -> 236
    //   348: astore_1
    //   349: ldc 69
    //   351: ldc 123
    //   353: aload_1
    //   354: invokestatic 126	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: aconst_null
    //   358: astore_1
    //   359: goto -123 -> 236
    //   362: astore_2
    //   363: aconst_null
    //   364: astore_1
    //   365: aload_1
    //   366: ifnull +7 -> 373
    //   369: aload_1
    //   370: invokevirtual 119	java/io/BufferedInputStream:close	()V
    //   373: aload_2
    //   374: athrow
    //   375: astore_1
    //   376: ldc 69
    //   378: ldc 123
    //   380: aload_1
    //   381: invokestatic 126	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: goto -11 -> 373
    //   387: aload 10
    //   389: ifnull +296 -> 685
    //   392: aload 10
    //   394: aconst_null
    //   395: invokestatic 135	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler;)Landroid/graphics/Bitmap;
    //   398: astore 5
    //   400: ldc 69
    //   402: ldc 137
    //   404: iconst_1
    //   405: anewarray 98	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: aload 10
    //   412: aastore
    //   413: invokestatic 102	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   416: aload 5
    //   418: ifnonnull +100 -> 518
    //   421: aload 9
    //   423: ifnull +95 -> 518
    //   426: aload 9
    //   428: invokestatic 141	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   431: astore 6
    //   433: aload 6
    //   435: ifnull +90 -> 525
    //   438: aload_1
    //   439: aload 6
    //   441: invokestatic 144	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   444: astore 5
    //   446: aload 6
    //   448: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   451: aload_1
    //   452: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   455: aload 5
    //   457: astore_1
    //   458: aload_1
    //   459: ifnonnull +105 -> 564
    //   462: iconst_0
    //   463: istore_3
    //   464: goto -333 -> 131
    //   467: astore 6
    //   469: aconst_null
    //   470: astore 5
    //   472: ldc 69
    //   474: ldc 151
    //   476: aload 6
    //   478: invokestatic 154	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   481: goto -65 -> 416
    //   484: astore 6
    //   486: ldc 69
    //   488: new 156	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   495: ldc 159
    //   497: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload 9
    //   502: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc 165
    //   507: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: aload 6
    //   515: invokestatic 154	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   518: aload 5
    //   520: astore 6
    //   522: goto -89 -> 433
    //   525: aload_1
    //   526: astore 5
    //   528: goto -73 -> 455
    //   531: astore 5
    //   533: aload 8
    //   535: astore_1
    //   536: ldc 69
    //   538: new 156	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   545: ldc 171
    //   547: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 5
    //   552: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 178	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: goto -103 -> 458
    //   564: getstatic 182	com/tencent/biz/qqstory/app/QQStoryConstant:c	Ljava/lang/String;
    //   567: invokestatic 185	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   570: pop
    //   571: aload_1
    //   572: aload 7
    //   574: invokestatic 188	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   577: istore 4
    //   579: aload_1
    //   580: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   583: iload 4
    //   585: ifeq +42 -> 627
    //   588: aload_2
    //   589: getfield 59	com/tencent/biz/qqstory/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   592: aload 7
    //   594: putfield 87	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   597: ldc 69
    //   599: new 156	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   606: ldc 190
    //   608: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 7
    //   613: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 192	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   622: iconst_1
    //   623: istore_3
    //   624: goto -493 -> 131
    //   627: ldc 69
    //   629: ldc 194
    //   631: invokestatic 196	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: iconst_0
    //   635: istore_3
    //   636: goto -505 -> 131
    //   639: aload_0
    //   640: new 34	com/tencent/biz/qqstory/base/ErrorMessage
    //   643: dup
    //   644: iconst_m1
    //   645: ldc 121
    //   647: invokespecial 39	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   650: invokespecial 43	com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   653: return
    //   654: astore 6
    //   656: aload 5
    //   658: astore_1
    //   659: aload 6
    //   661: astore 5
    //   663: goto -127 -> 536
    //   666: astore 6
    //   668: goto -196 -> 472
    //   671: astore_2
    //   672: goto -307 -> 365
    //   675: astore 6
    //   677: goto -356 -> 321
    //   680: astore 6
    //   682: goto -407 -> 275
    //   685: aconst_null
    //   686: astore 5
    //   688: goto -272 -> 416
    //   691: aconst_null
    //   692: astore_1
    //   693: goto -457 -> 236
    //   696: aload 6
    //   698: astore_1
    //   699: goto -463 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	702	0	this	HWEncodeMergeThumbSegment
    //   0	702	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	702	2	paramGenerateContext	GenerateContext
    //   130	506	3	i	int
    //   577	7	4	bool	boolean
    //   7	520	5	localObject1	java.lang.Object
    //   531	126	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   661	26	5	localObject2	java.lang.Object
    //   221	44	6	localBitmap1	android.graphics.Bitmap
    //   270	13	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   316	13	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   431	16	6	localBitmap2	android.graphics.Bitmap
    //   467	10	6	localIOException1	java.io.IOException
    //   484	30	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   520	1	6	localObject3	java.lang.Object
    //   654	6	6	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   666	1	6	localIOException2	java.io.IOException
    //   675	1	6	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   680	17	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   38	574	7	localObject4	java.lang.Object
    //   1	533	8	localObject5	java.lang.Object
    //   75	426	9	str1	String
    //   66	345	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   228	233	255	java/io/IOException
    //   195	213	270	java/io/FileNotFoundException
    //   292	297	302	java/io/IOException
    //   195	213	316	java/lang/OutOfMemoryError
    //   338	343	348	java/io/IOException
    //   195	213	362	finally
    //   369	373	375	java/io/IOException
    //   392	400	467	java/io/IOException
    //   426	433	484	java/lang/OutOfMemoryError
    //   392	400	531	java/lang/OutOfMemoryError
    //   400	416	531	java/lang/OutOfMemoryError
    //   438	446	531	java/lang/OutOfMemoryError
    //   472	481	531	java/lang/OutOfMemoryError
    //   486	518	531	java/lang/OutOfMemoryError
    //   446	455	654	java/lang/OutOfMemoryError
    //   400	416	666	java/io/IOException
    //   216	223	671	finally
    //   278	287	671	finally
    //   324	333	671	finally
    //   216	223	675	java/lang/OutOfMemoryError
    //   216	223	680	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.HWEncodeMergeThumbSegment
 * JD-Core Version:    0.7.0.1
 */