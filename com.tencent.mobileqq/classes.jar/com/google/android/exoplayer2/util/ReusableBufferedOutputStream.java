package com.google.android.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public final class ReusableBufferedOutputStream
  extends BufferedOutputStream
{
  private boolean closed;
  
  public ReusableBufferedOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public ReusableBufferedOutputStream(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream, paramInt);
  }
  
  public void close()
  {
    this.closed = true;
    Object localObject1 = null;
    try
    {
      flush();
      try
      {
        label11:
        this.out.close();
        localObject2 = localObject1;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          if (localObject1 != null) {
            Object localObject3 = localObject1;
          }
        }
      }
      if (localObject2 != null) {
        Util.sneakyThrow(localObject2);
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      break label11;
    }
  }
  
  public void reset(OutputStream paramOutputStream)
  {
    Assertions.checkState(this.closed);
    this.out = paramOutputStream;
    this.count = 0;
    this.closed = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ReusableBufferedOutputStream
 * JD-Core Version:    0.7.0.1
 */