package com.tencent.luggage.wxa.ar;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class a$c$a
  extends GeneratedMessageV3.Builder<a>
  implements d
{
  private int a;
  private Object b = "";
  private Object c = "";
  private Object d = "";
  private Object e = "";
  private int f;
  private int g;
  private int h;
  private Object i = "";
  private Object j = "";
  private Object k = "";
  
  private a$c$a()
  {
    h();
  }
  
  private a$c$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    h();
  }
  
  private void h()
  {
    a.c.A();
  }
  
  public a a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = "";
    this.a &= 0xFFFFFFFD;
    this.d = "";
    this.a &= 0xFFFFFFFB;
    this.e = "";
    this.a &= 0xFFFFFFF7;
    this.f = 0;
    this.a &= 0xFFFFFFEF;
    this.g = 0;
    this.a &= 0xFFFFFFDF;
    this.h = 0;
    this.a &= 0xFFFFFFBF;
    this.i = "";
    this.a &= 0xFFFFFF7F;
    this.j = "";
    this.a &= 0xFFFFFEFF;
    this.k = "";
    this.a &= 0xFFFFFDFF;
    return this;
  }
  
  public a a(int paramInt)
  {
    this.a |= 0x10;
    this.f = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 79	com/tencent/luggage/wxa/ar/a$c:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 85 3 0
    //   12: checkcast 52	com/tencent/luggage/wxa/ar/a$c
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 88	com/tencent/luggage/wxa/ar/a$c$a:a	(Lcom/tencent/luggage/wxa/ar/a$c;)Lcom/tencent/luggage/wxa/ar/a$c$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 92	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 52	com/tencent/luggage/wxa/ar/a$c
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 96	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 88	com/tencent/luggage/wxa/ar/a$c$a:a	(Lcom/tencent/luggage/wxa/ar/a$c;)Lcom/tencent/luggage/wxa/ar/a$c$a;
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
    if ((paramMessage instanceof a.c)) {
      return a((a.c)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(a.c paramc)
  {
    if (paramc == a.c.y()) {
      return this;
    }
    if (paramc.b())
    {
      this.a |= 0x1;
      this.b = a.c.a(paramc);
      onChanged();
    }
    if (paramc.d())
    {
      this.a |= 0x2;
      this.c = a.c.b(paramc);
      onChanged();
    }
    if (paramc.f())
    {
      this.a |= 0x4;
      this.d = a.c.c(paramc);
      onChanged();
    }
    if (paramc.h())
    {
      this.a |= 0x8;
      this.e = a.c.d(paramc);
      onChanged();
    }
    if (paramc.j()) {
      a(paramc.k());
    }
    if (paramc.l()) {
      b(paramc.m());
    }
    if (paramc.n()) {
      c(paramc.o());
    }
    if (paramc.p())
    {
      this.a |= 0x80;
      this.i = a.c.e(paramc);
      onChanged();
    }
    if (paramc.r())
    {
      this.a |= 0x100;
      this.j = a.c.f(paramc);
      onChanged();
    }
    if (paramc.t())
    {
      this.a |= 0x200;
      this.k = a.c.g(paramc);
      onChanged();
    }
    b(a.c.h(paramc));
    onChanged();
    return this;
  }
  
  public a b(int paramInt)
  {
    this.a |= 0x20;
    this.g = paramInt;
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
  
  public a.c b()
  {
    return a.c.y();
  }
  
  public a c(int paramInt)
  {
    this.a |= 0x40;
    this.h = paramInt;
    onChanged();
    return this;
  }
  
  public a.c c()
  {
    a.c localc = d();
    if (localc.isInitialized()) {
      return localc;
    }
    throw newUninitializedMessageException(localc);
  }
  
  public a.c d()
  {
    a.c localc = new a.c(this, null);
    int i1 = this.a;
    if ((i1 & 0x1) != 0) {
      n = 1;
    } else {
      n = 0;
    }
    a.c.a(localc, this.b);
    int m = n;
    if ((i1 & 0x2) != 0) {
      m = n | 0x2;
    }
    a.c.b(localc, this.c);
    int n = m;
    if ((i1 & 0x4) != 0) {
      n = m | 0x4;
    }
    a.c.c(localc, this.d);
    m = n;
    if ((i1 & 0x8) != 0) {
      m = n | 0x8;
    }
    a.c.d(localc, this.e);
    n = m;
    if ((i1 & 0x10) != 0)
    {
      a.c.a(localc, this.f);
      n = m | 0x10;
    }
    m = n;
    if ((i1 & 0x20) != 0)
    {
      a.c.b(localc, this.g);
      m = n | 0x20;
    }
    n = m;
    if ((i1 & 0x40) != 0)
    {
      a.c.c(localc, this.h);
      n = m | 0x40;
    }
    m = n;
    if ((i1 & 0x80) != 0) {
      m = n | 0x80;
    }
    a.c.e(localc, this.i);
    n = m;
    if ((i1 & 0x100) != 0) {
      n = m | 0x100;
    }
    a.c.f(localc, this.j);
    m = n;
    if ((i1 & 0x200) != 0) {
      m = n | 0x200;
    }
    a.c.g(localc, this.k);
    a.c.d(localc, m);
    onBuilt();
    return localc;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public boolean f()
  {
    return (this.a & 0x1) != 0;
  }
  
  public boolean g()
  {
    return (this.a & 0x2) != 0;
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return a.d();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.e().a(a.c.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    if (!f()) {
      return false;
    }
    return g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ar.a.c.a
 * JD-Core Version:    0.7.0.1
 */