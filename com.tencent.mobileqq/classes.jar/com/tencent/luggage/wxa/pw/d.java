package com.tencent.luggage.wxa.pw;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;

public final class d
{
  private static int a(Class paramClass)
  {
    boolean bool = paramClass.isEnum();
    int i = 0;
    if (!bool) {
      return 0;
    }
    paramClass = paramClass.getEnumConstants();
    int k = paramClass.length;
    int j = 0;
    while (i < k)
    {
      j = Math.max(((Enum)paramClass[i]).name().length(), j);
      i += 1;
    }
    return j;
  }
  
  @Nullable
  static <T extends Enum> T a(String paramString, Class<T> paramClass)
  {
    int i = a(paramClass);
    if (!af.c(paramString))
    {
      if (paramString.length() > i) {
        return null;
      }
      paramString = paramString.toUpperCase();
      paramClass = (Enum[])paramClass.getEnumConstants();
      int j = paramClass.length;
      i = 0;
      while (i < j)
      {
        Enum localEnum = (Enum)paramClass[i];
        if (paramString.equals(localEnum.name())) {
          return localEnum;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static Integer a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Integer.valueOf(((Number)paramObject).intValue());
    }
    if ((paramObject instanceof String)) {}
    try
    {
      int i = (int)Double.parseDouble((String)paramObject);
      return Integer.valueOf(i);
    }
    catch (NumberFormatException paramObject) {}
    return null;
    return null;
  }
  
  static <T> T a(T paramT1, T paramT2)
  {
    T ? = paramT1;
    if (paramT1 == null) {
      ? = paramT2;
    }
    return ?;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pw.d
 * JD-Core Version:    0.7.0.1
 */