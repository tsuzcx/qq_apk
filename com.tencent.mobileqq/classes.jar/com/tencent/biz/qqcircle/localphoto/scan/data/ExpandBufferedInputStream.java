package com.tencent.biz.qqcircle.localphoto.scan.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class ExpandBufferedInputStream
  extends FilterInputStream
{
  private static int f = 8192;
  private static final AtomicReferenceFieldUpdater<ExpandBufferedInputStream, byte[]> g = AtomicReferenceFieldUpdater.newUpdater(ExpandBufferedInputStream.class, [B.class, "buf");
  protected volatile byte[] a;
  protected int b;
  protected int c;
  protected int d = -1;
  protected int e;
  
  public ExpandBufferedInputStream(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    super(paramInputStream);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      this.a = paramArrayOfByte;
      return;
    }
    throw new IllegalArgumentException("Buffer size <= 0");
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = this.b - this.c;
    int i = j;
    if (j <= 0)
    {
      if ((paramInt2 >= b().length) && (this.d < 0)) {
        return a().read(paramArrayOfByte, paramInt1, paramInt2);
      }
      c();
      j = this.b - this.c;
      i = j;
      if (j <= 0) {
        return -1;
      }
    }
    j = paramInt2;
    if (i < paramInt2) {
      j = i;
    }
    System.arraycopy(b(), this.c, paramArrayOfByte, paramInt1, j);
    this.c += j;
    return j;
  }
  
  private InputStream a()
  {
    InputStream localInputStream = this.in;
    if (localInputStream != null) {
      return localInputStream;
    }
    throw new IOException("Stream closed");
  }
  
  private byte[] b()
  {
    byte[] arrayOfByte = this.a;
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    throw new IOException("Stream closed");
  }
  
  private void c()
  {
    Object localObject2 = b();
    int j = this.d;
    Object localObject1;
    if (j < 0)
    {
      this.c = 0;
      localObject1 = localObject2;
    }
    else
    {
      i = this.c;
      localObject1 = localObject2;
      if (i >= localObject2.length) {
        if (j > 0)
        {
          i -= j;
          System.arraycopy(localObject2, j, localObject2, 0, i);
          this.c = i;
          this.d = 0;
          localObject1 = localObject2;
        }
        else
        {
          int k = localObject2.length;
          j = this.e;
          if (k >= j)
          {
            this.d = -1;
            this.c = 0;
            localObject1 = localObject2;
          }
          else
          {
            k = i * 2;
            i = k;
            if (k > j) {
              i = j;
            }
            localObject1 = new byte[i];
            System.arraycopy(localObject2, 0, localObject1, 0, this.c);
            if (!g.compareAndSet(this, localObject2, localObject1)) {
              throw new IOException("Stream closed");
            }
          }
        }
      }
    }
    this.b = this.c;
    localObject2 = a();
    int i = this.c;
    i = ((InputStream)localObject2).read((byte[])localObject1, i, localObject1.length - i);
    if (i > 0) {
      this.b = (i + this.c);
    }
  }
  
  public int available()
  {
    try
    {
      int j = this.b - this.c;
      int k = a().available();
      int i = 2147483647;
      if (j <= 2147483647 - k) {
        i = j + k;
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void close()
  {
    do
    {
      localObject = this.a;
      if (localObject == null) {
        break;
      }
    } while (!g.compareAndSet(this, localObject, null));
    Object localObject = this.in;
    this.in = null;
    if (localObject != null) {
      ((InputStream)localObject).close();
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.e = paramInt;
      this.d = this.c;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    try
    {
      if (this.c >= this.b)
      {
        c();
        i = this.c;
        int j = this.b;
        if (i >= j) {
          return -1;
        }
      }
      byte[] arrayOfByte = b();
      int i = this.c;
      this.c = (i + 1);
      i = arrayOfByte[i];
      return i & 0xFF;
    }
    finally {}
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      b();
      int i = paramInt1 + paramInt2;
      int j = paramArrayOfByte.length;
      if ((paramInt1 | paramInt2 | i | j - i) >= 0)
      {
        i = 0;
        if (paramInt2 == 0) {
          return 0;
        }
        int k;
        do
        {
          InputStream localInputStream;
          do
          {
            j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
            if (j <= 0)
            {
              paramInt1 = i;
              if (i == 0) {
                paramInt1 = j;
              }
              return paramInt1;
            }
            j = i + j;
            if (j >= paramInt2) {
              return j;
            }
            localInputStream = this.in;
            i = j;
          } while (localInputStream == null);
          k = localInputStream.available();
          i = j;
        } while (k > 0);
        return j;
      }
      throw new IndexOutOfBoundsException();
    }
    finally {}
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public void reset()
  {
    try
    {
      b();
      if (this.d >= 0)
      {
        this.c = this.d;
        return;
      }
      throw new IOException("Resetting to invalid mark");
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    try
    {
      b();
      if (paramLong <= 0L) {
        return 0L;
      }
      long l2 = this.b - this.c;
      long l1 = l2;
      if (l2 <= 0L)
      {
        if (this.d < 0)
        {
          paramLong = a().skip(paramLong);
          return paramLong;
        }
        c();
        int i = this.b;
        int j = this.c;
        l2 = i - j;
        l1 = l2;
        if (l2 <= 0L) {
          return 0L;
        }
      }
      l2 = paramLong;
      if (l1 < paramLong) {
        l2 = l1;
      }
      this.c = ((int)(this.c + l2));
      return l2;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.data.ExpandBufferedInputStream
 * JD-Core Version:    0.7.0.1
 */