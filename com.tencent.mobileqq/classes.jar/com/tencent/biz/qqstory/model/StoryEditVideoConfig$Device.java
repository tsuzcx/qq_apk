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
    Device localDevice = jdField_a_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device;
    localDevice.jdField_a_of_type_JavaLangString = "all";
    localDevice.jdField_b_of_type_JavaLangString = "all";
  }
  
  public boolean a()
  {
    boolean bool2 = jdField_a_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.equals(this);
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (!jdField_b_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.equals(this))
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_b_of_type_JavaLangString, jdField_b_of_type_ComTencentBizQqstoryModelStoryEditVideoConfig$Device.jdField_b_of_type_JavaLangString))) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
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
      paramObject = (Device)paramObject;
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null)
      {
        if (!str.equals(paramObject.jdField_a_of_type_JavaLangString)) {
          return false;
        }
      }
      else if (paramObject.jdField_a_of_type_JavaLangString != null) {
        return false;
      }
      str = this.jdField_b_of_type_JavaLangString;
      if (str != null) {
        return str.equals(paramObject.jdField_b_of_type_JavaLangString);
      }
      return paramObject.jdField_b_of_type_JavaLangString == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.jdField_b_of_type_JavaLangString;
    if (str != null) {
      j = str.hashCode();
    }
    return i * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryEditVideoConfig.Device
 * JD-Core Version:    0.7.0.1
 */