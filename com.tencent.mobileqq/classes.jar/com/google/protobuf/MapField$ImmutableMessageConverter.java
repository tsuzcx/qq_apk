package com.google.protobuf;

import java.util.Map;

class MapField$ImmutableMessageConverter<K, V>
  implements MapField.Converter<K, V>
{
  private final MapEntry<K, V> a;
  
  public MapField$ImmutableMessageConverter(MapEntry<K, V> paramMapEntry)
  {
    this.a = paramMapEntry;
  }
  
  public Message a()
  {
    return this.a;
  }
  
  public Message a(K paramK, V paramV)
  {
    return this.a.c().a(paramK).b(paramV).f();
  }
  
  public void a(Message paramMessage, Map<K, V> paramMap)
  {
    paramMessage = (MapEntry)paramMessage;
    paramMap.put(paramMessage.a(), paramMessage.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapField.ImmutableMessageConverter
 * JD-Core Version:    0.7.0.1
 */