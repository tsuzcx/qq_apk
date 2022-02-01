package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class TypeAdapters$30
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    paramTypeToken = paramTypeToken.getRawType();
    if ((!Enum.class.isAssignableFrom(paramTypeToken)) || (paramTypeToken == Enum.class)) {
      return null;
    }
    paramGson = paramTypeToken;
    if (!paramTypeToken.isEnum()) {
      paramGson = paramTypeToken.getSuperclass();
    }
    return new TypeAdapters.EnumTypeAdapter(paramGson);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.30
 * JD-Core Version:    0.7.0.1
 */