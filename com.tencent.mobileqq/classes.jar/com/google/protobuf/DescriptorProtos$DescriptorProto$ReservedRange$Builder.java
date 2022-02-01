package com.google.protobuf;

public final class DescriptorProtos$DescriptorProto$ReservedRange$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
{
  private int a;
  private int b;
  private int c;
  
  private DescriptorProtos$DescriptorProto$ReservedRange$Builder()
  {
    f();
  }
  
  private DescriptorProtos$DescriptorProto$ReservedRange$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    //   2: getstatic 56	com/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 62 3 0
    //   12: checkcast 52	com/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 65	com/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange$Builder:a	(Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange;)Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange$Builder;
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
    //   39: checkcast 52	com/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 73	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 65	com/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange$Builder:a	(Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange;)Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange$Builder;
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
  
  public Builder a(DescriptorProtos.DescriptorProto.ReservedRange paramReservedRange)
  {
    if (paramReservedRange == DescriptorProtos.DescriptorProto.ReservedRange.getDefaultInstance()) {
      return this;
    }
    if (paramReservedRange.hasStart()) {
      a(paramReservedRange.getStart());
    }
    if (paramReservedRange.hasEnd()) {
      b(paramReservedRange.getEnd());
    }
    b(paramReservedRange.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.DescriptorProto.ReservedRange)) {
      return a((DescriptorProtos.DescriptorProto.ReservedRange)paramMessage);
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
  
  public DescriptorProtos.DescriptorProto.ReservedRange b()
  {
    return DescriptorProtos.DescriptorProto.ReservedRange.getDefaultInstance();
  }
  
  public DescriptorProtos.DescriptorProto.ReservedRange c()
  {
    DescriptorProtos.DescriptorProto.ReservedRange localReservedRange = d();
    if (localReservedRange.isInitialized()) {
      return localReservedRange;
    }
    throw newUninitializedMessageException(localReservedRange);
  }
  
  public DescriptorProtos.DescriptorProto.ReservedRange d()
  {
    DescriptorProtos.DescriptorProto.ReservedRange localReservedRange = new DescriptorProtos.DescriptorProto.ReservedRange(this, null);
    int k = this.a;
    int i;
    if ((k & 0x1) != 0)
    {
      DescriptorProtos.DescriptorProto.ReservedRange.access$4302(localReservedRange, this.b);
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if ((k & 0x2) != 0)
    {
      DescriptorProtos.DescriptorProto.ReservedRange.access$4402(localReservedRange, this.c);
      j = i | 0x2;
    }
    DescriptorProtos.DescriptorProto.ReservedRange.access$4502(localReservedRange, j);
    onBuilt();
    return localReservedRange;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.j();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.k().a(DescriptorProtos.DescriptorProto.ReservedRange.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRange.Builder
 * JD-Core Version:    0.7.0.1
 */