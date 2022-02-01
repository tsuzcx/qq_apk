package com.google.protobuf;

import java.lang.reflect.Method;

class GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor
  implements GeneratedMessage.FieldAccessorTable.FieldAccessor
{
  protected final Method a;
  protected final Method b;
  protected final Method c;
  
  public Object a(GeneratedMessage paramGeneratedMessage)
  {
    return GeneratedMessage.access$1200(this.a, paramGeneratedMessage, new Object[0]);
  }
  
  public Object a(GeneratedMessage paramGeneratedMessage, int paramInt)
  {
    return GeneratedMessage.access$1200(this.b, paramGeneratedMessage, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public Object b(GeneratedMessage paramGeneratedMessage)
  {
    return a(paramGeneratedMessage);
  }
  
  public boolean c(GeneratedMessage paramGeneratedMessage)
  {
    throw new UnsupportedOperationException("hasField() called on a repeated field.");
  }
  
  public int d(GeneratedMessage paramGeneratedMessage)
  {
    return ((Integer)GeneratedMessage.access$1200(this.c, paramGeneratedMessage, new Object[0])).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
 * JD-Core Version:    0.7.0.1
 */