package com.tencent.biz.qqstory.model.filter;

import com.tencent.biz.qqstory.utils.JsonORM.Column;

public class PictureFilterConfig
{
  @JsonORM.Column(a="id")
  public int a;
  @JsonORM.Column(a="name")
  public String b;
  @JsonORM.Column(a="items")
  public PictureFilterConfig.PictureElement[] c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterConfig{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", items-size=");
    PictureFilterConfig.PictureElement[] arrayOfPictureElement = this.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.PictureFilterConfig
 * JD-Core Version:    0.7.0.1
 */