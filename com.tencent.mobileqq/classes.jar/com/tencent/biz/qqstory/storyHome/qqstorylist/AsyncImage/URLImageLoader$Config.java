package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StringAppendTool;

public class URLImageLoader$Config
{
  public int a;
  public Drawable a;
  public Transformation a;
  public String a;
  public int b;
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return "?";
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation == null) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return StringAppendTool.a(new Object[] { this.jdField_a_of_type_JavaLangString, "/", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation.a() });
  }
  
  public boolean equals(Object paramObject)
  {
    return a().equals(((Config)paramObject).a());
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader.Config
 * JD-Core Version:    0.7.0.1
 */