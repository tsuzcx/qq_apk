package com.google.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class SmallSortedMap$1
  extends SmallSortedMap<FieldDescriptorType, Object>
{
  SmallSortedMap$1(int paramInt)
  {
    super(paramInt, null);
  }
  
  public void a()
  {
    if (!b())
    {
      int i = 0;
      while (i < c())
      {
        localObject = b(i);
        if (((FieldSet.FieldDescriptorLite)((Map.Entry)localObject).getKey()).p()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
        i += 1;
      }
      Object localObject = e().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((FieldSet.FieldDescriptorLite)localEntry.getKey()).p()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.SmallSortedMap.1
 * JD-Core Version:    0.7.0.1
 */