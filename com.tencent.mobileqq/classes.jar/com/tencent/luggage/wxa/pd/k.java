package com.tencent.luggage.wxa.pd;

import com.tencent.luggage.wxa.qz.af;

public class k
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "\\", "\\\\" };
    String[] arrayOfString2 = { "'", "\\'" };
    String[] arrayOfString3 = { "\"", "\\\"" };
    String[] arrayOfString4 = { "\b", "\\b" };
    String[] arrayOfString5 = { "\f", "\\f" };
    String[] arrayOfString6 = { "\r", "\\r" };
    String[] arrayOfString7 = { " ", "\\u2029" };
    a = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, { "\n", "\\n" }, { "\t", "\\t" }, arrayOfString4, arrayOfString5, arrayOfString6, { " ", "\\u2028" }, arrayOfString7 };
  }
  
  public static String a(String paramString)
  {
    if (af.c(paramString)) {
      return paramString;
    }
    String[][] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString1 = arrayOfString[i];
      paramString = paramString.replace(arrayOfString1[0], arrayOfString1[1]);
      i += 1;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.k
 * JD-Core Version:    0.7.0.1
 */