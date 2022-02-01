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
    String[] arrayOfString = a;
    arrayOfString[34] = "\\\"";
    arrayOfString[92] = "\\\\";
    arrayOfString[9] = "\\t";
    arrayOfString[8] = "\\b";
    arrayOfString[10] = "\\n";
    arrayOfString[13] = "\\r";
    arrayOfString[12] = "\\f";
    arrayOfString = (String[])arrayOfString.clone();
    b = arrayOfString;
    arrayOfString[60] = "\\u003c";
    arrayOfString = b;
    arrayOfString[62] = "\\u003e";
    arrayOfString[38] = "\\u0026";
    arrayOfString[61] = "\\u003d";
    arrayOfString[39] = "\\u0027";
  }
  
  public fg(Writer paramWriter)
  {
    a(6);
    this.i = ":";
    this.d = true;
    if (paramWriter != null)
    {
      this.e = paramWriter;
      return;
    }
    throw new NullPointerException("out == null");
  }
  
  private fg a(int paramInt1, int paramInt2, String paramString)
  {
    int m = f();
    if ((m != paramInt2) && (m != paramInt1)) {
      throw new IllegalStateException("Nesting problem.");
    }
    if (this.k == null)
    {
      this.g -= 1;
      if (m == paramInt2) {
        h();
      }
      this.e.write(paramString);
      return this;
    }
    paramString = new StringBuilder("Dangling name: ");
    paramString.append(this.k);
    throw new IllegalStateException(paramString.toString());
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
    int m = this.g;
    int[] arrayOfInt1 = this.f;
    if (m == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[m * 2];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, m);
      this.f = arrayOfInt2;
    }
    arrayOfInt1 = this.f;
    m = this.g;
    this.g = (m + 1);
    arrayOfInt1[m] = paramInt;
  }
  
  private void b(int paramInt)
  {
    this.f[(this.g - 1)] = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    int m = f();
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 4)
        {
          if (m != 6) {
            if (m == 7)
            {
              if (!this.c) {
                throw new IllegalStateException("JSON must have only one top-level value.");
              }
            }
            else {
              throw new IllegalStateException("Nesting problem.");
            }
          }
          if ((!this.c) && (!paramBoolean)) {
            throw new IllegalStateException("JSON must start with an array or an object.");
          }
          b(7);
          return;
        }
        this.e.append(this.i);
        b(5);
        return;
      }
      this.e.append(',');
      h();
      return;
    }
    b(2);
    h();
  }
  
  private void c(String paramString)
  {
    String[] arrayOfString;
    if (this.j) {
      arrayOfString = b;
    } else {
      arrayOfString = a;
    }
    this.e.write("\"");
    int i2 = paramString.length();
    int m = 0;
    int i1;
    for (int n = 0; m < i2; n = i1)
    {
      int i3 = paramString.charAt(m);
      String str1;
      if (i3 < 128)
      {
        String str2 = arrayOfString[i3];
        str1 = str2;
        if (str2 == null)
        {
          i1 = n;
          break label143;
        }
      }
      else if (i3 == 8232)
      {
        str1 = "\\u2028";
      }
      else
      {
        i1 = n;
        if (i3 != 8233) {
          break label143;
        }
        str1 = "\\u2029";
      }
      if (n < m) {
        this.e.write(paramString, n, m - n);
      }
      this.e.write(str1);
      i1 = m + 1;
      label143:
      m += 1;
    }
    if (n < i2) {
      this.e.write(paramString, n, i2 - n);
    }
    this.e.write("\"");
  }
  
  private int f()
  {
    int m = this.g;
    if (m != 0) {
      return this.f[(m - 1)];
    }
    throw new IllegalStateException("JsonWriter is closed.");
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
    if (this.h == null) {
      return;
    }
    this.e.write("\n");
    int n = this.g;
    int m = 1;
    while (m < n)
    {
      this.e.write(this.h);
      m += 1;
    }
  }
  
  private void i()
  {
    int m = f();
    if (m == 5) {
      this.e.write(44);
    } else {
      if (m != 3) {
        break label37;
      }
    }
    h();
    b(4);
    return;
    label37:
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
    if (paramString != null)
    {
      if (this.k == null)
      {
        if (this.g != 0)
        {
          this.k = paramString;
          return this;
        }
        throw new IllegalStateException("JsonWriter is closed.");
      }
      throw new IllegalStateException();
    }
    throw new NullPointerException("name == null");
  }
  
  public fg a(boolean paramBoolean)
  {
    g();
    b(false);
    Writer localWriter = this.e;
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    localWriter.write(str);
    return this;
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
    if ((m <= 1) && ((m != 1) || (this.f[(m - 1)] == 7)))
    {
      this.g = 0;
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public fg d()
  {
    return a(3, 5, "}");
  }
  
  public fg e()
  {
    if (this.k != null) {
      if (this.d)
      {
        g();
      }
      else
      {
        this.k = null;
        return this;
      }
    }
    b(false);
    this.e.write("null");
    return this;
  }
  
  public void flush()
  {
    if (this.g != 0)
    {
      this.e.flush();
      return;
    }
    throw new IllegalStateException("JsonWriter is closed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.fg
 * JD-Core Version:    0.7.0.1
 */