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

public final class b$i$a
  extends GeneratedMessageV3.Builder<a>
  implements i
{
  private int a;
  private int b;
  private int c = 1;
  private int d = -1;
  private ByteString e = ByteString.EMPTY;
  private int f;
  
  private b$i$a()
  {
    f();
  }
  
  private b$i$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    b.i.q();
  }
  
  public a a()
  {
    super.clear();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = 1;
    this.a &= 0xFFFFFFFD;
    this.d = -1;
    this.a &= 0xFFFFFFFB;
    this.e = ByteString.EMPTY;
    this.a &= 0xFFFFFFF7;
    this.f = 0;
    this.a &= 0xFFFFFFEF;
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
      this.a |= 0x8;
      this.e = paramByteString;
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
    //   2: getstatic 71	com/tencent/ilink/tdi/b$i:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 77 3 0
    //   12: checkcast 42	com/tencent/ilink/tdi/b$i
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 80	com/tencent/ilink/tdi/b$i$a:a	(Lcom/tencent/ilink/tdi/b$i;)Lcom/tencent/ilink/tdi/b$i$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 84	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 42	com/tencent/ilink/tdi/b$i
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 88	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 80	com/tencent/ilink/tdi/b$i$a:a	(Lcom/tencent/ilink/tdi/b$i;)Lcom/tencent/ilink/tdi/b$i$a;
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
    if ((paramMessage instanceof b.i)) {
      return a((b.i)paramMessage);
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
      this.a |= 0x4;
      this.d = parama.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(a.c paramc)
  {
    if (paramc != null)
    {
      this.a |= 0x2;
      this.c = paramc.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(b.i parami)
  {
    if (parami == b.i.o()) {
      return this;
    }
    if (parami.b()) {
      a(parami.c());
    }
    if (parami.d()) {
      a(parami.e());
    }
    if (parami.f()) {
      a(parami.g());
    }
    if (parami.h()) {
      a(parami.i());
    }
    if (parami.j()) {
      b(parami.k());
    }
    b(b.i.a(parami));
    onChanged();
    return this;
  }
  
  public a b(int paramInt)
  {
    this.a |= 0x10;
    this.f = paramInt;
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
  
  public b.i b()
  {
    return b.i.o();
  }
  
  public b.i c()
  {
    b.i locali = d();
    if (locali.isInitialized()) {
      return locali;
    }
    throw newUninitializedMessageException(locali);
  }
  
  public b.i d()
  {
    b.i locali = new b.i(this, null);
    int k = this.a;
    if ((k & 0x1) != 0)
    {
      b.i.a(locali, this.b);
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i = j;
    if ((k & 0x2) != 0) {
      i = j | 0x2;
    }
    b.i.b(locali, this.c);
    int j = i;
    if ((k & 0x4) != 0) {
      j = i | 0x4;
    }
    b.i.c(locali, this.d);
    i = j;
    if ((k & 0x8) != 0) {
      i = j | 0x8;
    }
    b.i.a(locali, this.e);
    j = i;
    if ((k & 0x10) != 0)
    {
      b.i.d(locali, this.f);
      j = i | 0x10;
    }
    b.i.e(locali, j);
    onBuilt();
    return locali;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return b.n();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.o().a(b.i.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.i.a
 * JD-Core Version:    0.7.0.1
 */