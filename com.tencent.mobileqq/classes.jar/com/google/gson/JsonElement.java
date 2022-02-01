package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonElement
{
  public abstract JsonElement deepCopy();
  
  public BigDecimal getAsBigDecimal()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public BigInteger getAsBigInteger()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean getAsBoolean()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  Boolean getAsBooleanWrapper()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public byte getAsByte()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public char getAsCharacter()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public double getAsDouble()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public float getAsFloat()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public int getAsInt()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public JsonArray getAsJsonArray()
  {
    if (isJsonArray()) {
      return (JsonArray)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Array: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public JsonNull getAsJsonNull()
  {
    if (isJsonNull()) {
      return (JsonNull)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Null: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public JsonObject getAsJsonObject()
  {
    if (isJsonObject()) {
      return (JsonObject)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Object: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public JsonPrimitive getAsJsonPrimitive()
  {
    if (isJsonPrimitive()) {
      return (JsonPrimitive)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Primitive: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public long getAsLong()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public Number getAsNumber()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public short getAsShort()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String getAsString()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean isJsonArray()
  {
    return this instanceof JsonArray;
  }
  
  public boolean isJsonNull()
  {
    return this instanceof JsonNull;
  }
  
  public boolean isJsonObject()
  {
    return this instanceof JsonObject;
  }
  
  public boolean isJsonPrimitive()
  {
    return this instanceof JsonPrimitive;
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      JsonWriter localJsonWriter = new JsonWriter((Writer)localObject);
      localJsonWriter.setLenient(true);
      Streams.write(this, localJsonWriter);
      localObject = ((StringWriter)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.JsonElement
 * JD-Core Version:    0.7.0.1
 */