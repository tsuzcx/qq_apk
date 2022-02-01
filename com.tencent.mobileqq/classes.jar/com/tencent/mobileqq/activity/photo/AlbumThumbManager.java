package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import bked;
import bkee;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.BytesBufferPool.BytesBuffer;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLState;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
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
  static final String SDCARD_ROOT;
  public static final String TAG = "AlbumThumbManager";
  private static final int byteKeyLength = 16;
  private static final BytesBufferPool sCacheBufferPool = new BytesBufferPool(4, 204800);
  private static AlbumThumbManager sInstance;
  private static AlbumThumbManager.TempBuffer tempBuffer;
  private static ByteBuffer tempByteBuffer;
  private boolean isThumbKeyUseSize = false;
  bked mBlobCache;
  private final Object mBlobLock = new Object();
  Context mContext;
  
  static
  {
    SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
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
  
  private boolean getCacheData(byte[] paramArrayOfByte, long paramLong, BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    if (paramArrayOfByte == null) {}
    bkee localbkee;
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
        localbkee = new bkee();
        localbkee.jdField_a_of_type_Long = paramLong;
        localbkee.jdField_a_of_type_ArrayOfByte = paramBytesBuffer.data;
        synchronized (this.mBlobLock)
        {
          if (!this.mBlobCache.a(localbkee)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!isSameKey(paramArrayOfByte, localbkee.jdField_a_of_type_ArrayOfByte));
    paramBytesBuffer.data = localbkee.jdField_a_of_type_ArrayOfByte;
    paramBytesBuffer.offset = paramArrayOfByte.length;
    paramBytesBuffer.length = (localbkee.jdField_a_of_type_Int - paramBytesBuffer.offset);
    return true;
  }
  
  private boolean getCacheData(byte[] paramArrayOfByte, long paramLong, AlbumThumbManager.TempBuffer paramTempBuffer)
  {
    if (paramArrayOfByte == null) {}
    bkee localbkee;
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
        localbkee = new bkee();
        localbkee.jdField_a_of_type_Long = paramLong;
        localbkee.jdField_a_of_type_ArrayOfByte = paramTempBuffer.data;
        synchronized (this.mBlobLock)
        {
          if (!this.mBlobCache.a(localbkee)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!isSameKey(paramArrayOfByte, localbkee.jdField_a_of_type_ArrayOfByte, localbkee.jdField_a_of_type_Int - 16, 16));
    paramTempBuffer.data = localbkee.jdField_a_of_type_ArrayOfByte;
    paramTempBuffer.offset = 0;
    paramTempBuffer.length = (localbkee.jdField_a_of_type_Int - 16);
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
    //   3: getfield 135	com/tencent/mobileqq/activity/photo/AlbumThumbManager:mBlobCache	Lbked;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 74	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   21: getstatic 87	com/tencent/mobileqq/activity/photo/AlbumThumbManager:SDCARD_BOLB_PATH	Ljava/lang/String;
    //   24: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 25
    //   29: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 207
    //   34: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: new 66	java/io/File
    //   44: dup
    //   45: new 74	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   52: getstatic 87	com/tencent/mobileqq/activity/photo/AlbumThumbManager:SDCARD_BOLB_PATH	Ljava/lang/String;
    //   55: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 25
    //   60: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 210	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 214	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_2
    //   78: invokevirtual 217	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aload_0
    //   83: new 152	bked
    //   86: dup
    //   87: aload_1
    //   88: sipush 2500
    //   91: ldc 7
    //   93: iconst_0
    //   94: iconst_1
    //   95: invokespecial 220	bked:<init>	(Ljava/lang/String;IIZI)V
    //   98: putfield 135	com/tencent/mobileqq/activity/photo/AlbumThumbManager:mBlobCache	Lbked;
    //   101: goto -90 -> 11
    //   104: astore_1
    //   105: ldc 30
    //   107: iconst_2
    //   108: ldc 222
    //   110: aload_1
    //   111: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   69	9	2	localFile	File
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
    Object localObject1;
    if (this.isThumbKeyUseSize) {
      if ((paramDownloadParams != null) && ((paramDownloadParams.tag instanceof LocalMediaInfo)))
      {
        localObject1 = (LocalMediaInfo)paramDownloadParams.tag;
        localObject1 = "" + ((LocalMediaInfo)localObject1).modifiedDate;
        if (!((String)localObject1).equals(""))
        {
          ??? = localObject1;
          if (!((String)localObject1).equals("0")) {}
        }
        else
        {
          localObject1 = new File(paramURL.getPath());
        }
      }
    }
    for (??? = "" + ((File)localObject1).length();; ??? = "")
    {
      ??? = SecurityUtil.getBytes(paramURL.toString() + (String)???);
      localObject1 = sCacheBufferPool.get();
      long l1 = SystemClock.uptimeMillis();
      long l2 = SecurityUtil.crc64Long((byte[])???);
      try
      {
        if (!getCacheData((byte[])???, l2, (BytesBufferPool.BytesBuffer)localObject1))
        {
          paramBitmapDecoder = paramBitmapDecoder.getBitmap(paramURL);
          if (paramBitmapDecoder == null) {
            break label718;
          }
          paramDownloadParams = compressToJPEG(paramBitmapDecoder, 70);
          ByteBuffer localByteBuffer = ByteBuffer.allocate(???.length + paramDownloadParams.length);
          localByteBuffer.put((byte[])???);
          localByteBuffer.put(paramDownloadParams);
          synchronized (this.mBlobLock)
          {
            try
            {
              this.mBlobCache.a(l2, localByteBuffer.array());
              if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
                QLog.d("AlbumThumbManager", 2, "getThumb bitmap from cache,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - l1) + " sizeDisk:" + paramDownloadParams.length + " sizeMemory:" + paramBitmapDecoder.getByteCount());
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
        label718:
        localObject1 = "";
      }
      catch (OutOfMemoryError paramBitmapDecoder)
      {
        QLog.e("AlbumThumbManager", 2, "decode thumb", paramBitmapDecoder);
        if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
          QLog.d("AlbumThumbManager", 2, "getThumb bitmap OutOfMemoryError,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - l1));
        }
        return null;
        paramBitmapDecoder = new BitmapFactory.Options();
        paramBitmapDecoder.inPreferredConfig = Bitmap.Config.RGB_565;
        if (paramDownloadParams == null) {}
        for (paramBitmapDecoder.inSampleSize = 1;; paramBitmapDecoder.inSampleSize = URLState.calculateInSampleSize(paramBitmapDecoder, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight))
        {
          paramBitmapDecoder = SafeBitmapFactory.decodeByteArray(((BytesBufferPool.BytesBuffer)localObject1).data, ((BytesBufferPool.BytesBuffer)localObject1).offset, ((BytesBufferPool.BytesBuffer)localObject1).length, paramBitmapDecoder);
          if ((QLog.isColorLevel()) && (paramURL.getProtocol().equals("albumthumb"))) {
            QLog.d("AlbumThumbManager", 2, "getThumb bitmap from decode,url:" + paramURL + " cost:" + (SystemClock.uptimeMillis() - l1) + " sizeDisk:" + ((BytesBufferPool.BytesBuffer)localObject1).length + " sizeMemory:" + paramBitmapDecoder.getByteCount());
          }
          return paramBitmapDecoder;
          paramBitmapDecoder.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeByteArray(((BytesBufferPool.BytesBuffer)localObject1).data, ((BytesBufferPool.BytesBuffer)localObject1).offset, ((BytesBufferPool.BytesBuffer)localObject1).length, paramBitmapDecoder);
          paramBitmapDecoder.inJustDecodeBounds = false;
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
          sCacheBufferPool.recycle((BytesBufferPool.BytesBuffer)localObject1);
          continue;
          sCacheBufferPool.recycle((BytesBufferPool.BytesBuffer)localObject1);
        }
      }
      finally
      {
        sCacheBufferPool.recycle((BytesBufferPool.BytesBuffer)localObject1);
      }
      break;
    }
  }
  
  public Bitmap getThumbNew(URL arg1, BitmapDecoder paramBitmapDecoder)
  {
    try
    {
      if (tempBuffer == null)
      {
        tempBuffer = new AlbumThumbManager.TempBuffer(102400, null);
        tempByteBuffer = ByteBuffer.wrap(tempBuffer.data);
      }
      tempByteBuffer.clear();
      byte[] arrayOfByte = SecurityUtil.getBytes(???.toString());
      if (arrayOfByte.length < 16) {
        arrayOfByte = copyOf(arrayOfByte, 16);
      }
      for (;;)
      {
        long l = SecurityUtil.crc64Long(arrayOfByte);
        for (;;)
        {
          try
          {
            if (getCacheData(arrayOfByte, l, tempBuffer)) {
              continue;
            }
            paramBitmapDecoder = paramBitmapDecoder.getBitmap(???);
            if (paramBitmapDecoder == null) {
              continue;
            }
            ??? = paramBitmapDecoder;
            if (paramBitmapDecoder.getConfig() == Bitmap.Config.RGB_565)
            {
              ??? = paramBitmapDecoder;
              if (tempByteBuffer.remaining() >= paramBitmapDecoder.getHeight() * paramBitmapDecoder.getRowBytes() + 16 + 8)
              {
                paramBitmapDecoder.copyPixelsToBuffer(tempByteBuffer);
                tempByteBuffer.putInt(paramBitmapDecoder.getWidth());
                tempByteBuffer.putInt(paramBitmapDecoder.getHeight());
                tempByteBuffer.put(arrayOfByte, 0, 16);
              }
            }
          }
          catch (Throwable ???)
          {
            QLog.e("AlbumThumbManager", 2, "decode thumb", ???);
            ??? = null;
            continue;
            tempByteBuffer.clear();
            tempByteBuffer.put(tempBuffer.data, 0, tempBuffer.length);
            int i = tempByteBuffer.getInt(tempBuffer.length - 8);
            int j = tempByteBuffer.getInt(tempBuffer.length - 4);
            if ((i <= 500) || (j <= 500)) {
              continue;
            }
            QLog.e("AlbumThumbManager", 2, "thumb bitmap is dirty:" + ???.toString());
            ??? = null;
            continue;
            ??? = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
            tempByteBuffer.limit(tempBuffer.length - 8);
            tempByteBuffer.position(0);
            ???.copyPixelsFromBuffer(tempByteBuffer);
            continue;
          }
          synchronized (this.mBlobLock)
          {
            try
            {
              i = paramBitmapDecoder.getRowBytes();
              j = paramBitmapDecoder.getHeight();
              this.mBlobCache.a(l, tempByteBuffer.array(), i * j + 24);
              ??? = paramBitmapDecoder;
              return ???;
            }
            catch (IOException localIOException)
            {
              if (QLog.isColorLevel()) {
                QLog.e("AlbumThumbManager", 2, "decode thumb ioexception", localIOException);
              }
            }
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumThumbManager
 * JD-Core Version:    0.7.0.1
 */