package com.tencent.beacon.pack;

import java.io.Serializable;

public final class ValueType
  implements Serializable
{
  public static final ValueType BYTE = new ValueType(1, 1, "BYTE");
  public static final int BYTE_VAL = 1;
  public static final ValueType MAP = new ValueType(0, 0, "MAP");
  public static final int MAP_VAL = 0;
  public static final ValueType UNKNOWN = new ValueType(2, 2, "UNKNOWN");
  public static final int UNKNOWN_VAL = 2;
  private static ValueType[] values = new ValueType[3];
  private String t;
  private int value;
  
  private ValueType(int paramInt1, int paramInt2, String paramString)
  {
    this.t = paramString;
    this.value = paramInt2;
    values[paramInt1] = this;
  }
  
  public static ValueType convert(int paramInt)
  {
    ValueType[] arrayOfValueType = values;
    int j = arrayOfValueType.length;
    int i = 0;
    while (i < j)
    {
      ValueType localValueType = arrayOfValueType[i];
      if (localValueType.value() == paramInt) {
        return localValueType;
      }
      i += 1;
    }
    return null;
  }
  
  public static ValueType convert(String paramString)
  {
    ValueType[] arrayOfValueType = values;
    int j = arrayOfValueType.length;
    int i = 0;
    while (i < j)
    {
      ValueType localValueType = arrayOfValueType[i];
      if (localValueType.toString().equals(paramString)) {
        return localValueType;
      }
      i += 1;
    }
    return null;
  }
  
  public String toString()
  {
    return this.t;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.pack.ValueType
 * JD-Core Version:    0.7.0.1
 */