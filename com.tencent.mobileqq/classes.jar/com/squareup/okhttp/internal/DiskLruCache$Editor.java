package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;

public final class DiskLruCache$Editor
{
  private boolean committed;
  private final DiskLruCache.Entry entry;
  private boolean hasErrors;
  private final boolean[] written;
  
  private DiskLruCache$Editor(DiskLruCache paramDiskLruCache, DiskLruCache.Entry paramEntry)
  {
    this.entry = paramEntry;
    if (DiskLruCache.Entry.access$800(paramEntry)) {}
    for (paramDiskLruCache = null;; paramDiskLruCache = new boolean[DiskLruCache.access$2300(paramDiskLruCache)])
    {
      this.written = paramDiskLruCache;
      return;
    }
  }
  
  public void abort()
  {
    synchronized (this.this$0)
    {
      DiskLruCache.access$2600(this.this$0, this, false);
      return;
    }
  }
  
  public void abortUnlessCommitted()
  {
    synchronized (this.this$0)
    {
      boolean bool = this.committed;
      if (bool) {}
    }
    try
    {
      DiskLruCache.access$2600(this.this$0, this, false);
      label25:
      return;
      localObject = finally;
      throw localObject;
    }
    catch (IOException localIOException)
    {
      break label25;
    }
  }
  
  public void commit()
  {
    synchronized (this.this$0)
    {
      if (this.hasErrors)
      {
        DiskLruCache.access$2600(this.this$0, this, false);
        DiskLruCache.access$2700(this.this$0, this.entry);
        this.committed = true;
        return;
      }
      DiskLruCache.access$2600(this.this$0, this, true);
    }
  }
  
  public Sink newSink(int paramInt)
  {
    synchronized (this.this$0)
    {
      if (DiskLruCache.Entry.access$900(this.entry) != this) {
        throw new IllegalStateException();
      }
    }
    if (!DiskLruCache.Entry.access$800(this.entry)) {
      this.written[paramInt] = true;
    }
    Object localObject2 = DiskLruCache.Entry.access$1400(this.entry)[paramInt];
    try
    {
      localObject2 = DiskLruCache.access$2400(this.this$0).sink((File)localObject2);
      localObject2 = new DiskLruCache.Editor.1(this, (Sink)localObject2);
      return localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Sink localSink = DiskLruCache.access$2500();
      return localSink;
    }
  }
  
  public Source newSource(int paramInt)
  {
    synchronized (this.this$0)
    {
      if (DiskLruCache.Entry.access$900(this.entry) != this) {
        throw new IllegalStateException();
      }
    }
    if (!DiskLruCache.Entry.access$800(this.entry)) {
      return null;
    }
    try
    {
      Source localSource = DiskLruCache.access$2400(this.this$0).source(DiskLruCache.Entry.access$1300(this.entry)[paramInt]);
      return localSource;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.Editor
 * JD-Core Version:    0.7.0.1
 */