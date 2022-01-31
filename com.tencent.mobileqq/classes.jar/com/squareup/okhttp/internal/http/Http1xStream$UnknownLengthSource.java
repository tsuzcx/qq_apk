package com.squareup.okhttp.internal.http;

import okio.Buffer;
import okio.BufferedSource;

class Http1xStream$UnknownLengthSource
  extends Http1xStream.AbstractSource
{
  private boolean inputExhausted;
  
  private Http1xStream$UnknownLengthSource(Http1xStream paramHttp1xStream)
  {
    super(paramHttp1xStream, null);
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    if (!this.inputExhausted) {
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
    if (this.inputExhausted) {
      return -1L;
    }
    paramLong = Http1xStream.access$600(this.this$0).read(paramBuffer, paramLong);
    if (paramLong == -1L)
    {
      this.inputExhausted = true;
      endOfInput();
      return -1L;
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.UnknownLengthSource
 * JD-Core Version:    0.7.0.1
 */