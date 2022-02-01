package com.google.protobuf.nano;

import java.util.HashMap;
import java.util.Map;

class MapFactories$DefaultMapFactory
  implements MapFactories.MapFactory
{
  public <K, V> Map<K, V> forMap(Map<K, V> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.protobuf.nano.MapFactories.DefaultMapFactory
 * JD-Core Version:    0.7.0.1
 */