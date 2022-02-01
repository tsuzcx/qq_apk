package com.google.protobuf;

import java.io.OutputStream;
import java.nio.ByteBuffer;

final class CodedOutputStream$OutputStreamEncoder
  extends CodedOutputStream.AbstractBufferedEncoder
{
  private final OutputStream f;
  
  CodedOutputStream$OutputStreamEncoder(OutputStream paramOutputStream, int paramInt)
  {
    super(paramInt);
    if (paramOutputStream != null)
    {
      this.f = paramOutputStream;
      return;
    }
    throw new NullPointerException("out");
  }
  
  private void f()
  {
    this.f.write(this.b, 0, this.d);
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
    try
    {
      int j = paramString.length() * 3;
      int i = j(j);
      int k = i + j;
      if (k > this.c)
      {
        byte[] arrayOfByte = new byte[j];
        i = Utf8.a(paramString, arrayOfByte, 0, j);
        c(i);
        b(arrayOfByte, 0, i);
        return;
      }
      if (k > this.c - this.d) {
        f();
      }
      k = j(paramString.length());
      j = this.d;
      if (k == i) {}
      try
      {
        this.d = (j + k);
        int m = Utf8.a(paramString, this.b, this.d, this.c - this.d);
        this.d = j;
        i = m - j - k;
        t(i);
        this.d = m;
        break label177;
        i = Utf8.a(paramString);
        t(i);
        this.d = Utf8.a(paramString, this.b, this.d, i);
        label177:
        this.e += i;
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new CodedOutputStream.OutOfSpaceException(localArrayIndexOutOfBoundsException);
      }
      catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException1)
      {
        this.e -= this.d - j;
        this.d = j;
        throw localUnpairedSurrogateException1;
      }
      return;
    }
    catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException2)
    {
      a(paramString, localUnpairedSurrogateException2);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    b(paramByteBuffer);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c - this.d >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.b, this.d, paramInt2);
      this.d += paramInt2;
      this.e += paramInt2;
      return;
    }
    int i = this.c - this.d;
    System.arraycopy(paramArrayOfByte, paramInt1, this.b, this.d, i);
    paramInt1 += i;
    paramInt2 -= i;
    this.d = this.c;
    this.e += i;
    f();
    if (paramInt2 <= this.c)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.b, 0, paramInt2);
      this.d = paramInt2;
    }
    else
    {
      this.f.write(paramArrayOfByte, paramInt1, paramInt2);
    }
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
  
  public void b(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    if (this.c - this.d >= i)
    {
      paramByteBuffer.get(this.b, this.d, i);
      this.d += i;
      this.e += i;
      return;
    }
    int j = this.c - this.d;
    paramByteBuffer.get(this.b, this.d, j);
    i -= j;
    this.d = this.c;
    this.e += j;
    f();
    while (i > this.c)
    {
      paramByteBuffer.get(this.b, 0, this.c);
      this.f.write(this.b, 0, this.c);
      i -= this.c;
      this.e += this.c;
    }
    paramByteBuffer.get(this.b, 0, i);
    this.d = i;
    this.e += i;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte, paramInt1, paramInt2);
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
 * Qualified Name:     com.google.protobuf.CodedOutputStream.OutputStreamEncoder
 * JD-Core Version:    0.7.0.1
 */