package com.tencent.luggage.wxa.ar;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class a$b$a
  extends GeneratedMessageV3.Builder<a>
  implements c
{
  private int a;
  private Object b = "";
  private long c;
  private Object d = "";
  private Object e = "";
  private Object f = "";
  private Object g = "";
  private Object h = "";
  private Object i = "";
  private Object j = "";
  
  private a$b$a()
  {
    f();
  }
  
  private a$b$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    a.b.y();
  }
  
  public a a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = 0L;
    this.a &= 0xFFFFFFFD;
    this.d = "";
    this.a &= 0xFFFFFFFB;
    this.e = "";
    this.a &= 0xFFFFFFF7;
    this.f = "";
    this.a &= 0xFFFFFFEF;
    this.g = "";
    this.a &= 0xFFFFFFDF;
    this.h = "";
    this.a &= 0xFFFFFFBF;
    this.i = "";
    this.a &= 0xFFFFFF7F;
    this.j = "";
    this.a &= 0xFFFFFEFF;
    return this;
  }
  
  public a a(long paramLong)
  {
    this.a |= 0x2;
    this.c = paramLong;
    onChanged();
    return this;
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 77	com/tencent/luggage/wxa/ar/a$b:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 83 3 0
    //   12: checkcast 54	com/tencent/luggage/wxa/ar/a$b
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 86	com/tencent/luggage/wxa/ar/a$b$a:a	(Lcom/tencent/luggage/wxa/ar/a$b;)Lcom/tencent/luggage/wxa/ar/a$b$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 90	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 54	com/tencent/luggage/wxa/ar/a$b
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 94	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 86	com/tencent/luggage/wxa/ar/a$b$a:a	(Lcom/tencent/luggage/wxa/ar/a$b;)Lcom/tencent/luggage/wxa/ar/a$b$a;
    //   58: pop
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	a
    //   0	61	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	61	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
    //   1	29	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   35	43	28	finally
    //   2	16	34	com/google/protobuf/InvalidProtocolBufferException
    //   43	48	48	finally
  }
  
  public a a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return (a)super.clearField(paramFieldDescriptor);
  }
  
  public a a(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject)
  {
    return (a)super.setRepeatedField(paramFieldDescriptor, paramInt, paramObject);
  }
  
  public a a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (a)super.setField(paramFieldDescriptor, paramObject);
  }
  
  public a a(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    return (a)super.clearOneof(paramOneofDescriptor);
  }
  
  public a a(Message paramMessage)
  {
    if ((paramMessage instanceof a.b)) {
      return a((a.b)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(a.b paramb)
  {
    if (paramb == a.b.w()) {
      return this;
    }
    if (paramb.b())
    {
      this.a |= 0x1;
      this.b = a.b.a(paramb);
      onChanged();
    }
    if (paramb.d()) {
      a(paramb.e());
    }
    if (paramb.f())
    {
      this.a |= 0x4;
      this.d = a.b.b(paramb);
      onChanged();
    }
    if (paramb.h())
    {
      this.a |= 0x8;
      this.e = a.b.c(paramb);
      onChanged();
    }
    if (paramb.j())
    {
      this.a |= 0x10;
      this.f = a.b.d(paramb);
      onChanged();
    }
    if (paramb.l())
    {
      this.a |= 0x20;
      this.g = a.b.e(paramb);
      onChanged();
    }
    if (paramb.n())
    {
      this.a |= 0x40;
      this.h = a.b.f(paramb);
      onChanged();
    }
    if (paramb.p())
    {
      this.a |= 0x80;
      this.i = a.b.g(paramb);
      onChanged();
    }
    if (paramb.r())
    {
      this.a |= 0x100;
      this.j = a.b.h(paramb);
      onChanged();
    }
    b(a.b.i(paramb));
    onChanged();
    return this;
  }
  
  public a b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (a)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final a b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public a.b b()
  {
    return a.b.w();
  }
  
  public a.b c()
  {
    a.b localb = d();
    if (localb.isInitialized()) {
      return localb;
    }
    throw newUninitializedMessageException(localb);
  }
  
  public a.b d()
  {
    a.b localb = new a.b(this, null);
    int n = this.a;
    if ((n & 0x1) != 0) {
      m = 1;
    } else {
      m = 0;
    }
    a.b.a(localb, this.b);
    int k = m;
    if ((n & 0x2) != 0)
    {
      a.b.a(localb, this.c);
      k = m | 0x2;
    }
    int m = k;
    if ((n & 0x4) != 0) {
      m = k | 0x4;
    }
    a.b.b(localb, this.d);
    k = m;
    if ((n & 0x8) != 0) {
      k = m | 0x8;
    }
    a.b.c(localb, this.e);
    m = k;
    if ((n & 0x10) != 0) {
      m = k | 0x10;
    }
    a.b.d(localb, this.f);
    k = m;
    if ((n & 0x20) != 0) {
      k = m | 0x20;
    }
    a.b.e(localb, this.g);
    m = k;
    if ((n & 0x40) != 0) {
      m = k | 0x40;
    }
    a.b.f(localb, this.h);
    k = m;
    if ((n & 0x80) != 0) {
      k = m | 0x80;
    }
    a.b.g(localb, this.i);
    m = k;
    if ((n & 0x100) != 0) {
      m = k | 0x100;
    }
    a.b.h(localb, this.j);
    a.b.a(localb, m);
    onBuilt();
    return localb;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return a.f();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.g().a(a.b.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ar.a.b.a
 * JD-Core Version:    0.7.0.1
 */