package com.tencent.biz.common.util;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public class SubString
{
  public static int a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (j < paramString.length)
    {
      int k = i + 1;
      i = k;
      if (!a(paramString[j])) {
        i = k + 1;
      }
      j += 1;
    }
    return i;
  }
  
  public static final int a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return 0;
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = "UTF-8";
    }
    try
    {
      int i = paramString1.getBytes(paramString2).length;
      return i;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      label31:
      break label31;
    }
    return paramString1.length() * 3;
  }
  
  public static String a(String paramString, int paramInt)
  {
    try
    {
      paramString = paramString.getBytes("Unicode");
      i = 2;
      j = 0;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        int i;
        continue;
        label54:
        int k;
        do
        {
          k = j + 1;
          break;
          k = j;
        } while (paramString[i] != 0);
        i += 1;
        int j = k;
        continue;
        paramInt = i;
        if (i % 2 == 1)
        {
          paramInt = i - 1;
          if (paramString[paramInt] == 0) {
            paramInt = i + 1;
          }
        }
      }
    }
    if ((i < paramString.length) && (j < paramInt)) {
      if (i % 2 == 1)
      {
        break label54;
        paramString = new String(paramString, 0, paramInt, "Unicode");
        return paramString;
        return "";
      }
    }
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    if (a(paramString1) < paramInt) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramString1, paramInt));
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static final String a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = "UTF-8";
    }
    if (a(paramString1, paramString2) <= paramInt) {
      return paramString1;
    }
    int i = 0;
    int j = 0;
    while (i < paramString1.length())
    {
      int k = i + 1;
      j += a(paramString1.substring(i, k), paramString2);
      if (j > paramInt)
      {
        paramString2 = paramString1.substring(0, i);
        paramString1 = paramString2;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append(paramString3);
          paramString1 = paramString1.toString();
        }
        return paramString1;
      }
      i = k;
    }
    return paramString1;
  }
  
  public static boolean a(char paramChar)
  {
    return paramChar / '' == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.SubString
 * JD-Core Version:    0.7.0.1
 */