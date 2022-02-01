package com.google.protobuf;

import java.util.Map;

abstract interface MapField$Converter<K, V>
{
  public abstract Message a();
  
  public abstract Message a(K paramK, V paramV);
  
  public abstract void a(Message paramMessage, Map<K, V> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapField.Converter
 * JD-Core Version:    0.7.0.1
 */