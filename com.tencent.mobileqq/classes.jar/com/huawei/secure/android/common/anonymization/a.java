package com.huawei.secure.android.common.anonymization;

public class a
{
  public static int a(String paramString, char paramChar, int paramInt)
  {
    int i = paramString.length() - 1;
    for (int j = paramInt; i >= 0; j = paramInt)
    {
      paramInt = j;
      if (paramString.charAt(i) == paramChar)
      {
        j -= 1;
        paramInt = j;
        if (j <= 0) {
          return i;
        }
      }
      i -= 1;
    }
    return i;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2.length() > 0))
    {
      if (paramString3.length() <= 0) {
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
        }
        else
        {
          if (m >= paramString3.length()) {
            i = j;
          } else {
            i = paramString3.charAt(m);
          }
          paramString1[k] = i;
        }
        k += 1;
      }
      return new String(paramString1);
    }
    return paramString1;
  }
  
  public static String a(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length <= 0) {
        return "";
      }
      if (paramInt >= 0)
      {
        if (paramInt >= paramArrayOfString.length) {
          return "";
        }
        return paramArrayOfString[paramInt];
      }
    }
    return "";
  }
  
  public static String[] a(String paramString, char paramChar)
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
    while ((j < paramString.length()) && (k < i))
    {
      char c = paramString.charAt(j);
      if (c == paramChar)
      {
        arrayOfString[k] = localStringBuilder.toString();
        localStringBuilder.setLength(0);
        k += 1;
      }
      else
      {
        localStringBuilder.append(c);
      }
      j += 1;
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
  
  public static String[] a(String paramString, int... paramVarArgs)
  {
    if (paramString == null) {
      return new String[] { "" };
    }
    if ((paramString.length() > 1) && (paramVarArgs.length > 0))
    {
      if (paramVarArgs.length <= 1) {
        return split(paramString, paramVarArgs[0]);
      }
      int k = paramVarArgs[0];
      int[] arrayOfInt = new int[paramVarArgs.length - 1];
      int j;
      for (int i = 0; i < arrayOfInt.length; i = j)
      {
        j = i + 1;
        paramVarArgs[j] -= k;
      }
      paramString = split(paramString, k);
      return a(a(paramString, 0), a(a(paramString, 1), arrayOfInt));
    }
    return new String[] { paramString };
  }
  
  public static String[] a(String paramString, String[] paramArrayOfString)
  {
    return a(new String[] { paramString }, paramArrayOfString);
  }
  
  public static String[] a(String[] paramArrayOfString, String paramString)
  {
    return a(paramArrayOfString, new String[] { paramString });
  }
  
  public static String[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString1.length <= 0)
    {
      if (paramArrayOfString2.length <= 0) {
        return new String[0];
      }
      return paramArrayOfString2;
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
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = new char[paramString.length()];
      int i = 0;
      while (i < paramString.length)
      {
        paramString[i] = paramChar;
        i += 1;
      }
      return new String(paramString);
    }
    return "";
  }
  
  public static String b(String paramString, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        if (paramVarArgs[i] != null)
        {
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramVarArgs[i]);
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String[] split(String paramString, int paramInt)
  {
    if (paramString == null) {
      return new String[] { "", "" };
    }
    if ((paramInt >= 0) && (paramInt <= paramString.length())) {
      return new String[] { paramString.substring(0, paramInt), paramString.substring(paramInt) };
    }
    return new String[] { paramString, "" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.anonymization.a
 * JD-Core Version:    0.7.0.1
 */