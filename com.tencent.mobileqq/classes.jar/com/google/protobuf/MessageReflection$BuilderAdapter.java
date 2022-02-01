package com.google.protobuf;

class MessageReflection$BuilderAdapter
  implements MessageReflection.MergeTarget
{
  private final Message.Builder a;
  
  public MessageReflection$BuilderAdapter(Message.Builder paramBuilder)
  {
    this.a = paramBuilder;
  }
  
  public ExtensionRegistry.ExtensionInfo a(ExtensionRegistry paramExtensionRegistry, Descriptors.Descriptor paramDescriptor, int paramInt)
  {
    return paramExtensionRegistry.b(paramDescriptor, paramInt);
  }
  
  public MessageReflection.MergeTarget.ContainerType a()
  {
    return MessageReflection.MergeTarget.ContainerType.MESSAGE;
  }
  
  public MessageReflection.MergeTarget a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    this.a.setField(paramFieldDescriptor, paramObject);
    return this;
  }
  
  public Object a(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.FieldDescriptor paramFieldDescriptor, Message paramMessage)
  {
    if (paramMessage != null) {
      paramMessage = paramMessage.newBuilderForType();
    } else {
      paramMessage = this.a.newBuilderForField(paramFieldDescriptor);
    }
    if (!paramFieldDescriptor.p())
    {
      paramFieldDescriptor = (Message)a(paramFieldDescriptor);
      if (paramFieldDescriptor != null) {
        paramMessage.mergeFrom(paramFieldDescriptor);
      }
    }
    paramMessage.mergeFrom(paramByteString, paramExtensionRegistryLite);
    return paramMessage.buildPartial();
  }
  
  public Object a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.FieldDescriptor paramFieldDescriptor, Message paramMessage)
  {
    if (paramMessage != null) {
      paramMessage = paramMessage.newBuilderForType();
    } else {
      paramMessage = this.a.newBuilderForField(paramFieldDescriptor);
    }
    if (!paramFieldDescriptor.p())
    {
      Message localMessage = (Message)a(paramFieldDescriptor);
      if (localMessage != null) {
        paramMessage.mergeFrom(localMessage);
      }
    }
    paramCodedInputStream.a(paramFieldDescriptor.f(), paramMessage, paramExtensionRegistryLite);
    return paramMessage.buildPartial();
  }
  
  public Object a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return this.a.getField(paramFieldDescriptor);
  }
  
  public MessageReflection.MergeTarget b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    this.a.addRepeatedField(paramFieldDescriptor, paramObject);
    return this;
  }
  
  public Object b(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.FieldDescriptor paramFieldDescriptor, Message paramMessage)
  {
    if (paramMessage != null) {
      paramMessage = paramMessage.newBuilderForType();
    } else {
      paramMessage = this.a.newBuilderForField(paramFieldDescriptor);
    }
    if (!paramFieldDescriptor.p())
    {
      paramFieldDescriptor = (Message)a(paramFieldDescriptor);
      if (paramFieldDescriptor != null) {
        paramMessage.mergeFrom(paramFieldDescriptor);
      }
    }
    paramCodedInputStream.a(paramMessage, paramExtensionRegistryLite);
    return paramMessage.buildPartial();
  }
  
  public boolean b(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return this.a.hasField(paramFieldDescriptor);
  }
  
  public WireFormat.Utf8Validation c(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.k()) {
      return WireFormat.Utf8Validation.STRICT;
    }
    if ((!paramFieldDescriptor.p()) && ((this.a instanceof GeneratedMessage.Builder))) {
      return WireFormat.Utf8Validation.LAZY;
    }
    return WireFormat.Utf8Validation.LOOSE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageReflection.BuilderAdapter
 * JD-Core Version:    0.7.0.1
 */