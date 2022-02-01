package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.UUID;

final class TypeAdapters$24
  extends TypeAdapter<UUID>
{
  public UUID read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return UUID.fromString(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, UUID paramUUID)
  {
    if (paramUUID == null) {}
    for (paramUUID = null;; paramUUID = paramUUID.toString())
    {
      paramJsonWriter.value(paramUUID);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.24
 * JD-Core Version:    0.7.0.1
 */