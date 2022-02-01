package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

final class BinaryWriter$UnsafeDirectWriter
  extends BinaryWriter
{
  private ByteBuffer c;
  private long d;
  private long e;
  private long f;
  
  private void a(AllocatedBuffer paramAllocatedBuffer)
  {
    if (paramAllocatedBuffer.a())
    {
      ByteBuffer localByteBuffer = paramAllocatedBuffer.c();
      if (localByteBuffer.isDirect())
      {
        e();
        this.a.addFirst(paramAllocatedBuffer);
        this.c = localByteBuffer;
        paramAllocatedBuffer = this.c;
        paramAllocatedBuffer.limit(paramAllocatedBuffer.capacity());
        this.c.position(0);
        this.d = UnsafeUtil.a(this.c);
        this.e = (this.d + (this.c.limit() - 1));
        this.f = this.e;
        return;
      }
      throw new RuntimeException("Allocator returned non-direct buffer");
    }
    throw new RuntimeException("Allocated buffer does not have NIO buffer");
  }
  
  private void e(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)paramLong);
  }
  
  private void f()
  {
    a(c());
  }
  
  private void f(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 7));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)paramLong & 0x7F | 0x80));
  }
  
  private int g()
  {
    return (int)(this.e - this.f);
  }
  
  private void g(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)paramLong >>> 14));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private int h()
  {
    return i() + 1;
  }
  
  private void h(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 21));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private int i()
  {
    return (int)(this.f - this.d);
  }
  
  private void i(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 28));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void j(int paramInt)
  {
    a(b(paramInt));
  }
  
  private void j(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 35));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void k(int paramInt)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)paramInt);
  }
  
  private void k(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 42));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 35 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void l(int paramInt)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 7));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt & 0x7F | 0x80));
  }
  
  private void l(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 49));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 42 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 35 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void m(int paramInt)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 14));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt & 0x7F | 0x80));
  }
  
  private void m(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 56));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 49 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 42 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 35 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void n(int paramInt)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 21));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 14 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt & 0x7F | 0x80));
  }
  
  private void n(long paramLong)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 63));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 56 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 49 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 42 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 35 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 28 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 21 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 14 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(int)(paramLong & 0x7F | 0x80));
  }
  
  private void o(int paramInt)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 28));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 21 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 14 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >>> 7 & 0x7F | 0x80));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt & 0x7F | 0x80));
  }
  
  public void a(byte paramByte)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, paramByte);
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
    int i = d();
    paramSchema.a(paramObject, this);
    int j = d();
    c(10);
    d(j - i);
    c(paramInt, 2);
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = d();
    a(paramString);
    int j = d();
    c(10);
    d(j - i);
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
    int j = paramString.length() - 1;
    long l;
    while (j >= 0)
    {
      k = paramString.charAt(j);
      if (k >= 128) {
        break;
      }
      l = this.f;
      this.f = (l - 1L);
      UnsafeUtil.a(l, (byte)k);
      j -= 1;
    }
    int k = j;
    if (j == -1) {
      return;
    }
    while (k >= 0)
    {
      int i = paramString.charAt(k);
      if (i < 128)
      {
        l = this.f;
        if (l >= this.d)
        {
          this.f = (l - 1L);
          UnsafeUtil.a(l, (byte)i);
          break label524;
        }
      }
      if (i < 2048)
      {
        l = this.f;
        if (l > this.d)
        {
          this.f = (l - 1L);
          UnsafeUtil.a(l, (byte)(i & 0x3F | 0x80));
          l = this.f;
          this.f = (l - 1L);
          UnsafeUtil.a(l, (byte)(i >>> 6 | 0x3C0));
          break label524;
        }
      }
      if ((i < 55296) || (57343 < i))
      {
        l = this.f;
        if (l > this.d + 1L)
        {
          this.f = (l - 1L);
          UnsafeUtil.a(l, (byte)(i & 0x3F | 0x80));
          l = this.f;
          this.f = (l - 1L);
          UnsafeUtil.a(l, (byte)(i >>> 6 & 0x3F | 0x80));
          l = this.f;
          this.f = (l - 1L);
          UnsafeUtil.a(l, (byte)(i >>> 12 | 0x1E0));
          break label524;
        }
      }
      if (this.f > this.d + 2L)
      {
        if (k != 0)
        {
          char c1 = paramString.charAt(k - 1);
          if (Character.isSurrogatePair(c1, i))
          {
            k -= 1;
            j = Character.toCodePoint(c1, i);
            l = this.f;
            this.f = (l - 1L);
            UnsafeUtil.a(l, (byte)(j & 0x3F | 0x80));
            l = this.f;
            this.f = (l - 1L);
            UnsafeUtil.a(l, (byte)(j >>> 6 & 0x3F | 0x80));
            l = this.f;
            this.f = (l - 1L);
            UnsafeUtil.a(l, (byte)(j >>> 12 & 0x3F | 0x80));
            l = this.f;
            this.f = (l - 1L);
            UnsafeUtil.a(l, (byte)(j >>> 18 | 0xF0));
            break label524;
          }
        }
        throw new Utf8.UnpairedSurrogateException(k - 1, k);
      }
      else
      {
        c(k);
        k += 1;
      }
      label524:
      k -= 1;
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    if (h() < i)
    {
      this.b += i;
      this.a.addFirst(AllocatedBuffer.a(paramByteBuffer));
      f();
      return;
    }
    this.f -= i;
    this.c.position(i() + 1);
    this.c.put(paramByteBuffer);
  }
  
  void a(boolean paramBoolean)
  {
    a((byte)paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (h() < paramInt2) {
      j(paramInt2);
    }
    this.f -= paramInt2;
    this.c.position(i() + 1);
    this.c.put(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    int i = d();
    Protobuf.a().a(paramObject, this);
    int j = d();
    c(10);
    d(j - i);
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
    if (h() < paramInt2)
    {
      this.b += paramInt2;
      this.a.addFirst(AllocatedBuffer.a(paramArrayOfByte, paramInt1, paramInt2));
      f();
      return;
    }
    this.f -= paramInt2;
    this.c.position(i() + 1);
    this.c.put(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  void c(int paramInt)
  {
    if (h() < paramInt) {
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
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)(paramLong >> 56) & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)(paramLong >> 48) & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)(paramLong >> 40) & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)(paramLong >> 32) & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)(paramLong >> 24) & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)(paramLong >> 16) & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)(paramLong >> 8) & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)((int)paramLong & 0xFF));
  }
  
  public int d()
  {
    return this.b + g();
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
      this.b += g();
      this.c.position(i() + 1);
      this.c = null;
      this.f = 0L;
      this.e = 0L;
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
  
  void g(int paramInt)
  {
    long l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >> 24 & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >> 16 & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt >> 8 & 0xFF));
    l = this.f;
    this.f = (l - 1L);
    UnsafeUtil.a(l, (byte)(paramInt & 0xFF));
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
 * Qualified Name:     com.google.protobuf.BinaryWriter.UnsafeDirectWriter
 * JD-Core Version:    0.7.0.1
 */