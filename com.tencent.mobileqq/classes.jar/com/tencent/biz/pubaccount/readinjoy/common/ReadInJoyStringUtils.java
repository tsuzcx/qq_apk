package com.tencent.biz.pubaccount.readinjoy.common;

public class ReadInJoyStringUtils
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "&gt;", ">" };
    String[] arrayOfString2 = { "&quot;", "\"" };
    String[] arrayOfString3 = { "&agrave;", "à" };
    String[] arrayOfString4 = { "&Agrave;", "À" };
    String[] arrayOfString5 = { "&auml;", "ä" };
    String[] arrayOfString6 = { "&Auml;", "Ä" };
    String[] arrayOfString7 = { "&Acirc;", "Â" };
    String[] arrayOfString8 = { "&Aring;", "Å" };
    String[] arrayOfString9 = { "&AElig;", "Æ" };
    String[] arrayOfString10 = { "&ccedil;", "ç" };
    String[] arrayOfString11 = { "&Ecirc;", "Ê" };
    String[] arrayOfString12 = { "&euml;", "ë" };
    String[] arrayOfString13 = { "&iuml;", "ï" };
    String[] arrayOfString14 = { "&Iuml;", "Ï" };
    String[] arrayOfString15 = { "&Ocirc;", "Ô" };
    String[] arrayOfString16 = { "&ouml;", "ö" };
    String[] arrayOfString17 = { "&Ouml;", "Ö" };
    String[] arrayOfString18 = { "&szlig;", "ß" };
    String[] arrayOfString19 = { "&Ugrave;", "Ù" };
    String[] arrayOfString20 = { "&Ucirc;", "Û" };
    String[] arrayOfString21 = { "&Uuml;", "Ü" };
    String[] arrayOfString22 = { "&nbsp;", " " };
    String[] arrayOfString23 = { "&copy;", "©" };
    String[] arrayOfString24 = { "&reg;", "®" };
    String[] arrayOfString25 = { "&euro;", "₠" };
    a = new String[][] { { "&lt;", "<" }, arrayOfString1, { "&amp;", "&" }, arrayOfString2, arrayOfString3, arrayOfString4, { "&acirc;", "â" }, arrayOfString5, arrayOfString6, arrayOfString7, { "&aring;", "å" }, arrayOfString8, { "&aelig;", "æ" }, arrayOfString9, arrayOfString10, { "&Ccedil;", "Ç" }, { "&eacute;", "é" }, { "&Eacute;", "É" }, { "&egrave;", "è" }, { "&Egrave;", "È" }, { "&ecirc;", "ê" }, arrayOfString11, arrayOfString12, { "&Euml;", "Ë" }, arrayOfString13, arrayOfString14, { "&ocirc;", "ô" }, arrayOfString15, arrayOfString16, arrayOfString17, { "&oslash;", "ø" }, { "&Oslash;", "Ø" }, arrayOfString18, { "&ugrave;", "ù" }, arrayOfString19, { "&ucirc;", "û" }, arrayOfString20, { "&uuml;", "ü" }, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25 };
  }
  
  public static String a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = paramString.indexOf("&", paramInt);
    String str = paramString;
    int j;
    if (i > -1)
    {
      j = paramString.indexOf(";", i);
      str = paramString;
      if (j > i)
      {
        str = paramString.substring(i, j + 1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      if ((paramInt >= a.length) || (a[paramInt][0].equals(str)))
      {
        str = paramString;
        if (paramInt < a.length) {
          str = a(paramString.substring(0, i) + a[paramInt][1] + paramString.substring(j + 1), i);
        }
        return str;
      }
      paramInt += 1;
    }
  }
  
  public static String a(String paramString1, String paramString2, char paramChar)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty())) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString1.length();
    paramString1 = paramString1.toCharArray();
    int i = 0;
    if (i < k) {
      if (k - i >= paramString2.length())
      {
        j = 0;
        label59:
        if (j >= paramString2.length()) {
          break label153;
        }
        if (paramString1[(i + j)] == paramString2.charAt(j)) {}
      }
    }
    label153:
    for (int j = 0;; j = 1)
    {
      if (j != 0)
      {
        localStringBuilder.append(paramChar);
        i = paramString2.length() - 1 + i;
        i += 1;
        break;
        j += 1;
        break label59;
      }
      localStringBuilder.append(paramString1[i]);
      for (;;)
      {
        break;
        localStringBuilder.append(paramString1[i]);
      }
      return localStringBuilder.toString();
    }
  }
  
  public static String b(String paramString)
  {
    int i = paramString.length();
    while ((i < 0) && (paramString.charAt(i - 1) <= ' ')) {
      i -= 1;
    }
    String str = paramString;
    if (i < paramString.length()) {
      str = paramString.substring(0, i);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyStringUtils
 * JD-Core Version:    0.7.0.1
 */