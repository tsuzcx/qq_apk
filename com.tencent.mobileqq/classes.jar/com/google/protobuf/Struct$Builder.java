package com.google.protobuf;

public final class Struct$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements StructOrBuilder
{
  private int a;
  private MapField<String, Value> b;
  
  private Struct$Builder()
  {
    f();
  }
  
  private Struct$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    boolean bool = GeneratedMessageV3.alwaysUseFieldBuilders;
  }
  
  private MapField<String, Value> g()
  {
    MapField localMapField2 = this.b;
    MapField localMapField1 = localMapField2;
    if (localMapField2 == null) {
      localMapField1 = MapField.a(Struct.FieldsDefaultEntryHolder.a);
    }
    return localMapField1;
  }
  
  private MapField<String, Value> h()
  {
    onChanged();
    if (this.b == null) {
      this.b = MapField.b(Struct.FieldsDefaultEntryHolder.a);
    }
    if (!this.b.i()) {
      this.b = this.b.d();
    }
    return this.b;
  }
  
  public Builder a()
  {
    super.clear();
    h().c();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 81	com/google/protobuf/Struct:access$500	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 87 3 0
    //   12: checkcast 77	com/google/protobuf/Struct
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 90	com/google/protobuf/Struct$Builder:a	(Lcom/google/protobuf/Struct;)Lcom/google/protobuf/Struct$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 94	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 77	com/google/protobuf/Struct
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 98	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 90	com/google/protobuf/Struct$Builder:a	(Lcom/google/protobuf/Struct;)Lcom/google/protobuf/Struct$Builder;
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
    if ((paramMessage instanceof Struct)) {
      return a((Struct)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public Builder a(Struct paramStruct)
  {
    if (paramStruct == Struct.getDefaultInstance()) {
      return this;
    }
    h().a(Struct.access$400(paramStruct));
    b(paramStruct.unknownFields);
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
  
  public Struct b()
  {
    return Struct.getDefaultInstance();
  }
  
  public Struct c()
  {
    Struct localStruct = d();
    if (localStruct.isInitialized()) {
      return localStruct;
    }
    throw newUninitializedMessageException(localStruct);
  }
  
  public Struct d()
  {
    Struct localStruct = new Struct(this, null);
    int i = this.a;
    Struct.access$302(localStruct, g());
    Struct.access$300(localStruct).h();
    onBuilt();
    return localStruct;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return StructProto.a;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return StructProto.b.a(Struct.class, Builder.class);
  }
  
  protected MapField internalGetMapField(int paramInt)
  {
    if (paramInt == 1) {
      return g();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid map field number: ");
    localStringBuilder.append(paramInt);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  protected MapField internalGetMutableMapField(int paramInt)
  {
    if (paramInt == 1) {
      return h();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid map field number: ");
    localStringBuilder.append(paramInt);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Struct.Builder
 * JD-Core Version:    0.7.0.1
 */