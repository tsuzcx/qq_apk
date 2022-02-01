package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class TypeAdapters$29
  extends TypeAdapter<JsonElement>
{
  public JsonElement read(JsonReader paramJsonReader)
  {
    Object localObject;
    switch (TypeAdapters.36.$SwitchMap$com$google$gson$stream$JsonToken[paramJsonReader.peek().ordinal()])
    {
    default: 
      throw new IllegalArgumentException();
    case 6: 
      localObject = new JsonObject();
      paramJsonReader.beginObject();
      while (paramJsonReader.hasNext()) {
        ((JsonObject)localObject).add(paramJsonReader.nextName(), read(paramJsonReader));
      }
      paramJsonReader.endObject();
      return localObject;
    case 5: 
      localObject = new JsonArray();
      paramJsonReader.beginArray();
      while (paramJsonReader.hasNext()) {
        ((JsonArray)localObject).add(read(paramJsonReader));
      }
      paramJsonReader.endArray();
      return localObject;
    case 4: 
      paramJsonReader.nextNull();
      return JsonNull.INSTANCE;
    case 3: 
      return new JsonPrimitive(paramJsonReader.nextString());
    case 2: 
      return new JsonPrimitive(Boolean.valueOf(paramJsonReader.nextBoolean()));
    }
    return new JsonPrimitive(new LazilyParsedNumber(paramJsonReader.nextString()));
  }
  
  public void write(JsonWriter paramJsonWriter, JsonElement paramJsonElement)
  {
    if ((paramJsonElement != null) && (!paramJsonElement.isJsonNull()))
    {
      if (paramJsonElement.isJsonPrimitive())
      {
        paramJsonElement = paramJsonElement.getAsJsonPrimitive();
        if (paramJsonElement.isNumber())
        {
          paramJsonWriter.value(paramJsonElement.getAsNumber());
          return;
        }
        if (paramJsonElement.isBoolean())
        {
          paramJsonWriter.value(paramJsonElement.getAsBoolean());
          return;
        }
        paramJsonWriter.value(paramJsonElement.getAsString());
        return;
      }
      if (paramJsonElement.isJsonArray())
      {
        paramJsonWriter.beginArray();
        paramJsonElement = paramJsonElement.getAsJsonArray().iterator();
        while (paramJsonElement.hasNext()) {
          write(paramJsonWriter, (JsonElement)paramJsonElement.next());
        }
        paramJsonWriter.endArray();
        return;
      }
      if (paramJsonElement.isJsonObject())
      {
        paramJsonWriter.beginObject();
        paramJsonElement = paramJsonElement.getAsJsonObject().entrySet().iterator();
        while (paramJsonElement.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramJsonElement.next();
          paramJsonWriter.name((String)localEntry.getKey());
          write(paramJsonWriter, (JsonElement)localEntry.getValue());
        }
        paramJsonWriter.endObject();
        return;
      }
      paramJsonWriter = new StringBuilder();
      paramJsonWriter.append("Couldn't write ");
      paramJsonWriter.append(paramJsonElement.getClass());
      throw new IllegalArgumentException(paramJsonWriter.toString());
    }
    paramJsonWriter.nullValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.29
 * JD-Core Version:    0.7.0.1
 */