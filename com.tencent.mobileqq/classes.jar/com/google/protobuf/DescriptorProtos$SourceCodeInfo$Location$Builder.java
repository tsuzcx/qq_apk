package com.google.protobuf;

public final class DescriptorProtos$SourceCodeInfo$Location$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.SourceCodeInfo.LocationOrBuilder
{
  private int a;
  private Internal.IntList b = GeneratedMessageV3.emptyIntList();
  private Internal.IntList c = GeneratedMessageV3.emptyIntList();
  private Object d = "";
  private Object e = "";
  private LazyStringList f = LazyStringArrayList.a;
  
  private DescriptorProtos$SourceCodeInfo$Location$Builder()
  {
    f();
  }
  
  private DescriptorProtos$SourceCodeInfo$Location$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
  
  private void h()
  {
    if ((this.a & 0x2) == 0)
    {
      this.c = GeneratedMessageV3.mutableCopy(this.c);
      this.a |= 0x2;
    }
  }
  
  private void i()
  {
    if ((this.a & 0x10) == 0)
    {
      this.f = new LazyStringArrayList(this.f);
      this.a |= 0x10;
    }
  }
  
  public Builder a()
  {
    super.clear();
    this.b = GeneratedMessageV3.emptyIntList();
    this.a &= 0xFFFFFFFE;
    this.c = GeneratedMessageV3.emptyIntList();
    this.a &= 0xFFFFFFFD;
    this.d = "";
    this.a &= 0xFFFFFFFB;
    this.e = "";
    this.a &= 0xFFFFFFF7;
    this.f = LazyStringArrayList.a;
    this.a &= 0xFFFFFFEF;
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 83	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 89 3 0
    //   12: checkcast 79	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 92	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location$Builder:a	(Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location;)Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 96	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 79	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 100	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 92	com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location$Builder:a	(Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location;)Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location$Builder;
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
  
  public Builder a(DescriptorProtos.SourceCodeInfo.Location paramLocation)
  {
    if (paramLocation == DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance()) {
      return this;
    }
    if (!DescriptorProtos.SourceCodeInfo.Location.access$27800(paramLocation).isEmpty())
    {
      if (this.b.isEmpty())
      {
        this.b = DescriptorProtos.SourceCodeInfo.Location.access$27800(paramLocation);
        this.a &= 0xFFFFFFFE;
      }
      else
      {
        g();
        this.b.addAll(DescriptorProtos.SourceCodeInfo.Location.access$27800(paramLocation));
      }
      onChanged();
    }
    if (!DescriptorProtos.SourceCodeInfo.Location.access$27900(paramLocation).isEmpty())
    {
      if (this.c.isEmpty())
      {
        this.c = DescriptorProtos.SourceCodeInfo.Location.access$27900(paramLocation);
        this.a &= 0xFFFFFFFD;
      }
      else
      {
        h();
        this.c.addAll(DescriptorProtos.SourceCodeInfo.Location.access$27900(paramLocation));
      }
      onChanged();
    }
    if (paramLocation.hasLeadingComments())
    {
      this.a |= 0x4;
      this.d = DescriptorProtos.SourceCodeInfo.Location.access$28000(paramLocation);
      onChanged();
    }
    if (paramLocation.hasTrailingComments())
    {
      this.a |= 0x8;
      this.e = DescriptorProtos.SourceCodeInfo.Location.access$28100(paramLocation);
      onChanged();
    }
    if (!DescriptorProtos.SourceCodeInfo.Location.access$28200(paramLocation).isEmpty())
    {
      if (this.f.isEmpty())
      {
        this.f = DescriptorProtos.SourceCodeInfo.Location.access$28200(paramLocation);
        this.a &= 0xFFFFFFEF;
      }
      else
      {
        i();
        this.f.addAll(DescriptorProtos.SourceCodeInfo.Location.access$28200(paramLocation));
      }
      onChanged();
    }
    b(paramLocation.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.SourceCodeInfo.Location)) {
      return a((DescriptorProtos.SourceCodeInfo.Location)paramMessage);
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
  
  public DescriptorProtos.SourceCodeInfo.Location b()
  {
    return DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance();
  }
  
  public DescriptorProtos.SourceCodeInfo.Location c()
  {
    DescriptorProtos.SourceCodeInfo.Location localLocation = d();
    if (localLocation.isInitialized()) {
      return localLocation;
    }
    throw newUninitializedMessageException(localLocation);
  }
  
  public DescriptorProtos.SourceCodeInfo.Location d()
  {
    DescriptorProtos.SourceCodeInfo.Location localLocation = new DescriptorProtos.SourceCodeInfo.Location(this, null);
    int k = this.a;
    if ((k & 0x1) != 0)
    {
      this.b.b();
      this.a &= 0xFFFFFFFE;
    }
    DescriptorProtos.SourceCodeInfo.Location.access$27802(localLocation, this.b);
    if ((this.a & 0x2) != 0)
    {
      this.c.b();
      this.a &= 0xFFFFFFFD;
    }
    DescriptorProtos.SourceCodeInfo.Location.access$27902(localLocation, this.c);
    int i;
    if ((k & 0x4) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    DescriptorProtos.SourceCodeInfo.Location.access$28002(localLocation, this.d);
    int j = i;
    if ((k & 0x8) != 0) {
      j = i | 0x2;
    }
    DescriptorProtos.SourceCodeInfo.Location.access$28102(localLocation, this.e);
    if ((this.a & 0x10) != 0)
    {
      this.f = this.f.e();
      this.a &= 0xFFFFFFEF;
    }
    DescriptorProtos.SourceCodeInfo.Location.access$28202(localLocation, this.f);
    DescriptorProtos.SourceCodeInfo.Location.access$28302(localLocation, j);
    onBuilt();
    return localLocation;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.X();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.Y().a(DescriptorProtos.SourceCodeInfo.Location.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location.Builder
 * JD-Core Version:    0.7.0.1
 */