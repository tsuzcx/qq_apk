package com.google.protobuf;

abstract interface MessageReflection$MergeTarget
{
  public abstract ExtensionRegistry.ExtensionInfo a(ExtensionRegistry paramExtensionRegistry, Descriptors.Descriptor paramDescriptor, int paramInt);
  
  public abstract MessageReflection.MergeTarget.ContainerType a();
  
  public abstract MergeTarget a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject);
  
  public abstract Object a(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.FieldDescriptor paramFieldDescriptor, Message paramMessage);
  
  public abstract Object a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.FieldDescriptor paramFieldDescriptor, Message paramMessage);
  
  public abstract MergeTarget b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject);
  
  public abstract Object b(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.FieldDescriptor paramFieldDescriptor, Message paramMessage);
  
  public abstract boolean b(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract WireFormat.Utf8Validation c(Descriptors.FieldDescriptor paramFieldDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageReflection.MergeTarget
 * JD-Core Version:    0.7.0.1
 */