package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$16
  extends TypeAdapter<String>
{
  public String read(JsonReader paramJsonReader)
  {
    JsonToken localJsonToken = paramJsonReader.peek();
    if (localJsonToken == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    if (localJsonToken == JsonToken.BOOLEAN) {
      return Boolean.toString(paramJsonReader.nextBoolean());
    }
    return paramJsonReader.nextString();
  }
  
  public void write(JsonWriter paramJsonWriter, String paramString)
  {
    paramJsonWriter.value(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.16
 * JD-Core Version:    0.7.0.1
 */