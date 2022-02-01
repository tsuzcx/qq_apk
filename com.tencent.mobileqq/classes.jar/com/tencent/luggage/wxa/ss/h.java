package com.tencent.luggage.wxa.ss;

import java.io.File;

public class h
  implements d
{
  public d a;
  
  public h(d paramd)
  {
    this.a = paramd;
  }
  
  public h(File paramFile)
  {
    this.a = g.a().a(paramFile);
  }
  
  public h(String paramString)
  {
    this.a = g.a().a(paramString);
  }
  
  public String a()
  {
    return this.a.a();
  }
  
  public boolean b()
  {
    return this.a.b();
  }
  
  public boolean d()
  {
    return this.a.d();
  }
  
  public boolean e()
  {
    return this.a.e();
  }
  
  public String[] f()
  {
    return this.a.f();
  }
  
  public h[] g()
  {
    d[] arrayOfd = this.a.c();
    int i = 0;
    if ((arrayOfd != null) && (arrayOfd.length != 0))
    {
      h[] arrayOfh = new h[arrayOfd.length];
      while (i < arrayOfd.length)
      {
        arrayOfh[i] = new h(arrayOfd[i]);
        i += 1;
      }
      return arrayOfh;
    }
    return new h[0];
  }
  
  public String h()
  {
    return this.a.a();
  }
  
  public String i()
  {
    return this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ss.h
 * JD-Core Version:    0.7.0.1
 */