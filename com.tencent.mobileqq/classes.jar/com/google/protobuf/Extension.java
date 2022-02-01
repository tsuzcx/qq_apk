package com.google.protobuf;

public abstract class Extension<ContainingType extends MessageLite, Type>
  extends ExtensionLite<ContainingType, Type>
{
  public abstract Message a();
  
  protected abstract Object a(Object paramObject);
  
  public abstract Descriptors.FieldDescriptor b();
  
  protected abstract Object b(Object paramObject);
  
  final boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Extension
 * JD-Core Version:    0.7.0.1
 */