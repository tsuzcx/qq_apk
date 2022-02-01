package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class ag$b$a
  extends GeneratedMessageV3.Builder<a>
  implements ai
{
  private int a;
  private int b;
  private int c;
  private ByteString d = ByteString.EMPTY;
  private boolean e;
  private boolean f;
  private int g;
  
  private ag$b$a()
  {
    f();
  }
  
  private ag$b$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    ag.b.s();
  }
  
  public a a()
  {
    super.clear();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    this.d = ByteString.EMPTY;
    this.a &= 0xFFFFFFFB;
    this.e = false;
    this.a &= 0xFFFFFFF7;
    this.f = false;
    this.a &= 0xFFFFFFEF;
    this.g = 0;
    this.a &= 0xFFFFFFDF;
    return this;
  }
  
  public a a(int paramInt)
  {
    this.a |= 0x1;
    this.b = paramInt;
    onChanged();
    return this;
  }
  
  public a a(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      this.a |= 0x4;
      this.d = paramByteString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 75	com/tencent/ilinkservice/ag$b:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 81 3 0
    //   12: checkcast 40	com/tencent/ilinkservice/ag$b
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 84	com/tencent/ilinkservice/ag$b$a:a	(Lcom/tencent/ilinkservice/ag$b;)Lcom/tencent/ilinkservice/ag$b$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 88	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 40	com/tencent/ilinkservice/ag$b
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 92	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 84	com/tencent/ilinkservice/ag$b$a:a	(Lcom/tencent/ilinkservice/ag$b;)Lcom/tencent/ilinkservice/ag$b$a;
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
    if ((paramMessage instanceof ag.b)) {
      return a((ag.b)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(ag.b paramb)
  {
    if (paramb == ag.b.q()) {
      return this;
    }
    if (paramb.b()) {
      a(paramb.c());
    }
    if (paramb.d()) {
      b(paramb.e());
    }
    if (paramb.f()) {
      a(paramb.g());
    }
    if (paramb.h()) {
      a(paramb.i());
    }
    if (paramb.j()) {
      b(paramb.k());
    }
    if (paramb.l()) {
      c(paramb.m());
    }
    b(ag.b.a(paramb));
    onChanged();
    return this;
  }
  
  public a a(boolean paramBoolean)
  {
    this.a |= 0x8;
    this.e = paramBoolean;
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
  
  public a b(boolean paramBoolean)
  {
    this.a |= 0x10;
    this.f = paramBoolean;
    onChanged();
    return this;
  }
  
  public ag.b b()
  {
    return ag.b.q();
  }
  
  public a c(int paramInt)
  {
    this.a |= 0x20;
    this.g = paramInt;
    onChanged();
    return this;
  }
  
  public ag.b c()
  {
    ag.b localb = d();
    if (localb.isInitialized()) {
      return localb;
    }
    throw newUninitializedMessageException(localb);
  }
  
  public ag.b d()
  {
    ag.b localb = new ag.b(this, null);
    int k = this.a;
    if ((k & 0x1) != 0)
    {
      ag.b.a(localb, this.b);
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i = j;
    if ((k & 0x2) != 0)
    {
      ag.b.b(localb, this.c);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x4) != 0) {
      j = i | 0x4;
    }
    ag.b.a(localb, this.d);
    i = j;
    if ((k & 0x8) != 0)
    {
      ag.b.a(localb, this.e);
      i = j | 0x8;
    }
    j = i;
    if ((k & 0x10) != 0)
    {
      ag.b.b(localb, this.f);
      j = i | 0x10;
    }
    i = j;
    if ((k & 0x20) != 0)
    {
      ag.b.c(localb, this.g);
      i = j | 0x20;
    }
    ag.b.d(localb, i);
    onBuilt();
    return localb;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return ag.d();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ag.e().a(ag.b.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ag.b.a
 * JD-Core Version:    0.7.0.1
 */