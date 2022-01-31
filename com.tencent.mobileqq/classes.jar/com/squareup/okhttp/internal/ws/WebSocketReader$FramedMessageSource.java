package com.squareup.okhttp.internal.ws;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

final class WebSocketReader$FramedMessageSource
  implements Source
{
  private WebSocketReader$FramedMessageSource(WebSocketReader paramWebSocketReader) {}
  
  public void close()
  {
    if (WebSocketReader.access$200(this.this$0)) {}
    for (;;)
    {
      return;
      WebSocketReader.access$202(this.this$0, true);
      if (!WebSocketReader.access$100(this.this$0))
      {
        WebSocketReader.access$1000(this.this$0).skip(WebSocketReader.access$400(this.this$0) - WebSocketReader.access$300(this.this$0));
        while (!WebSocketReader.access$500(this.this$0))
        {
          WebSocketReader.access$600(this.this$0);
          WebSocketReader.access$1000(this.this$0).skip(WebSocketReader.access$400(this.this$0));
        }
      }
    }
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (WebSocketReader.access$100(this.this$0)) {
      throw new IOException("closed");
    }
    if (WebSocketReader.access$200(this.this$0)) {
      throw new IllegalStateException("closed");
    }
    if (WebSocketReader.access$300(this.this$0) == WebSocketReader.access$400(this.this$0))
    {
      if (WebSocketReader.access$500(this.this$0)) {
        return -1L;
      }
      WebSocketReader.access$600(this.this$0);
      if (WebSocketReader.access$700(this.this$0) != 0) {
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(WebSocketReader.access$700(this.this$0)));
      }
      if ((WebSocketReader.access$500(this.this$0)) && (WebSocketReader.access$400(this.this$0) == 0L)) {
        return -1L;
      }
    }
    paramLong = Math.min(paramLong, WebSocketReader.access$400(this.this$0) - WebSocketReader.access$300(this.this$0));
    if (WebSocketReader.access$800(this.this$0))
    {
      paramLong = Math.min(paramLong, WebSocketReader.access$900(this.this$0).length);
      paramLong = WebSocketReader.access$1000(this.this$0).read(WebSocketReader.access$900(this.this$0), 0, (int)paramLong);
      if (paramLong == -1L) {
        throw new EOFException();
      }
      WebSocketProtocol.toggleMask(WebSocketReader.access$900(this.this$0), paramLong, WebSocketReader.access$1100(this.this$0), WebSocketReader.access$300(this.this$0));
      paramBuffer.write(WebSocketReader.access$900(this.this$0), 0, (int)paramLong);
    }
    long l;
    do
    {
      WebSocketReader.access$302(this.this$0, WebSocketReader.access$300(this.this$0) + paramLong);
      return paramLong;
      l = WebSocketReader.access$1000(this.this$0).read(paramBuffer, paramLong);
      paramLong = l;
    } while (l != -1L);
    throw new EOFException();
  }
  
  public Timeout timeout()
  {
    return WebSocketReader.access$1000(this.this$0).timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.WebSocketReader.FramedMessageSource
 * JD-Core Version:    0.7.0.1
 */