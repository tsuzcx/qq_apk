package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T>
  extends TypeAdapter<T>
{
  private final Gson context;
  private final TypeAdapter<T> delegate;
  private final Type type;
  
  TypeAdapterRuntimeTypeWrapper(Gson paramGson, TypeAdapter<T> paramTypeAdapter, Type paramType)
  {
    this.context = paramGson;
    this.delegate = paramTypeAdapter;
    this.type = paramType;
  }
  
  private Type getRuntimeTypeIfMoreSpecific(Type paramType, Object paramObject)
  {
    Object localObject = paramType;
    if (paramObject != null) {
      if ((paramType != Object.class) && (!(paramType instanceof TypeVariable)))
      {
        localObject = paramType;
        if (!(paramType instanceof Class)) {}
      }
      else
      {
        localObject = paramObject.getClass();
      }
    }
    return localObject;
  }
  
  public T read(JsonReader paramJsonReader)
  {
    return this.delegate.read(paramJsonReader);
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
  {
    Object localObject1 = this.delegate;
    Object localObject2 = getRuntimeTypeIfMoreSpecific(this.type, paramT);
    if (localObject2 != this.type)
    {
      localObject1 = this.context.getAdapter(TypeToken.get((Type)localObject2));
      if ((localObject1 instanceof ReflectiveTypeAdapterFactory.Adapter))
      {
        localObject2 = this.delegate;
        if (!(localObject2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
          localObject1 = localObject2;
        }
      }
    }
    ((TypeAdapter)localObject1).write(paramJsonWriter, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper
 * JD-Core Version:    0.7.0.1
 */