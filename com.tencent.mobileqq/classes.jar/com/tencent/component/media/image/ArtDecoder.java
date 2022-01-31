package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;

@TargetApi(19)
public class ArtDecoder
  implements IDecoder
{
  public static final int DECODE_BUFFER_SIZE = 16384;
  private static final String TAG = "ArtDecoder";
  BitmapPool mBitmapPool;
  ByteArrayPool mByteArrayPool;
  
  public ArtDecoder(ByteArrayPool paramByteArrayPool, BitmapPool paramBitmapPool)
  {
    this.mByteArrayPool = paramByteArrayPool;
    this.mBitmapPool = paramBitmapPool;
  }
  
  private Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4)
  {
    if ((paramInt3 < 0) || (paramInt4 < 0))
    {
      Log.e("ArtDecoder", "decodeByteArray width " + paramInt3 + ", height " + paramInt4);
      paramOptions.inDither = true;
      paramOptions.inMutable = true;
      paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      try
      {
        paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
        return paramArrayOfByte;
      }
      catch (RuntimeException paramArrayOfByte)
      {
        paramArrayOfByte = paramArrayOfByte;
        throw paramArrayOfByte;
      }
      finally {}
    }
    Bitmap localBitmap = (Bitmap)this.mBitmapPool.get(paramInt3 * paramInt4 * BitmapUtils.getBytesPerPixel(paramOptions.inPreferredConfig));
    paramOptions.inBitmap = localBitmap;
    paramOptions.inDither = true;
    paramOptions.inMutable = true;
    if (isPng(paramOptions.outMimeType)) {
      paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }
    try
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
      if (localBitmap != paramArrayOfByte)
      {
        ImageManagerLog.w("ArtDecoder", "decodeByteArray reuse bitmap false reuse: " + localBitmap + ", decodeBitmap: " + paramArrayOfByte);
        this.mBitmapPool.release(localBitmap);
      }
      return paramArrayOfByte;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      ImageManagerLog.e("ArtDecoder", "decodeImage byte Array error " + paramInt3 + ", " + paramInt4);
      throw paramArrayOfByte;
    }
    finally {}
  }
  
  private Bitmap decodeImageFromStream(InputStream paramInputStream, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap = paramOptions.inBitmap;
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream);
    paramInputStream = (byte[])this.mByteArrayPool.get(16384);
    try
    {
      paramOptions.inTempStorage = paramInputStream;
      paramOptions = BitmapFactory.decodeStream(localBufferedInputStream, null, paramOptions);
      this.mByteArrayPool.release(paramInputStream);
      if ((localBitmap == paramOptions) || (localBitmap == null)) {
        return paramOptions;
      }
      ImageManagerLog.w("ArtDecoder", "decodeImageStream reuse bitmap false reuse: " + localBitmap + ", decodeBitmap: " + paramOptions);
      this.mBitmapPool.release(localBitmap);
      return paramOptions;
    }
    catch (RuntimeException paramOptions)
    {
      ImageManagerLog.e("ArtDecoder", "decodeImageFromStream error ! " + Log.getStackTraceString(paramOptions));
      return null;
    }
    catch (OutOfMemoryError paramOptions)
    {
      ImageManagerLog.e("ArtDecoder", "decodeImageFromStream error ! " + Log.getStackTraceString(paramOptions));
      return null;
    }
    catch (Throwable paramOptions)
    {
      ImageManagerLog.e("ArtDecoder", "decodeImageFromStream error ! " + Log.getStackTraceString(paramOptions));
      return null;
    }
    finally
    {
      this.mByteArrayPool.release(paramInputStream);
      if ((localBitmap != null) && (localBitmap != null))
      {
        ImageManagerLog.w("ArtDecoder", "decodeImageStream reuse bitmap false reuse: " + localBitmap + ", decodeBitmap: " + null);
        this.mBitmapPool.release(localBitmap);
      }
    }
    return null;
    return paramOptions;
  }
  
  private BitmapFactory.Options getDecodeOptions(BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    localOptions.inMutable = true;
    if (!paramBoolean)
    {
      localOptions.inBitmap = null;
      return localOptions;
    }
    if ((localOptions.outHeight <= 0) || (localOptions.outWidth <= 0) || (localOptions.inSampleSize < 1)) {
      throw new IllegalArgumentException("options 参数错误");
    }
    int j = localOptions.inSampleSize;
    int i = (localOptions.outWidth + j - 1) / j;
    j = (localOptions.outHeight + j - 1) / j;
    if (isPng(localOptions.outMimeType)) {
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }
    Bitmap localBitmap = (Bitmap)this.mBitmapPool.get(j * i * BitmapUtils.getBytesPerPixel(localOptions.inPreferredConfig));
    if (localBitmap == null)
    {
      Log.e("ArtDecoder", "decodeImage Stream error no bitmap");
      paramOptions = localBitmap;
    }
    for (;;)
    {
      localOptions.inBitmap = paramOptions;
      return localOptions;
      paramOptions = localBitmap;
      if (!localBitmap.isMutable())
      {
        Log.e("ArtDecoder", "decodeImage Stream error bitmap not mutable !");
        paramOptions = null;
      }
    }
  }
  
  private static boolean isPng(String paramString)
  {
    return "image/png".equalsIgnoreCase(paramString);
  }
  
  private void reset(FileInputStream paramFileInputStream)
  {
    paramFileInputStream.getChannel().position(0L);
  }
  
  /* Error */
  public Bitmap decodeBitmap(java.io.File paramFile, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +24 -> 25
    //   4: aload_1
    //   5: invokevirtual 222	java/io/File:exists	()Z
    //   8: ifeq +17 -> 25
    //   11: aload_1
    //   12: invokevirtual 225	java/io/File:isFile	()Z
    //   15: ifeq +10 -> 25
    //   18: aload_1
    //   19: invokevirtual 228	java/io/File:canRead	()Z
    //   22: ifne +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new 60	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 166	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 8
    //   36: aload 8
    //   38: iconst_1
    //   39: putfield 231	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload 8
    //   44: aload_0
    //   45: getfield 27	com/tencent/component/media/image/ArtDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   48: sipush 16384
    //   51: invokevirtual 143	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   54: checkcast 145	[B
    //   57: putfield 148	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   60: new 137	java/io/BufferedInputStream
    //   63: dup
    //   64: new 201	java/io/FileInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: sipush 8192
    //   75: invokespecial 237	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   78: astore 6
    //   80: aload 6
    //   82: astore 5
    //   84: aload 6
    //   86: aconst_null
    //   87: aload 8
    //   89: invokestatic 152	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   92: pop
    //   93: aload 6
    //   95: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   98: aload 8
    //   100: iconst_0
    //   101: putfield 231	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   104: new 242	com/tencent/component/media/image/ImageLoader$Options
    //   107: dup
    //   108: invokespecial 243	com/tencent/component/media/image/ImageLoader$Options:<init>	()V
    //   111: astore 5
    //   113: aload 5
    //   115: iload_3
    //   116: putfield 246	com/tencent/component/media/image/ImageLoader$Options:clipHeight	I
    //   119: aload 5
    //   121: iload_2
    //   122: putfield 249	com/tencent/component/media/image/ImageLoader$Options:clipWidth	I
    //   125: iload_3
    //   126: ifle +27 -> 153
    //   129: iload_2
    //   130: ifle +23 -> 153
    //   133: aload 8
    //   135: aload 5
    //   137: aload 8
    //   139: getfield 172	android/graphics/BitmapFactory$Options:outWidth	I
    //   142: aload 8
    //   144: getfield 169	android/graphics/BitmapFactory$Options:outHeight	I
    //   147: invokestatic 255	com/tencent/component/media/image/ImageOptionSampleSize:computeSampleSize	(Lcom/tencent/component/media/image/ImageLoader$Options;II)I
    //   150: putfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   153: aload 8
    //   155: getfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   158: iconst_1
    //   159: if_icmpge +9 -> 168
    //   162: aload 8
    //   164: iconst_1
    //   165: putfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   168: aload 8
    //   170: aload 4
    //   172: invokestatic 259	com/tencent/component/media/utils/BitmapUtils:addInBitmapOptions	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;)V
    //   175: new 137	java/io/BufferedInputStream
    //   178: dup
    //   179: new 201	java/io/FileInputStream
    //   182: dup
    //   183: aload_1
    //   184: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   187: sipush 8192
    //   190: invokespecial 237	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   193: astore 4
    //   195: aload 4
    //   197: astore_1
    //   198: aload 4
    //   200: aconst_null
    //   201: aload 8
    //   203: invokestatic 152	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   206: astore 5
    //   208: aload 4
    //   210: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   213: aload 5
    //   215: areturn
    //   216: astore_1
    //   217: ldc 16
    //   219: aload_1
    //   220: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   223: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 5
    //   228: areturn
    //   229: astore 5
    //   231: ldc 16
    //   233: aload 5
    //   235: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   238: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: goto -143 -> 98
    //   244: astore 7
    //   246: aconst_null
    //   247: astore 6
    //   249: aload 6
    //   251: astore 5
    //   253: ldc 16
    //   255: aload 7
    //   257: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   260: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 6
    //   265: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   268: goto -170 -> 98
    //   271: astore 5
    //   273: ldc 16
    //   275: aload 5
    //   277: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   280: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: goto -185 -> 98
    //   286: astore 7
    //   288: aconst_null
    //   289: astore 6
    //   291: aload 6
    //   293: astore 5
    //   295: ldc 16
    //   297: aload 7
    //   299: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   302: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload 6
    //   307: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   310: goto -212 -> 98
    //   313: astore 5
    //   315: ldc 16
    //   317: aload 5
    //   319: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   322: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -227 -> 98
    //   328: astore_1
    //   329: aconst_null
    //   330: astore 5
    //   332: aload 5
    //   334: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   337: aload_1
    //   338: athrow
    //   339: astore 4
    //   341: ldc 16
    //   343: aload 4
    //   345: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   348: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto -14 -> 337
    //   354: astore 5
    //   356: aconst_null
    //   357: astore 4
    //   359: aload 4
    //   361: astore_1
    //   362: ldc 16
    //   364: aload 5
    //   366: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   369: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload 4
    //   374: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   377: aconst_null
    //   378: areturn
    //   379: astore_1
    //   380: ldc 16
    //   382: aload_1
    //   383: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   386: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aconst_null
    //   390: areturn
    //   391: astore 5
    //   393: aconst_null
    //   394: astore 4
    //   396: aload 4
    //   398: astore_1
    //   399: ldc 16
    //   401: aload 5
    //   403: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   406: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload 4
    //   411: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   414: aconst_null
    //   415: areturn
    //   416: astore_1
    //   417: ldc 16
    //   419: aload_1
    //   420: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   423: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: aconst_null
    //   427: areturn
    //   428: astore 5
    //   430: aconst_null
    //   431: astore 4
    //   433: aload 4
    //   435: astore_1
    //   436: ldc 16
    //   438: aload 5
    //   440: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   443: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload 4
    //   448: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   451: aconst_null
    //   452: areturn
    //   453: astore_1
    //   454: ldc 16
    //   456: aload_1
    //   457: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   460: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: aconst_null
    //   464: areturn
    //   465: astore 4
    //   467: aconst_null
    //   468: astore_1
    //   469: aload_1
    //   470: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   473: aload 4
    //   475: athrow
    //   476: astore_1
    //   477: ldc 16
    //   479: aload_1
    //   480: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   483: invokestatic 129	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: goto -13 -> 473
    //   489: astore 4
    //   491: goto -22 -> 469
    //   494: astore 5
    //   496: goto -63 -> 433
    //   499: astore 5
    //   501: goto -105 -> 396
    //   504: astore 5
    //   506: goto -147 -> 359
    //   509: astore_1
    //   510: goto -178 -> 332
    //   513: astore 7
    //   515: goto -224 -> 291
    //   518: astore 7
    //   520: goto -271 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	ArtDecoder
    //   0	523	1	paramFile	java.io.File
    //   0	523	2	paramInt1	int
    //   0	523	3	paramInt2	int
    //   0	523	4	paramBitmap	Bitmap
    //   82	145	5	localObject1	Object
    //   229	5	5	localIOException1	java.io.IOException
    //   251	1	5	localBufferedInputStream1	BufferedInputStream
    //   271	5	5	localIOException2	java.io.IOException
    //   293	1	5	localBufferedInputStream2	BufferedInputStream
    //   313	5	5	localIOException3	java.io.IOException
    //   330	3	5	localObject2	Object
    //   354	11	5	localOutOfMemoryError1	OutOfMemoryError
    //   391	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   428	11	5	localThrowable1	Throwable
    //   494	1	5	localThrowable2	Throwable
    //   499	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   504	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   78	228	6	localBufferedInputStream3	BufferedInputStream
    //   244	12	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   286	12	7	localThrowable3	Throwable
    //   513	1	7	localThrowable4	Throwable
    //   518	1	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   34	168	8	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   208	213	216	java/io/IOException
    //   93	98	229	java/io/IOException
    //   60	80	244	java/io/FileNotFoundException
    //   263	268	271	java/io/IOException
    //   60	80	286	java/lang/Throwable
    //   305	310	313	java/io/IOException
    //   60	80	328	finally
    //   332	337	339	java/io/IOException
    //   175	195	354	java/lang/OutOfMemoryError
    //   372	377	379	java/io/IOException
    //   175	195	391	java/io/FileNotFoundException
    //   409	414	416	java/io/IOException
    //   175	195	428	java/lang/Throwable
    //   446	451	453	java/io/IOException
    //   175	195	465	finally
    //   469	473	476	java/io/IOException
    //   198	208	489	finally
    //   362	372	489	finally
    //   399	409	489	finally
    //   436	446	489	finally
    //   198	208	494	java/lang/Throwable
    //   198	208	499	java/io/FileNotFoundException
    //   198	208	504	java/lang/OutOfMemoryError
    //   84	93	509	finally
    //   253	263	509	finally
    //   295	305	509	finally
    //   84	93	513	java/lang/Throwable
    //   84	93	518	java/io/FileNotFoundException
  }
  
  /* Error */
  public Bitmap decodeFile(java.io.File paramFile, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: iconst_1
    //   13: istore_3
    //   14: new 201	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_1
    //   23: aload_2
    //   24: ifnull +328 -> 352
    //   27: aload_2
    //   28: getfield 169	android/graphics/BitmapFactory$Options:outHeight	I
    //   31: ifle +321 -> 352
    //   34: aload_2
    //   35: getfield 172	android/graphics/BitmapFactory$Options:outWidth	I
    //   38: ifle +314 -> 352
    //   41: aload_2
    //   42: getfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   45: iconst_1
    //   46: if_icmpge +6 -> 52
    //   49: goto +303 -> 352
    //   52: aload_0
    //   53: aload_2
    //   54: iload_3
    //   55: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   58: astore 4
    //   60: aload_0
    //   61: aload_1
    //   62: aload 4
    //   64: invokespecial 265	com/tencent/component/media/image/ArtDecoder:decodeImageFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   67: astore_2
    //   68: iload_3
    //   69: ifeq +277 -> 346
    //   72: aload_2
    //   73: ifnonnull +273 -> 346
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 267	com/tencent/component/media/image/ArtDecoder:reset	(Ljava/io/FileInputStream;)V
    //   81: aload_0
    //   82: aload_1
    //   83: aload_0
    //   84: aload 4
    //   86: iconst_0
    //   87: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   90: invokespecial 265	com/tencent/component/media/image/ArtDecoder:decodeImageFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   93: astore 4
    //   95: aload 4
    //   97: astore_2
    //   98: aload_1
    //   99: ifnull +10 -> 109
    //   102: aload_1
    //   103: invokevirtual 268	java/io/FileInputStream:close	()V
    //   106: aload 4
    //   108: astore_2
    //   109: aload_2
    //   110: areturn
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   116: aload 4
    //   118: areturn
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_1
    //   122: aload 5
    //   124: astore 4
    //   126: ldc 16
    //   128: aload_2
    //   129: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   132: invokestatic 119	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_1
    //   136: astore_2
    //   137: aload 5
    //   139: ifnull -30 -> 109
    //   142: aload 5
    //   144: invokevirtual 268	java/io/FileInputStream:close	()V
    //   147: aload_1
    //   148: areturn
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   154: aload_1
    //   155: areturn
    //   156: astore_2
    //   157: aconst_null
    //   158: astore_1
    //   159: aload 6
    //   161: astore 5
    //   163: aload 5
    //   165: astore 4
    //   167: ldc 16
    //   169: aload_2
    //   170: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   173: invokestatic 119	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_1
    //   177: astore_2
    //   178: aload 5
    //   180: ifnull -71 -> 109
    //   183: aload 5
    //   185: invokevirtual 268	java/io/FileInputStream:close	()V
    //   188: aload_1
    //   189: areturn
    //   190: astore_2
    //   191: aload_2
    //   192: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   195: aload_1
    //   196: areturn
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_1
    //   200: aload 7
    //   202: astore 5
    //   204: aload 5
    //   206: astore 4
    //   208: ldc 16
    //   210: aload_2
    //   211: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   214: invokestatic 119	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_1
    //   218: astore_2
    //   219: aload 5
    //   221: ifnull -112 -> 109
    //   224: aload 5
    //   226: invokevirtual 268	java/io/FileInputStream:close	()V
    //   229: aload_1
    //   230: areturn
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   236: aload_1
    //   237: areturn
    //   238: astore_1
    //   239: aload 4
    //   241: ifnull +8 -> 249
    //   244: aload 4
    //   246: invokevirtual 268	java/io/FileInputStream:close	()V
    //   249: aload_1
    //   250: athrow
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   256: goto -7 -> 249
    //   259: astore_2
    //   260: aload_1
    //   261: astore 4
    //   263: aload_2
    //   264: astore_1
    //   265: goto -26 -> 239
    //   268: astore_2
    //   269: aconst_null
    //   270: astore 4
    //   272: aload_1
    //   273: astore 5
    //   275: aload 4
    //   277: astore_1
    //   278: goto -74 -> 204
    //   281: astore 4
    //   283: aload_1
    //   284: astore 5
    //   286: aload_2
    //   287: astore_1
    //   288: aload 4
    //   290: astore_2
    //   291: goto -87 -> 204
    //   294: astore_2
    //   295: aconst_null
    //   296: astore 4
    //   298: aload_1
    //   299: astore 5
    //   301: aload 4
    //   303: astore_1
    //   304: goto -141 -> 163
    //   307: astore 4
    //   309: aload_1
    //   310: astore 5
    //   312: aload_2
    //   313: astore_1
    //   314: aload 4
    //   316: astore_2
    //   317: goto -154 -> 163
    //   320: astore_2
    //   321: aconst_null
    //   322: astore 4
    //   324: aload_1
    //   325: astore 5
    //   327: aload 4
    //   329: astore_1
    //   330: goto -208 -> 122
    //   333: astore 4
    //   335: aload_1
    //   336: astore 5
    //   338: aload_2
    //   339: astore_1
    //   340: aload 4
    //   342: astore_2
    //   343: goto -221 -> 122
    //   346: aload_2
    //   347: astore 4
    //   349: goto -254 -> 95
    //   352: iconst_0
    //   353: istore_3
    //   354: goto -302 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	ArtDecoder
    //   0	357	1	paramFile	java.io.File
    //   0	357	2	paramOptions	BitmapFactory.Options
    //   13	341	3	bool	boolean
    //   7	269	4	localObject1	Object
    //   281	8	4	localThrowable	Throwable
    //   296	6	4	localObject2	Object
    //   307	8	4	localIOException	java.io.IOException
    //   322	6	4	localObject3	Object
    //   333	8	4	localFileNotFoundException	java.io.FileNotFoundException
    //   347	1	4	localOptions	BitmapFactory.Options
    //   10	327	5	localObject4	Object
    //   1	159	6	localObject5	Object
    //   4	197	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   102	106	111	java/io/IOException
    //   14	23	119	java/io/FileNotFoundException
    //   142	147	149	java/io/IOException
    //   14	23	156	java/io/IOException
    //   183	188	190	java/io/IOException
    //   14	23	197	java/lang/Throwable
    //   224	229	231	java/io/IOException
    //   14	23	238	finally
    //   126	135	238	finally
    //   167	176	238	finally
    //   208	217	238	finally
    //   244	249	251	java/io/IOException
    //   27	41	259	finally
    //   41	49	259	finally
    //   52	68	259	finally
    //   76	95	259	finally
    //   27	41	268	java/lang/Throwable
    //   41	49	268	java/lang/Throwable
    //   52	68	268	java/lang/Throwable
    //   76	95	281	java/lang/Throwable
    //   27	41	294	java/io/IOException
    //   41	49	294	java/io/IOException
    //   52	68	294	java/io/IOException
    //   76	95	307	java/io/IOException
    //   27	41	320	java/io/FileNotFoundException
    //   41	49	320	java/io/FileNotFoundException
    //   52	68	320	java/io/FileNotFoundException
    //   76	95	333	java/io/FileNotFoundException
  }
  
  /* Error */
  public BitmapReference decodeImage(java.io.File paramFile, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 201	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_1
    //   14: aload_0
    //   15: aload_3
    //   16: aload_2
    //   17: invokevirtual 276	com/tencent/component/media/image/ArtDecoder:decodeImage	(Ljava/io/FileInputStream;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/component/media/image/BitmapReference;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_3
    //   24: ifnull +9 -> 33
    //   27: aload_3
    //   28: invokevirtual 268	java/io/FileInputStream:close	()V
    //   31: aload_2
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_3
    //   38: aload_3
    //   39: astore_1
    //   40: ldc 16
    //   42: aload_2
    //   43: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   46: invokestatic 119	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload 4
    //   51: astore_1
    //   52: aload_3
    //   53: ifnull -20 -> 33
    //   56: aload_3
    //   57: invokevirtual 268	java/io/FileInputStream:close	()V
    //   60: aconst_null
    //   61: areturn
    //   62: astore_1
    //   63: aconst_null
    //   64: areturn
    //   65: astore_2
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_3
    //   69: astore_1
    //   70: ldc 16
    //   72: aload_2
    //   73: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   76: invokestatic 119	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload 4
    //   81: astore_1
    //   82: aload_3
    //   83: ifnull -50 -> 33
    //   86: aload_3
    //   87: invokevirtual 268	java/io/FileInputStream:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_1
    //   93: aconst_null
    //   94: areturn
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 268	java/io/FileInputStream:close	()V
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: aload_2
    //   110: areturn
    //   111: astore_1
    //   112: goto -6 -> 106
    //   115: astore_2
    //   116: goto -18 -> 98
    //   119: astore_2
    //   120: goto -52 -> 68
    //   123: astore_2
    //   124: goto -86 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	ArtDecoder
    //   0	127	1	paramFile	java.io.File
    //   0	127	2	paramOptions	BitmapFactory.Options
    //   11	76	3	localFileInputStream	FileInputStream
    //   1	79	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	35	java/io/FileNotFoundException
    //   56	60	62	java/io/IOException
    //   3	12	65	java/lang/Throwable
    //   86	90	92	java/io/IOException
    //   3	12	95	finally
    //   27	31	108	java/io/IOException
    //   102	106	111	java/io/IOException
    //   14	21	115	finally
    //   40	49	115	finally
    //   70	79	115	finally
    //   14	21	119	java/lang/Throwable
    //   14	21	123	java/io/FileNotFoundException
  }
  
  /* Error */
  public BitmapReference decodeImage(FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_1
    //   9: ifnonnull +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: aload_2
    //   15: ifnull +58 -> 73
    //   18: aload_3
    //   19: astore 4
    //   21: aload 8
    //   23: astore 5
    //   25: aload 9
    //   27: astore 6
    //   29: aload_2
    //   30: getfield 169	android/graphics/BitmapFactory$Options:outHeight	I
    //   33: ifle +40 -> 73
    //   36: aload_3
    //   37: astore 4
    //   39: aload 8
    //   41: astore 5
    //   43: aload 9
    //   45: astore 6
    //   47: aload_2
    //   48: getfield 172	android/graphics/BitmapFactory$Options:outWidth	I
    //   51: ifle +22 -> 73
    //   54: aload_3
    //   55: astore 4
    //   57: aload 8
    //   59: astore 5
    //   61: aload 9
    //   63: astore 6
    //   65: aload_2
    //   66: getfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   69: iconst_1
    //   70: if_icmpge +88 -> 158
    //   73: aload_3
    //   74: astore 4
    //   76: aload 8
    //   78: astore 5
    //   80: aload 9
    //   82: astore 6
    //   84: aload_0
    //   85: aload_2
    //   86: iconst_0
    //   87: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   90: astore 7
    //   92: aload_3
    //   93: astore 4
    //   95: aload 8
    //   97: astore 5
    //   99: aload 9
    //   101: astore 6
    //   103: aload_0
    //   104: aload_1
    //   105: aload 7
    //   107: invokespecial 265	com/tencent/component/media/image/ArtDecoder:decodeImageFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   110: astore_3
    //   111: aload_3
    //   112: astore_2
    //   113: aload_3
    //   114: ifnonnull +39 -> 153
    //   117: aload_3
    //   118: astore 4
    //   120: aload_3
    //   121: astore 5
    //   123: aload_3
    //   124: astore 6
    //   126: aload_0
    //   127: aload_1
    //   128: invokespecial 267	com/tencent/component/media/image/ArtDecoder:reset	(Ljava/io/FileInputStream;)V
    //   131: aload_3
    //   132: astore 4
    //   134: aload_3
    //   135: astore 5
    //   137: aload_3
    //   138: astore 6
    //   140: aload_0
    //   141: aload_1
    //   142: aload_0
    //   143: aload 7
    //   145: iconst_0
    //   146: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   149: invokespecial 265	com/tencent/component/media/image/ArtDecoder:decodeImageFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   152: astore_2
    //   153: aload_2
    //   154: invokestatic 282	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   157: areturn
    //   158: aload_3
    //   159: astore 4
    //   161: aload 8
    //   163: astore 5
    //   165: aload 9
    //   167: astore 6
    //   169: aload_0
    //   170: aload_2
    //   171: iconst_1
    //   172: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   175: astore 7
    //   177: goto -85 -> 92
    //   180: astore_1
    //   181: ldc 16
    //   183: aload_1
    //   184: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   187: invokestatic 119	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload 4
    //   192: astore_2
    //   193: goto -40 -> 153
    //   196: astore_1
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: ldc 16
    //   202: aload_1
    //   203: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   206: invokestatic 119	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload 5
    //   211: astore_2
    //   212: goto -59 -> 153
    //   215: astore_1
    //   216: ldc 16
    //   218: aload_1
    //   219: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   222: invokestatic 119	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload 6
    //   227: astore_2
    //   228: goto -75 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	ArtDecoder
    //   0	231	1	paramFileInputStream	FileInputStream
    //   0	231	2	paramOptions	BitmapFactory.Options
    //   7	152	3	localBitmap1	Bitmap
    //   19	172	4	localBitmap2	Bitmap
    //   23	187	5	localObject1	Object
    //   27	199	6	localObject2	Object
    //   90	86	7	localOptions	BitmapFactory.Options
    //   1	161	8	localObject3	Object
    //   4	162	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   29	36	180	java/io/FileNotFoundException
    //   47	54	180	java/io/FileNotFoundException
    //   65	73	180	java/io/FileNotFoundException
    //   84	92	180	java/io/FileNotFoundException
    //   103	111	180	java/io/FileNotFoundException
    //   126	131	180	java/io/FileNotFoundException
    //   140	153	180	java/io/FileNotFoundException
    //   169	177	180	java/io/FileNotFoundException
    //   29	36	196	finally
    //   47	54	196	finally
    //   65	73	196	finally
    //   84	92	196	finally
    //   103	111	196	finally
    //   126	131	196	finally
    //   140	153	196	finally
    //   169	177	196	finally
    //   181	190	196	finally
    //   200	209	196	finally
    //   216	225	196	finally
    //   29	36	199	java/io/IOException
    //   47	54	199	java/io/IOException
    //   65	73	199	java/io/IOException
    //   84	92	199	java/io/IOException
    //   103	111	199	java/io/IOException
    //   126	131	199	java/io/IOException
    //   140	153	199	java/io/IOException
    //   169	177	199	java/io/IOException
    //   29	36	215	java/lang/Throwable
    //   47	54	215	java/lang/Throwable
    //   65	73	215	java/lang/Throwable
    //   84	92	215	java/lang/Throwable
    //   103	111	215	java/lang/Throwable
    //   126	131	215	java/lang/Throwable
    //   140	153	215	java/lang/Throwable
    //   169	177	215	java/lang/Throwable
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
        paramArrayOfByte.printStackTrace();
        ImageManagerLog.e("ArtDecoder", "decodeImage error " + paramArrayOfByte.toString());
        paramArrayOfByte = localObject;
      }
    }
  }
  
  public int getHitCount()
  {
    if (this.mBitmapPool != null) {
      return this.mBitmapPool.getHitCount();
    }
    return 0;
  }
  
  public int getMissCount()
  {
    if (this.mBitmapPool != null) {
      return this.mBitmapPool.getMissCount();
    }
    return 0;
  }
  
  public long getTotalExpectSize()
  {
    if (this.mBitmapPool != null) {
      return this.mBitmapPool.getTotalExpectSize();
    }
    return 0L;
  }
  
  public long getTotalRealSize()
  {
    if (this.mBitmapPool != null) {
      return this.mBitmapPool.getTotalRealSize();
    }
    return 0L;
  }
  
  public void resizeCache(float paramFloat)
  {
    if (this.mBitmapPool != null) {
      this.mBitmapPool.resizeCache(paramFloat);
    }
  }
  
  public void trimToSize(float paramFloat)
  {
    if (this.mBitmapPool != null) {
      this.mBitmapPool.trimToSize(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.ArtDecoder
 * JD-Core Version:    0.7.0.1
 */