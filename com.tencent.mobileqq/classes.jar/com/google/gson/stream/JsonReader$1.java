package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;

final class JsonReader$1
  extends JsonReaderInternalAccess
{
  public void promoteNameToValue(JsonReader paramJsonReader)
  {
    if ((paramJsonReader instanceof JsonTreeReader))
    {
      ((JsonTreeReader)paramJsonReader).promoteNameToValue();
      return;
    }
    int j = paramJsonReader.peeked;
    int i = j;
    if (j == 0) {
      i = paramJsonReader.doPeek();
    }
    if (i == 13)
    {
      paramJsonReader.peeked = 9;
      return;
    }
    if (i == 12)
    {
      paramJsonReader.peeked = 8;
      return;
    }
    if (i == 14)
    {
      paramJsonReader.peeked = 10;
      return;
    }
    throw new IllegalStateException("Expected a name but was " + paramJsonReader.peek() + paramJsonReader.locationString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.stream.JsonReader.1
 * JD-Core Version:    0.7.0.1
 */