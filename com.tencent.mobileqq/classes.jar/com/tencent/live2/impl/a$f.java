package com.tencent.live2.impl;

public class a$f
{
  public int a = 2;
  public boolean b = false;
  public boolean c = false;
  
  public a$f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt;
    this.b = paramBoolean2;
    this.c = paramBoolean1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[qualityIndex:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][enableAdjRes:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][enableAdjBitrate:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.a.f
 * JD-Core Version:    0.7.0.1
 */