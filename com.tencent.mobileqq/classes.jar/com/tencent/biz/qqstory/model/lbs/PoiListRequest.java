package com.tencent.biz.qqstory.model.lbs;

import android.support.annotation.NonNull;

public class PoiListRequest
{
  @NonNull
  public final BasicLocation a;
  @NonNull
  public final String b;
  @NonNull
  public final String c;
  
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
      paramObject = (PoiListRequest)paramObject;
      if (!this.a.equals(paramObject.a)) {
        return false;
      }
      if (!this.b.equals(paramObject.b)) {
        return false;
      }
      return this.c.equals(paramObject.c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PoiListRequest{mBasicLocation=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mCoordinate=");
    localStringBuilder.append(0);
    localStringBuilder.append(", mCount=");
    localStringBuilder.append(20);
    localStringBuilder.append(", mCookie='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mKeyWord='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.PoiListRequest
 * JD-Core Version:    0.7.0.1
 */