package com.huawei.secure.android.common.anonymization;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

public class Anonymizer
{
  private static final String TAG = Anonymizer.class.getSimpleName();
  
  @NonNull
  public static String maskAccountId(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    if (paramString.length() <= 1) {
      return "*";
    }
    if (paramString.length() < 8) {
      return maskCommonString(paramString, 0, 1);
    }
    return maskCommonString(paramString, 0, 4);
  }
  
  @NonNull
  public static String maskBankAccount(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    if (paramString.length() <= 2) {
      return a.b(paramString, '*');
    }
    if ((paramString.length() >= 11) && (paramString.length() < 20)) {
      return maskCommonString(paramString, 4, 4);
    }
    return maskCommonString(paramString, 6, 4);
  }
  
  @NonNull
  public static String maskBirthday(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    if (paramString.length() <= 4) {
      return a.b(paramString, '*');
    }
    paramString = a.split(paramString, 4);
    return a.b("", new String[] { a.a(paramString, 0), a.a(a.a(paramString, 1), "0123456789", "*") });
  }
  
  @NonNull
  public static String maskCommonString(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 < 0) {
        i = 0;
      }
      if (paramString.length() <= paramInt1 + i)
      {
        paramInt2 = paramString.length() - 1;
        paramInt1 = 1;
      }
      for (;;)
      {
        paramString = a.a(paramString, paramInt1, paramInt2);
        return a.b("", new String[] { a.a(paramString, 0), a.b(a.a(paramString, 1), '*'), a.a(paramString, 2) });
        paramInt2 = paramString.length() - i;
      }
    }
  }
  
  @NonNull
  public static String maskEmail(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
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
  
  @NonNull
  public static String maskId(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    return maskCommonString(paramString, paramString.length() - 12, 0);
  }
  
  @NonNull
  public static String maskImeiImsi(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    return maskCommonString(paramString, paramString.length() - 4, 0);
  }
  
  @NonNull
  public static String maskIpV4(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    int i = paramString.lastIndexOf('.');
    if (i < 0) {
      return a.b(paramString, '*');
    }
    paramString = a.split(paramString, i + 1);
    return a.b("", new String[] { a.a(paramString, 0), a.b(a.a(paramString, 1), '*') });
  }
  
  @NonNull
  public static String maskIpV6(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
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
  
  public static String maskLower8Bit(@NonNull String paramString)
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
  
  @NonNull
  public static String maskMac(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    int i = a.a(paramString, '-', 2);
    if (i < 0) {
      return a.a(paramString, "0123456789ABCDEFabcdef", "*");
    }
    paramString = a.split(paramString, i);
    return a.b("", new String[] { a.a(paramString, 0), a.a(a.a(paramString, 1), "0123456789ABCDEFabcdef", "*") });
  }
  
  @NonNull
  public static String maskName(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    if (paramString.length() <= 1) {
      return "*";
    }
    return maskCommonString(paramString, 1, 0);
  }
  
  @NonNull
  public static String maskPhone(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    if (paramString.length() <= 2) {
      return a.b(paramString, '*');
    }
    if ((paramString.length() >= 8) && (paramString.length() < 11)) {
      return maskCommonString(paramString, 2, 2);
    }
    return maskCommonString(paramString, 3, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.anonymization.Anonymizer
 * JD-Core Version:    0.7.0.1
 */