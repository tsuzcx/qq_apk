package com.bumptech.glide.disklrucache;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class DiskLruCache$Entry
{
  File[] a;
  File[] b;
  private final String d;
  private final long[] e;
  private boolean f;
  private DiskLruCache.Editor g;
  private long h;
  
  private DiskLruCache$Entry(DiskLruCache paramDiskLruCache, String paramString)
  {
    this.d = paramString;
    this.e = new long[DiskLruCache.e(paramDiskLruCache)];
    this.a = new File[DiskLruCache.e(paramDiskLruCache)];
    this.b = new File[DiskLruCache.e(paramDiskLruCache)];
    paramString = new StringBuilder(paramString);
    paramString.append('.');
    int j = paramString.length();
    int i = 0;
    while (i < DiskLruCache.e(paramDiskLruCache))
    {
      paramString.append(i);
      this.a[i] = new File(DiskLruCache.f(paramDiskLruCache), paramString.toString());
      paramString.append(".tmp");
      this.b[i] = new File(DiskLruCache.f(paramDiskLruCache), paramString.toString());
      paramString.setLength(j);
      i += 1;
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    int i;
    if (paramArrayOfString.length == DiskLruCache.e(this.c)) {
      i = 0;
    }
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.e[i] = Long.parseLong(paramArrayOfString[i]);
        i += 1;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label40:
      break label40;
    }
    throw b(paramArrayOfString);
    paramArrayOfString = b(paramArrayOfString);
    for (;;)
    {
      throw paramArrayOfString;
    }
  }
  
  private IOException b(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected journal line: ");
    localStringBuilder.append(Arrays.toString(paramArrayOfString));
    throw new IOException(localStringBuilder.toString());
  }
  
  public File a(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long[] arrayOfLong = this.e;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      localStringBuilder.append(' ');
      localStringBuilder.append(l);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public File b(int paramInt)
  {
    return this.b[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.disklrucache.DiskLruCache.Entry
 * JD-Core Version:    0.7.0.1
 */