package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.reflect.TypeToken;

final class TreeTypeAdapter$SingleTypeFactory
  implements TypeAdapterFactory
{
  private final JsonDeserializer<?> deserializer;
  private final TypeToken<?> exactType;
  private final Class<?> hierarchyType;
  private final boolean matchRawType;
  private final JsonSerializer<?> serializer;
  
  TreeTypeAdapter$SingleTypeFactory(Object paramObject, TypeToken<?> paramTypeToken, boolean paramBoolean, Class<?> paramClass)
  {
    boolean bool = paramObject instanceof JsonSerializer;
    Object localObject2 = null;
    if (bool) {
      localObject1 = (JsonSerializer)paramObject;
    } else {
      localObject1 = null;
    }
    this.serializer = ((JsonSerializer)localObject1);
    Object localObject1 = localObject2;
    if ((paramObject instanceof JsonDeserializer)) {
      localObject1 = (JsonDeserializer)paramObject;
    }
    this.deserializer = ((JsonDeserializer)localObject1);
    if ((this.serializer == null) && (this.deserializer == null)) {
      bool = false;
    } else {
      bool = true;
    }
    .Gson.Preconditions.checkArgument(bool);
    this.exactType = paramTypeToken;
    this.matchRawType = paramBoolean;
    this.hierarchyType = paramClass;
  }
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    TypeToken localTypeToken = this.exactType;
    boolean bool;
    if (localTypeToken != null)
    {
      if ((!localTypeToken.equals(paramTypeToken)) && ((!this.matchRawType) || (this.exactType.getType() != paramTypeToken.getRawType()))) {
        bool = false;
      } else {
        bool = true;
      }
    }
    else {
      bool = this.hierarchyType.isAssignableFrom(paramTypeToken.getRawType());
    }
    if (bool) {
      return new TreeTypeAdapter(this.serializer, this.deserializer, paramGson, paramTypeToken, this);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory
 * JD-Core Version:    0.7.0.1
 */