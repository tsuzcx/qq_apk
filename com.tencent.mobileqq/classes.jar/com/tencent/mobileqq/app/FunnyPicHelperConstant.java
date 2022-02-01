package com.tencent.mobileqq.app;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class FunnyPicHelperConstant
{
  public static Set<String> a = new HashSet();
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf("qto_");
      if (i >= 0) {
        return paramString.substring(i, paramString.length());
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FunnyPicHelperConstant
 * JD-Core Version:    0.7.0.1
 */