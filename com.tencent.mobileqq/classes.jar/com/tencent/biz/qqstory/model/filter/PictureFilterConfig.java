package com.tencent.biz.qqstory.model.filter;

import com.tencent.biz.qqstory.utils.JsonORM.Column;

public class PictureFilterConfig
{
  @JsonORM.Column(a="id")
  public int a;
  @JsonORM.Column(a="name")
  public String a;
  @JsonORM.Column(a="items")
  public PictureFilterConfig.PictureElement[] a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterConfig{id=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", items-size=");
    PictureFilterConfig.PictureElement[] arrayOfPictureElement = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelFilterPictureFilterConfig$PictureElement;
    int i;
    if (arrayOfPictureElement != null) {
      i = arrayOfPictureElement.length;
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.PictureFilterConfig
 * JD-Core Version:    0.7.0.1
 */