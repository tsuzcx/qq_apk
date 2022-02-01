package com.tencent.ilink.tdi;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class b$j$a
  extends GeneratedMessageV3.Builder<a>
  implements j
{
  private int a;
  private int b = 1;
  private int c = 0;
  private ByteString d = ByteString.EMPTY;
  
  private b$j$a()
  {
    f();
  }
  
  private b$j$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    b.j.m();
  }
  
  public a a()
  {
    super.clear();
    this.b = 1;
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    this.d = ByteString.EMPTY;
    this.a &= 0xFFFFFFFB;
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
    //   2: getstatic 65	com/tencent/ilink/tdi/b$j:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 71 3 0
    //   12: checkcast 41	com/tencent/ilink/tdi/b$j
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 74	com/tencent/ilink/tdi/b$j$a:a	(Lcom/tencent/ilink/tdi/b$j;)Lcom/tencent/ilink/tdi/b$j$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 78	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 41	com/tencent/ilink/tdi/b$j
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 82	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 74	com/tencent/ilink/tdi/b$j$a:a	(Lcom/tencent/ilink/tdi/b$j;)Lcom/tencent/ilink/tdi/b$j$a;
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
    if ((paramMessage instanceof b.j)) {
      return a((b.j)paramMessage);
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
    if (paramc != null)
    {
      this.a |= 0x1;
      this.b = paramc.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(a.d paramd)
  {
    if (paramd != null)
    {
      this.a |= 0x2;
      this.c = paramd.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(b.j paramj)
  {
    if (paramj == b.j.k()) {
      return this;
    }
    if (paramj.b()) {
      a(paramj.c());
    }
    if (paramj.d()) {
      a(paramj.e());
    }
    if (paramj.f()) {
      a(paramj.g());
    }
    b(b.j.a(paramj));
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
  
  public b.j b()
  {
    return b.j.k();
  }
  
  public b.j c()
  {
    b.j localj = d();
    if (localj.isInitialized()) {
      return localj;
    }
    throw newUninitializedMessageException(localj);
  }
  
  public b.j d()
  {
    b.j localj = new b.j(this, null);
    int k = this.a;
    if ((k & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    b.j.a(localj, this.b);
    int i = j;
    if ((k & 0x2) != 0) {
      i = j | 0x2;
    }
    b.j.b(localj, this.c);
    int j = i;
    if ((k & 0x4) != 0) {
      j = i | 0x4;
    }
    b.j.a(localj, this.d);
    b.j.c(localj, j);
    onBuilt();
    return localj;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return b.p();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.q().a(b.j.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.j.a
 * JD-Core Version:    0.7.0.1
 */