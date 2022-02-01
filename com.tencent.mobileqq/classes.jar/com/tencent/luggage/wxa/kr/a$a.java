package com.tencent.luggage.wxa.kr;

import com.tencent.luggage.wxa.qz.af;

public class a$a
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public a$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = af.b(paramString1);
    this.b = af.b(paramString2);
    this.c = af.b(paramString3);
    this.d = af.b(paramString4);
    this.e = af.b(paramString5);
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a.length() > 0) {
      localStringBuilder.append(this.a);
    }
    if (this.b.length() > 0) {
      localStringBuilder.append(this.b);
    }
    if (this.c.length() > 0) {
      localStringBuilder.append(this.c);
    }
    if (this.d.length() > 0) {
      localStringBuilder.append(this.d);
    }
    if (this.e.length() > 0)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.e);
    }
    return localStringBuilder.toString();
  }
  
  private String d()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (this.d.length() > 0)
    {
      localStringBuilder1.append(this.d);
      localStringBuilder1.append(" ");
    }
    StringBuilder localStringBuilder2;
    if (this.c.length() > 0)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(this.c);
      localStringBuilder2.append(" ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.b.length() > 0)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(this.b);
      localStringBuilder2.append(" ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.a.length() > 0) {
      localStringBuilder1.append(this.a);
    }
    if (this.e.length() > 0)
    {
      localStringBuilder1.append(" ");
      localStringBuilder1.append(this.e);
    }
    return localStringBuilder1.toString();
  }
  
  public String a()
  {
    return this.e;
  }
  
  public String b()
  {
    if ((!af.a(this.a)) && (!af.a(this.b)) && (!af.a(this.c)) && (!af.a(this.d)) && (!af.a(this.e))) {
      return d();
    }
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.a.a
 * JD-Core Version:    0.7.0.1
 */