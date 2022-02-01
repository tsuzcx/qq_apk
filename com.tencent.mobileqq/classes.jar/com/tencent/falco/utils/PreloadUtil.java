package com.tencent.falco.utils;

import android.text.TextUtils;

public class PreloadUtil
{
  public static boolean a(String paramString, int paramInt)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains(".flv")) && (paramInt == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.PreloadUtil
 * JD-Core Version:    0.7.0.1
 */