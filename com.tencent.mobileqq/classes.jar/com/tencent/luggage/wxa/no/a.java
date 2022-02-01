package com.tencent.luggage.wxa.no;

import androidx.annotation.NonNull;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.f;

public class a
  implements AppBrandSimpleImageLoader.f
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  /* Error */
  public android.graphics.Bitmap a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: aload_1
    //   3: astore 4
    //   5: aload_1
    //   6: astore 5
    //   8: aload_1
    //   9: astore 6
    //   11: aload_0
    //   12: getfield 22	com/tencent/luggage/wxa/no/a:c	I
    //   15: iflt +266 -> 281
    //   18: aload_1
    //   19: astore_3
    //   20: aload_1
    //   21: astore 4
    //   23: aload_1
    //   24: astore 5
    //   26: aload_1
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 24	com/tencent/luggage/wxa/no/a:d	I
    //   33: ifge +6 -> 39
    //   36: goto +245 -> 281
    //   39: aload_1
    //   40: astore_3
    //   41: aload_1
    //   42: astore 4
    //   44: aload_1
    //   45: astore 5
    //   47: aload_1
    //   48: astore 6
    //   50: aload_1
    //   51: invokevirtual 38	java/io/InputStream:markSupported	()Z
    //   54: ifeq +8 -> 62
    //   57: aload_1
    //   58: astore_2
    //   59: goto +90 -> 149
    //   62: aload_1
    //   63: astore_3
    //   64: aload_1
    //   65: astore 4
    //   67: aload_1
    //   68: astore 5
    //   70: aload_1
    //   71: astore 6
    //   73: aload_1
    //   74: instanceof 40
    //   77: ifeq +29 -> 106
    //   80: aload_1
    //   81: astore_3
    //   82: aload_1
    //   83: astore 4
    //   85: aload_1
    //   86: astore 5
    //   88: aload_1
    //   89: astore 6
    //   91: new 42	com/tencent/luggage/wxa/qz/g
    //   94: dup
    //   95: aload_1
    //   96: checkcast 40	java/io/FileInputStream
    //   99: invokespecial 45	com/tencent/luggage/wxa/qz/g:<init>	(Ljava/io/FileInputStream;)V
    //   102: astore_1
    //   103: goto +326 -> 429
    //   106: aload_1
    //   107: astore_2
    //   108: aload_1
    //   109: astore_3
    //   110: aload_1
    //   111: astore 4
    //   113: aload_1
    //   114: astore 5
    //   116: aload_1
    //   117: astore 6
    //   119: aload_1
    //   120: invokevirtual 38	java/io/InputStream:markSupported	()Z
    //   123: ifne +26 -> 149
    //   126: aload_1
    //   127: astore_3
    //   128: aload_1
    //   129: astore 4
    //   131: aload_1
    //   132: astore 5
    //   134: aload_1
    //   135: astore 6
    //   137: new 47	java/io/BufferedInputStream
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 50	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   145: astore_1
    //   146: goto +283 -> 429
    //   149: aload_2
    //   150: astore_3
    //   151: aload_2
    //   152: astore 4
    //   154: aload_2
    //   155: astore 5
    //   157: aload_2
    //   158: astore 6
    //   160: new 52	android/graphics/BitmapFactory$Options
    //   163: dup
    //   164: invokespecial 53	android/graphics/BitmapFactory$Options:<init>	()V
    //   167: astore 7
    //   169: aload_2
    //   170: astore_3
    //   171: aload_2
    //   172: astore 4
    //   174: aload_2
    //   175: astore 5
    //   177: aload_2
    //   178: astore 6
    //   180: aload 7
    //   182: iconst_1
    //   183: putfield 57	android/graphics/BitmapFactory$Options:inMutable	Z
    //   186: aload_2
    //   187: astore_3
    //   188: aload_2
    //   189: astore 4
    //   191: aload_2
    //   192: astore 5
    //   194: aload_2
    //   195: astore 6
    //   197: aload_2
    //   198: iconst_0
    //   199: invokestatic 63	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   202: astore_1
    //   203: aload_2
    //   204: astore_3
    //   205: aload_2
    //   206: astore 4
    //   208: aload_2
    //   209: astore 5
    //   211: aload_2
    //   212: astore 6
    //   214: aload_1
    //   215: new 65	android/graphics/Rect
    //   218: dup
    //   219: aload_0
    //   220: getfield 18	com/tencent/luggage/wxa/no/a:a	I
    //   223: aload_0
    //   224: getfield 20	com/tencent/luggage/wxa/no/a:b	I
    //   227: aload_0
    //   228: getfield 18	com/tencent/luggage/wxa/no/a:a	I
    //   231: aload_0
    //   232: getfield 22	com/tencent/luggage/wxa/no/a:c	I
    //   235: iadd
    //   236: aload_0
    //   237: getfield 20	com/tencent/luggage/wxa/no/a:b	I
    //   240: aload_0
    //   241: getfield 24	com/tencent/luggage/wxa/no/a:d	I
    //   244: iadd
    //   245: invokespecial 67	android/graphics/Rect:<init>	(IIII)V
    //   248: aload 7
    //   250: invokevirtual 71	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   253: astore 7
    //   255: aload_2
    //   256: astore_3
    //   257: aload_2
    //   258: astore 4
    //   260: aload_2
    //   261: astore 5
    //   263: aload_2
    //   264: astore 6
    //   266: aload_1
    //   267: invokevirtual 74	android/graphics/BitmapRegionDecoder:recycle	()V
    //   270: aload_2
    //   271: ifnull +7 -> 278
    //   274: aload_2
    //   275: invokevirtual 77	java/io/InputStream:close	()V
    //   278: aload 7
    //   280: areturn
    //   281: aload_1
    //   282: ifnull +7 -> 289
    //   285: aload_1
    //   286: invokevirtual 77	java/io/InputStream:close	()V
    //   289: aconst_null
    //   290: areturn
    //   291: astore_1
    //   292: goto +107 -> 399
    //   295: astore_1
    //   296: aload 4
    //   298: astore_3
    //   299: ldc 79
    //   301: ldc 81
    //   303: iconst_1
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: aload_1
    //   310: invokestatic 87	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   313: aastore
    //   314: invokestatic 92	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload 4
    //   319: ifnull +78 -> 397
    //   322: aload 4
    //   324: invokevirtual 77	java/io/InputStream:close	()V
    //   327: aconst_null
    //   328: areturn
    //   329: astore_1
    //   330: aload 5
    //   332: astore_3
    //   333: ldc 79
    //   335: ldc 81
    //   337: iconst_1
    //   338: anewarray 4	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: aload_1
    //   344: invokestatic 87	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   347: aastore
    //   348: invokestatic 92	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: aload 5
    //   353: ifnull +44 -> 397
    //   356: aload 5
    //   358: astore 4
    //   360: goto -38 -> 322
    //   363: astore_1
    //   364: aload 6
    //   366: astore_3
    //   367: ldc 79
    //   369: ldc 81
    //   371: iconst_1
    //   372: anewarray 4	java/lang/Object
    //   375: dup
    //   376: iconst_0
    //   377: aload_1
    //   378: invokestatic 87	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   381: aastore
    //   382: invokestatic 92	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: aload 6
    //   387: ifnull +10 -> 397
    //   390: aload 6
    //   392: astore 4
    //   394: goto -72 -> 322
    //   397: aconst_null
    //   398: areturn
    //   399: aload_3
    //   400: ifnull +7 -> 407
    //   403: aload_3
    //   404: invokevirtual 77	java/io/InputStream:close	()V
    //   407: goto +5 -> 412
    //   410: aload_1
    //   411: athrow
    //   412: goto -2 -> 410
    //   415: astore_1
    //   416: aload 7
    //   418: areturn
    //   419: astore_1
    //   420: aconst_null
    //   421: areturn
    //   422: astore_1
    //   423: aconst_null
    //   424: areturn
    //   425: astore_2
    //   426: goto -19 -> 407
    //   429: aload_1
    //   430: astore_2
    //   431: goto -282 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	a
    //   0	434	1	paramInputStream	java.io.InputStream
    //   58	217	2	localInputStream1	java.io.InputStream
    //   425	1	2	localIOException	java.io.IOException
    //   430	1	2	localInputStream2	java.io.InputStream
    //   1	403	3	localObject1	Object
    //   3	390	4	localObject2	Object
    //   6	351	5	localObject3	Object
    //   9	382	6	localObject4	Object
    //   167	250	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	18	291	finally
    //   29	36	291	finally
    //   50	57	291	finally
    //   73	80	291	finally
    //   91	103	291	finally
    //   119	126	291	finally
    //   137	146	291	finally
    //   160	169	291	finally
    //   180	186	291	finally
    //   197	203	291	finally
    //   214	255	291	finally
    //   266	270	291	finally
    //   299	317	291	finally
    //   333	351	291	finally
    //   367	385	291	finally
    //   11	18	295	java/lang/OutOfMemoryError
    //   29	36	295	java/lang/OutOfMemoryError
    //   50	57	295	java/lang/OutOfMemoryError
    //   73	80	295	java/lang/OutOfMemoryError
    //   91	103	295	java/lang/OutOfMemoryError
    //   119	126	295	java/lang/OutOfMemoryError
    //   137	146	295	java/lang/OutOfMemoryError
    //   160	169	295	java/lang/OutOfMemoryError
    //   180	186	295	java/lang/OutOfMemoryError
    //   197	203	295	java/lang/OutOfMemoryError
    //   214	255	295	java/lang/OutOfMemoryError
    //   266	270	295	java/lang/OutOfMemoryError
    //   11	18	329	java/lang/IllegalArgumentException
    //   29	36	329	java/lang/IllegalArgumentException
    //   50	57	329	java/lang/IllegalArgumentException
    //   73	80	329	java/lang/IllegalArgumentException
    //   91	103	329	java/lang/IllegalArgumentException
    //   119	126	329	java/lang/IllegalArgumentException
    //   137	146	329	java/lang/IllegalArgumentException
    //   160	169	329	java/lang/IllegalArgumentException
    //   180	186	329	java/lang/IllegalArgumentException
    //   197	203	329	java/lang/IllegalArgumentException
    //   214	255	329	java/lang/IllegalArgumentException
    //   266	270	329	java/lang/IllegalArgumentException
    //   11	18	363	java/io/IOException
    //   29	36	363	java/io/IOException
    //   50	57	363	java/io/IOException
    //   73	80	363	java/io/IOException
    //   91	103	363	java/io/IOException
    //   119	126	363	java/io/IOException
    //   137	146	363	java/io/IOException
    //   160	169	363	java/io/IOException
    //   180	186	363	java/io/IOException
    //   197	203	363	java/io/IOException
    //   214	255	363	java/io/IOException
    //   266	270	363	java/io/IOException
    //   274	278	415	java/io/IOException
    //   285	289	419	java/io/IOException
    //   322	327	422	java/io/IOException
    //   403	407	425	java/io/IOException
  }
  
  @NonNull
  public String a()
  {
    return String.format("Decoder_x%s_y%s_w%s_h%s", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.no.a
 * JD-Core Version:    0.7.0.1
 */