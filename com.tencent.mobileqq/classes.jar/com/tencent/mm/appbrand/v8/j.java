package com.tencent.mm.appbrand.v8;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;

final class j
  extends aa
{
  private static final ThreadLocal<j> c = new ThreadLocal();
  @NonNull
  private final j.a a;
  private boolean b;
  
  private j(j.a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.a = parama;
    this.b = true;
  }
  
  public static j a(@NonNull j.a parama, boolean paramBoolean)
  {
    if (c.get() == null)
    {
      parama = new j(parama, paramBoolean);
      c.set(parama);
      return parama;
    }
    throw new RuntimeException("Only one Looper may be created per thread");
  }
  
  protected boolean i()
  {
    return (!this.b) && (super.i());
  }
  
  protected void j()
  {
    super.j();
    this.b = this.a.a();
  }
  
  protected void k()
  {
    super.k();
    this.b = this.a.a();
  }
  
  protected void l()
  {
    super.l();
    j.a locala = this.a;
    if (locala != null) {
      locala.c();
    }
  }
  
  protected void m()
  {
    if ((this.a != null) && (!p())) {
      this.a.b();
    }
  }
  
  protected void n()
  {
    j.a locala = this.a;
    if (locala != null) {
      locala.b();
    }
  }
  
  protected void o()
  {
    if (this.a != null)
    {
      o.d("MicroMsg.NodeJSRuntimeLooper", "onQuit wakeUpUVLoop");
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.j
 * JD-Core Version:    0.7.0.1
 */