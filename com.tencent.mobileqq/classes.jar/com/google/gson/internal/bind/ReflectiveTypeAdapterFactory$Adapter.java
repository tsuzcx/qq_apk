package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory$Adapter<T>
  extends TypeAdapter<T>
{
  private final Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields;
  private final ObjectConstructor<T> constructor;
  
  ReflectiveTypeAdapterFactory$Adapter(ObjectConstructor<T> paramObjectConstructor, Map<String, ReflectiveTypeAdapterFactory.BoundField> paramMap)
  {
    this.constructor = paramObjectConstructor;
    this.boundFields = paramMap;
  }
  
  public T read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    Object localObject1 = this.constructor.construct();
    try
    {
      paramJsonReader.beginObject();
      while (paramJsonReader.hasNext())
      {
        Object localObject2 = paramJsonReader.nextName();
        localObject2 = (ReflectiveTypeAdapterFactory.BoundField)this.boundFields.get(localObject2);
        if ((localObject2 != null) && (((ReflectiveTypeAdapterFactory.BoundField)localObject2).deserialized)) {
          ((ReflectiveTypeAdapterFactory.BoundField)localObject2).read(paramJsonReader, localObject1);
        } else {
          paramJsonReader.skipValue();
        }
      }
      paramJsonReader.endObject();
      return localObject1;
    }
    catch (IllegalAccessException paramJsonReader)
    {
      throw new AssertionError(paramJsonReader);
    }
    catch (IllegalStateException paramJsonReader)
    {
      paramJsonReader = new JsonSyntaxException(paramJsonReader);
    }
    for (;;)
    {
      throw paramJsonReader;
    }
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
  {
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.beginObject();
    try
    {
      Iterator localIterator = this.boundFields.values().iterator();
      while (localIterator.hasNext())
      {
        ReflectiveTypeAdapterFactory.BoundField localBoundField = (ReflectiveTypeAdapterFactory.BoundField)localIterator.next();
        if (localBoundField.writeField(paramT))
        {
          paramJsonWriter.name(localBoundField.name);
          localBoundField.write(paramJsonWriter, paramT);
        }
      }
      paramJsonWriter.endObject();
      return;
    }
    catch (IllegalAccessException paramJsonWriter)
    {
      paramJsonWriter = new AssertionError(paramJsonWriter);
    }
    for (;;)
    {
      throw paramJsonWriter;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
 * JD-Core Version:    0.7.0.1
 */