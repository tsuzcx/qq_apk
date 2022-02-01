package com.tencent.luggage.wxa.a;

import java.util.Locale;

class l$h
{
  String a;
  int b = 0;
  int c = 0;
  private e d = new e();
  
  l$h(String paramString)
  {
    this.a = paramString.trim();
    this.c = this.a.length();
  }
  
  float a(float paramFloat)
  {
    if (Float.isNaN(paramFloat)) {
      return (0.0F / 0.0F);
    }
    h();
    return i();
  }
  
  float a(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return (0.0F / 0.0F);
    }
    h();
    return i();
  }
  
  Boolean a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    h();
    return m();
  }
  
  String a(char paramChar, boolean paramBoolean)
  {
    if (f()) {
      return null;
    }
    char c1 = this.a.charAt(this.b);
    if (((!paramBoolean) && (a(c1))) || (c1 == paramChar)) {
      return null;
    }
    int i = this.b;
    for (c1 = n(); (c1 != 'èøø') && (c1 != paramChar) && ((paramBoolean) || (!a(c1))); c1 = n()) {}
    return this.a.substring(i, this.b);
  }
  
  boolean a(char paramChar)
  {
    int i = this.b;
    boolean bool;
    if ((i < this.c) && (this.a.charAt(i) == paramChar)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.b += 1;
    }
    return bool;
  }
  
  boolean a(int paramInt)
  {
    return (paramInt == 32) || (paramInt == 10) || (paramInt == 13) || (paramInt == 9);
  }
  
  boolean a(String paramString)
  {
    int i = paramString.length();
    int j = this.b;
    boolean bool;
    if ((j <= this.c - i) && (this.a.substring(j, j + i).equals(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.b += i;
    }
    return bool;
  }
  
  String b(char paramChar)
  {
    return a(paramChar, false);
  }
  
  boolean b(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 13);
  }
  
  String c(char paramChar)
  {
    return a(paramChar, true);
  }
  
  boolean f()
  {
    return this.b == this.c;
  }
  
  void g()
  {
    for (;;)
    {
      int i = this.b;
      if (i >= this.c) {
        break;
      }
      if (!a(this.a.charAt(i))) {
        return;
      }
      this.b += 1;
    }
  }
  
  boolean h()
  {
    g();
    int i = this.b;
    if (i == this.c) {
      return false;
    }
    if (this.a.charAt(i) != ',') {
      return false;
    }
    this.b += 1;
    g();
    return true;
  }
  
  float i()
  {
    float f = this.d.a(this.a, this.b, this.c);
    if (!Float.isNaN(f)) {
      this.b = this.d.a();
    }
    return f;
  }
  
  float j()
  {
    h();
    float f = this.d.a(this.a, this.b, this.c);
    if (!Float.isNaN(f)) {
      this.b = this.d.a();
    }
    return f;
  }
  
  Integer k()
  {
    int i = this.b;
    if (i == this.c) {
      return null;
    }
    String str = this.a;
    this.b = (i + 1);
    return Integer.valueOf(str.charAt(i));
  }
  
  h.p l()
  {
    float f = i();
    if (Float.isNaN(f)) {
      return null;
    }
    h.bd localbd = s();
    if (localbd == null) {
      return new h.p(f, h.bd.a);
    }
    return new h.p(f, localbd);
  }
  
  Boolean m()
  {
    int i = this.b;
    if (i == this.c) {
      return null;
    }
    i = this.a.charAt(i);
    if ((i != 48) && (i != 49)) {
      return null;
    }
    int j = this.b;
    boolean bool = true;
    this.b = (j + 1);
    if (i != 49) {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  int n()
  {
    int j = this.b;
    int i = this.c;
    if (j == i) {
      return -1;
    }
    this.b = (j + 1);
    j = this.b;
    if (j < i) {
      return this.a.charAt(j);
    }
    return -1;
  }
  
  String o()
  {
    return a(' ', false);
  }
  
  String p()
  {
    if (f()) {
      return null;
    }
    int j = this.b;
    int i = this.a.charAt(j);
    if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)))
    {
      for (i = n(); ((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)); i = n()) {}
      return this.a.substring(j, this.b);
    }
    this.b = j;
    return null;
  }
  
  String q()
  {
    if (f()) {
      return null;
    }
    int j = this.b;
    for (int i = this.a.charAt(j); ((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)); i = n()) {}
    int k = this.b;
    while (a(i)) {
      i = n();
    }
    if (i == 40)
    {
      this.b += 1;
      return this.a.substring(j, k);
    }
    this.b = j;
    return null;
  }
  
  String r()
  {
    int i = this.b;
    while ((!f()) && (!a(this.a.charAt(this.b)))) {
      this.b += 1;
    }
    String str = this.a.substring(i, this.b);
    this.b = i;
    return str;
  }
  
  h.bd s()
  {
    if (f()) {
      return null;
    }
    if (this.a.charAt(this.b) == '%')
    {
      this.b += 1;
      return h.bd.i;
    }
    int i = this.b;
    if (i > this.c - 2) {
      return null;
    }
    try
    {
      h.bd localbd = h.bd.valueOf(this.a.substring(i, i + 2).toLowerCase(Locale.US));
      this.b += 2;
      return localbd;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return null;
  }
  
  boolean t()
  {
    int i = this.b;
    int j = this.c;
    boolean bool2 = false;
    if (i == j) {
      return false;
    }
    i = this.a.charAt(i);
    boolean bool1;
    if ((i < 97) || (i > 122))
    {
      bool1 = bool2;
      if (i >= 65)
      {
        bool1 = bool2;
        if (i > 90) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  String u()
  {
    if (f()) {
      return null;
    }
    int j = this.b;
    int k = this.a.charAt(j);
    if ((k != 39) && (k != 34)) {
      return null;
    }
    for (int i = n(); (i != -1) && (i != k); i = n()) {}
    if (i == -1)
    {
      this.b = j;
      return null;
    }
    this.b += 1;
    return this.a.substring(j + 1, this.b - 1);
  }
  
  String v()
  {
    if (f()) {
      return null;
    }
    int i = this.b;
    this.b = this.c;
    return this.a.substring(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.l.h
 * JD-Core Version:    0.7.0.1
 */