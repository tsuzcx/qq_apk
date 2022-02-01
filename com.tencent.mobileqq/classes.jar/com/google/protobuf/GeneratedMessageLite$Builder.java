package com.google.protobuf;

public abstract class GeneratedMessageLite$Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>>
  extends AbstractMessageLite.Builder<MessageType, BuilderType>
{
  protected MessageType a;
  protected boolean b;
  private final MessageType c;
  
  private void a(MessageType paramMessageType1, MessageType paramMessageType2)
  {
    Protobuf.a().a(paramMessageType1).b(paramMessageType1, paramMessageType2);
  }
  
  public BuilderType a(MessageType paramMessageType)
  {
    a();
    a(this.a, paramMessageType);
    return this;
  }
  
  protected void a()
  {
    if (this.b)
    {
      GeneratedMessageLite localGeneratedMessageLite = (GeneratedMessageLite)this.a.a(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
      a(localGeneratedMessageLite, this.a);
      this.a = localGeneratedMessageLite;
      this.b = false;
    }
  }
  
  public BuilderType b()
  {
    Builder localBuilder = d().b();
    localBuilder.a(c());
    return localBuilder;
  }
  
  public MessageType c()
  {
    if (this.b) {
      return this.a;
    }
    this.a.c();
    this.b = true;
    return this.a;
  }
  
  public MessageType d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageLite.Builder
 * JD-Core Version:    0.7.0.1
 */