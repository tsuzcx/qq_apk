package com.google.protobuf;

public final class DescriptorProtos$GeneratedCodeInfo$Annotation$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
{
  private int a;
  private Internal.IntList b = GeneratedMessageV3.emptyIntList();
  private Object c = "";
  private int d;
  private int e;
  
  private DescriptorProtos$GeneratedCodeInfo$Annotation$Builder()
  {
    f();
  }
  
  private DescriptorProtos$GeneratedCodeInfo$Annotation$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
  }
  
  private void g()
  {
    if ((this.a & 0x1) == 0)
    {
      this.b = GeneratedMessageV3.mutableCopy(this.b);
      this.a |= 0x1;
    }
  }
  
  public Builder a()
  {
    super.clear();
    this.b = GeneratedMessageV3.emptyIntList();
    this.a &= 0xFFFFFFFE;
    this.c = "";
    this.a &= 0xFFFFFFFD;
    this.d = 0;
    this.a &= 0xFFFFFFFB;
    this.e = 0;
    this.a &= 0xFFFFFFF7;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.a |= 0x4;
    this.d = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 75	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 81 3 0
    //   12: checkcast 71	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 84	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Builder:a	(Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation;)Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 88	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 71	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 92	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 84	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Builder:a	(Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation;)Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Annotation$Builder;
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
  
  public Builder a(DescriptorProtos.GeneratedCodeInfo.Annotation paramAnnotation)
  {
    if (paramAnnotation == DescriptorProtos.GeneratedCodeInfo.Annotation.getDefaultInstance()) {
      return this;
    }
    if (!DescriptorProtos.GeneratedCodeInfo.Annotation.access$29700(paramAnnotation).isEmpty())
    {
      if (this.b.isEmpty())
      {
        this.b = DescriptorProtos.GeneratedCodeInfo.Annotation.access$29700(paramAnnotation);
        this.a &= 0xFFFFFFFE;
      }
      else
      {
        g();
        this.b.addAll(DescriptorProtos.GeneratedCodeInfo.Annotation.access$29700(paramAnnotation));
      }
      onChanged();
    }
    if (paramAnnotation.hasSourceFile())
    {
      this.a |= 0x2;
      this.c = DescriptorProtos.GeneratedCodeInfo.Annotation.access$29800(paramAnnotation);
      onChanged();
    }
    if (paramAnnotation.hasBegin()) {
      a(paramAnnotation.getBegin());
    }
    if (paramAnnotation.hasEnd()) {
      b(paramAnnotation.getEnd());
    }
    b(paramAnnotation.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.GeneratedCodeInfo.Annotation)) {
      return a((DescriptorProtos.GeneratedCodeInfo.Annotation)paramMessage);
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
    this.a |= 0x8;
    this.e = paramInt;
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
  
  public DescriptorProtos.GeneratedCodeInfo.Annotation b()
  {
    return DescriptorProtos.GeneratedCodeInfo.Annotation.getDefaultInstance();
  }
  
  public DescriptorProtos.GeneratedCodeInfo.Annotation c()
  {
    DescriptorProtos.GeneratedCodeInfo.Annotation localAnnotation = d();
    if (localAnnotation.isInitialized()) {
      return localAnnotation;
    }
    throw newUninitializedMessageException(localAnnotation);
  }
  
  public DescriptorProtos.GeneratedCodeInfo.Annotation d()
  {
    DescriptorProtos.GeneratedCodeInfo.Annotation localAnnotation = new DescriptorProtos.GeneratedCodeInfo.Annotation(this, null);
    int k = this.a;
    if ((k & 0x1) != 0)
    {
      this.b.b();
      this.a &= 0xFFFFFFFE;
    }
    DescriptorProtos.GeneratedCodeInfo.Annotation.access$29702(localAnnotation, this.b);
    if ((k & 0x2) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    DescriptorProtos.GeneratedCodeInfo.Annotation.access$29802(localAnnotation, this.c);
    int i = j;
    if ((k & 0x4) != 0)
    {
      DescriptorProtos.GeneratedCodeInfo.Annotation.access$29902(localAnnotation, this.d);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x8) != 0)
    {
      DescriptorProtos.GeneratedCodeInfo.Annotation.access$30002(localAnnotation, this.e);
      j = i | 0x4;
    }
    DescriptorProtos.GeneratedCodeInfo.Annotation.access$30102(localAnnotation, j);
    onBuilt();
    return localAnnotation;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.ab();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.ac().a(DescriptorProtos.GeneratedCodeInfo.Annotation.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation.Builder
 * JD-Core Version:    0.7.0.1
 */