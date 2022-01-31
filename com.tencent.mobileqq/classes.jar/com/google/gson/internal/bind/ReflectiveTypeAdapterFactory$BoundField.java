package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

abstract class ReflectiveTypeAdapterFactory$BoundField
{
  final boolean deserialized;
  final String name;
  final boolean serialized;
  
  protected ReflectiveTypeAdapterFactory$BoundField(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.name = paramString;
    this.serialized = paramBoolean1;
    this.deserialized = paramBoolean2;
  }
  
  abstract void read(JsonReader paramJsonReader, Object paramObject);
  
  abstract void write(JsonWriter paramJsonWriter, Object paramObject);
  
  abstract boolean writeField(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
 * JD-Core Version:    0.7.0.1
 */