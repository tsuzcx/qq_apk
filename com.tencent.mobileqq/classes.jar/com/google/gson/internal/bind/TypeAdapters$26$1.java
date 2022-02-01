package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.Date;

class TypeAdapters$26$1
  extends TypeAdapter<Timestamp>
{
  TypeAdapters$26$1(TypeAdapters.26 param26, TypeAdapter paramTypeAdapter) {}
  
  public Timestamp read(JsonReader paramJsonReader)
  {
    paramJsonReader = (Date)this.val$dateTypeAdapter.read(paramJsonReader);
    if (paramJsonReader != null) {
      return new Timestamp(paramJsonReader.getTime());
    }
    return null;
  }
  
  public void write(JsonWriter paramJsonWriter, Timestamp paramTimestamp)
  {
    this.val$dateTypeAdapter.write(paramJsonWriter, paramTimestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.26.1
 * JD-Core Version:    0.7.0.1
 */