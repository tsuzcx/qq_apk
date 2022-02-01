package com.tencent.map.sdk.a;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class fg
  implements Closeable, Flushable
{
  private static final String[] a = new String[''];
  private static final String[] b;
  public boolean c;
  protected boolean d;
  private final Writer e;
  private int[] f = new int[32];
  private int g = 0;
  private String h;
  private String i;
  private boolean j;
  private String k;
  
  static
  {
    int m = 0;
    while (m <= 31)
    {
      a[m] = String.format("\\u%04x", new Object[] { Integer.valueOf(m) });
      m += 1;
    }
    a[34] = "\\\"";
    a[92] = "\\\\";
    a[9] = "\\t";
    a[8] = "\\b";
    a[10] = "\\n";
    a[13] = "\\r";
    a[12] = "\\f";
    String[] arrayOfString = (String[])a.clone();
    b = arrayOfString;
    arrayOfString[60] = "\\u003c";
    b[62] = "\\u003e";
    b[38] = "\\u0026";
    b[61] = "\\u003d";
    b[39] = "\\u0027";
  }
  
  public fg(Writer paramWriter)
  {
    a(6);
    this.i = ":";
    this.d = true;
    if (paramWriter == null) {
      throw new NullPointerException("out == null");
    }
    this.e = paramWriter;
  }
  
  private fg a(int paramInt1, int paramInt2, String paramString)
  {
    int m = f();
    if ((m != paramInt2) && (m != paramInt1)) {
      throw new IllegalStateException("Nesting problem.");
    }
    if (this.k != null) {
      throw new IllegalStateException("Dangling name: " + this.k);
    }
    this.g -= 1;
    if (m == paramInt2) {
      h();
    }
    this.e.write(paramString);
    return this;
  }
  
  private fg a(int paramInt, String paramString)
  {
    b(true);
    a(paramInt);
    this.e.write(paramString);
    return this;
  }
  
  private void a(int paramInt)
  {
    if (this.g == this.f.length)
    {
      arrayOfInt = new int[this.g * 2];
      System.arraycopy(this.f, 0, arrayOfInt, 0, this.g);
      this.f = arrayOfInt;
    }
    int[] arrayOfInt = this.f;
    int m = this.g;
    this.g = (m + 1);
    arrayOfInt[m] = paramInt;
  }
  
  private void b(int paramInt)
  {
    this.f[(this.g - 1)] = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    switch (f())
    {
    case 3: 
    case 5: 
    default: 
      throw new IllegalStateException("Nesting problem.");
    case 7: 
      if (!this.c) {
        throw new IllegalStateException("JSON must have only one top-level value.");
      }
    case 6: 
      if ((!this.c) && (!paramBoolean)) {
        throw new IllegalStateException("JSON must start with an array or an object.");
      }
      b(7);
      return;
    case 1: 
      b(2);
      h();
      return;
    case 2: 
      this.e.append(',');
      h();
      return;
    }
    this.e.append(this.i);
    b(5);
  }
  
  private void c(String paramString)
  {
    int n = 0;
    if (this.j) {}
    int i2;
    int m;
    int i3;
    int i1;
    for (String[] arrayOfString = b;; arrayOfString = a)
    {
      this.e.write("\"");
      i2 = paramString.length();
      m = 0;
      for (;;)
      {
        if (m >= i2) {
          break label153;
        }
        i3 = paramString.charAt(m);
        if (i3 >= 128) {
          break;
        }
        String str2 = arrayOfString[i3];
        str1 = str2;
        if (str2 != null) {
          break label101;
        }
        i1 = n;
        m += 1;
        n = i1;
      }
    }
    if (i3 == 8232) {}
    for (String str1 = "\\u2028";; str1 = "\\u2029")
    {
      label101:
      if (n < m) {
        this.e.write(paramString, n, m - n);
      }
      this.e.write(str1);
      i1 = m + 1;
      break;
      i1 = n;
      if (i3 != 8233) {
        break;
      }
    }
    label153:
    if (n < i2) {
      this.e.write(paramString, n, i2 - n);
    }
    this.e.write("\"");
  }
  
  private int f()
  {
    if (this.g == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    return this.f[(this.g - 1)];
  }
  
  private void g()
  {
    if (this.k != null)
    {
      i();
      c(this.k);
      this.k = null;
    }
  }
  
  private void h()
  {
    if (this.h == null) {}
    for (;;)
    {
      return;
      this.e.write("\n");
      int m = 1;
      int n = this.g;
      while (m < n)
      {
        this.e.write(this.h);
        m += 1;
      }
    }
  }
  
  private void i()
  {
    int m = f();
    if (m == 5) {
      this.e.write(44);
    }
    while (m == 3)
    {
      h();
      b(4);
      return;
    }
    throw new IllegalStateException("Nesting problem.");
  }
  
  public fg a()
  {
    g();
    return a(1, "[");
  }
  
  public fg a(long paramLong)
  {
    g();
    b(false);
    this.e.write(Long.toString(paramLong));
    return this;
  }
  
  public fg a(Number paramNumber)
  {
    if (paramNumber == null) {
      return e();
    }
    g();
    String str = paramNumber.toString();
    if ((!this.c) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN")))) {
      throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(paramNumber)));
    }
    b(false);
    this.e.append(str);
    return this;
  }
  
  public fg a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    if (this.k != null) {
      throw new IllegalStateException();
    }
    if (this.g == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    this.k = paramString;
    return this;
  }
  
  public fg a(boolean paramBoolean)
  {
    g();
    b(false);
    Writer localWriter = this.e;
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      localWriter.write(str);
      return this;
    }
  }
  
  public fg b()
  {
    return a(1, 2, "]");
  }
  
  public fg b(String paramString)
  {
    if (paramString == null) {
      return e();
    }
    g();
    b(false);
    c(paramString);
    return this;
  }
  
  public fg c()
  {
    g();
    return a(3, "{");
  }
  
  public void close()
  {
    this.e.close();
    int m = this.g;
    if ((m > 1) || ((m == 1) && (this.f[(m - 1)] != 7))) {
      throw new IOException("Incomplete document");
    }
    this.g = 0;
  }
  
  public fg d()
  {
    return a(3, 5, "}");
  }
  
  public fg e()
  {
    if (this.k != null)
    {
      if (this.d) {
        g();
      }
    }
    else
    {
      b(false);
      this.e.write("null");
      return this;
    }
    this.k = null;
    return this;
  }
  
  public void flush()
  {
    if (this.g == 0) {
      throw new IllegalStateException("JsonWriter is closed.");
    }
    this.e.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.fg
 * JD-Core Version:    0.7.0.1
 */