package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Timeout;

final class Http1xStream$FixedLengthSink
  implements Sink
{
  private long bytesRemaining;
  private boolean closed;
  private final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.access$300(this.this$0).timeout());
  
  private Http1xStream$FixedLengthSink(Http1xStream paramHttp1xStream, long paramLong)
  {
    this.bytesRemaining = paramLong;
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    this.closed = true;
    if (this.bytesRemaining > 0L) {
      throw new ProtocolException("unexpected end of stream");
    }
    Http1xStream.access$400(this.this$0, this.timeout);
    Http1xStream.access$502(this.this$0, 3);
  }
  
  public void flush()
  {
    if (this.closed) {
      return;
    }
    Http1xStream.access$300(this.this$0).flush();
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    if (paramLong > this.bytesRemaining) {
      throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + paramLong);
    }
    Http1xStream.access$300(this.this$0).write(paramBuffer, paramLong);
    this.bytesRemaining -= paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.FixedLengthSink
 * JD-Core Version:    0.7.0.1
 */