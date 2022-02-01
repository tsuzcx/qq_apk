package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter
  extends JsonWriter
{
  private static final JsonPrimitive SENTINEL_CLOSED = new JsonPrimitive("closed");
  private static final Writer UNWRITABLE_WRITER = new JsonTreeWriter.1();
  private String pendingName;
  private JsonElement product = JsonNull.INSTANCE;
  private final List<JsonElement> stack = new ArrayList();
  
  public JsonTreeWriter()
  {
    super(UNWRITABLE_WRITER);
  }
  
  private JsonElement peek()
  {
    List localList = this.stack;
    return (JsonElement)localList.get(localList.size() - 1);
  }
  
  private void put(JsonElement paramJsonElement)
  {
    if (this.pendingName != null)
    {
      if ((!paramJsonElement.isJsonNull()) || (getSerializeNulls())) {
        ((JsonObject)peek()).add(this.pendingName, paramJsonElement);
      }
      this.pendingName = null;
      return;
    }
    if (this.stack.isEmpty())
    {
      this.product = paramJsonElement;
      return;
    }
    JsonElement localJsonElement = peek();
    if ((localJsonElement instanceof JsonArray))
    {
      ((JsonArray)localJsonElement).add(paramJsonElement);
      return;
    }
    throw new IllegalStateException();
  }
  
  public JsonWriter beginArray()
  {
    JsonArray localJsonArray = new JsonArray();
    put(localJsonArray);
    this.stack.add(localJsonArray);
    return this;
  }
  
  public JsonWriter beginObject()
  {
    JsonObject localJsonObject = new JsonObject();
    put(localJsonObject);
    this.stack.add(localJsonObject);
    return this;
  }
  
  public void close()
  {
    if (this.stack.isEmpty())
    {
      this.stack.add(SENTINEL_CLOSED);
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public JsonWriter endArray()
  {
    if ((!this.stack.isEmpty()) && (this.pendingName == null))
    {
      if ((peek() instanceof JsonArray))
      {
        List localList = this.stack;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public JsonWriter endObject()
  {
    if ((!this.stack.isEmpty()) && (this.pendingName == null))
    {
      if ((peek() instanceof JsonObject))
      {
        List localList = this.stack;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public void flush() {}
  
  public JsonElement get()
  {
    if (this.stack.isEmpty()) {
      return this.product;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected one JSON element but was ");
    localStringBuilder.append(this.stack);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public JsonWriter name(String paramString)
  {
    if ((!this.stack.isEmpty()) && (this.pendingName == null))
    {
      if ((peek() instanceof JsonObject))
      {
        this.pendingName = paramString;
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public JsonWriter nullValue()
  {
    put(JsonNull.INSTANCE);
    return this;
  }
  
  public JsonWriter value(double paramDouble)
  {
    if ((!isLenient()) && ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSON forbids NaN and infinities: ");
      localStringBuilder.append(paramDouble);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    put(new JsonPrimitive(Double.valueOf(paramDouble)));
    return this;
  }
  
  public JsonWriter value(long paramLong)
  {
    put(new JsonPrimitive(Long.valueOf(paramLong)));
    return this;
  }
  
  public JsonWriter value(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return nullValue();
    }
    put(new JsonPrimitive(paramBoolean));
    return this;
  }
  
  public JsonWriter value(Number paramNumber)
  {
    if (paramNumber == null) {
      return nullValue();
    }
    if (!isLenient())
    {
      double d = paramNumber.doubleValue();
      if ((Double.isNaN(d)) || (Double.isInfinite(d)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("JSON forbids NaN and infinities: ");
        localStringBuilder.append(paramNumber);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    put(new JsonPrimitive(paramNumber));
    return this;
  }
  
  public JsonWriter value(String paramString)
  {
    if (paramString == null) {
      return nullValue();
    }
    put(new JsonPrimitive(paramString));
    return this;
  }
  
  public JsonWriter value(boolean paramBoolean)
  {
    put(new JsonPrimitive(Boolean.valueOf(paramBoolean)));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.JsonTreeWriter
 * JD-Core Version:    0.7.0.1
 */