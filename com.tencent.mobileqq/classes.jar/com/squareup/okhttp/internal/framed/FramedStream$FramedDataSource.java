package com.squareup.okhttp.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

final class FramedStream$FramedDataSource
  implements Source
{
  private boolean closed;
  private boolean finished;
  private final long maxByteCount;
  private final Buffer readBuffer = new Buffer();
  private final Buffer receiveBuffer = new Buffer();
  
  static
  {
    if (!FramedStream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FramedStream$FramedDataSource(FramedStream paramFramedStream, long paramLong)
  {
    this.maxByteCount = paramLong;
  }
  
  private void checkNotClosed()
  {
    if (this.closed) {
      throw new IOException("stream closed");
    }
    if (FramedStream.access$800(this.this$0) != null) {
      throw new IOException("stream was reset: " + FramedStream.access$800(this.this$0));
    }
  }
  
  private void waitUntilReadable()
  {
    FramedStream.access$700(this.this$0).enter();
    try
    {
      if (this.readBuffer.size() == 0L) {
        if ((!this.finished) && (!this.closed) && (FramedStream.access$800(this.this$0) == null)) {
          FramedStream.access$900(this.this$0);
        }
      }
      return;
    }
    finally
    {
      FramedStream.access$700(this.this$0).exitAndThrowIfTimedOut();
    }
  }
  
  public void close()
  {
    synchronized (this.this$0)
    {
      this.closed = true;
      this.readBuffer.clear();
      this.this$0.notifyAll();
      FramedStream.access$1000(this.this$0);
      return;
    }
  }
  
  public long read(Buffer arg1, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    synchronized (this.this$0)
    {
      waitUntilReadable();
      checkNotClosed();
      if (this.readBuffer.size() == 0L) {
        return -1L;
      }
      paramLong = this.readBuffer.read(???, Math.min(paramLong, this.readBuffer.size()));
      ??? = this.this$0;
      ???.unacknowledgedBytesRead += paramLong;
      if (this.this$0.unacknowledgedBytesRead >= FramedStream.access$500(this.this$0).okHttpSettings.getInitialWindowSize(65536) / 2)
      {
        FramedStream.access$500(this.this$0).writeWindowUpdateLater(FramedStream.access$600(this.this$0), this.this$0.unacknowledgedBytesRead);
        this.this$0.unacknowledgedBytesRead = 0L;
      }
      synchronized (FramedStream.access$500(this.this$0))
      {
        ??? = FramedStream.access$500(this.this$0);
        ((FramedConnection)???).unacknowledgedBytesRead += paramLong;
        if (FramedStream.access$500(this.this$0).unacknowledgedBytesRead >= FramedStream.access$500(this.this$0).okHttpSettings.getInitialWindowSize(65536) / 2)
        {
          FramedStream.access$500(this.this$0).writeWindowUpdateLater(0, FramedStream.access$500(this.this$0).unacknowledgedBytesRead);
          FramedStream.access$500(this.this$0).unacknowledgedBytesRead = 0L;
        }
        return paramLong;
      }
    }
  }
  
  void receive(BufferedSource paramBufferedSource, long paramLong)
  {
    long l = paramLong;
    if (!$assertionsDisabled)
    {
      l = paramLong;
      if (Thread.holdsLock(this.this$0)) {
        throw new AssertionError();
      }
    }
    for (;;)
    {
      l -= paramLong;
      synchronized (this.this$0)
      {
        if (this.readBuffer.size() == 0L)
        {
          i = 1;
          this.readBuffer.writeAll(this.receiveBuffer);
          if (i != 0) {
            this.this$0.notifyAll();
          }
          if (l > 0L) {}
          boolean bool;
          synchronized (this.this$0)
          {
            bool = this.finished;
            if (this.readBuffer.size() + l > this.maxByteCount)
            {
              i = 1;
              if (i != 0)
              {
                paramBufferedSource.skip(l);
                this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
              }
            }
            else
            {
              i = 0;
            }
          }
          if (bool)
          {
            paramBufferedSource.skip(l);
            return;
          }
          paramLong = paramBufferedSource.read(this.receiveBuffer, l);
          if (paramLong != -1L) {
            continue;
          }
          throw new EOFException();
        }
        int i = 0;
      }
    }
  }
  
  public Timeout timeout()
  {
    return FramedStream.access$700(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedStream.FramedDataSource
 * JD-Core Version:    0.7.0.1
 */