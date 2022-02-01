package com.google.protobuf;

import java.util.Map;

public abstract interface MessageOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract Map<Descriptors.FieldDescriptor, Object> getAllFields();
  
  public abstract Message getDefaultInstanceForType();
  
  public abstract Descriptors.Descriptor getDescriptorForType();
  
  public abstract Object getField(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract UnknownFieldSet getUnknownFields();
  
  public abstract boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageOrBuilder
 * JD-Core Version:    0.7.0.1
 */