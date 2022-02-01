package com.tencent.luggage.wxa.r;

public final class v$d
{
  private final String a;
  private final int b;
  private final int c;
  private int d;
  private String e;
  
  public v$d(int paramInt1, int paramInt2)
  {
    this(-2147483648, paramInt1, paramInt2);
  }
  
  public v$d(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramInt1 != -2147483648)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("/");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    this.a = ((String)localObject);
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = -2147483648;
  }
  
  private void d()
  {
    if (this.d != -2147483648) {
      return;
    }
    throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
  }
  
  public void a()
  {
    int i = this.d;
    if (i == -2147483648) {
      i = this.b;
    } else {
      i += this.c;
    }
    this.d = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.d);
    this.e = localStringBuilder.toString();
  }
  
  public int b()
  {
    d();
    return this.d;
  }
  
  public String c()
  {
    d();
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.v.d
 * JD-Core Version:    0.7.0.1
 */