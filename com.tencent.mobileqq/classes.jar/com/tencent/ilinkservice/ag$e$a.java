package com.tencent.ilinkservice;

import com.google.protobuf.AbstractMessageLite.Builder;
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

public final class ag$e$a
  extends GeneratedMessageV3.Builder<a>
  implements al
{
  private int a;
  private Object b = "";
  private LazyStringList c = LazyStringArrayList.a;
  private boolean d;
  private Object e = "";
  private Object f = "";
  private long g;
  private Object h = "";
  private Object i = "";
  private int j;
  private int k;
  
  private ag$e$a()
  {
    f();
  }
  
  private ag$e$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    ag.e.A();
  }
  
  private void g()
  {
    if ((this.a & 0x2) == 0)
    {
      this.c = new LazyStringArrayList(this.c);
      this.a |= 0x2;
    }
  }
  
  public a a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = LazyStringArrayList.a;
    this.a &= 0xFFFFFFFD;
    this.d = false;
    this.a &= 0xFFFFFFFB;
    this.e = "";
    this.a &= 0xFFFFFFF7;
    this.f = "";
    this.a &= 0xFFFFFFEF;
    this.g = 0L;
    this.a &= 0xFFFFFFDF;
    this.h = "";
    this.a &= 0xFFFFFFBF;
    this.i = "";
    this.a &= 0xFFFFFF7F;
    this.j = 0;
    this.a &= 0xFFFFFEFF;
    this.k = 0;
    this.a &= 0xFFFFFDFF;
    return this;
  }
  
  public a a(int paramInt)
  {
    this.a |= 0x100;
    this.j = paramInt;
    onChanged();
    return this;
  }
  
  public a a(long paramLong)
  {
    this.a |= 0x20;
    this.g = paramLong;
    onChanged();
    return this;
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 90	com/tencent/ilinkservice/ag$e:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 96 3 0
    //   12: checkcast 57	com/tencent/ilinkservice/ag$e
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 99	com/tencent/ilinkservice/ag$e$a:a	(Lcom/tencent/ilinkservice/ag$e;)Lcom/tencent/ilinkservice/ag$e$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 103	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 57	com/tencent/ilinkservice/ag$e
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 107	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 99	com/tencent/ilinkservice/ag$e$a:a	(Lcom/tencent/ilinkservice/ag$e;)Lcom/tencent/ilinkservice/ag$e$a;
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
    if ((paramMessage instanceof ag.e)) {
      return a((ag.e)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(ag.e parame)
  {
    if (parame == ag.e.y()) {
      return this;
    }
    if (parame.b())
    {
      this.a |= 0x1;
      this.b = ag.e.a(parame);
      onChanged();
    }
    if (!ag.e.b(parame).isEmpty())
    {
      if (this.c.isEmpty())
      {
        this.c = ag.e.b(parame);
        this.a &= 0xFFFFFFFD;
      }
      else
      {
        g();
        this.c.addAll(ag.e.b(parame));
      }
      onChanged();
    }
    if (parame.f()) {
      a(parame.g());
    }
    if (parame.h())
    {
      this.a |= 0x8;
      this.e = ag.e.c(parame);
      onChanged();
    }
    if (parame.j())
    {
      this.a |= 0x10;
      this.f = ag.e.d(parame);
      onChanged();
    }
    if (parame.l()) {
      a(parame.m());
    }
    if (parame.n())
    {
      this.a |= 0x40;
      this.h = ag.e.e(parame);
      onChanged();
    }
    if (parame.p())
    {
      this.a |= 0x80;
      this.i = ag.e.f(parame);
      onChanged();
    }
    if (parame.r()) {
      a(parame.s());
    }
    if (parame.t()) {
      b(parame.u());
    }
    b(ag.e.g(parame));
    onChanged();
    return this;
  }
  
  public a a(Iterable<String> paramIterable)
  {
    g();
    AbstractMessageLite.Builder.addAll(paramIterable, this.c);
    onChanged();
    return this;
  }
  
  public a a(String paramString)
  {
    if (paramString != null)
    {
      this.a |= 0x1;
      this.b = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(boolean paramBoolean)
  {
    this.a |= 0x4;
    this.d = paramBoolean;
    onChanged();
    return this;
  }
  
  public a b(int paramInt)
  {
    this.a |= 0x200;
    this.k = paramInt;
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
      this.a |= 0x8;
      this.e = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public ag.e b()
  {
    return ag.e.y();
  }
  
  public a c(String paramString)
  {
    if (paramString != null)
    {
      this.a |= 0x10;
      this.f = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public ag.e c()
  {
    ag.e locale = d();
    if (locale.isInitialized()) {
      return locale;
    }
    throw newUninitializedMessageException(locale);
  }
  
  public a d(String paramString)
  {
    if (paramString != null)
    {
      this.a |= 0x40;
      this.h = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public ag.e d()
  {
    ag.e locale = new ag.e(this, null);
    int i1 = this.a;
    if ((i1 & 0x1) != 0) {
      n = 1;
    } else {
      n = 0;
    }
    ag.e.a(locale, this.b);
    if ((this.a & 0x2) != 0)
    {
      this.c = this.c.e();
      this.a &= 0xFFFFFFFD;
    }
    ag.e.a(locale, this.c);
    int m = n;
    if ((i1 & 0x4) != 0)
    {
      ag.e.a(locale, this.d);
      m = n | 0x2;
    }
    int n = m;
    if ((i1 & 0x8) != 0) {
      n = m | 0x4;
    }
    ag.e.b(locale, this.e);
    m = n;
    if ((i1 & 0x10) != 0) {
      m = n | 0x8;
    }
    ag.e.c(locale, this.f);
    n = m;
    if ((i1 & 0x20) != 0)
    {
      ag.e.a(locale, this.g);
      n = m | 0x10;
    }
    m = n;
    if ((i1 & 0x40) != 0) {
      m = n | 0x20;
    }
    ag.e.d(locale, this.h);
    n = m;
    if ((i1 & 0x80) != 0) {
      n = m | 0x40;
    }
    ag.e.e(locale, this.i);
    m = n;
    if ((i1 & 0x100) != 0)
    {
      ag.e.a(locale, this.j);
      m = n | 0x80;
    }
    n = m;
    if ((i1 & 0x200) != 0)
    {
      ag.e.b(locale, this.k);
      n = m | 0x100;
    }
    ag.e.c(locale, n);
    onBuilt();
    return locale;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return ag.l();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.m().a(ag.e.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.e.a
 * JD-Core Version:    0.7.0.1
 */