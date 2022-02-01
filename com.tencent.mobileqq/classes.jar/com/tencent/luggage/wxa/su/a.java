package com.tencent.luggage.wxa.su;

import java.util.HashMap;

public class a
{
  static HashMap<String, a.a> a = new HashMap();
  
  public static a.a a(String paramString)
  {
    try
    {
      if (!a.containsKey(paramString)) {
        a.put(paramString, new a.a(paramString));
      }
      paramString = (a.a)a.get(paramString);
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.a
 * JD-Core Version:    0.7.0.1
 */