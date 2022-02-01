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

public final class b$u$a
  extends GeneratedMessageV3.Builder<a>
  implements u
{
  private int a;
  private int b;
  private ByteString c = ByteString.EMPTY;
  private ByteString d = ByteString.EMPTY;
  private int e;
  private int f;
  private ByteString g = ByteString.EMPTY;
  private ByteString h = ByteString.EMPTY;
  private ByteString i = ByteString.EMPTY;
  
  private b$u$a()
  {
    f();
  }
  
  private b$u$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    b.u.w();
  }
  
  public a a()
  {
    super.clear();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = ByteString.EMPTY;
    this.a &= 0xFFFFFFFD;
    this.d = ByteString.EMPTY;
    this.a &= 0xFFFFFFFB;
    this.e = 0;
    this.a &= 0xFFFFFFF7;
    this.f = 0;
    this.a &= 0xFFFFFFEF;
    this.g = ByteString.EMPTY;
    this.a &= 0xFFFFFFDF;
    this.h = ByteString.EMPTY;
    this.a &= 0xFFFFFFBF;
    this.i = ByteString.EMPTY;
    this.a &= 0xFFFFFF7F;
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
      this.a |= 0x2;
      this.c = paramByteString;
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
    //   2: getstatic 80	com/tencent/ilink/tdi/b$u:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 86 3 0
    //   12: checkcast 49	com/tencent/ilink/tdi/b$u
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 89	com/tencent/ilink/tdi/b$u$a:a	(Lcom/tencent/ilink/tdi/b$u;)Lcom/tencent/ilink/tdi/b$u$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 93	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 49	com/tencent/ilink/tdi/b$u
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 97	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 89	com/tencent/ilink/tdi/b$u$a:a	(Lcom/tencent/ilink/tdi/b$u;)Lcom/tencent/ilink/tdi/b$u$a;
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
    if ((paramMessage instanceof b.u)) {
      return a((b.u)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(b.u paramu)
  {
    if (paramu == b.u.u()) {
      return this;
    }
    if (paramu.b()) {
      a(paramu.c());
    }
    if (paramu.d()) {
      a(paramu.e());
    }
    if (paramu.f()) {
      b(paramu.g());
    }
    if (paramu.h()) {
      b(paramu.i());
    }
    if (paramu.j()) {
      c(paramu.k());
    }
    if (paramu.l()) {
      c(paramu.m());
    }
    if (paramu.n()) {
      d(paramu.o());
    }
    if (paramu.p()) {
      e(paramu.q());
    }
    b(b.u.a(paramu));
    onChanged();
    return this;
  }
  
  public a b(int paramInt)
  {
    this.a |= 0x8;
    this.e = paramInt;
    onChanged();
    return this;
  }
  
  public a b(ByteString paramByteString)
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
  
  public a b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (a)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final a b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public b.u b()
  {
    return b.u.u();
  }
  
  public a c(int paramInt)
  {
    this.a |= 0x10;
    this.f = paramInt;
    onChanged();
    return this;
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
  
  public b.u c()
  {
    b.u localu = d();
    if (localu.isInitialized()) {
      return localu;
    }
    throw newUninitializedMessageException(localu);
  }
  
  public a d(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      this.a |= 0x40;
      this.h = paramByteString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public b.u d()
  {
    b.u localu = new b.u(this, null);
    int m = this.a;
    if ((m & 0x1) != 0)
    {
      b.u.a(localu, this.b);
      k = 1;
    }
    else
    {
      k = 0;
    }
    int j = k;
    if ((m & 0x2) != 0) {
      j = k | 0x2;
    }
    b.u.a(localu, this.c);
    int k = j;
    if ((m & 0x4) != 0) {
      k = j | 0x4;
    }
    b.u.b(localu, this.d);
    j = k;
    if ((m & 0x8) != 0)
    {
      b.u.b(localu, this.e);
      j = k | 0x8;
    }
    k = j;
    if ((m & 0x10) != 0)
    {
      b.u.c(localu, this.f);
      k = j | 0x10;
    }
    j = k;
    if ((m & 0x20) != 0) {
      j = k | 0x20;
    }
    b.u.c(localu, this.g);
    k = j;
    if ((m & 0x40) != 0) {
      k = j | 0x40;
    }
    b.u.d(localu, this.h);
    j = k;
    if ((m & 0x80) != 0) {
      j = k | 0x80;
    }
    b.u.e(localu, this.i);
    b.u.d(localu, j);
    onBuilt();
    return localu;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public a e(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      this.a |= 0x80;
      this.i = paramByteString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return b.r();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.s().a(b.u.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.u.a
 * JD-Core Version:    0.7.0.1
 */