package com.google.protobuf;

import java.lang.reflect.Method;

class GeneratedMessage$FieldAccessorTable$SingularFieldAccessor
  implements GeneratedMessage.FieldAccessorTable.FieldAccessor
{
  protected final Method a;
  protected final Method b;
  protected final Method c;
  protected final Descriptors.FieldDescriptor d;
  protected final boolean e;
  protected final boolean f;
  
  private int e(GeneratedMessage paramGeneratedMessage)
  {
    return ((Internal.EnumLite)GeneratedMessage.access$1200(this.c, paramGeneratedMessage, new Object[0])).getNumber();
  }
  
  public Object a(GeneratedMessage paramGeneratedMessage)
  {
    return GeneratedMessage.access$1200(this.a, paramGeneratedMessage, new Object[0]);
  }
  
  public Object a(GeneratedMessage paramGeneratedMessage, int paramInt)
  {
    throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
  }
  
  public Object b(GeneratedMessage paramGeneratedMessage)
  {
    return a(paramGeneratedMessage);
  }
  
  public boolean c(GeneratedMessage paramGeneratedMessage)
  {
    boolean bool2 = this.f;
    boolean bool1 = false;
    if (!bool2)
    {
      if (this.e)
      {
        if (e(paramGeneratedMessage) == this.d.f()) {
          bool1 = true;
        }
        return bool1;
      }
      return a(paramGeneratedMessage).equals(this.d.s()) ^ true;
    }
    return ((Boolean)GeneratedMessage.access$1200(this.b, paramGeneratedMessage, new Object[0])).booleanValue();
  }
  
  public int d(GeneratedMessage paramGeneratedMessage)
  {
    throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor
 * JD-Core Version:    0.7.0.1
 */