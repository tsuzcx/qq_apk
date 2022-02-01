package com.tencent.mobileqq.app;

import android.text.TextUtils;

public class DiyDoutuHelper
{
  public static String a(String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf("diydoutu@");
      if (i >= 0)
      {
        paramString = paramString.substring(i, paramString.length());
        break label34;
      }
    }
    paramString = "";
    label34:
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf(".");
      str = paramString;
      if (i >= 0) {
        str = paramString.substring(0, i);
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiyDoutuHelper
 * JD-Core Version:    0.7.0.1
 */