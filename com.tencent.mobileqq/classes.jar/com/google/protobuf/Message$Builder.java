package com.google.protobuf;

public abstract interface Message$Builder
  extends MessageLite.Builder, MessageOrBuilder
{
  public abstract Builder addRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject);
  
  public abstract Message build();
  
  public abstract Message buildPartial();
  
  public abstract Builder clearField(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract Descriptors.Descriptor getDescriptorForType();
  
  public abstract Builder mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract Builder mergeFrom(Message paramMessage);
  
  public abstract Builder newBuilderForField(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract Builder setField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject);
  
  public abstract Builder setUnknownFields(UnknownFieldSet paramUnknownFieldSet);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Message.Builder
 * JD-Core Version:    0.7.0.1
 */