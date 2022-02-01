package com.google.protobuf;

public final class DescriptorProtos$OneofDescriptorProto$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.OneofDescriptorProtoOrBuilder
{
  private int a;
  private Object b = "";
  private DescriptorProtos.OneofOptions c;
  private SingleFieldBuilderV3<DescriptorProtos.OneofOptions, DescriptorProtos.OneofOptions.Builder, DescriptorProtos.OneofOptionsOrBuilder> d;
  
  private DescriptorProtos$OneofDescriptorProto$Builder()
  {
    h();
  }
  
  private DescriptorProtos$OneofDescriptorProto$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
  
  private SingleFieldBuilderV3<DescriptorProtos.OneofOptions, DescriptorProtos.OneofOptions.Builder, DescriptorProtos.OneofOptionsOrBuilder> i()
  {
    if (this.d == null)
    {
      this.d = new SingleFieldBuilderV3(g(), getParentForChildren(), isClean());
      this.c = null;
    }
    return this.d;
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.d;
    if (localSingleFieldBuilderV3 == null) {
      this.c = null;
    } else {
      localSingleFieldBuilderV3.g();
    }
    this.a &= 0xFFFFFFFD;
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 86	com/google/protobuf/DescriptorProtos$OneofDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 92 3 0
    //   12: checkcast 82	com/google/protobuf/DescriptorProtos$OneofDescriptorProto
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 95	com/google/protobuf/DescriptorProtos$OneofDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$OneofDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$OneofDescriptorProto$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 99	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 82	com/google/protobuf/DescriptorProtos$OneofDescriptorProto
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 103	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 95	com/google/protobuf/DescriptorProtos$OneofDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$OneofDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$OneofDescriptorProto$Builder;
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
  
  public Builder a(DescriptorProtos.OneofDescriptorProto paramOneofDescriptorProto)
  {
    if (paramOneofDescriptorProto == DescriptorProtos.OneofDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (paramOneofDescriptorProto.hasName())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.OneofDescriptorProto.access$9100(paramOneofDescriptorProto);
      onChanged();
    }
    if (paramOneofDescriptorProto.hasOptions()) {
      a(paramOneofDescriptorProto.getOptions());
    }
    b(paramOneofDescriptorProto.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(DescriptorProtos.OneofOptions paramOneofOptions)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      if ((this.a & 0x2) != 0)
      {
        localObject = this.c;
        if ((localObject != null) && (localObject != DescriptorProtos.OneofOptions.getDefaultInstance()))
        {
          this.c = DescriptorProtos.OneofOptions.newBuilder(this.c).a(paramOneofOptions).d();
          break label60;
        }
      }
      this.c = paramOneofOptions;
      label60:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramOneofOptions);
    }
    this.a |= 0x2;
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
    if ((paramMessage instanceof DescriptorProtos.OneofDescriptorProto)) {
      return a((DescriptorProtos.OneofDescriptorProto)paramMessage);
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
  
  public DescriptorProtos.OneofDescriptorProto b()
  {
    return DescriptorProtos.OneofDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.OneofDescriptorProto c()
  {
    DescriptorProtos.OneofDescriptorProto localOneofDescriptorProto = d();
    if (localOneofDescriptorProto.isInitialized()) {
      return localOneofDescriptorProto;
    }
    throw newUninitializedMessageException(localOneofDescriptorProto);
  }
  
  public DescriptorProtos.OneofDescriptorProto d()
  {
    DescriptorProtos.OneofDescriptorProto localOneofDescriptorProto = new DescriptorProtos.OneofDescriptorProto(this, null);
    int k = this.a;
    int i;
    if ((k & 0x1) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    DescriptorProtos.OneofDescriptorProto.access$9102(localOneofDescriptorProto, this.b);
    int j = i;
    if ((k & 0x2) != 0)
    {
      SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.d;
      if (localSingleFieldBuilderV3 == null) {
        DescriptorProtos.OneofDescriptorProto.access$9202(localOneofDescriptorProto, this.c);
      } else {
        DescriptorProtos.OneofDescriptorProto.access$9202(localOneofDescriptorProto, (DescriptorProtos.OneofOptions)localSingleFieldBuilderV3.d());
      }
      j = i | 0x2;
    }
    DescriptorProtos.OneofDescriptorProto.access$9302(localOneofDescriptorProto, j);
    onBuilt();
    return localOneofDescriptorProto;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public boolean f()
  {
    return (this.a & 0x2) != 0;
  }
  
  public DescriptorProtos.OneofOptions g()
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      DescriptorProtos.OneofOptions localOneofOptions = this.c;
      localObject = localOneofOptions;
      if (localOneofOptions == null) {
        localObject = DescriptorProtos.OneofOptions.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.OneofOptions)((SingleFieldBuilderV3)localObject).c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.p();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.q().a(DescriptorProtos.OneofDescriptorProto.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return (!f()) || (g().isInitialized());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.OneofDescriptorProto.Builder
 * JD-Core Version:    0.7.0.1
 */