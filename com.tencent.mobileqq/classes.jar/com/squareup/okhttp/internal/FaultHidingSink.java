package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class FaultHidingSink
  extends ForwardingSink
{
  private boolean hasErrors;
  
  public FaultHidingSink(Sink paramSink)
  {
    super(paramSink);
  }
  
  public void close()
  {
    if (this.hasErrors) {
      return;
    }
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }
  
  public void flush()
  {
    if (this.hasErrors) {
      return;
    }
    try
    {
      super.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }
  
  protected void onException(IOException paramIOException) {}
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (this.hasErrors)
    {
      paramBuffer.skip(paramLong);
      return;
    }
    try
    {
      super.write(paramBuffer, paramLong);
      return;
    }
    catch (IOException paramBuffer)
    {
      this.hasErrors = true;
      onException(paramBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.FaultHidingSink
 * JD-Core Version:    0.7.0.1
 */