package com.tencent.biz.pubaccount.readinjoy.common;

public class ReadInJoyStringUtils
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "&amp;", "&" };
    String[] arrayOfString2 = { "&agrave;", "à" };
    String[] arrayOfString3 = { "&acirc;", "â" };
    String[] arrayOfString4 = { "&AElig;", "Æ" };
    String[] arrayOfString5 = { "&ccedil;", "ç" };
    String[] arrayOfString6 = { "&ecirc;", "ê" };
    String[] arrayOfString7 = { "&Uuml;", "Ü" };
    a = new String[][] { { "&lt;", "<" }, { "&gt;", ">" }, arrayOfString1, { "&quot;", "\"" }, arrayOfString2, { "&Agrave;", "À" }, arrayOfString3, { "&auml;", "ä" }, { "&Auml;", "Ä" }, { "&Acirc;", "Â" }, { "&aring;", "å" }, { "&Aring;", "Å" }, { "&aelig;", "æ" }, arrayOfString4, arrayOfString5, { "&Ccedil;", "Ç" }, { "&eacute;", "é" }, { "&Eacute;", "É" }, { "&egrave;", "è" }, { "&Egrave;", "È" }, arrayOfString6, { "&Ecirc;", "Ê" }, { "&euml;", "ë" }, { "&Euml;", "Ë" }, { "&iuml;", "ï" }, { "&Iuml;", "Ï" }, { "&ocirc;", "ô" }, { "&Ocirc;", "Ô" }, { "&ouml;", "ö" }, { "&Ouml;", "Ö" }, { "&oslash;", "ø" }, { "&Oslash;", "Ø" }, { "&szlig;", "ß" }, { "&ugrave;", "ù" }, { "&Ugrave;", "Ù" }, { "&ucirc;", "û" }, { "&Ucirc;", "Û" }, { "&uuml;", "ü" }, arrayOfString7, { "&nbsp;", " " }, { "&copy;", "©" }, { "&reg;", "®" }, { "&euro;", "₠" } };
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