package com.tencent.luggage.wxa.qz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  private static final Pattern a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  private static final Pattern b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
  private static final Pattern c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
  
  public static boolean a(String paramString)
  {
    return b.matcher(paramString).matches();
  }
  
  public static boolean b(String paramString)
  {
    return c.matcher(paramString).matches();
  }
  
  public static boolean c(String paramString)
  {
    return (a(paramString)) || (b(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.i
 * JD-Core Version:    0.7.0.1
 */