package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import okio.BufferedSink;
import okio.Source;

final class DiskLruCache$Entry
{
  private final File[] cleanFiles;
  private DiskLruCache.Editor currentEditor;
  private final File[] dirtyFiles;
  private final String key;
  private final long[] lengths;
  private boolean readable;
  private long sequenceNumber;
  
  private DiskLruCache$Entry(DiskLruCache paramDiskLruCache, String paramString)
  {
    this.key = paramString;
    this.lengths = new long[DiskLruCache.access$2300(paramDiskLruCache)];
    this.cleanFiles = new File[DiskLruCache.access$2300(paramDiskLruCache)];
    this.dirtyFiles = new File[DiskLruCache.access$2300(paramDiskLruCache)];
    paramString = new StringBuilder(paramString).append('.');
    int j = paramString.length();
    int i = 0;
    while (i < DiskLruCache.access$2300(paramDiskLruCache))
    {
      paramString.append(i);
      this.cleanFiles[i] = new File(DiskLruCache.access$2800(paramDiskLruCache), paramString.toString());
      paramString.append(".tmp");
      this.dirtyFiles[i] = new File(DiskLruCache.access$2800(paramDiskLruCache), paramString.toString());
      paramString.setLength(j);
      i += 1;
    }
  }
  
  private IOException invalidLengths(String[] paramArrayOfString)
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
  
  private void setLengths(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != DiskLruCache.access$2300(this.this$0)) {
      throw invalidLengths(paramArrayOfString);
    }
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.lengths[i] = Long.parseLong(paramArrayOfString[i]);
        i += 1;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw invalidLengths(paramArrayOfString);
    }
  }
  
  DiskLruCache.Snapshot snapshot()
  {
    j = 0;
    if (!Thread.holdsLock(this.this$0)) {
      throw new AssertionError();
    }
    Source[] arrayOfSource = new Source[DiskLruCache.access$2300(this.this$0)];
    Object localObject = (long[])this.lengths.clone();
    i = 0;
    for (;;)
    {
      try
      {
        if (i < DiskLruCache.access$2300(this.this$0))
        {
          arrayOfSource[i] = DiskLruCache.access$2400(this.this$0).source(this.cleanFiles[i]);
          i += 1;
          continue;
        }
        localObject = new DiskLruCache.Snapshot(this.this$0, this.key, this.sequenceNumber, arrayOfSource, (long[])localObject, null);
        return localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        i = j;
        continue;
      }
      if ((i >= DiskLruCache.access$2300(this.this$0)) || (arrayOfSource[i] == null)) {
        continue;
      }
      Util.closeQuietly(arrayOfSource[i]);
      i += 1;
    }
    return null;
  }
  
  void writeLengths(BufferedSink paramBufferedSink)
  {
    long[] arrayOfLong = this.lengths;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      paramBufferedSink.writeByte(32).writeDecimalLong(l);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.Entry
 * JD-Core Version:    0.7.0.1
 */