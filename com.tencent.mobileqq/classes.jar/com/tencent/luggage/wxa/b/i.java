package com.tencent.luggage.wxa.b;

import java.io.Writer;

class i
{
  private static final char[] b = { 92, 34 };
  private static final char[] c = { 92, 92 };
  private static final char[] d = { 92, 110 };
  private static final char[] e = { 92, 114 };
  private static final char[] f = { 92, 116 };
  private static final char[] g = { 92, 117, 50, 48, 50, 56 };
  private static final char[] h = { 92, 117, 50, 48, 50, 57 };
  private static final char[] i = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected final Writer a;
  
  i(Writer paramWriter)
  {
    this.a = paramWriter;
  }
  
  private static char[] a(char paramChar)
  {
    if (paramChar > '\\')
    {
      if (paramChar >= ' ')
      {
        if (paramChar > ' ') {
          return null;
        }
        if (paramChar == ' ') {
          return g;
        }
        return h;
      }
      return null;
    }
    if (paramChar == '\\') {
      return c;
    }
    if (paramChar > '"') {
      return null;
    }
    if (paramChar == '"') {
      return b;
    }
    if (paramChar > '\037') {
      return null;
    }
    if (paramChar == '\n') {
      return d;
    }
    if (paramChar == '\r') {
      return e;
    }
    if (paramChar == '\t') {
      return f;
    }
    char[] arrayOfChar = i;
    return new char[] { '\\', 'u', '0', '0', arrayOfChar[(paramChar >> '\004' & 0xF)], arrayOfChar[(paramChar & 0xF)] };
  }
  
  protected void a()
  {
    this.a.write(91);
  }
  
  protected void a(String paramString)
  {
    this.a.write(paramString);
  }
  
  protected void b()
  {
    this.a.write(93);
  }
  
  protected void b(String paramString)
  {
    this.a.write(paramString);
  }
  
  protected void c()
  {
    this.a.write(44);
  }
  
  protected void c(String paramString)
  {
    this.a.write(34);
    e(paramString);
    this.a.write(34);
  }
  
  protected void d()
  {
    this.a.write(123);
  }
  
  protected void d(String paramString)
  {
    this.a.write(34);
    e(paramString);
    this.a.write(34);
  }
  
  protected void e()
  {
    this.a.write(125);
  }
  
  protected void e(String paramString)
  {
    int n = paramString.length();
    int j = 0;
    int m;
    for (int k = 0; j < n; k = m)
    {
      char[] arrayOfChar = a(paramString.charAt(j));
      m = k;
      if (arrayOfChar != null)
      {
        this.a.write(paramString, k, j - k);
        this.a.write(arrayOfChar);
        m = j + 1;
      }
      j += 1;
    }
    this.a.write(paramString, k, n - k);
  }
  
  protected void f()
  {
    this.a.write(58);
  }
  
  protected void g()
  {
    this.a.write(44);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.i
 * JD-Core Version:    0.7.0.1
 */