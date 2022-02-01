package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public final class TreeTypeAdapter<T>
  extends TypeAdapter<T>
{
  private final TreeTypeAdapter<T>.GsonContextImpl context = new TreeTypeAdapter.GsonContextImpl(this, null);
  private TypeAdapter<T> delegate;
  private final JsonDeserializer<T> deserializer;
  final Gson gson;
  private final JsonSerializer<T> serializer;
  private final TypeAdapterFactory skipPast;
  private final TypeToken<T> typeToken;
  
  public TreeTypeAdapter(JsonSerializer<T> paramJsonSerializer, JsonDeserializer<T> paramJsonDeserializer, Gson paramGson, TypeToken<T> paramTypeToken, TypeAdapterFactory paramTypeAdapterFactory)
  {
    this.serializer = paramJsonSerializer;
    this.deserializer = paramJsonDeserializer;
    this.gson = paramGson;
    this.typeToken = paramTypeToken;
    this.skipPast = paramTypeAdapterFactory;
  }
  
  private TypeAdapter<T> delegate()
  {
    TypeAdapter localTypeAdapter = this.delegate;
    if (localTypeAdapter != null) {
      return localTypeAdapter;
    }
    localTypeAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
    this.delegate = localTypeAdapter;
    return localTypeAdapter;
  }
  
  public static TypeAdapterFactory newFactory(TypeToken<?> paramTypeToken, Object paramObject)
  {
    return new TreeTypeAdapter.SingleTypeFactory(paramObject, paramTypeToken, false, null);
  }
  
  public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> paramTypeToken, Object paramObject)
  {
    boolean bool;
    if (paramTypeToken.getType() == paramTypeToken.getRawType()) {
      bool = true;
    } else {
      bool = false;
    }
    return new TreeTypeAdapter.SingleTypeFactory(paramObject, paramTypeToken, bool, null);
  }
  
  public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> paramClass, Object paramObject)
  {
    return new TreeTypeAdapter.SingleTypeFactory(paramObject, null, false, paramClass);
  }
  
  public T read(JsonReader paramJsonReader)
  {
    if (this.deserializer == null) {
      return delegate().read(paramJsonReader);
    }
    paramJsonReader = Streams.parse(paramJsonReader);
    if (paramJsonReader.isJsonNull()) {
      return null;
    }
    return this.deserializer.deserialize(paramJsonReader, this.typeToken.getType(), this.context);
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
  {
    JsonSerializer localJsonSerializer = this.serializer;
    if (localJsonSerializer == null)
    {
      delegate().write(paramJsonWriter, paramT);
      return;
    }
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    Streams.write(localJsonSerializer.serialize(paramT, this.typeToken.getType(), this.context), paramJsonWriter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TreeTypeAdapter
 * JD-Core Version:    0.7.0.1
 */