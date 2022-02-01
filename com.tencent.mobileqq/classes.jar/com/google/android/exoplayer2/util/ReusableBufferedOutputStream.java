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
    try
    {
      flush();
      Object localObject1 = null;
    }
    catch (Throwable localThrowable1) {}
    Object localObject2;
    try
    {
      this.out.close();
      localObject2 = localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      localObject2 = localThrowable1;
      if (localThrowable1 == null) {
        localObject2 = localThrowable2;
      }
    }
    if (localObject2 != null) {
      Util.sneakyThrow((Throwable)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ReusableBufferedOutputStream
 * JD-Core Version:    0.7.0.1
 */