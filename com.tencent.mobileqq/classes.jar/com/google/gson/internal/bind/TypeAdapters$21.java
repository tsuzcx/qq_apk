package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.net.URL;

final class TypeAdapters$21
  extends TypeAdapter<URL>
{
  public URL read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    paramJsonReader = paramJsonReader.nextString();
    if ("null".equals(paramJsonReader)) {
      return null;
    }
    return new URL(paramJsonReader);
  }
  
  public void write(JsonWriter paramJsonWriter, URL paramURL)
  {
    if (paramURL == null) {
      paramURL = null;
    } else {
      paramURL = paramURL.toExternalForm();
    }
    paramJsonWriter.value(paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.21
 * JD-Core Version:    0.7.0.1
 */