package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;

public final class b$s$a
  extends GeneratedMessageV3.Builder<a>
  implements s
{
  private int a;
  private Object b = "";
  private int c;
  private Object d = "";
  private Object e = "";
  private Object f = "";
  private b.t g;
  private SingleFieldBuilderV3<b.t, b.t.a, t> h;
  private Object i = "";
  
  private b$s$a()
  {
    g();
  }
  
  private b$s$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    g();
  }
  
  private void g()
  {
    if (b.s.u()) {
      h();
    }
  }
  
  private SingleFieldBuilderV3<b.t, b.t.a, t> h()
  {
    if (this.h == null)
    {
      this.h = new SingleFieldBuilderV3(f(), getParentForChildren(), isClean());
      this.g = null;
    }
    return this.h;
  }
  
  public a a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    this.d = "";
    this.a &= 0xFFFFFFFB;
    this.e = "";
    this.a &= 0xFFFFFFF7;
    this.f = "";
    this.a &= 0xFFFFFFEF;
    SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.h;
    if (localSingleFieldBuilderV3 == null) {
      this.g = null;
    } else {
      localSingleFieldBuilderV3.g();
    }
    this.a &= 0xFFFFFFDF;
    this.i = "";
    this.a &= 0xFFFFFFBF;
    return this;
  }
  
  public a a(int paramInt)
  {
    this.a |= 0x2;
    this.c = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 98	com/tencent/ilink/tdi/b$s:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 104 3 0
    //   12: checkcast 49	com/tencent/ilink/tdi/b$s
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 107	com/tencent/ilink/tdi/b$s$a:a	(Lcom/tencent/ilink/tdi/b$s;)Lcom/tencent/ilink/tdi/b$s$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 111	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 49	com/tencent/ilink/tdi/b$s
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 115	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 107	com/tencent/ilink/tdi/b$s$a:a	(Lcom/tencent/ilink/tdi/b$s;)Lcom/tencent/ilink/tdi/b$s$a;
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
    if ((paramMessage instanceof b.s)) {
      return a((b.s)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(b.s params)
  {
    if (params == b.s.s()) {
      return this;
    }
    if (params.b())
    {
      this.a |= 0x1;
      this.b = b.s.a(params);
      onChanged();
    }
    if (params.d()) {
      a(params.e());
    }
    if (params.f())
    {
      this.a |= 0x4;
      this.d = b.s.b(params);
      onChanged();
    }
    if (params.h())
    {
      this.a |= 0x8;
      this.e = b.s.c(params);
      onChanged();
    }
    if (params.j())
    {
      this.a |= 0x10;
      this.f = b.s.d(params);
      onChanged();
    }
    if (params.l()) {
      a(params.m());
    }
    if (params.n())
    {
      this.a |= 0x40;
      this.i = b.s.e(params);
      onChanged();
    }
    b(b.s.f(params));
    onChanged();
    return this;
  }
  
  public a a(b.t paramt)
  {
    Object localObject = this.h;
    if (localObject == null)
    {
      if ((this.a & 0x20) != 0)
      {
        localObject = this.g;
        if ((localObject != null) && (localObject != b.t.k()))
        {
          this.g = b.t.a(this.g).a(paramt).d();
          break label61;
        }
      }
      this.g = paramt;
      label61:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramt);
    }
    this.a |= 0x20;
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
  
  public b.s b()
  {
    return b.s.s();
  }
  
  public a c(String paramString)
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
  
  public b.s c()
  {
    b.s locals = d();
    if (locals.isInitialized()) {
      return locals;
    }
    throw newUninitializedMessageException(locals);
  }
  
  public a d(String paramString)
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
  
  public b.s d()
  {
    b.s locals = new b.s(this, null);
    int m = this.a;
    if ((m & 0x1) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    b.s.a(locals, this.b);
    int j = k;
    if ((m & 0x2) != 0)
    {
      b.s.a(locals, this.c);
      j = k | 0x2;
    }
    int k = j;
    if ((m & 0x4) != 0) {
      k = j | 0x4;
    }
    b.s.b(locals, this.d);
    j = k;
    if ((m & 0x8) != 0) {
      j = k | 0x8;
    }
    b.s.c(locals, this.e);
    k = j;
    if ((m & 0x10) != 0) {
      k = j | 0x10;
    }
    b.s.d(locals, this.f);
    j = k;
    if ((m & 0x20) != 0)
    {
      SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.h;
      if (localSingleFieldBuilderV3 == null) {
        b.s.a(locals, this.g);
      } else {
        b.s.a(locals, (b.t)localSingleFieldBuilderV3.d());
      }
      j = k | 0x20;
    }
    k = j;
    if ((m & 0x40) != 0) {
      k = j | 0x40;
    }
    b.s.e(locals, this.i);
    b.s.b(locals, k);
    onBuilt();
    return locals;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public b.t f()
  {
    Object localObject = this.h;
    if (localObject == null)
    {
      b.t localt = this.g;
      localObject = localt;
      if (localt == null) {
        localObject = b.t.k();
      }
      return localObject;
    }
    return (b.t)((SingleFieldBuilderV3)localObject).c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return b.d();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.e().a(b.s.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.s.a
 * JD-Core Version:    0.7.0.1
 */