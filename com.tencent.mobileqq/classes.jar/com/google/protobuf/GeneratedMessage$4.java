package com.google.protobuf;

import java.lang.reflect.Field;

final class GeneratedMessage$4
  extends GeneratedMessage.CachedDescriptorRetriever
{
  GeneratedMessage$4(Class paramClass, String paramString1, String paramString2)
  {
    super(null);
  }
  
  protected Descriptors.FieldDescriptor a()
  {
    try
    {
      Descriptors.FieldDescriptor localFieldDescriptor = ((Descriptors.FileDescriptor)this.a.getClassLoader().loadClass(this.b).getField("descriptor").get(null)).a(this.c);
      return localFieldDescriptor;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot load descriptors: ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" is not a valid descriptor class name");
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.4
 * JD-Core Version:    0.7.0.1
 */