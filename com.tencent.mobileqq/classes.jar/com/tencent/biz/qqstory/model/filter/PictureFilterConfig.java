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
    StringBuilder localStringBuilder = new StringBuilder().append("FilterConfig{id=").append(this.jdField_a_of_type_Int).append(", name='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", items-size=");
    if (this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelFilterPictureFilterConfig$PictureElement != null) {}
    for (int i = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelFilterPictureFilterConfig$PictureElement.length;; i = 0) {
      return i + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.PictureFilterConfig
 * JD-Core Version:    0.7.0.1
 */