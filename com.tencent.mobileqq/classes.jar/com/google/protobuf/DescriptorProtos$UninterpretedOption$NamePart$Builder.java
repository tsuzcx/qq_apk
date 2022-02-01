package com.google.protobuf;

public final class DescriptorProtos$UninterpretedOption$NamePart$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.UninterpretedOption.NamePartOrBuilder
{
  private int a;
  private Object b = "";
  private boolean c;
  
  private DescriptorProtos$UninterpretedOption$NamePart$Builder()
  {
    h();
  }
  
  private DescriptorProtos$UninterpretedOption$NamePart$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    h();
  }
  
  private void h()
  {
    boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = false;
    this.a &= 0xFFFFFFFD;
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 55	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 61 3 0
    //   12: checkcast 51	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 64	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart$Builder:a	(Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart;)Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart$Builder;
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
    //   39: checkcast 51	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 72	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 64	com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart$Builder:a	(Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart;)Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart$Builder;
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
  
  public Builder a(DescriptorProtos.UninterpretedOption.NamePart paramNamePart)
  {
    if (paramNamePart == DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance()) {
      return this;
    }
    if (paramNamePart.hasNamePart())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.UninterpretedOption.NamePart.access$25500(paramNamePart);
      onChanged();
    }
    if (paramNamePart.hasIsExtension()) {
      a(paramNamePart.getIsExtension());
    }
    b(paramNamePart.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.UninterpretedOption.NamePart)) {
      return a((DescriptorProtos.UninterpretedOption.NamePart)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.a |= 0x2;
    this.c = paramBoolean;
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
  
  public DescriptorProtos.UninterpretedOption.NamePart b()
  {
    return DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance();
  }
  
  public DescriptorProtos.UninterpretedOption.NamePart c()
  {
    DescriptorProtos.UninterpretedOption.NamePart localNamePart = d();
    if (localNamePart.isInitialized()) {
      return localNamePart;
    }
    throw newUninitializedMessageException(localNamePart);
  }
  
  public DescriptorProtos.UninterpretedOption.NamePart d()
  {
    DescriptorProtos.UninterpretedOption.NamePart localNamePart = new DescriptorProtos.UninterpretedOption.NamePart(this, null);
    int k = this.a;
    int i;
    if ((k & 0x1) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    DescriptorProtos.UninterpretedOption.NamePart.access$25502(localNamePart, this.b);
    int j = i;
    if ((k & 0x2) != 0)
    {
      DescriptorProtos.UninterpretedOption.NamePart.access$25602(localNamePart, this.c);
      j = i | 0x2;
    }
    DescriptorProtos.UninterpretedOption.NamePart.access$25702(localNamePart, j);
    onBuilt();
    return localNamePart;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public boolean f()
  {
    return (this.a & 0x1) != 0;
  }
  
  public boolean g()
  {
    return (this.a & 0x2) != 0;
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.T();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.U().a(DescriptorProtos.UninterpretedOption.NamePart.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    if (!f()) {
      return false;
    }
    return g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePart.Builder
 * JD-Core Version:    0.7.0.1
 */