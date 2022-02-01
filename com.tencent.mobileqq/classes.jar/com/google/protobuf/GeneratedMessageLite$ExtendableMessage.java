package com.google.protobuf;

public abstract class GeneratedMessageLite$ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends GeneratedMessageLite.ExtendableBuilder<MessageType, BuilderType>>
  extends GeneratedMessageLite<MessageType, BuilderType>
  implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType, BuilderType>
{
  protected FieldSet<GeneratedMessageLite.ExtensionDescriptor> c = FieldSet.b();
  
  FieldSet<GeneratedMessageLite.ExtensionDescriptor> e()
  {
    if (this.c.e()) {
      this.c = this.c.f();
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageLite.ExtendableMessage
 * JD-Core Version:    0.7.0.1
 */