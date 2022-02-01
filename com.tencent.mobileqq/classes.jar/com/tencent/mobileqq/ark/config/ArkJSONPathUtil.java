package com.tencent.mobileqq.ark.config;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ArkJSONPathUtil
{
  private static volatile ArkJSONPathUtil a;
  
  public static ArkJSONPathUtil a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ArkJSONPathUtil();
        }
      }
      finally {}
    }
    return a;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Pattern.compile("^\\[(\\d+)\\]$").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Pattern.compile("^\\[('|\")(.+)('|\")\\]$").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.ArkJSONPathUtil
 * JD-Core Version:    0.7.0.1
 */