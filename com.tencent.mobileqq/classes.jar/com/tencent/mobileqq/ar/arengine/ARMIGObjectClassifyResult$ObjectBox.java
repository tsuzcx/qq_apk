package com.tencent.mobileqq.ar.arengine;

public class ARMIGObjectClassifyResult$ObjectBox
{
  public int a;
  public int b;
  public int c;
  public int d;
  public float e;
  public int f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("xMIN:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",xMAX:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",yMIN:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",yMAX:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.ObjectBox
 * JD-Core Version:    0.7.0.1
 */