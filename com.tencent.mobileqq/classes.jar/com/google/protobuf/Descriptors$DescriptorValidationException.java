package com.google.protobuf;

public class Descriptors$DescriptorValidationException
  extends Exception
{
  private static final long serialVersionUID = 5750205775490483148L;
  private final String description;
  private final String name;
  private final Message proto;
  
  private Descriptors$DescriptorValidationException(Descriptors.FileDescriptor paramFileDescriptor, String paramString)
  {
    super(localStringBuilder.toString());
    this.name = paramFileDescriptor.b();
    this.proto = paramFileDescriptor.a();
    this.description = paramString;
  }
  
  private Descriptors$DescriptorValidationException(Descriptors.GenericDescriptor paramGenericDescriptor, String paramString)
  {
    super(localStringBuilder.toString());
    this.name = paramGenericDescriptor.c();
    this.proto = paramGenericDescriptor.l();
    this.description = paramString;
  }
  
  private Descriptors$DescriptorValidationException(Descriptors.GenericDescriptor paramGenericDescriptor, String paramString, Throwable paramThrowable)
  {
    this(paramGenericDescriptor, paramString);
    initCause(paramThrowable);
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public Message getProblemProto()
  {
    return this.proto;
  }
  
  public String getProblemSymbolName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.DescriptorValidationException
 * JD-Core Version:    0.7.0.1
 */