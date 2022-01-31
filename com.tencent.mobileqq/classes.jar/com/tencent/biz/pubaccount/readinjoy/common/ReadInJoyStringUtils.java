package com.tencent.biz.pubaccount.readinjoy.common;

public class ReadInJoyStringUtils
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "&auml;", "ä" };
    String[] arrayOfString2 = { "&Eacute;", "É" };
    String[] arrayOfString3 = { "&ecirc;", "ê" };
    String[] arrayOfString4 = { "&Ouml;", "Ö" };
    String[] arrayOfString5 = { "&ucirc;", "û" };
    String[] arrayOfString6 = { "&Uuml;", "Ü" };
    String[] arrayOfString7 = { "&nbsp;", " " };
    a = new String[][] { { "&lt;", "<" }, { "&gt;", ">" }, { "&amp;", "&" }, { "&quot;", "\"" }, { "&agrave;", "à" }, { "&Agrave;", "À" }, { "&acirc;", "â" }, arrayOfString1, { "&Auml;", "Ä" }, { "&Acirc;", "Â" }, { "&aring;", "å" }, { "&Aring;", "Å" }, { "&aelig;", "æ" }, { "&AElig;", "Æ" }, { "&ccedil;", "ç" }, { "&Ccedil;", "Ç" }, { "&eacute;", "é" }, arrayOfString2, { "&egrave;", "è" }, { "&Egrave;", "È" }, arrayOfString3, { "&Ecirc;", "Ê" }, { "&euml;", "ë" }, { "&Euml;", "Ë" }, { "&iuml;", "ï" }, { "&Iuml;", "Ï" }, { "&ocirc;", "ô" }, { "&Ocirc;", "Ô" }, { "&ouml;", "ö" }, arrayOfString4, { "&oslash;", "ø" }, { "&Oslash;", "Ø" }, { "&szlig;", "ß" }, { "&ugrave;", "ù" }, { "&Ugrave;", "Ù" }, arrayOfString5, { "&Ucirc;", "Û" }, { "&uuml;", "ü" }, arrayOfString6, arrayOfString7, { "&copy;", "©" }, { "&reg;", "®" }, { "&euro;", "₠" } };
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyStringUtils
 * JD-Core Version:    0.7.0.1
 */