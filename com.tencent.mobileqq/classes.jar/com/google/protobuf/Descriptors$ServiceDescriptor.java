package com.google.protobuf;

public final class Descriptors$ServiceDescriptor
  extends Descriptors.GenericDescriptor
{
  private final int a;
  private DescriptorProtos.ServiceDescriptorProto b;
  private final String c;
  private final Descriptors.FileDescriptor d;
  private Descriptors.MethodDescriptor[] e;
  
  private Descriptors$ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto paramServiceDescriptorProto, Descriptors.FileDescriptor paramFileDescriptor, int paramInt)
  {
    this.a = paramInt;
    this.b = paramServiceDescriptorProto;
    this.c = Descriptors.a(paramFileDescriptor, null, paramServiceDescriptorProto.getName());
    this.d = paramFileDescriptor;
    this.e = new Descriptors.MethodDescriptor[paramServiceDescriptorProto.getMethodCount()];
    paramInt = 0;
    while (paramInt < paramServiceDescriptorProto.getMethodCount())
    {
      this.e[paramInt] = new Descriptors.MethodDescriptor(paramServiceDescriptorProto.getMethod(paramInt), paramFileDescriptor, this, paramInt, null);
      paramInt += 1;
    }
    Descriptors.FileDescriptor.a(paramFileDescriptor).c(this);
  }
  
  private void e()
  {
    Descriptors.MethodDescriptor[] arrayOfMethodDescriptor = this.e;
    int j = arrayOfMethodDescriptor.length;
    int i = 0;
    while (i < j)
    {
      Descriptors.MethodDescriptor.a(arrayOfMethodDescriptor[i]);
      i += 1;
    }
  }
  
  public DescriptorProtos.ServiceDescriptorProto a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.b.getName();
  }
  
  public String c()
  {
    return this.c;
  }
  
  public Descriptors.FileDescriptor d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.ServiceDescriptor
 * JD-Core Version:    0.7.0.1
 */