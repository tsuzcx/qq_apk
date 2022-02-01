package com.tencent.luggage.wxa.rt;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

class f$c
  extends FileInputStream
{
  private long a = 0L;
  
  f$c(String paramString)
  {
    super(paramString);
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.a = getChannel().position();
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void reset()
  {
    getChannel().position(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.f.c
 * JD-Core Version:    0.7.0.1
 */