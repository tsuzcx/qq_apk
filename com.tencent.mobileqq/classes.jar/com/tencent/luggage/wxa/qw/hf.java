package com.tencent.luggage.wxa.qw;

public class hf
  extends com.tencent.luggage.wxa.qu.a
{
  private String a;
  private boolean b;
  
  private int f()
  {
    return 0;
  }
  
  public hf a(String paramString)
  {
    this.a = paramString;
    this.b = true;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(com.tencent.luggage.wxa.tc.a parama)
  {
    if (this.b) {
      parama.a(1, this.a);
    }
  }
  
  public boolean a(com.tencent.luggage.wxa.sx.a parama, com.tencent.luggage.wxa.qu.a parama1, int paramInt)
  {
    parama1 = (hf)parama1;
    if (paramInt != 1) {
      return false;
    }
    parama1.a(parama.c(paramInt));
    return true;
  }
  
  public hf b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new com.tencent.luggage.wxa.sx.a(paramArrayOfByte, p);
    for (int i = a(paramArrayOfByte);; i = a(paramArrayOfByte))
    {
      if (i <= 0) {
        return e();
      }
      if (!a(paramArrayOfByte, this, i)) {
        paramArrayOfByte.b();
      }
    }
  }
  
  public byte[] b()
  {
    e();
    return super.b();
  }
  
  public int d()
  {
    boolean bool = this.b;
    int i = 0;
    if (bool) {
      i = 0 + com.tencent.luggage.wxa.sw.a.a(1, this.a);
    }
    return i + f();
  }
  
  protected hf e()
  {
    return this;
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.hf
 * JD-Core Version:    0.7.0.1
 */