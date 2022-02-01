package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive
  extends JsonElement
{
  private static final Class<?>[] PRIMITIVE_TYPES = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  private Object value;
  
  public JsonPrimitive(Boolean paramBoolean)
  {
    setValue(paramBoolean);
  }
  
  public JsonPrimitive(Character paramCharacter)
  {
    setValue(paramCharacter);
  }
  
  public JsonPrimitive(Number paramNumber)
  {
    setValue(paramNumber);
  }
  
  JsonPrimitive(Object paramObject)
  {
    setValue(paramObject);
  }
  
  public JsonPrimitive(String paramString)
  {
    setValue(paramString);
  }
  
  private static boolean isIntegral(JsonPrimitive paramJsonPrimitive)
  {
    paramJsonPrimitive = paramJsonPrimitive.value;
    boolean bool3 = paramJsonPrimitive instanceof Number;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramJsonPrimitive = (Number)paramJsonPrimitive;
      if ((!(paramJsonPrimitive instanceof BigInteger)) && (!(paramJsonPrimitive instanceof Long)) && (!(paramJsonPrimitive instanceof Integer)) && (!(paramJsonPrimitive instanceof Short)))
      {
        bool1 = bool2;
        if (!(paramJsonPrimitive instanceof Byte)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean isPrimitiveOrString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return true;
    }
    paramObject = paramObject.getClass();
    Class[] arrayOfClass = PRIMITIVE_TYPES;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].isAssignableFrom(paramObject)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public JsonPrimitive deepCopy()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (JsonPrimitive)paramObject;
      if (this.value == null) {
        return paramObject.value == null;
      }
      if ((isIntegral(this)) && (isIntegral(paramObject))) {
        return getAsNumber().longValue() == paramObject.getAsNumber().longValue();
      }
      if (((this.value instanceof Number)) && ((paramObject.value instanceof Number)))
      {
        double d1 = getAsNumber().doubleValue();
        double d2 = paramObject.getAsNumber().doubleValue();
        if (d1 != d2)
        {
          if ((Double.isNaN(d1)) && (Double.isNaN(d2))) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      return this.value.equals(paramObject.value);
    }
    return false;
  }
  
  public BigDecimal getAsBigDecimal()
  {
    Object localObject = this.value;
    if ((localObject instanceof BigDecimal)) {
      return (BigDecimal)localObject;
    }
    return new BigDecimal(localObject.toString());
  }
  
  public BigInteger getAsBigInteger()
  {
    Object localObject = this.value;
    if ((localObject instanceof BigInteger)) {
      return (BigInteger)localObject;
    }
    return new BigInteger(localObject.toString());
  }
  
  public boolean getAsBoolean()
  {
    if (isBoolean()) {
      return getAsBooleanWrapper().booleanValue();
    }
    return Boolean.parseBoolean(getAsString());
  }
  
  Boolean getAsBooleanWrapper()
  {
    return (Boolean)this.value;
  }
  
  public byte getAsByte()
  {
    if (isNumber()) {
      return getAsNumber().byteValue();
    }
    return Byte.parseByte(getAsString());
  }
  
  public char getAsCharacter()
  {
    return getAsString().charAt(0);
  }
  
  public double getAsDouble()
  {
    if (isNumber()) {
      return getAsNumber().doubleValue();
    }
    return Double.parseDouble(getAsString());
  }
  
  public float getAsFloat()
  {
    if (isNumber()) {
      return getAsNumber().floatValue();
    }
    return Float.parseFloat(getAsString());
  }
  
  public int getAsInt()
  {
    if (isNumber()) {
      return getAsNumber().intValue();
    }
    return Integer.parseInt(getAsString());
  }
  
  public long getAsLong()
  {
    if (isNumber()) {
      return getAsNumber().longValue();
    }
    return Long.parseLong(getAsString());
  }
  
  public Number getAsNumber()
  {
    Object localObject = this.value;
    if ((localObject instanceof String)) {
      return new LazilyParsedNumber((String)localObject);
    }
    return (Number)localObject;
  }
  
  public short getAsShort()
  {
    if (isNumber()) {
      return getAsNumber().shortValue();
    }
    return Short.parseShort(getAsString());
  }
  
  public String getAsString()
  {
    if (isNumber()) {
      return getAsNumber().toString();
    }
    if (isBoolean()) {
      return getAsBooleanWrapper().toString();
    }
    return (String)this.value;
  }
  
  public int hashCode()
  {
    if (this.value == null) {
      return 31;
    }
    if (isIntegral(this)) {}
    Object localObject;
    for (long l = getAsNumber().longValue();; l = Double.doubleToLongBits(getAsNumber().doubleValue()))
    {
      return (int)(l >>> 32 ^ l);
      localObject = this.value;
      if (!(localObject instanceof Number)) {
        break;
      }
    }
    return localObject.hashCode();
  }
  
  public boolean isBoolean()
  {
    return this.value instanceof Boolean;
  }
  
  public boolean isNumber()
  {
    return this.value instanceof Number;
  }
  
  public boolean isString()
  {
    return this.value instanceof String;
  }
  
  void setValue(Object paramObject)
  {
    if ((paramObject instanceof Character))
    {
      this.value = String.valueOf(((Character)paramObject).charValue());
      return;
    }
    boolean bool;
    if ((!(paramObject instanceof Number)) && (!isPrimitiveOrString(paramObject))) {
      bool = false;
    } else {
      bool = true;
    }
    .Gson.Preconditions.checkArgument(bool);
    this.value = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.JsonPrimitive
 * JD-Core Version:    0.7.0.1
 */