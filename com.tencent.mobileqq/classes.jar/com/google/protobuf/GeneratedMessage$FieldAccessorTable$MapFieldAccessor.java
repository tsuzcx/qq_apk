package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GeneratedMessage$FieldAccessorTable$MapFieldAccessor
  implements GeneratedMessage.FieldAccessorTable.FieldAccessor
{
  private final Descriptors.FieldDescriptor a;
  
  private MapField<?, ?> e(GeneratedMessage paramGeneratedMessage)
  {
    return paramGeneratedMessage.internalGetMapField(this.a.f());
  }
  
  public Object a(GeneratedMessage paramGeneratedMessage)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < d(paramGeneratedMessage))
    {
      localArrayList.add(a(paramGeneratedMessage, i));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Object a(GeneratedMessage paramGeneratedMessage, int paramInt)
  {
    return e(paramGeneratedMessage).e().get(paramInt);
  }
  
  public Object b(GeneratedMessage paramGeneratedMessage)
  {
    return a(paramGeneratedMessage);
  }
  
  public boolean c(GeneratedMessage paramGeneratedMessage)
  {
    throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
  }
  
  public int d(GeneratedMessage paramGeneratedMessage)
  {
    return e(paramGeneratedMessage).e().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage.FieldAccessorTable.MapFieldAccessor
 * JD-Core Version:    0.7.0.1
 */