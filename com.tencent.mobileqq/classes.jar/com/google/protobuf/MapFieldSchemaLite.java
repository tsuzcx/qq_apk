package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapFieldSchemaLite
  implements MapFieldSchema
{
  private static <K, V> int b(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject = (MapFieldLite)paramObject1;
    paramObject1 = (MapEntryLite)paramObject2;
    boolean bool = ((MapFieldLite)localObject).isEmpty();
    int i = 0;
    if (bool) {
      return 0;
    }
    paramObject2 = ((MapFieldLite)localObject).entrySet().iterator();
    while (paramObject2.hasNext())
    {
      localObject = (Map.Entry)paramObject2.next();
      i += paramObject1.a(paramInt, ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
    }
    return i;
  }
  
  private static <K, V> MapFieldLite<K, V> b(Object paramObject1, Object paramObject2)
  {
    MapFieldLite localMapFieldLite = (MapFieldLite)paramObject1;
    paramObject2 = (MapFieldLite)paramObject2;
    paramObject1 = localMapFieldLite;
    if (!paramObject2.isEmpty())
    {
      paramObject1 = localMapFieldLite;
      if (!localMapFieldLite.isMutable()) {
        paramObject1 = localMapFieldLite.mutableCopy();
      }
      paramObject1.mergeFrom(paramObject2);
    }
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
    return (MapFieldLite)paramObject;
  }
  
  public Map<?, ?> b(Object paramObject)
  {
    return (MapFieldLite)paramObject;
  }
  
  public boolean c(Object paramObject)
  {
    return ((MapFieldLite)paramObject).isMutable() ^ true;
  }
  
  public Object d(Object paramObject)
  {
    ((MapFieldLite)paramObject).makeImmutable();
    return paramObject;
  }
  
  public Object e(Object paramObject)
  {
    return MapFieldLite.emptyMapField().mutableCopy();
  }
  
  public MapEntryLite.Metadata<?, ?> f(Object paramObject)
  {
    return ((MapEntryLite)paramObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapFieldSchemaLite
 * JD-Core Version:    0.7.0.1
 */