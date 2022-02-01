package com.tencent.luggage.wxa.rb;

public abstract class e
{
  private final f<e.a, g> a = new e.1(this);
  private final f<e.b, String> b = new e.2(this);
  
  private void a(e.a parama, g paramg)
  {
    parama.a(paramg.a, paramg);
  }
  
  private void a(e.b paramb, String paramString)
  {
    paramb.a();
  }
  
  public void a(String paramString, int paramInt, Object paramObject)
  {
    g localg = new g();
    localg.a = paramString;
    localg.b = paramInt;
    localg.d = paramObject;
    localg.c = this;
    this.a.a(localg);
    this.a.b();
  }
  
  public void c(String paramString)
  {
    paramString = new g(paramString);
    this.a.a(paramString);
    this.a.b();
  }
  
  public void f()
  {
    g localg = new g("*");
    this.a.a(localg);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rb.e
 * JD-Core Version:    0.7.0.1
 */