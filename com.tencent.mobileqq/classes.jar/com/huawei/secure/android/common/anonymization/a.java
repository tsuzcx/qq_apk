package com.huawei.secure.android.common.anonymization;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class a
{
  public static int a(@NonNull String paramString, char paramChar, int paramInt)
  {
    int i = paramString.length() - 1;
    int j = paramInt;
    paramInt = i;
    for (;;)
    {
      if (paramInt >= 0)
      {
        i = j;
        if (paramString.charAt(paramInt) == paramChar)
        {
          j -= 1;
          i = j;
          if (j > 0) {}
        }
      }
      else
      {
        return paramInt;
      }
      paramInt -= 1;
      j = i;
    }
  }
  
  public static String a(@Nullable String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2.length() <= 0) || (paramString3.length() <= 0)) {
      return paramString1;
    }
    char[] arrayOfChar = paramString1.toCharArray();
    paramString1 = new char[paramString1.length()];
    int j = paramString3.charAt(paramString3.length() - 1);
    int k = 0;
    while (k < arrayOfChar.length)
    {
      int i = arrayOfChar[k];
      int m = paramString2.lastIndexOf(i);
      if (m < 0)
      {
        paramString1[k] = i;
        k += 1;
      }
      else
      {
        if (m >= paramString3.length()) {}
        for (i = j;; i = paramString3.charAt(m))
        {
          paramString1[k] = i;
          break;
        }
      }
    }
    return new String(paramString1);
  }
  
  public static String a(String[] paramArrayOfString, int paramInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      return "";
    }
    if ((paramInt < 0) || (paramInt >= paramArrayOfString.length)) {
      return "";
    }
    return paramArrayOfString[paramInt];
  }
  
  public static String[] a(@Nullable String paramString, char paramChar)
  {
    if (paramString == null) {
      return new String[0];
    }
    if (paramString.length() <= 0) {
      return new String[] { paramString };
    }
    int j = 0;
    for (int i = 1; j < paramString.length(); i = k)
    {
      k = i;
      if (paramString.charAt(j) == paramChar) {
        k = i + 1;
      }
      j += 1;
    }
    if (i <= 1) {
      return new String[] { paramString };
    }
    String[] arrayOfString = new String[i];
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    j = 0;
    int k = 0;
    if ((j < paramString.length()) && (k < i))
    {
      char c = paramString.charAt(j);
      if (c == paramChar)
      {
        arrayOfString[k] = localStringBuilder.toString();
        localStringBuilder.setLength(0);
        k += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(c);
      }
    }
    arrayOfString[k] = localStringBuilder.toString();
    return arrayOfString;
  }
  
  public static String[] a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = split(paramString, paramInt1);
    return a(a(paramString, 0), split(a(paramString, 1), paramInt2 - paramInt1));
  }
  
  public static String[] a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramString = split(paramString, paramInt1);
    return a(a(paramString, 0), a(a(paramString, 1), paramInt2 - paramInt1, paramInt3 - paramInt1));
  }
  
  public static String[] a(@Nullable String paramString, int... paramVarArgs)
  {
    if (paramString == null) {
      return new String[] { "" };
    }
    if ((paramString.length() <= 1) || (paramVarArgs.length <= 0)) {
      return new String[] { paramString };
    }
    if (paramVarArgs.length <= 1) {
      return split(paramString, paramVarArgs[0]);
    }
    int j = paramVarArgs[0];
    int[] arrayOfInt = new int[paramVarArgs.length - 1];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = (paramVarArgs[(i + 1)] - j);
      i += 1;
    }
    paramString = split(paramString, j);
    return a(a(paramString, 0), a(a(paramString, 1), arrayOfInt));
  }
  
  public static String[] a(String paramString, String[] paramArrayOfString)
  {
    return a(new String[] { paramString }, paramArrayOfString);
  }
  
  public static String[] a(String[] paramArrayOfString, String paramString)
  {
    return a(paramArrayOfString, new String[] { paramString });
  }
  
  public static String[] a(@NonNull String[] paramArrayOfString1, @NonNull String[] paramArrayOfString2)
  {
    if (paramArrayOfString1.length <= 0)
    {
      paramArrayOfString1 = paramArrayOfString2;
      if (paramArrayOfString2.length <= 0) {
        paramArrayOfString1 = new String[0];
      }
      return paramArrayOfString1;
    }
    if (paramArrayOfString2.length <= 0) {
      return paramArrayOfString1;
    }
    String[] arrayOfString = new String[paramArrayOfString1.length + paramArrayOfString2.length];
    System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, paramArrayOfString1.length);
    System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length, paramArrayOfString2.length);
    return arrayOfString;
  }
  
  public static String b(String paramString, char paramChar)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    paramString = new char[paramString.length()];
    int i = 0;
    while (i < paramString.length)
    {
      paramString[i] = paramChar;
      i += 1;
    }
    return new String(paramString);
  }
  
  public static String b(@NonNull String paramString, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] != null) {
        localStringBuilder.append(paramString).append(paramVarArgs[i]);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String[] split(@Nullable String paramString, int paramInt)
  {
    if (paramString == null) {
      return new String[] { "", "" };
    }
    if ((paramInt < 0) || (paramInt > paramString.length())) {
      return new String[] { paramString, "" };
    }
    return new String[] { paramString.substring(0, paramInt), paramString.substring(paramInt) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.anonymization.a
 * JD-Core Version:    0.7.0.1
 */