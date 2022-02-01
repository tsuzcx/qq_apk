package com.google.protobuf;

abstract class CodedOutputStream$AbstractBufferedEncoder
  extends CodedOutputStream
{
  final byte[] b;
  final int c;
  int d;
  int e;
  
  CodedOutputStream$AbstractBufferedEncoder(int paramInt)
  {
    super(null);
    if (paramInt >= 0)
    {
      this.b = new byte[Math.max(paramInt, 20)];
      this.c = this.b.length;
      return;
    }
    throw new IllegalArgumentException("bufferSize must be >= 0");
  }
  
  final void b(byte paramByte)
  {
    byte[] arrayOfByte = this.b;
    int i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = paramByte;
    this.e += 1;
  }
  
  public final int c()
  {
    throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
  }
  
  final void l(long paramLong)
  {
    long l = paramLong;
    byte[] arrayOfByte;
    int i;
    if (CodedOutputStream.e())
    {
      l = this.d;
      for (;;)
      {
        if ((paramLong & 0xFFFFFF80) == 0L)
        {
          arrayOfByte = this.b;
          i = this.d;
          this.d = (i + 1);
          UnsafeUtil.a(arrayOfByte, i, (byte)(int)paramLong);
          i = (int)(this.d - l);
          this.e += i;
          return;
        }
        arrayOfByte = this.b;
        i = this.d;
        this.d = (i + 1);
        UnsafeUtil.a(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
        paramLong >>>= 7;
      }
    }
    for (;;)
    {
      if ((l & 0xFFFFFF80) == 0L)
      {
        arrayOfByte = this.b;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)(int)l);
        this.e += 1;
        return;
      }
      arrayOfByte = this.b;
      i = this.d;
      this.d = (i + 1);
      arrayOfByte[i] = ((byte)((int)l & 0x7F | 0x80));
      this.e += 1;
      l >>>= 7;
    }
  }
  
  final void m(long paramLong)
  {
    byte[] arrayOfByte = this.b;
    int i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 8 & 0xFF));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 16 & 0xFF));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)(int)(0xFF & paramLong >> 24));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 32) & 0xFF));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 48) & 0xFF));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
    this.e += 8;
  }
  
  final void n(int paramInt1, int paramInt2)
  {
    t(WireFormat.a(paramInt1, paramInt2));
  }
  
  final void s(int paramInt)
  {
    if (paramInt >= 0)
    {
      t(paramInt);
      return;
    }
    l(paramInt);
  }
  
  final void t(int paramInt)
  {
    int i = paramInt;
    byte[] arrayOfByte;
    if (CodedOutputStream.e())
    {
      long l = this.d;
      for (;;)
      {
        if ((paramInt & 0xFFFFFF80) == 0)
        {
          arrayOfByte = this.b;
          i = this.d;
          this.d = (i + 1);
          UnsafeUtil.a(arrayOfByte, i, (byte)paramInt);
          paramInt = (int)(this.d - l);
          this.e += paramInt;
          return;
        }
        arrayOfByte = this.b;
        i = this.d;
        this.d = (i + 1);
        UnsafeUtil.a(arrayOfByte, i, (byte)(paramInt & 0x7F | 0x80));
        paramInt >>>= 7;
      }
    }
    for (;;)
    {
      if ((i & 0xFFFFFF80) == 0)
      {
        arrayOfByte = this.b;
        paramInt = this.d;
        this.d = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)i);
        this.e += 1;
        return;
      }
      arrayOfByte = this.b;
      paramInt = this.d;
      this.d = (paramInt + 1);
      arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
      this.e += 1;
      i >>>= 7;
    }
  }
  
  final void u(int paramInt)
  {
    byte[] arrayOfByte = this.b;
    int i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 16 & 0xFF));
    i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
    this.e += 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedOutputStream.AbstractBufferedEncoder
 * JD-Core Version:    0.7.0.1
 */