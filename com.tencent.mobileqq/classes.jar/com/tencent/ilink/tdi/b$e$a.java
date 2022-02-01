package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class b$e$a
  extends GeneratedMessageV3.Builder<a>
  implements g
{
  private int a;
  private LazyStringList b = LazyStringArrayList.a;
  
  private b$e$a()
  {
    f();
  }
  
  private b$e$a(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    b.e.i();
  }
  
  private void g()
  {
    if ((this.a & 0x1) == 0)
    {
      this.b = new LazyStringArrayList(this.b);
      this.a |= 0x1;
    }
  }
  
  public a a()
  {
    super.clear();
    this.b = LazyStringArrayList.a;
    this.a &= 0xFFFFFFFE;
    return this;
  }
  
  /* Error */
  public a a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 55	com/tencent/ilink/tdi/b$e:a	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 61 3 0
    //   12: checkcast 34	com/tencent/ilink/tdi/b$e
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 64	com/tencent/ilink/tdi/b$e$a:a	(Lcom/tencent/ilink/tdi/b$e;)Lcom/tencent/ilink/tdi/b$e$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 68	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 34	com/tencent/ilink/tdi/b$e
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 72	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 64	com/tencent/ilink/tdi/b$e$a:a	(Lcom/tencent/ilink/tdi/b$e;)Lcom/tencent/ilink/tdi/b$e$a;
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
    if ((paramMessage instanceof b.e)) {
      return a((b.e)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final a a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (a)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public a a(b.e parame)
  {
    if (parame == b.e.g()) {
      return this;
    }
    if (!b.e.a(parame).isEmpty())
    {
      if (this.b.isEmpty())
      {
        this.b = b.e.a(parame);
        this.a &= 0xFFFFFFFE;
      }
      else
      {
        g();
        this.b.addAll(b.e.a(parame));
      }
      onChanged();
    }
    b(b.e.b(parame));
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
  
  public b.e b()
  {
    return b.e.g();
  }
  
  public b.e c()
  {
    b.e locale = d();
    if (locale.isInitialized()) {
      return locale;
    }
    throw newUninitializedMessageException(locale);
  }
  
  public b.e d()
  {
    b.e locale = new b.e(this, null);
    if ((this.a & 0x1) != 0)
    {
      this.b = this.b.e();
      this.a &= 0xFFFFFFFE;
    }
    b.e.a(locale, this.b);
    onBuilt();
    return locale;
  }
  
  public a e()
  {
    return (a)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return b.P();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return b.Q().a(b.e.class, a.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.e.a
 * JD-Core Version:    0.7.0.1
 */