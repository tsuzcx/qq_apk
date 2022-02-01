package com.tencent.ilinkservice;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class ag$f$a
  extends GeneratedMessageV3.Builder<a>
  implements am
{
  private int a;
  private int b;
  private Object c = "";
  private Object d = "";
  private int e;
  private int f;
  private int g;
  private int h;
  private Object i = "";
  private Object j = "";
  private int k;
  
  private ag$f$a()
  {
    j();
  }
  
  private ag$f$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    j();
  }
  
  private void j()
  {
    ag.f.A();
  }
  
  public a a()
  {
    super.clear();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = "";
    this.a &= 0xFFFFFFFD;
    this.d = "";
    this.a &= 0xFFFFFFFB;
    this.e = 0;
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
    this.k = 0;
    this.a &= 0xFFFFFDFF;
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
    //   2: getstatic 79	com/tencent/ilinkservice/ag$f:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 85 3 0
    //   12: checkcast 46	com/tencent/ilinkservice/ag$f
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 88	com/tencent/ilinkservice/ag$f$a:a	(Lcom/tencent/ilinkservice/ag$f;)Lcom/tencent/ilinkservice/ag$f$a;
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
    //   39: checkcast 46	com/tencent/ilinkservice/ag$f
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 96	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 88	com/tencent/ilinkservice/ag$f$a:a	(Lcom/tencent/ilinkservice/ag$f;)Lcom/tencent/ilinkservice/ag$f$a;
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
    if ((paramMessage instanceof ag.f)) {
      return a((ag.f)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(ag.f paramf)
  {
    if (paramf == ag.f.y()) {
      return this;
    }
    if (paramf.b()) {
      a(paramf.c());
    }
    if (paramf.d())
    {
      this.a |= 0x2;
      this.c = ag.f.b(paramf);
      onChanged();
    }
    if (paramf.f())
    {
      this.a |= 0x4;
      this.d = ag.f.c(paramf);
      onChanged();
    }
    if (paramf.h()) {
      b(paramf.i());
    }
    if (paramf.j()) {
      c(paramf.k());
    }
    if (paramf.l()) {
      d(paramf.m());
    }
    if (paramf.n()) {
      e(paramf.o());
    }
    if (paramf.p())
    {
      this.a |= 0x80;
      this.i = ag.f.d(paramf);
      onChanged();
    }
    if (paramf.r())
    {
      this.a |= 0x100;
      this.j = ag.f.e(paramf);
      onChanged();
    }
    if (paramf.t()) {
      f(paramf.u());
    }
    b(ag.f.f(paramf));
    onChanged();
    return this;
  }
  
  public a a(String paramString)
  {
    if (paramString != null)
    {
      this.a |= 0x2;
      this.c = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a b(int paramInt)
  {
    this.a |= 0x8;
    this.e = paramInt;
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
  
  public a b(String paramString)
  {
    if (paramString != null)
    {
      this.a |= 0x4;
      this.d = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public ag.f b()
  {
    return ag.f.y();
  }
  
  public a c(int paramInt)
  {
    this.a |= 0x10;
    this.f = paramInt;
    onChanged();
    return this;
  }
  
  public a c(String paramString)
  {
    if (paramString != null)
    {
      this.a |= 0x100;
      this.j = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public ag.f c()
  {
    ag.f localf = d();
    if (localf.isInitialized()) {
      return localf;
    }
    throw newUninitializedMessageException(localf);
  }
  
  public a d(int paramInt)
  {
    this.a |= 0x20;
    this.g = paramInt;
    onChanged();
    return this;
  }
  
  public ag.f d()
  {
    ag.f localf = new ag.f(this, null);
    int i1 = this.a;
    if ((i1 & 0x1) != 0)
    {
      ag.f.a(localf, this.b);
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
    ag.f.a(localf, this.c);
    int n = m;
    if ((i1 & 0x4) != 0) {
      n = m | 0x4;
    }
    ag.f.b(localf, this.d);
    m = n;
    if ((i1 & 0x8) != 0)
    {
      ag.f.b(localf, this.e);
      m = n | 0x8;
    }
    n = m;
    if ((i1 & 0x10) != 0)
    {
      ag.f.c(localf, this.f);
      n = m | 0x10;
    }
    m = n;
    if ((i1 & 0x20) != 0)
    {
      ag.f.d(localf, this.g);
      m = n | 0x20;
    }
    n = m;
    if ((i1 & 0x40) != 0)
    {
      ag.f.e(localf, this.h);
      n = m | 0x40;
    }
    m = n;
    if ((i1 & 0x80) != 0) {
      m = n | 0x80;
    }
    ag.f.c(localf, this.i);
    n = m;
    if ((i1 & 0x100) != 0) {
      n = m | 0x100;
    }
    ag.f.d(localf, this.j);
    m = n;
    if ((i1 & 0x200) != 0)
    {
      ag.f.f(localf, this.k);
      m = n | 0x200;
    }
    ag.f.g(localf, m);
    onBuilt();
    return localf;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public a e(int paramInt)
  {
    this.a |= 0x40;
    this.h = paramInt;
    onChanged();
    return this;
  }
  
  public a f(int paramInt)
  {
    this.a |= 0x200;
    this.k = paramInt;
    onChanged();
    return this;
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
    return ag.b();
  }
  
  public boolean h()
  {
    return (this.a & 0x4) != 0;
  }
  
  public boolean i()
  {
    return (this.a & 0x8) != 0;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.c().a(ag.f.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    if (!f()) {
      return false;
    }
    if (!g()) {
      return false;
    }
    if (!h()) {
      return false;
    }
    return i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.f.a
 * JD-Core Version:    0.7.0.1
 */