package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$33
  implements TypeAdapterFactory
{
  TypeAdapters$33(Class paramClass1, Class paramClass2, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    paramGson = paramTypeToken.getRawType();
    if ((paramGson != this.val$unboxed) && (paramGson != this.val$boxed)) {
      return null;
    }
    return this.val$typeAdapter;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Factory[type=");
    localStringBuilder.append(this.val$boxed.getName());
    localStringBuilder.append("+");
    localStringBuilder.append(this.val$unboxed.getName());
    localStringBuilder.append(",adapter=");
    localStringBuilder.append(this.val$typeAdapter);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.33
 * JD-Core Version:    0.7.0.1
 */