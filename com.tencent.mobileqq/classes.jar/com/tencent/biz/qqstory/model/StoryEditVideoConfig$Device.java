package com.tencent.biz.qqstory.model;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM.Column;

public class StoryEditVideoConfig$Device
{
  public static Device a;
  public static Device b;
  @JsonORM.Column(a="manufacturer")
  public String a;
  @JsonORM.Column(a="model")
  public String b;
  
  static
  {
    jdField_a_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device = new Device();
    jdField_b_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device = new Device();
    jdField_b_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.jdField_a_of_type_JavaLangString = Build.MANUFACTURER;
    jdField_b_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.jdField_b_of_type_JavaLangString = Build.MODEL;
    jdField_a_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.jdField_a_of_type_JavaLangString = "all";
    jdField_a_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.jdField_b_of_type_JavaLangString = "all";
  }
  
  public boolean a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.equals(this)) {}
    while ((jdField_b_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.equals(this)) || ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_b_of_type_JavaLangString, jdField_b_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.jdField_b_of_type_JavaLangString)))) {
      return true;
    }
    return false;
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
      paramObject = (Device)paramObject;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        if (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) {}
      }
      else {
        while (paramObject.jdField_a_of_type_JavaLangString != null) {
          return false;
        }
      }
      if (this.jdField_b_of_type_JavaLangString != null) {
        return this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString);
      }
    } while (paramObject.jdField_b_of_type_JavaLangString == null);
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (int i = this.jdField_a_of_type_JavaLangString.hashCode();; i = 0)
    {
      if (this.jdField_b_of_type_JavaLangString != null) {
        j = this.jdField_b_of_type_JavaLangString.hashCode();
      }
      return i * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryEditVideoConfig.Device
 * JD-Core Version:    0.7.0.1
 */