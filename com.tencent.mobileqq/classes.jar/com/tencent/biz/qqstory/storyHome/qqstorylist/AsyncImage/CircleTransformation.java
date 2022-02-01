package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import java.util.Map;

public class CircleTransformation
  implements Transformation
{
  public Map<String, Bitmap> a;
  public Bitmap b = null;
  
  public CircleTransformation(Map<String, Bitmap> paramMap, Bitmap paramBitmap)
  {
    this.a = paramMap;
  }
  
  /* Error */
  public Bitmap a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 34	android/graphics/Bitmap:getWidth	()I
    //   4: aload_1
    //   5: invokevirtual 37	android/graphics/Bitmap:getHeight	()I
    //   8: invokestatic 43	java/lang/Math:min	(II)I
    //   11: istore_3
    //   12: aload_1
    //   13: invokevirtual 34	android/graphics/Bitmap:getWidth	()I
    //   16: iload_3
    //   17: isub
    //   18: iconst_2
    //   19: idiv
    //   20: istore 4
    //   22: aload_1
    //   23: invokevirtual 37	android/graphics/Bitmap:getHeight	()I
    //   26: iload_3
    //   27: isub
    //   28: iconst_2
    //   29: idiv
    //   30: istore 5
    //   32: aload_0
    //   33: getfield 20	com/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/CircleTransformation:a	Ljava/util/Map;
    //   36: astore 6
    //   38: aload 6
    //   40: ifnull +62 -> 102
    //   43: new 45	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   50: astore 7
    //   52: aload 7
    //   54: ldc 48
    //   56: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 7
    //   62: iload_3
    //   63: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 7
    //   69: ldc 57
    //   71: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 7
    //   77: iload_3
    //   78: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: aload 7
    //   86: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokeinterface 67 2 0
    //   94: checkcast 30	android/graphics/Bitmap
    //   97: astore 6
    //   99: goto +6 -> 105
    //   102: aconst_null
    //   103: astore 6
    //   105: aload 6
    //   107: ifnull +172 -> 279
    //   110: aload 6
    //   112: invokevirtual 71	android/graphics/Bitmap:isRecycled	()Z
    //   115: ifeq +6 -> 121
    //   118: goto +161 -> 279
    //   121: aload 6
    //   123: iconst_0
    //   124: invokevirtual 75	android/graphics/Bitmap:eraseColor	(I)V
    //   127: aload_1
    //   128: aload 6
    //   130: iload 4
    //   132: iload 5
    //   134: iload_3
    //   135: iload_3
    //   136: aconst_null
    //   137: iconst_0
    //   138: invokestatic 80	com/tencent/biz/qqstory/storyHome/qqstorylist/common/StoryListUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)V
    //   141: goto +127 -> 268
    //   144: aload_1
    //   145: iload 4
    //   147: iload 5
    //   149: iload_3
    //   150: iload_3
    //   151: invokestatic 84	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   154: astore 7
    //   156: aload 7
    //   158: astore 6
    //   160: aload_0
    //   161: getfield 20	com/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/CircleTransformation:a	Ljava/util/Map;
    //   164: ifnull -23 -> 141
    //   167: aload_0
    //   168: getfield 20	com/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/CircleTransformation:a	Ljava/util/Map;
    //   171: astore 6
    //   173: new 45	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   180: astore 8
    //   182: aload 8
    //   184: ldc 48
    //   186: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 8
    //   192: iload_3
    //   193: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 8
    //   199: ldc 57
    //   201: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 8
    //   207: iload_3
    //   208: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 6
    //   214: aload 8
    //   216: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: aload 7
    //   221: invokeinterface 88 3 0
    //   226: pop
    //   227: aload 7
    //   229: astore 6
    //   231: goto -90 -> 141
    //   234: astore 8
    //   236: aload 7
    //   238: astore 6
    //   240: goto +5 -> 245
    //   243: astore 8
    //   245: ldc 90
    //   247: ldc 92
    //   249: iconst_2
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: iload_3
    //   256: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: aload 8
    //   264: aastore
    //   265: invokestatic 104	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload 6
    //   270: astore 7
    //   272: aload 6
    //   274: ifnonnull +143 -> 417
    //   277: aconst_null
    //   278: areturn
    //   279: aload_1
    //   280: iload 4
    //   282: iload 5
    //   284: iload_3
    //   285: iload_3
    //   286: invokestatic 84	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   289: astore 7
    //   291: aload 7
    //   293: astore 6
    //   295: aload_0
    //   296: getfield 20	com/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/CircleTransformation:a	Ljava/util/Map;
    //   299: ifnull +107 -> 406
    //   302: aload_0
    //   303: getfield 20	com/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/CircleTransformation:a	Ljava/util/Map;
    //   306: astore 6
    //   308: new 45	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   315: astore 8
    //   317: aload 8
    //   319: ldc 48
    //   321: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 8
    //   327: iload_3
    //   328: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 8
    //   334: ldc 57
    //   336: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 8
    //   342: iload_3
    //   343: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 6
    //   349: aload 8
    //   351: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: aload 7
    //   356: invokeinterface 88 3 0
    //   361: pop
    //   362: aload 7
    //   364: astore 6
    //   366: goto +40 -> 406
    //   369: astore 8
    //   371: aload 7
    //   373: astore 6
    //   375: goto +8 -> 383
    //   378: astore 8
    //   380: aconst_null
    //   381: astore 6
    //   383: ldc 90
    //   385: ldc 92
    //   387: iconst_2
    //   388: anewarray 4	java/lang/Object
    //   391: dup
    //   392: iconst_0
    //   393: iload_3
    //   394: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: aastore
    //   398: dup
    //   399: iconst_1
    //   400: aload 8
    //   402: aastore
    //   403: invokestatic 104	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   406: aload 6
    //   408: astore 7
    //   410: aload 6
    //   412: ifnonnull +5 -> 417
    //   415: aconst_null
    //   416: areturn
    //   417: aload_0
    //   418: getfield 18	com/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/CircleTransformation:b	Landroid/graphics/Bitmap;
    //   421: astore 6
    //   423: aload 6
    //   425: ifnull +27 -> 452
    //   428: aload 6
    //   430: invokevirtual 71	android/graphics/Bitmap:isRecycled	()Z
    //   433: ifeq +6 -> 439
    //   436: goto +16 -> 452
    //   439: aload_0
    //   440: getfield 18	com/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/CircleTransformation:b	Landroid/graphics/Bitmap;
    //   443: astore_1
    //   444: aload_1
    //   445: iconst_0
    //   446: invokevirtual 75	android/graphics/Bitmap:eraseColor	(I)V
    //   449: goto +44 -> 493
    //   452: iload_3
    //   453: iload_3
    //   454: getstatic 110	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   457: invokestatic 113	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   460: astore 6
    //   462: aload 6
    //   464: astore_1
    //   465: goto +28 -> 493
    //   468: astore 6
    //   470: ldc 90
    //   472: ldc 115
    //   474: aload 6
    //   476: invokestatic 119	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   479: iload_3
    //   480: iconst_2
    //   481: idiv
    //   482: istore_3
    //   483: iload_3
    //   484: iload_3
    //   485: aload_1
    //   486: invokevirtual 123	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   489: invokestatic 113	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   492: astore_1
    //   493: iload_3
    //   494: i2f
    //   495: fconst_2
    //   496: fdiv
    //   497: fstore_2
    //   498: new 125	android/graphics/Canvas
    //   501: dup
    //   502: aload_1
    //   503: invokespecial 128	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   506: astore 6
    //   508: new 130	android/graphics/Paint
    //   511: dup
    //   512: invokespecial 131	android/graphics/Paint:<init>	()V
    //   515: astore 8
    //   517: aload 8
    //   519: new 133	android/graphics/BitmapShader
    //   522: dup
    //   523: aload 7
    //   525: getstatic 139	android/graphics/Shader$TileMode:CLAMP	Landroid/graphics/Shader$TileMode;
    //   528: getstatic 139	android/graphics/Shader$TileMode:CLAMP	Landroid/graphics/Shader$TileMode;
    //   531: invokespecial 142	android/graphics/BitmapShader:<init>	(Landroid/graphics/Bitmap;Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V
    //   534: invokevirtual 146	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   537: pop
    //   538: aload 8
    //   540: iconst_1
    //   541: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   544: aload 6
    //   546: fload_2
    //   547: fload_2
    //   548: fload_2
    //   549: aload 8
    //   551: invokevirtual 154	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   554: aload_1
    //   555: areturn
    //   556: ldc 90
    //   558: ldc 156
    //   560: aload 6
    //   562: invokestatic 119	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   565: aconst_null
    //   566: areturn
    //   567: astore 7
    //   569: goto -425 -> 144
    //   572: astore_1
    //   573: goto -17 -> 556
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	this	CircleTransformation
    //   0	576	1	paramBitmap	Bitmap
    //   497	52	2	f	float
    //   11	483	3	i	int
    //   20	261	4	j	int
    //   30	253	5	k	int
    //   36	427	6	localObject1	Object
    //   468	7	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   506	55	6	localCanvas	android.graphics.Canvas
    //   50	474	7	localObject2	Object
    //   567	1	7	localException	java.lang.Exception
    //   180	35	8	localStringBuilder1	java.lang.StringBuilder
    //   234	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   243	20	8	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   315	35	8	localStringBuilder2	java.lang.StringBuilder
    //   369	1	8	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   378	23	8	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   515	35	8	localPaint	android.graphics.Paint
    // Exception table:
    //   from	to	target	type
    //   160	227	234	java/lang/OutOfMemoryError
    //   144	156	243	java/lang/OutOfMemoryError
    //   295	362	369	java/lang/OutOfMemoryError
    //   279	291	378	java/lang/OutOfMemoryError
    //   452	462	468	java/lang/OutOfMemoryError
    //   127	141	567	java/lang/Exception
    //   483	493	572	java/lang/OutOfMemoryError
  }
  
  public String a()
  {
    return "circle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation
 * JD-Core Version:    0.7.0.1
 */