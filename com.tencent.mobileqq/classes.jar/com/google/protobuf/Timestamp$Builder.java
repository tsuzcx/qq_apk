package com.google.protobuf;

public final class Timestamp$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements TimestampOrBuilder
{
  private long a;
  private int b;
  
  private Timestamp$Builder()
  {
    f();
  }
  
  private Timestamp$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    this.b = 0;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.b = paramInt;
    onChanged();
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
    //   2: invokestatic 55	com/google/protobuf/Timestamp:access$500	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 61 3 0
    //   12: checkcast 51	com/google/protobuf/Timestamp
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 64	com/google/protobuf/Timestamp$Builder:a	(Lcom/google/protobuf/Timestamp;)Lcom/google/protobuf/Timestamp$Builder;
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
    //   39: checkcast 51	com/google/protobuf/Timestamp
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 72	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 64	com/google/protobuf/Timestamp$Builder:a	(Lcom/google/protobuf/Timestamp;)Lcom/google/protobuf/Timestamp$Builder;
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
    if ((paramMessage instanceof Timestamp)) {
      return a((Timestamp)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public Builder a(Timestamp paramTimestamp)
  {
    if (paramTimestamp == Timestamp.getDefaultInstance()) {
      return this;
    }
    if (paramTimestamp.getSeconds() != 0L) {
      a(paramTimestamp.getSeconds());
    }
    if (paramTimestamp.getNanos() != 0) {
      a(paramTimestamp.getNanos());
    }
    b(paramTimestamp.unknownFields);
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
  
  public Timestamp b()
  {
    return Timestamp.getDefaultInstance();
  }
  
  public Timestamp c()
  {
    Timestamp localTimestamp = d();
    if (localTimestamp.isInitialized()) {
      return localTimestamp;
    }
    throw newUninitializedMessageException(localTimestamp);
  }
  
  public Timestamp d()
  {
    Timestamp localTimestamp = new Timestamp(this, null);
    Timestamp.access$302(localTimestamp, this.a);
    Timestamp.access$402(localTimestamp, this.b);
    onBuilt();
    return localTimestamp;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return TimestampProto.a;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TimestampProto.b.a(Timestamp.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Timestamp.Builder
 * JD-Core Version:    0.7.0.1
 */