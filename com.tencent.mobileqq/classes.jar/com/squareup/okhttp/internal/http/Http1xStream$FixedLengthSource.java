package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;

class Http1xStream$FixedLengthSource
  extends Http1xStream.AbstractSource
{
  private long bytesRemaining;
  
  public Http1xStream$FixedLengthSource(Http1xStream paramHttp1xStream, long paramLong)
  {
    super(paramHttp1xStream, null);
    this.bytesRemaining = paramLong;
    if (this.bytesRemaining == 0L) {
      endOfInput();
    }
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    if ((this.bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
      unexpectedEndOfInput();
    }
    this.closed = true;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    if (this.bytesRemaining == 0L) {
      return -1L;
    }
    paramLong = Http1xStream.access$600(this.this$0).read(paramBuffer, Math.min(this.bytesRemaining, paramLong));
    if (paramLong == -1L)
    {
      unexpectedEndOfInput();
      throw new ProtocolException("unexpected end of stream");
    }
    this.bytesRemaining -= paramLong;
    if (this.bytesRemaining == 0L) {
      endOfInput();
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.FixedLengthSource
 * JD-Core Version:    0.7.0.1
 */