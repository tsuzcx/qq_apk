package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public abstract class BaseDiskCache
  implements DiskCache
{
  public static final int DEFAULT_BUFFER_SIZE = 32768;
  public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
  public static final int DEFAULT_COMPRESS_QUALITY = 100;
  private static final String ERROR_ARG_NULL = " argument must be not null";
  private static final String TEMP_IMAGE_POSTFIX = ".tmp";
  protected int bufferSize = 32768;
  protected final File cacheDir;
  protected Bitmap.CompressFormat compressFormat = DEFAULT_COMPRESS_FORMAT;
  protected int compressQuality = 100;
  protected final FileNameGenerator fileNameGenerator;
  protected final File reserveCacheDir;
  
  public BaseDiskCache(File paramFile)
  {
    this(paramFile, null);
  }
  
  public BaseDiskCache(File paramFile1, File paramFile2)
  {
    this(paramFile1, paramFile2, DefaultConfigurationFactory.createFileNameGenerator());
  }
  
  public BaseDiskCache(File paramFile1, File paramFile2, FileNameGenerator paramFileNameGenerator)
  {
    if (paramFile1 != null)
    {
      if (paramFileNameGenerator != null)
      {
        this.cacheDir = paramFile1;
        this.reserveCacheDir = paramFile2;
        this.fileNameGenerator = paramFileNameGenerator;
        return;
      }
      throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }
    throw new IllegalArgumentException("cacheDir argument must be not null");
  }
  
  public void clear()
  {
    File[] arrayOfFile = this.cacheDir.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public void close() {}
  
  public File get(String paramString)
  {
    return getFile(paramString);
  }
  
  public File getDirectory()
  {
    return this.cacheDir;
  }
  
  protected File getFile(String paramString)
  {
    String str = this.fileNameGenerator.generate(paramString);
    File localFile1 = this.cacheDir;
    paramString = localFile1;
    if (!localFile1.exists())
    {
      paramString = localFile1;
      if (!this.cacheDir.mkdirs())
      {
        File localFile2 = this.reserveCacheDir;
        paramString = localFile1;
        if (localFile2 != null) {
          if (!localFile2.exists())
          {
            paramString = localFile1;
            if (!this.reserveCacheDir.mkdirs()) {}
          }
          else
          {
            paramString = this.reserveCacheDir;
          }
        }
      }
    }
    return new File(paramString, str);
  }
  
  public boolean remove(String paramString)
  {
    return getFile(paramString).delete();
  }
  
  public boolean save(String paramString, Bitmap paramBitmap)
  {
    paramString = getFile(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString.getAbsolutePath());
    ((StringBuilder)localObject).append(".tmp");
    localObject = new File(((StringBuilder)localObject).toString());
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject), this.bufferSize);
    try
    {
      boolean bool2 = paramBitmap.compress(this.compressFormat, this.compressQuality, localBufferedOutputStream);
      IoUtils.closeSilently(localBufferedOutputStream);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!((File)localObject).renameTo(paramString)) {
          bool1 = false;
        }
      }
      if (!bool1) {
        ((File)localObject).delete();
      }
      paramBitmap.recycle();
      return bool1;
    }
    finally
    {
      IoUtils.closeSilently(localBufferedOutputStream);
      ((File)localObject).delete();
    }
  }
  
  /* Error */
  public boolean save(String paramString, java.io.InputStream paramInputStream, com.nostra13.universalimageloader.utils.IoUtils.CopyListener paramCopyListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 92	com/nostra13/universalimageloader/cache/disc/impl/BaseDiskCache:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore 6
    //   7: new 115	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: aload 6
    //   18: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_1
    //   26: ldc 20
    //   28: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: new 78	java/io/File
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 7
    //   45: new 130	java/io/BufferedOutputStream
    //   48: dup
    //   49: new 132	java/io/FileOutputStream
    //   52: dup
    //   53: aload 7
    //   55: invokespecial 134	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: aload_0
    //   59: getfield 56	com/nostra13/universalimageloader/cache/disc/impl/BaseDiskCache:bufferSize	I
    //   62: invokespecial 137	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   65: astore_1
    //   66: aload_2
    //   67: aload_1
    //   68: aload_3
    //   69: aload_0
    //   70: getfield 56	com/nostra13/universalimageloader/cache/disc/impl/BaseDiskCache:bufferSize	I
    //   73: invokestatic 161	com/nostra13/universalimageloader/utils/IoUtils:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/nostra13/universalimageloader/utils/IoUtils$CopyListener;I)Z
    //   76: istore 4
    //   78: aload_1
    //   79: invokestatic 149	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   82: iload 4
    //   84: istore 5
    //   86: iload 4
    //   88: ifeq +20 -> 108
    //   91: iload 4
    //   93: istore 5
    //   95: aload 7
    //   97: aload 6
    //   99: invokevirtual 153	java/io/File:renameTo	(Ljava/io/File;)Z
    //   102: ifne +6 -> 108
    //   105: iconst_0
    //   106: istore 5
    //   108: iload 5
    //   110: ifne +9 -> 119
    //   113: aload 7
    //   115: invokevirtual 86	java/io/File:delete	()Z
    //   118: pop
    //   119: iload 5
    //   121: ireturn
    //   122: astore_1
    //   123: goto +14 -> 137
    //   126: astore_2
    //   127: aload_1
    //   128: invokestatic 149	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   131: aload_2
    //   132: athrow
    //   133: astore_1
    //   134: iconst_0
    //   135: istore 4
    //   137: iload 4
    //   139: istore 5
    //   141: iload 4
    //   143: ifeq +20 -> 163
    //   146: iload 4
    //   148: istore 5
    //   150: aload 7
    //   152: aload 6
    //   154: invokevirtual 153	java/io/File:renameTo	(Ljava/io/File;)Z
    //   157: ifne +6 -> 163
    //   160: iconst_0
    //   161: istore 5
    //   163: iload 5
    //   165: ifne +9 -> 174
    //   168: aload 7
    //   170: invokevirtual 86	java/io/File:delete	()Z
    //   173: pop
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	BaseDiskCache
    //   0	176	1	paramString	String
    //   0	176	2	paramInputStream	java.io.InputStream
    //   0	176	3	paramCopyListener	com.nostra13.universalimageloader.utils.IoUtils.CopyListener
    //   76	71	4	bool1	boolean
    //   84	80	5	bool2	boolean
    //   5	148	6	localFile1	File
    //   43	126	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   78	82	122	finally
    //   66	78	126	finally
    //   45	66	133	finally
    //   127	133	133	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache
 * JD-Core Version:    0.7.0.1
 */