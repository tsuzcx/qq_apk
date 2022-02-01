package com.google.protobuf;

final class ExtensionRegistryLite$ObjectIntPair
{
  private final Object a;
  private final int b;
  
  ExtensionRegistryLite$ObjectIntPair(Object paramObject, int paramInt)
  {
    this.a = paramObject;
    this.b = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ObjectIntPair;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ObjectIntPair)paramObject;
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
    return System.identityHashCode(this.a) * 65535 + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ExtensionRegistryLite.ObjectIntPair
 * JD-Core Version:    0.7.0.1
 */