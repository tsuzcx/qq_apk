package com.squareup.okhttp.internal.ws;

import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.Sink;
import okio.Timeout;

final class WebSocketWriter$FrameSink
  implements Sink
{
  private boolean closed;
  private int formatOpcode;
  private boolean isFirstFrame;
  
  private WebSocketWriter$FrameSink(WebSocketWriter paramWebSocketWriter) {}
  
  public void close()
  {
    if (this.closed) {
      throw new IOException("closed");
    }
    synchronized (this.this$0)
    {
      WebSocketWriter.access$500(this.this$0, this.formatOpcode, WebSocketWriter.access$400(this.this$0).size(), this.isFirstFrame, true);
      this.closed = true;
      WebSocketWriter.access$702(this.this$0, false);
      return;
    }
  }
  
  public void flush()
  {
    if (this.closed) {
      throw new IOException("closed");
    }
    synchronized (this.this$0)
    {
      WebSocketWriter.access$500(this.this$0, this.formatOpcode, WebSocketWriter.access$400(this.this$0).size(), this.isFirstFrame, false);
      this.isFirstFrame = false;
      return;
    }
  }
  
  public Timeout timeout()
  {
    return WebSocketWriter.access$600(this.this$0).timeout();
  }
  
  public void write(Buffer arg1, long paramLong)
  {
    if (this.closed) {
      throw new IOException("closed");
    }
    WebSocketWriter.access$400(this.this$0).write(???, paramLong);
    paramLong = WebSocketWriter.access$400(this.this$0).completeSegmentByteCount();
    if (paramLong > 0L) {}
    synchronized (this.this$0)
    {
      WebSocketWriter.access$500(this.this$0, this.formatOpcode, paramLong, this.isFirstFrame, false);
      this.isFirstFrame = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.WebSocketWriter.FrameSink
 * JD-Core Version:    0.7.0.1
 */