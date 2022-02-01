package com.google.protobuf;

import java.util.logging.Logger;

public final class Descriptors
{
  private static final Logger a = Logger.getLogger(Descriptors.class.getName());
  
  private static String b(Descriptors.FileDescriptor paramFileDescriptor, Descriptors.Descriptor paramDescriptor, String paramString)
  {
    if (paramDescriptor != null)
    {
      paramFileDescriptor = new StringBuilder();
      paramFileDescriptor.append(paramDescriptor.c());
      paramFileDescriptor.append('.');
      paramFileDescriptor.append(paramString);
      return paramFileDescriptor.toString();
    }
    paramFileDescriptor = paramFileDescriptor.e();
    if (!paramFileDescriptor.isEmpty())
    {
      paramDescriptor = new StringBuilder();
      paramDescriptor.append(paramFileDescriptor);
      paramDescriptor.append('.');
      paramDescriptor.append(paramString);
      return paramDescriptor.toString();
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors
 * JD-Core Version:    0.7.0.1
 */