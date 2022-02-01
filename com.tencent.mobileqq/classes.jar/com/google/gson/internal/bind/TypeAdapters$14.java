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
    int i = TypeAdapters.36.$SwitchMap$com$google$gson$stream$JsonToken[localJsonToken.ordinal()];
    if ((i != 1) && (i != 3))
    {
      if (i == 4)
      {
        paramJsonReader.nextNull();
        return null;
      }
      paramJsonReader = new StringBuilder();
      paramJsonReader.append("Expecting number, got: ");
      paramJsonReader.append(localJsonToken);
      throw new JsonSyntaxException(paramJsonReader.toString());
    }
    return new LazilyParsedNumber(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, Number paramNumber)
  {
    paramJsonWriter.value(paramNumber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.14
 * JD-Core Version:    0.7.0.1
 */