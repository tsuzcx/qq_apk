package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Sink;

class DiskLruCache$2
  extends FaultHidingSink
{
  static
  {
    if (!DiskLruCache.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  DiskLruCache$2(DiskLruCache paramDiskLruCache, Sink paramSink)
  {
    super(paramSink);
  }
  
  protected void onException(IOException paramIOException)
  {
    assert (Thread.holdsLock(this.this$0));
    DiskLruCache.access$602(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.2
 * JD-Core Version:    0.7.0.1
 */