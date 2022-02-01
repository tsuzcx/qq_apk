package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.BytesBufferPool.BytesBuffer;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLState;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.cache.common.BlobCache;
import common.qzone.component.cache.common.BlobCache.LookupRequest;
import common.qzone.component.util.SecurityUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;

public class AlbumThumbManager
{
  private static final int BLOB_CACHE_MAX_BYTES = 52428800;
  private static final int BLOB_CACHE_MAX_ENTRIES = 2500;
  private static final int BLOB_CACHE_VERSION = 1;
  private static final int BYTESBUFFER_POOL_SIZE = 4;
  private static final int BYTESBUFFER_SIZE = 204800;
  private static final int BYTESBUFFER_SIZE_NEW = 102400;
  private static final int DEFAULT_JPEG_QUALITY = 70;
  private static final int MEGABYTE = 1048576;
  static final String PATH_MOBILEQQ_CACHE = "mqq";
  static final String SDCARD_BOLB_PATH = SDCARD_ROOT + "/Tencent/blob/";
  static final String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  public static final String TAG = "AlbumThumbManager";
  private static final int byteKeyLength = 16;
  private static final BytesBufferPool sCacheBufferPool = new BytesBufferPool(4, 204800);
  private static AlbumThumbManager sInstance;
  private static AlbumThumbManager.TempBuffer tempBuffer;
  private static ByteBuffer tempByteBuffer;
  private boolean isThumbKeyUseSize = false;
  BlobCache mBlobCache;
  private final Object mBlobLock = new Object();
  Context mContext;
  
  private AlbumThumbManager(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    retrieveBlobCache(paramContext);
  }
  
  private static byte[] compressToJPEG(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(65536);
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private Bitmap createBitMapFromCache(URL paramURL, DownloadParams paramDownloadParams, BytesBufferPool.BytesBuffer paramBytesBuffer, long paramLong)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    if (paramDownloadParams == null) {}
    for (localOptions.inSampleSize = 1;; localOptions.inSampleSize = URLState.calculateInSampleSize(localOptions, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight))
    {
      paramDownloadParams = SafeBitmapFactory.decodeByteArray(paramBytesBuffer.data, paramBytesBuffer.offset, paramBytesBuffer.length, localOptions);
      if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
        QLog.d("AlbumThumbManager", 2, "getThumb bitmap from decode,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - paramLong) + " sizeDisk:" + paramBytesBuffer.length + " sizeMemory:" + paramDownloadParams.getByteCount());
      }
      return paramDownloadParams;
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeByteArray(paramBytesBuffer.data, paramBytesBuffer.offset, paramBytesBuffer.length, localOptions);
      localOptions.inJustDecodeBounds = false;
    }
  }
  
