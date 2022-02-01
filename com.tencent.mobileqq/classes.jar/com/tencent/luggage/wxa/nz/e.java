package com.tencent.luggage.wxa.nz;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public class e
{
  private int a;
  private byte[] b;
  private String c;
  private String d;
  private d.a e;
  private Map<String, String> f;
  private ArrayList<String> g;
  private int h = 15;
  private String i;
  private String j;
  private HttpURLConnection k;
  private String l;
  private long m;
  private String n;
  private Runnable o = null;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private boolean t = true;
  
  public e(String paramString1, byte[] paramArrayOfByte, int paramInt, d.a parama, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.c = paramString1;
    this.b = paramArrayOfByte;
    this.e = parama;
    this.a = paramInt;
    this.d = paramString2;
    this.m = System.currentTimeMillis();
    this.q = paramBoolean1;
    this.r = paramBoolean2;
    this.s = paramBoolean3;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.o = paramRunnable;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(HttpURLConnection paramHttpURLConnection)
  {
    this.k = paramHttpURLConnection;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.g = paramArrayList;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.f = paramMap;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void b(String paramString)
  {
    this.j = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public byte[] b()
  {
    return this.b;
  }
  
  public d.a c()
  {
    return this.e;
  }
  
  public void c(String paramString)
  {
    this.l = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public int d()
  {
    return this.a;
  }
  
  public void d(String paramString)
  {
    this.n = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public Map<String, String> e()
  {
    return this.f;
  }
  
  public void e(String paramString)
  {
    this.i = paramString;
  }
  
  public void e(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public String f()
  {
    return this.d;
  }
  
  public ArrayList<String> g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public String j()
  {
    return this.l;
  }
  
  public HttpURLConnection k()
  {
    return this.k;
  }
  
  public String l()
  {
    return this.n;
  }
  
  public int m()
  {
    return (int)(System.currentTimeMillis() - this.m);
  }
  
  public long n()
  {
    byte[] arrayOfByte = this.b;
    if (arrayOfByte != null) {
      return arrayOfByte.length;
    }
    return 0L;
  }
  
  public String o()
  {
    return this.i;
  }
  
  public Runnable p()
  {
    return this.o;
  }
  
  public boolean q()
  {
    return this.p;
  }
  
  public boolean r()
  {
    return this.r;
  }
  
  public boolean s()
  {
    return this.q;
  }
  
  public boolean t()
  {
    return this.s;
  }
  
  public boolean u()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.e
 * JD-Core Version:    0.7.0.1
 */