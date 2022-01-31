package com.squareup.okhttp.internal;

import java.io.Closeable;
import okio.Source;

public final class DiskLruCache$Snapshot
  implements Closeable
{
  private final String key;
  private final long[] lengths;
  private final long sequenceNumber;
  private final Source[] sources;
  
  private DiskLruCache$Snapshot(DiskLruCache paramDiskLruCache, String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
  {
    this.key = paramString;
    this.sequenceNumber = paramLong;
    this.sources = paramArrayOfSource;
    this.lengths = paramArrayOfLong;
  }
  
  public void close()
  {
    Source[] arrayOfSource = this.sources;
    int j = arrayOfSource.length;
    int i = 0;
    while (i < j)
    {
      Util.closeQuietly(arrayOfSource[i]);
      i += 1;
    }
  }
  
  public DiskLruCache.Editor edit()
  {
    return DiskLruCache.access$2200(this.this$0, this.key, this.sequenceNumber);
  }
  
  public long getLength(int paramInt)
  {
    return this.lengths[paramInt];
  }
  
  public Source getSource(int paramInt)
  {
    return this.sources[paramInt];
  }
  
  public String key()
  {
    return this.key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.Snapshot
 * JD-Core Version:    0.7.0.1
 */