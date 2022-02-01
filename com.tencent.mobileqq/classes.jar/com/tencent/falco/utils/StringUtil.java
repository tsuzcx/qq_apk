package com.tencent.falco.utils;

import android.text.TextUtils;
import java.security.MessageDigest;

public final class StringUtil
{
  public static final String[] COMMENT_RATE = { "", "万", "亿" };
  private static char[] chineseParam = { 12301, -244, 12290, -225, 8230, -230, -162, 12304, -253, 12289, -251, -246, -250, -252, -248, 8216, 8217, 8220, 8221, 12302, 12308, -165, 12304, -27, -31, 8214, 12310, 12298, 12300, 12299, 12311, 12305, -163, 12309, 12303, 8221, -247, -255, -229, 8212 };
  
  public static boolean checkNameChinese(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length())
    {
      if (!isChinese(arrayOfChar[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String computeSHA1(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      paramString = paramString.getBytes("iso-8859-1");
      localMessageDigest.update(paramString, 0, paramString.length);
      paramString = HexUtil.bytesToHexString(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String formatNumber(long paramLong)
  {
    if (paramLong < 10000L) {
      return Long.toString(paramLong);
    }
    return String.format("%.1fw", new Object[] { Double.valueOf(paramLong / 10000.0D) });
  }
  
  public static Boolean isChinese(String paramString)
  {
    Boolean localBoolean1 = Boolean.valueOf(true);
    if (!isEmpty(paramString))
    {
      int i = 0;
      for (;;)
      {
        localBoolean2 = localBoolean1;
        if (i >= paramString.length()) {
          break;
        }
        if (!paramString.substring(i, i + 1).matches("[Α-￥]")) {
          localBoolean1 = Boolean.valueOf(false);
        }
        i += 1;
      }
    }
    Boolean localBoolean2 = localBoolean1;
    return localBoolean2;
  }
  
  public static boolean isChinese(char paramChar)
  {
    Object localObject = chineseParam;
    int j = localObject.length;
    int i = 0;
    if (i < j) {
      if (localObject[i] != paramChar) {}
    }
    do
    {
      return false;
      i += 1;
      break;
      localObject = Character.UnicodeBlock.of(paramChar);
    } while ((localObject != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) && (localObject != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) && (localObject != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) && (localObject != Character.UnicodeBlock.GENERAL_PUNCTUATION) && (localObject != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) && (localObject != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS));
    return true;
  }
  
  public static Boolean isContainChinese(String paramString)
  {
    int i = 0;
    Boolean localBoolean1 = Boolean.valueOf(false);
    Boolean localBoolean2 = localBoolean1;
    if (!isEmpty(paramString)) {
      for (;;)
      {
        localBoolean2 = localBoolean1;
        if (i >= paramString.length()) {
          break;
        }
        if (paramString.substring(i, i + 1).matches("[Α-￥]")) {
          localBoolean1 = Boolean.valueOf(true);
        }
        i += 1;
      }
    }
    return localBoolean2;
  }
  
  public static boolean isEmpty(String paramString)
  {
    return TextUtils.isEmpty(paramString);
  }
  
  public static Boolean isNumber(String paramString)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramString.matches("^[0-9]+$")) {
      localBoolean = Boolean.valueOf(true);
    }
    return localBoolean;
  }
  
  public static Boolean isNumberLetter(String paramString)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramString.matches("^[A-Za-z0-9]+$")) {
      localBoolean = Boolean.valueOf(true);
    }
    return localBoolean;
  }
  
  public static String tenTh2wan(long paramLong)
  {
    return tenTh2wan(String.valueOf(paramLong));
  }
  
  public static String tenTh2wan(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    int m;
    do
    {
      return str;
      m = paramString.length();
      str = paramString;
    } while (m < 5);
    int j;
    int i;
    if (m >= 5)
    {
      j = 3;
      i = 1;
    }
    for (;;)
    {
      int k = i;
      if (m >= 9)
      {
        j = 7;
        k = i + 1;
      }
      paramString = new StringBuilder(paramString.substring(0, paramString.length() - j));
      if (paramString.charAt(paramString.length() - 1) != '0') {
        paramString.insert(paramString.length() - 1, ".");
      }
      for (;;)
      {
        return COMMENT_RATE[k];
        paramString.deleteCharAt(paramString.length() - 1);
      }
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.StringUtil
 * JD-Core Version:    0.7.0.1
 */