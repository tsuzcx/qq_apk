package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Currency;

final class TypeAdapters$25
  extends TypeAdapter<Currency>
{
  public Currency read(JsonReader paramJsonReader)
  {
    return Currency.getInstance(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, Currency paramCurrency)
  {
    paramJsonWriter.value(paramCurrency.getCurrencyCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.25
 * JD-Core Version:    0.7.0.1
 */