package com.google.protobuf;

public final class Mixin$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements MixinOrBuilder
{
  private Object a = "";
  private Object b = "";
  
  private Mixin$Builder()
  {
    f();
  }
  
  private Mixin$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    this.b = "";
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 51	com/google/protobuf/Mixin:access$500	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 57 3 0
    //   12: checkcast 47	com/google/protobuf/Mixin
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 60	com/google/protobuf/Mixin$Builder:a	(Lcom/google/protobuf/Mixin;)Lcom/google/protobuf/Mixin$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 64	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 47	com/google/protobuf/Mixin
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 68	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 60	com/google/protobuf/Mixin$Builder:a	(Lcom/google/protobuf/Mixin;)Lcom/google/protobuf/Mixin$Builder;
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
    if ((paramMessage instanceof Mixin)) {
      return a((Mixin)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public Builder a(Mixin paramMixin)
  {
    if (paramMixin == Mixin.getDefaultInstance()) {
      return this;
    }
    if (!paramMixin.getName().isEmpty())
    {
      this.a = Mixin.access$300(paramMixin);
      onChanged();
    }
    if (!paramMixin.getRoot().isEmpty())
    {
      this.b = Mixin.access$400(paramMixin);
      onChanged();
    }
    b(paramMixin.unknownFields);
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
  
  public Mixin b()
  {
    return Mixin.getDefaultInstance();
  }
  
  public Mixin c()
  {
    Mixin localMixin = d();
    if (localMixin.isInitialized()) {
      return localMixin;
    }
    throw newUninitializedMessageException(localMixin);
  }
  
  public Mixin d()
  {
    Mixin localMixin = new Mixin(this, null);
    Mixin.access$302(localMixin, this.a);
    Mixin.access$402(localMixin, this.b);
    onBuilt();
    return localMixin;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return ApiProto.e;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ApiProto.f.a(Mixin.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Mixin.Builder
 * JD-Core Version:    0.7.0.1
 */