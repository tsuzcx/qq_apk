package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;

public class RegionalThumbDecoder
  implements BitmapDecoder
{
  /* Error */
  @android.annotation.TargetApi(10)
  public android.graphics.Bitmap getBitmap(java.net.URL paramURL)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 28	com/tencent/mobileqq/activity/photo/LocalMediaInfo:parseUrl	(Ljava/net/URL;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   4: astore 7
    //   6: aload 7
    //   8: ifnull +657 -> 665
    //   11: new 30	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 31	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: iconst_1
    //   21: putfield 35	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload 7
    //   26: getfield 39	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   29: aload_1
    //   30: invokestatic 45	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: pop
    //   34: aload_1
    //   35: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   38: aload_1
    //   39: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   42: if_icmple +21 -> 63
    //   45: aload_1
    //   46: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   49: istore_2
    //   50: aload_1
    //   51: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   54: aload_1
    //   55: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   58: idiv
    //   59: istore_3
    //   60: goto +18 -> 78
    //   63: aload_1
    //   64: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   67: istore_2
    //   68: aload_1
    //   69: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   72: aload_1
    //   73: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   76: idiv
    //   77: istore_3
    //   78: iload_3
    //   79: i2f
    //   80: ldc 53
    //   82: fcmpg
    //   83: ifgt +48 -> 131
    //   86: aload_1
    //   87: aload_1
    //   88: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   91: aload_1
    //   92: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   95: aload 7
    //   97: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   100: invokestatic 62	com/tencent/mobileqq/activity/photo/ThumbDecoder:calSampleSize	(III)I
    //   103: putfield 65	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   106: aload_1
    //   107: iconst_0
    //   108: putfield 35	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: aload_1
    //   112: getstatic 71	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   115: putfield 74	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   118: aload 7
    //   120: getfield 39	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   123: aload_1
    //   124: invokestatic 79	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore_1
    //   128: goto +104 -> 232
    //   131: new 81	android/graphics/Rect
    //   134: dup
    //   135: iconst_0
    //   136: iconst_0
    //   137: iload_2
    //   138: iload_2
    //   139: invokespecial 84	android/graphics/Rect:<init>	(IIII)V
    //   142: astore 6
    //   144: aload_1
    //   145: iload_2
    //   146: iload_2
    //   147: aload 7
    //   149: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   152: invokestatic 62	com/tencent/mobileqq/activity/photo/ThumbDecoder:calSampleSize	(III)I
    //   155: putfield 65	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   158: aload_1
    //   159: iconst_0
    //   160: putfield 35	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   163: aload_1
    //   164: getstatic 71	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   167: putfield 74	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   170: new 86	java/io/BufferedInputStream
    //   173: dup
    //   174: new 88	java/io/FileInputStream
    //   177: dup
    //   178: aload 7
    //   180: getfield 39	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   183: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   186: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   189: astore 5
    //   191: aload 5
    //   193: iconst_1
    //   194: invokestatic 100	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   197: astore 8
    //   199: aload 5
    //   201: invokevirtual 105	java/io/InputStream:close	()V
    //   204: aload 8
    //   206: ifnull +471 -> 677
    //   209: aload 8
    //   211: aload 6
    //   213: aload_1
    //   214: invokevirtual 109	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   217: astore_1
    //   218: aload_1
    //   219: astore 5
    //   221: aload_1
    //   222: astore 6
    //   224: aload 8
    //   226: invokevirtual 112	android/graphics/BitmapRegionDecoder:recycle	()V
    //   229: goto +3 -> 232
    //   232: aload_1
    //   233: ifnonnull +31 -> 264
    //   236: aload_1
    //   237: astore 5
    //   239: aload_1
    //   240: astore 6
    //   242: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +437 -> 682
    //   248: aload_1
    //   249: astore 5
    //   251: aload_1
    //   252: astore 6
    //   254: ldc 120
    //   256: iconst_2
    //   257: ldc 122
    //   259: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_1
    //   263: areturn
    //   264: aload_1
    //   265: astore 5
    //   267: aload_1
    //   268: astore 6
    //   270: aload 7
    //   272: getfield 39	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   275: invokestatic 132	com/tencent/mobileqq/transfile/URLDrawableHelper:getExifRotation	(Ljava/lang/String;)I
    //   278: istore_2
    //   279: iload_2
    //   280: ifne +41 -> 321
    //   283: aload_1
    //   284: astore 5
    //   286: aload_1
    //   287: astore 6
    //   289: aload_1
    //   290: invokevirtual 138	android/graphics/Bitmap:getWidth	()I
    //   293: aload 7
    //   295: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   298: if_icmpne +23 -> 321
    //   301: aload_1
    //   302: astore 5
    //   304: aload_1
    //   305: astore 6
    //   307: aload_1
    //   308: invokevirtual 141	android/graphics/Bitmap:getHeight	()I
    //   311: aload 7
    //   313: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   316: if_icmpne +5 -> 321
    //   319: aload_1
    //   320: areturn
    //   321: aload_1
    //   322: astore 5
    //   324: aload_1
    //   325: astore 6
    //   327: aload_1
    //   328: invokevirtual 138	android/graphics/Bitmap:getWidth	()I
    //   331: istore_3
    //   332: aload_1
    //   333: astore 5
    //   335: aload_1
    //   336: astore 6
    //   338: aload_1
    //   339: invokevirtual 141	android/graphics/Bitmap:getHeight	()I
    //   342: istore 4
    //   344: aload_1
    //   345: astore 5
    //   347: aload_1
    //   348: astore 6
    //   350: new 81	android/graphics/Rect
    //   353: dup
    //   354: invokespecial 142	android/graphics/Rect:<init>	()V
    //   357: astore 8
    //   359: aload_1
    //   360: astore 5
    //   362: aload_1
    //   363: astore 6
    //   365: new 144	android/graphics/RectF
    //   368: dup
    //   369: fconst_0
    //   370: fconst_0
    //   371: aload 7
    //   373: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   376: i2f
    //   377: aload 7
    //   379: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   382: i2f
    //   383: invokespecial 147	android/graphics/RectF:<init>	(FFFF)V
    //   386: astore 9
    //   388: iload_3
    //   389: iload 4
    //   391: if_icmple +40 -> 431
    //   394: aload_1
    //   395: astore 5
    //   397: aload_1
    //   398: astore 6
    //   400: iload_3
    //   401: iload 4
    //   403: isub
    //   404: iconst_2
    //   405: idiv
    //   406: istore_3
    //   407: aload_1
    //   408: astore 5
    //   410: aload_1
    //   411: astore 6
    //   413: aload 8
    //   415: iload_3
    //   416: iconst_0
    //   417: iload_3
    //   418: iload 4
    //   420: iadd
    //   421: iload 4
    //   423: iconst_0
    //   424: iadd
    //   425: invokevirtual 150	android/graphics/Rect:set	(IIII)V
    //   428: goto +38 -> 466
    //   431: aload_1
    //   432: astore 5
    //   434: aload_1
    //   435: astore 6
    //   437: iload 4
    //   439: iload_3
    //   440: isub
    //   441: iconst_2
    //   442: idiv
    //   443: istore 4
    //   445: aload_1
    //   446: astore 5
    //   448: aload_1
    //   449: astore 6
    //   451: aload 8
    //   453: iconst_0
    //   454: iload 4
    //   456: iload_3
    //   457: iconst_0
    //   458: iadd
    //   459: iload_3
    //   460: iload 4
    //   462: iadd
    //   463: invokevirtual 150	android/graphics/Rect:set	(IIII)V
    //   466: aload_1
    //   467: astore 5
    //   469: aload_1
    //   470: astore 6
    //   472: aload 7
    //   474: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   477: aload 7
    //   479: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   482: getstatic 71	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   485: invokestatic 154	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   488: astore 10
    //   490: aload_1
    //   491: astore 5
    //   493: aload_1
    //   494: astore 6
    //   496: new 156	android/graphics/Canvas
    //   499: dup
    //   500: aload 10
    //   502: invokespecial 159	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   505: astore 11
    //   507: iload_2
    //   508: ifeq +32 -> 540
    //   511: aload_1
    //   512: astore 5
    //   514: aload_1
    //   515: astore 6
    //   517: aload 11
    //   519: iload_2
    //   520: i2f
    //   521: aload 7
    //   523: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   526: i2f
    //   527: fconst_2
    //   528: fdiv
    //   529: aload 7
    //   531: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   534: i2f
    //   535: fconst_2
    //   536: fdiv
    //   537: invokevirtual 163	android/graphics/Canvas:rotate	(FFF)V
    //   540: aload_1
    //   541: astore 5
    //   543: aload_1
    //   544: astore 6
    //   546: aload 11
    //   548: aload_1
    //   549: aload 8
    //   551: aload 9
    //   553: new 165	android/graphics/Paint
    //   556: dup
    //   557: bipush 6
    //   559: invokespecial 168	android/graphics/Paint:<init>	(I)V
    //   562: invokevirtual 172	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   565: aload 10
    //   567: ifnull +98 -> 665
    //   570: aload_1
    //   571: astore 5
    //   573: aload_1
    //   574: astore 6
    //   576: aload_1
    //   577: invokevirtual 173	android/graphics/Bitmap:recycle	()V
    //   580: aload 10
    //   582: areturn
    //   583: astore_1
    //   584: goto +31 -> 615
    //   587: astore_1
    //   588: goto +54 -> 642
    //   591: astore_1
    //   592: goto +7 -> 599
    //   595: astore_1
    //   596: aconst_null
    //   597: astore 5
    //   599: aload 5
    //   601: ifnull +8 -> 609
    //   604: aload 5
    //   606: invokevirtual 105	java/io/InputStream:close	()V
    //   609: aload_1
    //   610: athrow
    //   611: astore_1
    //   612: aconst_null
    //   613: astore 5
    //   615: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +12 -> 630
    //   621: ldc 120
    //   623: iconst_2
    //   624: ldc 175
    //   626: aload_1
    //   627: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   630: aload 5
    //   632: ifnull +33 -> 665
    //   635: aload 5
    //   637: areturn
    //   638: astore_1
    //   639: aconst_null
    //   640: astore 6
    //   642: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq +12 -> 657
    //   648: ldc 120
    //   650: iconst_2
    //   651: ldc 180
    //   653: aload_1
    //   654: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   657: aload 6
    //   659: ifnull +6 -> 665
    //   662: aload 6
    //   664: areturn
    //   665: aconst_null
    //   666: areturn
    //   667: astore 5
    //   669: goto -465 -> 204
    //   672: astore 5
    //   674: goto -65 -> 609
    //   677: aconst_null
    //   678: astore_1
    //   679: goto -447 -> 232
    //   682: aload_1
    //   683: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	this	RegionalThumbDecoder
    //   0	684	1	paramURL	java.net.URL
    //   49	471	2	i	int
    //   59	404	3	j	int
    //   342	121	4	k	int
    //   189	447	5	localObject1	Object
    //   667	1	5	localIOException1	java.io.IOException
    //   672	1	5	localIOException2	java.io.IOException
    //   142	521	6	localObject2	Object
    //   4	526	7	localLocalMediaInfo	LocalMediaInfo
    //   197	353	8	localObject3	Object
    //   386	166	9	localRectF	android.graphics.RectF
    //   488	93	10	localBitmap	android.graphics.Bitmap
    //   505	42	11	localCanvas	android.graphics.Canvas
    // Exception table:
    //   from	to	target	type
    //   224	229	583	java/lang/Exception
    //   242	248	583	java/lang/Exception
    //   254	262	583	java/lang/Exception
    //   270	279	583	java/lang/Exception
    //   289	301	583	java/lang/Exception
    //   307	319	583	java/lang/Exception
    //   327	332	583	java/lang/Exception
    //   338	344	583	java/lang/Exception
    //   350	359	583	java/lang/Exception
    //   365	388	583	java/lang/Exception
    //   400	407	583	java/lang/Exception
    //   413	428	583	java/lang/Exception
    //   437	445	583	java/lang/Exception
    //   451	466	583	java/lang/Exception
    //   472	490	583	java/lang/Exception
    //   496	507	583	java/lang/Exception
    //   517	540	583	java/lang/Exception
    //   546	565	583	java/lang/Exception
    //   576	580	583	java/lang/Exception
    //   224	229	587	java/lang/OutOfMemoryError
    //   242	248	587	java/lang/OutOfMemoryError
    //   254	262	587	java/lang/OutOfMemoryError
    //   270	279	587	java/lang/OutOfMemoryError
    //   289	301	587	java/lang/OutOfMemoryError
    //   307	319	587	java/lang/OutOfMemoryError
    //   327	332	587	java/lang/OutOfMemoryError
    //   338	344	587	java/lang/OutOfMemoryError
    //   350	359	587	java/lang/OutOfMemoryError
    //   365	388	587	java/lang/OutOfMemoryError
    //   400	407	587	java/lang/OutOfMemoryError
    //   413	428	587	java/lang/OutOfMemoryError
    //   437	445	587	java/lang/OutOfMemoryError
    //   451	466	587	java/lang/OutOfMemoryError
    //   472	490	587	java/lang/OutOfMemoryError
    //   496	507	587	java/lang/OutOfMemoryError
    //   517	540	587	java/lang/OutOfMemoryError
    //   546	565	587	java/lang/OutOfMemoryError
    //   576	580	587	java/lang/OutOfMemoryError
    //   191	199	591	finally
    //   170	191	595	finally
    //   11	60	611	java/lang/Exception
    //   63	78	611	java/lang/Exception
    //   86	128	611	java/lang/Exception
    //   131	170	611	java/lang/Exception
    //   199	204	611	java/lang/Exception
    //   209	218	611	java/lang/Exception
    //   604	609	611	java/lang/Exception
    //   609	611	611	java/lang/Exception
    //   11	60	638	java/lang/OutOfMemoryError
    //   63	78	638	java/lang/OutOfMemoryError
    //   86	128	638	java/lang/OutOfMemoryError
    //   131	170	638	java/lang/OutOfMemoryError
    //   199	204	638	java/lang/OutOfMemoryError
    //   209	218	638	java/lang/OutOfMemoryError
    //   604	609	638	java/lang/OutOfMemoryError
    //   609	611	638	java/lang/OutOfMemoryError
    //   199	204	667	java/io/IOException
    //   604	609	672	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.RegionalThumbDecoder
 * JD-Core Version:    0.7.0.1
 */