package com.tencent.biz.qqstory.model.lbs;

import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

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
  
  public static BasicLocation a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation != null) {
      return new BasicLocation((int)(paramSosoLocation.a * 1000000.0D), (int)(paramSosoLocation.b * 1000000.0D));
    }
    return new BasicLocation(0, 0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (BasicLocation)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
    } while (this.b == paramObject.b);
    return false;
  }
  
  public int hashCode()
  {
    return this.a * 31 + this.b;
  }
  
  public String toString()
  {
    return "GpsMsg{latitude=" + this.a + ", longitude=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.BasicLocation
 * JD-Core Version:    0.7.0.1
 */