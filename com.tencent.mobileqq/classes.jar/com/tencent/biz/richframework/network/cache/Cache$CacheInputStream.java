package com.tencent.biz.richframework.network.cache;

import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Cache$CacheInputStream
{
  private InputStream mInputStream;
  private DiskLruCache.Snapshot mSnapshot;
  
  public Cache$CacheInputStream(Cache paramCache) {}
  
  public Cache$CacheInputStream(Cache paramCache, DiskLruCache.Snapshot paramSnapshot, InputStream paramInputStream)
  {
    this.mSnapshot = paramSnapshot;
    this.mInputStream = paramInputStream;
  }
  
  public void close()
  {
    if (this.mInputStream != null) {}
    try
    {
      this.mInputStream.close();
      label14:
      if (this.mSnapshot != null) {
        this.mSnapshot.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public FileDescriptor getFileDescriptor()
  {
    if (this.mInputStream != null) {
      try
      {
        FileDescriptor localFileDescriptor = ((FileInputStream)this.mInputStream).getFD();
        return localFileDescriptor;
      }
      catch (IOException localIOException)
      {
        return null;
      }
    }
    return null;
  }
  
  public InputStream getInputStream()
  {
    return this.mInputStream;
  }
  
  public void setInputStream(InputStream paramInputStream)
  {
    this.mInputStream = paramInputStream;
  }
  
  public void setSnapshot(DiskLruCache.Snapshot paramSnapshot)
  {
    this.mSnapshot = paramSnapshot;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.Cache.CacheInputStream
 * JD-Core Version:    0.7.0.1
 */