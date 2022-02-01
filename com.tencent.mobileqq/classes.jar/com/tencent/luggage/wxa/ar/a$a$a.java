package com.tencent.luggage.wxa.ar;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class a$a$a
  extends GeneratedMessageV3.Builder<a>
  implements b
{
  private int a;
  private long b;
  private Object c = "";
  private Object d = "";
  private int e;
  private Object f = "";
  private Object g = "";
  private Object h = "";
  private int i;
  private Object j = "";
  private Object k = "";
  private Object l = "";
  private Object m = "";
  private Object n = "";
  private int o;
  private int p;
  
  private a$a$a()
  {
    g();
  }
  
  private a$a$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    g();
  }
  
  private void g()
  {
    a.a.K();
  }
  
  public a a()
  {
    super.clear();
    this.b = 0L;
    this.a &= 0xFFFFFFFE;
    this.c = "";
    this.a &= 0xFFFFFFFD;
    this.d = "";
    this.a &= 0xFFFFFFFB;
    this.e = 0;
    this.a &= 0xFFFFFFF7;
    this.f = "";
    this.a &= 0xFFFFFFEF;
    this.g = "";
    this.a &= 0xFFFFFFDF;
    this.h = "";
    this.a &= 0xFFFFFFBF;
    this.i = 0;
    this.a &= 0xFFFFFF7F;
    this.j = "";
    this.a &= 0xFFFFFEFF;
    this.k = "";
    this.a &= 0xFFFFFDFF;
    this.l = "";
    this.a &= 0xFFFFFBFF;
    this.m = "";
    this.a &= 0xFFFFF7FF;
    this.n = "";
    this.a &= 0xFFFFEFFF;
    this.o = 0;
    this.a &= 0xFFFFDFFF;
    this.p = 0;
    this.a &= 0xFFFFBFFF;
    return this;
  }
  
  public a a(int paramInt)
  {
    this.a |= 0x8;
    this.e = paramInt;
    onChanged();
    return this;
  }
  
  public a a(long paramLong)
  {
    this.a |= 0x1;
    this.b = paramLong;
    onChanged();
    return this;
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 96	com/tencent/luggage/wxa/ar/a$a:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 102 3 0
    //   12: checkcast 64	com/tencent/luggage/wxa/ar/a$a
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 105	com/tencent/luggage/wxa/ar/a$a$a:a	(Lcom/tencent/luggage/wxa/ar/a$a;)Lcom/tencent/luggage/wxa/ar/a$a$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 109	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 64	com/tencent/luggage/wxa/ar/a$a
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 113	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 105	com/tencent/luggage/wxa/ar/a$a$a:a	(Lcom/tencent/luggage/wxa/ar/a$a;)Lcom/tencent/luggage/wxa/ar/a$a$a;
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
    if ((paramMessage instanceof a.a)) {
      return a((a.a)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(a.a parama)
  {
    if (parama == a.a.I()) {
      return this;
    }
    if (parama.b()) {
      a(parama.c());
    }
    if (parama.d())
    {
      this.a |= 0x2;
      this.c = a.a.a(parama);
      onChanged();
    }
    if (parama.f())
    {
      this.a |= 0x4;
      this.d = a.a.b(parama);
      onChanged();
    }
    if (parama.h()) {
      a(parama.i());
    }
    if (parama.j())
    {
      this.a |= 0x10;
      this.f = a.a.c(parama);
      onChanged();
    }
    if (parama.l())
    {
      this.a |= 0x20;
      this.g = a.a.d(parama);
      onChanged();
    }
    if (parama.n())
    {
      this.a |= 0x40;
      this.h = a.a.e(parama);
      onChanged();
    }
    if (parama.p()) {
      b(parama.q());
    }
    if (parama.r())
    {
      this.a |= 0x100;
      this.j = a.a.f(parama);
      onChanged();
    }
    if (parama.t())
    {
      this.a |= 0x200;
      this.k = a.a.g(parama);
      onChanged();
    }
    if (parama.v())
    {
      this.a |= 0x400;
      this.l = a.a.h(parama);
      onChanged();
    }
    if (parama.x())
    {
      this.a |= 0x800;
      this.m = a.a.i(parama);
      onChanged();
    }
    if (parama.z())
    {
      this.a |= 0x1000;
      this.n = a.a.j(parama);
      onChanged();
    }
    if (parama.B()) {
      c(parama.C());
    }
    if (parama.D()) {
      d(parama.E());
    }
    b(a.a.k(parama));
    onChanged();
    return this;
  }
  
  public a b(int paramInt)
  {
    this.a |= 0x80;
    this.i = paramInt;
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
  
  public a.a b()
  {
    return a.a.I();
  }
  
  public a c(int paramInt)
  {
    this.a |= 0x2000;
    this.o = paramInt;
    onChanged();
    return this;
  }
  
  public a.a c()
  {
    a.a locala = d();
    if (locala.isInitialized()) {
      return locala;
    }
    throw newUninitializedMessageException(locala);
  }
  
  public a d(int paramInt)
  {
    this.a |= 0x4000;
    this.p = paramInt;
    onChanged();
    return this;
  }
  
  public a.a d()
  {
    a.a locala = new a.a(this, null);
    int i3 = this.a;
    if ((i3 & 0x1) != 0)
    {
      a.a.a(locala, this.b);
      i2 = 1;
    }
    else
    {
      i2 = 0;
    }
    int i1 = i2;
    if ((i3 & 0x2) != 0) {
      i1 = i2 | 0x2;
    }
    a.a.a(locala, this.c);
    int i2 = i1;
    if ((i3 & 0x4) != 0) {
      i2 = i1 | 0x4;
    }
    a.a.b(locala, this.d);
    i1 = i2;
    if ((i3 & 0x8) != 0)
    {
      a.a.a(locala, this.e);
      i1 = i2 | 0x8;
    }
    i2 = i1;
    if ((i3 & 0x10) != 0) {
      i2 = i1 | 0x10;
    }
    a.a.c(locala, this.f);
    i1 = i2;
    if ((i3 & 0x20) != 0) {
      i1 = i2 | 0x20;
    }
    a.a.d(locala, this.g);
    i2 = i1;
    if ((i3 & 0x40) != 0) {
      i2 = i1 | 0x40;
    }
    a.a.e(locala, this.h);
    i1 = i2;
    if ((i3 & 0x80) != 0)
    {
      a.a.b(locala, this.i);
      i1 = i2 | 0x80;
    }
    i2 = i1;
    if ((i3 & 0x100) != 0) {
      i2 = i1 | 0x100;
    }
    a.a.f(locala, this.j);
    i1 = i2;
    if ((i3 & 0x200) != 0) {
      i1 = i2 | 0x200;
    }
    a.a.g(locala, this.k);
    i2 = i1;
    if ((i3 & 0x400) != 0) {
      i2 = i1 | 0x400;
    }
    a.a.h(locala, this.l);
    i1 = i2;
    if ((i3 & 0x800) != 0) {
      i1 = i2 | 0x800;
    }
    a.a.i(locala, this.m);
    i2 = i1;
    if ((i3 & 0x1000) != 0) {
      i2 = i1 | 0x1000;
    }
    a.a.j(locala, this.n);
    i1 = i2;
    if ((i3 & 0x2000) != 0)
    {
      a.a.c(locala, this.o);
      i1 = i2 | 0x2000;
    }
    i2 = i1;
    if ((i3 & 0x4000) != 0)
    {
      a.a.d(locala, this.p);
      i2 = i1 | 0x4000;
    }
    a.a.e(locala, i2);
    onBuilt();
    return locala;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public boolean f()
  {
    return (this.a & 0x2) != 0;
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return a.b();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.c().a(a.a.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ar.a.a.a
 * JD-Core Version:    0.7.0.1
 */