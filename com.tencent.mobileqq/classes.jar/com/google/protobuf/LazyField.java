package com.google.protobuf;

public class LazyField
  extends LazyFieldLite
{
  private final MessageLite b;
  
  public LazyField(MessageLite paramMessageLite, ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString)
  {
    super(paramExtensionRegistryLite, paramByteString);
    this.b = paramMessageLite;
  }
  
  public MessageLite a()
  {
    return a(this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    return a().equals(paramObject);
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.LazyField
 * JD-Core Version:    0.7.0.1
 */