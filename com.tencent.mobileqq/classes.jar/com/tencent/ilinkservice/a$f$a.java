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

public final class a$f$a
  extends GeneratedMessageV3.Builder<a>
  implements g
{
  private int a;
  private Object b = "";
  private int c;
  private int d;
  private ByteString e = ByteString.EMPTY;
  
  private a$f$a()
  {
    f();
  }
  
  private a$f$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    a.f.o();
  }
  
  public a a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    this.d = 0;
    this.a &= 0xFFFFFFFB;
    this.e = ByteString.EMPTY;
    this.a &= 0xFFFFFFF7;
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
    //   2: getstatic 72	com/tencent/ilinkservice/a$f:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 78 3 0
    //   12: checkcast 43	com/tencent/ilinkservice/a$f
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 81	com/tencent/ilinkservice/a$f$a:a	(Lcom/tencent/ilinkservice/a$f;)Lcom/tencent/ilinkservice/a$f$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 85	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 43	com/tencent/ilinkservice/a$f
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 89	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 81	com/tencent/ilinkservice/a$f$a:a	(Lcom/tencent/ilinkservice/a$f;)Lcom/tencent/ilinkservice/a$f$a;
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
    if ((paramMessage instanceof a.f)) {
      return a((a.f)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(a.f paramf)
  {
    if (paramf == a.f.m()) {
      return this;
    }
    if (paramf.b())
    {
      this.a |= 0x1;
      this.b = a.f.a(paramf);
      onChanged();
    }
    if (paramf.d()) {
      a(paramf.e());
    }
    if (paramf.f()) {
      b(paramf.g());
    }
    if (paramf.h()) {
      a(paramf.i());
    }
    b(a.f.b(paramf));
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
  
  public a.f b()
  {
    return a.f.m();
  }
  
  public a.f c()
  {
    a.f localf = d();
    if (localf.isInitialized()) {
      return localf;
    }
    throw newUninitializedMessageException(localf);
  }
  
  public a.f d()
  {
    a.f localf = new a.f(this, null);
    int k = this.a;
    if ((k & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    a.f.a(localf, this.b);
    int i = j;
    if ((k & 0x2) != 0)
    {
      a.f.a(localf, this.c);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x4) != 0)
    {
      a.f.b(localf, this.d);
      j = i | 0x4;
    }
    i = j;
    if ((k & 0x8) != 0) {
      i = j | 0x8;
    }
    a.f.a(localf, this.e);
    a.f.c(localf, i);
    onBuilt();
    return localf;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return a.z();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.A().a(a.f.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.a.f.a
 * JD-Core Version:    0.7.0.1
 */