package com.tencent.mm.plugin.appbrand.jsruntime;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.appbrand.v8.c;
import com.tencent.mm.appbrand.v8.n;

final class f
  extends d
{
  private final c b;
  private final n c;
  private final int d;
  
  public f(n paramn, int paramInt)
  {
    this.b = paramn.a();
    this.c = paramn;
    this.d = paramInt;
  }
  
  @NonNull
  protected c a()
  {
    return this.b;
  }
  
  @NonNull
  protected n b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void n()
  {
    o.c("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
  }
  
  public void o()
  {
    o.c("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
  }
  
  public void setJsExceptionHandler(h paramh)
  {
    b().a(d(), paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.f
 * JD-Core Version:    0.7.0.1
 */