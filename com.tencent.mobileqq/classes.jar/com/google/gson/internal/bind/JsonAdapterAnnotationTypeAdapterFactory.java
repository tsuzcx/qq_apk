package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor constructorConstructor;
  
  public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor)
  {
    this.constructorConstructor = paramConstructorConstructor;
  }
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    JsonAdapter localJsonAdapter = (JsonAdapter)paramTypeToken.getRawType().getAnnotation(JsonAdapter.class);
    if (localJsonAdapter == null) {
      return null;
    }
    return getTypeAdapter(this.constructorConstructor, paramGson, paramTypeToken, localJsonAdapter);
  }
  
  TypeAdapter<?> getTypeAdapter(ConstructorConstructor paramConstructorConstructor, Gson paramGson, TypeToken<?> paramTypeToken, JsonAdapter paramJsonAdapter)
  {
    Object localObject = paramConstructorConstructor.get(TypeToken.get(paramJsonAdapter.value())).construct();
    if ((localObject instanceof TypeAdapter))
    {
      paramConstructorConstructor = (TypeAdapter)localObject;
    }
    else if ((localObject instanceof TypeAdapterFactory))
    {
      paramConstructorConstructor = ((TypeAdapterFactory)localObject).create(paramGson, paramTypeToken);
    }
    else
    {
      boolean bool = localObject instanceof JsonSerializer;
      if ((!bool) && (!(localObject instanceof JsonDeserializer)))
      {
        paramConstructorConstructor = new StringBuilder();
        paramConstructorConstructor.append("Invalid attempt to bind an instance of ");
        paramConstructorConstructor.append(localObject.getClass().getName());
        paramConstructorConstructor.append(" as a @JsonAdapter for ");
        paramConstructorConstructor.append(paramTypeToken.toString());
        paramConstructorConstructor.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        throw new IllegalArgumentException(paramConstructorConstructor.toString());
      }
      JsonDeserializer localJsonDeserializer = null;
      if (bool) {
        paramConstructorConstructor = (JsonSerializer)localObject;
      } else {
        paramConstructorConstructor = null;
      }
      if ((localObject instanceof JsonDeserializer)) {
        localJsonDeserializer = (JsonDeserializer)localObject;
      }
      paramConstructorConstructor = new TreeTypeAdapter(paramConstructorConstructor, localJsonDeserializer, paramGson, paramTypeToken, null);
    }
    paramGson = paramConstructorConstructor;
    if (paramConstructorConstructor != null)
    {
      paramGson = paramConstructorConstructor;
      if (paramJsonAdapter.nullSafe()) {
        paramGson = paramConstructorConstructor.nullSafe();
      }
    }
    return paramGson;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory
 * JD-Core Version:    0.7.0.1
 */