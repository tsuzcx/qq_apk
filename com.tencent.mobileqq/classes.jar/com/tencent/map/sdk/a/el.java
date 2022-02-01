package com.tencent.map.sdk.a;

import java.math.BigInteger;

public final class el
  extends Number
{
  private final String a;
  
  public el(String paramString)
  {
    this.a = paramString;
  }
  
  public final double doubleValue()
  {
    return Double.parseDouble(this.a);
  }
  
  public final float floatValue()
  {
    return Float.parseFloat(this.a);
  }
  
  public final int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.a);
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
      l = Long.parseLong(this.a);
      return (int)l;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label21;
    }
    return new BigInteger(this.a).intValue();
  }
  
  public final long longValue()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label10:
      break label10;
    }
    return new BigInteger(this.a).longValue();
  }
  
  public final String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.el
 * JD-Core Version:    0.7.0.1
 */