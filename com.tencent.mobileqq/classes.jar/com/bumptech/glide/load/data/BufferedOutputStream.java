package com.bumptech.glide.load.data;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.OutputStream;

public final class BufferedOutputStream
  extends OutputStream
{
  @NonNull
  private final OutputStream a;
  private byte[] b;
  private ArrayPool c;
  private int d;
  
  public BufferedOutputStream(@NonNull OutputStream paramOutputStream, @NonNull ArrayPool paramArrayPool)
  {
    this(paramOutputStream, paramArrayPool, 65536);
  }
  
  @VisibleForTesting
  BufferedOutputStream(@NonNull OutputStream paramOutputStream, ArrayPool paramArrayPool, int paramInt)
  {
    this.a = paramOutputStream;
    this.c = paramArrayPool;
    this.b = ((byte[])paramArrayPool.a(paramInt, [B.class));
  }
  
  private void a()
  {
    int i = this.d;
    if (i > 0)
    {
      this.a.write(this.b, 0, i);
      this.d = 0;
    }
  }
  
  private void b()
  {
    if (this.d == this.b.length) {
      a();
    }
  }
  
  private void c()
  {
    byte[] arrayOfByte = this.b;
    if (arrayOfByte != null)
    {
      this.c.a(arrayOfByte);
      this.b = null;
    }
  }
  
  public void close()
  {
    try
    {
      flush();
      this.a.close();
      c();
      return;
    }
    finally
    {
      this.a.close();
    }
  }
  
  public void flush()
  {
    a();
    this.a.flush();
  }
  
  public void write(int paramInt)
  {
    byte[] arrayOfByte = this.b;
    int i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    b();
  }
  
  public void write(@NonNull byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j;
    do
    {
      int k = paramInt2 - i;
      j = paramInt1 + i;
      if ((this.d == 0) && (k >= this.b.length))
      {
        this.a.write(paramArrayOfByte, j, k);
        return;
      }
      k = Math.min(k, this.b.length - this.d);
      System.arraycopy(paramArrayOfByte, j, this.b, this.d, k);
      this.d += k;
      j = i + k;
      b();
      i = j;
    } while (j < paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.BufferedOutputStream
 * JD-Core Version:    0.7.0.1
 */