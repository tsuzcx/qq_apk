package com.tencent.biz.qqcircle.bizparts.danmaku.util;

import android.os.Build.VERSION;
import android.util.SparseIntArray;
import com.tencent.mobileqq.text.EmotcationConstants;

public class EmotcationUtils
{
  public static String a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return paramString;
    }
    if (paramString == null) {
      return "";
    }
    if (paramString.length() <= 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length();
    int i = 0;
    while (i < k)
    {
      int m = paramString.codePointAt(i);
      if (EmotcationConstants.EMOJI_MAP.get(m, -1) != -1)
      {
        int j = i;
        if (m > 65535) {
          j = i + 1;
        }
        localStringBuilder.append("*");
        i = j;
      }
      else
      {
        localStringBuilder.append(paramString.charAt(i));
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.util.EmotcationUtils
 * JD-Core Version:    0.7.0.1
 */