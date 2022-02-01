package com.bumptech.glide.disklrucache;

import java.io.File;

public final class DiskLruCache$Value
{
  private final String b;
  private final long c;
  private final long[] d;
  private final File[] e;
  
  private DiskLruCache$Value(DiskLruCache paramDiskLruCache, String paramString, long paramLong, File[] paramArrayOfFile, long[] paramArrayOfLong)
  {
    this.b = paramString;
    this.c = paramLong;
    this.e = paramArrayOfFile;
    this.d = paramArrayOfLong;
  }
  
  public File a(int paramInt)
  {
    return this.e[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.disklrucache.DiskLruCache.Value
 * JD-Core Version:    0.7.0.1
 */