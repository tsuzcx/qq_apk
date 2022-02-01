package com.google.protobuf;

public final class DescriptorProtos$FieldDescriptorProto$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.FieldDescriptorProtoOrBuilder
{
  private int a;
  private Object b = "";
  private int c;
  private int d = 1;
  private int e = 1;
  private Object f = "";
  private Object g = "";
  private Object h = "";
  private int i;
  private Object j = "";
  private DescriptorProtos.FieldOptions k;
  private SingleFieldBuilderV3<DescriptorProtos.FieldOptions, DescriptorProtos.FieldOptions.Builder, DescriptorProtos.FieldOptionsOrBuilder> l;
  
  private DescriptorProtos$FieldDescriptorProto$Builder()
  {
    h();
  }
  
  private DescriptorProtos$FieldDescriptorProto$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
  
  private SingleFieldBuilderV3<DescriptorProtos.FieldOptions, DescriptorProtos.FieldOptions.Builder, DescriptorProtos.FieldOptionsOrBuilder> i()
  {
    if (this.l == null)
    {
      this.l = new SingleFieldBuilderV3(g(), getParentForChildren(), isClean());
      this.k = null;
    }
    return this.l;
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    this.d = 1;
    this.a &= 0xFFFFFFFB;
    this.e = 1;
    this.a &= 0xFFFFFFF7;
    this.f = "";
    this.a &= 0xFFFFFFEF;
    this.g = "";
    this.a &= 0xFFFFFFDF;
    this.h = "";
    this.a &= 0xFFFFFFBF;
    this.i = 0;
    this.a &= 0xFFFFFF7F;
    this.j = "";
    this.a &= 0xFFFFFEFF;
    SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.l;
    if (localSingleFieldBuilderV3 == null) {
      this.k = null;
    } else {
      localSingleFieldBuilderV3.g();
    }
    this.a &= 0xFFFFFDFF;
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
    //   2: getstatic 111	com/google/protobuf/DescriptorProtos$FieldDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 117 3 0
    //   12: checkcast 107	com/google/protobuf/DescriptorProtos$FieldDescriptorProto
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 120	com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 124	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 107	com/google/protobuf/DescriptorProtos$FieldDescriptorProto
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 128	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 120	com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Builder;
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
  
  public Builder a(DescriptorProtos.FieldDescriptorProto.Label paramLabel)
  {
    if (paramLabel != null)
    {
      this.a |= 0x4;
      this.d = paramLabel.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder a(DescriptorProtos.FieldDescriptorProto.Type paramType)
  {
    if (paramType != null)
    {
      this.a |= 0x8;
      this.e = paramType.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder a(DescriptorProtos.FieldDescriptorProto paramFieldDescriptorProto)
  {
    if (paramFieldDescriptorProto == DescriptorProtos.FieldDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (paramFieldDescriptorProto.hasName())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.FieldDescriptorProto.access$7400(paramFieldDescriptorProto);
      onChanged();
    }
    if (paramFieldDescriptorProto.hasNumber()) {
      a(paramFieldDescriptorProto.getNumber());
    }
    if (paramFieldDescriptorProto.hasLabel()) {
      a(paramFieldDescriptorProto.getLabel());
    }
    if (paramFieldDescriptorProto.hasType()) {
      a(paramFieldDescriptorProto.getType());
    }
    if (paramFieldDescriptorProto.hasTypeName())
    {
      this.a |= 0x10;
      this.f = DescriptorProtos.FieldDescriptorProto.access$7800(paramFieldDescriptorProto);
      onChanged();
    }
    if (paramFieldDescriptorProto.hasExtendee())
    {
      this.a |= 0x20;
      this.g = DescriptorProtos.FieldDescriptorProto.access$7900(paramFieldDescriptorProto);
      onChanged();
    }
    if (paramFieldDescriptorProto.hasDefaultValue())
    {
      this.a |= 0x40;
      this.h = DescriptorProtos.FieldDescriptorProto.access$8000(paramFieldDescriptorProto);
      onChanged();
    }
    if (paramFieldDescriptorProto.hasOneofIndex()) {
      b(paramFieldDescriptorProto.getOneofIndex());
    }
    if (paramFieldDescriptorProto.hasJsonName())
    {
      this.a |= 0x100;
      this.j = DescriptorProtos.FieldDescriptorProto.access$8200(paramFieldDescriptorProto);
      onChanged();
    }
    if (paramFieldDescriptorProto.hasOptions()) {
      a(paramFieldDescriptorProto.getOptions());
    }
    b(paramFieldDescriptorProto.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(DescriptorProtos.FieldOptions paramFieldOptions)
  {
    Object localObject = this.l;
    if (localObject == null)
    {
      if ((this.a & 0x200) != 0)
      {
        localObject = this.k;
        if ((localObject != null) && (localObject != DescriptorProtos.FieldOptions.getDefaultInstance()))
        {
          this.k = DescriptorProtos.FieldOptions.newBuilder(this.k).a(paramFieldOptions).d();
          break label62;
        }
      }
      this.k = paramFieldOptions;
      label62:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramFieldOptions);
    }
    this.a |= 0x200;
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
    if ((paramMessage instanceof DescriptorProtos.FieldDescriptorProto)) {
      return a((DescriptorProtos.FieldDescriptorProto)paramMessage);
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
    this.a |= 0x80;
    this.i = paramInt;
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
  
  public DescriptorProtos.FieldDescriptorProto b()
  {
    return DescriptorProtos.FieldDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.FieldDescriptorProto c()
  {
    DescriptorProtos.FieldDescriptorProto localFieldDescriptorProto = d();
    if (localFieldDescriptorProto.isInitialized()) {
      return localFieldDescriptorProto;
    }
    throw newUninitializedMessageException(localFieldDescriptorProto);
  }
  
  public DescriptorProtos.FieldDescriptorProto d()
  {
    DescriptorProtos.FieldDescriptorProto localFieldDescriptorProto = new DescriptorProtos.FieldDescriptorProto(this, null);
    int i1 = this.a;
    if ((i1 & 0x1) != 0) {
      n = 1;
    } else {
      n = 0;
    }
    DescriptorProtos.FieldDescriptorProto.access$7402(localFieldDescriptorProto, this.b);
    int m = n;
    if ((i1 & 0x2) != 0)
    {
      DescriptorProtos.FieldDescriptorProto.access$7502(localFieldDescriptorProto, this.c);
      m = n | 0x2;
    }
    int n = m;
    if ((i1 & 0x4) != 0) {
      n = m | 0x4;
    }
    DescriptorProtos.FieldDescriptorProto.access$7602(localFieldDescriptorProto, this.d);
    m = n;
    if ((i1 & 0x8) != 0) {
      m = n | 0x8;
    }
    DescriptorProtos.FieldDescriptorProto.access$7702(localFieldDescriptorProto, this.e);
    n = m;
    if ((i1 & 0x10) != 0) {
      n = m | 0x10;
    }
    DescriptorProtos.FieldDescriptorProto.access$7802(localFieldDescriptorProto, this.f);
    m = n;
    if ((i1 & 0x20) != 0) {
      m = n | 0x20;
    }
    DescriptorProtos.FieldDescriptorProto.access$7902(localFieldDescriptorProto, this.g);
    n = m;
    if ((i1 & 0x40) != 0) {
      n = m | 0x40;
    }
    DescriptorProtos.FieldDescriptorProto.access$8002(localFieldDescriptorProto, this.h);
    m = n;
    if ((i1 & 0x80) != 0)
    {
      DescriptorProtos.FieldDescriptorProto.access$8102(localFieldDescriptorProto, this.i);
      m = n | 0x80;
    }
    n = m;
    if ((i1 & 0x100) != 0) {
      n = m | 0x100;
    }
    DescriptorProtos.FieldDescriptorProto.access$8202(localFieldDescriptorProto, this.j);
    m = n;
    if ((i1 & 0x200) != 0)
    {
      SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.l;
      if (localSingleFieldBuilderV3 == null) {
        DescriptorProtos.FieldDescriptorProto.access$8302(localFieldDescriptorProto, this.k);
      } else {
        DescriptorProtos.FieldDescriptorProto.access$8302(localFieldDescriptorProto, (DescriptorProtos.FieldOptions)localSingleFieldBuilderV3.d());
      }
      m = n | 0x200;
    }
    DescriptorProtos.FieldDescriptorProto.access$8402(localFieldDescriptorProto, m);
    onBuilt();
    return localFieldDescriptorProto;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public boolean f()
  {
    return (this.a & 0x200) != 0;
  }
  
  public DescriptorProtos.FieldOptions g()
  {
    Object localObject = this.l;
    if (localObject == null)
    {
      DescriptorProtos.FieldOptions localFieldOptions = this.k;
      localObject = localFieldOptions;
      if (localFieldOptions == null) {
        localObject = DescriptorProtos.FieldOptions.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.FieldOptions)((SingleFieldBuilderV3)localObject).c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.n();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.o().a(DescriptorProtos.FieldDescriptorProto.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return (!f()) || (g().isInitialized());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Builder
 * JD-Core Version:    0.7.0.1
 */