package com.tencent.biz.qqstory.model.lbs;

import com.tencent.mobileqq.soso.location.data.SosoLocation;

public class BasicLocation
{
  public final int a;
  public final int b;
  public final int c;
  
  public BasicLocation(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = 1;
  }
  
  public BasicLocation(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public static BasicLocation a(SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation != null) {
      return new BasicLocation((int)(paramSosoLocation.mLat02 * 1000000.0D), (int)(paramSosoLocation.mLon02 * 1000000.0D));
    }
    return new BasicLocation(0, 0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (BasicLocation)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
      return this.b == paramObject.b;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a * 31 + this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GpsMsg{latitude=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", longitude=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.BasicLocation
 * JD-Core Version:    0.7.0.1
 */