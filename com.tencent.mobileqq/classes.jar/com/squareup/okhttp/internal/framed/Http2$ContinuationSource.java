package com.squareup.okhttp.internal.framed;

import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

final class Http2$ContinuationSource
  implements Source
{
  byte flags;
  int left;
  int length;
  short padding;
  private final BufferedSource source;
  int streamId;
  
  public Http2$ContinuationSource(BufferedSource paramBufferedSource)
  {
    this.source = paramBufferedSource;
  }
  
  private void readContinuationHeader()
  {
    int i = this.streamId;
    int j = Http2.access$300(this.source);
    this.left = j;
    this.length = j;
    byte b = (byte)(this.source.readByte() & 0xFF);
    this.flags = ((byte)(this.source.readByte() & 0xFF));
    if (Http2.access$100().isLoggable(Level.FINE)) {
      Http2.access$100().fine(Http2.FrameLogger.formatHeader(true, this.streamId, this.length, b, this.flags));
    }
    this.streamId = (this.source.readInt() & 0x7FFFFFFF);
    if (b != 9) {
      throw Http2.access$200("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
    }
    if (this.streamId != i) {
      throw Http2.access$200("TYPE_CONTINUATION streamId changed", new Object[0]);
    }
  }
  
  public void close() {}
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (this.left == 0)
    {
      this.source.skip(this.padding);
      this.padding = 0;
      if ((this.flags & 0x4) == 0) {}
    }
    do
    {
      return -1L;
      readContinuationHeader();
      break;
      paramLong = this.source.read(paramBuffer, Math.min(paramLong, this.left));
    } while (paramLong == -1L);
    this.left = ((int)(this.left - paramLong));
    return paramLong;
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.Http2.ContinuationSource
 * JD-Core Version:    0.7.0.1
 */