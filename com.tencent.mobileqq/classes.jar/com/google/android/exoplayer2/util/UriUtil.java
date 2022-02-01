package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;

public final class UriUtil
{
  private static final int FRAGMENT = 3;
  private static final int INDEX_COUNT = 4;
  private static final int PATH = 1;
  private static final int QUERY = 2;
  private static final int SCHEME_COLON = 0;
  
  private static int[] getUriIndices(String paramString)
  {
    int[] arrayOfInt = new int[4];
    if (TextUtils.isEmpty(paramString))
    {
      arrayOfInt[0] = -1;
      return arrayOfInt;
    }
    int j = paramString.length();
    int i = paramString.indexOf('#');
    if (i == -1) {}
    for (;;)
    {
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
      if ((m + 2 < i) && (paramString.charAt(m + 1) == '/') && (paramString.charAt(m + 2) == '/'))
      {
        k = 1;
        if (k == 0) {
          break label202;
        }
        n = paramString.indexOf('/', m + 3);
        if (n != -1)
        {
          k = n;
          if (n <= i) {
            break label173;
          }
        }
      }
      label173:
      label202:
      for (k = i;; k = m + 1)
      {
        arrayOfInt[0] = m;
        arrayOfInt[1] = k;
        arrayOfInt[2] = i;
        arrayOfInt[3] = j;
        return arrayOfInt;
        k = 0;
        break;
      }
      j = i;
    }
  }
  
  private static String removeDotSegments(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return paramStringBuilder.toString();
    }
    int i = paramInt1;
    if (paramStringBuilder.charAt(paramInt1) == '/') {
      i = paramInt1 + 1;
    }
    int k = i;
    paramInt1 = i;
    int j = paramInt2;
    paramInt2 = k;
    if (paramInt2 <= j)
    {
      if (paramInt2 == j)
      {
        k = paramInt2;
        label52:
        if ((paramInt2 != paramInt1 + 1) || (paramStringBuilder.charAt(paramInt1) != '.')) {
          break label122;
        }
        paramStringBuilder.delete(paramInt1, k);
        j -= k - paramInt1;
        k = paramInt1;
        paramInt2 = paramInt1;
        paramInt1 = k;
      }
      for (;;)
      {
        break;
        if (paramStringBuilder.charAt(paramInt2) == '/')
        {
          k = paramInt2 + 1;
          break label52;
        }
        paramInt2 += 1;
        break;
        label122:
        if ((paramInt2 == paramInt1 + 2) && (paramStringBuilder.charAt(paramInt1) == '.') && (paramStringBuilder.charAt(paramInt1 + 1) == '.'))
        {
          paramInt2 = paramStringBuilder.lastIndexOf("/", paramInt1 - 2) + 1;
          if (paramInt2 > i) {}
          for (paramInt1 = paramInt2;; paramInt1 = i)
          {
            paramStringBuilder.delete(paramInt1, k);
            j -= k - paramInt1;
            paramInt1 = paramInt2;
            break;
          }
        }
        paramInt2 += 1;
        paramInt1 = paramInt2;
      }
    }
    return paramStringBuilder.toString();
  }
  
  public static String resolve(String paramString1, String paramString2)
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
    paramString2 = getUriIndices(paramString1);
    if (paramString2[0] != -1)
    {
      localStringBuilder.append(paramString1);
      removeDotSegments(localStringBuilder, paramString2[1], paramString2[2]);
      return localStringBuilder.toString();
    }
    int[] arrayOfInt = getUriIndices(str);
    if (paramString2[3] == 0) {
      return paramString1;
    }
    if (paramString2[2] == 0) {
      return paramString1;
    }
    if (paramString2[1] != 0)
    {
      i = arrayOfInt[0] + 1;
      localStringBuilder.append(str, 0, i).append(paramString1);
      return removeDotSegments(localStringBuilder, paramString2[1] + i, i + paramString2[2]);
    }
    int j;
    if (paramString1.charAt(paramString2[1]) == '/')
    {
      localStringBuilder.append(str, 0, arrayOfInt[1]).append(paramString1);
      i = arrayOfInt[1];
      j = arrayOfInt[1];
      return removeDotSegments(localStringBuilder, i, paramString2[2] + j);
    }
    if ((arrayOfInt[0] + 2 < arrayOfInt[1]) && (arrayOfInt[1] == arrayOfInt[2]))
    {
      localStringBuilder.append(str, 0, arrayOfInt[1]).append('/').append(paramString1);
      i = arrayOfInt[1];
      j = arrayOfInt[1];
      return removeDotSegments(localStringBuilder, i, paramString2[2] + j + 1);
    }
    int i = str.lastIndexOf('/', arrayOfInt[2] - 1);
    if (i == -1) {
      i = arrayOfInt[1];
    }
    for (;;)
    {
      localStringBuilder.append(str, 0, i).append(paramString1);
      return removeDotSegments(localStringBuilder, arrayOfInt[1], i + paramString2[2]);
      i += 1;
    }
  }
  
  public static Uri resolveToUri(String paramString1, String paramString2)
  {
    return Uri.parse(resolve(paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.util.UriUtil
 * JD-Core Version:    0.7.0.1
 */