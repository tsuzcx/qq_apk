package com.bumptech.glide.disklrucache;

import java.io.File;
import java.io.IOException;

public final class DiskLruCache$Editor
{
  private final DiskLruCache.Entry b;
  private final boolean[] c;
  private boolean d;
  
  private DiskLruCache$Editor(DiskLruCache paramDiskLruCache, DiskLruCache.Entry paramEntry)
  {
    this.b = paramEntry;
    if (DiskLruCache.Entry.d(paramEntry)) {
      paramDiskLruCache = null;
    } else {
      paramDiskLruCache = new boolean[DiskLruCache.e(paramDiskLruCache)];
    }
    this.c = paramDiskLruCache;
  }
  
  public File a(int paramInt)
  {
    synchronized (this.a)
    {
      if (DiskLruCache.Entry.a(this.b) == this)
      {
        if (!DiskLruCache.Entry.d(this.b)) {
          this.c[paramInt] = true;
        }
        File localFile = this.b.b(paramInt);
        if (!DiskLruCache.f(this.a).exists()) {
          DiskLruCache.f(this.a).mkdirs();
        }
        return localFile;
      }
      throw new IllegalStateException();
    }
  }
  
  public void a()
  {
    DiskLruCache.a(this.a, this, true);
    this.d = true;
  }
  
  public void b()
  {
    DiskLruCache.a(this.a, this, false);
  }
  
  public void c()
  {
    if (!this.d) {}
    try
    {
      b();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.disklrucache.DiskLruCache.Editor
 * JD-Core Version:    0.7.0.1
 */