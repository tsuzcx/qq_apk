package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract interface Parser<MessageType>
{
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream);
  
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(ByteString paramByteString);
  
  public abstract MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(CodedInputStream paramCodedInputStream);
  
  public abstract MessageType parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(InputStream paramInputStream);
  
  public abstract MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(ByteBuffer paramByteBuffer);
  
  public abstract MessageType parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte);
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MessageType parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Parser
 * JD-Core Version:    0.7.0.1
 */