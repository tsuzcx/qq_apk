package com.bumptech.glide.load.resource.bitmap;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream
  extends FilterInputStream
{
  private volatile byte[] a;
  private int b;
  private int c;
  private int d = -1;
  private int e;
  private final ArrayPool f;
  
  public RecyclableBufferedInputStream(@NonNull InputStream paramInputStream, @NonNull ArrayPool paramArrayPool)
  {
    this(paramInputStream, paramArrayPool, 65536);
  }
  
  @VisibleForTesting
  RecyclableBufferedInputStream(@NonNull InputStream paramInputStream, @NonNull ArrayPool paramArrayPool, int paramInt)
  {
    super(paramInputStream);
    this.f = paramArrayPool;
    this.a = ((byte[])paramArrayPool.a(paramInt, [B.class));
  }
  
  private int a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    int i = this.d;
    if (i != -1)
    {
      int k = this.e;
      int j = this.c;
      if (k - i < j)
      {
        byte[] arrayOfByte;
        if ((i == 0) && (j > paramArrayOfByte.length) && (this.b == paramArrayOfByte.length))
        {
          k = paramArrayOfByte.length * 2;
          i = k;
          if (k > j) {
            i = j;
          }
          arrayOfByte = (byte[])this.f.a(i, [B.class);
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
          this.a = arrayOfByte;
          this.f.a(paramArrayOfByte);
        }
        else
        {
          i = this.d;
          arrayOfByte = paramArrayOfByte;
          if (i > 0)
          {
            System.arraycopy(paramArrayOfByte, i, paramArrayOfByte, 0, paramArrayOfByte.length - i);
            arrayOfByte = paramArrayOfByte;
          }
        }
        this.e -= this.d;
        this.d = 0;
        this.b = 0;
        i = this.e;
        j = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
        if (j <= 0) {
          i = this.e;
        } else {
          i = this.e + j;
        }
        this.b = i;
        return j;
      }
    }
    i = paramInputStream.read(paramArrayOfByte);
    if (i > 0)
    {
      this.d = -1;
      this.e = 0;
      this.b = i;
    }
    return i;
  }
  
  private static IOException c()
  {
    throw new IOException("BufferedInputStream is closed");
  }
  
  public void a()
  {
    try
    {
      this.c = this.a.length;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int available()
  {
    try
    {
      InputStream localInputStream = this.in;
      if ((this.a != null) && (localInputStream != null))
      {
        int i = this.b;
        int j = this.e;
        int k = localInputStream.available();
        return i - j + k;
      }
      throw c();
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      if (this.a != null)
      {
        this.f.a(this.a);
        this.a = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void close()
  {
    if (this.a != null)
    {
      this.f.a(this.a);
      this.a = null;
    }
    InputStream localInputStream = this.in;
    this.in = null;
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.c = Math.max(this.c, paramInt);
      this.d = this.e;
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
      byte[] arrayOfByte = this.a;
      Object localObject1 = this.in;
      if ((arrayOfByte != null) && (localObject1 != null))
      {
        int i;
        if (this.e >= this.b)
        {
          i = a((InputStream)localObject1, arrayOfByte);
          if (i == -1) {
            return -1;
          }
        }
        localObject1 = arrayOfByte;
        if (arrayOfByte != this.a)
        {
          localObject1 = this.a;
          if (localObject1 == null) {
            throw c();
          }
        }
        if (this.b - this.e > 0)
        {
          i = this.e;
          this.e = (i + 1);
          i = localObject1[i];
          return i & 0xFF;
        }
        return -1;
      }
      throw c();
    }
    finally {}
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject1 = this.a;
      if (localObject1 != null)
      {
        if (paramInt2 == 0) {
          return 0;
        }
        InputStream localInputStream = this.in;
        if (localInputStream != null)
        {
          int i;
          int j;
          if (this.e < this.b)
          {
            if (this.b - this.e >= paramInt2) {
              i = paramInt2;
            } else {
              i = this.b - this.e;
            }
            System.arraycopy(localObject1, this.e, paramArrayOfByte, paramInt1, i);
            this.e += i;
            if (i != paramInt2)
            {
              j = localInputStream.available();
              if (j != 0)
              {
                j = paramInt1 + i;
                paramInt1 = paramInt2 - i;
                i = j;
                break label150;
              }
            }
            return i;
          }
          else
          {
            j = paramInt2;
            i = paramInt1;
            paramInt1 = j;
          }
          for (;;)
          {
            label150:
            int k = this.d;
            j = -1;
            if ((k == -1) && (paramInt1 >= localObject1.length))
            {
              int m = localInputStream.read(paramArrayOfByte, i, paramInt1);
              k = m;
              if (m == -1)
              {
                if (paramInt1 != paramInt2) {
                  j = paramInt2 - paramInt1;
                }
                return j;
              }
            }
            else
            {
              k = a(localInputStream, (byte[])localObject1);
              if (k == -1)
              {
                if (paramInt1 != paramInt2) {
                  j = paramInt2 - paramInt1;
                }
                return j;
              }
              Object localObject2 = localObject1;
              if (localObject1 != this.a)
              {
                localObject2 = this.a;
                if (localObject2 == null) {
                  throw c();
                }
              }
              if (this.b - this.e >= paramInt1) {
                j = paramInt1;
              } else {
                j = this.b - this.e;
              }
              System.arraycopy(localObject2, this.e, paramArrayOfByte, i, j);
              this.e += j;
              k = j;
              localObject1 = localObject2;
            }
            paramInt1 -= k;
            if (paramInt1 == 0) {
              return paramInt2;
            }
            j = localInputStream.available();
            if (j == 0) {
              return paramInt2 - paramInt1;
            }
            i += k;
          }
        }
        throw c();
      }
      throw c();
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
      if (this.a != null)
      {
        if (-1 != this.d)
        {
          this.e = this.d;
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Mark has been invalidated, pos: ");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" markLimit: ");
        localStringBuilder.append(this.c);
        throw new RecyclableBufferedInputStream.InvalidMarkException(localStringBuilder.toString());
      }
      throw new IOException("Stream is closed");
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    if (paramLong < 1L) {
      return 0L;
    }
    try
    {
      byte[] arrayOfByte = this.a;
      if (arrayOfByte != null)
      {
        InputStream localInputStream = this.in;
        if (localInputStream != null)
        {
          if (this.b - this.e >= paramLong)
          {
            this.e = ((int)(this.e + paramLong));
            return paramLong;
          }
          long l1 = this.b - this.e;
          this.e = this.b;
          if ((this.d != -1) && (paramLong <= this.c))
          {
            int i = a(localInputStream, arrayOfByte);
            if (i == -1) {
              return l1;
            }
            if (this.b - this.e >= paramLong - l1)
            {
              this.e = ((int)(this.e + paramLong - l1));
              return paramLong;
            }
            paramLong = this.b;
            long l2 = this.e;
            this.e = this.b;
            return l1 + paramLong - l2;
          }
          paramLong = localInputStream.skip(paramLong - l1);
          return l1 + paramLong;
        }
        throw c();
      }
      throw c();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream
 * JD-Core Version:    0.7.0.1
 */