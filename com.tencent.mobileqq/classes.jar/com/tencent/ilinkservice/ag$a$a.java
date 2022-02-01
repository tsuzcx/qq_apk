package com.tencent.ilinkservice;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class ag$a$a
  extends GeneratedMessageV3.Builder<a>
  implements ah
{
  private int a;
  private long b;
  private Object c = "";
  private Object d = "";
  private Object e = "";
  private int f;
  private Object g = "";
  private Object h = "";
  private long i;
  private long j;
  private long k;
  
  private ag$a$a()
  {
    f();
  }
  
  private ag$a$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    ag.a.A();
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
    this.e = "";
    this.a &= 0xFFFFFFF7;
    this.f = 0;
    this.a &= 0xFFFFFFEF;
    this.g = "";
    this.a &= 0xFFFFFFDF;
    this.h = "";
    this.a &= 0xFFFFFFBF;
    this.i = 0L;
    this.a &= 0xFFFFFF7F;
    this.j = 0L;
    this.a &= 0xFFFFFEFF;
    this.k = 0L;
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
    //   2: getstatic 81	com/tencent/ilinkservice/ag$a:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 87 3 0
    //   12: checkcast 49	com/tencent/ilinkservice/ag$a
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 90	com/tencent/ilinkservice/ag$a$a:a	(Lcom/tencent/ilinkservice/ag$a;)Lcom/tencent/ilinkservice/ag$a$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 94	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 49	com/tencent/ilinkservice/ag$a
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 90	com/tencent/ilinkservice/ag$a$a:a	(Lcom/tencent/ilinkservice/ag$a;)Lcom/tencent/ilinkservice/ag$a$a;
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
    if ((paramMessage instanceof ag.a)) {
      return a((ag.a)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(ag.a parama)
  {
    if (parama == ag.a.y()) {
      return this;
    }
    if (parama.b()) {
      a(parama.c());
    }
    if (parama.d())
    {
      this.a |= 0x2;
      this.c = ag.a.a(parama);
      onChanged();
    }
    if (parama.f())
    {
      this.a |= 0x4;
      this.d = ag.a.b(parama);
      onChanged();
    }
    if (parama.h())
    {
      this.a |= 0x8;
      this.e = ag.a.c(parama);
      onChanged();
    }
    if (parama.j()) {
      a(parama.k());
    }
    if (parama.l())
    {
      this.a |= 0x20;
      this.g = ag.a.d(parama);
      onChanged();
    }
    if (parama.n())
    {
      this.a |= 0x40;
      this.h = ag.a.e(parama);
      onChanged();
    }
    if (parama.p()) {
      b(parama.q());
    }
    if (parama.r()) {
      c(parama.s());
    }
    if (parama.t()) {
      d(parama.u());
    }
    b(ag.a.f(parama));
    onChanged();
    return this;
  }
  
  public a b(long paramLong)
  {
    this.a |= 0x80;
    this.i = paramLong;
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
  
  public ag.a b()
  {
    return ag.a.y();
  }
  
  public a c(long paramLong)
  {
    this.a |= 0x100;
    this.j = paramLong;
    onChanged();
    return this;
  }
  
  public ag.a c()
  {
    ag.a locala = d();
    if (locala.isInitialized()) {
      return locala;
    }
    throw newUninitializedMessageException(locala);
  }
  
  public a d(long paramLong)
  {
    this.a |= 0x200;
    this.k = paramLong;
    onChanged();
    return this;
  }
  
  public ag.a d()
  {
    ag.a locala = new ag.a(this, null);
    int i1 = this.a;
    if ((i1 & 0x1) != 0)
    {
      ag.a.a(locala, this.b);
      n = 1;
    }
    else
    {
      n = 0;
    }
    int m = n;
    if ((i1 & 0x2) != 0) {
      m = n | 0x2;
    }
    ag.a.a(locala, this.c);
    int n = m;
    if ((i1 & 0x4) != 0) {
      n = m | 0x4;
    }
    ag.a.b(locala, this.d);
    m = n;
    if ((i1 & 0x8) != 0) {
      m = n | 0x8;
    }
    ag.a.c(locala, this.e);
    n = m;
    if ((i1 & 0x10) != 0)
    {
      ag.a.a(locala, this.f);
      n = m | 0x10;
    }
    m = n;
    if ((i1 & 0x20) != 0) {
      m = n | 0x20;
    }
    ag.a.d(locala, this.g);
    n = m;
    if ((i1 & 0x40) != 0) {
      n = m | 0x40;
    }
    ag.a.e(locala, this.h);
    m = n;
    if ((i1 & 0x80) != 0)
    {
      ag.a.b(locala, this.i);
      m = n | 0x80;
    }
    n = m;
    if ((i1 & 0x100) != 0)
    {
      ag.a.c(locala, this.j);
      n = m | 0x100;
    }
    m = n;
    if ((i1 & 0x200) != 0)
    {
      ag.a.d(locala, this.k);
      m = n | 0x200;
    }
    ag.a.b(locala, m);
    onBuilt();
    return locala;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return ag.f();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.g().a(ag.a.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.a.a
 * JD-Core Version:    0.7.0.1
 */