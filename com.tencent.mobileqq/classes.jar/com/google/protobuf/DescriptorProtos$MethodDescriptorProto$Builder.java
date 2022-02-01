package com.google.protobuf;

public final class DescriptorProtos$MethodDescriptorProto$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.MethodDescriptorProtoOrBuilder
{
  private int a;
  private Object b = "";
  private Object c = "";
  private Object d = "";
  private DescriptorProtos.MethodOptions e;
  private SingleFieldBuilderV3<DescriptorProtos.MethodOptions, DescriptorProtos.MethodOptions.Builder, DescriptorProtos.MethodOptionsOrBuilder> f;
  private boolean g;
  private boolean h;
  
  private DescriptorProtos$MethodDescriptorProto$Builder()
  {
    h();
  }
  
  private DescriptorProtos$MethodDescriptorProto$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
  
  private SingleFieldBuilderV3<DescriptorProtos.MethodOptions, DescriptorProtos.MethodOptions.Builder, DescriptorProtos.MethodOptionsOrBuilder> i()
  {
    if (this.f == null)
    {
      this.f = new SingleFieldBuilderV3(g(), getParentForChildren(), isClean());
      this.e = null;
    }
    return this.f;
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = "";
    this.a &= 0xFFFFFFFD;
    this.d = "";
    this.a &= 0xFFFFFFFB;
    SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.f;
    if (localSingleFieldBuilderV3 == null) {
      this.e = null;
    } else {
      localSingleFieldBuilderV3.g();
    }
    this.a &= 0xFFFFFFF7;
    this.g = false;
    this.a &= 0xFFFFFFEF;
    this.h = false;
    this.a &= 0xFFFFFFDF;
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 96	com/google/protobuf/DescriptorProtos$MethodDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 102 3 0
    //   12: checkcast 92	com/google/protobuf/DescriptorProtos$MethodDescriptorProto
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 105	com/google/protobuf/DescriptorProtos$MethodDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 109	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 92	com/google/protobuf/DescriptorProtos$MethodDescriptorProto
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 113	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 105	com/google/protobuf/DescriptorProtos$MethodDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto$Builder;
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
  
  public Builder a(DescriptorProtos.MethodDescriptorProto paramMethodDescriptorProto)
  {
    if (paramMethodDescriptorProto == DescriptorProtos.MethodDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (paramMethodDescriptorProto.hasName())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.MethodDescriptorProto.access$14100(paramMethodDescriptorProto);
      onChanged();
    }
    if (paramMethodDescriptorProto.hasInputType())
    {
      this.a |= 0x2;
      this.c = DescriptorProtos.MethodDescriptorProto.access$14200(paramMethodDescriptorProto);
      onChanged();
    }
    if (paramMethodDescriptorProto.hasOutputType())
    {
      this.a |= 0x4;
      this.d = DescriptorProtos.MethodDescriptorProto.access$14300(paramMethodDescriptorProto);
      onChanged();
    }
    if (paramMethodDescriptorProto.hasOptions()) {
      a(paramMethodDescriptorProto.getOptions());
    }
    if (paramMethodDescriptorProto.hasClientStreaming()) {
      a(paramMethodDescriptorProto.getClientStreaming());
    }
    if (paramMethodDescriptorProto.hasServerStreaming()) {
      b(paramMethodDescriptorProto.getServerStreaming());
    }
    b(paramMethodDescriptorProto.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(DescriptorProtos.MethodOptions paramMethodOptions)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if ((this.a & 0x8) != 0)
      {
        localObject = this.e;
        if ((localObject != null) && (localObject != DescriptorProtos.MethodOptions.getDefaultInstance()))
        {
          this.e = DescriptorProtos.MethodOptions.newBuilder(this.e).a(paramMethodOptions).d();
          break label61;
        }
      }
      this.e = paramMethodOptions;
      label61:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramMethodOptions);
    }
    this.a |= 0x8;
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
    if ((paramMessage instanceof DescriptorProtos.MethodDescriptorProto)) {
      return a((DescriptorProtos.MethodDescriptorProto)paramMessage);
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
    this.a |= 0x10;
    this.g = paramBoolean;
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
  
  public Builder b(boolean paramBoolean)
  {
    this.a |= 0x20;
    this.h = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.MethodDescriptorProto b()
  {
    return DescriptorProtos.MethodDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.MethodDescriptorProto c()
  {
    DescriptorProtos.MethodDescriptorProto localMethodDescriptorProto = d();
    if (localMethodDescriptorProto.isInitialized()) {
      return localMethodDescriptorProto;
    }
    throw newUninitializedMessageException(localMethodDescriptorProto);
  }
  
  public DescriptorProtos.MethodDescriptorProto d()
  {
    DescriptorProtos.MethodDescriptorProto localMethodDescriptorProto = new DescriptorProtos.MethodDescriptorProto(this, null);
    int k = this.a;
    if ((k & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    DescriptorProtos.MethodDescriptorProto.access$14102(localMethodDescriptorProto, this.b);
    int i = j;
    if ((k & 0x2) != 0) {
      i = j | 0x2;
    }
    DescriptorProtos.MethodDescriptorProto.access$14202(localMethodDescriptorProto, this.c);
    int j = i;
    if ((k & 0x4) != 0) {
      j = i | 0x4;
    }
    DescriptorProtos.MethodDescriptorProto.access$14302(localMethodDescriptorProto, this.d);
    i = j;
    if ((k & 0x8) != 0)
    {
      SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.f;
      if (localSingleFieldBuilderV3 == null) {
        DescriptorProtos.MethodDescriptorProto.access$14402(localMethodDescriptorProto, this.e);
      } else {
        DescriptorProtos.MethodDescriptorProto.access$14402(localMethodDescriptorProto, (DescriptorProtos.MethodOptions)localSingleFieldBuilderV3.d());
      }
      i = j | 0x8;
    }
    j = i;
    if ((k & 0x10) != 0)
    {
      DescriptorProtos.MethodDescriptorProto.access$14502(localMethodDescriptorProto, this.g);
      j = i | 0x10;
    }
    i = j;
    if ((k & 0x20) != 0)
    {
      DescriptorProtos.MethodDescriptorProto.access$14602(localMethodDescriptorProto, this.h);
      i = j | 0x20;
    }
    DescriptorProtos.MethodDescriptorProto.access$14702(localMethodDescriptorProto, i);
    onBuilt();
    return localMethodDescriptorProto;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public boolean f()
  {
    return (this.a & 0x8) != 0;
  }
  
  public DescriptorProtos.MethodOptions g()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      DescriptorProtos.MethodOptions localMethodOptions = this.e;
      localObject = localMethodOptions;
      if (localMethodOptions == null) {
        localObject = DescriptorProtos.MethodOptions.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.MethodOptions)((SingleFieldBuilderV3)localObject).c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.z();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.A().a(DescriptorProtos.MethodDescriptorProto.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return (!f()) || (g().isInitialized());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.MethodDescriptorProto.Builder
 * JD-Core Version:    0.7.0.1
 */