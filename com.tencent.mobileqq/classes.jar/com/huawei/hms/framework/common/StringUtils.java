package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.secure.android.common.util.SafeString;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class StringUtils
{
  private static final int INIT_CAPACITY = 1024;
  private static boolean IS_AEGIS_STRING_LIBRARY_LOADED = false;
  private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
  private static final String TAG = "StringUtils";
  
  public static String anonymizeMessage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if (i % 2 != 0) {
        paramString[i] = 42;
      }
      i += 1;
    }
    return new String(paramString);
  }
  
  public static String byte2Str(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", paramArrayOfByte);
    }
    return "";
  }
  
  private static boolean checkCompatible(String paramString)
  {
    ClassLoader localClassLoader = SecurityBase64Utils.class.getClassLoader();
    if (localClassLoader == null) {
      return false;
    }
    try
    {
      localClassLoader.loadClass(paramString);
      try
      {
        IS_AEGIS_STRING_LIBRARY_LOADED = true;
        return true;
      }
      finally {}
      return false;
    }
    catch (ClassNotFoundException paramString) {}
  }
  
  public static String format(String paramString, Object... paramVarArgs)
  {
    if (paramString == null) {
      return "";
    }
    return String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  public static byte[] getBytes(long paramLong)
  {
    return getBytes(String.valueOf(paramLong));
  }
  
  public static byte[] getBytes(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    if (paramString == null) {
      return arrayOfByte;
    }
    try
    {
      paramString = paramString.getBytes("utf-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label19:
      break label19;
    }
    Logger.w("StringUtils", "the content has error while it is converted to bytes");
    return arrayOfByte;
  }
  
  public static String getTraceInfo(Throwable paramThrowable)
  {
    paramThrowable = paramThrowable.getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder(1024);
    int j = paramThrowable.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramThrowable[i];
      localStringBuilder.append("at ");
      localStringBuilder.append(localObject.toString());
      localStringBuilder.append(";");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String replace(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    String str;
    if ((!IS_AEGIS_STRING_LIBRARY_LOADED) && (!checkCompatible("com.huawei.secure.android.common.util.SafeString")))
    {
      str = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (TextUtils.isEmpty(paramCharSequence1)) {}
      }
    }
    try
    {
      str = paramString.replace(paramCharSequence1, paramCharSequence2);
      return str;
    }
    catch (Exception paramCharSequence1) {}
    return SafeString.replace(paramString, paramCharSequence1, paramCharSequence2);
    return paramString;
  }
  
  public static byte[] str2Byte(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new byte[0];
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", paramString);
    }
    return new byte[0];
  }
  
  public static boolean strEquals(String paramString1, String paramString2)
  {
    return (paramString1 == paramString2) || ((paramString1 != null) && (paramString1.equals(paramString2)));
  }
  
  public static int stringToInteger(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      Logger.w("StringUtils", "String to Integer catch NumberFormatException.", paramString);
    }
    return paramInt;
  }
  
  public static long stringToLong(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramLong;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      Logger.w("StringUtils", "String to Long catch NumberFormatException.", paramString);
    }
    return paramLong;
  }
  
  public static String substring(String paramString, int paramInt)
  {
    if (checkCompatible("com.huawei.secure.android.common.util.SafeString")) {
      return SafeString.substring(paramString, paramInt);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= paramInt) && (paramInt >= 0)) {}
    try
    {
      paramString = paramString.substring(paramInt);
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
    return "";
  }
  
  public static String substring(String paramString, int paramInt1, int paramInt2)
  {
    if ((IS_AEGIS_STRING_LIBRARY_LOADED) || (checkCompatible("com.huawei.secure.android.common.util.SafeString")) || ((!TextUtils.isEmpty(paramString)) && (paramInt1 >= 0) && (paramInt2 <= paramString.length()) && (paramInt2 >= paramInt1))) {}
    try
    {
      paramString = paramString.substring(paramInt1, paramInt2);
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
    return SafeString.substring(paramString, paramInt1, paramInt2);
    return "";
  }
  
  public static String toLowerCase(String paramString)
  {
    if (paramString == null) {
      return paramString;
    }
    return paramString.toLowerCase(Locale.ROOT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.StringUtils
 * JD-Core Version:    0.7.0.1
 */