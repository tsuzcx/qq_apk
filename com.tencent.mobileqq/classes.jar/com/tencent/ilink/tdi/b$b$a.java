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

public final class b$b$a
  extends GeneratedMessageV3.Builder<a>
  implements d
{
  private int a;
  private ByteString b = ByteString.EMPTY;
  private int c;
  
  private b$b$a()
  {
    f();
  }
  
  private b$b$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    b.b.k();
  }
  
  public a a()
  {
    super.clear();
    this.b = ByteString.EMPTY;
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    return this;
  }
  
  public a a(int paramInt)
  {
    this.a |= 0x2;
    this.c = paramInt;
    onChanged();
    return this;
  }
  
  public a a(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      this.a |= 0x1;
      this.b = paramByteString;
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
    //   2: getstatic 63	com/tencent/ilink/tdi/b$b:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 69 3 0
    //   12: checkcast 36	com/tencent/ilink/tdi/b$b
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 72	com/tencent/ilink/tdi/b$b$a:a	(Lcom/tencent/ilink/tdi/b$b;)Lcom/tencent/ilink/tdi/b$b$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 76	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 36	com/tencent/ilink/tdi/b$b
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 80	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 72	com/tencent/ilink/tdi/b$b$a:a	(Lcom/tencent/ilink/tdi/b$b;)Lcom/tencent/ilink/tdi/b$b$a;
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
    if ((paramMessage instanceof b.b)) {
      return a((b.b)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(b.b paramb)
  {
    if (paramb == b.b.i()) {
      return this;
    }
    if (paramb.b()) {
      a(paramb.c());
    }
    if (paramb.d()) {
      a(paramb.e());
    }
    b(b.b.a(paramb));
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
  
  public b.b b()
  {
    return b.b.i();
  }
  
  public b.b c()
  {
    b.b localb = d();
    if (localb.isInitialized()) {
      return localb;
    }
    throw newUninitializedMessageException(localb);
  }
  
  public b.b d()
  {
    b.b localb = new b.b(this, null);
    int k = this.a;
    int i;
    if ((k & 0x1) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    b.b.a(localb, this.b);
    int j = i;
    if ((k & 0x2) != 0)
    {
      b.b.a(localb, this.c);
      j = i | 0x2;
    }
    b.b.b(localb, j);
    onBuilt();
    return localb;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return b.J();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.K().a(b.b.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.b.a
 * JD-Core Version:    0.7.0.1
 */