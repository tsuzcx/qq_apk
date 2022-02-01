package com.google.protobuf;

public abstract interface MessageLite$Builder
  extends MessageLiteOrBuilder, Cloneable
{
  public abstract MessageLite build();
  
  public abstract MessageLite buildPartial();
  
  public abstract Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract Builder mergeFrom(MessageLite paramMessageLite);
  
  public abstract Builder mergeFrom(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageLite.Builder
 * JD-Core Version:    0.7.0.1
 */