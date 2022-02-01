package com.google.protobuf;

final class ArrayDecoders$Registers
{
  public int a;
  public long b;
  public Object c;
  public final ExtensionRegistryLite d;
  
  ArrayDecoders$Registers()
  {
    this.d = ExtensionRegistryLite.d();
  }
  
  ArrayDecoders$Registers(ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (paramExtensionRegistryLite != null)
    {
      this.d = paramExtensionRegistryLite;
      return;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ArrayDecoders.Registers
 * JD-Core Version:    0.7.0.1
 */