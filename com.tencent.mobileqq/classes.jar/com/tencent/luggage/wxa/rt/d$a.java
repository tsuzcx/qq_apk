package com.tencent.luggage.wxa.rt;

public class d$a
{
  public final String a;
  public final String b;
  public final long c;
  public final long d;
  public final long e;
  public final boolean f;
  final d g;
  
  public d$a(d paramd, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.g = paramd;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramLong3;
    this.f = paramBoolean;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" -> ");
    ((StringBuilder)localObject).append(this.g.toString());
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.f)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[DIR] ");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.d.a
 * JD-Core Version:    0.7.0.1
 */