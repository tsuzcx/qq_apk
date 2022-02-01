package com.google.protobuf;

import java.io.IOException;

class DynamicMessage$1
  extends AbstractParser<DynamicMessage>
{
  DynamicMessage$1(DynamicMessage paramDynamicMessage) {}
  
  public DynamicMessage a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    DynamicMessage.Builder localBuilder = DynamicMessage.b(DynamicMessage.a(this.a));
    try
    {
      localBuilder.mergeFrom(paramCodedInputStream, paramExtensionRegistryLite);
      return localBuilder.c();
    }
    catch (IOException paramCodedInputStream)
    {
      throw new InvalidProtocolBufferException(paramCodedInputStream).setUnfinishedMessage(localBuilder.c());
    }
    catch (InvalidProtocolBufferException paramCodedInputStream)
    {
      throw paramCodedInputStream.setUnfinishedMessage(localBuilder.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DynamicMessage.1
 * JD-Core Version:    0.7.0.1
 */