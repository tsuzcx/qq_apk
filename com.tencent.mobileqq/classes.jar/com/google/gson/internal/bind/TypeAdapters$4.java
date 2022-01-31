package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$4
  extends TypeAdapter<Boolean>
{
  public Boolean read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return Boolean.valueOf(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, Boolean paramBoolean)
  {
    if (paramBoolean == null) {}
    for (paramBoolean = "null";; paramBoolean = paramBoolean.toString())
    {
      paramJsonWriter.value(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.4
 * JD-Core Version:    0.7.0.1
 */