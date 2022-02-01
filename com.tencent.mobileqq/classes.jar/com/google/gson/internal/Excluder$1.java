package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

class Excluder$1
  extends TypeAdapter<T>
{
  private TypeAdapter<T> delegate;
  
  Excluder$1(Excluder paramExcluder, boolean paramBoolean1, boolean paramBoolean2, Gson paramGson, TypeToken paramTypeToken) {}
  
  private TypeAdapter<T> delegate()
  {
    TypeAdapter localTypeAdapter = this.delegate;
    if (localTypeAdapter != null) {
      return localTypeAdapter;
    }
    localTypeAdapter = this.val$gson.getDelegateAdapter(this.this$0, this.val$type);
    this.delegate = localTypeAdapter;
    return localTypeAdapter;
  }
  
  public T read(JsonReader paramJsonReader)
  {
    if (this.val$skipDeserialize)
    {
      paramJsonReader.skipValue();
      return null;
    }
    return delegate().read(paramJsonReader);
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
  {
    if (this.val$skipSerialize)
    {
      paramJsonWriter.nullValue();
      return;
    }
    delegate().write(paramJsonWriter, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.Excluder.1
 * JD-Core Version:    0.7.0.1
 */