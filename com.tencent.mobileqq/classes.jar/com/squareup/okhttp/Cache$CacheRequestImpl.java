package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Editor;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import java.io.IOException;
import okio.Sink;

final class Cache$CacheRequestImpl
  implements CacheRequest
{
  private Sink body;
  private Sink cacheOut;
  private boolean done;
  private final DiskLruCache.Editor editor;
  
  public Cache$CacheRequestImpl(Cache paramCache, DiskLruCache.Editor paramEditor)
  {
    this.editor = paramEditor;
    this.cacheOut = paramEditor.newSink(1);
    this.body = new Cache.CacheRequestImpl.1(this, this.cacheOut, paramCache, paramEditor);
  }
  
  public void abort()
  {
    synchronized (this.this$0)
    {
      if (this.done) {
        return;
      }
      this.done = true;
      Cache.access$908(this.this$0);
      Util.closeQuietly(this.cacheOut);
      try
      {
        this.editor.abort();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  public Sink body()
  {
    return this.body;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Cache.CacheRequestImpl
 * JD-Core Version:    0.7.0.1
 */