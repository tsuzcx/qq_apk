package com.google.protobuf;

public final class Int32Value$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements Int32ValueOrBuilder
{
  private int a;
  
  private Int32Value$Builder()
  {
    f();
  }
  
  private Int32Value$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    this.a = 0;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.a = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 50	com/google/protobuf/Int32Value:access$400	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 56 3 0
    //   12: checkcast 46	com/google/protobuf/Int32Value
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 59	com/google/protobuf/Int32Value$Builder:a	(Lcom/google/protobuf/Int32Value;)Lcom/google/protobuf/Int32Value$Builder;
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
    //   39: checkcast 46	com/google/protobuf/Int32Value
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 67	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 59	com/google/protobuf/Int32Value$Builder:a	(Lcom/google/protobuf/Int32Value;)Lcom/google/protobuf/Int32Value$Builder;
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
  
  public Builder a(Int32Value paramInt32Value)
  {
    if (paramInt32Value == Int32Value.getDefaultInstance()) {
      return this;
    }
    if (paramInt32Value.getValue() != 0) {
      a(paramInt32Value.getValue());
    }
    b(paramInt32Value.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof Int32Value)) {
      return a((Int32Value)paramMessage);
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
  
  public Int32Value b()
  {
    return Int32Value.getDefaultInstance();
  }
  
  public Int32Value c()
  {
    Int32Value localInt32Value = d();
    if (localInt32Value.isInitialized()) {
      return localInt32Value;
    }
    throw newUninitializedMessageException(localInt32Value);
  }
  
  public Int32Value d()
  {
    Int32Value localInt32Value = new Int32Value(this, null);
    Int32Value.access$302(localInt32Value, this.a);
    onBuilt();
    return localInt32Value;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return WrappersProto.i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return WrappersProto.j.a(Int32Value.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Int32Value.Builder
 * JD-Core Version:    0.7.0.1
 */