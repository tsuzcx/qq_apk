package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import com.tencent.biz.qqstory.boundaries.KeepConstructor;

public class DoodleRotateSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
  implements KeepConstructor
{
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 28	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:d	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   4: getfield 34	com/tencent/mobileqq/editor/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   7: ifnonnull +18 -> 25
    //   10: aload_0
    //   11: new 36	com/tencent/biz/qqstory/base/ErrorMessage
    //   14: dup
    //   15: iconst_m1
    //   16: ldc 38
    //   18: invokespecial 41	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   21: invokespecial 45	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   24: return
    //   25: aload_2
    //   26: getfield 28	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:d	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   29: getfield 48	com/tencent/mobileqq/editor/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   32: astore 13
    //   34: aload_2
    //   35: getfield 28	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:d	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   38: getfield 51	com/tencent/mobileqq/editor/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   41: astore 12
    //   43: aload 12
    //   45: ifnonnull +14 -> 59
    //   48: aload 13
    //   50: ifnonnull +9 -> 59
    //   53: aload_0
    //   54: aload_2
    //   55: invokespecial 55	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   58: return
    //   59: aload_2
    //   60: getfield 59	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:i	Lcom/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateThumbArgs;
    //   63: getfield 65	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateThumbArgs:g	I
    //   66: istore 5
    //   68: aload_2
    //   69: getfield 68	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:b	I
    //   72: istore_3
    //   73: iload_3
    //   74: iconst_2
    //   75: if_icmpeq +28 -> 103
    //   78: iload_3
    //   79: iconst_3
    //   80: if_icmpeq +23 -> 103
    //   83: iload_3
    //   84: iconst_5
    //   85: if_icmpeq +18 -> 103
    //   88: iload_3
    //   89: bipush 6
    //   91: if_icmpne +6 -> 97
    //   94: goto +9 -> 103
    //   97: aload_0
    //   98: aload_2
    //   99: invokespecial 55	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   102: return
    //   103: iconst_0
    //   104: istore 7
    //   106: iconst_0
    //   107: istore 8
    //   109: aload 13
    //   111: ifnull +26 -> 137
    //   114: aload 13
    //   116: aconst_null
    //   117: invokestatic 73	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler;)Landroid/graphics/Bitmap;
    //   120: astore 9
    //   122: iconst_1
    //   123: istore 4
    //   125: goto +18 -> 143
    //   128: astore_1
    //   129: ldc 75
    //   131: ldc 77
    //   133: aload_1
    //   134: invokestatic 83	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: aconst_null
    //   138: astore 9
    //   140: iconst_0
    //   141: istore 4
    //   143: aload 9
    //   145: astore_1
    //   146: aload 9
    //   148: ifnonnull +199 -> 347
    //   151: aload 9
    //   153: astore_1
    //   154: aload 12
    //   156: ifnull +191 -> 347
    //   159: new 85	java/io/BufferedInputStream
    //   162: dup
    //   163: new 87	java/io/FileInputStream
    //   166: dup
    //   167: aload 12
    //   169: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   172: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   175: astore 10
    //   177: aload 10
    //   179: astore_1
    //   180: aload 10
    //   182: invokestatic 99	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   185: astore 11
    //   187: aload 10
    //   189: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   192: aload 11
    //   194: astore_1
    //   195: goto +152 -> 347
    //   198: astore_1
    //   199: ldc 75
    //   201: ldc 104
    //   203: aload_1
    //   204: invokestatic 83	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   207: aload 11
    //   209: astore_1
    //   210: goto +137 -> 347
    //   213: astore 11
    //   215: goto +20 -> 235
    //   218: astore 11
    //   220: goto +51 -> 271
    //   223: astore_1
    //   224: aconst_null
    //   225: astore 9
    //   227: goto +96 -> 323
    //   230: astore 11
    //   232: aconst_null
    //   233: astore 10
    //   235: aload 10
    //   237: astore_1
    //   238: ldc 75
    //   240: ldc 106
    //   242: aload 11
    //   244: invokestatic 83	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload 9
    //   249: astore_1
    //   250: aload 10
    //   252: ifnull +95 -> 347
    //   255: aload 10
    //   257: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   260: aload 9
    //   262: astore_1
    //   263: goto +84 -> 347
    //   266: astore 11
    //   268: aconst_null
    //   269: astore 10
    //   271: aload 10
    //   273: astore_1
    //   274: ldc 75
    //   276: ldc 108
    //   278: aload 11
    //   280: invokestatic 83	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload 9
    //   285: astore_1
    //   286: aload 10
    //   288: ifnull +59 -> 347
    //   291: aload 10
    //   293: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   296: aload 9
    //   298: astore_1
    //   299: goto +48 -> 347
    //   302: astore_1
    //   303: ldc 75
    //   305: ldc 104
    //   307: aload_1
    //   308: invokestatic 83	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   311: aload 9
    //   313: astore_1
    //   314: goto +33 -> 347
    //   317: astore_2
    //   318: aload_1
    //   319: astore 9
    //   321: aload_2
    //   322: astore_1
    //   323: aload 9
    //   325: ifnull +20 -> 345
    //   328: aload 9
    //   330: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   333: goto +12 -> 345
    //   336: astore_2
    //   337: ldc 75
    //   339: ldc 104
    //   341: aload_2
    //   342: invokestatic 83	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   345: aload_1
    //   346: athrow
    //   347: aload_1
    //   348: ifnull +209 -> 557
    //   351: iload 5
    //   353: sipush 270
    //   356: if_icmpne +9 -> 365
    //   359: bipush 90
    //   361: istore_3
    //   362: goto +18 -> 380
    //   365: iload 5
    //   367: bipush 90
    //   369: if_icmpne +9 -> 378
    //   372: bipush 166
    //   374: istore_3
    //   375: goto +5 -> 380
    //   378: iconst_0
    //   379: istore_3
    //   380: aload_2
    //   381: getfield 111	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:c	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   384: instanceof 113
    //   387: ifeq +55 -> 442
    //   390: new 115	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   397: astore 9
    //   399: aload 9
    //   401: ldc 118
    //   403: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 9
    //   409: iload 5
    //   411: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 9
    //   417: ldc 127
    //   419: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 9
    //   425: iconst_0
    //   426: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: ldc 75
    //   432: aload 9
    //   434: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 135	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: iconst_0
    //   441: istore_3
    //   442: aload_1
    //   443: iload_3
    //   444: invokestatic 140	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateDoodleImageSegment:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   447: astore_1
    //   448: aload_1
    //   449: ifnull +75 -> 524
    //   452: iload 8
    //   454: istore 6
    //   456: iload 4
    //   458: ifeq +31 -> 489
    //   461: aload_1
    //   462: aload 13
    //   464: aconst_null
    //   465: invokestatic 143	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler;)V
    //   468: iconst_1
    //   469: istore 6
    //   471: goto +18 -> 489
    //   474: astore 9
    //   476: ldc 75
    //   478: ldc 145
    //   480: aload 9
    //   482: invokestatic 83	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   485: iload 8
    //   487: istore 6
    //   489: iload 6
    //   491: istore 7
    //   493: iload 6
    //   495: ifne +25 -> 520
    //   498: iload 6
    //   500: istore 7
    //   502: aload 12
    //   504: ifnull +16 -> 520
    //   507: aload_1
    //   508: getstatic 151	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   511: bipush 60
    //   513: aload 12
    //   515: invokestatic 154	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   518: istore 7
    //   520: aload_1
    //   521: invokevirtual 159	android/graphics/Bitmap:recycle	()V
    //   524: aload_1
    //   525: ifnull +26 -> 551
    //   528: iload 7
    //   530: ifeq +6 -> 536
    //   533: goto +18 -> 551
    //   536: aload_0
    //   537: new 36	com/tencent/biz/qqstory/base/ErrorMessage
    //   540: dup
    //   541: iconst_m1
    //   542: ldc 161
    //   544: invokespecial 41	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   547: invokespecial 45	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   550: return
    //   551: aload_0
    //   552: aload_2
    //   553: invokespecial 55	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   556: return
    //   557: aload_0
    //   558: new 163	com/tencent/biz/qqstory/base/BitmapError
    //   561: dup
    //   562: ldc 75
    //   564: bipush 6
    //   566: invokespecial 166	com/tencent/biz/qqstory/base/BitmapError:<init>	(Ljava/lang/String;I)V
    //   569: invokespecial 45	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyError	(Ljava/lang/Error;)V
    //   572: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	DoodleRotateSegment
    //   0	573	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	573	2	paramGenerateContext	GenerateContext
    //   72	372	3	i	int
    //   123	334	4	j	int
    //   66	344	5	k	int
    //   454	45	6	bool1	boolean
    //   104	425	7	bool2	boolean
    //   107	379	8	bool3	boolean
    //   120	313	9	localObject	java.lang.Object
    //   474	7	9	localIOException	java.io.IOException
    //   175	117	10	localBufferedInputStream	java.io.BufferedInputStream
    //   185	23	11	localBitmap	android.graphics.Bitmap
    //   213	1	11	localFileNotFoundException1	java.io.FileNotFoundException
    //   218	1	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   230	13	11	localFileNotFoundException2	java.io.FileNotFoundException
    //   266	13	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   41	473	12	str1	java.lang.String
    //   32	431	13	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   114	122	128	java/lang/Throwable
    //   187	192	198	java/io/IOException
    //   180	187	213	java/io/FileNotFoundException
    //   180	187	218	java/lang/OutOfMemoryError
    //   159	177	223	finally
    //   159	177	230	java/io/FileNotFoundException
    //   159	177	266	java/lang/OutOfMemoryError
    //   255	260	302	java/io/IOException
    //   291	296	302	java/io/IOException
    //   180	187	317	finally
    //   238	247	317	finally
    //   274	283	317	finally
    //   328	333	336	java/io/IOException
    //   461	468	474	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.DoodleRotateSegment
 * JD-Core Version:    0.7.0.1
 */