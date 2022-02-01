package com.google.protobuf;

public final class DescriptorProtos$DescriptorProto$ExtensionRange$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
{
  private int a;
  private int b;
  private int c;
  private DescriptorProtos.ExtensionRangeOptions d;
  private SingleFieldBuilderV3<DescriptorProtos.ExtensionRangeOptions, DescriptorProtos.ExtensionRangeOptions.Builder, DescriptorProtos.ExtensionRangeOptionsOrBuilder> e;
  
  private DescriptorProtos$DescriptorProto$ExtensionRange$Builder()
  {
    h();
  }
  
  private DescriptorProtos$DescriptorProto$ExtensionRange$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    h();
  }
  
  private void h()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
      i();
    }
  }
  
  private SingleFieldBuilderV3<DescriptorProtos.ExtensionRangeOptions, DescriptorProtos.ExtensionRangeOptions.Builder, DescriptorProtos.ExtensionRangeOptionsOrBuilder> i()
  {
    if (this.e == null)
    {
      this.e = new SingleFieldBuilderV3(g(), getParentForChildren(), isClean());
      this.d = null;
    }
    return this.e;
  }
  
  public Builder a()
  {
    super.clear();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.e;
    if (localSingleFieldBuilderV3 == null) {
      this.d = null;
    } else {
      localSingleFieldBuilderV3.g();
    }
    this.a &= 0xFFFFFFFB;
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
    //   2: getstatic 90	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 96 3 0
    //   12: checkcast 86	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 99	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange$Builder:a	(Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange;)Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 103	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 86	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 107	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 99	com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange$Builder:a	(Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange;)Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange$Builder;
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
  
  public Builder a(DescriptorProtos.DescriptorProto.ExtensionRange paramExtensionRange)
  {
    if (paramExtensionRange == DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance()) {
      return this;
    }
    if (paramExtensionRange.hasStart()) {
      a(paramExtensionRange.getStart());
    }
    if (paramExtensionRange.hasEnd()) {
      b(paramExtensionRange.getEnd());
    }
    if (paramExtensionRange.hasOptions()) {
      a(paramExtensionRange.getOptions());
    }
    b(paramExtensionRange.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(DescriptorProtos.ExtensionRangeOptions paramExtensionRangeOptions)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      if ((this.a & 0x4) != 0)
      {
        localObject = this.d;
        if ((localObject != null) && (localObject != DescriptorProtos.ExtensionRangeOptions.getDefaultInstance()))
        {
          this.d = DescriptorProtos.ExtensionRangeOptions.newBuilder(this.d).a(paramExtensionRangeOptions).d();
          break label60;
        }
      }
      this.d = paramExtensionRangeOptions;
      label60:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramExtensionRangeOptions);
    }
    this.a |= 0x4;
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
    if ((paramMessage instanceof DescriptorProtos.DescriptorProto.ExtensionRange)) {
      return a((DescriptorProtos.DescriptorProto.ExtensionRange)paramMessage);
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
  
  public DescriptorProtos.DescriptorProto.ExtensionRange b()
  {
    return DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance();
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange c()
  {
    DescriptorProtos.DescriptorProto.ExtensionRange localExtensionRange = d();
    if (localExtensionRange.isInitialized()) {
      return localExtensionRange;
    }
    throw newUninitializedMessageException(localExtensionRange);
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange d()
  {
    DescriptorProtos.DescriptorProto.ExtensionRange localExtensionRange = new DescriptorProtos.DescriptorProto.ExtensionRange(this, null);
    int k = this.a;
    if ((k & 0x1) != 0)
    {
      DescriptorProtos.DescriptorProto.ExtensionRange.access$3302(localExtensionRange, this.b);
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i = j;
    if ((k & 0x2) != 0)
    {
      DescriptorProtos.DescriptorProto.ExtensionRange.access$3402(localExtensionRange, this.c);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x4) != 0)
    {
      SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.e;
      if (localSingleFieldBuilderV3 == null) {
        DescriptorProtos.DescriptorProto.ExtensionRange.access$3502(localExtensionRange, this.d);
      } else {
        DescriptorProtos.DescriptorProto.ExtensionRange.access$3502(localExtensionRange, (DescriptorProtos.ExtensionRangeOptions)localSingleFieldBuilderV3.d());
      }
      j = i | 0x4;
    }
    DescriptorProtos.DescriptorProto.ExtensionRange.access$3602(localExtensionRange, j);
    onBuilt();
    return localExtensionRange;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public boolean f()
  {
    return (this.a & 0x4) != 0;
  }
  
  public DescriptorProtos.ExtensionRangeOptions g()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      DescriptorProtos.ExtensionRangeOptions localExtensionRangeOptions = this.d;
      localObject = localExtensionRangeOptions;
      if (localExtensionRangeOptions == null) {
        localObject = DescriptorProtos.ExtensionRangeOptions.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.ExtensionRangeOptions)((SingleFieldBuilderV3)localObject).c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.h();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.i().a(DescriptorProtos.DescriptorProto.ExtensionRange.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return (!f()) || (g().isInitialized());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange.Builder
 * JD-Core Version:    0.7.0.1
 */