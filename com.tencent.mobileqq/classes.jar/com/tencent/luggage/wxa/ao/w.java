package com.tencent.luggage.wxa.ao;

import android.net.Uri;
import android.text.TextUtils;

public final class w
{
  public static Uri a(String paramString1, String paramString2)
  {
    return Uri.parse(b(paramString1, paramString2));
  }
  
  private static String a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return paramStringBuilder.toString();
    }
    int i = paramInt1;
    if (paramStringBuilder.charAt(paramInt1) == '/') {
      i = paramInt1 + 1;
    }
    paramInt1 = i;
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = j;
    j = paramInt2;
    for (;;)
    {
      if (j > paramInt1) {
        break label207;
      }
      int k;
      if (j == paramInt1)
      {
        k = j;
      }
      else
      {
        if (paramStringBuilder.charAt(j) != '/') {
          break label198;
        }
        k = j + 1;
      }
      int m = paramInt2 + 1;
      if ((j == m) && (paramStringBuilder.charAt(paramInt2) == '.'))
      {
        paramStringBuilder.delete(paramInt2, k);
        paramInt1 -= k - paramInt2;
        break;
      }
      if ((j == paramInt2 + 2) && (paramStringBuilder.charAt(paramInt2) == '.') && (paramStringBuilder.charAt(m) == '.'))
      {
        paramInt2 = paramStringBuilder.lastIndexOf("/", paramInt2 - 2) + 1;
        if (paramInt2 > i) {
          j = paramInt2;
        } else {
          j = i;
        }
        paramStringBuilder.delete(j, k);
        paramInt1 -= k - j;
      }
      else
      {
        paramInt2 = j + 1;
      }
      break;
      label198:
      j += 1;
    }
    label207:
    return paramStringBuilder.toString();
  }
  
  private static int[] a(String paramString)
  {
    int[] arrayOfInt = new int[4];
    if (TextUtils.isEmpty(paramString))
    {
      arrayOfInt[0] = -1;
      return arrayOfInt;
    }
    int j = paramString.length();
    int i = paramString.indexOf('#');
    if (i != -1) {
      j = i;
    }
    int k = paramString.indexOf('?');
    if (k != -1)
    {
      i = k;
      if (k <= j) {}
    }
    else
    {
      i = j;
    }
    int m = paramString.indexOf('/');
    if (m != -1)
    {
      k = m;
      if (m <= i) {}
    }
    else
    {
      k = i;
    }
    int n = paramString.indexOf(':');
    m = n;
    if (n > k) {
      m = -1;
    }
    k = m + 2;
    if ((k < i) && (paramString.charAt(m + 1) == '/') && (paramString.charAt(k) == '/')) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      n = paramString.indexOf('/', m + 3);
      if (n != -1)
      {
        k = n;
        if (n <= i) {}
      }
      else
      {
        k = i;
      }
    }
    else
    {
      k = m + 1;
    }
    arrayOfInt[0] = m;
    arrayOfInt[1] = k;
    arrayOfInt[2] = i;
    arrayOfInt[3] = j;
    return arrayOfInt;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = a(paramString1);
    if (paramString2[0] != -1)
    {
      localStringBuilder.append(paramString1);
      a(localStringBuilder, paramString2[1], paramString2[2]);
      return localStringBuilder.toString();
    }
    int[] arrayOfInt = a(str);
    if (paramString2[3] == 0)
    {
      localStringBuilder.append(str, 0, arrayOfInt[3]);
      localStringBuilder.append(paramString1);
      return localStringBuilder.toString();
    }
    if (paramString2[2] == 0)
    {
      localStringBuilder.append(str, 0, arrayOfInt[2]);
      localStringBuilder.append(paramString1);
      return localStringBuilder.toString();
    }
    if (paramString2[1] != 0)
    {
      i = arrayOfInt[0] + 1;
      localStringBuilder.append(str, 0, i);
      localStringBuilder.append(paramString1);
      return a(localStringBuilder, paramString2[1] + i, i + paramString2[2]);
    }
    if (paramString1.charAt(paramString2[1]) == '/')
    {
      localStringBuilder.append(str, 0, arrayOfInt[1]);
      localStringBuilder.append(paramString1);
      return a(localStringBuilder, arrayOfInt[1], arrayOfInt[1] + paramString2[2]);
    }
    if ((arrayOfInt[0] + 2 < arrayOfInt[1]) && (arrayOfInt[1] == arrayOfInt[2]))
    {
      localStringBuilder.append(str, 0, arrayOfInt[1]);
      localStringBuilder.append('/');
      localStringBuilder.append(paramString1);
      return a(localStringBuilder, arrayOfInt[1], arrayOfInt[1] + paramString2[2] + 1);
    }
    int i = str.lastIndexOf('/', arrayOfInt[2] - 1);
    if (i == -1) {
      i = arrayOfInt[1];
    } else {
      i += 1;
    }
    localStringBuilder.append(str, 0, i);
    localStringBuilder.append(paramString1);
    return a(localStringBuilder, arrayOfInt[1], i + paramString2[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.w
 * JD-Core Version:    0.7.0.1
 */