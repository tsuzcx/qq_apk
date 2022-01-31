package com.tencent.a.a.a.a;

import android.content.Context;

public abstract class f
{
  protected Context a = null;
  
  protected f(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(c paramc)
  {
    if (paramc == null) {}
    do
    {
      return;
      paramc = paramc.toString();
    } while (!a());
    a(h.g(paramc));
  }
  
  protected abstract void a(String paramString);
  
  protected abstract boolean a();
  
  protected abstract String b();
  
  public final c o()
  {
    c localc = null;
    if (a()) {}
    for (String str = h.f(b());; str = null)
    {
      if (str != null) {
        localc = c.e(str);
      }
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.a.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */