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

public final class b$c$a
  extends GeneratedMessageV3.Builder<a>
  implements e
{
  private int a;
  private int b;
  private int c = 1;
  private int d;
  private Object e = "";
  private ByteString f = ByteString.EMPTY;
  private int g = 1;
  private int h;
  private boolean i;
  private boolean j;
  
  private b$c$a()
  {
    f();
  }
  
  private b$c$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    b.c.y();
  }
  
  public a a()
  {
    super.clear();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = 1;
    this.a &= 0xFFFFFFFD;
    this.d = 0;
    this.a &= 0xFFFFFFFB;
    this.e = "";
    this.a &= 0xFFFFFFF7;
    this.f = ByteString.EMPTY;
    this.a &= 0xFFFFFFEF;
    this.g = 1;
    this.a &= 0xFFFFFFDF;
    this.h = 0;
    this.a &= 0xFFFFFFBF;
    this.i = false;
    this.a &= 0xFFFFFF7F;
    this.j = false;
    this.a &= 0xFFFFFEFF;
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
      this.a |= 0x10;
      this.f = paramByteString;
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
    //   2: getstatic 87	com/tencent/ilink/tdi/b$c:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 93 3 0
    //   12: checkcast 52	com/tencent/ilink/tdi/b$c
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 96	com/tencent/ilink/tdi/b$c$a:a	(Lcom/tencent/ilink/tdi/b$c;)Lcom/tencent/ilink/tdi/b$c$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 100	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 52	com/tencent/ilink/tdi/b$c
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 104	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 96	com/tencent/ilink/tdi/b$c$a:a	(Lcom/tencent/ilink/tdi/b$c;)Lcom/tencent/ilink/tdi/b$c$a;
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
    if ((paramMessage instanceof b.c)) {
      return a((b.c)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(b.c paramc)
  {
    if (paramc == b.c.w()) {
      return this;
    }
    if (paramc.b()) {
      a(paramc.c());
    }
    if (paramc.d()) {
      a(paramc.e());
    }
    if (paramc.f()) {
      b(paramc.g());
    }
    if (paramc.h())
    {
      this.a |= 0x8;
      this.e = b.c.a(paramc);
      onChanged();
    }
    if (paramc.j()) {
      a(paramc.k());
    }
    if (paramc.l()) {
      a(paramc.m());
    }
    if (paramc.n()) {
      c(paramc.o());
    }
    if (paramc.p()) {
      a(paramc.q());
    }
    if (paramc.r()) {
      b(paramc.s());
    }
    b(b.c.b(paramc));
    onChanged();
    return this;
  }
  
  public a a(b.h paramh)
  {
    if (paramh != null)
    {
      this.a |= 0x2;
      this.c = paramh.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(b.y paramy)
  {
    if (paramy != null)
    {
      this.a |= 0x20;
      this.g = paramy.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(String paramString)
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
  
  public a a(boolean paramBoolean)
  {
    this.a |= 0x80;
    this.i = paramBoolean;
    onChanged();
    return this;
  }
  
  public a b(int paramInt)
  {
    this.a |= 0x4;
    this.d = paramInt;
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
    this.a |= 0x100;
    this.j = paramBoolean;
    onChanged();
    return this;
  }
  
  public b.c b()
  {
    return b.c.w();
  }
  
  public a c(int paramInt)
  {
    this.a |= 0x40;
    this.h = paramInt;
    onChanged();
    return this;
  }
  
  public b.c c()
  {
    b.c localc = d();
    if (localc.isInitialized()) {
      return localc;
    }
    throw newUninitializedMessageException(localc);
  }
  
  public b.c d()
  {
    b.c localc = new b.c(this, null);
    int n = this.a;
    if ((n & 0x1) != 0)
    {
      b.c.a(localc, this.b);
      m = 1;
    }
    else
    {
      m = 0;
    }
    int k = m;
    if ((n & 0x2) != 0) {
      k = m | 0x2;
    }
    b.c.b(localc, this.c);
    int m = k;
    if ((n & 0x4) != 0)
    {
      b.c.c(localc, this.d);
      m = k | 0x4;
    }
    k = m;
    if ((n & 0x8) != 0) {
      k = m | 0x8;
    }
    b.c.a(localc, this.e);
    m = k;
    if ((n & 0x10) != 0) {
      m = k | 0x10;
    }
    b.c.a(localc, this.f);
    k = m;
    if ((n & 0x20) != 0) {
      k = m | 0x20;
    }
    b.c.d(localc, this.g);
    m = k;
    if ((n & 0x40) != 0)
    {
      b.c.e(localc, this.h);
      m = k | 0x40;
    }
    k = m;
    if ((n & 0x80) != 0)
    {
      b.c.a(localc, this.i);
      k = m | 0x80;
    }
    m = k;
    if ((n & 0x100) != 0)
    {
      b.c.b(localc, this.j);
      m = k | 0x100;
    }
    b.c.f(localc, m);
    onBuilt();
    return localc;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return b.D();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.E().a(b.c.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.c.a
 * JD-Core Version:    0.7.0.1
 */