package com.google.protobuf;

public abstract class GeneratedMessage$ExtendableBuilder<MessageType extends GeneratedMessage.ExtendableMessage, BuilderType extends ExtendableBuilder<MessageType, BuilderType>>
  extends GeneratedMessage.Builder<BuilderType>
  implements GeneratedMessage.ExtendableMessageOrBuilder<MessageType>
{
  private FieldSet<Descriptors.FieldDescriptor> a = FieldSet.b();
  
  private FieldSet<Descriptors.FieldDescriptor> d()
  {
    this.a.d();
    return this.a;
  }
  
  public BuilderType c()
  {
    return (ExtendableBuilder)super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.ExtendableBuilder
 * JD-Core Version:    0.7.0.1
 */