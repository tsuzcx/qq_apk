package com.tencent.ilink.network;

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
  implements b
{
  private int a;
  private Object b = "";
  private int c;
  private Object d = "";
  private int e;
  private int f = 0;
  
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
    a.b.q();
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
    this.e = 0;
    this.a &= 0xFFFFFFF7;
    this.f = 0;
    this.a &= 0xFFFFFFEF;
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
    //   2: getstatic 64	com/tencent/ilink/network/a$b:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 70 3 0
    //   12: checkcast 39	com/tencent/ilink/network/a$b
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 73	com/tencent/ilink/network/a$b$a:a	(Lcom/tencent/ilink/network/a$b;)Lcom/tencent/ilink/network/a$b$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 77	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 39	com/tencent/ilink/network/a$b
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 81	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 73	com/tencent/ilink/network/a$b$a:a	(Lcom/tencent/ilink/network/a$b;)Lcom/tencent/ilink/network/a$b$a;
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
  
  public a a(a.a parama)
  {
    if (parama != null)
    {
      this.a |= 0x10;
      this.f = parama.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(a.b paramb)
  {
    if (paramb == a.b.o()) {
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
    if (paramb.h()) {
      b(paramb.i());
    }
    if (paramb.j()) {
      a(paramb.k());
    }
    b(a.b.c(paramb));
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
  
  public a.b b()
  {
    return a.b.o();
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
    int k = this.a;
    if ((k & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    a.b.a(localb, this.b);
    int i = j;
    if ((k & 0x2) != 0)
    {
      a.b.a(localb, this.c);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x4) != 0) {
      j = i | 0x4;
    }
    a.b.b(localb, this.d);
    i = j;
    if ((k & 0x8) != 0)
    {
      a.b.b(localb, this.e);
      i = j | 0x8;
    }
    j = i;
    if ((k & 0x10) != 0) {
      j = i | 0x10;
    }
    a.b.c(localb, this.f);
    a.b.d(localb, j);
    onBuilt();
    return localb;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return a.b();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.c().a(a.b.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.network.a.b.a
 * JD-Core Version:    0.7.0.1
 */