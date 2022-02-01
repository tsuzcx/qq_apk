package com.google.protobuf;

public final class Option$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements OptionOrBuilder
{
  private Object a = "";
  private Any b;
  private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> c;
  
  private Option$Builder()
  {
    f();
  }
  
  private Option$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    this.a = "";
    if (this.c == null)
    {
      this.b = null;
      return this;
    }
    this.b = null;
    this.c = null;
    return this;
  }
  
  public Builder a(Any paramAny)
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      localObject = this.b;
      if (localObject != null) {
        this.b = Any.newBuilder((Any)localObject).a(paramAny).d();
      } else {
        this.b = paramAny;
      }
      onChanged();
      return this;
    }
    ((SingleFieldBuilderV3)localObject).b(paramAny);
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 80	com/google/protobuf/Option:access$500	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 86 3 0
    //   12: checkcast 76	com/google/protobuf/Option
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 89	com/google/protobuf/Option$Builder:a	(Lcom/google/protobuf/Option;)Lcom/google/protobuf/Option$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 93	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 76	com/google/protobuf/Option
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 97	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 89	com/google/protobuf/Option$Builder:a	(Lcom/google/protobuf/Option;)Lcom/google/protobuf/Option$Builder;
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
    if ((paramMessage instanceof Option)) {
      return a((Option)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public Builder a(Option paramOption)
  {
    if (paramOption == Option.getDefaultInstance()) {
      return this;
    }
    if (!paramOption.getName().isEmpty())
    {
      this.a = Option.access$300(paramOption);
      onChanged();
    }
    if (paramOption.hasValue()) {
      a(paramOption.getValue());
    }
    b(paramOption.unknownFields);
    onChanged();
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
  
  public Option b()
  {
    return Option.getDefaultInstance();
  }
  
  public Option c()
  {
    Option localOption = d();
    if (localOption.isInitialized()) {
      return localOption;
    }
    throw newUninitializedMessageException(localOption);
  }
  
  public Option d()
  {
    Option localOption = new Option(this, null);
    Option.access$302(localOption, this.a);
    SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.c;
    if (localSingleFieldBuilderV3 == null) {
      Option.access$402(localOption, this.b);
    } else {
      Option.access$402(localOption, (Any)localSingleFieldBuilderV3.d());
    }
    onBuilt();
    return localOption;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return TypeProto.i;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.j.a(Option.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Option.Builder
 * JD-Core Version:    0.7.0.1
 */