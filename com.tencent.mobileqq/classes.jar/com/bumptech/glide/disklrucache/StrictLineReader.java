package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class StrictLineReader
  implements Closeable
{
  private final InputStream a;
  private final Charset b;
  private byte[] c;
  private int d;
  private int e;
  
  public StrictLineReader(InputStream paramInputStream, int paramInt, Charset paramCharset)
  {
    if ((paramInputStream != null) && (paramCharset != null))
    {
      if (paramInt >= 0)
      {
        if (paramCharset.equals(Util.a))
        {
          this.a = paramInputStream;
          this.b = paramCharset;
          this.c = new byte[paramInt];
          return;
        }
        throw new IllegalArgumentException("Unsupported encoding");
      }
      throw new IllegalArgumentException("capacity <= 0");
    }
    throw new NullPointerException();
  }
  
  public StrictLineReader(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, 8192, paramCharset);
  }
  
  private void c()
  {
    InputStream localInputStream = this.a;
    byte[] arrayOfByte = this.c;
    int i = localInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (i != -1)
    {
      this.d = 0;
      this.e = i;
      return;
    }
    throw new EOFException();
  }
  
  public String a()
  {
    int i;
    int j;
    label276:
    label283:
    synchronized (this.a)
    {
      if (this.c != null)
      {
        if (this.d >= this.e) {
          c();
        }
        i = this.d;
        Object localObject1;
        if (i != this.e)
        {
          if (this.c[i] != 10) {
            break label276;
          }
          if (i != this.d)
          {
            localObject1 = this.c;
            j = i - 1;
            if (localObject1[j] == 13)
            {
              localObject1 = new String(this.c, this.d, j - this.d, this.b.name());
              this.d = (i + 1);
              return localObject1;
            }
          }
        }
        else
        {
          localObject1 = new StrictLineReader.1(this, this.e - this.d + 80);
          do
          {
            ((ByteArrayOutputStream)localObject1).write(this.c, this.d, this.e - this.d);
            this.e = -1;
            c();
            i = this.d;
          } while (i == this.e);
          if (this.c[i] != 10) {
            break label283;
          }
          if (i != this.d) {
            ((ByteArrayOutputStream)localObject1).write(this.c, this.d, i - this.d);
          }
          this.d = (i + 1);
          localObject1 = ((ByteArrayOutputStream)localObject1).toString();
          return localObject1;
        }
      }
      else
      {
        throw new IOException("LineReader is closed");
      }
    }
  }
  
  public boolean b()
  {
    return this.e == -1;
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.c != null)
      {
        this.c = null;
        this.a.close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.disklrucache.StrictLineReader
 * JD-Core Version:    0.7.0.1
 */