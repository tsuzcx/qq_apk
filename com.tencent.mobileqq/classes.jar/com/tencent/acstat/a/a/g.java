package com.tencent.acstat.a.a;

import android.content.Context;

public abstract class g
{
  protected Context a = null;
  
  protected g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static String c()
  {
    return i.d("6X8Y4XdM2Vhvn0I=");
  }
  
  public static String d()
  {
    return i.d("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=");
  }
  
  private void d(String paramString)
  {
    if (a()) {
      a(b(paramString));
    }
  }
  
  private String g()
  {
    if (a()) {
      return c(b());
    }
    return null;
  }
  
  public void a(d paramd)
  {
    if (paramd == null) {
      return;
    }
    d(paramd.toString());
  }
  
  protected abstract void a(String paramString);
  
  protected abstract boolean a();
  
  protected abstract String b();
  
  protected String b(String paramString)
  {
    return i.e(paramString);
  }
  
  protected String c(String paramString)
  {
    return i.d(paramString);
  }
  
  public d e()
  {
    String str = g();
    if (str != null) {
      return d.a(str);
    }
    return null;
  }
  
  protected String f()
  {
    return i.d("4kU71lN96TJUomD1vOU9lgj9Tw==");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.acstat.a.a.g
 * JD-Core Version:    0.7.0.1
 */