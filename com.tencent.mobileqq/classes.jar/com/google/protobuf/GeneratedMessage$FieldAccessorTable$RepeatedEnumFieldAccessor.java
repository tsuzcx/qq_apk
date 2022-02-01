package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor
  extends GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
{
  private Descriptors.EnumDescriptor d;
  private final Method e;
  private boolean f;
  private Method g;
  
  public Object a(GeneratedMessage paramGeneratedMessage)
  {
    ArrayList localArrayList = new ArrayList();
    int j = d(paramGeneratedMessage);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramGeneratedMessage, i));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Object a(GeneratedMessage paramGeneratedMessage, int paramInt)
  {
    if (this.f)
    {
      paramInt = ((Integer)GeneratedMessage.access$1200(this.g, paramGeneratedMessage, new Object[] { Integer.valueOf(paramInt) })).intValue();
      return this.d.b(paramInt);
    }
    return GeneratedMessage.access$1200(this.e, super.a(paramGeneratedMessage, paramInt), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedEnumFieldAccessor
 * JD-Core Version:    0.7.0.1
 */