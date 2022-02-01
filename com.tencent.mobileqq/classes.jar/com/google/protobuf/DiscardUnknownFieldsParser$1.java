package com.google.protobuf;

final class DiscardUnknownFieldsParser$1
  extends AbstractParser<T>
{
  public T a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      paramCodedInputStream.u();
      paramExtensionRegistryLite = (Message)this.a.parsePartialFrom(paramCodedInputStream, paramExtensionRegistryLite);
      return paramExtensionRegistryLite;
    }
    finally
    {
      paramCodedInputStream.v();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DiscardUnknownFieldsParser.1
 * JD-Core Version:    0.7.0.1
 */