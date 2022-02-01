package com.tencent.luggage.wxa.hd;

import android.text.TextUtils;

abstract class c$b
{
  private final c.a a;
  
  c$b(c.a parama)
  {
    this.a = parama;
  }
  
  abstract String a();
  
  void b() {}
  
  void c() {}
  
  final String d()
  {
    String str = this.a.a(null);
    if (!TextUtils.isEmpty(str))
    {
      b();
      return str;
    }
    c();
    return e();
  }
  
  final String e()
  {
    String str = a();
    if (!TextUtils.isEmpty(str)) {
      this.a.b(str);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.b
 * JD-Core Version:    0.7.0.1
 */