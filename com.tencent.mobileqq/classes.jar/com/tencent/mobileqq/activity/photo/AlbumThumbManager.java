package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.BytesBufferPool.BytesBuffer;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.cache.common.BlobCache;
import common.qzone.component.cache.common.BlobCache.LookupRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import wvz;

public class AlbumThumbManager
{
  private static final BytesBufferPool jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool = new BytesBufferPool(4, 204800);
  private static AlbumThumbManager jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
  private static ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private static wvz jdField_a_of_type_Wvz;
  Context jdField_a_of_type_AndroidContentContext;
  BlobCache jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  
  private AlbumThumbManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a(paramContext);
  }
  
  public static AlbumThumbManager a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager != null) {
      return jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager != null)
      {
        paramContext = jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
        return paramContext;
      }
    }
    finally {}
    paramContext = new AlbumThumbManager(paramContext);
    jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager = paramContext;
    return paramContext;
  }
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 50	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   21: getstatic 57	com/tencent/mobileqq/app/AppConstants:aN	Ljava/lang/String;
    //   24: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 63
    //   29: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 65
    //   34: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: new 71	java/io/File
    //   44: dup
    //   45: new 50	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   52: getstatic 57	com/tencent/mobileqq/app/AppConstants:aN	Ljava/lang/String;
    //   55: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 63
    //   60: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 78	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_2
    //   78: invokevirtual 81	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aload_0
    //   83: new 83	common/qzone/component/cache/common/BlobCache
    //   86: dup
    //   87: aload_1
    //   88: sipush 2500
    //   91: ldc 84
    //   93: iconst_0
    //   94: iconst_1
    //   95: invokespecial 87	common/qzone/component/cache/common/BlobCache:<init>	(Ljava/lang/String;IIZI)V
    //   98: putfield 48	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   101: goto -90 -> 11
    //   104: astore_1
    //   105: ldc 89
    //   107: iconst_2
    //   108: ldc 91
    //   110: aload_1
    //   111: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: goto -103 -> 11
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	AlbumThumbManager
    //   0	122	1	paramContext	Context
    //   69	9	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   41	82	104	java/lang/Exception
    //   82	101	104	java/lang/Exception
    //   2	7	117	finally
    //   14	41	117	finally
    //   41	82	117	finally
    //   82	101	117	finally
    //   105	114	117	finally
  }
  
  private boolean a(byte[] paramArrayOfByte, long paramLong, BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    if (paramArrayOfByte == null) {}
    BlobCache.LookupRequest localLookupRequest;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache != null) {
          break;
        }
        a(this.jdField_a_of_type_AndroidContentContext);
      } while (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache == null);
      try
      {
        localLookupRequest = new BlobCache.LookupRequest();
        localLookupRequest.jdField_a_of_type_Long = paramLong;
        localLookupRequest.jdField_a_of_type_ArrayOfByte = paramBytesBuffer.jdField_a_of_type_ArrayOfByte;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (!this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(localLookupRequest)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!a(paramArrayOfByte, localLookupRequest.jdField_a_of_type_ArrayOfByte));
    paramBytesBuffer.jdField_a_of_type_ArrayOfByte = localLookupRequest.jdField_a_of_type_ArrayOfByte;
    paramBytesBuffer.jdField_a_of_type_Int = paramArrayOfByte.length;
    paramBytesBuffer.b = (localLookupRequest.jdField_a_of_type_Int - paramBytesBuffer.jdField_a_of_type_Int);
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = paramArrayOfByte1.length;
    if (paramArrayOfByte2.length < j) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label34;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label34:
    return true;
  }
  
  private static byte[] a(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(65536);
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  /* Error */
  public Bitmap a(java.net.URL paramURL, com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder paramBitmapDecoder)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 158	java/net/URL:toString	()Ljava/lang/String;
    //   4: invokestatic 163	common/qzone/component/util/SecurityUtil:a	(Ljava/lang/String;)[B
    //   7: astore 9
    //   9: getstatic 23	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   12: invokevirtual 166	com/tencent/component/network/utils/BytesBufferPool:a	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   15: astore 7
    //   17: invokestatic 172	android/os/SystemClock:uptimeMillis	()J
    //   20: lstore_3
    //   21: aload 9
    //   23: invokestatic 175	common/qzone/component/util/SecurityUtil:a	([B)J
    //   26: lstore 5
    //   28: aload_0
    //   29: aload 9
    //   31: lload 5
    //   33: aload 7
    //   35: invokespecial 177	com/tencent/mobileqq/activity/photo/AlbumThumbManager:a	([BJLcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)Z
    //   38: ifne +263 -> 301
    //   41: aload_2
    //   42: aload_1
    //   43: invokeinterface 182 2 0
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +383 -> 433
    //   53: aload_2
    //   54: bipush 70
    //   56: invokestatic 184	com/tencent/mobileqq/activity/photo/AlbumThumbManager:a	(Landroid/graphics/Bitmap;I)[B
    //   59: astore 8
    //   61: aload 9
    //   63: arraylength
    //   64: aload 8
    //   66: arraylength
    //   67: iadd
    //   68: invokestatic 190	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   71: astore 10
    //   73: aload 10
    //   75: aload 9
    //   77: invokevirtual 194	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   80: pop
    //   81: aload 10
    //   83: aload 8
    //   85: invokevirtual 194	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   88: pop
    //   89: aload_0
    //   90: getfield 29	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   93: astore 9
    //   95: aload 9
    //   97: monitorenter
    //   98: aload_0
    //   99: getfield 48	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   102: lload 5
    //   104: aload 10
    //   106: invokevirtual 197	java/nio/ByteBuffer:array	()[B
    //   109: invokevirtual 200	common/qzone/component/cache/common/BlobCache:a	(J[B)V
    //   112: aload 9
    //   114: monitorexit
    //   115: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +76 -> 194
    //   121: aload_1
    //   122: invokevirtual 206	java/net/URL:getProtocol	()Ljava/lang/String;
    //   125: ldc 208
    //   127: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +64 -> 194
    //   133: ldc 89
    //   135: iconst_2
    //   136: new 50	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   143: ldc 216
    //   145: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: ldc 221
    //   154: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokestatic 172	android/os/SystemClock:uptimeMillis	()J
    //   160: lload_3
    //   161: lsub
    //   162: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   165: ldc 226
    //   167: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 8
    //   172: arraylength
    //   173: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc 231
    //   178: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_2
    //   182: invokevirtual 235	android/graphics/Bitmap:getByteCount	()I
    //   185: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: getstatic 23	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   197: aload 7
    //   199: invokevirtual 242	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   202: aload_2
    //   203: areturn
    //   204: astore 10
    //   206: ldc 89
    //   208: iconst_2
    //   209: ldc 244
    //   211: aload 10
    //   213: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: goto -104 -> 112
    //   219: astore_2
    //   220: aload 9
    //   222: monitorexit
    //   223: aload_2
    //   224: athrow
    //   225: astore_2
    //   226: ldc 89
    //   228: iconst_2
    //   229: ldc 246
    //   231: aload_2
    //   232: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   235: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +53 -> 291
    //   241: aload_1
    //   242: invokevirtual 206	java/net/URL:getProtocol	()Ljava/lang/String;
    //   245: ldc 208
    //   247: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq +41 -> 291
    //   253: ldc 89
    //   255: iconst_2
    //   256: new 50	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   263: ldc 248
    //   265: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_1
    //   269: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   272: ldc 221
    //   274: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokestatic 172	android/os/SystemClock:uptimeMillis	()J
    //   280: lload_3
    //   281: lsub
    //   282: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   285: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: getstatic 23	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   294: aload 7
    //   296: invokevirtual 242	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   299: aconst_null
    //   300: areturn
    //   301: new 250	android/graphics/BitmapFactory$Options
    //   304: dup
    //   305: invokespecial 251	android/graphics/BitmapFactory$Options:<init>	()V
    //   308: astore_2
    //   309: aload_2
    //   310: getstatic 257	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   313: putfield 260	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   316: aload_2
    //   317: iconst_1
    //   318: putfield 263	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   321: aload 7
    //   323: getfield 111	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:jdField_a_of_type_ArrayOfByte	[B
    //   326: aload 7
    //   328: getfield 123	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:jdField_a_of_type_Int	I
    //   331: aload 7
    //   333: getfield 127	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:b	I
    //   336: aload_2
    //   337: invokestatic 269	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   340: astore_2
    //   341: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +79 -> 423
    //   347: aload_1
    //   348: invokevirtual 206	java/net/URL:getProtocol	()Ljava/lang/String;
    //   351: ldc 208
    //   353: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   356: ifeq +67 -> 423
    //   359: ldc 89
    //   361: iconst_2
    //   362: new 50	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 271
    //   372: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_1
    //   376: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   379: ldc 221
    //   381: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokestatic 172	android/os/SystemClock:uptimeMillis	()J
    //   387: lload_3
    //   388: lsub
    //   389: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   392: ldc 226
    //   394: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 7
    //   399: getfield 127	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:b	I
    //   402: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: ldc 231
    //   407: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_2
    //   411: invokevirtual 235	android/graphics/Bitmap:getByteCount	()I
    //   414: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: getstatic 23	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   426: aload 7
    //   428: invokevirtual 242	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   431: aload_2
    //   432: areturn
    //   433: getstatic 23	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   436: aload 7
    //   438: invokevirtual 242	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   441: goto -142 -> 299
    //   444: astore_2
    //   445: ldc 89
    //   447: iconst_2
    //   448: ldc 246
    //   450: aload_2
    //   451: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   454: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +54 -> 511
    //   460: aload_1
    //   461: invokevirtual 206	java/net/URL:getProtocol	()Ljava/lang/String;
    //   464: ldc 208
    //   466: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   469: ifeq +42 -> 511
    //   472: ldc 89
    //   474: iconst_2
    //   475: new 50	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 273
    //   485: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_1
    //   489: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   492: ldc 221
    //   494: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokestatic 172	android/os/SystemClock:uptimeMillis	()J
    //   500: lload_3
    //   501: lsub
    //   502: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   505: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: getstatic 23	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   514: aload 7
    //   516: invokevirtual 242	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   519: goto -220 -> 299
    //   522: astore_1
    //   523: getstatic 23	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   526: aload 7
    //   528: invokevirtual 242	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   531: aload_1
    //   532: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	AlbumThumbManager
    //   0	533	1	paramURL	java.net.URL
    //   0	533	2	paramBitmapDecoder	com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
    //   20	481	3	l1	long
    //   26	77	5	l2	long
    //   15	512	7	localBytesBuffer	BytesBufferPool.BytesBuffer
    //   59	112	8	arrayOfByte	byte[]
    //   71	34	10	localByteBuffer	ByteBuffer
    //   204	8	10	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   98	112	204	java/io/IOException
    //   98	112	219	finally
    //   112	115	219	finally
    //   206	216	219	finally
    //   220	223	219	finally
    //   28	49	225	java/lang/OutOfMemoryError
    //   53	98	225	java/lang/OutOfMemoryError
    //   115	194	225	java/lang/OutOfMemoryError
    //   223	225	225	java/lang/OutOfMemoryError
    //   301	423	225	java/lang/OutOfMemoryError
    //   28	49	444	java/lang/Throwable
    //   53	98	444	java/lang/Throwable
    //   115	194	444	java/lang/Throwable
    //   223	225	444	java/lang/Throwable
    //   301	423	444	java/lang/Throwable
    //   28	49	522	finally
    //   53	98	522	finally
    //   115	194	522	finally
    //   223	225	522	finally
    //   226	291	522	finally
    //   301	423	522	finally
    //   445	511	522	finally
  }
  
  public void a()
  {
    try
    {
      jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.a();
      jdField_a_of_type_Wvz = null;
      jdField_a_of_type_JavaNioByteBuffer = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumThumbManager
 * JD-Core Version:    0.7.0.1
 */