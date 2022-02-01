package com.tencent.luggage.wxa.lo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

 enum b$a
{
  final DateFormat d;
  
  private b$a(DateFormat paramDateFormat)
  {
    this.d = paramDateFormat;
  }
  
  static a a(String paramString)
  {
    int j = Math.min(paramString.length(), 5);
    int i = 0;
    paramString = paramString.substring(0, Math.max(0, j)).toLowerCase();
    j = paramString.hashCode();
    if (j != 99228)
    {
      if (j != 3704893)
      {
        if ((j == 104080000) && (paramString.equals("month")))
        {
          i = 1;
          break label93;
        }
      }
      else if (paramString.equals("year")) {
        break label93;
      }
    }
    else if (paramString.equals("day"))
    {
      i = 2;
      break label93;
    }
    i = -1;
    label93:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return b;
        }
        return c;
      }
      return b;
    }
    return a;
  }
  
  Date b(String paramString)
  {
    try
    {
      paramString = this.d.parse(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label11:
      break label11;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.b.a
 * JD-Core Version:    0.7.0.1
 */