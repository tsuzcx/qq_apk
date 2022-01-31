package com.tencent.biz.pubaccount.readinjoy.common;

public class ReadInJoyStringUtils
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "&lt;", "<" };
    String[] arrayOfString2 = { "&amp;", "&" };
    String[] arrayOfString3 = { "&quot;", "\"" };
    String[] arrayOfString4 = { "&acirc;", "â" };
    String[] arrayOfString5 = { "&auml;", "ä" };
    String[] arrayOfString6 = { "&aring;", "å" };
    String[] arrayOfString7 = { "&Aring;", "Å" };
    String[] arrayOfString8 = { "&aelig;", "æ" };
    String[] arrayOfString9 = { "&AElig;", "Æ" };
    String[] arrayOfString10 = { "&ccedil;", "ç" };
    String[] arrayOfString11 = { "&eacute;", "é" };
    String[] arrayOfString12 = { "&Eacute;", "É" };
    String[] arrayOfString13 = { "&egrave;", "è" };
    String[] arrayOfString14 = { "&Egrave;", "È" };
    String[] arrayOfString15 = { "&Euml;", "Ë" };
    String[] arrayOfString16 = { "&iuml;", "ï" };
    String[] arrayOfString17 = { "&Ocirc;", "Ô" };
    String[] arrayOfString18 = { "&ouml;", "ö" };
    String[] arrayOfString19 = { "&Oslash;", "Ø" };
    String[] arrayOfString20 = { "&ugrave;", "ù" };
    String[] arrayOfString21 = { "&Ucirc;", "Û" };
    String[] arrayOfString22 = { "&uuml;", "ü" };
    String[] arrayOfString23 = { "&reg;", "®" };
    a = new String[][] { arrayOfString1, { "&gt;", ">" }, arrayOfString2, arrayOfString3, { "&agrave;", "à" }, { "&Agrave;", "À" }, arrayOfString4, arrayOfString5, { "&Auml;", "Ä" }, { "&Acirc;", "Â" }, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, { "&Ccedil;", "Ç" }, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, { "&ecirc;", "ê" }, { "&Ecirc;", "Ê" }, { "&euml;", "ë" }, arrayOfString15, arrayOfString16, { "&Iuml;", "Ï" }, { "&ocirc;", "ô" }, arrayOfString17, arrayOfString18, { "&Ouml;", "Ö" }, { "&oslash;", "ø" }, arrayOfString19, { "&szlig;", "ß" }, arrayOfString20, { "&Ugrave;", "Ù" }, { "&ucirc;", "û" }, arrayOfString21, arrayOfString22, { "&Uuml;", "Ü" }, { "&nbsp;", " " }, { "&copy;", "©" }, arrayOfString23, { "&euro;", "₠" } };
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