package com.google.protobuf;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

final class CodedOutputStream$UnsafeDirectNioEncoder
  extends CodedOutputStream
{
  private final ByteBuffer b;
  private final ByteBuffer c;
  private final long d;
  private final long e;
  private final long f;
  private long g;
  
  private void l(long paramLong)
  {
    this.c.position(m(paramLong));
  }
  
  private int m(long paramLong)
  {
    return (int)(paramLong - this.d);
  }
  
  public void a(byte paramByte)
  {
    long l = this.g;
    if (l < this.e)
    {
      this.g = (1L + l);
      UnsafeUtil.a(l, paramByte);
      return;
    }
    throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(l), Long.valueOf(this.e), Integer.valueOf(1) }));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(WireFormat.a(paramInt1, paramInt2));
  }
  
  public void a(int paramInt, ByteString paramByteString)
  {
    a(paramInt, 2);
    a(paramByteString);
  }
  
  public void a(int paramInt, MessageLite paramMessageLite)
  {
    a(paramInt, 2);
    a(paramMessageLite);
  }
  
  void a(int paramInt, MessageLite paramMessageLite, Schema paramSchema)
  {
    a(paramInt, 2);
    a(paramMessageLite, paramSchema);
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, 2);
    a(paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0);
    a((byte)paramBoolean);
  }
  
  public void a(ByteString paramByteString)
  {
    c(paramByteString.size());
    paramByteString.writeTo(this);
  }
  
  public void a(MessageLite paramMessageLite)
  {
    c(paramMessageLite.getSerializedSize());
    paramMessageLite.writeTo(this);
  }
  
  void a(MessageLite paramMessageLite, Schema paramSchema)
  {
    c(((AbstractMessageLite)paramMessageLite).getSerializedSize(paramSchema));
    paramSchema.a(paramMessageLite, this.a);
  }
  
  public void a(String paramString)
  {
    long l = this.g;
    try
    {
      int i = j(paramString.length() * 3);
      int j = j(paramString.length());
      if (j == i)
      {
        i = m(this.g) + j;
        this.c.position(i);
        Utf8.a(paramString, this.c);
        i = this.c.position() - i;
        c(i);
        this.g += i;
        return;
      }
      i = Utf8.a(paramString);
      c(i);
      l(this.g);
      Utf8.a(paramString, this.c);
      this.g += i;
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramString);
    }
    catch (IllegalArgumentException paramString)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramString);
    }
    catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
    {
      this.g = l;
      l(this.g);
      a(paramString, localUnpairedSurrogateException);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    b(paramByteBuffer);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramArrayOfByte.length - paramInt2 >= paramInt1))
    {
      long l1 = this.e;
      long l2 = paramInt2;
      long l3 = this.g;
      if (l1 - l2 >= l3)
      {
        UnsafeUtil.a(paramArrayOfByte, paramInt1, l3, l2);
        this.g += l2;
        return;
      }
    }
    if (paramArrayOfByte == null) {
      throw new NullPointerException("value");
    }
    throw new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(this.g), Long.valueOf(this.e), Integer.valueOf(paramInt2) }));
  }
  
  public void b()
  {
    this.b.position(m(this.g));
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      c(paramInt);
      return;
    }
    b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0);
    b(paramInt2);
  }
  
  public void b(int paramInt, long paramLong)
  {
    a(paramInt, 0);
    b(paramLong);
  }
  
  public void b(int paramInt, ByteString paramByteString)
  {
    a(1, 3);
    c(2, paramInt);
    a(3, paramByteString);
    a(1, 4);
  }
  
  public void b(int paramInt, MessageLite paramMessageLite)
  {
    a(1, 3);
    c(2, paramInt);
    a(3, paramMessageLite);
    a(1, 4);
  }
  
  public void b(long paramLong)
  {
    long l = paramLong;
    if (this.g <= this.f) {
      for (;;)
      {
        if ((paramLong & 0xFFFFFF80) == 0L)
        {
          l = this.g;
          this.g = (1L + l);
          UnsafeUtil.a(l, (byte)(int)paramLong);
          return;
        }
        l = this.g;
        this.g = (l + 1L);
        UnsafeUtil.a(l, (byte)((int)paramLong & 0x7F | 0x80));
        paramLong >>>= 7;
      }
    }
    for (;;)
    {
      paramLong = this.g;
      if (paramLong >= this.e) {
        break;
      }
      if ((l & 0xFFFFFF80) == 0L)
      {
        this.g = (1L + paramLong);
        UnsafeUtil.a(paramLong, (byte)(int)l);
        return;
      }
      this.g = (paramLong + 1L);
      UnsafeUtil.a(paramLong, (byte)((int)l & 0x7F | 0x80));
      l >>>= 7;
    }
    CodedOutputStream.OutOfSpaceException localOutOfSpaceException = new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.e), Integer.valueOf(1) }));
    for (;;)
    {
      throw localOutOfSpaceException;
    }
  }
  
  public void b(ByteBuffer paramByteBuffer)
  {
    try
    {
      int i = paramByteBuffer.remaining();
      l(this.g);
      this.c.put(paramByteBuffer);
      this.g += i;
      return;
    }
    catch (BufferOverflowException paramByteBuffer)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramByteBuffer);
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int c()
  {
    return (int)(this.e - this.g);
  }
  
  public void c(int paramInt)
  {
    int i = paramInt;
    long l;
    if (this.g <= this.f) {
      for (;;)
      {
        if ((paramInt & 0xFFFFFF80) == 0)
        {
          l = this.g;
          this.g = (1L + l);
          UnsafeUtil.a(l, (byte)paramInt);
          return;
        }
        l = this.g;
        this.g = (l + 1L);
        UnsafeUtil.a(l, (byte)(paramInt & 0x7F | 0x80));
        paramInt >>>= 7;
      }
    }
    for (;;)
    {
      l = this.g;
      if (l >= this.e) {
        break;
      }
      if ((i & 0xFFFFFF80) == 0)
      {
        this.g = (1L + l);
        UnsafeUtil.a(l, (byte)i);
        return;
      }
      this.g = (l + 1L);
      UnsafeUtil.a(l, (byte)(i & 0x7F | 0x80));
      i >>>= 7;
    }
    CodedOutputStream.OutOfSpaceException localOutOfSpaceException = new CodedOutputStream.OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(l), Long.valueOf(this.e), Integer.valueOf(1) }));
    for (;;)
    {
      throw localOutOfSpaceException;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0);
    c(paramInt2);
  }
  
  public void d(int paramInt, long paramLong)
  {
    a(paramInt, 1);
    d(paramLong);
  }
  
  public void d(long paramLong)
  {
    this.c.putLong(m(this.g), paramLong);
    this.g += 8L;
  }
  
  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramInt2);
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void e(int paramInt)
  {
    this.c.putInt(m(this.g), paramInt);
    this.g += 4L;
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    a(paramInt1, 5);
    e(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedOutputStream.UnsafeDirectNioEncoder
 * JD-Core Version:    0.7.0.1
 */