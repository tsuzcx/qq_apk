package com.tencent.luggage.wxa.gl;

import com.tencent.luggage.wxa.qz.p;

public class d<K, O>
  extends p<K, O>
  implements b<K, O>
{
  private b.a<K, O> a = null;
  private b.b<K, O> b = null;
  
  public d(int paramInt)
  {
    super(paramInt);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(boolean paramBoolean, K paramK, O paramO1, O paramO2)
  {
    super.a(paramBoolean, paramK, paramO1, paramO2);
    b.a locala = this.a;
    if (locala != null) {
      locala.a(paramK, paramO1, paramO2);
    }
  }
  
  public int b(K paramK, O paramO)
  {
    b.b localb = this.b;
    if (localb != null) {
      return localb.a(paramK, paramO);
    }
    return super.b(paramK, paramO);
  }
  
  public void b()
  {
    a(-1);
  }
  
  public O c(K paramK)
  {
    return super.c(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gl.d
 * JD-Core Version:    0.7.0.1
 */