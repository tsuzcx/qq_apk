package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

public final class DiskLruCache$Snapshot
  implements Closeable
{
  private File[] files;
  private final InputStream[] ins;
  private final String key;
  private final long[] lengths;
  private final long sequenceNumber;
  
  private DiskLruCache$Snapshot(DiskLruCache paramDiskLruCache, String paramString, long paramLong, File[] paramArrayOfFile, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
  {
    this.key = paramString;
    this.sequenceNumber = paramLong;
    this.files = paramArrayOfFile;
    this.ins = paramArrayOfInputStream;
    this.lengths = paramArrayOfLong;
  }
  
  public void close()
  {
    InputStream[] arrayOfInputStream = this.ins;
    int j = arrayOfInputStream.length;
    int i = 0;
    while (i < j)
    {
      Util.closeQuietly(arrayOfInputStream[i]);
      i += 1;
    }
  }
  
  public DiskLruCache.Editor edit()
  {
    return DiskLruCache.access$1700(this.this$0, this.key, this.sequenceNumber);
  }
  
  public File getFile(int paramInt)
  {
    return this.files[paramInt];
  }
  
  public InputStream getInputStream(int paramInt)
  {
    return this.ins[paramInt];
  }
  
  public long getLength(int paramInt)
  {
    return this.lengths[paramInt];
  }
  
  public String getString(int paramInt)
  {
    return DiskLruCache.access$1800(getInputStream(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Snapshot
 * JD-Core Version:    0.7.0.1
 */