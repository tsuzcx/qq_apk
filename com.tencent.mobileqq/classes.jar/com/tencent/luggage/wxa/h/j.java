package com.tencent.luggage.wxa.h;

import java.util.HashSet;

public final class j
{
  private static final HashSet<String> a = new HashSet();
  private static String b = "goog.exo.core";
  
  public static String a()
  {
    try
    {
      String str = b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (a.add(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(b);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString);
        b = localStringBuilder.toString();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.j
 * JD-Core Version:    0.7.0.1
 */