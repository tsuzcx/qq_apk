package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.File;

public class DefaultDecoder
  implements IDecoder
{
  private static final String TAG = "DefaultDecoder";
  
  /* Error */
  private Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc 10
    //   2: new 23	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   9: ldc 26
    //   11: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: iload 5
    //   16: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc 35
    //   21: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload 6
    //   26: invokevirtual 33	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 45	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: aload 4
    //   38: iconst_1
    //   39: putfield 51	android/graphics/BitmapFactory$Options:inDither	Z
    //   42: aload 4
    //   44: iconst_1
    //   45: putfield 54	android/graphics/BitmapFactory$Options:inMutable	Z
    //   48: aload 4
    //   50: getstatic 60	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   53: putfield 63	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   56: aload_1
    //   57: iload_2
    //   58: iload_3
    //   59: aload 4
    //   61: invokestatic 68	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: ldc 10
    //   70: aload_1
    //   71: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   74: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_1
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: ldc 10
    //   85: aload_1
    //   86: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   89: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aconst_null
    //   93: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	DefaultDecoder
    //   0	94	1	paramArrayOfByte	byte[]
    //   0	94	2	paramInt1	int
    //   0	94	3	paramInt2	int
    //   0	94	4	paramOptions	BitmapFactory.Options
    //   0	94	5	paramInt3	int
    //   0	94	6	paramInt4	int
    // Exception table:
    //   from	to	target	type
    //   56	65	67	java/lang/RuntimeException
    //   56	65	79	finally
    //   68	77	79	finally
    //   83	92	79	finally
    //   56	65	82	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public Bitmap decodeBitmap(File paramFile, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +24 -> 25
    //   4: aload_1
    //   5: invokevirtual 91	java/io/File:exists	()Z
    //   8: ifeq +17 -> 25
    //   11: aload_1
    //   12: invokevirtual 94	java/io/File:isFile	()Z
    //   15: ifeq +10 -> 25
    //   18: aload_1
    //   19: invokevirtual 97	java/io/File:canRead	()Z
    //   22: ifne +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new 47	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 98	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 8
    //   36: aload 8
    //   38: iconst_1
    //   39: putfield 101	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: new 103	java/io/BufferedInputStream
    //   45: dup
    //   46: new 105	java/io/FileInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: sipush 8192
    //   57: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   60: astore 6
    //   62: aload 6
    //   64: astore 5
    //   66: aload 6
    //   68: aconst_null
    //   69: aload 8
    //   71: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   74: pop
    //   75: aload 6
    //   77: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   80: aload 8
    //   82: iconst_0
    //   83: putfield 101	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   86: new 120	com/tencent/component/media/image/ImageLoader$Options
    //   89: dup
    //   90: invokespecial 121	com/tencent/component/media/image/ImageLoader$Options:<init>	()V
    //   93: astore 5
    //   95: aload 5
    //   97: iload_3
    //   98: putfield 125	com/tencent/component/media/image/ImageLoader$Options:clipHeight	I
    //   101: aload 5
    //   103: iload_2
    //   104: putfield 128	com/tencent/component/media/image/ImageLoader$Options:clipWidth	I
    //   107: iload_3
    //   108: ifle +27 -> 135
    //   111: iload_2
    //   112: ifle +23 -> 135
    //   115: aload 8
    //   117: aload 5
    //   119: aload 8
    //   121: getfield 131	android/graphics/BitmapFactory$Options:outWidth	I
    //   124: aload 8
    //   126: getfield 134	android/graphics/BitmapFactory$Options:outHeight	I
    //   129: invokestatic 140	com/tencent/component/media/image/ImageOptionSampleSize:computeSampleSize	(Lcom/tencent/component/media/image/ImageLoader$Options;II)I
    //   132: putfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   135: aload 8
    //   137: getfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   140: iconst_1
    //   141: if_icmpge +9 -> 150
    //   144: aload 8
    //   146: iconst_1
    //   147: putfield 143	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   150: new 103	java/io/BufferedInputStream
    //   153: dup
    //   154: new 105	java/io/FileInputStream
    //   157: dup
    //   158: aload_1
    //   159: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   162: sipush 8192
    //   165: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   168: astore 5
    //   170: aload 5
    //   172: astore_1
    //   173: aload 8
    //   175: aload 4
    //   177: invokestatic 149	com/tencent/component/media/utils/BitmapUtils:addInBitmapOptions	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;)V
    //   180: aload 5
    //   182: astore_1
    //   183: aload 5
    //   185: aconst_null
    //   186: aload 8
    //   188: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   191: astore 4
    //   193: aload 5
    //   195: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   198: aload 4
    //   200: areturn
    //   201: astore_1
    //   202: ldc 10
    //   204: aload_1
    //   205: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   208: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 4
    //   213: areturn
    //   214: astore 5
    //   216: ldc 10
    //   218: aload 5
    //   220: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   223: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: goto -146 -> 80
    //   229: astore 7
    //   231: aconst_null
    //   232: astore 6
    //   234: aload 6
    //   236: astore 5
    //   238: ldc 10
    //   240: aload 7
    //   242: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   245: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload 6
    //   250: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   253: goto -173 -> 80
    //   256: astore 5
    //   258: ldc 10
    //   260: aload 5
    //   262: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   265: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: goto -188 -> 80
    //   271: astore 7
    //   273: aconst_null
    //   274: astore 6
    //   276: aload 6
    //   278: astore 5
    //   280: ldc 10
    //   282: aload 7
    //   284: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   287: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload 6
    //   292: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   295: goto -215 -> 80
    //   298: astore 5
    //   300: ldc 10
    //   302: aload 5
    //   304: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   307: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: goto -230 -> 80
    //   313: astore_1
    //   314: aconst_null
    //   315: astore 5
    //   317: aload 5
    //   319: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   322: aload_1
    //   323: athrow
    //   324: astore 4
    //   326: ldc 10
    //   328: aload 4
    //   330: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   333: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: goto -14 -> 322
    //   339: astore 4
    //   341: aconst_null
    //   342: astore 5
    //   344: aload 5
    //   346: astore_1
    //   347: ldc 10
    //   349: aload 4
    //   351: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   354: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 5
    //   359: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   362: aconst_null
    //   363: areturn
    //   364: astore_1
    //   365: ldc 10
    //   367: aload_1
    //   368: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   371: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aconst_null
    //   375: areturn
    //   376: astore 4
    //   378: aconst_null
    //   379: astore 5
    //   381: aload 5
    //   383: astore_1
    //   384: ldc 10
    //   386: aload 4
    //   388: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   391: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 5
    //   396: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   399: aconst_null
    //   400: areturn
    //   401: astore_1
    //   402: ldc 10
    //   404: aload_1
    //   405: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   408: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: aconst_null
    //   412: areturn
    //   413: astore 4
    //   415: aconst_null
    //   416: astore 5
    //   418: aload 5
    //   420: astore_1
    //   421: ldc 10
    //   423: aload 4
    //   425: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   428: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload 5
    //   433: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   436: aconst_null
    //   437: areturn
    //   438: astore_1
    //   439: ldc 10
    //   441: aload_1
    //   442: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   445: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: aconst_null
    //   449: areturn
    //   450: astore 4
    //   452: aconst_null
    //   453: astore_1
    //   454: aload_1
    //   455: invokevirtual 118	java/io/BufferedInputStream:close	()V
    //   458: aload 4
    //   460: athrow
    //   461: astore_1
    //   462: ldc 10
    //   464: aload_1
    //   465: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   468: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto -13 -> 458
    //   474: astore 4
    //   476: goto -22 -> 454
    //   479: astore 4
    //   481: goto -63 -> 418
    //   484: astore 4
    //   486: goto -105 -> 381
    //   489: astore 4
    //   491: goto -147 -> 344
    //   494: astore_1
    //   495: goto -178 -> 317
    //   498: astore 7
    //   500: goto -224 -> 276
    //   503: astore 7
    //   505: goto -271 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	this	DefaultDecoder
    //   0	508	1	paramFile	File
    //   0	508	2	paramInt1	int
    //   0	508	3	paramInt2	int
    //   0	508	4	paramBitmap	Bitmap
    //   64	130	5	localObject1	Object
    //   214	5	5	localIOException1	java.io.IOException
    //   236	1	5	localBufferedInputStream1	java.io.BufferedInputStream
    //   256	5	5	localIOException2	java.io.IOException
    //   278	1	5	localBufferedInputStream2	java.io.BufferedInputStream
    //   298	5	5	localIOException3	java.io.IOException
    //   315	117	5	localObject2	Object
    //   60	231	6	localBufferedInputStream3	java.io.BufferedInputStream
    //   229	12	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   271	12	7	localThrowable1	Throwable
    //   498	1	7	localThrowable2	Throwable
    //   503	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   34	153	8	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   193	198	201	java/io/IOException
    //   75	80	214	java/io/IOException
    //   42	62	229	java/io/FileNotFoundException
    //   248	253	256	java/io/IOException
    //   42	62	271	java/lang/Throwable
    //   290	295	298	java/io/IOException
    //   42	62	313	finally
    //   317	322	324	java/io/IOException
    //   150	170	339	java/io/FileNotFoundException
    //   357	362	364	java/io/IOException
    //   150	170	376	java/lang/OutOfMemoryError
    //   394	399	401	java/io/IOException
    //   150	170	413	java/lang/Throwable
    //   431	436	438	java/io/IOException
    //   150	170	450	finally
    //   454	458	461	java/io/IOException
    //   173	180	474	finally
    //   183	193	474	finally
    //   347	357	474	finally
    //   384	394	474	finally
    //   421	431	474	finally
    //   173	180	479	java/lang/Throwable
    //   183	193	479	java/lang/Throwable
    //   173	180	484	java/lang/OutOfMemoryError
    //   183	193	484	java/lang/OutOfMemoryError
    //   173	180	489	java/io/FileNotFoundException
    //   183	193	489	java/io/FileNotFoundException
    //   66	75	494	finally
    //   238	248	494	finally
    //   280	290	494	finally
    //   66	75	498	java/lang/Throwable
    //   66	75	503	java/io/FileNotFoundException
  }
  
  public Bitmap decodeFile(File paramFile, BitmapFactory.Options paramOptions)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramOptions);
      return paramFile;
    }
    catch (OutOfMemoryError paramFile)
    {
      ImageManagerLog.e("DefaultDecoder", Log.getStackTraceString(paramFile));
    }
    return null;
  }
  
  /* Error */
  public BitmapReference decodeImage(File paramFile, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 105	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_1
    //   14: aload_0
    //   15: aload_3
    //   16: aload_2
    //   17: invokevirtual 162	com/tencent/component/media/image/DefaultDecoder:decodeImage	(Ljava/io/FileInputStream;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/component/media/image/BitmapReference;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_3
    //   24: ifnull +9 -> 33
    //   27: aload_3
    //   28: invokevirtual 163	java/io/FileInputStream:close	()V
    //   31: aload_2
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_3
    //   38: aload_3
    //   39: astore_1
    //   40: ldc 10
    //   42: new 23	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   49: ldc 165
    //   51: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   58: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload 4
    //   69: astore_1
    //   70: aload_3
    //   71: ifnull -38 -> 33
    //   74: aload_3
    //   75: invokevirtual 163	java/io/FileInputStream:close	()V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: areturn
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_3
    //   86: aload_3
    //   87: astore_1
    //   88: ldc 10
    //   90: new 23	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   97: ldc 165
    //   99: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   106: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 4
    //   117: astore_1
    //   118: aload_3
    //   119: ifnull -86 -> 33
    //   122: aload_3
    //   123: invokevirtual 163	java/io/FileInputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: aconst_null
    //   133: astore_1
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 163	java/io/FileInputStream:close	()V
    //   142: aload_2
    //   143: athrow
    //   144: astore_1
    //   145: aload_2
    //   146: areturn
    //   147: astore_1
    //   148: goto -6 -> 142
    //   151: astore_2
    //   152: goto -18 -> 134
    //   155: astore_2
    //   156: goto -70 -> 86
    //   159: astore_2
    //   160: goto -122 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	DefaultDecoder
    //   0	163	1	paramFile	File
    //   0	163	2	paramOptions	BitmapFactory.Options
    //   11	112	3	localFileInputStream	java.io.FileInputStream
    //   1	115	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	35	java/io/FileNotFoundException
    //   74	78	80	java/io/IOException
    //   3	12	83	java/lang/Throwable
    //   122	126	128	java/io/IOException
    //   3	12	131	finally
    //   27	31	144	java/io/IOException
    //   138	142	147	java/io/IOException
    //   14	21	151	finally
    //   40	67	151	finally
    //   88	115	151	finally
    //   14	21	155	java/lang/Throwable
    //   14	21	159	java/io/FileNotFoundException
  }
  
  /* Error */
  public BitmapReference decodeImage(java.io.FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 103	java/io/BufferedInputStream
    //   12: dup
    //   13: aload_1
    //   14: sipush 8192
    //   17: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   20: astore 5
    //   22: iload 4
    //   24: istore_3
    //   25: getstatic 172	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 21
    //   30: if_icmplt +19 -> 49
    //   33: iload 4
    //   35: istore_3
    //   36: ldc 174
    //   38: getstatic 179	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   41: invokevirtual 185	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   44: ifeq +5 -> 49
    //   47: iconst_1
    //   48: istore_3
    //   49: iload_3
    //   50: ifeq +103 -> 153
    //   53: sipush 4096
    //   56: newarray byte
    //   58: astore 6
    //   60: new 187	java/io/ByteArrayOutputStream
    //   63: dup
    //   64: invokespecial 188	java/io/ByteArrayOutputStream:<init>	()V
    //   67: astore_1
    //   68: aload 5
    //   70: aload 6
    //   72: iconst_0
    //   73: aload 6
    //   75: arraylength
    //   76: invokevirtual 192	java/io/BufferedInputStream:read	([BII)I
    //   79: istore_3
    //   80: iload_3
    //   81: iconst_m1
    //   82: if_icmpeq +47 -> 129
    //   85: aload_1
    //   86: aload 6
    //   88: iconst_0
    //   89: iload_3
    //   90: invokevirtual 196	java/io/ByteArrayOutputStream:write	([BII)V
    //   93: goto -25 -> 68
    //   96: astore_1
    //   97: ldc 10
    //   99: new 23	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   106: ldc 165
    //   108: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   115: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_1
    //   127: aload_1
    //   128: athrow
    //   129: aload_1
    //   130: invokevirtual 200	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   133: astore 5
    //   135: aload_1
    //   136: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   139: aload 5
    //   141: iconst_0
    //   142: aload 5
    //   144: arraylength
    //   145: aload_2
    //   146: invokestatic 68	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   149: invokestatic 207	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   152: areturn
    //   153: aload 5
    //   155: aconst_null
    //   156: aload_2
    //   157: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: invokestatic 207	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   163: astore_1
    //   164: aload_1
    //   165: areturn
    //   166: astore_1
    //   167: ldc 10
    //   169: new 23	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   176: ldc 165
    //   178: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokestatic 72	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   185: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 77	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aconst_null
    //   195: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	DefaultDecoder
    //   0	196	1	paramFileInputStream	java.io.FileInputStream
    //   0	196	2	paramOptions	BitmapFactory.Options
    //   24	66	3	i	int
    //   1	33	4	j	int
    //   20	134	5	localObject	Object
    //   58	29	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	22	96	java/lang/Exception
    //   25	33	96	java/lang/Exception
    //   36	47	96	java/lang/Exception
    //   53	68	96	java/lang/Exception
    //   68	80	96	java/lang/Exception
    //   85	93	96	java/lang/Exception
    //   129	153	96	java/lang/Exception
    //   153	164	96	java/lang/Exception
    //   9	22	126	finally
    //   25	33	126	finally
    //   36	47	126	finally
    //   53	68	126	finally
    //   68	80	126	finally
    //   85	93	126	finally
    //   97	124	126	finally
    //   129	153	126	finally
    //   153	164	126	finally
    //   167	194	126	finally
    //   9	22	166	java/lang/OutOfMemoryError
    //   25	33	166	java/lang/OutOfMemoryError
    //   36	47	166	java/lang/OutOfMemoryError
    //   53	68	166	java/lang/OutOfMemoryError
    //   68	80	166	java/lang/OutOfMemoryError
    //   85	93	166	java/lang/OutOfMemoryError
    //   129	153	166	java/lang/OutOfMemoryError
    //   153	164	166	java/lang/OutOfMemoryError
  }
  
  public BitmapReference decodeImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramInt3, paramInt4);
      return BitmapReference.getBitmapReference(paramArrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        ImageManagerLog.e("DefaultDecoder", "decodeImage error " + Log.getStackTraceString(paramArrayOfByte));
        paramArrayOfByte = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.DefaultDecoder
 * JD-Core Version:    0.7.0.1
 */