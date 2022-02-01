package com.tencent.luggage.wxa.ri;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.luggage.wxa.qz.af;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
  implements InputFilter
{
  private int a;
  private a.a b;
  
  public a(int paramInt, a.a parama)
  {
    this.a = paramInt;
    this.b = parama;
  }
  
  public static int a(String paramString)
  {
    if (af.c(paramString)) {
      return 0;
    }
    return paramString.length() + c(paramString) + d(paramString);
  }
  
  public static int a(String paramString, a.a parama)
  {
    if (parama == a.a.a) {
      return b(paramString);
    }
    if (parama == a.a.b) {
      return a(paramString);
    }
    return 0;
  }
  
  public static int b(String paramString)
  {
    if (af.c(paramString)) {
      return 0;
    }
    return paramString.length();
  }
  
  public static int c(String paramString)
  {
    if (af.c(paramString)) {
      return 0;
    }
    paramString = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(paramString);
    int i = 0;
    while (paramString.find())
    {
      int j = 0;
      while (j <= paramString.groupCount())
      {
        i += 1;
        j += 1;
      }
    }
    return i;
  }
  
  public static int d(String paramString)
  {
    boolean bool = af.c(paramString);
    int i = 0;
    if (bool) {
      return 0;
    }
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      int m = paramString.charAt(i);
      k = j;
      if (m >= 0)
      {
        k = j;
        if (m <= 127) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return paramString.length() - (c(paramString) + j);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    Object localObject = paramCharSequence;
    if (a(paramSpanned.toString(), this.b) + a(paramCharSequence.toString(), this.b) > this.a) {
      localObject = "";
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ri.a
 * JD-Core Version:    0.7.0.1
 */