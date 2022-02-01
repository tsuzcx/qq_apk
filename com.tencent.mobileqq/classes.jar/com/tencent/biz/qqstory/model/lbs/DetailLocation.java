package com.tencent.biz.qqstory.model.lbs;

public class DetailLocation
  extends BasicLocation
{
  public final int d;
  
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
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (DetailLocation)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
      if (this.b != paramObject.b) {
        return false;
      }
      return this.d == paramObject.d;
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((super.hashCode() * 31 + this.a) * 31 + this.b) * 31 + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.DetailLocation
 * JD-Core Version:    0.7.0.1
 */