package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$20
  extends TypeAdapter<StringBuffer>
{
  public StringBuffer read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return new StringBuffer(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null) {
      paramStringBuffer = null;
    } else {
      paramStringBuffer = paramStringBuffer.toString();
    }
    paramJsonWriter.value(paramStringBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.20
 * JD-Core Version:    0.7.0.1
 */