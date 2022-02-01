package com.tencent.mm.appbrand.v8;

import androidx.annotation.NonNull;

class ac
  extends aa
{
  private static final ThreadLocal<ac> b = new ThreadLocal();
  @NonNull
  private final ac.a a;
  
  ac(@NonNull ac.a parama, boolean paramBoolean)
  {
    super(paramBoolean);
    this.a = parama;
  }
  
  public static ac a(@NonNull ac.a parama, boolean paramBoolean)
  {
    if (b.get() == null)
    {
      parama = new ac(parama, paramBoolean);
      b.set(parama);
      return parama;
    }
    throw new RuntimeException("Only one Looper may be created per thread");
  }
  
  protected void j()
  {
    super.j();
    ac.a locala = this.a;
    if (locala != null) {
      locala.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.ac
 * JD-Core Version:    0.7.0.1
 */