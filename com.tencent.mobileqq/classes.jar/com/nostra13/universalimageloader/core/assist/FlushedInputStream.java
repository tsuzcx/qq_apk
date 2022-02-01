package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.InputStream;

public class FlushedInputStream
  extends FilterInputStream
{
  public FlushedInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public long skip(long paramLong)
  {
    long l2;
    for (long l1 = 0L; l1 < paramLong; l1 += l2)
    {
      long l3 = this.in.skip(paramLong - l1);
      l2 = l3;
      if (l3 == 0L)
      {
        if (read() < 0) {
          return l1;
        }
        l2 = 1L;
      }
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.FlushedInputStream
 * JD-Core Version:    0.7.0.1
 */