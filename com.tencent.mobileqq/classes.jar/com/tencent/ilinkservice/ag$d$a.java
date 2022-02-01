package com.tencent.ilinkservice;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class ag$d$a
  extends GeneratedMessageV3.Builder<a>
  implements ak
{
  private int a;
  private Object b = "";
  private Object c = "";
  private Object d = "";
  private Object e = "";
  private Object f = "";
  
  private ag$d$a()
  {
    f();
  }
  
  private ag$d$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    ag.d.q();
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
    this.f = "";
    this.a &= 0xFFFFFFEF;
    return this;
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 60	com/tencent/ilinkservice/ag$d:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 66 3 0
    //   12: checkcast 43	com/tencent/ilinkservice/ag$d
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 69	com/tencent/ilinkservice/ag$d$a:a	(Lcom/tencent/ilinkservice/ag$d;)Lcom/tencent/ilinkservice/ag$d$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 73	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 43	com/tencent/ilinkservice/ag$d
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 77	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 69	com/tencent/ilinkservice/ag$d$a:a	(Lcom/tencent/ilinkservice/ag$d;)Lcom/tencent/ilinkservice/ag$d$a;
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
    if ((paramMessage instanceof ag.d)) {
      return a((ag.d)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(ag.d paramd)
  {
    if (paramd == ag.d.o()) {
      return this;
    }
    if (paramd.b())
    {
      this.a |= 0x1;
      this.b = ag.d.a(paramd);
      onChanged();
    }
    if (paramd.d())
    {
      this.a |= 0x2;
      this.c = ag.d.b(paramd);
      onChanged();
    }
    if (paramd.f())
    {
      this.a |= 0x4;
      this.d = ag.d.c(paramd);
      onChanged();
    }
    if (paramd.h())
    {
      this.a |= 0x8;
      this.e = ag.d.d(paramd);
      onChanged();
    }
    if (paramd.j())
    {
      this.a |= 0x10;
      this.f = ag.d.e(paramd);
      onChanged();
    }
    b(ag.d.f(paramd));
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
      this.a |= 0x2;
      this.c = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public ag.d b()
  {
    return ag.d.o();
  }
  
  public a c(String paramString)
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
  
  public ag.d c()
  {
    ag.d locald = d();
    if (locald.isInitialized()) {
      return locald;
    }
    throw newUninitializedMessageException(locald);
  }
  
  public a d(String paramString)
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
  
  public ag.d d()
  {
    ag.d locald = new ag.d(this, null);
    int k = this.a;
    if ((k & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    ag.d.a(locald, this.b);
    int i = j;
    if ((k & 0x2) != 0) {
      i = j | 0x2;
    }
    ag.d.b(locald, this.c);
    int j = i;
    if ((k & 0x4) != 0) {
      j = i | 0x4;
    }
    ag.d.c(locald, this.d);
    i = j;
    if ((k & 0x8) != 0) {
      i = j | 0x8;
    }
    ag.d.d(locald, this.e);
    j = i;
    if ((k & 0x10) != 0) {
      j = i | 0x10;
    }
    ag.d.e(locald, this.f);
    ag.d.a(locald, j);
    onBuilt();
    return locald;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public a e(String paramString)
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
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return ag.h();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.i().a(ag.d.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.d.a
 * JD-Core Version:    0.7.0.1
 */