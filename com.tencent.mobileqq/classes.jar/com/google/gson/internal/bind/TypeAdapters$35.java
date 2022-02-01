package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$35
  implements TypeAdapterFactory
{
  TypeAdapters$35(Class paramClass, TypeAdapter paramTypeAdapter) {}
  
  public <T2> TypeAdapter<T2> create(Gson paramGson, TypeToken<T2> paramTypeToken)
  {
    paramGson = paramTypeToken.getRawType();
    if (!this.val$clazz.isAssignableFrom(paramGson)) {
      return null;
    }
    return new TypeAdapters.35.1(this, paramGson);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Factory[typeHierarchy=");
    localStringBuilder.append(this.val$clazz.getName());
    localStringBuilder.append(",adapter=");
    localStringBuilder.append(this.val$typeAdapter);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.35
 * JD-Core Version:    0.7.0.1
 */