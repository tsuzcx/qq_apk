package com.google.protobuf;

import java.util.List;
import java.util.Map;

final class CodedInputStreamReader
  implements Reader
{
  private final CodedInputStream a;
  private int b;
  private int c;
  private int d = 0;
  
  private CodedInputStreamReader(CodedInputStream paramCodedInputStream)
  {
    this.a = ((CodedInputStream)Internal.a(paramCodedInputStream, "input"));
    this.a.d = this;
  }
  
  public static CodedInputStreamReader a(CodedInputStream paramCodedInputStream)
  {
    if (paramCodedInputStream.d != null) {
      return paramCodedInputStream.d;
    }
    return new CodedInputStreamReader(paramCodedInputStream);
  }
  
  private Object a(WireFormat.FieldType paramFieldType, Class<?> paramClass, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    switch (CodedInputStreamReader.1.a[paramFieldType.ordinal()])
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
    if (WireFormat.a(this.b) == paramInt) {
      return;
    }
    throw InvalidProtocolBufferException.invalidWireType();
  }
  
  private void b(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      return;
    }
    throw InvalidProtocolBufferException.parseFailure();
  }
  
  private <T> T c(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = this.a.m();
    if (this.a.a < this.a.b)
    {
      i = this.a.c(i);
      Object localObject = paramSchema.a();
      CodedInputStream localCodedInputStream = this.a;
      localCodedInputStream.a += 1;
      paramSchema.a(localObject, this, paramExtensionRegistryLite);
      paramSchema.d(localObject);
      this.a.a(0);
      paramSchema = this.a;
      paramSchema.a -= 1;
      this.a.d(i);
      return localObject;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  private void c(int paramInt)
  {
    if ((paramInt & 0x3) == 0) {
      return;
    }
    throw InvalidProtocolBufferException.parseFailure();
  }
  
  private <T> T d(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = this.c;
    this.c = WireFormat.a(WireFormat.b(this.b), 4);
    try
    {
      Object localObject = paramSchema.a();
      paramSchema.a(localObject, this, paramExtensionRegistryLite);
      paramSchema.d(localObject);
      int j = this.b;
      int k = this.c;
      if (j == k) {
        return localObject;
      }
      throw InvalidProtocolBufferException.parseFailure();
    }
    finally
    {
      this.c = i;
    }
  }
  
  private void d(int paramInt)
  {
    if (this.a.z() == paramInt) {
      return;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  public <T> T a(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    a(2);
    return c(paramSchema, paramExtensionRegistryLite);
  }
  
  public <T> T a(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    a(2);
    return c(Protobuf.a().a(paramClass), paramExtensionRegistryLite);
  }
  
  public void a(List<Double> paramList)
  {
    int j;
    if ((paramList instanceof DoubleArrayList))
    {
      paramList = (DoubleArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 1)
      {
        if (i == 2)
        {
          i = this.a.m();
          b(i);
          j = this.a.z();
          do
          {
            paramList.a(this.a.b());
          } while (this.a.z() < j + i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(this.a.b());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 1)
    {
      if (i == 2)
      {
        i = this.a.m();
        b(i);
        j = this.a.z();
        do
        {
          paramList.add(Double.valueOf(this.a.b()));
        } while (this.a.z() < j + i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Double.valueOf(this.a.b()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public <T> void a(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (WireFormat.a(this.b) == 2)
    {
      int i = this.b;
      int j;
      do
      {
        paramList.add(c(paramSchema, paramExtensionRegistryLite));
        if (this.a.y()) {
          break;
        }
        if (this.d != 0) {
          return;
        }
        j = this.a.a();
      } while (j == i);
      this.d = j;
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
    if (WireFormat.a(this.b) == 2)
    {
      int i;
      if (((paramList instanceof LazyStringList)) && (!paramBoolean))
      {
        paramList = (LazyStringList)paramList;
        do
        {
          paramList.a(o());
          if (this.a.y()) {
            return;
          }
          i = this.a.a();
        } while (i == this.b);
        this.d = i;
        return;
      }
      do
      {
        String str;
        if (paramBoolean) {
          str = n();
        } else {
          str = m();
        }
        paramList.add(str);
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
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
    a(2);
    i = this.a.m();
    i = this.a.c(i);
    Object localObject1 = paramMetadata.d;
    Object localObject2 = paramMetadata.f;
    do
    {
      for (;;)
      {
        try
        {
          int j = b();
          if (j != 2147483647)
          {
            boolean bool = this.a.y();
            if (!bool) {
              if (j != 1) {
                if (j == 2) {}
              }
            }
          }
        }
        finally
        {
          Object localObject3;
          this.a.d(i);
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
    paramMap.put(localObject1, localObject2);
    this.a.d(i);
  }
  
  public boolean a()
  {
    return this.a.w();
  }
  
  public int b()
  {
    int i = this.d;
    if (i != 0)
    {
      this.b = i;
      this.d = 0;
    }
    else
    {
      this.b = this.a.a();
    }
    i = this.b;
    if ((i != 0) && (i != this.c)) {
      return WireFormat.b(i);
    }
    return 2147483647;
  }
  
  public <T> T b(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    a(3);
    return d(paramSchema, paramExtensionRegistryLite);
  }
  
  public <T> T b(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    a(3);
    return d(Protobuf.a().a(paramClass), paramExtensionRegistryLite);
  }
  
  public void b(List<Float> paramList)
  {
    if ((paramList instanceof FloatArrayList))
    {
      paramList = (FloatArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.a(this.a.c());
            if (this.a.y()) {
              return;
            }
            i = this.a.a();
          } while (i == this.b);
          this.d = i;
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      i = this.a.m();
      c(i);
      j = this.a.z();
      do
      {
        paramList.a(this.a.c());
      } while (this.a.z() < j + i);
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Float.valueOf(this.a.c()));
          if (this.a.y()) {
            return;
          }
          i = this.a.a();
        } while (i == this.b);
        this.d = i;
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    i = this.a.m();
    c(i);
    int j = this.a.z();
    do
    {
      paramList.add(Float.valueOf(this.a.c()));
    } while (this.a.z() < j + i);
  }
  
  public <T> void b(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (WireFormat.a(this.b) == 3)
    {
      int i = this.b;
      int j;
      do
      {
        paramList.add(d(paramSchema, paramExtensionRegistryLite));
        if (this.a.y()) {
          break;
        }
        if (this.d != 0) {
          return;
        }
        j = this.a.a();
      } while (j == i);
      this.d = j;
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
    return this.b;
  }
  
  public void c(List<Long> paramList)
  {
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.a.m();
          i = this.a.z() + i;
          do
          {
            paramList.a(this.a.d());
          } while (this.a.z() < i);
          d(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(this.a.d());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.a.m();
        i = this.a.z() + i;
        do
        {
          paramList.add(Long.valueOf(this.a.d()));
        } while (this.a.z() < i);
        d(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(this.a.d()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public void d(List<Long> paramList)
  {
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.a.m();
          i = this.a.z() + i;
          do
          {
            paramList.a(this.a.e());
          } while (this.a.z() < i);
          d(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(this.a.e());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.a.m();
        i = this.a.z() + i;
        do
        {
          paramList.add(Long.valueOf(this.a.e()));
        } while (this.a.z() < i);
        d(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(this.a.e()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public boolean d()
  {
    if (!this.a.y())
    {
      int i = this.b;
      if (i != this.c) {
        return this.a.b(i);
      }
    }
    return false;
  }
  
  public double e()
  {
    a(1);
    return this.a.b();
  }
  
  public void e(List<Integer> paramList)
  {
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.a.m();
          i = this.a.z() + i;
          do
          {
            paramList.d(this.a.f());
          } while (this.a.z() < i);
          d(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.d(this.a.f());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.a.m();
        i = this.a.z() + i;
        do
        {
          paramList.add(Integer.valueOf(this.a.f()));
        } while (this.a.z() < i);
        d(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Integer.valueOf(this.a.f()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public float f()
  {
    a(5);
    return this.a.c();
  }
  
  public void f(List<Long> paramList)
  {
    int j;
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 1)
      {
        if (i == 2)
        {
          i = this.a.m();
          b(i);
          j = this.a.z();
          do
          {
            paramList.a(this.a.g());
          } while (this.a.z() < j + i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(this.a.g());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 1)
    {
      if (i == 2)
      {
        i = this.a.m();
        b(i);
        j = this.a.z();
        do
        {
          paramList.add(Long.valueOf(this.a.g()));
        } while (this.a.z() < j + i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(this.a.g()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public long g()
  {
    a(0);
    return this.a.d();
  }
  
  public void g(List<Integer> paramList)
  {
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.d(this.a.h());
            if (this.a.y()) {
              return;
            }
            i = this.a.a();
          } while (i == this.b);
          this.d = i;
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      i = this.a.m();
      c(i);
      j = this.a.z();
      do
      {
        paramList.d(this.a.h());
      } while (this.a.z() < j + i);
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(this.a.h()));
          if (this.a.y()) {
            return;
          }
          i = this.a.a();
        } while (i == this.b);
        this.d = i;
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    i = this.a.m();
    c(i);
    int j = this.a.z();
    do
    {
      paramList.add(Integer.valueOf(this.a.h()));
    } while (this.a.z() < j + i);
  }
  
  public long h()
  {
    a(0);
    return this.a.e();
  }
  
  public void h(List<Boolean> paramList)
  {
    if ((paramList instanceof BooleanArrayList))
    {
      paramList = (BooleanArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.a.m();
          i = this.a.z() + i;
          do
          {
            paramList.a(this.a.i());
          } while (this.a.z() < i);
          d(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(this.a.i());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.a.m();
        i = this.a.z() + i;
        do
        {
          paramList.add(Boolean.valueOf(this.a.i()));
        } while (this.a.z() < i);
        d(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Boolean.valueOf(this.a.i()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public int i()
  {
    a(0);
    return this.a.f();
  }
  
  public void i(List<String> paramList)
  {
    a(paramList, false);
  }
  
  public long j()
  {
    a(1);
    return this.a.g();
  }
  
  public void j(List<String> paramList)
  {
    a(paramList, true);
  }
  
  public int k()
  {
    a(5);
    return this.a.h();
  }
  
  public void k(List<ByteString> paramList)
  {
    if (WireFormat.a(this.b) == 2)
    {
      int i;
      do
      {
        paramList.add(o());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
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
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.a.m();
          i = this.a.z() + i;
          do
          {
            paramList.d(this.a.m());
          } while (this.a.z() < i);
          d(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.d(this.a.m());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.a.m();
        i = this.a.z() + i;
        do
        {
          paramList.add(Integer.valueOf(this.a.m()));
        } while (this.a.z() < i);
        d(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Integer.valueOf(this.a.m()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public boolean l()
  {
    a(0);
    return this.a.i();
  }
  
  public String m()
  {
    a(2);
    return this.a.j();
  }
  
  public void m(List<Integer> paramList)
  {
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.a.m();
          i = this.a.z() + i;
          do
          {
            paramList.d(this.a.n());
          } while (this.a.z() < i);
          d(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.d(this.a.n());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.a.m();
        i = this.a.z() + i;
        do
        {
          paramList.add(Integer.valueOf(this.a.n()));
        } while (this.a.z() < i);
        d(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Integer.valueOf(this.a.n()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public String n()
  {
    a(2);
    return this.a.k();
  }
  
  public void n(List<Integer> paramList)
  {
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.d(this.a.o());
            if (this.a.y()) {
              return;
            }
            i = this.a.a();
          } while (i == this.b);
          this.d = i;
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      i = this.a.m();
      c(i);
      j = this.a.z();
      do
      {
        paramList.d(this.a.o());
      } while (this.a.z() < j + i);
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(this.a.o()));
          if (this.a.y()) {
            return;
          }
          i = this.a.a();
        } while (i == this.b);
        this.d = i;
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    i = this.a.m();
    c(i);
    int j = this.a.z();
    do
    {
      paramList.add(Integer.valueOf(this.a.o()));
    } while (this.a.z() < j + i);
  }
  
  public ByteString o()
  {
    a(2);
    return this.a.l();
  }
  
  public void o(List<Long> paramList)
  {
    int j;
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 1)
      {
        if (i == 2)
        {
          i = this.a.m();
          b(i);
          j = this.a.z();
          do
          {
            paramList.a(this.a.p());
          } while (this.a.z() < j + i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(this.a.p());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 1)
    {
      if (i == 2)
      {
        i = this.a.m();
        b(i);
        j = this.a.z();
        do
        {
          paramList.add(Long.valueOf(this.a.p()));
        } while (this.a.z() < j + i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(this.a.p()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public int p()
  {
    a(0);
    return this.a.m();
  }
  
  public void p(List<Integer> paramList)
  {
    if ((paramList instanceof IntArrayList))
    {
      paramList = (IntArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.a.m();
          i = this.a.z() + i;
          do
          {
            paramList.d(this.a.q());
          } while (this.a.z() < i);
          d(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.d(this.a.q());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.a.m();
        i = this.a.z() + i;
        do
        {
          paramList.add(Integer.valueOf(this.a.q()));
        } while (this.a.z() < i);
        d(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Integer.valueOf(this.a.q()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public int q()
  {
    a(0);
    return this.a.n();
  }
  
  public void q(List<Long> paramList)
  {
    if ((paramList instanceof LongArrayList))
    {
      paramList = (LongArrayList)paramList;
      i = WireFormat.a(this.b);
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.a.m();
          i = this.a.z() + i;
          do
          {
            paramList.a(this.a.r());
          } while (this.a.z() < i);
          d(i);
          return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
      }
      do
      {
        paramList.a(this.a.r());
        if (this.a.y()) {
          return;
        }
        i = this.a.a();
      } while (i == this.b);
      this.d = i;
      return;
    }
    int i = WireFormat.a(this.b);
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.a.m();
        i = this.a.z() + i;
        do
        {
          paramList.add(Long.valueOf(this.a.r()));
        } while (this.a.z() < i);
        d(i);
        return;
      }
      throw InvalidProtocolBufferException.invalidWireType();
    }
    do
    {
      paramList.add(Long.valueOf(this.a.r()));
      if (this.a.y()) {
        return;
      }
      i = this.a.a();
    } while (i == this.b);
    this.d = i;
  }
  
  public int r()
  {
    a(5);
    return this.a.o();
  }
  
  public long s()
  {
    a(1);
    return this.a.p();
  }
  
  public int t()
  {
    a(0);
    return this.a.q();
  }
  
  public long u()
  {
    a(0);
    return this.a.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedInputStreamReader
 * JD-Core Version:    0.7.0.1
 */