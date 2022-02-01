package com.google.gson.internal;

import java.math.BigDecimal;

public final class LazilyParsedNumber
  extends Number
{
  private final String value;
  
  public LazilyParsedNumber(String paramString)
  {
    this.value = paramString;
  }
  
  private Object writeReplace()
  {
    return new BigDecimal(this.value);
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(this.value);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof LazilyParsedNumber))
    {
      Object localObject = (LazilyParsedNumber)paramObject;
      paramObject = this.value;
      localObject = ((LazilyParsedNumber)localObject).value;
      if (paramObject != localObject)
      {
        if (paramObject.equals(localObject)) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public float floatValue()
  {
    return Float.parseFloat(this.value);
  }
  
  public int hashCode()
  {
    return this.value.hashCode();
  }
  
  public int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.value);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label10:
      long l;
      label21:
      break label10;
    }
    try
    {
      l = Long.parseLong(this.value);
      return (int)l;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label21;
    }
    return new BigDecimal(this.value).intValue();
  }
  
  public long longValue()
  {
    try
    {
      long l = Long.parseLong(this.value);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label10:
      break label10;
    }
    return new BigDecimal(this.value).longValue();
  }
  
  public String toString()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.LazilyParsedNumber
 * JD-Core Version:    0.7.0.1
 */