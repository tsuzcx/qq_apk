package com.google.protobuf;

import java.io.IOException;

public final class UnknownFieldSet$Parser
  extends AbstractParser<UnknownFieldSet>
{
  public UnknownFieldSet a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramExtensionRegistryLite = UnknownFieldSet.a();
    try
    {
      paramExtensionRegistryLite.a(paramCodedInputStream);
      return paramExtensionRegistryLite.b();
    }
    catch (IOException paramCodedInputStream)
    {
      throw new InvalidProtocolBufferException(paramCodedInputStream).setUnfinishedMessage(paramExtensionRegistryLite.b());
    }
    catch (InvalidProtocolBufferException paramCodedInputStream)
    {
      throw paramCodedInputStream.setUnfinishedMessage(paramExtensionRegistryLite.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnknownFieldSet.Parser
 * JD-Core Version:    0.7.0.1
 */