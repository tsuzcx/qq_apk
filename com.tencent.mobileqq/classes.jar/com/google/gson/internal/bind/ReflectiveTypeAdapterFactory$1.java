package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;

class ReflectiveTypeAdapterFactory$1
  extends ReflectiveTypeAdapterFactory.BoundField
{
  ReflectiveTypeAdapterFactory$1(ReflectiveTypeAdapterFactory paramReflectiveTypeAdapterFactory, String paramString, boolean paramBoolean1, boolean paramBoolean2, Field paramField, boolean paramBoolean3, TypeAdapter paramTypeAdapter, Gson paramGson, TypeToken paramTypeToken, boolean paramBoolean4)
  {
    super(paramString, paramBoolean1, paramBoolean2);
  }
  
  void read(JsonReader paramJsonReader, Object paramObject)
  {
    paramJsonReader = this.val$typeAdapter.read(paramJsonReader);
    if ((paramJsonReader != null) || (!this.val$isPrimitive)) {
      this.val$field.set(paramObject, paramJsonReader);
    }
  }
  
  void write(JsonWriter paramJsonWriter, Object paramObject)
  {
    Object localObject = this.val$field.get(paramObject);
    if (this.val$jsonAdapterPresent) {
      paramObject = this.val$typeAdapter;
    } else {
      paramObject = new TypeAdapterRuntimeTypeWrapper(this.val$context, this.val$typeAdapter, this.val$fieldType.getType());
    }
    paramObject.write(paramJsonWriter, localObject);
  }
  
  public boolean writeField(Object paramObject)
  {
    boolean bool2 = this.serialized;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (this.val$field.get(paramObject) != paramObject) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
 * JD-Core Version:    0.7.0.1
 */