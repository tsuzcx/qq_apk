package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class CharacterUtil
{
  static final long a = a(-1L, 10L);
  
  static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 > paramLong2) {
      return 1;
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    int j = 0;
    int i = 0;
    while ((paramString != null) && (j < paramString.length()))
    {
      if (a(paramString.charAt(j))) {
        i += 2;
      } else {
        i += 1;
      }
      j += 1;
    }
    return i;
  }
  
  static long a(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      if (a(paramLong1, paramLong2) < 0) {
        return 0L;
      }
      return 1L;
    }
    if (paramLong1 >= 0L) {
      return paramLong1 / paramLong2;
    }
    int i = 1;
    long l = (paramLong1 >>> 1) / paramLong2 << 1;
    if (a(paramLong1 - l * paramLong2, paramLong2) < 0) {
      i = 0;
    }
    return l + i;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CharacterUtil", 2, "the strind is null!");
      }
      return 0L;
    }
    if (paramString.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CharacterUtil", 2, "invalid string!");
      }
      return 0L;
    }
    int i = 0;
    while (i < paramString.length())
    {
      int j = Character.digit(paramString.charAt(i), 10);
      if (j != -1)
      {
        if ((i > 18) && (a(l, j, 10)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Too large for unsigned long: ");
          localStringBuilder.append(paramString);
          throw new NumberFormatException(localStringBuilder.toString());
        }
        l = l * 10 + j;
        i += 1;
      }
      else
      {
        throw new NumberFormatException(paramString);
      }
    }
    return l;
  }
  
  public static String a(long paramLong)
  {
    long l = 0xFFFFFFFF & paramLong;
    if (paramLong == l) {
      return String.valueOf(l);
    }
    char[] arrayOfChar = "-9223372036854775808".toCharArray();
    arrayOfChar[0] = '0';
    int j = arrayOfChar.length - 1;
    paramLong = l;
    while ((j != 0) && (paramLong != 0L))
    {
      int i = (char)(int)(arrayOfChar[j] + paramLong % 10L);
      arrayOfChar[j] = i;
      if (i > 57)
      {
        arrayOfChar[j] = ((char)(arrayOfChar[j] - '\n'));
        int k = j - 1;
        arrayOfChar[k] = ((char)(arrayOfChar[k] + '\001'));
      }
      paramLong /= 10L;
      j -= 1;
    }
    j = '1' - arrayOfChar[0];
    return new String(arrayOfChar, j, arrayOfChar.length - j);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramInt2;
      paramInt2 = paramInt1;
      while (paramInt2 < i)
      {
        int j = i;
        if (a(paramString.charAt(paramInt2))) {
          j = i - 1;
        }
        paramInt2 += 1;
        i = j;
      }
      return paramString.substring(paramInt1, i);
    }
    return "";
  }
  
  public static boolean a(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION);
  }
  
  private static boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramLong >= 0L)
    {
      long l = a;
      if (paramLong < l) {
        return false;
      }
      if (paramLong > l) {
        return true;
      }
      if (paramInt1 > 5) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.CharacterUtil
 * JD-Core Version:    0.7.0.1
 */