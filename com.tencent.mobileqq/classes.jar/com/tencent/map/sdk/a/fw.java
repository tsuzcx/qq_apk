package com.tencent.map.sdk.a;

public final class fw
  implements Cloneable
{
  public double a = 4.9E-324D;
  public double b = 4.9E-324D;
  
  public fw(double paramDouble1, double paramDouble2)
  {
    this.b = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble1));
    this.a = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble2));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject.hashCode() != hashCode()) {
      return false;
    }
    if (!(paramObject instanceof fw)) {
      return false;
    }
    paramObject = (fw)paramObject;
    return (Double.doubleToLongBits(paramObject.b) == Double.doubleToLongBits(this.b)) && (Double.doubleToLongBits(paramObject.a) == Double.doubleToLongBits(this.a));
  }
  
  public final int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.b);
    long l2 = Double.doubleToLongBits(this.a);
    return ((int)(l2 ^ l2 >>> 32) + 31) * 31 + (int)(l1 ^ l1 >>> 32);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("x=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",y=");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fw
 * JD-Core Version:    0.7.0.1
 */