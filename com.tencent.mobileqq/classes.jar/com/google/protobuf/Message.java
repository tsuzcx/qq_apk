package com.google.protobuf;

public abstract interface Message
  extends MessageLite, MessageOrBuilder
{
  public abstract Parser<? extends Message> getParserForType();
  
  public abstract Message.Builder newBuilderForType();
  
  public abstract Message.Builder toBuilder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Message
 * JD-Core Version:    0.7.0.1
 */