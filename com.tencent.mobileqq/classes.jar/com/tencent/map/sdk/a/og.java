package com.tencent.map.sdk.a;

public final class og<D extends nz>
  extends oj<D>
{
  private og.a a;
  private oa.a<D> b;
  
  og(og.a parama)
  {
    this.a = parama;
    int j = (int)((float)Runtime.getRuntime().maxMemory() * 0.5F);
    int k = (int)((float)Runtime.getRuntime().maxMemory() * 0.15F);
    og.a locala = this.a;
    int i = j;
    if (locala != null) {
      i = Math.min(Math.max(locala.a, k), j);
    }
    this.b = new oa.a(i, parama.b);
  }
  
  public final D a(String paramString, Class<D> paramClass)
  {
    return (nz)this.b.b(paramString);
  }
  
  public final void a()
  {
    this.b.a();
  }
  
  public final void a(String paramString, D paramD)
  {
    this.b.a(paramString, paramD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.og
 * JD-Core Version:    0.7.0.1
 */