package com.tencent.luggage.wxa.ak;

import com.tencent.luggage.wxa.ao.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  private static final Pattern a = Pattern.compile("^NOTE(( |\t).*)?$");
  private static final Pattern b = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");
  
  public static long a(String paramString)
  {
    paramString = paramString.split("\\.", 2);
    int i = 0;
    String[] arrayOfString = paramString[0].split(":");
    int j = arrayOfString.length;
    long l = 0L;
    while (i < j)
    {
      l = l * 60L + Long.parseLong(arrayOfString[i]);
      i += 1;
    }
    return (l * 1000L + Long.parseLong(paramString[1])) * 1000L;
  }
  
  public static void a(m paramm)
  {
    paramm = paramm.y();
    if ((paramm != null) && (b.matcher(paramm).matches())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected WEBVTT. Got ");
    localStringBuilder.append(paramm);
    throw new com.tencent.luggage.wxa.ad.f(localStringBuilder.toString());
  }
  
  public static float b(String paramString)
  {
    if (paramString.endsWith("%")) {
      return Float.parseFloat(paramString.substring(0, paramString.length() - 1)) / 100.0F;
    }
    throw new NumberFormatException("Percentages must end with %");
  }
  
  public static Matcher b(m paramm)
  {
    Object localObject;
    do
    {
      localObject = paramm.y();
      if (localObject == null) {
        break;
      }
      if (a.matcher((CharSequence)localObject).matches()) {
        for (;;)
        {
          localObject = paramm.y();
          if ((localObject == null) || (((String)localObject).isEmpty())) {
            break;
          }
        }
      }
      localObject = f.a.matcher((CharSequence)localObject);
    } while (!((Matcher)localObject).matches());
    return localObject;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ak.h
 * JD-Core Version:    0.7.0.1
 */