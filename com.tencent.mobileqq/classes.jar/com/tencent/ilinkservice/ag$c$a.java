package com.tencent.ilinkservice;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class ag$c$a
  extends GeneratedMessageV3.Builder<a>
  implements aj
{
  private int a;
  private int b;
  private int c;
  private Object d = "";
  private int e;
  private LazyStringList f = LazyStringArrayList.a;
  private boolean g;
  private Object h = "";
  private Object i = "";
  private LazyStringList j = LazyStringArrayList.a;
  
  private ag$c$a()
  {
    f();
  }
  
  private ag$c$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    ag.c.y();
  }
  
  private void g()
  {
    if ((this.a & 0x10) == 0)
    {
      this.f = new LazyStringArrayList(this.f);
      this.a |= 0x10;
    }
  }
  
  private void h()
  {
    if ((this.a & 0x100) == 0)
    {
      this.j = new LazyStringArrayList(this.j);
      this.a |= 0x100;
    }
  }
  
  public a a()
  {
    super.clear();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    this.d = "";
    this.a &= 0xFFFFFFFB;
    this.e = 0;
    this.a &= 0xFFFFFFF7;
    this.f = LazyStringArrayList.a;
    this.a &= 0xFFFFFFEF;
    this.g = false;
    this.a &= 0xFFFFFFDF;
    this.h = "";
    this.a &= 0xFFFFFFBF;
    this.i = "";
    this.a &= 0xFFFFFF7F;
    this.j = LazyStringArrayList.a;
    this.a &= 0xFFFFFEFF;
    return this;
  }
  
  public a a(int paramInt)
  {
    this.a |= 0x1;
    this.b = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 85	com/tencent/ilinkservice/ag$c:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 91 3 0
    //   12: checkcast 53	com/tencent/ilinkservice/ag$c
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 94	com/tencent/ilinkservice/ag$c$a:a	(Lcom/tencent/ilinkservice/ag$c;)Lcom/tencent/ilinkservice/ag$c$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 53	com/tencent/ilinkservice/ag$c
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 102	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 94	com/tencent/ilinkservice/ag$c$a:a	(Lcom/tencent/ilinkservice/ag$c;)Lcom/tencent/ilinkservice/ag$c$a;
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
    if ((paramMessage instanceof ag.c)) {
      return a((ag.c)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(ag.c paramc)
  {
    if (paramc == ag.c.w()) {
      return this;
    }
    if (paramc.b()) {
      a(paramc.c());
    }
    if (paramc.d()) {
      b(paramc.e());
    }
    if (paramc.f())
    {
      this.a |= 0x4;
      this.d = ag.c.a(paramc);
      onChanged();
    }
    if (paramc.h()) {
      c(paramc.i());
    }
    if (!ag.c.b(paramc).isEmpty())
    {
      if (this.f.isEmpty())
      {
        this.f = ag.c.b(paramc);
        this.a &= 0xFFFFFFEF;
      }
      else
      {
        g();
        this.f.addAll(ag.c.b(paramc));
      }
      onChanged();
    }
    if (paramc.l()) {
      a(paramc.m());
    }
    if (paramc.n())
    {
      this.a |= 0x40;
      this.h = ag.c.c(paramc);
      onChanged();
    }
    if (paramc.p())
    {
      this.a |= 0x80;
      this.i = ag.c.d(paramc);
      onChanged();
    }
    if (!ag.c.e(paramc).isEmpty())
    {
      if (this.j.isEmpty())
      {
        this.j = ag.c.e(paramc);
        this.a &= 0xFFFFFEFF;
      }
      else
      {
        h();
        this.j.addAll(ag.c.e(paramc));
      }
      onChanged();
    }
    b(ag.c.f(paramc));
    onChanged();
    return this;
  }
  
  public a a(boolean paramBoolean)
  {
    this.a |= 0x20;
    this.g = paramBoolean;
    onChanged();
    return this;
  }
  
  public a b(int paramInt)
  {
    this.a |= 0x2;
    this.c = paramInt;
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
  
  public ag.c b()
  {
    return ag.c.w();
  }
  
  public a c(int paramInt)
  {
    this.a |= 0x8;
    this.e = paramInt;
    onChanged();
    return this;
  }
  
  public ag.c c()
  {
    ag.c localc = d();
    if (localc.isInitialized()) {
      return localc;
    }
    throw newUninitializedMessageException(localc);
  }
  
  public ag.c d()
  {
    ag.c localc = new ag.c(this, null);
    int n = this.a;
    if ((n & 0x1) != 0)
    {
      ag.c.a(localc, this.b);
      m = 1;
    }
    else
    {
      m = 0;
    }
    int k = m;
    if ((n & 0x2) != 0)
    {
      ag.c.b(localc, this.c);
      k = m | 0x2;
    }
    int m = k;
    if ((n & 0x4) != 0) {
      m = k | 0x4;
    }
    ag.c.a(localc, this.d);
    k = m;
    if ((n & 0x8) != 0)
    {
      ag.c.c(localc, this.e);
      k = m | 0x8;
    }
    if ((this.a & 0x10) != 0)
    {
      this.f = this.f.e();
      this.a &= 0xFFFFFFEF;
    }
    ag.c.a(localc, this.f);
    m = k;
    if ((n & 0x20) != 0)
    {
      ag.c.a(localc, this.g);
      m = k | 0x10;
    }
    k = m;
    if ((n & 0x40) != 0) {
      k = m | 0x20;
    }
    ag.c.b(localc, this.h);
    m = k;
    if ((n & 0x80) != 0) {
      m = k | 0x40;
    }
    ag.c.c(localc, this.i);
    if ((this.a & 0x100) != 0)
    {
      this.j = this.j.e();
      this.a &= 0xFFFFFEFF;
    }
    ag.c.b(localc, this.j);
    ag.c.d(localc, m);
    onBuilt();
    return localc;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return ag.j();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.k().a(ag.c.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.c.a
 * JD-Core Version:    0.7.0.1
 */