package com.tencent.beacon.base.util;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class f
{
  public static String a(String paramString)
  {
    return paramString.trim().replace(" ", "").replace("\t", "").replace("&", "").replace(":", "").replace("=", "").replace(";", "");
  }
  
  public static void a(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] == null) {
        paramArrayOfString[i] = "";
      }
      i += 1;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      boolean bool = Charset.forName("ISO-8859-1").newEncoder().canEncode(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      c.a(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.util.f
 * JD-Core Version:    0.7.0.1
 */