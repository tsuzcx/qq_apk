package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.concurrent.atomic.AtomicLong;

final class Gson$4
  extends TypeAdapter<AtomicLong>
{
  Gson$4(TypeAdapter paramTypeAdapter) {}
  
  public AtomicLong read(JsonReader paramJsonReader)
  {
    return new AtomicLong(((Number)this.val$longAdapter.read(paramJsonReader)).longValue());
  }
  
  public void write(JsonWriter paramJsonWriter, AtomicLong paramAtomicLong)
  {
    this.val$longAdapter.write(paramJsonWriter, Long.valueOf(paramAtomicLong.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.Gson.4
 * JD-Core Version:    0.7.0.1
 */