package com.squareup.okhttp.internal;

import okio.Buffer;
import okio.Sink;
import okio.Timeout;

final class DiskLruCache$4
  implements Sink
{
  public void close() {}
  
  public void flush() {}
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    paramBuffer.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.4
 * JD-Core Version:    0.7.0.1
 */