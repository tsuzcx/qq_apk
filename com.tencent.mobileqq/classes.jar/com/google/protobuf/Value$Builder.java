package com.google.protobuf;

public final class Value$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements ValueOrBuilder
{
  private int a = 0;
  private Object b;
  private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> c;
  private SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> d;
  
  private Value$Builder()
  {
    f();
  }
  
  private Value$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    this.a = 0;
    this.b = null;
    return this;
  }
  
  public Builder a(double paramDouble)
  {
    this.a = 2;
    this.b = Double.valueOf(paramDouble);
    onChanged();
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.a = 1;
    this.b = Integer.valueOf(paramInt);
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 71	com/google/protobuf/Value:access$500	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 77 3 0
    //   12: checkcast 67	com/google/protobuf/Value
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 80	com/google/protobuf/Value$Builder:a	(Lcom/google/protobuf/Value;)Lcom/google/protobuf/Value$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 84	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 67	com/google/protobuf/Value
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 88	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 80	com/google/protobuf/Value$Builder:a	(Lcom/google/protobuf/Value;)Lcom/google/protobuf/Value$Builder;
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
  
  public Builder a(ListValue paramListValue)
  {
    SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.d;
    if (localSingleFieldBuilderV3 == null)
    {
      if ((this.a == 6) && (this.b != ListValue.getDefaultInstance())) {
        this.b = ListValue.newBuilder((ListValue)this.b).a(paramListValue).d();
      } else {
        this.b = paramListValue;
      }
      onChanged();
    }
    else
    {
      if (this.a == 6) {
        localSingleFieldBuilderV3.b(paramListValue);
      }
      this.d.a(paramListValue);
    }
    this.a = 6;
    return this;
  }
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof Value)) {
      return a((Value)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public Builder a(Struct paramStruct)
  {
    SingleFieldBuilderV3 localSingleFieldBuilderV3 = this.c;
    if (localSingleFieldBuilderV3 == null)
    {
      if ((this.a == 5) && (this.b != Struct.getDefaultInstance())) {
        this.b = Struct.newBuilder((Struct)this.b).a(paramStruct).d();
      } else {
        this.b = paramStruct;
      }
      onChanged();
    }
    else
    {
      if (this.a == 5) {
        localSingleFieldBuilderV3.b(paramStruct);
      }
      this.c.a(paramStruct);
    }
    this.a = 5;
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(Value paramValue)
  {
    if (paramValue == Value.getDefaultInstance()) {
      return this;
    }
    switch (Value.2.a[paramValue.getKindCase().ordinal()])
    {
    default: 
      break;
    case 6: 
      a(paramValue.getListValue());
      break;
    case 5: 
      a(paramValue.getStructValue());
      break;
    case 4: 
      a(paramValue.getBoolValue());
      break;
    case 3: 
      this.a = 3;
      this.b = Value.access$300(paramValue);
      onChanged();
      break;
    case 2: 
      a(paramValue.getNumberValue());
      break;
    case 1: 
      a(paramValue.getNullValueValue());
    }
    b(paramValue.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.a = 4;
    this.b = Boolean.valueOf(paramBoolean);
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
  
  public Value b()
  {
    return Value.getDefaultInstance();
  }
  
  public Value c()
  {
    Value localValue = d();
    if (localValue.isInitialized()) {
      return localValue;
    }
    throw newUninitializedMessageException(localValue);
  }
  
  public Value d()
  {
    Value localValue = new Value(this, null);
    if (this.a == 1) {
      Value.access$302(localValue, this.b);
    }
    if (this.a == 2) {
      Value.access$302(localValue, this.b);
    }
    if (this.a == 3) {
      Value.access$302(localValue, this.b);
    }
    if (this.a == 4) {
      Value.access$302(localValue, this.b);
    }
    SingleFieldBuilderV3 localSingleFieldBuilderV3;
    if (this.a == 5)
    {
      localSingleFieldBuilderV3 = this.c;
      if (localSingleFieldBuilderV3 == null) {
        Value.access$302(localValue, this.b);
      } else {
        Value.access$302(localValue, localSingleFieldBuilderV3.d());
      }
    }
    if (this.a == 6)
    {
      localSingleFieldBuilderV3 = this.d;
      if (localSingleFieldBuilderV3 == null) {
        Value.access$302(localValue, this.b);
      } else {
        Value.access$302(localValue, localSingleFieldBuilderV3.d());
      }
    }
    Value.access$402(localValue, this.a);
    onBuilt();
    return localValue;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return StructProto.e;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return StructProto.f.a(Value.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Value.Builder
 * JD-Core Version:    0.7.0.1
 */