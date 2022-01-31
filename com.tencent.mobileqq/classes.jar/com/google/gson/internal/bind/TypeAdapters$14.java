package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class TypeAdapters$14
  extends TypeAdapter<Number>
{
  public Number read(JsonReader paramJsonReader)
  {
    JsonToken localJsonToken = paramJsonReader.peek();
    switch (TypeAdapters.36.$SwitchMap$com$google$gson$stream$JsonToken[localJsonToken.ordinal()])
    {
    case 2: 
    default: 
      throw new JsonSyntaxException("Expecting number, got: " + localJsonToken);
    case 4: 
      paramJsonReader.nextNull();
      return null;
    }
    return new LazilyParsedNumber(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, Number paramNumber)
  {
    paramJsonWriter.value(paramNumber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.14
 * JD-Core Version:    0.7.0.1
 */