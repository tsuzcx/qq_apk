package com.tencent.luggage.wxa.jr;

public class a
{
  private String a;
  private b b = new b();
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b.a(paramString1, paramString2);
  }
  
  public String b(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(", attrs:");
    localStringBuilder.append(this.b.toString());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jr.a
 * JD-Core Version:    0.7.0.1
 */