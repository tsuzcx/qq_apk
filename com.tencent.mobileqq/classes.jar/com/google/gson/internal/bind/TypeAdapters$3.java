package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$3
  extends TypeAdapter<Boolean>
{
  public Boolean read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    if (paramJsonReader.peek() == JsonToken.STRING) {
      return Boolean.valueOf(Boolean.parseBoolean(paramJsonReader.nextString()));
    }
    return Boolean.valueOf(paramJsonReader.nextBoolean());
  }
  
  public void write(JsonWriter paramJsonWriter, Boolean paramBoolean)
  {
    paramJsonWriter.value(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.3
 * JD-Core Version:    0.7.0.1
 */