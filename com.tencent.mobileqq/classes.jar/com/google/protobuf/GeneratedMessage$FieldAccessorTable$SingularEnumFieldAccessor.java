package com.google.protobuf;

import java.lang.reflect.Method;

final class GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor
  extends GeneratedMessage.FieldAccessorTable.SingularFieldAccessor
{
  private Descriptors.EnumDescriptor g;
  private Method h;
  private boolean i;
  private Method j;
  
  public Object a(GeneratedMessage paramGeneratedMessage)
  {
    if (this.i)
    {
      int k = ((Integer)GeneratedMessage.access$1200(this.j, paramGeneratedMessage, new Object[0])).intValue();
      return this.g.b(k);
    }
    return GeneratedMessage.access$1200(this.h, super.a(paramGeneratedMessage), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularEnumFieldAccessor
 * JD-Core Version:    0.7.0.1
 */