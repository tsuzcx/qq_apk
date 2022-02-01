package com.tencent.luggage.wxa.b;

import java.io.Reader;
import java.io.StringReader;

class f
{
  private final Reader a;
  private final char[] b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private StringBuilder i;
  private int j;
  
  f(Reader paramReader, int paramInt)
  {
    this.a = paramReader;
    this.b = new char[paramInt];
    this.f = 1;
    this.j = -1;
  }
  
  f(String paramString)
  {
    this(new StringReader(paramString), Math.max(10, Math.min(1024, paramString.length())));
  }
  
  private j a(String paramString)
  {
    if (x()) {
      return b("Unexpected end of input");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected ");
    localStringBuilder.append(paramString);
    return b(localStringBuilder.toString());
  }
  
  private void a(char paramChar)
  {
    if (b(paramChar)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("'");
    localStringBuilder.append(paramChar);
    localStringBuilder.append("'");
    throw a(localStringBuilder.toString());
  }
  
  private h b()
  {
    int k = this.h;
    if (k != 34)
    {
      if (k != 45)
      {
        if (k != 91) {
          if (k != 102) {
            if (k != 110) {
              if (k != 116) {
                if (k == 123) {}
              }
            }
          }
        }
        switch (k)
        {
        default: 
          throw a("value");
          return d();
          return g();
          return f();
          return h();
          return c();
        }
      }
      return l();
    }
    return i();
  }
  
  private j b(String paramString)
  {
    int m = this.c + this.d;
    int n = this.g;
    int k;
    if (x()) {
      k = m;
    } else {
      k = m - 1;
    }
    return new j(paramString, k, this.f, m - n - 1);
  }
  
  private boolean b(char paramChar)
  {
    if (this.h != paramChar) {
      return false;
    }
    q();
    return true;
  }
  
  private b c()
  {
    q();
    Object localObject = new b();
    p();
    if (b(']')) {
      return localObject;
    }
    do
    {
      p();
      ((b)localObject).a(b());
      p();
    } while (b(','));
    if (b(']')) {
      return localObject;
    }
    localObject = a("',' or ']'");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private e d()
  {
    q();
    Object localObject = new e();
    p();
    if (b('}')) {
      return localObject;
    }
    do
    {
      p();
      String str = e();
      p();
      if (!b(':')) {
        break;
      }
      p();
      ((e)localObject).a(str, b());
      p();
    } while (b(','));
    if (b('}')) {
      return localObject;
    }
    throw a("',' or '}'");
    localObject = a("':'");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private String e()
  {
    if (this.h == 34) {
      return j();
    }
    throw a("name");
  }
  
  private h f()
  {
    q();
    a('u');
    a('l');
    a('l');
    return a.a;
  }
  
  private h g()
  {
    q();
    a('r');
    a('u');
    a('e');
    return a.b;
  }
  
  private h h()
  {
    q();
    a('a');
    a('l');
    a('s');
    a('e');
    return a.c;
  }
  
  private h i()
  {
    return new g(j());
  }
  
  private String j()
  {
    q();
    r();
    for (;;)
    {
      int k = this.h;
      if (k == 34) {
        break label60;
      }
      if (k == 92)
      {
        s();
        k();
        r();
      }
      else
      {
        if (k < 32) {
          break;
        }
        q();
      }
    }
    throw a("valid string character");
    label60:
    String str = t();
    q();
    return str;
  }
  
  private void k()
  {
    q();
    int k = this.h;
    if ((k != 34) && (k != 47) && (k != 92))
    {
      if (k != 98)
      {
        if (k != 102)
        {
          if (k != 110)
          {
            if (k != 114)
            {
              if (k != 116)
              {
                if (k == 117)
                {
                  char[] arrayOfChar = new char[4];
                  k = 0;
                  while (k < 4)
                  {
                    q();
                    if (w())
                    {
                      arrayOfChar[k] = ((char)this.h);
                      k += 1;
                    }
                    else
                    {
                      throw a("hexadecimal digit");
                    }
                  }
                  this.i.append((char)Integer.parseInt(new String(arrayOfChar), 16));
                }
                else
                {
                  throw a("valid escape sequence");
                }
              }
              else {
                this.i.append('\t');
              }
            }
            else {
              this.i.append('\r');
            }
          }
          else {
            this.i.append('\n');
          }
        }
        else {
          this.i.append('\f');
        }
      }
      else {
        this.i.append('\b');
      }
    }
    else {
      this.i.append((char)this.h);
    }
    q();
  }
  
  private h l()
  {
    r();
    b('-');
    int k = this.h;
    if (o())
    {
      while ((k != 48) && (o())) {}
      m();
      n();
      return new d(t());
    }
    j localj = a("digit");
    for (;;)
    {
      throw localj;
    }
  }
  
  private boolean m()
  {
    if (!b('.')) {
      return false;
    }
    if (o())
    {
      while (o()) {}
      return true;
    }
    j localj = a("digit");
    for (;;)
    {
      throw localj;
    }
  }
  
  private boolean n()
  {
    if ((!b('e')) && (!b('E'))) {
      return false;
    }
    if (!b('+')) {
      b('-');
    }
    if (o())
    {
      while (o()) {}
      return true;
    }
    j localj = a("digit");
    for (;;)
    {
      throw localj;
    }
  }
  
  private boolean o()
  {
    if (!v()) {
      return false;
    }
    q();
    return true;
  }
  
  private void p()
  {
    while (u()) {
      q();
    }
  }
  
  private void q()
  {
    int m = this.d;
    int k = this.e;
    if (m == k)
    {
      m = this.j;
      if (m != -1)
      {
        this.i.append(this.b, m, k - m);
        this.j = 0;
      }
      this.c += this.e;
      localObject = this.a;
      char[] arrayOfChar = this.b;
      this.e = ((Reader)localObject).read(arrayOfChar, 0, arrayOfChar.length);
      this.d = 0;
      if (this.e == -1)
      {
        this.h = -1;
        return;
      }
    }
    if (this.h == 10)
    {
      this.f += 1;
      this.g = (this.c + this.d);
    }
    Object localObject = this.b;
    k = this.d;
    this.d = (k + 1);
    this.h = localObject[k];
  }
  
  private void r()
  {
    if (this.i == null) {
      this.i = new StringBuilder();
    }
    this.j = (this.d - 1);
  }
  
  private void s()
  {
    int k;
    if (this.h == -1) {
      k = this.d;
    } else {
      k = this.d - 1;
    }
    StringBuilder localStringBuilder = this.i;
    char[] arrayOfChar = this.b;
    int m = this.j;
    localStringBuilder.append(arrayOfChar, m, k - m);
    this.j = -1;
  }
  
  private String t()
  {
    int k;
    if (this.h == -1) {
      k = this.d;
    } else {
      k = this.d - 1;
    }
    Object localObject;
    int m;
    if (this.i.length() > 0)
    {
      localObject = this.i;
      char[] arrayOfChar = this.b;
      m = this.j;
      ((StringBuilder)localObject).append(arrayOfChar, m, k - m);
      localObject = this.i.toString();
      this.i.setLength(0);
    }
    else
    {
      localObject = this.b;
      m = this.j;
      localObject = new String((char[])localObject, m, k - m);
    }
    this.j = -1;
    return localObject;
  }
  
  private boolean u()
  {
    int k = this.h;
    return (k == 32) || (k == 9) || (k == 10) || (k == 13);
  }
  
  private boolean v()
  {
    int k = this.h;
    return (k >= 48) && (k <= 57);
  }
  
  private boolean w()
  {
    int k = this.h;
    if ((k < 48) || (k > 57))
    {
      k = this.h;
      if ((k < 97) || (k > 102)) {
        k = this.h;
      }
    }
    return (k >= 65) && (k <= 70);
  }
  
  private boolean x()
  {
    return this.h == -1;
  }
  
  h a()
  {
    q();
    p();
    h localh = b();
    p();
    if (x()) {
      return localh;
    }
    throw b("Unexpected character");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.f
 * JD-Core Version:    0.7.0.1
 */