package com.nostra13.universalimageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.IoUtils.CopyListener;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LruDiskCache
  implements DiskCache
{
  public static final int DEFAULT_BUFFER_SIZE = 32768;
  public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
  public static final int DEFAULT_COMPRESS_QUALITY = 100;
  private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
  private static final String ERROR_ARG_NULL = " argument must be not null";
  protected int bufferSize = 32768;
  protected DiskLruCache cache;
  protected Bitmap.CompressFormat compressFormat = DEFAULT_COMPRESS_FORMAT;
  protected int compressQuality = 100;
  protected final FileNameGenerator fileNameGenerator;
  private File reserveCacheDir;
  
  public LruDiskCache(File paramFile, FileNameGenerator paramFileNameGenerator, long paramLong)
  {
    this(paramFile, null, paramFileNameGenerator, paramLong, 0);
  }
  
  public LruDiskCache(File paramFile1, File paramFile2, FileNameGenerator paramFileNameGenerator, long paramLong, int paramInt)
  {
    if (paramFile1 != null)
    {
      if (paramLong >= 0L)
      {
        if (paramInt >= 0)
        {
          if (paramFileNameGenerator != null)
          {
            long l = paramLong;
            if (paramLong == 0L) {
              l = 9223372036854775807L;
            }
            if (paramInt == 0) {
              paramInt = 2147483647;
            }
            this.reserveCacheDir = paramFile2;
            this.fileNameGenerator = paramFileNameGenerator;
            initCache(paramFile1, paramFile2, l, paramInt);
            return;
          }
          throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
      }
      throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
    }
    throw new IllegalArgumentException("cacheDir argument must be not null");
  }
  
  private String getKey(String paramString)
  {
    return this.fileNameGenerator.generate(paramString);
  }
  
  private void initCache(File paramFile1, File paramFile2, long paramLong, int paramInt)
  {
    try
    {
      this.cache = DiskLruCache.open(paramFile1, 1, 1, paramLong, paramInt);
      return;
    }
    catch (IOException paramFile1)
    {
      L.e(paramFile1);
      if (paramFile2 != null) {
        initCache(paramFile2, null, paramLong, paramInt);
      }
      if (this.cache != null) {
        return;
      }
      throw paramFile1;
    }
  }
  
  public void clear()
  {
    try
    {
      this.cache.delete();
    }
    catch (IOException localIOException1)
    {
      L.e(localIOException1);
    }
    try
    {
      initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.getMaxFileCount());
      return;
    }
    catch (IOException localIOException2)
    {
      L.e(localIOException2);
    }
  }
  
  public void close()
  {
    try
    {
      this.cache.close();
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
    }
    this.cache = null;
  }
  
  /* Error */
  public File get(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 93	com/nostra13/universalimageloader/cache/disc/impl/ext/LruDiskCache:cache	Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache;
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 122	com/nostra13/universalimageloader/cache/disc/impl/ext/LruDiskCache:getKey	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokevirtual 125	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:get	(Ljava/lang/String;)Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +9 -> 28
    //   22: aload 4
    //   24: astore_1
    //   25: goto +13 -> 38
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: iconst_0
    //   32: invokevirtual 131	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot:getFile	(I)Ljava/io/File;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_1
    //   38: aload_2
    //   39: ifnull +7 -> 46
    //   42: aload_2
    //   43: invokevirtual 132	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot:close	()V
    //   46: aload_1
    //   47: areturn
    //   48: astore_3
    //   49: goto +12 -> 61
    //   52: astore_2
    //   53: aload_3
    //   54: astore_1
    //   55: goto +23 -> 78
    //   58: astore_3
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_3
    //   64: invokestatic 99	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/Throwable;)V
    //   67: aload_2
    //   68: ifnull +7 -> 75
    //   71: aload_2
    //   72: invokevirtual 132	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_2
    //   78: aload_1
    //   79: ifnull +7 -> 86
    //   82: aload_1
    //   83: invokevirtual 132	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot:close	()V
    //   86: aload_2
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	LruDiskCache
    //   0	88	1	paramString	String
    //   17	26	2	localSnapshot	DiskLruCache.Snapshot
    //   52	1	2	localObject1	Object
    //   60	12	2	localObject2	Object
    //   77	10	2	localObject3	Object
    //   1	36	3	localFile	File
    //   48	6	3	localIOException1	IOException
    //   58	6	3	localIOException2	IOException
    //   3	20	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   30	36	48	java/io/IOException
    //   5	18	52	finally
    //   5	18	58	java/io/IOException
    //   30	36	77	finally
    //   63	67	77	finally
  }
  
  public File getDirectory()
  {
    return this.cache.getDirectory();
  }
  
  public boolean remove(String paramString)
  {
    try
    {
      boolean bool = this.cache.remove(getKey(paramString));
      return bool;
    }
    catch (IOException paramString)
    {
      L.e(paramString);
    }
    return false;
  }
  
  public boolean save(String paramString, Bitmap paramBitmap)
  {
    DiskLruCache.Editor localEditor = this.cache.edit(getKey(paramString));
    if (localEditor == null) {
      return false;
    }
    paramString = new BufferedOutputStream(localEditor.newOutputStream(0), this.bufferSize);
    try
    {
      boolean bool = paramBitmap.compress(this.compressFormat, this.compressQuality, paramString);
      IoUtils.closeSilently(paramString);
      if (bool)
      {
        localEditor.commit();
        return bool;
      }
      localEditor.abort();
      return bool;
    }
    finally
    {
      IoUtils.closeSilently(paramString);
    }
  }
  
  public boolean save(String paramString, InputStream paramInputStream, IoUtils.CopyListener paramCopyListener)
  {
    paramString = this.cache.edit(getKey(paramString));
    if (paramString == null) {
      return false;
    }
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramString.newOutputStream(0), this.bufferSize);
    try
    {
      boolean bool = IoUtils.copyStream(paramInputStream, localBufferedOutputStream, paramCopyListener, this.bufferSize);
      IoUtils.closeSilently(localBufferedOutputStream);
      if (bool)
      {
        paramString.commit();
        return bool;
      }
      paramString.abort();
      return bool;
    }
    finally
    {
      IoUtils.closeSilently(localBufferedOutputStream);
      paramString.abort();
    }
  }
  
  public void setBufferSize(int paramInt)
  {
    this.bufferSize = paramInt;
  }
  
  public void setCompressFormat(Bitmap.CompressFormat paramCompressFormat)
  {
    this.compressFormat = paramCompressFormat;
  }
  
  public void setCompressQuality(int paramInt)
  {
    this.compressQuality = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache
 * JD-Core Version:    0.7.0.1
 */