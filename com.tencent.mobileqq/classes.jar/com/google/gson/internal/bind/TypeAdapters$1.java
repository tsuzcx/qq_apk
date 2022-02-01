package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$1
  extends TypeAdapter<Class>
{
  public Class read(JsonReader paramJsonReader)
  {
    throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
  }
  
  public void write(JsonWriter paramJsonWriter, Class paramClass)
  {
    paramJsonWriter = new StringBuilder();
    paramJsonWriter.append("Attempted to serialize java.lang.Class: ");
    paramJsonWriter.append(paramClass.getName());
    paramJsonWriter.append(". Forgot to register a type adapter?");
    throw new UnsupportedOperationException(paramJsonWriter.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.1
 * JD-Core Version:    0.7.0.1
 */