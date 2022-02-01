package com.bumptech.glide.load.data;

import android.support.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class ExifOrientationStream
  extends FilterInputStream
{
  private static final byte[] a = { -1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0 };
  private static final int b = a.length;
  private static final int c = b + 2;
  private final byte d;
  private int e;
  
  public ExifOrientationStream(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    if ((paramInt >= -1) && (paramInt <= 8))
    {
      this.d = ((byte)paramInt);
      return;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Cannot add invalid orientation: ");
    paramInputStream.append(paramInt);
    throw new IllegalArgumentException(paramInputStream.toString());
  }
  
  public void mark(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
  {
    int i = this.e;
    if (i >= 2)
    {
      int j = c;
      if (i <= j)
      {
        if (i == j)
        {
          i = this.d;
          break label55;
        }
        i = a[(i - 2)] & 0xFF;
        break label55;
      }
    }
    i = super.read();
    label55:
    if (i != -1) {
      this.e += 1;
    }
    return i;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.e;
    int j = c;
    if (i > j)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    else if (i == j)
    {
      paramArrayOfByte[paramInt1] = this.d;
      paramInt1 = 1;
    }
    else if (i < 2)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, 2 - i);
    }
    else
    {
      paramInt2 = Math.min(j - i, paramInt2);
      System.arraycopy(a, this.e - 2, paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    }
    if (paramInt1 > 0) {
      this.e += paramInt1;
    }
    return paramInt1;
  }
  
  public void reset()
  {
    throw new UnsupportedOperationException();
  }
  
  public long skip(long paramLong)
  {
    paramLong = super.skip(paramLong);
    if (paramLong > 0L) {
      this.e = ((int)(this.e + paramLong));
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.ExifOrientationStream
 * JD-Core Version:    0.7.0.1
 */