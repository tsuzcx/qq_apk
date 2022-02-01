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
    double d = paramLong;
    Double.isNaN(d);
    return String.format("%.1fw", new Object[] { Double.valueOf(d / 10000.0D) });
  }
  
  public static Boolean isChinese(String paramString)
  {
    Boolean localBoolean1 = Boolean.valueOf(true);
    Boolean localBoolean2 = localBoolean1;
    if (!isEmpty(paramString))
    {
      int j;
      for (int i = 0; i < paramString.length(); i = j)
      {
        j = i + 1;
        if (!paramString.substring(i, j).matches("[Α-￥]")) {
          localBoolean1 = Boolean.valueOf(false);
        }
      }
      localBoolean2 = localBoolean1;
    }
    return localBoolean2;
  }
  
  public static boolean isChinese(char paramChar)
  {
    Object localObject = chineseParam;
    int j = localObject.length;
    boolean bool = false;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] == paramChar) {
        return false;
      }
      i += 1;
    }
    localObject = Character.UnicodeBlock.of(paramChar);
    if ((localObject == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localObject == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localObject == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localObject == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localObject == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localObject == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS)) {
      bool = true;
    }
    return bool;
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
        int j = i + 1;
        if (paramString.substring(i, j).matches("[Α-￥]")) {
          localBoolean1 = Boolean.valueOf(true);
        }
        i = j;
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
  
  public static String secToTime(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00";
    }
    long l2 = paramLong / 60L;
    if (l2 < 60L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(unitFormat(l2));
      localStringBuilder.append(":");
      localStringBuilder.append(unitFormat(paramLong % 60L));
      return localStringBuilder.toString();
    }
    long l1 = l2 / 60L;
    if (l1 > 99L) {
      return "99:59:59";
    }
    l2 %= 60L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(unitFormat(l1));
    localStringBuilder.append(":");
    localStringBuilder.append(unitFormat(l2));
    localStringBuilder.append(":");
    localStringBuilder.append(unitFormat(paramLong - 3600L * l1 - 60L * l2));
    return localStringBuilder.toString();
  }
  
  public static String tenTh2wan(long paramLong)
  {
    return tenTh2wan(String.valueOf(paramLong));
  }
  
  public static String tenTh2wan(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int m = paramString.length();
    if (m < 5) {
      return paramString;
    }
    int i;
    int j;
    if (m >= 5)
    {
      i = 1;
      j = 3;
    }
    else
    {
      i = 0;
      j = 0;
    }
    int k = i;
    if (m >= 9)
    {
      j = 7;
      k = i + 1;
    }
    paramString = new StringBuilder(paramString.substring(0, paramString.length() - j));
    if (paramString.charAt(paramString.length() - 1) != '0') {
      paramString.insert(paramString.length() - 1, ".");
    } else {
      paramString.deleteCharAt(paramString.length() - 1);
    }
    paramString.append(COMMENT_RATE[k]);
    return paramString.toString();
  }
  
  public static String unitFormat(long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong < 10L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(paramLong);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.StringUtil
 * JD-Core Version:    0.7.0.1
 */