package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;

public abstract class p
{
  private final String a;
  
  public p()
  {
    this("");
  }
  
  public p(String paramString)
  {
    this.a = paramString;
  }
  
  p a(n paramn)
  {
    if (TextUtils.isEmpty(this.a))
    {
      a(paramn, paramn.b().getGlobalObject());
      return this;
    }
    V8Object localV8Object = paramn.b().newV8Object();
    paramn.b().add(this.a, localV8Object);
    a(paramn, localV8Object);
    localV8Object.release();
    return this;
  }
  
  abstract void a();
  
  protected abstract void a(n paramn, V8Object paramV8Object);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.p
 * JD-Core Version:    0.7.0.1
 */