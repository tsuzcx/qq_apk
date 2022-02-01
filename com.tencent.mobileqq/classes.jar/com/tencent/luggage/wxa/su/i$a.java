package com.tencent.luggage.wxa.su;

public class i$a
{
  public int a;
  public String b;
  public String c;
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public boolean b()
  {
    return this.a == 2;
  }
  
  public boolean c()
  {
    return this.a == 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PluginPatchConfig type:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",originalFileName:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",patchFileName:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.i.a
 * JD-Core Version:    0.7.0.1
 */