package com.tencent.luggage.wxa.qw;

public class gx
  extends com.tencent.luggage.wxa.qu.a
{
  private int a;
  private boolean b;
  private com.tencent.luggage.wxa.qu.b c;
  private boolean d;
  
  private gx a(int paramInt)
  {
    this.a = paramInt;
    this.b = true;
    return this;
  }
  
  private int f()
  {
    return 0;
  }
  
  public gx a(com.tencent.luggage.wxa.qu.b paramb)
  {
    if (paramb == null) {
      b(null);
    }
    this.c = paramb;
    this.d = true;
    a(this.c.a());
    return this;
  }
  
  public void a(com.tencent.luggage.wxa.tc.a parama)
  {
    parama.a(1, this.a);
    if (this.d) {
      parama.a(2, this.c);
    }
  }
  
  public final boolean a(com.tencent.luggage.wxa.sx.a parama, com.tencent.luggage.wxa.qu.a parama1, int paramInt)
  {
    parama1 = (gx)parama1;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return false;
      }
      parama1.a(parama.h(paramInt));
      return true;
    }
    parama1.a(parama.a(paramInt));
    return true;
  }
  
  public byte[] a()
  {
    return this.c.c();
  }
  
  public gx b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = com.tencent.luggage.wxa.qu.b.a(paramArrayOfByte);
    a(paramArrayOfByte);
    a(paramArrayOfByte.a());
    return this;
  }
  
  public byte[] b()
  {
    e();
    return super.b();
  }
  
  public gx c(byte[] paramArrayOfByte)
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
  
  public int d()
  {
    int j = com.tencent.luggage.wxa.sw.a.a(1, this.a) + 0;
    int i = j;
    if (this.d) {
      i = j + com.tencent.luggage.wxa.sw.a.a(2, this.c);
    }
    return i + f();
  }
  
  protected gx e()
  {
    if (this.b) {
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder("Not all required fields were included (false = not included in message),  iLen:");
    localStringBuilder.append(this.b);
    throw new com.tencent.luggage.wxa.sw.b(localStringBuilder.toString());
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder("");
    ((StringBuilder)localObject).append(getClass().getName());
    ((StringBuilder)localObject).append("(");
    localObject = new StringBuilder(String.valueOf(((StringBuilder)localObject).toString()));
    ((StringBuilder)localObject).append("iLen = ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("   ");
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.d)
    {
      localObject = new StringBuilder(String.valueOf(str));
      ((StringBuilder)localObject).append("Buffer = ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("   ");
      localObject = ((StringBuilder)localObject).toString();
    }
    localObject = new StringBuilder(String.valueOf(localObject));
    ((StringBuilder)localObject).append(")");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.gx
 * JD-Core Version:    0.7.0.1
 */