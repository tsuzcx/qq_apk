package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

final class BinaryWriter$SafeHeapWriter
  extends BinaryWriter
{
  private AllocatedBuffer c;
  private byte[] d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  private void a(AllocatedBuffer paramAllocatedBuffer)
  {
    if (paramAllocatedBuffer.b())
    {
      e();
      this.a.addFirst(paramAllocatedBuffer);
      this.c = paramAllocatedBuffer;
      this.d = paramAllocatedBuffer.d();
      int j = paramAllocatedBuffer.e();
      this.f = (paramAllocatedBuffer.g() + j);
      this.e = (j + paramAllocatedBuffer.f());
      this.g = (this.e - 1);
      this.h = (this.f - 1);
      this.i = this.h;
      return;
    }
    throw new RuntimeException("Allocator returned non-heap buffer");
  }
  
  private void e(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)paramLong);
  }
  
  private void f(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 7));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)paramLong & 0x7F | 0x80));
  }
  
  private void g(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)paramLong >>> 14));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void h()
  {
    a(b());
  }
  
  private void h(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 21));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void i(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 28));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void j(int paramInt)
  {
    a(a(paramInt));
  }
  
  private void j(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 35));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void k(int paramInt)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)paramInt);
  }
  
  private void k(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 42));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 35 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void l(int paramInt)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 7));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt & 0x7F | 0x80));
  }
  
  private void l(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 49));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 42 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 35 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void m(int paramInt)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 14));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt & 0x7F | 0x80));
  }
  
  private void m(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 56));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 49 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 42 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 35 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void n(int paramInt)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 21));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 14 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt & 0x7F | 0x80));
  }
  
  private void n(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 63));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 56 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 49 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 42 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 35 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void o(int paramInt)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 28));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 21 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 14 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >>> 7 & 0x7F | 0x80));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt & 0x7F | 0x80));
  }
  
  public void a(byte paramByte)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = paramByte;
  }
  
  public void a(int paramInt, ByteString paramByteString)
  {
    try
    {
      paramByteString.writeToReverse(this);
      c(10);
      d(paramByteString.size());
      c(paramInt, 2);
      return;
    }
    catch (IOException paramByteString)
    {
      throw new RuntimeException(paramByteString);
    }
  }
  
  public void a(int paramInt, Object paramObject, Schema paramSchema)
  {
    int j = d();
    paramSchema.a(paramObject, this);
    int k = d();
    c(10);
    d(k - j);
    c(paramInt, 2);
  }
  
  public void a(int paramInt, String paramString)
  {
    int j = d();
    a(paramString);
    int k = d();
    c(10);
    d(k - j);
    c(paramInt, 2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    c(6);
    a((byte)paramBoolean);
    c(paramInt, 0);
  }
  
  void a(long paramLong)
  {
    switch (BinaryWriter.d(paramLong))
    {
    default: 
      return;
    case 10: 
      n(paramLong);
      return;
    case 9: 
      m(paramLong);
      return;
    case 8: 
      l(paramLong);
      return;
    case 7: 
      k(paramLong);
      return;
    case 6: 
      j(paramLong);
      return;
    case 5: 
      i(paramLong);
      return;
    case 4: 
      h(paramLong);
      return;
    case 3: 
      g(paramLong);
      return;
    case 2: 
      f(paramLong);
      return;
    }
    e(paramLong);
  }
  
  void a(String paramString)
  {
    c(paramString.length());
    int k = paramString.length() - 1;
    this.i -= k;
    int m;
    while (k >= 0)
    {
      m = paramString.charAt(k);
      if (m >= 128) {
        break;
      }
      this.d[(this.i + k)] = ((byte)m);
      k -= 1;
    }
    if (k == -1)
    {
      this.i -= 1;
      return;
    }
    this.i += k;
    while (k >= 0)
    {
      int j = paramString.charAt(k);
      byte[] arrayOfByte;
      if (j < 128)
      {
        m = this.i;
        if (m > this.g)
        {
          arrayOfByte = this.d;
          this.i = (m - 1);
          arrayOfByte[m] = ((byte)j);
          break label563;
        }
      }
      if (j < 2048)
      {
        m = this.i;
        if (m > this.e)
        {
          arrayOfByte = this.d;
          this.i = (m - 1);
          arrayOfByte[m] = ((byte)(j & 0x3F | 0x80));
          m = this.i;
          this.i = (m - 1);
          arrayOfByte[m] = ((byte)(j >>> 6 | 0x3C0));
          break label563;
        }
      }
      if ((j < 55296) || (57343 < j))
      {
        m = this.i;
        if (m > this.e + 1)
        {
          arrayOfByte = this.d;
          this.i = (m - 1);
          arrayOfByte[m] = ((byte)(j & 0x3F | 0x80));
          m = this.i;
          this.i = (m - 1);
          arrayOfByte[m] = ((byte)(j >>> 6 & 0x3F | 0x80));
          m = this.i;
          this.i = (m - 1);
          arrayOfByte[m] = ((byte)(j >>> 12 | 0x1E0));
          break label563;
        }
      }
      if (this.i > this.e + 2)
      {
        if (k != 0)
        {
          char c1 = paramString.charAt(k - 1);
          if (Character.isSurrogatePair(c1, j))
          {
            k -= 1;
            m = Character.toCodePoint(c1, j);
            arrayOfByte = this.d;
            int n = this.i;
            this.i = (n - 1);
            arrayOfByte[n] = ((byte)(m & 0x3F | 0x80));
            n = this.i;
            this.i = (n - 1);
            arrayOfByte[n] = ((byte)(m >>> 6 & 0x3F | 0x80));
            n = this.i;
            this.i = (n - 1);
            arrayOfByte[n] = ((byte)(m >>> 12 & 0x3F | 0x80));
            n = this.i;
            this.i = (n - 1);
            arrayOfByte[n] = ((byte)(m >>> 18 | 0xF0));
            break label563;
          }
        }
        throw new Utf8.UnpairedSurrogateException(k - 1, k);
      }
      else
      {
        c(k);
        k += 1;
      }
      label563:
      k -= 1;
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.remaining();
    if (g() < j)
    {
      this.b += j;
      this.a.addFirst(AllocatedBuffer.a(paramByteBuffer));
      h();
    }
    this.i -= j;
    paramByteBuffer.get(this.d, this.i + 1, j);
  }
  
  void a(boolean paramBoolean)
  {
    a((byte)paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (g() < paramInt2) {
      j(paramInt2);
    }
    this.i -= paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.d, this.i + 1, paramInt2);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    int j = d();
    Protobuf.a().a(paramObject, this);
    int k = d();
    c(10);
    d(k - j);
    c(paramInt, 2);
  }
  
  public void b(int paramInt, Object paramObject, Schema paramSchema)
  {
    c(paramInt, 4);
    paramSchema.a(paramObject, this);
    c(paramInt, 3);
  }
  
  void b(long paramLong)
  {
    a(CodedOutputStream.k(paramLong));
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (g() < paramInt2)
    {
      this.b += paramInt2;
      this.a.addFirst(AllocatedBuffer.a(paramArrayOfByte, paramInt1, paramInt2));
      h();
      return;
    }
    this.i -= paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.d, this.i + 1, paramInt2);
  }
  
  void c(int paramInt)
  {
    if (g() < paramInt) {
      j(paramInt);
    }
  }
  
  void c(int paramInt1, int paramInt2)
  {
    d(WireFormat.a(paramInt1, paramInt2));
  }
  
  public void c(int paramInt, long paramLong)
  {
    c(15);
    a(paramLong);
    c(paramInt, 0);
  }
  
  public void c(int paramInt, Object paramObject)
  {
    c(paramInt, 4);
    Protobuf.a().a(paramObject, this);
    c(paramInt, 3);
  }
  
  void c(long paramLong)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)(paramLong >> 56) & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)(paramLong >> 48) & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)(paramLong >> 40) & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)(paramLong >> 32) & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)(paramLong >> 24) & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)(paramLong >> 16) & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)(paramLong >> 8) & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)((int)paramLong & 0xFF));
  }
  
  public int d()
  {
    return this.b + f();
  }
  
  void d(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0)
    {
      k(paramInt);
      return;
    }
    if ((paramInt & 0xFFFFC000) == 0)
    {
      l(paramInt);
      return;
    }
    if ((0xFFE00000 & paramInt) == 0)
    {
      m(paramInt);
      return;
    }
    if ((0xF0000000 & paramInt) == 0)
    {
      n(paramInt);
      return;
    }
    o(paramInt);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    c(10);
    d(paramInt2);
    c(paramInt1, 0);
  }
  
  public void d(int paramInt, long paramLong)
  {
    c(15);
    b(paramLong);
    c(paramInt, 0);
  }
  
  void e()
  {
    if (this.c != null)
    {
      this.b += f();
      AllocatedBuffer localAllocatedBuffer = this.c;
      localAllocatedBuffer.a(this.i - localAllocatedBuffer.e() + 1);
      this.c = null;
      this.i = 0;
      this.h = 0;
    }
  }
  
  void e(int paramInt)
  {
    if (paramInt >= 0)
    {
      d(paramInt);
      return;
    }
    a(paramInt);
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    c(15);
    e(paramInt2);
    c(paramInt1, 0);
  }
  
  public void e(int paramInt, long paramLong)
  {
    c(13);
    c(paramLong);
    c(paramInt, 1);
  }
  
  int f()
  {
    return this.h - this.i;
  }
  
  void f(int paramInt)
  {
    d(CodedOutputStream.p(paramInt));
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    c(10);
    f(paramInt2);
    c(paramInt1, 0);
  }
  
  int g()
  {
    return this.i - this.g;
  }
  
  void g(int paramInt)
  {
    byte[] arrayOfByte = this.d;
    int j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >> 24 & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >> 16 & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt >> 8 & 0xFF));
    j = this.i;
    this.i = (j - 1);
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
  }
  
  public void g(int paramInt1, int paramInt2)
  {
    c(9);
    g(paramInt2);
    c(paramInt1, 5);
  }
  
  public void h(int paramInt)
  {
    c(paramInt, 3);
  }
  
  public void i(int paramInt)
  {
    c(paramInt, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.BinaryWriter.SafeHeapWriter
 * JD-Core Version:    0.7.0.1
 */