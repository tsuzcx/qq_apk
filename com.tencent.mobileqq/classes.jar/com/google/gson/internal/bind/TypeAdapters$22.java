package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.net.URI;
import java.net.URISyntaxException;

final class TypeAdapters$22
  extends TypeAdapter<URI>
{
  public URI read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    try
    {
      paramJsonReader = paramJsonReader.nextString();
      if ("null".equals(paramJsonReader)) {
        return null;
      }
      paramJsonReader = new URI(paramJsonReader);
      return paramJsonReader;
    }
    catch (URISyntaxException paramJsonReader)
    {
      throw new JsonIOException(paramJsonReader);
    }
  }
  
  public void write(JsonWriter paramJsonWriter, URI paramURI)
  {
    if (paramURI == null) {
      paramURI = null;
    } else {
      paramURI = paramURI.toASCIIString();
    }
    paramJsonWriter.value(paramURI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.22
 * JD-Core Version:    0.7.0.1
 */