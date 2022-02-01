package com.tencent.luggage.wxa.nz;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public class h
{
  public volatile boolean a = false;
  private String b;
  private String c;
  private String d;
  private String e;
  private Map<String, String> f;
  private Map<String, String> g;
  private g.a h;
  private String i;
  private int j;
  private ArrayList<String> k;
  private int l = 15;
  private String m;
  private HttpURLConnection n = null;
  private long o;
  private String p;
  
  h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, g.a parama)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.h = parama;
    this.d = paramString3;
    this.e = paramString4;
    this.j = paramInt;
    this.i = paramString5;
    this.o = System.currentTimeMillis();
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(HttpURLConnection paramHttpURLConnection)
  {
    this.n = paramHttpURLConnection;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.k = paramArrayList;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.f = paramMap;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    this.m = paramString;
  }
  
  public void b(Map<String, String> paramMap)
  {
    this.g = paramMap;
  }
  
  public g.a c()
  {
    return this.h;
  }
  
  public void c(String paramString)
  {
    this.p = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.i;
  }
  
  public Map<String, String> g()
  {
    return this.f;
  }
  
  public Map<String, String> h()
  {
    return this.g;
  }
  
  public int i()
  {
    return this.j;
  }
  
  public ArrayList<String> j()
  {
    return this.k;
  }
  
  public int k()
  {
    return this.l;
  }
  
  public String l()
  {
    return this.m;
  }
  
  public HttpURLConnection m()
  {
    return this.n;
  }
  
  public String n()
  {
    return this.p;
  }
  
  public int o()
  {
    return (int)(System.currentTimeMillis() - this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.h
 * JD-Core Version:    0.7.0.1
 */