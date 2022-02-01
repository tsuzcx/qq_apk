package com.tencent.imsdk.message;

import java.io.Serializable;

public class DownloadProgressInfo
  implements Serializable
{
  private long currentSize;
  private long totalSize;
  
  public DownloadProgressInfo(long paramLong1, long paramLong2)
  {
    this.currentSize = paramLong1;
    this.totalSize = paramLong2;
  }
  
  public long getCurrentSize()
  {
    return this.currentSize;
  }
  
  public long getTotalSize()
  {
    return this.totalSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.DownloadProgressInfo
 * JD-Core Version:    0.7.0.1
 */