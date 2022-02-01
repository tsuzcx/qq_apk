package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

class Gson$FutureTypeAdapter<T>
  extends TypeAdapter<T>
{
  private TypeAdapter<T> delegate;
  
  public T read(JsonReader paramJsonReader)
  {
    TypeAdapter localTypeAdapter = this.delegate;
    if (localTypeAdapter != null) {
      return localTypeAdapter.read(paramJsonReader);
    }
    throw new IllegalStateException();
  }
  
  public void setDelegate(TypeAdapter<T> paramTypeAdapter)
  {
    if (this.delegate == null)
    {
      this.delegate = paramTypeAdapter;
      return;
    }
    throw new AssertionError();
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
  {
    TypeAdapter localTypeAdapter = this.delegate;
    if (localTypeAdapter != null)
    {
      localTypeAdapter.write(paramJsonWriter, paramT);
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.Gson.FutureTypeAdapter
 * JD-Core Version:    0.7.0.1
 */