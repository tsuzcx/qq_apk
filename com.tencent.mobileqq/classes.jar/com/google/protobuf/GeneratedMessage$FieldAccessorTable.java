package com.google.protobuf;

public final class GeneratedMessage$FieldAccessorTable
{
  private final Descriptors.Descriptor a;
  private final GeneratedMessage.FieldAccessorTable.FieldAccessor[] b;
  private final GeneratedMessage.FieldAccessorTable.OneofAccessor[] c;
  
  private GeneratedMessage.FieldAccessorTable.FieldAccessor a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.v() == this.a)
    {
      if (!paramFieldDescriptor.u()) {
        return this.b[paramFieldDescriptor.a()];
      }
      throw new IllegalArgumentException("This type does not have extensions.");
    }
    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
  }
  
  private GeneratedMessage.FieldAccessorTable.OneofAccessor a(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    if (paramOneofDescriptor.c() == this.a) {
      return this.c[paramOneofDescriptor.a()];
    }
    throw new IllegalArgumentException("OneofDescriptor does not match message type.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.FieldAccessorTable
 * JD-Core Version:    0.7.0.1
 */