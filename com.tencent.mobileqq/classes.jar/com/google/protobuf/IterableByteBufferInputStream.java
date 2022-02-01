package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

class IterableByteBufferInputStream
  extends InputStream
{
  private Iterator<ByteBuffer> a;
  private ByteBuffer b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private byte[] g;
  private int h;
  private long i;
  
  private void a(int paramInt)
  {
    this.e += paramInt;
    if (this.e == this.b.limit()) {
      a();
    }
  }
  
  private boolean a()
  {
    this.d += 1;
    if (!this.a.hasNext()) {
      return false;
    }
    this.b = ((ByteBuffer)this.a.next());
    this.e = this.b.position();
    if (this.b.hasArray())
    {
      this.f = true;
      this.g = this.b.array();
      this.h = this.b.arrayOffset();
      return true;
    }
    this.f = false;
    this.i = UnsafeUtil.a(this.b);
    this.g = null;
    return true;
  }
  
  public int read()
  {
    if (this.d == this.c) {
      return -1;
    }
    if (this.f)
    {
      j = this.g[(this.e + this.h)];
      a(1);
      return j & 0xFF;
    }
    int j = UnsafeUtil.a(this.e + this.i);
    a(1);
    return j & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.d == this.c) {
      return -1;
    }
    int k = this.b.limit() - this.e;
    int j = paramInt2;
    if (paramInt2 > k) {
      j = k;
    }
    if (this.f)
    {
      System.arraycopy(this.g, this.e + this.h, paramArrayOfByte, paramInt1, j);
      a(j);
      return j;
    }
    paramInt2 = this.b.position();
    this.b.position(this.e);
    this.b.get(paramArrayOfByte, paramInt1, j);
    this.b.position(paramInt2);
    a(j);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.IterableByteBufferInputStream
 * JD-Core Version:    0.7.0.1
 */