package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.FileInputStream;
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
  
  /* Error */
  private Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: iload 5
    //   2: iflt +212 -> 214
    //   5: iload 6
    //   7: ifge +6 -> 13
    //   10: goto +204 -> 214
    //   13: aload_0
    //   14: getfield 29	com/tencent/component/media/image/ArtDecoder:mBitmapPool	Lcom/tencent/component/media/image/BitmapPool;
    //   17: iload 5
    //   19: iload 6
    //   21: imul
    //   22: aload 4
    //   24: getfield 40	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   27: invokestatic 46	com/tencent/component/media/utils/BitmapUtils:getBytesPerPixel	(Landroid/graphics/Bitmap$Config;)I
    //   30: imul
    //   31: invokevirtual 52	com/tencent/component/media/image/BitmapPool:get	(I)Ljava/lang/Object;
    //   34: checkcast 54	android/graphics/Bitmap
    //   37: astore 7
    //   39: aload 4
    //   41: aload 7
    //   43: putfield 58	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   46: aload 4
    //   48: iconst_1
    //   49: putfield 62	android/graphics/BitmapFactory$Options:inDither	Z
    //   52: aload 4
    //   54: iconst_1
    //   55: putfield 65	android/graphics/BitmapFactory$Options:inMutable	Z
    //   58: aload 4
    //   60: getfield 68	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   63: invokestatic 72	com/tencent/component/media/image/ArtDecoder:isPng	(Ljava/lang/String;)Z
    //   66: ifeq +11 -> 77
    //   69: aload 4
    //   71: getstatic 77	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   74: putfield 40	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   77: aload_1
    //   78: iload_2
    //   79: iload_3
    //   80: aload 4
    //   82: invokestatic 82	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   85: astore 4
    //   87: aload 4
    //   89: astore_1
    //   90: aload 7
    //   92: aload 4
    //   94: if_acmpeq +201 -> 295
    //   97: new 84	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   104: astore_1
    //   105: aload_1
    //   106: ldc 87
    //   108: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_1
    //   113: aload 7
    //   115: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_1
    //   120: ldc 96
    //   122: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: aload 4
    //   129: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: ldc 16
    //   135: aload_1
    //   136: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 29	com/tencent/component/media/image/ArtDecoder:mBitmapPool	Lcom/tencent/component/media/image/BitmapPool;
    //   146: aload 7
    //   148: invokevirtual 110	com/tencent/component/media/image/BitmapPool:release	(Landroid/graphics/Bitmap;)V
    //   151: aload 4
    //   153: areturn
    //   154: astore_1
    //   155: goto +57 -> 212
    //   158: astore_1
    //   159: new 84	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   166: astore 4
    //   168: aload 4
    //   170: ldc 112
    //   172: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 4
    //   178: iload 5
    //   180: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 4
    //   186: ldc 117
    //   188: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 4
    //   194: iload 6
    //   196: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: ldc 16
    //   202: aload 4
    //   204: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_1
    //   211: athrow
    //   212: aload_1
    //   213: athrow
    //   214: new 84	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   221: astore 7
    //   223: aload 7
    //   225: ldc 122
    //   227: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 7
    //   233: iload 5
    //   235: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 7
    //   241: ldc 124
    //   243: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 7
    //   249: iload 6
    //   251: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc 16
    //   257: aload 7
    //   259: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 129	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   265: pop
    //   266: aload 4
    //   268: iconst_1
    //   269: putfield 62	android/graphics/BitmapFactory$Options:inDither	Z
    //   272: aload 4
    //   274: iconst_1
    //   275: putfield 65	android/graphics/BitmapFactory$Options:inMutable	Z
    //   278: aload 4
    //   280: getstatic 77	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   283: putfield 40	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   286: aload_1
    //   287: iload_2
    //   288: iload_3
    //   289: aload 4
    //   291: invokestatic 82	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   294: astore_1
    //   295: aload_1
    //   296: areturn
    //   297: astore_1
    //   298: goto +6 -> 304
    //   301: astore_1
    //   302: aload_1
    //   303: athrow
    //   304: aload_1
    //   305: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	ArtDecoder
    //   0	306	1	paramArrayOfByte	byte[]
    //   0	306	2	paramInt1	int
    //   0	306	3	paramInt2	int
    //   0	306	4	paramOptions	BitmapFactory.Options
    //   0	306	5	paramInt3	int
    //   0	306	6	paramInt4	int
    //   37	221	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	87	154	finally
    //   159	212	154	finally
    //   77	87	158	java/lang/RuntimeException
    //   286	295	297	finally
    //   302	304	297	finally
    //   286	295	301	java/lang/RuntimeException
  }
  
  /* Error */
  private Bitmap decodeImageFromStream(java.io.InputStream paramInputStream, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 58	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   4: astore 5
    //   6: new 137	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 140	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   14: astore 6
    //   16: aload_0
    //   17: getfield 27	com/tencent/component/media/image/ArtDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   20: sipush 16384
    //   23: invokevirtual 143	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   26: checkcast 145	[B
    //   29: astore_1
    //   30: aconst_null
    //   31: astore 4
    //   33: aconst_null
    //   34: astore_3
    //   35: aload_2
    //   36: aload_1
    //   37: putfield 148	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   40: aload 6
    //   42: aconst_null
    //   43: aload_2
    //   44: invokestatic 152	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 27	com/tencent/component/media/image/ArtDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   52: aload_1
    //   53: invokevirtual 155	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   56: aload_2
    //   57: astore_1
    //   58: aload 5
    //   60: aload_2
    //   61: if_acmpeq +294 -> 355
    //   64: aload_2
    //   65: astore_1
    //   66: aload 5
    //   68: ifnull +287 -> 355
    //   71: new 84	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: ldc 157
    //   82: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_1
    //   87: aload 5
    //   89: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: ldc 96
    //   96: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_1
    //   101: aload_2
    //   102: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: ldc 16
    //   108: aload_1
    //   109: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 29	com/tencent/component/media/image/ArtDecoder:mBitmapPool	Lcom/tencent/component/media/image/BitmapPool;
    //   119: aload 5
    //   121: invokevirtual 110	com/tencent/component/media/image/BitmapPool:release	(Landroid/graphics/Bitmap;)V
    //   124: aload_2
    //   125: areturn
    //   126: astore_2
    //   127: goto +230 -> 357
    //   130: astore_2
    //   131: new 84	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   138: astore 6
    //   140: aload 6
    //   142: ldc 159
    //   144: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 6
    //   150: aload_2
    //   151: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   154: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: ldc 16
    //   160: aload 6
    //   162: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_0
    //   169: getfield 27	com/tencent/component/media/image/ArtDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   172: aload_1
    //   173: invokevirtual 155	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   176: aload 4
    //   178: astore_1
    //   179: aload 5
    //   181: ifnull +174 -> 355
    //   184: aload 4
    //   186: astore_1
    //   187: aload 5
    //   189: ifnull +166 -> 355
    //   192: new 84	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   199: astore_1
    //   200: aload_3
    //   201: astore_2
    //   202: goto -123 -> 79
    //   205: astore_2
    //   206: new 84	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   213: astore 6
    //   215: aload 6
    //   217: ldc 159
    //   219: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 6
    //   225: aload_2
    //   226: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   229: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: ldc 16
    //   235: aload 6
    //   237: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_0
    //   244: getfield 27	com/tencent/component/media/image/ArtDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   247: aload_1
    //   248: invokevirtual 155	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   251: aload 4
    //   253: astore_1
    //   254: aload 5
    //   256: ifnull +99 -> 355
    //   259: aload 4
    //   261: astore_1
    //   262: aload 5
    //   264: ifnull +91 -> 355
    //   267: new 84	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   274: astore_1
    //   275: aload_3
    //   276: astore_2
    //   277: goto -198 -> 79
    //   280: astore_2
    //   281: new 84	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   288: astore 6
    //   290: aload 6
    //   292: ldc 159
    //   294: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 6
    //   300: aload_2
    //   301: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   304: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: ldc 16
    //   310: aload 6
    //   312: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload_0
    //   319: getfield 27	com/tencent/component/media/image/ArtDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   322: aload_1
    //   323: invokevirtual 155	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   326: aload 4
    //   328: astore_1
    //   329: aload 5
    //   331: ifnull +24 -> 355
    //   334: aload 4
    //   336: astore_1
    //   337: aload 5
    //   339: ifnull +16 -> 355
    //   342: new 84	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   349: astore_1
    //   350: aload_3
    //   351: astore_2
    //   352: goto -273 -> 79
    //   355: aload_1
    //   356: areturn
    //   357: aload_0
    //   358: getfield 27	com/tencent/component/media/image/ArtDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   361: aload_1
    //   362: invokevirtual 155	com/tencent/component/media/image/ByteArrayPool:release	(Ljava/lang/Object;)V
    //   365: aload 5
    //   367: ifnull +61 -> 428
    //   370: aload 5
    //   372: ifnull +56 -> 428
    //   375: new 84	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   382: astore_1
    //   383: aload_1
    //   384: ldc 157
    //   386: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_1
    //   391: aload 5
    //   393: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload_1
    //   398: ldc 96
    //   400: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_1
    //   405: aconst_null
    //   406: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: ldc 16
    //   412: aload_1
    //   413: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload_0
    //   420: getfield 29	com/tencent/component/media/image/ArtDecoder:mBitmapPool	Lcom/tencent/component/media/image/BitmapPool;
    //   423: aload 5
    //   425: invokevirtual 110	com/tencent/component/media/image/BitmapPool:release	(Landroid/graphics/Bitmap;)V
    //   428: goto +5 -> 433
    //   431: aload_2
    //   432: athrow
    //   433: goto -2 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	ArtDecoder
    //   0	436	1	paramInputStream	java.io.InputStream
    //   0	436	2	paramOptions	BitmapFactory.Options
    //   34	317	3	localObject1	Object
    //   31	304	4	localObject2	Object
    //   4	420	5	localBitmap	Bitmap
    //   14	297	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	48	126	finally
    //   131	168	126	finally
    //   206	243	126	finally
    //   281	318	126	finally
    //   35	48	130	java/lang/Throwable
    //   35	48	205	java/lang/OutOfMemoryError
    //   35	48	280	java/lang/RuntimeException
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
    if ((localOptions.outHeight > 0) && (localOptions.outWidth > 0) && (localOptions.inSampleSize >= 1))
    {
      int j = localOptions.inSampleSize;
      int i = (localOptions.outWidth + j - 1) / j;
      j = (localOptions.outHeight + j - 1) / j;
      if (isPng(localOptions.outMimeType)) {
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      }
      Bitmap localBitmap = (Bitmap)this.mBitmapPool.get(i * j * BitmapUtils.getBytesPerPixel(localOptions.inPreferredConfig));
      if (localBitmap == null)
      {
        Log.e("ArtDecoder", "decodeImage Stream error no bitmap");
        paramOptions = localBitmap;
      }
      else
      {
        paramOptions = localBitmap;
        if (!localBitmap.isMutable())
        {
          Log.e("ArtDecoder", "decodeImage Stream error bitmap not mutable !");
          paramOptions = null;
        }
      }
      localOptions.inBitmap = paramOptions;
      return localOptions;
    }
    throw new IllegalArgumentException("options 参数错误");
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
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: ifnull +477 -> 481
    //   7: aload_1
    //   8: invokevirtual 222	java/io/File:exists	()Z
    //   11: ifeq +470 -> 481
    //   14: aload_1
    //   15: invokevirtual 225	java/io/File:isFile	()Z
    //   18: ifeq +463 -> 481
    //   21: aload_1
    //   22: invokevirtual 228	java/io/File:canRead	()Z
    //   25: ifne +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: new 36	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 166	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 9
    //   39: aload 9
    //   41: iconst_1
    //   42: putfield 231	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload 9
    //   47: aload_0
    //   48: getfield 27	com/tencent/component/media/image/ArtDecoder:mByteArrayPool	Lcom/tencent/component/media/image/ByteArrayPool;
    //   51: sipush 16384
    //   54: invokevirtual 143	com/tencent/component/media/image/ByteArrayPool:get	(I)Ljava/lang/Object;
    //   57: checkcast 145	[B
    //   60: putfield 148	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   63: new 137	java/io/BufferedInputStream
    //   66: dup
    //   67: new 201	java/io/FileInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: sipush 8192
    //   78: invokespecial 237	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   81: astore 6
    //   83: aload 6
    //   85: astore 5
    //   87: aload 6
    //   89: aconst_null
    //   90: aload 9
    //   92: invokestatic 152	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   95: pop
    //   96: aload 6
    //   98: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   101: goto +86 -> 187
    //   104: astore 7
    //   106: goto +20 -> 126
    //   109: astore 7
    //   111: goto +42 -> 153
    //   114: astore_1
    //   115: aconst_null
    //   116: astore 5
    //   118: goto +341 -> 459
    //   121: astore 7
    //   123: aconst_null
    //   124: astore 6
    //   126: aload 6
    //   128: astore 5
    //   130: ldc 16
    //   132: aload 7
    //   134: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   137: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 6
    //   142: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   145: goto +42 -> 187
    //   148: astore 7
    //   150: aconst_null
    //   151: astore 6
    //   153: aload 6
    //   155: astore 5
    //   157: ldc 16
    //   159: aload 7
    //   161: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   164: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 6
    //   169: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   172: goto +15 -> 187
    //   175: astore 5
    //   177: ldc 16
    //   179: aload 5
    //   181: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 9
    //   189: iconst_0
    //   190: putfield 231	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   193: new 242	com/tencent/component/media/image/ImageLoader$Options
    //   196: dup
    //   197: invokespecial 243	com/tencent/component/media/image/ImageLoader$Options:<init>	()V
    //   200: astore 5
    //   202: aload 5
    //   204: iload_3
    //   205: putfield 246	com/tencent/component/media/image/ImageLoader$Options:clipHeight	I
    //   208: aload 5
    //   210: iload_2
    //   211: putfield 249	com/tencent/component/media/image/ImageLoader$Options:clipWidth	I
    //   214: iload_3
    //   215: ifle +27 -> 242
    //   218: iload_2
    //   219: ifle +23 -> 242
    //   222: aload 9
    //   224: aload 5
    //   226: aload 9
    //   228: getfield 172	android/graphics/BitmapFactory$Options:outWidth	I
    //   231: aload 9
    //   233: getfield 169	android/graphics/BitmapFactory$Options:outHeight	I
    //   236: invokestatic 255	com/tencent/component/media/image/ImageOptionSampleSize:computeSampleSize	(Lcom/tencent/component/media/image/ImageLoader$Options;II)I
    //   239: putfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   242: aload 9
    //   244: getfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   247: iconst_1
    //   248: if_icmpge +9 -> 257
    //   251: aload 9
    //   253: iconst_1
    //   254: putfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   257: aload 9
    //   259: aload 4
    //   261: invokestatic 259	com/tencent/component/media/utils/BitmapUtils:addInBitmapOptions	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;)V
    //   264: new 137	java/io/BufferedInputStream
    //   267: dup
    //   268: new 201	java/io/FileInputStream
    //   271: dup
    //   272: aload_1
    //   273: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   276: sipush 8192
    //   279: invokespecial 237	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   282: astore 4
    //   284: aload 4
    //   286: astore_1
    //   287: aload 4
    //   289: aconst_null
    //   290: aload 9
    //   292: invokestatic 152	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   295: astore 5
    //   297: aload 5
    //   299: astore_1
    //   300: aload 4
    //   302: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   305: aload 5
    //   307: areturn
    //   308: astore 4
    //   310: ldc 16
    //   312: aload 4
    //   314: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   317: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_1
    //   321: areturn
    //   322: astore 5
    //   324: goto +25 -> 349
    //   327: astore 5
    //   329: goto +48 -> 377
    //   332: astore 5
    //   334: goto +71 -> 405
    //   337: astore_1
    //   338: aconst_null
    //   339: astore 4
    //   341: goto +95 -> 436
    //   344: astore 5
    //   346: aconst_null
    //   347: astore 4
    //   349: aload 4
    //   351: astore_1
    //   352: ldc 16
    //   354: aload 5
    //   356: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   359: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload 8
    //   364: astore_1
    //   365: aload 4
    //   367: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   370: aconst_null
    //   371: areturn
    //   372: astore 5
    //   374: aconst_null
    //   375: astore 4
    //   377: aload 4
    //   379: astore_1
    //   380: ldc 16
    //   382: aload 5
    //   384: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   387: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload 8
    //   392: astore_1
    //   393: aload 4
    //   395: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   398: aconst_null
    //   399: areturn
    //   400: astore 5
    //   402: aconst_null
    //   403: astore 4
    //   405: aload 4
    //   407: astore_1
    //   408: ldc 16
    //   410: aload 5
    //   412: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   415: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: aload 8
    //   420: astore_1
    //   421: aload 4
    //   423: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   426: aconst_null
    //   427: areturn
    //   428: astore 5
    //   430: aload_1
    //   431: astore 4
    //   433: aload 5
    //   435: astore_1
    //   436: aload 4
    //   438: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   441: goto +15 -> 456
    //   444: astore 4
    //   446: ldc 16
    //   448: aload 4
    //   450: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   453: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload_1
    //   457: athrow
    //   458: astore_1
    //   459: aload 5
    //   461: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   464: goto +15 -> 479
    //   467: astore 4
    //   469: ldc 16
    //   471: aload 4
    //   473: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   476: invokestatic 120	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: aload_1
    //   480: athrow
    //   481: aconst_null
    //   482: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	ArtDecoder
    //   0	483	1	paramFile	java.io.File
    //   0	483	2	paramInt1	int
    //   0	483	3	paramInt2	int
    //   0	483	4	paramBitmap	Bitmap
    //   85	71	5	localBufferedInputStream1	java.io.BufferedInputStream
    //   175	5	5	localIOException	java.io.IOException
    //   200	106	5	localObject1	Object
    //   322	1	5	localThrowable1	Throwable
    //   327	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   332	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   344	11	5	localThrowable2	Throwable
    //   372	11	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   400	11	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   428	32	5	localObject2	Object
    //   81	87	6	localBufferedInputStream2	java.io.BufferedInputStream
    //   104	1	7	localThrowable3	Throwable
    //   109	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   121	12	7	localThrowable4	Throwable
    //   148	12	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   1	418	8	localObject3	Object
    //   37	254	9	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   87	96	104	java/lang/Throwable
    //   87	96	109	java/io/FileNotFoundException
    //   63	83	114	finally
    //   63	83	121	java/lang/Throwable
    //   63	83	148	java/io/FileNotFoundException
    //   96	101	175	java/io/IOException
    //   140	145	175	java/io/IOException
    //   167	172	175	java/io/IOException
    //   300	305	308	java/io/IOException
    //   365	370	308	java/io/IOException
    //   393	398	308	java/io/IOException
    //   421	426	308	java/io/IOException
    //   287	297	322	java/lang/Throwable
    //   287	297	327	java/io/FileNotFoundException
    //   287	297	332	java/lang/OutOfMemoryError
    //   264	284	337	finally
    //   264	284	344	java/lang/Throwable
    //   264	284	372	java/io/FileNotFoundException
    //   264	284	400	java/lang/OutOfMemoryError
    //   287	297	428	finally
    //   352	362	428	finally
    //   380	390	428	finally
    //   408	418	428	finally
    //   436	441	444	java/io/IOException
    //   87	96	458	finally
    //   130	140	458	finally
    //   157	167	458	finally
    //   459	464	467	java/io/IOException
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
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 11
    //   18: aconst_null
    //   19: astore 4
    //   21: new 201	java/io/FileInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_1
    //   30: iconst_1
    //   31: istore_3
    //   32: aload_2
    //   33: ifnull +363 -> 396
    //   36: aload 9
    //   38: astore 4
    //   40: aload 10
    //   42: astore 5
    //   44: aload 11
    //   46: astore 6
    //   48: aload_2
    //   49: getfield 169	android/graphics/BitmapFactory$Options:outHeight	I
    //   52: ifle +344 -> 396
    //   55: aload 9
    //   57: astore 4
    //   59: aload 10
    //   61: astore 5
    //   63: aload 11
    //   65: astore 6
    //   67: aload_2
    //   68: getfield 172	android/graphics/BitmapFactory$Options:outWidth	I
    //   71: ifle +325 -> 396
    //   74: aload 9
    //   76: astore 4
    //   78: aload 10
    //   80: astore 5
    //   82: aload 11
    //   84: astore 6
    //   86: aload_2
    //   87: getfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   90: iconst_1
    //   91: if_icmpge +6 -> 97
    //   94: goto +302 -> 396
    //   97: aload 9
    //   99: astore 4
    //   101: aload 10
    //   103: astore 5
    //   105: aload 11
    //   107: astore 6
    //   109: aload_0
    //   110: aload_2
    //   111: iload_3
    //   112: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   115: astore 7
    //   117: aload 9
    //   119: astore 4
    //   121: aload 10
    //   123: astore 5
    //   125: aload 11
    //   127: astore 6
    //   129: aload_0
    //   130: aload_1
    //   131: aload 7
    //   133: invokespecial 265	com/tencent/component/media/image/ArtDecoder:decodeImageFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   136: astore_2
    //   137: aload_2
    //   138: astore 4
    //   140: iload_3
    //   141: ifeq +49 -> 190
    //   144: aload_2
    //   145: astore 4
    //   147: aload_2
    //   148: ifnonnull +42 -> 190
    //   151: aload_2
    //   152: astore 4
    //   154: aload_2
    //   155: astore 5
    //   157: aload_2
    //   158: astore 6
    //   160: aload_0
    //   161: aload_1
    //   162: invokespecial 267	com/tencent/component/media/image/ArtDecoder:reset	(Ljava/io/FileInputStream;)V
    //   165: aload_2
    //   166: astore 4
    //   168: aload_2
    //   169: astore 5
    //   171: aload_2
    //   172: astore 6
    //   174: aload_0
    //   175: aload_1
    //   176: aload_0
    //   177: aload 7
    //   179: iconst_0
    //   180: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   183: invokespecial 265	com/tencent/component/media/image/ArtDecoder:decodeImageFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   186: astore_2
    //   187: aload_2
    //   188: astore 4
    //   190: aload_1
    //   191: invokevirtual 268	java/io/FileInputStream:close	()V
    //   194: goto +8 -> 202
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   202: aload 4
    //   204: areturn
    //   205: astore_1
    //   206: goto +123 -> 329
    //   209: astore 5
    //   211: aconst_null
    //   212: astore_1
    //   213: aload 6
    //   215: astore_2
    //   216: aload_2
    //   217: astore 4
    //   219: ldc 16
    //   221: aload 5
    //   223: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   226: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_1
    //   230: astore 4
    //   232: aload_2
    //   233: ifnull +93 -> 326
    //   236: aload_1
    //   237: astore 4
    //   239: aload_2
    //   240: invokevirtual 268	java/io/FileInputStream:close	()V
    //   243: aload_1
    //   244: areturn
    //   245: astore_1
    //   246: aload_1
    //   247: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   250: aload 4
    //   252: areturn
    //   253: astore 5
    //   255: aconst_null
    //   256: astore_1
    //   257: aload 7
    //   259: astore_2
    //   260: aload_2
    //   261: astore 4
    //   263: ldc 16
    //   265: aload 5
    //   267: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   270: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_1
    //   274: astore 4
    //   276: aload_2
    //   277: ifnull +49 -> 326
    //   280: aload_1
    //   281: astore 4
    //   283: aload_2
    //   284: invokevirtual 268	java/io/FileInputStream:close	()V
    //   287: aload_1
    //   288: areturn
    //   289: astore 5
    //   291: aconst_null
    //   292: astore_1
    //   293: aload 8
    //   295: astore_2
    //   296: aload_2
    //   297: astore 4
    //   299: ldc 16
    //   301: aload 5
    //   303: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   306: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_1
    //   310: astore 4
    //   312: aload_2
    //   313: ifnull +13 -> 326
    //   316: aload_1
    //   317: astore 4
    //   319: aload_2
    //   320: invokevirtual 268	java/io/FileInputStream:close	()V
    //   323: aload_1
    //   324: astore 4
    //   326: aload 4
    //   328: areturn
    //   329: aload 4
    //   331: ifnull +16 -> 347
    //   334: aload 4
    //   336: invokevirtual 268	java/io/FileInputStream:close	()V
    //   339: goto +8 -> 347
    //   342: astore_2
    //   343: aload_2
    //   344: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   347: aload_1
    //   348: athrow
    //   349: astore_2
    //   350: aload_1
    //   351: astore 4
    //   353: aload_2
    //   354: astore_1
    //   355: goto -26 -> 329
    //   358: astore 5
    //   360: aload_1
    //   361: astore_2
    //   362: aload 4
    //   364: astore_1
    //   365: goto -149 -> 216
    //   368: astore 6
    //   370: aload 5
    //   372: astore 4
    //   374: aload_1
    //   375: astore_2
    //   376: aload 6
    //   378: astore 5
    //   380: aload 4
    //   382: astore_1
    //   383: goto -123 -> 260
    //   386: astore 5
    //   388: aload_1
    //   389: astore_2
    //   390: aload 6
    //   392: astore_1
    //   393: goto -97 -> 296
    //   396: iconst_0
    //   397: istore_3
    //   398: goto -301 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	ArtDecoder
    //   0	401	1	paramFile	java.io.File
    //   0	401	2	paramOptions	BitmapFactory.Options
    //   31	367	3	bool	boolean
    //   19	362	4	localObject1	Object
    //   42	128	5	localObject2	Object
    //   209	13	5	localThrowable1	Throwable
    //   253	13	5	localIOException1	java.io.IOException
    //   289	13	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   358	13	5	localThrowable2	Throwable
    //   378	1	5	localIOException2	java.io.IOException
    //   386	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	213	6	localObject3	Object
    //   368	23	6	localIOException3	java.io.IOException
    //   4	254	7	localOptions	BitmapFactory.Options
    //   7	287	8	localObject4	Object
    //   10	108	9	localObject5	Object
    //   13	109	10	localObject6	Object
    //   16	110	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   190	194	197	java/io/IOException
    //   21	30	205	finally
    //   219	229	205	finally
    //   263	273	205	finally
    //   299	309	205	finally
    //   21	30	209	java/lang/Throwable
    //   239	243	245	java/io/IOException
    //   283	287	245	java/io/IOException
    //   319	323	245	java/io/IOException
    //   21	30	253	java/io/IOException
    //   21	30	289	java/io/FileNotFoundException
    //   334	339	342	java/io/IOException
    //   48	55	349	finally
    //   67	74	349	finally
    //   86	94	349	finally
    //   109	117	349	finally
    //   129	137	349	finally
    //   160	165	349	finally
    //   174	187	349	finally
    //   48	55	358	java/lang/Throwable
    //   67	74	358	java/lang/Throwable
    //   86	94	358	java/lang/Throwable
    //   109	117	358	java/lang/Throwable
    //   129	137	358	java/lang/Throwable
    //   160	165	358	java/lang/Throwable
    //   174	187	358	java/lang/Throwable
    //   48	55	368	java/io/IOException
    //   67	74	368	java/io/IOException
    //   86	94	368	java/io/IOException
    //   109	117	368	java/io/IOException
    //   129	137	368	java/io/IOException
    //   160	165	368	java/io/IOException
    //   174	187	368	java/io/IOException
    //   48	55	386	java/io/FileNotFoundException
    //   67	74	386	java/io/FileNotFoundException
    //   86	94	386	java/io/FileNotFoundException
    //   109	117	386	java/io/FileNotFoundException
    //   129	137	386	java/io/FileNotFoundException
    //   160	165	386	java/io/FileNotFoundException
    //   174	187	386	java/io/FileNotFoundException
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
    //   24: invokevirtual 268	java/io/FileInputStream:close	()V
    //   27: aload_1
    //   28: areturn
    //   29: astore_2
    //   30: goto +64 -> 94
    //   33: astore_2
    //   34: goto +16 -> 50
    //   37: astore_2
    //   38: goto +33 -> 71
    //   41: astore_2
    //   42: aconst_null
    //   43: astore_1
    //   44: goto +50 -> 94
    //   47: astore_2
    //   48: aconst_null
    //   49: astore_3
    //   50: aload_3
    //   51: astore_1
    //   52: ldc 16
    //   54: aload_2
    //   55: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   58: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_3
    //   62: ifnull +30 -> 92
    //   65: aload 4
    //   67: astore_1
    //   68: goto -45 -> 23
    //   71: aload_3
    //   72: astore_1
    //   73: ldc 16
    //   75: aload_2
    //   76: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   79: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_3
    //   83: ifnull +9 -> 92
    //   86: aload 4
    //   88: astore_1
    //   89: goto -66 -> 23
    //   92: aconst_null
    //   93: areturn
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 268	java/io/FileInputStream:close	()V
    //   102: goto +5 -> 107
    //   105: aload_2
    //   106: athrow
    //   107: goto -2 -> 105
    //   110: astore_2
    //   111: aload_1
    //   112: areturn
    //   113: astore_1
    //   114: goto -12 -> 102
    //   117: astore_2
    //   118: aconst_null
    //   119: astore_3
    //   120: goto -49 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	ArtDecoder
    //   0	123	1	paramFile	java.io.File
    //   0	123	2	paramOptions	BitmapFactory.Options
    //   11	109	3	localFileInputStream	FileInputStream
    //   1	86	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	21	29	finally
    //   52	61	29	finally
    //   73	82	29	finally
    //   14	21	33	java/lang/Throwable
    //   14	21	37	java/io/FileNotFoundException
    //   3	12	41	finally
    //   3	12	47	java/lang/Throwable
    //   23	27	110	java/io/IOException
    //   98	102	113	java/io/IOException
    //   3	12	117	java/io/FileNotFoundException
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
    //   15: ifnull +83 -> 98
    //   18: aload_3
    //   19: astore 4
    //   21: aload 8
    //   23: astore 5
    //   25: aload 9
    //   27: astore 6
    //   29: aload_2
    //   30: getfield 169	android/graphics/BitmapFactory$Options:outHeight	I
    //   33: ifle +65 -> 98
    //   36: aload_3
    //   37: astore 4
    //   39: aload 8
    //   41: astore 5
    //   43: aload 9
    //   45: astore 6
    //   47: aload_2
    //   48: getfield 172	android/graphics/BitmapFactory$Options:outWidth	I
    //   51: ifle +47 -> 98
    //   54: aload_3
    //   55: astore 4
    //   57: aload 8
    //   59: astore 5
    //   61: aload 9
    //   63: astore 6
    //   65: aload_2
    //   66: getfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   69: iconst_1
    //   70: if_icmpge +6 -> 76
    //   73: goto +25 -> 98
    //   76: aload_3
    //   77: astore 4
    //   79: aload 8
    //   81: astore 5
    //   83: aload 9
    //   85: astore 6
    //   87: aload_0
    //   88: aload_2
    //   89: iconst_1
    //   90: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   93: astore 7
    //   95: goto +22 -> 117
    //   98: aload_3
    //   99: astore 4
    //   101: aload 8
    //   103: astore 5
    //   105: aload 9
    //   107: astore 6
    //   109: aload_0
    //   110: aload_2
    //   111: iconst_0
    //   112: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   115: astore 7
    //   117: aload_3
    //   118: astore 4
    //   120: aload 8
    //   122: astore 5
    //   124: aload 9
    //   126: astore 6
    //   128: aload_0
    //   129: aload_1
    //   130: aload 7
    //   132: invokespecial 265	com/tencent/component/media/image/ArtDecoder:decodeImageFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   135: astore_3
    //   136: aload_3
    //   137: astore_2
    //   138: aload_3
    //   139: ifnonnull +91 -> 230
    //   142: aload_3
    //   143: astore 4
    //   145: aload_3
    //   146: astore 5
    //   148: aload_3
    //   149: astore 6
    //   151: aload_0
    //   152: aload_1
    //   153: invokespecial 267	com/tencent/component/media/image/ArtDecoder:reset	(Ljava/io/FileInputStream;)V
    //   156: aload_3
    //   157: astore 4
    //   159: aload_3
    //   160: astore 5
    //   162: aload_3
    //   163: astore 6
    //   165: aload_0
    //   166: aload_1
    //   167: aload_0
    //   168: aload 7
    //   170: iconst_0
    //   171: invokespecial 263	com/tencent/component/media/image/ArtDecoder:getDecodeOptions	(Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   174: invokespecial 265	com/tencent/component/media/image/ArtDecoder:decodeImageFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   177: astore_2
    //   178: goto +52 -> 230
    //   181: astore_1
    //   182: goto +53 -> 235
    //   185: astore_1
    //   186: ldc 16
    //   188: aload_1
    //   189: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload 4
    //   197: astore_2
    //   198: goto +32 -> 230
    //   201: astore_1
    //   202: ldc 16
    //   204: aload_1
    //   205: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   208: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 5
    //   213: astore_2
    //   214: goto +16 -> 230
    //   217: astore_1
    //   218: ldc 16
    //   220: aload_1
    //   221: invokestatic 163	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   224: invokestatic 106	com/tencent/component/media/utils/ImageManagerLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload 6
    //   229: astore_2
    //   230: aload_2
    //   231: invokestatic 282	com/tencent/component/media/image/BitmapReference:getBitmapReference	(Landroid/graphics/Bitmap;)Lcom/tencent/component/media/image/BitmapReference;
    //   234: areturn
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	ArtDecoder
    //   0	237	1	paramFileInputStream	FileInputStream
    //   0	237	2	paramOptions	BitmapFactory.Options
    //   7	156	3	localBitmap1	Bitmap
    //   19	177	4	localBitmap2	Bitmap
    //   23	189	5	localObject1	Object
    //   27	201	6	localObject2	Object
    //   93	76	7	localOptions	BitmapFactory.Options
    //   1	120	8	localObject3	Object
    //   4	121	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   29	36	181	finally
    //   47	54	181	finally
    //   65	73	181	finally
    //   87	95	181	finally
    //   109	117	181	finally
    //   128	136	181	finally
    //   151	156	181	finally
    //   165	178	181	finally
    //   186	195	181	finally
    //   202	211	181	finally
    //   218	227	181	finally
    //   29	36	185	java/lang/Throwable
    //   47	54	185	java/lang/Throwable
    //   65	73	185	java/lang/Throwable
    //   87	95	185	java/lang/Throwable
    //   109	117	185	java/lang/Throwable
    //   128	136	185	java/lang/Throwable
    //   151	156	185	java/lang/Throwable
    //   165	178	185	java/lang/Throwable
    //   29	36	201	java/io/IOException
    //   47	54	201	java/io/IOException
    //   65	73	201	java/io/IOException
    //   87	95	201	java/io/IOException
    //   109	117	201	java/io/IOException
    //   128	136	201	java/io/IOException
    //   151	156	201	java/io/IOException
    //   165	178	201	java/io/IOException
    //   29	36	217	java/io/FileNotFoundException
    //   47	54	217	java/io/FileNotFoundException
    //   65	73	217	java/io/FileNotFoundException
    //   87	95	217	java/io/FileNotFoundException
    //   109	117	217	java/io/FileNotFoundException
    //   128	136	217	java/io/FileNotFoundException
    //   151	156	217	java/io/FileNotFoundException
    //   165	178	217	java/io/FileNotFoundException
  }
  
  public BitmapReference decodeImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3, int paramInt4)
  {
    try
    {
      paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramInt3, paramInt4);
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramOptions = new StringBuilder();
      paramOptions.append("decodeImage error ");
      paramOptions.append(paramArrayOfByte.toString());
      ImageManagerLog.e("ArtDecoder", paramOptions.toString());
      paramArrayOfByte = null;
    }
    return BitmapReference.getBitmapReference(paramArrayOfByte);
  }
  
  public int getHitCount()
  {
    BitmapPool localBitmapPool = this.mBitmapPool;
    if (localBitmapPool != null) {
      return localBitmapPool.getHitCount();
    }
    return 0;
  }
  
  public int getMissCount()
  {
    BitmapPool localBitmapPool = this.mBitmapPool;
    if (localBitmapPool != null) {
      return localBitmapPool.getMissCount();
    }
    return 0;
  }
  
  public long getTotalExpectSize()
  {
    BitmapPool localBitmapPool = this.mBitmapPool;
    if (localBitmapPool != null) {
      return localBitmapPool.getTotalExpectSize();
    }
    return 0L;
  }
  
  public long getTotalRealSize()
  {
    BitmapPool localBitmapPool = this.mBitmapPool;
    if (localBitmapPool != null) {
      return localBitmapPool.getTotalRealSize();
    }
    return 0L;
  }
  
  public void resizeCache(float paramFloat)
  {
    BitmapPool localBitmapPool = this.mBitmapPool;
    if (localBitmapPool != null) {
      localBitmapPool.resizeCache(paramFloat);
    }
  }
  
  public void trimToSize(float paramFloat)
  {
    BitmapPool localBitmapPool = this.mBitmapPool;
    if (localBitmapPool != null) {
      localBitmapPool.trimToSize(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ArtDecoder
 * JD-Core Version:    0.7.0.1
 */