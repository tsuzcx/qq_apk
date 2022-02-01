package com.tencent.avgame.util;

import android.graphics.Paint;
import android.text.TextUtils;

public class ContactUtils
{
  public static Paint a = new Paint();
  
  public static float a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      a.setTextSize(36.0F);
      return a.measureText(paramString) / 36.0F;
    }
    return 1.0F;
  }
  
  public static String a(String paramString, float paramFloat)
  {
    Object localObject = paramString;
    if (a(paramString) > paramFloat)
    {
      int i = Math.max(0, (int)(paramFloat - 3.0F));
      int j = i;
      while (i < paramString.length())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, i));
        ((StringBuilder)localObject).append("…");
        if (a(((StringBuilder)localObject).toString()) > paramFloat) {
          break;
        }
        j = i;
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, j));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.ContactUtils
 * JD-Core Version:    0.7.0.1
 */