package com.google.protobuf;

import java.nio.ByteBuffer;
import java.util.Iterator;

final class CodedInputStream$IterableDirectByteBufferDecoder
  extends CodedInputStream
{
  private Iterator<ByteBuffer> e;
  private ByteBuffer f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private long o;
  private long p;
  private long q;
  private long r;
  
  private void F()
  {
    if (this.e.hasNext())
    {
      G();
      return;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private void G()
  {
    this.f = ((ByteBuffer)this.e.next());
    this.m += (int)(this.o - this.p);
    this.o = this.f.position();
    this.p = this.o;
    this.r = this.f.limit();
    this.q = UnsafeUtil.a(this.f);
    long l1 = this.o;
    long l2 = this.q;
    this.o = (l1 + l2);
    this.p += l2;
    this.r += l2;
  }
  
  private void H()
  {
    this.i += this.j;
    int i1 = this.i;
    int i2 = i1 - this.n;
    int i3 = this.k;
    if (i2 > i3)
    {
      this.j = (i2 - i3);
      this.i = (i1 - this.j);
      return;
    }
    this.j = 0;
  }
  
  private void I()
  {
    int i1 = 0;
    while (i1 < 10)
    {
      if (E() >= 0) {
        return;
      }
      i1 += 1;
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  private int J()
  {
    return (int)(this.i - this.m - this.o + this.p);
  }
  
  private long K()
  {
    return this.r - this.o;
  }
  
  /* Error */
  private ByteBuffer a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder:f	Ljava/nio/ByteBuffer;
    //   4: invokevirtual 62	java/nio/ByteBuffer:position	()I
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 52	com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder:f	Ljava/nio/ByteBuffer;
    //   12: invokevirtual 65	java/nio/ByteBuffer:limit	()I
    //   15: istore 4
    //   17: aload_0
    //   18: getfield 52	com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder:f	Ljava/nio/ByteBuffer;
    //   21: iload_1
    //   22: invokevirtual 99	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   25: pop
    //   26: aload_0
    //   27: getfield 52	com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder:f	Ljava/nio/ByteBuffer;
    //   30: iload_2
    //   31: invokevirtual 101	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   34: pop
    //   35: aload_0
    //   36: getfield 52	com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder:f	Ljava/nio/ByteBuffer;
    //   39: invokevirtual 105	java/nio/ByteBuffer:slice	()Ljava/nio/ByteBuffer;
    //   42: astore 5
    //   44: aload_0
    //   45: getfield 52	com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder:f	Ljava/nio/ByteBuffer;
    //   48: iload_3
    //   49: invokevirtual 99	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   52: pop
    //   53: aload_0
    //   54: getfield 52	com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder:f	Ljava/nio/ByteBuffer;
    //   57: iload 4
    //   59: invokevirtual 101	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   62: pop
    //   63: aload 5
    //   65: areturn
    //   66: astore 5
    //   68: goto +7 -> 75
    //   71: invokestatic 43	com/google/protobuf/InvalidProtocolBufferException:truncatedMessage	()Lcom/google/protobuf/InvalidProtocolBufferException;
    //   74: athrow
    //   75: aload_0
    //   76: getfield 52	com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder:f	Ljava/nio/ByteBuffer;
    //   79: iload_3
    //   80: invokevirtual 99	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   83: pop
    //   84: aload_0
    //   85: getfield 52	com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder:f	Ljava/nio/ByteBuffer;
    //   88: iload 4
    //   90: invokevirtual 101	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   93: pop
    //   94: aload 5
    //   96: athrow
    //   97: astore 5
    //   99: goto -28 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	IterableDirectByteBufferDecoder
    //   0	102	1	paramInt1	int
    //   0	102	2	paramInt2	int
    //   7	73	3	i1	int
    //   15	74	4	i2	int
    //   42	22	5	localByteBuffer	ByteBuffer
    //   66	29	5	localObject	Object
    //   97	1	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   17	44	66	finally
    //   71	75	66	finally
    //   17	44	97	java/lang/IllegalArgumentException
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= J()))
    {
      int i1 = paramInt2;
      while (i1 > 0)
      {
        if (K() == 0L) {
          F();
        }
        int i2 = Math.min(i1, (int)K());
        long l1 = this.o;
        long l2 = paramInt2 - i1 + paramInt1;
        long l3 = i2;
        UnsafeUtil.a(l1, paramArrayOfByte, l2, l3);
        i1 -= i2;
        this.o += l3;
      }
      return;
    }
    if (paramInt2 <= 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      throw InvalidProtocolBufferException.negativeSize();
    }
    paramArrayOfByte = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public void A()
  {
    int i1;
    do
    {
      i1 = a();
    } while ((i1 != 0) && (b(i1)));
  }
  
  public long B()
  {
    long l2 = this.o;
    long l3;
    long l4;
    if (this.r != l2)
    {
      l1 = l2 + 1L;
      int i1 = UnsafeUtil.a(l2);
      if (i1 >= 0)
      {
        this.o += 1L;
        return i1;
      }
      if (this.r - this.o >= 10L)
      {
        l2 = l1 + 1L;
        i1 ^= UnsafeUtil.a(l1) << 7;
        if (i1 < 0) {
          i1 ^= 0xFFFFFF80;
        }
        for (l1 = l2;; l1 = l2)
        {
          l2 = i1;
          break label386;
          l1 = l2 + 1L;
          i1 ^= UnsafeUtil.a(l2) << 14;
          if (i1 >= 0)
          {
            l2 = i1 ^ 0x3F80;
            break label386;
          }
          l2 = l1 + 1L;
          i1 ^= UnsafeUtil.a(l1) << 21;
          if (i1 >= 0) {
            break;
          }
          i1 ^= 0xFFE03F80;
        }
        l3 = i1;
        l1 = l2 + 1L;
        l2 = l3 ^ UnsafeUtil.a(l2) << 28;
        if (l2 >= 0L)
        {
          l3 = 266354560L;
          l2 ^= l3;
          break label386;
        }
        l3 = l1 + 1L;
        l2 ^= UnsafeUtil.a(l1) << 35;
        if (l2 < 0L)
        {
          l4 = -34093383808L;
          l1 = l3;
          l3 = l4;
        }
        for (;;)
        {
          l2 ^= l3;
          break label386;
          l1 = l3 + 1L;
          l2 ^= UnsafeUtil.a(l3) << 42;
          if (l2 >= 0L)
          {
            l3 = 4363953127296L;
            break;
          }
          l4 = l1 + 1L;
          l2 ^= UnsafeUtil.a(l1) << 49;
          if (l2 >= 0L) {
            break label323;
          }
          l3 = -558586000294016L;
          l1 = l4;
        }
        label323:
        l3 = l4 + 1L;
        l4 = l2 ^ UnsafeUtil.a(l4) << 56 ^ 0xFE03F80;
        l2 = l4;
        l1 = l3;
        if (l4 >= 0L) {
          break label386;
        }
        if (UnsafeUtil.a(l3) >= 0L) {
          break label377;
        }
      }
    }
    return t();
    label377:
    long l1 = 1L + l3;
    l2 = l4;
    label386:
    this.o = l1;
    return l2;
  }
  
  public int C()
  {
    if (K() >= 4L)
    {
      long l1 = this.o;
      this.o = (4L + l1);
      int i1 = UnsafeUtil.a(l1);
      int i2 = UnsafeUtil.a(1L + l1);
      int i3 = UnsafeUtil.a(2L + l1);
      return (UnsafeUtil.a(l1 + 3L) & 0xFF) << 24 | i1 & 0xFF | (i2 & 0xFF) << 8 | (i3 & 0xFF) << 16;
    }
    return E() & 0xFF | (E() & 0xFF) << 8 | (E() & 0xFF) << 16 | (E() & 0xFF) << 24;
  }
  
  public long D()
  {
    if (K() >= 8L)
    {
      long l1 = this.o;
      this.o = (8L + l1);
      long l2 = UnsafeUtil.a(l1);
      long l3 = UnsafeUtil.a(1L + l1);
      long l4 = UnsafeUtil.a(2L + l1);
      long l5 = UnsafeUtil.a(3L + l1);
      long l6 = UnsafeUtil.a(4L + l1);
      long l7 = UnsafeUtil.a(5L + l1);
      long l8 = UnsafeUtil.a(6L + l1);
      return (UnsafeUtil.a(l1 + 7L) & 0xFF) << 56 | (l8 & 0xFF) << 48 | (l6 & 0xFF) << 32 | (l4 & 0xFF) << 16 | l2 & 0xFF | (l3 & 0xFF) << 8 | (l5 & 0xFF) << 24 | (l7 & 0xFF) << 40;
    }
    return E() & 0xFF | (E() & 0xFF) << 8 | (E() & 0xFF) << 16 | (E() & 0xFF) << 24 | (E() & 0xFF) << 32 | (E() & 0xFF) << 40 | (E() & 0xFF) << 48 | (E() & 0xFF) << 56;
  }
  
  public byte E()
  {
    if (K() == 0L) {
      F();
    }
    long l1 = this.o;
    this.o = (1L + l1);
    return UnsafeUtil.a(l1);
  }
  
  public int a()
  {
    if (y())
    {
      this.l = 0;
      return 0;
    }
    this.l = s();
    if (WireFormat.b(this.l) != 0) {
      return this.l;
    }
    throw InvalidProtocolBufferException.invalidTag();
  }
  
  public <T extends MessageLite> T a(Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i1 = s();
    if (this.a < this.b)
    {
      i1 = c(i1);
      this.a += 1;
      paramParser = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
      a(0);
      this.a -= 1;
      d(i1);
      return paramParser;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public void a(int paramInt)
  {
    if (this.l == paramInt) {
      return;
    }
    throw InvalidProtocolBufferException.invalidEndTag();
  }
  
  public void a(int paramInt, MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (this.a < this.b)
    {
      this.a += 1;
      paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
      a(WireFormat.a(paramInt, 4));
      this.a -= 1;
      return;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public void a(MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i1 = s();
    if (this.a < this.b)
    {
      i1 = c(i1);
      this.a += 1;
      paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
      a(0);
      this.a -= 1;
      d(i1);
      return;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public double b()
  {
    return Double.longBitsToDouble(D());
  }
  
  public boolean b(int paramInt)
  {
    int i1 = WireFormat.a(paramInt);
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 == 5)
              {
                f(4);
                return true;
              }
              throw InvalidProtocolBufferException.invalidWireType();
            }
            return false;
          }
          A();
          a(WireFormat.a(WireFormat.b(paramInt), 4));
          return true;
        }
        f(s());
        return true;
      }
      f(8);
      return true;
    }
    I();
    return true;
  }
  
  public float c()
  {
    return Float.intBitsToFloat(C());
  }
  
  public int c(int paramInt)
  {
    if (paramInt >= 0)
    {
      paramInt += z();
      int i1 = this.k;
      if (paramInt <= i1)
      {
        this.k = paramInt;
        H();
        return i1;
      }
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  public long d()
  {
    return B();
  }
  
  public void d(int paramInt)
  {
    this.k = paramInt;
    H();
  }
  
  public long e()
  {
    return B();
  }
  
  public int f()
  {
    return s();
  }
  
  public void f(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.i - this.m - this.o + this.p))
    {
      while (paramInt > 0)
      {
        if (K() == 0L) {
          F();
        }
        int i1 = Math.min(paramInt, (int)K());
        paramInt -= i1;
        this.o += i1;
      }
      return;
    }
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  public long g()
  {
    return D();
  }
  
  public int h()
  {
    return C();
  }
  
  public boolean i()
  {
    return B() != 0L;
  }
  
  public String j()
  {
    int i1 = s();
    Object localObject;
    if (i1 > 0)
    {
      long l1 = i1;
      long l2 = this.r;
      long l3 = this.o;
      if (l1 <= l2 - l3)
      {
        localObject = new byte[i1];
        UnsafeUtil.a(l3, (byte[])localObject, 0L, l1);
        localObject = new String((byte[])localObject, Internal.a);
        this.o += l1;
        return localObject;
      }
    }
    if ((i1 > 0) && (i1 <= J()))
    {
      localObject = new byte[i1];
      b((byte[])localObject, 0, i1);
      return new String((byte[])localObject, Internal.a);
    }
    if (i1 == 0) {
      return "";
    }
    if (i1 < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public String k()
  {
    int i1 = s();
    Object localObject;
    if (i1 > 0)
    {
      long l1 = i1;
      long l2 = this.r;
      long l3 = this.o;
      if (l1 <= l2 - l3)
      {
        int i2 = (int)(l3 - this.p);
        localObject = Utf8.a(this.f, i2, i1);
        this.o += l1;
        return localObject;
      }
    }
    if ((i1 >= 0) && (i1 <= J()))
    {
      localObject = new byte[i1];
      b((byte[])localObject, 0, i1);
      return Utf8.b((byte[])localObject, 0, i1);
    }
    if (i1 == 0) {
      return "";
    }
    if (i1 <= 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public ByteString l()
  {
    int i1 = s();
    Object localObject;
    if (i1 > 0)
    {
      long l1 = i1;
      long l2 = this.r;
      long l3 = this.o;
      if (l1 <= l2 - l3)
      {
        if ((this.g) && (this.h))
        {
          int i2 = (int)(l3 - this.q);
          localObject = ByteString.wrap(a(i2, i1 + i2));
          this.o += l1;
          return localObject;
        }
        localObject = new byte[i1];
        UnsafeUtil.a(this.o, (byte[])localObject, 0L, l1);
        this.o += l1;
        return ByteString.wrap((byte[])localObject);
      }
    }
    if ((i1 > 0) && (i1 <= J()))
    {
      localObject = new byte[i1];
      b((byte[])localObject, 0, i1);
      return ByteString.wrap((byte[])localObject);
    }
    if (i1 == 0) {
      return ByteString.EMPTY;
    }
    if (i1 < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public int m()
  {
    return s();
  }
  
  public int n()
  {
    return s();
  }
  
  public int o()
  {
    return C();
  }
  
  public long p()
  {
    return D();
  }
  
  public int q()
  {
    return e(s());
  }
  
  public long r()
  {
    return a(B());
  }
  
  public int s()
  {
    long l1 = this.o;
    int i1;
    if (this.r != l1)
    {
      long l2 = l1 + 1L;
      i1 = UnsafeUtil.a(l1);
      if (i1 >= 0)
      {
        this.o += 1L;
        return i1;
      }
      if (this.r - this.o >= 10L)
      {
        l1 = l2 + 1L;
        i1 ^= UnsafeUtil.a(l2) << 7;
        if (i1 < 0)
        {
          i1 ^= 0xFFFFFF80;
          break label293;
        }
        l2 = l1 + 1L;
        i1 ^= UnsafeUtil.a(l1) << 14;
        if (i1 >= 0)
        {
          i1 ^= 0x3F80;
          l1 = l2;
        }
        int i2;
        long l3;
        do
        {
          do
          {
            int i3;
            do
            {
              break;
              l1 = l2 + 1L;
              i1 ^= UnsafeUtil.a(l2) << 21;
              if (i1 < 0)
              {
                i1 ^= 0xFFE03F80;
                break;
              }
              l2 = l1 + 1L;
              i3 = UnsafeUtil.a(l1);
              i2 = i1 ^ i3 << 28 ^ 0xFE03F80;
              i1 = i2;
              l1 = l2;
            } while (i3 >= 0);
            l3 = l2 + 1L;
            i1 = i2;
            l1 = l3;
            if (UnsafeUtil.a(l2) >= 0) {
              break;
            }
            l2 = l3 + 1L;
            i1 = i2;
            l1 = l2;
          } while (UnsafeUtil.a(l3) >= 0);
          l3 = l2 + 1L;
          i1 = i2;
          l1 = l3;
          if (UnsafeUtil.a(l2) >= 0) {
            break;
          }
          l2 = l3 + 1L;
          i1 = i2;
          l1 = l2;
        } while (UnsafeUtil.a(l3) >= 0);
        l1 = l2 + 1L;
        i1 = i2;
        if (UnsafeUtil.a(l2) >= 0) {
          break label293;
        }
      }
    }
    return (int)t();
    label293:
    this.o = l1;
    return i1;
  }
  
  long t()
  {
    long l1 = 0L;
    int i1 = 0;
    while (i1 < 64)
    {
      int i2 = E();
      l1 |= (i2 & 0x7F) << i1;
      if ((i2 & 0x80) == 0) {
        return l1;
      }
      i1 += 7;
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  public int x()
  {
    int i1 = this.k;
    if (i1 == 2147483647) {
      return -1;
    }
    return i1 - z();
  }
  
  public boolean y()
  {
    return this.m + this.o - this.p == this.i;
  }
  
  public int z()
  {
    return (int)(this.m - this.n + this.o - this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder
 * JD-Core Version:    0.7.0.1
 */