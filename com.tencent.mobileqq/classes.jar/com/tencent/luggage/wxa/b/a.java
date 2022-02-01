package com.tencent.luggage.wxa.b;

import java.io.IOException;

public final class a
{
  public static final h a = new c("null");
  public static final h b = new c("true");
  public static final h c = new c("false");
  
  public static h a(double paramDouble)
  {
    if ((!Double.isInfinite(paramDouble)) && (!Double.isNaN(paramDouble))) {
      return new d(c(Double.toString(paramDouble)));
    }
    throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
  }
  
  public static h a(float paramFloat)
  {
    if ((!Float.isInfinite(paramFloat)) && (!Float.isNaN(paramFloat))) {
      return new d(c(Float.toString(paramFloat)));
    }
    throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
  }
  
  public static h a(int paramInt)
  {
    return new d(Integer.toString(paramInt, 10));
  }
  
  public static h a(long paramLong)
  {
    return new d(Long.toString(paramLong, 10));
  }
  
  public static h a(String paramString)
  {
    if (paramString == null) {
      return a;
    }
    return new g(paramString);
  }
  
  public static h a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b;
    }
    return c;
  }
  
  public static h b(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = new f(paramString).a();
        return paramString;
      }
      catch (IOException paramString)
      {
        throw new RuntimeException(paramString);
      }
    }
    throw new NullPointerException("string is null");
  }
  
  private static String c(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith(".0")) {
      str = paramString.substring(0, paramString.length() - 2);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.a
 * JD-Core Version:    0.7.0.1
 */