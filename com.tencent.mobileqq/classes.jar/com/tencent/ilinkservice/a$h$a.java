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

public final class a$h$a
  extends GeneratedMessageV3.Builder<a>
  implements i
{
  private int a;
  private Object b = "";
  private int c;
  private int d;
  private ByteString e = ByteString.EMPTY;
  
  private a$h$a()
  {
    f();
  }
  
  private a$h$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    a.h.o();
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
    //   2: getstatic 72	com/tencent/ilinkservice/a$h:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 78 3 0
    //   12: checkcast 43	com/tencent/ilinkservice/a$h
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 81	com/tencent/ilinkservice/a$h$a:a	(Lcom/tencent/ilinkservice/a$h;)Lcom/tencent/ilinkservice/a$h$a;
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
    //   39: checkcast 43	com/tencent/ilinkservice/a$h
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 89	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 81	com/tencent/ilinkservice/a$h$a:a	(Lcom/tencent/ilinkservice/a$h;)Lcom/tencent/ilinkservice/a$h$a;
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
    if ((paramMessage instanceof a.h)) {
      return a((a.h)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(a.h paramh)
  {
    if (paramh == a.h.m()) {
      return this;
    }
    if (paramh.b())
    {
      this.a |= 0x1;
      this.b = a.h.a(paramh);
      onChanged();
    }
    if (paramh.d()) {
      a(paramh.e());
    }
    if (paramh.f()) {
      b(paramh.g());
    }
    if (paramh.h()) {
      a(paramh.i());
    }
    b(a.h.b(paramh));
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
  
  public a.h b()
  {
    return a.h.m();
  }
  
  public a.h c()
  {
    a.h localh = d();
    if (localh.isInitialized()) {
      return localh;
    }
    throw newUninitializedMessageException(localh);
  }
  
  public a.h d()
  {
    a.h localh = new a.h(this, null);
    int k = this.a;
    if ((k & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    a.h.a(localh, this.b);
    int i = j;
    if ((k & 0x2) != 0)
    {
      a.h.a(localh, this.c);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x4) != 0)
    {
      a.h.b(localh, this.d);
      j = i | 0x4;
    }
    i = j;
    if ((k & 0x8) != 0) {
      i = j | 0x8;
    }
    a.h.a(localh, this.e);
    a.h.c(localh, i);
    onBuilt();
    return localh;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return a.B();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return a.C().a(a.h.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.a.h.a
 * JD-Core Version:    0.7.0.1
 */