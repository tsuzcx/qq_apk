package com.google.protobuf;

public final class BytesValue$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements BytesValueOrBuilder
{
  private ByteString a = ByteString.EMPTY;
  
  private BytesValue$Builder()
  {
    f();
  }
  
  private BytesValue$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    this.a = ByteString.EMPTY;
    return this;
  }
  
  public Builder a(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      this.a = paramByteString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder a(BytesValue paramBytesValue)
  {
    if (paramBytesValue == BytesValue.getDefaultInstance()) {
      return this;
    }
    if (paramBytesValue.getValue() != ByteString.EMPTY) {
      a(paramBytesValue.getValue());
    }
    b(paramBytesValue.unknownFields);
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 77	com/google/protobuf/BytesValue:access$400	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 83 3 0
    //   12: checkcast 52	com/google/protobuf/BytesValue
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 85	com/google/protobuf/BytesValue$Builder:a	(Lcom/google/protobuf/BytesValue;)Lcom/google/protobuf/BytesValue$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 89	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 52	com/google/protobuf/BytesValue
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 93	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 85	com/google/protobuf/BytesValue$Builder:a	(Lcom/google/protobuf/BytesValue;)Lcom/google/protobuf/BytesValue$Builder;
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
    if ((paramMessage instanceof BytesValue)) {
      return a((BytesValue)paramMessage);
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
  
  public BytesValue b()
  {
    return BytesValue.getDefaultInstance();
  }
  
  public BytesValue c()
  {
    BytesValue localBytesValue = d();
    if (localBytesValue.isInitialized()) {
      return localBytesValue;
    }
    throw newUninitializedMessageException(localBytesValue);
  }
  
  public BytesValue d()
  {
    BytesValue localBytesValue = new BytesValue(this, null);
    BytesValue.access$302(localBytesValue, this.a);
    onBuilt();
    return localBytesValue;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return WrappersProto.q;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return WrappersProto.r.a(BytesValue.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.BytesValue.Builder
 * JD-Core Version:    0.7.0.1
 */