package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;

public class MarkEnforcingInputStream
  extends FilterInputStream
{
  private int a = -2147483648;
  
  public MarkEnforcingInputStream(@NonNull InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private long a(long paramLong)
  {
    int i = this.a;
    if (i == 0) {
      return -1L;
    }
    long l = paramLong;
    if (i != -2147483648)
    {
      l = paramLong;
      if (paramLong > i) {
        l = i;
      }
    }
    return l;
  }
  
  private void b(long paramLong)
  {
    int i = this.a;
    if ((i != -2147483648) && (paramLong != -1L)) {
      this.a = ((int)(i - paramLong));
    }
  }
  
  public int available()
  {
    int i = this.a;
    if (i == -2147483648) {
      return super.available();
    }
    return Math.min(i, super.available());
  }
  
  public void mark(int paramInt)
  {
    try
    {
      super.mark(paramInt);
      this.a = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int read()
  {
    if (a(1L) == -1L) {
      return -1;
    }
    int i = super.read();
    b(1L);
    return i;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = (int)a(paramInt2);
    if (paramInt2 == -1) {
      return -1;
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    b(paramInt1);
    return paramInt1;
  }
  
  public void reset()
  {
    try
    {
      super.reset();
      this.a = -2147483648;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    paramLong = a(paramLong);
    if (paramLong == -1L) {
      return 0L;
    }
    paramLong = super.skip(paramLong);
    b(paramLong);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.MarkEnforcingInputStream
 * JD-Core Version:    0.7.0.1
 */