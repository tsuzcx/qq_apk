package com.google.protobuf;

import java.nio.ByteBuffer;

final class CodedInputStream$UnsafeDirectNioDecoder
  extends CodedInputStream
{
  private final ByteBuffer e;
  private final boolean f;
  private final long g;
  private long h;
  private long i;
  private long j;
  private int k;
  private int l;
  private boolean m;
  private int n = 2147483647;
  
  private CodedInputStream$UnsafeDirectNioDecoder(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    super(null);
    this.e = paramByteBuffer;
    this.g = UnsafeUtil.a(paramByteBuffer);
    this.h = (this.g + paramByteBuffer.limit());
    this.i = (this.g + paramByteBuffer.position());
    this.j = this.i;
    this.f = paramBoolean;
  }
  
  static boolean A()
  {
    return UnsafeUtil.b();
  }
  
  private void G()
  {
    if (K() >= 10)
    {
      H();
      return;
    }
    I();
  }
  
  private void H()
  {
    int i1 = 0;
    while (i1 < 10)
    {
      long l1 = this.i;
      this.i = (1L + l1);
      if (UnsafeUtil.a(l1) >= 0) {
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
  
  private void I()
  {
    int i1 = 0;
    while (i1 < 10)
    {
      if (F() >= 0) {
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
  
  private void J()
  {
    this.h += this.k;
    long l1 = this.h;
    int i1 = (int)(l1 - this.j);
    int i2 = this.n;
    if (i1 > i2)
    {
      this.k = (i1 - i2);
      this.h = (l1 - this.k);
      return;
    }
    this.k = 0;
  }
  
  private int K()
  {
    return (int)(this.h - this.i);
  }
  
  /* Error */
  private ByteBuffer a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:e	Ljava/nio/ByteBuffer;
    //   4: invokevirtual 47	java/nio/ByteBuffer:position	()I
    //   7: istore 5
    //   9: aload_0
    //   10: getfield 28	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:e	Ljava/nio/ByteBuffer;
    //   13: invokevirtual 42	java/nio/ByteBuffer:limit	()I
    //   16: istore 6
    //   18: aload_0
    //   19: getfield 28	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:e	Ljava/nio/ByteBuffer;
    //   22: aload_0
    //   23: lload_1
    //   24: invokespecial 93	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:b	(J)I
    //   27: invokevirtual 96	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   30: pop
    //   31: aload_0
    //   32: getfield 28	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:e	Ljava/nio/ByteBuffer;
    //   35: aload_0
    //   36: lload_3
    //   37: invokespecial 93	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:b	(J)I
    //   40: invokevirtual 98	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   43: pop
    //   44: aload_0
    //   45: getfield 28	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:e	Ljava/nio/ByteBuffer;
    //   48: invokevirtual 102	java/nio/ByteBuffer:slice	()Ljava/nio/ByteBuffer;
    //   51: astore 7
    //   53: aload_0
    //   54: getfield 28	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:e	Ljava/nio/ByteBuffer;
    //   57: iload 5
    //   59: invokevirtual 96	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   62: pop
    //   63: aload_0
    //   64: getfield 28	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:e	Ljava/nio/ByteBuffer;
    //   67: iload 6
    //   69: invokevirtual 98	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   72: pop
    //   73: aload 7
    //   75: areturn
    //   76: astore 7
    //   78: goto +7 -> 85
    //   81: invokestatic 105	com/google/protobuf/InvalidProtocolBufferException:truncatedMessage	()Lcom/google/protobuf/InvalidProtocolBufferException;
    //   84: athrow
    //   85: aload_0
    //   86: getfield 28	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:e	Ljava/nio/ByteBuffer;
    //   89: iload 5
    //   91: invokevirtual 96	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   94: pop
    //   95: aload_0
    //   96: getfield 28	com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder:e	Ljava/nio/ByteBuffer;
    //   99: iload 6
    //   101: invokevirtual 98	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   104: pop
    //   105: aload 7
    //   107: athrow
    //   108: astore 7
    //   110: goto -29 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	UnsafeDirectNioDecoder
    //   0	113	1	paramLong1	long
    //   0	113	3	paramLong2	long
    //   7	83	5	i1	int
    //   16	84	6	i2	int
    //   51	23	7	localByteBuffer	ByteBuffer
    //   76	30	7	localObject	Object
    //   108	1	7	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   18	53	76	finally
    //   81	85	76	finally
    //   18	53	108	java/lang/IllegalArgumentException
  }
  
  private int b(long paramLong)
  {
    return (int)(paramLong - this.g);
  }
  
  public void B()
  {
    int i1;
    do
    {
      i1 = a();
    } while ((i1 != 0) && (b(i1)));
  }
  
  public long C()
  {
    long l2 = this.i;
    long l3;
    long l4;
    if (this.h != l2)
    {
      l1 = l2 + 1L;
      int i1 = UnsafeUtil.a(l2);
      if (i1 >= 0)
      {
        this.i = l1;
        return i1;
      }
      if (this.h - l1 >= 9L)
      {
        l2 = l1 + 1L;
        i1 ^= UnsafeUtil.a(l1) << 7;
        if (i1 < 0) {
          i1 ^= 0xFFFFFF80;
        }
        for (l1 = l2;; l1 = l2)
        {
          l2 = i1;
          break label378;
          l1 = l2 + 1L;
          i1 ^= UnsafeUtil.a(l2) << 14;
          if (i1 >= 0)
          {
            l2 = i1 ^ 0x3F80;
            break label378;
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
          break label378;
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
          break label378;
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
            break label315;
          }
          l3 = -558586000294016L;
          l1 = l4;
        }
        label315:
        l3 = l4 + 1L;
        l4 = l2 ^ UnsafeUtil.a(l4) << 56 ^ 0xFE03F80;
        l2 = l4;
        l1 = l3;
        if (l4 >= 0L) {
          break label378;
        }
        if (UnsafeUtil.a(l3) >= 0L) {
          break label369;
        }
      }
    }
    return t();
    label369:
    long l1 = 1L + l3;
    l2 = l4;
    label378:
    this.i = l1;
    return l2;
  }
  
  public int D()
  {
    long l1 = this.i;
    if (this.h - l1 >= 4L)
    {
      this.i = (4L + l1);
      int i1 = UnsafeUtil.a(l1);
      int i2 = UnsafeUtil.a(1L + l1);
      int i3 = UnsafeUtil.a(2L + l1);
      return (UnsafeUtil.a(l1 + 3L) & 0xFF) << 24 | i1 & 0xFF | (i2 & 0xFF) << 8 | (i3 & 0xFF) << 16;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public long E()
  {
    long l1 = this.i;
    if (this.h - l1 >= 8L)
    {
      this.i = (8L + l1);
      long l2 = UnsafeUtil.a(l1);
      long l3 = UnsafeUtil.a(1L + l1);
      long l4 = UnsafeUtil.a(2L + l1);
      long l5 = UnsafeUtil.a(3L + l1);
      long l6 = UnsafeUtil.a(4L + l1);
      long l7 = UnsafeUtil.a(5L + l1);
      long l8 = UnsafeUtil.a(6L + l1);
      return (UnsafeUtil.a(l1 + 7L) & 0xFF) << 56 | l2 & 0xFF | (l3 & 0xFF) << 8 | (l4 & 0xFF) << 16 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 32 | (l7 & 0xFF) << 40 | (l8 & 0xFF) << 48;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public byte F()
  {
    long l1 = this.i;
    if (l1 != this.h)
    {
      this.i = (1L + l1);
      return UnsafeUtil.a(l1);
    }
    throw InvalidProtocolBufferException.truncatedMessage();
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
    return Double.longBitsToDouble(E());
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
          B();
          a(WireFormat.a(WireFormat.b(paramInt), 4));
          return true;
        }
        f(s());
        return true;
      }
      f(8);
      return true;
    }
    G();
    return true;
  }
  
  public float c()
  {
    return Float.intBitsToFloat(D());
  }
  
  public int c(int paramInt)
  {
    if (paramInt >= 0)
    {
      paramInt += z();
      int i1 = this.n;
      if (paramInt <= i1)
      {
        this.n = paramInt;
        J();
        return i1;
      }
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  public long d()
  {
    return C();
  }
  
  public void d(int paramInt)
  {
    this.n = paramInt;
    J();
  }
  
  public long e()
  {
    return C();
  }
  
  public int f()
  {
    return s();
  }
  
  public void f(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= K()))
    {
      this.i += paramInt;
      return;
    }
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public long g()
  {
    return E();
  }
  
  public int h()
  {
    return D();
  }
  
  public boolean i()
  {
    return C() != 0L;
  }
  
  public String j()
  {
    int i1 = s();
    if ((i1 > 0) && (i1 <= K()))
    {
      Object localObject = new byte[i1];
      long l1 = this.i;
      long l2 = i1;
      UnsafeUtil.a(l1, (byte[])localObject, 0L, l2);
      localObject = new String((byte[])localObject, Internal.a);
      this.i += l2;
      return localObject;
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
    if ((i1 > 0) && (i1 <= K()))
    {
      int i2 = b(this.i);
      String str = Utf8.a(this.e, i2, i1);
      this.i += i1;
      return str;
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
    if ((i1 > 0) && (i1 <= K()))
    {
      if ((this.f) && (this.m))
      {
        l1 = this.i;
        l2 = i1;
        localObject = a(l1, l1 + l2);
        this.i += l2;
        return ByteString.wrap((ByteBuffer)localObject);
      }
      Object localObject = new byte[i1];
      long l1 = this.i;
      long l2 = i1;
      UnsafeUtil.a(l1, (byte[])localObject, 0L, l2);
      this.i += l2;
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
    return D();
  }
  
  public long p()
  {
    return E();
  }
  
  public int q()
  {
    return e(s());
  }
  
  public long r()
  {
    return a(C());
  }
  
  public int s()
  {
    long l1 = this.i;
    int i1;
    if (this.h != l1)
    {
      long l2 = l1 + 1L;
      i1 = UnsafeUtil.a(l1);
      if (i1 >= 0)
      {
        this.i = l2;
        return i1;
      }
      if (this.h - l2 >= 9L)
      {
        l1 = l2 + 1L;
        i1 ^= UnsafeUtil.a(l2) << 7;
        if (i1 < 0)
        {
          i1 ^= 0xFFFFFF80;
          break label287;
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
          break label287;
        }
      }
    }
    return (int)t();
    label287:
    this.i = l1;
    return i1;
  }
  
  long t()
  {
    long l1 = 0L;
    int i1 = 0;
    while (i1 < 64)
    {
      int i2 = F();
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
    int i1 = this.n;
    if (i1 == 2147483647) {
      return -1;
    }
    return i1 - z();
  }
  
  public boolean y()
  {
    return this.i == this.h;
  }
  
  public int z()
  {
    return (int)(this.i - this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder
 * JD-Core Version:    0.7.0.1
 */