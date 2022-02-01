package com.tencent.luggage.wxa.ni;

import com.tencent.luggage.wxa.qz.af;

class a$a
{
  String a = "";
  int b = 0;
  long c = 0L;
  long d = 0L;
  long e = 0L;
  long f = 0L;
  long g = 0L;
  long h = 0L;
  int i = 0;
  long j = 0L;
  long k = 0L;
  long l = 0L;
  long m = 0L;
  long n = 0L;
  int o = 0;
  int p = 0;
  String q = "";
  
  a$a(a parama) {}
  
  void a()
  {
    this.a = "";
    this.b = 0;
    this.c = 0L;
    this.e = 0L;
    this.d = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.i = 0;
    this.k = 0L;
    this.l = 0L;
    this.j = 0L;
    this.m = 0L;
    this.n = 0L;
    this.o = 0;
    this.p = 0;
    this.q = "";
  }
  
  void a(String paramString)
  {
    if (!af.c(paramString))
    {
      String str = paramString;
      if (paramString.length() > 512) {
        str = paramString.substring(0, 512);
      }
      this.a = str;
      return;
    }
    this.a = "";
  }
  
  void b()
  {
    this.k = 0L;
    this.l = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ni.a.a
 * JD-Core Version:    0.7.0.1
 */