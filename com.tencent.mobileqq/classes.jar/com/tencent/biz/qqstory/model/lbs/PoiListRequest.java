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
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (getClass() != paramObject.getClass());
        paramObject = (PoiListRequest)paramObject;
        bool1 = bool2;
      } while (!this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.equals(paramObject.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation));
      bool1 = bool2;
    } while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
    return this.b.equals(paramObject.b);
  }
  
  public int hashCode()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.hashCode() * 31 + this.jdField_a_of_type_JavaLangString.hashCode()) * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    return "PoiListRequest{mBasicLocation=" + this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation + ", mCoordinate=" + 0 + ", mCount=" + 20 + ", mCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mKeyWord='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.PoiListRequest
 * JD-Core Version:    0.7.0.1
 */