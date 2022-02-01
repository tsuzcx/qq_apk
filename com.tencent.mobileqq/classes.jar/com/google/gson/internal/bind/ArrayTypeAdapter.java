package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class ArrayTypeAdapter<E>
  extends TypeAdapter<Object>
{
  public static final TypeAdapterFactory FACTORY = new ArrayTypeAdapter.1();
  private final Class<E> componentType;
  private final TypeAdapter<E> componentTypeAdapter;
  
  public ArrayTypeAdapter(Gson paramGson, TypeAdapter<E> paramTypeAdapter, Class<E> paramClass)
  {
    this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(paramGson, paramTypeAdapter, paramClass);
    this.componentType = paramClass;
  }
  
  public Object read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      paramJsonReader = null;
      return paramJsonReader;
    }
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      localArrayList.add(this.componentTypeAdapter.read(paramJsonReader));
    }
    paramJsonReader.endArray();
    int j = localArrayList.size();
    Object localObject = Array.newInstance(this.componentType, j);
    int i = 0;
    for (;;)
    {
      paramJsonReader = localObject;
      if (i >= j) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
      i += 1;
    }
  }
  
  public void write(JsonWriter paramJsonWriter, Object paramObject)
  {
    if (paramObject == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.beginArray();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.componentTypeAdapter.write(paramJsonWriter, localObject);
      i += 1;
    }
    paramJsonWriter.endArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.ArrayTypeAdapter
 * JD-Core Version:    0.7.0.1
 */