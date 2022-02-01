package com.google.protobuf;

import java.lang.reflect.Method;

class GeneratedMessage$FieldAccessorTable$OneofAccessor
{
  private final Descriptors.Descriptor a;
  private final Method b;
  
  public boolean a(GeneratedMessage paramGeneratedMessage)
  {
    return ((Internal.EnumLite)GeneratedMessage.access$1200(this.b, paramGeneratedMessage, new Object[0])).getNumber() != 0;
  }
  
  public Descriptors.FieldDescriptor b(GeneratedMessage paramGeneratedMessage)
  {
    int i = ((Internal.EnumLite)GeneratedMessage.access$1200(this.b, paramGeneratedMessage, new Object[0])).getNumber();
    if (i > 0) {
      return this.a.b(i);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
 * JD-Core Version:    0.7.0.1
 */