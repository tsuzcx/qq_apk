package com.tencent.luggage.wxa.nk;

import java.util.ArrayList;

public final class c$b
{
  private ArrayList<c.c> a = new ArrayList();
  private StringBuilder b = new StringBuilder();
  
  public ArrayList<c.c> a()
  {
    return this.a;
  }
  
  public void a(c.c paramc)
  {
    this.a.add(paramc);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = this.b;
    localStringBuilder.append(paramString);
    localStringBuilder.append("\n");
  }
  
  public String b()
  {
    return this.b.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nk.c.b
 * JD-Core Version:    0.7.0.1
 */