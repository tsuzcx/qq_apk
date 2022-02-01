package com.google.protobuf;

public final class DescriptorProtos$EnumValueDescriptorProto$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.EnumValueDescriptorProtoOrBuilder
{
  private int a;
  private Object b = "";
  private int c;
  private DescriptorProtos.EnumValueOptions d;
  private SingleFieldBuilderV3<DescriptorProtos.EnumValueOptions, DescriptorProtos.EnumValueOptions.Builder, DescriptorProtos.EnumValueOptionsOrBuilder> e;
  
  private DescriptorProtos$EnumValueDescriptorProto$Builder()
  {
    h();
  }
  
  private DescriptorProtos$EnumValueDescriptorProto$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
  
  private SingleFieldBuilderV3<DescriptorProtos.EnumValueOptions, DescriptorProtos.EnumValueOptions.Builder, DescriptorProtos.EnumValueOptionsOrBuilder> i()
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
    this.b = "";
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
    this.a |= 0x2;
    this.c = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 93	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 99 3 0
    //   12: checkcast 89	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 102	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 106	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 89	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 110	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 102	com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto$Builder;
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
  
  public Builder a(DescriptorProtos.EnumValueDescriptorProto paramEnumValueDescriptorProto)
  {
    if (paramEnumValueDescriptorProto == DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (paramEnumValueDescriptorProto.hasName())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.EnumValueDescriptorProto.access$12100(paramEnumValueDescriptorProto);
      onChanged();
    }
    if (paramEnumValueDescriptorProto.hasNumber()) {
      a(paramEnumValueDescriptorProto.getNumber());
    }
    if (paramEnumValueDescriptorProto.hasOptions()) {
      a(paramEnumValueDescriptorProto.getOptions());
    }
    b(paramEnumValueDescriptorProto.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(DescriptorProtos.EnumValueOptions paramEnumValueOptions)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      if ((this.a & 0x4) != 0)
      {
        localObject = this.d;
        if ((localObject != null) && (localObject != DescriptorProtos.EnumValueOptions.getDefaultInstance()))
        {
          this.d = DescriptorProtos.EnumValueOptions.newBuilder(this.d).a(paramEnumValueOptions).d();
          break label60;
        }
      }
      this.d = paramEnumValueOptions;
      label60:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramEnumValueOptions);
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
    if ((paramMessage instanceof DescriptorProtos.EnumValueDescriptorProto)) {
      return a((DescriptorProtos.EnumValueDescriptorProto)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(String paramString)
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
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.EnumValueDescriptorProto b()
  {
    return DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.EnumValueDescriptorProto c()
  {
    DescriptorProtos.EnumValueDescriptorProto localEnumValueDescriptorProto = d();
    if (localEnumValueDescriptorProto.isInitialized()) {
      return localEnumValueDescriptorProto;
    }
    throw newUninitializedMessageException(localEnumValueDescriptorProto);
  }
  
  public DescriptorProtos.EnumValueDescriptorProto d()
  {
    DescriptorProtos.EnumValueDescriptorProto localEnumValueDescriptorProto = new DescriptorProtos.EnumValueDescriptorProto(this, null);
    int k = this.a;
    if ((k & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    DescriptorProtos.EnumValueDescriptorProto.access$12102(localEnumValueDescriptorProto, this.b);
    int i = j;
    if ((k & 0x2) != 0)
    {
      DescriptorProtos.EnumValueDescriptorProto.access$12202(localEnumValueDescriptorProto, this.c);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x4) != 0)
    {
      SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.e;
      if (localSingleFieldBuilderV3 == null) {
        DescriptorProtos.EnumValueDescriptorProto.access$12302(localEnumValueDescriptorProto, this.d);
      } else {
        DescriptorProtos.EnumValueDescriptorProto.access$12302(localEnumValueDescriptorProto, (DescriptorProtos.EnumValueOptions)localSingleFieldBuilderV3.d());
      }
      j = i | 0x4;
    }
    DescriptorProtos.EnumValueDescriptorProto.access$12402(localEnumValueDescriptorProto, j);
    onBuilt();
    return localEnumValueDescriptorProto;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public boolean f()
  {
    return (this.a & 0x4) != 0;
  }
  
  public DescriptorProtos.EnumValueOptions g()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      DescriptorProtos.EnumValueOptions localEnumValueOptions = this.d;
      localObject = localEnumValueOptions;
      if (localEnumValueOptions == null) {
        localObject = DescriptorProtos.EnumValueOptions.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.EnumValueOptions)((SingleFieldBuilderV3)localObject).c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.v();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.w().a(DescriptorProtos.EnumValueDescriptorProto.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return (!f()) || (g().isInitialized());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.EnumValueDescriptorProto.Builder
 * JD-Core Version:    0.7.0.1
 */