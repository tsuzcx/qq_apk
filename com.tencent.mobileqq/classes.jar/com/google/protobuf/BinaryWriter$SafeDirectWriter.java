package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;

final class BinaryWriter$SafeDirectWriter
  extends BinaryWriter
{
  private ByteBuffer c;
  private int d;
  private int e;
  
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
        this.c.order(ByteOrder.LITTLE_ENDIAN);
        this.d = (this.c.limit() - 1);
        this.e = this.d;
        return;
      }
      throw new RuntimeException("Allocator returned non-direct buffer");
    }
    throw new RuntimeException("Allocated buffer does not have NIO buffer");
  }
  
  private void e(long paramLong)
  {
    k((int)paramLong);
  }
  
  private void f()
  {
    a(c());
  }
  
  private void f(long paramLong)
  {
    l((int)paramLong);
  }
  
  private int g()
  {
    return this.d - this.e;
  }
  
  private void g(long paramLong)
  {
    m((int)paramLong);
  }
  
  private int h()
  {
    return this.e + 1;
  }
  
  private void h(long paramLong)
  {
    n((int)paramLong);
  }
  
  private void i(long paramLong)
  {
    this.e -= 5;
    this.c.putLong(this.e - 2, (paramLong & 0x7F | 0x80) << 24 | (0xF0000000 & paramLong) << 28 | (0xFE00000 & paramLong | 0x10000000) << 27 | (0x1FC000 & paramLong | 0x200000) << 26 | (0x3F80 & paramLong | 0x4000) << 25);
  }
  
  private void j(int paramInt)
  {
    a(b(paramInt));
  }
  
  private void j(long paramLong)
  {
    this.e -= 6;
    this.c.putLong(this.e - 1, (paramLong & 0x7F | 0x80) << 16 | (0x0 & paramLong) << 21 | (0xF0000000 & paramLong | 0x0) << 20 | (0xFE00000 & paramLong | 0x10000000) << 19 | (0x1FC000 & paramLong | 0x200000) << 18 | (0x3F80 & paramLong | 0x4000) << 17);
  }
  
  private void k(int paramInt)
  {
    ByteBuffer localByteBuffer = this.c;
    int i = this.e;
    this.e = (i - 1);
    localByteBuffer.put(i, (byte)paramInt);
  }
  
  private void k(long paramLong)
  {
    this.e -= 7;
    this.c.putLong(this.e, (paramLong & 0x7F | 0x80) << 8 | (0x0 & paramLong) << 14 | (0x0 & paramLong | 0x0) << 13 | (0xF0000000 & paramLong | 0x0) << 12 | (0xFE00000 & paramLong | 0x10000000) << 11 | (0x1FC000 & paramLong | 0x200000) << 10 | (0x3F80 & paramLong | 0x4000) << 9);
  }
  
  private void l(int paramInt)
  {
    this.e -= 2;
    this.c.putShort(this.e + 1, (short)(paramInt & 0x7F | 0x80 | (paramInt & 0x3F80) << 1));
  }
  
  private void l(long paramLong)
  {
    this.e -= 8;
    this.c.putLong(this.e + 1, paramLong & 0x7F | 0x80 | (0x0 & paramLong) << 7 | (0x0 & paramLong | 0x0) << 6 | (0x0 & paramLong | 0x0) << 5 | (0xF0000000 & paramLong | 0x0) << 4 | (0xFE00000 & paramLong | 0x10000000) << 3 | (0x1FC000 & paramLong | 0x200000) << 2 | (0x3F80 & paramLong | 0x4000) << 1);
  }
  
  private void m(int paramInt)
  {
    this.e -= 3;
    this.c.putInt(this.e, (paramInt & 0x7F | 0x80) << 8 | (0x1FC000 & paramInt) << 10 | (paramInt & 0x3F80 | 0x4000) << 9);
  }
  
  private void m(long paramLong)
  {
    this.e -= 8;
    this.c.putLong(this.e + 1, paramLong & 0x7F | 0x80 | (0x0 & paramLong | 0x0) << 7 | (0x0 & paramLong | 0x0) << 6 | (0x0 & paramLong | 0x0) << 5 | (0xF0000000 & paramLong | 0x0) << 4 | (0xFE00000 & paramLong | 0x10000000) << 3 | (0x1FC000 & paramLong | 0x200000) << 2 | (0x3F80 & paramLong | 0x4000) << 1);
  }
  
  private void n(int paramInt)
  {
    this.e -= 4;
    this.c.putInt(this.e + 1, paramInt & 0x7F | 0x80 | (0xFE00000 & paramInt) << 3 | (0x1FC000 & paramInt | 0x200000) << 2 | (paramInt & 0x3F80 | 0x4000) << 1);
  }
  
  private void n(long paramLong)
  {
    ByteBuffer localByteBuffer = this.c;
    int i = this.e;
    this.e = (i - 1);
    localByteBuffer.put(i, (byte)(int)(paramLong >>> 56));
    m(paramLong & 0xFFFFFFFF);
  }
  
  private void o(int paramInt)
  {
    ByteBuffer localByteBuffer = this.c;
    int i = this.e;
    this.e = (i - 1);
    localByteBuffer.put(i, (byte)(paramInt >>> 28));
    this.e -= 4;
    this.c.putInt(this.e + 1, paramInt & 0x7F | 0x80 | (paramInt >>> 21 & 0x7F | 0x80) << 24 | (paramInt >>> 14 & 0x7F | 0x80) << 16 | (paramInt >>> 7 & 0x7F | 0x80) << 8);
  }
  
  private void o(long paramLong)
  {
    ByteBuffer localByteBuffer = this.c;
    int i = this.e;
    this.e = (i - 1);
    localByteBuffer.put(i, (byte)(int)(paramLong >>> 63));
    localByteBuffer = this.c;
    i = this.e;
    this.e = (i - 1);
    localByteBuffer.put(i, (byte)(int)(paramLong >>> 56 & 0x7F | 0x80));
    m(paramLong & 0xFFFFFFFF);
  }
  
  public void a(byte paramByte)
  {
    ByteBuffer localByteBuffer = this.c;
    int i = this.e;
    this.e = (i - 1);
    localByteBuffer.put(i, paramByte);
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
      o(paramLong);
      return;
    case 9: 
      n(paramLong);
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
    this.e -= j;
    int k;
    while (j >= 0)
    {
      k = paramString.charAt(j);
      if (k >= 128) {
        break;
      }
      this.c.put(this.e + j, (byte)k);
      j -= 1;
    }
    if (j == -1)
    {
      this.e -= 1;
      return;
    }
    this.e += j;
    while (j >= 0)
    {
      int i = paramString.charAt(j);
      ByteBuffer localByteBuffer;
      if (i < 128)
      {
        k = this.e;
        if (k >= 0)
        {
          localByteBuffer = this.c;
          this.e = (k - 1);
          localByteBuffer.put(k, (byte)i);
          break label614;
        }
      }
      if (i < 2048)
      {
        k = this.e;
        if (k > 0)
        {
          localByteBuffer = this.c;
          this.e = (k - 1);
          localByteBuffer.put(k, (byte)(i & 0x3F | 0x80));
          localByteBuffer = this.c;
          k = this.e;
          this.e = (k - 1);
          localByteBuffer.put(k, (byte)(i >>> 6 | 0x3C0));
          break label614;
        }
      }
      if ((i < 55296) || (57343 < i))
      {
        k = this.e;
        if (k > 1)
        {
          localByteBuffer = this.c;
          this.e = (k - 1);
          localByteBuffer.put(k, (byte)(i & 0x3F | 0x80));
          localByteBuffer = this.c;
          k = this.e;
          this.e = (k - 1);
          localByteBuffer.put(k, (byte)(i >>> 6 & 0x3F | 0x80));
          localByteBuffer = this.c;
          k = this.e;
          this.e = (k - 1);
          localByteBuffer.put(k, (byte)(i >>> 12 | 0x1E0));
          break label614;
        }
      }
      if (this.e > 2)
      {
        if (j != 0)
        {
          char c1 = paramString.charAt(j - 1);
          if (Character.isSurrogatePair(c1, i))
          {
            j -= 1;
            k = Character.toCodePoint(c1, i);
            localByteBuffer = this.c;
            int m = this.e;
            this.e = (m - 1);
            localByteBuffer.put(m, (byte)(k & 0x3F | 0x80));
            localByteBuffer = this.c;
            m = this.e;
            this.e = (m - 1);
            localByteBuffer.put(m, (byte)(k >>> 6 & 0x3F | 0x80));
            localByteBuffer = this.c;
            m = this.e;
            this.e = (m - 1);
            localByteBuffer.put(m, (byte)(k >>> 12 & 0x3F | 0x80));
            localByteBuffer = this.c;
            m = this.e;
            this.e = (m - 1);
            localByteBuffer.put(m, (byte)(k >>> 18 | 0xF0));
            break label614;
          }
        }
        throw new Utf8.UnpairedSurrogateException(j - 1, j);
      }
      else
      {
        c(j);
        j += 1;
      }
      label614:
      j -= 1;
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
    this.e -= i;
    this.c.position(this.e + 1);
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
    this.e -= paramInt2;
    this.c.position(this.e + 1);
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
    this.e -= paramInt2;
    this.c.position(this.e + 1);
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
    this.e -= 8;
    this.c.putLong(this.e + 1, paramLong);
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
      this.c.position(this.e + 1);
      this.c = null;
      this.e = 0;
      this.d = 0;
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
    this.e -= 4;
    this.c.putInt(this.e + 1, paramInt);
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
 * Qualified Name:     com.google.protobuf.BinaryWriter.SafeDirectWriter
 * JD-Core Version:    0.7.0.1
 */