package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class b$z$a
  extends GeneratedMessageV3.Builder<a>
  implements w
{
  private int a;
  private int b = -1;
  private int c;
  private long d;
  private Object e = "";
  private int f = 0;
  
  private b$z$a()
  {
    f();
  }
  
  private b$z$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    b.z.q();
  }
  
  public a a()
  {
    super.clear();
    this.b = -1;
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    this.d = 0L;
    this.a &= 0xFFFFFFFB;
    this.e = "";
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
  
  public a a(long paramLong)
  {
    this.a |= 0x4;
    this.d = paramLong;
    onChanged();
    return this;
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 66	com/tencent/ilink/tdi/b$z:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 72 3 0
    //   12: checkcast 40	com/tencent/ilink/tdi/b$z
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 75	com/tencent/ilink/tdi/b$z$a:a	(Lcom/tencent/ilink/tdi/b$z;)Lcom/tencent/ilink/tdi/b$z$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 79	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 40	com/tencent/ilink/tdi/b$z
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 83	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 75	com/tencent/ilink/tdi/b$z$a:a	(Lcom/tencent/ilink/tdi/b$z;)Lcom/tencent/ilink/tdi/b$z$a;
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
    if ((paramMessage instanceof b.z)) {
      return a((b.z)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(b.w paramw)
  {
    if (paramw != null)
    {
      this.a |= 0x10;
      this.f = paramw.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(b.x paramx)
  {
    if (paramx != null)
    {
      this.a |= 0x1;
      this.b = paramx.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public a a(b.z paramz)
  {
    if (paramz == b.z.o()) {
      return this;
    }
    if (paramz.b()) {
      a(paramz.c());
    }
    if (paramz.d()) {
      a(paramz.e());
    }
    if (paramz.f()) {
      a(paramz.g());
    }
    if (paramz.h())
    {
      this.a |= 0x8;
      this.e = b.z.a(paramz);
      onChanged();
    }
    if (paramz.j()) {
      a(paramz.k());
    }
    b(b.z.b(paramz));
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
  
  public b.z b()
  {
    return b.z.o();
  }
  
  public b.z c()
  {
    b.z localz = d();
    if (localz.isInitialized()) {
      return localz;
    }
    throw newUninitializedMessageException(localz);
  }
  
  public b.z d()
  {
    b.z localz = new b.z(this, null);
    int k = this.a;
    if ((k & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    b.z.a(localz, this.b);
    int i = j;
    if ((k & 0x2) != 0)
    {
      b.z.b(localz, this.c);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x4) != 0)
    {
      b.z.a(localz, this.d);
      j = i | 0x4;
    }
    i = j;
    if ((k & 0x8) != 0) {
      i = j | 0x8;
    }
    b.z.a(localz, this.e);
    j = i;
    if ((k & 0x10) != 0) {
      j = i | 0x10;
    }
    b.z.c(localz, this.f);
    b.z.d(localz, j);
    onBuilt();
    return localz;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return b.B();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.C().a(b.z.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.z.a
 * JD-Core Version:    0.7.0.1
 */