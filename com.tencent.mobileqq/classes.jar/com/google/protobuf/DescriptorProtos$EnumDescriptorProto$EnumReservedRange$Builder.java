package com.google.protobuf;

public final class DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
{
  private int a;
  private int b;
  private int c;
  
  private DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder()
  {
    f();
  }
  
  private DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.a |= 0x1;
    this.b = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 56	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 62 3 0
    //   12: checkcast 52	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 65	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange;)Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 69	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 52	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 73	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 65	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange;)Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;
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
  
  public Builder a(DescriptorProtos.EnumDescriptorProto.EnumReservedRange paramEnumReservedRange)
  {
    if (paramEnumReservedRange == DescriptorProtos.EnumDescriptorProto.EnumReservedRange.getDefaultInstance()) {
      return this;
    }
    if (paramEnumReservedRange.hasStart()) {
      a(paramEnumReservedRange.getStart());
    }
    if (paramEnumReservedRange.hasEnd()) {
      b(paramEnumReservedRange.getEnd());
    }
    b(paramEnumReservedRange.unknownFields);
    onChanged();
    return this;
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
    if ((paramMessage instanceof DescriptorProtos.EnumDescriptorProto.EnumReservedRange)) {
      return a((DescriptorProtos.EnumDescriptorProto.EnumReservedRange)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder b(int paramInt)
  {
    this.a |= 0x2;
    this.c = paramInt;
    onChanged();
    return this;
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.EnumDescriptorProto.EnumReservedRange b()
  {
    return DescriptorProtos.EnumDescriptorProto.EnumReservedRange.getDefaultInstance();
  }
  
  public DescriptorProtos.EnumDescriptorProto.EnumReservedRange c()
  {
    DescriptorProtos.EnumDescriptorProto.EnumReservedRange localEnumReservedRange = d();
    if (localEnumReservedRange.isInitialized()) {
      return localEnumReservedRange;
    }
    throw newUninitializedMessageException(localEnumReservedRange);
  }
  
  public DescriptorProtos.EnumDescriptorProto.EnumReservedRange d()
  {
    DescriptorProtos.EnumDescriptorProto.EnumReservedRange localEnumReservedRange = new DescriptorProtos.EnumDescriptorProto.EnumReservedRange(this, null);
    int k = this.a;
    int i;
    if ((k & 0x1) != 0)
    {
      DescriptorProtos.EnumDescriptorProto.EnumReservedRange.access$10202(localEnumReservedRange, this.b);
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if ((k & 0x2) != 0)
    {
      DescriptorProtos.EnumDescriptorProto.EnumReservedRange.access$10302(localEnumReservedRange, this.c);
      j = i | 0x2;
    }
    DescriptorProtos.EnumDescriptorProto.EnumReservedRange.access$10402(localEnumReservedRange, j);
    onBuilt();
    return localEnumReservedRange;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.t();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.u().a(DescriptorProtos.EnumDescriptorProto.EnumReservedRange.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder
 * JD-Core Version:    0.7.0.1
 */