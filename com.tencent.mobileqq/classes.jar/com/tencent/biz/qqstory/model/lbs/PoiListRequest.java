package com.tencent.biz.qqstory.model.lbs;

import android.support.annotation.NonNull;

public class PoiListRequest
{
  @NonNull
  public final BasicLocation a;
  @NonNull
  public final String a;
  @NonNull
  public final String b;
  
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
      if (!this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.equals(paramObject.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation)) {
        return false;
      }
      if (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) {
        return false;
      }
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.hashCode() * 31 + this.jdField_a_of_type_JavaLangString.hashCode()) * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PoiListRequest{mBasicLocation=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation);
    localStringBuilder.append(", mCoordinate=");
    localStringBuilder.append(0);
    localStringBuilder.append(", mCount=");
    localStringBuilder.append(20);
    localStringBuilder.append(", mCookie='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mKeyWord='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.PoiListRequest
 * JD-Core Version:    0.7.0.1
 */