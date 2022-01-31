package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.net.SocketTimeoutException;
import okio.AsyncTimeout;

class FramedStream$StreamTimeout
  extends AsyncTimeout
{
  FramedStream$StreamTimeout(FramedStream paramFramedStream) {}
  
  public void exitAndThrowIfTimedOut()
  {
    if (exit()) {
      throw newTimeoutException(null);
    }
  }
  
  public IOException newTimeoutException(IOException paramIOException)
  {
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause(paramIOException);
    }
    return localSocketTimeoutException;
  }
  
  public void timedOut()
  {
    this.this$0.closeLater(ErrorCode.CANCEL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedStream.StreamTimeout
 * JD-Core Version:    0.7.0.1
 */