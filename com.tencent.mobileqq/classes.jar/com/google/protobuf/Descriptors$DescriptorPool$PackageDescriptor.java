package com.google.protobuf;

final class Descriptors$DescriptorPool$PackageDescriptor
  extends Descriptors.GenericDescriptor
{
  private final String a;
  private final String b;
  private final Descriptors.FileDescriptor c;
  
  Descriptors$DescriptorPool$PackageDescriptor(String paramString1, String paramString2, Descriptors.FileDescriptor paramFileDescriptor)
  {
    this.c = paramFileDescriptor;
    this.b = paramString2;
    this.a = paramString1;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public Descriptors.FileDescriptor d()
  {
    return this.c;
  }
  
  public Message l()
  {
    return this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.DescriptorPool.PackageDescriptor
 * JD-Core Version:    0.7.0.1
 */