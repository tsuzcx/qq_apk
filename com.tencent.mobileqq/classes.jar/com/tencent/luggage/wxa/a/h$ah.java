package com.tencent.luggage.wxa.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

abstract class h$ah
  extends h.ak
  implements h.ag, h.aj
{
  List<h.an> i = new ArrayList();
  Set<String> j = null;
  String k = null;
  Set<String> l = null;
  Set<String> m = null;
  Set<String> n = null;
  
  public void a(h.an paraman)
  {
    this.i.add(paraman);
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
  }
  
  public void a(Set<String> paramSet)
  {
    this.j = paramSet;
  }
  
  public List<h.an> b()
  {
    return this.i;
  }
  
  public void b(Set<String> paramSet)
  {
    this.l = paramSet;
  }
  
  public Set<String> c()
  {
    return this.j;
  }
  
  public void c(Set<String> paramSet)
  {
    this.m = paramSet;
  }
  
  public String d()
  {
    return this.k;
  }
  
  public void d(Set<String> paramSet)
  {
    this.n = paramSet;
  }
  
  public Set<String> e()
  {
    return null;
  }
  
  public Set<String> f()
  {
    return this.m;
  }
  
  public Set<String> g()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.h.ah
 * JD-Core Version:    0.7.0.1
 */