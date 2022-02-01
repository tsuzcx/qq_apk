package com.google.protobuf;

import java.nio.ByteBuffer;

final class CodedOutputStream$ByteOutputEncoder
  extends CodedOutputStream.AbstractBufferedEncoder
{
  private final ByteOutput f;
  
  private void f()
  {
    this.f.a(this.b, 0, this.d);
    this.d = 0;
  }
  
  private void v(int paramInt)
  {
    if (this.c - this.d < paramInt) {
      f();
    }
  }
  
  public void a(byte paramByte)
  {
    if (this.d == this.c) {
      f();
    }
    b(paramByte);
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
    v(11);
    n(paramInt, 0);
    b((byte)paramBoolean);
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
    int i = paramString.length() * 3;
    int j = j(i);
    int k = j + i;
    if (k > this.c)
    {
      byte[] arrayOfByte = new byte[i];
      i = Utf8.a(paramString, arrayOfByte, 0, i);
      c(i);
      b(arrayOfByte, 0, i);
      return;
    }
    if (k > this.c - this.d) {
      f();
    }
    i = this.d;
    try
    {
      k = j(paramString.length());
      if (k == j)
      {
        this.d = (i + k);
        j = Utf8.a(paramString, this.b, this.d, this.c - this.d);
        this.d = i;
        k = j - i - k;
        t(k);
        this.d = j;
        this.e += k;
        return;
      }
      j = Utf8.a(paramString);
      t(j);
      this.d = Utf8.a(paramString, this.b, this.d, j);
      this.e += j;
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramString);
    }
    catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
    {
      this.e -= this.d - i;
      this.d = i;
      a(paramString, localUnpairedSurrogateException);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    b();
    int i = paramByteBuffer.remaining();
    this.f.a(paramByteBuffer);
    this.e += i;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b();
    this.f.a(paramArrayOfByte, paramInt1, paramInt2);
    this.e += paramInt2;
  }
  
  public void b()
  {
    if (this.d > 0) {
      f();
    }
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
    v(20);
    n(paramInt1, 0);
    s(paramInt2);
  }
  
  public void b(int paramInt, long paramLong)
  {
    v(20);
    n(paramInt, 0);
    l(paramLong);
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
    v(10);
    l(paramLong);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b();
    this.f.b(paramArrayOfByte, paramInt1, paramInt2);
    this.e += paramInt2;
  }
  
  public void c(int paramInt)
  {
    v(5);
    t(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    v(20);
    n(paramInt1, 0);
    t(paramInt2);
  }
  
  public void d(int paramInt, long paramLong)
  {
    v(18);
    n(paramInt, 1);
    m(paramLong);
  }
  
  public void d(long paramLong)
  {
    v(8);
    m(paramLong);
  }
  
  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramInt2);
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void e(int paramInt)
  {
    v(4);
    u(paramInt);
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    v(14);
    n(paramInt1, 5);
    u(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedOutputStream.ByteOutputEncoder
 * JD-Core Version:    0.7.0.1
 */