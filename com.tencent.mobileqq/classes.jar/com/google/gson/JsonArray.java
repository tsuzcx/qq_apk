package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray
  extends JsonElement
  implements Iterable<JsonElement>
{
  private final List<JsonElement> elements;
  
  public JsonArray()
  {
    this.elements = new ArrayList();
  }
  
  public JsonArray(int paramInt)
  {
    this.elements = new ArrayList(paramInt);
  }
  
  public void add(JsonElement paramJsonElement)
  {
    Object localObject = paramJsonElement;
    if (paramJsonElement == null) {
      localObject = JsonNull.INSTANCE;
    }
    this.elements.add(localObject);
  }
  
  public void add(Boolean paramBoolean)
  {
    List localList = this.elements;
    if (paramBoolean == null) {
      paramBoolean = JsonNull.INSTANCE;
    } else {
      paramBoolean = new JsonPrimitive(paramBoolean);
    }
    localList.add(paramBoolean);
  }
  
  public void add(Character paramCharacter)
  {
    List localList = this.elements;
    if (paramCharacter == null) {
      paramCharacter = JsonNull.INSTANCE;
    } else {
      paramCharacter = new JsonPrimitive(paramCharacter);
    }
    localList.add(paramCharacter);
  }
  
  public void add(Number paramNumber)
  {
    List localList = this.elements;
    if (paramNumber == null) {
      paramNumber = JsonNull.INSTANCE;
    } else {
      paramNumber = new JsonPrimitive(paramNumber);
    }
    localList.add(paramNumber);
  }
  
  public void add(String paramString)
  {
    List localList = this.elements;
    if (paramString == null) {
      paramString = JsonNull.INSTANCE;
    } else {
      paramString = new JsonPrimitive(paramString);
    }
    localList.add(paramString);
  }
  
  public void addAll(JsonArray paramJsonArray)
  {
    this.elements.addAll(paramJsonArray.elements);
  }
  
  public boolean contains(JsonElement paramJsonElement)
  {
    return this.elements.contains(paramJsonElement);
  }
  
  public JsonArray deepCopy()
  {
    if (!this.elements.isEmpty())
    {
      JsonArray localJsonArray = new JsonArray(this.elements.size());
      Iterator localIterator = this.elements.iterator();
      while (localIterator.hasNext()) {
        localJsonArray.add(((JsonElement)localIterator.next()).deepCopy());
      }
      return localJsonArray;
    }
    return new JsonArray();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof JsonArray)) && (((JsonArray)paramObject).elements.equals(this.elements)));
  }
  
  public JsonElement get(int paramInt)
  {
    return (JsonElement)this.elements.get(paramInt);
  }
  
  public BigDecimal getAsBigDecimal()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsBigDecimal();
    }
    throw new IllegalStateException();
  }
  
  public BigInteger getAsBigInteger()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsBigInteger();
    }
    throw new IllegalStateException();
  }
  
  public boolean getAsBoolean()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsBoolean();
    }
    throw new IllegalStateException();
  }
  
  public byte getAsByte()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsByte();
    }
    throw new IllegalStateException();
  }
  
  public char getAsCharacter()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsCharacter();
    }
    throw new IllegalStateException();
  }
  
  public double getAsDouble()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsDouble();
    }
    throw new IllegalStateException();
  }
  
  public float getAsFloat()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsFloat();
    }
    throw new IllegalStateException();
  }
  
  public int getAsInt()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsInt();
    }
    throw new IllegalStateException();
  }
  
  public long getAsLong()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsLong();
    }
    throw new IllegalStateException();
  }
  
  public Number getAsNumber()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsNumber();
    }
    throw new IllegalStateException();
  }
  
  public short getAsShort()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsShort();
    }
    throw new IllegalStateException();
  }
  
  public String getAsString()
  {
    if (this.elements.size() == 1) {
      return ((JsonElement)this.elements.get(0)).getAsString();
    }
    throw new IllegalStateException();
  }
  
  public int hashCode()
  {
    return this.elements.hashCode();
  }
  
  public Iterator<JsonElement> iterator()
  {
    return this.elements.iterator();
  }
  
  public JsonElement remove(int paramInt)
  {
    return (JsonElement)this.elements.remove(paramInt);
  }
  
  public boolean remove(JsonElement paramJsonElement)
  {
    return this.elements.remove(paramJsonElement);
  }
  
  public JsonElement set(int paramInt, JsonElement paramJsonElement)
  {
    return (JsonElement)this.elements.set(paramInt, paramJsonElement);
  }
  
  public int size()
  {
    return this.elements.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.JsonArray
 * JD-Core Version:    0.7.0.1
 */