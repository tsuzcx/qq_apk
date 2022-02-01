package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.LikeEntry;
import java.util.List;

public class DetailLikeListLoader$GetLikeListEvent
  extends BaseEvent
{
  public int a;
  public String a;
  public List<LikeEntry> a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  
  public DetailLikeListLoader$GetLikeListEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetLikeListEvent{feedId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isForDetail=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mLikeCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mHasLike=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mLikeEntryList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListEvent
 * JD-Core Version:    0.7.0.1
 */