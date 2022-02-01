package com.google.protobuf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class CodedInputStream$StreamDecoder
  extends CodedInputStream
{
  private final InputStream e;
  private final byte[] f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l = 2147483647;
  private CodedInputStream.StreamDecoder.RefillCallback m = null;
  
  private CodedInputStream$StreamDecoder(InputStream paramInputStream, int paramInt)
  {
    super(null);
    Internal.a(paramInputStream, "input");
    this.e = paramInputStream;
    this.f = new byte[paramInt];
    this.g = 0;
    this.i = 0;
    this.k = 0;
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
      localObject = this.f;
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
    int i1 = this.k;
    int n = this.g;
    i1 += n;
    int i2 = this.l;
    if (i1 > i2)
    {
      this.h = (i1 - i2);
      this.g = (n - this.h);
      return;
    }
    this.h = 0;
  }
  
  private byte[] a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = i(paramInt);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = (byte[])((byte[])localObject2).clone();
      }
      return localObject1;
    }
    int i1 = this.i;
    int i2 = this.g;
    int n = i2 - i1;
    this.k += i2;
    this.i = 0;
    this.g = 0;
    localObject2 = j(paramInt - n);
    Object localObject1 = new byte[paramInt];
    System.arraycopy(this.f, i1, localObject1, 0, n);
    localObject2 = ((List)localObject2).iterator();
    paramInt = n;
    while (((Iterator)localObject2).hasNext())
    {
      byte[] arrayOfByte = (byte[])((Iterator)localObject2).next();
      System.arraycopy(arrayOfByte, 0, localObject1, paramInt, arrayOfByte.length);
      paramInt += arrayOfByte.length;
    }
    return localObject1;
  }
  
  private void g(int paramInt)
  {
    if (!h(paramInt))
    {
      if (paramInt > this.c - this.k - this.i) {
        throw InvalidProtocolBufferException.sizeLimitExceeded();
      }
      throw InvalidProtocolBufferException.truncatedMessage();
    }
  }
  
  private boolean h(int paramInt)
  {
    if (this.i + paramInt > this.g)
    {
      int n = this.c;
      int i1 = this.k;
      int i2 = this.i;
      if (paramInt > n - i1 - i2) {
        return false;
      }
      if (i1 + i2 + paramInt > this.l) {
        return false;
      }
      localObject = this.m;
      if (localObject != null) {
        ((CodedInputStream.StreamDecoder.RefillCallback)localObject).a();
      }
      n = this.i;
      if (n > 0)
      {
        i1 = this.g;
        if (i1 > n)
        {
          localObject = this.f;
          System.arraycopy(localObject, n, localObject, 0, i1 - n);
        }
        this.k += n;
        this.g -= n;
        this.i = 0;
      }
      localObject = this.e;
      byte[] arrayOfByte = this.f;
      n = this.g;
      n = ((InputStream)localObject).read(arrayOfByte, n, Math.min(arrayOfByte.length - n, this.c - this.k - this.g));
      if ((n != 0) && (n >= -1) && (n <= this.f.length))
      {
        if (n > 0)
        {
          this.g += n;
          I();
          if (this.g >= paramInt) {
            return true;
          }
          return h(paramInt);
        }
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.e.getClass());
      ((StringBuilder)localObject).append("#read(byte[]) returned invalid result: ");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append("\nThe InputStream implementation is buggy.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refillBuffer() called when ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" bytes were already available in buffer");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private byte[] i(int paramInt)
  {
    if (paramInt == 0) {
      return Internal.c;
    }
    if (paramInt >= 0)
    {
      int n = this.k + this.i + paramInt;
      if (n - this.c <= 0)
      {
        int i1 = this.l;
        if (n <= i1)
        {
          n = this.g - this.i;
          i1 = paramInt - n;
          if ((i1 >= 4096) && (i1 > this.e.available())) {
            return null;
          }
          localObject = new byte[paramInt];
          System.arraycopy(this.f, this.i, localObject, 0, n);
          this.k += this.g;
          this.i = 0;
          this.g = 0;
          while (n < localObject.length)
          {
            i1 = this.e.read((byte[])localObject, n, paramInt - n);
            if (i1 != -1)
            {
              this.k += i1;
              n += i1;
            }
            else
            {
              throw InvalidProtocolBufferException.truncatedMessage();
            }
          }
          return localObject;
        }
        f(i1 - this.k - this.i);
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      throw InvalidProtocolBufferException.sizeLimitExceeded();
    }
    Object localObject = InvalidProtocolBufferException.negativeSize();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private List<byte[]> j(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramInt > 0)
    {
      byte[] arrayOfByte = new byte[Math.min(paramInt, 4096)];
      int n = 0;
      while (n < arrayOfByte.length)
      {
        int i1 = this.e.read(arrayOfByte, n, arrayOfByte.length - n);
        if (i1 != -1)
        {
          this.k += i1;
          n += i1;
        }
        else
        {
          throw InvalidProtocolBufferException.truncatedMessage();
        }
      }
      paramInt -= arrayOfByte.length;
      localArrayList.add(arrayOfByte);
    }
    return localArrayList;
  }
  
  private ByteString k(int paramInt)
  {
    byte[] arrayOfByte1 = i(paramInt);
    if (arrayOfByte1 != null) {
      return ByteString.copyFrom(arrayOfByte1);
    }
    int i1 = this.i;
    int i2 = this.g;
    int n = i2 - i1;
    this.k += i2;
    this.i = 0;
    this.g = 0;
    Object localObject = j(paramInt - n);
    arrayOfByte1 = new byte[paramInt];
    System.arraycopy(this.f, i1, arrayOfByte1, 0, n);
    localObject = ((List)localObject).iterator();
    paramInt = n;
    while (((Iterator)localObject).hasNext())
    {
      byte[] arrayOfByte2 = (byte[])((Iterator)localObject).next();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt, arrayOfByte2.length);
      paramInt += arrayOfByte2.length;
    }
    return ByteString.wrap(arrayOfByte1);
  }
  
  private void l(int paramInt)
  {
    int i2;
    int i1;
    int n;
    Object localObject1;
    if (paramInt >= 0)
    {
      i2 = this.k;
      i1 = this.i;
      n = this.l;
      if (i2 + i1 + paramInt <= n)
      {
        localObject1 = this.m;
        n = 0;
        if (localObject1 == null)
        {
          this.k = (i2 + i1);
          n = this.g;
          this.g = 0;
          this.i = 0;
          n -= i1;
        }
      }
    }
    for (;;)
    {
      long l2;
      if (n < paramInt)
      {
        try
        {
          localObject1 = this.e;
          long l1 = paramInt - n;
          l2 = ((InputStream)localObject1).skip(l1);
          if ((l2 >= 0L) && (l2 <= l1))
          {
            if (l2 != 0L) {
              break label308;
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.e.getClass());
            ((StringBuilder)localObject1).append("#skip returned invalid result: ");
            ((StringBuilder)localObject1).append(l2);
            ((StringBuilder)localObject1).append("\nThe InputStream implementation is buggy.");
            throw new IllegalStateException(((StringBuilder)localObject1).toString());
          }
        }
        finally
        {
          this.k += n;
          I();
        }
      }
      else
      {
        this.k += n;
        I();
        if (n < paramInt)
        {
          i1 = this.g;
          n = i1 - this.i;
          this.i = i1;
          g(1);
          for (;;)
          {
            i2 = paramInt - n;
            i1 = this.g;
            if (i2 <= i1) {
              break;
            }
            n += i1;
            this.i = i1;
            g(1);
          }
          this.i = i2;
        }
        return;
        f(n - i2 - i1);
        throw InvalidProtocolBufferException.truncatedMessage();
        InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.negativeSize();
        for (;;)
        {
          throw localInvalidProtocolBufferException;
        }
      }
      label308:
      n += (int)l2;
    }
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
      byte[] arrayOfByte = this.f;
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
    int i1 = this.i;
    int n = i1;
    if (this.g - i1 < 4)
    {
      g(4);
      n = this.i;
    }
    byte[] arrayOfByte = this.f;
    this.i = (n + 4);
    i1 = arrayOfByte[n];
    int i2 = arrayOfByte[(n + 1)];
    int i3 = arrayOfByte[(n + 2)];
    return (arrayOfByte[(n + 3)] & 0xFF) << 24 | i1 & 0xFF | (i2 & 0xFF) << 8 | (i3 & 0xFF) << 16;
  }
  
  public long D()
  {
    int i1 = this.i;
    int n = i1;
    if (this.g - i1 < 8)
    {
      g(8);
      n = this.i;
    }
    byte[] arrayOfByte = this.f;
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
  
  public byte E()
  {
    if (this.i == this.g) {
      g(1);
    }
    byte[] arrayOfByte = this.f;
    int n = this.i;
    this.i = (n + 1);
    return arrayOfByte[n];
  }
  
  public int a()
  {
    if (y())
    {
      this.j = 0;
      return 0;
    }
    this.j = s();
    if (WireFormat.b(this.j) != 0) {
      return this.j;
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
    if (this.j == paramInt) {
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
      paramInt += this.k + this.i;
      int n = this.l;
      if (paramInt <= n)
      {
        this.l = paramInt;
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
    this.l = paramInt;
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
  
  public void f(int paramInt)
  {
    int n = this.g;
    int i1 = this.i;
    if ((paramInt <= n - i1) && (paramInt >= 0))
    {
      this.i = (i1 + paramInt);
      return;
    }
    l(paramInt);
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
    int n = s();
    String str;
    if (n > 0)
    {
      int i1 = this.g;
      int i2 = this.i;
      if (n <= i1 - i2)
      {
        str = new String(this.f, i2, n, Internal.a);
        this.i += n;
        return str;
      }
    }
    if (n == 0) {
      return "";
    }
    if (n <= this.g)
    {
      g(n);
      str = new String(this.f, this.i, n, Internal.a);
      this.i += n;
      return str;
    }
    return new String(a(n, false), Internal.a);
  }
  
  public String k()
  {
    int i2 = s();
    int n = this.i;
    int i3 = this.g;
    int i1 = 0;
    byte[] arrayOfByte;
    if ((i2 <= i3 - n) && (i2 > 0))
    {
      arrayOfByte = this.f;
      this.i = (n + i2);
    }
    else
    {
      if (i2 == 0) {
        return "";
      }
      if (i2 <= this.g)
      {
        g(i2);
        arrayOfByte = this.f;
        this.i = (i2 + 0);
        n = i1;
      }
      else
      {
        arrayOfByte = a(i2, false);
        n = i1;
      }
    }
    return Utf8.b(arrayOfByte, n, i2);
  }
  
  public ByteString l()
  {
    int n = s();
    int i1 = this.g;
    int i2 = this.i;
    if ((n <= i1 - i2) && (n > 0))
    {
      ByteString localByteString = ByteString.copyFrom(this.f, i2, n);
      this.i += n;
      return localByteString;
    }
    if (n == 0) {
      return ByteString.EMPTY;
    }
    return k(n);
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
      byte[] arrayOfByte = this.f;
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
          break label268;
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
          break label268;
        }
      }
    }
    return (int)t();
    label268:
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
    int n = this.l;
    if (n == 2147483647) {
      return -1;
    }
    return n - (this.k + this.i);
  }
  
  public boolean y()
  {
    return (this.i == this.g) && (!h(1));
  }
  
  public int z()
  {
    return this.k + this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedInputStream.StreamDecoder
 * JD-Core Version:    0.7.0.1
 */