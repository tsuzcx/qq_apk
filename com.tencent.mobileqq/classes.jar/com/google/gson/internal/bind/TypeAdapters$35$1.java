package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

class TypeAdapters$35$1
  extends TypeAdapter<T1>
{
  TypeAdapters$35$1(TypeAdapters.35 param35, Class paramClass) {}
  
  public T1 read(JsonReader paramJsonReader)
  {
    paramJsonReader = this.this$0.val$typeAdapter.read(paramJsonReader);
    if (paramJsonReader != null)
    {
      if (this.val$requestedType.isInstance(paramJsonReader)) {
        return paramJsonReader;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected a ");
      localStringBuilder.append(this.val$requestedType.getName());
      localStringBuilder.append(" but was ");
      localStringBuilder.append(paramJsonReader.getClass().getName());
      throw new JsonSyntaxException(localStringBuilder.toString());
    }
    return paramJsonReader;
  }
  
  public void write(JsonWriter paramJsonWriter, T1 paramT1)
  {
    this.this$0.val$typeAdapter.write(paramJsonWriter, paramT1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.35.1
 * JD-Core Version:    0.7.0.1
 */