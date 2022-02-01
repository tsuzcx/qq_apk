package com.google.protobuf;

final class ExtensionRegistry$DescriptorIntPair
{
  private final Descriptors.Descriptor a;
  private final int b;
  
  ExtensionRegistry$DescriptorIntPair(Descriptors.Descriptor paramDescriptor, int paramInt)
  {
    this.a = paramDescriptor;
    this.b = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DescriptorIntPair;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DescriptorIntPair)paramObject;
    bool1 = bool2;
    if (this.a == paramObject.a)
    {
      bool1 = bool2;
      if (this.b == paramObject.b) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 65535 + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ExtensionRegistry.DescriptorIntPair
 * JD-Core Version:    0.7.0.1
 */