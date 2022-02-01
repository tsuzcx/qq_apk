package com.google.protobuf;

public final class FieldMask$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements FieldMaskOrBuilder
{
  private int a;
  private LazyStringList b = LazyStringArrayList.a;
  
  private FieldMask$Builder()
  {
    f();
  }
  
  private FieldMask$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
  }
  
  private void g()
  {
    if ((this.a & 0x1) == 0)
    {
      this.b = new LazyStringArrayList(this.b);
      this.a |= 0x1;
    }
  }
  
  public Builder a()
  {
    super.clear();
    this.b = LazyStringArrayList.a;
    this.a &= 0xFFFFFFFE;
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 58	com/google/protobuf/FieldMask:access$400	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 64 3 0
    //   12: checkcast 54	com/google/protobuf/FieldMask
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 67	com/google/protobuf/FieldMask$Builder:a	(Lcom/google/protobuf/FieldMask;)Lcom/google/protobuf/FieldMask$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 71	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 54	com/google/protobuf/FieldMask
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 75	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 67	com/google/protobuf/FieldMask$Builder:a	(Lcom/google/protobuf/FieldMask;)Lcom/google/protobuf/FieldMask$Builder;
    //   58: pop
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	Builder
    //   0	61	1	paramCodedInputStream	CodedInputStream
    //   0	61	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   1	29	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   35	43	28	finally
    //   2	16	34	com/google/protobuf/InvalidProtocolBufferException
    //   43	48	48	finally
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return (Builder)super.clearField(paramFieldDescriptor);
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject)
  {
    return (Builder)super.setRepeatedField(paramFieldDescriptor, paramInt, paramObject);
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.setField(paramFieldDescriptor, paramObject);
  }
  
  public Builder a(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    return (Builder)super.clearOneof(paramOneofDescriptor);
  }
  
  public Builder a(FieldMask paramFieldMask)
  {
    if (paramFieldMask == FieldMask.getDefaultInstance()) {
      return this;
    }
    if (!FieldMask.access$300(paramFieldMask).isEmpty())
    {
      if (this.b.isEmpty())
      {
        this.b = FieldMask.access$300(paramFieldMask);
        this.a &= 0xFFFFFFFE;
      }
      else
      {
        g();
        this.b.addAll(FieldMask.access$300(paramFieldMask));
      }
      onChanged();
    }
    b(paramFieldMask.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof FieldMask)) {
      return a((FieldMask)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public FieldMask b()
  {
    return FieldMask.getDefaultInstance();
  }
  
  public FieldMask c()
  {
    FieldMask localFieldMask = d();
    if (localFieldMask.isInitialized()) {
      return localFieldMask;
    }
    throw newUninitializedMessageException(localFieldMask);
  }
  
  public FieldMask d()
  {
    FieldMask localFieldMask = new FieldMask(this, null);
    if ((this.a & 0x1) != 0)
    {
      this.b = this.b.e();
      this.a &= 0xFFFFFFFE;
    }
    FieldMask.access$302(localFieldMask, this.b);
    onBuilt();
    return localFieldMask;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return FieldMaskProto.a;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return FieldMaskProto.b.a(FieldMask.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.FieldMask.Builder
 * JD-Core Version:    0.7.0.1
 */