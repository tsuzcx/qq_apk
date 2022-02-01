package com.tencent.mobileqq.activity.photo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;

public class NewRegionalThumbDecoder
  implements BitmapDecoder
{
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
    new Canvas(localBitmap).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new RectF(0.0F, 0.0F, paramInt1, paramInt2), new Paint(6));
    return localBitmap;
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  public Bitmap getBitmap(java.net.URL paramURL)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 71	com/tencent/mobileqq/activity/photo/LocalMediaInfo:parseUrl	(Ljava/net/URL;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   4: astore 9
    //   6: aload 9
    //   8: ifnull +571 -> 579
    //   11: new 73	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 74	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: iconst_0
    //   21: putfield 78	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload 9
    //   26: getfield 82	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   29: aload_1
    //   30: invokestatic 87	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: astore_1
    //   34: aload 9
    //   36: getfield 91	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   39: istore_2
    //   40: aload 9
    //   42: getfield 94	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   45: istore_3
    //   46: aload_1
    //   47: invokevirtual 36	android/graphics/Bitmap:getWidth	()I
    //   50: istore 4
    //   52: aload_1
    //   53: invokevirtual 39	android/graphics/Bitmap:getHeight	()I
    //   56: istore 5
    //   58: iload 5
    //   60: iload 4
    //   62: if_icmple +185 -> 247
    //   65: iload 5
    //   67: iload 4
    //   69: idiv
    //   70: i2f
    //   71: ldc 95
    //   73: fcmpl
    //   74: ifle +101 -> 175
    //   77: iload_3
    //   78: iload_2
    //   79: getstatic 19	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   82: invokestatic 25	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   85: astore 8
    //   87: new 27	android/graphics/Canvas
    //   90: dup
    //   91: aload 8
    //   93: invokespecial 30	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   96: astore 7
    //   98: iload 4
    //   100: iconst_3
    //   101: imul
    //   102: istore 6
    //   104: aload 7
    //   106: aload_1
    //   107: new 32	android/graphics/Rect
    //   110: dup
    //   111: iconst_0
    //   112: iload 5
    //   114: iload 6
    //   116: isub
    //   117: iconst_2
    //   118: idiv
    //   119: iload 4
    //   121: iload 5
    //   123: iload 6
    //   125: iadd
    //   126: iconst_2
    //   127: idiv
    //   128: invokespecial 42	android/graphics/Rect:<init>	(IIII)V
    //   131: new 44	android/graphics/RectF
    //   134: dup
    //   135: fconst_0
    //   136: fconst_0
    //   137: iload_3
    //   138: i2f
    //   139: iload_2
    //   140: i2f
    //   141: invokespecial 47	android/graphics/RectF:<init>	(FFFF)V
    //   144: new 49	android/graphics/Paint
    //   147: dup
    //   148: bipush 6
    //   150: invokespecial 52	android/graphics/Paint:<init>	(I)V
    //   153: invokevirtual 56	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   156: aload_1
    //   157: astore 7
    //   159: aload 8
    //   161: ifnull +267 -> 428
    //   164: aload_1
    //   165: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   168: aload 8
    //   170: astore 7
    //   172: goto +256 -> 428
    //   175: iload 5
    //   177: iload_2
    //   178: if_icmple +403 -> 581
    //   181: aload_0
    //   182: aload_1
    //   183: iload 4
    //   185: iload_2
    //   186: imul
    //   187: iload 5
    //   189: idiv
    //   190: iload_2
    //   191: invokespecial 100	com/tencent/mobileqq/activity/photo/NewRegionalThumbDecoder:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   194: astore 8
    //   196: aload_1
    //   197: astore 7
    //   199: aload 8
    //   201: ifnull +227 -> 428
    //   204: aload_1
    //   205: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   208: aload 8
    //   210: astore_1
    //   211: goto +220 -> 431
    //   214: aload_0
    //   215: aload_1
    //   216: iload_3
    //   217: iload 5
    //   219: iload_3
    //   220: imul
    //   221: iload 4
    //   223: idiv
    //   224: invokespecial 100	com/tencent/mobileqq/activity/photo/NewRegionalThumbDecoder:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   227: astore 8
    //   229: aload_1
    //   230: astore 7
    //   232: aload 8
    //   234: ifnull +194 -> 428
    //   237: aload_1
    //   238: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   241: aload 8
    //   243: astore_1
    //   244: goto +187 -> 431
    //   247: iload 4
    //   249: iload 5
    //   251: idiv
    //   252: i2f
    //   253: ldc 95
    //   255: fcmpl
    //   256: ifle +100 -> 356
    //   259: iload_2
    //   260: iload_3
    //   261: getstatic 19	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   264: invokestatic 25	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   267: astore 8
    //   269: new 27	android/graphics/Canvas
    //   272: dup
    //   273: aload 8
    //   275: invokespecial 30	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   278: astore 7
    //   280: iload 5
    //   282: iconst_3
    //   283: imul
    //   284: istore 6
    //   286: aload 7
    //   288: aload_1
    //   289: new 32	android/graphics/Rect
    //   292: dup
    //   293: iload 4
    //   295: iload 6
    //   297: isub
    //   298: iconst_2
    //   299: idiv
    //   300: iconst_0
    //   301: iload 4
    //   303: iload 6
    //   305: iadd
    //   306: iconst_2
    //   307: idiv
    //   308: iload 5
    //   310: invokespecial 42	android/graphics/Rect:<init>	(IIII)V
    //   313: new 44	android/graphics/RectF
    //   316: dup
    //   317: fconst_0
    //   318: fconst_0
    //   319: iload_2
    //   320: i2f
    //   321: iload_3
    //   322: i2f
    //   323: invokespecial 47	android/graphics/RectF:<init>	(FFFF)V
    //   326: new 49	android/graphics/Paint
    //   329: dup
    //   330: bipush 6
    //   332: invokespecial 52	android/graphics/Paint:<init>	(I)V
    //   335: invokevirtual 56	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   338: aload_1
    //   339: astore 7
    //   341: aload 8
    //   343: ifnull +85 -> 428
    //   346: aload_1
    //   347: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   350: aload 8
    //   352: astore_1
    //   353: goto +78 -> 431
    //   356: iload 4
    //   358: iload_2
    //   359: if_icmple +252 -> 611
    //   362: aload_0
    //   363: aload_1
    //   364: iload_2
    //   365: iload 5
    //   367: iload_2
    //   368: imul
    //   369: iload 4
    //   371: idiv
    //   372: invokespecial 100	com/tencent/mobileqq/activity/photo/NewRegionalThumbDecoder:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   375: astore 8
    //   377: aload_1
    //   378: astore 7
    //   380: aload 8
    //   382: ifnull +46 -> 428
    //   385: aload_1
    //   386: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   389: aload 8
    //   391: astore_1
    //   392: goto +39 -> 431
    //   395: aload_0
    //   396: aload_1
    //   397: iload 4
    //   399: iload_3
    //   400: imul
    //   401: iload 5
    //   403: idiv
    //   404: iload_3
    //   405: invokespecial 100	com/tencent/mobileqq/activity/photo/NewRegionalThumbDecoder:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   408: astore 8
    //   410: aload_1
    //   411: astore 7
    //   413: aload 8
    //   415: ifnull +13 -> 428
    //   418: aload_1
    //   419: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   422: aload 8
    //   424: astore_1
    //   425: goto +6 -> 431
    //   428: aload 7
    //   430: astore_1
    //   431: aload 9
    //   433: getfield 82	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   436: invokestatic 106	com/tencent/mobileqq/transfile/URLDrawableHelper:getExifRotation	(Ljava/lang/String;)I
    //   439: istore_2
    //   440: iload_2
    //   441: ifeq +64 -> 505
    //   444: new 108	android/graphics/Matrix
    //   447: dup
    //   448: invokespecial 109	android/graphics/Matrix:<init>	()V
    //   451: astore 7
    //   453: aload 7
    //   455: iload_2
    //   456: i2f
    //   457: aload_1
    //   458: invokevirtual 36	android/graphics/Bitmap:getWidth	()I
    //   461: iconst_2
    //   462: idiv
    //   463: i2f
    //   464: aload_1
    //   465: invokevirtual 39	android/graphics/Bitmap:getHeight	()I
    //   468: iconst_2
    //   469: idiv
    //   470: i2f
    //   471: invokevirtual 113	android/graphics/Matrix:setRotate	(FFF)V
    //   474: aload_1
    //   475: iconst_0
    //   476: iconst_0
    //   477: aload_1
    //   478: invokevirtual 36	android/graphics/Bitmap:getWidth	()I
    //   481: aload_1
    //   482: invokevirtual 39	android/graphics/Bitmap:getHeight	()I
    //   485: aload 7
    //   487: iconst_1
    //   488: invokestatic 116	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   491: astore 7
    //   493: aload 7
    //   495: ifnull +10 -> 505
    //   498: aload_1
    //   499: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   502: aload 7
    //   504: areturn
    //   505: aload_1
    //   506: areturn
    //   507: astore 7
    //   509: goto +22 -> 531
    //   512: astore 7
    //   514: goto +43 -> 557
    //   517: astore 7
    //   519: goto +12 -> 531
    //   522: astore 7
    //   524: goto +33 -> 557
    //   527: astore 7
    //   529: aconst_null
    //   530: astore_1
    //   531: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq +13 -> 547
    //   537: ldc 124
    //   539: iconst_2
    //   540: ldc 126
    //   542: aload 7
    //   544: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   547: aload_1
    //   548: ifnull +31 -> 579
    //   551: aload_1
    //   552: areturn
    //   553: astore 7
    //   555: aconst_null
    //   556: astore_1
    //   557: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq +13 -> 573
    //   563: ldc 124
    //   565: iconst_2
    //   566: ldc 132
    //   568: aload 7
    //   570: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   573: aload_1
    //   574: ifnull +5 -> 579
    //   577: aload_1
    //   578: areturn
    //   579: aconst_null
    //   580: areturn
    //   581: iload 5
    //   583: iload_2
    //   584: if_icmpge -370 -> 214
    //   587: iload 5
    //   589: iload_3
    //   590: if_icmple -376 -> 214
    //   593: iload 4
    //   595: iload_2
    //   596: if_icmpge -382 -> 214
    //   599: iload 4
    //   601: iload_3
    //   602: if_icmple -388 -> 214
    //   605: aload_1
    //   606: astore 7
    //   608: goto -180 -> 428
    //   611: iload 4
    //   613: iload_2
    //   614: if_icmpge -219 -> 395
    //   617: iload 4
    //   619: iload_3
    //   620: if_icmple -225 -> 395
    //   623: iload 5
    //   625: iload_2
    //   626: if_icmpge -231 -> 395
    //   629: iload 5
    //   631: iload_3
    //   632: if_icmple -237 -> 395
    //   635: aload_1
    //   636: astore 7
    //   638: goto -210 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	641	0	this	NewRegionalThumbDecoder
    //   0	641	1	paramURL	java.net.URL
    //   39	588	2	i	int
    //   45	588	3	j	int
    //   50	571	4	k	int
    //   56	577	5	m	int
    //   102	204	6	n	int
    //   96	407	7	localObject	Object
    //   507	1	7	localException1	java.lang.Exception
    //   512	1	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   517	1	7	localException2	java.lang.Exception
    //   522	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   527	16	7	localException3	java.lang.Exception
    //   553	16	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   606	31	7	localURL	java.net.URL
    //   85	338	8	localBitmap	Bitmap
    //   4	428	9	localLocalMediaInfo	LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   431	440	507	java/lang/Exception
    //   444	493	507	java/lang/Exception
    //   498	502	507	java/lang/Exception
    //   431	440	512	java/lang/OutOfMemoryError
    //   444	493	512	java/lang/OutOfMemoryError
    //   498	502	512	java/lang/OutOfMemoryError
    //   34	58	517	java/lang/Exception
    //   65	98	517	java/lang/Exception
    //   104	156	517	java/lang/Exception
    //   164	168	517	java/lang/Exception
    //   181	196	517	java/lang/Exception
    //   204	208	517	java/lang/Exception
    //   214	229	517	java/lang/Exception
    //   237	241	517	java/lang/Exception
    //   247	280	517	java/lang/Exception
    //   286	338	517	java/lang/Exception
    //   346	350	517	java/lang/Exception
    //   362	377	517	java/lang/Exception
    //   385	389	517	java/lang/Exception
    //   395	410	517	java/lang/Exception
    //   418	422	517	java/lang/Exception
    //   34	58	522	java/lang/OutOfMemoryError
    //   65	98	522	java/lang/OutOfMemoryError
    //   104	156	522	java/lang/OutOfMemoryError
    //   164	168	522	java/lang/OutOfMemoryError
    //   181	196	522	java/lang/OutOfMemoryError
    //   204	208	522	java/lang/OutOfMemoryError
    //   214	229	522	java/lang/OutOfMemoryError
    //   237	241	522	java/lang/OutOfMemoryError
    //   247	280	522	java/lang/OutOfMemoryError
    //   286	338	522	java/lang/OutOfMemoryError
    //   346	350	522	java/lang/OutOfMemoryError
    //   362	377	522	java/lang/OutOfMemoryError
    //   385	389	522	java/lang/OutOfMemoryError
    //   395	410	522	java/lang/OutOfMemoryError
    //   418	422	522	java/lang/OutOfMemoryError
    //   11	34	527	java/lang/Exception
    //   11	34	553	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.NewRegionalThumbDecoder
 * JD-Core Version:    0.7.0.1
 */