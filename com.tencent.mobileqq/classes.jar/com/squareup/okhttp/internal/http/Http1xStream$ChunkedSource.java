package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;

class Http1xStream$ChunkedSource
  extends Http1xStream.AbstractSource
{
  private static final long NO_CHUNK_YET = -1L;
  private long bytesRemainingInChunk = -1L;
  private boolean hasMoreChunks = true;
  private final HttpEngine httpEngine;
  
  Http1xStream$ChunkedSource(Http1xStream paramHttp1xStream, HttpEngine paramHttpEngine)
  {
    super(paramHttp1xStream, null);
    this.httpEngine = paramHttpEngine;
  }
  
  private void readChunkSize()
  {
    if (this.bytesRemainingInChunk != -1L) {
      Http1xStream.access$600(this.this$0).readUtf8LineStrict();
    }
    try
    {
      this.bytesRemainingInChunk = Http1xStream.access$600(this.this$0).readHexadecimalUnsignedLong();
      String str = Http1xStream.access$600(this.this$0).readUtf8LineStrict().trim();
      if ((this.bytesRemainingInChunk < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
        throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + str + "\"");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException(localNumberFormatException.getMessage());
    }
    if (this.bytesRemainingInChunk == 0L)
    {
      this.hasMoreChunks = false;
      this.httpEngine.receiveHeaders(this.this$0.readHeaders());
      endOfInput();
    }
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    if ((this.hasMoreChunks) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
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
    if (!this.hasMoreChunks) {}
    do
    {
      return -1L;
      if ((this.bytesRemainingInChunk != 0L) && (this.bytesRemainingInChunk != -1L)) {
        break;
      }
      readChunkSize();
    } while (!this.hasMoreChunks);
    paramLong = Http1xStream.access$600(this.this$0).read(paramBuffer, Math.min(paramLong, this.bytesRemainingInChunk));
    if (paramLong == -1L)
    {
      unexpectedEndOfInput();
      throw new ProtocolException("unexpected end of stream");
    }
    this.bytesRemainingInChunk -= paramLong;
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.ChunkedSource
 * JD-Core Version:    0.7.0.1
 */