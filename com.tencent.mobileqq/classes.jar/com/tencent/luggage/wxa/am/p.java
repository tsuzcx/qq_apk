package com.tencent.luggage.wxa.am;

public final class p
  extends s.a
{
  private final String a;
  private final w<? super g> b;
  private final int c;
  private final int d;
  private final boolean e;
  
  public p(String paramString, w<? super g> paramw)
  {
    this(paramString, paramw, 8000, 8000, false);
  }
  
  public p(String paramString, w<? super g> paramw, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramw;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramBoolean;
  }
  
  protected o a(s.f paramf)
  {
    return new o(this.a, null, this.b, this.c, this.d, this.e, paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.p
 * JD-Core Version:    0.7.0.1
 */