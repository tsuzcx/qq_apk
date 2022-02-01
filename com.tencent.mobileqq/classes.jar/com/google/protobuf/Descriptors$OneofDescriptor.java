package com.google.protobuf;

public final class Descriptors$OneofDescriptor
{
  private final int a;
  private DescriptorProtos.OneofDescriptorProto b;
  private final String c;
  private final Descriptors.FileDescriptor d;
  private Descriptors.Descriptor e;
  private int f;
  private Descriptors.FieldDescriptor[] g;
  
  private Descriptors$OneofDescriptor(DescriptorProtos.OneofDescriptorProto paramOneofDescriptorProto, Descriptors.FileDescriptor paramFileDescriptor, Descriptors.Descriptor paramDescriptor, int paramInt)
  {
    this.b = paramOneofDescriptorProto;
    this.c = Descriptors.a(paramFileDescriptor, paramDescriptor, paramOneofDescriptorProto.getName());
    this.d = paramFileDescriptor;
    this.a = paramInt;
    this.e = paramDescriptor;
    this.f = 0;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b.getName();
  }
  
  public Descriptors.Descriptor c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.OneofDescriptor
 * JD-Core Version:    0.7.0.1
 */