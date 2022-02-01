package com.google.protobuf;

abstract class GeneratedMessage$CachedDescriptorRetriever
  implements GeneratedMessage.ExtensionDescriptorRetriever
{
  private volatile Descriptors.FieldDescriptor a;
  
  protected abstract Descriptors.FieldDescriptor a();
  
  public Descriptors.FieldDescriptor b()
  {
    if (this.a == null) {
      try
      {
        if (this.a == null) {
          this.a = a();
        }
      }
      finally {}
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever
 * JD-Core Version:    0.7.0.1
 */