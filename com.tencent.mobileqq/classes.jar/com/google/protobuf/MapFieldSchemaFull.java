package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapFieldSchemaFull
  implements MapFieldSchema
{
  private static <K, V> int b(int paramInt, Object paramObject1, Object paramObject2)
  {
    int i = 0;
    if (paramObject1 == null) {
      return 0;
    }
    Object localObject = ((MapField)paramObject1).a();
    paramObject1 = (MapEntry)paramObject2;
    if (((Map)localObject).isEmpty()) {
      return 0;
    }
    paramObject2 = ((Map)localObject).entrySet().iterator();
    while (paramObject2.hasNext())
    {
      localObject = (Map.Entry)paramObject2.next();
      i += CodedOutputStream.h(paramInt) + CodedOutputStream.o(MapEntryLite.a(paramObject1.f(), ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue()));
    }
    return i;
  }
  
  private static <K, V> Object b(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (MapField)paramObject1;
    paramObject2 = (MapField)paramObject2;
    if (!paramObject1.i()) {
      paramObject1.d();
    }
    paramObject1.a(paramObject2);
    return paramObject1;
  }
  
  public int a(int paramInt, Object paramObject1, Object paramObject2)
  {
    return b(paramInt, paramObject1, paramObject2);
  }
  
  public Object a(Object paramObject1, Object paramObject2)
  {
    return b(paramObject1, paramObject2);
  }
  
  public Map<?, ?> a(Object paramObject)
  {
    return ((MapField)paramObject).b();
  }
  
  public Map<?, ?> b(Object paramObject)
  {
    return ((MapField)paramObject).a();
  }
  
  public boolean c(Object paramObject)
  {
    return ((MapField)paramObject).i() ^ true;
  }
  
  public Object d(Object paramObject)
  {
    ((MapField)paramObject).h();
    return paramObject;
  }
  
  public Object e(Object paramObject)
  {
    return MapField.b((MapEntry)paramObject);
  }
  
  public MapEntryLite.Metadata<?, ?> f(Object paramObject)
  {
    return ((MapEntry)paramObject).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapFieldSchemaFull
 * JD-Core Version:    0.7.0.1
 */