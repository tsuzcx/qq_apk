package com.google.protobuf;

public final class Descriptors$MethodDescriptor
  extends Descriptors.GenericDescriptor
{
  private final int a;
  private DescriptorProtos.MethodDescriptorProto b;
  private final String c;
  private final Descriptors.FileDescriptor d;
  private final Descriptors.ServiceDescriptor e;
  private Descriptors.Descriptor f;
  private Descriptors.Descriptor g;
  
  private Descriptors$MethodDescriptor(DescriptorProtos.MethodDescriptorProto paramMethodDescriptorProto, Descriptors.FileDescriptor paramFileDescriptor, Descriptors.ServiceDescriptor paramServiceDescriptor, int paramInt)
  {
    this.a = paramInt;
    this.b = paramMethodDescriptorProto;
    this.d = paramFileDescriptor;
    this.e = paramServiceDescriptor;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramServiceDescriptor.c());
    localStringBuilder.append('.');
    localStringBuilder.append(paramMethodDescriptorProto.getName());
    this.c = localStringBuilder.toString();
    Descriptors.FileDescriptor.a(paramFileDescriptor).c(this);
  }
  
  private void e()
  {
    Object localObject = Descriptors.FileDescriptor.a(this.d).a(this.b.getInputType(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
    if ((localObject instanceof Descriptors.Descriptor))
    {
      this.f = ((Descriptors.Descriptor)localObject);
      localObject = Descriptors.FileDescriptor.a(this.d).a(this.b.getOutputType(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
      if ((localObject instanceof Descriptors.Descriptor))
      {
        this.g = ((Descriptors.Descriptor)localObject);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('"');
      ((StringBuilder)localObject).append(this.b.getOutputType());
      ((StringBuilder)localObject).append("\" is not a message type.");
      throw new Descriptors.DescriptorValidationException(this, ((StringBuilder)localObject).toString(), null);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append('"');
    ((StringBuilder)localObject).append(this.b.getInputType());
    ((StringBuilder)localObject).append("\" is not a message type.");
    throw new Descriptors.DescriptorValidationException(this, ((StringBuilder)localObject).toString(), null);
  }
  
  public DescriptorProtos.MethodDescriptorProto a()
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
 * Qualified Name:     com.google.protobuf.Descriptors.MethodDescriptor
 * JD-Core Version:    0.7.0.1
 */