package com.tencent.luggage.wxa.kr;

import com.tencent.luggage.wxa.qz.af;

public class a$b
{
  private String a;
  private String b;
  private String c;
  
  public a$b(String paramString1, String paramString2, String paramString3)
  {
    this.a = af.b(paramString1);
    this.b = af.b(paramString2);
    this.c = af.b(paramString3);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((!af.a(this.a)) && (!af.a(this.b)) && (!af.a(this.c)))
    {
      if (this.a.trim().length() > 0) {
        localStringBuilder.append(this.a);
      }
      if (this.b.trim().length() > 0)
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.b);
      }
      if (this.c.trim().length() > 0)
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.c);
      }
    }
    else
    {
      if (this.c.trim().length() > 0) {
        localStringBuilder.append(this.c);
      }
      if (this.b.trim().length() > 0) {
        localStringBuilder.append(this.b);
      }
      if (this.a.trim().length() > 0) {
        localStringBuilder.append(this.a);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.a.b
 * JD-Core Version:    0.7.0.1
 */