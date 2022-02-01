package com.google.protobuf;

public final class Descriptors$EnumValueDescriptor
  extends Descriptors.GenericDescriptor
  implements Internal.EnumLite
{
  private final int a;
  private DescriptorProtos.EnumValueDescriptorProto b;
  private final String c;
  private final Descriptors.FileDescriptor d;
  private final Descriptors.EnumDescriptor e;
  
  private Descriptors$EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto paramEnumValueDescriptorProto, Descriptors.FileDescriptor paramFileDescriptor, Descriptors.EnumDescriptor paramEnumDescriptor, int paramInt)
  {
    this.a = paramInt;
    this.b = paramEnumValueDescriptorProto;
    this.d = paramFileDescriptor;
    this.e = paramEnumDescriptor;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEnumDescriptor.c());
    localStringBuilder.append('.');
    localStringBuilder.append(paramEnumValueDescriptorProto.getName());
    this.c = localStringBuilder.toString();
    Descriptors.FileDescriptor.a(paramFileDescriptor).c(this);
    Descriptors.FileDescriptor.a(paramFileDescriptor).a(this);
  }
  
  private Descriptors$EnumValueDescriptor(Descriptors.FileDescriptor paramFileDescriptor, Descriptors.EnumDescriptor paramEnumDescriptor, Integer paramInteger)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("UNKNOWN_ENUM_VALUE_");
    ((StringBuilder)localObject).append(paramEnumDescriptor.b());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInteger);
    localObject = ((StringBuilder)localObject).toString();
    paramInteger = DescriptorProtos.EnumValueDescriptorProto.newBuilder().a((String)localObject).a(paramInteger.intValue()).c();
    this.a = -1;
    this.b = paramInteger;
    this.d = paramFileDescriptor;
    this.e = paramEnumDescriptor;
    paramFileDescriptor = new StringBuilder();
    paramFileDescriptor.append(paramEnumDescriptor.c());
    paramFileDescriptor.append('.');
    paramFileDescriptor.append(paramInteger.getName());
    this.c = paramFileDescriptor.toString();
  }
  
  public int a()
  {
    return this.a;
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
  
  public DescriptorProtos.EnumValueDescriptorProto e()
  {
    return this.b;
  }
  
  public Descriptors.EnumDescriptor f()
  {
    return this.e;
  }
  
  public int getNumber()
  {
    return this.b.getNumber();
  }
  
  public String toString()
  {
    return this.b.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.EnumValueDescriptor
 * JD-Core Version:    0.7.0.1
 */