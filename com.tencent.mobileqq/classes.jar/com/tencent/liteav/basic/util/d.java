package com.tencent.liteav.basic.util;

public class d
{
  public int a;
  public int b;
  
  public d() {}
  
  public d(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof d)) {
      return false;
    }
    paramObject = (d)paramObject;
    return (paramObject.a == this.a) && (paramObject.b == this.b);
  }
  
  public int hashCode()
  {
    return this.a * 32713 + this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Size(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.d
 * JD-Core Version:    0.7.0.1
 */