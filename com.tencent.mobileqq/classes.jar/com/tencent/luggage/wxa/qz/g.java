package com.tencent.luggage.wxa.qz;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public class g
  extends FilterInputStream
{
  private long a = 0L;
  
  public g(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.a = ((FileInputStream)this.in).getChannel().position();
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.FileSeekingInputStream", localException, "Failed seeking FileChannel.", new Object[0]);
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void reset()
  {
    ((FileInputStream)this.in).getChannel().position(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.g
 * JD-Core Version:    0.7.0.1
 */