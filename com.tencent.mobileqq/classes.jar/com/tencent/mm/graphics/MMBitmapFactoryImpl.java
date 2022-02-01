package com.tencent.mm.graphics;

import android.content.res.AssetManager.AssetInputStream;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.TypedValue;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ry.b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;

@Keep
class MMBitmapFactoryImpl
{
  private static final int DENSITY_DEFAULT = 160;
  private static final int REWIND_BUFFER_SIZE = 8388608;
  private static final String TAG = "MicroMsg.MMBitmapFactory";
  private static final int TEMP_STORAGE_SIZE = 4096;
  private static final MMBitmapFactory.a[] sNativeLibraryLoader = { null };
  private a mDecodeCanary = null;
  private boolean mForceUsingSystemDecoderOpt = false;
  private MMBitmapFactory.b mStreamProvider = null;
  
  private MMBitmapFactoryImpl()
  {
    loadNativeModule("mmimgcodec");
  }
  
  private void announceDecodeResult(BitmapFactory.Options paramOptions, Bitmap paramBitmap, boolean paramBoolean)
  {
    assertNotNull(paramOptions, "[-] opts is null.");
    String str;
    if (paramBoolean) {
      str = "system";
    } else {
      str = "mmcodec";
    }
    if (((paramBitmap != null) || (paramOptions.outMimeType != null)) && (paramOptions.outWidth > 0) && (paramOptions.outHeight > 0))
    {
      b.c("MicroMsg.MMBitmapFactory", "[+] decode success by %s, boundsOnly:%s, w:%s, h:%s, mime-type:%s, sampleSize:%s", new Object[] { str, Boolean.valueOf(paramOptions.inJustDecodeBounds), Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight), paramOptions.outMimeType, Integer.valueOf(paramOptions.inSampleSize) });
      if ((this.mDecodeCanary != null) && (paramBitmap != null) && (!paramOptions.inJustDecodeBounds))
      {
        int i = paramBitmap.getByteCount();
        if (i >= this.mDecodeCanary.a()) {
          this.mDecodeCanary.a(paramOptions, i);
        }
      }
    }
    else
    {
      b.a("MicroMsg.MMBitmapFactory", "[+] fail to decode by %s", new Object[] { str });
    }
  }
  
  private static void assertNotNull(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  private Bitmap decodeByteArrayInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if (isForceSystemDecoder(localOptions))
    {
      b.b("MicroMsg.MMBitmapFactory", "[!] force decoding data by system codec.");
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
      announceDecodeResult(localOptions, paramArrayOfByte, true);
      return paramArrayOfByte;
    }
    for (;;)
    {
      try
      {
        paramOptions = nativeDecodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
        if (localOptions.outMimeType != null)
        {
          i = 1;
          if (i != 0)
          {
            announceDecodeResult(localOptions, paramOptions, false);
            setDensityFromOptions(paramOptions, localOptions);
            return scaleBitmapOnDemand(paramOptions, localOptions);
          }
          b.b("MicroMsg.MMBitmapFactory", "[!] unsupported image format, try to decode with system codec.");
          paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
          announceDecodeResult(localOptions, paramArrayOfByte, true);
          return paramArrayOfByte;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        b.a("MicroMsg.MMBitmapFactory", paramArrayOfByte, "decode failed.");
        return null;
      }
      int i = 0;
    }
  }
  
  /* Error */
  private Bitmap decodeFileDescriptorInternal(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 5
    //   3: aload_3
    //   4: ifnonnull +12 -> 16
    //   7: new 62	android/graphics/BitmapFactory$Options
    //   10: dup
    //   11: invokespecial 131	android/graphics/BitmapFactory$Options:<init>	()V
    //   14: astore 5
    //   16: aload_0
    //   17: aload 5
    //   19: invokespecial 135	com/tencent/mm/graphics/MMBitmapFactoryImpl:isForceSystemDecoder	(Landroid/graphics/BitmapFactory$Options;)Z
    //   22: ifeq +36 -> 58
    //   25: ldc 14
    //   27: ldc 170
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_1
    //   36: aastore
    //   37: invokestatic 172	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: aload_1
    //   41: aload_2
    //   42: aload 5
    //   44: invokestatic 175	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   47: astore_1
    //   48: aload_0
    //   49: aload 5
    //   51: aload_1
    //   52: iconst_1
    //   53: invokespecial 148	com/tencent/mm/graphics/MMBitmapFactoryImpl:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   56: aload_1
    //   57: areturn
    //   58: aload_0
    //   59: aload_1
    //   60: invokespecial 179	com/tencent/mm/graphics/MMBitmapFactoryImpl:nativeIsSeekable	(Ljava/io/FileDescriptor;)Z
    //   63: ifeq +93 -> 156
    //   66: aload_0
    //   67: aload_1
    //   68: aload 5
    //   70: invokestatic 183	com/tencent/mm/graphics/MMBitmapFactoryImpl:getOrCreateStorageBuffer	(Landroid/graphics/BitmapFactory$Options;)[B
    //   73: aload_2
    //   74: aload 5
    //   76: invokespecial 187	com/tencent/mm/graphics/MMBitmapFactoryImpl:nativeDecodeFileDescriptor	(Ljava/io/FileDescriptor;[BLandroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   79: astore_3
    //   80: aload 5
    //   82: getfield 65	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   85: ifnull +140 -> 225
    //   88: iconst_1
    //   89: istore 4
    //   91: goto +3 -> 94
    //   94: iload 4
    //   96: ifeq +24 -> 120
    //   99: aload_0
    //   100: aload 5
    //   102: aload_3
    //   103: iconst_0
    //   104: invokespecial 148	com/tencent/mm/graphics/MMBitmapFactoryImpl:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   107: aload_3
    //   108: aload 5
    //   110: invokestatic 155	com/tencent/mm/graphics/MMBitmapFactoryImpl:setDensityFromOptions	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)V
    //   113: aload_3
    //   114: aload 5
    //   116: invokestatic 159	com/tencent/mm/graphics/MMBitmapFactoryImpl:scaleBitmapOnDemand	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   119: areturn
    //   120: ldc 14
    //   122: ldc 161
    //   124: invokestatic 141	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: aload_2
    //   129: aload 5
    //   131: invokestatic 175	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   134: astore_1
    //   135: aload_0
    //   136: aload 5
    //   138: aload_1
    //   139: iconst_1
    //   140: invokespecial 148	com/tencent/mm/graphics/MMBitmapFactoryImpl:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   143: aload_1
    //   144: areturn
    //   145: astore_1
    //   146: ldc 14
    //   148: aload_1
    //   149: ldc 163
    //   151: invokestatic 166	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   154: aconst_null
    //   155: areturn
    //   156: new 189	java/io/FileInputStream
    //   159: dup
    //   160: aload_1
    //   161: invokespecial 192	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   164: astore_3
    //   165: aload_3
    //   166: astore_1
    //   167: aload_0
    //   168: aload_3
    //   169: aload_2
    //   170: aload 5
    //   172: invokespecial 196	com/tencent/mm/graphics/MMBitmapFactoryImpl:decodeStreamInternal	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   175: astore_2
    //   176: aload_3
    //   177: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   180: aload_2
    //   181: areturn
    //   182: astore_2
    //   183: goto +36 -> 219
    //   186: astore_1
    //   187: aload_3
    //   188: astore_2
    //   189: aload_1
    //   190: astore_3
    //   191: goto +12 -> 203
    //   194: astore_2
    //   195: aconst_null
    //   196: astore_1
    //   197: goto +22 -> 219
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_2
    //   203: aload_2
    //   204: astore_1
    //   205: ldc 14
    //   207: aload_3
    //   208: ldc 163
    //   210: invokestatic 166	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   213: aload_2
    //   214: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   217: aconst_null
    //   218: areturn
    //   219: aload_1
    //   220: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   223: aload_2
    //   224: athrow
    //   225: iconst_0
    //   226: istore 4
    //   228: goto -134 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	MMBitmapFactoryImpl
    //   0	231	1	paramFileDescriptor	FileDescriptor
    //   0	231	2	paramRect	Rect
    //   0	231	3	paramOptions	BitmapFactory.Options
    //   89	138	4	i	int
    //   1	170	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   66	88	145	java/lang/Throwable
    //   99	120	145	java/lang/Throwable
    //   120	143	145	java/lang/Throwable
    //   167	176	182	finally
    //   205	213	182	finally
    //   167	176	186	java/lang/Throwable
    //   156	165	194	finally
    //   156	165	200	java/lang/Throwable
  }
  
  /* Error */
  private Bitmap decodeFileInternal(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 6
    //   3: aload_2
    //   4: ifnonnull +12 -> 16
    //   7: new 62	android/graphics/BitmapFactory$Options
    //   10: dup
    //   11: invokespecial 131	android/graphics/BitmapFactory$Options:<init>	()V
    //   14: astore 6
    //   16: aload_0
    //   17: aload 6
    //   19: invokespecial 135	com/tencent/mm/graphics/MMBitmapFactoryImpl:isForceSystemDecoder	(Landroid/graphics/BitmapFactory$Options;)Z
    //   22: istore 4
    //   24: iconst_1
    //   25: istore_3
    //   26: iload 4
    //   28: ifeq +26 -> 54
    //   31: ldc 14
    //   33: ldc 202
    //   35: iconst_1
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: invokestatic 172	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: aload_1
    //   48: aload 6
    //   50: invokespecial 205	com/tencent/mm/graphics/MMBitmapFactoryImpl:decodeFileWithStreamBySystemInternal	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   53: areturn
    //   54: aload_0
    //   55: aload_1
    //   56: invokespecial 209	com/tencent/mm/graphics/MMBitmapFactoryImpl:getStreamFromPath	(Ljava/lang/String;)Ljava/io/InputStream;
    //   59: invokestatic 213	com/tencent/mm/graphics/MMBitmapFactoryImpl:wrapUnResetableStreamOnDemand	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   62: astore 5
    //   64: aload 5
    //   66: astore_2
    //   67: aload 5
    //   69: invokestatic 216	com/tencent/mm/graphics/MMBitmapFactoryImpl:getCompatibleRewindBufferSize	()I
    //   72: invokevirtual 222	java/io/InputStream:mark	(I)V
    //   75: aload 5
    //   77: astore_2
    //   78: aload_0
    //   79: aload 5
    //   81: aconst_null
    //   82: aload 6
    //   84: invokespecial 225	com/tencent/mm/graphics/MMBitmapFactoryImpl:nativeDecodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   87: astore 7
    //   89: aload 5
    //   91: astore_2
    //   92: aload 6
    //   94: getfield 65	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   97: ifnull +125 -> 222
    //   100: goto +3 -> 103
    //   103: iload_3
    //   104: ifeq +43 -> 147
    //   107: aload 5
    //   109: astore_2
    //   110: aload_0
    //   111: aload 6
    //   113: aload 7
    //   115: iconst_0
    //   116: invokespecial 148	com/tencent/mm/graphics/MMBitmapFactoryImpl:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   119: aload 5
    //   121: astore_2
    //   122: aload 7
    //   124: aload 6
    //   126: invokestatic 155	com/tencent/mm/graphics/MMBitmapFactoryImpl:setDensityFromOptions	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)V
    //   129: aload 5
    //   131: astore_2
    //   132: aload 7
    //   134: aload 6
    //   136: invokestatic 159	com/tencent/mm/graphics/MMBitmapFactoryImpl:scaleBitmapOnDemand	(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore_1
    //   140: aload 5
    //   142: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   145: aload_1
    //   146: areturn
    //   147: aload 5
    //   149: astore_2
    //   150: ldc 14
    //   152: ldc 161
    //   154: invokestatic 141	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 5
    //   159: astore_2
    //   160: aload_0
    //   161: aload_1
    //   162: aload 6
    //   164: invokespecial 205	com/tencent/mm/graphics/MMBitmapFactoryImpl:decodeFileWithStreamBySystemInternal	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   167: astore_1
    //   168: aload 5
    //   170: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   173: aload_1
    //   174: areturn
    //   175: astore_1
    //   176: goto +40 -> 216
    //   179: astore_2
    //   180: aload 5
    //   182: astore_1
    //   183: aload_2
    //   184: astore 5
    //   186: goto +13 -> 199
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: goto +24 -> 216
    //   195: astore 5
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_1
    //   200: astore_2
    //   201: ldc 14
    //   203: aload 5
    //   205: ldc 163
    //   207: invokestatic 166	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   210: aload_1
    //   211: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   214: aconst_null
    //   215: areturn
    //   216: aload_2
    //   217: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   220: aload_1
    //   221: athrow
    //   222: iconst_0
    //   223: istore_3
    //   224: goto -121 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	MMBitmapFactoryImpl
    //   0	227	1	paramString	String
    //   0	227	2	paramOptions	BitmapFactory.Options
    //   25	199	3	i	int
    //   22	5	4	bool	boolean
    //   62	123	5	localObject	Object
    //   195	9	5	localThrowable	Throwable
    //   1	162	6	localOptions	BitmapFactory.Options
    //   87	46	7	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   67	75	175	finally
    //   78	89	175	finally
    //   92	100	175	finally
    //   110	119	175	finally
    //   122	129	175	finally
    //   132	140	175	finally
    //   150	157	175	finally
    //   160	168	175	finally
    //   201	210	175	finally
    //   67	75	179	java/lang/Throwable
    //   78	89	179	java/lang/Throwable
    //   92	100	179	java/lang/Throwable
    //   110	119	179	java/lang/Throwable
    //   122	129	179	java/lang/Throwable
    //   132	140	179	java/lang/Throwable
    //   150	157	179	java/lang/Throwable
    //   160	168	179	java/lang/Throwable
    //   54	64	189	finally
    //   54	64	195	java/lang/Throwable
  }
  
  /* Error */
  private Bitmap decodeFileWithStreamBySystemInternal(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/mm/graphics/MMBitmapFactoryImpl:mStreamProvider	Lcom/tencent/mm/graphics/MMBitmapFactory$b;
    //   4: ifnull +91 -> 95
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 209	com/tencent/mm/graphics/MMBitmapFactoryImpl:getStreamFromPath	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: invokestatic 213	com/tencent/mm/graphics/MMBitmapFactoryImpl:wrapUnResetableStreamOnDemand	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   15: astore_3
    //   16: aload_3
    //   17: astore_1
    //   18: aload_3
    //   19: invokestatic 216	com/tencent/mm/graphics/MMBitmapFactoryImpl:getCompatibleRewindBufferSize	()I
    //   22: invokevirtual 222	java/io/InputStream:mark	(I)V
    //   25: aload_3
    //   26: astore_1
    //   27: aload_3
    //   28: aconst_null
    //   29: aload_2
    //   30: invokestatic 228	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: astore 4
    //   35: aload_3
    //   36: astore_1
    //   37: aload_0
    //   38: aload_2
    //   39: aload 4
    //   41: iconst_1
    //   42: invokespecial 148	com/tencent/mm/graphics/MMBitmapFactoryImpl:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   45: aload_3
    //   46: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   49: aload 4
    //   51: areturn
    //   52: astore_2
    //   53: goto +36 -> 89
    //   56: astore_1
    //   57: aload_3
    //   58: astore_2
    //   59: aload_1
    //   60: astore_3
    //   61: goto +12 -> 73
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_1
    //   67: goto +22 -> 89
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: ldc 14
    //   77: aload_3
    //   78: ldc 230
    //   80: invokestatic 166	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   83: aload_2
    //   84: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   87: aconst_null
    //   88: areturn
    //   89: aload_1
    //   90: invokestatic 198	com/tencent/mm/graphics/MMBitmapFactoryImpl:closeQuietly	(Ljava/io/Closeable;)V
    //   93: aload_2
    //   94: athrow
    //   95: aload_1
    //   96: aload_2
    //   97: invokestatic 233	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   100: astore_1
    //   101: aload_0
    //   102: aload_2
    //   103: aload_1
    //   104: iconst_1
    //   105: invokespecial 148	com/tencent/mm/graphics/MMBitmapFactoryImpl:announceDecodeResult	(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap;Z)V
    //   108: aload_1
    //   109: areturn
    //   110: astore_1
    //   111: ldc 14
    //   113: aload_1
    //   114: ldc 230
    //   116: invokestatic 166	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   119: aconst_null
    //   120: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	MMBitmapFactoryImpl
    //   0	121	1	paramString	String
    //   0	121	2	paramOptions	BitmapFactory.Options
    //   15	46	3	localObject	Object
    //   70	8	3	localThrowable	Throwable
    //   33	17	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   18	25	52	finally
    //   27	35	52	finally
    //   37	45	52	finally
    //   75	83	52	finally
    //   18	25	56	java/lang/Throwable
    //   27	35	56	java/lang/Throwable
    //   37	45	56	java/lang/Throwable
    //   7	16	64	finally
    //   7	16	70	java/lang/Throwable
    //   95	108	110	java/lang/Throwable
  }
  
  private Bitmap decodeStreamInternal(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if ((paramInputStream instanceof AssetManager.AssetInputStream)) {
      b.b("MicroMsg.MMBitmapFactory", "[!] force decoding stream by system codec since it's asset stream.");
    }
    for (;;)
    {
      i = 1;
      break label58;
      if (!isForceSystemDecoder(localOptions)) {
        break;
      }
      b.b("MicroMsg.MMBitmapFactory", "[!] force decoding stream by system codec since specific options.");
    }
    int i = 0;
    label58:
    if (i != 0)
    {
      paramInputStream = BitmapFactory.decodeStream(paramInputStream, paramRect, localOptions);
      announceDecodeResult(localOptions, paramInputStream, true);
      return paramInputStream;
    }
    for (;;)
    {
      try
      {
        paramInputStream = wrapUnResetableStreamOnDemand(paramInputStream);
        paramInputStream.mark(getCompatibleRewindBufferSize());
        paramOptions = nativeDecodeStream(paramInputStream, paramRect, localOptions);
        if (localOptions.outMimeType != null)
        {
          i = 1;
          if (i != 0)
          {
            announceDecodeResult(localOptions, paramOptions, false);
            setDensityFromOptions(paramOptions, localOptions);
            return scaleBitmapOnDemand(paramOptions, localOptions);
          }
          b.b("MicroMsg.MMBitmapFactory", "[!] unsupported image format, try to decode with system codec.");
          paramInputStream.reset();
          paramInputStream.mark(getCompatibleRewindBufferSize());
          paramInputStream = BitmapFactory.decodeStream(paramInputStream, paramRect, localOptions);
          announceDecodeResult(localOptions, paramInputStream, true);
          return paramInputStream;
        }
      }
      catch (Throwable paramInputStream)
      {
        b.a("MicroMsg.MMBitmapFactory", paramInputStream, "decode failed.");
        return null;
      }
      i = 0;
    }
  }
  
  private static int getCompatibleRewindBufferSize()
  {
    if ("HUAWEI".equals(Build.MANUFACTURER)) {}
    return 8388608;
  }
  
  public static MMBitmapFactoryImpl getInstance()
  {
    return MMBitmapFactoryImpl.b.a;
  }
  
  private static byte[] getOrCreateStorageBuffer(BitmapFactory.Options paramOptions)
  {
    if (paramOptions != null) {
      paramOptions = paramOptions.inTempStorage;
    } else {
      paramOptions = null;
    }
    if (paramOptions != null) {
      return paramOptions;
    }
    return new byte[4096];
  }
  
  private InputStream getStreamFromPath(@NonNull String paramString)
  {
    MMBitmapFactory.b localb = this.mStreamProvider;
    if (localb != null)
    {
      paramString = localb.a(paramString);
      if (paramString != null) {
        return paramString;
      }
      throw new IllegalArgumentException("Injected stream provider returned null in getStreamFromPath.");
    }
    return new FileInputStream(paramString);
  }
  
  private boolean isForceSystemDecoder(BitmapFactory.Options paramOptions)
  {
    return (this.mForceUsingSystemDecoderOpt) || ((paramOptions != null) && (Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.HARDWARE.equals(paramOptions.inPreferredConfig)));
  }
  
  /* Error */
  private void loadNativeModule(String paramString)
  {
    // Byte code:
    //   0: getstatic 30	com/tencent/mm/graphics/MMBitmapFactoryImpl:sNativeLibraryLoader	[Lcom/tencent/mm/graphics/MMBitmapFactory$a;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: getstatic 30	com/tencent/mm/graphics/MMBitmapFactoryImpl:sNativeLibraryLoader	[Lcom/tencent/mm/graphics/MMBitmapFactory$a;
    //   9: iconst_0
    //   10: aaload
    //   11: ifnull +17 -> 28
    //   14: getstatic 30	com/tencent/mm/graphics/MMBitmapFactoryImpl:sNativeLibraryLoader	[Lcom/tencent/mm/graphics/MMBitmapFactory$a;
    //   17: iconst_0
    //   18: aaload
    //   19: aload_1
    //   20: invokeinterface 292 2 0
    //   25: goto +7 -> 32
    //   28: aload_1
    //   29: invokestatic 297	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   32: aload_2
    //   33: monitorexit
    //   34: ldc 14
    //   36: ldc_w 299
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 96	com/tencent/luggage/wxa/ry/b:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: return
    //   51: astore_3
    //   52: aload_2
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    //   56: astore_2
    //   57: ldc 14
    //   59: aload_2
    //   60: ldc_w 301
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: aastore
    //   71: invokestatic 304	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: new 306	java/lang/RuntimeException
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 309	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	MMBitmapFactoryImpl
    //   0	83	1	paramString	String
    //   56	23	2	localThrowable	Throwable
    //   51	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	25	51	finally
    //   28	32	51	finally
    //   32	34	51	finally
    //   52	54	51	finally
    //   0	6	56	java/lang/Throwable
    //   34	50	56	java/lang/Throwable
    //   54	56	56	java/lang/Throwable
  }
  
  private native void nativeAddExternalLibDir(String paramString);
  
  private native Bitmap nativeDecodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions);
  
  private native Bitmap nativeDecodeFileDescriptor(FileDescriptor paramFileDescriptor, byte[] paramArrayOfByte, Rect paramRect, BitmapFactory.Options paramOptions);
  
  private native Bitmap nativeDecodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions);
  
  private native boolean nativeIsSeekable(FileDescriptor paramFileDescriptor);
  
  private native int nativePinBitmap(Bitmap paramBitmap);
  
  private native int nativeUnPinBitmap(Bitmap paramBitmap);
  
  private static Bitmap scaleBitmapOnDemand(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (paramBitmap != null)
    {
      if (paramOptions == null) {
        return paramBitmap;
      }
      if (!paramOptions.inScaled) {
        return paramBitmap;
      }
      int i = paramOptions.inDensity;
      int j = paramOptions.inTargetDensity;
      int k = paramOptions.inScreenDensity;
      if ((i != 0) && (j != 0) && (i != k)) {
        f1 = j / i;
      } else {
        f1 = 1.0F;
      }
      if (f1 == 1.0F) {
        return paramBitmap;
      }
      i = (int)(paramBitmap.getWidth() * f1 + 0.5F);
      j = (int)(paramBitmap.getHeight() * f1 + 0.5F);
      float f1 = i / paramBitmap.getWidth();
      float f2 = j / paramBitmap.getHeight();
      b.d("MicroMsg.MMBitmapFactory", "[+] Bmp to scale: [sw: %s, sh: %s, dw: %s, dh: %s, scX: %s, scY: %s]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2) });
      paramOptions = new Matrix();
      paramOptions.setScale(f1, f2);
      paramOptions = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramOptions, true);
      if (paramOptions != paramBitmap) {
        paramBitmap.recycle();
      }
      return paramOptions;
    }
    return paramBitmap;
  }
  
  private static void setDensityFromOptions(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (paramBitmap != null)
    {
      if (paramOptions == null) {
        return;
      }
      int i = paramOptions.inDensity;
      if (i != 0)
      {
        paramBitmap.setDensity(i);
        int j = paramOptions.inTargetDensity;
        if ((j != 0) && (i != j))
        {
          if (i == paramOptions.inScreenDensity) {
            return;
          }
          byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
          if ((arrayOfByte != null) && (NinePatch.isNinePatchChunk(arrayOfByte))) {
            i = 1;
          } else {
            i = 0;
          }
          if ((!paramOptions.inScaled) && (i == 0)) {
            return;
          }
          paramBitmap.setDensity(j);
        }
      }
      else if (paramOptions.inBitmap != null)
      {
        paramBitmap.setDensity(160);
      }
    }
  }
  
  public static void setNativeLibraryLoader(@Nullable MMBitmapFactory.a parama)
  {
    synchronized (sNativeLibraryLoader)
    {
      sNativeLibraryLoader[0] = parama;
      return;
    }
  }
  
  private static InputStream wrapUnResetableStreamOnDemand(InputStream paramInputStream)
  {
    if (paramInputStream.markSupported()) {
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream)) {
      return new MMBitmapFactoryImpl.a((FileInputStream)paramInputStream);
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  public void addExternalCodecLibDir(String paramString)
  {
    b.c("MicroMsg.MMBitmapFactory", "[+] add external codec library path: %s", new Object[] { paramString });
    nativeAddExternalLibDir(paramString);
  }
  
  @Nullable
  public Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    assertNotNull(paramArrayOfByte, "'data' is null.");
    return decodeByteArrayInternal(paramArrayOfByte, paramInt1, paramInt2, null);
  }
  
  @Nullable
  public Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    assertNotNull(paramArrayOfByte, "'data' is null.");
    return decodeByteArrayInternal(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
  }
  
  @Nullable
  public Bitmap decodeFile(String paramString)
  {
    assertNotNull(paramString, "'pathName' is null.");
    return decodeFileInternal(paramString, null);
  }
  
  @Nullable
  public Bitmap decodeFile(String paramString, @Nullable BitmapFactory.Options paramOptions)
  {
    assertNotNull(paramString, "'pathName' is null.");
    return decodeFileInternal(paramString, paramOptions);
  }
  
  @Nullable
  public Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor)
  {
    assertNotNull(paramFileDescriptor, "'fd' is null.");
    return decodeFileDescriptorInternal(paramFileDescriptor, null, null);
  }
  
  @Nullable
  public Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor, @Nullable Rect paramRect, @Nullable BitmapFactory.Options paramOptions)
  {
    assertNotNull(paramFileDescriptor, "'fd' is null.");
    return decodeFileDescriptorInternal(paramFileDescriptor, paramRect, paramOptions);
  }
  
  @Nullable
  public Bitmap decodeResource(Resources paramResources, int paramInt)
  {
    b.d("MicroMsg.MMBitmapFactory", "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s", new Object[] { paramResources, Integer.valueOf(paramInt) });
    return BitmapFactory.decodeResource(paramResources, paramInt);
  }
  
  @Nullable
  public Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    b.d("MicroMsg.MMBitmapFactory", "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s, opts: %s", new Object[] { paramResources, Integer.valueOf(paramInt), paramOptions });
    return BitmapFactory.decodeResource(paramResources, paramInt, paramOptions);
  }
  
  @Nullable
  public Bitmap decodeResourceStream(@Nullable Resources paramResources, @Nullable TypedValue paramTypedValue, @Nullable InputStream paramInputStream, @Nullable Rect paramRect, @Nullable BitmapFactory.Options paramOptions)
  {
    b.d("MicroMsg.MMBitmapFactory", "[*] transfer invocation to BitmapFactory.decodeResourceStream, res: %s, value: %s, is: %s, pad: %s, opts: %s", new Object[] { paramResources, paramTypedValue, paramInputStream, paramRect, paramOptions });
    return BitmapFactory.decodeResourceStream(paramResources, paramTypedValue, paramInputStream, paramRect, paramOptions);
  }
  
  @Nullable
  public Bitmap decodeStream(InputStream paramInputStream)
  {
    assertNotNull(paramInputStream, "'is' is null.");
    return decodeStreamInternal(paramInputStream, null, null);
  }
  
  @Nullable
  public Bitmap decodeStream(InputStream paramInputStream, @Nullable Rect paramRect, @Nullable BitmapFactory.Options paramOptions)
  {
    assertNotNull(paramInputStream, "'is' is null.");
    return decodeStreamInternal(paramInputStream, paramRect, paramOptions);
  }
  
  public Bitmap pinBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      b.c("MicroMsg.MMBitmapFactory", "[tomys] Try to pin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", new Object[] { paramBitmap, Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), paramBitmap.getConfig(), Integer.valueOf(paramBitmap.getByteCount()) });
      int i = nativePinBitmap(paramBitmap);
      if (i < 0) {
        b.a("MicroMsg.MMBitmapFactory", "pinBitmap failed, ret: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    return paramBitmap;
  }
  
  public void setDecodeCanary(a parama)
  {
    this.mDecodeCanary = parama;
  }
  
  public void setForceUsingSystemDecoder(boolean paramBoolean)
  {
    b.b("MicroMsg.MMBitmapFactory", "[!] setForceUsingSystemDecoder, value: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mForceUsingSystemDecoderOpt = paramBoolean;
  }
  
  public void setStreamProvider(MMBitmapFactory.b paramb)
  {
    this.mStreamProvider = paramb;
  }
  
  public Bitmap unPinBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      b.c("MicroMsg.MMBitmapFactory", "[tomys] Try to unpin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", new Object[] { paramBitmap, Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), paramBitmap.getConfig(), Integer.valueOf(paramBitmap.getByteCount()) });
      int i = nativeUnPinBitmap(paramBitmap);
      if (i < 0) {
        b.a("MicroMsg.MMBitmapFactory", "unPinBitmap failed, ret: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.graphics.MMBitmapFactoryImpl
 * JD-Core Version:    0.7.0.1
 */