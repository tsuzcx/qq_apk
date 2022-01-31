package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Editor;
import okio.ForwardingSink;
import okio.Sink;

class Cache$CacheRequestImpl$1
  extends ForwardingSink
{
  Cache$CacheRequestImpl$1(Cache.CacheRequestImpl paramCacheRequestImpl, Sink paramSink, Cache paramCache, DiskLruCache.Editor paramEditor)
  {
    super(paramSink);
  }
  
  public void close()
  {
    synchronized (this.this$1.this$0)
    {
      if (Cache.CacheRequestImpl.access$700(this.this$1)) {
        return;
      }
      Cache.CacheRequestImpl.access$702(this.this$1, true);
      Cache.access$808(this.this$1.this$0);
      super.close();
      this.val$editor.commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Cache.CacheRequestImpl.1
 * JD-Core Version:    0.7.0.1
 */