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
  static final String SDCARD_BOLB_PATH;
  static final String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  public static final String TAG = "QQAlbum";
  private static final int byteKeyLength = 16;
  private static final BytesBufferPool sCacheBufferPool = new BytesBufferPool(4, 204800);
  private static AlbumThumbManager sInstance;
  private static AlbumThumbManager.TempBuffer tempBuffer;
  private static ByteBuffer tempByteBuffer;
  private boolean isThumbKeyUseSize = false;
  BlobCache mBlobCache;
  private final Object mBlobLock = new Object();
  Context mContext;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SDCARD_ROOT);
    localStringBuilder.append("/Tencent/blob/");
    SDCARD_BOLB_PATH = localStringBuilder.toString();
  }
  
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
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
    if (paramDownloadParams == null)
    {
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
    }
    else
    {
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      SafeBitmapFactory.decodeByteArray(paramBytesBuffer.data, paramBytesBuffer.offset, paramBytesBuffer.length, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = URLState.calculateInSampleSize((BitmapFactory.Options)localObject, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight);
    }
    paramDownloadParams = SafeBitmapFactory.decodeByteArray(paramBytesBuffer.data, paramBytesBuffer.offset, paramBytesBuffer.length, (BitmapFactory.Options)localObject);
    if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getThumb bitmap from decode,url:");
      ((StringBuilder)localObject).append(paramURL);
      ((StringBuilder)localObject).append(" cost:");
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - paramLong);
      ((StringBuilder)localObject).append(" sizeDisk:");
      ((StringBuilder)localObject).append(paramBytesBuffer.length);
      ((StringBuilder)localObject).append(" sizeMemory:");
      ((StringBuilder)localObject).append(paramDownloadParams.getByteCount());
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    return paramDownloadParams;
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
      try
      {
        synchronized (this.mBlobLock)
        {
          this.mBlobCache.a(paramLong2, localByteBuffer.array());
        }
      }
      catch (IOException localIOException)
      {
        QLog.e("AlbumThumbManager", 2, "decode thumb ioexception", localIOException);
        if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb")))
        {
          ??? = new StringBuilder();
          ???.append("getThumb bitmap from cache,url:");
          ???.append(paramURL);
          ???.append(" cost:");
          ???.append(SystemClock.uptimeMillis() - paramLong1);
          ???.append(" sizeDisk:");
          ???.append(arrayOfByte.length);
          ???.append(" sizeMemory:");
          ???.append(paramBitmapDecoder.getByteCount());
          QLog.d("QQAlbum", 2, ???.toString());
        }
        return paramBitmapDecoder;
      }
      throw paramURL;
    }
    return null;
  }
  
  private boolean getCacheData(byte[] paramArrayOfByte, long paramLong, BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    if (this.mBlobCache == null)
    {
      retrieveBlobCache(this.mContext);
      if (this.mBlobCache == null) {
        return false;
      }
    }
    try
    {
      BlobCache.LookupRequest localLookupRequest = new BlobCache.LookupRequest();
      localLookupRequest.a = paramLong;
      localLookupRequest.b = paramBytesBuffer.data;
      synchronized (this.mBlobLock)
      {
        if (!this.mBlobCache.a(localLookupRequest)) {
          return false;
        }
        if (isSameKey(paramArrayOfByte, localLookupRequest.b))
        {
          paramBytesBuffer.data = localLookupRequest.b;
          paramBytesBuffer.offset = paramArrayOfByte.length;
          paramBytesBuffer.length = (localLookupRequest.c - paramBytesBuffer.offset);
          return true;
        }
      }
      return false;
    }
    catch (IOException paramArrayOfByte)
    {
      QLog.e("QQAlbum", 2, "getCacheData ioexception", paramArrayOfByte);
    }
  }
  
  private boolean getCacheData(byte[] paramArrayOfByte, long paramLong, AlbumThumbManager.TempBuffer paramTempBuffer)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    if (this.mBlobCache == null)
    {
      retrieveBlobCache(this.mContext);
      if (this.mBlobCache == null) {
        return false;
      }
    }
    try
    {
      BlobCache.LookupRequest localLookupRequest = new BlobCache.LookupRequest();
      localLookupRequest.a = paramLong;
      localLookupRequest.b = paramTempBuffer.data;
      synchronized (this.mBlobLock)
      {
        if (!this.mBlobCache.a(localLookupRequest)) {
          return false;
        }
        if (isSameKey(paramArrayOfByte, localLookupRequest.b, localLookupRequest.c - 16, 16))
        {
          paramTempBuffer.data = localLookupRequest.b;
          paramTempBuffer.offset = 0;
          paramTempBuffer.length = (localLookupRequest.c - 16);
          return true;
        }
      }
      return false;
    }
    catch (IOException paramArrayOfByte)
    {
      QLog.e("QQAlbum", 2, "getCacheData ioexception", paramArrayOfByte);
    }
  }
  
  public static AlbumThumbManager getInstance(Context paramContext)
  {
    AlbumThumbManager localAlbumThumbManager = sInstance;
    if (localAlbumThumbManager != null) {
      return localAlbumThumbManager;
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
    boolean bool = this.isThumbKeyUseSize;
    Object localObject = "";
    if (bool)
    {
      if ((paramDownloadParams != null) && ((paramDownloadParams.tag instanceof LocalMediaInfo)))
      {
        paramDownloadParams = (LocalMediaInfo)paramDownloadParams.tag;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramDownloadParams.modifiedDate);
        paramDownloadParams = ((StringBuilder)localObject).toString();
      }
      else
      {
        paramDownloadParams = "";
      }
      if ((!paramDownloadParams.equals("")) && (!paramDownloadParams.equals("0")))
      {
        localObject = paramDownloadParams;
      }
      else
      {
        paramDownloadParams = new File(paramURL.getPath());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramDownloadParams.length());
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramDownloadParams = new StringBuilder();
    paramDownloadParams.append(paramURL.toString());
    paramDownloadParams.append((String)localObject);
    return SecurityUtil.b(paramDownloadParams.toString());
  }
  
  private static boolean isSameKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = paramArrayOfByte1.length;
    if (paramArrayOfByte2.length < j) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean isSameKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte1.length < paramInt2) {
      return false;
    }
    if (paramArrayOfByte2.length < paramInt1 + paramInt2) {
      return false;
    }
    int i = 0;
    while (i < paramInt2)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[(paramInt1 + i)]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void retrieveBlobCache(Context paramContext)
  {
    try
    {
      paramContext = this.mBlobCache;
      if (paramContext != null) {
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append(SDCARD_BOLB_PATH);
      paramContext.append("mqq");
      paramContext.append("/atb");
      paramContext = paramContext.toString();
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(SDCARD_BOLB_PATH);
        ((StringBuilder)localObject).append("mqq");
        localObject = new File(((StringBuilder)localObject).toString());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        this.mBlobCache = new BlobCache(paramContext, 2500, 52428800, false, 1);
      }
      catch (Exception paramContext)
      {
        QLog.e("QQAlbum", 2, "init blobcache", paramContext);
      }
      return;
    }
    finally {}
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
  
  /* Error */
  public Bitmap getThumb(URL paramURL, BitmapDecoder paramBitmapDecoder, DownloadParams paramDownloadParams)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_3
    //   3: invokespecial 382	com/tencent/mobileqq/activity/photo/AlbumThumbManager:getKey	(Ljava/net/URL;Lcom/tencent/image/DownloadParams;)[B
    //   6: astore 10
    //   8: getstatic 87	com/tencent/mobileqq/activity/photo/AlbumThumbManager:sCacheBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   11: invokevirtual 386	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   14: astore 9
    //   16: invokestatic 213	android/os/SystemClock:uptimeMillis	()J
    //   19: lstore 4
    //   21: aload 10
    //   23: invokestatic 389	common/qzone/component/util/SecurityUtil:a	([B)J
    //   26: lstore 6
    //   28: aload_0
    //   29: aload 10
    //   31: lload 6
    //   33: aload 9
    //   35: invokespecial 391	com/tencent/mobileqq/activity/photo/AlbumThumbManager:getCacheData	([BJLcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)Z
    //   38: istore 8
    //   40: iload 8
    //   42: ifne +43 -> 85
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: aload 10
    //   50: lload 4
    //   52: lload 6
    //   54: invokespecial 393	com/tencent/mobileqq/activity/photo/AlbumThumbManager:createBitMapFromUrl	(Ljava/net/URL;Lcom/tencent/mobileqq/transfile/bitmapcreator/BitmapDecoder;[BJJ)Landroid/graphics/Bitmap;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull +15 -> 74
    //   62: aload_2
    //   63: astore_1
    //   64: getstatic 87	com/tencent/mobileqq/activity/photo/AlbumThumbManager:sCacheBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   67: aload 9
    //   69: invokevirtual 397	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   72: aload_1
    //   73: areturn
    //   74: getstatic 87	com/tencent/mobileqq/activity/photo/AlbumThumbManager:sCacheBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   77: aload 9
    //   79: invokevirtual 397	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   82: goto +194 -> 276
    //   85: aload_0
    //   86: aload_1
    //   87: aload_3
    //   88: aload 9
    //   90: lload 4
    //   92: invokespecial 399	com/tencent/mobileqq/activity/photo/AlbumThumbManager:createBitMapFromCache	(Ljava/net/URL;Lcom/tencent/image/DownloadParams;Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;J)Landroid/graphics/Bitmap;
    //   95: astore_2
    //   96: aload_2
    //   97: astore_1
    //   98: goto -34 -> 64
    //   101: astore_2
    //   102: goto +12 -> 114
    //   105: astore_2
    //   106: goto +89 -> 195
    //   109: astore_1
    //   110: goto +168 -> 278
    //   113: astore_2
    //   114: ldc 30
    //   116: iconst_2
    //   117: ldc_w 401
    //   120: aload_2
    //   121: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -53 -> 74
    //   130: aload_1
    //   131: invokevirtual 192	java/net/URL:getProtocol	()Ljava/lang/String;
    //   134: ldc 194
    //   136: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifeq -65 -> 74
    //   142: new 66	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   149: astore_2
    //   150: aload_2
    //   151: ldc_w 403
    //   154: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_2
    //   159: aload_1
    //   160: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: ldc 207
    //   167: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_2
    //   172: invokestatic 213	android/os/SystemClock:uptimeMillis	()J
    //   175: lload 4
    //   177: lsub
    //   178: invokevirtual 216	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: ldc 30
    //   184: iconst_2
    //   185: aload_2
    //   186: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: goto -118 -> 74
    //   195: ldc 30
    //   197: iconst_2
    //   198: ldc_w 401
    //   201: aload_2
    //   202: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq -134 -> 74
    //   211: aload_1
    //   212: invokevirtual 192	java/net/URL:getProtocol	()Ljava/lang/String;
    //   215: ldc 194
    //   217: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   220: ifeq -146 -> 74
    //   223: new 66	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   230: astore_2
    //   231: aload_2
    //   232: ldc_w 405
    //   235: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_2
    //   240: aload_1
    //   241: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_2
    //   246: ldc 207
    //   248: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_2
    //   253: invokestatic 213	android/os/SystemClock:uptimeMillis	()J
    //   256: lload 4
    //   258: lsub
    //   259: invokevirtual 216	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 30
    //   265: iconst_2
    //   266: aload_2
    //   267: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: goto -199 -> 74
    //   276: aconst_null
    //   277: areturn
    //   278: getstatic 87	com/tencent/mobileqq/activity/photo/AlbumThumbManager:sCacheBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   281: aload 9
    //   283: invokevirtual 397	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   286: goto +5 -> 291
    //   289: aload_1
    //   290: athrow
    //   291: goto -2 -> 289
    //   294: astore_2
    //   295: goto -100 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	AlbumThumbManager
    //   0	298	1	paramURL	URL
    //   0	298	2	paramBitmapDecoder	BitmapDecoder
    //   0	298	3	paramDownloadParams	DownloadParams
    //   19	238	4	l1	long
    //   26	27	6	l2	long
    //   38	3	8	bool	boolean
    //   14	268	9	localBytesBuffer	BytesBufferPool.BytesBuffer
    //   6	43	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   45	58	101	java/lang/Throwable
    //   85	96	101	java/lang/Throwable
    //   45	58	105	java/lang/OutOfMemoryError
    //   85	96	105	java/lang/OutOfMemoryError
    //   28	40	109	finally
    //   45	58	109	finally
    //   85	96	109	finally
    //   114	192	109	finally
    //   195	273	109	finally
    //   28	40	113	java/lang/Throwable
    //   28	40	294	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumThumbManager
 * JD-Core Version:    0.7.0.1
 */