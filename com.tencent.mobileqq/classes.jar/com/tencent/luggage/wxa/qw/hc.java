package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;

public class hc
  extends com.tencent.luggage.wxa.qu.a
{
  private int a;
  private boolean b;
  
  private int e()
  {
    return 0;
  }
  
  protected hc a()
  {
    if (this.b) {
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder("Not all required fields were included (false = not included in message),  iVal:");
    localStringBuilder.append(this.b);
    throw new b(localStringBuilder.toString());
  }
  
  public hc a(int paramInt)
  {
    this.a = paramInt;
    this.b = true;
    return this;
  }
  
  public void a(com.tencent.luggage.wxa.tc.a parama)
  {
    parama.a(1, this.a);
  }
  
  public boolean a(com.tencent.luggage.wxa.sx.a parama, com.tencent.luggage.wxa.qu.a parama1, int paramInt)
  {
    parama1 = (hc)parama1;
    if (paramInt != 1) {
      return false;
    }
    parama1.a(parama.a(paramInt));
    return true;
  }
  
  public hc b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new com.tencent.luggage.wxa.sx.a(paramArrayOfByte, p);
    for (int i = a(paramArrayOfByte);; i = a(paramArrayOfByte))
    {
      if (i <= 0) {
        return a();
      }
      if (!a(paramArrayOfByte, this, i)) {
        paramArrayOfByte.b();
      }
    }
  }
  
  public byte[] b()
  {
    a();
    return super.b();
  }
  
  public int d()
  {
    return com.tencent.luggage.wxa.sw.a.a(1, this.a) + 0 + e();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append("(");
    localStringBuilder = new StringBuilder(String.valueOf(localStringBuilder.toString()));
    localStringBuilder.append("iVal = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("   ");
    localStringBuilder = new StringBuilder(String.valueOf(localStringBuilder.toString()));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.hc
 * JD-Core Version:    0.7.0.1
 */