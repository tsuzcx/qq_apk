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

public final class b$m$a
  extends GeneratedMessageV3.Builder<a>
  implements m
{
  private int a;
  private int b;
  private int c = 1;
  private int d = 1;
  private ByteString e = ByteString.EMPTY;
  private ByteString f = ByteString.EMPTY;
  private ByteString g = ByteString.EMPTY;
  private int h;
  
  private b$m$a()
  {
    f();
  }
  
  private b$m$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    b.m.u();
  }
  
  public a a()
  {
    super.clear();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = 1;
    this.a &= 0xFFFFFFFD;
    this.d = 1;
    this.a &= 0xFFFFFFFB;
    this.e = ByteString.EMPTY;
    this.a &= 0xFFFFFFF7;
    this.f = ByteString.EMPTY;
    this.a &= 0xFFFFFFEF;
    this.g = ByteString.EMPTY;
    this.a &= 0xFFFFFFDF;
    this.h = 0;
    this.a &= 0xFFFFFFBF;
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
    //   2: getstatic 77	com/tencent/ilink/tdi/b$m:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 83 3 0
    //   12: checkcast 48	com/tencent/ilink/tdi/b$m
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 86	com/tencent/ilink/tdi/b$m$a:a	(Lcom/tencent/ilink/tdi/b$m;)Lcom/tencent/ilink/tdi/b$m$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 90	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 48	com/tencent/ilink/tdi/b$m
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 94	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 86	com/tencent/ilink/tdi/b$m$a:a	(Lcom/tencent/ilink/tdi/b$m;)Lcom/tencent/ilink/tdi/b$m$a;
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
    if ((paramMessage instanceof b.m)) {
      return a((b.m)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(a.b paramb)
  {
    if (paramb != null)
    {
      this.a |= 0x4;
      this.d = paramb.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(a.e parame)
  {
    if (parame != null)
    {
      this.a |= 0x2;
      this.c = parame.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(b.m paramm)
  {
    if (paramm == b.m.s()) {
      return this;
    }
    if (paramm.b()) {
      a(paramm.c());
    }
    if (paramm.d()) {
      a(paramm.e());
    }
    if (paramm.f()) {
      a(paramm.g());
    }
    if (paramm.h()) {
      a(paramm.i());
    }
    if (paramm.j()) {
      b(paramm.k());
    }
    if (paramm.l()) {
      c(paramm.m());
    }
    if (paramm.n()) {
      b(paramm.o());
    }
    b(b.m.a(paramm));
    onChanged();
    return this;
  }
  
  public a b(int paramInt)
  {
    this.a |= 0x40;
    this.h = paramInt;
    onChanged();
    return this;
  }
  
  public a b(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      this.a |= 0x10;
      this.f = paramByteString;
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
  
  public b.m b()
  {
    return b.m.s();
  }
  
  public a c(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      this.a |= 0x20;
      this.g = paramByteString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public b.m c()
  {
    b.m localm = d();
    if (localm.isInitialized()) {
      return localm;
    }
    throw newUninitializedMessageException(localm);
  }
  
  public b.m d()
  {
    b.m localm = new b.m(this, null);
    int k = this.a;
    if ((k & 0x1) != 0)
    {
      b.m.a(localm, this.b);
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
    b.m.b(localm, this.c);
    int j = i;
    if ((k & 0x4) != 0) {
      j = i | 0x4;
    }
    b.m.c(localm, this.d);
    i = j;
    if ((k & 0x8) != 0) {
      i = j | 0x8;
    }
    b.m.a(localm, this.e);
    j = i;
    if ((k & 0x10) != 0) {
      j = i | 0x10;
    }
    b.m.b(localm, this.f);
    i = j;
    if ((k & 0x20) != 0) {
      i = j | 0x20;
    }
    b.m.c(localm, this.g);
    j = i;
    if ((k & 0x40) != 0)
    {
      b.m.d(localm, this.h);
      j = i | 0x40;
    }
    b.m.e(localm, j);
    onBuilt();
    return localm;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return b.j();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.k().a(b.m.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.m.a
 * JD-Core Version:    0.7.0.1
 */