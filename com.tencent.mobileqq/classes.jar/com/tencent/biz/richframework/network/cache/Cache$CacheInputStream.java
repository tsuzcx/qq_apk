package com.tencent.biz.richframework.network.cache;

import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Cache$CacheInputStream
{
  private InputStream mInputStream = null;
  private DiskLruCache.Snapshot mSnapshot = null;
  
  public Cache$CacheInputStream(Cache paramCache) {}
  
  public Cache$CacheInputStream(Cache paramCache, DiskLruCache.Snapshot paramSnapshot, InputStream paramInputStream)
  {
    this.mSnapshot = paramSnapshot;
    this.mInputStream = paramInputStream;
  }
  
  public void close()
  {
    InputStream localInputStream = this.mInputStream;
    if (localInputStream != null) {
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    DiskLruCache.Snapshot localSnapshot = this.mSnapshot;
    if (localSnapshot != null) {
      localSnapshot.close();
    }
  }
  
  public FileDescriptor getFileDescriptor()
  {
    Object localObject = this.mInputStream;
    if (localObject != null) {
      try
      {
        localObject = ((FileInputStream)localObject).getFD();
        return localObject;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.Cache.CacheInputStream
 * JD-Core Version:    0.7.0.1
 */