package com.huawei.secure.android.common.anonymization;

import android.text.TextUtils;
import android.util.Log;

public class Anonymizer
{
  private static final String TAG = "Anonymizer";
  
  public static String maskAccountId(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (paramString.length() <= 1) {
        return "*";
      }
      if (paramString.length() < 8) {
        return maskCommonString(paramString, 0, 1);
      }
      return maskCommonString(paramString, 0, 4);
    }
    return "";
  }
  
  public static String maskBankAccount(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (paramString.length() <= 2) {
        return a.b(paramString, '*');
      }
      if ((paramString.length() >= 11) && (paramString.length() < 20)) {
        return maskCommonString(paramString, 4, 4);
      }
      return maskCommonString(paramString, 6, 4);
    }
    return "";
  }
  
  public static String maskBirthday(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "";
      }
      if (paramString.length() <= 4) {
        return a.b(paramString, '*');
      }
      paramString = a.split(paramString, 4);
      return a.b("", new String[] { a.a(paramString, 0), a.a(a.a(paramString, 1), "0123456789", "*") });
    }
    return "";
  }
  
  public static String maskCommonString(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "";
      }
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      if (paramString.length() <= i + paramInt1)
      {
        paramInt1 = paramString.length() - 1;
        i = 1;
      }
      else
      {
        paramInt1 = paramString.length() - paramInt1;
      }
      paramString = a.a(paramString, i, paramInt1);
      return a.b("", new String[] { a.a(paramString, 0), a.b(a.a(paramString, 1), '*'), a.a(paramString, 2) });
    }
    return "";
  }
  
  public static String maskEmail(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "";
      }
      if (paramString.length() <= 1) {
        return "*";
      }
      int i = paramString.indexOf('@');
      if (i < 0)
      {
        paramString = a.split(paramString, 1);
        return a.b("", new String[] { a.a(paramString, 0), a.b(a.a(paramString, 1), '*') });
      }
      paramString = a.a(paramString, i, i + 1, paramString.lastIndexOf('.'));
      return a.b("", new String[] { a.b(a.a(paramString, 0), '*'), a.a(paramString, 1), a.b(a.a(paramString, 2), '*'), a.a(paramString, 3) });
    }
    return "";
  }
  
  public static String maskId(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return maskCommonString(paramString, paramString.length() - 12, 0);
    }
    return "";
  }
  
  public static String maskImeiImsi(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return maskCommonString(paramString, paramString.length() - 4, 0);
    }
    return "";
  }
  
  public static String maskIpV4(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "";
      }
      int i = paramString.lastIndexOf('.');
      if (i < 0) {
        return a.b(paramString, '*');
      }
      paramString = a.split(paramString, i + 1);
      return a.b("", new String[] { a.a(paramString, 0), a.b(a.a(paramString, 1), '*') });
    }
    return "";
  }
  
  public static String maskIpV6(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "";
      }
      String[] arrayOfString = a.a(paramString, ':');
      if (arrayOfString.length <= 1) {
        return a.b(paramString, '*');
      }
      if (arrayOfString.length != 8)
      {
        paramString = a.split(paramString, paramString.indexOf(':') + 1);
        return a.b("", new String[] { a.a(paramString, 0), a.a(a.a(paramString, 1), "0123456789ABCDEFabcdef", "*") });
      }
      arrayOfString[2] = maskLower8Bit(arrayOfString[2]);
      int i = 3;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = a.b(arrayOfString[i], '*');
        i += 1;
      }
      return a.b(":", arrayOfString);
    }
    return "";
  }
  
  public static String maskLower8Bit(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Log.e(TAG, "maskLower8Bit: s is null");
      return "";
    }
    if (paramString.length() <= 2) {
      return a.b(paramString, '*');
    }
    paramString = a.split(paramString, paramString.length() - 2);
    return a.b("", new String[] { a.a(paramString, 0), a.b(a.a(paramString, 1), '*') });
  }
  
  public static String maskMac(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "";
      }
      int i = a.a(paramString, '-', 2);
      if (i < 0) {
        return a.a(paramString, "0123456789ABCDEFabcdef", "*");
      }
      paramString = a.split(paramString, i);
      return a.b("", new String[] { a.a(paramString, 0), a.a(a.a(paramString, 1), "0123456789ABCDEFabcdef", "*") });
    }
    return "";
  }
  
  public static String maskName(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (paramString.length() <= 1) {
        return "*";
      }
      return maskCommonString(paramString, 1, 0);
    }
    return "";
  }
  
  public static String maskPhone(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (paramString.length() <= 2) {
        return a.b(paramString, '*');
      }
      if ((paramString.length() >= 8) && (paramString.length() < 11)) {
        return maskCommonString(paramString, 2, 2);
      }
      return maskCommonString(paramString, 3, 4);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.anonymization.Anonymizer
 * JD-Core Version:    0.7.0.1
 */