package com.google.protobuf;

import java.util.Arrays;

final class CodedInputStream$ArrayDecoder
  extends CodedInputStream
{
  private final byte[] e;
  private final boolean f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private int m = 2147483647;
  
  private CodedInputStream$ArrayDecoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(null);
    this.e = paramArrayOfByte;
    this.g = (paramInt2 + paramInt1);
    this.i = paramInt1;
    this.j = this.i;
    this.f = paramBoolean;
  }
  
  private void F()
  {
    if (this.g - this.i >= 10)
    {
      G();
      return;
    }
    H();
  }
  
  private void G()
  {
    int n = 0;
    while (n < 10)
    {
      localObject = this.e;
      int i1 = this.i;
      this.i = (i1 + 1);
      if (localObject[i1] >= 0) {
        return;
      }
      n += 1;
    }
    Object localObject = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private void H()
  {
    int n = 0;
    while (n < 10)
    {
      if (E() >= 0) {
        return;
      }
      n += 1;
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  private void I()
  {
    this.g += this.h;
    int n = this.g;
    int i1 = n - this.j;
    int i2 = this.m;
    if (i1 > i2)
    {
      this.h = (i1 - i2);
      this.g = (n - this.h);
      return;
    }
    this.h = 0;
  }
  
  public void A()
  {
    int n;
    do
    {
      n = a();
    } while ((n != 0) && (b(n)));
  }
  
  public long B()
  {
    int i2 = this.i;
    int n = this.g;
    long l1;
    if (n != i2)
    {
      byte[] arrayOfByte = this.e;
      int i1 = i2 + 1;
      i2 = arrayOfByte[i2];
      if (i2 >= 0)
      {
        this.i = i1;
        return i2;
      }
      if (n - i1 >= 9)
      {
        n = i1 + 1;
        i2 ^= arrayOfByte[i1] << 7;
        if (i2 < 0) {
          i1 = i2 ^ 0xFFFFFF80;
        }
        for (;;)
        {
          l1 = i1;
          break label350;
          i1 = n + 1;
          i2 ^= arrayOfByte[n] << 14;
          if (i2 >= 0)
          {
            l1 = i2 ^ 0x3F80;
            n = i1;
            break label350;
          }
          n = i1 + 1;
          i1 = i2 ^ arrayOfByte[i1] << 21;
          if (i1 >= 0) {
            break;
          }
          i1 ^= 0xFFE03F80;
        }
        l1 = i1;
        i1 = n + 1;
        long l2 = l1 ^ arrayOfByte[n] << 28;
        if (l2 >= 0L)
        {
          l1 = 266354560L;
          n = i1;
          l1 ^= l2;
        }
        label293:
        do
        {
          break label350;
          n = i1 + 1;
          l1 = l2 ^ arrayOfByte[i1] << 35;
          if (l1 < 0L) {}
          for (l2 = -34093383808L;; l2 = -558586000294016L)
          {
            l1 ^= l2;
            break label350;
            i1 = n + 1;
            l2 = l1 ^ arrayOfByte[n] << 42;
            if (l2 >= 0L)
            {
              l1 = 4363953127296L;
              n = i1;
              break;
            }
            n = i1 + 1;
            l1 = l2 ^ arrayOfByte[i1] << 49;
            if (l1 >= 0L) {
              break label293;
            }
          }
          i1 = n + 1;
          l2 = l1 ^ arrayOfByte[n] << 56 ^ 0xFE03F80;
          n = i1;
          l1 = l2;
        } while (l2 >= 0L);
        n = i1 + 1;
        l1 = l2;
        if (arrayOfByte[i1] >= 0L) {
          break label350;
        }
      }
    }
    return t();
    label350:
    this.i = n;
    return l1;
  }
  
  public int C()
  {
    int n = this.i;
    if (this.g - n >= 4)
    {
      byte[] arrayOfByte = this.e;
      this.i = (n + 4);
      int i1 = arrayOfByte[n];
      int i2 = arrayOfByte[(n + 1)];
      int i3 = arrayOfByte[(n + 2)];
      return (arrayOfByte[(n + 3)] & 0xFF) << 24 | i1 & 0xFF | (i2 & 0xFF) << 8 | (i3 & 0xFF) << 16;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public long D()
  {
    int n = this.i;
    if (this.g - n >= 8)
    {
      byte[] arrayOfByte = this.e;
      this.i = (n + 8);
      long l1 = arrayOfByte[n];
      long l2 = arrayOfByte[(n + 1)];
      long l3 = arrayOfByte[(n + 2)];
      long l4 = arrayOfByte[(n + 3)];
      long l5 = arrayOfByte[(n + 4)];
      long l6 = arrayOfByte[(n + 5)];
      long l7 = arrayOfByte[(n + 6)];
      return (arrayOfByte[(n + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public byte E()
  {
    int n = this.i;
    if (n != this.g)
    {
      byte[] arrayOfByte = this.e;
      this.i = (n + 1);
      return arrayOfByte[n];
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public int a()
  {
    if (y())
    {
      this.k = 0;
      return 0;
    }
    this.k = s();
    if (WireFormat.b(this.k) != 0) {
      return this.k;
    }
    throw InvalidProtocolBufferException.invalidTag();
  }
  
  public <T extends MessageLite> T a(Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int n = s();
    if (this.a < this.b)
    {
      n = c(n);
      this.a += 1;
      paramParser = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
      a(0);
      this.a -= 1;
      d(n);
      return paramParser;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public void a(int paramInt)
  {
    if (this.k == paramInt) {
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
    int n = s();
    if (this.a < this.b)
    {
      n = c(n);
      this.a += 1;
      paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
      a(0);
      this.a -= 1;
      d(n);
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
    int n = WireFormat.a(paramInt);
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 4)
            {
              if (n == 5)
              {
                g(4);
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
        g(s());
        return true;
      }
      g(8);
      return true;
    }
    F();
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
      int n = this.m;
      if (paramInt <= n)
      {
        this.m = paramInt;
        I();
        return n;
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
    this.m = paramInt;
    I();
  }
  
  public long e()
  {
    return B();
  }
  
  public int f()
  {
    return s();
  }
  
  public byte[] f(int paramInt)
  {
    if (paramInt > 0)
    {
      int n = this.g;
      int i1 = this.i;
      if (paramInt <= n - i1)
      {
        this.i = (paramInt + i1);
        return Arrays.copyOfRange(this.e, i1, this.i);
      }
    }
    if (paramInt <= 0)
    {
      if (paramInt == 0) {
        return Internal.c;
      }
      throw InvalidProtocolBufferException.negativeSize();
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public long g()
  {
    return D();
  }
  
  public void g(int paramInt)
  {
    if (paramInt >= 0)
    {
      int n = this.g;
      int i1 = this.i;
      if (paramInt <= n - i1)
      {
        this.i = (i1 + paramInt);
        return;
      }
    }
    if (paramInt < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    throw InvalidProtocolBufferException.truncatedMessage();
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
    int n = s();
    if (n > 0)
    {
      int i1 = this.g;
      int i2 = this.i;
      if (n <= i1 - i2)
      {
        String str = new String(this.e, i2, n, Internal.a);
        this.i += n;
        return str;
      }
    }
    if (n == 0) {
      return "";
    }
    if (n < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public String k()
  {
    int n = s();
    if (n > 0)
    {
      int i1 = this.g;
      int i2 = this.i;
      if (n <= i1 - i2)
      {
        String str = Utf8.b(this.e, i2, n);
        this.i += n;
        return str;
      }
    }
    if (n == 0) {
      return "";
    }
    if (n <= 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public ByteString l()
  {
    int n = s();
    if (n > 0)
    {
      int i1 = this.g;
      int i2 = this.i;
      if (n <= i1 - i2)
      {
        ByteString localByteString;
        if ((this.f) && (this.l)) {
          localByteString = ByteString.wrap(this.e, i2, n);
        } else {
          localByteString = ByteString.copyFrom(this.e, this.i, n);
        }
        this.i += n;
        return localByteString;
      }
    }
    if (n == 0) {
      return ByteString.EMPTY;
    }
    return ByteString.wrap(f(n));
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
    int i2 = this.i;
    int n = this.g;
    int i1;
    if (n != i2)
    {
      byte[] arrayOfByte = this.e;
      i1 = i2 + 1;
      i2 = arrayOfByte[i2];
      if (i2 >= 0)
      {
        this.i = i1;
        return i2;
      }
      if (n - i1 >= 9)
      {
        n = i1 + 1;
        i2 ^= arrayOfByte[i1] << 7;
        if (i2 < 0)
        {
          i1 = i2 ^ 0xFFFFFF80;
          break label267;
        }
        i1 = n + 1;
        i2 ^= arrayOfByte[n] << 14;
        if (i2 >= 0)
        {
          i2 ^= 0x3F80;
          n = i1;
          i1 = i2;
        }
        int i3;
        int i4;
        do
        {
          do
          {
            do
            {
              break;
              n = i1 + 1;
              i1 = i2 ^ arrayOfByte[i1] << 21;
              if (i1 < 0)
              {
                i1 ^= 0xFFE03F80;
                break;
              }
              i3 = n + 1;
              i4 = arrayOfByte[n];
              i2 = i1 ^ i4 << 28 ^ 0xFE03F80;
              i1 = i2;
              n = i3;
            } while (i4 >= 0);
            i4 = i3 + 1;
            i1 = i2;
            n = i4;
            if (arrayOfByte[i3] >= 0) {
              break;
            }
            i3 = i4 + 1;
            i1 = i2;
            n = i3;
          } while (arrayOfByte[i4] >= 0);
          i4 = i3 + 1;
          i1 = i2;
          n = i4;
          if (arrayOfByte[i3] >= 0) {
            break;
          }
          i3 = i4 + 1;
          i1 = i2;
          n = i3;
        } while (arrayOfByte[i4] >= 0);
        n = i3 + 1;
        i1 = i2;
        if (arrayOfByte[i3] >= 0) {
          break label267;
        }
      }
    }
    return (int)t();
    label267:
    this.i = n;
    return i1;
  }
  
  long t()
  {
    long l1 = 0L;
    int n = 0;
    while (n < 64)
    {
      int i1 = E();
      l1 |= (i1 & 0x7F) << n;
      if ((i1 & 0x80) == 0) {
        return l1;
      }
      n += 7;
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  public int x()
  {
    int n = this.m;
    if (n == 2147483647) {
      return -1;
    }
    return n - z();
  }
  
  public boolean y()
  {
    return this.i == this.g;
  }
  
  public int z()
  {
    return this.i - this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedInputStream.ArrayDecoder
 * JD-Core Version:    0.7.0.1
 */