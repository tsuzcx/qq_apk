package com.google.protobuf;

public abstract interface MessageLite
  extends MessageLiteOrBuilder
{
  public abstract Parser<? extends MessageLite> getParserForType();
  
  public abstract int getSerializedSize();
  
  public abstract MessageLite.Builder newBuilderForType();
  
  public abstract MessageLite.Builder toBuilder();
  
  public abstract byte[] toByteArray();
  
  public abstract ByteString toByteString();
  
  public abstract void writeTo(CodedOutputStream paramCodedOutputStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageLite
 * JD-Core Version:    0.7.0.1
 */