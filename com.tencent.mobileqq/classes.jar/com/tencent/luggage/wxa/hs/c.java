package com.tencent.luggage.wxa.hs;

public class c
{
  public static final String a(String paramString1, String paramString2)
  {
    if ((!paramString1.contains(":")) && (paramString1.length() >= 1)) {
      return paramString1;
    }
    paramString1 = paramString1.split(":");
    if ((paramString1[0] != null) && (paramString1[0].length() > 0)) {
      return paramString1[0];
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hs.c
 * JD-Core Version:    0.7.0.1
 */