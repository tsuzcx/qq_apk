package com.google.protobuf;

class MessageReflection$ExtensionAdapter
  implements MessageReflection.MergeTarget
{
  private final FieldSet<Descriptors.FieldDescriptor> a;
  
  MessageReflection$ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> paramFieldSet)
  {
    this.a = paramFieldSet;
  }
  
  public ExtensionRegistry.ExtensionInfo a(ExtensionRegistry paramExtensionRegistry, Descriptors.Descriptor paramDescriptor, int paramInt)
  {
    return paramExtensionRegistry.b(paramDescriptor, paramInt);
  }
  
  public MessageReflection.MergeTarget.ContainerType a()
  {
    return MessageReflection.MergeTarget.ContainerType.EXTENSION_SET;
  }
  
  public MessageReflection.MergeTarget a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    this.a.a(paramFieldDescriptor, paramObject);
    return this;
  }
  
  public Object a(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.FieldDescriptor paramFieldDescriptor, Message paramMessage)
  {
    paramMessage = paramMessage.newBuilderForType();
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
    paramMessage = paramMessage.newBuilderForType();
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
    return this.a.b(paramFieldDescriptor);
  }
  
  public MessageReflection.MergeTarget b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    this.a.b(paramFieldDescriptor, paramObject);
    return this;
  }
  
  public Object b(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.FieldDescriptor paramFieldDescriptor, Message paramMessage)
  {
    paramMessage = paramMessage.newBuilderForType();
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
    return this.a.a(paramFieldDescriptor);
  }
  
  public WireFormat.Utf8Validation c(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.k()) {
      return WireFormat.Utf8Validation.STRICT;
    }
    return WireFormat.Utf8Validation.LOOSE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageReflection.ExtensionAdapter
 * JD-Core Version:    0.7.0.1
 */