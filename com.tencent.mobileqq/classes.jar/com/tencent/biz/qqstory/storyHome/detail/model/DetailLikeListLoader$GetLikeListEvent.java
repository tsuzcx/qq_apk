package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class DetailLikeListLoader$GetLikeListEvent
  extends BaseEvent
{
  public int a;
  public String a;
  public List a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  
  public DetailLikeListLoader$GetLikeListEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    this.errorInfo = paramErrorMessage;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GetLikeListEvent{feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", isForDetail=" + this.jdField_a_of_type_Boolean + ", mType=" + this.jdField_a_of_type_Int + ", mLikeCount=" + this.b + ", mHasLike=" + this.c + ", mLikeEntryList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListEvent
 * JD-Core Version:    0.7.0.1
 */