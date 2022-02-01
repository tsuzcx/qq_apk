package com.google.protobuf;

import java.io.InputStream;

class RopeByteString$RopeInputStream
  extends InputStream
{
  private RopeByteString.PieceIterator b;
  private ByteString.LeafByteString c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public RopeByteString$RopeInputStream(RopeByteString paramRopeByteString)
  {
    a();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    paramInt1 = paramInt2;
    while (paramInt1 > 0)
    {
      b();
      if (this.c == null)
      {
        if (paramInt1 != paramInt2) {
          break;
        }
        return -1;
      }
      int k = Math.min(this.d - this.e, paramInt1);
      int j = i;
      if (paramArrayOfByte != null)
      {
        this.c.copyTo(paramArrayOfByte, this.e, i, k);
        j = i + k;
      }
      this.e += k;
      paramInt1 -= k;
      i = j;
    }
    return paramInt2 - paramInt1;
  }
  
  private void a()
  {
    this.b = new RopeByteString.PieceIterator(this.a, null);
    this.c = this.b.a();
    this.d = this.c.size();
    this.e = 0;
    this.f = 0;
  }
  
  private void b()
  {
    if (this.c != null)
    {
      int i = this.e;
      int j = this.d;
      if (i == j)
      {
        this.f += j;
        this.e = 0;
        if (this.b.hasNext())
        {
          this.c = this.b.a();
          this.d = this.c.size();
          return;
        }
        this.c = null;
        this.d = 0;
      }
    }
  }
  
  public int available()
  {
    int i = this.f;
    int j = this.e;
    return this.a.size() - (i + j);
  }
  
  public void mark(int paramInt)
  {
    this.g = (this.f + this.e);
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    b();
    ByteString.LeafByteString localLeafByteString = this.c;
    if (localLeafByteString == null) {
      return -1;
    }
    int i = this.e;
    this.e = (i + 1);
    return localLeafByteString.byteAt(i) & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt1)) {
        return a(paramArrayOfByte, paramInt1, paramInt2);
      }
      throw new IndexOutOfBoundsException();
    }
    throw new NullPointerException();
  }
  
  public void reset()
  {
    try
    {
      a();
      a(null, 0, this.g);
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
    if (paramLong >= 0L)
    {
      long l = paramLong;
      if (paramLong > 2147483647L) {
        l = 2147483647L;
      }
      return a(null, 0, (int)l);
    }
    throw new IndexOutOfBoundsException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RopeByteString.RopeInputStream
 * JD-Core Version:    0.7.0.1
 */