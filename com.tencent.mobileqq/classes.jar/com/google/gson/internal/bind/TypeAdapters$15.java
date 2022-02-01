package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$15
  extends TypeAdapter<Character>
{
  public Character read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    paramJsonReader = paramJsonReader.nextString();
    if (paramJsonReader.length() == 1) {
      return Character.valueOf(paramJsonReader.charAt(0));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expecting character, got: ");
    localStringBuilder.append(paramJsonReader);
    throw new JsonSyntaxException(localStringBuilder.toString());
  }
  
  public void write(JsonWriter paramJsonWriter, Character paramCharacter)
  {
    if (paramCharacter == null) {
      paramCharacter = null;
    } else {
      paramCharacter = String.valueOf(paramCharacter);
    }
    paramJsonWriter.value(paramCharacter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.15
 * JD-Core Version:    0.7.0.1
 */