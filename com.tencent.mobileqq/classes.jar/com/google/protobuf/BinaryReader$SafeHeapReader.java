package com.google.protobuf;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

final class BinaryReader$SafeHeapReader
  extends BinaryReader
{
  private final boolean a;
  private final byte[] b;
  private int c;
  private final int d;
  private int e;
  private int f;
  private int g;
  
  public BinaryReader$SafeHeapReader(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    super(null);
    this.a = paramBoolean;
    this.b = paramByteBuffer.array();
    int i = paramByteBuffer.arrayOffset() + paramByteBuffer.position();
    this.c = i;
    this.d = i;
    this.e = (paramByteBuffer.arrayOffset() + paramByteBuffer.limit());
  }
  
  private int A()
  {
    b(4);
    return C();
  }
  
  private long B()
  {
    b(8);
    return D();
  }
  
  private int C()
  {
    int i = this.c;
    byte[] arrayOfByte = this.b;
    this.c = (i + 4);
    int j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  private long D()
  {
    int i = this.c;
    byte[] arrayOfByte = this.b;
    this.c = (i + 8);
    long l1 = arrayOfByte[i];
    long l2 = arrayOfByte[(i + 1)];
    long l3 = arrayOfByte[(i + 2)];
    long l4 = arrayOfByte[(i + 3)];
    long l5 = arrayOfByte[(i + 4)];
    long l6 = arrayOfByte[(i + 5)];
    long l7 = arrayOfByte[(i + 6)];
    return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  private void E()
  {
    int j = this.e;
    int i = this.c;
    if (j - i >= 10)
    {
      byte[] arrayOfByte = this.b;
      j = 0;
      while (j < 10)
      {
        int k = i + 1;
        if (arrayOfByte[i] >= 0)
        {
          this.c = k;
          return;
        }
        j += 1;
        i = k;
      }
    }
    F();
  }
  
  private void F()
  {
    int i = 0;
    while (i < 10)
    {
      if (z() >= 0) {
        return;
      }
      i += 1;
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  private void G()
  {
    int i = this.g;
    this.g = WireFormat.a(WireFormat.b(this.f), 4);
    while ((b() != 2147483647) && (d())) {}
    if (this.f == this.g)
    {
      this.g = i;
      return;
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.parseFailure();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  private Object a(WireFormat.FieldType paramFieldType, Class<?> paramClass, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    switch (BinaryReader.1.a[paramFieldType.ordinal()])
    {
    default: 
      throw new RuntimeException("unsupported field type.");
    case 17: 
      return Long.valueOf(g());
    case 16: 
      return Integer.valueOf(p());
    case 15: 
      return n();
    case 14: 
      return Long.valueOf(u());
    case 13: 
      return Integer.valueOf(t());
    case 12: 
      return Long.valueOf(s());
    case 11: 
      return Integer.valueOf(r());
    case 10: 
      return a(paramClass, paramExtensionRegistryLite);
    case 9: 
      return Long.valueOf(h());
    case 8: 
      return Integer.valueOf(i());
    case 7: 
      return Float.valueOf(f());
    case 6: 
      return Long.valueOf(j());
    case 5: 
      return Integer.valueOf(k());
    case 4: 
      return Integer.valueOf(q());
    case 3: 
      return Double.valueOf(e());
    case 2: 
      return o();
    }
    return Boolean.valueOf(l());
  }
  
  private void a(int paramInt)
  {
    b(paramInt);
    this.c += paramInt;
  }
  
  private void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.e - this.c)) {
      return;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private <T> T c(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int j = x();
    b(j);
    int i = this.e;
    j = this.c + j;
    this.e = j;
    try
    {
      Object localObject = paramSchema.a();
      paramSchema.a(localObject, this, paramExtensionRegistryLite);
      paramSchema.d(localObject);
      int k = this.c;
      if (k == j) {
        return localObject;
      }
      throw InvalidProtocolBufferException.parseFailure();
    }
    finally
    {
      this.e = i;
    }
  }
  
  private void c(int paramInt)
  {
    if (WireFormat.a(this.f) == paramInt) {
      return;
    }
    throw InvalidProtocolBufferException.invalidWireType();
  }
  
  private <T> T d(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = this.g;
    this.g = WireFormat.a(WireFormat.b(this.f), 4);
    try
    {
      Object localObject = paramSchema.a();
      paramSchema.a(localObject, this, paramExtensionRegistryLite);
      paramSchema.d(localObject);
      int j = this.f;
      int k = this.g;
      if (j == k) {
        return localObject;
      }
      throw InvalidProtocolBufferException.parseFailure();
    }
    finally
    {
      this.g = i;
    }
  }
  
  private void d(int paramInt)
  {
    b(paramInt);
    if ((paramInt & 0x7) == 0) {
      return;
    }
    throw InvalidProtocolBufferException.parseFailure();
  }
  
  private void e(int paramInt)
  {
    b(paramInt);
    if ((paramInt & 0x3) == 0) {
      return;
    }
    throw InvalidProtocolBufferException.parseFailure();
  }
  
  private void f(int paramInt)
  {
    if (this.c == paramInt) {
      return;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private boolean w()
  {
    return this.c == this.e;
  }
  
  private int x()
  {
    int k = this.c;
    int i = this.e;
    if (i != k)
    {
      localObject = this.b;
      int j = k + 1;
      k = localObject[k];
      if (k >= 0)
      {
        this.c = j;
        return k;
      }
      if (i - j < 9) {
        return (int)y();
      }
      i = j + 1;
      k ^= localObject[j] << 7;
      if (k < 0)
      {
        j = k ^ 0xFFFFFF80;
      }
      else
      {
        j = i + 1;
        k ^= localObject[i] << 14;
        if (k >= 0)
        {
          k ^= 0x3F80;
          i = j;
          j = k;
        }
        for (;;)
        {
          break;
          i = j + 1;
          j = k ^ localObject[j] << 21;
          if (j < 0)
          {
            j ^= 0xFFE03F80;
          }
          else
          {
            int m = i + 1;
            int n = localObject[i];
            k = j ^ n << 28 ^ 0xFE03F80;
            j = k;
            i = m;
            if (n < 0)
            {
              n = m + 1;
              j = k;
              i = n;
              if (localObject[m] < 0)
              {
                m = n + 1;
                j = k;
                i = m;
                if (localObject[n] < 0)
                {
                  n = m + 1;
                  j = k;
                  i = n;
                  if (localObject[m] < 0)
                  {
                    m = n + 1;
                    j = k;
                    i = m;
                    if (localObject[n] < 0)
                    {
                      i = m + 1;
                      if (localObject[m] >= 0) {
                        j = k;
                      } else {
                        throw InvalidProtocolBufferException.malformedVarint();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      this.c = i;
      return j;
    }
    Object localObject = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private long y()
  {
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = z();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  private byte z()
  {
    int i = this.c;
    if (i != this.e)
    {
      byte[] arrayOfByte = this.b;
      this.c = (i + 1);
      return arrayOfByte[i];
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public <T> T a(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    c(2);
    return c(paramSchema, paramExtensionRegistryLite);
  }
  
  public <T> T a(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    c(2);
    return c(Protobuf.a().a(paramClass), paramExtensionRegistryLite);
  }
  
  public String a(boolean paramBoolean)
  {
    c(2);
    int i = x();
    if (i == 0) {
      return "";
    }
    b(i);
    if (paramBoolean)
    {
      localObject = this.b;
      int j = this.c;
      if (!Utf8.a((byte[])localObject, j, j + i)) {
        throw InvalidProtocolBufferException.invalidUtf8();
      }
    }
    Object localObject = new String(this.b, this.c, i, Internal.a);
    this.c += i;
    return localObject;
  }
  
  public void a(List<Double> paramList)
  {
    int j;
    if ((paramList instanceof DoubleArrayList))
    {
      paramList = (DoubleArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 1)
      {
        if (i == 2)
        {
          i = x();
          d(i);
          j = this.c;
          while (this.c < j + i) {
            paramList.a(Double.longBitsToDouble(D()));
          }
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(e());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 1)
    {
      if (i == 2)
      {
        i = x();
        d(i);
        j = this.c;
        while (this.c < j + i) {
          paramList.add(Double.valueOf(Double.longBitsToDouble(D())));
        }
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Double.valueOf(e()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public <T> void a(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (WireFormat.a(this.f) == 2)
    {
      int i = this.f;
      int j;
      do
      {
        paramList.add(c(paramSchema, paramExtensionRegistryLite));
        if (w()) {
          return;
        }
        j = this.c;
      } while (x() == i);
      this.c = j;
      return;
    }
    paramList = InvalidProtocolBufferException.invalidWireType();
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (WireFormat.a(this.f) == 2)
    {
      int i;
      if (((paramList instanceof LazyStringList)) && (!paramBoolean))
      {
        paramList = (LazyStringList)paramList;
        do
        {
          paramList.a(o());
          if (w()) {
            return;
          }
          i = this.c;
        } while (x() == this.f);
        this.c = i;
        return;
      }
      do
      {
        paramList.add(a(paramBoolean));
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    paramList = InvalidProtocolBufferException.invalidWireType();
    for (;;)
    {
      throw paramList;
    }
  }
  
  public <K, V> void a(Map<K, V> paramMap, MapEntryLite.Metadata<K, V> paramMetadata, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    c(2);
    int j = x();
    b(j);
    i = this.e;
    this.e = (this.c + j);
    do
    {
      for (;;)
      {
        try
        {
          localObject1 = paramMetadata.d;
          localObject2 = paramMetadata.f;
          j = b();
          if (j == 2147483647)
          {
            paramMap.put(localObject1, localObject2);
            this.e = i;
            return;
          }
          if (j != 1) {
            if (j == 2) {}
          }
        }
        finally
        {
          Object localObject1;
          Object localObject2;
          Object localObject3;
          this.e = i;
          continue;
          throw paramMap;
          continue;
        }
        try
        {
          if (d()) {
            continue;
          }
          throw new InvalidProtocolBufferException("Unable to parse map entry.");
        }
        catch (InvalidProtocolBufferException.InvalidWireTypeException localInvalidWireTypeException)
        {
          continue;
        }
        localObject3 = a(paramMetadata.e, paramMetadata.f.getClass(), paramExtensionRegistryLite);
        localObject2 = localObject3;
        continue;
        localObject3 = a(paramMetadata.c, null, null);
        localObject1 = localObject3;
      }
    } while (d());
    throw new InvalidProtocolBufferException("Unable to parse map entry.");
  }
  
  public int b()
  {
    if (w()) {
      return 2147483647;
    }
    this.f = x();
    int i = this.f;
    if (i == this.g) {
      return 2147483647;
    }
    return WireFormat.b(i);
  }
  
  public <T> T b(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    c(3);
    return d(paramSchema, paramExtensionRegistryLite);
  }
  
  public <T> T b(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    c(3);
    return d(Protobuf.a().a(paramClass), paramExtensionRegistryLite);
  }
  
  public void b(List<Float> paramList)
  {
    if ((paramList instanceof FloatArrayList))
    {
      paramList = (FloatArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.a(f());
            if (w()) {
              return;
            }
            i = this.c;
          } while (x() == this.f);
          this.c = i;
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      i = x();
      e(i);
      j = this.c;
      while (this.c < j + i) {
        paramList.a(Float.intBitsToFloat(C()));
      }
    }
    int i = WireFormat.a(this.f);
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Float.valueOf(f()));
          if (w()) {
            return;
          }
          i = this.c;
        } while (x() == this.f);
        this.c = i;
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    i = x();
    e(i);
    int j = this.c;
    while (this.c < j + i) {
      paramList.add(Float.valueOf(Float.intBitsToFloat(C())));
    }
  }
  
  public <T> void b(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (WireFormat.a(this.f) == 3)
    {
      int i = this.f;
      int j;
      do
      {
        paramList.add(d(paramSchema, paramExtensionRegistryLite));
        if (w()) {
          return;
        }
        j = this.c;
      } while (x() == i);
      this.c = j;
      return;
    }
    paramList = InvalidProtocolBufferException.invalidWireType();
    for (;;)
    {
      throw paramList;
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void c(List<Long> paramList)
  {
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 0)
      {
        if (i == 2)
        {
          i = x();
          i = this.c + i;
          while (this.c < i) {
            paramList.a(v());
          }
          f(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(g());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 0)
    {
      if (i == 2)
      {
        i = x();
        i = this.c + i;
        while (this.c < i) {
          paramList.add(Long.valueOf(v()));
        }
        f(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(g()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public void d(List<Long> paramList)
  {
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 0)
      {
        if (i == 2)
        {
          i = x();
          i = this.c + i;
          while (this.c < i) {
            paramList.a(v());
          }
          f(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(h());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 0)
    {
      if (i == 2)
      {
        i = x();
        i = this.c + i;
        while (this.c < i) {
          paramList.add(Long.valueOf(v()));
        }
        f(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(h()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public boolean d()
  {
    if (!w())
    {
      int i = this.f;
      if (i != this.g)
      {
        i = WireFormat.a(i);
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 5)
                {
                  a(4);
                  return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
              }
              G();
              return true;
            }
            a(x());
            return true;
          }
          a(8);
          return true;
        }
        E();
        return true;
      }
    }
    return false;
  }
  
  public double e()
  {
    c(1);
    return Double.longBitsToDouble(B());
  }
  
  public void e(List<Integer> paramList)
  {
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 0)
      {
        if (i == 2)
        {
          i = x();
          i = this.c + i;
          while (this.c < i) {
            paramList.d(x());
          }
          f(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.d(i());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 0)
    {
      if (i == 2)
      {
        i = x();
        i = this.c + i;
        while (this.c < i) {
          paramList.add(Integer.valueOf(x()));
        }
        f(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Integer.valueOf(i()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public float f()
  {
    c(5);
    return Float.intBitsToFloat(A());
  }
  
  public void f(List<Long> paramList)
  {
    int j;
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 1)
      {
        if (i == 2)
        {
          i = x();
          d(i);
          j = this.c;
          while (this.c < j + i) {
            paramList.a(D());
          }
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(j());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 1)
    {
      if (i == 2)
      {
        i = x();
        d(i);
        j = this.c;
        while (this.c < j + i) {
          paramList.add(Long.valueOf(D()));
        }
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(j()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public long g()
  {
    c(0);
    return v();
  }
  
  public void g(List<Integer> paramList)
  {
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.d(k());
            if (w()) {
              return;
            }
            i = this.c;
          } while (x() == this.f);
          this.c = i;
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      i = x();
      e(i);
      j = this.c;
      while (this.c < j + i) {
        paramList.d(C());
      }
    }
    int i = WireFormat.a(this.f);
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(k()));
          if (w()) {
            return;
          }
          i = this.c;
        } while (x() == this.f);
        this.c = i;
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    i = x();
    e(i);
    int j = this.c;
    while (this.c < j + i) {
      paramList.add(Integer.valueOf(C()));
    }
  }
  
  public long h()
  {
    c(0);
    return v();
  }
  
  public void h(List<Boolean> paramList)
  {
    boolean bool;
    if ((paramList instanceof BooleanArrayList))
    {
      paramList = (BooleanArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 0)
      {
        if (i == 2)
        {
          i = x();
          i = this.c + i;
          while (this.c < i)
          {
            if (x() != 0) {
              bool = true;
            } else {
              bool = false;
            }
            paramList.a(bool);
          }
          f(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(l());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 0)
    {
      if (i == 2)
      {
        i = x();
        i = this.c + i;
        while (this.c < i)
        {
          if (x() != 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramList.add(Boolean.valueOf(bool));
        }
        f(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Boolean.valueOf(l()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public int i()
  {
    c(0);
    return x();
  }
  
  public void i(List<String> paramList)
  {
    a(paramList, false);
  }
  
  public long j()
  {
    c(1);
    return B();
  }
  
  public void j(List<String> paramList)
  {
    a(paramList, true);
  }
  
  public int k()
  {
    c(5);
    return A();
  }
  
  public void k(List<ByteString> paramList)
  {
    if (WireFormat.a(this.f) == 2)
    {
      int i;
      do
      {
        paramList.add(o());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    paramList = InvalidProtocolBufferException.invalidWireType();
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void l(List<Integer> paramList)
  {
    int j;
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 0)
      {
        if (i == 2)
        {
          i = x();
          j = this.c;
          while (this.c < j + i) {
            paramList.d(x());
          }
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.d(p());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 0)
    {
      if (i == 2)
      {
        i = x();
        j = this.c;
        while (this.c < j + i) {
          paramList.add(Integer.valueOf(x()));
        }
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Integer.valueOf(p()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public boolean l()
  {
    boolean bool = false;
    c(0);
    if (x() != 0) {
      bool = true;
    }
    return bool;
  }
  
  public String m()
  {
    return a(false);
  }
  
  public void m(List<Integer> paramList)
  {
    int j;
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 0)
      {
        if (i == 2)
        {
          i = x();
          j = this.c;
          while (this.c < j + i) {
            paramList.d(x());
          }
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.d(q());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 0)
    {
      if (i == 2)
      {
        i = x();
        j = this.c;
        while (this.c < j + i) {
          paramList.add(Integer.valueOf(x()));
        }
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Integer.valueOf(q()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public String n()
  {
    return a(true);
  }
  
  public void n(List<Integer> paramList)
  {
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.d(r());
            if (w()) {
              return;
            }
            i = this.c;
          } while (x() == this.f);
          this.c = i;
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      i = x();
      e(i);
      j = this.c;
      while (this.c < j + i) {
        paramList.d(C());
      }
    }
    int i = WireFormat.a(this.f);
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(r()));
          if (w()) {
            return;
          }
          i = this.c;
        } while (x() == this.f);
        this.c = i;
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    i = x();
    e(i);
    int j = this.c;
    while (this.c < j + i) {
      paramList.add(Integer.valueOf(C()));
    }
  }
  
  public ByteString o()
  {
    c(2);
    int i = x();
    if (i == 0) {
      return ByteString.EMPTY;
    }
    b(i);
    ByteString localByteString;
    if (this.a) {
      localByteString = ByteString.wrap(this.b, this.c, i);
    } else {
      localByteString = ByteString.copyFrom(this.b, this.c, i);
    }
    this.c += i;
    return localByteString;
  }
  
  public void o(List<Long> paramList)
  {
    int j;
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 1)
      {
        if (i == 2)
        {
          i = x();
          d(i);
          j = this.c;
          while (this.c < j + i) {
            paramList.a(D());
          }
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(s());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 1)
    {
      if (i == 2)
      {
        i = x();
        d(i);
        j = this.c;
        while (this.c < j + i) {
          paramList.add(Long.valueOf(D()));
        }
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(s()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public int p()
  {
    c(0);
    return x();
  }
  
  public void p(List<Integer> paramList)
  {
    int j;
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 0)
      {
        if (i == 2)
        {
          i = x();
          j = this.c;
          while (this.c < j + i) {
            paramList.d(CodedInputStream.e(x()));
          }
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.d(t());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 0)
    {
      if (i == 2)
      {
        i = x();
        j = this.c;
        while (this.c < j + i) {
          paramList.add(Integer.valueOf(CodedInputStream.e(x())));
        }
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Integer.valueOf(t()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public int q()
  {
    c(0);
    return x();
  }
  
  public void q(List<Long> paramList)
  {
    int j;
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.f);
      if (i != 0)
      {
        if (i == 2)
        {
          i = x();
          j = this.c;
          while (this.c < j + i) {
            paramList.a(CodedInputStream.a(v()));
          }
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(u());
        if (w()) {
          return;
        }
        i = this.c;
      } while (x() == this.f);
      this.c = i;
      return;
    }
    int i = WireFormat.a(this.f);
    if (i != 0)
    {
      if (i == 2)
      {
        i = x();
        j = this.c;
        while (this.c < j + i) {
          paramList.add(Long.valueOf(CodedInputStream.a(v())));
        }
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(u()));
      if (w()) {
        return;
      }
      i = this.c;
    } while (x() == this.f);
    this.c = i;
  }
  
  public int r()
  {
    c(5);
    return A();
  }
  
  public long s()
  {
    c(1);
    return B();
  }
  
  public int t()
  {
    c(0);
    return CodedInputStream.e(x());
  }
  
  public long u()
  {
    c(0);
    return CodedInputStream.a(v());
  }
  
  public long v()
  {
    int k = this.c;
    int i = this.e;
    if (i != k)
    {
      localObject = this.b;
      int j = k + 1;
      k = localObject[k];
      if (k >= 0)
      {
        this.c = j;
        return k;
      }
      if (i - j < 9) {
        return y();
      }
      i = j + 1;
      k ^= localObject[j] << 7;
      if (k < 0) {
        j = k ^ 0xFFFFFF80;
      }
      for (;;)
      {
        l1 = j;
        break label351;
        j = i + 1;
        k ^= localObject[i] << 14;
        if (k >= 0)
        {
          l1 = k ^ 0x3F80;
          i = j;
          break label351;
        }
        i = j + 1;
        j = k ^ localObject[j] << 21;
        if (j >= 0) {
          break;
        }
        j ^= 0xFFE03F80;
      }
      long l1 = j;
      j = i + 1;
      long l2 = l1 ^ localObject[i] << 28;
      if (l2 >= 0L)
      {
        l1 = 266354560L;
        i = j;
        l1 ^= l2;
      }
      for (;;)
      {
        break label351;
        i = j + 1;
        l1 = l2 ^ localObject[j] << 35;
        if (l1 < 0L) {}
        for (l2 = -34093383808L;; l2 = -558586000294016L)
        {
          l1 ^= l2;
          break label351;
          j = i + 1;
          l2 = l1 ^ localObject[i] << 42;
          if (l2 >= 0L)
          {
            l1 = 4363953127296L;
            i = j;
            break;
          }
          i = j + 1;
          l1 = l2 ^ localObject[j] << 49;
          if (l1 >= 0L) {
            break label292;
          }
        }
        label292:
        j = i + 1;
        l2 = l1 ^ localObject[i] << 56 ^ 0xFE03F80;
        i = j;
        l1 = l2;
        if (l2 < 0L)
        {
          i = j + 1;
          if (localObject[j] >= 0L) {
            l1 = l2;
          } else {
            throw InvalidProtocolBufferException.malformedVarint();
          }
        }
      }
      label351:
      this.c = i;
      return l1;
    }
    Object localObject = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.BinaryReader.SafeHeapReader
 * JD-Core Version:    0.7.0.1
 */