  private Bitmap createBitMapFromUrl(URL paramURL, BitmapDecoder paramBitmapDecoder, byte[] arg3, long paramLong1, long paramLong2)
  {
    paramBitmapDecoder = paramBitmapDecoder.getBitmap(paramURL);
    if (paramBitmapDecoder != null)
    {
      byte[] arrayOfByte = compressToJPEG(paramBitmapDecoder, 70);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(???.length + arrayOfByte.length);
      localByteBuffer.put(???);
      localByteBuffer.put(arrayOfByte);
      synchronized (this.mBlobLock)
      {
        try
        {
          this.mBlobCache.a(paramLong2, localByteBuffer.array());
          if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
            QLog.d("AlbumThumbManager", 2, "getThumb bitmap from cache,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - paramLong1) + " sizeDisk:" + arrayOfByte.length + " sizeMemory:" + paramBitmapDecoder.getByteCount());
          }
          return paramBitmapDecoder;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            QLog.e("AlbumThumbManager", 2, "decode thumb ioexception", localIOException);
          }
        }
      }
    }
    return null;
  }
  
  private boolean getCacheData(byte[] paramArrayOfByte, long paramLong, BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    if (paramArrayOfByte == null) {}
    BlobCache.LookupRequest localLookupRequest;
    do
    {
      do
      {
        return false;
        if (this.mBlobCache != null) {
          break;
        }
        retrieveBlobCache(this.mContext);
      } while (this.mBlobCache == null);
      try
      {
        localLookupRequest = new BlobCache.LookupRequest();
        localLookupRequest.jdField_a_of_type_Long = paramLong;
        localLookupRequest.jdField_a_of_type_ArrayOfByte = paramBytesBuffer.data;
        synchronized (this.mBlobLock)
        {
          if (!this.mBlobCache.a(localLookupRequest)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!isSameKey(paramArrayOfByte, localLookupRequest.jdField_a_of_type_ArrayOfByte));
    paramBytesBuffer.data = localLookupRequest.jdField_a_of_type_ArrayOfByte;
    paramBytesBuffer.offset = paramArrayOfByte.length;
    paramBytesBuffer.length = (localLookupRequest.jdField_a_of_type_Int - paramBytesBuffer.offset);
    return true;
  }
  
  private boolean getCacheData(byte[] paramArrayOfByte, long paramLong, AlbumThumbManager.TempBuffer paramTempBuffer)
  {
    if (paramArrayOfByte == null) {}
    BlobCache.LookupRequest localLookupRequest;
    do
    {
      do
      {
        return false;
        if (this.mBlobCache != null) {
          break;
        }
        retrieveBlobCache(this.mContext);
      } while (this.mBlobCache == null);
      try
      {
        localLookupRequest = new BlobCache.LookupRequest();
        localLookupRequest.jdField_a_of_type_Long = paramLong;
        localLookupRequest.jdField_a_of_type_ArrayOfByte = paramTempBuffer.data;
        synchronized (this.mBlobLock)
        {
          if (!this.mBlobCache.a(localLookupRequest)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!isSameKey(paramArrayOfByte, localLookupRequest.jdField_a_of_type_ArrayOfByte, localLookupRequest.jdField_a_of_type_Int - 16, 16));
    paramTempBuffer.data = localLookupRequest.jdField_a_of_type_ArrayOfByte;
    paramTempBuffer.offset = 0;
    paramTempBuffer.length = (localLookupRequest.jdField_a_of_type_Int - 16);
    return true;
  }
  
  public static AlbumThumbManager getInstance(Context paramContext)
  {
    if (sInstance != null) {
      return sInstance;
    }
    try
    {
      if (sInstance == null)
      {
        sInstance = new AlbumThumbManager(paramContext);
        if (Build.BRAND.equals("Sony")) {
          sInstance.isThumbKeyUseSize = true;
        }
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private byte[] getKey(URL paramURL, DownloadParams paramDownloadParams)
  {
    if (this.isThumbKeyUseSize) {
      if ((paramDownloadParams != null) && ((paramDownloadParams.tag instanceof LocalMediaInfo)))
      {
        paramDownloadParams = (LocalMediaInfo)paramDownloadParams.tag;
        paramDownloadParams = "" + paramDownloadParams.modifiedDate;
        if (!paramDownloadParams.equals(""))
        {
          localObject = paramDownloadParams;
          if (!paramDownloadParams.equals("0")) {}
        }
        else
        {
          paramDownloadParams = new File(paramURL.getPath());
        }
      }
    }
    for (Object localObject = "" + paramDownloadParams.length();; localObject = "")
    {
      return SecurityUtil.a(paramURL.toString() + (String)localObject);
      paramDownloadParams = "";
      break;
    }
  }
  
  private static boolean isSameKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
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
  
  private static boolean isSameKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte1.length < paramInt2) {}
    while (paramArrayOfByte2.length < paramInt1 + paramInt2) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2) {
        break label47;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[(paramInt1 + i)]) {
        break;
      }
      i += 1;
    }
    label47:
    return true;
  }
  
  /* Error */
  private void retrieveBlobCache(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 255	com/tencent/mobileqq/activity/photo/AlbumThumbManager:mBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 66	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   21: getstatic 80	com/tencent/mobileqq/activity/photo/AlbumThumbManager:SDCARD_BOLB_PATH	Ljava/lang/String;
    //   24: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 25
    //   29: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 347
    //   35: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore_1
    //   42: new 58	java/io/File
    //   45: dup
    //   46: new 66	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   53: getstatic 80	com/tencent/mobileqq/activity/photo/AlbumThumbManager:SDCARD_BOLB_PATH	Ljava/lang/String;
    //   56: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 25
    //   61: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 335	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore_2
    //   71: aload_2
    //   72: invokevirtual 350	java/io/File:exists	()Z
    //   75: ifne +8 -> 83
    //   78: aload_2
    //   79: invokevirtual 353	java/io/File:mkdirs	()Z
    //   82: pop
    //   83: aload_0
    //   84: new 260	common/qzone/component/cache/common/BlobCache
    //   87: dup
    //   88: aload_1
    //   89: sipush 2500
    //   92: ldc 7
    //   94: iconst_0
    //   95: iconst_1
    //   96: invokespecial 356	common/qzone/component/cache/common/BlobCache:<init>	(Ljava/lang/String;IIZI)V
    //   99: putfield 255	com/tencent/mobileqq/activity/photo/AlbumThumbManager:mBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   102: goto -91 -> 11
    //   105: astore_1
    //   106: ldc 30
    //   108: iconst_2
    //   109: ldc_w 358
    //   112: aload_1
    //   113: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   116: goto -105 -> 11
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	AlbumThumbManager
    //   0	124	1	paramContext	Context
    //   70	9	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   42	83	105	java/lang/Exception
    //   83	102	105	java/lang/Exception
    //   2	7	119	finally
    //   14	42	119	finally
    //   42	83	119	finally
    //   83	102	119	finally
    //   106	116	119	finally
  }
  
  public void clear()
  {
    try
    {
      sCacheBufferPool.clear();
      tempBuffer = null;
      tempByteBuffer = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public byte[] copyOf(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = 0;
    while (paramInt < paramArrayOfByte.length)
    {
      arrayOfByte[paramInt] = paramArrayOfByte[paramInt];
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  public Bitmap getThumb(URL paramURL, BitmapDecoder paramBitmapDecoder)
  {
    return getThumb(paramURL, paramBitmapDecoder, null);
  }
  
  public Bitmap getThumb(URL paramURL, BitmapDecoder paramBitmapDecoder, DownloadParams paramDownloadParams)
  {
    byte[] arrayOfByte = getKey(paramURL, paramDownloadParams);
    localBytesBuffer = sCacheBufferPool.get();
    l1 = SystemClock.uptimeMillis();
    long l2 = SecurityUtil.a(arrayOfByte);
    try
    {
      if (!getCacheData(arrayOfByte, l2, localBytesBuffer))
      {
        paramBitmapDecoder = createBitMapFromUrl(paramURL, paramBitmapDecoder, arrayOfByte, l1, l2);
        if (paramBitmapDecoder != null) {
          return paramBitmapDecoder;
        }
      }
      else
      {
        paramBitmapDecoder = createBitMapFromCache(paramURL, paramDownloadParams, localBytesBuffer, l1);
        return paramBitmapDecoder;
      }
    }
    catch (OutOfMemoryError paramBitmapDecoder)
    {
      for (;;)
      {
        QLog.e("AlbumThumbManager", 2, "decode thumb", paramBitmapDecoder);
        if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
          QLog.d("AlbumThumbManager", 2, "getThumb bitmap OutOfMemoryError,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - l1));
        }
        sCacheBufferPool.recycle(localBytesBuffer);
      }
    }
    catch (Throwable paramBitmapDecoder)
    {
      for (;;)
      {
        QLog.e("AlbumThumbManager", 2, "decode thumb", paramBitmapDecoder);
        if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
          QLog.d("AlbumThumbManager", 2, "getThumb bitmap Throwable,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - l1));
        }
        sCacheBufferPool.recycle(localBytesBuffer);
      }
    }
    finally
    {
      sCacheBufferPool.recycle(localBytesBuffer);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumThumbManager
 * JD-Core Version:    0.7.0.1
 */