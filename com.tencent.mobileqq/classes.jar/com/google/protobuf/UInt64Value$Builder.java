package com.google.protobuf;

public final class UInt64Value$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements UInt64ValueOrBuilder
{
  private long a;
  
  private UInt64Value$Builder()
  {
    f();
  }
  
  private UInt64Value$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
  }
  
  public Builder a()
  {
    super.clear();
    this.a = 0L;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.a = paramLong;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 50	com/google/protobuf/UInt64Value:access$400	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 56 3 0
    //   12: checkcast 46	com/google/protobuf/UInt64Value
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 59	com/google/protobuf/UInt64Value$Builder:a	(Lcom/google/protobuf/UInt64Value;)Lcom/google/protobuf/UInt64Value$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 63	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 46	com/google/protobuf/UInt64Value
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 67	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 59	com/google/protobuf/UInt64Value$Builder:a	(Lcom/google/protobuf/UInt64Value;)Lcom/google/protobuf/UInt64Value$Builder;
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
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof UInt64Value)) {
      return a((UInt64Value)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public Builder a(UInt64Value paramUInt64Value)
  {
    if (paramUInt64Value == UInt64Value.getDefaultInstance()) {
      return this;
    }
    if (paramUInt64Value.getValue() != 0L) {
      a(paramUInt64Value.getValue());
    }
    b(paramUInt64Value.unknownFields);
    onChanged();
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
  
  public UInt64Value b()
  {
    return UInt64Value.getDefaultInstance();
  }
  
  public UInt64Value c()
  {
    UInt64Value localUInt64Value = d();
    if (localUInt64Value.isInitialized()) {
      return localUInt64Value;
    }
    throw newUninitializedMessageException(localUInt64Value);
  }
  
  public UInt64Value d()
  {
    UInt64Value localUInt64Value = new UInt64Value(this, null);
    UInt64Value.access$302(localUInt64Value, this.a);
    onBuilt();
    return localUInt64Value;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return WrappersProto.g;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return WrappersProto.h.a(UInt64Value.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UInt64Value.Builder
 * JD-Core Version:    0.7.0.1
 */