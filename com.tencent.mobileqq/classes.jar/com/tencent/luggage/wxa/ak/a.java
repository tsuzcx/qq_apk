package com.tencent.luggage.wxa.ak;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ao.e;
import com.tencent.luggage.wxa.ao.m;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a
{
  private static final Pattern a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
  private final m b = new m();
  private final StringBuilder c = new StringBuilder();
  
  private static char a(m paramm, int paramInt)
  {
    return (char)paramm.a[paramInt];
  }
  
  static String a(m paramm, StringBuilder paramStringBuilder)
  {
    b(paramm);
    if (paramm.b() == 0) {
      return null;
    }
    paramStringBuilder = d(paramm, paramStringBuilder);
    if (!"".equals(paramStringBuilder)) {
      return paramStringBuilder;
    }
    paramStringBuilder = new StringBuilder();
    paramStringBuilder.append("");
    paramStringBuilder.append((char)paramm.g());
    return paramStringBuilder.toString();
  }
  
  private void a(d paramd, String paramString)
  {
    if ("".equals(paramString)) {
      return;
    }
    int i = paramString.indexOf('[');
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = a.matcher(paramString.substring(i));
      if (((Matcher)localObject).matches()) {
        paramd.c(((Matcher)localObject).group(1));
      }
      localObject = paramString.substring(0, i);
    }
    paramString = ((String)localObject).split("\\.");
    localObject = paramString[0];
    i = ((String)localObject).indexOf('#');
    if (i != -1)
    {
      paramd.b(((String)localObject).substring(0, i));
      paramd.a(((String)localObject).substring(i + 1));
    }
    else
    {
      paramd.b((String)localObject);
    }
    if (paramString.length > 1) {
      paramd.a((String[])Arrays.copyOfRange(paramString, 1, paramString.length));
    }
  }
  
  private static void a(m paramm, d paramd, StringBuilder paramStringBuilder)
  {
    b(paramm);
    String str1 = d(paramm, paramStringBuilder);
    if ("".equals(str1)) {
      return;
    }
    if (!":".equals(a(paramm, paramStringBuilder))) {
      return;
    }
    b(paramm);
    String str2 = c(paramm, paramStringBuilder);
    if (str2 != null)
    {
      if ("".equals(str2)) {
        return;
      }
      int i = paramm.d();
      paramStringBuilder = a(paramm, paramStringBuilder);
      if (!";".equals(paramStringBuilder))
      {
        if ("}".equals(paramStringBuilder)) {
          paramm.c(i);
        }
      }
      else
      {
        if ("color".equals(str1))
        {
          paramd.a(e.b(str2));
          return;
        }
        if ("background-color".equals(str1))
        {
          paramd.b(e.b(str2));
          return;
        }
        if ("text-decoration".equals(str1))
        {
          if ("underline".equals(str2)) {
            paramd.a(true);
          }
        }
        else
        {
          if ("font-family".equals(str1))
          {
            paramd.d(str2);
            return;
          }
          if ("font-weight".equals(str1))
          {
            if ("bold".equals(str2)) {
              paramd.b(true);
            }
          }
          else if (("font-style".equals(str1)) && ("italic".equals(str2))) {
            paramd.c(true);
          }
        }
      }
    }
  }
  
  private static String b(m paramm, StringBuilder paramStringBuilder)
  {
    b(paramm);
    if (paramm.b() < 5) {
      return null;
    }
    if (!"::cue".equals(paramm.e(5))) {
      return null;
    }
    int i = paramm.d();
    String str = a(paramm, paramStringBuilder);
    if (str == null) {
      return null;
    }
    if ("{".equals(str))
    {
      paramm.c(i);
      return "";
    }
    if ("(".equals(str)) {
      str = d(paramm);
    } else {
      str = null;
    }
    paramm = a(paramm, paramStringBuilder);
    if (")".equals(paramm))
    {
      if (paramm == null) {
        return null;
      }
      return str;
    }
    return null;
  }
  
  static void b(m paramm)
  {
    for (int i = 1;; i = 0)
    {
      if ((paramm.b() <= 0) || (i == 0)) {
        return;
      }
      if ((e(paramm)) || (f(paramm))) {
        break;
      }
    }
  }
  
  private static String c(m paramm, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i == 0)
    {
      int j = paramm.d();
      String str = a(paramm, paramStringBuilder);
      if (str == null) {
        return null;
      }
      if ((!"}".equals(str)) && (!";".equals(str)))
      {
        localStringBuilder.append(str);
      }
      else
      {
        paramm.c(j);
        i = 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  static void c(m paramm)
  {
    while (!TextUtils.isEmpty(paramm.y())) {}
  }
  
  private static String d(m paramm)
  {
    int j = paramm.d();
    int k = paramm.c();
    int i = 0;
    while ((j < k) && (i == 0))
    {
      if ((char)paramm.a[j] == ')') {
        i = 1;
      } else {
        i = 0;
      }
      j += 1;
    }
    return paramm.e(j - 1 - paramm.d()).trim();
  }
  
  private static String d(m paramm, StringBuilder paramStringBuilder)
  {
    int j = 0;
    paramStringBuilder.setLength(0);
    int i = paramm.d();
    int k = paramm.c();
    while ((i < k) && (j == 0))
    {
      char c1 = (char)paramm.a[i];
      if (((c1 < 'A') || (c1 > 'Z')) && ((c1 < 'a') || (c1 > 'z')) && ((c1 < '0') || (c1 > '9')) && (c1 != '#') && (c1 != '-') && (c1 != '.') && (c1 != '_'))
      {
        j = 1;
      }
      else
      {
        i += 1;
        paramStringBuilder.append(c1);
      }
    }
    paramm.d(i - paramm.d());
    return paramStringBuilder.toString();
  }
  
  private static boolean e(m paramm)
  {
    int i = a(paramm, paramm.d());
    if ((i != 9) && (i != 10) && (i != 12) && (i != 13) && (i != 32)) {
      return false;
    }
    paramm.d(1);
    return true;
  }
  
  private static boolean f(m paramm)
  {
    int i = paramm.d();
    int j = paramm.c();
    byte[] arrayOfByte = paramm.a;
    if (i + 2 <= j)
    {
      int k = i + 1;
      if (arrayOfByte[i] == 47)
      {
        i = k + 1;
        if (arrayOfByte[k] == 42)
        {
          for (;;)
          {
            k = i + 1;
            if (k >= j) {
              break;
            }
            if (((char)arrayOfByte[i] == '*') && ((char)arrayOfByte[k] == '/'))
            {
              i = k + 1;
              j = i;
            }
            else
            {
              i = k;
            }
          }
          paramm.d(j - paramm.d());
          return true;
        }
      }
    }
    return false;
  }
  
  public d a(m paramm)
  {
    this.c.setLength(0);
    int i = paramm.d();
    c(paramm);
    this.b.a(paramm.a, paramm.d());
    this.b.c(i);
    String str = b(this.b, this.c);
    Object localObject = null;
    paramm = localObject;
    if (str != null)
    {
      if (!"{".equals(a(this.b, this.c))) {
        return null;
      }
      d locald = new d();
      a(locald, str);
      str = null;
      i = 0;
      while (i == 0)
      {
        int j = this.b.d();
        str = a(this.b, this.c);
        if ((str != null) && (!"}".equals(str))) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          this.b.c(j);
          a(this.b, locald, this.c);
        }
      }
      paramm = localObject;
      if ("}".equals(str)) {
        paramm = locald;
      }
    }
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ak.a
 * JD-Core Version:    0.7.0.1
 */