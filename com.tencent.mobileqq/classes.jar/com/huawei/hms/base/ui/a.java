package com.huawei.hms.base.ui;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public static final Pattern a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int m = paramString.length();
    int j = 1;
    if (1 == m) {
      return String.valueOf('*');
    }
    StringBuilder localStringBuilder = new StringBuilder(m);
    int i = 0;
    while (i < m)
    {
      char c1 = paramString.charAt(i);
      int k = j;
      char c2 = c1;
      if (a.matcher(String.valueOf(c1)).matches())
      {
        if (j % 2 == 0) {
          c1 = '*';
        }
        k = j + 1;
        c2 = c1;
      }
      localStringBuilder.append(c2);
      i += 1;
      j = k;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    if (!TextUtils.isEmpty(paramString)) {
      if (paramBoolean) {
        localStringBuilder.append(a(paramString));
      } else {
        localStringBuilder.append(paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.e(paramString1, a(paramString2, false));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.e(paramString1, a(paramString2, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.base.ui.a
 * JD-Core Version:    0.7.0.1
 */